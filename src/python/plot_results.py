#!/usr/bin/env python3
# casa_plots.py
# Usage:
#   python casa_plots.py /path/to/index.csv [/path/to/another.csv ...] --out plots/
#
# Outputs:
#   plots/summary.csv
#   plots/baseline/...
#   plots/scenarioA/...
#   plots/scenarioB/...

import argparse
from pathlib import Path
import pandas as pd
import numpy as np
import matplotlib.pyplot as plt

# ----------------------------
# Helpers for flexible schemas
# ----------------------------

def first_col(df, candidates, default=None):
    """Return the first column from candidates that exists in df, else default."""
    for c in candidates:
        if c in df.columns:
            return c
    return default

def pick_size_cols(df):
    """
    Decide which columns to use as the 'post-transform' size for a scenario row.
    We prefer A_post_* if available; otherwise fall back to top-level.
    """
    cols = {}
    cols['Total']       = first_col(df, ['A_post_TotalElements', 'TotalElements'])
    cols['DS']          = first_col(df, ['A_post_DS', 'DS'])
    cols['PD']          = first_col(df, ['A_post_PD', 'PD'])
    cols['Functions']   = first_col(df, ['A_post_Functions', 'Functions'])
    cols['Components']  = first_col(df, ['A_post_Components', 'Components'])
    cols['Vulns']       = first_col(df, ['A_post_Vulnerabilities', 'Vulnerabilities'])
    cols['Purposes']    = first_col(df, ['A_post_Purposes', 'Purposes'])
    cols['Consents']    = first_col(df, ['A_post_Consents', 'Consents'])
    return cols

def ensure_numeric(df, cols):
    for c in cols:
        if c in df.columns:
            df[c] = pd.to_numeric(df[c], errors='coerce')

def combined_load(paths):
    frames = []
    for p in paths:
        df = pd.read_csv(p)
        df['__source__'] = str(p)
        frames.append(df)
    if not frames:
        raise SystemExit("No CSVs loaded.")
    return pd.concat(frames, ignore_index=True)

def build_cols_for_prefix(df, prefix):
    """
    Build the 'cols' mapping for a given prefix.
    prefix examples: 'baseline', 'A_post', 'B_post'.
    Falls back to top-level columns if a prefixed one is missing.
    """
    def pick(pref_name, toplvl):
        cand = []
        if pref_name is not None:
            cand.append(f"{prefix}_{pref_name}" if prefix else pref_name)
        if toplvl is not None:
            cand.append(toplvl)
        return first_col(df, cand)

    return {
        'Total':      pick('TotalElements', 'TotalElements'),
        'DS':         pick('DS',            'DS'),
        'PD':         pick('PD',            'PD'),
        'Functions':  pick('Functions',     'Functions'),
        'Components': pick('Components',    'Components'),
        'Vulns':      pick('Vulnerabilities','Vulnerabilities'),
        'Purposes':   pick('Purposes',      'Purposes'),
        'Consents':   pick('Consents',      'Consents'),
    }

def scenario_label_and_prefixes(df):
    """
    Decide which scenarios we can plot based on columns available.
    Returns a list of tuples: (label, prefix_string)
      - 'baseline' -> 'baseline'
      - 'scenarioA'-> 'A_post'
      - 'scenarioB'-> 'B_post'
    Only include scenarios that have at least a usable TotalElements column.
    """
    candidates = [
        ('baseline', 'baseline'),
        ('scenarioA','A_post'),
        ('scenarioB','B_post'),
    ]
    usable = []
    for label, pref in candidates:
        cols = build_cols_for_prefix(df, pref)
        if cols['Total'] is not None and cols['Total'] in df.columns:
            usable.append((label, pref))
    # If nothing prefixed exists (older CSVs), fall back to top-level once
    if not usable:
        usable.append(('all', ''))
    return usable

# ----------------------------
# Plotting utilities
# ----------------------------

def model_size_hist(df, size_col, out_path, title_suffix=""):
    s = df[size_col].dropna()
    if s.empty:
        print(f"[warn] No data for {size_col}; skipping model_size_hist.")
        return
    plt.figure(figsize=(8,5))
    plt.hist(s, bins=20)
    plt.xlabel('Total elements')
    plt.ylabel('Count of models')
    plt.title(f'Model size distribution{title_suffix}')
    plt.tight_layout()
    plt.savefig(out_path)
    plt.close()

