package thesis.evaluation.version3.result_evaluation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thesis.evaluation.version3.me.ManagedElementView;
import thesis.evaluation.version3.sa.SelfAdaptationOracleRebuilderV3;

public final class ResultEvaluationRunnerV3 {
    private static final Logger logger = LoggerFactory.getLogger(ResultEvaluationRunnerV3.class);

    private final ManagedElementArtifactProjectorV3 projector = new ManagedElementArtifactProjectorV3();
    private final ProspectiveModelComparatorV3 comparator = new ProspectiveModelComparatorV3();
    private final OfflineResultAnalyzerV3 analyzer = new OfflineResultAnalyzerV3();

    public void run(Path applyRunRoot, Path outRoot) throws Exception {
        run(applyRunRoot, outRoot, false);
    }

    public void run(Path applyRunRoot, Path outRoot, boolean resume) throws Exception {
        ResultEvaluationConfig config = loadConfig(applyRunRoot, outRoot, resume);
        Files.createDirectories(outRoot);

        List<EvaluationInputUnit> inputs = loadInputs(config.applyRunRoot.resolve("application_manifest.csv"), config.applyRunRoot);
        Path manifestPath = outRoot.resolve("result_evaluation_manifest.csv");
        List<ResultEvaluationRecord> records = config.resume ? loadExistingRecords(manifestPath) : new ArrayList<>();
        Set<String> completedKeys = completedKeys(records);
        int skipped = 0;
        logger.info(
                "v3 result evaluation: evaluating {} applied self-adaptations (resume={}, alreadyDone={})",
                inputs.size(),
                config.resume,
                completedKeys.size());
        try (ResultEvaluationManifestWriterV3 manifest = new ResultEvaluationManifestWriterV3(manifestPath, config.resume)) {
            for (EvaluationInputUnit input : inputs) {
                String key = input.modelIndex() + "|" + input.adaptationIndex();
                if (config.resume && completedKeys.contains(key)) {
                    skipped++;
                    continue;
                }
                logger.info(
                        "v3 result evaluation: modelIndex={} adaptationIndex={} adaptationId={} caseSlug={}",
                        input.modelIndex(),
                        input.adaptationIndex(),
                        input.adaptationId(),
                        input.caseSlug());
                ResultEvaluationRecord record = evaluateUnit(input, config);
                records.add(record);
                manifest.append(record);
            }
        }
        new ResultEvaluationSummaryWriterV3().write(outRoot, records);
        logger.info("v3 result evaluation: completed (skippedAlreadyDone={})", skipped);
    }

    private ResultEvaluationRecord evaluateUnit(EvaluationInputUnit input, ResultEvaluationConfig config) {
        ResultEvaluationRecord record = new ResultEvaluationRecord();
        record.modelIndex = input.modelIndex();
        record.modelId = input.modelId();
        record.adaptationIndex = input.adaptationIndex();
        record.adaptationId = input.adaptationId();
        record.caseSlug = input.caseSlug();
        record.sourceModelPath = input.sourceModelPath().toString();
        record.prospectiveModelPath = input.prospectiveModelPath().toString();
        record.status = "OK";
        try {
            SelfAdaptationOracleRebuilderV3.OracleCase oracle = SelfAdaptationOracleRebuilderV3.rebuild(
                    input.sourceModelSeed(),
                    input.specSeed(),
                    input.modelIndex(),
                    input.adaptationIndex(),
                    config.pruneSourceModels,
                    config.tinyProfile);

            try (ManagedElementArtifactProjectorV3.LoadedModel loaded = projector.load(input.prospectiveModelPath())) {
                NormalizedManagedElementModel expected = normalizeOracle(oracle);
                NormalizedManagedElementModel actual = projector.project(loaded.root());
                ProspectiveModelComparatorV3.ComparisonResult derivation = comparator.compare(expected, actual);
                record.derivationCorrect = derivation.matches();
                record.derivationIssueCount = derivation.issues().size();
                record.derivationIssues = String.join(" | ", derivation.issues());

                EObject actualRoot = loaded.root();
                comparePurposeResults(actualRoot, oracle, record);
                compareRiskResults(actualRoot, oracle, record);
            }
        } catch (Exception e) {
            record.status = "ERROR";
            record.errorCode = e.getClass().getSimpleName();
            record.errorMessage = e.getMessage();
            logger.error(
                    "v3 result evaluation: failed modelIndex={} adaptationIndex={} adaptationId={} error={}",
                    record.modelIndex,
                    record.adaptationIndex,
                    record.adaptationId,
                    record.errorMessage,
                    e);
        }
        return record;
    }

