package thesis;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.Set;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import com.google.common.collect.Sets;

import CASA.CASAPackage;
import CASA.CVSSVector;
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
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

public class CASARisk {
	
    public enum EstimationMode { AUTO, EXHAUSTIVE, MONTE_CARLO }
    private static final int EXHAUSTIVE_MAX_VULNS = 18; // tune as needed
    private EstimationMode estimationMode = EstimationMode.AUTO;
    
    private int mcSamples = 10_000;
    private long mcSeed = 42L;
	
	private static final StatsCollector collector = StatsCollector.getInstance();
	
	private static final String BASEDIR = "src/thesis";
	private static final String ECOREPATH = "CASA.ecore";
	
	private static final String RISKRULESPATH = "CASARiskRules.henshin";
	private final Map<String, Rule> riskRules;
	
	private CASARiskConsentRules casaRiskConsentRules;
	
	private static final double I_MAX = 100.0; // I_R^max from the thesis

	private Engine engine;
	private HenshinResourceSet rs;
	
	enum VulnerabilityExploitation {
		NOT_EXPLOITED,
		EXPLOITED
	}
	
	@Getter @Setter @AllArgsConstructor @NoArgsConstructor
	public static class RiskViolation {
	    private CASA.DataSubject dataSubject;
	    private CASA.Consent consent;          // the consent that failed
	    private double dataSubjectRiskLevel;   // computed risk for DS
	    private double informedRiskLevel;      // consent’s informedRiskLevel
	}

	@Getter @Setter @AllArgsConstructor @NoArgsConstructor
	public static class RiskCheckResult {
	    /** True iff at least one consent violates the risk rule. */
	    private boolean violated;
	    /** All (DS -- riskLevel) computed by analyzeRisk(...). */
	    private Map<CASA.DataSubject, Double> riskLevels = new HashMap<>();
	    /** Which consents violated (could be multiple DS/consents). */
	    private List<RiskViolation> violations = new ArrayList<>();
	    /** Present only if NOT violated (i.e., model passes risk). */
	    private Optional<CASASelfAdaptationAnalysisModel> modelIfOk = Optional.empty();
	}
	
	public CASARisk() {
		this(10.0);
	}

	public CASARisk(double riskConsentThreshold) {
		this.rs = new HenshinResourceSet(BASEDIR);
		this.rs.registerDynamicEPackages(ECOREPATH);
		this.rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
		
		this.riskRules = HenshinUtils.loadRules(RISKRULESPATH, this.rs);
		this.engine = new EngineImpl();
		this.engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);
		
		this.casaRiskConsentRules = new CASARiskConsentRules(riskConsentThreshold);
	}
	
    public CASARisk setMode(EstimationMode mode) { this.estimationMode = mode; return this; }
    public CASARisk setMcSamples(int samples)  { this.mcSamples = samples; return this; }
    public CASARisk setMcSeed(long seed)       { this.mcSeed = seed; return this; }
    
    private int exhaustiveMaxVulns = EXHAUSTIVE_MAX_VULNS;
    public CASARisk setExhaustiveMaxVulns(int n) { this.exhaustiveMaxVulns = n; return this; }

	
