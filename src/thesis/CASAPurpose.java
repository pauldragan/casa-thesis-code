package thesis;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import CASA.CASAPackage;
import CASA.Consent;
import CASA.DataSubject;
import CASA.FuncPersData;
import CASA.PersonalData;
import CASA.PurposeConsent;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CASAPurpose {
	
	private static final StatsCollector collector = StatsCollector.getInstance();

	private static final String BASEDIR = "src/thesis";
	private static final String ECOREPATH = "CASA.ecore";
	private static final String PURPOSEMODELPATH = "src/resources/casa-swim-purpose-model.owx";

	public enum PurposeNameMappingMode {
		LEGACY,
		V3
	}

	private CASAPurposeModel purposeModel;
	private CASAPurposeConsentRules purposeConsentRules;
	private final PurposeNameMappingMode purposeNameMappingMode;
	private final LawfulBasisSelectionPolicy lawfulBasisSelectionPolicy;

	private static final String PURPOSEMODELRULESPATH = "CASAPurposeRules.henshin";
	private final Map<String, Rule> purposeRules;

	private Engine engine;
	private HenshinResourceSet rs;
	
	@Getter @Setter @AllArgsConstructor
	public static class PurposeCheckResult {
	    /** True iff violations were found. */
	    private boolean violated;
	    /** Full analysis details (violations + ok consents). */
	    private AnalysisResult analysis;
	    /** Present only when there are NO violations (i.e., corrected model exists). */
	    private Optional<CASASelfAdaptationAnalysisModel> correctedModel;
	}

	@Getter
	@Setter
	class AnalysisResult {
		@Getter
		@Setter
		class ViolatatedConsent {
			private CASA.FuncPersData f;
			private CASA.DataSubject ds;
			private CASA.PersonalData d;
			private CASA.PurposeConsent p;

			public ViolatatedConsent(FuncPersData f, DataSubject ds, PersonalData d, PurposeConsent p) {
				this.f = f;
				this.ds = ds;
				this.d = d;
				this.p = p;
			}
		}

		@Getter
		@Setter
		class AppropriateConsent {
			private CASA.FuncPersData f;
			private CASA.DataSubject ds;
			private CASA.PersonalData d;
			private CASA.PurposeConsent p;
			private CASA.Consent c;

			public AppropriateConsent(FuncPersData f, DataSubject ds, PersonalData d, PurposeConsent p, Consent c) {
				this.f = f;
				this.ds = ds;
				this.d = d;
				this.p = p;
				this.c = c;
			}
		}

		private List<ViolatatedConsent> violations;
		private List<AppropriateConsent> okConsent;

		public AnalysisResult(List<ViolatatedConsent> violations, List<AppropriateConsent> okConsent) {
			this.violations = new ArrayList<>(violations);
			this.okConsent = new ArrayList<>(okConsent);
		}

		public AnalysisResult() {
			this.violations = new ArrayList<>();
			this.okConsent = new ArrayList<>();
		}

		public void addViolation(CASA.FuncPersData f, CASA.DataSubject ds, CASA.PersonalData d, CASA.PurposeConsent p) {
			violations.add(new ViolatatedConsent(f, ds, d, p));
		}

		public void addOkConsent(CASA.FuncPersData f, CASA.DataSubject ds, CASA.PersonalData d, CASA.PurposeConsent p, CASA.Consent c) {
			okConsent.add(new AppropriateConsent(f, ds, d, p, c));
		}
	}

	public CASAPurpose() {
		this.rs = new HenshinResourceSet(BASEDIR);
		rs.registerDynamicEPackages(ECOREPATH);
		rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);

		this.purposeModel = new CASAPurposeModel(PURPOSEMODELPATH);
		this.purposeConsentRules = new CASAPurposeConsentRules();
		this.purposeRules = HenshinUtils.loadRules(PURPOSEMODELRULESPATH, this.rs);
		this.engine = new EngineImpl();
		this.engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);
		this.purposeNameMappingMode = PurposeNameMappingMode.LEGACY;
		this.lawfulBasisSelectionPolicy = new FirstNonViolating();
	}
	
	public CASAPurpose(String purposeModelPath) {
		this(purposeModelPath, PurposeNameMappingMode.LEGACY);
	}

	public CASAPurpose(String purposeModelPath, PurposeNameMappingMode purposeNameMappingMode) {
		this.rs = new HenshinResourceSet(BASEDIR);
		rs.registerDynamicEPackages(ECOREPATH);
		rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);

		this.purposeModel = new CASAPurposeModel(purposeModelPath);
		this.purposeConsentRules = new CASAPurposeConsentRules();
		this.purposeRules = HenshinUtils.loadRules(PURPOSEMODELRULESPATH, this.rs);
		this.engine = new EngineImpl();
		this.engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);
		this.purposeNameMappingMode = purposeNameMappingMode;
		this.lawfulBasisSelectionPolicy = new FirstNonViolating();
	}

	public void test() {
		// CASA.System modelRoot = HenshinUtils.loadModel("CASA_transformed_transformed.xmi", rs);
		CASA.System modelRoot = HenshinUtils.loadModel("CASA_transformed_transformed_transformed_transformed.xmi", rs);
		EGraph graph = new EGraphImpl(modelRoot);
		AnalysisResult result = this.analyzeModel(graph);
		EGraph correctedGraph = this.correctModel(graph, result);
		if (correctedGraph != null) {
			System.out.println("Managed to correct graph... saving...");
			CASASelfAdaptationAnalysisModel correctedModel = new CASASelfAdaptationAnalysisModel(correctedGraph);
			System.out.println(correctedGraph);
			System.out.println(correctedGraph.getRoots().get(0));
			// HenshinUtils.saveModel("test_output.xmi", BASEDIR, correctedGraph.getRoots().get(0));
			HenshinUtils.saveModel("test_output.xmi", BASEDIR, correctedGraph.getRoots().get(0));
		}
	}

	public Optional<CASASelfAdaptationAnalysisModel> applyCASAPurpose(CASASelfAdaptationAnalysisModel model) {
	    PurposeCheckResult r = applyCASAPurposeDetailed(model);
	    return r.getCorrectedModel(); // present only if NOT violated
	}

	public PurposeCheckResult applyCASAPurposeDetailed(CASASelfAdaptationAnalysisModel model) {
	    EGraph graph = model.getGraph();

	    // 1) Analyze
	    AnalysisResult analysis = this.analyzeModel(graph);

	    // 2) Decide and (optionally) produce corrected model
	    boolean violated = !analysis.getViolations().isEmpty();
	    Optional<CASASelfAdaptationAnalysisModel> corrected = Optional.empty();

	    if (!violated) {
	        // Only correct when there are no violations (correctModel() contract)
	        EGraph correctedGraph = this.correctModel(graph, analysis);
	        if (correctedGraph != null) {
	            corrected = Optional.of(new CASASelfAdaptationAnalysisModel(correctedGraph));
	        }
	    }

	    // 3) Stats
	    collector.record("purposeConsentViolated", violated);

	    return new PurposeCheckResult(violated, analysis, corrected);
	}
	
	private AnalysisResult analyzeModel(EGraph graph) {
		List<Match> matches = HenshinUtils.applyMatchRule(graph, this.purposeRules.get("IdentifyProcessingPurposes"),
				engine);
		AnalysisResult result = new AnalysisResult();
		for (Match m : matches) {
			for (CASA.DataSubject ds : m.getNodeTargets().stream().filter(e -> e instanceof CASA.DataSubject)
					.map(e -> (CASA.DataSubject) e).toList()) {
				System.out.println("Matched node: " + ds);

				for (CASA.PersonalData data : ds.getIdentifiedBy()) {
					for (CASA.FuncPersData func : data.getProcessedBy()) {
						Set<CASA.PurposeConsent> purposes = new HashSet<>();
						purposes.addAll(func.getHas().stream().filter(e -> e instanceof CASA.PurposeConsent)
								.map(e -> (CASA.PurposeConsent) e).toList());

						Collection<CASA.Consent> consents = new HashSet<>(data.getSubjectOfConsent());

						for (CASA.PurposeConsent p : purposes) {
							System.out.println(p);

							String pA = convertHenshinPurposeToPurposeModelName(p, purposeNameMappingMode);
							System.out.println(pA);

							Optional<CASA.Consent> appropriateConsent = lawfulBasisSelectionPolicy.selectLawfulBasis(
									pA, consents, purposeModel, purposeConsentRules, purposeNameMappingMode);

							if (appropriateConsent.isEmpty()) {
								result.addViolation(func, ds, data, p);
							} else {
								result.addOkConsent(func, ds, data, p, appropriateConsent.get());
							}
						}
					}
				}
			}
		}
		return result;
	}
	
	private EGraph correctModel(EGraph model, AnalysisResult results) {
		if (!results.getViolations().isEmpty()) {
			return null; // model contains consent violations
		}
		
		// Delete existing associations between purpose and consent
		Rule deleteRule = purposeRules.get("DeleteExistingPurposeConsentSimple");
		while (HenshinUtils.applyModelChangeRule(model, deleteRule, engine)) { 
			System.out.println("Deleted existing purpose consent...");
		}
		
		// Correct model by making the connections between consent and purposes
		Rule correctRule = purposeRules.get("CorrectPurposeConsent");
		for (var result : results.getOkConsent()) {
			List<Pair<String,String>> params = new ArrayList<>();
			params.add(new ImmutablePair<String, String>("cName", result.getC().getForPurpose()));	
			params.add(new ImmutablePair<String, String>("dsName", result.getDs().getName()));
			params.add(new ImmutablePair<String, String>("dName", result.getD().getName()));
			params.add(new ImmutablePair<String, String>("pName", result.getP().getName()));
			params.add(new ImmutablePair<String, String>("fName", result.getF().getName()));
			
			HenshinUtils.applyModelChangeRule(model, correctRule, engine, params);
		}
		
		return model;
	}

	static String convertHenshinPurposeToPurposeModelName(CASA.Purpose purpose, PurposeNameMappingMode mode) {
		return convertHenshinPurposeToPurposeModelName(purpose.getName(), mode);
	}

	static String convertHenshinPurposeToPurposeModelName(String purpose, PurposeNameMappingMode mode) {
		return switch (mode) {
		case LEGACY -> purpose.replace("Serve", "").replace("Purpose", "");
		case V3 -> switch (purpose) {
			case "PMarketing" -> "Marketing";
			case "PStandardAds" -> "StandardAds";
			case "PTargetedAds" -> "TargetedAds";
			case "PLocationTargetedAds" -> "LocationTargetedAds";
			case "PBehaviorTargetedAds" -> "BehaviorTargetedAds";
			case "PProfiling" -> "Profiling";
			case "PFirstPartyProfiling" -> "FirstPartyProfiling";
			case "PThirdPartyProfiling" -> "ThirdPartyProfiling";
			case "PUserExperience" -> "UserExperience";
			case "PVideoRecommendation" -> "VideoRecommendation";
			case "PP2PStreaming" -> "P2PStreaming";
			case "PSocial" -> "Social";
			case "PComments" -> "Comments";
			case "PVideoSharing" -> "VideoSharing";
			default -> purpose.replace("Serve", "").replace("Purpose", "");
		};
		};
	}

}
