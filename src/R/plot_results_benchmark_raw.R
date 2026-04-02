#!/usr/bin/env Rscript
# bench_exec_times_fit_AB_ms_raw.R
# Usage:
#   Rscript bench_exec_times_fit_AB_ms_raw.R samples1.csv.gz [samples2.csv.gz ...] \
#     --out plots \
#     --xfm-model poly2 --purpose-model linear --risk-model linear \
#     --bins 12 --logy-scatter --logy-bins --show-se
#
# Outputs:
#   plots/bench_exec_times_vs_size_fit_A.pdf
#   plots/bench_exec_times_vs_size_fit_B.pdf
#   plots/bench_exec_times_vs_size_envelope_A.pdf
#   plots/bench_exec_times_vs_size_envelope_B.pdf
#   plots/bench_exec_times_share_bins_A.pdf
#   plots/bench_exec_times_share_bins_B.pdf
#   plots/bench_exec_models_A.txt
#   plots/bench_exec_models_B.txt
#   plots/raw_summary.txt

suppressWarnings({
  suppressPackageStartupMessages({
    library(optparse)
    library(readr)
    library(dplyr)
    library(ggplot2)
    library(cowplot)
    library(scales)
    library(purrr)
    library(stringr)
    library(hexbin)
    library(tidyr)
    library(mgcv)   # for Gaussian Process / GAM envelopes
  })
})

# ----------------------------
# Theme & colors (CASA style)
# ----------------------------
init_theme <- function() {
  theme_set(theme_cowplot(font_size = 8, font_family = "TeX Gyre Pagella") +
              theme(plot.title = element_blank()))
}
# ----------------------------
# Labels & colors
# ----------------------------
COL_XFM  <- "#0072B2" # blue
COL_PURP <- "#E69F00" # orange
COL_RISK <- "#009E73" # green

# >>> Script constants you can edit <<<
SERIES_LABELS <- c(
  transform = "Transform",
  purpose   = "Purpose-check",
  risk      = "Risk-check"
)

# color map keyed by the *labels* actually plotted
COL_MAP <- setNames(
  c(COL_XFM, COL_PURP, COL_RISK),
  unname(SERIES_LABELS[c("transform","purpose","risk")])
)

background_grid <- function() {
  theme(panel.grid.major = element_line(color = "grey90", linewidth = 0.25),
        panel.grid.minor = element_blank())
}

# ----------------------------
# Helpers
# ----------------------------
combined_load_raw <- function(paths) {
  frames <- lapply(paths, function(p) {
    readr::read_csv(p, show_col_types = FALSE) %>% mutate(`__source__` = as.character(p))
  })
  if (!length(frames)) stop("No raw CSVs loaded.")
  bind_rows(frames)
}

ensure_numeric <- function(df, cols) {
  cols <- intersect(cols, names(df))
  for (c in cols) df[[c]] <- suppressWarnings(as.numeric(df[[c]]))
  df
}

model_formula <- function(kind = c("linear","poly2","poly3","logx","exp")) {
  kind <- match.arg(kind)
  switch(kind,
         linear = y ~ x,
         poly2  = y ~ poly(x, 2, raw = TRUE),
         poly3  = y ~ poly(x, 3, raw = TRUE),
         logx   = y ~ log(x + 1),
         exp    = y ~ exp(x))
}

# Summaries to console + file (raw, per iteration)
summarize_raw <- function(raw, out_path) {
  raw <- ensure_numeric(raw, c("micros","TotalElements","model_index","rep"))
  raw$ms <- raw$micros / 1000
  
  top <- list(
    header = "=== RAW SAMPLES SUMMARY ===",
    files  = sprintf("Files: %s", paste(unique(raw$`__source__`), collapse = ", ")),
    rows   = sprintf("Total rows: %s", format(nrow(raw), big.mark=",")),
    scenarios = capture.output(print(raw %>% count(scenario, name="rows") %>% arrange(scenario))),
    phases    = capture.output(print(raw %>% count(phase, name="rows") %>% arrange(phase))),
    per_model = capture.output(print(raw %>% distinct(scenario, model_index) %>% count(scenario, name="unique_models") %>% arrange(scenario))),
    reps = capture.output(print(raw %>%
                                  count(scenario, model_index, phase, name="n_iter") %>%
                                  group_by(scenario, phase) %>%
                                  summarise(min=min(n_iter), p50=quantile(n_iter,0.5), max=max(n_iter),
                                            mean=mean(n_iter), .groups="drop") %>%
                                  arrange(scenario, phase))),
    size = capture.output(print(raw %>%
                                  summarise(size_min=min(TotalElements, na.rm=TRUE),
                                            size_p50=quantile(TotalElements,0.5, na.rm=TRUE),
                                            size_max=max(TotalElements, na.rm=TRUE),
                                            n_sizes=n_distinct(TotalElements)))),
    timing = capture.output(print(raw %>%
                                    group_by(phase) %>%
                                    summarise(ms_min = min(ms, na.rm=TRUE),
                                              ms_p50 = median(ms, na.rm=TRUE),
                                              ms_mean= mean(ms, na.rm=TRUE),
                                              ms_p95 = quantile(ms, 0.95, na.rm=TRUE),
                                              ms_max = max(ms, na.rm=TRUE),
                                              n = dplyr::n(), .groups="drop")))
  )
  
  lines <- c(
    top$header, top$files, top$rows, "",
    "[rows by scenario]", top$scenarios, "",
    "[rows by phase]", top$phases, "",
    "[unique models by scenario]", top$per_model, "",
    "[iterations per (scenario, model, phase)]", top$reps, "",
    "[model sizes]", top$size, "",
    "[timing by phase, ms]", top$timing, ""
  )
  message(paste(lines, collapse = "\n"))
  writeLines(lines, out_path)
}

# Build long-format per-iteration data with labeled series & colors
# Always per-iteration (no pre-averaging by model)
build_long_series_from_raw <- function(raw_df, scenario_tag) {
  raw_df <- ensure_numeric(raw_df, c("TotalElements","micros"))
  raw_df %>%
    dplyr::filter(scenario == scenario_tag,
                  phase %in% c("transform","purpose","risk")) %>%
    dplyr::mutate(
      Series = dplyr::case_when(
        phase == "transform" ~ SERIES_LABELS[["transform"]],
        phase == "purpose"   ~ SERIES_LABELS[["purpose"]],
        phase == "risk"      ~ SERIES_LABELS[["risk"]],
        TRUE ~ NA_character_
      ),
      ms_mean = micros / 1000.0
    ) %>%
    dplyr::filter(!is.na(Series), is.finite(TotalElements), is.finite(ms_mean)) %>%
    dplyr::select(TotalElements, Series, ms_mean) %>%
    dplyr::mutate(Scenario = scenario_tag)
}

