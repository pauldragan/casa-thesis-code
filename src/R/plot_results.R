#!/usr/bin/env Rscript
# casa_plots.R
# Usage:
#   Rscript casa_plots.R /path/to/index.csv [/path/to/another.csv ...] --out plots --bins 20 --envelope iqr
#
# Outputs:
#   plots/summary.csv
#   plots/baseline/*.pdf
#   plots/scenarioA/*.pdf
#   plots/scenarioB/*.pdf
#   plots/deltas/*.pdf
#
# Styling: Pagella (texgyrepagella-regular.otf), cowplot theme, brewer palettes.

suppressWarnings({
  suppressPackageStartupMessages({
    library(optparse)
    library(readr)
    library(dplyr)
    library(tidyr)
    library(ggplot2)
    library(cowplot)
    library(scales)
    library(showtext)
    library(stringr)
    library(purrr)
  })
})

# ----------------------------
# Font & theme (like your thesis)
# ----------------------------
init_theme <- function() {
  theme_set(theme_cowplot(font_size = 8, font_family = "TeX Gyre Pagella") +
              theme(plot.title = element_blank()))
}

ACCENT_BLUE <- "#0072B2"  # nice, clean blue (colorblind-friendly)
no_titles <- theme(plot.title = element_blank())

# Soft, print-friendly palette + distinct borders & linetypes (for element composition area w/ texture)
ELEMENT_PALETTE_SOFT <- c(
  "DS"             = "#c7e9c0",
  "PD"             = "#a6bddb",
  "Functions"      = "#fdd0a2",
  "Components"     = "#bcbddc",
  "Vulnerabilities"= "#ccebc5",
  "Purposes"       = "#fdae6b",
  "Consents"       = "#9ecae1"
)
ELEMENT_BORDER_COLORS <- c(
  "DS"             = "#7fbf7b",
  "PD"             = "#3690c0",
  "Functions"      = "#e6550d",
  "Components"     = "#756bb1",
  "Vulnerabilities"= "#41ab5d",
  "Purposes"       = "#d95f0e",
  "Consents"       = "#3182bd"
)
ELEMENT_LINETYPES <- c(
  "DS"             = "solid",
  "PD"             = "dashed",
  "Functions"      = "dotdash",
  "Components"     = "twodash",
  "Vulnerabilities"= "longdash",
  "Purposes"       = "dotted",
  "Consents"       = "F1"
)

# Violations palette (COLORS ONLY)
VIOL_COLORS <- c(
  "Purpose (Unrelated)"       = "#0072B2", # blue
  "Purpose (Generalization)"  = "#E69F00", # orange
  "Risk"                      = "#009E73"  # bluish green
)


# ----------------------------
# Helpers
# ----------------------------
first_col <- function(df, candidates, default = NA_character_) {
  for (c in candidates) if (c %in% names(df)) return(c)
  default
}

pick_size_cols <- function(df) {
  list(
    Total       = first_col(df, c("A_post_TotalElements","TotalElements")),
    DS          = first_col(df, c("A_post_DS","DS")),
    PD          = first_col(df, c("A_post_PD","PD")),
    Functions   = first_col(df, c("A_post_Functions","Functions")),
    Components  = first_col(df, c("A_post_Components","Components")),
    Vulns       = first_col(df, c("A_post_Vulnerabilities","Vulnerabilities")),
    Purposes    = first_col(df, c("A_post_Purposes","Purposes")),
    Consents    = first_col(df, c("A_post_Consents","Consents"))
  )
}

build_cols_for_prefix <- function(df, prefix) {
  pick <- function(pref_name, toplvl) {
    cand <- character()
    if (!is.null(prefix) && nzchar(prefix) && !is.null(pref_name)) cand <- c(paste0(prefix, "_", pref_name))
    if (!is.null(toplvl)) cand <- c(cand, toplvl)
    first_col(df, cand)
  }
  list(
    Total      = pick("TotalElements","TotalElements"),
    DS         = pick("DS","DS"),
    PD         = pick("PD","PD"),
    Functions  = pick("Functions","Functions"),
    Components = pick("Components","Components"),
    Vulns      = pick("Vulnerabilities","Vulnerabilities"),
    Purposes   = pick("Purposes","Purposes"),
    Consents   = pick("Consents","Consents")
  )
}

scenario_label_and_prefixes <- function(df) {
  candidates <- list(
    list(label="baseline",  pref="baseline"),
    list(label="scenarioA", pref="A_post"),
    list(label="scenarioB", pref="B_post")
  )
  usable <- list()
  for (c in candidates) {
    cols <- build_cols_for_prefix(df, c$pref)
    if (!is.na(cols$Total) && cols$Total %in% names(df)) usable <- append(usable, list(c))
  }
  if (length(usable) == 0) usable <- list(list(label="all", pref=""))
  usable
}

ensure_numeric <- function(df, cols) {
  cols <- cols[!is.na(cols) & cols %in% names(df)]
  for (c in cols) df[[c]] <- suppressWarnings(as.numeric(df[[c]]))
  df
}

combined_load <- function(paths) {
  frames <- lapply(paths, \(p) {
    readr::read_csv(p, show_col_types = FALSE) %>% mutate(`__source__` = as.character(p))
  })
  if (length(frames) == 0) stop("No CSVs loaded.")
  bind_rows(frames)
}

is_finite_all <- function(...) {
  mats <- list(...)
  ok <- Reduce(`&`, lapply(mats, function(v) is.finite(v)))
  ok[is.na(ok)] <- FALSE
  ok
}

# ----------------------------
# Plotting helpers
# ----------------------------
.elem_shapes <- c(
  "DataSubjects"    = 16,
  "PersonalData"    = 15,
  "Functions"       = 17,
  "Components"      = 7,
  "Vulnerabilities" = 4,
  "Purposes"        = 8,
  "Consents"        = 3
)

ELEMENT_PALETTE <- c(
  "DS"              = "#56B4E9",
  "PD"              = "#E69F00",
  "Functions"       = "#009E73",
  "Components"      = "#0072B2",
  "Vulnerabilities" = "#D55E00",
  "Purposes"        = "#CC79A7",
  "Consents"        = "#F0E442"
)

