package thesis.evaluation.version3.sa;

record ExpectedViolation(
        String kind,
        String dataSubjectId,
        String personalDataId,
        String functionId,
        String componentId,
        String purposeId,
        String vulnerabilityId,
        String rationale) {
}
