package thesis.evaluation.version3.me;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

final class GenerationOrchestrator {
    private final GenerationConfig config;
    private final SpecSampler specSampler;
    private final ManagedElementInstantiator instantiator;
    private final StatsCollectorV3 statsCollector;
    private final DatasetValidatorV3 validator;
    private final GraphMlWriterV3 graphMlWriter;
    private final RulePrunerV3 pruner;
    private final CasaModelMapperV3 casaModelMapper;
    private final XmiWriterV3 xmiWriter;

    GenerationOrchestrator(GenerationConfig config) {
        this.config = config;
        this.specSampler = new SpecSampler(config);
        this.instantiator = new ManagedElementInstantiator(config);
        this.statsCollector = new StatsCollectorV3();
        this.validator = new DatasetValidatorV3(config);
        this.graphMlWriter = new GraphMlWriterV3();
        this.pruner = new RulePrunerV3();
        this.casaModelMapper = new CasaModelMapperV3();
        this.xmiWriter = new XmiWriterV3();
    }

    void run() throws IOException {
        Files.createDirectories(config.runRoot);
        Files.createDirectories(config.runRoot.resolve("logs"));
        writeConfigSnapshot(config.runRoot.resolve("generation_config.json"));

        Path manifestPath = config.runRoot.resolve("manifest.csv");

        int modelIndex = config.resume ? nextModelIndex(manifestPath) : 0;
        try (ManifestWriterV3 manifest = new ManifestWriterV3(manifestPath, config, config.resume)) {
            while (modelIndex < config.targetCount) {
                long seed = Math.addExact(config.baseSeed, modelIndex);
                GenerationResult result = generateOne(modelIndex, seed);
                if (config.exportXmi) {
                    Path xmiPath = config.runRoot.resolve("models")
                            .resolve(String.format("model_%06d.xmi", modelIndex));
                    Resource resource = casaModelMapper.mapToResource(
                            result.instance,
                            URI.createFileURI(xmiPath.toAbsolutePath().toString()));
                    Path written = xmiWriter.write(resource, xmiPath);
                    result.record.xmiPath = written.toString();
                } else {
                    result.record.xmiPath = "";
                }
                if (config.exportGraphMl) {
                    Path graphPath = config.runRoot.resolve("graphs")
                            .resolve(String.format("model_%06d.graphml", modelIndex));
                    Path written = graphMlWriter.write(result.instance, graphPath);
                    result.record.graphMlPath = written.toString();
                } else {
                    result.record.graphMlPath = "";
                }
                manifest.append(result.record);
                modelIndex++;
            }
        }
    }

    private int nextModelIndex(Path manifestPath) throws IOException {
        if (!Files.exists(manifestPath) || Files.size(manifestPath) == 0L) {
            return 0;
        }
        List<String> lines = Files.readAllLines(manifestPath, StandardCharsets.UTF_8);
        int next = 0;
        for (int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            if (line == null || line.isBlank()) {
                continue;
            }
            int comma = line.indexOf(',');
            String firstCell = comma >= 0 ? line.substring(0, comma) : line;
            int modelIndex = Integer.parseInt(firstCell.trim());
            next = Math.max(next, modelIndex + 1);
        }
        return next;
    }

    private GenerationResult generateOne(int modelIndex, long seed) {
        GenerationRecord record = new GenerationRecord();
        record.modelIndex = modelIndex;
        record.seed = seed;
        record.status = "STARTED";

        ManagedElementSpec spec = specSampler.sample(modelIndex, seed);
        ManagedElementInstance me = instantiator.instantiate(spec);
        PruneResult pruneResult = null;
        if (config.enablePruning) {
            pruneResult = pruner.prune(me);
        }
        ModelStats stats = statsCollector.compute(me);
        ValidationResult validation = validator.validate(spec, me, stats);

        record.spec = spec;
        record.modelId = me.modelId;
        record.stats = stats;
        record.validation = validation;
        record.prune = pruneResult;
        record.status = validation.isValid() ? "OK" : "INVALID";
        return new GenerationResult(record, me);
    }

    private record GenerationResult(GenerationRecord record, ManagedElementInstance instance) {}

    private void writeConfigSnapshot(Path configPath) throws IOException {
        String json = """
                {
                  "note": "non-EMF generation run snapshot",
                  "baseSeed": %d,
                  "targetCount": %d,
                  "enablePruning": %s,
                  "exportXmi": %s,
                  "exportGraphMl": %s,
                  "resume": %s,
                  "catalog": {
                    "purposeCount": %d,
                    "vulnerabilityCount": %d
                  }
                }
                """.formatted(
                config.baseSeed,
                config.targetCount,
                String.valueOf(config.enablePruning),
                String.valueOf(config.exportXmi),
                String.valueOf(config.exportGraphMl),
                String.valueOf(config.resume),
                config.catalog.expectedPurposeCount(),
                config.catalog.expectedVulnerabilityCount());
        Files.writeString(configPath, json, StandardCharsets.UTF_8);
    }
}
