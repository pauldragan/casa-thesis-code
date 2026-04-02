package thesis.evaluation.version3.dataset_evaluation;

import java.nio.file.Path;

final class ManagedElementDatasetEvaluationConfig {
    final Path meRunRoot;
    final Path outputRoot;

    ManagedElementDatasetEvaluationConfig(Path meRunRoot, Path outputRoot) {
        this.meRunRoot = meRunRoot;
        this.outputRoot = outputRoot;
    }
}
