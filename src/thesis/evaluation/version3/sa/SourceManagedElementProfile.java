package thesis.evaluation.version3.sa;

import java.util.LinkedHashMap;
import java.util.Map;

final class SourceManagedElementProfile {
    final String modelId;
    final int totalDataSubjects;
    final int totalFunctions;
    final int totalComponents;

    final Map<String, Integer> functionCountByType;
    final Map<String, Integer> componentCountByType;

    SourceManagedElementProfile(
            String modelId,
            int totalDataSubjects,
            int totalFunctions,
            int totalComponents,
            Map<String, Integer> functionCountByType,
            Map<String, Integer> componentCountByType) {
        this.modelId = modelId;
        this.totalDataSubjects = totalDataSubjects;
        this.totalFunctions = totalFunctions;
        this.totalComponents = totalComponents;
        this.functionCountByType = new LinkedHashMap<>(functionCountByType);
        this.componentCountByType = new LinkedHashMap<>(componentCountByType);
    }

    int maxRemovableFunctions() {
        return Math.max(0, Math.min(10, totalFunctions - 4));
    }

    int maxRemovableComponents() {
        return Math.max(0, Math.min(6, totalComponents - 6));
    }
}
