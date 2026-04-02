package thesis.evaluation.version3.sa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import thesis.evaluation.version3.me.GenerateManagedElementViewsV3;
import thesis.evaluation.version3.me.ManagedElementView;

public final class SelfAdaptationOracleRebuilderV3 {
    public record PurposeViolation(
            String dataSubjectId,
            String personalDataId,
            String functionId,
            String purposeId) {
    }

    public record RiskViolation(
            String dataSubjectId,
            String functionId,
            String componentId,
            String vulnerabilityCve) {
    }

    public record AddedComponentVulnerability(
            String componentId,
            String vulnerabilityCve) {
    }

    public record OracleCase(
            String sourceModelId,
            String adaptationId,
            String caseSlug,
            ManagedElementView sourceView,
            ManagedElementView expectedProspectiveView,
            List<AddedComponentVulnerability> expectedAddedComponentVulnerabilities,
            List<PurposeViolation> expectedPurposeViolations,
            List<PurposeViolation> expectedIdentifiablePurposeViolations,
            List<RiskViolation> expectedRiskViolations,
            List<RiskViolation> expectedIdentifiableRiskViolations) {
    }

    private SelfAdaptationOracleRebuilderV3() {
    }

    public static OracleCase rebuild(long baseSeed, int modelIndex, int adaptationIndex, boolean pruneSourceModels) {
        return rebuild(baseSeed, modelIndex, adaptationIndex, pruneSourceModels, false);
    }

    public static OracleCase rebuild(
            long baseSeed,
            int modelIndex,
            int adaptationIndex,
            boolean pruneSourceModels,
            boolean tinyProfile) {
        long modelSeed = baseSeed + modelIndex;
        ManagedElementView sourceView = GenerateManagedElementViewsV3.generateSingle(
                modelSeed,
                modelIndex,
                pruneSourceModels,
                tinyProfile);

        SelfAdaptationGenerationConfig config = tinyProfile
                ? SelfAdaptationGenerationConfig.tiny()
                : SelfAdaptationGenerationConfig.defaults();
        SelfAdaptationSpecSampler sampler = new SelfAdaptationSpecSampler(config);
        SelfAdaptationInstantiator instantiator = new SelfAdaptationInstantiator(config);

        SourceManagedElementProfile profile = SourceManagedElementAdapter.toProfile(sourceView);
        SourceManagedElementInstance sourceInstance = SourceManagedElementAdapter.toInstance(sourceView);
        SelfAdaptationSpec spec = sampler.sample(profile, modelIndex, adaptationIndex, modelSeed, baseSeed + (modelIndex * 1000L) + adaptationIndex);
        return rebuild(sourceView, sourceInstance, spec, instantiator);
    }

    public static OracleCase rebuild(
            long sourceModelSeed,
            long specSeed,
            int modelIndex,
            int adaptationIndex,
            boolean pruneSourceModels,
            boolean tinyProfile) {
        ManagedElementView sourceView = GenerateManagedElementViewsV3.generateSingle(
                sourceModelSeed,
                modelIndex,
                pruneSourceModels,
                tinyProfile);

        SelfAdaptationGenerationConfig config = tinyProfile
                ? SelfAdaptationGenerationConfig.tiny()
                : SelfAdaptationGenerationConfig.defaults();
        SelfAdaptationSpecSampler sampler = new SelfAdaptationSpecSampler(config);
        SelfAdaptationInstantiator instantiator = new SelfAdaptationInstantiator(config);

        SourceManagedElementProfile profile = SourceManagedElementAdapter.toProfile(sourceView);
        SourceManagedElementInstance sourceInstance = SourceManagedElementAdapter.toInstance(sourceView);
        SelfAdaptationSpec spec = sampler.sample(profile, modelIndex, adaptationIndex, sourceModelSeed, specSeed);
        return rebuild(sourceView, sourceInstance, spec, instantiator);
    }

    private static OracleCase rebuild(
            ManagedElementView sourceView,
            SourceManagedElementInstance sourceInstance,
            SelfAdaptationSpec spec,
            SelfAdaptationInstantiator instantiator) {
        SelfAdaptationInstance instance = instantiator.instantiate(sourceInstance, spec);

        ManagedElementView expectedProspectiveView = applyConceptualDelta(sourceView, instance);
        List<PurposeViolation> purposeViolations = instance.expectedPurposeViolations.stream()
                .map(v -> new PurposeViolation(v.dataSubjectId(), v.personalDataId(), v.functionId(), v.purposeId()))
                .toList();
        List<PurposeViolation> identifiablePurposeViolations = instance.expectedIdentifiablePurposeViolations.stream()
                .map(v -> new PurposeViolation(v.dataSubjectId(), v.personalDataId(), v.functionId(), v.purposeId()))
                .toList();
        List<AddedComponentVulnerability> addedComponentVulnerabilities = collectAddedComponentVulnerabilities(instance);
        List<RiskViolation> riskViolations = mapRiskViolations(instance).stream().toList();
        List<RiskViolation> identifiableRiskViolations = mapIdentifiableRiskViolations(instance).stream().toList();
        return new OracleCase(
                sourceView.modelId,
                instance.adaptationId,
                spec.combination.caseSlug(),
                sourceView,
                expectedProspectiveView,
                addedComponentVulnerabilities,
                purposeViolations,
                identifiablePurposeViolations,
                riskViolations,
                identifiableRiskViolations);
    }

