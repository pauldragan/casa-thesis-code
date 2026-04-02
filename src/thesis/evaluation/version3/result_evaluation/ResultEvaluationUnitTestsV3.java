package thesis.evaluation.version3.result_evaluation;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class ResultEvaluationUnitTestsV3 {
    private ResultEvaluationUnitTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("result.matchesWhenExpectedAndActualAreEqual",
                ResultEvaluationUnitTestsV3::matchesWhenExpectedAndActualAreEqual);
        TestSupportV3.run("result.failsWhenUnexpectedExtraFunctionAppears",
                ResultEvaluationUnitTestsV3::failsWhenUnexpectedExtraFunctionAppears);
        TestSupportV3.run("result.failsWhenExpectedRelationIsMissing",
                ResultEvaluationUnitTestsV3::failsWhenExpectedRelationIsMissing);
    }

    private static void matchesWhenExpectedAndActualAreEqual() {
        NormalizedManagedElementModel expected = model();
        NormalizedManagedElementModel actual = model();

        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);

        TestSupportV3.check(result.matches(), "Comparator should accept identical models");
        TestSupportV3.check(result.issues().isEmpty(), "Comparator should not report issues for identical models");
    }

    private static void failsWhenUnexpectedExtraFunctionAppears() {
        NormalizedManagedElementModel expected = model();
        NormalizedManagedElementModel actual = model();
        actual.addFunction("fn_extra", "FComments");

        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);

        TestSupportV3.check(!result.matches(), "Comparator should reject unexpected extra functions");
        TestSupportV3.check(result.issues().contains("functionTypes mismatch"),
                "Comparator should report functionTypes mismatch for unexpected extra functions");
    }

    private static void failsWhenExpectedRelationIsMissing() {
        NormalizedManagedElementModel expected = model();
        NormalizedManagedElementModel actual = model();
        actual.functionProcesses.get("fn1").clear();

        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);

        TestSupportV3.check(!result.matches(), "Comparator should reject missing expected relations");
        TestSupportV3.check(result.issues().contains("functionProcesses mismatch"),
                "Comparator should report functionProcesses mismatch for missing process relations");
    }

    private static NormalizedManagedElementModel model() {
        NormalizedManagedElementModel model = new NormalizedManagedElementModel();
        model.modelId = "m1";
        model.dataSubjectTypes.put("ds1", "DSUser");
        model.personalDataTypes.put("pd1", "PDComment");
        model.personalDataIdentifies.put("pd1", "ds1");
        model.componentTypes.put("c1", "CNginx");
        model.purposeTypes.put("PComments", "PComments");
        model.addFunction("fn1", "FComments");
        model.functionRealizedBy.get("fn1").add("c1");
        model.functionProcesses.get("fn1").add("pd1");
        model.functionHasPurpose.get("fn1").add("PComments");
        model.addVulnerability("CVE-1");
        model.vulnerabilityAffects.get("CVE-1").add("c1");
        model.consentKeys.add("ds1|pd1|PComments");
        return model;
    }
}
