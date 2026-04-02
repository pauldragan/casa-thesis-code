#!/usr/bin/env python3
from __future__ import annotations

import argparse
import csv
import math
from pathlib import Path

import matplotlib as mpl
import matplotlib.pyplot as plt
from matplotlib import font_manager
from matplotlib.ticker import MaxNLocator, MultipleLocator
import numpy as np


FIG_WIDTH_IN = 5.542
FONT_SIZE = 8
HISTOGRAM_TARGET_BINS = 30


FUNCTION_TYPES = [
    "FUploadVideo",
    "FStreamVideo",
    "FRemoveVideo",
    "FComments",
    "FLiveStreamVideo",
    "FP2PStreaming",
    "FRecommendVideos",
    "FServeStandardAds",
    "FServeLocationTargetedAds",
    "FServeBehaviorTargetedAds",
]

COMPONENT_TYPES = [
    "CNginx",
    "CExpressJS",
    "CPostgresql",
    "CAngularSPA",
    "CRedis",
    "CFilesystem",
]

DATASUBJECT_TYPES = [
    "DSUser",
    "DSModerator",
    "DSAdministrator",
]

PERSONALDATA_TYPES = [
    "PDUsername",
    "PDPassword",
    "PDEmail",
    "PDPaymentDetails",
    "PDTrackingCookie",
    "PDStreamingHistory",
    "PDUploadedVideo",
    "PDComment",
    "PDVideoMetadata",
    "PDDeviceType",
    "PDDeviceLocation",
    "PDRequestTimestamp",
]

RELATION_TYPES = ["realizes", "processes", "hasPurpose"]

DATA_SUBJECT_TARGETS = {
    "DSUser": (1, 265),
    "DSModerator": (1, 30),
    "DSAdministrator": (1, 3),
}

FUNCTION_TARGETS = {
    "FUploadVideo": (1, 5),
    "FStreamVideo": (1, 5),
    "FRemoveVideo": (1, 5),
    "FComments": (1, 5),
    "FLiveStreamVideo": (0, 5),
    "FP2PStreaming": (0, 5),
    "FRecommendVideos": (0, 5),
    "FServeStandardAds": (0, 5),
    "FServeLocationTargetedAds": (0, 5),
    "FServeBehaviorTargetedAds": (0, 5),
}

COMPONENT_TARGETS = {
    "CNginx": (1, 20),
    "CExpressJS": (1, 20),
    "CPostgresql": (1, 20),
    "CAngularSPA": (1, 20),
    "CRedis": (1, 20),
    "CFilesystem": (1, 20),
}

PERSONAL_DATA_TARGETS = {
    "PDUsername": (1, 5),
    "PDPassword": (1, 5),
    "PDEmail": (1, 5),
    "PDPaymentDetails": (0, 5),
    "PDTrackingCookie": (0, 5),
    "PDStreamingHistory": (0, 5),
    "PDUploadedVideo": (0, 5),
    "PDComment": (0, 5),
    "PDVideoMetadata": (0, 5),
    "PDDeviceType": (0, 5),
    "PDDeviceLocation": (0, 5),
    "PDRequestTimestamp": (0, 5),
}

RELATION_TARGETS = {
    "realizes/realizedBy": (1, 6),
    "processes/processedBy": (1, 14),
    "hasPurpose/ofFunction": (1, 14),
}

RELATION_MULTIPLICITY_TARGETS = {
    "realizes": (1, 6),
    "processes": (1, 14),
    "hasPurpose": (1, 14),
}

SA_FUNCTION_CHANGE_TARGET = (0, 10)
SA_COMPONENT_CHANGE_TARGET = (0, 6)
SA_FUNCTION_HIST_RANGE = (1, 10)
SA_COMPONENT_HIST_RANGE = (1, 6)


def configure_matplotlib() -> None:
    preferred_serif = [
        "TeX Gyre Pagella",
        "Palatino Linotype",
        "Palatino",
        "Times New Roman",
        "DejaVu Serif",
    ]
    mpl.rcParams.update(
        {
            "figure.figsize": (FIG_WIDTH_IN, FIG_WIDTH_IN * 0.62),
            "figure.dpi": 300,
            "savefig.dpi": 300,
            "font.size": FONT_SIZE,
            "axes.titlesize": FONT_SIZE,
            "axes.labelsize": FONT_SIZE,
            "xtick.labelsize": FONT_SIZE,
            "ytick.labelsize": FONT_SIZE,
            "legend.fontsize": FONT_SIZE,
            "font.family": "serif",
            "font.serif": preferred_serif,
            "pdf.fonttype": 42,
            "ps.fonttype": 42,
            "axes.linewidth": 0.6,
            "grid.linewidth": 0.5,
            "lines.linewidth": 1.0,
        }
    )
    available_fonts = {f.name for f in font_manager.fontManager.ttflist}
    if "TeX Gyre Pagella" not in available_fonts:
        print("[WARN] TeX Gyre Pagella not found. Using serif fallback.")


def read_csv(path: Path) -> list[dict[str, str]]:
    with path.open(newline="", encoding="utf-8") as handle:
        return list(csv.DictReader(handle))


def parse_float_rows(rows: list[dict[str, str]], key: str) -> list[float]:
    return [float(row[key]) for row in rows]


def save_pdf(fig: plt.Figure, outpath: Path) -> None:
    fig.tight_layout()
    fig.savefig(outpath, bbox_inches="tight")
    plt.close(fig)


def cumulative_mean(values: np.ndarray) -> np.ndarray:
    return np.cumsum(values) / np.arange(1, values.shape[0] + 1)


def cumulative_min(values: np.ndarray) -> np.ndarray:
    return np.minimum.accumulate(values)


def cumulative_max(values: np.ndarray) -> np.ndarray:
    return np.maximum.accumulate(values)


def plot_histogram(
    values: np.ndarray,
    xlabel: str,
    outpath: Path,
    target_bins: int = HISTOGRAM_TARGET_BINS,
    integer_width: bool = True,
) -> dict[str, str] | None:
    if values.size == 0:
        return None
    fig = plt.figure(figsize=(FIG_WIDTH_IN, FIG_WIDTH_IN * 0.24))
    ax = fig.add_subplot(1, 1, 1)

    vmin = float(np.min(values))
    vmax = float(np.max(values))
    span = max(vmax - vmin, 1e-9)
    imin = int(np.floor(vmin))
    imax = int(np.ceil(vmax))
    if imin == imax:
        imax = imin + 1
    raw_width = span / max(1, int(target_bins))
    if integer_width:
        bin_width = max(1.0, float(int(round(raw_width))))
    else:
        bin_width = max(1e-6, float(raw_width))
    start = bin_width * np.floor(vmin / bin_width)
    end = bin_width * np.ceil(vmax / bin_width)
    if end <= start:
        end = start + bin_width
    if integer_width and bin_width == 1:
        start_i = int(np.floor(vmin))
        end_i = int(np.ceil(vmax))
        centers = np.arange(start_i, end_i + 1, 1)
        bins = np.arange(start_i - 0.5, end_i + 1.5, 1.0)
        start = float(start_i)
        end = float(end_i)
    else:
        centers = np.arange(start, end + bin_width, bin_width)
        bins = np.concatenate([centers - bin_width / 2.0, [centers[-1] + bin_width / 2.0]])
    ax.hist(values, bins=bins, edgecolor="black", linewidth=0.6, color="#4E79A7")
    if not integer_width:
        pad = bin_width * 0.5
        ax.set_xlim(start - pad, end + pad)
        centers = (bins[:-1] + bins[1:]) / 2.0
        step = max(1, int(math.ceil(len(centers) / 8.0)))
        tick_positions = centers[::step]
        ax.set_xticks(tick_positions)
        ax.set_xticklabels([f"{pos:.2f}" for pos in tick_positions])
    else:
        ax.set_xlim(bins[0], bins[-1])
        centers = (bins[:-1] + bins[1:]) / 2.0
        step = max(1, int(math.ceil(len(centers) / 10.0)))
        tick_positions = centers[::step]
        ax.set_xticks(tick_positions)
        ax.set_xticklabels([str(int(round(pos))) for pos in tick_positions])

    ax.set_xlabel(xlabel)
    ax.set_ylabel("Models")
    ax.grid(True, which="major", axis="y", alpha=0.35)
    save_pdf(fig, outpath)
    return {
        "plot": outpath.name,
        "bin_size": f"{bin_width:.6f}" if not integer_width else str(int(round(bin_width))),
        "num_bins": str(len(bins) - 1),
        "integer_bins": "true" if integer_width else "false",
    }


def series_from_summary_rows(summary_rows: list[dict[str, str]], types: list[str]) -> dict[str, np.ndarray]:
    out: dict[str, np.ndarray] = {}
    for type_name in types:
        key = f"count_{type_name}"
        out[type_name] = np.array([float(row.get(key, "0") or "0") for row in summary_rows], dtype=float)
    return out


def relation_series_from_summary_rows(summary_rows: list[dict[str, str]]) -> dict[str, np.ndarray]:
    return {
        "realizes/realizedBy": np.array([float(row["realizes_avg"]) for row in summary_rows], dtype=float),
        "processes/processedBy": np.array([float(row["processes_avg"]) for row in summary_rows], dtype=float),
        "hasPurpose/ofFunction": np.array([float(row["hasPurpose_avg"]) for row in summary_rows], dtype=float),
    }


def relation_triptych_series_from_summary_rows(
    summary_rows: list[dict[str, str]]
) -> tuple[dict[str, np.ndarray], dict[str, np.ndarray], dict[str, np.ndarray]]:
    avg_series = {
        "realizes/realizedBy": np.array([float(row["realizes_avg"]) for row in summary_rows], dtype=float),
        "processes/processedBy": np.array([float(row["processes_avg"]) for row in summary_rows], dtype=float),
        "hasPurpose/ofFunction": np.array([float(row["hasPurpose_avg"]) for row in summary_rows], dtype=float),
    }
    min_series = {
        "realizes/realizedBy": np.array([float(row["realizes_min"]) for row in summary_rows], dtype=float),
        "processes/processedBy": np.array([float(row["processes_min"]) for row in summary_rows], dtype=float),
        "hasPurpose/ofFunction": np.array([float(row["hasPurpose_min"]) for row in summary_rows], dtype=float),
    }
    max_series = {
        "realizes/realizedBy": np.array([float(row["realizes_max"]) for row in summary_rows], dtype=float),
        "processes/processedBy": np.array([float(row["processes_max"]) for row in summary_rows], dtype=float),
        "hasPurpose/ofFunction": np.array([float(row["hasPurpose_max"]) for row in summary_rows], dtype=float),
    }
    return avg_series, min_series, max_series


