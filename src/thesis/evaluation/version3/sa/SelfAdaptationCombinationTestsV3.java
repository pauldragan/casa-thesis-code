package thesis.evaluation.version3.sa;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class SelfAdaptationCombinationTestsV3 {
    private SelfAdaptationCombinationTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.SelfAdaptationCombination.mapsSingleFlagCaseSlug",
                SelfAdaptationCombinationTestsV3::mapsSingleFlagCaseSlug);
        TestSupportV3.run("sa.SelfAdaptationCombination.coversAll63Combinations",
                SelfAdaptationCombinationTestsV3::coversAll63Combinations);
    }

    private static void mapsSingleFlagCaseSlug() {
        TestSupportV3.equals("afs", SelfAdaptationCombination.fromIndex(0).caseSlug(), "Combination index 0 should map to afs");
        TestSupportV3.equals("afp", SelfAdaptationCombination.fromIndex(1).caseSlug(), "Combination index 1 should map to afp");
        TestSupportV3.equals("rc", SelfAdaptationCombination.fromIndex(31).caseSlug(), "Combination index 31 should map to rc");
    }

    private static void coversAll63Combinations() {
        TestSupportV3.equals(63, SelfAdaptationCombination.COUNT, "There should be 63 non-empty combinations");
        for (int i = 0; i < SelfAdaptationCombination.COUNT; i++) {
            TestSupportV3.check(!SelfAdaptationCombination.fromIndex(i).caseSlug().isBlank(),
                    "Each combination should have a non-blank case slug: index=" + i);
        }
    }
}
