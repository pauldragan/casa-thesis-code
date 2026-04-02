package thesis.evaluation.version3.sa;

enum SelfAdaptationAtomicCase {
    ADD_FUNCTION_SAFE(1 << 0, "afs"),
    ADD_FUNCTION_PURPOSE_VIOLATION(1 << 1, "afp"),
    REMOVE_FUNCTION(1 << 2, "rf"),
    ADD_COMPONENT_SAFE(1 << 3, "acs"),
    ADD_COMPONENT_RISK_VIOLATION(1 << 4, "acr"),
    REMOVE_COMPONENT(1 << 5, "rc");

    final int bit;
    final String shortCode;

    SelfAdaptationAtomicCase(int bit, String shortCode) {
        this.bit = bit;
        this.shortCode = shortCode;
    }
}