def personaldata_per_datasubject_series_from_summary_rows(
    summary_rows: list[dict[str, str]], types: list[str]
) -> dict[str, np.ndarray]:
    ds_total = np.array(
        [
            float(row["count_DSUser"]) + float(row["count_DSModerator"]) + float(row["count_DSAdministrator"])
            for row in summary_rows
        ],
        dtype=float,
    )
    ds_total = np.where(ds_total <= 0.0, np.nan, ds_total)

    out: dict[str, np.ndarray] = {}
    for type_name in types:
        key = f"count_{type_name}"
        counts = np.array([float(row.get(key, "0") or "0") for row in summary_rows], dtype=float)
        out[type_name] = counts / ds_total
    return out


def personaldata_triptych_series_from_summary_rows(
    summary_rows: list[dict[str, str]], types: list[str]
) -> tuple[dict[str, np.ndarray], dict[str, np.ndarray], dict[str, np.ndarray]]:
    avg_series = {}
    min_series = {}
    max_series = {}
    for type_name in types:
        avg_series[type_name] = np.array(
            [float(row.get(f"pd_ds_avg_{type_name}", "0") or "0") for row in summary_rows],
            dtype=float,
        )
        min_series[type_name] = np.array(
            [float(row.get(f"pd_ds_min_{type_name}", "0") or "0") for row in summary_rows],
            dtype=float,
        )
        max_series[type_name] = np.array(
            [float(row.get(f"pd_ds_max_{type_name}", "0") or "0") for row in summary_rows],
            dtype=float,
        )
    return avg_series, min_series, max_series


def plot_grouped_histogram_categories(
    series: dict[str, np.ndarray],
    xlabel: str,
    outpath: Path,
    min_val: int,
    max_val: int,
    bin_width: int = 1,
) -> None:
    if min_val >= max_val:
        max_val = min_val + 1
    bin_width = max(1, int(bin_width))
    start = bin_width * int(np.floor(min_val / bin_width))
    end = bin_width * int(np.ceil(max_val / bin_width))
    if end == start:
        end = start + bin_width
    bins = np.arange(start, end + bin_width, bin_width)
    left = bins[:-1]
    centers = left + (bin_width / 2.0)

    fig = plt.figure(figsize=(FIG_WIDTH_IN, FIG_WIDTH_IN * 0.52))
    ax = fig.add_subplot(1, 1, 1)

    base_colors = list(plt.cm.tab20.colors)
    base_colors += list(plt.cm.tab20b.colors)
    base_colors += list(plt.cm.tab20c.colors)

    n_series = len(series)
    if n_series == 0:
        return
    group_width = 0.82 * bin_width
    bar_width = group_width / n_series
    start_offsets = -0.5 * group_width + 0.5 * bar_width

    for idx, (name, values) in enumerate(series.items()):
        counts, _ = np.histogram(values, bins=bins)
        offsets = start_offsets + idx * bar_width
        ax.bar(
            centers + offsets,
            counts,
            width=bar_width,
            align="center",
            edgecolor="black",
            linewidth=0.6,
            label=name,
            color=base_colors[idx % len(base_colors)],
        )

    ax.set_xlim(bins[0], bins[-1])
    tick_values = np.arange(start, end + 1, bin_width)
    step = max(1, int(math.ceil(len(tick_values) / 12.0)))
    shown_ticks = tick_values[::step]
    ax.set_xticks(shown_ticks)
    ax.set_xticklabels([str(int(v)) for v in shown_ticks])
    ax.set_xlabel(xlabel)
    ax.set_ylabel("Models")
    ax.grid(True, which="major", axis="y", alpha=0.35)

    handles, labels = ax.get_legend_handles_labels()
    n_labels = len(labels)
    ncol = min(4, max(1, n_labels))
    nrows = max(1, int(math.ceil(n_labels / ncol)))
    extra_height = (nrows - 1) * 0.20
    fig.set_size_inches(FIG_WIDTH_IN, FIG_WIDTH_IN * 0.52 + extra_height)
    legend_y = -0.02
    bottom_pad = 0.18
    ax.legend(
        handles,
        labels,
        loc="upper center",
        bbox_to_anchor=(0.5, legend_y),
        bbox_transform=fig.transFigure,
        ncol=ncol,
        frameon=False,
        handlelength=1.4,
        handletextpad=0.5,
        labelspacing=0.3,
        columnspacing=0.8,
    )
    fig.subplots_adjust(bottom=bottom_pad)
    save_pdf(fig, outpath)


def plot_triptych(series: dict[str, np.ndarray], outpath: Path, ylabel: str) -> None:
    idx = np.arange(1, next(iter(series.values())).shape[0] + 1)
    n_labels = len(series)
    ncol = min(4, max(1, n_labels))
    nrows = max(1, int(math.ceil(n_labels / ncol)))
    extra_height = (nrows - 1) * 0.35

    fig, axes = plt.subplots(
        3,
        1,
        sharex=True,
        figsize=(FIG_WIDTH_IN, (FIG_WIDTH_IN * 0.25) * 2.8 + extra_height),
    )

    base_colors = list(plt.cm.tab20.colors)
    base_colors += list(plt.cm.tab20b.colors)
    base_colors += list(plt.cm.tab20c.colors)
    for ax in axes:
        ax.set_prop_cycle(color=base_colors)

    mean_values = {name: cumulative_mean(values) for name, values in series.items()}
    min_values = {name: cumulative_min(values) for name, values in series.items()}
    max_values = {name: cumulative_max(values) for name, values in series.items()}

    def set_axis_range(ax: plt.Axes, values_list: list[np.ndarray]) -> None:
        all_vals = np.concatenate([v[np.isfinite(v)] for v in values_list])
        if all_vals.size == 0:
            return
        vmin = float(np.min(all_vals))
        vmax = float(np.max(all_vals))
        if vmin == vmax:
            pad = 1.0 if vmin == 0 else max(1.0, abs(vmin) * 0.05)
            vmin -= pad
            vmax += pad
        pad = max(1.0, (vmax - vmin) * 0.05)
        imin = int(np.floor(vmin))
        imax = int(np.ceil(vmax))
        if imin == imax:
            imax = imin + 1
        mid = (imin + imax) / 2.0
        ax.set_ylim(vmin - pad, vmax + pad)
        ax.set_yticks([imin, mid, imax])

    for name, values in mean_values.items():
        axes[0].plot(idx, values, label=name)
    axes[0].set_ylabel(f"{ylabel}\n(average)")
    axes[0].grid(True, alpha=0.35)
    set_axis_range(axes[0], list(series.values()))

    for name, values in min_values.items():
        axes[1].plot(idx, values, label=name)
    axes[1].set_ylabel(f"{ylabel}\n(minimum)")
    axes[1].grid(True, alpha=0.35)
    set_axis_range(axes[1], list(min_values.values()))

    for name, values in max_values.items():
        axes[2].plot(idx, values, label=name)
    axes[2].set_ylabel(f"{ylabel}\n(maximum)")
    axes[2].set_xlabel("Generated models")
    axes[2].grid(True, alpha=0.35)
    set_axis_range(axes[2], list(max_values.values()))

    handles, labels = axes[2].get_legend_handles_labels()
    fig.legend(
        handles,
        labels,
        loc="lower center",
        bbox_to_anchor=(0.5, -0.09),
        ncol=ncol,
        frameon=False,
        handlelength=1.4,
        handletextpad=0.5,
        labelspacing=0.3,
        columnspacing=0.8,
    )
    fig.subplots_adjust(bottom=0.23)
    save_pdf(fig, outpath)


def plot_triptych_explicit(
    mean_values: dict[str, np.ndarray],
    min_values: dict[str, np.ndarray],
    max_values: dict[str, np.ndarray],
    outpath: Path,
    ylabel: str,
) -> None:
    idx = np.arange(1, next(iter(mean_values.values())).shape[0] + 1)
    n_labels = len(mean_values)
    ncol = min(4, max(1, n_labels))
    nrows = max(1, int(math.ceil(n_labels / ncol)))
    extra_height = (nrows - 1) * 0.35

    fig, axes = plt.subplots(
        3,
        1,
        sharex=True,
        figsize=(FIG_WIDTH_IN, (FIG_WIDTH_IN * 0.25) * 2.8 + extra_height),
    )

    base_colors = list(plt.cm.tab20.colors)
    base_colors += list(plt.cm.tab20b.colors)
    base_colors += list(plt.cm.tab20c.colors)
    for ax in axes:
        ax.set_prop_cycle(color=base_colors)

    mean_cumulative = {name: cumulative_mean(values) for name, values in mean_values.items()}
    min_cumulative = {name: cumulative_min(values) for name, values in min_values.items()}
    max_cumulative = {name: cumulative_max(values) for name, values in max_values.items()}

    def set_axis_range(ax: plt.Axes, values_list: list[np.ndarray]) -> None:
        arrays = [v[np.isfinite(v)] for v in values_list if np.isfinite(v).any()]
        if not arrays:
            return
        all_vals = np.concatenate(arrays)
        vmin = float(np.min(all_vals))
        vmax = float(np.max(all_vals))
        if vmin == vmax:
            pad = 1.0 if vmin == 0 else max(1.0, abs(vmin) * 0.05)
            vmin -= pad
            vmax += pad
        pad = max(1.0, (vmax - vmin) * 0.05)
        imin = int(np.floor(vmin))
        imax = int(np.ceil(vmax))
        if imin == imax:
            imax = imin + 1
        mid = (imin + imax) / 2.0
        ax.set_ylim(vmin - pad, vmax + pad)
        ax.set_yticks([imin, mid, imax])

    for name, values in mean_cumulative.items():
        axes[0].plot(idx, values, label=name)
    axes[0].set_ylabel(f"{ylabel}\n(average)")
    axes[0].grid(True, alpha=0.35)
    set_axis_range(axes[0], list(mean_cumulative.values()))

    for name, values in min_cumulative.items():
        axes[1].plot(idx, values, label=name)
    axes[1].set_ylabel(f"{ylabel}\n(minimum)")
    axes[1].grid(True, alpha=0.35)
    set_axis_range(axes[1], list(min_cumulative.values()))

    for name, values in max_cumulative.items():
        axes[2].plot(idx, values, label=name)
    axes[2].set_ylabel(f"{ylabel}\n(maximum)")
    axes[2].set_xlabel("Generated models")
    axes[2].grid(True, alpha=0.35)
    set_axis_range(axes[2], list(max_cumulative.values()))

    handles, labels = axes[2].get_legend_handles_labels()
    fig.legend(
        handles,
        labels,
        loc="lower center",
        bbox_to_anchor=(0.5, -0.09),
        ncol=ncol,
        frameon=False,
        handlelength=1.4,
        handletextpad=0.5,
        labelspacing=0.3,
        columnspacing=0.8,
    )
    fig.subplots_adjust(bottom=0.23)
    save_pdf(fig, outpath)


