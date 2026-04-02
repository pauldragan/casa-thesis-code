package thesis.evaluation.version3.me;

import java.util.random.RandomGenerator;

final class IntRange {
    final int min;
    final int max;

    IntRange(int min, int max) {
        if (min > max) {
            throw new IllegalArgumentException("Invalid range: min > max (" + min + " > " + max + ")");
        }
        this.min = min;
        this.max = max;
    }

    int sample(RandomGenerator rng) {
        if (min == max) {
            return min;
        }
        return min + rng.nextInt(max - min + 1);
    }

    @Override
    public String toString() {
        return "[" + min + "," + max + "]";
    }
}
