#!/usr/bin/env bash
set -euo pipefail

ROOT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")/../.." && pwd)"
cd "$ROOT_DIR"

VM_OUT_ROOT="${VM_OUT_ROOT:-/home/thesis/data/results}"
mkdir -p "$VM_OUT_ROOT"

if [ -z "${JAVA_HOME:-}" ] && [ -d "/home/thesis/java/jdk-17.0.2" ]; then
  export JAVA_HOME="/home/thesis/java/jdk-17.0.2"
fi

PYTHON_BIN="${PYTHON_BIN:-$ROOT_DIR/.venv/bin/python}"
if [ ! -x "$PYTHON_BIN" ]; then
  PYTHON_BIN="$(command -v python3 || true)"
fi
if [ -z "$PYTHON_BIN" ] || [ ! -x "$PYTHON_BIN" ]; then
  echo "[vm-repro] Missing Python interpreter. Run: scripts/vm/setup_fedora.sh" >&2
  exit 3
fi

usage() {
  cat <<'EOF'
VM reproducibility runner for the thesis code.

Usage:
  runner.sh help
  runner.sh setup-fedora
  runner.sh build
  runner.sh smoke
  runner.sh apply-smoke [model_count] [seed] [--resume]
  runner.sh dataset-eval [--resume]
  runner.sh result-eval
  runner.sh full-pipeline [model_count] [seed] [--resume]
  runner.sh run-thesis <thesis args...>
  runner.sh plot-dataset-eval [dataset_eval_dir] [plot_out_dir]
  runner.sh plot-result-eval [result_eval_dir] [plot_out_dir]
  runner.sh plot-python <index.csv> [more.csv ...] [--out <dir>]
  runner.sh plot-r <index.csv> [more.csv ...] [--out <dir>] [--bins N] [--envelope iqr|p10p90|minmax]
  runner.sh shell

Examples:
  runner.sh setup-fedora
  runner.sh build
  runner.sh apply-smoke 3500 20260311 --resume
  runner.sh full-pipeline 3500 20260311 --resume
EOF
}

has_flag() {
  local flag="$1"
  shift
  local arg
  for arg in "$@"; do
    if [ "$arg" = "$flag" ]; then
      return 0
    fi
  done
  return 1
}

ensure_runtime_ready() {
  local java_bin=""
  if [ -n "${JAVA_BIN:-}" ] && [ -x "${JAVA_BIN}" ]; then
    java_bin="${JAVA_BIN}"
  elif [ -n "${JAVA_HOME:-}" ] && [ -x "${JAVA_HOME}/bin/java" ]; then
    java_bin="${JAVA_HOME}/bin/java"
  elif [ -x "/home/thesis/java/jdk-17.0.2/bin/java" ]; then
    java_bin="/home/thesis/java/jdk-17.0.2/bin/java"
  elif command -v java >/dev/null 2>&1; then
    java_bin="$(command -v java)"
  else
    echo "[vm-repro] Missing Java runtime." >&2
    echo "[vm-repro] Either install via scripts/vm/setup_fedora.sh or set JAVA_HOME/JAVA_BIN." >&2
    exit 3
  fi

  if [ ! -f target/classes/thesis/Thesis.class ]; then
    echo "[vm-repro] Missing precompiled classes at target/classes." >&2
    echo "[vm-repro] Compile in Eclipse once (or sync precompiled target/classes) and retry." >&2
    exit 3
  fi

  JAVA_BIN="$java_bin"

  # If runtime deps are already synced, skip Maven.
  if [ -d target/dependency ] && [ -n "$(ls -A target/dependency 2>/dev/null || true)" ]; then
    return 0
  fi

  if ! command -v mvn >/dev/null 2>&1; then
    echo "[vm-repro] Missing Maven and target/dependency is empty." >&2
    echo "[vm-repro] Install Maven (scripts/vm/setup_fedora.sh) or sync target/dependency." >&2
    exit 3
  fi

  echo "[vm-repro] Resolving runtime dependencies into target/dependency..."
  mvn -B -q dependency:copy-dependencies -DincludeScope=runtime

}

run_thesis() {
  if [ "$#" -eq 0 ]; then
    echo "run-thesis requires thesis arguments, e.g. -config v3_smoke" >&2
    exit 2
  fi

  if ! has_flag "-v3-out" "$@"; then
    set -- "$@" -v3-out "$VM_OUT_ROOT/models_experiment/version3_smoke"
  fi
  if ! has_flag "-v3-sa-out" "$@"; then
    set -- "$@" -v3-sa-out "$VM_OUT_ROOT/models_experiment/version3_sa_smoke"
  fi
  if ! has_flag "-v3-apply-out" "$@"; then
    set -- "$@" -v3-apply-out "$VM_OUT_ROOT/models_experiment/version3_apply_smoke"
  fi
  if ! has_flag "-v3-me-eval-out" "$@"; then
    set -- "$@" -v3-me-eval-out "$VM_OUT_ROOT/models_experiment/version3_me_dataset_evaluation"
  fi
  if ! has_flag "-v3-sa-eval-out" "$@"; then
    set -- "$@" -v3-sa-eval-out "$VM_OUT_ROOT/models_experiment/version3_sa_dataset_evaluation"
  fi
  if ! has_flag "-v3-dataset-eval-out" "$@"; then
    set -- "$@" -v3-dataset-eval-out "$VM_OUT_ROOT/models_experiment/version3_dataset_evaluation"
  fi
  if ! has_flag "-v3-result-eval-out" "$@"; then
    set -- "$@" -v3-result-eval-out "$VM_OUT_ROOT/models_experiment/version3_result_evaluation"
  fi
  if ! has_flag "-v3-bench-out" "$@"; then
    set -- "$@" -v3-bench-out "$VM_OUT_ROOT/models_experiment/version3_scalability_benchmark"
  fi

  ensure_runtime_ready
  "${JAVA_BIN}" -cp "target/classes:target/dependency/*:lib/*" thesis.Thesis "$@"
}

