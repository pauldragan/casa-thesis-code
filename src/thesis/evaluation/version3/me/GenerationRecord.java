package thesis.evaluation.version3.me;

final class GenerationRecord {
    int modelIndex;
    long seed;
    String modelId;
    String status;
    String xmiPath;
    String graphMlPath;

    ManagedElementSpec spec;
    ModelStats stats;
    ValidationResult validation;
    PruneResult prune;
}
