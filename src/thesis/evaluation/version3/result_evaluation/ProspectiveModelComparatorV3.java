package thesis.evaluation.version3.result_evaluation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ProspectiveModelComparatorV3 {
    ComparisonResult compare(NormalizedManagedElementModel expected, NormalizedManagedElementModel actual) {
        List<String> issues = new ArrayList<>();
        compareMap("dataSubjectTypes", expected.dataSubjectTypes, actual.dataSubjectTypes, issues);
        compareMap("personalDataTypes", expected.personalDataTypes, actual.personalDataTypes, issues);
        compareMap("personalDataIdentifies", expected.personalDataIdentifies, actual.personalDataIdentifies, issues);
        compareMap("functionTypes", expected.functionTypes, actual.functionTypes, issues);
        compareNestedSetMap("functionRealizedBy", expected.functionRealizedBy, actual.functionRealizedBy, issues);
        compareNestedSetMap("functionProcesses", expected.functionProcesses, actual.functionProcesses, issues);
        compareNestedSetMap("functionHasPurpose", expected.functionHasPurpose, actual.functionHasPurpose, issues);
        compareMap("componentTypes", expected.componentTypes, actual.componentTypes, issues);
        compareMap("purposeTypes", expected.purposeTypes, actual.purposeTypes, issues);
        compareSet("vulnerabilityCves", expected.vulnerabilityCves, actual.vulnerabilityCves, issues);
        compareNestedSetMap("vulnerabilityAffects", expected.vulnerabilityAffects, actual.vulnerabilityAffects, issues);
        compareSet("consentKeys", expected.consentKeys, actual.consentKeys, issues);
        return new ComparisonResult(issues.isEmpty(), issues);
    }

    private static void compareMap(String label, Map<String, String> expected, Map<String, String> actual, List<String> issues) {
        if (!expected.equals(actual)) {
            issues.add(label + " mismatch");
        }
    }

    private static void compareSet(String label, Set<String> expected, Set<String> actual, List<String> issues) {
        if (!expected.equals(actual)) {
            issues.add(label + " mismatch");
        }
    }

    private static void compareNestedSetMap(
            String label,
            Map<String, Set<String>> expected,
            Map<String, Set<String>> actual,
            List<String> issues) {
        if (!expected.equals(actual)) {
            issues.add(label + " mismatch");
        }
    }

    record ComparisonResult(boolean matches, List<String> issues) {
    }
}
