#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
cd "$ROOT_DIR"

usage() {
  cat <<'EOF'
Fedora setup for VM reproducibility runs.

Usage:
  setup_fedora.sh

Installs:
  - Maven
  - Python 3 + pip
  - Python venv at .venv (uses system-site-packages)
  - R + build prerequisites
  - Python plotting dependencies from requirements-python.txt
  - R plotting dependencies used by src/R/plot_results.R

Prerequisite:
  - Local JDK at /home/thesis/java/jdk-17.0.2 (no Java install via dnf)
EOF
}

if [[ "${1:-}" == "help" || "${1:-}" == "--help" || "${1:-}" == "-h" ]]; then
  usage
  exit 0
fi

if command -v sudo >/dev/null 2>&1; then
  SUDO=(sudo)
else
  SUDO=()
fi

if [[ ! -x "/home/thesis/java/jdk-17.0.2/bin/java" ]]; then
  echo "[setup] Missing required local JDK: /home/thesis/java/jdk-17.0.2/bin/java" >&2
  echo "[setup] Provide that JDK path before running setup." >&2
  exit 2
fi

echo "[setup] Installing Fedora packages..."
"${SUDO[@]}" dnf install -y \
  maven \
  python3 \
  python3-pip \
  python3-virtualenv \
  python3-devel \
  R \
  gcc \
  gcc-c++ \
  make \
  freetype-devel \
  harfbuzz-devel \
  fribidi-devel \
  libpng-devel \
  libjpeg-turbo-devel

echo "[setup] Creating Python virtual environment (.venv)..."
python3 -m venv --system-site-packages .venv

echo "[setup] Installing Python packages in .venv..."
if ! ./.venv/bin/pip install --only-binary=:all: -r requirements-python.txt; then
  echo "[setup] WARN: pip install failed (likely wheel compatibility on this Fedora/Python version)." >&2
  echo "[setup] Falling back to Fedora Python packages for plotting stack..." >&2
  "${SUDO[@]}" dnf install -y \
    python3-numpy \
    python3-pandas \
    python3-matplotlib
fi

echo "[setup] Installing R packages (user library)..."
export R_LIBS_USER="${R_LIBS_USER:-$HOME/R/x86_64-pc-linux-gnu-library/$(Rscript -e 'cat(paste(R.version$major, R.version$minor, sep=\".\"))')}"
mkdir -p "$R_LIBS_USER"
Rscript -e "install.packages(c('optparse','readr','dplyr','tidyr','ggplot2','cowplot','scales','showtext','stringr','purrr'), repos='https://cloud.r-project.org', lib=Sys.getenv('R_LIBS_USER'))"

echo "[setup] Java expected at /home/thesis/java/jdk-17.0.2 (runner auto-detects it)."

echo "[setup] Done."
