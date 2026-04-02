package thesis.evaluation.version3.sa;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.henshin.model.Module;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import thesis.evaluation.version3.me.GenerateManagedElementViewsV3;
import thesis.evaluation.version3.me.ManagedElementView;

public final class GenerateSelfAdaptationsV3 {
    private static final Logger logger = LoggerFactory.getLogger(GenerateSelfAdaptationsV3.class);

    private GenerateSelfAdaptationsV3() {
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
        Path out = Path.of(outPath);
        SelfAdaptationGenerationConfig config = tinyProfile
                ? SelfAdaptationGenerationConfig.tiny()
                : SelfAdaptationGenerationConfig.defaults();
        Files.createDirectories(out);
        writeConfigSnapshot(out.resolve("generation_config.json"), modelCount, seed, pruneSourceModels, resume, tinyProfile, config);

        Path manifestPath = out.resolve("self_adaptation_manifest.csv");
        Path failureLogPath = out.resolve("self_adaptation_failed_attempts.csv");
        Set<CaseKey> existingCases = resume ? readExistingCases(manifestPath) : new HashSet<>();

        try (SelfAdaptationManifestWriterV3 manifest = new SelfAdaptationManifestWriterV3(
                manifestPath,
                resume);
                FailureAttemptLogWriter failureLog = new FailureAttemptLogWriter(
                        failureLogPath,
                        resume)) {
            SelfAdaptationSpecSampler sampler = new SelfAdaptationSpecSampler(config);
            SelfAdaptationValidatorV3 validator = new SelfAdaptationValidatorV3();
            SelfAdaptationInstantiator instantiator = new SelfAdaptationInstantiator(config);
            HenshinTransformationMapperV3 henshinMapper = new HenshinTransformationMapperV3();
            HenshinTransformationWriterV3 henshinWriter = new HenshinTransformationWriterV3();

            for (int modelIndex = 0; modelIndex < modelCount; modelIndex++) {
                if (resume && modelCompleted(existingCases, modelIndex)) {
                    logger.info("v3 SA generation: skipping completed modelIndex={}", modelIndex);
                    continue;
                }
                long sourceModelSeed = deriveSourceModelSeed(seed, modelIndex);
                logger.info("v3 SA generation: model {}/{} sourceSeed={}", modelIndex + 1, modelCount, sourceModelSeed);
                ManagedElementView meView = GenerateManagedElementViewsV3.generateSingle(
                        sourceModelSeed,
                        modelIndex,
                        pruneSourceModels,
                        tinyProfile);
                SourceManagedElementProfile profile = SourceManagedElementAdapter.toProfile(meView);
                SourceManagedElementInstance snapshot = SourceManagedElementAdapter.toInstance(meView);
                List<AcceptedCase> acceptedCases = new ArrayList<>();
                for (int adaptationIndex = 0; adaptationIndex < SelfAdaptationCombination.COUNT; adaptationIndex++) {
                    CaseKey caseKey = new CaseKey(modelIndex, adaptationIndex);
                    if (resume && existingCases.contains(caseKey)) {
                        continue;
                    }
                    String caseSlug = SelfAdaptationCombination.fromIndex(adaptationIndex).caseSlug();
                    logger.info(
                            "v3 SA generation: modelIndex={} case {}/{} slug={}",
                            modelIndex,
                            adaptationIndex + 1,
                            SelfAdaptationCombination.COUNT,
                            caseSlug);
                    AcceptedCase accepted = null;
                    SelfAdaptationSpec lastSpec = null;
                    SelfAdaptationInstance lastInstance = null;
                    String lastStage = "";
                    String lastIssue = "";
                    for (int caseAttempt = 0; caseAttempt < config.maxAttemptsPerCase; caseAttempt++) {
                        long specSeed = deriveSpecSeed(seed, modelIndex, adaptationIndex, caseAttempt);
                        SelfAdaptationSpec spec = sampler.sample(profile, modelIndex, adaptationIndex, sourceModelSeed, specSeed);
                        lastSpec = spec;
                        SaValidationResult specValidation = validator.validate(profile, spec);
                        if (!specValidation.valid()) {
                            lastStage = "spec_validation";
                            lastIssue = specValidation.message();
                            logger.warn(
                                    "v3 SA generation: spec validation failed modelIndex={} adaptationIndex={} attempt={} slug={} issue={}",
                                    modelIndex,
                                    adaptationIndex,
                                    caseAttempt,
                                    caseSlug,
                                    lastIssue);
                            failureLog.append(modelIndex, adaptationIndex, caseAttempt, sourceModelSeed, spec, null, lastStage, specValidation);
                            continue;
                        }
                        SelfAdaptationInstance instance = instantiator.instantiate(snapshot, spec);
                        lastInstance = instance;
                        SaValidationResult caseValidation = validator.validateInstantiatedCase(spec, instance);
                        if (!caseValidation.valid()) {
                            lastStage = "case_realization";
                            lastIssue = caseValidation.message();
                            logger.warn(
                                    "v3 SA generation: case realization failed modelIndex={} adaptationIndex={} attempt={} slug={} issue={}",
                                    modelIndex,
                                    adaptationIndex,
                                    caseAttempt,
                                    caseSlug,
                                    lastIssue);
                            failureLog.append(modelIndex, adaptationIndex, caseAttempt, sourceModelSeed, spec, instance, lastStage, caseValidation);
                            continue;
                        }
                        accepted = new AcceptedCase(spec, instance, snapshot);
                        logger.info(
                                "v3 SA generation: accepted modelIndex={} adaptationIndex={} slug={} specSeed={}",
                                modelIndex,
                                adaptationIndex,
                                caseSlug,
                                specSeed);
                        break;
                    }
                    if (accepted == null) {
                        SelfAdaptationSpec failedSpec = lastSpec != null
                                ? lastSpec
                                : sampler.sample(
                                        profile,
                                        modelIndex,
                                        adaptationIndex,
                                        sourceModelSeed,
                                        deriveSpecSeed(seed, modelIndex, adaptationIndex, 0));
                        SelfAdaptationInstance failedInstance = lastInstance != null
                                ? lastInstance
                                : failedInstanceFor(failedSpec, snapshot, lastStage, lastIssue);
                        failedInstance.notes.add("failed after bounded retries");
                        failedInstance.notes.add("failureLog=" + out.resolve("self_adaptation_failed_attempts.csv"));
                        manifest.append(
                                modelIndex,
                                failedSpec,
                                failedInstance,
                                snapshot,
                                new SaValidationResult(
                                        false,
                                        "SA_CASE_UNREALIZED",
                                        "attempts=" + config.maxAttemptsPerCase
                                                + ";stage=" + lastStage
                                                + ";issue=" + lastIssue
                                                + ";requested=" + summarizeRequested(failedSpec)
                                                + ";achieved=" + summarizeAchieved(lastInstance)));
                        existingCases.add(caseKey);
                        logger.error(
                                "v3 SA generation: failed after retries modelIndex={} adaptationIndex={} slug={} stage={} issue={}",
                                modelIndex,
                                adaptationIndex,
                                caseSlug,
                                lastStage,
                                lastIssue);
                        continue;
                    }
                    acceptedCases.add(accepted);
                    existingCases.add(caseKey);
                }

                for (AcceptedCase accepted : acceptedCases) {
                    Path henshinPath = out.resolve("transformations")
                            .resolve(String.format("model_%06d", modelIndex))
                            .resolve(accepted.instance.adaptationId + ".henshin");
                    Module module = henshinMapper.map(accepted.instance, accepted.snapshot);
                    accepted.instance.henshinPath = henshinWriter.write(module, henshinPath).toString();
                    manifest.append(modelIndex, accepted.spec, accepted.instance, accepted.snapshot, new SaValidationResult(true, "", ""));
                }
                logger.info(
                        "v3 SA generation: completed modelIndex={} acceptedCases={}/{}",
                        modelIndex,
                        acceptedCases.size(),
                        SelfAdaptationCombination.COUNT);
            }
        }
    }

