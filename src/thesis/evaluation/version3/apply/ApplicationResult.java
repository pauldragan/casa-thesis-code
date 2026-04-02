package thesis.evaluation.version3.apply;

final class ApplicationResult {
    int modelIndex;
    String modelId;
    int adaptationIndex;
    String adaptationId;
    String caseSlug;
    String sourceModelPath;
    String henshinPath;
    String prospectiveModelPath;
    String status;
    boolean applicationSucceeded;
    boolean emfValidationOk;
    boolean oracleCheckOk;
    String appliedUnitName;
    long executionTimeMillis;
    int sourceFunctions;
    int sourceComponents;
    int resultFunctions;
    int resultComponents;
    int deltaFunctions;
    int deltaComponents;
    String errorCode;
    String errorMessage;
}
