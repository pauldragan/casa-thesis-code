package thesis.evaluation.version3.me;

import java.nio.file.Path;
import java.util.Map;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class SpecSamplerTestsV3 {
    private SpecSamplerTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("me.SpecSampler.samplesCountsWithinConfiguredRanges",
                SpecSamplerTestsV3::samplesCountsWithinConfiguredRanges);
        TestSupportV3.run("me.SpecSampler.keepsMandatoryMinimaPositive",
                SpecSamplerTestsV3::keepsMandatoryMinimaPositive);
    }

    private static void samplesCountsWithinConfiguredRanges() {
        GenerationConfig config = GenerationConfig.tiny(Path.of("."));
        ManagedElementSpec spec = new SpecSampler(config).sample(0, 20260311L);

        for (Map.Entry<String, Integer> entry : spec.dataSubjectCountByType.entrySet()) {
            IntRange range = config.ranges.dataSubjectCountByType.get(entry.getKey());
            TestSupportV3.check(entry.getValue() >= range.min && entry.getValue() <= range.max,
                    "Data subject count should stay within configured range for " + entry.getKey());
        }
        for (Map.Entry<String, Integer> entry : spec.functionCountByType.entrySet()) {
            IntRange range = config.ranges.functionCountByType.get(entry.getKey());
            TestSupportV3.check(entry.getValue() >= range.min && entry.getValue() <= range.max,
                    "Function count should stay within configured range for " + entry.getKey());
        }
        for (Map.Entry<String, Integer> entry : spec.componentCountByType.entrySet()) {
            IntRange range = config.ranges.componentCountByType.get(entry.getKey());
            TestSupportV3.check(entry.getValue() >= range.min && entry.getValue() <= range.max,
                    "Component count should stay within configured range for " + entry.getKey());
        }
    }

    private static void keepsMandatoryMinimaPositive() {
        GenerationConfig config = GenerationConfig.tiny(Path.of("."));
        ManagedElementSpec spec = new SpecSampler(config).sample(0, 20260311L);

        TestSupportV3.check(spec.totalDataSubjects() > 0, "SpecSampler should keep total data subjects positive");
        TestSupportV3.check(spec.totalFunctions() > 0, "SpecSampler should keep total functions positive");
        TestSupportV3.check(spec.totalComponents() > 0, "SpecSampler should keep total components positive");
        for (String mandatoryType : config.catalog.mandatoryFunctionTypes) {
            TestSupportV3.check(spec.functionCountByType.getOrDefault(mandatoryType, 0) > 0,
                    "Mandatory function type should remain present: " + mandatoryType);
        }
    }
}