def coverage_counts_from_summary_rows(
    summary_rows: list[dict[str, str]], types: list[str]
) -> dict[str, list[int]]:
    out: dict[str, list[int]] = {}
    for type_name in types:
        key = f"count_{type_name}"
        out[type_name] = [int(float(row.get(key, "0") or "0")) for row in summary_rows]
    return out


def coverage_counts_from_rows(
    rows: list[dict[str, str]], type_key: str, value_key: str
) -> dict[str, list[int]]:
    out: dict[str, list[int]] = {}
    for row in rows:
        out.setdefault(row[type_key], []).append(int(float(row[value_key])))
    return out


def plot_coverage_strip_plot(
    counts_by_type: dict[str, list[int]],
    configured_ranges: dict[str, tuple[int, int]],
    outpath: Path,
    xlabel: str,
) -> None:
    if not counts_by_type:
        return

    row_names = [name for name in configured_ranges.keys() if name in counts_by_type]
    global_min = min(configured_ranges[name][0] for name in row_names)
    global_max = max(configured_ranges[name][1] for name in row_names)
    fig_height = max(2.0, 0.28 * len(row_names) + 0.9)
    fig, ax = plt.subplots(figsize=(FIG_WIDTH_IN, fig_height))

    all_frequencies: list[int] = []
    per_type_freq: dict[str, dict[int, int]] = {}
    for name in row_names:
        freq: dict[int, int] = {}
        for value in counts_by_type.get(name, []):
            freq[value] = freq.get(value, 0) + 1
        per_type_freq[name] = freq
        all_frequencies.extend(freq.values())

    max_freq = max(all_frequencies) if all_frequencies else 1
    norm = mpl.colors.Normalize(vmin=1, vmax=max_freq)
    cmap = mpl.cm.get_cmap("Blues")

    for row_idx, name in enumerate(row_names):
        configured_min, configured_max = configured_ranges[name]
        y = float(row_idx)
        ax.hlines(y, configured_min, configured_max, color="#d0d0d0", linewidth=2.0, zorder=1)
        freq = per_type_freq[name]
        realized_values = sorted(v for v in freq.keys() if configured_min <= v <= configured_max)
        if realized_values:
            colors = [cmap(norm(freq[v])) for v in realized_values]
            ax.scatter(
                realized_values,
                [y] * len(realized_values),
                s=22,
                c=colors,
                edgecolors="black",
                linewidths=0.25,
                zorder=3,
            )
            ax.scatter(
                [realized_values[0], realized_values[-1]],
                [y, y],
                s=28,
                c=[colors[0], colors[-1]],
                edgecolors="black",
                linewidths=0.35,
                zorder=4,
            )

    ax.set_yticks(np.arange(len(row_names)))
    ax.set_yticklabels(row_names)
    ax.set_xlabel(xlabel)
    ax.set_ylabel("Type")
    ax.set_xlim(global_min - 0.5, global_max + 0.5)
    span = global_max - global_min + 1
    if span <= 30:
        ax.set_xticks(np.arange(global_min, global_max + 1, 1))
    else:
        step = 10 if span > 100 else 5
        major_start = int(math.ceil(global_min / step) * step)
        ax.set_xticks(np.arange(major_start, global_max + 1, step))
        ax.xaxis.set_minor_locator(MultipleLocator(1))
        ax.tick_params(axis="x", which="minor", length=2.0)
    ax.grid(True, axis="x", alpha=0.2)

    sm = mpl.cm.ScalarMappable(norm=norm, cmap=cmap)
    sm.set_array([])
    cbar = fig.colorbar(sm, ax=ax, pad=0.02)
    cbar.set_label("Occurrences")

    save_pdf(fig, outpath)


def plot_coverage_strip_subplots(
    counts_by_type: dict[str, list[int]],
    configured_ranges: dict[str, tuple[int, int]],
    outpath: Path,
    xlabel: str,
) -> None:
    if not counts_by_type:
        return

    row_names = [name for name in configured_ranges.keys() if name in counts_by_type]
    if not row_names:
        return

    all_frequencies: list[int] = []
    per_type_freq: dict[str, dict[int, int]] = {}
    for name in row_names:
        freq: dict[int, int] = {}
        for value in counts_by_type.get(name, []):
            freq[value] = freq.get(value, 0) + 1
        per_type_freq[name] = freq
        all_frequencies.extend(freq.values())

    max_freq = max(all_frequencies) if all_frequencies else 1
    norm = mpl.colors.Normalize(vmin=1, vmax=max_freq)
    cmap = mpl.cm.get_cmap("Blues")

    fig_height = max(2.4, 0.95 * len(row_names))
    fig, axes = plt.subplots(len(row_names), 1, figsize=(FIG_WIDTH_IN, fig_height), sharey=False)
    if len(row_names) == 1:
        axes = [axes]

    for ax, name in zip(axes, row_names):
        configured_min, configured_max = configured_ranges[name]
        freq = per_type_freq[name]
        realized_values = sorted(v for v in freq.keys() if configured_min <= v <= configured_max)
        y = 0.0
        ax.hlines(y, configured_min, configured_max, color="#d0d0d0", linewidth=2.0, zorder=1)
        if realized_values:
            colors = [cmap(norm(freq[v])) for v in realized_values]
            ax.scatter(
                realized_values,
                [y] * len(realized_values),
                s=22,
                c=colors,
                edgecolors="black",
                linewidths=0.25,
                zorder=3,
            )
            ax.scatter(
                [realized_values[0], realized_values[-1]],
                [y, y],
                s=28,
                c=[colors[0], colors[-1]],
                edgecolors="black",
                linewidths=0.35,
                zorder=4,
            )
        ax.set_xlim(configured_min - 0.5, configured_max + 0.5)
        span = configured_max - configured_min + 1
        if span <= 30:
            ax.set_xticks(np.arange(configured_min, configured_max + 1, 1))
        else:
            step = 10 if span > 100 else 5
            major_start = int(math.ceil(configured_min / step) * step)
            ax.set_xticks(np.arange(major_start, configured_max + 1, step))
            ax.xaxis.set_minor_locator(MultipleLocator(1))
            ax.tick_params(axis="x", which="minor", length=2.0)
        ax.set_yticks([0])
        ax.set_yticklabels([name])
        ax.set_ylim(-0.6, 0.6)
        ax.grid(True, axis="x", alpha=0.2)

    axes[-1].set_xlabel(xlabel)

    sm = mpl.cm.ScalarMappable(norm=norm, cmap=cmap)
    sm.set_array([])
    cbar = fig.colorbar(sm, ax=axes, pad=0.02)
    cbar.set_label("Occurrences")

    save_pdf(fig, outpath)


def latex_escape(value: str) -> str:
    return (
        value.replace("\\", "\\textbackslash{}")
        .replace("_", "\\_")
        .replace("%", "\\%")
        .replace("&", "\\&")
        .replace("#", "\\#")
    )


def _format_cell(key: str, value: str) -> str:
    if key.startswith("avg_"):
        return f"{float(value):.2f}"
    return value


def format_integer_range(min_value: int, max_value: int) -> str:
    return f"{min_value}--{max_value}"


def compact_missing_values(missing_values: list[int]) -> str:
    if not missing_values:
        return "none"
    ranges: list[str] = []
    start = missing_values[0]
    prev = missing_values[0]
    for value in missing_values[1:]:
        if value == prev + 1:
            prev = value
            continue
        ranges.append(str(start) if start == prev else f"{start}--{prev}")
        start = value
        prev = value
    ranges.append(str(start) if start == prev else f"{start}--{prev}")
    return ", ".join(ranges)


def latex_missing_values_cell(value: str) -> str:
    if value == "none":
        return "\\emph{none}"
    parts = value.split(", ")
    if len(parts) <= 3 and len(value) <= 24:
        return latex_escape(value)
    midpoint = max(1, int(math.ceil(len(parts) / 2.0)))
    first = ", ".join(parts[:midpoint])
    second = ", ".join(parts[midpoint:])
    return (
        "\\begin{tabular}[t]{@{}l@{}}"
        + latex_escape(first)
        + " \\\\ "
        + latex_escape(second)
        + "\\end{tabular}"
    )


def compute_coverage_rows(
    values_by_type: dict[str, list[int]],
    configured_ranges: dict[str, tuple[int, int]],
) -> list[dict[str, str]]:
    rows: list[dict[str, str]] = []
    for name, configured in configured_ranges.items():
        configured_min, configured_max = configured
        target_values = set(range(configured_min, configured_max + 1))
        observed_values = {value for value in values_by_type.get(name, []) if configured_min <= value <= configured_max}
        missing_values = sorted(target_values - observed_values)
        coverage_pct = 100.0 * len(observed_values) / max(1, len(target_values))
        rows.append(
            {
                "class": name,
                "target_range": format_integer_range(configured_min, configured_max),
                "missing_values": compact_missing_values(missing_values),
                "coverage_pct": format_compact_decimal(coverage_pct, decimals=1),
            }
        )
    return rows


def format_compact_decimal(value: float, decimals: int = 1) -> str:
    text = f"{value:.{decimals}f}"
    if "." in text:
        text = text.rstrip("0").rstrip(".")
    return text


