package thesis;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

public class CASAConsentExperimentsRunner {

	/* ---------- Small helpers ---------- */

	public static class IntBounds {
		public final int min, max;

		public IntBounds(int min, int max) {
			if (min > max)
				throw new IllegalArgumentException("min > max");
			this.min = min;
			this.max = max;
		}

		public int sample(Random r) {
			if (min == max)
				return min;
			return min + r.nextInt(max - min + 1);
		}

		@Override
		public String toString() {
			return "[" + min + "," + max + "]";
		}
	}

	public static class Spec {
		// how many different models to generate/check
		public int totalModels = 10;

		public String outModelsRoot = "./out/models_experiment"; // root folder for all runs
		public String runId = "exp_" + System.currentTimeMillis(); // folder tag for this run
		public String indexCsvName = "index.csv"; // master index per run

		// base seed; each model i uses (baseSeed + i) so structure is reproduced across
		// scenarios
		public long baseSeed = 20251013L;

		// where the ecore is (required)
		public String ecorePath = "src/thesis/CASA.ecore";

		// saving is optional
		public boolean saveModels = false;
		public String outDir = "./out";

		public boolean writeCsv = true;
		public String csvPath = "./out/experiment_results.csv";

		// structural bounds
		public IntBounds numDataSubjects = new IntBounds(5, 10);
		public IntBounds personalDataPerSubject = new IntBounds(3, 5);
		public IntBounds numFuncPersData = new IntBounds(4, 8);
		public IntBounds numComponents = new IntBounds(3, 6);
		public IntBounds componentsPerFunction = new IntBounds(1, 4);
		public IntBounds vulnsPerComponent = new IntBounds(2, 4);
		public IntBounds functionsPerPersonalData = new IntBounds(1, 2);
		
		public IntBounds nonViolatingPurposesPerFunction = new IntBounds(1, 1);

		// consent knobs (per-model, sampled per scenario)
		public IntBounds purposeMismatchUnrelated = new IntBounds(0, 3); 
		public IntBounds purposeMismatchSpecial = new IntBounds(0, 2); 
		public IntBounds riskViolations = new IntBounds(0, 3); 
		
		public IntBounds disabledVulnsPerComponent = new IntBounds(0, 0);

		// CVSS preset (same for all)
		public CasaModelGenerator.CVSSPreset cvssPreset = CasaModelGenerator.CVSSPreset.defaultPreset();

		public IntBounds riskGroupSize = new IntBounds(1, 4); // PDs per new risk function
		public IntBounds riskComponents = new IntBounds(1, 3); // components per risk function
		public IntBounds riskVulns = new IntBounds(1, 3); // vulns per component
		
	    public IntBounds extraPurposesPerFunction = new IntBounds(0, 0);
	    
	    public CASARisk.EstimationMode riskEstimationMode = CASARisk.EstimationMode.AUTO;
	    public int  riskMcSamples          = 20_000;   // was hardcoded in analyzer
	    public long riskMcSeed             = 1234L;    // was hardcoded in analyzer
	    public int  riskExhaustiveMaxVulns = 15;   
	    
	    public String toJson() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("{\n");
	        // simple string helper
	        java.util.function.Function<String,String> q = s -> "\"" + s.replace("\\", "\\\\").replace("\"","\\\"") + "\"";

	        // IntBounds -> JSON
	        java.util.function.Function<IntBounds, String> jb = b -> "{ \"min\": " + b.min + ", \"max\": " + b.max + " }";

	        sb.append("  \"totalModels\": ").append(totalModels).append(",\n");
	        sb.append("  \"outModelsRoot\": ").append(q.apply(outModelsRoot)).append(",\n");
	        sb.append("  \"runId\": ").append(q.apply(runId)).append(",\n");
	        sb.append("  \"indexCsvName\": ").append(q.apply(indexCsvName)).append(",\n");
	        sb.append("  \"baseSeed\": ").append(baseSeed).append(",\n");
	        sb.append("  \"ecorePath\": ").append(q.apply(ecorePath)).append(",\n");
	        sb.append("  \"saveModels\": ").append(saveModels).append(",\n");
	        sb.append("  \"outDir\": ").append(q.apply(outDir)).append(",\n");
	        sb.append("  \"writeCsv\": ").append(writeCsv).append(",\n");
	        sb.append("  \"csvPath\": ").append(q.apply(csvPath)).append(",\n");

	        // structural bounds
	        sb.append("  \"numDataSubjects\": ").append(jb.apply(numDataSubjects)).append(",\n");
	        sb.append("  \"personalDataPerSubject\": ").append(jb.apply(personalDataPerSubject)).append(",\n");
	        sb.append("  \"numFuncPersData\": ").append(jb.apply(numFuncPersData)).append(",\n");
	        sb.append("  \"numComponents\": ").append(jb.apply(numComponents)).append(",\n");
	        sb.append("  \"componentsPerFunction\": ").append(jb.apply(componentsPerFunction)).append(",\n");
	        sb.append("  \"vulnsPerComponent\": ").append(jb.apply(vulnsPerComponent)).append(",\n");
	        sb.append("  \"functionsPerPersonalData\": ").append(jb.apply(functionsPerPersonalData)).append(",\n");
	        sb.append("  \"nonViolatingPurposesPerFunction\": ").append(jb.apply(nonViolatingPurposesPerFunction)).append(",\n");

