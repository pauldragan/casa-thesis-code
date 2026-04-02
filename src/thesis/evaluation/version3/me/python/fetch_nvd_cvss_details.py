#!/usr/bin/env python3
"""
Fetch CVSS details for the v3 evaluation CVE catalog from the NVD CVE API.

Default behavior:
- parse the CVE list from `../GenerationConfig.java`
- fetch CVE records from the official NVD API
- extract CVSS metrics, preferring NVD CVSS v3.1
- write a normalized JSON artifact

Usage:
    python fetch_nvd_cvss_details.py --out out/cvss_details.json

Optional:
    NVD_API_KEY=... python fetch_nvd_cvss_details.py --delay 0.2
"""

from __future__ import annotations

import argparse
import json
import os
import re
import sys
import time
import urllib.error
import urllib.parse
import urllib.request
from collections import OrderedDict
from pathlib import Path
from typing import Any


SCRIPT_DIR = Path(__file__).resolve().parent
DEFAULT_CONFIG_PATH = SCRIPT_DIR.parent / "GenerationConfig.java"
DEFAULT_OUT_PATH = SCRIPT_DIR / "nvd_cvss_details.json"
NVD_API_URL = "https://services.nvd.nist.gov/rest/json/cves/2.0"


def parse_args() -> argparse.Namespace:
    parser = argparse.ArgumentParser()
    parser.add_argument("--config", type=Path, default=DEFAULT_CONFIG_PATH)
    parser.add_argument("--out", type=Path, default=DEFAULT_OUT_PATH)
    parser.add_argument(
        "--delay",
        type=float,
        default=6.0,
        help="Delay in seconds between requests when no NVD_API_KEY is provided. Default: 6.0",
    )
    parser.add_argument(
        "--timeout",
        type=float,
        default=30.0,
        help="HTTP timeout in seconds. Default: 30.0",
    )
    parser.add_argument(
        "--retries",
        type=int,
        default=3,
        help="Retry count for transient HTTP failures. Default: 3",
    )
    return parser.parse_args()


def extract_catalog(config_path: Path) -> dict[str, list[str]]:
    text = config_path.read_text(encoding="utf-8")
    pattern = re.compile(
        r'vulns\.put\("(?P<component>[^"]+)",\s*List\.of\((?P<body>.*?)\)\);',
        re.DOTALL,
    )
    catalog: dict[str, list[str]] = OrderedDict()
    for match in pattern.finditer(text):
        component = match.group("component")
        body = match.group("body")
        cves = re.findall(r'"(CVE-[0-9]{4}-[0-9]+)"', body)
        catalog[component] = cves
    if not catalog:
        raise RuntimeError(f"Failed to extract vulnerability catalog from {config_path}")
    return catalog


def build_request(cve_id: str, api_key: str | None) -> urllib.request.Request:
    url = f"{NVD_API_URL}?{urllib.parse.urlencode({'cveId': cve_id})}"
    headers = {
        "User-Agent": "phd-thesis-version3-cvss-fetcher/1.0",
        "Accept": "application/json",
    }
    if api_key:
        headers["apiKey"] = api_key
    return urllib.request.Request(url, headers=headers)


def load_json(request: urllib.request.Request, timeout: float, retries: int) -> dict[str, Any]:
    last_error: Exception | None = None
    for attempt in range(1, retries + 1):
        try:
            with urllib.request.urlopen(request, timeout=timeout) as response:
                return json.load(response)
        except urllib.error.HTTPError as exc:
            if exc.code in (403, 404):
                raise
            last_error = exc
        except urllib.error.URLError as exc:
            last_error = exc
        if attempt < retries:
            time.sleep(min(2**attempt, 8))
    assert last_error is not None
    raise last_error


def pick_cvss(metrics: dict[str, Any]) -> tuple[str | None, dict[str, Any] | None]:
    for key in ("cvssMetricV31", "cvssMetricV30", "cvssMetricV2"):
        entries = metrics.get(key)
        if entries:
            first = entries[0]
            cvss_data = first.get("cvssData")
            if cvss_data:
                return key, first
    return None, None


