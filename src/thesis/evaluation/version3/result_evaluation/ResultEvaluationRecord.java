package thesis.evaluation.version3.result_evaluation;

final class ResultEvaluationRecord {
    int modelIndex;
    String modelId;
    int adaptationIndex;
    String adaptationId;
    String caseSlug;
    String sourceModelPath;
    String prospectiveModelPath;

    boolean derivationCorrect;
    int derivationIssueCount;
    String derivationIssues;

    int expectedPurposeViolations;
    int expectedIdentifiablePurposeViolations;
    int actualPurposeViolations;
    int purposeTruePositives;
    int purposeFalseNegatives;
    int purposeFalsePositives;
    double purposeAccuracy;

    int expectedRiskViolations;
    int expectedIdentifiableRiskViolations;
    int actualRiskViolations;
    int riskTruePositives;
    int riskFalseNegatives;
    int riskFalsePositives;
    double riskAccuracy;

    String status;
    String errorCode;
    String errorMessage;
}
