package thesis.evaluation.version3.sa;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

final class SelfAdaptationInstantiator {
    private final SelfAdaptationGenerationConfig config;
    private final PurposeSemanticsV3 purposeSemantics;

    SelfAdaptationInstantiator(SelfAdaptationGenerationConfig config) {
        this.config = config;
        this.purposeSemantics = new PurposeSemanticsV3();
    }

    SelfAdaptationInstance instantiate(SourceManagedElementInstance source, SelfAdaptationSpec spec) {
        Random random = new Random(spec.seed);
        SelfAdaptationInstance instance = new SelfAdaptationInstance();
        instance.adaptationId = String.format(
                "sa_%06d_%03d_%s",
                spec.modelIndex,
                spec.adaptationIndex,
                spec.combination.caseSlug());
        instance.sourceModelId = source.modelId;
        instance.notes.addAll(spec.notes);

        selectRemovedFunctions(source, spec, random, instance);
        selectRemovedComponents(source, spec, random, instance);

        List<SelfAdaptationInstance.AddedComponent> addedComponents = createAddedComponents(source, spec, random, instance);
        List<SelfAdaptationInstance.AddedFunction> addedFunctions = createAddedFunctions(source, spec, random, instance, addedComponents);

        instance.addedComponents.addAll(addedComponents);
        instance.addedFunctions.addAll(addedFunctions);
        finalizeExpectedViolations(spec, instance);
        return instance;
    }

    private void selectRemovedFunctions(
            SourceManagedElementInstance source,
            SelfAdaptationSpec spec,
            Random random,
            SelfAdaptationInstance instance) {
        Map<String, Integer> remainingByType = new LinkedHashMap<>();
        for (SourceManagedElementInstance.FunctionView function : source.functions.values()) {
            remainingByType.merge(function.type(), 1, Integer::sum);
        }
        List<SourceManagedElementInstance.FunctionView> candidates = new ArrayList<>(source.functions.values());
        candidates.sort(Comparator.comparing(SourceManagedElementInstance.FunctionView::id));
        Collections.shuffle(candidates, random);
        for (SourceManagedElementInstance.FunctionView function : candidates) {
            if (instance.removedFunctionIds.size() >= spec.removeFunctionCount) {
                break;
            }
            int remainingOfType = remainingByType.getOrDefault(function.type(), 0);
            if (config.mandatoryFunctionTypes.contains(function.type()) && remainingOfType <= 1) {
                continue;
            }
            instance.removedFunctionIds.add(function.id());
            remainingByType.put(function.type(), remainingOfType - 1);
        }
        if (instance.removedFunctionIds.size() < spec.removeFunctionCount) {
            instance.notes.add("requested function removals underachieved: requested="
                    + spec.removeFunctionCount + ", achieved=" + instance.removedFunctionIds.size());
        }
    }

    private void selectRemovedComponents(
            SourceManagedElementInstance source,
            SelfAdaptationSpec spec,
            Random random,
            SelfAdaptationInstance instance) {
        Map<String, Integer> remainingByType = new LinkedHashMap<>();
        for (SourceManagedElementInstance.ComponentView component : source.components.values()) {
            remainingByType.merge(component.type(), 1, Integer::sum);
        }
        List<SourceManagedElementInstance.ComponentView> candidates = new ArrayList<>(source.components.values());
        candidates.sort(Comparator.comparing(SourceManagedElementInstance.ComponentView::id));
        Collections.shuffle(candidates, random);
        for (SourceManagedElementInstance.ComponentView component : candidates) {
            if (instance.removedComponentIds.size() >= spec.removeComponentCount) {
                break;
            }
            int remainingOfType = remainingByType.getOrDefault(component.type(), 0);
            if (remainingOfType <= 1) {
                continue;
            }
            instance.removedComponentIds.add(component.id());
            remainingByType.put(component.type(), remainingOfType - 1);
        }
        if (instance.removedComponentIds.size() < spec.removeComponentCount) {
            instance.notes.add("requested component removals underachieved: requested="
                    + spec.removeComponentCount + ", achieved=" + instance.removedComponentIds.size());
        }
    }

