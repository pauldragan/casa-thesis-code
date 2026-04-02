package thesis.evaluation.version3.benchmark;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Random;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CASA.CASAPackage;
import thesis.CASAOfflineConsentAnalyzer;
import thesis.CASAPurpose;
import thesis.CASARisk;

public final class GenerateScalabilityBenchmarkV3 {
    private static final Logger logger = LoggerFactory.getLogger(GenerateScalabilityBenchmarkV3.class);

    private static final String V3_PURPOSE_ONTOLOGY_PATH = "src/resources/casa-v3-eval-purpose-model.owx";
    private static final double V3_RISK_CONSENT_THRESHOLD = 0.000001d;

    private static final String CASE_FUNCTIONS = "afs_afp";
    private static final String CASE_COMPONENTS = "acs_acr";

    private GenerateScalabilityBenchmarkV3() {
    }

    public static void run(
            String applyRunRoot,
            String outRoot,
            int requestedModelCount,
            long sampleSeed,
            int warmupIterations,
            int repetitions) throws Exception {
        if (requestedModelCount <= 0) {
            throw new IllegalArgumentException("requestedModelCount must be > 0");
        }
        if (warmupIterations < 0) {
            throw new IllegalArgumentException("warmupIterations must be >= 0");
        }
        if (repetitions <= 0) {
            throw new IllegalArgumentException("repetitions must be > 0");
        }

        Path runRoot = Path.of(applyRunRoot);
        Path meManifest = runRoot.resolve("managed_elements").resolve("manifest.csv");
        Path saManifest = runRoot.resolve("self_adaptations").resolve("self_adaptation_manifest.csv");
        Path appManifest = runRoot.resolve("application_manifest.csv");
        if (!Files.exists(meManifest)) {
            throw new IllegalStateException("Missing managed-element manifest: " + meManifest);
        }
        if (!Files.exists(saManifest)) {
            throw new IllegalStateException("Missing self-adaptation manifest: " + saManifest);
        }
        if (!Files.exists(appManifest)) {
            throw new IllegalStateException("Missing application manifest: " + appManifest);
        }

        Path out = Path.of(outRoot);
        Files.createDirectories(out);

        Map<Integer, SourceModelInfo> sourcesByModel = loadSourceModels(meManifest);
        Map<String, Boolean> successfulApplications = loadSuccessfulApplications(appManifest);
        Map<Integer, Map<String, AdaptationInfo>> adaptationsByModel = loadAdaptations(saManifest, successfulApplications);
        List<SampledModel> candidates = buildCandidates(sourcesByModel, adaptationsByModel);
        if (candidates.isEmpty()) {
            throw new IllegalStateException(
                    "No eligible models found with both benchmark cases ("
                            + CASE_FUNCTIONS
                            + ", "
                            + CASE_COMPONENTS
                            + ")");
        }

        Collections.shuffle(candidates, new Random(sampleSeed));
        int sampleCount = Math.min(requestedModelCount, candidates.size());
        List<SampledModel> sampled = new ArrayList<>(candidates.subList(0, sampleCount));

        logger.info(
                "v3 benchmark: candidates={}, sampled={}, requested={}, warmup={}, repetitions={}",
                candidates.size(),
                sampled.size(),
                requestedModelCount,
                warmupIterations,
                repetitions);

        Path selectedModelsCsv = out.resolve("benchmark_selected_models.csv");
        Path samplesCsv = out.resolve("benchmark_samples.csv");
        Path summaryCsv = out.resolve("benchmark_summary.csv");
        Path metadataJson = out.resolve("benchmark_metadata.json");

        writeSelectedModels(selectedModelsCsv, sampled);
        writeMetadata(
                metadataJson,
                runRoot,
                sampled.size(),
                candidates.size(),
                requestedModelCount,
                sampleSeed,
                warmupIterations,
                repetitions);

        CASAOfflineConsentAnalyzer analyzer = new CASAOfflineConsentAnalyzer(
                new CASAOfflineConsentAnalyzer.RiskEngineConfig(
                        CASARisk.EstimationMode.MONTE_CARLO,
                        20_000,
                        1234L,
                        15,
                        V3_RISK_CONSENT_THRESHOLD),
                V3_PURPOSE_ONTOLOGY_PATH,
                CASAPurpose.PurposeNameMappingMode.V3);

        try (BufferedWriter samples = Files.newBufferedWriter(samplesCsv, StandardCharsets.UTF_8);
                BufferedWriter summary = Files.newBufferedWriter(summaryCsv, StandardCharsets.UTF_8)) {
            samples.write(String.join(",", List.of(
                    "model_index",
                    "model_id",
                    "case_slug",
                    "adaptation_id",
                    "iteration",
                    "source_total_instances",
                    "source_total_relations",
                    "transform_ms",
                    "purpose_ms",
                    "risk_ms",
                    "total_ms",
                    "purpose_violated",
                    "risk_violated")));
            samples.newLine();

            summary.write(String.join(",", List.of(
                    "model_index",
                    "model_id",
                    "case_slug",
                    "adaptation_id",
                    "source_total_instances",
                    "source_total_relations",
                    "repetitions",
                    "transform_avg_ms",
                    "transform_std_ms",
                    "transform_min_ms",
                    "transform_max_ms",
                    "purpose_avg_ms",
                    "purpose_std_ms",
                    "purpose_min_ms",
                    "purpose_max_ms",
                    "risk_avg_ms",
                    "risk_std_ms",
                    "risk_min_ms",
                    "risk_max_ms",
                    "total_avg_ms",
                    "total_std_ms",
                    "total_min_ms",
                    "total_max_ms",
                    "purpose_violated_runs",
                    "risk_violated_runs")));
            summary.newLine();

            int processed = 0;
            for (SampledModel model : sampled) {
                processed++;
                logger.info("v3 benchmark: model {}/{} (index={})", processed, sampled.size(), model.modelIndex);
                EObject sourceRootForSize = null;
                CASAOfflineConsentAnalyzer.ModelSize size = null;

                for (String caseSlug : List.of(CASE_FUNCTIONS, CASE_COMPONENTS)) {
                    AdaptationInfo adaptation = model.adaptations.get(caseSlug);
                    if (adaptation == null) {
                        continue;
                    }
                    TransformationExecutor executor = new TransformationExecutor(adaptation.henshinPath);
                    EObject sourceRoot = executor.loadSourceRoot(model.source.path);
                    if (sourceRootForSize == null) {
                        sourceRootForSize = sourceRoot;
                        size = CASAOfflineConsentAnalyzer.computeModelSize(sourceRootForSize);
                    }
                    OnlineStats transformStats = new OnlineStats();
                    OnlineStats purposeStats = new OnlineStats();
                    OnlineStats riskStats = new OnlineStats();
                    OnlineStats totalStats = new OnlineStats();
                    int purposeViolatedRuns = 0;
                    int riskViolatedRuns = 0;

                    int totalIterations = warmupIterations + repetitions;
                    for (int i = 0; i < totalIterations; i++) {
                        TransformResult transform = executor.apply(sourceRoot);
                        if (!transform.applied) {
                            throw new IllegalStateException(
                                    "Henshin unit did not apply for model_index="
                                            + model.modelIndex
                                            + ", case="
                                            + caseSlug
                                            + ", henshin="
                                            + adaptation.henshinPath);
                        }

                        long purposeStart = System.nanoTime();
                        CASAPurpose.PurposeCheckResult purposeResult = analyzer.runPurposeOnly(transform.transformedRoot);
                        long purposeNanos = System.nanoTime() - purposeStart;

                        long riskStart = System.nanoTime();
                        CASARisk.RiskCheckResult riskResult = analyzer.runRiskOnlyDetailed(
                                transform.transformedRoot,
                                purposeResult);
                        long riskNanos = System.nanoTime() - riskStart;

                        long totalNanos = transform.elapsedNanos + purposeNanos + riskNanos;

                        if (i < warmupIterations) {
                            continue;
                        }

                        int iteration = i - warmupIterations;
                        double transformMs = nanosToMillis(transform.elapsedNanos);
                        double purposeMs = nanosToMillis(purposeNanos);
                        double riskMs = nanosToMillis(riskNanos);
                        double totalMs = nanosToMillis(totalNanos);

                        transformStats.add(transformMs);
                        purposeStats.add(purposeMs);
                        riskStats.add(riskMs);
                        totalStats.add(totalMs);
                        if (purposeResult.isViolated()) {
                            purposeViolatedRuns++;
                        }
                        if (riskResult.isViolated()) {
                            riskViolatedRuns++;
                        }

                        samples.write(String.join(",", List.of(
                                String.valueOf(model.modelIndex),
                                csv(model.source.modelId),
                                csv(caseSlug),
                                csv(adaptation.adaptationId),
                                String.valueOf(iteration),
                                String.valueOf(size.totalEObjects),
                                String.valueOf(size.totalRelations),
                                fmt(transformMs),
                                fmt(purposeMs),
                                fmt(riskMs),
                                fmt(totalMs),
                                String.valueOf(purposeResult.isViolated()),
                                String.valueOf(riskResult.isViolated()))));
                        samples.newLine();
                    }

                    summary.write(String.join(",", List.of(
                            String.valueOf(model.modelIndex),
                            csv(model.source.modelId),
                            csv(caseSlug),
                            csv(adaptation.adaptationId),
                            String.valueOf(size.totalEObjects),
                            String.valueOf(size.totalRelations),
                            String.valueOf(repetitions),
                            fmt(transformStats.mean()),
                            fmt(transformStats.stdDev()),
                            fmt(transformStats.min()),
                            fmt(transformStats.max()),
                            fmt(purposeStats.mean()),
                            fmt(purposeStats.stdDev()),
                            fmt(purposeStats.min()),
                            fmt(purposeStats.max()),
                            fmt(riskStats.mean()),
                            fmt(riskStats.stdDev()),
                            fmt(riskStats.min()),
                            fmt(riskStats.max()),
                            fmt(totalStats.mean()),
                            fmt(totalStats.stdDev()),
                            fmt(totalStats.min()),
                            fmt(totalStats.max()),
                            String.valueOf(purposeViolatedRuns),
                            String.valueOf(riskViolatedRuns))));
                    summary.newLine();
                    summary.flush();
                    samples.flush();
                }
            }
        }

        logger.info(
                "v3 benchmark: completed. outputs: {}, {}, {}, {}",
                selectedModelsCsv,
                samplesCsv,
                summaryCsv,
                metadataJson);
    }

