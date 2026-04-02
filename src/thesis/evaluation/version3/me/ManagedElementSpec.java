package thesis.evaluation.version3.me;

import java.util.LinkedHashMap;
import java.util.Map;

final class ManagedElementSpec {
    final int modelIndex;
    final long seed;

    final Map<String, Integer> dataSubjectCountByType;
    final Map<String, Integer> functionCountByType;
    final Map<String, Integer> componentCountByType;

    final int expectedPurposeConcepts;
    final int expectedVulnerabilityConcepts;

    ManagedElementSpec(
            int modelIndex,
            long seed,
            Map<String, Integer> dataSubjectCountByType,
            Map<String, Integer> functionCountByType,
            Map<String, Integer> componentCountByType,
            int expectedPurposeConcepts,
            int expectedVulnerabilityConcepts) {
        this.modelIndex = modelIndex;
        this.seed = seed;
        this.dataSubjectCountByType = new LinkedHashMap<>(dataSubjectCountByType);
        this.functionCountByType = new LinkedHashMap<>(functionCountByType);
        this.componentCountByType = new LinkedHashMap<>(componentCountByType);
        this.expectedPurposeConcepts = expectedPurposeConcepts;
        this.expectedVulnerabilityConcepts = expectedVulnerabilityConcepts;
    }

    int totalDataSubjects() {
        return dataSubjectCountByType.values().stream().mapToInt(Integer::intValue).sum();
    }

    int totalFunctions() {
        return functionCountByType.values().stream().mapToInt(Integer::intValue).sum();
    }

    int totalComponents() {
        return componentCountByType.values().stream().mapToInt(Integer::intValue).sum();
    }
}