def model_complexity_scatter(df, cols, out_path, title_suffix=""):
    """
    Scatter: Total elements (x) vs count of each element type (y), for all types.
    """
    series = [
        ('Functions',      cols.get('Functions')),
        ('Components',     cols.get('Components')),
        ('PersonalData',   cols.get('PD')),
        ('DataSubjects',   cols.get('DS')),
        ('Vulnerabilities',cols.get('Vulns')),
        ('Purposes',       cols.get('Purposes')),
        ('Consents',       cols.get('Consents')),
    ]

    xcol = cols.get('Total')
    if xcol is None or xcol not in df.columns:
        print(f"[warn] No data for total elements column; skipping complexity scatter.")
        return

    series = [(label, c) for (label, c) in series if c is not None and c in df.columns]
    if not series:
        print("[warn] No element columns found; skipping complexity scatter.")
        return

    ensure_numeric(df, [xcol] + [c for _, c in series])

    plt.figure(figsize=(9,6))
    markers = ['o','s','^','D','v','P','X','*','h','>','<']
    for i, (label, c) in enumerate(series):
        plt.scatter(df[xcol], df[c], alpha=0.6, marker=markers[i % len(markers)], label=label)

    plt.xlabel('Total elements')
    plt.ylabel('Count')
    plt.title(f'Complexity vs. size (all element types){title_suffix}')
    plt.legend(ncol=2)
    plt.tight_layout()
    plt.savefig(out_path)
    plt.close()

def model_complexity_trends(df, cols, out_path, n_bins=10, title_suffix=""):
    """
    Plot average counts of each element type vs. model size bins (line plot).
    """
    xcol = cols.get('Total')
    if xcol is None or xcol not in df.columns:
        print("[warn] Missing total elements column; skipping complexity trends.")
        return

    element_cols = [
        ('DataSubjects',   cols.get('DS')),
        ('PersonalData',   cols.get('PD')),
        ('Functions',      cols.get('Functions')),
        ('Components',     cols.get('Components')),
        ('Vulnerabilities',cols.get('Vulns')),
        ('Purposes',       cols.get('Purposes')),
        ('Consents',       cols.get('Consents')),
    ]
    element_cols = [(name, c) for name, c in element_cols if c and c in df.columns]
    if not element_cols:
        print("[warn] No element columns found; skipping complexity trends.")
        return

    ensure_numeric(df, [xcol] + [c for _, c in element_cols])

    bins = np.linspace(df[xcol].min(), df[xcol].max(), n_bins + 1)
    df = df.copy()
    df['__size_bin__'] = pd.cut(df[xcol], bins=bins, labels=False, include_lowest=True)

    grouped = df.groupby('__size_bin__').mean(numeric_only=True)
    x_centers = [(bins[i] + bins[i+1]) / 2 for i in range(len(bins)-1)]

    plt.figure(figsize=(9,6))
    for name, c in element_cols:
        y = grouped[c].reindex(range(len(x_centers))).to_numpy()
        plt.plot(x_centers, y, marker='o', label=name)

    plt.xlabel('Model size (total elements, binned)')
    plt.ylabel('Average count')
    plt.title(f'Model complexity trends vs. size{title_suffix}')
    plt.legend(ncol=2)
    plt.tight_layout()
    plt.savefig(out_path)
    plt.close()