    private static Map<Integer, SourceModelInfo> loadSourceModels(Path meManifest) throws IOException {
        Map<Integer, SourceModelInfo> rows = new LinkedHashMap<>();
        for (Map<String, String> row : CsvTable.read(meManifest)) {
            int modelIndex = parseInt(row.get("model_index"), -1);
            if (modelIndex < 0) {
                continue;
            }
            String xmi = row.getOrDefault("xmi_path", "");
            if (xmi.isBlank()) {
                continue;
            }
            boolean validationOk = Boolean.parseBoolean(row.getOrDefault("validation_ok", "false"));
            if (!validationOk) {
                continue;
            }
            Path sourcePath = resolveExistingPath(xmi, meManifest);
            rows.put(modelIndex, new SourceModelInfo(modelIndex, row.getOrDefault("model_id", ""), sourcePath));
        }
        return rows;
    }

    private static Map<Integer, Map<String, AdaptationInfo>> loadAdaptations(
            Path saManifest,
            Map<String, Boolean> successfulApplications) throws IOException {
        Map<Integer, Map<String, AdaptationInfo>> byModel = new LinkedHashMap<>();
        for (Map<String, String> row : CsvTable.read(saManifest)) {
            if (!Boolean.parseBoolean(row.getOrDefault("validation_ok", "false"))) {
                continue;
            }
            String caseSlug = row.getOrDefault("case_slug", "");
            if (!CASE_FUNCTIONS.equals(caseSlug) && !CASE_COMPONENTS.equals(caseSlug)) {
                continue;
            }
            int modelIndex = parseInt(row.get("model_index"), -1);
            if (modelIndex < 0) {
                continue;
            }
            int adaptationIndex = parseInt(row.get("adaptation_index"), -1);
            if (adaptationIndex < 0) {
                continue;
            }
            if (!successfulApplications.getOrDefault(key(modelIndex, adaptationIndex), false)) {
                continue;
            }
            String henshin = row.getOrDefault("henshin_path", "");
            if (henshin.isBlank()) {
                continue;
            }
            Path henshinPath = resolveExistingPath(henshin, saManifest);
            AdaptationInfo info = new AdaptationInfo(
                    modelIndex,
                    row.getOrDefault("adaptation_id", ""),
                    caseSlug,
                    henshinPath);
            byModel.computeIfAbsent(modelIndex, k -> new LinkedHashMap<>()).putIfAbsent(caseSlug, info);
        }
        return byModel;
    }

