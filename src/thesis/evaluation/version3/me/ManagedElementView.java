package thesis.evaluation.version3.me;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

public final class ManagedElementView {
    public final String modelId;
    public final Map<String, DataSubjectView> dataSubjects;
    public final Map<String, PersonalDataView> personalData;
    public final Map<String, FunctionView> functions;
    public final Map<String, ComponentView> components;
    public final Map<String, PurposeView> purposes;
    public final Map<String, VulnerabilityView> vulnerabilities;
    public final Map<String, ConsentView> consents;

    public ManagedElementView(
            String modelId,
            Map<String, DataSubjectView> dataSubjects,
            Map<String, PersonalDataView> personalData,
            Map<String, FunctionView> functions,
            Map<String, ComponentView> components,
            Map<String, PurposeView> purposes,
            Map<String, VulnerabilityView> vulnerabilities,
            Map<String, ConsentView> consents) {
        this.modelId = modelId;
        this.dataSubjects = new LinkedHashMap<>(dataSubjects);
        this.personalData = new LinkedHashMap<>(personalData);
        this.functions = new LinkedHashMap<>(functions);
        this.components = new LinkedHashMap<>(components);
        this.purposes = new LinkedHashMap<>(purposes);
        this.vulnerabilities = new LinkedHashMap<>(vulnerabilities);
        this.consents = new LinkedHashMap<>(consents);
    }

    public record DataSubjectView(String id, String type, String name) {}
    public record PersonalDataView(String id, String type, String name, String identifiesDsId) {}
    public record FunctionView(
            String id,
            String type,
            String name,
            Set<String> realizedByComponentIds,
            Set<String> processesPersonalDataIds,
            Set<String> hasPurposeIds) {}
    public record ComponentView(String id, String type, String name) {}
    public record PurposeView(String id, String type, String name) {}
    public record VulnerabilityView(String id, String cveName, String componentTypeOwner) {}
    public record ConsentView(String id, String givenByDsId, String forPersonalDataId, String givenForPurposeId) {}
}