def write_coverage_latex_table(
    rows: list[dict[str, str]],
    outpath: Path,
    caption: str,
    label: str,
    emph_classes: bool = False,
    first_column_label: str = "Class",
) -> None:
    with outpath.open("w", encoding="utf-8") as handle:
        handle.write("\\begin{table}[t]\n")
        handle.write("\\centering\n")
        handle.write(f"\\caption{{{caption}}}\n")
        handle.write(f"\\label{{{label}}}\n")
        handle.write("\\begin{tabular}{l c c c}\n")
        handle.write("\\toprule\n")
        handle.write(
            f"\\textbf{{{latex_escape(first_column_label)}}} & \\textbf{{Target range}} & \\textbf{{Missing values}} & \\textbf{{Target range coverage (\\%)}} \\\\\n"
        )
        handle.write("\\midrule\n")
        for row in rows:
            class_name = latex_escape(row["class"])
            if emph_classes:
                class_name = f"\\emph{{{class_name}}}"
            handle.write(
                f"{class_name} & {latex_escape(row['target_range'])} & "
                f"{latex_missing_values_cell(row['missing_values'])} & "
                f"{latex_escape(row['coverage_pct'])} \\\\\n"
            )
        handle.write("\\bottomrule\n")
        handle.write("\\end{tabular}\n")
        handle.write("\\end{table}\n")


def write_text_reference_statistics(input_dir: Path, out_dir: Path, summary_rows: list[dict[str, str]]) -> None:
    rows: list[dict[str, str]] = []

    def add_rows(category: str, values_by_type: dict[str, list[int]], unit: str) -> None:
        for type_name, values in values_by_type.items():
            if not values:
                continue
            arr = np.array(values, dtype=float)
            rows.append(
                {
                    "category": category,
                    "type": type_name,
                    "unit": unit,
                    "avg": f"{float(np.mean(arr)):.4f}",
                    "min": str(int(np.min(arr))),
                    "max": str(int(np.max(arr))),
                }
            )

    add_rows(
        "instances_per_model_datasubject",
        coverage_counts_from_summary_rows(summary_rows, DATASUBJECT_TYPES),
        "per_model",
    )
    add_rows(
        "instances_per_model_function",
        coverage_counts_from_summary_rows(summary_rows, FUNCTION_TYPES),
        "per_model",
    )
    add_rows(
        "instances_per_model_component",
        coverage_counts_from_summary_rows(summary_rows, COMPONENT_TYPES),
        "per_model",
    )

    personaldata_value_rows = read_csv(input_dir / "me_personaldata_per_datasubject_values.csv")
    add_rows(
        "instances_per_datasubject_personaldata",
        coverage_counts_from_rows(personaldata_value_rows, "type", "count"),
        "per_datasubject",
    )

    relation_value_rows = read_csv(input_dir / "me_relation_multiplicities_per_function.csv")
    add_rows(
        "multiplicity_per_owner_relation",
        coverage_counts_from_rows(relation_value_rows, "relation_type", "count"),
        "per_owner",
    )

    out_csv = out_dir / "text_reference_statistics.csv"
    with out_csv.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.DictWriter(handle, fieldnames=["category", "type", "unit", "avg", "min", "max"])
        writer.writeheader()
        writer.writerows(rows)


def write_histogram_metadata(out_dir: Path, rows: list[dict[str, str]]) -> None:
    out_csv = out_dir / "histogram_metadata.csv"
    with out_csv.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.DictWriter(handle, fieldnames=["plot", "bin_size", "num_bins", "integer_bins"])
        writer.writeheader()
        writer.writerows(rows)


def plot_added_removed_histogram_grouped(
    removed: np.ndarray,
    added: np.ndarray,
    xlabel: str,
    outpath: Path,
    ylabel: str = "Self-adaptations",
    min_value: int = 1,
    max_value: int = 5,
    bin_width: int = 1,
    exclude_zeros: bool = False,
    label_added: str = "Added",
    label_removed: str = "Removed",
) -> None:
    if exclude_zeros:
        removed = removed[removed > 0]
        added = added[added > 0]

    if removed.size == 0 and added.size == 0:
        return

    bin_width = max(1, int(bin_width))
    start = bin_width * int(np.floor(min_value / bin_width))
    if exclude_zeros and start <= 0:
        start = bin_width
    end = bin_width * int(np.ceil(max_value / bin_width))
    if end <= start:
        end = start + bin_width
    bins = np.arange(start, end + bin_width, bin_width, dtype=float)
    filtered_removed = removed[(removed >= bins[0]) & (removed < bins[-1])]
    filtered_added = added[(added >= bins[0]) & (added < bins[-1])]
    left = bins[:-1]
    width = np.diff(bins)
    centers = left + (bin_width / 2.0)

    added_counts, _ = np.histogram(filtered_added, bins=bins)
    removed_counts, _ = np.histogram(filtered_removed, bins=bins)

    fig = plt.figure(figsize=(FIG_WIDTH_IN, FIG_WIDTH_IN * 0.24))
    ax = fig.add_subplot(1, 1, 1)

    group_width = 0.82 * bin_width
    bar_width = group_width / 2.0
    offsets = np.array([-0.5 * bar_width, 0.5 * bar_width])

    ax.bar(
        centers + offsets[0],
        added_counts,
        width=bar_width,
        align="center",
        edgecolor="black",
        linewidth=0.6,
        color="#4E79A7",
        label=label_added,
    )
    ax.bar(
        centers + offsets[1],
        removed_counts,
        width=bar_width,
        align="center",
        edgecolor="black",
        linewidth=0.6,
        color="#F28E2B",
        label=label_removed,
    )
    ax.set_ylabel(ylabel)
    ax.set_xlim(bins[0], bins[-1])
    ax.grid(True, which="major", axis="y", alpha=0.35)
    tick_values = left
    tick_positions = centers
    tick_step = max(1, int(math.ceil(len(tick_values) / 12.0)))
    ax.set_xticks(tick_positions[::tick_step])
    ax.set_xticklabels([str(int(value)) for value in tick_values[::tick_step]])
    ax.set_xlabel(xlabel)

    handles, labels = ax.get_legend_handles_labels()
    fig.legend(
        handles,
        labels,
        loc="lower center",
        bbox_to_anchor=(0.5, -0.14),
        ncol=2,
        frameon=False,
        handlelength=1.4,
        handletextpad=0.5,
        columnspacing=0.8,
    )
    fig.subplots_adjust(bottom=0.48)
    save_pdf(fig, outpath)


def summary_key_index(summary_rows: list[dict[str, str]]) -> dict[tuple[str, str], int]:
    return {
        (row["model_index"], row["adaptation_index"]): idx
        for idx, row in enumerate(summary_rows)
    }


def count_series_from_type_rows(
    summary_rows: list[dict[str, str]],
    by_type_rows: list[dict[str, str]],
    ordered_types: list[str] | None = None,
    type_field: str = "type",
) -> dict[str, np.ndarray]:
    key_to_index = summary_key_index(summary_rows)
    inferred_types = ordered_types or sorted({row[type_field] for row in by_type_rows})
    series = {type_name: np.zeros(len(summary_rows), dtype=float) for type_name in inferred_types}
    for row in by_type_rows:
        idx = key_to_index.get((row["model_index"], row["adaptation_index"]))
        type_name = row[type_field]
        if idx is None:
            continue
        series.setdefault(type_name, np.zeros(len(summary_rows), dtype=float))
        series[type_name][idx] += float(row["count"])
    if ordered_types is None:
        return {name: series[name] for name in sorted(series)}
    return {name: series.get(name, np.zeros(len(summary_rows), dtype=float)) for name in ordered_types}


def change_table_rows(
    ordered_types: list[str],
    series: dict[str, np.ndarray],
) -> list[dict[str, str]]:
    rows: list[dict[str, str]] = []
    for type_name in ordered_types:
        values = series.get(type_name, np.zeros(1, dtype=float))
        rows.append(
            {
                "class": type_name,
                "min": str(int(np.min(values))),
                "max": str(int(np.max(values))),
                "avg": f"{np.mean(values):.1f}",
                "total": str(int(np.sum(values))),
            }
        )
    return rows


def violation_table_rows(
    summary_rows: list[dict[str, str]],
    purpose_key: str,
    risk_key: str,
) -> list[dict[str, str]]:
    purpose = np.array(parse_float_rows(summary_rows, purpose_key), dtype=float)
    risk = np.array(parse_float_rows(summary_rows, risk_key), dtype=float)
    return [
        {
            "type": "Incompatible purpose",
            "min": str(int(np.min(purpose))),
            "max": str(int(np.max(purpose))),
            "avg": f"{np.mean(purpose):.1f}",
            "total": str(int(np.sum(purpose))),
        },
        {
            "type": "Increased risk",
            "min": str(int(np.min(risk))),
            "max": str(int(np.max(risk))),
            "avg": f"{np.mean(risk):.1f}",
            "total": str(int(np.sum(risk))),
        },
    ]


def violation_summary_rows(
    summary_rows: list[dict[str, str]],
    purpose_key: str,
    risk_key: str,
) -> list[dict[str, str]]:
    purpose = np.array(parse_float_rows(summary_rows, purpose_key), dtype=float)
    risk = np.array(parse_float_rows(summary_rows, risk_key), dtype=float)
    rows: list[dict[str, str]] = []
    for label, values in [
        ("Incompatible purpose", purpose),
        ("Increased risk", risk),
    ]:
        positive = values[values > 0]
        rows.append(
            {
                "type": label,
                "total": str(int(positive.size)),
                "total_violations": str(int(np.sum(values))),
                "max": "-" if positive.size == 0 else f"{np.max(positive):.1f}",
                "avg": "-" if positive.size == 0 else f"{np.mean(positive):.1f}",
            }
        )
    rows.append(
        {
            "type": "No consent violations",
            "total": str(int(np.sum((purpose <= 0) & (risk <= 0)))),
            "total_violations": "-",
            "max": "-",
            "avg": "-",
        }
    )
    return rows


def write_selfadapt_change_latex_table(
    rows: list[dict[str, str]],
    outpath: Path,
    caption: str,
    label: str,
) -> None:
    with outpath.open("w", encoding="utf-8") as handle:
        handle.write("\\begin{table}[t]\n")
        handle.write("\\centering\n")
        handle.write(f"\\caption{{{caption}}}\n")
        handle.write(f"\\label{{{label}}}\n")
        handle.write("\\begin{tabular}{l c c c c}\n")
        handle.write("\\toprule\n")
        handle.write("\\textbf{Class} & \\textbf{Minimum per} & \\textbf{Maximum per} & \\textbf{Average per} & \\textbf{Total} \\\\\n")
        handle.write(" & \\textbf{self-adaptation} & \\textbf{self-adaptation} & \\textbf{self-adaptation} & \\\\\n")
        handle.write("\\midrule\n")
        for row in rows:
            handle.write(
                f"\\emph{{{latex_escape(row['class'])}}} & {row['min']} & {row['max']} & {row['avg']} & \\num{{{row['total']}}} \\\\\n"
            )
        handle.write("\\bottomrule\n")
        handle.write("\\end{tabular}\n")
        handle.write("\\end{table}\n")