build_long_series_from_raw_rel <- function(raw_df, scenario_tag) {
  raw_df <- ensure_numeric(raw_df, c("TotalRelations","micros"))
  raw_df %>%
    dplyr::filter(scenario == scenario_tag,
                  phase %in% c("transform","purpose","risk")) %>%
    dplyr::mutate(
      Series = dplyr::case_when(
        phase == "transform" ~ SERIES_LABELS[["transform"]],
        phase == "purpose"   ~ SERIES_LABELS[["purpose"]],
        phase == "risk"      ~ SERIES_LABELS[["risk"]],
        TRUE ~ NA_character_
      ),
      ms_mean = micros / 1000.0
    ) %>%
    dplyr::filter(!is.na(Series), is.finite(TotalRelations), is.finite(ms_mean)) %>%
    dplyr::transmute(TotalElements = TotalRelations, Series, ms_mean,
                     Scenario = scenario_tag)
}


# ----------------------------
# Figure builders
# ----------------------------
# Scatter (per iteration) + fitted lines
p_exec_fit_scenario <- function(df_long,
                                scenario_tag,
                                model_xfm = "poly2",
                                model_purpose = "linear",
                                model_risk = "linear",
                                show_se = FALSE,
                                logy = FALSE,
                                title_suffix = "",
                                scatter_mode = "points") {
  long <- df_long %>% dplyr::filter(Scenario == scenario_tag)
  if (!nrow(long)) return(NULL)
  present_series <- sort(unique(long$Series))
  series_models <- setNames(
    c(model_xfm, model_purpose, model_risk),
    unname(SERIES_LABELS[c("transform","purpose","risk")])
  )
  
  col_map <- COL_MAP
  
  if (identical(scatter_mode, "hex")) {
    if (!requireNamespace("hexbin", quietly = TRUE)) {
      stop("scatter-mode=hex requires the 'hexbin' package: install.packages('hexbin')")
    }
    p <- ggplot(long, aes(x = TotalElements, y = ms_mean)) +
      stat_binhex(bins = 50) +
      facet_wrap(~ Series, nrow = 1) +
      scale_fill_viridis_c(trans = "log10", name = "count") +
      theme(legend.position = "top") +
      background_grid() +
      labs(x = "model size (TotalElements)",
           y = if (logy) "execution time (ms, log10)" else "execution time (ms)",
           title = paste0("Execution time vs. model size", title_suffix))
    
    # Add per-series fitted lines on top
    for (sn in intersect(names(series_models), present_series)) {
      kind <- series_models[[sn]]
      p <- p + geom_smooth(
        data = subset(long, Series == sn),
        aes(x = TotalElements, y = ms_mean, color = sn),
        method = "lm",
        formula = model_formula(kind),
        se = show_se,
        linewidth = 0.7,
        inherit.aes = FALSE
      )
    }
    p <- p + scale_color_manual(values = col_map, breaks = names(col_map), name = NULL)
    
  } else {
    # Default: regular scatter, colored by series
    p <- ggplot(long, aes(x = TotalElements, y = ms_mean, color = Series)) +
      geom_point(alpha = 0.25, size = 0.6, stroke = 0) +
      scale_color_manual(values = col_map, drop = TRUE, name = NULL) +
      theme(legend.position = "top") +
      background_grid() +
      labs(x = "model size (TotalElements)",
           y = if (logy) "execution time (ms, log10)" else "execution time (ms)",
           title = paste0("Execution time vs. model size", title_suffix))
    
    for (sn in intersect(names(series_models), present_series)) {
      kind <- series_models[[sn]]
      p <- p + geom_smooth(
        data = subset(long, Series == sn),
        method = "lm",
        formula = model_formula(kind),
        se = show_se,
        linewidth = 0.7
      )
    }
  }
  
  if (logy) {
    p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  } else {
    p <- p + scale_y_continuous(labels = scales::label_number())
  }
  
  p
}

# ---- NEW: total-time HEXBIN + fitted line ----
p_total_hex_scatter_fit <- function(df_total,
                                    model_kind = c("linear","poly2","poly3","logx","exp"),
                                    logy = FALSE,
                                    title_suffix = "",
                                    bins = 50) {
  model_kind <- match.arg(model_kind)
  if (!requireNamespace("hexbin", quietly = TRUE)) {
    stop("scatter-mode=hex requires the 'hexbin' package: install.packages('hexbin')")
  }
  if (!nrow(df_total)) return(NULL)
  
  p <- ggplot(df_total,  aes(x = TotalElements, y = ms_total)) +
    stat_binhex(bins = bins) +
    scale_fill_viridis_c(trans = "log10", name = "count", begin=0.3) +
    geom_smooth(
      method = "lm",
      formula = model_formula(model_kind),
      se = FALSE,
      linewidth = 2.0,       # thick white underlay
      color = "white"
    ) +
    geom_smooth(
      method = "lm",
      formula = model_formula(model_kind),
      se = FALSE,
      linewidth = 0.9,       # thinner colored overlay
      color = "blue"      # your blue
    ) +
    background_grid() +
    theme(legend.position = "right") +
    labs(x = "model size",
         y = if (logy) "execution time (ms, log10)" else "execution time (ms)",
         title = paste0("Total time vs. model size (hexbin)", title_suffix))
  
  if (logy) p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  else      p <- p + scale_y_continuous(labels = scales::label_number())
  
  p
}


# Envelope (per iteration): 10–90% ribbons + median line per bin, plus fitted lines
p_exec_envelope_scenario <- function(df_long,
                                     scenario_tag,
                                     n_bins = 12,
                                     model_xfm = "poly2",
                                     model_purpose = "linear",
                                     model_risk = "linear",
                                     logy = FALSE,
                                     title_suffix = "") {
  long <- df_long %>% dplyr::filter(Scenario == scenario_tag)
  if (!nrow(long)) return(NULL)
  
  # Build bins on TotalElements
  x <- long$TotalElements
  brk  <- seq(min(x, na.rm = TRUE), max(x, na.rm = TRUE), length.out = n_bins + 1)
  mids <- (brk[-1] + brk[-length(brk)]) / 2
  long$.__bin__ <- cut(long$TotalElements, breaks = brk, include.lowest = TRUE, labels = FALSE)
  bins_tbl <- tibble(`.__bin__` = seq_len(n_bins), x_mid = mids)
  
  # Per-bin per-series quantiles
  qfun <- function(v) quantile(v, probs = c(0.10, 0.50, 0.90), na.rm = TRUE, names = FALSE)
  env <- long %>%
    dplyr::filter(is.finite(.__bin__)) %>%
    dplyr::group_by(.__bin__, Series) %>%
    dplyr::summarise(
      q10 = qfun(ms_mean)[1],
      q50 = qfun(ms_mean)[2],
      q90 = qfun(ms_mean)[3],
      .groups = "drop"
    ) %>%
    dplyr::left_join(bins_tbl, by = ".__bin__")
  
  if (!nrow(env)) return(NULL)
  
  col_map <- COL_MAP
  
  p <- ggplot() +
    # ribbon per series
    geom_ribbon(
      data = env,
      aes(x = x_mid, ymin = q10, ymax = q90, fill = Series),
      alpha = 0.25
    ) +
    # median line per series
    geom_line(
      data = env,
      aes(x = x_mid, y = q50, color = Series),
      linewidth = 0.8
    ) +
    scale_fill_manual(values = col_map, drop = TRUE) +
    scale_color_manual(values = col_map, drop = TRUE) +
    background_grid() +
    theme(legend.position = "top") +
    labs(x = "model size (TotalElements, bin midpoints)",
         y = if (logy) "execution time (ms, log10)" else "execution time (ms)",
         fill = NULL, color = NULL,
         title = paste0("Execution time envelopes by size", title_suffix))
  
  # Add fitted lm lines (on raw per-iteration points)
  series_models <- setNames(
    c(model_xfm, model_purpose, model_risk),
    unname(SERIES_LABELS[c("transform","purpose","risk")])
  )
  
  for (sn in intersect(names(series_models), unique(long$Series))) {
    kind <- series_models[[sn]]
    p <- p + geom_smooth(
      data = subset(long, Series == sn),
      aes(x = TotalElements, y = ms_mean, color = Series),
      method = "lm",
      formula = model_formula(kind),
      se = FALSE,
      linewidth = 0.8
    )
  }
  
  if (logy) {
    p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  } else {
    p <- p + scale_y_continuous(labels = scales::label_number())
  }
  p
}

