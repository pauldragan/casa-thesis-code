package thesis.evaluation.version3.apply;

import java.nio.file.Files;
import java.nio.file.Path;

import thesis.evaluation.version3.me.ManagedElementTestFixturesV3;
import thesis.evaluation.version3.sa.SelfAdaptationTestFixturesV3;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class TransformationApplicatorV3Tests {
    private TransformationApplicatorV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("apply.TransformationApplicatorV3.appliesTransformationSuccessfully",
                TransformationApplicatorV3Tests::appliesTransformationSuccessfully);
        TestSupportV3.run("apply.TransformationApplicatorV3.reportsOracleDeltaMismatch",
                TransformationApplicatorV3Tests::reportsOracleDeltaMismatch);
    }

    private static void appliesTransformationSuccessfully() {
        try {
            Path tempDir = Files.createTempDirectory("v3_apply_success_");
            Path sourceModelPath = ManagedElementTestFixturesV3.writeCrossStageSourceModel(tempDir.resolve("source"));
            Path henshinPath = SelfAdaptationTestFixturesV3.writeCrossStageTransformation(tempDir.resolve("sa"));
            Path outXmiPath = tempDir.resolve("applied").resolve("sa_cross_stage.xmi");

            ApplicationResult result = new TransformationApplicatorV3().apply(new ApplicationInput(
                    0, "me_000000", 0, "sa_cross_stage", "cross_stage",
                    sourceModelPath, henshinPath, 1, 1, 1, 1), outXmiPath);

            TestSupportV3.check(result.applicationSucceeded, details("Transformation should apply successfully", result));
            TestSupportV3.check(result.emfValidationOk, details("Applied result should survive EMF reload validation", result));
            TestSupportV3.check(result.oracleCheckOk, details("Observed deltas should match expected oracle deltas", result));
            TestSupportV3.equals("OK", result.status, details("Application status should be OK", result));
        } catch (Exception e) {
            throw new AssertionError("TransformationApplicatorV3 success test failed: " + e.getMessage(), e);
        }
    }

    private static void reportsOracleDeltaMismatch() {
        try {
            Path tempDir = Files.createTempDirectory("v3_apply_mismatch_");
            Path sourceModelPath = ManagedElementTestFixturesV3.writeCrossStageSourceModel(tempDir.resolve("source"));
            Path henshinPath = SelfAdaptationTestFixturesV3.writeCrossStageTransformation(tempDir.resolve("sa"));
            Path outXmiPath = tempDir.resolve("applied").resolve("sa_cross_stage.xmi");

            ApplicationResult result = new TransformationApplicatorV3().apply(new ApplicationInput(
                    0, "me_000000", 0, "sa_cross_stage", "cross_stage",
                    sourceModelPath, henshinPath, 2, 1, 1, 1), outXmiPath);

            TestSupportV3.check(result.applicationSucceeded, details("Transformation should still apply for mismatch case", result));
            TestSupportV3.check(!result.oracleCheckOk, details("Oracle delta mismatch should be detected", result));
            TestSupportV3.equals("INVALID", result.status, details("Status should be INVALID when oracle deltas do not match", result));
            TestSupportV3.equals("ORACLE_CHECK_FAILED", result.errorCode,
                    details("Oracle delta mismatch should be reported explicitly", result));
        } catch (Exception e) {
            throw new AssertionError("TransformationApplicatorV3 mismatch test failed: " + e.getMessage(), e);
        }
    }

    private static String details(String message, ApplicationResult result) {
        return message
                + " | status=" + result.status
                + ", errorCode=" + result.errorCode
                + ", errorMessage=" + result.errorMessage
                + ", applied=" + result.applicationSucceeded
                + ", emfValidationOk=" + result.emfValidationOk
                + ", oracleCheckOk=" + result.oracleCheckOk
                + ", deltaFunctions=" + result.deltaFunctions
                + ", deltaComponents=" + result.deltaComponents;
    }
}