def write_selfadapt_violation_latex_table(
    rows: list[dict[str, str]],
    outpath: Path,
    caption: str,
    label: str,
) -> None:
    with outpath.open("w", encoding="utf-8") as handle:
        handle.write("\\begin{table}[t]\n")
        handle.write("\\centering\n")
        handle.write(f"\\caption{{{caption}}}\n")
        handle.write(f"\\label{{{label}}}\n")
        handle.write("\\begin{tabular}{l c c c c}\n")
        handle.write("\\toprule\n")
        handle.write("\\textbf{Type} & \\textbf{Minimum per} & \\textbf{Maximum per} & \\textbf{Average per} & \\textbf{Total} \\\\\n")
        handle.write(" & \\textbf{self-adaptation} & \\textbf{self-adaptation} & \\textbf{self-adaptation} & \\\\\n")
        handle.write("\\midrule\n")
        for row in rows:
            handle.write(
                f"\\emph{{{latex_escape(row['type'])}}} & {row['min']} & {row['max']} & {row['avg']} & \\num{{{row['total']}}} \\\\\n"
            )
        handle.write("\\bottomrule\n")
        handle.write("\\end{tabular}\n")
        handle.write("\\end{table}\n")


def write_selfadapt_violation_summary_latex_table(
    rows: list[dict[str, str]],
    outpath: Path,
    caption: str,
    label: str,
) -> None:
    with outpath.open("w", encoding="utf-8") as handle:
        handle.write("\\begin{table}[t]\n")
        handle.write("\\centering\n")
        handle.write("\\footnotesize\n")
        handle.write("\\begin{threeparttable}\n")
        handle.write(f"\\caption{{{caption}}}\n")
        handle.write(f"\\label{{{label}}}\n")
        handle.write("\\begin{tabular}{l c c c c}\n")
        handle.write("\\toprule\n")
        handle.write("\\textbf{Type} & \\textbf{Total} & \\textbf{Total} & \\textbf{Maximum\\tnote{\\textdagger}} & \\textbf{Average\\tnote{\\textdagger}} \\\\\n")
        handle.write("\\textbf{} & \\textbf{self-adaptations} & \\textbf{violations} & \\textbf{violations} & \\textbf{violations} \\\\\n")
        handle.write("\\midrule\n")
        for row in rows:
            total_violations_cell = row["total_violations"]
            if total_violations_cell != "-":
                total_violations_cell = f"\\num{{{total_violations_cell}}}"
            handle.write(
                f"{latex_escape(row['type'])} & \\num{{{row['total']}}} & "
                f"{total_violations_cell} & {row['max']} & {row['avg']} \\\\\n"
            )
        handle.write("\\bottomrule\n")
        handle.write("\\end{tabular}\n")
        handle.write("\\begin{tablenotes}\n")
        handle.write("\\item[\\textdagger]{\\footnotesize Computed over self-adaptations with violations of the respective type.}\n")
        handle.write("\\end{tablenotes}\n")
        handle.write("\\end{threeparttable}\n")
        handle.write("\\end{table}\n")


def write_rows_csv(outpath: Path, rows: list[dict[str, str]]) -> None:
    if not rows:
        return
    with outpath.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.DictWriter(handle, fieldnames=list(rows[0].keys()))
        writer.writeheader()
        writer.writerows(rows)


def build_key(row: dict[str, str]) -> tuple[str, str]:
    return (row.get("model_index", ""), row.get("adaptation_index", ""))


def type_change_presence_rows(
    summary_rows: list[dict[str, str]],
    functions_added_rows: list[dict[str, str]],
    functions_removed_rows: list[dict[str, str]],
    components_added_rows: list[dict[str, str]],
    components_removed_rows: list[dict[str, str]],
) -> list[dict[str, str]]:
    total = len(summary_rows)

    def presence_map(rows: list[dict[str, str]]) -> dict[str, set[tuple[str, str]]]:
        by_type: dict[str, set[tuple[str, str]]] = {}
        for row in rows:
            type_name = row.get("type", "")
            if not type_name:
                continue
            by_type.setdefault(type_name, set()).add(build_key(row))
        return by_type

    f_add = presence_map(functions_added_rows)
    f_rem = presence_map(functions_removed_rows)
    c_add = presence_map(components_added_rows)
    c_rem = presence_map(components_removed_rows)

    rows: list[dict[str, str]] = []
    for type_name in FUNCTION_TYPES:
        rows.append(
            {
                "section": "Function",
                "class": type_name,
                "self_adaptations_add": str(len(f_add.get(type_name, set()))),
                "self_adaptations_remove": str(len(f_rem.get(type_name, set()))),
                "share_add_pct": format_compact_decimal(
                    100.0 * len(f_add.get(type_name, set())) / max(1, total),
                    decimals=2,
                ),
                "share_remove_pct": format_compact_decimal(
                    100.0 * len(f_rem.get(type_name, set())) / max(1, total),
                    decimals=2,
                ),
            }
        )
    for type_name in COMPONENT_TYPES:
        rows.append(
            {
                "section": "Component",
                "class": type_name,
                "self_adaptations_add": str(len(c_add.get(type_name, set()))),
                "self_adaptations_remove": str(len(c_rem.get(type_name, set()))),
                "share_add_pct": format_compact_decimal(
                    100.0 * len(c_add.get(type_name, set())) / max(1, total),
                    decimals=2,
                ),
                "share_remove_pct": format_compact_decimal(
                    100.0 * len(c_rem.get(type_name, set())) / max(1, total),
                    decimals=2,
                ),
            }
        )
    return rows


def write_type_change_presence_latex_table(
    rows: list[dict[str, str]],
    outpath: Path,
    caption: str,
    label: str,
) -> None:
    with outpath.open("w", encoding="utf-8") as handle:
        handle.write("\\begin{table}[t]\n")
        handle.write("\\centering\n")
        handle.write("\\footnotesize\n")
        handle.write(f"\\caption{{{caption}}}\n")
        handle.write(f"\\label{{{label}}}\n")
        handle.write("\\begin{tabular}{l c c}\n")
        handle.write("\\toprule\n")
        handle.write("\\textbf{Class} & \\textbf{Added by} & \\textbf{Removed by} \\\\\n")
        handle.write(" & \\textbf{\\#self-adaptations} & \\textbf{\\#self-adaptations} \\\\\n")
        handle.write("\\midrule\n")
        first_component_idx = next((idx for idx, r in enumerate(rows) if r["section"] == "Component"), len(rows))
        for idx, row in enumerate(rows):
            if idx == first_component_idx:
                handle.write("\\midrule\n")
            handle.write(
                f"\\emph{{{latex_escape(row['class'])}}} & "
                f"\\num{{{row['self_adaptations_add']}}} & "
                f"\\num{{{row['self_adaptations_remove']}}} \\\\\n"
            )
        handle.write("\\bottomrule\n")
        handle.write("\\end{tabular}\n")
        handle.write("\\end{table}\n")


def classify_change_state(added: float, removed: float) -> str:
    if added <= 0 and removed <= 0:
        return "no_change"
    if added > 0 and removed <= 0:
        return "add"
    if removed > 0 and added <= 0:
        return "remove"
    return "both"


def function_component_intersection_rows(summary_rows: list[dict[str, str]]) -> tuple[list[dict[str, str]], int]:
    states = ["no_change", "add", "remove"]
    counts: dict[tuple[str, str], int] = {(f, c): 0 for f in states for c in states}
    excluded = 0
    for row in summary_rows:
        f_state = classify_change_state(
            float(row.get("added_functions", "0") or "0"),
            float(row.get("removed_functions", "0") or "0"),
        )
        c_state = classify_change_state(
            float(row.get("added_components", "0") or "0"),
            float(row.get("removed_components", "0") or "0"),
        )
        if f_state == "both" or c_state == "both":
            excluded += 1
            continue
        counts[(f_state, c_state)] += 1
    rows: list[dict[str, str]] = []
    for f_state in states:
        rows.append(
            {
                "function_change": f_state,
                "component_no_change": str(counts[(f_state, "no_change")]),
                "component_add": str(counts[(f_state, "add")]),
                "component_remove": str(counts[(f_state, "remove")]),
                "row_total": str(
                    counts[(f_state, "no_change")]
                    + counts[(f_state, "add")]
                    + counts[(f_state, "remove")]
                ),
            }
        )
    return rows, excluded


def format_state_label(state: str) -> str:
    return {
        "no_change": "No function change",
        "add": "Add function",
        "remove": "Remove function",
    }.get(state, state)


def write_function_component_intersection_latex_table(
    rows: list[dict[str, str]],
    excluded_both: int,
    outpath: Path,
    caption: str,
    label: str,
) -> None:
    with outpath.open("w", encoding="utf-8") as handle:
        handle.write("\\begin{table}[t]\n")
        handle.write("\\centering\n")
        handle.write("\\footnotesize\n")
        handle.write("\\begin{threeparttable}\n")
        handle.write(f"\\caption{{{caption}}}\n")
        handle.write(f"\\label{{{label}}}\n")
        handle.write("\\begin{tabular}{l c c c c}\n")
        handle.write("\\toprule\n")
        handle.write("\\textbf{Function change} & \\textbf{No component change} & \\textbf{Add component} & \\textbf{Remove component} & \\textbf{Total} \\\\\n")
        handle.write("\\midrule\n")
        for row in rows:
            handle.write(
                f"{latex_escape(format_state_label(row['function_change']))} & "
                f"\\num{{{row['component_no_change']}}} & "
                f"\\num{{{row['component_add']}}} & "
                f"\\num{{{row['component_remove']}}} & "
                f"\\num{{{row['row_total']}}} \\\\\n"
            )
        handle.write("\\bottomrule\n")
        handle.write("\\end{tabular}\n")
        if excluded_both > 0:
            handle.write("\\begin{tablenotes}\n")
            handle.write(
                "\\item[]{\\footnotesize Excluded from the 3\\(\\times\\)3 grid: "
                f"\\num{{{excluded_both}}} self-adaptations with simultaneous add+remove in functions and/or components.}}\n"
            )
            handle.write("\\end{tablenotes}\n")
        handle.write("\\end{threeparttable}\n")
        handle.write("\\end{table}\n")