# Histogram for total relations (same look as p_hist)
p_hist_relations <- function(df, rel_col = "TotalRelations", title_suffix = "", bins = 10) {
  if (!(rel_col %in% names(df))) return(NULL)
  s <- suppressWarnings(as.numeric(df[[rel_col]]))
  s <- s[is.finite(s)]
  if (!length(s)) return(NULL)
  ggplot(df, aes(x = .data[[rel_col]])) +
    geom_histogram(bins = bins, color = "black", linewidth = 0.2, fill = ACCENT_BLUE) +
    labs(x = "total relations", y = "count of models",
         title = paste0("Model relation distribution", title_suffix)) +
    background_grid()
}


p_hist <- function(df, size_col, title_suffix="", bins=10) {
  s <- df[[size_col]]
  s <- s[!is.na(s)]
  if (length(s) == 0) return(NULL)
  ggplot(df, aes(x = .data[[size_col]])) +
    geom_histogram(bins = bins, color = "black", linewidth = 0.2, fill = ACCENT_BLUE) +
    labs(x = "total elements", y = "count of models",
         title = paste0("Model size distribution", title_suffix)) +
    background_grid()
}

p_scatter_all <- function(df, cols, title_suffix="") {
  xcol <- cols$Total
  if (is.na(xcol) || !(xcol %in% names(df))) return(NULL)
  series <- c("Functions","Components","PD","DS","Vulns","Purposes","Consents")
  series_cols <- c(cols$Functions, cols$Components, cols$PD, cols$DS, cols$Vulns, cols$Purposes, cols$Consents)
  keep <- !is.na(series_cols) & series_cols %in% names(df)
  if (!any(keep)) return(NULL)
  long <- map2(series[keep], series_cols[keep], \(nm, col) {
    tibble(Element = nm, x = df[[xcol]], y = df[[col]])
  }) %>% bind_rows() %>% filter(is_finite_all(x, y))
  
  ggplot(long, aes(x = x, y = y, color = Element, shape = Element)) +
    geom_point(alpha = 0.6, size = 1, na.rm = TRUE) +
    scale_shape_manual(values = .elem_shapes[unique(long$Element)]) +
    scale_color_brewer(palette = "Dark2") +
    labs(x = "total elements", y = "count",
         title = paste0("Complexity vs. size (all element types)", title_suffix)) +
    background_grid()
}

bin_stats <- function(df, xcol, ycol, n_bins = 10) {
  x <- df[[xcol]]
  x <- x[is.finite(x)]
  if (!length(x)) return(tibble())
  bins <- seq(min(x, na.rm=TRUE), max(x, na.rm=TRUE), length.out = n_bins + 1)
  mids <- (bins[-1] + bins[-length(bins)]) / 2
  df$.__bin__ <- cut(df[[xcol]], breaks = bins, include.lowest = TRUE, labels = FALSE)
  gp <- df %>% group_by(.__bin__) %>%
    summarize(
      mean = mean(.data[[ycol]], na.rm=TRUE),
      med  = median(.data[[ycol]], na.rm=TRUE),
      q1   = quantile(.data[[ycol]], 0.25, na.rm=TRUE, type = 7),
      q3   = quantile(.data[[ycol]], 0.75, na.rm=TRUE, type = 7),
      p10  = quantile(.data[[ycol]], 0.10, na.rm=TRUE, type = 7),
      p90  = quantile(.data[[ycol]], 0.90, na.rm=TRUE, type = 7),
      min  = suppressWarnings(min(.data[[ycol]], na.rm=TRUE)),
      max  = suppressWarnings(max(.data[[ycol]], na.rm=TRUE)),
      .groups="drop"
    )
  gp$bin_index <- gp$.__bin__
  full <- tibble(bin_index = seq_len(n_bins)) %>%
    left_join(gp, by="bin_index") %>%
    mutate(x = mids[bin_index])
  full
}

p_trends_mean <- function(df, cols, n_bins=10, title_suffix="") {
  xcol <- cols$Total
  if (is.na(xcol) || !(xcol %in% names(df))) return(NULL)
  series <- c("DataSubjects","PersonalData","Functions","Components","Vulnerabilities","Purposes","Consents")
  scols  <- c(cols$DS, cols$PD, cols$Functions, cols$Components, cols$Vulns, cols$Purposes, cols$Consents)
  keep <- !is.na(scols) & scols %in% names(df)
  if (!any(keep)) return(NULL)
  stats_list <- map2(series[keep], scols[keep], \(nm, col) {
    bs <- bin_stats(df, xcol, col, n_bins)
    if (nrow(bs) == 0) return(tibble())
    bs$Element <- nm
    bs
  }) %>% bind_rows() %>% filter(is_finite_all(x, mean))
  if (!nrow(stats_list)) return(NULL)
  ggplot(stats_list, aes(x = x, y = mean, color = Element, shape = Element)) +
    geom_line(linewidth = 0.6, na.rm = TRUE) +
    geom_point(size = 1, na.rm = TRUE) +
    scale_shape_manual(values = .elem_shapes[unique(stats_list$Element)]) +
    scale_color_brewer(palette = "Dark2") +
    labs(x = "model size (total elements, binned)", y = "average count",
         title = paste0("Model complexity trends vs. size", title_suffix)) +
    background_grid()
}

