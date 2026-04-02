package thesis;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class CASAPurposeModelTests {

	private static final String PURPOSE_MODEL_PATH = "src/resources/casa-v3-eval-purpose-model.owx";

	private CASAPurposeModelTests() {
	}

	public static void runAll() {
		TestSupportV3.run("thesis.CASAPurposeModel.resolvesCommentsToSocialAsSpecialization",
				CASAPurposeModelTests::resolvesCommentsToSocialAsSpecialization);
		TestSupportV3.run("thesis.CASAPurposeModel.resolvesMarketingToCommentsAsUnrelated",
				CASAPurposeModelTests::resolvesMarketingToCommentsAsUnrelated);
		TestSupportV3.run("thesis.CASAPurposeModel.resolvesTargetedAdsToMarketingAsSpecialization",
				CASAPurposeModelTests::resolvesTargetedAdsToMarketingAsSpecialization);
		TestSupportV3.run("thesis.CASAPurposeModel.resolvesMarketingToTargetedAdsAsGeneralization",
				CASAPurposeModelTests::resolvesMarketingToTargetedAdsAsGeneralization);
	}

	private static void resolvesCommentsToSocialAsSpecialization() {
		CASAPurposeModel model = new CASAPurposeModel(PURPOSE_MODEL_PATH);
		TestSupportV3.equals(CASAPurposeModel.PurposeRelation.SPECIALIZATION,
				model.calculatePurposeRelation("Comments", "Social"),
				"CASAPurposeModel should resolve Comments -> Social as specialization");
	}

	private static void resolvesMarketingToCommentsAsUnrelated() {
		CASAPurposeModel model = new CASAPurposeModel(PURPOSE_MODEL_PATH);
		TestSupportV3.equals(CASAPurposeModel.PurposeRelation.NONE,
				model.calculatePurposeRelation("Marketing", "Comments"),
				"CASAPurposeModel should resolve Marketing -> Comments as unrelated");
	}

	private static void resolvesTargetedAdsToMarketingAsSpecialization() {
		CASAPurposeModel model = new CASAPurposeModel(PURPOSE_MODEL_PATH);
		TestSupportV3.equals(CASAPurposeModel.PurposeRelation.SPECIALIZATION,
				model.calculatePurposeRelation("TargetedAds", "Marketing"),
				"CASAPurposeModel should resolve TargetedAds -> Marketing as specialization");
	}

	private static void resolvesMarketingToTargetedAdsAsGeneralization() {
		CASAPurposeModel model = new CASAPurposeModel(PURPOSE_MODEL_PATH);
		TestSupportV3.equals(CASAPurposeModel.PurposeRelation.GENERALIZATION,
				model.calculatePurposeRelation("Marketing", "TargetedAds"),
				"CASAPurposeModel should resolve Marketing -> TargetedAds as generalization");
	}
}
