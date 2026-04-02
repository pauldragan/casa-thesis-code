#!/usr/bin/env python3
from __future__ import annotations

import argparse
import csv
from pathlib import Path

import matplotlib as mpl
import matplotlib.pyplot as plt
from matplotlib import font_manager
import numpy as np


FIG_WIDTH_IN = 5.542
FONT_SIZE = 8
DEFAULT_BINS = 12

CASE_LABELS = {
    "afs_afp": "AFS+AFP (function-focused)",
    "acs_acr": "ACS+ACR (component-focused)",
}

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
            "figure.figsize": (FIG_WIDTH_IN, FIG_WIDTH_IN * 0.95),
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


def read_summary(path: Path) -> list[dict[str, str]]:
    with path.open("r", encoding="utf-8", newline="") as handle:
        return list(csv.DictReader(handle))


def to_float(row: dict[str, str], key: str) -> float:
    raw = row.get(key, "")
    if raw is None or raw == "":
        return 0.0
    return float(raw)


def save_pdf(fig: plt.Figure, outpath: Path) -> None:
    fig.savefig(outpath, bbox_inches="tight")
    plt.close(fig)


def bin_phase_means(
    x: np.ndarray,
    transform: np.ndarray,
    purpose: np.ndarray,
    risk: np.ndarray,
    bins: int,
) -> tuple[np.ndarray, np.ndarray, np.ndarray, np.ndarray]:
    if x.size == 0:
        return np.array([]), np.array([]), np.array([]), np.array([])

    if np.allclose(np.min(x), np.max(x)):
        center = np.array([float(np.min(x))])
        return (
            center,
            np.array([float(np.mean(transform))]),
            np.array([float(np.mean(risk))]),
            np.array([float(np.mean(purpose))]),
        )

    edges = np.linspace(float(np.min(x)), float(np.max(x)), bins + 1)
    mids: list[float] = []
    tvals: list[float] = []
    rvals: list[float] = []
    pvals: list[float] = []

    for i in range(bins):
        lo = edges[i]
        hi = edges[i + 1]
        if i == bins - 1:
            mask = (x >= lo) & (x <= hi)
        else:
            mask = (x >= lo) & (x < hi)
        if not np.any(mask):
            continue
        mids.append((lo + hi) / 2.0)
        tvals.append(float(np.mean(transform[mask])))
        rvals.append(float(np.mean(risk[mask])))
        pvals.append(float(np.mean(purpose[mask])))

    return np.array(mids), np.array(tvals), np.array(rvals), np.array(pvals)