p_trends_envelope <- function(df, cols, n_bins=10, envelope="iqr", title_suffix="") {
  xcol <- cols$Total
  series <- c("DataSubjects","PersonalData","Functions","Components","Vulnerabilities","Purposes","Consents")
  scols  <- c(cols$DS, cols$PD, cols$Functions, cols$Components, cols$Vulns, cols$Purposes, cols$Consents)
  keep <- !is.na(scols) & scols %in% names(df)
  if (!any(keep)) return(NULL)
  stats_list <- map2(series[keep], scols[keep], \(nm, col) {
    bs <- bin_stats(df, xcol, col, n_bins)
    if (nrow(bs) == 0) return(tibble())
    bs$Element <- nm
    bs
  }) %>% bind_rows()
  if (!nrow(stats_list)) return(NULL)
  pick <- function(d) {
    if (envelope == "p10p90") list(line = d$mean, lo = d$p10, hi = d$p90, lbl="mean, 10–90%")
    else if (envelope == "minmax") list(line = d$mean, lo = d$min, hi = d$max, lbl="mean, min–max")
    else list(line = d$med, lo = d$q1, hi = d$q3, lbl="median, IQR")
  }
  stats_pick <- stats_list %>%
    group_by(Element) %>%
    group_modify(function(df, key) {
      env <- pick(df)
      df$.line <- env$line
      df$.lo   <- env$lo
      df$.hi   <- env$hi
      df$.lbl  <- env$lbl
      df
    }) %>% ungroup() %>%
    filter(is_finite_all(x, .line, .lo, .hi))
  if (!nrow(stats_pick)) return(NULL)
  ggplot(stats_pick, aes(x = x, color = Element, fill = Element)) +
    geom_ribbon(aes(ymin = .lo, ymax = .hi), alpha = 0.15, linewidth = 0, na.rm = TRUE) +
    geom_line(aes(y = .line), linewidth = 0.7, na.rm = TRUE) +
    geom_point(aes(y = .line, shape = Element), size = 1, na.rm = TRUE) +
    scale_shape_manual(values = .elem_shapes[unique(stats_pick$Element)]) +
    scale_color_brewer(palette = "Dark2") +
    scale_fill_brewer(palette = "Dark2") +
    labs(x = "model size (total elements, binned)", y = "count",
         title = paste0("Model complexity trends with variability (", unique(stats_pick$.lbl), ")", title_suffix)) +
    background_grid()
}

p_violations_vs_size <- function(df, size_col, title_suffix="") {
  gt_purpose <- first_col(df, c("gt_purpose_total"))
  gt_risk    <- first_col(df, c("gt_risk_violations"))
  det_p      <- first_col(df, c("detected_purpose_total"))
  det_r      <- first_col(df, c("detected_risk_violations"))
  need <- c(size_col, gt_purpose, gt_risk, det_p, det_r)
  if (any(is.na(need))) return(NULL)
  long <- bind_rows(
    tibble(Series="GT purpose",       x=df[[size_col]], y=df[[gt_purpose]]),
    tibble(Series="Detected purpose", x=df[[size_col]], y=df[[det_p]]),
    tibble(Series="GT risk",          x=df[[size_col]], y=df[[gt_risk]]),
    tibble(Series="Detected risk",    x=df[[size_col]], y=df[[det_r]])
  ) %>% filter(is_finite_all(x, y))
  ggplot(long, aes(x = x, y = y, color = Series, shape = Series)) +
    geom_point(alpha = 0.6, size = 1, na.rm = TRUE) +
    scale_color_brewer(palette = "Set1") +
    labs(x = "total elements", y = "# of violations",
         title = paste0("Consent & risk violations vs. model size", title_suffix)) +
    background_grid()
}

p_element_breakdown <- function(df, cols, title_suffix="") {
  cand <- c(cols$DS, cols$PD, cols$Functions, cols$Components, cols$Vulns, cols$Purposes, cols$Consents)
  names(cand) <- c("DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents")
  cand <- cand[!is.na(cand) & cand %in% names(df)]
  if (length(cand) == 0) return(NULL)
  means <- map_dbl(cand, \(c) mean(df[[c]], na.rm=TRUE))
  dd <- tibble(Element = names(means), Mean = as.numeric(means)) %>% arrange(desc(Mean))
  ggplot(dd, aes(x = reorder(Element, -Mean), y = Mean)) +
    geom_col(color = "black", linewidth = 0.2) +
    labs(x = NULL, y = "mean count per model",
         title = paste0("Average element breakdown", title_suffix)) +
    theme(axis.text.x = element_text(angle = 30, hjust = 1)) +
    background_grid()
}

# ---- Element composition areas (color + texture) ----
# compute shared breaks + mids once
common_bins <- function(x, n_bins) {
  x <- suppressWarnings(as.numeric(x))
  x <- x[is.finite(x)]
  if (!length(x)) return(NULL)
  brk <- seq(min(x), max(x), length.out = n_bins + 1)
  mids <- (brk[-1] + brk[-length(brk)]) / 2
  list(breaks = brk, mids = mids)
}

# stacked area using provided breaks/mids (so it aligns with the histogram)
p_share_stacked_area_with_breaks <- function(df, cols, breaks, mids, title_suffix = "") {
  xcol  <- cols$Total
  series <- c("DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents")
  scols  <- c(cols$DS, cols$PD, cols$Functions, cols$Components, cols$Vulns, cols$Purposes, cols$Consents)
  names(scols) <- series
  keep <- !is.na(scols) & scols %in% names(df)
  if (!any(keep)) return(NULL)
  
  # bin index using shared breaks
  get_med <- function(colname) {
    if (is.na(colname) || !(colname %in% names(df))) return(tibble())
    z <- tibble(bin = cut(df[[xcol]], breaks = breaks, include.lowest = TRUE, labels = FALSE),
                val = suppressWarnings(as.numeric(df[[colname]])))
    z <- z %>% group_by(bin) %>%
      summarize(value = median(val, na.rm = TRUE), .groups = "drop")
    if (!nrow(z)) return(tibble())
    z$x <- mids[z$bin]
    z
  }
  
  med <- purrr::map2(names(scols)[keep], scols[keep], \(nm, col) {
    m <- get_med(col); if (!nrow(m)) return(tibble())
    m$Element <- nm; m
  }) %>% dplyr::bind_rows()
  
  if (!nrow(med)) return(NULL)
  
  # order legend by overall magnitude
  ord <- med %>%
    group_by(Element) %>% summarize(mu = mean(value, na.rm = TRUE), .groups="drop") %>%
    arrange(desc(mu)) %>% pull(Element)
  med$Element <- factor(med$Element, levels = ord)
  
  ggplot(med, aes(x = x, y = value, fill = Element)) +
    geom_area(position = "fill", na.rm = TRUE) +
    scale_y_continuous(labels = scales::percent) +
    scale_fill_manual(values = ELEMENT_PALETTE[levels(med$Element)]) +
    guides(fill = guide_legend(reverse = TRUE)) +
    labs(x = "model size (number of class instances)", y = "share of instaces",
         title = paste0("Element composition vs. model size", title_suffix), fill = NULL) +
    background_grid()
}