# Envelope around the fitted line: model-based prediction intervals (per iteration)
p_exec_prediction_envelope_scenario <- function(
    df_long,
    scenario_tag,
    model_xfm = "poly2",
    model_purpose = "linear",
    model_risk = "linear",
    pi_level = 0.90,
    logy = FALSE,
    title_suffix = ""
) {
  long <- df_long %>% dplyr::filter(Scenario == scenario_tag)
  if (!nrow(long)) return(NULL)
  
  series_models <- setNames(
    c(model_xfm, model_purpose, model_risk),
    unname(SERIES_LABELS[c("transform","purpose","risk")])
  )
  
  col_map <- COL_MAP
  
  # Build an x-grid across the observed range
  x_min <- min(long$TotalElements, na.rm = TRUE)
  x_max <- max(long$TotalElements, na.rm = TRUE)
  x_grid <- data.frame(x = seq(x_min, x_max, length.out = 200))
  
  # Fit per series and predict intervals on the grid
  preds <- purrr::map_dfr(names(series_models), function(sn) {
    d <- long %>%
      dplyr::filter(Series == sn) %>%
      dplyr::select(x = TotalElements, y = ms_mean) %>%
      dplyr::filter(is.finite(x), is.finite(y))
    if (!nrow(d)) return(NULL)
    
    m <- lm(model_formula(series_models[[sn]]), data = d)
    pr <- as.data.frame(predict(m, newdata = x_grid, interval = "prediction", level = pi_level))
    tibble(
      Series = sn,
      x = x_grid$x,
      fit = pr$fit,
      lwr = pr$lwr,
      upr = pr$upr
    )
  })
  
  if (!nrow(preds)) return(NULL)
  
  p <- ggplot() +
    geom_ribbon(
      data = preds,
      aes(x = x, ymin = lwr, ymax = upr, fill = Series),
      alpha = 0.25
    ) +
    geom_line(
      data = preds,
      aes(x = x, y = fit, color = Series),
      linewidth = 0.9
    ) +
    scale_fill_manual(values = col_map, drop = TRUE) +
    scale_color_manual(values = col_map, drop = TRUE) +
    background_grid() +
    theme(legend.position = "top") +
    labs(
      x = "model size (TotalElements)",
      y = if (logy) "execution time (ms, log10)" else "execution time (ms)",
      fill = NULL, color = NULL,
      title = paste0(
        sprintf("Fitted lines with %.0f%% prediction envelopes", 100*pi_level),
        title_suffix
      )
    )
  
  if (logy) {
    p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  } else {
    p <- p + scale_y_continuous(labels = scales::label_number())
  }
  p
}

# Binned stacked composition (per iteration)
p_exec_bins_stack <- function(df_long,
                              scenario_tag,
                              n_bins = 12,
                              logy = FALSE,
                              title_suffix = "") {
  long <- df_long %>% dplyr::filter(Scenario == scenario_tag)
  if (!nrow(long)) return(NULL)
  
  x <- long$TotalElements
  brk  <- seq(min(x, na.rm = TRUE), max(x, na.rm = TRUE), length.out = n_bins + 1)
  mids <- (brk[-1] + brk[-length(brk)]) / 2
  long$.__bin__ <- cut(long$TotalElements, breaks = brk, include.lowest = TRUE, labels = FALSE)
  bins_tbl <- tibble(`.__bin__` = seq_len(n_bins), x_mid = mids)
  
  agg <- long %>%
    dplyr::filter(is.finite(.__bin__)) %>%
    dplyr::group_by(.__bin__, Series) %>%
    dplyr::summarise(avg = mean(ms_mean, na.rm = TRUE), .groups = "drop") %>%
    tidyr::drop_na() %>%
    dplyr::left_join(bins_tbl, by = ".__bin__")
  
  if (!nrow(agg)) return(NULL)
  
  col_map <- COL_MAP
  
  p <- ggplot(agg, aes(x = x_mid, y = avg, fill = Series)) +
    geom_col(position = "stack", color = "black", linewidth = 0.15) +
    scale_fill_manual(values = col_map, drop = TRUE) +
    scale_x_continuous(labels = function(v) format(round(v), big.mark = ",")) +
    labs(x = "model size",
         y = if (logy) "avg execution time (per bin, ms, log10)" else "avg exec time per bin (ms)",
         fill = NULL,
         title = paste0("Execution time composition by size bin", title_suffix)) +
    background_grid() +
    theme(legend.position = "right")
  
  if (logy)
    p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  else
    p <- p + scale_y_continuous(labels = scales::label_number())
  
  p
}

p_exec_area_stack <- function(df_long,
                              scenario_tag,
                              n_bins = 12,
                              logy = FALSE,
                              title_suffix = "") {
  
  long <- df_long %>% dplyr::filter(Scenario == scenario_tag)
  if (!nrow(long)) return(NULL)
  
  # Build bins on TotalElements
  x <- long$TotalElements
  brk  <- seq(min(x, na.rm = TRUE), max(x, na.rm = TRUE), length.out = n_bins + 1)
  mids <- (brk[-1] + brk[-length(brk)]) / 2
  long$.__bin__ <- cut(long$TotalElements, breaks = brk, include.lowest = TRUE, labels = FALSE)
  bins_tbl <- tibble(`.__bin__` = seq_len(n_bins), x_mid = mids)
  
  # Per-bin per-series mean (ms)
  agg <- long %>%
    dplyr::filter(is.finite(.__bin__)) %>%
    dplyr::group_by(.__bin__, Series) %>%
    dplyr::summarise(avg = mean(ms_mean, na.rm = TRUE), .groups = "drop") %>%
    dplyr::left_join(bins_tbl, by = ".__bin__") %>%
    dplyr::arrange(Series, x_mid)
  
  if (!nrow(agg)) return(NULL)
  
  # Ensure complete grid so areas don’t break if a bin lacks a series
  all_series <- sort(unique(agg$Series))
  
  complete_grid <- tidyr::expand_grid(.__bin__ = seq_len(n_bins), Series = all_series) %>%
    dplyr::left_join(bins_tbl, by = ".__bin__") %>%                    # bring x_mid once
    dplyr::left_join(agg %>% dplyr::select(.__bin__, Series, avg),     # then bring avg
                     by = c(".__bin__", "Series")) %>%
    dplyr::mutate(avg = dplyr::coalesce(avg, 0)) %>%
    dplyr::arrange(Series, x_mid)
  
  col_map <- COL_MAP
  
  p <- ggplot(complete_grid, aes(x = x_mid, y = avg, fill = Series)) +
    geom_area(position = "stack", alpha = 0.85) +
    scale_fill_manual(values = col_map, drop = TRUE) +
    scale_x_continuous(labels = function(v) format(round(v), big.mark = ",")) +
    labs(x = "model size (TotalElements, bin midpoints)",
         y = if (logy) "avg execution time per bin (ms, log10)" else "avg execution time (ms)",
         fill = NULL,
         title = paste0("Execution time composition by size (stacked area)", title_suffix)) +
    background_grid() +
    theme(legend.position = "top")
  
  if (logy)
    p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  else
    p <- p + scale_y_continuous(labels = scales::label_number())
  
  p
}

