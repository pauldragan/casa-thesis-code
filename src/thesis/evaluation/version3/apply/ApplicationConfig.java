package thesis.evaluation.version3.apply;

import java.nio.file.Path;

final class ApplicationConfig {
    final long baseSeed;
    final int modelCount;
    final boolean pruneSourceModels;
    final Path runRoot;
    final Path meRoot;
    final Path saRoot;
    final Path applicationsRoot;

    ApplicationConfig(long baseSeed, int modelCount, boolean pruneSourceModels, Path runRoot) {
        this.baseSeed = baseSeed;
        this.modelCount = modelCount;
        this.pruneSourceModels = pruneSourceModels;
        this.runRoot = runRoot;
        this.meRoot = runRoot.resolve("managed_elements");
        this.saRoot = runRoot.resolve("self_adaptations");
        this.applicationsRoot = runRoot.resolve("applications");
    }
}
