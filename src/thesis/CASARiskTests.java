package thesis;

import java.util.List;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class CASARiskTests {

	private CASARiskTests() {
	}

	public static void runAll() {
		TestSupportV3.run("thesis.CASARisk.identifiesRiskRelevantDataSubjectWhenVulnerabilityIsReachable",
				CASARiskTests::identifiesRiskRelevantDataSubjectWhenVulnerabilityIsReachable);
		TestSupportV3.run("thesis.CASARisk.computesZeroRiskWhenNoVulnerabilityIsReachable",
				CASARiskTests::computesZeroRiskWhenNoVulnerabilityIsReachable);
		TestSupportV3.run("thesis.CASARisk.computesDeterministicExhaustiveRiskForSingleVulnerability",
				CASARiskTests::computesDeterministicExhaustiveRiskForSingleVulnerability);
		TestSupportV3.run("thesis.CASARisk.autoModeUsesExhaustiveAtOrBelowCutoff",
				CASARiskTests::autoModeUsesExhaustiveAtOrBelowCutoff);
		TestSupportV3.run("thesis.CASARisk.autoModeUsesMonteCarloAboveCutoff",
				CASARiskTests::autoModeUsesMonteCarloAboveCutoff);
		TestSupportV3.run("thesis.CASARisk.disabledVulnerabilityContributesZeroRisk",
				CASARiskTests::disabledVulnerabilityContributesZeroRisk);
		TestSupportV3.run("thesis.CASARisk.detailedResultChecksAllConsentsOfDataSubject",
				CASARiskTests::detailedResultChecksAllConsentsOfDataSubject);
		TestSupportV3.run("thesis.CASARisk.detailedResultCollectsEveryViolatingConsent",
				CASARiskTests::detailedResultCollectsEveryViolatingConsent);
		TestSupportV3.run("thesis.CASARisk.returnsModelIfOkOnlyWhenNoRiskViolationExists",
				CASARiskTests::returnsModelIfOkOnlyWhenNoRiskViolationExists);
	}

	private static void identifiesRiskRelevantDataSubjectWhenVulnerabilityIsReachable() {
		CASATestFixtures.RiskFixture fixture = CASATestFixtures.riskFixture(1, true);
		CASATestFixtures.addRiskConsent(fixture, "PComments", 1_000_000.0);

		CASARisk risk = new CASARisk(10.0).setMode(CASARisk.EstimationMode.EXHAUSTIVE);
		CASARisk.RiskCheckResult result = risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.check(result.getRiskLevels().containsKey(fixture.ds()),
				"CASARisk should compute a risk level for a reachable data subject");
	}

	private static void computesZeroRiskWhenNoVulnerabilityIsReachable() {
		CASATestFixtures.RiskFixture fixture = CASATestFixtures.riskFixture(0, true);
		CASATestFixtures.addRiskConsent(fixture, "PComments", 1_000_000.0);

		CASARisk risk = new CASARisk(10.0).setMode(CASARisk.EstimationMode.EXHAUSTIVE);
		CASARisk.RiskCheckResult result = risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.check(result.getRiskLevels().containsKey(fixture.ds()),
				"CASARisk currently still produces a risk entry for the matched data subject");
		TestSupportV3.equals(0.0, result.getRiskLevels().get(fixture.ds()),
				"CASARisk should compute zero risk when no vulnerability is reachable");
	}

	private static void computesDeterministicExhaustiveRiskForSingleVulnerability() {
		CASATestFixtures.RiskFixture fixture = CASATestFixtures.riskFixture(1, true);
		CASATestFixtures.addRiskConsent(fixture, "PComments", 1_000_000.0);

		CASARisk risk = new CASARisk(10.0).setMode(CASARisk.EstimationMode.EXHAUSTIVE);
		CASARisk.RiskCheckResult result = risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		double actualRisk = result.getRiskLevels().get(fixture.ds());
		double expectedImpact = ((100.0 * 0.56) + (100.0 * 0.56) + (100.0 * 0.56)) / 3.0 * 1.0;
		double expectedProbability = 0.85 * 0.77 * 0.85 * 0.85 * 1.0 * 1.0;
		double expectedRisk = expectedImpact * expectedProbability;

		TestSupportV3.check(Math.abs(actualRisk - expectedRisk) < 1e-9,
				"CASARisk should compute the expected exhaustive risk for one vulnerability");
	}

	private static void autoModeUsesExhaustiveAtOrBelowCutoff() {
		StatsCollector.getInstance().clear();
		CASATestFixtures.RiskFixture fixture = CASATestFixtures.riskFixture(1, true);
		CASATestFixtures.addRiskConsent(fixture, "PComments", 1_000_000.0);

		CASARisk risk = new CASARisk(10.0)
				.setMode(CASARisk.EstimationMode.AUTO)
				.setExhaustiveMaxVulns(1);
		risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		List<String> modes = StatsCollector.getInstance().getStringStats("riskEstimationMode");
		TestSupportV3.equals("EXHAUSTIVE", modes.get(modes.size() - 1),
				"CASARisk AUTO mode should choose exhaustive at or below cutoff");
	}

	private static void autoModeUsesMonteCarloAboveCutoff() {
		StatsCollector.getInstance().clear();
		CASATestFixtures.RiskFixture fixture = CASATestFixtures.riskFixture(2, true);
		CASATestFixtures.addRiskConsent(fixture, "PComments", 1_000_000.0);

		CASARisk risk = new CASARisk(10.0)
				.setMode(CASARisk.EstimationMode.AUTO)
				.setExhaustiveMaxVulns(1)
				.setMcSamples(500)
				.setMcSeed(1234L);
		CASARisk.RiskCheckResult result = risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		List<String> modes = StatsCollector.getInstance().getStringStats("riskEstimationMode");
		TestSupportV3.equals("MONTE_CARLO", modes.get(modes.size() - 1),
				"CASARisk AUTO mode should choose Monte Carlo above cutoff");
		double riskValue = result.getRiskLevels().get(fixture.ds());
		TestSupportV3.check(Double.isFinite(riskValue), "CASARisk Monte Carlo estimate should be finite");
	}

	private static void disabledVulnerabilityContributesZeroRisk() {
		CASATestFixtures.RiskFixture fixture = CASATestFixtures.riskFixture(1, false);
		CASATestFixtures.addRiskConsent(fixture, "PComments", 1_000_000.0);

		CASARisk risk = new CASARisk(10.0).setMode(CASARisk.EstimationMode.EXHAUSTIVE);
		CASARisk.RiskCheckResult result = risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.equals(0.0, result.getRiskLevels().get(fixture.ds()),
				"CASARisk should treat disabled vulnerabilities as zero contribution");
	}

	private static void detailedResultChecksAllConsentsOfDataSubject() {
		CASATestFixtures.RiskFixture fixture = CASATestFixtures.riskFixture(1, true);
		CASATestFixtures.addRiskConsent(fixture, "PComments", 0.0);
		CASATestFixtures.addRiskConsent(fixture, "PSocial", 1_000_000.0);

		CASARisk risk = new CASARisk(10.0).setMode(CASARisk.EstimationMode.EXHAUSTIVE);
		CASARisk.RiskCheckResult result = risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.equals(1, result.getViolations().size(),
				"CASARisk should check all consents and keep only the violating ones");
		TestSupportV3.equals("PComments", result.getViolations().get(0).getConsent().getForPurpose(),
				"CASARisk should report the violating consent, not just the first or last consent");
	}

	private static void detailedResultCollectsEveryViolatingConsent() {
		CASATestFixtures.RiskFixture fixture = CASATestFixtures.riskFixture(1, true);
		CASATestFixtures.addRiskConsent(fixture, "PComments", 0.0);
		CASATestFixtures.addRiskConsent(fixture, "PSocial", 1.0);

		CASARisk risk = new CASARisk(10.0).setMode(CASARisk.EstimationMode.EXHAUSTIVE);
		CASARisk.RiskCheckResult result = risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(fixture.system()));

		TestSupportV3.equals(2, result.getViolations().size(),
				"CASARisk detailed result should collect every violating consent of the data subject");
	}

	private static void returnsModelIfOkOnlyWhenNoRiskViolationExists() {
		CASATestFixtures.RiskFixture okFixture = CASATestFixtures.riskFixture(1, true);
		CASATestFixtures.addRiskConsent(okFixture, "PComments", 1_000_000.0);

		CASARisk risk = new CASARisk(10.0).setMode(CASARisk.EstimationMode.EXHAUSTIVE);
		CASARisk.RiskCheckResult ok = risk.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(okFixture.system()));
		TestSupportV3.check(ok.getModelIfOk().isPresent(),
				"CASARisk should return modelIfOk when no risk consent violation exists");

		CASATestFixtures.RiskFixture violatingFixture = CASATestFixtures.riskFixture(1, true);
		CASATestFixtures.addRiskConsent(violatingFixture, "PComments", 0.0);
		CASARisk.RiskCheckResult violating = risk
				.applyCASARiskDetailed(CASATestFixtures.asAnalysisModel(violatingFixture.system()));
		TestSupportV3.check(violating.getModelIfOk().isEmpty(),
				"CASARisk should not return modelIfOk when a risk consent violation exists");
	}
}
