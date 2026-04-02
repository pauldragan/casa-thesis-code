package thesis.evaluation.version3.sa;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class SelfAdaptationInstantiatorTestsV3 {
    private SelfAdaptationInstantiatorTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.SelfAdaptationInstantiator.afsCreatesSafeAddedFunctionWithoutPurposeViolations",
                SelfAdaptationInstantiatorTestsV3::afsCreatesSafeAddedFunctionWithoutPurposeViolations);
        TestSupportV3.run("sa.SelfAdaptationInstantiator.afpCreatesPurposeViolatingAddedFunction",
                SelfAdaptationInstantiatorTestsV3::afpCreatesPurposeViolatingAddedFunction);
        TestSupportV3.run("sa.SelfAdaptationInstantiator.acrCreatesRiskViolations",
                SelfAdaptationInstantiatorTestsV3::acrCreatesRiskViolations);
        TestSupportV3.run("sa.SelfAdaptationInstantiator.acsCreatesSafeAddedComponentWithoutVulnerabilities",
                SelfAdaptationInstantiatorTestsV3::acsCreatesSafeAddedComponentWithoutVulnerabilities);
        TestSupportV3.run("sa.SelfAdaptationInstantiator.rfRemovesExistingFunction",
                SelfAdaptationInstantiatorTestsV3::rfRemovesExistingFunction);
        TestSupportV3.run("sa.SelfAdaptationInstantiator.rfDoesNotRemoveWhenMinimumWouldBeViolated",
                SelfAdaptationInstantiatorTestsV3::rfDoesNotRemoveWhenMinimumWouldBeViolated);
        TestSupportV3.run("sa.SelfAdaptationInstantiator.rcRemovesExistingComponent",
                SelfAdaptationInstantiatorTestsV3::rcRemovesExistingComponent);
        TestSupportV3.run("sa.SelfAdaptationInstantiator.rcDoesNotRemoveWhenMinimumWouldBeViolated",
                SelfAdaptationInstantiatorTestsV3::rcDoesNotRemoveWhenMinimumWouldBeViolated);
        TestSupportV3.run("sa.SelfAdaptationInstantiator.afsAfpCreatesBothSafeAndViolatingFunctions",
                SelfAdaptationInstantiatorTestsV3::afsAfpCreatesBothSafeAndViolatingFunctions);
    }

    private static void afsCreatesSafeAddedFunctionWithoutPurposeViolations() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModel(), spec(0,1,0,0,0,0,0));
        TestSupportV3.equals(1, instance.addedFunctions.size(), "afs should create one added function");
        TestSupportV3.check(instance.expectedPurposeViolations.isEmpty(), "afs should not create purpose violations");
    }

    private static void afpCreatesPurposeViolatingAddedFunction() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModel(), spec(1,1,0,0,0,1,0));
        TestSupportV3.equals(1, instance.addedFunctions.size(), "afp should create one added function");
        TestSupportV3.equals(1, instance.expectedPurposeViolations.size(), "afp should create one purpose violation");
        TestSupportV3.check(!"PComments".equals(instance.expectedPurposeViolations.get(0).purposeId()),
                "afp should choose an incompatible purpose in the fixture");
    }

    private static void acrCreatesRiskViolations() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModel(), spec(15,0,0,1,0,0,1));
        TestSupportV3.equals(1, instance.addedComponents.size(), "acr should create one added component");
        TestSupportV3.notEmpty(instance.expectedRiskViolations, "acr should create expected risk violations");
        ExpectedViolation violation = instance.expectedRiskViolations.get(0);
        TestSupportV3.equals("RISK", violation.kind(), "acr should emit risk violation tuples");
        TestSupportV3.check(!violation.componentId().isBlank(), "acr should reference a non-empty added component id");
        TestSupportV3.check(instance.addedComponents.stream().anyMatch(component -> component.id().equals(violation.componentId())),
                "acr should reference one of the actually added components");
    }

    private static void acsCreatesSafeAddedComponentWithoutVulnerabilities() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModel(), spec(7,0,0,1,0,0,0));
        TestSupportV3.equals(1, instance.addedComponents.size(), "acs should create one added component");
        TestSupportV3.check(instance.addedComponents.get(0).vulnerabilityCves().isEmpty(),
                "acs should create a safe added component without vulnerabilities");
        TestSupportV3.check(instance.expectedRiskViolations.isEmpty(),
                "acs should not create expected risk violations");
    }

    private static void rfRemovesExistingFunction() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModelWithRemovableFunction(), spec(3,0,1,0,0,0,0));
        TestSupportV3.notEmpty(instance.removedFunctionIds, "rf should remove at least one function");
        TestSupportV3.check(instance.removedFunctionIds.contains("f1"), "rf should remove the only removable fixture function");
    }

    private static void rfDoesNotRemoveWhenMinimumWouldBeViolated() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModel(), spec(3,0,1,0,0,0,0));
        TestSupportV3.check(instance.removedFunctionIds.isEmpty(),
                "rf should not remove functions when the source model is below the removal feasibility threshold");
    }

    private static void rcRemovesExistingComponent() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModelWithRemovableComponent(), spec(31,0,0,0,1,0,0));
        TestSupportV3.notEmpty(instance.removedComponentIds, "rc should remove at least one component");
        TestSupportV3.check(instance.removedComponentIds.contains("c2"), "rc should remove the extra removable fixture component");
    }

    private static void rcDoesNotRemoveWhenMinimumWouldBeViolated() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModel(), spec(31,0,0,0,1,0,0));
        TestSupportV3.check(instance.removedComponentIds.isEmpty(),
                "rc should not remove components when the source model is below the removal feasibility threshold");
    }

    private static void afsAfpCreatesBothSafeAndViolatingFunctions() {
        SelfAdaptationInstance instance = new SelfAdaptationInstantiator(testConfig()).instantiate(sourceModel(), spec(2,2,0,0,0,1,0));
        TestSupportV3.equals(2, instance.addedFunctions.size(), "afs_afp should create two added functions in the fixture");
        long violating = instance.addedFunctions.stream()
                .filter(fn -> instance.expectedPurposeViolations.stream().anyMatch(v -> fn.id().equals(v.functionId())))
                .count();
        long safe = instance.addedFunctions.size() - violating;
        TestSupportV3.equals(1L, safe, "afs_afp should realize one safe added function");
        TestSupportV3.equals(1L, violating, "afs_afp should realize one violating added function");
    }

    private static SelfAdaptationGenerationConfig testConfig() {
        return new SelfAdaptationGenerationConfig(1L,2,2,1,1,1,1,1,1,1,3,1,
                List.of("FUploadVideo"), List.of("FUploadVideo"), List.of("CNginx"),
                List.of("PComments","PSocial","PMarketing"), Map.of("CNginx", List.of("CVE-1")), "test");
    }

    private static SourceManagedElementInstance sourceModel() {
        SourceManagedElementInstance source = new SourceManagedElementInstance("me_000000");
        source.dataSubjects.put("ds1", new SourceManagedElementInstance.DataSubjectView("ds1", "DSUser", "ds1"));
        source.personalData.put("pd1", new SourceManagedElementInstance.PersonalDataView("pd1", "PDComment", "pd1", "ds1"));
        source.components.put("c1", new SourceManagedElementInstance.ComponentView("c1", "CNginx", "c1"));
        source.functions.put("f1", new SourceManagedElementInstance.FunctionView("f1","FUploadVideo","f1",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.purposes.put("PComments", new SourceManagedElementInstance.PurposeView("PComments","PComments","PComments"));
        source.purposes.put("PSocial", new SourceManagedElementInstance.PurposeView("PSocial","PSocial","PSocial"));
        source.purposes.put("PMarketing", new SourceManagedElementInstance.PurposeView("PMarketing","PMarketing","PMarketing"));
        source.consents.put("cons1", new SourceManagedElementInstance.ConsentView("cons1", "ds1", "pd1", "PComments"));
        return source;
    }

    private static SourceManagedElementInstance sourceModelWithRemovableComponent() {
        SourceManagedElementInstance source = sourceModel();
        source.components.put("c2", new SourceManagedElementInstance.ComponentView("c2", "CNginx", "c2"));
        source.functions.put("f2", new SourceManagedElementInstance.FunctionView("f2", "FUploadVideo", "f2",
                new LinkedHashSet<>(Set.of("c2")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f3", new SourceManagedElementInstance.FunctionView("f3", "FUploadVideo", "f3",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f4", new SourceManagedElementInstance.FunctionView("f4", "FUploadVideo", "f4",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f5", new SourceManagedElementInstance.FunctionView("f5", "FUploadVideo", "f5",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f6", new SourceManagedElementInstance.FunctionView("f6", "FUploadVideo", "f6",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f7", new SourceManagedElementInstance.FunctionView("f7", "FUploadVideo", "f7",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f8", new SourceManagedElementInstance.FunctionView("f8", "FUploadVideo", "f8",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        return source;
    }

    private static SourceManagedElementInstance sourceModelWithRemovableFunction() {
        SourceManagedElementInstance source = sourceModel();
        source.functions.put("f2", new SourceManagedElementInstance.FunctionView("f2", "FUploadVideo", "f2",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f3", new SourceManagedElementInstance.FunctionView("f3", "FUploadVideo", "f3",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f4", new SourceManagedElementInstance.FunctionView("f4", "FUploadVideo", "f4",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        source.functions.put("f5", new SourceManagedElementInstance.FunctionView("f5", "FUploadVideo", "f5",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        return source;
    }

    private static SelfAdaptationSpec spec(int combinationIndex,int addFunctionCount,int removeFunctionCount,int addComponentCount,int removeComponentCount,int requestedPurposeViolations,int requestedRiskViolations) {
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
