#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
cd "$ROOT_DIR"

usage() {
  cat <<'EOF'
Create a compressed source archive from the Git repository.

Usage:
  scripts/create-code-archive.sh [output] [git-ref]

Defaults:
  output:  casa-code.tar.gz
  git-ref: HEAD

The archive contains only files committed at the selected Git reference and
extracts into a casa-code/ directory.
EOF
}

if [[ "${1:-}" == "help" || "${1:-}" == "--help" || "${1:-}" == "-h" ]]; then
  usage
  exit 0
fi

OUTPUT="${1:-$ROOT_DIR/casa-code.tar.gz}"
GIT_REF="${2:-HEAD}"
TEMP_OUTPUT="${OUTPUT}.tmp"

if ! git diff --quiet || ! git diff --cached --quiet; then
  echo "Refusing to create the archive: tracked files have uncommitted changes." >&2
  echo "Commit or stash them first so the archive matches the repository state." >&2
  exit 1
fi

git rev-parse --verify "${GIT_REF}^{commit}" >/dev/null

trap 'rm -f "$TEMP_OUTPUT"' EXIT
git archive \
  --format=tar.gz \
  --prefix=casa-code/ \
  --output="$TEMP_OUTPUT" \
  "$GIT_REF"
mv "$TEMP_OUTPUT" "$OUTPUT"
trap - EXIT

echo "Created $OUTPUT from $GIT_REF"