def write_sa_change_presence_summary(summary_rows: list[dict[str, str]], out_dir: Path) -> None:
    total = len(summary_rows)
    function_added = sum(float(row.get("added_functions", "0") or "0") > 0 for row in summary_rows)
    function_removed = sum(float(row.get("removed_functions", "0") or "0") > 0 for row in summary_rows)
    component_added = sum(float(row.get("added_components", "0") or "0") > 0 for row in summary_rows)
    component_removed = sum(float(row.get("removed_components", "0") or "0") > 0 for row in summary_rows)

    function_changed = sum(float(row.get("changed_functions_total", "0") or "0") > 0 for row in summary_rows)
    component_changed = sum(float(row.get("changed_components_total", "0") or "0") > 0 for row in summary_rows)
    any_changed = sum(float(row.get("changed_instances_total", "0") or "0") > 0 for row in summary_rows)

    function_unchanged = total - function_changed
    component_unchanged = total - component_changed
    any_unchanged = total - any_changed

    def pct(value: int) -> str:
        if total == 0:
            return "0"
        return format_compact_decimal(100.0 * value / total, decimals=2)

    rows = [
        {"metric": "adds_functions", "self_adaptations": str(function_added), "share_pct": pct(function_added)},
        {"metric": "removes_functions", "self_adaptations": str(function_removed), "share_pct": pct(function_removed)},
        {"metric": "changes_functions", "self_adaptations": str(function_changed), "share_pct": pct(function_changed)},
        {"metric": "unchanged_functions", "self_adaptations": str(function_unchanged), "share_pct": pct(function_unchanged)},
        {"metric": "adds_components", "self_adaptations": str(component_added), "share_pct": pct(component_added)},
        {"metric": "removes_components", "self_adaptations": str(component_removed), "share_pct": pct(component_removed)},
        {"metric": "changes_components", "self_adaptations": str(component_changed), "share_pct": pct(component_changed)},
        {"metric": "unchanged_components", "self_adaptations": str(component_unchanged), "share_pct": pct(component_unchanged)},
        {"metric": "changes_any_instances", "self_adaptations": str(any_changed), "share_pct": pct(any_changed)},
        {"metric": "unchanged_any_instances", "self_adaptations": str(any_unchanged), "share_pct": pct(any_unchanged)},
        {"metric": "total_self_adaptations", "self_adaptations": str(total), "share_pct": "100" if total > 0 else "0"},
    ]
    write_rows_csv(out_dir / "sa_change_presence_summary.csv", rows)


def write_sa_change_magnitude_summary(summary_rows: list[dict[str, str]], out_dir: Path) -> None:
    if not summary_rows:
        return

    def series(key: str) -> np.ndarray:
        return np.array([float(row.get(key, "0") or "0") for row in summary_rows], dtype=float)

    def row_for(metric: str, values: np.ndarray) -> dict[str, str]:
        changed_count = int(np.sum(values > 0))
        total = float(np.sum(values))
        return {
            "metric": metric,
            "total_changes": str(int(total)),
            "average_changes_per_self_adaptation": format_compact_decimal(float(np.mean(values)), decimals=4),
            "minimum_changes_per_self_adaptation": str(int(np.min(values))),
            "maximum_changes_per_self_adaptation": str(int(np.max(values))),
            "self_adaptations_with_change": str(changed_count),
            "share_self_adaptations_with_change_pct": format_compact_decimal(
                100.0 * changed_count / max(1, len(summary_rows)),
                decimals=2,
            ),
        }

    rows = [
        row_for("added_functions", series("added_functions")),
        row_for("removed_functions", series("removed_functions")),
        row_for("changed_functions_total", series("changed_functions_total")),
        row_for("added_components", series("added_components")),
        row_for("removed_components", series("removed_components")),
        row_for("changed_components_total", series("changed_components_total")),
        row_for("changed_instances_total", series("changed_instances_total")),
    ]
    write_rows_csv(out_dir / "sa_change_magnitude_summary.csv", rows)


def rsa32_change_type_rows(summary_rows: list[dict[str, str]]) -> list[dict[str, str]]:
    total = len(summary_rows)

    def count(predicate) -> int:
        return sum(1 for row in summary_rows if predicate(row))

    def pct(value: int) -> str:
        if total == 0:
            return "0"
        return format_compact_decimal(100.0 * value / total, decimals=2)

    adds_functions = count(lambda r: float(r.get("added_functions", "0") or "0") > 0)
    removes_functions = count(lambda r: float(r.get("removed_functions", "0") or "0") > 0)
    adds_components = count(lambda r: float(r.get("added_components", "0") or "0") > 0)
    removes_components = count(lambda r: float(r.get("removed_components", "0") or "0") > 0)
    no_function_change = count(
        lambda r: float(r.get("added_functions", "0") or "0") <= 0
        and float(r.get("removed_functions", "0") or "0") <= 0
    )
    no_component_change = count(
        lambda r: float(r.get("added_components", "0") or "0") <= 0
        and float(r.get("removed_components", "0") or "0") <= 0
    )

    return [
        {"change_type": "Adds functions", "self_adaptations": str(adds_functions), "share_pct": pct(adds_functions)},
        {"change_type": "Removes functions", "self_adaptations": str(removes_functions), "share_pct": pct(removes_functions)},
        {"change_type": "Adds components", "self_adaptations": str(adds_components), "share_pct": pct(adds_components)},
        {"change_type": "Removes components", "self_adaptations": str(removes_components), "share_pct": pct(removes_components)},
        {"change_type": "No function change", "self_adaptations": str(no_function_change), "share_pct": pct(no_function_change)},
        {"change_type": "No component change", "self_adaptations": str(no_component_change), "share_pct": pct(no_component_change)},
    ]


def write_rsa32_change_type_latex_table(
    rows: list[dict[str, str]],
    outpath: Path,
    caption: str,
    label: str,
) -> None:
    with outpath.open("w", encoding="utf-8") as handle:
        handle.write("\\begin{table}[t]\n")
        handle.write("\\centering\n")
        handle.write("\\footnotesize\n")
        handle.write(f"\\caption{{{caption}}}\n")
        handle.write(f"\\label{{{label}}}\n")
        handle.write("\\begin{tabular}{l c c}\n")
        handle.write("\\toprule\n")
        handle.write("\\textbf{Change type} & \\textbf{Self-adaptations} & \\textbf{Share (\\%)} \\\\\n")
        handle.write("\\midrule\n")
        for row in rows:
            handle.write(
                f"{latex_escape(row['change_type'])} & "
                f"\\num{{{row['self_adaptations']}}} & "
                f"{latex_escape(row['share_pct'])} \\\\\n"
            )
        handle.write("\\bottomrule\n")
        handle.write("\\end{tabular}\n")
        handle.write("\\end{table}\n")


def render_change_tables(
    out_dir: Path,
    summary_rows: list[dict[str, str]],
    by_type_rows: list[dict[str, str]],
    ordered_types: list[str],
    target_range: tuple[int, int],
    csv_name: str,
    tex_name: str,
    caption: str,
    label: str,
) -> None:
    series = count_series_from_type_rows(summary_rows, by_type_rows, ordered_types)
    values_by_type = {
        type_name: [int(round(v)) for v in series.get(type_name, np.zeros(len(summary_rows), dtype=float)).tolist()]
        for type_name in ordered_types
    }
    ranges = {type_name: target_range for type_name in ordered_types}
    rows = compute_coverage_rows(values_by_type, ranges)
    write_rows_csv(out_dir / csv_name, rows)
    write_coverage_latex_table(
        rows,
        out_dir / tex_name,
        caption,
        label,
        emph_classes=True,
        first_column_label="Class",
    )