    private static List<AddedComponentVulnerability> collectAddedComponentVulnerabilities(SelfAdaptationInstance instance) {
        List<AddedComponentVulnerability> rows = new ArrayList<>();
        for (SelfAdaptationInstance.AddedComponent component : instance.addedComponents) {
            for (String cve : component.vulnerabilityCves()) {
                rows.add(new AddedComponentVulnerability(component.id(), cve));
            }
        }
        return rows;
    }

    private static Set<RiskViolation> mapRiskViolations(SelfAdaptationInstance instance) {
        return mapRiskViolations(instance.expectedRiskViolations, instance);
    }

    private static Set<RiskViolation> mapIdentifiableRiskViolations(SelfAdaptationInstance instance) {
        return mapRiskViolations(instance.expectedIdentifiableRiskViolations, instance);
    }

    private static Set<RiskViolation> mapRiskViolations(List<ExpectedViolation> sourceViolations, SelfAdaptationInstance instance) {
        Map<String, String> cveByVulnerabilityId = new LinkedHashMap<>();
        for (SelfAdaptationInstance.AddedComponent component : instance.addedComponents) {
            List<String> vulnerabilityIds = new ArrayList<>(component.vulnerabilityIds());
            List<String> vulnerabilityCves = new ArrayList<>(component.vulnerabilityCves());
            for (int i = 0; i < Math.min(vulnerabilityIds.size(), vulnerabilityCves.size()); i++) {
                cveByVulnerabilityId.put(vulnerabilityIds.get(i), vulnerabilityCves.get(i));
            }
        }
        LinkedHashSet<RiskViolation> violations = new LinkedHashSet<>();
        for (ExpectedViolation expected : sourceViolations) {
            violations.add(new RiskViolation(
                    expected.dataSubjectId(),
                    expected.functionId(),
                    expected.componentId(),
                    cveByVulnerabilityId.getOrDefault(expected.vulnerabilityId(), "")));
        }
        return violations;
    }

    private static ManagedElementView applyConceptualDelta(ManagedElementView source, SelfAdaptationInstance instance) {
        Map<String, ManagedElementView.DataSubjectView> dataSubjects = new LinkedHashMap<>(source.dataSubjects);
        Map<String, ManagedElementView.PersonalDataView> personalData = new LinkedHashMap<>(source.personalData);
        Map<String, ManagedElementView.ComponentView> components = new LinkedHashMap<>(source.components);
        Map<String, ManagedElementView.PurposeView> purposes = new LinkedHashMap<>(source.purposes);
        Map<String, ManagedElementView.VulnerabilityView> vulnerabilities = new LinkedHashMap<>(source.vulnerabilities);
        Map<String, ManagedElementView.ConsentView> consents = new LinkedHashMap<>(source.consents);

        Map<String, ManagedElementView.FunctionView> functions = new LinkedHashMap<>();
        for (ManagedElementView.FunctionView function : source.functions.values()) {
            if (instance.removedFunctionIds.contains(function.id())) {
                continue;
            }
            LinkedHashSet<String> remainingComponents = new LinkedHashSet<>(function.realizedByComponentIds());
            remainingComponents.removeAll(instance.removedComponentIds);
            functions.put(function.id(), new ManagedElementView.FunctionView(
                    function.id(),
                    function.type(),
                    function.name(),
                    remainingComponents,
                    new LinkedHashSet<>(function.processesPersonalDataIds()),
                    new LinkedHashSet<>(function.hasPurposeIds())));
        }

        for (String removedComponentId : instance.removedComponentIds) {
            components.remove(removedComponentId);
        }

        for (SelfAdaptationInstance.AddedComponent addedComponent : instance.addedComponents) {
            components.put(addedComponent.id(), new ManagedElementView.ComponentView(
                    addedComponent.id(),
                    addedComponent.type(),
                    addedComponent.name()));
            for (String realizedFunctionId : addedComponent.realizedFunctionIds()) {
                ManagedElementView.FunctionView function = functions.get(realizedFunctionId);
                if (function == null) {
                    continue;
                }
                LinkedHashSet<String> realizedBy = new LinkedHashSet<>(function.realizedByComponentIds());
                realizedBy.add(addedComponent.id());
                functions.put(realizedFunctionId, new ManagedElementView.FunctionView(
                        function.id(),
                        function.type(),
                        function.name(),
                        realizedBy,
                        new LinkedHashSet<>(function.processesPersonalDataIds()),
                        new LinkedHashSet<>(function.hasPurposeIds())));
            }
            List<String> vulnerabilityIds = new ArrayList<>(addedComponent.vulnerabilityIds());
            List<String> vulnerabilityCves = new ArrayList<>(addedComponent.vulnerabilityCves());
            for (int i = 0; i < Math.min(vulnerabilityIds.size(), vulnerabilityCves.size()); i++) {
                String vulnerabilityId = vulnerabilityIds.get(i);
                String cve = vulnerabilityCves.get(i);
                vulnerabilities.put(vulnerabilityId, new ManagedElementView.VulnerabilityView(
                        vulnerabilityId,
                        cve,
                        addedComponent.type()));
            }
        }

        for (SelfAdaptationInstance.AddedFunction addedFunction : instance.addedFunctions) {
            functions.put(addedFunction.id(), new ManagedElementView.FunctionView(
                    addedFunction.id(),
                    addedFunction.type(),
                    addedFunction.name(),
                    new LinkedHashSet<>(addedFunction.realizedByComponentIds()),
                    new LinkedHashSet<>(addedFunction.processesPersonalDataIds()),
                    new LinkedHashSet<>(addedFunction.hasPurposeIds())));
        }

        return new ManagedElementView(
                source.modelId,
                dataSubjects,
                personalData,
                functions,
                components,
                purposes,
                vulnerabilities,
                consents);
    }
}
