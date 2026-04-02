package thesis.evaluation.version3.dataset_evaluation;

import java.nio.file.Path;

final class SelfAdaptationDatasetEvaluationConfig {
    final Path saRunRoot;
    final Path outputRoot;

    SelfAdaptationDatasetEvaluationConfig(Path saRunRoot, Path outputRoot) {
        this.saRunRoot = saRunRoot;
        this.outputRoot = outputRoot;
    }
}