    private void comparePurposeResults(
            EObject actualRoot,
            SelfAdaptationOracleRebuilderV3.OracleCase oracle,
            ResultEvaluationRecord record) throws Exception {
        Set<String> actualViolations = analyzer.analyzePurposeViolationKeys(actualRoot);
        Set<String> expectedViolations = new LinkedHashSet<>();
        Set<String> expectedIdentifiableViolations = new LinkedHashSet<>();
        for (SelfAdaptationOracleRebuilderV3.PurposeViolation violation : oracle.expectedPurposeViolations()) {
            expectedViolations.add(purposeKey(
                    violation.dataSubjectId(),
                    violation.personalDataId(),
                    violation.functionId(),
                    violation.purposeId()));
        }
        for (SelfAdaptationOracleRebuilderV3.PurposeViolation violation : oracle.expectedIdentifiablePurposeViolations()) {
            expectedIdentifiableViolations.add(purposeKey(
                    violation.dataSubjectId(),
                    violation.personalDataId(),
                    violation.functionId(),
                    violation.purposeId()));
        }
        fillMetrics(expectedViolations, expectedIdentifiableViolations, actualViolations, true, record);
    }

    private void compareRiskResults(
            EObject actualRoot,
            SelfAdaptationOracleRebuilderV3.OracleCase oracle,
            ResultEvaluationRecord record) {
        Set<String> actualViolations = analyzer.analyzeRiskViolationDataSubjects(actualRoot);
        Set<String> expectedViolations = new LinkedHashSet<>();
        Set<String> expectedIdentifiableViolations = new LinkedHashSet<>();
        for (SelfAdaptationOracleRebuilderV3.RiskViolation violation : oracle.expectedRiskViolations()) {
            expectedViolations.add(violation.dataSubjectId());
        }
        for (SelfAdaptationOracleRebuilderV3.RiskViolation violation : oracle.expectedIdentifiableRiskViolations()) {
            expectedIdentifiableViolations.add(violation.dataSubjectId());
        }
        fillMetrics(expectedViolations, expectedIdentifiableViolations, actualViolations, false, record);
    }

    private void fillMetrics(
            Set<String> expected,
            Set<String> expectedIdentifiable,
            Set<String> actual,
            boolean purpose,
            ResultEvaluationRecord record) {
        Set<String> tp = new LinkedHashSet<>(expectedIdentifiable);
        tp.retainAll(actual);
        Set<String> fn = new LinkedHashSet<>(expectedIdentifiable);
        fn.removeAll(actual);
        Set<String> fp = new LinkedHashSet<>(actual);
        fp.removeAll(expectedIdentifiable);
        double accuracy = expectedIdentifiable.isEmpty() && fp.isEmpty()
                ? 1.0
                : expectedIdentifiable.isEmpty()
                        ? 0.0
                        : (double) tp.size() / expectedIdentifiable.size();

        if (purpose) {
            record.expectedPurposeViolations = expected.size();
            record.expectedIdentifiablePurposeViolations = expectedIdentifiable.size();
            record.actualPurposeViolations = actual.size();
            record.purposeTruePositives = tp.size();
            record.purposeFalseNegatives = fn.size();
            record.purposeFalsePositives = fp.size();
            record.purposeAccuracy = accuracy;
        } else {
            record.expectedRiskViolations = expected.size();
            record.expectedIdentifiableRiskViolations = expectedIdentifiable.size();
            record.actualRiskViolations = actual.size();
            record.riskTruePositives = tp.size();
            record.riskFalseNegatives = fn.size();
            record.riskFalsePositives = fp.size();
            record.riskAccuracy = accuracy;
        }
    }

    private static String purposeKey(String dsId, String pdId, String functionId, String purposeId) {
        return dsId + "|" + pdId + "|" + functionId + "|" + purposeId;
    }

