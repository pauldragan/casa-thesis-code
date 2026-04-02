package thesis.evaluation.version3.me;

import java.nio.file.Path;

public final class GenerateManagedElementViewsV3 {
    private GenerateManagedElementViewsV3() {
    }

    public static ManagedElementView generateSingle(long seed, int modelIndex, boolean enablePruning) {
        return generateSingle(seed, modelIndex, enablePruning, false);
    }

    public static ManagedElementView generateSingle(long seed, int modelIndex, boolean enablePruning, boolean tinyProfile) {
        Path out = Path.of(".");
        GenerationConfig defaults = tinyProfile ? GenerationConfig.tiny(out) : GenerationConfig.defaults(out);
        GenerationConfig config = new GenerationConfig(
                seed,
                1,
                enablePruning,
                false,
                false,
                false,
                out,
                defaults.catalog,
                defaults.ranges,
                defaults.profileName);

        SpecSampler specSampler = new SpecSampler(config);
        ManagedElementInstantiator instantiator = new ManagedElementInstantiator(config);
        ManagedElementSpec spec = specSampler.sample(modelIndex, seed);
        ManagedElementInstance me = instantiator.instantiate(spec);
        if (enablePruning) {
            new RulePrunerV3().prune(me);
        }
        return ManagedElementViewExporter.export(me);
    }
}
