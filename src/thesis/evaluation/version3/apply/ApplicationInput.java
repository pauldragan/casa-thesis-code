package thesis.evaluation.version3.apply;

import java.nio.file.Path;

record ApplicationInput(
        int modelIndex,
        String modelId,
        int adaptationIndex,
        String adaptationId,
        String caseSlug,
        Path sourceModelPath,
        Path henshinPath,
        int expectedAddedFunctions,
        int expectedRemovedFunctions,
        int expectedAddedComponents,
        int expectedRemovedComponents) {
}