    private static NormalizedManagedElementModel normalizeOracle(SelfAdaptationOracleRebuilderV3.OracleCase oracle) {
        ManagedElementView view = oracle.expectedProspectiveView();
        NormalizedManagedElementModel model = new NormalizedManagedElementModel();
        model.modelId = view.modelId;
        view.dataSubjects.values().forEach(ds -> model.dataSubjectTypes.put(ds.id(), ds.type()));
        view.personalData.values().forEach(pd -> {
            model.personalDataTypes.put(pd.id(), pd.type());
            model.personalDataIdentifies.put(pd.id(), pd.identifiesDsId());
        });
        view.functions.values().forEach(function -> {
            model.addFunction(function.id(), function.type());
            model.functionRealizedBy.get(function.id()).addAll(function.realizedByComponentIds());
            model.functionProcesses.get(function.id()).addAll(function.processesPersonalDataIds());
            model.functionHasPurpose.get(function.id()).addAll(function.hasPurposeIds());
        });
        view.components.values().forEach(component -> model.componentTypes.put(component.id(), component.type()));
        view.purposes.values().forEach(purpose -> model.purposeTypes.put(purpose.id(), purpose.type()));
        view.vulnerabilities.values().forEach(vulnerability -> model.addVulnerability(vulnerability.cveName()));
        for (SelfAdaptationOracleRebuilderV3.AddedComponentVulnerability row : oracle.expectedAddedComponentVulnerabilities()) {
            model.addVulnerability(row.vulnerabilityCve());
            model.vulnerabilityAffects.get(row.vulnerabilityCve()).add(row.componentId());
        }
        view.consents.values().forEach(consent -> model.consentKeys.add(
                ManagedElementArtifactProjectorV3.consentKey(
                        consent.givenByDsId(),
                        consent.forPersonalDataId(),
                        consent.givenForPurposeId())));
        return model;
    }

    private ResultEvaluationConfig loadConfig(Path applyRunRoot, Path outRoot, boolean resume) throws IOException {
        String json = Files.readString(applyRunRoot.resolve("generation_config.json"), StandardCharsets.UTF_8);
        long baseSeed = parseLong(json, "baseSeed");
        boolean pruneSourceModels = parseBoolean(json, "pruneSourceModels");
        boolean tinyProfile = "tiny".equals(parseString(json, "profile", "default"));
        return new ResultEvaluationConfig(applyRunRoot, outRoot, baseSeed, pruneSourceModels, tinyProfile, resume);
    }

    private static long parseLong(String json, String key) {
        String marker = "\"" + key + "\":";
        int start = json.indexOf(marker);
        if (start < 0) {
            throw new IllegalStateException("Missing key in config: " + key);
        }
        int valueStart = start + marker.length();
        int valueEnd = valueStart;
        while (valueEnd < json.length() && " \n\r\t".indexOf(json.charAt(valueEnd)) >= 0) {
            valueEnd++;
        }
        int cursor = valueEnd;
        while (cursor < json.length() && Character.isDigit(json.charAt(cursor))) {
            cursor++;
        }
        return Long.parseLong(json.substring(valueEnd, cursor));
    }

    private static boolean parseBoolean(String json, String key) {
        String marker = "\"" + key + "\":";
        int start = json.indexOf(marker);
        if (start < 0) {
            throw new IllegalStateException("Missing key in config: " + key);
        }
        int valueStart = start + marker.length();
        while (valueStart < json.length() && " \n\r\t".indexOf(json.charAt(valueStart)) >= 0) {
            valueStart++;
        }
        if (json.startsWith("true", valueStart)) {
            return true;
        }
        if (json.startsWith("false", valueStart)) {
            return false;
        }
        throw new IllegalStateException("Invalid boolean for key: " + key);
    }

    private static String parseString(String json, String key, String defaultValue) {
        String marker = "\"" + key + "\":";
        int start = json.indexOf(marker);
        if (start < 0) {
            return defaultValue;
        }
        int valueStart = start + marker.length();
        while (valueStart < json.length() && " \n\r\t".indexOf(json.charAt(valueStart)) >= 0) {
            valueStart++;
        }
        if (json.charAt(valueStart) != '"') {
            return defaultValue;
        }
        int valueEnd = json.indexOf('"', valueStart + 1);
        if (valueEnd < 0) {
            return defaultValue;
        }
        return json.substring(valueStart + 1, valueEnd);
    }

