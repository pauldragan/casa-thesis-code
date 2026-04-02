package thesis.evaluation.version3.tests;

import java.util.Collection;
import java.util.Objects;

public final class TestSupportV3 {
    private TestSupportV3() {
    }

    public static void check(boolean condition, String message) {
        if (!condition) {
            throw new AssertionError(message);
        }
    }

    public static void equals(Object expected, Object actual, String message) {
        if (!Objects.equals(expected, actual)) {
            throw new AssertionError(message + " | expected=" + expected + ", actual=" + actual);
        }
    }

    public static void notEmpty(Collection<?> values, String message) {
        if (values == null || values.isEmpty()) {
            throw new AssertionError(message);
        }
    }

    public static void run(String testName, Runnable test) {
        System.out.println("[v3_tests] START  " + testName);
        test.run();
        System.out.println("[v3_tests] PASS   " + testName);
    }
}