def model_complexity_trends_with_envelopes(
    df, cols, out_path, n_bins=10, envelope="iqr", title_suffix=""
):
    """
    Plot per-element trends vs. model size with a shaded variability envelope.

    envelope:
      - "iqr"     -> median line + shaded [Q1, Q3]
      - "p10p90"  -> mean line + shaded [10th, 90th]
      - "minmax"  -> mean line + shaded [min, max]
    """
    xcol = cols.get("Total")
    if xcol is None or xcol not in df.columns:
        print("[warn] Missing total elements column; skipping complexity trends.")
        return

    element_cols = [
        ("DataSubjects",   cols.get("DS")),
        ("PersonalData",   cols.get("PD")),
        ("Functions",      cols.get("Functions")),
        ("Components",     cols.get("Components")),
        ("Vulnerabilities",cols.get("Vulns")),
        ("Purposes",       cols.get("Purposes")),
        ("Consents",       cols.get("Consents")),
    ]
    element_cols = [(name, c) for name, c in element_cols if c and c in df.columns]
    if not element_cols:
        print("[warn] No element columns found; skipping complexity trends.")
        return

    ensure_numeric(df, [xcol] + [c for _, c in element_cols])

    # Build bins on total elements
    bins = np.linspace(df[xcol].min(), df[xcol].max(), n_bins + 1)
    df = df.copy()
    df["__size_bin__"] = pd.cut(df[xcol], bins=bins, labels=False, include_lowest=True)
    x_centers = [(bins[i] + bins[i + 1]) / 2 for i in range(len(bins) - 1)]

    def stats_per_bin(col):
        grp = df.groupby("__size_bin__")[col]
        mean  = grp.mean()
        med   = grp.median()
        q1    = grp.quantile(0.25)
        q3    = grp.quantile(0.75)
        p10   = grp.quantile(0.10)
        p90   = grp.quantile(0.90)
        vmin  = grp.min()
        vmax  = grp.max()
        idx = range(len(bins) - 1)
        return {
            "mean":  mean.reindex(idx).to_numpy(),
            "med":   med.reindex(idx).to_numpy(),
            "q1":    q1.reindex(idx).to_numpy(),
            "q3":    q3.reindex(idx).to_numpy(),
            "p10":   p10.reindex(idx).to_numpy(),
            "p90":   p90.reindex(idx).to_numpy(),
            "min":   vmin.reindex(idx).to_numpy(),
            "max":   vmax.reindex(idx).to_numpy(),
        }

    plt.figure(figsize=(9, 6))
    for name, c in element_cols:
        st = stats_per_bin(c)

        if envelope == "iqr":
            y_line = st["med"]
            y_lo, y_hi = st["q1"], st["q3"]
            label = f"{name} (median, IQR)"
        elif envelope == "p10p90":
            y_line = st["mean"]
            y_lo, y_hi = st["p10"], st["p90"]
            label = f"{name} (mean, 10–90%)"
        else:  # "minmax"
            y_line = st["mean"]
            y_lo, y_hi = st["min"], st["max"]
            label = f"{name} (mean, min–max)"

        plt.plot(x_centers, y_line, marker='o', label=label)
        plt.fill_between(x_centers, y_lo, y_hi, alpha=0.2)

    plt.xlabel("Model size (total elements, binned)")
    plt.ylabel("Count")
    plt.title(f"Model complexity trends with variability{title_suffix}")
    plt.legend(ncol=2)
    plt.tight_layout()
    plt.savefig(out_path)
    plt.close()

def violations_vs_size_scatter(df, size_col, out_path, title_suffix=""):
    gt_purpose = first_col(df, ['gt_purpose_total'])
    gt_risk    = first_col(df, ['gt_risk_violations'])
    det_purpose = first_col(df, ['detected_purpose_total'])
    det_risk    = first_col(df, ['detected_risk_violations'])
    need = [size_col, gt_purpose, gt_risk, det_purpose, det_risk]
    if any(c is None for c in need):
        print("[warn] Missing columns for violations_vs_size_scatter; skipping.")
        return

    ensure_numeric(df, need)
    plt.figure(figsize=(8,5))
    plt.scatter(df[size_col], df[gt_purpose], alpha=0.6, label='GT purpose')
    plt.scatter(df[size_col], df[det_purpose], alpha=0.6, marker='x', label='Detected purpose')
    plt.scatter(df[size_col], df[gt_risk],    alpha=0.6, marker='s', label='GT risk')
    plt.scatter(df[size_col], df[det_risk],   alpha=0.6, marker='^', label='Detected risk')
    plt.xlabel('Total elements')
    plt.ylabel('# of violations')
    plt.title(f'Consent & risk violations vs. model size{title_suffix}')
    plt.legend()
    plt.tight_layout()
    plt.savefig(out_path)
    plt.close()

def element_breakdown_bars(df, cols, out_path, title_suffix=""):
    cand = [cols['DS'], cols['PD'], cols['Functions'], cols['Components'],
            cols['Vulns'], cols['Purposes'], cols['Consents']]
    cand = [c for c in cand if c is not None and c in df.columns]
    if not cand:
        print("[warn] No element columns found; skipping element_breakdown_bars.")
        return
    ensure_numeric(df, cand)
    means = df[cand].mean().sort_values(ascending=False)
    plt.figure(figsize=(8,5))
    plt.bar(means.index, means.values)
    plt.ylabel('Mean count per model')
    plt.title(f'Average element breakdown{title_suffix}')
    plt.xticks(rotation=30, ha='right')
    plt.tight_layout()
    plt.savefig(out_path)
    plt.close()

# ----------------------------
# Summary table
# ----------------------------

