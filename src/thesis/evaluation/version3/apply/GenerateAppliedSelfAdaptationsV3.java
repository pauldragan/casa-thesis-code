package thesis.evaluation.version3.apply;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thesis.evaluation.version3.me.GenerateManagedElementsV3;
import thesis.evaluation.version3.sa.GenerateSelfAdaptationsV3;

public final class GenerateAppliedSelfAdaptationsV3 {
    private static final Logger logger = LoggerFactory.getLogger(GenerateAppliedSelfAdaptationsV3.class);

    private GenerateAppliedSelfAdaptationsV3() {
    }

    public static void runSmoke(int modelCount, long seed, String outPath, boolean pruneSourceModels) throws Exception {
        runSmoke(modelCount, seed, outPath, pruneSourceModels, false);
    }

    public static void runSmoke(
            int modelCount,
            long seed,
            String outPath,
            boolean pruneSourceModels,
            boolean tinyProfile) throws Exception {
        runSmoke(modelCount, seed, outPath, pruneSourceModels, false, tinyProfile);
    }

    public static void runSmoke(
            int modelCount,
            long seed,
            String outPath,
            boolean pruneSourceModels,
            boolean resume,
            boolean tinyProfile) throws Exception {
        ApplicationConfig config = new ApplicationConfig(seed, modelCount, pruneSourceModels, Path.of(outPath));
        Files.createDirectories(config.runRoot);
        writeConfigSnapshot(config.runRoot.resolve("generation_config.json"), config, resume, tinyProfile);

        GenerateManagedElementsV3.run(
                modelCount,
                seed,
                config.meRoot.toString(),
                true,
                false,
                pruneSourceModels,
                resume,
                tinyProfile);
        GenerateSelfAdaptationsV3.runSmoke(modelCount, seed, config.saRoot.toString(), pruneSourceModels, resume, tinyProfile);

        List<ApplicationInput> inputs = buildInputs(config.meRoot.resolve("manifest.csv"),
                config.saRoot.resolve("self_adaptation_manifest.csv"));
        if (resume) {
            inputs = filterAlreadyApplied(config.runRoot.resolve("application_manifest.csv"), inputs);
        }
        logger.info("v3 apply: applying {} accepted self-adaptations", inputs.size());

        TransformationApplicatorV3 applicator = new TransformationApplicatorV3();
        try (ApplicationManifestWriterV3 manifest = new ApplicationManifestWriterV3(
                config.runRoot.resolve("application_manifest.csv"),
                resume)) {
            for (ApplicationInput input : inputs) {
                logger.info(
                        "v3 apply: modelIndex={} adaptationIndex={} adaptationId={} caseSlug={}",
                        input.modelIndex(),
                        input.adaptationIndex(),
                        input.adaptationId(),
                        input.caseSlug());
                Path outXmi = config.applicationsRoot
                        .resolve(String.format("model_%06d", input.modelIndex()))
                        .resolve(input.adaptationId() + ".xmi");
                ApplicationResult result = applicator.apply(input, outXmi);
                manifest.append(result);
            }
        }
        logger.info("v3 apply: completed application run");
    }

    private static List<ApplicationInput> buildInputs(Path meManifest, Path saManifest) throws IOException {
        Map<Integer, Map<String, String>> meByModelIndex = new LinkedHashMap<>();
        for (Map<String, String> row : CsvTableV3.read(meManifest)) {
            meByModelIndex.put(Integer.parseInt(row.get("model_index")), row);
        }

        List<ApplicationInput> inputs = new ArrayList<>();
        for (Map<String, String> row : CsvTableV3.read(saManifest)) {
            if (!Boolean.parseBoolean(row.getOrDefault("validation_ok", "false"))) {
                continue;
            }
            int modelIndex = Integer.parseInt(row.get("model_index"));
            Map<String, String> meRow = meByModelIndex.get(modelIndex);
            if (meRow == null) {
                throw new IllegalStateException("Missing source ME manifest row for model_index=" + modelIndex);
            }
            inputs.add(new ApplicationInput(
                    modelIndex,
                    row.get("model_id"),
                    Integer.parseInt(row.get("adaptation_index")),
                    row.get("adaptation_id"),
                    row.get("case_slug"),
                    Path.of(meRow.get("xmi_path")),
                    Path.of(row.get("henshin_path")),
                    Integer.parseInt(row.get("added_functions")),
                    Integer.parseInt(row.get("removed_functions")),
                    Integer.parseInt(row.get("added_components")),
                    Integer.parseInt(row.get("removed_components"))));
        }
        return inputs;
    }

    private static List<ApplicationInput> filterAlreadyApplied(Path manifestPath, List<ApplicationInput> inputs) throws IOException {
        Map<String, ApplicationInput> pending = new LinkedHashMap<>();
        for (ApplicationInput input : inputs) {
            pending.put(key(input.modelIndex(), input.adaptationIndex()), input);
        }
        if (!Files.exists(manifestPath) || Files.size(manifestPath) == 0L) {
            return new ArrayList<>(pending.values());
        }
        for (Map<String, String> row : CsvTableV3.read(manifestPath)) {
            pending.remove(key(
                    Integer.parseInt(row.get("model_index")),
                    Integer.parseInt(row.get("adaptation_index"))));
        }
        return new ArrayList<>(pending.values());
    }

    private static String key(int modelIndex, int adaptationIndex) {
        return modelIndex + ":" + adaptationIndex;
    }

    private static void writeConfigSnapshot(Path configPath, ApplicationConfig config, boolean resume, boolean tinyProfile) throws IOException {
        String json = """
                {
                  "note": "apply self-adaptations smoke run",
                  "baseSeed": %d,
                  "modelCount": %d,
                  "caseCountPerModel": 63,
                  "pruneSourceModels": %s,
                  "resume": %s,
                  "profile": "%s"
                }
                """.formatted(
                config.baseSeed,
                config.modelCount,
                String.valueOf(config.pruneSourceModels),
                String.valueOf(resume),
                tinyProfile ? "tiny" : "default");
        Files.writeString(configPath, json, StandardCharsets.UTF_8);
    }
}
