package thesis;

import java.util.List;
import java.util.Optional;

import CASA.Consent;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class FirstNonViolatingTests {

	private static final String PURPOSE_MODEL_PATH = "src/resources/casa-v3-eval-purpose-model.owx";

	private FirstNonViolatingTests() {
	}

	public static void runAll() {
		TestSupportV3.run("thesis.FirstNonViolating.selectsFirstNonViolatingConsent",
				FirstNonViolatingTests::selectsFirstNonViolatingConsent);
		TestSupportV3.run("thesis.FirstNonViolating.returnsEmptyWhenAllCandidateConsentsViolate",
				FirstNonViolatingTests::returnsEmptyWhenAllCandidateConsentsViolate);
		TestSupportV3.run("thesis.FirstNonViolating.preservesCandidateIterationOrder",
				FirstNonViolatingTests::preservesCandidateIterationOrder);
	}

	private static void selectsFirstNonViolatingConsent() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		Consent violating = CASATestFixtures.addConsent(fixture, "cons_marketing", "PMarketing");
		Consent selected = CASATestFixtures.addConsent(fixture, "cons_social", "PSocial");

		FirstNonViolating policy = new FirstNonViolating();
		CASAPurposeModel model = new CASAPurposeModel(PURPOSE_MODEL_PATH);
		CASAPurposeConsentRules rules = new CASAPurposeConsentRules();

		Optional<Consent> result = policy.selectLawfulBasis(
				"Comments",
				List.of(violating, selected),
				model,
				rules,
				CASAPurpose.PurposeNameMappingMode.V3);

		TestSupportV3.equals(selected, result.orElse(null),
				"FirstNonViolating should select the first non-violating candidate");
	}

	private static void returnsEmptyWhenAllCandidateConsentsViolate() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		Consent violating = CASATestFixtures.addConsent(fixture, "cons_marketing", "PMarketing");

		FirstNonViolating policy = new FirstNonViolating();
		CASAPurposeModel model = new CASAPurposeModel(PURPOSE_MODEL_PATH);
		CASAPurposeConsentRules rules = new CASAPurposeConsentRules();

		Optional<Consent> result = policy.selectLawfulBasis(
				"Comments",
				List.of(violating),
				model,
				rules,
				CASAPurpose.PurposeNameMappingMode.V3);

		TestSupportV3.check(result.isEmpty(),
				"FirstNonViolating should return empty when all candidate consents violate");
	}

	private static void preservesCandidateIterationOrder() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		Consent firstCompatible = CASATestFixtures.addConsent(fixture, "cons_social", "PSocial");
		Consent secondCompatible = CASATestFixtures.addConsent(fixture, "cons_comments", "PComments");

		FirstNonViolating policy = new FirstNonViolating();
		CASAPurposeModel model = new CASAPurposeModel(PURPOSE_MODEL_PATH);
		CASAPurposeConsentRules rules = new CASAPurposeConsentRules();

		Optional<Consent> result = policy.selectLawfulBasis(
				"Comments",
				List.of(firstCompatible, secondCompatible),
				model,
				rules,
				CASAPurpose.PurposeNameMappingMode.V3);

		TestSupportV3.equals(firstCompatible, result.orElse(null),
				"FirstNonViolating should preserve candidate iteration order");
	}
}
