package thesis.evaluation.version3.result_evaluation;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;

import thesis.evaluation.version3.me.ManagedElementTestFixturesV3;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class OfflineResultAnalyzerV3Tests {
    private OfflineResultAnalyzerV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("result.OfflineResultAnalyzerV3.extractsPurposeViolations",
                OfflineResultAnalyzerV3Tests::extractsPurposeViolations);
        TestSupportV3.run("result.OfflineResultAnalyzerV3.suppressesIdentifiableRiskWhenPurposeViolationExists",
                OfflineResultAnalyzerV3Tests::suppressesIdentifiableRiskWhenPurposeViolationExists);
    }

    private static void extractsPurposeViolations() {
        try {
            OfflineResultAnalyzerV3 analyzer = new OfflineResultAnalyzerV3();
            Path path = ManagedElementTestFixturesV3.writePurposeViolationModel(Files.createTempDirectory("v3_analyzer_purpose_"));
            try (ManagedElementArtifactProjectorV3.LoadedModel loaded = new ManagedElementArtifactProjectorV3().load(path)) {
                Set<String> violations = analyzer.analyzePurposeViolationKeys(loaded.root());
                TestSupportV3.check(violations.contains("user_1|comment_1|upload_1|PMarketing"),
                        "Analyzer should extract the expected purpose violation key");
            }
        } catch (Exception e) {
            throw new AssertionError("OfflineResultAnalyzerV3 purpose test failed: " + e.getMessage(), e);
        }
    }

    private static void suppressesIdentifiableRiskWhenPurposeViolationExists() {
        try {
            OfflineResultAnalyzerV3 analyzer = new OfflineResultAnalyzerV3();
            Path path = ManagedElementTestFixturesV3.writePurposeAndRiskViolationModel(Files.createTempDirectory("v3_analyzer_risk_"));
            try (ManagedElementArtifactProjectorV3.LoadedModel loaded = new ManagedElementArtifactProjectorV3().load(path)) {
                wireRiskEdges(loaded.root());
                Set<String> dataSubjects = analyzer.analyzeRiskViolationDataSubjects(loaded.root());
                TestSupportV3.equals(Set.of(), dataSubjects,
                        "Analyzer should suppress identifiable risk when purpose violations are present");
            }
        } catch (Exception e) {
            throw new AssertionError("OfflineResultAnalyzerV3 risk suppression test failed: " + e.getMessage(), e);
        }
    }

    private static void wireRiskEdges(EObject root) {
        EObject vulnerability = first(many(root, "vulnerabilities"));
        EObject component = first(many(root, "components"));
        addReference(vulnerability, "affects", component);
        addReference(component, "affectedBy", vulnerability);
    }

    @SuppressWarnings("unchecked")
    private static java.util.List<EObject> many(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            throw new IllegalStateException("Missing feature " + featureName + " on " + obj.eClass().getName());
        }
        return (java.util.List<EObject>) obj.eGet(feature);
    }

    private static EObject first(java.util.List<EObject> values) {
        if (values.isEmpty()) {
            throw new IllegalStateException("Expected non-empty EObject list");
        }
        return values.get(0);
    }

    @SuppressWarnings("unchecked")
    private static void addReference(EObject obj, String featureName, EObject value) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            throw new IllegalStateException("Missing feature " + featureName + " on " + obj.eClass().getName());
        }
        ((java.util.List<EObject>) obj.eGet(feature)).add(value);
    }

}
