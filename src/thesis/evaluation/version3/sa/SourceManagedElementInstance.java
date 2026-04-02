package thesis.evaluation.version3.sa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class SourceManagedElementInstance {
    final String modelId;

    final Map<String, DataSubjectView> dataSubjects = new LinkedHashMap<>();
    final Map<String, PersonalDataView> personalData = new LinkedHashMap<>();
    final Map<String, FunctionView> functions = new LinkedHashMap<>();
    final Map<String, ComponentView> components = new LinkedHashMap<>();
    final Map<String, PurposeView> purposes = new LinkedHashMap<>();
    final Map<String, VulnerabilityView> vulnerabilities = new LinkedHashMap<>();
    final Map<String, ConsentView> consents = new LinkedHashMap<>();

    SourceManagedElementInstance(String modelId) {
        this.modelId = modelId;
    }

    List<String> personalDataIdsSorted() {
        return new ArrayList<>(personalData.keySet());
    }

    List<String> functionIdsSorted() {
        return new ArrayList<>(functions.keySet());
    }

    List<String> componentIdsSorted() {
        return new ArrayList<>(components.keySet());
    }

    Set<String> consentPurposeTypesForPersonalData(String personalDataId) {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        for (ConsentView consent : consents.values()) {
            if (personalDataId.equals(consent.forPersonalDataId)) {
                PurposeView purpose = purposes.get(consent.givenForPurposeId);
                if (purpose != null) {
                    result.add(purpose.type());
                }
            }
        }
        return result;
    }

    Set<String> dataSubjectIdsProcessedByFunction(String functionId) {
        LinkedHashSet<String> result = new LinkedHashSet<>();
        FunctionView function = functions.get(functionId);
        if (function == null) {
            return result;
        }
        for (String personalDataId : function.processesPersonalDataIds) {
            PersonalDataView pd = personalData.get(personalDataId);
            if (pd != null) {
                result.add(pd.identifiesDsId);
            }
        }
        return result;
    }

    record DataSubjectView(String id, String type, String name) {
    }

    record PersonalDataView(String id, String type, String name, String identifiesDsId) {
    }

    record FunctionView(
            String id,
            String type,
            String name,
            Set<String> realizedByComponentIds,
            Set<String> processesPersonalDataIds,
            Set<String> hasPurposeIds) {
    }

    record ComponentView(String id, String type, String name) {
    }

    record PurposeView(String id, String type, String name) {
    }

    record VulnerabilityView(String id, String cveName, String componentTypeOwner) {
    }

    record ConsentView(String id, String givenByDsId, String forPersonalDataId, String givenForPurposeId) {
    }
}