    private static Map<String, Boolean> loadSuccessfulApplications(Path appManifest) throws IOException {
        Map<String, Boolean> success = new HashMap<>();
        for (Map<String, String> row : CsvTable.read(appManifest)) {
            int modelIndex = parseInt(row.get("model_index"), -1);
            int adaptationIndex = parseInt(row.get("adaptation_index"), -1);
            if (modelIndex < 0 || adaptationIndex < 0) {
                continue;
            }
            boolean okStatus = "OK".equalsIgnoreCase(row.getOrDefault("status", ""));
            boolean applied = Boolean.parseBoolean(row.getOrDefault("application_succeeded", "false"));
            boolean emfOk = Boolean.parseBoolean(row.getOrDefault("emf_validation_ok", "false"));
            boolean oracleOk = Boolean.parseBoolean(row.getOrDefault("oracle_check_ok", "false"));
            success.put(key(modelIndex, adaptationIndex), okStatus && applied && emfOk && oracleOk);
        }
        return success;
    }

    private static List<SampledModel> buildCandidates(
            Map<Integer, SourceModelInfo> sourcesByModel,
            Map<Integer, Map<String, AdaptationInfo>> adaptationsByModel) {
        List<SampledModel> out = new ArrayList<>();
        for (Map.Entry<Integer, SourceModelInfo> sourceEntry : sourcesByModel.entrySet()) {
            int modelIndex = sourceEntry.getKey();
            Map<String, AdaptationInfo> adaptations = adaptationsByModel.get(modelIndex);
            if (adaptations == null) {
                continue;
            }
            if (!adaptations.containsKey(CASE_FUNCTIONS) || !adaptations.containsKey(CASE_COMPONENTS)) {
                continue;
            }
            out.add(new SampledModel(modelIndex, sourceEntry.getValue(), adaptations));
        }
        return out;
    }

