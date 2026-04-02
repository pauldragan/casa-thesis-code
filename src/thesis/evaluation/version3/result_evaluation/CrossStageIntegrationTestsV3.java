package thesis.evaluation.version3.result_evaluation;

import java.nio.file.Files;
import java.nio.file.Path;

import thesis.evaluation.version3.apply.TransformationApplicatorTestSupportV3;
import thesis.evaluation.version3.me.ManagedElementTestFixturesV3;
import thesis.evaluation.version3.sa.SelfAdaptationTestFixturesV3;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class CrossStageIntegrationTestsV3 {
    private CrossStageIntegrationTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("crossStage.applyProjectCompareMatchesExpectedProspectiveModel",
                CrossStageIntegrationTestsV3::applyProjectCompareMatchesExpectedProspectiveModel);
    }

    private static void applyProjectCompareMatchesExpectedProspectiveModel() {
        try {
            Path tempDir = Files.createTempDirectory("v3_cross_stage_");
            Path sourceModelPath = ManagedElementTestFixturesV3.writeCrossStageSourceModel(tempDir.resolve("source"));
            Path henshinPath = SelfAdaptationTestFixturesV3.writeCrossStageTransformation(tempDir.resolve("sa"));
            Path outXmiPath = tempDir.resolve("applied").resolve("sa_cross_stage.xmi");

            TransformationApplicatorTestSupportV3.applyCrossStageFixture(sourceModelPath, henshinPath, outXmiPath);

            NormalizedManagedElementModel actual = new ManagedElementArtifactProjectorV3().project(outXmiPath);
            NormalizedManagedElementModel expected = expectedProspectiveModel();
            ProspectiveModelComparatorV3.ComparisonResult comparison = new ProspectiveModelComparatorV3().compare(expected, actual);

            TestSupportV3.check(comparison.matches(),
                    "Projected applied model should match the expected prospective model | issues=" + comparison.issues());
        } catch (Exception e) {
            throw new AssertionError("Cross-stage integration test failed: " + e.getMessage(), e);
        }
    }

    private static NormalizedManagedElementModel expectedProspectiveModel() {
        NormalizedManagedElementModel model = new NormalizedManagedElementModel();
        model.modelId = "";
        model.dataSubjectTypes.put("user_1", "DSUser");
        model.personalDataTypes.put("comment_1", "PDComment");
        model.personalDataIdentifies.put("comment_1", "user_1");
        model.componentTypes.put("sa_cross_stage_comp_000", "CNginx");
        model.purposeTypes.put("PComments", "PComments");
        model.addFunction("sa_cross_stage_fn_000", "FUploadVideo");
        model.functionRealizedBy.get("sa_cross_stage_fn_000").add("sa_cross_stage_comp_000");
        model.functionProcesses.get("sa_cross_stage_fn_000").add("comment_1");
        model.functionHasPurpose.get("sa_cross_stage_fn_000").add("PComments");
        model.addVulnerability("CVE-2024-7347");
        model.vulnerabilityAffects.get("CVE-2024-7347").add("sa_cross_stage_comp_000");
        model.consentKeys.add(ManagedElementArtifactProjectorV3.consentKey("user_1", "comment_1", "PComments"));
        return model;
    }
}
