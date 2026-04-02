#!/usr/bin/env python3
"""
Validate the normalized NVD CVSS JSON produced by fetch_nvd_cvss_details.py.

Checks:
- entry count and duplicate CVE IDs
- missing or no-metrics entries
- CVSS version != 3.1
- missing required CVSS 3.1 fields

Outputs:
- JSON summary report
- human-readable text log of all problems
"""

from __future__ import annotations

import argparse
import json
from collections import Counter, defaultdict
from pathlib import Path
from typing import Any


SCRIPT_DIR = Path(__file__).resolve().parent
DEFAULT_IN_PATH = SCRIPT_DIR / "nvd_cvss_details.json"
DEFAULT_OUT_JSON = SCRIPT_DIR / "nvd_cvss_validation_report.json"
DEFAULT_OUT_LOG = SCRIPT_DIR / "nvd_cvss_validation_problems.txt"

REQUIRED_V31_FIELDS = [
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
]


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument("--in", dest="in_path", type=Path, default=DEFAULT_IN_PATH)
    parser.add_argument("--out-json", type=Path, default=DEFAULT_OUT_JSON)
    parser.add_argument("--out-log", type=Path, default=DEFAULT_OUT_LOG)
    return parser.parse_args()


def load_entries(path: Path) -> list[dict[str, Any]]:
    payload = json.loads(path.read_text(encoding="utf-8"))
    entries = payload.get("entries")
    if not isinstance(entries, list):
        raise RuntimeError(f"Missing or invalid 'entries' array in {path}")
    return entries


def classify_entry(entry: dict[str, Any]) -> list[str]:
    problems: list[str] = []
    status = entry.get("status")
    version = entry.get("cvssVersion")

    if status == "missing":
        problems.append("missing_cve_record")
        return problems
    if status == "no_cvss_metrics":
        problems.append("missing_cvss_metrics")
        return problems
    if status != "ok":
        problems.append(f"unexpected_status:{status}")

    if version != "3.1":
        if version is None:
            problems.append("missing_cvss_version")
        else:
            problems.append(f"non_v31_cvss:{version}")

    missing_fields = [field for field in REQUIRED_V31_FIELDS if entry.get(field) in (None, "")]
    if missing_fields:
        problems.append("missing_required_fields:" + ",".join(missing_fields))

    return problems


def build_report(entries: list[dict[str, Any]]) -> tuple[dict[str, Any], str]:
    cve_ids = [str(entry.get("cveId", "")) for entry in entries]
    duplicates = sorted([cve for cve, count in Counter(cve_ids).items() if cve and count > 1])

    problems_by_cve: dict[str, list[str]] = {}
    counters: Counter[str] = Counter()
    by_component: dict[str, list[str]] = defaultdict(list)

    for entry in entries:
        cve_id = str(entry.get("cveId", ""))
        component = str(entry.get("componentType", ""))
        problems = classify_entry(entry)
        if problems:
            problems_by_cve[cve_id] = problems
            by_component[component].append(cve_id)
            for problem in problems:
                counters[problem] += 1

    ok_entries = len(entries) - len(problems_by_cve)
    report = {
        "inputEntryCount": len(entries),
        "uniqueCveCount": len(set(cve_ids)),
        "duplicateCves": duplicates,
        "okEntryCount": ok_entries,
        "problemEntryCount": len(problems_by_cve),
        "problemTypeCounts": dict(sorted(counters.items())),
        "problemsByComponentType": {
            component: sorted(cves) for component, cves in sorted(by_component.items())
        },
        "problemsByCve": {
            cve_id: problems for cve_id, problems in sorted(problems_by_cve.items())
        },
    }

    lines: list[str] = []
    lines.append(f"Input entries: {report['inputEntryCount']}")
    lines.append(f"Unique CVEs: {report['uniqueCveCount']}")
    lines.append(f"OK entries: {report['okEntryCount']}")
    lines.append(f"Entries with problems: {report['problemEntryCount']}")
    if duplicates:
        lines.append("Duplicate CVEs: " + ", ".join(duplicates))
    lines.append("")
    lines.append("Problem type counts:")
    if counters:
        for key, count in sorted(counters.items()):
            lines.append(f"- {key}: {count}")
    else:
        lines.append("- none")
    lines.append("")
    lines.append("Problems by CVE:")
    if problems_by_cve:
        for cve_id, problems in sorted(problems_by_cve.items()):
            lines.append(f"- {cve_id}: " + " | ".join(problems))
    else:
        lines.append("- none")

    return report, "\n".join(lines) + "\n"


def main() -> int:
    args = parse_args()
    entries = load_entries(args.in_path)
    report, log_text = build_report(entries)
    args.out_json.parent.mkdir(parents=True, exist_ok=True)
    args.out_log.parent.mkdir(parents=True, exist_ok=True)
    args.out_json.write_text(json.dumps(report, indent=2), encoding="utf-8")
    args.out_log.write_text(log_text, encoding="utf-8")
    print(f"Wrote JSON report to {args.out_json}")
    print(f"Wrote text log to {args.out_log}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
