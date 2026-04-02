package thesis.evaluation.version3.result_evaluation;

import java.nio.file.Path;

record EvaluationInputUnit(
        int modelIndex,
        String modelId,
        int adaptationIndex,
        String adaptationId,
        String caseSlug,
        long sourceModelSeed,
        long specSeed,
        Path sourceModelPath,
        Path prospectiveModelPath) {
}