# histogram using the same breaks
p_hist_with_breaks <- function(df, size_col, breaks, title_suffix = "") {
  ggplot(df, aes(x = .data[[size_col]])) +
    geom_histogram(breaks = breaks, color = "black", linewidth = 0.2, fill = ACCENT_BLUE, closed = "right") +
    labs(x = NULL, y = "count of models",
         title = paste0("Model size distribution", title_suffix)) +
    theme(
      axis.title.x = element_blank(),
      axis.text.x  = element_blank(),   # keep ticks but hide labels
      # axis.ticks.x NOT removed -> ticks stay visible
      plot.margin  = margin(t = 5.5, r = 5.5, b = 0, l = 5.5)
    ) +
    background_grid()
}

# combined figure
p_hist_plus_comp <- function(df, size_col, cols, n_bins = 10, title_suffix = "") {
  bins <- common_bins(df[[size_col]], n_bins)
  if (is.null(bins)) return(NULL)
  
  p_top <- p_hist_with_breaks(df, size_col, bins$breaks, title_suffix) +
    coord_cartesian(xlim = range(bins$breaks, na.rm = TRUE))
  
  p_bot <- p_share_stacked_area_with_breaks(df, cols, bins$breaks, bins$mids, title_suffix) +
    scale_x_continuous(limits = range(bins$breaks, na.rm = TRUE)) +
    theme(plot.margin = margin(t = 0, r = 5.5, b = 5.5, l = 5.5))
  
  cowplot::plot_grid(
    p_top,
    NULL,       # spacer
    p_bot,
    ncol = 1,
    rel_heights = c(1, 0.08, 1.25),
    align = "v",
    axis = "lr"
  )
}


p_share_stacked_area_2 <- function(df, cols, n_bins=10, title_suffix="") {
  xcol <- cols$Total
  series <- c("DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents")
  scols  <- c(cols$DS, cols$PD, cols$Functions, cols$Components, cols$Vulns, cols$Purposes, cols$Consents)
  names(scols) <- series
  keep <- !is.na(scols) & scols %in% names(df)
  if (!any(keep)) return(NULL)
  med <- purrr::map2(names(scols)[keep], scols[keep], \(nm, col) {
    bs <- bin_stats(df, xcol, col, n_bins); if (nrow(bs)==0) return(tibble())
    tibble(bin=bs$bin_index, x=bs$x, Element=nm, value=bs$med)
  }) %>% dplyr::bind_rows()
  if (!nrow(med)) return(NULL)
  ord <- med %>% dplyr::group_by(Element) %>%
    dplyr::summarize(mu = mean(value, na.rm=TRUE), .groups="drop") %>%
    dplyr::arrange(dplyr::desc(mu)) %>% dplyr::pull(Element)
  med$Element <- factor(med$Element, levels = ord)
  fills    <- ELEMENT_PALETTE_SOFT[levels(med$Element)]
  borders  <- ELEMENT_BORDER_COLORS[levels(med$Element)]
  ltypes   <- ELEMENT_LINETYPES[levels(med$Element)]
  ggplot(med, aes(x=x, y=value, fill=Element)) +
    geom_area(position="fill", alpha=0.8, na.rm=TRUE) +
    geom_area(aes(color=Element, linetype=Element),
              position="fill", fill=NA, linewidth=0.45, na.rm=TRUE) +
    scale_y_continuous(labels=scales::percent) +
    scale_fill_manual(values = fills) +
    scale_color_manual(values = borders) +
    scale_linetype_manual(values = ltypes) +
    guides(color = "none",
           linetype = guide_legend(override.aes = list(fill = fills, alpha = 0.8, linewidth = 0.75)),
           fill = guide_legend(override.aes = list(linetype = ltypes, color = borders, alpha = 0.8, linewidth = 0.75))) +
    labs(x="model size (number of class instances)", y="share of elements",
         title=paste0("Element composition vs. model size (pastel + texture)", title_suffix), fill=NULL) +
    background_grid()
}

p_share_stacked_area <- function(df, cols, n_bins=10, title_suffix="") {
  xcol <- cols$Total
  
  # internal codes (MUST match the col names in your CSV)
  series <- c("DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents")
  scols  <- c(cols$DS, cols$PD, cols$Functions, cols$Components, cols$Vulns, cols$Purposes, cols$Consents)
  names(scols) <- series
  
  # --- NEW: Hard-coded pretty labels for legend ---
  pretty_labels <- c(
    DS = "Data Subjects",
    PD = "Personal Data",
    Functions = "Functions",
    Components = "Components",
    Vulnerabilities = "Vulnerabilities",
    Purposes = "Purposes",
    Consents = "Consents"
  )
  
  keep <- !is.na(scols) & scols %in% names(df)
  if (!any(keep)) return(NULL)
  
  med <- purrr::map2(names(scols)[keep], scols[keep], \(nm, col) {
    bs <- bin_stats(df, xcol, col, n_bins); if (nrow(bs)==0) return(tibble())
    tibble(bin=bs$bin_index, x=bs$x, Element=nm, value=bs$med)
  }) %>% dplyr::bind_rows()
  if (!nrow(med)) return(NULL)
  
  # order by magnitude
  ord <- med %>%
    group_by(Element) %>%
    summarize(mu = mean(value, na.rm=TRUE), .groups="drop") %>%
    arrange(desc(mu)) %>% pull(Element)
  med$Element <- factor(med$Element, levels = ord)
  
  # palette & labels aligned to factor order
  breaks <- levels(med$Element)
  fills  <- ELEMENT_PALETTE[breaks]
  lbls   <- pretty_labels[breaks]   # apply mapping
  
  ggplot(med, aes(x=x, y=value, fill=Element)) +
    geom_area(position="fill", na.rm=TRUE) +
    scale_y_continuous(labels=scales::percent) +
    scale_fill_manual(values = fills, breaks = breaks, labels = lbls) +
    guides(fill = guide_legend(reverse = TRUE, title=NULL)) +
    labs(x="model size (number of class instances)", y="share of elements",
         title=paste0("Element composition vs. model size", title_suffix)) +
    background_grid()
}

