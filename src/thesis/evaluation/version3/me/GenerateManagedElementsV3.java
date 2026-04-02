package thesis.evaluation.version3.me;

import java.nio.file.Path;

public final class GenerateManagedElementsV3 {

    private GenerateManagedElementsV3() {
    }

    public static void runSmoke(int count, long seed, String outPath) throws Exception {
        run(count, seed, outPath, true, false);
    }

    public static void run(
            int count,
            long seed,
            String outPath,
            boolean exportGraphMl) throws Exception {
        run(count, seed, outPath, true, exportGraphMl, true, false);
    }

    public static void run(
            int count,
            long seed,
            String outPath,
            boolean exportGraphMl,
            boolean tinyProfile) throws Exception {
        run(count, seed, outPath, true, exportGraphMl, true, tinyProfile);
    }

    public static void run(
            int count,
            long seed,
            String outPath,
            boolean exportXmi,
            boolean exportGraphMl,
            boolean enablePruning) throws Exception {
        run(count, seed, outPath, exportXmi, exportGraphMl, enablePruning, false);
    }

    public static void run(
            int count,
            long seed,
            String outPath,
            boolean exportXmi,
            boolean exportGraphMl,
            boolean enablePruning,
            boolean tinyProfile) throws Exception {
        run(count, seed, outPath, exportXmi, exportGraphMl, enablePruning, false, tinyProfile);
    }

    public static void run(
            int count,
            long seed,
            String outPath,
            boolean exportXmi,
            boolean exportGraphMl,
            boolean enablePruning,
            boolean resume,
            boolean tinyProfile) throws Exception {
        Path out = Path.of(outPath);
        GenerationConfig defaults = tinyProfile ? GenerationConfig.tiny(out) : GenerationConfig.defaults(out);
        GenerationConfig config = new GenerationConfig(
                seed,
                count,
                enablePruning,
                exportXmi,
                exportGraphMl,
                resume,
                out,
                defaults.catalog,
                defaults.ranges,
                defaults.profileName);

        new GenerationOrchestrator(config).run();
    }
}