def normalize_cvss(cve_id: str, component_type: str, payload: dict[str, Any]) -> dict[str, Any]:
    vulns = payload.get("vulnerabilities", [])
    if not vulns:
        return {
            "cveId": cve_id,
            "componentType": component_type,
            "status": "missing",
            "source": None,
            "cvssMetricKey": None,
            "cvssVersion": None,
            "vectorString": None,
            "baseScore": None,
            "baseSeverity": None,
            "attackVector": None,
            "attackComplexity": None,
            "privilegesRequired": None,
            "userInteraction": None,
            "scope": None,
            "confidentialityImpact": None,
            "integrityImpact": None,
            "availabilityImpact": None,
        }

    cve = vulns[0].get("cve", {})
    metric_key, metric_entry = pick_cvss(cve.get("metrics", {}))
    if metric_entry is None:
        return {
            "cveId": cve_id,
            "componentType": component_type,
            "status": "no_cvss_metrics",
            "source": None,
            "cvssMetricKey": None,
            "cvssVersion": None,
            "vectorString": None,
            "baseScore": None,
            "baseSeverity": None,
            "attackVector": None,
            "attackComplexity": None,
            "privilegesRequired": None,
            "userInteraction": None,
            "scope": None,
            "confidentialityImpact": None,
            "integrityImpact": None,
            "availabilityImpact": None,
        }

    cvss = metric_entry["cvssData"]
    return {
        "cveId": cve_id,
        "componentType": component_type,
        "status": "ok",
        "source": metric_entry.get("source"),
        "cvssMetricKey": metric_key,
        "cvssVersion": cvss.get("version"),
        "vectorString": cvss.get("vectorString"),
        "baseScore": cvss.get("baseScore"),
        "baseSeverity": cvss.get("baseSeverity", metric_entry.get("baseSeverity")),
        "attackVector": cvss.get("attackVector"),
        "attackComplexity": cvss.get("attackComplexity"),
        "privilegesRequired": cvss.get("privilegesRequired"),
        "userInteraction": cvss.get("userInteraction"),
        "scope": cvss.get("scope"),
        "confidentialityImpact": cvss.get("confidentialityImpact"),
        "integrityImpact": cvss.get("integrityImpact"),
        "availabilityImpact": cvss.get("availabilityImpact"),
    }


def fetch_all(
    catalog: dict[str, list[str]],
    config_path: Path,
    timeout: float,
    retries: int,
    delay: float,
    api_key: str | None,
) -> dict[str, Any]:
    results: list[dict[str, Any]] = []
    flat_items = [(component, cve) for component, cves in catalog.items() for cve in cves]
    for index, (component, cve_id) in enumerate(flat_items, start=1):
        print(f"[{index}/{len(flat_items)}] fetching {cve_id} ({component})", file=sys.stderr)
        request = build_request(cve_id, api_key)
        payload = load_json(request, timeout=timeout, retries=retries)
        results.append(normalize_cvss(cve_id, component, payload))
        if index < len(flat_items):
            time.sleep(0.6 if api_key else delay)
    return {
        "source": "NVD CVE API 2.0",
        "apiUrl": NVD_API_URL,
        "generatedAtEpochSeconds": int(time.time()),
        "configPath": str(config_path),
        "entries": results,
    }


def main() -> int:
    args = parse_args()
    api_key = os.environ.get("NVD_API_KEY")
    catalog = extract_catalog(args.config)
    payload = fetch_all(
        catalog=catalog,
        config_path=args.config,
        timeout=args.timeout,
        retries=args.retries,
        delay=args.delay,
        api_key=api_key,
    )
    args.out.parent.mkdir(parents=True, exist_ok=True)
    args.out.write_text(json.dumps(payload, indent=2), encoding="utf-8")
    print(f"Wrote {len(payload['entries'])} entries to {args.out}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