def render_sa_outputs(input_dir: Path, out_dir: Path) -> None:
    out_dir.mkdir(parents=True, exist_ok=True)
    summary_rows = read_csv(input_dir / "sa_summary.csv")
    functions_added_rows = read_csv(input_dir / "sa_functions_added_by_type.csv")
    functions_removed_rows = read_csv(input_dir / "sa_functions_removed_by_type.csv")
    components_added_rows = read_csv(input_dir / "sa_components_added_by_type.csv")
    components_removed_rows = read_csv(input_dir / "sa_components_removed_by_type.csv")

    plot_added_removed_histogram_grouped(
        np.array(parse_float_rows(summary_rows, "removed_functions"), dtype=float),
        np.array(parse_float_rows(summary_rows, "added_functions"), dtype=float),
        "Changed Function instances per self-adaptation",
        out_dir / "histogram_transform_instances_functions.pdf",
        min_value=SA_FUNCTION_HIST_RANGE[0],
        max_value=SA_FUNCTION_HIST_RANGE[1],
    )
    plot_added_removed_histogram_grouped(
        np.array(parse_float_rows(summary_rows, "removed_components"), dtype=float),
        np.array(parse_float_rows(summary_rows, "added_components"), dtype=float),
        "Changed Component instances per self-adaptation",
        out_dir / "histogram_transform_instances_components.pdf",
        min_value=SA_COMPONENT_HIST_RANGE[0],
        max_value=SA_COMPONENT_HIST_RANGE[1],
    )
    max_changed_relations = int(
        max(
            np.max(np.array(parse_float_rows(summary_rows, "added_relations"), dtype=float)),
            np.max(np.array(parse_float_rows(summary_rows, "removed_relations"), dtype=float)),
            1.0,
        )
    )
    plot_added_removed_histogram_grouped(
        np.array(parse_float_rows(summary_rows, "removed_relations"), dtype=float),
        np.array(parse_float_rows(summary_rows, "added_relations"), dtype=float),
        "Changed relations per self-adaptation",
        out_dir / "histogram_transform_relations_by_type.pdf",
        min_value=0,
        max_value=max_changed_relations,
        bin_width=10,
        exclude_zeros=True,
    )
    max_violations = int(
        max(
            np.max(np.array(parse_float_rows(summary_rows, "expected_purpose_violations"), dtype=float)),
            np.max(np.array(parse_float_rows(summary_rows, "expected_risk_violations"), dtype=float)),
            1.0,
        )
    )
    plot_added_removed_histogram_grouped(
        np.array(parse_float_rows(summary_rows, "expected_risk_violations"), dtype=float),
        np.array(parse_float_rows(summary_rows, "expected_purpose_violations"), dtype=float),
        "Consent violations introduced per self-adaptation",
        out_dir / "histogram_transform_violations.pdf",
        min_value=1,
        max_value=max_violations,
        bin_width=10,
        exclude_zeros=True,
        label_added="Incompatible purpose",
        label_removed="Increased risk",
    )

    render_change_tables(
        out_dir,
        summary_rows,
        functions_added_rows,
        FUNCTION_TYPES,
        SA_FUNCTION_CHANGE_TARGET,
        "table_selfadapt_functions_added.csv",
        "table_selfadapt_functions_added.tex",
        "Target-range coverage for added \\emph{Function} instances per self-adaptation.",
        "tab:selfadapt:changes:functions:added",
    )
    render_change_tables(
        out_dir,
        summary_rows,
        functions_removed_rows,
        FUNCTION_TYPES,
        SA_FUNCTION_CHANGE_TARGET,
        "table_selfadapt_functions_removed.csv",
        "table_selfadapt_functions_removed.tex",
        "Target-range coverage for removed \\emph{Function} instances per self-adaptation.",
        "tab:selfadapt:changes:functions:removed",
    )
    render_change_tables(
        out_dir,
        summary_rows,
        components_added_rows,
        COMPONENT_TYPES,
        SA_COMPONENT_CHANGE_TARGET,
        "table_selfadapt_components_added.csv",
        "table_selfadapt_components_added.tex",
        "Target-range coverage for added \\emph{Component} instances per self-adaptation.",
        "tab:selfadapt:changes:components:added",
    )
    render_change_tables(
        out_dir,
        summary_rows,
        components_removed_rows,
        COMPONENT_TYPES,
        SA_COMPONENT_CHANGE_TARGET,
        "table_selfadapt_components_removed.csv",
        "table_selfadapt_components_removed.tex",
        "Target-range coverage for removed \\emph{Component} instances per self-adaptation.",
        "tab:selfadapt:changes:components:removed",
    )

    violation_rows = violation_table_rows(summary_rows, "expected_purpose_violations", "expected_risk_violations")
    write_rows_csv(out_dir / "table_selfadapt_violations.csv", violation_rows)
    write_selfadapt_violation_latex_table(
        violation_rows,
        out_dir / "table_selfadapt_violations.tex",
        "Per self-adaptation consent violations.",
        "tab:selfadapt:violations",
    )
    violation_summary = violation_summary_rows(summary_rows, "expected_purpose_violations", "expected_risk_violations")
    write_rows_csv(out_dir / "table_selfadapt_violations_summary.csv", violation_summary)
    write_selfadapt_violation_summary_latex_table(
        violation_summary,
        out_dir / "table_selfadapt_violations_summary.tex",
        "Consent violations per self-adaptation.",
        "tab:selfadapt:violations:summary",
    )
    write_sa_change_presence_summary(summary_rows, out_dir)
    write_sa_change_magnitude_summary(summary_rows, out_dir)
    rsa32_rows = rsa32_change_type_rows(summary_rows)
    write_rows_csv(out_dir / "table_selfadapt_change_types.csv", rsa32_rows)
    write_rsa32_change_type_latex_table(
        rsa32_rows,
        out_dir / "table_selfadapt_change_types.tex",
        "Coverage of self-adaptation change types.",
        "tab:selfadapt:change:types",
    )

    type_presence_rows = type_change_presence_rows(
        summary_rows,
        functions_added_rows,
        functions_removed_rows,
        components_added_rows,
        components_removed_rows,
    )
    write_rows_csv(out_dir / "table_selfadapt_class_add_remove_presence.csv", type_presence_rows)
    write_type_change_presence_latex_table(
        type_presence_rows,
        out_dir / "table_selfadapt_class_add_remove_presence.tex",
        "Self-adaptations adding/removing each \\emph{Function} and \\emph{Component} type.",
        "tab:selfadapt:class:addremove:presence",
    )

    intersection_rows, excluded_both = function_component_intersection_rows(summary_rows)
    write_rows_csv(out_dir / "table_selfadapt_function_component_intersection.csv", intersection_rows)
    write_function_component_intersection_latex_table(
        intersection_rows,
        excluded_both,
        out_dir / "table_selfadapt_function_component_intersection.tex",
        "Self-adaptation counts by function-change and component-change categories.",
        "tab:selfadapt:function:component:intersection",
    )


def render_apply_outputs(input_dir: Path, out_dir: Path) -> None:
    out_dir.mkdir(parents=True, exist_ok=True)
    summary_rows = read_csv(input_dir / "apply_summary.csv")
    functions_added_rows = read_csv(input_dir / "apply_functions_added_by_type.csv")
    functions_removed_rows = read_csv(input_dir / "apply_functions_removed_by_type.csv")
    components_added_rows = read_csv(input_dir / "apply_components_added_by_type.csv")
    components_removed_rows = read_csv(input_dir / "apply_components_removed_by_type.csv")
    relation_rows = read_csv(input_dir / "apply_relations_changed_by_type.csv")

    plot_added_removed_histogram_grouped(
        np.array(parse_float_rows(summary_rows, "removed_functions"), dtype=float),
        np.array(parse_float_rows(summary_rows, "added_functions"), dtype=float),
        "Changed Function instances per applied self-adaptation",
        out_dir / "histogram_transform_instances_functions.pdf",
        bin_width=1,
    )
    plot_added_removed_histogram_grouped(
        np.array(parse_float_rows(summary_rows, "removed_components"), dtype=float),
        np.array(parse_float_rows(summary_rows, "added_components"), dtype=float),
        "Changed Component instances per applied self-adaptation",
        out_dir / "histogram_transform_instances_components.pdf",
        bin_width=1,
    )
    relation_series = count_series_from_type_rows(summary_rows, relation_rows, None, "type")
    if relation_series:
        max_value = int(max(np.max(values) for values in relation_series.values()))
        plot_grouped_histogram_categories(
            relation_series,
            "Changed relations per applied self-adaptation",
            out_dir / "histogram_transform_relations_by_type.pdf",
            0,
            max(1, max_value),
            bin_width=10,
        )

    render_change_tables(
        out_dir,
        summary_rows,
        functions_added_rows,
        FUNCTION_TYPES,
        SA_FUNCTION_CHANGE_TARGET,
        "table_selfadapt_functions_added.csv",
        "table_selfadapt_functions_added.tex",
        "Target-range coverage for added \\emph{Function} instances per applied self-adaptation.",
        "tab:apply:changes:functions:added",
    )
    render_change_tables(
        out_dir,
        summary_rows,
        functions_removed_rows,
        FUNCTION_TYPES,
        SA_FUNCTION_CHANGE_TARGET,
        "table_selfadapt_functions_removed.csv",
        "table_selfadapt_functions_removed.tex",
        "Target-range coverage for removed \\emph{Function} instances per applied self-adaptation.",
        "tab:apply:changes:functions:removed",
    )
    render_change_tables(
        out_dir,
        summary_rows,
        components_added_rows,
        COMPONENT_TYPES,
        SA_COMPONENT_CHANGE_TARGET,
        "table_selfadapt_components_added.csv",
        "table_selfadapt_components_added.tex",
        "Target-range coverage for added \\emph{Component} instances per applied self-adaptation.",
        "tab:apply:changes:components:added",
    )
    render_change_tables(
        out_dir,
        summary_rows,
        components_removed_rows,
        COMPONENT_TYPES,
        SA_COMPONENT_CHANGE_TARGET,
        "table_selfadapt_components_removed.csv",
        "table_selfadapt_components_removed.tex",
        "Target-range coverage for removed \\emph{Component} instances per applied self-adaptation.",
        "tab:apply:changes:components:removed",
    )

    violation_rows = violation_table_rows(summary_rows, "actual_purpose_violations", "actual_identifiable_risk_violations")
    max_violations = int(
        max(
            np.max(np.array(parse_float_rows(summary_rows, "actual_purpose_violations"), dtype=float)),
            np.max(np.array(parse_float_rows(summary_rows, "actual_identifiable_risk_violations"), dtype=float)),
            1.0,
        )
    )
    plot_added_removed_histogram_grouped(
        np.array(parse_float_rows(summary_rows, "actual_identifiable_risk_violations"), dtype=float),
        np.array(parse_float_rows(summary_rows, "actual_purpose_violations"), dtype=float),
        "Consent violations introduced per applied self-adaptation",
        out_dir / "histogram_transform_violations.pdf",
        min_value=1,
        max_value=max_violations,
        bin_width=10,
        exclude_zeros=True,
        label_added="Incompatible purpose",
        label_removed="Increased risk",
    )
    write_rows_csv(out_dir / "table_selfadapt_violations.csv", violation_rows)
    write_selfadapt_violation_latex_table(
        violation_rows,
        out_dir / "table_selfadapt_violations.tex",
        "Per applied self-adaptation consent violations.",
        "tab:apply:violations",
    )
    violation_summary = violation_summary_rows(summary_rows, "actual_purpose_violations", "actual_identifiable_risk_violations")
    write_rows_csv(out_dir / "table_selfadapt_violations_summary.csv", violation_summary)
    write_selfadapt_violation_summary_latex_table(
        violation_summary,
        out_dir / "table_selfadapt_violations_summary.tex",
        "Consent violations per applied self-adaptation.",
        "tab:apply:violations:summary",
    )


