package thesis;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class CASARiskConsentRulesTests {

	private CASARiskConsentRulesTests() {
	}

	public static void runAll() {
		TestSupportV3.run("thesis.CASARiskConsentRules.violatesWhenDifferenceEqualsThreshold",
				CASARiskConsentRulesTests::violatesWhenDifferenceEqualsThreshold);
		TestSupportV3.run("thesis.CASARiskConsentRules.violatesWhenDifferenceExceedsThreshold",
				CASARiskConsentRulesTests::violatesWhenDifferenceExceedsThreshold);
		TestSupportV3.run("thesis.CASARiskConsentRules.doesNotViolateWhenDifferenceIsBelowThreshold",
				CASARiskConsentRulesTests::doesNotViolateWhenDifferenceIsBelowThreshold);
		TestSupportV3.run("thesis.CASARiskConsentRules.computesAcceptableRiskLevelAsBasePlusThreshold",
				CASARiskConsentRulesTests::computesAcceptableRiskLevelAsBasePlusThreshold);
	}

	private static void violatesWhenDifferenceEqualsThreshold() {
		CASARiskConsentRules rules = new CASARiskConsentRules(10.0);
		TestSupportV3.equals(CASARiskConsentRules.RiskConsentViolation.VIOLATED,
				rules.applyRule(20.0, 10.0),
				"CASARiskConsentRules should violate when difference equals threshold");
	}

	private static void violatesWhenDifferenceExceedsThreshold() {
		CASARiskConsentRules rules = new CASARiskConsentRules(10.0);
		TestSupportV3.equals(CASARiskConsentRules.RiskConsentViolation.VIOLATED,
				rules.applyRule(25.0, 10.0),
				"CASARiskConsentRules should violate when difference exceeds threshold");
	}

	private static void doesNotViolateWhenDifferenceIsBelowThreshold() {
		CASARiskConsentRules rules = new CASARiskConsentRules(10.0);
		TestSupportV3.equals(CASARiskConsentRules.RiskConsentViolation.NOT_VIOLATED,
				rules.applyRule(19.999, 10.0),
				"CASARiskConsentRules should not violate when difference is below threshold");
	}

	private static void computesAcceptableRiskLevelAsBasePlusThreshold() {
		CASARiskConsentRules rules = new CASARiskConsentRules(10.0);
		TestSupportV3.equals(15.0, rules.getAcceptableRiskLevel(5.0),
				"CASARiskConsentRules should compute acceptable risk as base plus threshold");
	}
}
