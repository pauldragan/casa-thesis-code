package thesis.evaluation.version3.sa;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import thesis.evaluation.version3.me.ManagedElementView;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class SourceManagedElementAdapterTestsV3 {
    private SourceManagedElementAdapterTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.SourceManagedElementAdapter.buildsProfileWithCorrectCounts",
                SourceManagedElementAdapterTestsV3::buildsProfileWithCorrectCounts);
        TestSupportV3.run("sa.SourceManagedElementAdapter.buildsInstancePreservingRelationsAndConsentTypes",
                SourceManagedElementAdapterTestsV3::buildsInstancePreservingRelationsAndConsentTypes);
    }

    private static void buildsProfileWithCorrectCounts() {
        SourceManagedElementProfile profile = SourceManagedElementAdapter.toProfile(view());
        TestSupportV3.equals("me_test", profile.modelId, "Adapter should preserve model id in the profile");
        TestSupportV3.equals(1, profile.totalDataSubjects, "Adapter should count data subjects");
        TestSupportV3.equals(2, profile.totalFunctions, "Adapter should count functions");
        TestSupportV3.equals(2, profile.totalComponents, "Adapter should count components");
        TestSupportV3.equals(2, profile.functionCountByType.get("FUploadVideo"),
                "Adapter should aggregate function counts by type");
        TestSupportV3.equals(2, profile.componentCountByType.get("CNginx"),
                "Adapter should aggregate component counts by type");
    }

    private static void buildsInstancePreservingRelationsAndConsentTypes() {
        SourceManagedElementInstance instance = SourceManagedElementAdapter.toInstance(view());
        TestSupportV3.equals("PDComment", instance.personalData.get("pd1").type(),
                "Adapter should preserve personal data types");
        TestSupportV3.check(instance.functions.get("f1").realizedByComponentIds().contains("c1"),
                "Adapter should preserve realizedBy relations");
        TestSupportV3.check(instance.functions.get("f1").processesPersonalDataIds().contains("pd1"),
                "Adapter should preserve processes relations");
        TestSupportV3.check(instance.functions.get("f1").hasPurposeIds().contains("PComments"),
                "Adapter should preserve hasPurpose relations");
        TestSupportV3.check(instance.consentPurposeTypesForPersonalData("pd1").contains("PComments"),
                "Adapter instance should resolve consent purpose types through the purpose map");
        TestSupportV3.check(instance.dataSubjectIdsProcessedByFunction("f1").contains("ds1"),
                "Adapter instance should resolve processed data subjects through PD ownership");
    }

    private static ManagedElementView view() {
        Map<String, ManagedElementView.DataSubjectView> dataSubjects = new LinkedHashMap<>();
        dataSubjects.put("ds1", new ManagedElementView.DataSubjectView("ds1", "DSUser", "user_1"));

        Map<String, ManagedElementView.PersonalDataView> personalData = new LinkedHashMap<>();
        personalData.put("pd1", new ManagedElementView.PersonalDataView("pd1", "PDComment", "comment_1", "ds1"));

        Map<String, ManagedElementView.FunctionView> functions = new LinkedHashMap<>();
        functions.put("f1", new ManagedElementView.FunctionView("f1", "FUploadVideo", "upload_1",
                new LinkedHashSet<>(Set.of("c1")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));
        functions.put("f2", new ManagedElementView.FunctionView("f2", "FUploadVideo", "upload_2",
                new LinkedHashSet<>(Set.of("c2")), new LinkedHashSet<>(Set.of("pd1")), new LinkedHashSet<>(Set.of("PComments"))));

        Map<String, ManagedElementView.ComponentView> components = new LinkedHashMap<>();
        components.put("c1", new ManagedElementView.ComponentView("c1", "CNginx", "nginx_1"));
        components.put("c2", new ManagedElementView.ComponentView("c2", "CNginx", "nginx_2"));

        Map<String, ManagedElementView.PurposeView> purposes = new LinkedHashMap<>();
        purposes.put("PComments", new ManagedElementView.PurposeView("PComments", "PComments", "PComments"));

        Map<String, ManagedElementView.ConsentView> consents = new LinkedHashMap<>();
        consents.put("cons1", new ManagedElementView.ConsentView("cons1", "ds1", "pd1", "PComments"));

        return new ManagedElementView("me_test", dataSubjects, personalData, functions, components, purposes, Map.of(), consents);
    }
}
