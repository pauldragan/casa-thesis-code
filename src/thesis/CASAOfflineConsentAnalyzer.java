package thesis;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CASA.CASAPackage;
import thesis.CASAPurpose.PurposeCheckResult;

public class CASAOfflineConsentAnalyzer {

	private static final Logger logger = LoggerFactory.getLogger(CASAOfflineConsentAnalyzer.class);

	private static final String BASEDIR = "src/thesis";
	private static final String ECOREPATH = "CASA.ecore";

	// Defaults for structural risk-injection grouping/size
	private static final int DEF_MAX_SET_SIZE = 4; // PDs per new risk function
	private static final int DEF_MAX_COMPONENTS = 3; // components per function
	private static final int DEF_MAX_VULNS = 3; // vulns per component

	private static final int DEF_EXTRA_PURPOSES_MIN = 0;
	private static final int DEF_EXTRA_PURPOSES_MAX = 0;

	public static class RiskEngineConfig {
		public final CASARisk.EstimationMode mode;
		public final int mcSamples;
		public final long mcSeed;
		public final int exhaustiveMaxVulns;
		public final double riskConsentThreshold;

		public RiskEngineConfig(
				CASARisk.EstimationMode mode,
				int mcSamples,
				long mcSeed,
				int exhaustiveMaxVulns,
				double riskConsentThreshold) {
			this.mode = mode;
			this.mcSamples = mcSamples;
			this.mcSeed = mcSeed;
			this.exhaustiveMaxVulns = exhaustiveMaxVulns;
			this.riskConsentThreshold = riskConsentThreshold;
		}
	}

	public static class Result {
		public boolean purposeOK;
		public boolean riskOK;
		public CASABase.CASA_REASON reason = CASABase.CASA_REASON.NOT_VIOLATED;

		public int detectedPurposeViolations = 0;
		public int detectedRiskViolations = 0;

		public int detectedPurposeUnrelated = 0; // consent.forPurpose == "Research"
		public int detectedPurposeSpecialized = 0; // consent.forPurpose == "Special"

		public ModelSize size;

		@Override
		public String toString() {
			return "Result{purposeOK=" + purposeOK + ", riskOK=" + riskOK + ", detectedPurposeViolations="
					+ detectedPurposeViolations + ", detectedRiskViolations=" + detectedRiskViolations + ", reason="
					+ reason + "}";
		}
	}

	/** Bundle for “transform + analyze” results. */
	public static class TransformOutcome {
		public final Resource transformed; // cloned & modified model
		public final CASAAdaptationGenerator.StructuralReport applied; // what was injected
		public final Result analysis; // analysis on transformed model

		public TransformOutcome(Resource transformed, CASAAdaptationGenerator.StructuralReport applied,
				Result analysis) {
			this.transformed = transformed;
			this.applied = applied;
			this.analysis = analysis;
		}
	}

	// --- size accounting ----------------------------------------------------
	public static class ModelSize {
		public int totalEObjects;
		public int dataSubjects;
		public int personalData;
		public int functions;
		public int components;
		public int vulnerabilities;
		public int purposes;
		public int consents;

		@Override
		public String toString() {
			return String.format("total=%d, DS=%d, PD=%d, F=%d, C=%d, Vuln=%d, Purposes=%d, Consents=%d", totalEObjects,
					dataSubjects, personalData, functions, components, vulnerabilities, purposes, consents);
		}

		public long totalRelations = 0L;
		public java.util.Map<String, Long> relationsByType = new java.util.HashMap<>();
	}
	
	public static final class RelationStats {
	    public final long total;
	    public final Map<String, Long> byType;
	    public RelationStats(long total, Map<String, Long> byType) {
	        this.total = total; this.byType = byType;
	    }
	}