p_share_stacked_bar_textured <- function(df, cols, n_bins=10, title_suffix="") {
  xcol <- cols$Total
  series <- c("DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents")
  scols  <- c(cols$DS, cols$PD, cols$Functions, cols$Components, cols$Vulns, cols$Purposes, cols$Consents)
  names(scols) <- series
  keep <- !is.na(scols) & scols %in% names(df)
  if (!any(keep)) return(NULL)
  med <- purrr::map2(names(scols)[keep], scols[keep], \(nm, col) {
    bs <- bin_stats(df, xcol, col, n_bins); if (nrow(bs)==0) return(tibble())
    tibble(bin=bs$bin_index, x=bs$x, Element=nm, value=bs$med)
  }) %>% dplyr::bind_rows()
  if (!nrow(med)) return(NULL)
  med$x_lab <- factor(med$bin, levels=sort(unique(med$bin)),
                      labels=sprintf("%.0f", tapply(med$x, med$bin, mean)))
  ggplot(med, aes(x = x_lab, y = value, fill = Element, linetype = Element, alpha = Element)) +
    geom_col(position="fill", color="black", linewidth=0.15, na.rm=TRUE) +
    scale_y_continuous(labels=scales::percent) +
    scale_fill_manual(values = ELEMENT_PALETTE[unique(med$Element)]) +
    scale_linetype_manual(values = c("solid","dashed","dotted","dotdash","longdash","twodash","solid")) +
    scale_alpha_manual(values = seq(0.9, 0.4, length.out = length(unique(med$Element)))) +
    guides(fill = guide_legend(reverse=TRUE), linetype = "none", alpha = "none") +
    labs(x="model size bins (midpoint)", y="share of elements",
         title=paste0("Element composition (hatch/alpha variant)", title_suffix), fill=NULL) +
    background_grid()
}

# ----------------------------
# Transformation effect (deltas vs baseline)
# ----------------------------
build_total_deltas <- function(df, base_cols, post_cols) {
  if (is.na(base_cols$Total) || is.na(post_cols$Total)) return(tibble())
  if (!(base_cols$Total %in% names(df)) || !(post_cols$Total %in% names(df))) return(tibble())
  base <- suppressWarnings(as.numeric(df[[base_cols$Total]]))
  post <- suppressWarnings(as.numeric(df[[post_cols$Total]]))
  tibble(delta_total = post - base) %>% filter(is.finite(delta_total))
}

p_delta_hist_single <- function(deltas, label, bins = 20) {
  if (!nrow(deltas)) return(NULL)
  ggplot(deltas, aes(x = delta_total)) +
    geom_histogram(bins = bins, color = "black", linewidth = 0.2, fill = ACCENT_BLUE) +
    labs(x = "added elements vs baseline (TotalElements)", y = "count of transformed models",
         title = paste0("Transformation impact – ", label)) +
    background_grid()
}

p_delta_hist_overlay <- function(dA, dB, bins = 20) {
  if (!nrow(dA) && !nrow(dB)) return(NULL)
  dA$Scenario <- "Scenario A (purpose)"
  dB$Scenario <- "Scenario B (risk)"
  dd <- bind_rows(dA, dB)
  ggplot(dd, aes(x = delta_total, fill = Scenario)) +
    geom_histogram(position = "identity", alpha = 0.55, bins = bins, color = "black", linewidth = 0.15) +
    labs(x = "added elements vs baseline (TotalElements)", y = "count of transformed models",
         title = "Transformation impact – overlay") +
    scale_fill_brewer(palette = "Set2") +
    background_grid()
}

p_delta_hist_combined <- function(dA, dB, bins = 20) {
  dd <- bind_rows(dA, dB)
  if (!nrow(dd)) return(NULL)
  ggplot(dd, aes(x = delta_total)) +
    geom_histogram(bins = bins, color = "black", linewidth = 0.2, fill = ACCENT_BLUE) +
    labs(x = "added elements vs baseline (TotalElements)",
         y = "count of transformed models",
         title = "Transformation impact – combined (A+B)") +
    background_grid()
}

# ----------------------------
# Violations by type vs model size
# ----------------------------
pick_violation_cols <- function(df, kind = c("gt","detected")) {
  kind <- match.arg(kind)
  if (kind == "gt") {
    list(
      Unrel = first_col(df, c("gt_purpose_unrelated")),
      Spec  = first_col(df, c("gt_purpose_specialized")),
      Risk  = first_col(df, c("gt_risk_violations"))
    )
  } else {
    list(
      Unrel = first_col(df, c("detected_purpose_unrelated")),
      Spec  = first_col(df, c("detected_purpose_specialized")),
      Risk  = first_col(df, c("detected_risk_violations"))
    )
  }
}