def render_me_outputs(input_dir: Path, out_dir: Path) -> None:
    out_dir.mkdir(parents=True, exist_ok=True)
    summary_rows = read_csv(input_dir / "me_summary.csv")
    write_text_reference_statistics(input_dir, out_dir, summary_rows)

    histogram_rows: list[dict[str, str]] = []
    metadata = plot_histogram(
        np.array(parse_float_rows(summary_rows, "total_instances"), dtype=float),
        "Number of class instances per model",
        out_dir / "histogram_instances.pdf",
        target_bins=HISTOGRAM_TARGET_BINS,
        integer_width=True,
    )
    if metadata is not None:
        histogram_rows.append(metadata)
    metadata = plot_histogram(
        np.array(parse_float_rows(summary_rows, "total_relations"), dtype=float),
        "Number of relations per model",
        out_dir / "histogram_relations.pdf",
        target_bins=HISTOGRAM_TARGET_BINS,
        integer_width=True,
    )
    if metadata is not None:
        histogram_rows.append(metadata)
    metadata = plot_histogram(
        np.array(parse_float_rows(summary_rows, "connectivity"), dtype=float),
        "Relations per class instance (per model)",
        out_dir / "histogram_connectivity.pdf",
        target_bins=HISTOGRAM_TARGET_BINS,
        integer_width=False,
    )
    if metadata is not None:
        histogram_rows.append(metadata)
    write_histogram_metadata(out_dir, histogram_rows)

    plot_triptych(
        series_from_summary_rows(summary_rows, FUNCTION_TYPES),
        out_dir / "lines_instances_function_triptych.pdf",
        "Function instances",
    )
    plot_triptych(
        series_from_summary_rows(summary_rows, COMPONENT_TYPES),
        out_dir / "lines_instances_component_triptych.pdf",
        "Component instances",
    )
    plot_triptych(
        series_from_summary_rows(summary_rows, DATASUBJECT_TYPES),
        out_dir / "lines_instances_datasubject_triptych.pdf",
        "DataSubject instances",
    )
    pd_avg_series, pd_min_series, pd_max_series = personaldata_triptych_series_from_summary_rows(
        summary_rows, PERSONALDATA_TYPES
    )
    plot_triptych_explicit(
        pd_avg_series,
        pd_min_series,
        pd_max_series,
        out_dir / "lines_instances_personaldata_triptych.pdf",
        "PersonalData instances\nper DataSubject",
    )
    rel_avg_series, rel_min_series, rel_max_series = relation_triptych_series_from_summary_rows(summary_rows)
    plot_triptych_explicit(
        rel_avg_series,
        rel_min_series,
        rel_max_series,
        out_dir / "lines_relations_triptych.pdf",
        "Count per model",
    )

    plot_coverage_strip_subplots(
        coverage_counts_from_summary_rows(summary_rows, DATASUBJECT_TYPES),
        DATA_SUBJECT_TARGETS,
        out_dir / "coverage_strip_datasubjects.pdf",
        "Instances per model",
    )
    plot_coverage_strip_plot(
        coverage_counts_from_summary_rows(summary_rows, FUNCTION_TYPES),
        FUNCTION_TARGETS,
        out_dir / "coverage_strip_functions.pdf",
        "Instances per model",
    )
    plot_coverage_strip_plot(
        coverage_counts_from_summary_rows(summary_rows, COMPONENT_TYPES),
        COMPONENT_TARGETS,
        out_dir / "coverage_strip_components.pdf",
        "Instances per model",
    )

    personaldata_value_rows = read_csv(input_dir / "me_personaldata_per_datasubject_values.csv")
    plot_coverage_strip_plot(
        coverage_counts_from_rows(personaldata_value_rows, "type", "count"),
        PERSONAL_DATA_TARGETS,
        out_dir / "coverage_strip_personaldata_per_datasubject.pdf",
        "Instances per DataSubject",
    )

    relation_value_rows = read_csv(input_dir / "me_relation_multiplicities_per_function.csv")
    plot_coverage_strip_plot(
        coverage_counts_from_rows(relation_value_rows, "relation_type", "count"),
        RELATION_MULTIPLICITY_TARGETS,
        out_dir / "coverage_strip_relations_per_function.pdf",
        "Relations per Function",
    )

    all_relation_rows = read_csv(input_dir / "me_relations_all_types_by_model.csv")
    all_relation_series: dict[str, list[float]] = {}
    for row in all_relation_rows:
        all_relation_series.setdefault(row["relation_type"], []).append(float(row["count"]))
    if all_relation_series:
        relation_arrays = {key: np.array(values, dtype=float) for key, values in all_relation_series.items()}
        min_val = int(min(np.min(values) for values in relation_arrays.values()))
        max_val = int(max(np.max(values) for values in relation_arrays.values()))
        plot_grouped_histogram_categories(
            relation_arrays,
            "Number of relations per model",
            out_dir / "histogram_relations_all_types.pdf",
            min_val,
            max_val,
        )

    coverage_tables = [
        (
            "table_instances_datasubjects.csv",
            "table_instances_datasubjects.tex",
            "Coverage of configured ranges for \\emph{DataSubject} subclasses across the generated dataset.",
            "tab:dataset:bins:datasubjects",
            compute_coverage_rows(
                coverage_counts_from_summary_rows(summary_rows, DATASUBJECT_TYPES),
                DATA_SUBJECT_TARGETS,
            ),
        ),
        (
            "table_instances_functions.csv",
            "table_instances_functions.tex",
            "Coverage of configured ranges for \\emph{Function} subclasses across the generated dataset.",
            "tab:dataset:bins:functions",
            compute_coverage_rows(
                coverage_counts_from_summary_rows(summary_rows, FUNCTION_TYPES),
                FUNCTION_TARGETS,
            ),
        ),
        (
            "table_instances_components.csv",
            "table_instances_components.tex",
            "Coverage of configured ranges for \\emph{Component} subclasses across the generated dataset.",
            "tab:dataset:bins:components",
            compute_coverage_rows(
                coverage_counts_from_summary_rows(summary_rows, COMPONENT_TYPES),
                COMPONENT_TARGETS,
            ),
        ),
        (
            "table_instances_personaldata.csv",
            "table_instances_personaldata.tex",
            "Coverage of configured ranges for \\emph{PersonalData} subclasses across the generated dataset, evaluated per \\emph{DataSubject}.",
            "tab:dataset:bins:personaldata",
            compute_coverage_rows(
                coverage_counts_from_rows(personaldata_value_rows, "type", "count"),
                PERSONAL_DATA_TARGETS,
            ),
        ),
        (
            "table_relations_types.csv",
            "table_relations_types.tex",
            "Coverage of configured ranges for relation multiplicities per owner instance.",
            "tab:dataset:bins:relations",
            compute_coverage_rows(
                coverage_counts_from_rows(relation_value_rows, "relation_type", "count"),
                RELATION_MULTIPLICITY_TARGETS,
            ),
        ),
    ]

    for csv_name, tex_name, caption, label, rows in coverage_tables:
        with (out_dir / csv_name).open("w", newline="", encoding="utf-8") as handle:
            writer = csv.DictWriter(handle, fieldnames=list(rows[0].keys()))
            writer.writeheader()
            writer.writerows(rows)
        first_column_label = "Relation" if csv_name == "table_relations_types.csv" else "Class"
        write_coverage_latex_table(
            rows,
            out_dir / tex_name,
            caption,
            label,
            emph_classes=True,
            first_column_label=first_column_label,
        )

    passthrough_tables = [
        (
            "table_relations_all_types.csv",
            "table_relations_all_types.tex",
            "Summary statistics for all final managed-element relation types across the generated dataset.",
            "tab:dataset:relations:all",
            [
                ("relation_type", "l", True, "Relation"),
                ("models_with_relation", "c", False, "Models with relation"),
                ("min_count", "c", False, "Minimum"),
                ("avg_count", "c", False, "Average"),
                ("max_count", "c", False, "Maximum"),
            ],
        ),
    ]

    for csv_name, tex_name, caption, label, columns in passthrough_tables:
        rows = read_csv(input_dir / csv_name)
        with (out_dir / csv_name).open("w", newline="", encoding="utf-8") as handle:
            writer = csv.DictWriter(handle, fieldnames=list(rows[0].keys()))
            writer.writeheader()
            writer.writerows(rows)
        # Keep the generic table writer for the non-placeholder summary table.
        with (out_dir / tex_name).open("w", encoding="utf-8") as handle:
            handle.write("\\begin{table}[t]\n")
            handle.write("\\centering\n")
            handle.write(f"\\caption{{{caption}}}\n")
            handle.write(f"\\label{{{label}}}\n")
            handle.write("\\begin{tabular}{" + " ".join(spec for _, spec, _, _ in columns) + "}\n")
            handle.write("\\toprule\n")
            header = " & ".join(f"\\textbf{{{latex_escape(header_label)}}}" for _, _, _, header_label in columns)
            handle.write(header + " \\\\\n")
            handle.write("\\midrule\n")
            for row in rows:
                values = []
                for name, _, emphasize, _ in columns:
                    cell = latex_escape(_format_cell(name, row[name]))
                    if emphasize:
                        cell = f"\\emph{{{cell}}}"
                    values.append(cell)
                handle.write(" & ".join(values) + " \\\\\n")
            handle.write("\\bottomrule\n")
            handle.write("\\end{tabular}\n")
            handle.write("\\end{table}\n")


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="Render v3 dataset-evaluation plots and LaTeX tables.")
    parser.add_argument("--in", dest="input_dir", required=True, help="Directory containing dataset-evaluation CSV files.")
    parser.add_argument("--out", dest="output_dir", required=True, help="Directory where plots and tables should be written.")
    parser.add_argument(
        "--kind",
        choices=["auto", "me", "sa"],
        default="auto",
        help="Dataset-evaluation family to render. Defaults to auto-detection from CSV files.",
    )
    return parser.parse_args()


def main() -> None:
    args = parse_args()
    configure_matplotlib()
    input_dir = Path(args.input_dir)
    output_dir = Path(args.output_dir)
    kind = args.kind
    if kind == "auto":
        if (input_dir / "managed_elements").is_dir() or (input_dir / "self_adaptations").is_dir():
            if (input_dir / "managed_elements").is_dir():
                render_me_outputs(input_dir / "managed_elements", output_dir / "managed_elements")
            if (input_dir / "self_adaptations").is_dir():
                render_sa_outputs(input_dir / "self_adaptations", output_dir / "self_adaptations")
            return
        if (input_dir / "me_summary.csv").exists():
            kind = "me"
        elif (input_dir / "sa_summary.csv").exists():
            kind = "sa"
        else:
            raise SystemExit(f"Could not auto-detect dataset-evaluation kind from {input_dir}")
    if kind == "me":
        render_me_outputs(input_dir, output_dir)
    elif kind == "sa":
        render_sa_outputs(input_dir, output_dir)
    else:
        raise SystemExit(f"Unsupported render kind: {kind}")


if __name__ == "__main__":
    main()