	        // consent knobs
	        sb.append("  \"purposeMismatchUnrelated\": ").append(jb.apply(purposeMismatchUnrelated)).append(",\n");
	        sb.append("  \"purposeMismatchSpecial\": ").append(jb.apply(purposeMismatchSpecial)).append(",\n");
	        sb.append("  \"riskViolations\": ").append(jb.apply(riskViolations)).append(",\n");
	        sb.append("  \"disabledVulnsPerComponent\": ").append(jb.apply(disabledVulnsPerComponent)).append(",\n");

	        // risk injection structure
	        sb.append("  \"riskGroupSize\": ").append(jb.apply(riskGroupSize)).append(",\n");
	        sb.append("  \"riskComponents\": ").append(jb.apply(riskComponents)).append(",\n");
	        sb.append("  \"riskVulns\": ").append(jb.apply(riskVulns)).append(",\n");
	        sb.append("  \"extraPurposesPerFunction\": ").append(jb.apply(extraPurposesPerFunction)).append(",\n");

	        // cvss preset (store a name if you have one; fallback to toString)
	        sb.append("  \"cvssPreset\": ").append(q.apply(String.valueOf(cvssPreset))).append(",\n");

	        // risk engine config
	        sb.append("  \"riskEstimationMode\": ").append(q.apply(String.valueOf(riskEstimationMode))).append(",\n");
	        sb.append("  \"riskMcSamples\": ").append(riskMcSamples).append(",\n");
	        sb.append("  \"riskMcSeed\": ").append(riskMcSeed).append(",\n");
	        sb.append("  \"riskExhaustiveMaxVulns\": ").append(riskExhaustiveMaxVulns).append("\n");

