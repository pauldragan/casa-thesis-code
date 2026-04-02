package thesis.evaluation.version3.sa;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class SelfAdaptationUnitTestsV3 {
    private SelfAdaptationUnitTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.afsCreatesSafeAddedFunctionWithoutPurposeViolations",
                SelfAdaptationUnitTestsV3::afsCreatesSafeAddedFunctionWithoutPurposeViolations);
        TestSupportV3.run("sa.afpCreatesPurposeViolatingAddedFunction",
                SelfAdaptationUnitTestsV3::afpCreatesPurposeViolatingAddedFunction);
        TestSupportV3.run("sa.acrCreatesRiskViolations",
                SelfAdaptationUnitTestsV3::acrCreatesRiskViolations);
        TestSupportV3.run("sa.mixedAfpAcrKeepsTotalRiskButSuppressesIdentifiableRisk",
                SelfAdaptationUnitTestsV3::mixedAfpAcrKeepsTotalRiskButSuppressesIdentifiableRisk);
        TestSupportV3.run("sa.riskOracleDoesNotTruncateToRequestedCount",
                SelfAdaptationUnitTestsV3::riskOracleDoesNotTruncateToRequestedCount);
    }

    private static void afsCreatesSafeAddedFunctionWithoutPurposeViolations() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig())
                .instantiate(sourceModel(), spec(0, 1, 0, 0, 0, 0, 0));

        TestSupportV3.equals(1, instance.addedFunctions.size(), "afs should create one added function in fixture");
        TestSupportV3.check(instance.expectedPurposeViolations.isEmpty(), "afs fixture should not create purpose violations");
        TestSupportV3.check(instance.expectedIdentifiablePurposeViolations.isEmpty(),
                "afs fixture should not create identifiable purpose violations");
    }

    private static void afpCreatesPurposeViolatingAddedFunction() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig())
                .instantiate(sourceModel(), spec(1, 1, 0, 0, 0, 1, 0));

        TestSupportV3.equals(1, instance.addedFunctions.size(), "afp should create one added function in fixture");
        TestSupportV3.equals(1, instance.expectedPurposeViolations.size(), "afp should create one purpose violation in fixture");
        TestSupportV3.equals(1, instance.expectedIdentifiablePurposeViolations.size(),
                "afp should create one identifiable purpose violation in fixture");
        ExpectedViolation violation = instance.expectedPurposeViolations.get(0);
        TestSupportV3.equals("ds1", violation.dataSubjectId(), "afp violation should target ds1");
        TestSupportV3.equals("pd1", violation.personalDataId(), "afp violation should target pd1");
        TestSupportV3.equals(instance.addedFunctions.get(0).id(), violation.functionId(),
                "afp violation should reference the added function");
        TestSupportV3.check(!"PComments".equals(violation.purposeId()),
                "afp should choose a purpose incompatible with PComments consent in this fixture");
    }

    private static void acrCreatesRiskViolations() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig())
                .instantiate(sourceModel(), spec(15, 0, 0, 1, 0, 0, 1));

        TestSupportV3.equals(1, instance.addedComponents.size(), "acr should create one added component in fixture");
        TestSupportV3.notEmpty(instance.expectedRiskViolations, "acr should create risk violations in fixture");
        TestSupportV3.equals(instance.expectedRiskViolations.size(), instance.expectedIdentifiableRiskViolations.size(),
                "pure acr fixture should keep risk violations identifiable");
        TestSupportV3.equals("ds1", instance.expectedRiskViolations.get(0).dataSubjectId(),
                "acr risk violation should target ds1");
    }

    private static void mixedAfpAcrKeepsTotalRiskButSuppressesIdentifiableRisk() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig())
                .instantiate(sourceModel(), spec(17, 1, 0, 1, 0, 1, 1));

        TestSupportV3.equals(1, instance.expectedPurposeViolations.size(),
                "afp_acr should create one purpose violation in fixture");
        TestSupportV3.notEmpty(instance.expectedRiskViolations, "afp_acr should still have total expected risk violations");
        TestSupportV3.check(instance.expectedIdentifiableRiskViolations.isEmpty(),
                "afp_acr should suppress identifiable risk violations");
    }

    private static void riskOracleDoesNotTruncateToRequestedCount() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig())
                .instantiate(sourceModelWithTwoSubjects(), spec(15, 0, 0, 1, 0, 0, 1));

        TestSupportV3.equals(2, instance.expectedRiskViolations.size(),
                "risk oracle should keep the full structural DS set, not truncate to requested count");
        TestSupportV3.equals(2, instance.expectedIdentifiableRiskViolations.size(),
                "pure acr fixture should keep all risk violations identifiable");
    }

    private static SelfAdaptationGenerationConfig testConfig() {
        return new SelfAdaptationGenerationConfig(
                1L,
                2,
                2,
                1,
                1,
                1,
                1,
                1,
                1,
                1,
                3,
                1,
                List.of("FUploadVideo"),
                List.of("FUploadVideo"),
                List.of("CNginx"),
                List.of("PComments", "PSocial", "PMarketing"),
                Map.of("CNginx", List.of("CVE-1")),
                "test");
    }

    private static SourceManagedElementInstance sourceModel() {
        SourceManagedElementInstance source = new SourceManagedElementInstance("me_000000");
        source.dataSubjects.put("ds1", new SourceManagedElementInstance.DataSubjectView("ds1", "DSUser", "ds1"));
        source.personalData.put("pd1", new SourceManagedElementInstance.PersonalDataView("pd1", "PDComment", "pd1", "ds1"));
        source.components.put("c1", new SourceManagedElementInstance.ComponentView("c1", "CNginx", "c1"));
        source.functions.put("f1", new SourceManagedElementInstance.FunctionView(
                "f1",
                "FUploadVideo",
                "f1",
                new LinkedHashSet<>(Set.of("c1")),
                new LinkedHashSet<>(Set.of("pd1")),
                new LinkedHashSet<>(Set.of("PComments"))));
        source.purposes.put("PComments", new SourceManagedElementInstance.PurposeView("PComments", "PComments", "PComments"));
        source.purposes.put("PSocial", new SourceManagedElementInstance.PurposeView("PSocial", "PSocial", "PSocial"));
        source.purposes.put("PMarketing", new SourceManagedElementInstance.PurposeView("PMarketing", "PMarketing", "PMarketing"));
        source.consents.put("cons1", new SourceManagedElementInstance.ConsentView("cons1", "ds1", "pd1", "PComments"));
        return source;
    }

    private static SourceManagedElementInstance sourceModelWithTwoSubjects() {
        SourceManagedElementInstance source = sourceModel();
        source.dataSubjects.put("ds2", new SourceManagedElementInstance.DataSubjectView("ds2", "DSModerator", "ds2"));
        source.personalData.put("pd2", new SourceManagedElementInstance.PersonalDataView("pd2", "PDComment", "pd2", "ds2"));
        source.functions.put("f1", new SourceManagedElementInstance.FunctionView(
                "f1",
                "FUploadVideo",
                "f1",
                new LinkedHashSet<>(Set.of("c1")),
                new LinkedHashSet<>(Set.of("pd1", "pd2")),
                new LinkedHashSet<>(Set.of("PComments"))));
        source.consents.put("cons2", new SourceManagedElementInstance.ConsentView("cons2", "ds2", "pd2", "PComments"));
        return source;
    }

    private static SelfAdaptationSpec spec(
            int combinationIndex,
            int addFunctionCount,
            int removeFunctionCount,
            int addComponentCount,
            int removeComponentCount,
            int requestedPurposeViolations,
            int requestedRiskViolations) {
        SelfAdaptationSpec spec = new SelfAdaptationSpec();
        spec.modelIndex = 0;
        spec.adaptationIndex = combinationIndex;
        spec.sourceModelSeed = 1L;
        spec.seed = 100L + combinationIndex;
        spec.sourceModelId = "me_000000";
        spec.combination = SelfAdaptationCombination.fromIndex(combinationIndex);
        spec.addFunctionCount = addFunctionCount;
        spec.removeFunctionCount = removeFunctionCount;
        spec.addComponentCount = addComponentCount;
        spec.removeComponentCount = removeComponentCount;
        spec.requestedPurposeViolations = requestedPurposeViolations;
        spec.requestedRiskViolations = requestedRiskViolations;
        return spec;
    }
}
