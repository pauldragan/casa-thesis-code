#!/usr/bin/env python3
"""
Prepare the canonical editable CVSS artifact for the v3 evaluation CVE set.

The output contains exactly one version of the CVSS data per CVE.
Fetched NVD values are copied into that single editable record, together with:
- provenance fields (`sourceName`, `sourceUrl`)
- problem annotations from validation

This file is intended to become the single curated source of truth.
"""

from __future__ import annotations

import argparse
import csv
import json
from pathlib import Path
from typing import Any


SCRIPT_DIR = Path(__file__).resolve().parent
DEFAULT_FETCHED_JSON = SCRIPT_DIR / "nvd_cvss_details.json"
DEFAULT_VALIDATION_JSON = SCRIPT_DIR / "nvd_cvss_validation_report.json"
DEFAULT_OUT_CSV = SCRIPT_DIR / "manual_cvss_overrides.csv"
DEFAULT_OUT_JSON = SCRIPT_DIR / "manual_cvss_overrides.json"

FIELDS = [
    "cveId",
    "componentType",
    "problemReasons",
    "sourceName",
    "sourceUrl",
    "cvssVersion",
    "vectorString",
    "baseScore",
    "baseSeverity",
    "attackVector",
    "attackComplexity",
    "privilegesRequired",
    "userInteraction",
    "scope",
    "confidentialityImpact",
    "integrityImpact",
    "availabilityImpact",
    "notes",
]


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument("--in", dest="in_path", type=Path, default=DEFAULT_FETCHED_JSON)
    parser.add_argument("--validation", type=Path, default=DEFAULT_VALIDATION_JSON)
    parser.add_argument("--out-csv", type=Path, default=DEFAULT_OUT_CSV)
    parser.add_argument("--out-json", type=Path, default=DEFAULT_OUT_JSON)
    return parser.parse_args()


def load_json(path: Path) -> dict[str, Any]:
    return json.loads(path.read_text(encoding="utf-8"))


def load_problem_map(validation_path: Path | None) -> dict[str, list[str]]:
    if validation_path is None or not validation_path.exists():
        return {}
    payload = load_json(validation_path)
    raw = payload.get("problemsByCve", {})
    if not isinstance(raw, dict):
        return {}
    return {
        str(cve_id): [str(reason) for reason in reasons]
        for cve_id, reasons in raw.items()
        if isinstance(reasons, list)
    }


def infer_problem_reasons(entry: dict[str, Any]) -> list[str]:
    reasons: list[str] = []
    status = entry.get("status")
    version = entry.get("cvssVersion")
    if status in ("missing", "no_cvss_metrics"):
        reasons.append(str(status))
    if version not in (None, "3.1"):
        reasons.append(f"non_v31_cvss:{version}")
    return reasons


def consolidate_entries(
    fetched_entries: list[dict[str, Any]],
    problem_map: dict[str, list[str]],
) -> list[dict[str, Any]]:
    rows: list[dict[str, Any]] = []
    for fetched in fetched_entries:
        cve_id = str(fetched.get("cveId", ""))
        rows.append(
            {
                "cveId": cve_id,
                "componentType": str(fetched.get("componentType", "")),
                "problemReasons": problem_map.get(cve_id, infer_problem_reasons(fetched)),
                "sourceName": "NVD" if fetched.get("status") == "ok" else "",
                "sourceUrl": "",
                "cvssVersion": fetched.get("cvssVersion") or "",
                "vectorString": fetched.get("vectorString") or "",
                "baseScore": fetched.get("baseScore") if fetched.get("baseScore") is not None else "",
                "baseSeverity": fetched.get("baseSeverity") or "",
                "attackVector": fetched.get("attackVector") or "",
                "attackComplexity": fetched.get("attackComplexity") or "",
                "privilegesRequired": fetched.get("privilegesRequired") or "",
                "userInteraction": fetched.get("userInteraction") or "",
                "scope": fetched.get("scope") or "",
                "confidentialityImpact": fetched.get("confidentialityImpact") or "",
                "integrityImpact": fetched.get("integrityImpact") or "",
                "availabilityImpact": fetched.get("availabilityImpact") or "",
                "notes": "",
            }
        )
    rows.sort(key=lambda row: (row["componentType"], row["cveId"]))
    return rows


def write_csv(path: Path, rows: list[dict[str, Any]]) -> None:
    path.parent.mkdir(parents=True, exist_ok=True)
    with path.open("w", encoding="utf-8", newline="") as handle:
        writer = csv.DictWriter(handle, fieldnames=FIELDS)
        writer.writeheader()
        for row in rows:
            csv_row = dict(row)
            csv_row["problemReasons"] = " | ".join(row["problemReasons"])
            writer.writerow(csv_row)


def write_json(path: Path, rows: list[dict[str, Any]], fetched_json: Path, validation_json: Path | None) -> None:
    payload = {
        "sourceFetchedJson": str(fetched_json),
        "sourceValidationJson": str(validation_json) if validation_json and validation_json.exists() else None,
        "entryCount": len(rows),
        "entries": rows,
    }
    path.parent.mkdir(parents=True, exist_ok=True)
    path.write_text(json.dumps(payload, indent=2), encoding="utf-8")


def main() -> int:
    args = parse_args()
    fetched_payload = load_json(args.in_path)
    fetched_entries = fetched_payload.get("entries")
    if not isinstance(fetched_entries, list):
        raise RuntimeError(f"Missing or invalid 'entries' array in {args.in_path}")
    problem_map = load_problem_map(args.validation)
    rows = consolidate_entries(fetched_entries, problem_map)
    write_csv(args.out_csv, rows)
    write_json(args.out_json, rows, args.in_path, args.validation)
    print(f"Wrote canonical CSV to {args.out_csv}")
    print(f"Wrote canonical JSON to {args.out_json}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