def build_summary(df):
    cols = {
        'gt_purpose_total': first_col(df, ['gt_purpose_total']),
        'det_purpose_total': first_col(df, ['detected_purpose_total']),
        'gt_risk_violations': first_col(df, ['gt_risk_violations']),
        'det_risk_violations': first_col(df, ['detected_risk_violations']),
        'purpose_correct': first_col(df, ['purpose_correct']),
        'risk_correct': first_col(df, ['risk_correct']),
    }
    for k, v in cols.items():
        if v is None:
            cols[k] = '__missing__'

    numeric = [cols['gt_purpose_total'], cols['det_purpose_total'],
               cols['gt_risk_violations'], cols['det_risk_violations']]
    ensure_numeric(df, [c for c in numeric if c in df.columns])

    tot_gt_purp = df[cols['gt_purpose_total']].sum() if cols['gt_purpose_total'] in df.columns else np.nan
    tot_det_purp = df[cols['det_purpose_total']].sum() if cols['det_purpose_total'] in df.columns else np.nan
    tot_gt_risk = df[cols['gt_risk_violations']].sum() if cols['gt_risk_violations'] in df.columns else np.nan
    tot_det_risk = df[cols['det_risk_violations']].sum() if cols['det_risk_violations'] in df.columns else np.nan

    def all_true(colname):
        if colname not in df.columns: return None
        vals = df[colname]
        if vals.dtype == object:
            vals = vals.str.lower().isin(['true','1','yes'])
        return bool(vals.all())

    all_purpose_ok = all_true(cols['purpose_correct'])
    all_risk_ok = all_true(cols['risk_correct'])

    purp_mism = int((df[cols['gt_purpose_total']] != df[cols['det_purpose_total']]).sum()) if cols['gt_purpose_total'] in df.columns and cols['det_purpose_total'] in df.columns else None
    risk_mism = int((df[cols['gt_risk_violations']] != df[cols['det_risk_violations']]).sum()) if cols['gt_risk_violations'] in df.columns and cols['det_risk_violations'] in df.columns else None

    summary = pd.DataFrame([{
        'models': len(df),
        'total_gt_purpose': int(tot_gt_purp) if pd.notna(tot_gt_purp) else None,
        'total_detected_purpose': int(tot_det_purp) if pd.notna(tot_det_purp) else None,
        'purpose_all_match': all_purpose_ok,
        'purpose_row_mismatches': purp_mism,
        'total_gt_risk': int(tot_gt_risk) if pd.notna(tot_gt_risk) else None,
        'total_detected_risk': int(tot_det_risk) if pd.notna(tot_det_risk) else None,
        'risk_all_match': all_risk_ok,
        'risk_row_mismatches': risk_mism,
    }])
    return summary

# ----------------------------
# Main
# ----------------------------

def main():
    ap = argparse.ArgumentParser(description="Plots for CASA experiment CSVs.")
    ap.add_argument('csv', nargs='+', help='One or more index.csv files')
    ap.add_argument('--out', default='plots', help='Output directory for plots/tables')
    ap.add_argument('--bins', type=int, default=20, help='Number of size bins for trend plots')
    ap.add_argument('--envelope', choices=['iqr','p10p90','minmax'], default='iqr', help='Variability envelope')
    args = ap.parse_args()

    outdir = Path(args.out)
    outdir.mkdir(parents=True, exist_ok=True)

    df = combined_load(args.csv)

    # Root summary across all rows (independent of scenario size snapshot)
    summary = build_summary(df)
    summary.to_csv(outdir / 'summary.csv', index=False)

    print("\n=== CASA Summary (all rows) ===")
    print(summary.to_string(index=False))

    # Per-scenario plots
    for label, pref in scenario_label_and_prefixes(df):
        subdir = outdir / label
        subdir.mkdir(parents=True, exist_ok=True)

        cols_this = build_cols_for_prefix(df, pref)
        size_col_this = cols_this['Total']
        if size_col_this is None or size_col_this not in df.columns:
            print(f"[warn] Skipping {label}: no usable TotalElements column.")
            continue

        ensure_numeric(df, [c for c in cols_this.values() if c is not None])
        title_suffix = f" – {label}"

        # Plots
        model_size_hist(df, size_col_this, subdir / 'model_size_hist.png', title_suffix)
        model_complexity_scatter(df, cols_this, subdir / 'model_complexity_scatter.png', title_suffix)
        model_complexity_trends(df, cols_this, subdir / 'model_complexity_trends.png', n_bins=args.bins, title_suffix=title_suffix)
        model_complexity_trends_with_envelopes(
            df, cols_this, subdir / 'model_complexity_trends_envelopes.png',
            n_bins=args.bins, envelope=args.envelope, title_suffix=title_suffix
        )
        violations_vs_size_scatter(df, size_col_this, subdir / 'violations_vs_size_scatter.png', title_suffix)
        element_breakdown_bars(df, cols_this, subdir / 'element_breakdown_bars.png', title_suffix)

        # Optional per-scenario summary (same GT/detected columns, different size snapshot)
        scen_sum = build_summary(df)
        scen_sum.to_csv(subdir / f'summary_{label}.csv', index=False)

    print(f"\nWrote plots to: {outdir.resolve()}\n")

if __name__ == '__main__':
    main()
