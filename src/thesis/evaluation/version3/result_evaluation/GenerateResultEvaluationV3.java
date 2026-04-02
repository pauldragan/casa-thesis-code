package thesis.evaluation.version3.result_evaluation;

import java.nio.file.Path;

public final class GenerateResultEvaluationV3 {
    private GenerateResultEvaluationV3() {
    }

    public static void run(String applyRunRoot, String outRoot) throws Exception {
        run(applyRunRoot, outRoot, false);
    }

    public static void run(String applyRunRoot, String outRoot, boolean resume) throws Exception {
        new ResultEvaluationRunnerV3().run(Path.of(applyRunRoot), Path.of(outRoot), resume);
    }
}
