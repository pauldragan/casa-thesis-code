package thesis.evaluation.version3.me;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class ManagedElementInstantiatorTestsV3 {
    private ManagedElementInstantiatorTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("me.ManagedElementInstantiator.samplesFunctionRelationsLocallyPerFunction",
                ManagedElementInstantiatorTestsV3::samplesFunctionRelationsLocallyPerFunction);
        TestSupportV3.run("me.ManagedElementInstantiator.baselineConsentMatchesUnionOfProcessingFunctionPurposesPerPd",
                ManagedElementInstantiatorTestsV3::baselineConsentMatchesUnionOfProcessingFunctionPurposesPerPd);
    }

    private static void samplesFunctionRelationsLocallyPerFunction() {
        ManagedElementInstance me = new ManagedElementInstantiator(testConfig()).instantiate(testSpec(42L));

        Set<Integer> realizedByCounts = me.functions.values().stream().map(fn -> fn.realizedByComponentIds.size()).collect(Collectors.toSet());
        Set<Integer> processCounts = me.functions.values().stream().map(fn -> fn.processesPersonalDataIds.size()).collect(Collectors.toSet());
        Set<Integer> purposeCounts = me.functions.values().stream().map(fn -> fn.hasPurposeIds.size()).collect(Collectors.toSet());

        TestSupportV3.check(realizedByCounts.size() > 1, "ManagedElementInstantiator should sample realizedBy per function");
        TestSupportV3.check(processCounts.size() > 1, "ManagedElementInstantiator should sample processes per function");
        TestSupportV3.check(purposeCounts.size() > 1, "ManagedElementInstantiator should sample hasPurpose per function");
    }

    private static void baselineConsentMatchesUnionOfProcessingFunctionPurposesPerPd() {
        ManagedElementInstance me = new ManagedElementInstantiator(testConfig()).instantiate(testSpec(42L));
        for (ManagedElementInstance.PersonalDataNode pd : me.personalData.values()) {
            Set<String> expectedPurposes = me.functionsProcessingPersonalData(pd.id).stream()
                    .flatMap(fn -> fn.hasPurposeIds.stream())
                    .collect(Collectors.toSet());
            Set<String> actualPurposes = me.consents.values().stream()
                    .filter(consent -> consent.forPersonalDataId.equals(pd.id))
                    .map(consent -> consent.givenForPurposeId)
                    .collect(Collectors.toSet());
            TestSupportV3.equals(expectedPurposes, actualPurposes,
                    "ManagedElementInstantiator should create baseline consents from processing-function purposes for " + pd.id);
        }
    }

    private static ManagedElementSpec testSpec(long seed) {
        Map<String, Integer> ds = new LinkedHashMap<>();
        ds.put("DSUser", 3);
        ds.put("DSModerator", 2);
        Map<String, Integer> fn = new LinkedHashMap<>();
        fn.put("FUploadVideo", 8);
        fn.put("FComments", 8);
        Map<String, Integer> comp = new LinkedHashMap<>();
        comp.put("CNginx", 6);
        comp.put("CRedis", 6);
        return new ManagedElementSpec(0, seed, ds, fn, comp, 4, 1);
    }

    private static GenerationConfig testConfig() {
        GenerationConfig.Catalog catalog = new GenerationConfig.Catalog(
                java.util.List.of("DSUser", "DSModerator"),
                java.util.List.of("FUploadVideo"),
                java.util.List.of("FComments"),
                java.util.List.of("CNginx", "CRedis"),
                java.util.List.of("PDUsername"),
                java.util.List.of("PDComment"),
                java.util.List.of("PComments", "PSocial", "PMarketing", "PTargetedAds"),
                Map.of("CNginx", java.util.List.of("CVE-1"), "CRedis", java.util.List.of("CVE-2")));
        GenerationConfig.Ranges ranges = new GenerationConfig.Ranges(
                Map.of("DSUser", new IntRange(3, 3), "DSModerator", new IntRange(2, 2)),
                Map.of("FUploadVideo", new IntRange(8, 8), "FComments", new IntRange(8, 8)),
                Map.of("CNginx", new IntRange(6, 6), "CRedis", new IntRange(6, 6)),
                Map.of("PDUsername", new IntRange(1, 3), "PDComment", new IntRange(0, 2)),
                new IntRange(1, 3), new IntRange(1, 3), new IntRange(1, 3));
        return new GenerationConfig(1L, 1, false, false, false, false, Path.of("."), catalog, ranges, "test");
    }
}