	        sb.append("}\n");
	        return sb.toString();
	    }
	}

	// at top of CASAConsentExperimentsRunner
	private static final class SizeAgg {
		long totalEObjects, ds, pd, fn, comp, vuln, purp, cons;
		int n;

		void add(CASAOfflineConsentAnalyzer.Result r) {
			var s = r.size;
			totalEObjects += s.totalEObjects;
			ds += s.dataSubjects;
			pd += s.personalData;
			fn += s.functions;
			comp += s.components;
			vuln += s.vulnerabilities;
			purp += s.purposes;
			cons += s.consents;
			n++;
		}

		String meanLine() {
			if (n == 0)
				return "(no samples)";
			return String.format(
					"avg(total=%.1f, DS=%.1f, PD=%.1f, F=%.1f, C=%.1f, Vuln=%.1f, Purposes=%.1f, Consents=%.1f) over %d models",
					totalEObjects / (double) n, ds / (double) n, pd / (double) n, fn / (double) n, comp / (double) n,
					vuln / (double) n, purp / (double) n, cons / (double) n, n);
		}
	}

	/* ---------- Runner ---------- */

	private final Spec spec;

	public CASAConsentExperimentsRunner(Spec spec) {
		this.spec = spec;
	}

	public void runUsingTransformations() throws Exception {
	    // Prepare I/O
	    final URI ecoreURI = URI.createFileURI(new File(spec.ecorePath).getAbsolutePath());
	    final CASAOfflineConsentAnalyzer analyzer =
	    	    new CASAOfflineConsentAnalyzer(
	    	        new CASAOfflineConsentAnalyzer.RiskEngineConfig(
	    	            spec.riskEstimationMode,
	    	            spec.riskMcSamples,
	    	            spec.riskMcSeed,
	    	            spec.riskExhaustiveMaxVulns
	    	        )
	    	    );
	    final CASAAdaptationGenerator adap = new CASAAdaptationGenerator(); // (kept if analyzer uses it internally)

	    // Root folder for this run (suffix _xfm to differentiate)
	    final Path runRoot = Path.of(spec.outModelsRoot, spec.runId + "_xfm");
	    Files.createDirectories(runRoot);
	 // Save experiment configuration for reproducibility
	    writeString(runRoot.resolve("experiment_config.json"), spec.toJson());


	    // CSV: mirror the header used in run() so results are comparable
	    Path indexCsv = runRoot.resolve(spec.indexCsvName);
	    try (java.io.PrintWriter csv = new java.io.PrintWriter(
	            new java.io.OutputStreamWriter(Files.newOutputStream(indexCsv),
	                    java.nio.charset.StandardCharsets.UTF_8))) {

	        // --- helper to append a header block for sizes with a prefix
	        java.util.function.Function<String, String> sizeHeader = (prefix) ->
	            String.join(",", 
	                prefix + "_DS", prefix + "_PD", prefix + "_Functions", prefix + "_Components",
	                prefix + "_Vulnerabilities", prefix + "_Purposes", prefix + "_Consents", prefix + "_TotalElements"
	            );

	        // HEADER
	            csv.println(String.join(",",
	            	    // existing
	            	    "model_index","seed",
	            	    "purpose_model_path","risk_model_path",
	            	    "DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents","TotalElements","TotalRelations",  
	            	    "gt_purpose_total","gt_purpose_unrelated","gt_purpose_specialized","gt_risk_violations",
	            	    "detected_purpose_total","detected_purpose_unrelated","detected_purpose_specialized","detected_risk_violations",
	            	    "observed_purpose_ok","observed_risk_ok","purpose_correct","risk_correct",
	            	    "baseline_path","purpose_pre_path","risk_pre_path",
	            	    sizeHeader.apply("baseline"),
	            	    sizeHeader.apply("A_pre"),
	            	    sizeHeader.apply("A_post"),
	            	    sizeHeader.apply("B_pre"),
	            	    sizeHeader.apply("B_post")
	            	));

	        // For summary printouts
	        int purposeOkCount = 0, riskOkCount = 0;
	        int purposeDetectionsCorrect = 0, purposeFalsePos = 0, purposeFalseNeg = 0;
	        int riskDetectionsCorrect = 0, riskFalsePos = 0, riskFalseNeg = 0;

	        SizeAgg sizesPurpose = new SizeAgg();
	        SizeAgg sizesRisk    = new SizeAgg();

	        for (int i = 0; i < spec.totalModels; i++) {
	            final long seedForThisModel = spec.baseSeed + i;
	            final Random sampler = new Random(seedForThisModel);

	            // --- Sample clean structure (no violations) ---
	            CasaModelGenerator.Config base = new CasaModelGenerator.Config();
	            base.numDataSubjects           = spec.numDataSubjects.sample(sampler);
	            base.personalDataPerSubject    = spec.personalDataPerSubject.sample(sampler);
	            base.numFuncPersData           = spec.numFuncPersData.sample(sampler);
	            base.numComponents             = spec.numComponents.sample(sampler);
	            base.componentsPerFunction     = spec.componentsPerFunction.sample(sampler);
	            base.vulnsPerComponent         = spec.vulnsPerComponent.sample(sampler);
	            base.functionsPerPersonalData  = spec.functionsPerPersonalData.sample(sampler);
	            base.seed                      = seedForThisModel;
	            base.cvssPreset                = spec.cvssPreset;
	            base.saveAsXMI                 = false;
	            
	            int kNVPF = spec.nonViolatingPurposesPerFunction.sample(sampler);
	            base.nonViolatingPurposesPerFunction = kNVPF;
	            
	            base.disabledVulnsPerComponent = spec.disabledVulnsPerComponent.sample(sampler);
	            // start clean
	            base.purposeMismatchUnrelated  = 0;
	            base.purposeMismatchSpecialized= 0;
	            base.riskViolations            = 0;

	            // Per-model folder
	            Path modelDir = runRoot.resolve(String.format("model_%02d_seed_%d", i, seedForThisModel));
	            Files.createDirectories(modelDir);

	            // --- Generate a clean model once ---
	            Resource resClean = generate(ecoreURI, base, null); // not saving here yet

	            // --- Sample desired violations deterministically ---
	            int injUnrel = spec.purposeMismatchUnrelated.sample(sampler);
	            int injSpec  = spec.purposeMismatchSpecial.sample(sampler);
	            int injRisk  = spec.riskViolations.sample(sampler);

	            int maxSetSize = spec.riskGroupSize.max;
	            int maxComp    = spec.riskComponents.max;
	            int maxVulns   = spec.riskVulns.max;

	            // --- File paths (baseline + A/B pre/post)
	            Path baselinePath = modelDir.resolve("baseline_clean.xmi");
	            Path aPrePath     = modelDir.resolve("scenarioA_pre.xmi");
	            Path aPostPath    = modelDir.resolve("scenarioA_post.xmi");
	            Path bPrePath     = modelDir.resolve("scenarioB_pre.xmi");
	            Path bPostPath    = modelDir.resolve("scenarioB_post.xmi");

	            // --- Save & analyze BASELINE ---
	            Resource resBaseline = deepCopyResource(resClean);
	            resBaseline.setURI(URI.createFileURI(baselinePath.toFile().getAbsolutePath()));
	            resBaseline.save(null);
	            var baseObs = analyzer.analyzeResource(resBaseline);  // analyze baseline

	            // --- Scenario A: PRE ---
	            Resource resA_pre = deepCopyResource(resClean);
	            resA_pre.setURI(URI.createFileURI(aPrePath.toFile().getAbsolutePath()));
	            resA_pre.save(null);
	            var aPreObs = analyzer.analyzeResource(resA_pre);

	            // --- Scenario A: POST (transform) ---
	            Resource resA_forTransform = deepCopyResource(resA_pre);
	            var outA = analyzer.analyzeWithTransform(
	                resA_forTransform, injUnrel, injSpec, 0,
	                maxSetSize, maxComp, maxVulns,
	                /* extra non-violating purposes per function: */
	                spec.extraPurposesPerFunction.min,
	                spec.extraPurposesPerFunction.max,
	                seedForThisModel
	            );
	            outA.transformed.setURI(URI.createFileURI(aPostPath.toFile().getAbsolutePath()));
	            outA.transformed.save(null);
	            var aPostObs = outA.analysis;

	            // --- Scenario B: PRE ---
	            Resource resB_pre = deepCopyResource(resClean);
	            resB_pre.setURI(URI.createFileURI(bPrePath.toFile().getAbsolutePath()));
	            resB_pre.save(null);
	            var bPreObs = analyzer.analyzeResource(resB_pre);

	            // --- Scenario B: POST (transform) ---
	            Resource resB_forTransform = deepCopyResource(resB_pre);
	            var outB = analyzer.analyzeWithTransform(
	                resB_forTransform, 0, 0, injRisk,
	                maxSetSize, maxComp, maxVulns,
	                /* extra non-violating purposes per function: */
	                spec.extraPurposesPerFunction.min,
	                spec.extraPurposesPerFunction.max,
	                seedForThisModel
	            );
	            outB.transformed.setURI(URI.createFileURI(bPostPath.toFile().getAbsolutePath()));
	            outB.transformed.save(null);
	            var bPostObs = outB.analysis;
	            
	            // Observations for summary
	            sizesPurpose.add(aPostObs);
	            sizesRisk.add(bPostObs);

	            if (aPostObs.purposeOK) purposeOkCount++;
	            if (bPostObs.riskOK)    riskOkCount++;

	            // Sizes to keep old columns (taken from A post)
	            var s = aPostObs.size;
	            long total = s.totalEObjects;
	            long ds = s.dataSubjects, pd = s.personalData, fn = s.functions,
	                 comp = s.components, vuln = s.vulnerabilities, purp = s.purposes, cons = s.consents;
	            long rel = s.totalRelations;

	         // --- Ground truth (split, using actually introduced violations) ---
	            int gtPurposeUnrel = (outA.applied != null) ? outA.applied.doneUnrel : injUnrel;
	            int gtPurposeSpec  = (outA.applied != null) ? outA.applied.doneSpec  : injSpec;
	            int gtPurposeTotal = gtPurposeUnrel + gtPurposeSpec;
	            int gtRiskViol     = (outB.applied != null) ? outB.applied.riskPDs   : injRisk;

	            // --- Detected (split) ---
	            int detPurposeTotal = aPostObs.detectedPurposeViolations;
	            int detPurposeUnrel = aPostObs.detectedPurposeUnrelated;
	            int detPurposeSpec  = aPostObs.detectedPurposeSpecialized;
	            int detRisk         = bPostObs.detectedRiskViolations;

	            boolean observedPurposeOK = aPostObs.purposeOK;
	            boolean observedRiskOK    = bPostObs.riskOK;

	            boolean purposeCorrect = ((gtPurposeTotal > 0) == (detPurposeTotal > 0));
	            boolean riskCorrect    = ((gtRiskViol     > 0) == (detRisk         > 0));

	            boolean expectedPurposeOK = (gtPurposeTotal == 0);
	            if ((aPostObs.purposeOK == expectedPurposeOK)
	                    && ((expectedPurposeOK && aPostObs.reason == CASABase.CASA_REASON.NOT_VIOLATED)
	                        || (!expectedPurposeOK && aPostObs.reason == CASABase.CASA_REASON.PURPOSE_VIOLATED))) {
	                purposeDetectionsCorrect++;
	            } else {
	                if (!expectedPurposeOK && aPostObs.purposeOK) purposeFalseNeg++;
	                if ( expectedPurposeOK && !aPostObs.purposeOK) purposeFalsePos++;
	            }

	            boolean expectedRiskOK = (gtRiskViol == 0);
	            if ((bPostObs.riskOK == expectedRiskOK)
	                    && ((expectedRiskOK && bPostObs.reason == CASABase.CASA_REASON.NOT_VIOLATED)
	                        || (!expectedRiskOK && (bPostObs.reason == CASABase.CASA_REASON.RISK_VIOLATED || !bPostObs.riskOK)))) {
	                riskDetectionsCorrect++;
	            } else {
	                if (!expectedRiskOK && bPostObs.riskOK) riskFalseNeg++;
	                if ( expectedRiskOK && !bPostObs.riskOK) riskFalsePos++;
	            }

	            // ---- pack size blocks (baseline, A_pre, A_post, B_pre, B_post) ----
	            java.util.function.Function<CASAOfflineConsentAnalyzer.Result, long[]> toSize =
	                (obs) -> new long[] {
	                    obs.size.dataSubjects, obs.size.personalData, obs.size.functions, obs.size.components,
	                    obs.size.vulnerabilities, obs.size.purposes, obs.size.consents, obs.size.totalEObjects
	                };
	            long[] baseSz  = toSize.apply(baseObs);
	            long[] aPreSz  = toSize.apply(aPreObs);
	            long[] aPostSz = toSize.apply(aPostObs);
	            long[] bPreSz  = toSize.apply(bPreObs);
	            long[] bPostSz = toSize.apply(bPostObs);

	            // CSV row (matches header above)
	            csv.printf(
	            	    // head columns (through correctness flags + paths)
	            	    "%d,%d,%s,%s," +                                       // model_index, seed, purpose_model_path, risk_model_path
	            	    "%d,%d,%d,%d,%d,%d,%d,%d,%d," +                        // DS,PD,Functions,Components,Vulnerabilities,Purposes,Consents,TotalElements,TotalRelations
	            	    "%d,%d,%d,%d," +                                       // gt_* (total,unrelated,specialized,risk)
	            	    "%d,%d,%d,%d," +                                       // detected_* (total,unrelated,specialized,risk)
	            	    "%s,%s,%s,%s," +                                       // observed_purpose_ok, observed_risk_ok, purpose_correct, risk_correct
	            	    "%s,%s,%s," +                                          // baseline_path, purpose_pre_path, risk_pre_path

	            	    // size blocks (8 each): baseline, A_pre, A_post, B_pre, B_post
	            	    "%d,%d,%d,%d,%d,%d,%d,%d," +                           // baseline
	            	    "%d,%d,%d,%d,%d,%d,%d,%d," +                           // A_pre
	            	    "%d,%d,%d,%d,%d,%d,%d,%d," +                           // A_post
	            	    "%d,%d,%d,%d,%d,%d,%d,%d," +                           // B_pre
	            	    "%d,%d,%d,%d,%d,%d,%d,%d%n",                           // B_post

	            	    i, seedForThisModel,
	            	    aPostPath.toString(), bPostPath.toString(),

	            	    // sizes summary + relations
	            	    ds, pd, fn, comp, vuln, purp, cons, total, rel,

	            	    // ground truth split
	            	    gtPurposeTotal, gtPurposeUnrel, gtPurposeSpec, gtRiskViol,

	            	    // detected split
	            	    detPurposeTotal, detPurposeUnrel, detPurposeSpec, detRisk,

	            	    // booleans (printed as strings)
	            	    String.valueOf(observedPurposeOK), String.valueOf(observedRiskOK),
	            	    String.valueOf(purposeCorrect), String.valueOf(riskCorrect),

	            	    // paths
	            	    baselinePath.toString(), aPrePath.toString(), bPrePath.toString(),

	            	    // size blocks
	            	    baseSz[0], baseSz[1], baseSz[2], baseSz[3], baseSz[4], baseSz[5], baseSz[6], baseSz[7],
	            	    aPreSz[0], aPreSz[1], aPreSz[2], aPreSz[3], aPreSz[4], aPreSz[5], aPreSz[6], aPreSz[7],
	            	    aPostSz[0], aPostSz[1], aPostSz[2], aPostSz[3], aPostSz[4], aPostSz[5], aPostSz[6], aPostSz[7],
	            	    bPreSz[0], bPreSz[1], bPreSz[2], bPreSz[3], bPreSz[4], bPreSz[5], bPreSz[6], bPreSz[7],
	            	    bPostSz[0], bPostSz[1], bPostSz[2], bPostSz[3], bPostSz[4], bPostSz[5], bPostSz[6], bPostSz[7]
	            	);

	            // Console summary per model (unchanged)
	            System.out.printf(
	                "[%02d] seed=%d | A: inj(U=%d,S=%d) -> purposeOK=%s | B: inj(R=%d) -> riskOK=%s | det: P=%d(U=%d,S=%d) R=%d%n",
	                i, seedForThisModel, injUnrel, injSpec, observedPurposeOK, injRisk, observedRiskOK,
	                detPurposeTotal, detPurposeUnrel, detPurposeSpec, detRisk
	            );
	        }

	        // ---- Aggregate summary ----
	        System.out.println("=================================================");
	        System.out.printf("Transform experiments (A/B split): ran %d models.%n", spec.totalModels);
	        System.out.println("--- Model size (Scenario A: purpose) ---");
	        System.out.println(sizesPurpose.meanLine());
	        System.out.println("--- Model size (Scenario B: risk) ---");
	        System.out.println(sizesRisk.meanLine());
	        System.out.printf("Observed OK ratios: purposeOK=%d/%d, riskOK=%d/%d%n",
	                purposeOkCount, spec.totalModels, riskOkCount, spec.totalModels);
	        System.out.printf("Purpose detection: correct=%d/%d | FP=%d FN=%d%n",
	                purposeDetectionsCorrect, spec.totalModels, purposeFalsePos, purposeFalseNeg);
	        System.out.printf("Risk    detection: correct=%d/%d | FP=%d FN=%d%n",
	                riskDetectionsCorrect, spec.totalModels, riskFalsePos, riskFalseNeg);
	        System.out.println("Index CSV: " + indexCsv.toAbsolutePath());
	        System.out.println("Root dir:  " + runRoot.toAbsolutePath());
	        System.out.println("=================================================");
	    }
	}

	/** Minimal deep copy of a Resource (keeps cross-refs consistent). */
	private static Resource deepCopyResource(Resource src) {
		Resource dst = src.getResourceSet().createResource(
				org.eclipse.emf.common.util.URI.createURI("memory:/copy_" + java.util.UUID.randomUUID()));
		@SuppressWarnings("unchecked")
		java.util.Collection<org.eclipse.emf.ecore.EObject> copies = org.eclipse.emf.ecore.util.EcoreUtil
				.copyAll(src.getContents());
		dst.getContents().addAll(copies);
		return dst;
	}

	public void run() throws Exception {
		if (spec.saveModels)
			new File(spec.outDir).mkdirs();

		final URI ecoreURI = URI.createFileURI(new File(spec.ecorePath).getAbsolutePath());
		final CASAOfflineConsentAnalyzer analyzer =
			    new CASAOfflineConsentAnalyzer(
			        new CASAOfflineConsentAnalyzer.RiskEngineConfig(
			            spec.riskEstimationMode,
			            spec.riskMcSamples,
			            spec.riskMcSeed,
			            spec.riskExhaustiveMaxVulns
			        )
			    );

		// Accuracy tallies (per scenario)
		int purposeDetectionsCorrect = 0, purposeFalsePos = 0, purposeFalseNeg = 0;
		int riskDetectionsCorrect = 0, riskFalsePos = 0, riskFalseNeg = 0;

		// Simple observed-OK counters (optional)
		int purposeOkCount = 0;
		int riskOkCount = 0;

		// Model size aggregations (for summary prints)
		SizeAgg purposeSizes = new SizeAgg();
		SizeAgg riskSizes = new SizeAgg();

		// --- CSV setup ---
		// --- Output folders & CSV setup ---
		final Path runRoot = Path.of(spec.outModelsRoot, spec.runId);
		Files.createDirectories(runRoot);
		// Save experiment configuration for reproducibility
		writeString(runRoot.resolve("experiment_config.json"), spec.toJson());


		java.io.PrintWriter csv = null;
		if (spec.writeCsv) {
			Path indexCsv = runRoot.resolve(spec.indexCsvName);
			csv = new java.io.PrintWriter(new java.io.OutputStreamWriter(Files.newOutputStream(indexCsv),
					java.nio.charset.StandardCharsets.UTF_8));
			// Header: one row per *model index* (structure) including file paths
			csv.println(String.join(",", "model_index", "seed", "purpose_model_path", "risk_model_path", "DS", "PD",
					"Functions", "Components", "Vulnerabilities", "Purposes", "Consents", "TotalElements",
					"gt_purpose_total", "gt_purpose_unrelated", "gt_purpose_specialized", "gt_risk_violations",
					"detected_purpose_total", "detected_purpose_unrelated", "detected_purpose_specialized",
					"detected_risk_violations", "observed_purpose_ok", "observed_risk_ok", "purpose_correct",
					"risk_correct"));
		}

		try {
			for (int i = 0; i < spec.totalModels; i++) {
				final long seedForThisModel = spec.baseSeed + i;
				final Random sampler = new Random(seedForThisModel);

				// ---- Sample structure once (identical across both scenarios for this model)
				// ----
				CasaModelGenerator.Config base = new CasaModelGenerator.Config();
				base.numDataSubjects = spec.numDataSubjects.sample(sampler);
				base.personalDataPerSubject = spec.personalDataPerSubject.sample(sampler);
				base.numFuncPersData = spec.numFuncPersData.sample(sampler);
				base.numComponents = spec.numComponents.sample(sampler);
				base.componentsPerFunction = spec.componentsPerFunction.sample(sampler);
				base.vulnsPerComponent = spec.vulnsPerComponent.sample(sampler);
				base.functionsPerPersonalData = spec.functionsPerPersonalData.sample(sampler);
				
				int kNVPF = spec.nonViolatingPurposesPerFunction.sample(sampler);
				base.nonViolatingPurposesPerFunction = kNVPF;
				
				base.disabledVulnsPerComponent = spec.disabledVulnsPerComponent.sample(sampler);
				
				base.seed = seedForThisModel; // ensures identical structure
				base.cvssPreset = spec.cvssPreset;
				base.saveAsXMI = false;

				// Per-model folder
				Path modelDir = runRoot.resolve(String.format("model_%02d_seed_%d", i, seedForThisModel));
				Files.createDirectories(modelDir);

				// Filenames
				Path aPath = modelDir.resolve("scenarioA_purpose.xmi");
				Path bPath = modelDir.resolve("scenarioB_risk.xmi");

				// ---- Scenario A: Purpose-mismatch only (no risk violations) ----
				CasaModelGenerator.Config cfgA = cloneStruct(base);
				cfgA.purposeMismatchUnrelated = spec.purposeMismatchUnrelated.sample(sampler);
				cfgA.purposeMismatchSpecialized = spec.purposeMismatchSpecial.sample(sampler);
				cfgA.riskViolations = 0;

				Resource resA = generate(ecoreURI, cfgA, aPath.toFile().getAbsolutePath());

				var obsA = analyzer.analyzeResource(resA);
				purposeSizes.add(obsA);
				if (obsA.purposeOK)
					purposeOkCount++;

				// Ground truth for A
				int gtPurposeViolations = cfgA.purposeMismatchUnrelated + cfgA.purposeMismatchSpecialized;

				// Check purpose
				boolean expectedPurposeOK_A = (gtPurposeViolations == 0);
				boolean purposePASS_A = (obsA.purposeOK == expectedPurposeOK_A)
						&& ((expectedPurposeOK_A && obsA.reason == CASABase.CASA_REASON.NOT_VIOLATED)
								|| (!expectedPurposeOK_A && obsA.reason == CASABase.CASA_REASON.PURPOSE_VIOLATED));

				if (purposePASS_A) {
					purposeDetectionsCorrect++;
				} else {
					if (!expectedPurposeOK_A && obsA.purposeOK)
						purposeFalseNeg++; // missed violation
					if (expectedPurposeOK_A && !obsA.purposeOK)
						purposeFalsePos++; // spurious violation
				}

				// Risk in A should be OK; warn if not
				if (!obsA.riskOK) {
					System.out.printf("     [WARN] Scenario A triggered unexpected risk violation (seed=%d)%n",
							seedForThisModel);
				}

				// ---- Scenario B: Risk-only (no purpose mismatches) ----
				CasaModelGenerator.Config cfgB = cloneStruct(base);
				cfgB.purposeMismatchUnrelated = 0;
				cfgB.purposeMismatchSpecialized = 0;
				cfgB.riskViolations = spec.riskViolations.sample(sampler);

				Resource resB = generate(ecoreURI, cfgB, bPath.toFile().getAbsolutePath());

				var obsB = analyzer.analyzeResource(resB);
				riskSizes.add(obsB);
				if (obsB.riskOK)
					riskOkCount++;

				// Ground truth for B
				int gtRiskViolations = cfgB.riskViolations;

				// Check risk
				boolean expectedRiskOK_B = (gtRiskViolations == 0);
				boolean riskPASS_B = (obsB.riskOK == expectedRiskOK_B)
						&& ((expectedRiskOK_B && obsB.reason == CASABase.CASA_REASON.NOT_VIOLATED) || (!expectedRiskOK_B
								&& (obsB.reason == CASABase.CASA_REASON.RISK_VIOLATED || !obsB.riskOK)));

				if (riskPASS_B) {
					riskDetectionsCorrect++;
				} else {
					if (!expectedRiskOK_B && obsB.riskOK)
						riskFalseNeg++; // missed risk violation
					if (expectedRiskOK_B && !obsB.riskOK)
						riskFalsePos++; // spurious risk violation
				}

				// --- Per-model metadata.json (human + machine readable) ---
				String metadataJson = "" + "{\n" + "  \"model_index\": " + i + ",\n" + "  \"seed\": " + seedForThisModel
						+ ",\n" + "  \"paths\": {\n" + "    \"scenarioA\": \"" + jsonEscape(aPath.toString()) + "\",\n"
						+ "    \"scenarioB\": \"" + jsonEscape(bPath.toString()) + "\"\n" + "  },\n"
						+ "  \"structure\": {\n" + "    \"DS\": " + obsA.size.dataSubjects + ",\n" + "    \"PD\": "
						+ obsA.size.personalData + ",\n" + "    \"Functions\": " + obsA.size.functions + ",\n"
						+ "    \"Components\": " + obsA.size.components + ",\n" + "    \"Vulnerabilities\": "
						+ obsA.size.vulnerabilities + ",\n" + "    \"Purposes\": " + obsA.size.purposes + ",\n"
						+ "    \"Consents\": " + obsA.size.consents + ",\n" + "    \"TotalElements\": "
						+ obsA.size.totalEObjects + "\n" + "  },\n" + "  \"gt\": {\n" + "    \"purpose_unrelated\": "
						+ cfgA.purposeMismatchUnrelated + ",\n" + "    \"purpose_specialized\": "
						+ cfgA.purposeMismatchSpecialized + ",\n" + "    \"purpose_total\": "
						+ (cfgA.purposeMismatchUnrelated + cfgA.purposeMismatchSpecialized) + ",\n"
						+ "    \"risk_violations\": " + cfgB.riskViolations + "\n" + "  },\n" + "  \"detected\": {\n"
						+ "    \"purpose_unrelated\": " + obsA.detectedPurposeUnrelated + ",\n"
						+ "    \"purpose_specialized\": " + obsA.detectedPurposeSpecialized + ",\n"
						+ "    \"purpose_total\": " + obsA.detectedPurposeViolations + ",\n"
						+ "    \"risk_violations\": " + obsB.detectedRiskViolations + "\n" + "  },\n"
						+ "  \"observed\": {\n" + "    \"purposeOK\": " + obsA.purposeOK + ",\n" + "    \"riskOK\": "
						+ obsB.riskOK + "\n" + "  }\n" + "}\n";
				writeString(modelDir.resolve("metadata.json"), metadataJson);

				// ---- Per-model summary ----
				System.out.printf("[%02d] Struct(seed=%d): DS=%d PD/DS=%d F=%d C=%d CpF=%d Vuln/C=%d F/PD=%d%n", i,
						seedForThisModel, base.numDataSubjects, base.personalDataPerSubject, base.numFuncPersData,
						base.numComponents, base.componentsPerFunction, base.vulnsPerComponent,
						base.functionsPerPersonalData);

				System.out.printf(
						"     ScenarioA (Purpose): injected pmUnrel=%d pmSpec=%d | expected purposeOK=%s | observed purposeOK=%s reason=%s => %s%n",
						cfgA.purposeMismatchUnrelated, cfgA.purposeMismatchSpecialized, expectedPurposeOK_A,
						obsA.purposeOK, obsA.reason, (purposePASS_A ? "PASS" : "FAIL"));

				System.out.printf(
						"     ScenarioB (Risk):    injected riskViol=%d       | expected riskOK=%s    | observed riskOK=%s reason=%s => %s%n",
						cfgB.riskViolations, expectedRiskOK_B, obsB.riskOK, obsB.reason,
						(riskPASS_B ? "PASS" : "FAIL"));

				// ---- CSV row (one row per model) ----
				if (csv != null) {
					// Use the size from Scenario A (structure is the same across scenarios)
					var s = obsA.size;
					long total = s.totalEObjects;
					long ds = s.dataSubjects, pd = s.personalData, fn = s.functions, comp = s.components,
							vuln = s.vulnerabilities, purp = s.purposes, cons = s.consents;

					// --- Ground truth (split) ---
					int gtPurposeUnrel = cfgA.purposeMismatchUnrelated;
					int gtPurposeSpec = cfgA.purposeMismatchSpecialized;
					int gtPurposeTotal = gtPurposeUnrel + gtPurposeSpec;
					int gtRiskViol = cfgB.riskViolations;

					// --- Detected (split) from analyzer results ---
					int detPurposeTotal = obsA.detectedPurposeViolations;
					int detPurposeUnrel = obsA.detectedPurposeUnrelated;
					int detPurposeSpec = obsA.detectedPurposeSpecialized;
					int detRisk = obsB.detectedRiskViolations;

					// Observed OK
					boolean observedPurposeOK = obsA.purposeOK;
					boolean observedRiskOK = obsB.riskOK;

					// Correctness: any-vs-none match for each category
					boolean purposeCorrect = ((gtPurposeTotal > 0) == (detPurposeTotal > 0));
					boolean riskCorrect = ((gtRiskViol > 0) == (detRisk > 0));

					csv.printf(
							// 24 columns, matching the header exactly
							"%d,%d,%s,%s,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%d,%s,%s,%s,%s%n", i,
							seedForThisModel, aPath.toString(), // <<< path_scenarioA
							bPath.toString(), // <<< path_scenarioB
							ds, pd, fn, comp, vuln, purp, cons, total, gtPurposeTotal, gtPurposeUnrel, gtPurposeSpec,
							gtRiskViol, detPurposeTotal, detPurposeUnrel, detPurposeSpec, detRisk,
							String.valueOf(observedPurposeOK), String.valueOf(observedRiskOK),
							String.valueOf(purposeCorrect), String.valueOf(riskCorrect));
				}
			}

			// ---- Aggregate summary ----
			System.out.println("=================================================");
			System.out.printf("Ran %d structural samples (each with 2 scenarios).%n", spec.totalModels);

			System.out.printf("Purpose detection: correct=%d / %d  | FP=%d  FN=%d%n", purposeDetectionsCorrect,
					spec.totalModels, purposeFalsePos, purposeFalseNeg);

			System.out.printf("Risk detection:    correct=%d / %d  | FP=%d  FN=%d%n", riskDetectionsCorrect,
					spec.totalModels, riskFalsePos, riskFalseNeg);

			System.out.println("--- Model size (Purpose scenario) ---");
			System.out.println(purposeSizes.meanLine());

			System.out.println("--- Model size (Risk scenario) ---");
			System.out.println(riskSizes.meanLine());

			System.out.printf("Observed OK ratios: purposeOK=%d/%d, riskOK=%d/%d%n", purposeOkCount, spec.totalModels,
					riskOkCount, spec.totalModels);

			System.out.println("=================================================");
		} finally {
			if (csv != null)
				csv.close();
		}
	}

	/* ---------- Utilities ---------- */

	private static CasaModelGenerator.Config cloneStruct(CasaModelGenerator.Config src) {
		CasaModelGenerator.Config c = new CasaModelGenerator.Config();
		// copy only the structural parts + seed + cvss preset
		c.numDataSubjects = src.numDataSubjects;
		c.personalDataPerSubject = src.personalDataPerSubject;
		c.numFuncPersData = src.numFuncPersData;
		c.numComponents = src.numComponents;
		c.componentsPerFunction = src.componentsPerFunction;
		c.vulnsPerComponent = src.vulnsPerComponent;
		c.functionsPerPersonalData = src.functionsPerPersonalData;
		c.seed = src.seed;
		c.cvssPreset = src.cvssPreset;
		c.nonViolatingRiskLevel = src.nonViolatingRiskLevel;
		c.disabledVulnsPerComponent = src.disabledVulnsPerComponent;
		c.nonViolatingPurposesPerFunction = src.nonViolatingPurposesPerFunction;
		return c;
	}

	private static Resource deepCopyResource(Resource src, org.eclipse.emf.common.util.URI ecoreURI) {
		// New ad-hoc Resource in the same ResourceSet
		Resource dst = src.getResourceSet()
				.createResource(org.eclipse.emf.common.util.URI.createURI("memory:/copy_" + UUID.randomUUID()));
		// Deep copy all roots
		@SuppressWarnings("unchecked")
		java.util.Collection<org.eclipse.emf.ecore.EObject> copies = org.eclipse.emf.ecore.util.EcoreUtil
				.copyAll(src.getContents());
		dst.getContents().addAll(copies);
		return dst;
	}

	private static Resource generate(URI ecoreURI, CasaModelGenerator.Config cfg, String optionalSavePath)
			throws Exception {
		CasaModelGenerator gen = new CasaModelGenerator(cfg);
		gen.loadEcore(ecoreURI);

		// out dir URI is irrelevant; create a temp logical URI to satisfy
		// ResourceSet
		URI logicalOutDir = URI.createFileURI(new File(".").getAbsolutePath());
		Resource res = gen.generate(logicalOutDir);

		if (optionalSavePath != null) {
			File f = new File(optionalSavePath);
			res.setURI(URI.createFileURI(f.getAbsolutePath()));
			res.save(null);
		}
		return res;
	}

	private static void writeString(Path path, String content) throws Exception {
		Files.createDirectories(path.getParent());
		Files.writeString(path, content, StandardCharsets.UTF_8);
	}

	private static String jsonEscape(String s) {
		return s.replace("\\", "\\\\").replace("\"", "\\\"");
	}

	/* ---------- Example usage from Thesis.main ---------- */

	public static void exampleFromThesis() throws Exception {
		CASAConsentExperimentsRunner.Spec spec = new CASAConsentExperimentsRunner.Spec();
		spec.totalModels = 5;
		spec.baseSeed = 20251013L;
		spec.ecorePath = "src/thesis/CASA.ecore";
		spec.saveModels = false; // set true if you want XMI files

		// tighten or widen bounds as you like
		spec.numDataSubjects = new IntBounds(6, 6);
		spec.personalDataPerSubject = new IntBounds(5, 5);
		spec.numFuncPersData = new IntBounds(5, 5);
		spec.numComponents = new IntBounds(4, 4);
		spec.componentsPerFunction = new IntBounds(3, 3);
		spec.vulnsPerComponent = new IntBounds(3, 3);
		spec.functionsPerPersonalData = new IntBounds(1, 1);

		// consent magnitudes per model (sampled independently for each model)
		spec.purposeMismatchUnrelated = new IntBounds(0, 2);
		spec.purposeMismatchSpecial = new IntBounds(0, 1);
		spec.riskViolations = new IntBounds(1, 3);

		new CASAConsentExperimentsRunner(spec).run();
	}
}
