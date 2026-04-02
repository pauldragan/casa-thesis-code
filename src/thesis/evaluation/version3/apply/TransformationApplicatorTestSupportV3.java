package thesis.evaluation.version3.apply;

import java.nio.file.Path;

public final class TransformationApplicatorTestSupportV3 {
    private TransformationApplicatorTestSupportV3() {
    }

    public static Path applyCrossStageFixture(Path sourceModelPath, Path henshinPath, Path outXmiPath) {
        ApplicationInput input = new ApplicationInput(
                0,
                "me_000000",
                0,
                "sa_cross_stage",
                "cross_stage",
                sourceModelPath,
                henshinPath,
                1,
                1,
                1,
                1);
        ApplicationResult result = new TransformationApplicatorV3().apply(input, outXmiPath);
        if (!result.applicationSucceeded || !result.emfValidationOk || !result.oracleCheckOk || !"OK".equals(result.status)) {
            throw new AssertionError(
                    "Cross-stage application failed | status=" + result.status
                            + ", errorCode=" + result.errorCode
                            + ", errorMessage=" + result.errorMessage);
        }
        return outXmiPath;
    }
}
