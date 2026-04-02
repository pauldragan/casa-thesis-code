package thesis;

import java.lang.reflect.Field;

import CASA.Consent;
import CASA.PurposeConsent;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class CASAPurposeTests {

	private static final String PURPOSE_MODEL_PATH = "src/resources/casa-v3-eval-purpose-model.owx";

	private CASAPurposeTests() {
	}

	public static void runAll() {
		TestSupportV3.run("thesis.CASAPurpose.recordsViolationWhenNoLawfulBasisExists",
				CASAPurposeTests::recordsViolationWhenNoLawfulBasisExists);
		TestSupportV3.run("thesis.CASAPurpose.recordsOkConsentWhenLawfulBasisExists",
				CASAPurposeTests::recordsOkConsentWhenLawfulBasisExists);
		TestSupportV3.run("thesis.CASAPurpose.usesFirstNonViolatingAsConfiguredPolicy",
				CASAPurposeTests::usesFirstNonViolatingAsConfiguredPolicy);
		TestSupportV3.run("thesis.CASAPurpose.returnsNoCorrectedModelWhenViolationsExist",
				CASAPurposeTests::returnsNoCorrectedModelWhenViolationsExist);
		TestSupportV3.run("thesis.CASAPurpose.producesCorrectedModelWhenViolationsDoNotExist",
				CASAPurposeTests::producesCorrectedModelWhenViolationsDoNotExist);
		TestSupportV3.run("thesis.CASAPurpose.correctedModelRemovesExistingPurposeConsentLinks",
				CASAPurposeTests::correctedModelRemovesExistingPurposeConsentLinks);
		TestSupportV3.run("thesis.CASAPurpose.correctedModelRecreatesOnlySelectedLawfulBasisLinks",
				CASAPurposeTests::correctedModelRecreatesOnlySelectedLawfulBasisLinks);
		TestSupportV3.run("thesis.CASAPurpose.multipleCompatibleConsentsKeepOnlySelectedOne",
				CASAPurposeTests::multipleCompatibleConsentsKeepOnlySelectedOne);
	}

	private static void recordsViolationWhenNoLawfulBasisExists() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		CASATestFixtures.addConsent(fixture, "cons_marketing", "PMarketing");

		CASAPurpose purpose = new CASAPurpose(PURPOSE_MODEL_PATH, CASAPurpose.PurposeNameMappingMode.V3);
		CASAPurpose.PurposeCheckResult result = purpose
				.applyCASAPurposeDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.check(result.isViolated(), "CASAPurpose should report a violation when no lawful basis exists");
		TestSupportV3.equals(1, result.getAnalysis().getViolations().size(),
				"CASAPurpose should record one violating tuple");
		TestSupportV3.equals(0, result.getAnalysis().getOkConsent().size(),
				"CASAPurpose should not record okConsent when no lawful basis exists");
	}

	private static void recordsOkConsentWhenLawfulBasisExists() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		Consent consent = CASATestFixtures.addConsent(fixture, "cons_social", "PSocial");

		CASAPurpose purpose = new CASAPurpose(PURPOSE_MODEL_PATH, CASAPurpose.PurposeNameMappingMode.V3);
		CASAPurpose.PurposeCheckResult result = purpose
				.applyCASAPurposeDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.check(!result.isViolated(), "CASAPurpose should accept a specialization-compatible lawful basis");
		TestSupportV3.equals(0, result.getAnalysis().getViolations().size(),
				"CASAPurpose should not record violations when lawful basis exists");
		TestSupportV3.equals(1, result.getAnalysis().getOkConsent().size(),
				"CASAPurpose should record exactly one selected lawful basis");
		TestSupportV3.equals(consent, result.getAnalysis().getOkConsent().get(0).getC(),
				"CASAPurpose should record the selected consent as okConsent");
	}

	private static void usesFirstNonViolatingAsConfiguredPolicy() {
		CASAPurpose purpose = new CASAPurpose(PURPOSE_MODEL_PATH, CASAPurpose.PurposeNameMappingMode.V3);
		try {
			Field field = CASAPurpose.class.getDeclaredField("lawfulBasisSelectionPolicy");
			field.setAccessible(true);
			Object value = field.get(purpose);
			TestSupportV3.check(value instanceof FirstNonViolating,
					"CASAPurpose should default to FirstNonViolating lawful-basis selection");
		} catch (ReflectiveOperationException e) {
			throw new AssertionError("Could not inspect lawfulBasisSelectionPolicy field", e);
		}
	}

	private static void returnsNoCorrectedModelWhenViolationsExist() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		CASATestFixtures.addConsent(fixture, "cons_marketing", "PMarketing");

		CASAPurpose purpose = new CASAPurpose(PURPOSE_MODEL_PATH, CASAPurpose.PurposeNameMappingMode.V3);
		CASAPurpose.PurposeCheckResult result = purpose
				.applyCASAPurposeDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.check(result.getCorrectedModel().isEmpty(),
				"CASAPurpose should not return a corrected model when violations exist");
	}

	private static void producesCorrectedModelWhenViolationsDoNotExist() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		CASATestFixtures.addConsent(fixture, "cons_social", "PSocial");

		CASAPurpose purpose = new CASAPurpose(PURPOSE_MODEL_PATH, CASAPurpose.PurposeNameMappingMode.V3);
		CASAPurpose.PurposeCheckResult result = purpose
				.applyCASAPurposeDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.check(result.getCorrectedModel().isPresent(),
				"CASAPurpose should return a corrected model when no violations exist");
	}

	private static void correctedModelRemovesExistingPurposeConsentLinks() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		Consent consent = CASATestFixtures.addConsent(fixture, "cons_social", "PSocial");
		consent.getGivenFor().add(fixture.marketingPurpose());

		CASAPurpose purpose = new CASAPurpose(PURPOSE_MODEL_PATH, CASAPurpose.PurposeNameMappingMode.V3);
		CASAPurpose.PurposeCheckResult result = purpose
				.applyCASAPurposeDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		CASA.System corrected = CASATestFixtures.correctedRoot(result);
		PurposeConsent correctedMarketing = (PurposeConsent) CASATestFixtures.findPurposeByName(corrected, "PMarketing");
		Consent correctedConsent = CASATestFixtures.findConsentByForPurpose(corrected, "PSocial");

		TestSupportV3.equals(0, correctedMarketing.getRequires().size(),
				"Corrected model should remove stale marketing-purpose consent links");
		TestSupportV3.check(!correctedConsent.getGivenFor().contains(correctedMarketing),
				"Corrected model should remove stale consent.givenFor links");
	}

	private static void correctedModelRecreatesOnlySelectedLawfulBasisLinks() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		CASATestFixtures.addConsent(fixture, "cons_social", "PSocial");

		CASAPurpose purpose = new CASAPurpose(PURPOSE_MODEL_PATH, CASAPurpose.PurposeNameMappingMode.V3);
		CASAPurpose.PurposeCheckResult result = purpose
				.applyCASAPurposeDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		CASA.System corrected = CASATestFixtures.correctedRoot(result);
		PurposeConsent correctedComments = (PurposeConsent) CASATestFixtures.findPurposeByName(corrected, "PComments");
		PurposeConsent correctedSocial = (PurposeConsent) CASATestFixtures.findPurposeByName(corrected, "PSocial");
		Consent correctedConsent = CASATestFixtures.findConsentByForPurpose(corrected, "PSocial");

		TestSupportV3.equals(1, correctedComments.getRequires().size(),
				"Corrected model should recreate exactly one selected lawful-basis link");
		TestSupportV3.equals(correctedConsent, correctedComments.getRequires().get(0),
				"Corrected model should connect the selected consent to the function purpose");
		TestSupportV3.equals(0, correctedSocial.getRequires().size(),
				"Corrected model should not link the consent to unrelated purpose nodes");
	}

	private static void multipleCompatibleConsentsKeepOnlySelectedOne() {
		CASATestFixtures.PurposeFixture fixture = CASATestFixtures.purposeFixture();
		Consent socialConsent = CASATestFixtures.addConsent(fixture, "cons_social", "PSocial");
		Consent exactConsent = CASATestFixtures.addConsent(fixture, "cons_comments", "PComments");

		CASAPurpose purpose = new CASAPurpose(PURPOSE_MODEL_PATH, CASAPurpose.PurposeNameMappingMode.V3);
		CASAPurpose.PurposeCheckResult result = purpose
				.applyCASAPurposeDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		CASA.System corrected = CASATestFixtures.correctedRoot(result);
		PurposeConsent correctedComments = (PurposeConsent) CASATestFixtures.findPurposeByName(corrected, "PComments");
		Consent correctedSocial = CASATestFixtures.findConsentByForPurpose(corrected, "PSocial");
		Consent correctedExact = CASATestFixtures.findConsentByForPurpose(corrected, "PComments");

		TestSupportV3.equals(1, correctedComments.getRequires().size(),
				"CASAPurpose should keep only one selected lawful basis for one tuple");
		Consent selected = correctedComments.getRequires().get(0);
		TestSupportV3.check(selected == correctedSocial || selected == correctedExact,
				"Selected lawful basis should be one of the compatible candidate consents");
		TestSupportV3.check(correctedSocial.getGivenFor().size() + correctedExact.getGivenFor().size() == 1,
				"Exactly one of the compatible consents should remain linked after correction");
	}
}