def render_combined_figure(
    rows: list[dict[str, str]],
    size_col: str,
    size_label: str,
    bins: int,
    outpath: Path,
) -> dict[str, str] | None:
    if not rows:
        return None

    x = np.array([to_float(r, size_col) for r in rows], dtype=float)
    y_total = np.array([to_float(r, "total_avg_ms") for r in rows], dtype=float)
    y_transform = np.array([to_float(r, "transform_avg_ms") for r in rows], dtype=float)
    y_purpose = np.array([to_float(r, "purpose_avg_ms") for r in rows], dtype=float)
    y_risk = np.array([to_float(r, "risk_avg_ms") for r in rows], dtype=float)

    fig, (ax_top, ax_bottom) = plt.subplots(
        2, 1, sharex=True, figsize=(FIG_WIDTH_IN, FIG_WIDTH_IN * 0.92), gridspec_kw={"height_ratios": [2.1, 1.6]}
    )

    ax_top.scatter(x, y_total, s=10, color="#A347D1", alpha=0.85, label="Avg total")
    ax_top.set_ylabel("avg exec time per model (ms)")
    ax_top.grid(True, which="major", alpha=0.35)
    ax_top.legend(loc="center left", bbox_to_anchor=(1.01, 0.5), frameon=False, borderaxespad=0.0)

    mids, tvals, rvals, pvals = bin_phase_means(x, y_transform, y_purpose, y_risk, bins=bins)
    if mids.size > 0:
        if mids.size > 1:
            width = float(np.min(np.diff(np.sort(mids))) * 0.92)
        else:
            width = 1.0
        ax_bottom.bar(mids, tvals, width=width, color="#1f77b4", edgecolor="black", linewidth=0.4, label="Transform")
        ax_bottom.bar(
            mids,
            rvals,
            width=width,
            bottom=tvals,
            color="#0f9d76",
            edgecolor="black",
            linewidth=0.4,
            label="Risk-check",
        )
        ax_bottom.bar(
            mids,
            pvals,
            width=width,
            bottom=tvals + rvals,
            color="#d7a106",
            edgecolor="black",
            linewidth=0.4,
            label="Purpose-check",
        )

    ax_bottom.set_ylabel("avg exec time per bin (ms)")
    ax_bottom.set_xlabel(size_label)
    ax_bottom.grid(True, which="major", axis="y", alpha=0.35)
    ax_bottom.legend(loc="center left", bbox_to_anchor=(1.01, 0.5), frameon=False, borderaxespad=0.0)

    ax_top.set_title("Combined scalability benchmark")

    fig.tight_layout()
    save_pdf(fig, outpath)

    return {
        "plot": outpath.name,
        "case_slug": "combined",
        "size_axis": size_col,
        "models": str(len(rows)),
        "bins_used": str(mids.size),
        "bins_requested": str(bins),
        "x_min": f"{float(np.min(x)):.3f}",
        "x_max": f"{float(np.max(x)):.3f}",
        "total_avg_min_ms": f"{float(np.min(y_total)):.6f}",
        "total_avg_max_ms": f"{float(np.max(y_total)):.6f}",
    }


def write_plot_manifest(outpath: Path, rows: list[dict[str, str]]) -> None:
    if not rows:
        return
    with outpath.open("w", encoding="utf-8", newline="") as handle:
        writer = csv.DictWriter(
            handle,
            fieldnames=[
                "plot",
                "case_slug",
                "size_axis",
                "models",
                "bins_used",
                "bins_requested",
                "x_min",
                "x_max",
                "total_avg_min_ms",
                "total_avg_max_ms",
            ],
        )
        writer.writeheader()
        writer.writerows(rows)


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="Render V3 scalability benchmark plots.")
    parser.add_argument("--in", dest="in_dir", required=True, help="Benchmark output folder containing benchmark_summary.csv")
    parser.add_argument("--out", dest="out_dir", required=True, help="Output folder for benchmark plots")
    parser.add_argument("--bins", type=int, default=DEFAULT_BINS, help="Requested number of x-axis bins for lower subplot")
    return parser.parse_args()


def main() -> None:
    args = parse_args()
    in_dir = Path(args.in_dir)
    out_dir = Path(args.out_dir)
    out_dir.mkdir(parents=True, exist_ok=True)

    configure_matplotlib()

    summary_csv = in_dir / "benchmark_summary.csv"
    if not summary_csv.exists():
        raise SystemExit(f"Missing benchmark summary: {summary_csv}")
    rows = read_summary(summary_csv)
    if not rows:
        raise SystemExit(f"Benchmark summary is empty: {summary_csv}")
    rows = [r for r in rows if r.get("case_slug", "") in {"afs_afp", "acs_acr"}]

    manifest_rows: list[dict[str, str]] = []
    rel_plot = out_dir / "scalability_combined_relations.pdf"
    rec = render_combined_figure(
        rows,
        size_col="source_total_relations",
        size_label="model size (number of relations)",
        bins=max(1, int(args.bins)),
        outpath=rel_plot,
    )
    if rec is not None:
        manifest_rows.append(rec)

    inst_plot = out_dir / "scalability_combined_instances.pdf"
    rec = render_combined_figure(
        rows,
        size_col="source_total_instances",
        size_label="model size (number of class instances)",
        bins=max(1, int(args.bins)),
        outpath=inst_plot,
    )
    if rec is not None:
        manifest_rows.append(rec)

    write_plot_manifest(out_dir / "benchmark_plot_manifest.csv", manifest_rows)


if __name__ == "__main__":
    main()
