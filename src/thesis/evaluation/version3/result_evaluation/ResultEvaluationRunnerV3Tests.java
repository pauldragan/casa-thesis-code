package thesis.evaluation.version3.result_evaluation;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.Set;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class ResultEvaluationRunnerV3Tests {
    private ResultEvaluationRunnerV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("result.ResultEvaluationRunnerV3.computesMetricsAgainstIdentifiableViolations",
                ResultEvaluationRunnerV3Tests::computesMetricsAgainstIdentifiableViolations);
        TestSupportV3.run("result.ResultEvaluationRunnerV3.computesZeroExpectedAccuracyCorrectly",
                ResultEvaluationRunnerV3Tests::computesZeroExpectedAccuracyCorrectly);
    }

    private static void computesMetricsAgainstIdentifiableViolations() {
        try {
            ResultEvaluationRecord record = new ResultEvaluationRecord();
            invokeFillMetrics(
                    Set.of("a", "b", "c"),
                    Set.of("a", "b"),
                    Set.of("a", "x"),
                    true,
                    record);

            TestSupportV3.equals(3, record.expectedPurposeViolations,
                    "Runner should record total expected purpose violations");
            TestSupportV3.equals(2, record.expectedIdentifiablePurposeViolations,
                    "Runner should record identifiable expected purpose violations");
            TestSupportV3.equals(2, record.actualPurposeViolations,
                    "Runner should record CASA-identified purpose violations");
            TestSupportV3.equals(1, record.purposeTruePositives,
                    "Runner should count true positives against identifiable violations");
            TestSupportV3.equals(1, record.purposeFalseNegatives,
                    "Runner should count false negatives against identifiable violations");
            TestSupportV3.equals(1, record.purposeFalsePositives,
                    "Runner should count false positives against identifiable violations");
            TestSupportV3.equals(0.5d, record.purposeAccuracy,
                    "Runner should compute accuracy against identifiable violations");
        } catch (Exception e) {
            throw new AssertionError("ResultEvaluationRunnerV3 metrics test failed: " + e.getMessage(), e);
        }
    }

    private static void computesZeroExpectedAccuracyCorrectly() {
        try {
            ResultEvaluationRecord record = new ResultEvaluationRecord();
            invokeFillMetrics(Set.of(), Set.of(), Set.of(), false, record);
            TestSupportV3.equals(1.0d, record.riskAccuracy,
                    "Runner should report perfect accuracy when nothing is expected and nothing is identified");

            record = new ResultEvaluationRecord();
            invokeFillMetrics(Set.of(), Set.of(), Set.of("ds1"), false, record);
            TestSupportV3.equals(0.0d, record.riskAccuracy,
                    "Runner should report zero accuracy when nothing is expected but CASA identifies something");
        } catch (Exception e) {
            throw new AssertionError("ResultEvaluationRunnerV3 zero-expected metrics test failed: " + e.getMessage(), e);
        }
    }

    private static void invokeFillMetrics(
            Set<String> expected,
            Set<String> expectedIdentifiable,
            Set<String> actual,
            boolean purpose,
            ResultEvaluationRecord record) throws Exception {
        Method method = ResultEvaluationRunnerV3.class.getDeclaredMethod(
                "fillMetrics",
                Set.class,
                Set.class,
                Set.class,
                boolean.class,
                ResultEvaluationRecord.class);
        method.setAccessible(true);
        method.invoke(new ResultEvaluationRunnerV3(),
                new LinkedHashSet<>(expected),
                new LinkedHashSet<>(expectedIdentifiable),
                new LinkedHashSet<>(actual),
                purpose,
                record);
    }
}