build_total_points <- function(raw_df, scenario_tag) {
  need_num <- c("model_index","TotalElements","micros","rep")
  df <- ensure_numeric(raw_df, need_num)
  
  df %>%
    dplyr::filter(scenario == scenario_tag,
                  phase %in% c("transform","purpose","risk")) %>%
    dplyr::group_by(scenario, model_index, TotalElements, rep) %>%
    dplyr::summarise(ms_total = sum(micros, na.rm = TRUE) / 1000.0,
                     .groups = "drop") %>%
    dplyr::filter(is.finite(TotalElements), is.finite(ms_total))
}

# --- NEW: total-time scatter + fitted line ---
p_total_scatter_fit <- function(df_total,
                                model_kind = c("linear","poly2","poly3","logx","exp"),
                                logy = FALSE,
                                title_suffix = "") {
  model_kind <- match.arg(model_kind)
  if (!nrow(df_total)) return(NULL)
  
  p <- ggplot(df_total, aes(x = TotalElements, y = ms_total)) +
    geom_point(alpha = 0.35, size = 0.7, stroke = 0) +
    geom_smooth(
      method = "lm",
      formula = model_formula(model_kind),
      se = FALSE,
      linewidth = 0.9
    ) +
    background_grid() +
    theme(legend.position = "none") +
    labs(x = "model size (TotalElements)",
         y = if (logy) "total execution time (ms, log10)" else "total execution time (ms)",
         title = paste0("Total time vs. model size", title_suffix))
  
  if (logy) {
    p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  } else {
    p <- p + scale_y_continuous(labels = scales::label_number())
  }
  p
}

p_exec_prediction_envelope_log_scenario <- function(
    df_long,
    scenario_tag,
    model_xfm = "poly2",
    model_purpose = "linear",
    model_risk = "linear",
    pi_level = 0.90,
    logy = FALSE,
    title_suffix = ""
) {
  long <- df_long %>% dplyr::filter(Scenario == scenario_tag)
  if (!nrow(long)) return(NULL)
  
  deg_for <- function(kind) if (kind == "poly3") 3 else if (kind == "poly2") 2 else 1
  form_for <- function(kind) as.formula(
    paste0("y ~ poly(log(x + 1), ", deg_for(kind), ", raw=TRUE)")
  )
  
  series_models <- setNames(
    c(model_xfm, model_purpose, model_risk),
    unname(SERIES_LABELS[c("transform","purpose","risk")])
  )
  
  col_map <- COL_MAP
  
  x_min <- min(long$TotalElements, na.rm = TRUE)
  x_max <- max(long$TotalElements, na.rm = TRUE)
  x_grid <- data.frame(x = seq(x_min, x_max, length.out = 200))
  
  preds <- purrr::map_dfr(names(series_models), function(sn) {
    d <- long %>% dplyr::filter(Series == sn) %>%
      dplyr::transmute(x = TotalElements, y = log(ms_mean)) %>%
      dplyr::filter(is.finite(x), is.finite(y))
    if (!nrow(d)) return(NULL)
    
    m  <- lm(form_for(series_models[[sn]]), data = d)
    pr <- as.data.frame(predict(m, newdata = x_grid, interval = "prediction", level = pi_level))
    tibble(
      Series = sn,
      x      = x_grid$x,
      fit    = exp(pr$fit),
      lwr    = exp(pr$lwr),
      upr    = exp(pr$upr)
    )
  })
  
  if (!nrow(preds)) return(NULL)
  
  p <- ggplot() +
    geom_ribbon(data = preds, aes(x = x, ymin = lwr, ymax = upr, fill = Series), alpha = 0.25) +
    geom_line(data = preds,   aes(x = x, y = fit, color = Series), linewidth = 0.9) +
    scale_fill_manual(values = col_map, drop = TRUE) +
    scale_color_manual(values = col_map, drop = TRUE) +
    background_grid() +
    theme(legend.position = "top") +
    labs(
      x = "model size (TotalElements)",
      y = if (logy) "execution time (ms, log10)" else "execution time (ms)",
      fill = NULL, color = NULL,
      title = paste0(sprintf("Log-normal fit with %.0f%% prediction envelopes", 100*pi_level), title_suffix)
    )
  
  if (logy) p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  else      p <- p + scale_y_continuous(labels = scales::label_number())
  
  p
}

# Average total time across iterations, per model (one point per model)
build_total_avg_per_model <- function(df_total) {
  # df_total must be output of build_total_points(...): columns TotalElements, ms_total, model_index
  df_total %>%
    dplyr::group_by(model_index, TotalElements) %>%
    dplyr::summarise(ms_total_avg = mean(ms_total, na.rm = TRUE),
                     .groups = "drop") %>%
    dplyr::filter(is.finite(TotalElements), is.finite(ms_total_avg))
}

build_total_avg_per_model_rel <- function(df_total_rel) {
  df_total_rel %>%
    dplyr::group_by(model_index, TotalRelations) %>%
    dplyr::summarise(ms_total_avg = mean(ms_total, na.rm = TRUE), .groups = "drop") %>%
    dplyr::filter(is.finite(TotalRelations), is.finite(ms_total_avg))
}

build_elem_rel_pairs <- function(raw, per_model = TRUE) {
  need_num <- c("TotalElements","TotalRelations","model_index","rep")
  df <- ensure_numeric(raw, need_num)
  
  df <- df %>%
    dplyr::filter(phase %in% c("transform","purpose","risk")) %>%
    dplyr::select(scenario, model_index, rep, TotalElements, TotalRelations) %>%
    dplyr::filter(is.finite(TotalElements), is.finite(TotalRelations))
  
  if (per_model) {
    # assume size fields are constant per model; use median to be safe
    df <- df %>%
      dplyr::group_by(scenario, model_index) %>%
      dplyr::summarise(
        TotalElements   = median(TotalElements,   na.rm = TRUE),
        TotalRelations  = median(TotalRelations,  na.rm = TRUE),
        .groups = "drop"
      )
  } else {
    df <- df %>% dplyr::distinct(scenario, model_index, rep, TotalElements, TotalRelations)
  }
  df
}

