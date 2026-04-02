#!/usr/bin/env Rscript
# bench_exec_times_fit_AB_ms.R
# Usage:
#   Rscript bench_exec_times_fit_AB_ms.R bench.csv [bench2.csv ...] \
#     --out plots \
#     --xfm-model poly2 --purpose-model linear --risk-model linear \
#     --bins 12 --logy --show-se
#
# Outputs:
#   plots/bench_exec_times_vs_size_fit_A.pdf
#   plots/bench_exec_times_vs_size_fit_B.pdf
#   plots/bench_exec_times_share_bins_A.pdf
#   plots/bench_exec_times_share_bins_B.pdf
#   plots/bench_exec_models_A.txt
#   plots/bench_exec_models_B.txt

suppressWarnings({
  suppressPackageStartupMessages({
    library(optparse)
    library(readr)
    library(dplyr)
    library(ggplot2)
    library(cowplot)
    library(scales)
    library(showtext)
    library(purrr)
    library(stringr)
    library(tidyr)
  })
})

# ----------------------------
# Theme & colors (CASA style)
# ----------------------------
init_theme <- function() {
  theme_set(theme_cowplot(font_size = 8, font_family = "TeX Gyre Pagella") +
              theme(plot.title = element_blank()))
}
COL_XFM    <- "#0072B2" # blue
COL_PURP   <- "#E69F00" # orange
COL_RISK   <- "#009E73" # green

background_grid <- function() {
  theme(panel.grid.major = element_line(color = "grey90", linewidth = 0.25),
        panel.grid.minor = element_blank())
}

# ----------------------------
# Helpers
# ----------------------------
combined_load <- function(paths) {
  frames <- lapply(paths, \(p) readr::read_csv(p, show_col_types = FALSE) %>%
                     mutate(`__source__` = as.character(p)))
  if (!length(frames)) stop("No CSVs loaded.")
  bind_rows(frames)
}

ensure_numeric <- function(df, cols) {
  cols <- intersect(cols, names(df))
  for (c in cols) df[[c]] <- suppressWarnings(as.numeric(df[[c]]))
  df
}

