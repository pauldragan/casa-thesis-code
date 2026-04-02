package thesis;

import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;

import CASA.CASAFactory;
import CASA.CASAPackage;
import CASA.CVSSVector;
import CASA.CommentWriteRead;
import CASA.Component;
import CASA.Consent;
import CASA.FuncPersData;
import CASA.PComments;
import CASA.PMarketing;
import CASA.PSocial;
import CASA.User;
import CASA.Vulnerability;
import CASA.VideoComment;
import CASA.CVSS.AttackComplexity;
import CASA.CVSS.AttackVector;
import CASA.CVSS.AvailabilityImpact;
import CASA.CVSS.AvailabilityRequirement;
import CASA.CVSS.ConfidentialityImpact;
import CASA.CVSS.ConfidentialityRequirement;
import CASA.CVSS.ExploitCodeMaturity;
import CASA.CVSS.IntegrityImpact;
import CASA.CVSS.IntegrityRequirement;
import CASA.CVSS.PrivilegesRequired;
import CASA.CVSS.RemediationLevel;
import CASA.CVSS.ReportConfidence;
import CASA.CVSS.Scope;
import CASA.CVSS.UserInteraction;

final class CASATestFixtures {

	private CASATestFixtures() {
	}

	static PurposeFixture purposeFixture() {
		CASAPackage.eINSTANCE.eClass();
		CASAFactory factory = CASAFactory.eINSTANCE;

		CASA.System system = factory.createSystem();

		User ds = factory.createUser();
		ds.setName("user_1");
		system.getDataSubjects().add(ds);

		VideoComment pd = factory.createVideoComment();
		pd.setName("comment_1");
		pd.setIdentifies(ds);
		system.getDatas().add(pd);

		CommentWriteRead function = factory.createCommentWriteRead();
		function.setName("comment_fn_1");
		function.getProcessesPersData().add(pd);
		system.getFunctions().add(function);

		PComments commentsPurpose = factory.createPComments();
		commentsPurpose.setName("PComments");
		function.getHas().add(commentsPurpose);
		system.getPurposes().add(commentsPurpose);

		PSocial socialPurpose = factory.createPSocial();
		socialPurpose.setName("PSocial");
		system.getPurposes().add(socialPurpose);

		PMarketing marketingPurpose = factory.createPMarketing();
		marketingPurpose.setName("PMarketing");
		system.getPurposes().add(marketingPurpose);

		return new PurposeFixture(system, ds, pd, function, commentsPurpose, socialPurpose, marketingPurpose);
	}

	static Consent addConsent(PurposeFixture fixture, String consentId, String forPurpose) {
		CASAFactory factory = CASAFactory.eINSTANCE;
		Consent consent = factory.createConsent();
		consent.setForPurpose(forPurpose);
		consent.setInformedRiskLevel(100.0);
		fixture.ds().getGives().add(consent);
		consent.getForPersonalData().add(fixture.pd());
		return consent;
	}

	static CASASelfAdaptationAnalysisModel asAnalysisModel(CASA.System system) {
		return new CASASelfAdaptationAnalysisModel(new EGraphImpl(system));
	}

	static CASA.System correctedRoot(CASAPurpose.PurposeCheckResult result) {
		return (CASA.System) result.getCorrectedModel().orElseThrow().getGraph().getRoots().get(0);
	}

	static Consent findConsentByForPurpose(CASA.System system, String forPurpose) {
		for (CASA.DataSubject ds : system.getDataSubjects()) {
			for (Consent consent : ds.getGives()) {
				if (forPurpose.equals(consent.getForPurpose())) {
					return consent;
				}
			}
		}
		throw new IllegalStateException("Consent not found for forPurpose=" + forPurpose);
	}

	static CASA.Purpose findPurposeByName(CASA.System system, String name) {
		for (CASA.Purpose purpose : system.getPurposes()) {
			if (name.equals(purpose.getName())) {
				return purpose;
			}
		}
		throw new IllegalStateException("Purpose not found: " + name);
	}

	record PurposeFixture(
			CASA.System system,
			User ds,
			VideoComment pd,
			CommentWriteRead function,
			PComments commentsPurpose,
			PSocial socialPurpose,
			PMarketing marketingPurpose) {
	}

	static RiskFixture riskFixture(int vulnerabilityCount, boolean enabled) {
		CASAPackage.eINSTANCE.eClass();
		CASAFactory factory = CASAFactory.eINSTANCE;

		CASA.System system = factory.createSystem();

		User ds = factory.createUser();
		ds.setName("user_1");
		system.getDataSubjects().add(ds);

		VideoComment pd = factory.createVideoComment();
		pd.setName("comment_1");
		pd.setIdentifies(ds);
		system.getDatas().add(pd);

		CommentWriteRead function = factory.createCommentWriteRead();
		function.setName("comment_fn_1");
		function.getProcessesPersData().add(pd);
		system.getFunctions().add(function);

		Component component = factory.createComponent();
		component.setName("component_1");
		component.getRealizes().add(function);
		system.getComponents().add(component);

		for (int i = 0; i < vulnerabilityCount; i++) {
			Vulnerability vulnerability = factory.createVulnerability();
			vulnerability.setCveName("CVE-TEST-" + i);
			vulnerability.setIsEnabled(enabled);
			vulnerability.setDescribedBy(defaultCvssVector(factory));
			vulnerability.getAffects().add(component);
			system.getVulnerabilities().add(vulnerability);
		}

		return new RiskFixture(system, ds, pd, function, component);
	}

	static Consent addRiskConsent(RiskFixture fixture, String forPurpose, double informedRiskLevel) {
		CASAFactory factory = CASAFactory.eINSTANCE;
		Consent consent = factory.createConsent();
		consent.setForPurpose(forPurpose);
		consent.setInformedRiskLevel(informedRiskLevel);
		fixture.ds().getGives().add(consent);
		consent.getForPersonalData().add(fixture.pd());
		return consent;
	}

	private static CVSSVector defaultCvssVector(CASAFactory factory) {
		CVSSVector vector = factory.createCVSSVector();
		vector.setAttackVector(AttackVector.NETWORK);
		vector.setAttackComplexity(AttackComplexity.LOW);
		vector.setScope(Scope.UNCHANGED);
		vector.setPrivilegesRequired(PrivilegesRequired.NONE);
		vector.setUserInteraction(UserInteraction.NONE);
		vector.setExploitCodeMaturity(ExploitCodeMaturity.HIGH);
		vector.setReportConfidence(ReportConfidence.CONFIRMED);
		vector.setConfidentialityImpact(ConfidentialityImpact.HIGH);
		vector.setIntegrityImpact(IntegrityImpact.HIGH);
		vector.setAvailabilityImpact(AvailabilityImpact.HIGH);
		vector.setRemediationLevel(RemediationLevel.UNAVAILABLE);
		vector.setConfidentialityRequirement(ConfidentialityRequirement.HIGH);
		vector.setIntegrityRequirement(IntegrityRequirement.HIGH);
		vector.setAvailabilityRequirement(AvailabilityRequirement.HIGH);
		return vector;
	}

	record RiskFixture(
			CASA.System system,
			User ds,
			VideoComment pd,
			FuncPersData function,
			Component component) {
	}
}
