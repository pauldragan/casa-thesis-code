#!/usr/bin/env python3
from __future__ import annotations

import argparse
import csv
from pathlib import Path


def read_csv(path: Path) -> list[dict[str, str]]:
    with path.open(newline="", encoding="utf-8") as handle:
        return list(csv.DictReader(handle))


def write_rows_csv(outpath: Path, rows: list[dict[str, str]]) -> None:
    if not rows:
        return
    with outpath.open("w", newline="", encoding="utf-8") as handle:
        writer = csv.DictWriter(handle, fieldnames=list(rows[0].keys()))
        writer.writeheader()
        writer.writerows(rows)


def parse_bool(value: str) -> bool:
    return str(value).strip().lower() in {"true", "1", "yes"}


def to_int(value: str | None) -> int:
    if value is None:
        return 0
    text = str(value).strip()
    if text == "":
        return 0
    return int(float(text))


def format_accuracy(value: float) -> str:
    if abs(value - round(value)) < 1e-12:
        return f"{value:.1f}"
    return f"{value:.6f}".rstrip("0").rstrip(".")


def write_accuracy_table_latex(
    rows: list[tuple[str, str]],
    outpath: Path,
) -> None:
    with outpath.open("w", encoding="utf-8") as handle:
        handle.write("\\begin{tabular}{l r}\n")
        handle.write("\\toprule\n")
        handle.write("\\textbf{Metric} & \\textbf{Value} \\\\\n")
        handle.write("\\midrule\n")
        for metric, value in rows:
            value_out = value
            if value.replace(".", "", 1).isdigit():
                value_out = f"\\num{{{value}}}"
            handle.write(f"{metric} & {value_out} \\\\\n")
        handle.write("\\bottomrule\n")
        handle.write("\\end{tabular}\n")


def render_result_outputs(input_dir: Path, out_dir: Path) -> None:
    out_dir.mkdir(parents=True, exist_ok=True)
    manifest_rows = read_csv(input_dir / "result_evaluation_manifest.csv")

    total_derivations = len(manifest_rows)
    correct_derivations = sum(parse_bool(row.get("derivation_correct", "false")) for row in manifest_rows)
    incorrect_derivations = total_derivations - correct_derivations
    derivation_accuracy = 0.0 if total_derivations == 0 else correct_derivations / total_derivations

    purpose_expected = sum(to_int(row.get("expected_identifiable_purpose_violations")) for row in manifest_rows)
    purpose_tp = sum(to_int(row.get("purpose_true_positives")) for row in manifest_rows)
    purpose_fn = sum(to_int(row.get("purpose_false_negatives")) for row in manifest_rows)
    purpose_fp = sum(to_int(row.get("purpose_false_positives")) for row in manifest_rows)
    purpose_denom = purpose_tp + purpose_fn + purpose_fp
    purpose_accuracy = 1.0 if purpose_denom == 0 else purpose_tp / purpose_denom

    risk_expected = sum(to_int(row.get("expected_identifiable_risk_violations")) for row in manifest_rows)
    risk_tp = sum(to_int(row.get("risk_true_positives")) for row in manifest_rows)
    risk_fn = sum(to_int(row.get("risk_false_negatives")) for row in manifest_rows)
    risk_fp = sum(to_int(row.get("risk_false_positives")) for row in manifest_rows)
    risk_denom = risk_tp + risk_fn + risk_fp
    risk_accuracy = 1.0 if risk_denom == 0 else risk_tp / risk_denom

    derivation_rows = [
        ("Total derivations evaluated", str(total_derivations)),
        ("Correct derivations", str(correct_derivations)),
        ("Incorrect derivations", str(incorrect_derivations)),
        ("Derivation accuracy ($\\text{Accuracy}_d$)", format_accuracy(derivation_accuracy)),
    ]
    write_rows_csv(
        out_dir / "table_result_derivation_accuracy.csv",
        [{"metric": k, "value": v} for k, v in derivation_rows],
    )
    write_accuracy_table_latex(
        derivation_rows,
        out_dir / "table_result_derivation_accuracy.tex",
    )

    purpose_rows = [
        ("Total ground truth violations", str(purpose_expected)),
        ("Correctly identified violations", str(purpose_tp)),
        ("Missed violations (false negatives)", str(purpose_fn)),
        ("Incorrectly reported violations (false positives)", str(purpose_fp)),
        ("Accuracy ($\\text{Accuracy}_v^p$)", format_accuracy(purpose_accuracy)),
    ]
    write_rows_csv(
        out_dir / "table_result_purpose_accuracy.csv",
        [{"metric": k, "value": v} for k, v in purpose_rows],
    )
    write_accuracy_table_latex(
        purpose_rows,
        out_dir / "table_result_purpose_accuracy.tex",
    )

    risk_rows = [
        ("Total ground truth violations", str(risk_expected)),
        ("Correctly identified violations", str(risk_tp)),
        ("Missed violations (false negatives)", str(risk_fn)),
        ("Incorrectly reported violations (false positives)", str(risk_fp)),
        ("Accuracy ($\\text{Accuracy}_v^r$)", format_accuracy(risk_accuracy)),
    ]
    write_rows_csv(
        out_dir / "table_result_risk_accuracy.csv",
        [{"metric": k, "value": v} for k, v in risk_rows],
    )
    write_accuracy_table_latex(
        risk_rows,
        out_dir / "table_result_risk_accuracy.tex",
    )


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser(description="Render v3 result-evaluation LaTeX/CSV tables.")
    parser.add_argument("--in", dest="input_dir", required=True, help="Directory containing result_evaluation_manifest.csv.")
    parser.add_argument("--out", dest="output_dir", required=True, help="Directory where tables should be written.")
    return parser.parse_args()


def main() -> None:
    args = parse_args()
    render_result_outputs(Path(args.input_dir), Path(args.output_dir))


if __name__ == "__main__":
    main()