# convert *_avg_us columns (if present) to *_avg_ms (added as new columns)
us_to_ms_columns <- function(df, prefixes = c("A_", "B_"),
                             kinds = c("xfm", "purpose", "risk"),
                             suffix = "_avg_us") {
  for (pref in prefixes) for (k in kinds) {
    src <- paste0(pref, k, suffix)
    dst <- paste0(pref, k, "_avg_ms")
    if (src %in% names(df)) df[[dst]] <- suppressWarnings(as.numeric(df[[src]])) / 1000
  }
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

fit_and_summarize <- function(df, x, y_ms_col, kind, label) {
  if (!(x %in% names(df)) || !(y_ms_col %in% names(df)))
    return(paste0("\n=== ", label, " (", kind, ")\n[skip] missing column: ", y_ms_col))
  
  d <- tibble(x = df[[x]], y = df[[y_ms_col]]) %>% filter(is.finite(x) & is.finite(y))
  if (!nrow(d)) return(paste0("\n=== ", label, " (", kind, ")\n[skip] no finite data"))
  
  m <- lm(model_formula(kind), data = d)
  paste0("\n=== ", label, " (", kind, ", units = ms)\n",
         paste(capture.output(summary(m)), collapse = "\n"))
}

# ----------------------------
# One scenario: scatter + fitted lines (in ms)
# ----------------------------
p_exec_fit_scenario <- function(df, prefix,
                                size_col = "TotalElements",
                                model_xfm = "poly2",
                                model_purpose = "linear",
                                model_risk = "linear",
                                show_se = FALSE,
                                logy = FALSE,
                                title_suffix = "") {
  
  y_xfm_ms     <- paste0(prefix, "xfm_avg_ms")
  y_purpose_ms <- paste0(prefix, "purpose_avg_ms")
  y_risk_ms    <- paste0(prefix, "risk_avg_ms")
  
  present <- names(df)
  series <- list(
    list(name = "Transform",    col = y_xfm_ms,     model = model_xfm,     color = COL_XFM),
    list(name = "Purpose-only", col = y_purpose_ms, model = model_purpose, color = COL_PURP),
    list(name = "Risk-only",    col = y_risk_ms,    model = model_risk,    color = COL_RISK)
  )
  series <- Filter(function(s) s$col %in% present, series)
  if (!length(series)) return(NULL)
  
  need <- unique(c(size_col, vapply(series, function(s) s$col, character(1))))
  df <- ensure_numeric(df, need)
  
  long_raw <- bind_rows(lapply(series, function(s) {
    tibble(Series = s$name, x = df[[size_col]], y = df[[s$col]])
  })) %>% filter(is.finite(x) & is.finite(y))
  
  col_map <- setNames(vapply(series, function(s) s$color, character(1)),
                      vapply(series, function(s) s$name, character(1)))
  
  p <- ggplot(long_raw, aes(x = x, y = y, color = Series)) +
    geom_point(alpha = 0.35, size = 1, stroke = 0) +
    scale_color_manual(values = col_map) +
    background_grid() +
    theme(legend.position = "top") +
    labs(x = "model size (TotalElements)",
         y = if (logy) "execution time (ms, log₁₀)" else "execution time (ms)",
         color = NULL,
         title = paste0("Execution time vs. model size", title_suffix))
  
  for (s in series) {
    p <- p + geom_smooth(
      data = subset(long_raw, Series == s$name),
      method = "lm",
      formula = model_formula(s$model),
      se = show_se,
      size = 0.7
    )
  }
  
  if (logy) p <- p + scale_y_log10(labels = label_number_si()) else p <- p + scale_y_continuous(labels = comma)
  p
}

# ----------------------------
# One scenario: binned stacked bars (composition, in ms)
# ----------------------------
p_exec_bins_stack <- function(df, prefix,
                              size_col = "TotalElements",
                              n_bins = 12,
                              title_suffix = "") {
  
  y_xfm_ms     <- paste0(prefix, "xfm_avg_ms")
  y_purpose_ms <- paste0(prefix, "purpose_avg_ms")
  y_risk_ms    <- paste0(prefix, "risk_avg_ms")
  
  need <- c(size_col, y_xfm_ms, y_purpose_ms, y_risk_ms)
  df <- ensure_numeric(df, need)
  
  keep_cols <- intersect(c(size_col, y_xfm_ms, y_purpose_ms, y_risk_ms), names(df))
  df <- df[keep_cols]
  df <- df %>% dplyr::filter(is.finite(.data[[size_col]]))
  if (!nrow(df)) return(NULL)
  
  # breaks + midpoint lookup
  x    <- df[[size_col]]
  brk  <- seq(min(x, na.rm = TRUE), max(x, na.rm = TRUE), length.out = n_bins + 1)
  mids <- (brk[-1] + brk[-length(brk)]) / 2
  bins_tbl <- tibble(`.__bin__` = seq_len(n_bins), x_mid = mids)
  
  df$.__bin__ <- cut(df[[size_col]], breaks = brk, include.lowest = TRUE, labels = FALSE)
  
  has_xfm     <- y_xfm_ms     %in% names(df)
  has_purpose <- y_purpose_ms %in% names(df)
  has_risk    <- y_risk_ms    %in% names(df)
  
  agg <- df %>%
    dplyr::filter(is.finite(.__bin__)) %>%
    dplyr::group_by(.__bin__) %>%
    dplyr::summarize(
      xfm     = if (has_xfm)     mean(.data[[y_xfm_ms]],     na.rm = TRUE) else NA_real_,
      purpose = if (has_purpose) mean(.data[[y_purpose_ms]], na.rm = TRUE) else NA_real_,
      risk    = if (has_risk)    mean(.data[[y_risk_ms]],    na.rm = TRUE) else NA_real_,
      .groups = "drop"
    ) %>%
    dplyr::left_join(bins_tbl, by = ".__bin__")
  
  agg <- agg %>% dplyr::filter(!(is.na(xfm) & is.na(purpose) & is.na(risk)))
  if (!nrow(agg)) return(NULL)
  
  long <- agg %>%
    tidyr::pivot_longer(cols = c(xfm, purpose, risk),
                        names_to = "Series", values_to = "avg") %>%
    dplyr::filter(is.finite(avg))
  
  long$Series <- factor(long$Series,
                        levels = c("xfm", "purpose", "risk"),
                        labels = c("Transform", "Purpose-only", "Risk-only"))
  col_map <- c("Transform" = COL_XFM, "Purpose-only" = COL_PURP, "Risk-only" = COL_RISK)
  
  ggplot(long, aes(x = x_mid, y = avg, fill = Series)) +
    geom_col(position = "stack", color = "black", linewidth = 0.15) +
    scale_fill_manual(values = col_map) +
    scale_x_continuous(labels = function(v) format(round(v), big.mark = ",")) +
    labs(x = "model size (TotalElements, bin midpoints)",
         y = "avg execution time per bin (ms)",
         fill = NULL,
         title = paste0("Execution time composition by size bin", title_suffix)) +
    background_grid() +
    theme(legend.position = "top")
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
                help="Model for *_xfm_avg_us (plotted in ms): linear|poly2|poly3|logx|exp [default %default]"),
    make_option(c("--purpose-model"), type="character", default="linear",
                help="Model for *_purpose_avg_us (plotted in ms): linear|poly2|poly3|logx|exp [default %default]"),
    make_option(c("--risk-model"), type="character", default="linear",
                help="Model for *_risk_avg_us (plotted in ms): linear|poly2|poly3|logx|exp [default %default]"),
    make_option(c("--bins"), type="integer", default=12,
                help="Number of size bins for stacked bars [default %default]"),
    make_option(c("--logy"), action="store_true", default=FALSE, help="Use log10 on y-axis (scatter only)"),
    make_option(c("--show-se"), action="store_true", default=FALSE, help="Show 95%% CI ribbons (scatter only)")
  )
  parser <- OptionParser(usage="%prog bench.csv [bench2.csv ...] [options]", option_list = option_list)
  args <- parse_args(parser, positional_arguments = TRUE)
  if (!length(args$args)) { print_help(parser); quit(status=1) }
  
  outdir       <- args$options$out
  model_xfm    <- tolower(args$options$`xfm-model`)
  model_purp   <- tolower(args$options$`purpose-model`)
  model_risk   <- tolower(args$options$`risk-model`)
  n_bins       <- as.integer(args$options$bins)
  logy         <- isTRUE(args$options$logy)
  show_se      <- isTRUE(args$options$`show-se`)
  
  valid <- c("linear","poly2","poly3","logx","exp")
  if (!model_xfm %in% valid)  model_xfm  <- "poly2"
  if (!model_purp %in% valid) model_purp <- "linear"
  if (!model_risk %in% valid) model_risk <- "linear"
  if (!is.finite(n_bins) || n_bins < 2) n_bins <- 12
  
  dir.create(outdir, showWarnings = FALSE, recursive = TRUE)
  df <- combined_load(args$args)
  
  # Create ms columns once
  df <- us_to_ms_columns(df)
  
  # --- Scenario A ---
  pA <- p_exec_fit_scenario(
    df, prefix = "A_",
    model_xfm = model_xfm, model_purpose = model_purp, model_risk = model_risk,
    show_se = show_se, logy = logy, title_suffix = " – Scenario A"
  )
  if (!is.null(pA)) {
    ggsave(file.path(outdir, "bench_exec_times_vs_size_fit_A.pdf"),
           plot = pA, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  } else message("[warn] Scenario A: no series available to plot (scatter/fit)")
  
  pA_bins <- p_exec_bins_stack(df, prefix = "A_", n_bins = n_bins,
                               title_suffix = " – Scenario A")
  if (!is.null(pA_bins)) {
    ggsave(file.path(outdir, "bench_exec_times_share_bins_A.pdf"),
           plot = pA_bins, width = 5.542, height = 2.4, units = "in", device = cairo_pdf)
  } else message("[warn] Scenario A: no series available to plot (bins)")
  
  # --- Scenario B ---
  pB <- p_exec_fit_scenario(
    df, prefix = "B_",
    model_xfm = model_xfm, model_purpose = model_purp, model_risk = model_risk,
    show_se = show_se, logy = logy, title_suffix = " – Scenario B"
  )
  if (!is.null(pB)) {
    ggsave(file.path(outdir, "bench_exec_times_vs_size_fit_B.pdf"),
           plot = pB, width = 5.542, height = 2.6, units = "in", device = cairo_pdf)
  } else message("[warn] Scenario B: no series available to plot (scatter/fit)")
  
  pB_bins <- p_exec_bins_stack(df, prefix = "B_", n_bins = n_bins,
                               title_suffix = " – Scenario B")
  if (!is.null(pB_bins)) {
    ggsave(file.path(outdir, "bench_exec_times_share_bins_B.pdf"),
           plot = pB_bins, width = 5.542, height = 2.4, units = "in", device = cairo_pdf)
  } else message("[warn] Scenario B: no series available to plot (bins)")
  
  # --- Model summaries (A & B) — in ms
  writeLines(c(
    fit_and_summarize(df, "TotalElements", "A_xfm_avg_ms",     model_xfm,  "A: Transform"),
    fit_and_summarize(df, "TotalElements", "A_purpose_avg_ms", model_purp, "A: Purpose"),
    fit_and_summarize(df, "TotalElements", "A_risk_avg_ms",    model_risk, "A: Risk")
  ), file.path(outdir, "bench_exec_models_A.txt"))
  
  writeLines(c(
    fit_and_summarize(df, "TotalElements", "B_xfm_avg_ms",     model_xfm,  "B: Transform"),
    fit_and_summarize(df, "TotalElements", "B_purpose_avg_ms", model_purp, "B: Purpose"),
    fit_and_summarize(df, "TotalElements", "B_risk_avg_ms",    model_risk, "B: Risk")
  ), file.path(outdir, "bench_exec_models_B.txt"))
  
  message(sprintf("[ok] wrote outputs to: %s", normalizePath(outdir)))
}

if (identical(environment(), globalenv())) {
  tryCatch(main(), error = function(e) { message("Error: ", e$message); quit(status=1) })
}
