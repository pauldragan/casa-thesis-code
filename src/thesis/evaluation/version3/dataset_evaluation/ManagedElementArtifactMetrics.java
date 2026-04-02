package thesis.evaluation.version3.dataset_evaluation;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class ManagedElementArtifactMetrics {
    int modelIndex;
    String modelId;
    String xmiPath;

    final Map<String, Integer> countByType = new LinkedHashMap<>();
    final Map<String, Integer> relationCountByType = new LinkedHashMap<>();
    final Map<String, List<Integer>> personalDataCountsPerDataSubjectByType = new LinkedHashMap<>();
    final Map<String, List<Integer>> relationValuesPerFunctionByType = new LinkedHashMap<>();

    int totalInstances;
    int totalRelations;
    double connectivity;

    int realizesTotal;
    int processesTotal;
    int hasPurposeTotal;
    int affectedByTotal;

    int realizesMin;
    int realizesMax;
    double realizesAvg;

    int processesMin;
    int processesMax;
    double processesAvg;

    int hasPurposeMin;
    int hasPurposeMax;
    double hasPurposeAvg;

    int affectedByMin;
    int affectedByMax;
    double affectedByAvg;
}