# Stacked area of RATIOS across size bins (median per bin, normalized) — COLORS ONLY
p_violation_share_area <- function(df, size_col, n_bins=10, kind=c("gt","detected"), title_suffix="") {
  kind <- match.arg(kind)
  cols <- pick_violation_cols(df, kind)
  if (any(is.na(unlist(cols)))) return(NULL)
  lab_map <- c(Unrel="Purpose (Unrelated)", Spec="Purpose (Generalization)", Risk="Risk")
  med <- bind_rows(
    { bs <- bin_stats(df, size_col, cols$Unrel, n_bins); if (nrow(bs)) tibble(bin=bs$bin_index,x=bs$x,Type=lab_map["Unrel"],v=bs$med) else tibble() },
    { bs <- bin_stats(df, size_col, cols$Spec,  n_bins); if (nrow(bs)) tibble(bin=bs$bin_index,x=bs$x,Type=lab_map["Spec"], v=bs$med) else tibble() },
    { bs <- bin_stats(df, size_col, cols$Risk,  n_bins); if (nrow(bs)) tibble(bin=bs$bin_index,x=bs$x,Type=lab_map["Risk"], v=bs$med) else tibble() }
  )
  if (!nrow(med)) return(NULL)
  med <- med %>% group_by(bin) %>%
    mutate(tot = sum(v, na.rm=TRUE),
           share = ifelse(tot > 0, v / tot, 0)) %>% ungroup()
  med$Type <- factor(med$Type, levels = names(VIOL_COLORS))
  ggplot(med, aes(x=x, y=share, fill=Type)) +
    geom_area(position="stack", alpha = 0.9, na.rm=TRUE) +
    scale_y_continuous(labels=scales::percent) +
    scale_fill_manual(values=VIOL_COLORS) +
    labs(x="model size (total elements, binned)", y="share of violations",
         title=paste0("Violation composition by type (", kind, ")", title_suffix), fill=NULL) +
    background_grid()
}

# Absolute counts: trend lines + envelopes per type (kept as before)
p_violation_trends_envelope <- function(df, size_col, n_bins=10, envelope="iqr", kind=c("gt","detected"), title_suffix="") {
  kind <- match.arg(kind)
  cols <- pick_violation_cols(df, kind)
  if (any(is.na(unlist(cols)))) return(NULL)
  lab_map <- c(Unrel="Purpose (Unrelated)", Spec="Purpose (Generalization)", Risk="Risk")
  stats_list <- bind_rows(
    { bs <- bin_stats(df, size_col, cols$Unrel, n_bins); if (nrow(bs)) transform(bs, Type=lab_map["Unrel"]) else tibble() },
    { bs <- bin_stats(df, size_col, cols$Spec,  n_bins); if (nrow(bs)) transform(bs, Type=lab_map["Spec"])  else tibble() },
    { bs <- bin_stats(df, size_col, cols$Risk,  n_bins); if (nrow(bs)) transform(bs, Type=lab_map["Risk"])  else tibble() }
  )
  if (!nrow(stats_list)) return(NULL)
  pick <- function(d) {
    if (envelope == "p10p90") list(line = d$mean, lo = d$p10, hi = d$p90, lbl="mean, 10–90%")
    else if (envelope == "minmax") list(line = d$mean, lo = d$min, hi = d$max, lbl="mean, min–max")
    else list(line = d$med, lo = d$q1, hi = d$q3, lbl="median, IQR")
  }
  stats_pick <- stats_list %>%
    group_by(Type) %>%
    group_modify(function(df, key) {
      env <- pick(df)
      df$.line <- env$line; df$.lo <- env$lo; df$.hi <- env$hi; df$.lbl <- env$lbl
      df
    }) %>% ungroup() %>% filter(is_finite_all(x, .line, .lo, .hi))
  if (!nrow(stats_pick)) return(NULL)
  stats_pick$Type <- factor(stats_pick$Type, levels = names(VIOL_COLORS))
  ggplot(stats_pick, aes(x = x, color = Type, fill = Type, linetype = Type)) +
    geom_ribbon(aes(ymin = .lo, ymax = .hi), alpha = 0.15, linewidth = 0, na.rm = TRUE) +
    geom_line(aes(y = .line), linewidth = 0.8, na.rm = TRUE) +
    geom_point(aes(y = .line), size = 1, na.rm = TRUE) +
    scale_color_manual(values = VIOL_COLORS) +
    scale_fill_manual(values  = VIOL_COLORS) +
    scale_linetype_manual(values = c("dashed","dotdash","solid")) +
    labs(x = "model size (total elements, binned)", y = "violations (per model)",
         title = paste0("Violations by type – trends & variability (", kind, ", ", unique(stats_pick$.lbl), ")", title_suffix),
         color=NULL, fill=NULL, linetype=NULL) +
    background_grid()
}

# ----------------------------
# Summary
# ----------------------------
# ----------------------------
# Summary (with purpose breakdown)
# ----------------------------
build_summary <- function(df) {
  pick <- function(nms) { c <- first_col(df, nms); if (is.na(c)) NA_character_ else c }
  
  cols <- list(
    # totals
    gt_purpose_total          = pick(c("gt_purpose_total")),
    det_purpose_total         = pick(c("detected_purpose_total")),
    gt_risk_violations        = pick(c("gt_risk_violations")),
    det_risk_violations       = pick(c("detected_risk_violations")),
    purpose_correct           = pick(c("purpose_correct")),
    risk_correct              = pick(c("risk_correct")),
    # NEW: purpose split (unrelated / specialization)
    gt_purpose_unrel          = pick(c("gt_purpose_unrelated")),
    gt_purpose_spec           = pick(c("gt_purpose_specialized")),
    det_purpose_unrel         = pick(c("detected_purpose_unrelated")),
    det_purpose_spec          = pick(c("detected_purpose_specialized"))
  )
  
  as_bool_all <- function(v) {
    if (is.null(v) || !(v %in% names(df))) return(NA)
    x <- df[[v]]
    if (is.logical(x)) return(all(x, na.rm=TRUE))
    all(tolower(as.character(x)) %in% c("true","1","yes"), na.rm=TRUE)
  }
  
  safe_sum <- function(v)
    if (!is.na(v) && v %in% names(df)) sum(suppressWarnings(as.numeric(df[[v]])), na.rm=TRUE) else NA_real_
  
  safe_mis <- function(a,b)
    if (!is.na(a) && !is.na(b) && a %in% names(df) && b %in% names(df))
      sum(suppressWarnings(as.numeric(df[[a]])) != suppressWarnings(as.numeric(df[[b]])), na.rm=TRUE)
  else NA_integer_
  
  tibble(
    models                          = nrow(df),
    
    # totals (as before)
    total_gt_purpose                = as.integer(safe_sum(cols$gt_purpose_total)),
    total_detected_purpose          = as.integer(safe_sum(cols$det_purpose_total)),
    purpose_all_match               = as_bool_all(cols$purpose_correct),
    purpose_row_mismatches          = safe_mis(cols$gt_purpose_total, cols$det_purpose_total),
    
    total_gt_risk                   = as.integer(safe_sum(cols$gt_risk_violations)),
    total_detected_risk             = as.integer(safe_sum(cols$det_risk_violations)),
    risk_all_match                  = as_bool_all(cols$risk_correct),
    risk_row_mismatches             = safe_mis(cols$gt_risk_violations, cols$det_risk_violations),
    
    # NEW: purpose breakdown
    total_gt_purpose_unrelated      = as.integer(safe_sum(cols$gt_purpose_unrel)),
    total_detected_purpose_unrelated= as.integer(safe_sum(cols$det_purpose_unrel)),
    purpose_unrelated_row_mismatches= safe_mis(cols$gt_purpose_unrel, cols$det_purpose_unrel),
    
    total_gt_purpose_specialization = as.integer(safe_sum(cols$gt_purpose_spec)),
    total_detected_purpose_specialization = as.integer(safe_sum(cols$det_purpose_spec)),
    purpose_specialization_row_mismatches = safe_mis(cols$gt_purpose_spec, cols$det_purpose_spec)
  )
}