    private List<SelfAdaptationInstance.AddedComponent> createAddedComponents(
            SourceManagedElementInstance source,
            SelfAdaptationSpec spec,
            Random random,
            SelfAdaptationInstance instance) {
        List<SelfAdaptationInstance.AddedComponent> result = new ArrayList<>();
        List<String> functionIds = new ArrayList<>(source.functionIdsSorted());
        functionIds.removeAll(instance.removedFunctionIds);
        List<Boolean> riskyRoles = buildComponentRiskRoles(spec, random);
        for (int i = 0; i < spec.addComponentCount; i++) {
            boolean risky = riskyRoles.get(i);
            String type = config.componentTypes.get(random.nextInt(config.componentTypes.size()));
            String id = instance.adaptationId + "_comp_" + String.format("%03d", i);
            LinkedHashSet<String> realizedFunctionIds = new LinkedHashSet<>();
            if (!functionIds.isEmpty()) {
                int target = Math.min(
                        functionIds.size(),
                        sampleInRange(random, config.minRealizedByPerAddedFunction, config.maxRealizedByPerAddedFunction));
                List<String> shuffled = new ArrayList<>(functionIds);
                Collections.shuffle(shuffled, random);
                realizedFunctionIds.addAll(shuffled.subList(0, target));
            }
            LinkedHashSet<String> vulnerabilityIds = new LinkedHashSet<>();
            LinkedHashSet<String> vulnerabilityCves = new LinkedHashSet<>();
            if (risky) {
                List<String> cves = config.vulnerabilitiesByComponentType.getOrDefault(type, List.of());
                List<String> shuffledCves = new ArrayList<>(cves);
                Collections.shuffle(shuffledCves, random);
                int target = Math.min(shuffledCves.size(), sampleInRange(random, 1, config.maxAffectedByPerAddedComponent));
                for (int v = 0; v < target; v++) {
                    String cve = shuffledCves.get(v);
                    vulnerabilityIds.add(id + "_vuln_" + v);
                    vulnerabilityCves.add(cve);
                }
            }
            result.add(new SelfAdaptationInstance.AddedComponent(
                    id,
                    type,
                    id,
                    realizedFunctionIds,
                    vulnerabilityIds,
                    vulnerabilityCves));
            for (String functionId : realizedFunctionIds) {
                instance.addedRelations.add("realizedBy:" + functionId + "->" + id);
            }
        }
        return result;
    }

