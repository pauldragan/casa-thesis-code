package thesis.evaluation.version3.sa;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

final class SelfAdaptationInstance {
    String adaptationId;
    String sourceModelId;
    String henshinPath;

    final List<AddedFunction> addedFunctions = new ArrayList<>();
    final List<String> removedFunctionIds = new ArrayList<>();
    final List<AddedComponent> addedComponents = new ArrayList<>();
    final List<String> removedComponentIds = new ArrayList<>();

    final List<String> addedRelations = new ArrayList<>();
    final List<String> removedRelations = new ArrayList<>();

    final List<ExpectedViolation> expectedPurposeViolations = new ArrayList<>();
    final List<ExpectedViolation> expectedIdentifiablePurposeViolations = new ArrayList<>();
    final List<ExpectedViolation> expectedRiskViolations = new ArrayList<>();
    final List<ExpectedViolation> expectedIdentifiableRiskViolations = new ArrayList<>();
    final List<String> notes = new ArrayList<>();

    record AddedFunction(
            String id,
            String type,
            String name,
            Set<String> processesPersonalDataIds,
            Set<String> hasPurposeIds,
            Set<String> realizedByComponentIds) {
    }

    record AddedComponent(
            String id,
            String type,
            String name,
            Set<String> realizedFunctionIds,
            Set<String> vulnerabilityIds,
            Set<String> vulnerabilityCves) {
    }
}
