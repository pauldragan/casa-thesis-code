package thesis.evaluation.version3.result_evaluation;

import java.nio.file.Path;

final class ResultEvaluationConfig {
    final Path applyRunRoot;
    final Path outRoot;
    final long baseSeed;
    final boolean pruneSourceModels;
    final boolean tinyProfile;
    final boolean resume;

    ResultEvaluationConfig(
            Path applyRunRoot,
            Path outRoot,
            long baseSeed,
            boolean pruneSourceModels,
            boolean tinyProfile,
            boolean resume) {
        this.applyRunRoot = applyRunRoot;
        this.outRoot = outRoot;
        this.baseSeed = baseSeed;
        this.pruneSourceModels = pruneSourceModels;
        this.tinyProfile = tinyProfile;
        this.resume = resume;
    }
}
