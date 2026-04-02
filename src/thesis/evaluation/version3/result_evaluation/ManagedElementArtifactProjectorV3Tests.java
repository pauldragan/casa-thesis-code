package thesis.evaluation.version3.result_evaluation;

import java.nio.file.Files;
import java.nio.file.Path;

import thesis.evaluation.version3.me.ManagedElementTestFixturesV3;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class ManagedElementArtifactProjectorV3Tests {
    private ManagedElementArtifactProjectorV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("result.ManagedElementArtifactProjectorV3.projectsMappedCasaArtifactCorrectly",
                ManagedElementArtifactProjectorV3Tests::projectsMappedCasaArtifactCorrectly);
        TestSupportV3.run("result.ManagedElementArtifactProjectorV3.projectsSpecificPurposeSubtypesAndVulnerabilityAffects",
                ManagedElementArtifactProjectorV3Tests::projectsSpecificPurposeSubtypesAndVulnerabilityAffects);
    }

    private static void projectsMappedCasaArtifactCorrectly() {
        try {
            Path dir = Files.createTempDirectory("v3_projector_");
            Path xmi = ManagedElementTestFixturesV3.writeCrossStageSourceModel(dir);
            NormalizedManagedElementModel model = new ManagedElementArtifactProjectorV3().project(xmi);
            TestSupportV3.check(model.functionTypes.containsKey("stream_1"), "Projector should recover function ids by name");
            TestSupportV3.equals("FStreamVideo", model.functionTypes.get("stream_1"), "Projector should infer the correct function type");
            TestSupportV3.equals("CNginx", model.componentTypes.get("nginx_1"), "Projector should infer the correct component type");
            TestSupportV3.equals("PDComment", model.personalDataTypes.get("comment_1"), "Projector should infer the correct PD type");
            TestSupportV3.check(model.consentKeys.contains(ManagedElementArtifactProjectorV3.consentKey("user_1", "comment_1", "PComments")),
                    "Projector should recover consent keys");
        } catch (Exception e) {
            throw new AssertionError("ManagedElementArtifactProjectorV3 test failed: " + e.getMessage(), e);
        }
    }

    private static void projectsSpecificPurposeSubtypesAndVulnerabilityAffects() {
        try {
            Path dir = Files.createTempDirectory("v3_projector_subtypes_");
            Path xmi = ManagedElementTestFixturesV3.writePurposeSubtypeCoverageModel(dir);
            try (ManagedElementArtifactProjectorV3.LoadedModel loaded = new ManagedElementArtifactProjectorV3().load(xmi)) {
                wireRiskEdges(loaded.root());
                NormalizedManagedElementModel model = new ManagedElementArtifactProjectorV3().project(loaded.root());
                TestSupportV3.equals("PComments", model.purposeTypes.get("PComments"),
                        "Projector should preserve PComments rather than collapsing it to PSocial");
                TestSupportV3.equals("PBehaviorTargetedAds", model.purposeTypes.get("PBehaviorTargetedAds"),
                        "Projector should preserve behavior-targeted ads subtype");
                TestSupportV3.equals("PThirdPartyProfiling", model.purposeTypes.get("PThirdPartyProfiling"),
                        "Projector should preserve third-party profiling subtype");
                TestSupportV3.check(model.vulnerabilityAffects.containsKey("CVE-2024-7347"),
                        "Projector should recover vulnerability CVEs");
                TestSupportV3.check(model.vulnerabilityAffects.get("CVE-2024-7347").contains("nginx_1"),
                        "Projector should recover vulnerability-affects component links");
            }
        } catch (Exception e) {
            throw new AssertionError("ManagedElementArtifactProjectorV3 subtype test failed: " + e.getMessage(), e);
        }
    }

    private static void wireRiskEdges(org.eclipse.emf.ecore.EObject root) {
        org.eclipse.emf.ecore.EObject vulnerability = many(root, "vulnerabilities").get(0);
        org.eclipse.emf.ecore.EObject component = many(root, "components").get(0);
        addReference(vulnerability, "affects", component);
        addReference(component, "affectedBy", vulnerability);
    }

    @SuppressWarnings("unchecked")
    private static java.util.List<org.eclipse.emf.ecore.EObject> many(org.eclipse.emf.ecore.EObject obj, String featureName) {
        org.eclipse.emf.ecore.EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        return (java.util.List<org.eclipse.emf.ecore.EObject>) obj.eGet(feature);
    }

    @SuppressWarnings("unchecked")
    private static void addReference(org.eclipse.emf.ecore.EObject obj, String featureName, org.eclipse.emf.ecore.EObject value) {
        org.eclipse.emf.ecore.EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        ((java.util.List<org.eclipse.emf.ecore.EObject>) obj.eGet(feature)).add(value);
    }
}