    private static long deriveSourceModelSeed(long baseSeed, int modelIndex) {
        return baseSeed + modelIndex;
    }

    private static long deriveSpecSeed(
            long baseSeed,
            int modelIndex,
            int adaptationIndex,
            int caseAttempt) {
        return baseSeed
                + (modelIndex * 10_000L)
                + (adaptationIndex * 100L)
                + caseAttempt;
    }

    private record AcceptedCase(
            SelfAdaptationSpec spec,
            SelfAdaptationInstance instance,
            SourceManagedElementInstance snapshot) {
    }

    private static void writeConfigSnapshot(
            Path configPath,
            int modelCount,
            long seed,
            boolean pruneSourceModels,
            boolean resume,
            boolean tinyProfile,
            SelfAdaptationGenerationConfig config) throws IOException {
        String json = """
                {
                  "note": "self-adaptation conceptual smoke run",
                  "baseSeed": %d,
                  "modelCount": %d,
                  "adaptationsPerModel": %d,
                  "maxAttemptsPerCase": %d,
                  "sourceModelRegenerationEnabled": false,
                  "pruneSourceModels": %s,
                  "resume": %s,
                  "profile": "%s"
                }
                """.formatted(
                seed,
                modelCount,
                SelfAdaptationCombination.COUNT,
                config.maxAttemptsPerCase,
                String.valueOf(pruneSourceModels),
                String.valueOf(resume),
                tinyProfile ? SelfAdaptationGenerationConfig.PROFILE_TINY : SelfAdaptationGenerationConfig.PROFILE_DEFAULT);
        Files.writeString(configPath, json, StandardCharsets.UTF_8);
    }