    private List<SelfAdaptationInstance.AddedFunction> createAddedFunctions(
            SourceManagedElementInstance source,
            SelfAdaptationSpec spec,
            Random random,
            SelfAdaptationInstance instance,
            List<SelfAdaptationInstance.AddedComponent> addedComponents) {
        List<SelfAdaptationInstance.AddedFunction> result = new ArrayList<>();
        List<String> personalDataIds = new ArrayList<>(source.personalDataIdsSorted());
        if (personalDataIds.isEmpty()) {
            instance.notes.add("source model has no personal data; cannot instantiate added functions");
            return result;
        }
        List<String> consentBearingPdIds = new ArrayList<>();
        for (String personalDataId : personalDataIds) {
            if (!source.consentPurposeTypesForPersonalData(personalDataId).isEmpty()) {
                consentBearingPdIds.add(personalDataId);
            }
        }

        List<Boolean> purposeViolatingRoles = buildFunctionPurposeRoles(spec, random);
        int requiredViolatingFunctions = (int) purposeViolatingRoles.stream().filter(Boolean::booleanValue).count();
        int purposeTargetPerViolatingFunction = requiredViolatingFunctions == 0
                ? 0
                : Math.max(1, spec.requestedPurposeViolations / requiredViolatingFunctions);

        for (int i = 0; i < spec.addFunctionCount; i++) {
            boolean purposeViolating = purposeViolatingRoles.get(i);
            String type = config.functionTypes.get(random.nextInt(config.functionTypes.size()));
            String id = instance.adaptationId + "_fn_" + String.format("%03d", i);
            String name = id;

            List<String> anchorPool = consentBearingPdIds;
            if (anchorPool.isEmpty()) {
                instance.notes.add("no consent-bearing PD available for added function " + id);
                continue;
            }
            AnchorSelection anchorSelection = selectAnchorAndPurpose(source, anchorPool, random, purposeViolating);
            if (anchorSelection == null) {
                instance.notes.add("failed to choose function purpose for " + id);
                continue;
            }
            String chosenPurposeId = anchorSelection.purposeId();
            if (chosenPurposeId == null) {
                instance.notes.add("failed to choose function purpose for " + id);
                continue;
            }

            int targetProcessesPerAddedFunction = sampleInRange(
                    random,
                    config.minProcessesPerAddedFunction,
                    config.maxProcessesPerAddedFunction);
            List<String> candidatePdIds = consentBearingPdIds;
            LinkedHashSet<String> processedPdIds = selectProcessedPersonalData(
                    source,
                    candidatePdIds,
                    chosenPurposeId,
                    targetProcessesPerAddedFunction,
                    purposeTargetPerViolatingFunction,
                    purposeViolating,
                    instance);
            if (processedPdIds.isEmpty()) {
                instance.notes.add("failed to select processed PD for " + id);
                continue;
            }
            LinkedHashSet<String> hasPurposeIds = new LinkedHashSet<>();
            hasPurposeIds.add(chosenPurposeId);

            LinkedHashSet<String> realizedByComponentIds = new LinkedHashSet<>();
            List<String> componentPool = new ArrayList<>(source.componentIdsSorted());
            componentPool.removeAll(instance.removedComponentIds);
            for (SelfAdaptationInstance.AddedComponent addedComponent : addedComponents) {
                componentPool.add(addedComponent.id());
            }
            Collections.shuffle(componentPool, random);
            int realizeTarget = Math.min(
                    componentPool.size(),
                    sampleInRange(random, config.minRealizedByPerAddedFunction, config.maxRealizedByPerAddedFunction));
            realizedByComponentIds.addAll(componentPool.subList(0, realizeTarget));

            result.add(new SelfAdaptationInstance.AddedFunction(
                    id,
                    type,
                    name,
                    processedPdIds,
                    hasPurposeIds,
                    realizedByComponentIds));

            for (String personalDataId : processedPdIds) {
                instance.addedRelations.add("processes:" + id + "->" + personalDataId);
                recordPurposeViolationIfAny(source, chosenPurposeId, id, personalDataId, instance);
            }
            for (String purposeId : hasPurposeIds) {
                instance.addedRelations.add("hasPurpose:" + id + "->" + purposeId);
            }
            for (String componentId : realizedByComponentIds) {
                instance.addedRelations.add("realizedBy:" + id + "->" + componentId);
            }
        }

        if (spec.requestedRiskViolations > 0) {
            recordRiskViolations(source, spec, addedComponents, result, instance);
        }
        return result;
    }

    private String chooseFunctionPurpose(
            SourceManagedElementInstance source,
            Random random,
            Set<String> anchorConsentPurposeIds,
            boolean purposeViolating) {
        List<String> candidates = new ArrayList<>(config.purposeTypes);
        Collections.shuffle(candidates, random);
        if (purposeViolating) {
            if (anchorConsentPurposeIds.isEmpty()) {
                return null;
            }
            for (String candidate : candidates) {
                boolean incompatibleWithAll = true;
                for (String consentPurposeId : anchorConsentPurposeIds) {
                    if (!purposeSemantics.isGeneralizationOrUnrelated(candidate, consentPurposeId)) {
                        incompatibleWithAll = false;
                        break;
                    }
                }
                if (incompatibleWithAll) {
                    return candidate;
                }
            }
            return null;
        }
        if (!anchorConsentPurposeIds.isEmpty()) {
            return anchorConsentPurposeIds.iterator().next();
        }
        return null;
    }

