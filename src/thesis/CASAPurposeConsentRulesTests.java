package thesis;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class CASAPurposeConsentRulesTests {

	private CASAPurposeConsentRulesTests() {
	}

	public static void runAll() {
		TestSupportV3.run("thesis.CASAPurposeConsentRules.treatsSameAsNotViolated",
				CASAPurposeConsentRulesTests::treatsSameAsNotViolated);
		TestSupportV3.run("thesis.CASAPurposeConsentRules.treatsSpecializationAsNotViolated",
				CASAPurposeConsentRulesTests::treatsSpecializationAsNotViolated);
		TestSupportV3.run("thesis.CASAPurposeConsentRules.treatsGeneralizationAsViolated",
				CASAPurposeConsentRulesTests::treatsGeneralizationAsViolated);
		TestSupportV3.run("thesis.CASAPurposeConsentRules.treatsUnrelatedAsViolated",
				CASAPurposeConsentRulesTests::treatsUnrelatedAsViolated);
	}

	private static void treatsSameAsNotViolated() {
		CASAPurposeConsentRules rules = new CASAPurposeConsentRules();
		TestSupportV3.equals(CASAPurposeConsentRules.PurposeConsentViolation.NOT_VIOLATED,
				rules.applyRule(CASAPurposeModel.PurposeRelation.SAME),
				"CASAPurposeConsentRules should accept SAME");
	}

	private static void treatsSpecializationAsNotViolated() {
		CASAPurposeConsentRules rules = new CASAPurposeConsentRules();
		TestSupportV3.equals(CASAPurposeConsentRules.PurposeConsentViolation.NOT_VIOLATED,
				rules.applyRule(CASAPurposeModel.PurposeRelation.SPECIALIZATION),
				"CASAPurposeConsentRules should accept SPECIALIZATION");
	}

	private static void treatsGeneralizationAsViolated() {
		CASAPurposeConsentRules rules = new CASAPurposeConsentRules();
		TestSupportV3.equals(CASAPurposeConsentRules.PurposeConsentViolation.VIOLATED,
				rules.applyRule(CASAPurposeModel.PurposeRelation.GENERALIZATION),
				"CASAPurposeConsentRules should reject GENERALIZATION");
	}

	private static void treatsUnrelatedAsViolated() {
		CASAPurposeConsentRules rules = new CASAPurposeConsentRules();
		TestSupportV3.equals(CASAPurposeConsentRules.PurposeConsentViolation.VIOLATED,
				rules.applyRule(CASAPurposeModel.PurposeRelation.NONE),
				"CASAPurposeConsentRules should reject unrelated purposes");
	}
}