	public static RelationStats computeRelations(EObject root) {
	    long total = 0L;
	    Map<String, Long> byType = new HashMap<>();

	    // helper counts refs on a single object and updates the map
	    final java.util.function.Function<EObject, Long> countOne = (obj) -> {
	        long incTotal = 0L;
	        for (var ref : obj.eClass().getEAllReferences()) {
	            if (ref.isContainment()) continue; // skip the structural tree

	            String key = obj.eClass().getName() + "." + ref.getName()
	                       + " -> " + ref.getEReferenceType().getName();

	            Object v = obj.eGet(ref);
	            long inc = 0L;
	            if (v instanceof Collection<?> col) {
	                for (Object it : col) if (it instanceof EObject) inc++;
	            } else if (v instanceof EObject) {
	                inc = 1L;
	            }

	            if (inc > 0) {
	                incTotal += inc;
	                byType.merge(key, inc, Long::sum);
	            }
	        }
	        return incTotal;
	    };

	    // count root + contents
	    total += countOne.apply(root);
	    for (var it = root.eAllContents(); it.hasNext(); ) {
	        total += countOne.apply(it.next());
	    }
	    return new RelationStats(total, byType);
	}


	public static ModelSize computeModelSize(EObject root) {
	    ModelSize s = new ModelSize();

	    // ---- object counts (root + contents)
	    s.totalEObjects = 1;
	    if (root instanceof CASA.DataSubject)     s.dataSubjects++;
	    if (root instanceof CASA.PersonalData)    s.personalData++;
	    if (root instanceof CASA.FuncPersData)    s.functions++;
	    if (root instanceof CASA.Component)       s.components++;
	    if (root instanceof CASA.Vulnerability)   s.vulnerabilities++;
	    if (root instanceof CASA.PurposeConsent)  s.purposes++;
	    if (root instanceof CASA.Consent)         s.consents++;

	    for (var it = root.eAllContents(); it.hasNext();) {
	        EObject e = it.next();
	        s.totalEObjects++;
	        if (e instanceof CASA.DataSubject)     s.dataSubjects++;
	        if (e instanceof CASA.PersonalData)    s.personalData++;
	        if (e instanceof CASA.FuncPersData)    s.functions++;
	        if (e instanceof CASA.Component)       s.components++;
	        if (e instanceof CASA.Vulnerability)   s.vulnerabilities++;
	        if (e instanceof CASA.PurposeConsent)  s.purposes++;
	        if (e instanceof CASA.Consent)         s.consents++;
	    }

	    // ---- relation counts
	    RelationStats rel = computeRelations(root);
	    s.totalRelations = rel.total;
	    s.relationsByType.clear();
	    s.relationsByType.putAll(rel.byType);

	    return s;
	}


	// --- runtime state ------------------------------------------------------
	private final HenshinResourceSet rs;
	private final Engine engine;
	private final CASAPurpose casaPurpose;
	private final CASARisk casaRisk;

	public CASAOfflineConsentAnalyzer() {
		this(new RiskEngineConfig(CASARisk.EstimationMode.AUTO, 20_000, 1234L, 15, 10.0));
	}

	public CASAOfflineConsentAnalyzer(RiskEngineConfig cfg) {
		this(cfg, null, CASAPurpose.PurposeNameMappingMode.LEGACY);
	}

	public CASAOfflineConsentAnalyzer(String purposeModelPath, CASAPurpose.PurposeNameMappingMode purposeNameMappingMode) {
		this(new RiskEngineConfig(CASARisk.EstimationMode.AUTO, 20_000, 1234L, 15, 10.0), purposeModelPath, purposeNameMappingMode);
	}

	public CASAOfflineConsentAnalyzer(
			RiskEngineConfig cfg,
			String purposeModelPath,
			CASAPurpose.PurposeNameMappingMode purposeNameMappingMode) {
		this.rs = new HenshinResourceSet(BASEDIR);
		rs.registerDynamicEPackages(ECOREPATH);
		rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);

