package thesis.evaluation.version3.dataset_evaluation;

import java.nio.file.Path;

public final class GenerateManagedElementDatasetEvaluationV3 {
    private GenerateManagedElementDatasetEvaluationV3() {
    }

    public static void run(String meRunRoot, String outRoot) throws Exception {
        ManagedElementDatasetEvaluationConfig config = new ManagedElementDatasetEvaluationConfig(
                Path.of(meRunRoot),
                Path.of(outRoot));
        new ManagedElementDatasetEvaluatorV3(config).run();
    }
}