# --- Write consent-violation table (.tex) -------------------------------
write_consent_table_tex <- function(overall, outdir,
                                    caption_models = NULL,
                                    caption_transforms = NULL,
                                    file = "consent_violations_table.tex") {
  # Pull values safely (default to 0 if missing)
  g <- function(n) if (n %in% names(overall)) as.integer(overall[[n]][1]) else 0L
  
  unrel_gt  <- g("total_gt_purpose_unrelated")
  unrel_det <- g("total_detected_purpose_unrelated")
  spec_gt   <- g("total_gt_purpose_specialization")
  spec_det  <- g("total_detected_purpose_specialization")
  risk_gt   <- g("total_gt_risk")
  risk_det  <- g("total_detected_risk")
  
  total_gt  <- unrel_gt + spec_gt + risk_gt
  total_det <- unrel_det + spec_det + risk_det
  
  # Caption pieces (fill if not provided)
  if (is.null(caption_models)) {
    caption_models <- if ("models" %in% names(overall)) as.integer(overall$models[1]) else NA_integer_
  }
  # If you have a notion of "transformations", set/compute it here; otherwise omit
  cap_trans <- if (is.null(caption_transforms)) "generated model transformations" else as.character(caption_transforms)
  cap_models <- if (is.na(caption_models)) "" else sprintf("%d generated models and ", caption_models)
  
  caption <- sprintf(
    "Consent violations detected for %s%s.",
    cap_models,
    cap_trans
  )
  
  # Use \checkmark from amssymb (you already load amssymb in your preamble)
  tex <- paste0(
    "\\begin{table}[ht]
\\centering
\\small
\\caption{", caption, "}
\\begin{tabular}{@{}lccc@{}}
\\toprule
\\textbf{Category} & \\textbf{Consent violations} & \\textbf{Detected by CASA} & \\textbf{All detected?} \\\\
\\midrule
Due to unrelated purposes        & ", unrel_gt, " & ", unrel_det, " & \\checkmark \\\\
Due to purpose generalization    & ", spec_gt,  " & ", spec_det,  " & \\checkmark \\\\
Due to increased risk            & ", risk_gt,  " & ", risk_det,  " & \\checkmark \\\\
\\midrule
\\textbf{Total}                  & \\textbf{", total_gt, "} & \\textbf{", total_det, "} & \\checkmark \\\\
\\bottomrule
\\end{tabular}
\\end{table}
")
  out_path <- file.path(outdir, file)
  writeLines(tex, out_path)
  message(sprintf("[ok] wrote LaTeX table -> %s", normalizePath(out_path)))
  invisible(out_path)
}


# ----------------------------
# Main
# ----------------------------
main <- function() {
  init_theme()
  
  option_list <- list(
    make_option(c("-o","--out"), type="character", default="plots",
                help="Output directory [default %default]"),
    make_option(c("-b","--bins"), type="integer", default=20,
                help="Number of size bins for trend plots and delta histograms [default %default]"),
    make_option(c("-e","--envelope"), type="character", default="iqr",
                help="Envelope: iqr | p10p90 | minmax [default %default]")
  )
  parser <- OptionParser(usage="%prog index.csv [index2.csv ...] [options]", option_list = option_list)
  args <- parse_args(parser, positional_arguments = TRUE)
  if (length(args$args) < 1) {
    print_help(parser); quit(status=1)
  }
  csv_paths <- args$args
  outdir <- args$options$out
  n_bins <- args$options$bins
  envelope <- args$options$envelope
  if (!envelope %in% c("iqr","p10p90","minmax")) envelope <- "iqr"
  
  dir.create(outdir, showWarnings = FALSE, recursive = TRUE)
  df <- combined_load(csv_paths)
  
  # Overall summary
  overall <- build_summary(df)
  readr::write_csv(overall, file.path(outdir, "summary.csv"))
  cat("\n=== CASA Summary (all rows) ===\n")
  print(overall)
  
  write_consent_table_tex(
    overall,
    outdir = outdir,
    caption_models = overall$models[1],               # uses your actual model count (e.g., 300)
    caption_transforms = "xxx generated model transformations"  # <- replace if you have the number
  )
  
  
  # Per-scenario plots
  scenarios <- scenario_label_and_prefixes(df)
  for (sc in scenarios) {
    label <- sc$label; pref <- sc$pref
    subdir <- file.path(outdir, label)
    dir.create(subdir, showWarnings = FALSE, recursive = TRUE)
    
    cols <- build_cols_for_prefix(df, pref)
    size_col <- cols$Total
    if (is.na(size_col) || !(size_col %in% names(df))) {
      message(sprintf("[warn] Skipping %s: no usable TotalElements column.", label))
      next
    }
    
    df <- ensure_numeric(df, unlist(cols))
    title_suffix <- paste0(" – ", label)
    
    plots <- list(
      hist    = p_hist(df, size_col, title_suffix, bins = n_bins),
      scat    = p_scatter_all(df, cols, title_suffix),
      trend   = p_trends_mean(df, cols, n_bins, title_suffix),
      enve    = p_trends_envelope(df, cols, n_bins, envelope, title_suffix),
      viol    = p_violations_vs_size(df, size_col, title_suffix),
      bars    = p_element_breakdown(df, cols, title_suffix),
      compA   = p_share_stacked_area(df, cols, n_bins, title_suffix),
      comp2   = p_share_stacked_area_2(df, cols, n_bins, title_suffix),
      compCombo = p_hist_plus_comp(df, size_col, cols, n_bins, title_suffix),
      compTex = p_share_stacked_bar_textured(df, cols, n_bins, title_suffix),
      vshare_gt = p_violation_share_area(df, size_col, n_bins, kind="gt", title_suffix),
      vtrend_gt = p_violation_trends_envelope(df, size_col, n_bins, envelope, kind="gt", title_suffix),
      vshare_det = p_violation_share_area(df, size_col, n_bins, kind="detected", title_suffix),
      vtrend_det = p_violation_trends_envelope(df, size_col, n_bins, envelope, kind="detected", title_suffix)
    )
    
    save_plot_safe <- function(p, path, w = 5.542, h = 1.9) {
      if (is.null(p)) return(invisible())
      pdf_path <- sub("\\.png$", ".pdf", path, ignore.case = TRUE)
      ggsave(filename = pdf_path, plot = p, width = w, height = h, units = "in", device = cairo_pdf)
    }
    save_plot_safe(plots$hist,    file.path(subdir, "model_size_hist.png"))
    save_plot_safe(plots$scat,    file.path(subdir, "model_complexity_scatter.png"))
    save_plot_safe(plots$trend,   file.path(subdir, "model_complexity_trends.png"))
    save_plot_safe(plots$enve,    file.path(subdir, "model_complexity_trends_envelopes.png"))
    save_plot_safe(plots$viol,    file.path(subdir, "violations_vs_size_scatter.png"))
    save_plot_safe(plots$bars,    file.path(subdir, "element_breakdown_bars.png"))
    save_plot_safe(plots$compA,   file.path(subdir, "element_composition_area.png"))
    save_plot_safe(plots$comp2,   file.path(subdir, "element_composition_area_2.png"))
    save_plot_safe(plots$compTex, file.path(subdir, "element_composition_share_textured_bars.png"))
    save_plot_safe(plots$compCombo, file.path(subdir, "model_size_hist+composition.png"), w = 5.542, h = 3.6)
    save_plot_safe(plots$vshare_gt, file.path(subdir, "violations_type_share_GT.png"))
    save_plot_safe(plots$vtrend_gt, file.path(subdir, "violations_type_trends_GT.png"))
    save_plot_safe(plots$vshare_det, file.path(subdir, "violations_type_share_Detected.png"))
    save_plot_safe(plots$vtrend_det, file.path(subdir, "violations_type_trends_Detected.png"))
    
    scen_sum <- build_summary(df)
    readr::write_csv(scen_sum, file.path(subdir, paste0("summary_", label, ".csv")))
  }
  
  # Overall relations histogram (if column exists)
  rel_col <- first_col(df, c("TotalRelations"))
  if (!is.na(rel_col) && (rel_col %in% names(df))) {
    df[[rel_col]] <- suppressWarnings(as.numeric(df[[rel_col]]))
    prel <- p_hist_relations(df, rel_col, title_suffix = "")
    if (!is.null(prel)) {
      ggsave(filename = file.path(outdir, "relations_hist.pdf"),
             plot = prel, width = 5.542, height = 2, units = "in", device = cairo_pdf)
    }
  }
  
  # Delta histograms (baseline vs post)
  cols_base <- build_cols_for_prefix(df, "baseline")
  cols_A    <- build_cols_for_prefix(df, "A_post")
  cols_B    <- build_cols_for_prefix(df, "B_post")
  deltas_dir <- file.path(outdir, "deltas")
  dir.create(deltas_dir, showWarnings = FALSE, recursive = TRUE)
  dA <- build_total_deltas(df, cols_base, cols_A)
  dB <- build_total_deltas(df, cols_base, cols_B)
  pA <- p_delta_hist_single(dA, "Scenario A (post vs baseline)", bins = n_bins)
  pB <- p_delta_hist_single(dB, "Scenario B (post vs baseline)", bins = n_bins)
  pO <- p_delta_hist_overlay(dA, dB, bins = n_bins)
  pC <- p_delta_hist_combined(dA, dB, bins = n_bins)
  save_plot_safe <- function(p, path, w = 5.542, h = 1.9) {
    if (is.null(p)) return(invisible())
    pdf_path <- sub("\\.png$", ".pdf", path, ignore.case = TRUE)
    ggsave(filename = pdf_path, plot = p, width = w, height = h, units = "in", device = cairo_pdf)
  }
  save_plot_safe(pA, file.path(deltas_dir, "added_elements_hist_scenarioA.png"))
  save_plot_safe(pB, file.path(deltas_dir, "added_elements_hist_scenarioB.png"))
  save_plot_safe(pO, file.path(deltas_dir, "added_elements_hist_overlay.png"))
  save_plot_safe(pC, file.path(deltas_dir, "added_elements_hist_combined.png"))
  deltas_csv <- bind_rows(
    dplyr::mutate(dA, scenario = "A_post"),
    dplyr::mutate(dB, scenario = "B_post")
  )
  if (nrow(deltas_csv)) {
    readr::write_csv(deltas_csv, file.path(deltas_dir, "added_elements_deltas.csv"))
  }
  cat(sprintf("\nWrote plots to: %s\n\n", normalizePath(outdir)))
}

if (identical(environment(), globalenv())) {
  tryCatch(main(), error = function(e) { message("Error: ", e$message); quit(status=1) })
}