		this.engine = new EngineImpl();
		this.engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);

		this.casaPurpose = purposeModelPath == null || purposeModelPath.isBlank()
				? new CASAPurpose()
				: new CASAPurpose(purposeModelPath, purposeNameMappingMode);
		this.casaRisk = new CASARisk(cfg.riskConsentThreshold).setMode(cfg.mode).setMcSeed(cfg.mcSeed).setMcSamples(cfg.mcSamples)
				.setExhaustiveMaxVulns(cfg.exhaustiveMaxVulns);
	}

	// --- helpers ------------------------------------------------------------

	/**
	 * Deep copy the resource to a new ResourceSet (keeps CASA package registered).
	 */
	private static Resource deepCopyResource(Resource src) {
		if (src == null || src.getContents().isEmpty())
			throw new IllegalArgumentException("Source resource is empty.");

		var newRs = new ResourceSetImpl();
		newRs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
		newRs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());

		var copyRoot = EcoreUtil.copy(src.getContents().get(0));
		var uri = URI.createURI("inmem:/transformed-" + UUID.randomUUID() + ".xmi");
		var out = newRs.createResource(uri);
		out.getContents().add(copyRoot);
		return out;
	}

	// --- transform + analyze ------------------------------------------------

	/**
	 * Uses defaults for grouping/size (DEF_MAX_SET_SIZE, DEF_MAX_COMPONENTS,
	 * DEF_MAX_VULNS).
	 */
	public TransformOutcome analyzeWithTransform(Resource cleanRes, int nUnrelated, int nSpecial, int nRisk,
			long seed) {
		return analyzeWithTransform(cleanRes, nUnrelated, nSpecial, nRisk, DEF_MAX_SET_SIZE, DEF_MAX_COMPONENTS,
				DEF_MAX_VULNS, seed);

	}

	public TransformOutcome analyzeWithTransform(Resource cleanRes, int nUnrelated, int nSpecial, int nRisk,
			int maxSetSize, int maxComponents, int maxVulns, long seed) {
		return analyzeWithTransform(cleanRes, nUnrelated, nSpecial, nRisk, maxSetSize, maxComponents, maxVulns,
				DEF_EXTRA_PURPOSES_MIN, DEF_EXTRA_PURPOSES_MAX, seed);
	}

	/** Full-control variant used by experiments. */
	public TransformOutcome analyzeWithTransform(Resource cleanRes, int nUnrelated, int nSpecial, int nRisk,
			int maxSetSize, int maxComponents, int maxVulns, int extraPurposesMin, int extraPurposesMax, long seed) {
// 1) clone
		Resource transformed = deepCopyResource(cleanRes);

// 2) inject violations + extra purposes via structural Henshin rules
		var adap = new CASAAdaptationGenerator();
		var applied = adap.applyStructuralViolationsWithHenshin(transformed, nUnrelated, nSpecial, nRisk, maxSetSize,
				maxComponents, maxVulns, extraPurposesMin, extraPurposesMax, seed);

// 3) analyze the transformed resource
		var analysis = analyzeResource(transformed);
		analysis.size = computeModelSize(transformed.getContents().get(0)); // reflect new structure

		return new TransformOutcome(transformed, applied, analysis);
	}

	// --- plain analysis APIs ------------------------------------------------

	/** Old: analyze from file path (kept for convenience). */
	public Result analyzeFile(String modelPath) {
		EObject modelRoot = HenshinUtils.loadModel(modelPath, this.rs);
		return analyzeRoot(modelRoot);
	}

	/**
	 * Runs both purpose and risk analyses once on a copy of the given model root.
	 */
	public void runPurposeAndRisk(EObject modelRoot) {
		EGraph graph = new EGraphImpl(EcoreUtil.copy(modelRoot));
		CASASelfAdaptationAnalysisModel analysisModel = new CASASelfAdaptationAnalysisModel(graph);
		CASAPurpose.PurposeCheckResult purposeResult = casaPurpose.applyCASAPurposeDetailed(analysisModel);
		casaRisk.applyCASARiskDetailed(purposeResult.getCorrectedModel().orElse(analysisModel));
	}

	public PurposeCheckResult runPurposeOnly(EObject modelRoot) {
		EGraph graph = new EGraphImpl(EcoreUtil.copy(modelRoot));
		CASASelfAdaptationAnalysisModel analysisModel = new CASASelfAdaptationAnalysisModel(graph);
		return casaPurpose.applyCASAPurposeDetailed(analysisModel);
	}

	public void runRiskOnly(EObject modelRoot, CASAPurpose.PurposeCheckResult purposeCheckResult) {
		runRiskOnlyDetailed(modelRoot, purposeCheckResult);
	}

	public CASARisk.RiskCheckResult runRiskOnlyDetailed(EObject modelRoot,
			CASAPurpose.PurposeCheckResult purposeCheckResult) {
		if (purposeCheckResult != null && purposeCheckResult.getCorrectedModel().isPresent()) {
			return casaRisk.applyCASARiskDetailed(purposeCheckResult.getCorrectedModel().get());
		} else {
			EGraph graph = new EGraphImpl(EcoreUtil.copy(modelRoot));
			CASASelfAdaptationAnalysisModel analysisModel = new CASASelfAdaptationAnalysisModel(graph);
			return casaRisk.applyCASARiskDetailed(analysisModel);
		}
	}

	public Resource runTransformOnly(Resource cleanRes, int nUnrelated, int nSpecial, int nRisk, int maxSetSize,
			int maxComponents, int maxVulns, int extraPurposesMin, int extraPurposesMax, long seed) {
// 1) clone
		Resource transformed = deepCopyResource(cleanRes);

// 2) inject violations + extra purposes via structural Henshin rules
		var adap = new CASAAdaptationGenerator();
		var applied = adap.applyStructuralViolationsWithHenshin(transformed, nUnrelated, nSpecial, nRisk, maxSetSize,
				maxComponents, maxVulns, extraPurposesMin, extraPurposesMax, seed);

		return transformed;
	}

	/** Analyze directly from an in-memory EMF Resource. */
	public Result analyzeResource(Resource res) {
		if (res == null || res.getContents().isEmpty())
			throw new IllegalArgumentException("Resource has no contents.");
		return analyzeRoot(res.getContents().get(0));
	}

	/** Analyze directly from an in-memory root EObject. */
	public Result analyzeRoot(EObject modelRoot) {
		// copy so CASA rules can safely modify the graph if needed
		EGraph graph = new EGraphImpl(EcoreUtil.copy(modelRoot));
		CASASelfAdaptationAnalysisModel analysisModel = new CASASelfAdaptationAnalysisModel(graph);

		Result r = new Result();
		r.size = computeModelSize(modelRoot);

		// 1) Purpose
		CASAPurpose.PurposeCheckResult purposeResult = casaPurpose.applyCASAPurposeDetailed(analysisModel);
		r.purposeOK = !purposeResult.isViolated();

		if (purposeResult.isViolated()) {
			r.reason = CASABase.CASA_REASON.PURPOSE_VIOLATED;
			r.riskOK = false;

			// Deduplicate by Consent 
			java.util.Set<CASA.Consent> violatingConsents = new java.util.HashSet<>();
			for (var v : purposeResult.getAnalysis().getViolations()) {
				CASA.Consent matchedConsent = v.getDs().getGives().stream()
						.filter(c -> c.getForPersonalData().contains(v.getD())).findFirst().orElse(null);
				if (matchedConsent != null)
					violatingConsents.add(matchedConsent);
			}

			int unrel = 0, spec = 0;
			for (CASA.Consent c : violatingConsents) {
				String fp = c.getForPurpose();
				if ("Research".equals(fp) && "ViolationUnrelated".equals(fp))
					unrel++;
				else if ("Special".equals(fp) && "ViolationGeneralization".equals(fp))
					spec++;
			}

			for (var v : purposeResult.getAnalysis().getViolations()) {
				if ("ViolationUnrelated".equals(v.getP().getName())) {
					unrel++;
				} else if ("ViolationGeneralization".equals(v.getP().getName())) {
					spec++;
				}
			}

			r.detectedPurposeUnrelated = unrel;
			r.detectedPurposeSpecialized = spec;
			r.detectedPurposeViolations = violatingConsents.size();
			return r; // stop here
		} else {
			r.detectedPurposeViolations = 0;
			r.detectedPurposeUnrelated = 0;
			r.detectedPurposeSpecialized = 0;
		}

		// 2) Risk
		CASARisk.RiskCheckResult riskResult = casaRisk
				.applyCASARiskDetailed(purposeResult.getCorrectedModel().orElse(analysisModel));

		r.riskOK = !riskResult.isViolated();
		r.reason = r.riskOK ? CASABase.CASA_REASON.NOT_VIOLATED : CASABase.CASA_REASON.RISK_VIOLATED;
		r.detectedRiskViolations = riskResult.getViolations().size();

		return r;
	}
}
