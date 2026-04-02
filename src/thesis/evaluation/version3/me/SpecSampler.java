package thesis.evaluation.version3.me;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;

final class SpecSampler {
    private final GenerationConfig config;

    SpecSampler(GenerationConfig config) {
        this.config = config;
    }

    ManagedElementSpec sample(int modelIndex, long seed) {
        Random rng = new Random(seed);

        Map<String, Integer> dsByType = sampleMap(config.ranges.dataSubjectCountByType, rng);
        Map<String, Integer> fnByType = sampleMap(config.ranges.functionCountByType, rng);
        Map<String, Integer> compByType = sampleMap(config.ranges.componentCountByType, rng);
        if (fnByType.values().stream().mapToInt(Integer::intValue).sum() <= 0) {
            throw new IllegalStateException("Infeasible sample: total function count is zero.");
        }
        if (compByType.values().stream().mapToInt(Integer::intValue).sum() <= 0) {
            throw new IllegalStateException("Infeasible sample: total component count is zero.");
        }
        if (dsByType.values().stream().mapToInt(Integer::intValue).sum() <= 0) {
            throw new IllegalStateException("Infeasible sample: total data subject count is zero.");
        }

        return new ManagedElementSpec(
                modelIndex,
                seed,
                dsByType,
                fnByType,
                compByType,
                config.catalog.expectedPurposeCount(),
                config.catalog.expectedVulnerabilityCount());
    }

    private static Map<String, Integer> sampleMap(Map<String, IntRange> ranges, Random rng) {
        Map<String, Integer> sampled = new LinkedHashMap<>();
        for (Map.Entry<String, IntRange> e : ranges.entrySet()) {
            sampled.put(e.getKey(), e.getValue().sample(rng));
        }
        return sampled;
    }
}
