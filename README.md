# VM Execution Pipeline

This guide supports two workflows in the provided Fedora VM:

1. run the **full evaluation pipeline** (generate data + evaluate + plots/tables)
2. **reproduce plots/tables** from already provided experimental data

## Obtaining the VM

The VM can be downloaded from [here](https://uni-duisburg-essen.sciebo.de/s/QEF7MyWDzwJDCAA), from the `virtual-machine` folder, using password: `7LF6wLS4dY`.

The VM is split into 100MB parts. On Linux, after downloading all files in `virtual-machine`, run:

```bash
./merge_parts.sh
```

This creates `Thesis_VM.ova`. Import it into VirtualBox.

## Common Prerequisites (Both Workflows)

- Project available in VM at `.../code` (already present in provided VM)
- JDK at `/home/thesis/java/jdk-17.0.2` (already present in provided VM)
- Shared data folder mounted at `/home/thesis/data` (**must be mounted manually**)
- At least **300 GB free space** on mounted storage

Mount command:

```bash
VB_SHARE_NAME="thesis"        # Shared-folder name configured in VirtualBox
VM_USER="thesis"              # Linux user inside the VM
MOUNT_POINT="/home/$VM_USER/data"

sudo mkdir -p "$MOUNT_POINT"
sudo mount -t vboxsf \
  -o rw,uid=$(id -u "$VM_USER"),gid=$(id -g "$VM_USER"),dmode=0775,fmode=0664 \
  "$VB_SHARE_NAME" \
  "$MOUNT_POINT"
```

Check free space:

```bash
df -h /home/thesis/data
```

## Workflow A: Run Full Pipeline

This recomputes everything from scratch.

Optional setup (usually already done in provided VM):

```bash
cd code
./scripts/vm/setup_fedora.sh
```

Run:

```bash
cd code
./scripts/vm/runner.sh full-pipeline 3500 20260311 --resume
```

- `3500` = number of generated managed elements
- `20260311` = RNG seed

Default output root:

`/home/thesis/data/results`

Main output directories:
- `/home/thesis/data/results/models_experiment/version3_apply_smoke`
- `/home/thesis/data/results/models_experiment/version3_dataset_evaluation`
- `/home/thesis/data/results/models_experiment/version3_result_evaluation`

## Workflow B: Reproduce Plots/Tables from Provided Data

### 1. Obtain Experimental Data

Download from:
- URL: https://uni-duisburg-essen.sciebo.de/s/QEF7MyWDzwJDCAA
- Folder: `experimental-data`
- Password: `7LF6wLS4dY`

The data is split into 100MB parts. After downloading all files, run:

```bash
./merge-parts-and-extract.sh
```

Where to run download/extract:

- **Recommended:** download and extract on the host into the VirtualBox shared folder `thesis`, so files are immediately visible in VM at `/home/thesis/data`.
- **Alternative:** download and extract directly inside the VM, for example under `/home/thesis/data`.

Expected path inside the VM after extraction:

`/home/thesis/data/experimental-data/models_experiment`

### 2. Regenerate Plots

From `code/`:

```bash
./scripts/vm/runner.sh plot-dataset-eval \
  /home/thesis/data/experimental-data/models_experiment/version3_dataset_evaluation \
  /home/thesis/data/experimental-data/models_experiment/version3_dataset_evaluation/plots

./scripts/vm/runner.sh plot-result-eval \
  /home/thesis/data/experimental-data/models_experiment/version3_result_evaluation \
  /home/thesis/data/experimental-data/models_experiment/version3_result_evaluation/plots
```

## Help

```bash
cd code
./scripts/vm/runner.sh help
```
