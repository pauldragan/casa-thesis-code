package thesis.evaluation.version3.me;

import java.util.ArrayList;
import java.util.List;

final class ValidationResult {
    final List<String> violations = new ArrayList<>();

    boolean isValid() {
        return violations.isEmpty();
    }

    void add(String violation) {
        violations.add(violation);
    }

    String errorCode() {
        return isValid() ? "" : "VALIDATION_FAILED";
    }

    String message() {
        return String.join(" | ", violations);
    }
}
