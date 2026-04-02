package thesis.evaluation.version3.result_evaluation;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class ProspectiveModelComparatorV3Tests {
    private ProspectiveModelComparatorV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("result.ProspectiveModelComparatorV3.matchesWhenExpectedAndActualAreEqual",
                ProspectiveModelComparatorV3Tests::matchesWhenExpectedAndActualAreEqual);
        TestSupportV3.run("result.ProspectiveModelComparatorV3.failsWhenUnexpectedExtraFunctionAppears",
                ProspectiveModelComparatorV3Tests::failsWhenUnexpectedExtraFunctionAppears);
        TestSupportV3.run("result.ProspectiveModelComparatorV3.failsWhenExpectedRelationIsMissing",
                ProspectiveModelComparatorV3Tests::failsWhenExpectedRelationIsMissing);
        TestSupportV3.run("result.ProspectiveModelComparatorV3.failsWhenRemovedComponentIsStillPresent",
                ProspectiveModelComparatorV3Tests::failsWhenRemovedComponentIsStillPresent);
        TestSupportV3.run("result.ProspectiveModelComparatorV3.failsWhenUnexpectedVulnerabilityAppears",
                ProspectiveModelComparatorV3Tests::failsWhenUnexpectedVulnerabilityAppears);
        TestSupportV3.run("result.ProspectiveModelComparatorV3.failsWhenUnexpectedConsentAppears",
                ProspectiveModelComparatorV3Tests::failsWhenUnexpectedConsentAppears);
    }

    private static void matchesWhenExpectedAndActualAreEqual() {
        NormalizedManagedElementModel expected = model();
        NormalizedManagedElementModel actual = model();
        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);
        TestSupportV3.check(result.matches(), "Comparator should accept identical models");
    }

    private static void failsWhenUnexpectedExtraFunctionAppears() {
        NormalizedManagedElementModel expected = model();
        NormalizedManagedElementModel actual = model();
        actual.addFunction("fn_extra", "FComments");
        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);
        TestSupportV3.check(!result.matches(), "Comparator should reject unexpected extra functions");
        TestSupportV3.check(result.issues().contains("functionTypes mismatch"), "Comparator should report functionTypes mismatch");
    }

    private static void failsWhenExpectedRelationIsMissing() {
        NormalizedManagedElementModel expected = model();
        NormalizedManagedElementModel actual = model();
        actual.functionProcesses.get("fn1").clear();
        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);
        TestSupportV3.check(!result.matches(), "Comparator should reject missing expected relations");
        TestSupportV3.check(result.issues().contains("functionProcesses mismatch"), "Comparator should report functionProcesses mismatch");
    }

    private static void failsWhenRemovedComponentIsStillPresent() {
        NormalizedManagedElementModel expected = model();
        expected.componentTypes.clear();
        expected.functionRealizedBy.get("fn1").clear();
        expected.vulnerabilityAffects.get("CVE-1").clear();
        NormalizedManagedElementModel actual = model();
        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);
        TestSupportV3.check(!result.matches(), "Comparator should reject components that should have been removed");
        TestSupportV3.check(result.issues().contains("componentTypes mismatch"), "Comparator should report componentTypes mismatch");
    }

    private static void failsWhenUnexpectedVulnerabilityAppears() {
        NormalizedManagedElementModel expected = model();
        NormalizedManagedElementModel actual = model();
        actual.addVulnerability("CVE-2");
        actual.vulnerabilityAffects.get("CVE-2").add("c1");
        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);
        TestSupportV3.check(!result.matches(), "Comparator should reject unexpected vulnerabilities");
        TestSupportV3.check(result.issues().contains("vulnerabilityCves mismatch"), "Comparator should report vulnerabilityCves mismatch");
    }

    private static void failsWhenUnexpectedConsentAppears() {
        NormalizedManagedElementModel expected = model();
        NormalizedManagedElementModel actual = model();
        actual.consentKeys.add("ds1|pd1|PMarketing");
        ProspectiveModelComparatorV3.ComparisonResult result = new ProspectiveModelComparatorV3().compare(expected, actual);
        TestSupportV3.check(!result.matches(), "Comparator should reject unexpected consent keys");
        TestSupportV3.check(result.issues().contains("consentKeys mismatch"), "Comparator should report consentKeys mismatch");
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
