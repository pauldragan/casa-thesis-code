# VM Execution Pipeline

This guide is for running thesis experiments directly in a Fedora VM.

## 1. Prerequisites

- Project available in VM at `.../code`
- JDK available at `/home/thesis/java/jdk-17.0.2`
- Data folder mounted in VM at `/home/thesis/data`
- Writable output directory at `/home/thesis/data/results`
- At least **300 GB free space** available on mounted data storage

Mount command (explicit variables to avoid ambiguity):

```bash
VB_SHARE_NAME="thesis"        # Name of the shared folder configured in VirtualBox
VM_USER="thesis"              # Linux user inside the VM
MOUNT_POINT="/home/$VM_USER/data"

sudo mkdir -p "$MOUNT_POINT"
sudo mount -t vboxsf \
  -o rw,uid=$(id -u "$VM_USER"),gid=$(id -g "$VM_USER"),dmode=0775,fmode=0664 \
  "$VB_SHARE_NAME" \
  "$MOUNT_POINT"
```

## 2. Setup (one-time, provided VM is already set up)

From `code/`:

```bash
./scripts/vm/setup_fedora.sh
```

What it does:
- installs system prerequisites (Maven, Python, R, build deps)
- creates `.venv` (with `--system-site-packages`)
- installs Python packages for plotting
- installs required R packages in your user R library

## 3. Run Full Pipeline

From `code/`:

```bash
./scripts/vm/runner.sh full-pipeline 3500 20260311 --resume
```
where 3500 is the number of generated managed elements and 20260311 is the seed
used for the random number generator.

To execute the pipeline on a smaller scale, it is sufficient to reduce
the number of managed elements from 3500 to something lower (e.g., 10).

Pipeline stages:
1. generates managed elements and self-adaptations
2. applies self-adaptations to obtain prospective managed element models
3. applies CASA to obtain the consent violation check results
4. evaluates the generated dataset
5. evaluates the results of CASA
6. summarizes relevant metrics, generates tables and plots 

## 4. Output Location

Default root:

`/home/thesis/data/results`

Main directories:
- `/home/thesis/data/results/models_experiment/version3_apply_smoke`
- `/home/thesis/data/results/models_experiment/version3_dataset_evaluation`
- `/home/thesis/data/results/models_experiment/version3_result_evaluation`

Override root for one run:

```bash
VM_OUT_ROOT=/some/other/path ./scripts/vm/runner.sh full-pipeline
```

## 5. Useful Single Commands

```bash
./scripts/vm/runner.sh help
```