    private LinkedHashSet<String> selectProcessedPersonalData(
            SourceManagedElementInstance source,
            List<String> candidatePersonalDataIds,
            String functionPurposeId,
            int targetProcessesPerAddedFunction,
            int purposeTargetPerFunction,
            boolean purposeViolating,
            SelfAdaptationInstance instance) {
        LinkedHashSet<String> processed = new LinkedHashSet<>();
        int targetProcesses = Math.min(candidatePersonalDataIds.size(), targetProcessesPerAddedFunction);
        for (String personalDataId : candidatePersonalDataIds) {
            if (processed.size() >= targetProcesses) {
                break;
            }
            Set<String> consentPurposeIds = source.consentPurposeTypesForPersonalData(personalDataId);
            boolean compatible = isCompatibleWithAnyConsent(functionPurposeId, consentPurposeIds);
            if (purposeViolating) {
                if (!compatible) {
                    processed.add(personalDataId);
                }
            } else if (compatible) {
                processed.add(personalDataId);
            }
        }
        if (processed.isEmpty()) {
            if (purposeViolating) {
                instance.notes.add("no incompatible candidate for purpose-violating added function");
            } else {
                instance.notes.add("no compatible candidate for safe added function");
            }
        }
        return processed;
    }

    private static int sampleInRange(Random random, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range [" + min + ", " + max + "]");
        }
        if (min == max) {
            return min;
        }
        return min + random.nextInt(max - min + 1);
    }

    private boolean isCompatibleWithAnyConsent(String functionPurposeId, Set<String> consentPurposeIds) {
        if (consentPurposeIds.isEmpty()) {
            return false;
        }
        for (String consentPurposeId : consentPurposeIds) {
            if (purposeSemantics.isSameOrSpecialization(functionPurposeId, consentPurposeId)) {
                return true;
            }
        }
        return false;
    }

    private void recordPurposeViolationIfAny(
            SourceManagedElementInstance source,
            String functionPurposeId,
            String functionId,
            String personalDataId,
            SelfAdaptationInstance instance) {
        Set<String> consentPurposeIds = source.consentPurposeTypesForPersonalData(personalDataId);
        if (isCompatibleWithAnyConsent(functionPurposeId, consentPurposeIds)) {
            return;
        }
        SourceManagedElementInstance.PersonalDataView pd = source.personalData.get(personalDataId);
        String dataSubjectId = pd == null ? "" : pd.identifiesDsId();
        instance.expectedPurposeViolations.add(new ExpectedViolation(
                "PURPOSE",
                dataSubjectId,
                personalDataId,
                functionId,
                "",
                functionPurposeId,
                "",
                "function purpose incompatible with consent purpose(s)"));
    }

    private void recordRiskViolations(
            SourceManagedElementInstance source,
            SelfAdaptationSpec spec,
            List<SelfAdaptationInstance.AddedComponent> addedComponents,
            List<SelfAdaptationInstance.AddedFunction> addedFunctions,
            SelfAdaptationInstance instance) {
        LinkedHashSet<String> seenDataSubjectIds = new LinkedHashSet<>();
        Map<String, SelfAdaptationInstance.AddedFunction> addedFunctionById = new LinkedHashMap<>();
        for (SelfAdaptationInstance.AddedFunction function : addedFunctions) {
            addedFunctionById.put(function.id(), function);
        }
        for (SelfAdaptationInstance.AddedComponent component : addedComponents) {
            if (component.vulnerabilityCves().isEmpty()) {
                continue;
            }
            for (String functionId : component.realizedFunctionIds()) {
                for (String dataSubjectId : dataSubjectsProcessedByFunction(source, addedFunctionById, functionId)) {
                    if (!seenDataSubjectIds.add(dataSubjectId)) {
                        continue;
                    }
                    String vulnerabilityId = component.vulnerabilityIds().isEmpty()
                            ? ""
                            : component.vulnerabilityIds().iterator().next();
                    instance.expectedRiskViolations.add(new ExpectedViolation(
                            "RISK",
                            dataSubjectId,
                            "",
                            functionId,
                            component.id(),
                            "",
                            vulnerabilityId,
                            "added vulnerable component increases processing risk"));
                }
            }
            for (SelfAdaptationInstance.AddedFunction addedFunction : addedFunctions) {
                if (!addedFunction.realizedByComponentIds().contains(component.id())) {
                    continue;
                }
                for (String dataSubjectId : dataSubjectsProcessedByFunction(source, addedFunctionById, addedFunction.id())) {
                    if (!seenDataSubjectIds.add(dataSubjectId)) {
                        continue;
                    }
                    String vulnerabilityId = component.vulnerabilityIds().isEmpty()
                            ? ""
                            : component.vulnerabilityIds().iterator().next();
                    instance.expectedRiskViolations.add(new ExpectedViolation(
                            "RISK",
                            dataSubjectId,
                            "",
                            addedFunction.id(),
                            component.id(),
                            "",
                            vulnerabilityId,
                            "added vulnerable component increases processing risk"));
                }
            }
        }
        if (instance.expectedRiskViolations.size() < spec.requestedRiskViolations) {
            instance.notes.add("requested risk violations underachieved: requested="
                    + spec.requestedRiskViolations + ", achieved=" + instance.expectedRiskViolations.size());
        }
    }

    private Set<String> dataSubjectsProcessedByFunction(
            SourceManagedElementInstance source,
            Map<String, SelfAdaptationInstance.AddedFunction> addedFunctionById,
            String functionId) {
        SelfAdaptationInstance.AddedFunction added = addedFunctionById.get(functionId);
        if (added == null) {
            return source.dataSubjectIdsProcessedByFunction(functionId);
        }
        LinkedHashSet<String> ids = new LinkedHashSet<>();
        for (String personalDataId : added.processesPersonalDataIds()) {
            SourceManagedElementInstance.PersonalDataView pd = source.personalData.get(personalDataId);
            if (pd != null && pd.identifiesDsId() != null) {
                ids.add(pd.identifiesDsId());
            }
        }
        return ids;
    }

    private AnchorSelection selectAnchorAndPurpose(
            SourceManagedElementInstance source,
            List<String> anchorPool,
            Random random,
            boolean purposeViolating) {
        List<String> shuffledPdIds = new ArrayList<>(anchorPool);
        Collections.shuffle(shuffledPdIds, random);
        for (String anchorPdId : shuffledPdIds) {
            Set<String> anchorConsentPurposeIds = source.consentPurposeTypesForPersonalData(anchorPdId);
            String chosenPurposeId = chooseFunctionPurpose(source, random, anchorConsentPurposeIds, purposeViolating);
            if (chosenPurposeId != null) {
                return new AnchorSelection(anchorPdId, chosenPurposeId);
            }
        }
        return null;
    }

    private List<Boolean> buildFunctionPurposeRoles(SelfAdaptationSpec spec, Random random) {
        List<Boolean> roles = new ArrayList<>();
        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION)) {
            roles.add(Boolean.TRUE);
        }
        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_SAFE)) {
            roles.add(Boolean.FALSE);
        }
        while (roles.size() < spec.addFunctionCount) {
            if (spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION)
                    && spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_SAFE)) {
                roles.add(random.nextBoolean());
            } else if (spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION)) {
                roles.add(Boolean.TRUE);
            } else {
                roles.add(Boolean.FALSE);
            }
        }
        Collections.shuffle(roles, random);
        return roles;
    }

    private List<Boolean> buildComponentRiskRoles(SelfAdaptationSpec spec, Random random) {
        List<Boolean> roles = new ArrayList<>();
        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION)) {
            roles.add(Boolean.TRUE);
        }
        if (spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_SAFE)) {
            roles.add(Boolean.FALSE);
        }
        while (roles.size() < spec.addComponentCount) {
            if (spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION)
                    && spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_SAFE)) {
                roles.add(random.nextBoolean());
            } else if (spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION)) {
                roles.add(Boolean.TRUE);
            } else {
                roles.add(Boolean.FALSE);
            }
        }
        Collections.shuffle(roles, random);
        return roles;
    }

    private void finalizeExpectedViolations(SelfAdaptationSpec spec, SelfAdaptationInstance instance) {
        instance.expectedIdentifiablePurposeViolations.addAll(instance.expectedPurposeViolations);
        boolean mixedPurposeAndRisk = spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION)
                && spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION);
        if (!mixedPurposeAndRisk) {
            instance.expectedIdentifiableRiskViolations.addAll(instance.expectedRiskViolations);
        }
    }

    private record AnchorSelection(String personalDataId, String purposeId) {
    }
}
