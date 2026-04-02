package thesis.evaluation.version3.dataset_evaluation;

import java.nio.file.Path;

public final class GenerateSelfAdaptationDatasetEvaluationV3 {
    private GenerateSelfAdaptationDatasetEvaluationV3() {
    }

    public static void run(String saRunRoot, String outRoot) throws Exception {
        SelfAdaptationDatasetEvaluationConfig config = new SelfAdaptationDatasetEvaluationConfig(
                Path.of(saRunRoot),
                Path.of(outRoot));
        new SelfAdaptationDatasetEvaluatorV3(config).run();
    }
}
