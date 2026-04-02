package thesis.evaluation.version3.sa;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

record SelfAdaptationCombination(
        int combinationIndex,
        int mask,
        EnumSet<SelfAdaptationAtomicCase> cases) {

    static final int COUNT = (1 << SelfAdaptationAtomicCase.values().length) - 1;

    static SelfAdaptationCombination fromIndex(int combinationIndex) {
        if (combinationIndex < 0 || combinationIndex >= COUNT) {
            throw new IllegalArgumentException("combinationIndex must be in [0, " + (COUNT - 1) + "]: "
                    + combinationIndex);
        }
        int mask = combinationIndex + 1;
        EnumSet<SelfAdaptationAtomicCase> selected = EnumSet.noneOf(SelfAdaptationAtomicCase.class);
        for (SelfAdaptationAtomicCase atomicCase : SelfAdaptationAtomicCase.values()) {
            if ((mask & atomicCase.bit) != 0) {
                selected.add(atomicCase);
            }
        }
        return new SelfAdaptationCombination(combinationIndex, mask, selected);
    }

    boolean has(SelfAdaptationAtomicCase atomicCase) {
        return cases.contains(atomicCase);
    }

    String bits() {
        return String.format("%6s", Integer.toBinaryString(mask)).replace(' ', '0');
    }

    String caseSlug() {
        List<String> selectedCodes = new ArrayList<>();
        for (SelfAdaptationAtomicCase atomicCase : List.of(
                SelfAdaptationAtomicCase.ADD_FUNCTION_SAFE,
                SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION,
                SelfAdaptationAtomicCase.REMOVE_FUNCTION,
                SelfAdaptationAtomicCase.ADD_COMPONENT_SAFE,
                SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION,
                SelfAdaptationAtomicCase.REMOVE_COMPONENT)) {
            if (cases.contains(atomicCase)) {
                selectedCodes.add(atomicCase.shortCode);
            }
        }
        return String.join("_", selectedCodes);
    }
}
