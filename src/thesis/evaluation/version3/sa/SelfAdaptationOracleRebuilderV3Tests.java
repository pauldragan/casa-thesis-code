package thesis.evaluation.version3.sa;

import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import thesis.evaluation.version3.me.ManagedElementView;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class SelfAdaptationOracleRebuilderV3Tests {
    private SelfAdaptationOracleRebuilderV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.SelfAdaptationOracleRebuilderV3.buildsExpectedAndIdentifiableViolationSets",
                SelfAdaptationOracleRebuilderV3Tests::buildsExpectedAndIdentifiableViolationSets);
    }

    private static void buildsExpectedAndIdentifiableViolationSets() {
        try {
            ManagedElementView sourceView = sourceView();
            SourceManagedElementInstance sourceInstance = sourceInstance();
            SelfAdaptationSpec spec = spec(17);
            spec.addFunctionCount = 1;
            spec.addComponentCount = 1;
            spec.requestedPurposeViolations = 1;
            spec.requestedRiskViolations = 1;

            SelfAdaptationOracleRebuilderV3.OracleCase oracle = rebuild(sourceView, sourceInstance, spec, testInstantiator());

            TestSupportV3.notEmpty(oracle.expectedPurposeViolations(),
                    "Oracle should expose expected purpose violations for afp_acr");
            TestSupportV3.notEmpty(oracle.expectedIdentifiablePurposeViolations(),
                    "Oracle should expose identifiable purpose violations for afp_acr");
            TestSupportV3.notEmpty(oracle.expectedRiskViolations(),
                    "Oracle should expose total expected risk violations for afp_acr");
            TestSupportV3.equals(0, oracle.expectedIdentifiableRiskViolations().size(),
                    "Oracle should suppress identifiable risk violations for mixed afp+acr cases");
            TestSupportV3.check(oracle.expectedProspectiveView().functions.size() > sourceView.functions.size(),
                    "Oracle prospective view should include the added function");
            TestSupportV3.check(oracle.expectedProspectiveView().components.size() > sourceView.components.size(),
                    "Oracle prospective view should include the added component");
        } catch (Exception e) {
            throw new AssertionError("SelfAdaptationOracleRebuilderV3 test failed: " + e.getMessage(), e);
        }
    }

    private static SelfAdaptationOracleRebuilderV3.OracleCase rebuild(
            ManagedElementView sourceView,
            SourceManagedElementInstance sourceInstance,
            SelfAdaptationSpec spec,
            SelfAdaptationInstantiator instantiator) throws Exception {
        Method method = SelfAdaptationOracleRebuilderV3.class.getDeclaredMethod(
                "rebuild",
                ManagedElementView.class,
                SourceManagedElementInstance.class,
                SelfAdaptationSpec.class,
                SelfAdaptationInstantiator.class);
        method.setAccessible(true);
        return (SelfAdaptationOracleRebuilderV3.OracleCase) method.invoke(null, sourceView, sourceInstance, spec, instantiator);
    }

    private static SelfAdaptationInstantiator testInstantiator() {
        return new SelfAdaptationInstantiator(new SelfAdaptationGenerationConfig(
                1L,
                2, 2, 1, 1, 1, 1, 1, 1, 1, 3, 1,
                java.util.List.of("FUploadVideo"),
                java.util.List.of("FUploadVideo"),
                java.util.List.of("CNginx"),
                java.util.List.of("PComments", "PSocial", "PMarketing"),
                Map.of("CNginx", java.util.List.of("CVE-1")),
                "test"));
    }

    private static ManagedElementView sourceView() {
        Map<String, ManagedElementView.DataSubjectView> dataSubjects = new LinkedHashMap<>();
        dataSubjects.put("ds1", new ManagedElementView.DataSubjectView("ds1", "DSUser", "ds1"));

        Map<String, ManagedElementView.PersonalDataView> personalData = new LinkedHashMap<>();
        personalData.put("pd1", new ManagedElementView.PersonalDataView("pd1", "PDComment", "pd1", "ds1"));

        Map<String, ManagedElementView.FunctionView> functions = new LinkedHashMap<>();
        functions.put("f1", new ManagedElementView.FunctionView(
                "f1", "FUploadVideo", "f1",
                new LinkedHashSet<>(Set.of("c1")),
                new LinkedHashSet<>(Set.of("pd1")),
                new LinkedHashSet<>(Set.of("PComments"))));

        Map<String, ManagedElementView.ComponentView> components = new LinkedHashMap<>();
        components.put("c1", new ManagedElementView.ComponentView("c1", "CNginx", "c1"));

        Map<String, ManagedElementView.PurposeView> purposes = new LinkedHashMap<>();
        purposes.put("PComments", new ManagedElementView.PurposeView("PComments", "PComments", "PComments"));
        purposes.put("PSocial", new ManagedElementView.PurposeView("PSocial", "PSocial", "PSocial"));
        purposes.put("PMarketing", new ManagedElementView.PurposeView("PMarketing", "PMarketing", "PMarketing"));

        Map<String, ManagedElementView.ConsentView> consents = new LinkedHashMap<>();
        consents.put("cons1", new ManagedElementView.ConsentView("cons1", "ds1", "pd1", "PComments"));

        return new ManagedElementView("me_test", dataSubjects, personalData, functions, components, purposes, Map.of(), consents);
    }

    private static SourceManagedElementInstance sourceInstance() {
        SourceManagedElementInstance source = new SourceManagedElementInstance("me_test");
        source.dataSubjects.put("ds1", new SourceManagedElementInstance.DataSubjectView("ds1", "DSUser", "ds1"));
        source.personalData.put("pd1", new SourceManagedElementInstance.PersonalDataView("pd1", "PDComment", "pd1", "ds1"));
        source.components.put("c1", new SourceManagedElementInstance.ComponentView("c1", "CNginx", "c1"));
        source.functions.put("f1", new SourceManagedElementInstance.FunctionView(
                "f1", "FUploadVideo", "f1",
                new LinkedHashSet<>(Set.of("c1")),
                new LinkedHashSet<>(Set.of("pd1")),
                new LinkedHashSet<>(Set.of("PComments"))));
        source.purposes.put("PComments", new SourceManagedElementInstance.PurposeView("PComments", "PComments", "PComments"));
        source.purposes.put("PSocial", new SourceManagedElementInstance.PurposeView("PSocial", "PSocial", "PSocial"));
        source.purposes.put("PMarketing", new SourceManagedElementInstance.PurposeView("PMarketing", "PMarketing", "PMarketing"));
        source.consents.put("cons1", new SourceManagedElementInstance.ConsentView("cons1", "ds1", "pd1", "PComments"));
        return source;
    }

    private static SelfAdaptationSpec spec(int combinationIndex) {
        SelfAdaptationSpec spec = new SelfAdaptationSpec();
        spec.modelIndex = 0;
        spec.adaptationIndex = combinationIndex;
        spec.sourceModelSeed = 1L;
        spec.seed = 100L + combinationIndex;
        spec.sourceModelId = "me_test";
        spec.combination = SelfAdaptationCombination.fromIndex(combinationIndex);
        return spec;
    }
}