apply_smoke() {
  local model_count="${1:-${V3_APPLY_MODEL_COUNT:-3500}}"
  local seed="${2:-${V3_APPLY_SEED:-20260311}}"
  local maybe_resume="${3:-}"

  local args=(-config v3_apply_smoke -v3-apply-model-count "$model_count" -v3-apply-seed "$seed")
  if [ "$maybe_resume" = "--resume" ] || [ "${V3_RESUME:-0}" = "1" ]; then
    args+=(-v3-resume)
  fi

  run_thesis "${args[@]}"
}

dataset_eval() {
  local maybe_resume="${1:-}"
  local resume_flag=()
  if [ "$maybe_resume" = "--resume" ] || [ "${V3_RESUME:-0}" = "1" ]; then
    resume_flag=(-v3-resume)
  fi

  local apply_out="$VM_OUT_ROOT/models_experiment/version3_apply_smoke"
  local dataset_out="$VM_OUT_ROOT/models_experiment/version3_dataset_evaluation"

  run_thesis \
    -config v3_dataset_eval \
    -v3-dataset-eval-in "$apply_out" \
    -v3-dataset-eval-out "$dataset_out" \
    "${resume_flag[@]}"
}

result_eval() {
  local apply_out="$VM_OUT_ROOT/models_experiment/version3_apply_smoke"
  local result_out="$VM_OUT_ROOT/models_experiment/version3_result_evaluation"

  run_thesis \
    -config v3_result_eval \
    -v3-result-eval-in "$apply_out" \
    -v3-result-eval-out "$result_out" \
    -v3-result-eval-resume
}

plot_dataset_eval() {
  local dataset_dir="${1:-$VM_OUT_ROOT/models_experiment/version3_dataset_evaluation}"
  local out_dir="${2:-$dataset_dir/plots}"
  "$PYTHON_BIN" ./src/thesis/evaluation/version3/dataset_evaluation/python/main.py \
    --in "$dataset_dir" \
    --out "$out_dir"
}

plot_result_eval() {
  local result_dir="${1:-$VM_OUT_ROOT/models_experiment/version3_result_evaluation}"
  local out_dir="${2:-$result_dir/plots}"
  "$PYTHON_BIN" ./src/thesis/evaluation/version3/result_evaluation/python/main.py \
    --in "$result_dir" \
    --out "$out_dir"
}

full_pipeline() {
  local model_count="${1:-${V3_APPLY_MODEL_COUNT:-3500}}"
  local seed="${2:-${V3_APPLY_SEED:-20260311}}"
  local maybe_resume="${3:-}"

  echo "[vm-repro] Step 1/4: apply smoke (count=${model_count}, seed=${seed})"
  apply_smoke "$model_count" "$seed" "$maybe_resume"

  echo "[vm-repro] Step 2/4: dataset evaluation"
  dataset_eval "$maybe_resume"

  echo "[vm-repro] Step 3/4: result evaluation"
  result_eval

  echo "[vm-repro] Step 4/4: plotting (python)"
  if ! plot_dataset_eval; then
    echo "[vm-repro] WARN: dataset plots failed."
  fi
  if ! plot_result_eval; then
    echo "[vm-repro] WARN: result plots failed."
  fi

  echo "[vm-repro] Full pipeline finished."
}

cmd="${1:-help}"
shift || true

case "$cmd" in
  help)
    usage
    ;;
  setup-fedora)
    exec ./scripts/vm/setup_fedora.sh "$@"
    ;;
  build)
    ensure_runtime_ready
    ;;
  smoke)
    run_thesis -config v3_smoke -v3-count 5 -v3-seed 20260309
    ;;
  apply-smoke)
    apply_smoke "$@"
    ;;
  dataset-eval)
    dataset_eval "$@"
    ;;
  result-eval)
    result_eval "$@"
    ;;
  full-pipeline)
    full_pipeline "$@"
    ;;
  plot-dataset-eval)
    plot_dataset_eval "$@"
    ;;
  plot-result-eval)
    plot_result_eval "$@"
    ;;
  run-thesis)
    run_thesis "$@"
    ;;
  plot-python)
    if ! has_flag "--out" "$@"; then
      set -- "$@" --out "$VM_OUT_ROOT/plots_python"
    fi
    "$PYTHON_BIN" ./src/python/plot_results.py "$@"
    ;;
  plot-r)
    if ! has_flag "--out" "$@"; then
      set -- "$@" --out "$VM_OUT_ROOT/plots_r"
    fi
    Rscript ./src/R/plot_results.R "$@"
    ;;
  shell)
    exec bash
    ;;
  *)
    echo "Unknown command: $cmd" >&2
    usage
    exit 2
    ;;
esac
