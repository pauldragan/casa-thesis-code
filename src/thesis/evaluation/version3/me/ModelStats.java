package thesis.evaluation.version3.me;

import java.util.LinkedHashMap;
import java.util.Map;

final class ModelStats {
    final Map<String, Integer> countByType = new LinkedHashMap<>();
    final Map<String, Integer> relationCountByType = new LinkedHashMap<>();

    int totalInstances;
    int totalRelations;
    double connectivity;
}
