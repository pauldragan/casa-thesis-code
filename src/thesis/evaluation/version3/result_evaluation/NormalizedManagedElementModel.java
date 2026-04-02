package thesis.evaluation.version3.result_evaluation;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

public final class NormalizedManagedElementModel {
    public String modelId;
    public final Map<String, String> dataSubjectTypes = new LinkedHashMap<>();
    public final Map<String, String> personalDataTypes = new LinkedHashMap<>();
    public final Map<String, String> personalDataIdentifies = new LinkedHashMap<>();
    public final Map<String, String> functionTypes = new LinkedHashMap<>();
    public final Map<String, Set<String>> functionRealizedBy = new LinkedHashMap<>();
    public final Map<String, Set<String>> functionProcesses = new LinkedHashMap<>();
    public final Map<String, Set<String>> functionHasPurpose = new LinkedHashMap<>();
    public final Map<String, String> componentTypes = new LinkedHashMap<>();
    public final Map<String, String> purposeTypes = new LinkedHashMap<>();
    public final Set<String> vulnerabilityCves = new LinkedHashSet<>();
    public final Map<String, Set<String>> vulnerabilityAffects = new LinkedHashMap<>();
    public final Set<String> consentKeys = new LinkedHashSet<>();

    public void addFunction(String functionId, String functionType) {
        functionTypes.put(functionId, functionType);
        functionRealizedBy.computeIfAbsent(functionId, ignored -> new LinkedHashSet<>());
        functionProcesses.computeIfAbsent(functionId, ignored -> new LinkedHashSet<>());
        functionHasPurpose.computeIfAbsent(functionId, ignored -> new LinkedHashSet<>());
    }

    public void addVulnerability(String cve) {
        vulnerabilityCves.add(cve);
        vulnerabilityAffects.computeIfAbsent(cve, ignored -> new LinkedHashSet<>());
    }
}
