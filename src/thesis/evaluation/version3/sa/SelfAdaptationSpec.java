package thesis.evaluation.version3.sa;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class SelfAdaptationSpec {
    int modelIndex;
    int adaptationIndex;
    long sourceModelSeed;
    long seed;
    String sourceModelId;

    SelfAdaptationCombination combination;

    int addFunctionCount;
    int removeFunctionCount;
    int addComponentCount;
    int removeComponentCount;

    int requestedPurposeViolations;
    int requestedRiskViolations;

    final Map<String, Integer> requestedPurposeViolationsPerFunctionType = new LinkedHashMap<>();
    final Map<String, Integer> requestedRiskViolationsPerComponentType = new LinkedHashMap<>();
    final List<String> notes = new ArrayList<>();
}