//	public Optional<CASASelfAdaptationAnalysisModel> applyCASARisk(CASASelfAdaptationAnalysisModel model) {
//		EGraph graph = model.getGraph();
//		Map<CASA.DataSubject, Double> analysisResults = analyzeRisk(graph);
//		Optional<EGraph> result = evaluateRisk(graph, analysisResults);
//		
//		if (!result.isEmpty()) {
//			return Optional.of(new CASASelfAdaptationAnalysisModel(result.get()));
//		} else {
//			return Optional.empty();
//		}
//	}
    
    private static final class MCStat {
        final double mean, stderr;
        MCStat(double mean, double stderr) { this.mean = mean; this.stderr = stderr; }
    }

    /** Estimate E[min(I_MAX, sum_i a_i X_i)] with X_i ~ Bernoulli(p_i), indep. */
    private MCStat estimateRiskLevelMonteCarlo(
            List<CASA.Vulnerability> vulnerabilities,
            int numSamples,
            double Imax,
            Random rnd
    ) {
        final int n = vulnerabilities.size();
        if (n == 0) return new MCStat(0.0, 0.0);

        double[] impact = new double[n];
        double[] prob   = new double[n];
        for (int i = 0; i < n; i++) {
            CASA.Vulnerability v = vulnerabilities.get(i);
            impact[i] = calculateVulnerabilityImpact(v);
            prob[i]   = calculateVulnerabilityProbability(v);
        }

        double sum = 0.0, sumSq = 0.0;
        for (int t = 0; t < numSamples; t++) {
            double outcomeImpact = 0.0;
            for (int i = 0; i < n; i++) {
                if (rnd.nextDouble() < prob[i]) {
                    outcomeImpact += impact[i];
//                    if (outcomeImpact >= Imax) { outcomeImpact = Imax; break; }
                }
            }
            if (outcomeImpact >= Imax) outcomeImpact = Imax; 
            sum   += outcomeImpact;
            sumSq += outcomeImpact * outcomeImpact;
        }
        double mean   = sum / numSamples;
        double varPop = Math.max(0.0, (sumSq / numSamples) - mean * mean);
        double varUnb = (numSamples > 1) ? varPop * ((double) numSamples / (numSamples - 1)) : 0.0;
        double stderr = Math.sqrt(varUnb / numSamples);
        return new MCStat(mean, stderr);
    }
    
    private double computeRiskExhaustive(List<CASA.Vulnerability> vulns) {
        if (vulns.isEmpty()) return 0.0;

        // Build 2-element sets and cartesian product (as you did)
        List<Set<VulnerabilityExploitation>> sets = new ArrayList<>();
        for (int i = 0; i < vulns.size(); i++) {
            sets.add(Set.of(VulnerabilityExploitation.NOT_EXPLOITED, VulnerabilityExploitation.EXPLOITED));
        }
        Set<List<VulnerabilityExploitation>> outcomes = Sets.cartesianProduct(sets);

        double riskLevel = 0.0;
        for (List<VulnerabilityExploitation> outcome : outcomes) {
            double outcomeImpact = calculateOutcomeImpact(outcome, vulns);      // capped at I_MAX
            double outcomeProb   = calculateOutcomeProbability(outcome, vulns);
            riskLevel += outcomeImpact * outcomeProb;
        }
        return riskLevel;
    }

	
	public Optional<CASASelfAdaptationAnalysisModel> applyCASARisk(CASASelfAdaptationAnalysisModel model) {
	    RiskCheckResult r = applyCASARiskDetailed(model);
	    return r.isViolated() ? Optional.empty() : r.getModelIfOk();
	}
	
	public RiskCheckResult applyCASARiskDetailed(CASASelfAdaptationAnalysisModel model) {
	    EGraph graph = model.getGraph();

	    // 1) compute DS → risk level
	    Map<CASA.DataSubject, Double> analysisResults = analyzeRisk(graph);

	    // 2) evaluate consents against risk; collect which ones violate
	    RiskCheckResult result = evaluateRiskDetailed(graph, analysisResults);

	    // 3) keep simple API behavior: modelIfOk present only when no violation
	    if (!result.isViolated()) {
	        result.setModelIfOk(Optional.of(model));
	    }

	    return result;
	}

	
	public void test() {
		CASA.System modelRoot = HenshinUtils.loadModel("CASA_transformed.xmi", rs);
		EGraph graph = new EGraphImpl(modelRoot);
		Map<CASA.DataSubject, Double> analysisResults = analyzeRisk(graph);
		Optional<EGraph> result = evaluateRisk(graph, analysisResults);
		
	}
	
	private Set<CASA.DataSubject> identifyRisk(EGraph graph) {
		List<Match> matches = HenshinUtils.applyMatchRule(graph, this.riskRules.get("IdentifyProcessingRisks"),
				engine);
		
		Set<CASA.DataSubject> dataSubjects = new HashSet<>();
		for(Match m : matches) {
			List<CASA.DataSubject> ds =  m.getNodeTargets().stream().filter(e -> e instanceof CASA.DataSubject).map(e -> (CASA.DataSubject) e).toList();
			dataSubjects.addAll(ds);
		}
		
		return dataSubjects;
	}
	
	private RiskCheckResult evaluateRiskDetailed(EGraph graph, Map<CASA.DataSubject, Double> riskLevels) {
	    RiskCheckResult out = new RiskCheckResult();
	    out.setRiskLevels(riskLevels);

	    boolean anyViolated = false;

	    for (Map.Entry<CASA.DataSubject, Double> e : riskLevels.entrySet()) {
	        CASA.DataSubject ds = e.getKey();
	        double riskLevel = e.getValue();

	        double minInformedRiskLevel = Double.POSITIVE_INFINITY; // for stats

	        boolean dsViolated = false;
	        for (CASA.Consent c : ds.getGives()) {
	            // Rule evaluation (existing policy)
	            CASARiskConsentRules.RiskConsentViolation v =
	                casaRiskConsentRules.applyRule(riskLevel, c.getInformedRiskLevel());

	            // track min informed risk seen (for stats)
	            if (c.getInformedRiskLevel() < minInformedRiskLevel) {
	                minInformedRiskLevel = c.getInformedRiskLevel();
	            }

	            if (v == CASARiskConsentRules.RiskConsentViolation.VIOLATED) {
	                dsViolated = true;
	                anyViolated = true;

	                // record the exact consent that failed
	                out.getViolations().add(
	                    new RiskViolation(ds, c, riskLevel, c.getInformedRiskLevel())
	                );
	                // collect all violating consents for this DS
	            }
	        }

	        // existing telemetry
	        collector.record("acceptableRiskLevel",
	                casaRiskConsentRules.getAcceptableRiskLevel(minInformedRiskLevel));
	        collector.record("riskLevel", riskLevel);
	        collector.record("riskConsentViolated", dsViolated);
	    }

	    out.setViolated(anyViolated);
	    return out;
	}
	
	private Optional<EGraph> evaluateRisk(EGraph graph,  Map<CASA.DataSubject, Double> riskLevels) {
		boolean violated = false;
		for (CASA.DataSubject ds : riskLevels.keySet()) {
			double riskLevel = riskLevels.get(ds);
			
			double minInformedRiskLevel = 9999.0; // for statistic purposes
			violated = false;
			for (CASA.Consent c : ds.getGives()) {
				switch(casaRiskConsentRules.applyRule(riskLevel, c.getInformedRiskLevel())) {
				case VIOLATED:
					violated = true;
					break;
				case NOT_VIOLATED:
					break;
				};
				
				if (c.getInformedRiskLevel() < minInformedRiskLevel) { // for statistic purposes
					minInformedRiskLevel = c.getInformedRiskLevel();
				}
				
				if (violated) {
					break;
				}
			}
			
			collector.record("acceptableRiskLevel", casaRiskConsentRules.getAcceptableRiskLevel(minInformedRiskLevel));
			collector.record("riskLevel", riskLevel);
			collector.record("riskConsentViolated", violated);
			
			if (violated) {
				break;
			}
		}
		
		if (violated) {
			return Optional.empty();
		} else {
			return Optional.of(graph);
		}
	}
	
	private Map<CASA.DataSubject, Double> analyzeRisk(EGraph graph) {
	    Set<CASA.DataSubject> dataSubjects = identifyRisk(graph);
	    Map<CASA.DataSubject, Double> riskLevels = new HashMap<>();
	    final java.util.Random mcRnd = new java.util.Random(mcSeed);

	    for (CASA.DataSubject ds : dataSubjects) {
	        // collect vulnerabilities for this DS
	        Set<CASA.Vulnerability> vset = new HashSet<>();
	        for (CASA.PersonalData d : ds.getIdentifiedBy()) {
	            for (CASA.FuncPersData f : d.getProcessedBy()) {
	                for (CASA.Component k : f.getRealizedBy()) {
	                    vset.addAll(k.getAffectedBy());
	                }
	            }
	        }
	        List<CASA.Vulnerability> vList = new ArrayList<>(vset);

	        double computedRisk;
	        // decide mode
	        EstimationMode usedMode = this.estimationMode;
	        if (usedMode == EstimationMode.AUTO) {
	            usedMode = (vList.size() <= this.exhaustiveMaxVulns) ? EstimationMode.EXHAUSTIVE : EstimationMode.MONTE_CARLO;
	        }

	        if (usedMode == EstimationMode.EXHAUSTIVE) {
	            long t0 = System.currentTimeMillis();
	            computedRisk = computeRiskExhaustive(vList);
	            long t1 = System.currentTimeMillis();

	            collector.record("riskEstimationMode", "EXHAUSTIVE");
	            collector.record("risk.vulnCount", vList.size());
	            collector.record("exhaustive.runtime.ms", (t1 - t0));

	            System.out.printf(
	                "EXHAUSTIVE risk for DS='%s': risk=%.6f (vulns=%d, 2^n=%d, time=%d ms, mode=%s)%n",
	                (ds.getName() == null ? "<no-name>" : ds.getName()),
	                computedRisk,
	                vList.size(),
	                (1 << Math.min(vList.size(), 30)), // display 2^n safely (cap at 2^30)
	                (t1 - t0),
	                usedMode
	            );
	        } else {
	            // Monte Carlo approximation
	            MCStat stat = estimateRiskLevelMonteCarlo(vList, mcSamples, I_MAX, mcRnd);
	            computedRisk = stat.mean;

	            collector.record("riskEstimationMode", "MONTE_CARLO");
	            collector.record("risk.vulnCount", vList.size());
	            collector.record("mc.samples", mcSamples);
	            collector.record("mc.stderr", stat.stderr);

	            // print summary for debugging (optional)
	            System.out.printf(
	                "MC risk for DS='%s': mean=%.6f stderr=%.6f (vulns=%d, samples=%d, mode=%s)%n",
	                (ds.getName() == null ? "<no-name>" : ds.getName()),
	                stat.mean, stat.stderr, vList.size(), mcSamples, usedMode
	            );
	        }

	        riskLevels.put(ds, computedRisk);
	    }
	    return riskLevels;
	}


	
	private double calculateOutcomeImpact(List<VulnerabilityExploitation> outcome, List<CASA.Vulnerability> vulnerabilities) {
	    double sumImpact = 0.0;
	    for (int i = 0; i < outcome.size(); i++) {
	        if (outcome.get(i) == VulnerabilityExploitation.EXPLOITED) {
	            sumImpact += calculateVulnerabilityImpact(vulnerabilities.get(i));
	        }
	    }
	    return Math.min(I_MAX, sumImpact);
	}
	
	private double calculateOutcomeProbability(List<VulnerabilityExploitation> outcome, List<CASA.Vulnerability> vulnerabilities) {
		double outcomeProbability = 1.0;
		for (int i = 0; i < outcome.size(); i++) {
			CASA.Vulnerability v = vulnerabilities.get(i);
			double exploitationProbability = calculateVulnerabilityProbability(v);
			switch (outcome.get(i)) {
			case EXPLOITED:
				outcomeProbability *= exploitationProbability;
				break;
			case NOT_EXPLOITED:
				outcomeProbability *= 1.0 - exploitationProbability;
				break;
			}
		}
		return outcomeProbability;
	}
	
	private double calculateVulnerabilityImpact(CASA.Vulnerability v) {
	    if (!v.isIsEnabled()) return 0.0;
	    
		CASA.CVSSVector vec = v.getDescribedBy();
		ConfidentialityImpact C = vec.getConfidentialityImpact();
		IntegrityImpact I = vec.getIntegrityImpact();
		AvailabilityImpact A = vec.getAvailabilityImpact();
		ConfidentialityRequirement CR = vec.getConfidentialityRequirement();
		IntegrityRequirement IR = vec.getIntegrityRequirement();
		AvailabilityRequirement AR = vec.getAvailabilityRequirement();
		RemediationLevel RL = vec.getRemediationLevel();
		
		double IC = CASARiskCVSSMetrics.getMetricValue(CR) * CASARiskCVSSMetrics.getMetricValue(C);
		double II = CASARiskCVSSMetrics.getMetricValue(IR) * CASARiskCVSSMetrics.getMetricValue(I);
		double IA = CASARiskCVSSMetrics.getMetricValue(AR) * CASARiskCVSSMetrics.getMetricValue(A);
		double RLv = CASARiskCVSSMetrics.getMetricValue(RL);
		double impact = (IC + II + IA) / 3 * RLv;
		
		return impact;
	}
	
	private double calculateVulnerabilityProbability(CASA.Vulnerability v) {
	    if (!v.isIsEnabled()) return 0.0;
	    
		CASA.CVSSVector vec = v.getDescribedBy();
		AttackVector AV = vec.getAttackVector();
		AttackComplexity AC = vec.getAttackComplexity();
		PrivilegesRequired PR = vec.getPrivilegesRequired();
		Scope S = vec.getScope();
		UserInteraction UI = vec.getUserInteraction();
		ExploitCodeMaturity E = vec.getExploitCodeMaturity();
		ReportConfidence RC = vec.getReportConfidence();
		
		double p = CASARiskCVSSMetrics.getMetricValue(AV) *
				CASARiskCVSSMetrics.getMetricValue(AC) *
				CASARiskCVSSMetrics.getMetricValue(PR, S) *
				CASARiskCVSSMetrics.getMetricValue(UI) *
				CASARiskCVSSMetrics.getMetricValue(E) *
				CASARiskCVSSMetrics.getMetricValue(RC);
		
		return p;
	}

}
