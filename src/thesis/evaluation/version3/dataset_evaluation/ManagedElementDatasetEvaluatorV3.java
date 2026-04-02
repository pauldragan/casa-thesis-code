package thesis.evaluation.version3.dataset_evaluation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public final class ManagedElementDatasetEvaluatorV3 {
    private static final Map<String, int[]> PERSONAL_DATA_TARGETS = Map.ofEntries(
            Map.entry("PDUsername", new int[] {1, 5}),
            Map.entry("PDPassword", new int[] {1, 5}),
            Map.entry("PDEmail", new int[] {1, 5}),
            Map.entry("PDPaymentDetails", new int[] {0, 5}),
            Map.entry("PDTrackingCookie", new int[] {0, 5}),
            Map.entry("PDStreamingHistory", new int[] {0, 5}),
            Map.entry("PDUploadedVideo", new int[] {0, 5}),
            Map.entry("PDComment", new int[] {0, 5}),
            Map.entry("PDVideoMetadata", new int[] {0, 5}),
            Map.entry("PDDeviceType", new int[] {0, 5}),
            Map.entry("PDDeviceLocation", new int[] {0, 5}),
            Map.entry("PDRequestTimestamp", new int[] {0, 5}));

    private final ManagedElementDatasetEvaluationConfig config;
    private final ManagedElementArtifactEvaluatorV3 artifactEvaluator;

    public ManagedElementDatasetEvaluatorV3(ManagedElementDatasetEvaluationConfig config) {
        this.config = config;
        this.artifactEvaluator = new ManagedElementArtifactEvaluatorV3();
    }

    public void run() throws IOException {
        Files.createDirectories(config.outputRoot);
        Path manifestPath = config.meRunRoot.resolve("manifest.csv");
        List<Map<String, String>> manifestRows = CsvTableV3.read(manifestPath);
        List<ManagedElementArtifactMetrics> metrics = new ArrayList<>();
        for (Map<String, String> row : manifestRows) {
            if (row.get("xmi_path") == null || row.get("xmi_path").isBlank()) {
                continue;
            }
            Path xmiPath = resolveArtifactPath(manifestPath, row.get("xmi_path"));
            metrics.add(artifactEvaluator.evaluate(
                    Integer.parseInt(row.get("model_index")),
                    row.get("model_id"),
                    xmiPath));
        }
        writeModelSummary(metrics);
        writeConvergenceInstances(metrics);
        writeConvergenceRelations(metrics);
        writeTypeTables(metrics);
        writeRelationTable(metrics);
        writeAllRelationCounts(metrics);
        writeAllRelationSummary(metrics);
        writePersonalDataPerDataSubjectValues(metrics);
        writeRelationMultiplicityValues(metrics);
    }

    private void writeModelSummary(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        Path out = config.outputRoot.resolve("me_summary.csv");
        Set<String> types = allTypes(metrics);
        List<String> personalDataTypes = personalDataTypes(metrics);
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            List<String> header = new ArrayList<>(List.of(
                    "model_index", "model_id", "xmi_path", "total_instances", "total_relations", "connectivity",
                    "realizes_total", "realizes_min", "realizes_avg", "realizes_max",
                    "processes_total", "processes_min", "processes_avg", "processes_max",
                    "hasPurpose_total", "hasPurpose_min", "hasPurpose_avg", "hasPurpose_max",
                    "affectedBy_total", "affectedBy_min", "affectedBy_avg", "affectedBy_max"));
            types.forEach(t -> header.add("count_" + t));
            for (String type : personalDataTypes) {
                header.add("pd_ds_min_" + type);
                header.add("pd_ds_avg_" + type);
                header.add("pd_ds_max_" + type);
            }
            w.write(String.join(",", header));
            w.newLine();
            for (ManagedElementArtifactMetrics m : metrics) {
                List<String> row = new ArrayList<>();
                row.add(String.valueOf(m.modelIndex));
                row.add(csv(m.modelId));
                row.add(csv(m.xmiPath));
                row.add(String.valueOf(m.totalInstances));
                row.add(String.valueOf(m.totalRelations));
                row.add(fmt(m.connectivity));
                row.add(String.valueOf(m.realizesTotal));
                row.add(String.valueOf(m.realizesMin));
                row.add(fmt(m.realizesAvg));
                row.add(String.valueOf(m.realizesMax));
                row.add(String.valueOf(m.processesTotal));
                row.add(String.valueOf(m.processesMin));
                row.add(fmt(m.processesAvg));
                row.add(String.valueOf(m.processesMax));
                row.add(String.valueOf(m.hasPurposeTotal));
                row.add(String.valueOf(m.hasPurposeMin));
                row.add(fmt(m.hasPurposeAvg));
                row.add(String.valueOf(m.hasPurposeMax));
                row.add(String.valueOf(m.affectedByTotal));
                row.add(String.valueOf(m.affectedByMin));
                row.add(fmt(m.affectedByAvg));
                row.add(String.valueOf(m.affectedByMax));
                for (String type : types) {
                    row.add(String.valueOf(m.countByType.getOrDefault(type, 0)));
                }
                for (String type : personalDataTypes) {
                    List<Integer> values = m.personalDataCountsPerDataSubjectByType.getOrDefault(type, List.of());
                    row.add(String.valueOf(min(values)));
                    row.add(fmt(avg(values)));
                    row.add(String.valueOf(max(values)));
                }
                w.write(String.join(",", row));
                w.newLine();
            }
        }
    }

    private void writeConvergenceInstances(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        Path out = config.outputRoot.resolve("me_convergence_instances.csv");
        Set<String> types = allTypes(metrics);
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("generated_models,type,min_count,avg_count,max_count");
            w.newLine();
            Map<String, List<Integer>> prefix = new LinkedHashMap<>();
            for (ManagedElementArtifactMetrics m : metrics) {
                for (String type : types) {
                    prefix.computeIfAbsent(type, k -> new ArrayList<>()).add(m.countByType.getOrDefault(type, 0));
                }
                int generated = m.modelIndex + 1;
                for (String type : types) {
                    List<Integer> values = prefix.get(type);
                    w.write(String.join(",",
                            String.valueOf(generated),
                            type,
                            String.valueOf(min(values)),
                            fmt(avg(values)),
                            String.valueOf(max(values))));
                    w.newLine();
                }
            }
        }
    }

    private void writeConvergenceRelations(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        Path out = config.outputRoot.resolve("me_convergence_relations.csv");
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("generated_models,relation_type,min_per_owner,avg_per_owner,max_per_owner");
            w.newLine();
            List<Double> realizesAvg = new ArrayList<>();
            List<Integer> realizesMin = new ArrayList<>();
            List<Integer> realizesMax = new ArrayList<>();
            List<Double> processesAvg = new ArrayList<>();
            List<Integer> processesMin = new ArrayList<>();
            List<Integer> processesMax = new ArrayList<>();
            List<Double> hasAvg = new ArrayList<>();
            List<Integer> hasMin = new ArrayList<>();
            List<Integer> hasMax = new ArrayList<>();
            List<Double> affectedByAvg = new ArrayList<>();
            List<Integer> affectedByMin = new ArrayList<>();
            List<Integer> affectedByMax = new ArrayList<>();
            for (ManagedElementArtifactMetrics m : metrics) {
                realizesAvg.add(m.realizesAvg);
                realizesMin.add(m.realizesMin);
                realizesMax.add(m.realizesMax);
                processesAvg.add(m.processesAvg);
                processesMin.add(m.processesMin);
                processesMax.add(m.processesMax);
                hasAvg.add(m.hasPurposeAvg);
                hasMin.add(m.hasPurposeMin);
                hasMax.add(m.hasPurposeMax);
                affectedByAvg.add(m.affectedByAvg);
                affectedByMin.add(m.affectedByMin);
                affectedByMax.add(m.affectedByMax);
                int generated = m.modelIndex + 1;
                writeRelationRow(w, generated, "realizes", realizesMin, realizesAvg, realizesMax);
                writeRelationRow(w, generated, "processes", processesMin, processesAvg, processesMax);
                writeRelationRow(w, generated, "hasPurpose", hasMin, hasAvg, hasMax);
                writeRelationRow(w, generated, "affectedBy", affectedByMin, affectedByAvg, affectedByMax);
            }
        }
    }

    private void writeTypeTables(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        writeTypeTable(metrics, config.outputRoot.resolve("table_instances_datasubjects.csv"), List.of("DSUser", "DSModerator", "DSAdministrator"));
        writeTypeTable(metrics, config.outputRoot.resolve("table_instances_functions.csv"), List.of(
                "FUploadVideo", "FStreamVideo", "FRemoveVideo", "FComments", "FLiveStreamVideo",
                "FP2PStreaming", "FRecommendVideos", "FServeStandardAds", "FServeLocationTargetedAds", "FServeBehaviorTargetedAds"));
        writeTypeTable(metrics, config.outputRoot.resolve("table_instances_components.csv"), List.of(
                "CNginx", "CExpressJS", "CPostgresql", "CAngularSPA", "CRedis", "CFilesystem"));
        writePersonalDataTypeTable(metrics, config.outputRoot.resolve("table_instances_personaldata.csv"), List.of(
                "PDUsername", "PDPassword", "PDEmail", "PDPaymentDetails", "PDTrackingCookie", "PDStreamingHistory",
                "PDUploadedVideo", "PDComment", "PDVideoMetadata", "PDDeviceType", "PDDeviceLocation", "PDRequestTimestamp"));
    }

    private void writeRelationTable(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        Path out = config.outputRoot.resolve("table_relations_types.csv");
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("relation_type,min_per_owner,avg_per_owner,max_per_owner");
            w.newLine();
            writeFinalRelationSummary(w, metrics, "realizes");
            writeFinalRelationSummary(w, metrics, "processes");
            writeFinalRelationSummary(w, metrics, "hasPurpose");
            writeFinalRelationSummary(w, metrics, "affectedBy");
        }
    }

    private void writeAllRelationCounts(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        Path out = config.outputRoot.resolve("me_relations_all_types_by_model.csv");
        Set<String> relationTypes = allRelationTypes(metrics);
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("model_index,model_id,relation_type,count");
            w.newLine();
            for (ManagedElementArtifactMetrics m : metrics) {
                for (String relationType : relationTypes) {
                    w.write(String.join(",",
                            String.valueOf(m.modelIndex),
                            csv(m.modelId),
                            relationType,
                            String.valueOf(m.relationCountByType.getOrDefault(relationType, 0))));
                    w.newLine();
                }
            }
        }
    }

    private void writeAllRelationSummary(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        Path out = config.outputRoot.resolve("table_relations_all_types.csv");
        Set<String> relationTypes = allRelationTypes(metrics);
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("relation_type,models_with_relation,min_count,avg_count,max_count");
            w.newLine();
            for (String relationType : relationTypes) {
                List<Integer> values = new ArrayList<>();
                int modelsWithRelation = 0;
                for (ManagedElementArtifactMetrics m : metrics) {
                    int value = m.relationCountByType.getOrDefault(relationType, 0);
                    values.add(value);
                    if (value > 0) {
                        modelsWithRelation++;
                    }
                }
                w.write(String.join(",",
                        relationType,
                        String.valueOf(modelsWithRelation),
                        String.valueOf(min(values)),
                        fmt(avg(values)),
                        String.valueOf(max(values))));
                w.newLine();
            }
        }
    }

    private void writePersonalDataPerDataSubjectValues(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        Path out = config.outputRoot.resolve("me_personaldata_per_datasubject_values.csv");
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("model_index,model_id,type,count");
            w.newLine();
            for (ManagedElementArtifactMetrics m : metrics) {
                for (Map.Entry<String, List<Integer>> entry : m.personalDataCountsPerDataSubjectByType.entrySet()) {
                    for (Integer value : entry.getValue()) {
                        w.write(String.join(",",
                                String.valueOf(m.modelIndex),
                                csv(m.modelId),
                                entry.getKey(),
                                String.valueOf(value)));
                        w.newLine();
                    }
                }
            }
        }
    }

    private void writeRelationMultiplicityValues(List<ManagedElementArtifactMetrics> metrics) throws IOException {
        Path out = config.outputRoot.resolve("me_relation_multiplicities_per_function.csv");
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("model_index,model_id,relation_type,count");
            w.newLine();
            for (ManagedElementArtifactMetrics m : metrics) {
                for (Map.Entry<String, List<Integer>> entry : m.relationValuesPerFunctionByType.entrySet()) {
                    for (Integer value : entry.getValue()) {
                        w.write(String.join(",",
                                String.valueOf(m.modelIndex),
                                csv(m.modelId),
                                entry.getKey(),
                                String.valueOf(value)));
                        w.newLine();
                    }
                }
            }
        }
    }

    private void writeTypeTable(List<ManagedElementArtifactMetrics> metrics, Path out, List<String> types) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("type,models_with_type,min_count,avg_count,max_count");
            w.newLine();
            for (String type : types) {
                List<Integer> values = new ArrayList<>();
                int modelsWithType = 0;
                for (ManagedElementArtifactMetrics m : metrics) {
                    int value = m.countByType.getOrDefault(type, 0);
                    values.add(value);
                    if (value > 0) {
                        modelsWithType++;
                    }
                }
                w.write(String.join(",",
                        type,
                        String.valueOf(modelsWithType),
                        String.valueOf(min(values)),
                        fmt(avg(values)),
                        String.valueOf(max(values))));
                w.newLine();
            }
        }
    }

    private void writePersonalDataTypeTable(List<ManagedElementArtifactMetrics> metrics, Path out, List<String> types) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("type,models_with_type,min_count_per_model,avg_count_per_model,max_count_per_model,configured_range_per_datasubject,observed_range_per_datasubject,covered_values_per_datasubject,coverage_pct_per_datasubject,avg_count_per_datasubject");
            w.newLine();
            for (String type : types) {
                List<Integer> perModelValues = new ArrayList<>();
                List<Integer> perDataSubjectValues = new ArrayList<>();
                int modelsWithType = 0;
                for (ManagedElementArtifactMetrics m : metrics) {
                    int value = m.countByType.getOrDefault(type, 0);
                    perModelValues.add(value);
                    if (value > 0) {
                        modelsWithType++;
                    }
                    perDataSubjectValues.addAll(m.personalDataCountsPerDataSubjectByType.getOrDefault(type, List.of()));
                }
                int[] configuredRange = PERSONAL_DATA_TARGETS.getOrDefault(type, new int[] {0, 0});
                int observedMinPerDs = min(perDataSubjectValues);
                int observedMaxPerDs = max(perDataSubjectValues);
                int coveredValuesPerDs = distinctCount(perDataSubjectValues);
                int configuredValuesPerDs = Math.max(1, configuredRange[1] - configuredRange[0] + 1);
                double coveragePctPerDs = (100.0 * coveredValuesPerDs) / configuredValuesPerDs;
                w.write(String.join(",",
                        type,
                        String.valueOf(modelsWithType),
                        String.valueOf(min(perModelValues)),
                        fmt(avg(perModelValues)),
                        String.valueOf(max(perModelValues)),
                        configuredRange[0] + "-" + configuredRange[1],
                        observedMinPerDs + "-" + observedMaxPerDs,
                        String.valueOf(coveredValuesPerDs),
                        fmt(coveragePctPerDs),
                        fmt(avg(perDataSubjectValues))));
                w.newLine();
            }
        }
    }

    private static void writeRelationRow(BufferedWriter w, int generated, String relationType,
            List<Integer> mins, List<Double> avgs, List<Integer> maxs) throws IOException {
        w.write(String.join(",",
                String.valueOf(generated),
                relationType,
                String.valueOf(min(mins)),
                fmt(avgD(avgs)),
                String.valueOf(max(maxs))));
        w.newLine();
    }

    private static void writeFinalRelationSummary(BufferedWriter w, List<ManagedElementArtifactMetrics> metrics, String relationType)
            throws IOException {
        List<Integer> mins = new ArrayList<>();
        List<Double> avgs = new ArrayList<>();
        List<Integer> maxs = new ArrayList<>();
        for (ManagedElementArtifactMetrics m : metrics) {
            switch (relationType) {
                case "realizes" -> {
                    mins.add(m.realizesMin);
                    avgs.add(m.realizesAvg);
                    maxs.add(m.realizesMax);
                }
                case "processes" -> {
                    mins.add(m.processesMin);
                    avgs.add(m.processesAvg);
                    maxs.add(m.processesMax);
                }
                case "hasPurpose" -> {
                    mins.add(m.hasPurposeMin);
                    avgs.add(m.hasPurposeAvg);
                    maxs.add(m.hasPurposeMax);
                }
                case "affectedBy" -> {
                    mins.add(m.affectedByMin);
                    avgs.add(m.affectedByAvg);
                    maxs.add(m.affectedByMax);
                }
                default -> throw new IllegalArgumentException("Unknown relation type: " + relationType);
            }
        }
        w.write(String.join(",",
                relationType,
                String.valueOf(min(mins)),
                fmt(avgD(avgs)),
                String.valueOf(max(maxs))));
        w.newLine();
    }

    private static Set<String> allTypes(List<ManagedElementArtifactMetrics> metrics) {
        Set<String> types = new LinkedHashSet<>();
        for (ManagedElementArtifactMetrics m : metrics) {
            types.addAll(m.countByType.keySet());
        }
        return types;
    }

    private static List<String> personalDataTypes(List<ManagedElementArtifactMetrics> metrics) {
        List<String> types = new ArrayList<>();
        for (String type : allTypes(metrics)) {
            if (type.startsWith("PD")) {
                types.add(type);
            }
        }
        return types;
    }

    private static Set<String> allRelationTypes(List<ManagedElementArtifactMetrics> metrics) {
        Set<String> types = new LinkedHashSet<>();
        for (ManagedElementArtifactMetrics m : metrics) {
            types.addAll(m.relationCountByType.keySet());
        }
        return types;
    }

    private Path resolveArtifactPath(Path manifestPath, String rawPath) {
        Path path = Path.of(rawPath);
        if (path.isAbsolute()) {
            return path;
        }
        Path resolvedAgainstManifest = manifestPath.getParent().resolve(path).normalize();
        if (Files.exists(resolvedAgainstManifest)) {
            return resolvedAgainstManifest;
        }
        Path probeBase = config.meRunRoot;
        while (probeBase != null) {
            Path candidate = probeBase.resolve(path).normalize();
            if (Files.exists(candidate)) {
                return candidate;
            }
            probeBase = probeBase.getParent();
        }
        return path.normalize();
    }

    private static int min(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).min().orElse(0);
    }

    private static int max(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).max().orElse(0);
    }

    private static int distinctCount(List<Integer> values) {
        return new LinkedHashSet<>(values).size();
    }

    private static double avg(List<Integer> values) {
        return values.stream().mapToInt(Integer::intValue).average().orElse(0.0);
    }

    private static double avgD(List<Double> values) {
        return values.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    private static String fmt(double value) {
        return String.format(Locale.ROOT, "%.8f", value);
    }

    private static String csv(String value) {
        String v = value == null ? "" : value;
        if (v.contains(",") || v.contains("\"") || v.contains("\n")) {
            return "\"" + v.replace("\"", "\"\"") + "\"";
        }
        return v;
    }
}