    private static List<EvaluationInputUnit> loadInputs(Path applicationManifest, Path applyRunRoot) throws IOException {
        Map<String, Map<String, String>> saByKey = new LinkedHashMap<>();
        Path saManifest = applyRunRoot.resolve("self_adaptations").resolve("self_adaptation_manifest.csv");
        for (Map<String, String> row : CsvTableV3.read(saManifest)) {
            String key = row.get("model_index") + "|" + row.get("adaptation_index");
            saByKey.put(key, row);
        }
        List<EvaluationInputUnit> inputs = new ArrayList<>();
        for (Map<String, String> row : CsvTableV3.read(applicationManifest)) {
            if (!Boolean.parseBoolean(row.getOrDefault("application_succeeded", "false"))) {
                continue;
            }
            if (!Boolean.parseBoolean(row.getOrDefault("emf_validation_ok", "false"))) {
                continue;
            }
            String key = row.get("model_index") + "|" + row.get("adaptation_index");
            Map<String, String> saRow = saByKey.get(key);
            if (saRow == null) {
                throw new IllegalStateException("Missing SA manifest row for " + key);
            }
            inputs.add(new EvaluationInputUnit(
                    Integer.parseInt(row.get("model_index")),
                    row.get("model_id"),
                    Integer.parseInt(row.get("adaptation_index")),
                    row.get("adaptation_id"),
                    row.get("case_slug"),
                    Long.parseLong(saRow.get("source_model_seed")),
                    Long.parseLong(saRow.get("seed")),
                    resolveArtifactPath(applyRunRoot, row.get("source_model_path")),
                    resolveArtifactPath(applyRunRoot, row.get("prospective_model_path"))));
        }
        return inputs;
    }

    private static Path resolveArtifactPath(Path applyRunRoot, String rawPath) {
        Path path = Path.of(rawPath);
        if (path.isAbsolute()) {
            return path.normalize();
        }
        List<Path> candidates = List.of(
                path,
                applyRunRoot.resolve(path),
                applyRunRoot.getParent() == null ? path : applyRunRoot.getParent().resolve(path),
                applyRunRoot.resolveSibling(path.toString()));
        for (Path candidate : candidates) {
            if (Files.exists(candidate)) {
                return candidate.normalize();
            }
        }
        return path.normalize();
    }

    private static Set<String> completedKeys(List<ResultEvaluationRecord> records) {
        Set<String> keys = new LinkedHashSet<>();
        for (ResultEvaluationRecord record : records) {
            keys.add(record.modelIndex + "|" + record.adaptationIndex);
        }
        return keys;
    }

    private static List<ResultEvaluationRecord> loadExistingRecords(Path manifestPath) throws IOException {
        if (!Files.exists(manifestPath)) {
            return new ArrayList<>();
        }
        List<ResultEvaluationRecord> records = new ArrayList<>();
        for (Map<String, String> row : CsvTableV3.read(manifestPath)) {
            ResultEvaluationRecord record = new ResultEvaluationRecord();
            record.modelIndex = parseInt(row.get("model_index"));
            record.modelId = row.get("model_id");
            record.adaptationIndex = parseInt(row.get("adaptation_index"));
            record.adaptationId = row.get("adaptation_id");
            record.caseSlug = row.get("case_slug");
            record.sourceModelPath = row.get("source_model_path");
            record.prospectiveModelPath = row.get("prospective_model_path");
            record.derivationCorrect = Boolean.parseBoolean(row.get("derivation_correct"));
            record.derivationIssueCount = parseInt(row.get("derivation_issue_count"));
            record.derivationIssues = row.get("derivation_issues");
            record.expectedPurposeViolations = parseInt(row.get("expected_purpose_violations"));
            record.expectedIdentifiablePurposeViolations = parseInt(row.get("expected_identifiable_purpose_violations"));
            record.actualPurposeViolations = parseInt(row.get("identified_by_casa_purpose_violations"));
            record.purposeTruePositives = parseInt(row.get("purpose_true_positives"));
            record.purposeFalseNegatives = parseInt(row.get("purpose_false_negatives"));
            record.purposeFalsePositives = parseInt(row.get("purpose_false_positives"));
            record.purposeAccuracy = parseDouble(row.get("purpose_accuracy"));
            record.expectedRiskViolations = parseInt(row.get("expected_risk_violations"));
            record.expectedIdentifiableRiskViolations = parseInt(row.get("expected_identifiable_risk_violations"));
            record.actualRiskViolations = parseInt(row.get("identified_by_casa_risk_violations"));
            record.riskTruePositives = parseInt(row.get("risk_true_positives"));
            record.riskFalseNegatives = parseInt(row.get("risk_false_negatives"));
            record.riskFalsePositives = parseInt(row.get("risk_false_positives"));
            record.riskAccuracy = parseDouble(row.get("risk_accuracy"));
            record.status = row.get("status");
            record.errorCode = row.get("error_code");
            record.errorMessage = row.get("error_message");
            records.add(record);
        }
        return records;
    }

    private static int parseInt(String value) {
        if (value == null || value.isBlank()) {
            return 0;
        }
        return Integer.parseInt(value);
    }

    private static double parseDouble(String value) {
        if (value == null || value.isBlank()) {
            return 0.0;
        }
        return Double.parseDouble(value);
    }
}