p_elements_vs_relations <- function(df_pairs,
                                    by_scenario   = TRUE,
                                    scatter_mode  = c("points","hex"),
                                    logx = FALSE, logy = FALSE,
                                    title_suffix = " (per model)") {
  scatter_mode <- match.arg(scatter_mode)
  if (!nrow(df_pairs)) return(NULL)
  
  aes_base <- aes(x = TotalElements, y = TotalRelations)
  if (by_scenario) aes_base <- modifyList(aes_base, aes(color = scenario))
  
  p <- ggplot(df_pairs, aes_base)
  
  if (scatter_mode == "hex") {
    if (!requireNamespace("hexbin", quietly = TRUE)) {
      stop("scatter-mode=hex requires 'hexbin' (install.packages('hexbin'))")
    }
    p <- p + stat_binhex(bins = 40) +
      scale_fill_viridis_c(trans = "log10", name = "count") +
      guides(fill = guide_colorbar(barheight = unit(30, "pt")))
  } else {
    p <- p + geom_point(alpha = 1.0, size = 2.0, stroke = 0.0)
  }
  
  # simple linear trend per scenario (or global if not colored)
  # p <- p + geom_smooth(method = "lm", se = FALSE, linewidth = 0.8)
  
  # colors for scenarios (keeps legend even with 1 scenario present)
  if (by_scenario) {
    p <- p + scale_color_manual(
      values = c("A" = "deepskyblue2", "B" = "darkorange1"),
      breaks = c("A","B"), name = "Scenario"
    )
  }
  
  if (logx) p <- p + scale_x_log10(labels = scales::label_number())
  if (logy) p <- p + scale_y_log10(labels = scales::label_number())
  
  p +
    background_grid() +
    theme(legend.position = "right") +
    labs(
      x = "total class instances per model",
      y = "total relations per model",
      title = paste0("Total elements vs total relations", title_suffix)
    )
}


build_total_points_rel <- function(raw_df, scenario_tag) {
  need_num <- c("model_index","TotalRelations","micros","rep")
  df <- ensure_numeric(raw_df, need_num)
  df %>%
    dplyr::filter(scenario == scenario_tag,
                  phase %in% c("transform","purpose","risk")) %>%
    dplyr::group_by(scenario, model_index, TotalRelations, rep) %>%
    dplyr::summarise(ms_total = sum(micros, na.rm = TRUE) / 1000.0,
                     .groups = "drop") %>%
    dplyr::filter(is.finite(TotalRelations), is.finite(ms_total))
}

strip_x_axis <- function(p) {
  p + theme(
    axis.title.x = element_blank(),
    axis.text.x  = element_blank(),
    axis.ticks.x = element_blank(),
    plot.margin  = margin(t = 2, r = 5, b = 2, l = 5)
  )
}

strip_x_text_keep_ticks <- function(p) {
  p + theme(
    axis.title.x = element_blank(),
    axis.text.x  = element_blank(),   # hide numbers
    # keep axis.ticks.x as-is so tick marks remain
    plot.margin  = margin(t = 2, r = 5, b = 2, l = 5)
  )
}

stack_top_scatter_bottom_bins <- function(p_top, p_bottom, xlim_range,
                                          rel_heights = c(1.0, 1.2)) {
  p_top_aligned    <- p_top    + coord_cartesian(xlim = xlim_range)
  p_bottom_aligned <- p_bottom + coord_cartesian(xlim = xlim_range)
  cowplot::plot_grid(
    strip_x_text_keep_ticks(p_top_aligned),
    p_bottom_aligned,
    ncol = 1, align = "v", rel_heights = rel_heights
  )
}


p_total_avg_scatter_fit <- function(df_total_avg,
                                    model_kind = c("linear","poly2","poly3","logx","exp"),
                                    logy = FALSE,
                                    title_suffix = "") {
  model_kind <- match.arg(model_kind)
  if (!nrow(df_total_avg)) return(NULL)
  
  p <- ggplot(df_total_avg,
              aes(x = TotalElements, y = ms_total_avg,
                  color = "Avg total")) +   # <-- map dummy label to color
    geom_point(alpha = 0.7, size = 1.1, stroke = 0) +
    scale_color_manual(values = c("Avg total" = "darkorchid3"), name = NULL) +  # legend styling
    background_grid() +
    labs(x = "model size",
         y = if (logy) "avg total execution time per model (ms, log10)"
         else     "avg exec time per model (ms)",
         title = paste0("Total time (transform + purpose + risk), averaged per model",
                        title_suffix)) +
    theme(legend.position = "right")  # <-- show legend on top
  
  if (logy) {
    p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  } else {
    p <- p + scale_y_continuous(labels = scales::label_number())
  }
  
  p
}


p_exec_envelope_gp_scenario <- function(
  df_long, scenario_tag, pi_level = 0.90, logy = FALSE, title_suffix = ""
) {
  long <- df_long %>% dplyr::filter(Scenario == scenario_tag)
  if (!nrow(long)) return(NULL)

  z <- qnorm((1 + pi_level) / 2)
  col_map <- COL_MAP

  x_min <- min(long$TotalElements, na.rm = TRUE)
  x_max <- max(long$TotalElements, na.rm = TRUE)
  x_grid <- data.frame(x = seq(x_min, x_max, length.out = 200))

  fit_one <- function(sn) {
    d <- long %>% dplyr::filter(Series == sn) %>%
      dplyr::transmute(x = log(TotalElements + 1), y = log(ms_mean)) %>%
      dplyr::filter(is.finite(x), is.finite(y))
    if (!nrow(d)) return(NULL)

    m <- mgcv::gam(y ~ s(x, bs = "gp"), data = d)

    pr <- predict(m, newdata = data.frame(x = log(x_grid$x + 1)),
                  se.fit = TRUE, type = "link")

    # Residual variance on the model (log) scale:
    sigma2 <- summary(m)$scale           # == Var[ε] for Gaussian on log(ms)
    se_mean <- pr$se.fit                 # SE of mean
    se_pred <- sqrt(se_mean^2 + sigma2)  # SE for a new observation (prediction)

    tibble(
      Series = sn,
      x      = x_grid$x,
      fit    = exp(pr$fit),                  # back to ms
      lwr    = exp(pr$fit - z * se_pred),
      upr    = exp(pr$fit + z * se_pred)
    )
  }

  preds <- purrr::map_dfr(unique(long$Series), fit_one)
  if (!nrow(preds)) return(NULL)

  p <- ggplot() +
    geom_ribbon(data = preds, aes(x = x, ymin = lwr, ymax = upr, fill = Series), alpha = 0.25) +
    geom_line(  data = preds, aes(x = x, y = fit, color = Series), linewidth = 0.9) +
    scale_fill_manual(values = col_map, drop = TRUE) +
    scale_color_manual(values = col_map, drop = TRUE) +
    background_grid() +
    theme(legend.position = "top") +
    labs(
      x = "model size (TotalElements)",
      y = if (logy) "execution time (ms, log10)" else "execution time (ms)",
      fill = NULL, color = NULL,
      title = paste0(sprintf("Gaussian Process prediction envelopes (%.0f%%)", 100*pi_level),
                     title_suffix)
    )

  if (logy) p <- p + scale_y_log10(labels = scales::label_number(scale_cut = scales::cut_si("ms")))
  else      p <- p + scale_y_continuous(labels = scales::label_number())
  p
}



