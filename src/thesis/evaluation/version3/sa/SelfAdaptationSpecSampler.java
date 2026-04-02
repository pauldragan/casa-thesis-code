package thesis.evaluation.version3.sa;

import java.util.Random;

final class SelfAdaptationSpecSampler {
    private final SelfAdaptationGenerationConfig config;

    SelfAdaptationSpecSampler(SelfAdaptationGenerationConfig config) {
        this.config = config;
    }

    SelfAdaptationSpec sample(SourceManagedElementProfile profile, int modelIndex, int adaptationIndex) {
        long sourceModelSeed = config.baseSeed + modelIndex;
        long seed = config.baseSeed + (modelIndex * 1000L) + adaptationIndex;
        return sample(profile, modelIndex, adaptationIndex, sourceModelSeed, seed);
    }

    SelfAdaptationSpec sample(
            SourceManagedElementProfile profile,
            int modelIndex,
            int adaptationIndex,
            long sourceModelSeed,
            long seed) {
        Random random = new Random(seed);
        SelfAdaptationCombination combination = SelfAdaptationCombination.fromIndex(adaptationIndex);

        SelfAdaptationSpec spec = new SelfAdaptationSpec();
        spec.modelIndex = modelIndex;
        spec.adaptationIndex = adaptationIndex;
        spec.sourceModelSeed = sourceModelSeed;
        spec.seed = seed;
        spec.sourceModelId = profile.modelId;
        spec.combination = combination;

        spec.addFunctionCount = sampleFunctionAdds(combination, random);
        spec.removeFunctionCount = sampleFunctionRemovals(profile, combination, random);
        spec.addComponentCount = sampleComponentAdds(combination, random);
        spec.removeComponentCount = sampleComponentRemovals(profile, combination, random);

        spec.requestedPurposeViolations = samplePurposeViolations(profile, spec, random);
        spec.requestedRiskViolations = sampleRiskViolations(profile, spec, random);

        return spec;
    }

    private int sampleFunctionAdds(SelfAdaptationCombination combination, Random random) {
        int min = 0;
        if (combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_SAFE)) {
            min++;
        }
        if (combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION)) {
            min++;
        }
        if (min == 0) {
            return 0;
        }
        int max = config.maxAddedFunctions;
        return sampleInRange(random, min, max);
    }

    private int sampleFunctionRemovals(
            SourceManagedElementProfile profile,
            SelfAdaptationCombination combination,
            Random random) {
        if (!combination.has(SelfAdaptationAtomicCase.REMOVE_FUNCTION)) {
            return 0;
        }
        int max = profile.maxRemovableFunctions();
        int min = Math.min(1, max);
        return sampleInRange(random, min, max);
    }

    private int sampleComponentAdds(SelfAdaptationCombination combination, Random random) {
        int min = 0;
        if (combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_SAFE)) {
            min++;
        }
        if (combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION)) {
            min++;
        }
        if (min == 0) {
            return 0;
        }
        int max = config.maxAddedComponents;
        return sampleInRange(random, min, max);
    }

    private int sampleComponentRemovals(
            SourceManagedElementProfile profile,
            SelfAdaptationCombination combination,
            Random random) {
        if (!combination.has(SelfAdaptationAtomicCase.REMOVE_COMPONENT)) {
            return 0;
        }
        int max = profile.maxRemovableComponents();
        int min = Math.min(1, max);
        return sampleInRange(random, min, max);
    }

    private int samplePurposeViolations(SourceManagedElementProfile profile, SelfAdaptationSpec spec, Random random) {
        if (!spec.combination.has(SelfAdaptationAtomicCase.ADD_FUNCTION_PURPOSE_VIOLATION) || spec.addFunctionCount == 0) {
            return 0;
        }
        int perFunction = sampleInRange(random, 1, profile.totalDataSubjects);
        return perFunction * spec.addFunctionCount;
    }

    private int sampleRiskViolations(SourceManagedElementProfile profile, SelfAdaptationSpec spec, Random random) {
        if (!spec.combination.has(SelfAdaptationAtomicCase.ADD_COMPONENT_RISK_VIOLATION) || spec.addComponentCount == 0) {
            return 0;
        }
        int perComponent = sampleInRange(random, 1, profile.totalDataSubjects);
        return perComponent * spec.addComponentCount;
    }

    private static int sampleInRange(Random random, int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range [" + min + ", " + max + "]");
        }
        if (min == max) {
            return min;
        }
        return min + random.nextInt(max - min + 1);
    }
}
