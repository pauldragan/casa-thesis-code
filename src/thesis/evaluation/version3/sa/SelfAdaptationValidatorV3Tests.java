package thesis.evaluation.version3.sa;

import java.util.Map;
import java.util.Set;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class SelfAdaptationValidatorV3Tests {
    private SelfAdaptationValidatorV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.SelfAdaptationValidatorV3.rejectsSpecWithMissingRequestedViolations",
                SelfAdaptationValidatorV3Tests::rejectsSpecWithMissingRequestedViolations);
        TestSupportV3.run("sa.SelfAdaptationValidatorV3.rejectsSemanticallyUnrealizedCase",
                SelfAdaptationValidatorV3Tests::rejectsSemanticallyUnrealizedCase);
        TestSupportV3.run("sa.SelfAdaptationValidatorV3.acceptsValidButUnderachievedCase",
                SelfAdaptationValidatorV3Tests::acceptsValidButUnderachievedCase);
    }

    private static void rejectsSpecWithMissingRequestedViolations() {
        SelfAdaptationValidatorV3 validator = new SelfAdaptationValidatorV3();
        SourceManagedElementProfile profile = new SourceManagedElementProfile(
                "me_test",
                1,
                5,
                7,
                Map.of("FUploadVideo", 1),
                Map.of("CNginx", 2));
        SelfAdaptationSpec spec = baseSpec(1);
        spec.requestedPurposeViolations = 0;

        SaValidationResult result = validator.validate(profile, spec);

        TestSupportV3.check(!result.valid(), "Validator should reject afp spec without requested purpose violations");
        TestSupportV3.equals("SA_SPEC_INVALID", result.errorCode(), "Spec invalid code should be reported");
        TestSupportV3.check(result.message().contains("purpose_violation_case_without_requested_violations"),
                "Validator should explain the missing requested purpose violations");
    }

    private static void rejectsSemanticallyUnrealizedCase() {
        SelfAdaptationValidatorV3 validator = new SelfAdaptationValidatorV3();
        SelfAdaptationSpec spec = baseSpec(1);
        spec.requestedPurposeViolations = 2;
        SelfAdaptationInstance instance = new SelfAdaptationInstance();
        instance.adaptationId = "sa_test";
        instance.sourceModelId = "me_test";
        instance.addedFunctions.add(new SelfAdaptationInstance.AddedFunction(
                "fn1", "FUploadVideo", "fn1", Set.of("pd1"), Set.of("PComments"), Set.of("c1")));

        SaValidationResult result = validator.validateInstantiatedCase(spec, instance);

        TestSupportV3.check(!result.valid(), "Validator should reject afp case without an actual violating function");
        TestSupportV3.check(result.message().contains("missing_purpose_violating_added_function"),
                "Validator should report the missing violating function");
    }

    private static void acceptsValidButUnderachievedCase() {
        SelfAdaptationValidatorV3 validator = new SelfAdaptationValidatorV3();
        SelfAdaptationSpec spec = baseSpec(17);
        spec.addFunctionCount = 1;
        spec.addComponentCount = 1;
        spec.requestedPurposeViolations = 5;
        spec.requestedRiskViolations = 4;

        SelfAdaptationInstance instance = new SelfAdaptationInstance();
        instance.adaptationId = "sa_test";
        instance.sourceModelId = "me_test";
        instance.addedFunctions.add(new SelfAdaptationInstance.AddedFunction(
                "fn1", "FUploadVideo", "fn1", Set.of("pd1"), Set.of("PMarketing"), Set.of("c2")));
        instance.addedComponents.add(new SelfAdaptationInstance.AddedComponent(
                "c2", "CNginx", "c2", Set.of("f1"), Set.of("v1"), Set.of("CVE-1")));
        instance.expectedPurposeViolations.add(new ExpectedViolation("purpose", "ds1", "pd1", "fn1", "", "PMarketing", "", ""));
        instance.expectedIdentifiablePurposeViolations.add(new ExpectedViolation("purpose", "ds1", "pd1", "fn1", "", "PMarketing", "", ""));
        instance.expectedRiskViolations.add(new ExpectedViolation("risk", "ds1", "", "f1", "c2", "", "v1", ""));
        instance.notes.add("requested purpose violations underachieved: requested=5, achieved=1");
        instance.notes.add("requested risk violations underachieved: requested=4, achieved=1");

        SaValidationResult result = validator.validateInstantiatedCase(spec, instance);

        TestSupportV3.check(result.valid(), "Validator should accept semantically realized cases despite numeric underachievement");
    }

    private static SelfAdaptationSpec baseSpec(int combinationIndex) {
        SelfAdaptationSpec spec = new SelfAdaptationSpec();
        spec.modelIndex = 0;
        spec.adaptationIndex = combinationIndex;
        spec.sourceModelSeed = 1L;
        spec.seed = 100L + combinationIndex;
        spec.sourceModelId = "me_test";
        spec.combination = SelfAdaptationCombination.fromIndex(combinationIndex);
        spec.addFunctionCount = 1;
        spec.removeFunctionCount = 0;
        spec.addComponentCount = 0;
        spec.removeComponentCount = 0;
        return spec;
    }
}