fit_and_summarize <- function(df_long, scenario, series_name, kind, label) {
  d <- df_long %>%
    dplyr::filter(Scenario == scenario, Series == series_name) %>%
    dplyr::select(x = TotalElements, y = ms_mean) %>%
    dplyr::filter(is.finite(x) & is.finite(y))
  if (!nrow(d)) return(paste0("\n=== ", label, " (", kind, ")\n[skip] no finite data"))
  m <- lm(model_formula(kind), data = d)
  paste0("\n=== ", label, " (", kind, ", units = ms)\n",
         paste(capture.output(summary(m)), collapse = "\n"))
}

# ----------------------------
# Main
# ----------------------------
main <- function() {
  init_theme()
  
  option_list <- list(
    make_option(c("-o","--out"), type="character", default="plots",
                help="Output directory [default %default]"),
    make_option(c("--xfm-model"), type="character", default="poly2",
                help="Model for Transform series: linear|poly2|poly3|logx|exp [default %default]"),
    make_option(c("--purpose-model"), type="character", default="linear",
                help="Model for Purpose-only series: linear|poly2|poly3|logx|exp [default %default]"),
    make_option(c("--risk-model"), type="character", default="linear",
                help="Model for Risk-only series: linear|poly2|poly3|logx|exp [default %default]"),
    make_option(c("--bins"), type="integer", default=12,
                help="Number of size bins for stacked/envelope plots [default %default]"),
    make_option(c("--logy-scatter"), action="store_true", default=FALSE,
                help="Use log10 scale on y-axis for scatter plots only"),
    make_option(c("--pi-level"), type="double", default=0.90,
                help="Prediction interval level for envelope plots (e.g., 0.90, 0.95) [default %default]"),
    make_option(c("--logy-envelope"), action="store_true", default=FALSE,
                help="Use log10 scale on y-axis for envelope plots only"),
    make_option(c("--scatter-mode"), type="character", default="points",
                help="Scatter mode: points|hex [default %default]"),
    make_option(c("--logy-bins"), action="store_true", default=FALSE,
                help="Use log10 scale on y-axis for envelope & binned bar plots"),
    make_option(c("--show-se"), action="store_true", default=FALSE, help="Show 95%% CI ribbons on fitted LM (scatter only)")
  )
  parser <- OptionParser(usage="%prog samples.csv.gz [samples2.csv.gz ...] [options]", option_list = option_list)
  args <- parse_args(parser, positional_arguments = TRUE)
  if (!length(args$args)) { print_help(parser); quit(status=1) }
  
  outdir       <- args$options$out
  model_xfm    <- tolower(args$options$`xfm-model`)
  model_purp   <- tolower(args$options$`purpose-model`)
  model_risk   <- tolower(args$options$`risk-model`)
  n_bins       <- as.integer(args$options$bins)
  logy_scatter <- isTRUE(args$options$`logy-scatter`)
  logy_bins    <- isTRUE(args$options$`logy-bins`)
  show_se      <- isTRUE(args$options$`show-se`)
  
  
  scatter_mode <- args$options$scatter_mode
  if (is.null(scatter_mode)) scatter_mode <- args$options$`scatter-mode`
  scatter_mode <- tolower(scatter_mode %||% "points")
  if (!scatter_mode %in% c("points","hex")) scatter_mode <- "points"
  message(sprintf("[opt] scatter_mode = %s", scatter_mode))
  
  pi_level      <- as.numeric(args$options$`pi-level`)
  logy_env      <- isTRUE(args$options$`logy-envelope`)
  if (!is.finite(pi_level) || pi_level <= 0 || pi_level >= 1) pi_level <- 0.90
  
  valid <- c("linear","poly2","poly3","logx","exp")
  if (!model_xfm %in% valid)  model_xfm  <- "linear"
  if (!model_purp %in% valid) model_purp <- "linear"
  if (!model_risk %in% valid) model_risk <- "linear"
  if (!is.finite(n_bins) || n_bins < 2) n_bins <- 12
  
  dir.create(outdir, showWarnings = FALSE, recursive = TRUE)
  
  raw <- combined_load_raw(args$args)
  summarize_raw(raw, file.path(outdir, "raw_summary.txt"))
  
  # Build per-iteration long tables for A and B
  dfA <- build_long_series_from_raw(raw, "A")
  dfB <- build_long_series_from_raw(raw, "B")
  
  totA <- build_total_points(raw, "A")
  totB <- build_total_points(raw, "B")
  
  totA_avg <- build_total_avg_per_model(totA)
  totB_avg <- build_total_avg_per_model(totB)
  

  
  # ---------------- Scatter + fit
  pA_avg <- p_total_avg_scatter_fit(totA_avg, model_kind = model_xfm, logy = logy_scatter,
                                    title_suffix = " – Scenario A")
  if (!is.null(pA_avg)) ggsave(file.path(outdir, "bench_exec_times_total_avg_fit_A.pdf"),
                               plot = pA_avg, width = 5.542, height = 2.8, units = "in", device = cairo_pdf)
  
  pB_avg <- p_total_avg_scatter_fit(totB_avg, model_kind = model_xfm, logy = logy_scatter,
                                    title_suffix = " – Scenario B")
  if (!is.null(pB_avg)) ggsave(file.path(outdir, "bench_exec_times_total_avg_fit_B.pdf"),
                               plot = pB_avg, width = 5.542, height = 2.8, units = "in", device = cairo_pdf)
  
  
  pA <- p_total_hex_scatter_fit(totA, model_kind = model_xfm, logy = logy_scatter,
                                title_suffix = " – Scenario A")
  if (!is.null(pA)) ggsave(file.path(outdir, "bench_exec_times_total_fit_A.pdf"),
                               plot = pA, width = 5.542, height = 2.8, units = "in", device = cairo_pdf)
  
  pB <- p_total_hex_scatter_fit(totB, model_kind = model_xfm, logy = logy_scatter,
                                title_suffix = " – Scenario B")
  if (!is.null(pB)) ggsave(file.path(outdir, "bench_exec_times_total_fit_B.pdf"),
                           plot = pB, width = 5.542, height = 2.8, units = "in", device = cairo_pdf)
  
  # Envelope (model-based PI) + fitted lines (no scatter)
  pA_env <- p_exec_prediction_envelope_scenario(
    dfA, "A", model_xfm, model_purp, model_risk,
    pi_level = pi_level, logy = logy_env, title_suffix = " – Scenario A"
  )
  if (!is.null(pA_env)) ggsave(file.path(outdir, "bench_exec_times_vs_size_envelope_A.pdf"),
                               plot = pA_env, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  
  pB_env <- p_exec_prediction_envelope_scenario(
    dfB, "B", model_xfm, model_purp, model_risk,
    pi_level = pi_level, logy = logy_env, title_suffix = " – Scenario B"
  )
  if (!is.null(pB_env)) ggsave(file.path(outdir, "bench_exec_times_vs_size_envelope_B.pdf"),
                               plot = pB_env, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  
  # ----- Log-normal (Gaussian on log scale) envelopes
  pA_env_log <- p_exec_prediction_envelope_log_scenario(
    dfA, "A", model_xfm, model_purp, model_risk,
    pi_level = pi_level, logy = logy_env, title_suffix = " – Scenario A"
  )
  if (!is.null(pA_env_log)) ggsave(file.path(outdir, "bench_exec_times_vs_size_envelope_LOG_A.pdf"),
                                   plot = pA_env_log, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  
  pB_env_log <- p_exec_prediction_envelope_log_scenario(
    dfB, "B", model_xfm, model_purp, model_risk,
    pi_level = pi_level, logy = logy_env, title_suffix = " – Scenario B"
  )
  if (!is.null(pB_env_log)) ggsave(file.path(outdir, "bench_exec_times_vs_size_envelope_LOG_B.pdf"),
                                   plot = pB_env_log, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  
  
  
  
  # Scatter (avg per model) – relations on X
  # --- totals vs. TOTAL RELATIONS (per-iteration and avg-per-model) ---
  totA_rel <- build_total_points_rel(raw, "A")
  totB_rel <- build_total_points_rel(raw, "B")
  
  # Per-model averages
  totA_rel_avg <- build_total_avg_per_model_rel(totA_rel)
  totB_rel_avg <- build_total_avg_per_model_rel(totB_rel)
  
  # Reuse existing plotting fns by renaming x to TotalElements
  totA_rel_for_plot     <- totA_rel     %>% dplyr::rename(TotalElements = TotalRelations)
  totB_rel_for_plot     <- totB_rel     %>% dplyr::rename(TotalElements = TotalRelations)
  totA_rel_avg_for_plot <- totA_rel_avg %>% dplyr::rename(TotalElements = TotalRelations,
                                                          ms_total = ms_total_avg)
  # Note: p_total_avg_scatter_fit expects column 'ms_total_avg', so keep both:
  totA_rel_avg_for_plot <- totA_rel_avg_for_plot %>%
    dplyr::rename(ms_total_avg = ms_total)  # align expected name
  totB_rel_avg_for_plot <- totB_rel_avg %>%
    dplyr::rename(TotalElements = TotalRelations,
                  ms_total_avg = ms_total_avg)
  
  
  
  # avg-per-model (relations on X)
  pA_rel_avg <- p_total_avg_scatter_fit(totA_rel_avg_for_plot, model_kind = model_xfm,
                                        logy = logy_scatter,
                                        title_suffix = " – Scenario A (relations)")
  if (!is.null(pA_rel_avg)) ggsave(
    file.path(outdir, "bench_exec_times_total_avg_fit_rel_A.pdf"),
    plot = pA_rel_avg + labs(x = "model size (number of relations)"),
    width = 5.542, height = 2.8, units = "in", device = cairo_pdf
  )
  
  pB_rel_avg <- p_total_avg_scatter_fit(totB_rel_avg_for_plot, model_kind = model_xfm,
                                        logy = logy_scatter,
                                        title_suffix = " – Scenario B (relations)")
  if (!is.null(pB_rel_avg)) ggsave(
    file.path(outdir, "bench_exec_times_total_avg_fit_rel_B.pdf"),
    plot = pB_rel_avg + labs(x = "model size (number of relations)"),
    width = 5.542, height = 2.8, units = "in", device = cairo_pdf
  )
  
  # per-iteration (relations on X)
  pA_rel <- p_total_hex_scatter_fit(totA_rel_for_plot, model_kind = model_xfm,
                                    logy = logy_scatter,
                                    title_suffix = " – Scenario A (relations)")
  if (!is.null(pA_rel)) ggsave(
    file.path(outdir, "bench_exec_times_total_fit_rel_A.pdf"),
    plot = pA_rel + labs(x = "model size (number of relations)"),
    width = 5.542, height = 2.8, units = "in", device = cairo_pdf
  )
  
  pB_rel <- p_total_hex_scatter_fit(totB_rel_for_plot, model_kind = model_xfm,
                                    logy = logy_scatter,
                                    title_suffix = " – Scenario B (relations)")
  if (!is.null(pB_rel)) ggsave(
    file.path(outdir, "bench_exec_times_total_fit_rel_B.pdf"),
    plot = pB_rel + labs(x = "model size (number of relations)"),
    width = 5.542, height = 2.8, units = "in", device = cairo_pdf
  )
  
  # Long-format for relations
  dfA_rel <- build_long_series_from_raw_rel(raw, "A")
  dfB_rel <- build_long_series_from_raw_rel(raw, "B")
  
  # Binned stacked composition — relations on X
  pA_bins_rel <- p_exec_bins_stack(dfA_rel, "A", n_bins = n_bins, logy = logy_bins,
                                   title_suffix = " – Scenario A (relations)")
  if (!is.null(pA_bins_rel)) ggsave(
    file.path(outdir, "bench_exec_times_share_bins_rel_A.pdf"),
    plot = pA_bins_rel + labs(x = "model size (number of relations)"),
    width = 5.542, height = 2.4, units = "in", device = cairo_pdf
  )
  
  pB_bins_rel <- p_exec_bins_stack(dfB_rel, "B", n_bins = n_bins, logy = logy_bins,
                                   title_suffix = " – Scenario B (relations)")
  if (!is.null(pB_bins_rel)) ggsave(
    file.path(outdir, "bench_exec_times_share_bins_rel_B.pdf"),
    plot = pB_bins_rel + labs(x = "model size (number of relations)"),
    width = 5.542, height = 2.4, units = "in", device = cairo_pdf
  )
  
  # ----- COMBINED FIGURES (A/B) — RELATIONS -----
  # Common x-limits from raw points (already renamed to TotalElements)
  xlim_rel_A <- range(totA_rel_for_plot$TotalElements, na.rm = TRUE)
  xlim_rel_B <- range(totB_rel_for_plot$TotalElements, na.rm = TRUE)
  
  if (!is.null(pA_rel_avg) && !is.null(pA_bins_rel)) {
    combo_A_rel <- stack_top_scatter_bottom_bins(
      p_top    = pA_rel_avg + labs(x = NULL, title = NULL),
      p_bottom = pA_bins_rel + labs(x = "model size (number of relations)",
                                    title = NULL),
      xlim_range = xlim_rel_A
    )
    ggsave(file.path(outdir, "bench_exec_times_rel_A_combo.pdf"),
           plot = combo_A_rel, width = 5.542, height = 3.8, units = "in", device = cairo_pdf)
  }
  
  if (!is.null(pB_rel_avg) && !is.null(pB_bins_rel)) {
    combo_B_rel <- stack_top_scatter_bottom_bins(
      p_top    = pB_rel_avg + labs(x = NULL, title = NULL),
      p_bottom = pB_bins_rel + labs(x = "model size (number of relations)",
                                    title = NULL),
      xlim_range = xlim_rel_B
    )
    ggsave(file.path(outdir, "bench_exec_times_rel_B_combo.pdf"),
           plot = combo_B_rel, width = 5.542, height = 3.8, units = "in", device = cairo_pdf)
  }
  

  
  
  # ----- Gaussian Process envelopes (GAM with GP kernel)
  # pA_env_gp <- p_exec_envelope_gp_scenario(
  #   dfA, "A", pi_level = pi_level, logy = logy_env, title_suffix = " – Scenario A"
  # )
  # if (!is.null(pA_env_gp)) ggsave(file.path(outdir, "bench_exec_times_vs_size_envelope_GP_A.pdf"),
  #                                 plot = pA_env_gp, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  # 
  # pB_env_gp <- p_exec_envelope_gp_scenario(
  #   dfB, "B", pi_level = pi_level, logy = logy_env, title_suffix = " – Scenario B"
  # )
  # if (!is.null(pB_env_gp)) ggsave(file.path(outdir, "bench_exec_times_vs_size_envelope_GP_B.pdf"),
  #                                 plot = pB_env_gp, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  
  
  pA_area <- p_exec_area_stack(dfA, "A", n_bins = n_bins, logy = logy_bins, title_suffix = " – Scenario A")
  if (!is.null(pA_area)) ggsave(file.path(outdir, "bench_exec_times_area_A.pdf"),
                                plot = pA_area, width = 5.542, height = 2.4, units = "in", device = cairo_pdf)
  
  pB_area <- p_exec_area_stack(dfB, "B", n_bins = n_bins, logy = logy_bins, title_suffix = " – Scenario B")
  if (!is.null(pB_area)) ggsave(file.path(outdir, "bench_exec_times_area_B.pdf"),
                                plot = pB_area, width = 5.542, height = 2.4, units = "in", device = cairo_pdf)
  
  # pA_tot <- p_total_scatter_fit(totA, model_kind = model_xfm, logy = logy_scatter, title_suffix = " – Scenario A")
  # if (!is.null(pA_tot)) ggsave(file.path(outdir, "bench_exec_times_total_fit_A.pdf"),
  #                              plot = pA_tot, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  # 
  # pB_tot <- p_total_scatter_fit(totB, model_kind = model_xfm, logy = logy_scatter, title_suffix = " – Scenario B")
  # if (!is.null(pB_tot)) ggsave(file.path(outdir, "bench_exec_times_total_fit_B.pdf"),
  #                              plot = pB_tot, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  
  
  # ---------------- Bins stacked composition
  pA_bins <- p_exec_bins_stack(dfA, "A", n_bins = n_bins, logy = logy_bins, title_suffix = " – Scenario A")
  if (!is.null(pA_bins)) ggsave(file.path(outdir, "bench_exec_times_share_bins_A.pdf"),
                                plot = pA_bins, width = 5.542, height = 2.4, units = "in", device = cairo_pdf)
  pB_bins <- p_exec_bins_stack(dfB, "B", n_bins = n_bins, logy = logy_bins, title_suffix = " – Scenario B")
  if (!is.null(pB_bins)) ggsave(file.path(outdir, "bench_exec_times_share_bins_B.pdf"),
                                plot = pB_bins, width = 5.542, height = 2.4, units = "in", device = cairo_pdf)
  
  # ----- COMBINED FIGURES (A/B) — TOTAL ELEMENTS -----
  xlim_el_A <- range(totA$TotalElements, na.rm = TRUE)
  xlim_el_B <- range(totB$TotalElements, na.rm = TRUE)
  
  # reuse existing element-based plots: pA_avg/pB_avg (top) and pA_bins/pB_bins (bottom)
  if (!is.null(pA_avg) && !is.null(pA_bins)) {
    combo_A_el <- stack_top_scatter_bottom_bins(
      p_top    = pA_avg + labs(x = NULL, title = NULL),
      p_bottom = pA_bins + labs(x = "model size (number of class instances)", title = NULL),
      xlim_range = xlim_el_A
    )
    ggsave(file.path(outdir, "bench_exec_times_elements_A_combo.pdf"),
           plot = combo_A_el, width = 5.542, height = 3.8, units = "in", device = cairo_pdf)
  }
  
  if (!is.null(pB_avg) && !is.null(pB_bins)) {
    combo_B_el <- stack_top_scatter_bottom_bins(
      p_top    = pB_avg + labs(x = NULL, title = NULL),
      p_bottom = pB_bins + labs(x = "model size (number of class instances)", title = NULL),
      xlim_range = xlim_el_B
    )
    ggsave(file.path(outdir, "bench_exec_times_elements_B_combo.pdf"),
           plot = combo_B_el, width = 5.542, height = 3.8, units = "in", device = cairo_pdf)
  }
  
  
  
  # --- Elements vs Relations ---
  pairs_per_model <- build_elem_rel_pairs(raw, per_model = TRUE)
  p_pairs_model   <- p_elements_vs_relations(pairs_per_model,
                                             by_scenario = TRUE,
                                             scatter_mode = "points",
                                             logx = FALSE, logy = FALSE,
                                             title_suffix = " (per model)")
  if (!is.null(p_pairs_model)) ggsave(
    file.path(outdir, "bench_elements_vs_relations_per_model.pdf"),
    plot = p_pairs_model, width = 5.542, height = 2.8, units = "in", device = cairo_pdf
  )
  
  # Optional: per-iteration hexbin view (dense datasets)
  pairs_per_iter <- build_elem_rel_pairs(raw, per_model = FALSE)
  p_pairs_hex    <- p_elements_vs_relations(pairs_per_iter,
                                            by_scenario = TRUE,
                                            scatter_mode = "hex",
                                            logx = FALSE, logy = FALSE,
                                            title_suffix = " (per iteration, hexbin)")
  if (!is.null(p_pairs_hex)) ggsave(
    file.path(outdir, "bench_elements_vs_relations_hex.pdf"),
    plot = p_pairs_hex, width = 5.542, height = 2.8, units = "in", device = cairo_pdf
  )
  
  
  # ---------------- Model summaries (fits on per-iteration points)
  writeLines(c(
    fit_and_summarize(dfA, "A", SERIES_LABELS[["transform"]], model_xfm,  paste0("A: ", SERIES_LABELS[["transform"]])),
    fit_and_summarize(dfA, "A", SERIES_LABELS[["purpose"]],   model_purp, paste0("A: ", SERIES_LABELS[["purpose"]])),
    fit_and_summarize(dfA, "A", SERIES_LABELS[["risk"]],      model_risk, paste0("A: ", SERIES_LABELS[["risk"]]))
  ), file.path(outdir, "bench_exec_models_A.txt"))

  writeLines(c(
    fit_and_summarize(dfA, "B", SERIES_LABELS[["transform"]], model_xfm,  paste0("B: ", SERIES_LABELS[["transform"]])),
    fit_and_summarize(dfA, "B", SERIES_LABELS[["purpose"]],   model_purp, paste0("B: ", SERIES_LABELS[["purpose"]])),
    fit_and_summarize(dfA, "B", SERIES_LABELS[["risk"]],      model_risk, paste0("B: ", SERIES_LABELS[["risk"]]))
  ), file.path(outdir, "bench_exec_models_B.txt"))
  
  message(sprintf("[ok] wrote outputs to: %s", normalizePath(outdir)))
  message("goodbye")
}

if (identical(environment(), globalenv())) {
  tryCatch(main(), error = function(e) { message("Error: ", e$message); quit(status=1) })
}