    private static Unit resolveMainUnit(Module module) {
        for (Unit unit : module.getUnits()) {
            if (unit instanceof SequentialUnit) {
                return unit;
            }
        }
        if (!module.getUnits().isEmpty()) {
            return module.getUnits().get(0);
        }
        throw new IllegalStateException("No executable unit found in module: " + module.getName());
    }

    private static Path resolveExistingPath(String raw, Path manifestPath) {
        if (raw == null || raw.isBlank()) {
            throw new IllegalArgumentException("Empty path field in manifest " + manifestPath);
        }

        Path asGiven = Path.of(raw).normalize();
        if (asGiven.isAbsolute() && Files.exists(asGiven)) {
            return asGiven;
        }
        if (Files.exists(asGiven)) {
            return asGiven.toAbsolutePath().normalize();
        }

        Path againstManifest = manifestPath.getParent().resolve(raw).normalize();
        if (Files.exists(againstManifest)) {
            return againstManifest.toAbsolutePath().normalize();
        }

        throw new IllegalStateException("Referenced path not found from manifest " + manifestPath + ": " + raw);
    }

    private static void writeSelectedModels(Path out, List<SampledModel> sampled) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("model_index,model_id,source_model_path,case_slug,adaptation_id,henshin_path");
            w.newLine();
            for (SampledModel model : sampled) {
                for (String caseSlug : List.of(CASE_FUNCTIONS, CASE_COMPONENTS)) {
                    AdaptationInfo adaptation = model.adaptations.get(caseSlug);
                    w.write(String.join(",", List.of(
                            String.valueOf(model.modelIndex),
                            csv(model.source.modelId),
                            csv(model.source.path.toString()),
                            csv(caseSlug),
                            csv(adaptation.adaptationId),
                            csv(adaptation.henshinPath.toString()))));
                    w.newLine();
                }
            }
        }
    }

    private static void writeMetadata(
            Path out,
            Path applyRunRoot,
            int sampledModels,
            int candidateModels,
            int requestedModels,
            long sampleSeed,
            int warmupIterations,
            int repetitions) throws IOException {
        String json = """
                {
                  "generated_at": "%s",
                  "apply_run_root": "%s",
                  "benchmark_cases": ["%s", "%s"],
                  "requested_models": %d,
                  "candidate_models": %d,
                  "sampled_models": %d,
                  "sample_seed": %d,
                  "warmup_iterations": %d,
                  "repetitions": %d
                }
                """.formatted(
                Instant.now().toString(),
                applyRunRoot.toAbsolutePath().normalize(),
                CASE_FUNCTIONS,
                CASE_COMPONENTS,
                requestedModels,
                candidateModels,
                sampledModels,
                sampleSeed,
                warmupIterations,
                repetitions);
        Files.writeString(out, json, StandardCharsets.UTF_8);
    }

    private static String fmt(double value) {
        return String.format(Locale.ROOT, "%.6f", value);
    }

    private static double nanosToMillis(long nanos) {
        return nanos / 1_000_000.0d;
    }

    private static String csv(String value) {
        String v = value == null ? "" : value;
        if (v.contains(",") || v.contains("\"") || v.contains("\n")) {
            return "\"" + v.replace("\"", "\"\"") + "\"";
        }
        return v;
    }

    private static int parseInt(String raw, int fallback) {
        if (raw == null || raw.isBlank()) {
            return fallback;
        }
        try {
            return Integer.parseInt(raw.trim());
        } catch (NumberFormatException e) {
            return fallback;
        }
    }

    private static String key(int modelIndex, int adaptationIndex) {
        return modelIndex + ":" + adaptationIndex;
    }

    private record SourceModelInfo(int modelIndex, String modelId, Path path) {
    }

    private record AdaptationInfo(int modelIndex, String adaptationId, String caseSlug, Path henshinPath) {
    }

    private record SampledModel(int modelIndex, SourceModelInfo source, Map<String, AdaptationInfo> adaptations) {
    }

    private record TransformResult(EObject transformedRoot, long elapsedNanos, boolean applied) {
    }

    private static final class TransformationExecutor {
        private final HenshinResourceSet rs;
        private final Unit mainUnit;

        private TransformationExecutor(Path henshinPath) {
            Path henshinDir = henshinPath.getParent();
            this.rs = new HenshinResourceSet(henshinDir.toAbsolutePath().toString());
            rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
            rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
            rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
                    Resource.Factory.Registry.DEFAULT_EXTENSION,
                    new XMIResourceFactoryImpl());
            if (Files.exists(henshinDir.resolve("CASA.ecore"))) {
                rs.registerDynamicEPackages("CASA.ecore");
            }
            Module module = rs.getModule(henshinPath.getFileName().toString(), true);
            this.mainUnit = resolveMainUnit(module);
        }

        private EObject loadSourceRoot(Path sourceModelPath) {
            Resource sourceRes = rs.getResource(URI.createFileURI(sourceModelPath.toAbsolutePath().toString()), true);
            if (sourceRes.getContents().isEmpty()) {
                throw new IllegalStateException("Loaded source model has no contents: " + sourceModelPath);
            }
            return sourceRes.getContents().get(0);
        }

        private TransformResult apply(EObject sourceRoot) {
            EObject workingRoot = EcoreUtil.copy(sourceRoot);
            EGraph graph = new EGraphImpl(workingRoot);
            Engine engine = new EngineImpl();
            engine.getOptions().put(Engine.OPTION_DETERMINISTIC, Boolean.TRUE);
            UnitApplication application = new UnitApplicationImpl(engine, graph, mainUnit, null);
            long start = System.nanoTime();
            boolean applied = application.execute(null);
            long elapsed = System.nanoTime() - start;
            return new TransformResult(workingRoot, elapsed, applied);
        }
    }

    private static final class OnlineStats {
        private int count = 0;
        private double mean = 0.0;
        private double m2 = 0.0;
        private double min = Double.POSITIVE_INFINITY;
        private double max = Double.NEGATIVE_INFINITY;

        private void add(double x) {
            count++;
            double delta = x - mean;
            mean += delta / count;
            double delta2 = x - mean;
            m2 += delta * delta2;
            min = Math.min(min, x);
            max = Math.max(max, x);
        }

        private double mean() {
            return count == 0 ? 0.0 : mean;
        }

        private double stdDev() {
            return count <= 1 ? 0.0 : Math.sqrt(m2 / (count - 1));
        }

        private double min() {
            return count == 0 ? 0.0 : min;
        }

        private double max() {
            return count == 0 ? 0.0 : max;
        }
    }

    private static final class CsvTable {
        private CsvTable() {
        }

        private static List<Map<String, String>> read(Path path) throws IOException {
            List<String> lines = Files.readAllLines(path, StandardCharsets.UTF_8);
            if (lines.isEmpty()) {
                return List.of();
            }
            List<String> header = parseLine(lines.get(0));
            List<Map<String, String>> rows = new ArrayList<>();
            for (int i = 1; i < lines.size(); i++) {
                String line = lines.get(i);
                if (line == null || line.isBlank()) {
                    continue;
                }
                List<String> values = parseLine(line);
                Map<String, String> row = new HashMap<>();
                for (int c = 0; c < header.size(); c++) {
                    row.put(header.get(c), c < values.size() ? values.get(c) : "");
                }
                rows.add(row);
            }
            return rows;
        }

        private static List<String> parseLine(String line) {
            List<String> values = new ArrayList<>();
            StringBuilder current = new StringBuilder();
            boolean quoted = false;
            for (int i = 0; i < line.length(); i++) {
                char ch = line.charAt(i);
                if (ch == '"') {
                    if (quoted && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                        current.append('"');
                        i++;
                    } else {
                        quoted = !quoted;
                    }
                } else if (ch == ',' && !quoted) {
                    values.add(current.toString());
                    current.setLength(0);
                } else {
                    current.append(ch);
                }
            }
            values.add(current.toString());
            return values;
        }
    }
}