    private static boolean modelCompleted(Set<CaseKey> existingCases, int modelIndex) {
        for (int adaptationIndex = 0; adaptationIndex < SelfAdaptationCombination.COUNT; adaptationIndex++) {
            if (!existingCases.contains(new CaseKey(modelIndex, adaptationIndex))) {
                return false;
            }
        }
        return true;
    }

    private static Set<CaseKey> readExistingCases(Path manifestPath) throws IOException {
        Set<CaseKey> cases = new HashSet<>();
        if (!Files.exists(manifestPath) || Files.size(manifestPath) == 0L) {
            return cases;
        }
        List<String> lines = Files.readAllLines(manifestPath, StandardCharsets.UTF_8);
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line == null || line.isBlank()) {
                continue;
            }
            List<String> values = parseCsvLine(line);
            if (values.size() < 3) {
                continue;
            }
            cases.add(new CaseKey(Integer.parseInt(values.get(0)), Integer.parseInt(values.get(2))));
        }
        return cases;
    }

    private static List<String> parseCsvLine(String line) {
        List<String> values = new ArrayList<>();
        StringBuilder current = new StringBuilder();
        boolean inQuotes = false;
        for (int i = 0; i < line.length(); i++) {
            char ch = line.charAt(i);
            if (ch == '"') {
                if (inQuotes && i + 1 < line.length() && line.charAt(i + 1) == '"') {
                    current.append('"');
                    i++;
                } else {
                    inQuotes = !inQuotes;
                }
            } else if (ch == ',' && !inQuotes) {
                values.add(current.toString());
                current.setLength(0);
            } else {
                current.append(ch);
            }
        }
        values.add(current.toString());
        return values;
    }

    private record CaseKey(int modelIndex, int adaptationIndex) {
    }

    private static String summarizeRequested(SelfAdaptationSpec spec) {
        if (spec == null) {
            return "";
        }
        return "addF=" + spec.addFunctionCount
                + ";remF=" + spec.removeFunctionCount
                + ";addC=" + spec.addComponentCount
                + ";remC=" + spec.removeComponentCount
                + ";purposeViol=" + spec.requestedPurposeViolations
                + ";riskViol=" + spec.requestedRiskViolations
                + ";localSampling=per_added_element";
    }

    private static String summarizeAchieved(SelfAdaptationInstance instance) {
        if (instance == null) {
            return "";
        }
        return "addF=" + instance.addedFunctions.size()
                + ";safeAddF=" + countSafeAddedFunctions(instance)
                + ";violAddF=" + countViolatingAddedFunctions(instance)
                + ";remF=" + instance.removedFunctionIds.size()
                + ";addC=" + instance.addedComponents.size()
                + ";safeAddC=" + countSafeAddedComponents(instance)
                + ";riskyAddC=" + countRiskyAddedComponents(instance)
                + ";remC=" + instance.removedComponentIds.size()
                + ";purposeViol=" + instance.expectedPurposeViolations.size()
                + ";identPurposeViol=" + instance.expectedIdentifiablePurposeViolations.size()
                + ";riskViol=" + instance.expectedRiskViolations.size()
                + ";identRiskViol=" + instance.expectedIdentifiableRiskViolations.size()
                + ";notes=" + String.join(" | ", instance.notes);
    }

    private static int countSafeAddedFunctions(SelfAdaptationInstance instance) {
        int count = 0;
        for (SelfAdaptationInstance.AddedFunction function : instance.addedFunctions) {
            if (!hasPurposeViolation(instance, function.id())) {
                count++;
            }
        }
        return count;
    }

    private static int countViolatingAddedFunctions(SelfAdaptationInstance instance) {
        int count = 0;
        for (SelfAdaptationInstance.AddedFunction function : instance.addedFunctions) {
            if (hasPurposeViolation(instance, function.id())) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasPurposeViolation(SelfAdaptationInstance instance, String functionId) {
        for (ExpectedViolation violation : instance.expectedPurposeViolations) {
            if (functionId.equals(violation.functionId())) {
                return true;
            }
        }
        return false;
    }

    private static int countSafeAddedComponents(SelfAdaptationInstance instance) {
        int count = 0;
        for (SelfAdaptationInstance.AddedComponent component : instance.addedComponents) {
            if (component.vulnerabilityCves().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static int countRiskyAddedComponents(SelfAdaptationInstance instance) {
        int count = 0;
        for (SelfAdaptationInstance.AddedComponent component : instance.addedComponents) {
            if (!component.vulnerabilityCves().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static final class FailureAttemptLogWriter implements AutoCloseable {
        private final java.io.BufferedWriter writer;

        private FailureAttemptLogWriter(Path path) throws IOException {
            this(path, false);
        }

        private FailureAttemptLogWriter(Path path, boolean append) throws IOException {
            Files.createDirectories(path.getParent());
            boolean appendToExisting = append && Files.exists(path) && Files.size(path) > 0;
            this.writer = appendToExisting
                    ? Files.newBufferedWriter(path, StandardCharsets.UTF_8, java.nio.file.StandardOpenOption.APPEND)
                    : Files.newBufferedWriter(path, StandardCharsets.UTF_8);
            if (!appendToExisting) {
                writer.write(String.join(",", List.of(
                        "model_index",
                        "adaptation_index",
                        "case_slug",
                        "attempt_index",
                        "source_model_seed",
                        "spec_seed",
                        "stage",
                        "error_code",
                        "error_message",
                        "requested",
                        "achieved",
                        "instance_notes")));
                writer.newLine();
                writer.flush();
            }
        }

        private void append(
                int modelIndex,
                int adaptationIndex,
                int caseAttempt,
                long sourceModelSeed,
                SelfAdaptationSpec spec,
                SelfAdaptationInstance instance,
                String stage,
                SaValidationResult validation) throws IOException {
            writer.write(String.join(",", List.of(
                    String.valueOf(modelIndex),
                    String.valueOf(adaptationIndex),
                    csv(spec == null || spec.combination == null ? "" : spec.combination.caseSlug()),
                    String.valueOf(caseAttempt),
                    String.valueOf(sourceModelSeed),
                    String.valueOf(spec == null ? -1L : spec.seed),
                    csv(stage),
                    csv(validation.errorCode()),
                    csv(validation.message()),
                    csv(summarizeRequested(spec)),
                    csv(summarizeAchieved(instance)),
                    csv(instance == null ? "" : String.join(" | ", instance.notes)))));
            writer.newLine();
            writer.flush();
        }

        @Override
        public void close() throws IOException {
            writer.close();
        }
    }

    private static String csv(String value) {
        String v = value == null ? "" : value;
        if (v.contains(",") || v.contains("\"") || v.contains("\n")) {
            return "\"" + v.replace("\"", "\"\"") + "\"";
        }
        return v;
    }

    private static SelfAdaptationInstance failedInstanceFor(
            SelfAdaptationSpec spec,
            SourceManagedElementInstance snapshot,
            String stage,
            String issue) {
        SelfAdaptationInstance instance = new SelfAdaptationInstance();
        instance.adaptationId = String.format(
                "sa_%06d_%03d_%s",
                spec.modelIndex,
                spec.adaptationIndex,
                spec.combination.caseSlug());
        instance.sourceModelId = snapshot.modelId;
        if (stage != null && !stage.isBlank()) {
            instance.notes.add("lastStage=" + stage);
        }
        if (issue != null && !issue.isBlank()) {
            instance.notes.add("lastIssue=" + issue);
        }
        return instance;
    }
}
