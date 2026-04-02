package thesis.evaluation.version3.sa;

import java.util.ArrayList;
import java.util.List;

final class SelfAdaptationValidatorV3 {

    SaValidationResult validate(SourceManagedElementProfile profile, SelfAdaptationSpec spec) {
        List<String> issues = new ArrayList<>();

        if (spec.adaptationIndex < 0 || spec.adaptationIndex >= SelfAdaptationCombination.COUNT) {
            issues.add("adaptation_index_out_of_range");
        }
        if (spec.combination == null) {
            issues.add("missing_combination");
        }
        if (spec.removeFunctionCount > profile.maxRemovableFunctions()) {
            issues.add("remove_function_count_exceeds_feasible_limit");
        }
        if (spec.removeComponentCount > profile.maxRemovableComponents()) {
            issues.add("remove_component_count_exceeds_feasible_limit");
        }
        if (spec.combination != null && spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION)
                && spec.requestedPurposeViolations <= 0) {
            issues.add("purpose_violation_case_without_requested_violations");
        }
        if (spec.combination != null && spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION)
                && spec.requestedRiskViolations <= 0) {
            issues.add("risk_violation_case_without_requested_violations");
        }
        if (issues.isEmpty()) {
            return new SaValidationResult(true, "", "");
        }
        return new SaValidationResult(false, "SA_SPEC_INVALID", String.join("|", issues));
    }

    SaValidationResult validateInstantiatedCase(SelfAdaptationSpec spec, SelfAdaptationInstance instance) {
        List<String> issues = new ArrayList<>();

        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_SAFE)
                && countSafeAddedFunctions(instance) <= 0) {
            issues.add("missing_safe_added_function");
        }
        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION)
                && countViolatingAddedFunctions(instance) <= 0) {
            issues.add("missing_purpose_violating_added_function");
        }
        if (spec.combination.has(SelfAdaptationAtomicCase.REMOVE_FUNCTION)
                && instance.removedFunctionIds.isEmpty()) {
            issues.add("missing_removed_function");
        }
        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_SAFE)
                && countSafeAddedComponents(instance) <= 0) {
            issues.add("missing_safe_added_component");
        }
        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION)
                && countRiskyAddedComponents(instance) <= 0) {
            issues.add("missing_risky_added_component");
        }
        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION)
                && instance.expectedRiskViolations.isEmpty()) {
            issues.add("missing_expected_risk_violation");
        }
        if (spec.combination.has(SelfAdaptationAtomicCase.REMOVE_COMPONENT)
                && instance.removedComponentIds.isEmpty()) {
            issues.add("missing_removed_component");
        }
        if (issues.isEmpty()) {
            return new SaValidationResult(true, "", "");
        }
        return new SaValidationResult(false, "SA_CASE_UNREALIZED", String.join("|", issues));
    }

    private static int countSafeAddedFunctions(SelfAdaptationInstance instance) {
        int count = 0;
        for (SelfAdaptationInstance.AddedFunction function : instance.addedFunctions) {
            if (!hasPurposeViolation(instance, function.id())) {
                count++;
            }
        }
        return count;
    }

    private static int countViolatingAddedFunctions(SelfAdaptationInstance instance) {
        int count = 0;
        for (SelfAdaptationInstance.AddedFunction function : instance.addedFunctions) {
            if (hasPurposeViolation(instance, function.id())) {
                count++;
            }
        }
        return count;
    }

    private static boolean hasPurposeViolation(SelfAdaptationInstance instance, String functionId) {
        for (ExpectedViolation violation : instance.expectedPurposeViolations) {
            if (functionId.equals(violation.functionId())) {
                return true;
            }
        }
        return false;
    }

    private static int countSafeAddedComponents(SelfAdaptationInstance instance) {
        int count = 0;
        for (SelfAdaptationInstance.AddedComponent component : instance.addedComponents) {
            if (component.vulnerabilityCves().isEmpty()) {
                count++;
            }
        }
        return count;
    }

    private static int countRiskyAddedComponents(SelfAdaptationInstance instance) {
        int count = 0;
        for (SelfAdaptationInstance.AddedComponent component : instance.addedComponents) {
            if (!component.vulnerabilityCves().isEmpty()) {
                count++;
            }
        }
        return count;
    }
}
