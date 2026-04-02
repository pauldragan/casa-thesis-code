package thesis;

import com.google.common.base.Stopwatch;
import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.EObject;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.util.concurrent.TimeUnit;
import java.util.zip.GZIPOutputStream;

/**
 * Benchmarks purpose/risk analysis AND (optionally) the transformation step.
 *
 * Compatible with: - OLD manifest: minimal columns (risk_model_path, sizes...)
 *  runs old timing (no transform timing) - new manifest: baseline_path,
 * A_pre_path, A_post_path, B_pre_path, B_post_path, gt_purpose_unrelated,
 * gt_purpose_specialized, gt_risk_violations -> full transform+analysis timing
 *
 * If transformMode == "load" and *_post files exist, do only time analysis. If
 * transformMode == "regen" OR *_post missing, re-generate A/B post by
 * applying the same Henshin transformations (same seed + counts) and time that
 * step.
 */
public class CASAConsentBenchmarkRunner {

	public static class Spec {
		public String modelsDir = "./out/models";
		public String manifestPath = "./out/models/manifest.csv";
		public String benchCsvPath = "./out/benchmark_results.csv";
	    public String experimentConfigPath = null;
		/** Gzipped CSV with raw per-iteration samples. */
		public String rawSamplesPath = "./out/benchmark_samples.csv.gz";
		public int warmup = 5;
		public int iterations = 30;
		public String ecorePath = "src/thesis/CASA.ecore";

		/** "load" (prefer existing *_post) or "regen" (rebuild transformations). */
		public String transformMode = "regen";

		/** Knobs to match experiment runner defaults (only used in regen mode). */
		public int maxSetSize = 4; // PDs per injected risk function
		public int maxComponents = 3; // components per function
		public int maxVulns = 3; // vulns per component
		public int extraPurposesMin = 0;
		public int extraPurposesMax = 0;
		
	    public CASARisk.EstimationMode riskEstimationModeOverride = null;
	    public Integer riskMcSamplesOverride = null;
	    public Long riskMcSeedOverride = null;
	    public Integer riskExhaustiveMaxVulnsOverride = null;
	}

	private final Spec spec;
	private final CASAOfflineConsentAnalyzer analyzer;

	public CASAConsentBenchmarkRunner(Spec spec) {
		this.spec = spec;

	    CASAOfflineConsentAnalyzer.RiskEngineConfig rc = loadRiskConfig(spec);
	    this.analyzer = new CASAOfflineConsentAnalyzer(rc);
	}
	
	public void run() throws Exception {
		// Ensure output dirs exist
		Path benchCsv = Paths.get(spec.benchCsvPath);
		if (benchCsv.getParent() != null)
			Files.createDirectories(benchCsv.getParent());
		Path rawGzPath = Paths.get(spec.rawSamplesPath);
		if (rawGzPath.getParent() != null)
			Files.createDirectories(rawGzPath.getParent());

		try (BufferedReader reader = Files.newBufferedReader(Paths.get(spec.manifestPath), StandardCharsets.UTF_8);
				PrintWriter out = new PrintWriter(
						new OutputStreamWriter(new FileOutputStream(spec.benchCsvPath, false), StandardCharsets.UTF_8));
				// Raw samples gzipped CSV
				GZIPOutputStream rawGz = new GZIPOutputStream(new FileOutputStream(spec.rawSamplesPath, false));
				PrintWriter raw = new PrintWriter(new OutputStreamWriter(rawGz, StandardCharsets.UTF_8))) {

			String header = reader.readLine();
			if (header == null)
				return;
			String[] cols = header.split(",", -1);

			// --- Column indexes (best-effort: work with both old/new manifests) ---
			// Old
			int idxModel = idxOptional(cols, "model_index");
			int idxSeed = idxOptional(cols, "seed");
			int idxRiskPath = idxOptional(cols, "risk_model_path");
			int idxDS = idxOptional(cols, "DS");
			int idxPD = idxOptional(cols, "PD");
			int idxFN = idxOptional(cols, "Functions");
			int idxC = idxOptional(cols, "Components");
			int idxV = idxOptional(cols, "Vulnerabilities");
			int idxP = idxOptional(cols, "Purposes");
			int idxCONS = idxOptional(cols, "Consents");
			int idxTot = idxOptional(cols, "TotalElements");
			int idxGtRisk = idxOptional(cols, "gt_risk_violations");

			// New (paths + GT split)
			int idxBaseline = idxOptional(cols, "baseline_path");
			int idxAPrePath = idxOptional(cols, "purpose_pre_path"); // PRE (A)
			int idxBPrePath = idxOptional(cols, "risk_pre_path"); // PRE (B)
			int idxAPostPath = idxOptional(cols, "purpose_model_path"); // POST (A)
			int idxBPostPath = idxOptional(cols, "risk_model_path"); // POST (B)

			// GT split
			int idxGtUnrel = idxOptional(cols, "gt_purpose_unrelated");
			int idxGtSpec = idxOptional(cols, "gt_purpose_specialized");
			int idxGtRiskNew = idxOptional(cols, "gt_risk_violations");

			// Decide "new mode" strictly from required cols
			boolean hasNew = idxBaseline >= 0 && idxAPrePath >= 0 && idxBPrePath >= 0;

			// --- Output header (summary CSV) ---
			if (hasNew) {
				out.println(String.join(",",
						  "model_index","seed","DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents","TotalElements",
						  "A_xfm_avg_us","A_xfm_std_us","A_xfm_min_us","A_xfm_max_us","A_xfm_median_us",
						  "A_purpose_avg_us","A_purpose_std_us","A_purpose_min_us","A_purpose_max_us","A_purpose_median_us",
						  "A_risk_avg_us","A_risk_std_us","A_risk_min_us","A_risk_max_us","A_risk_median_us",
						  "A_joint_avg_us","A_joint_std_us","A_joint_min_us","A_joint_max_us","A_joint_median_us",
						  "B_xfm_avg_us","B_xfm_std_us","B_xfm_min_us","B_xfm_max_us","B_xfm_median_us",
						  "B_purpose_avg_us","B_purpose_std_us","B_purpose_min_us","B_purpose_max_us","B_purpose_median_us",
						  "B_risk_avg_us","B_risk_std_us","B_risk_min_us","B_risk_max_us","B_risk_median_us",
						  "B_joint_avg_us","B_joint_std_us","B_joint_min_us","B_joint_max_us","B_joint_median_us",
						  "iterations","gt_purpose_unrelated","gt_purpose_specialized","gt_risk_violations",
						  "TotalRelations", 
						  "baseline_path","A_pre_path","A_post_path","B_pre_path","B_post_path"
						));
			} else {
				out.println(String.join(",",
						  "model_index","seed","risk_model_path","DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents","TotalElements","gt_risk_violations",
						  "purpose_avg_us","purpose_std_us","purpose_min_us","purpose_max_us","purpose_median_us",
						  "risk_avg_us","risk_std_us","risk_min_us","risk_max_us","risk_median_us",
						  "joint_avg_us","joint_std_us","joint_min_us","joint_max_us","joint_median_us",
						  "iterations",
						  "TotalRelations"  
						));
			}

			// --- Raw samples header (gz CSV) ---
			raw.println(String.join(",",
					  "model_index","seed","scenario","phase","rep","micros",
					  "DS","PD","Functions","Components","Vulnerabilities","Purposes","Consents","TotalElements",
					  "gt_purpose_unrelated","gt_purpose_specialized","gt_risk_violations",
					  "baseline_path","A_pre_path","A_post_path","B_pre_path","B_post_path","risk_model_path",
					  "TotalRelations"
					));

			// --- Iterate rows ---
			String line;
			while ((line = reader.readLine()) != null) {
				if (line.isBlank())
					continue;
				String[] f = splitCsvLine(line, cols.length);

				int modelIndex = parseIntSafe(getOr(f, idxModel, "0"), 0);
				long seed = parseLongSafe(getOr(f, idxSeed, "0"), 0L);

				if (!hasNew) {
					// ========== OLD MODE (no transforms benchmarked) ==========
					int gtRisk = parseIntSafe(getOr(f, idxGtRisk, "0"), 0);
					if (gtRisk <= 0)
						continue; // original filter

					String riskPath = getOr(f, idxRiskPath, "");
					long ds = parseLongSafe(getOr(f, idxDS, "0"), 0L);
					long pd = parseLongSafe(getOr(f, idxPD, "0"), 0L);
					long fn = parseLongSafe(getOr(f, idxFN, "0"), 0L);
					long comp = parseLongSafe(getOr(f, idxC, "0"), 0L);
					long vuln = parseLongSafe(getOr(f, idxV, "0"), 0L);
					long purp = parseLongSafe(getOr(f, idxP, "0"), 0L);
					long cons = parseLongSafe(getOr(f, idxCONS, "0"), 0L);
					long total = parseLongSafe(getOr(f, idxTot, "0"), 0L);

					Resource res = loadXmi(riskPath, spec.ecorePath);
					EObject root = res.getContents().get(0);
					
					var size = CASAOfflineConsentAnalyzer.computeModelSize(root);
					long relTotal = size.totalRelations;

					DescriptiveStatistics purposeStats = new DescriptiveStatistics();
					DescriptiveStatistics riskStats = new DescriptiveStatistics();
					DescriptiveStatistics jointStats = new DescriptiveStatistics();

					for (int rep = 0; rep < spec.warmup + spec.iterations; rep++) {
						Stopwatch swPurpose = Stopwatch.createStarted();
						var purposeResult = analyzer.runPurposeOnly(root);
						swPurpose.stop();
						long microsPurpose = swPurpose.elapsed(TimeUnit.MICROSECONDS);

						boolean skipRisk = purposeResult != null && purposeResult.isViolated(); // <-- key line
						long microsRisk = 0L;

						if (!skipRisk) {
							Stopwatch swRisk = Stopwatch.createStarted();
							analyzer.runRiskOnly(root, purposeResult);
							swRisk.stop();
							microsRisk = swRisk.elapsed(TimeUnit.MICROSECONDS);
						}
						long microsJoint = microsPurpose + microsRisk;

						if (rep >= spec.warmup) {
							int r = rep - spec.warmup;
							purposeStats.addValue(microsPurpose);
							if (!skipRisk)
								riskStats.addValue(microsRisk);
							jointStats.addValue(microsJoint);

							// raw rows (always write purpose & joint; write risk=0 if skipped)
							writeRaw(raw, modelIndex, seed, "OLD", "purpose", r, microsPurpose, ds, pd, fn, comp, vuln,
									purp, cons, total, 0, 0, gtRisk, "", "", "", "", "", riskPath, relTotal);

							writeRaw(raw, modelIndex, seed, "OLD", "risk", r, microsRisk, // 0 if skipped
									ds, pd, fn, comp, vuln, purp, cons, total, 0, 0, gtRisk, "", "", "", "", "",
									riskPath, relTotal);

							writeRaw(raw, modelIndex, seed, "OLD", "joint", r, microsJoint, ds, pd, fn, comp, vuln,
									purp, cons, total, 0, 0, gtRisk, "", "", "", "", "", riskPath, relTotal);
						}
					}

					out.printf(
							  "%d,%d,%s,%d,%d,%d,%d,%d,%d,%d,%d,%d," +
							  "%.3f,%.3f,%.3f,%.3f,%.3f," +   // purpose
							  "%.3f,%.3f,%.3f,%.3f,%.3f," +   // risk
							  "%.3f,%.3f,%.3f,%.3f,%.3f," +   // joint
							  "%d,%d%n",
							  modelIndex, seed, riskPath, ds, pd, fn, comp, vuln, purp, cons, total, gtRisk,
							  m(purposeStats.getMean()), m(purposeStats.getStandardDeviation()), m(purposeStats.getMin()), m(purposeStats.getMax()), m(purposeStats.getPercentile(50)),
							  m(riskStats.getMean()), m(riskStats.getStandardDeviation()), m(riskStats.getMin()), m(riskStats.getMax()), m(riskStats.getPercentile(50)),
							  m(jointStats.getMean()), m(jointStats.getStandardDeviation()), m(jointStats.getMin()), m(jointStats.getMax()), m(jointStats.getPercentile(50)),
							  jointStats.getN(), relTotal
							);

					continue;
				}

				String basePath = getOr(f, idxBaseline, "");
				String aPrePath = getOr(f, idxAPrePath, "");
				String aPostPath = getOr(f, idxAPostPath, "");
				String bPrePath = getOr(f, idxBPrePath, "");
				String bPostPath = getOr(f, idxBPostPath, "");

				int gtUnrel = parseIntSafe(getOr(f, idxGtUnrel, "0"), 0);
				int gtSpec = parseIntSafe(getOr(f, idxGtSpec, "0"), 0);
				int gtRiskN = parseIntSafe(getOr(f, idxGtRiskNew, "0"), 0);

				long ds = parseLongSafe(getOr(f, idxDS, null), Long.MIN_VALUE);
				long pd = parseLongSafe(getOr(f, idxPD, null), Long.MIN_VALUE);
				long fn = parseLongSafe(getOr(f, idxFN, null), Long.MIN_VALUE);
				long comp = parseLongSafe(getOr(f, idxC, null), Long.MIN_VALUE);
				long vuln = parseLongSafe(getOr(f, idxV, null), Long.MIN_VALUE);
				long purp = parseLongSafe(getOr(f, idxP, null), Long.MIN_VALUE);
				long cons = parseLongSafe(getOr(f, idxCONS, null), Long.MIN_VALUE);
				long total = parseLongSafe(getOr(f, idxTot, null), Long.MIN_VALUE);
				
				// Load PRE resources
				Resource resApre = loadXmi(aPrePath, spec.ecorePath);
				Resource resBpre = loadXmi(bPrePath, spec.ecorePath);

				// Always compute relSummary from baseline
				long relSummary;
				{
				    Resource resBase = loadXmi(basePath, spec.ecorePath);
				    var s = CASAOfflineConsentAnalyzer.computeModelSize(resBase.getContents().get(0));
				    relSummary = s.totalRelations;

				    // If sizes missing in manifest, fill them from baseline now
				    if (ds == Long.MIN_VALUE || total == Long.MIN_VALUE) {
				        ds = s.dataSubjects;
				        pd = s.personalData;
				        fn = s.functions;
				        comp = s.components;
				        vuln = s.vulnerabilities;
				        purp = s.purposes;
				        cons = s.consents;
				        total = s.totalEObjects;
				    }
				}

				// Timers (A/B): transform + purpose + risk + joint
				DescriptiveStatistics A_xfm = new DescriptiveStatistics();
				DescriptiveStatistics A_pur = new DescriptiveStatistics();
				DescriptiveStatistics A_risk = new DescriptiveStatistics();
				DescriptiveStatistics A_join = new DescriptiveStatistics();

				DescriptiveStatistics B_xfm = new DescriptiveStatistics();
				DescriptiveStatistics B_pur = new DescriptiveStatistics();
				DescriptiveStatistics B_risk = new DescriptiveStatistics();
				DescriptiveStatistics B_join = new DescriptiveStatistics();

				boolean regen = "regen".equalsIgnoreCase(spec.transformMode) || !fileExists(aPostPath)
						|| !fileExists(bPostPath);

				for (int rep = 0; rep < spec.warmup + spec.iterations; rep++) {
					// ---------- Scenario A (purpose) ----------
					Resource resApost;
					long tAxfm = 0L;
					if (regen) {
						Resource forTransform = cloneToNewSet(resApre);
						Stopwatch sw = Stopwatch.createStarted();
						var outA = analyzer.runTransformOnly(forTransform, gtUnrel, gtSpec, 0, spec.maxSetSize,
								spec.maxComponents, spec.maxVulns, spec.extraPurposesMin, spec.extraPurposesMax, seed);
						sw.stop();
						tAxfm = sw.elapsed(TimeUnit.MICROSECONDS);
						resApost = outA;
					} else {
						resApost = loadXmi(aPostPath, spec.ecorePath);
					}

					EObject rootA = resApost.getContents().get(0);
					long relA = CASAOfflineConsentAnalyzer.computeModelSize(rootA).totalRelations;

					// Purpose
					Stopwatch swAp = Stopwatch.createStarted();
					var pr = analyzer.runPurposeOnly(rootA);
					swAp.stop();
					long tAp = swAp.elapsed(TimeUnit.MICROSECONDS);

					// Skip risk if purpose violated
					boolean skipRiskA = pr != null && pr.isViolated();
					long tAr = 0L;
					if (!skipRiskA) {
						Stopwatch swAr = Stopwatch.createStarted();
						analyzer.runRiskOnly(rootA, pr);
						swAr.stop();
						tAr = swAr.elapsed(TimeUnit.MICROSECONDS);
					}

					long tAj = tAp + tAr;

					if (rep >= spec.warmup) {
						int r = rep - spec.warmup;
						if (regen) {
							A_xfm.addValue(tAxfm);
							writeRaw(raw, modelIndex, seed, "A", "transform", r, tAxfm, ds, pd, fn, comp, vuln, purp,
									cons, total, gtUnrel, gtSpec, gtRiskN, basePath, aPrePath, aPostPath, bPrePath,
									bPostPath, "", relA);
						}
						A_pur.addValue(tAp);
						if (!skipRiskA)
							A_risk.addValue(tAr); // don’t add skipped
						A_join.addValue(tAj);

						writeRaw(raw, modelIndex, seed, "A", "purpose", r, tAp, ds, pd, fn, comp, vuln, purp, cons,
								total, gtUnrel, gtSpec, gtRiskN, basePath, aPrePath, aPostPath, bPrePath, bPostPath,
								"", relA);
						writeRaw(raw, modelIndex, seed, "A", "risk", r, tAr, // 0 if skipped
								ds, pd, fn, comp, vuln, purp, cons, total, gtUnrel, gtSpec, gtRiskN, basePath, aPrePath,
								aPostPath, bPrePath, bPostPath, "", relA);
						writeRaw(raw, modelIndex, seed, "A", "joint", r, tAj, ds, pd, fn, comp, vuln, purp, cons, total,
								gtUnrel, gtSpec, gtRiskN, basePath, aPrePath, aPostPath, bPrePath, bPostPath, "", relA);
					}

					// ---------- Scenario B (risk) ----------
					Resource resBpost;
					long tBxfm = 0L;
					if (regen) {
						Resource forTransform = cloneToNewSet(resBpre);
						Stopwatch sw = Stopwatch.createStarted();
						var outB = analyzer.runTransformOnly(forTransform, 0, 0, gtRiskN, spec.maxSetSize,
								spec.maxComponents, spec.maxVulns, spec.extraPurposesMin, spec.extraPurposesMax, seed);
						sw.stop();
						tBxfm = sw.elapsed(TimeUnit.MICROSECONDS);
						resBpost = outB;

					} else {
						resBpost = loadXmi(bPostPath, spec.ecorePath);
					}

					EObject rootB = resBpost.getContents().get(0);
					long relB = CASAOfflineConsentAnalyzer.computeModelSize(rootB).totalRelations;

					// Purpose first (gate for risk)
					Stopwatch swBp = Stopwatch.createStarted();
					var prB = analyzer.runPurposeOnly(rootB);
					swBp.stop();
					long tBp = swBp.elapsed(TimeUnit.MICROSECONDS);

					// Skip risk if purpose violated in B
					boolean skipRiskB = prB != null && prB.isViolated();
					long tBr = 0L;
					if (!skipRiskB) {
						Stopwatch swBr = Stopwatch.createStarted();
						analyzer.runRiskOnly(rootB, prB);
						swBr.stop();
						tBr = swBr.elapsed(TimeUnit.MICROSECONDS);
					}

					long tBj = tBp + tBr;

					if (rep >= spec.warmup) {
						int r = rep - spec.warmup;
						if (regen) {
							B_xfm.addValue(tBxfm);
							writeRaw(raw, modelIndex, seed, "B", "transform", r, tBxfm, ds, pd, fn, comp, vuln, purp,
									cons, total, gtUnrel, gtSpec, gtRiskN, basePath, aPrePath, aPostPath, bPrePath,
									bPostPath, "", relB);
						}
						B_pur.addValue(tBp);
						if (!skipRiskB)
							B_risk.addValue(tBr); // don’t add skipped
						B_join.addValue(tBj);

						writeRaw(raw, modelIndex, seed, "B", "purpose", r, tBp, ds, pd, fn, comp, vuln, purp, cons,
								total, gtUnrel, gtSpec, gtRiskN, basePath, aPrePath, aPostPath, bPrePath, bPostPath,
								"", relB);
						writeRaw(raw, modelIndex, seed, "B", "risk", r, tBr, // 0 if skipped
								ds, pd, fn, comp, vuln, purp, cons, total, gtUnrel, gtSpec, gtRiskN, basePath, aPrePath,
								aPostPath, bPrePath, bPostPath, "", relB);
						writeRaw(raw, modelIndex, seed, "B", "joint", r, tBj, ds, pd, fn, comp, vuln, purp, cons, total,
								gtUnrel, gtSpec, gtRiskN, basePath, aPrePath, aPostPath, bPrePath, bPostPath, "", relB);
					}
				}

				// Emit one CSV row per structure (model_index)
				out.printf("%d,%d," + "%d,%d,%d,%d,%d,%d,%d,%d," +
					    // A_xfm ... A_joint
					    "%.3f,%.3f,%.3f,%.3f,%.3f," +
					    "%.3f,%.3f,%.3f,%.3f,%.3f," +
					    "%.3f,%.3f,%.3f,%.3f,%.3f," +
					    "%.3f,%.3f,%.3f,%.3f,%.3f," +
					    // B_xfm ... B_joint
					    "%.3f,%.3f,%.3f,%.3f,%.3f," +
					    "%.3f,%.3f,%.3f,%.3f,%.3f," +
					    "%.3f,%.3f,%.3f,%.3f,%.3f," +
					    "%.3f,%.3f,%.3f,%.3f,%.3f," +
					    // iterations, GTs, TotalRelations, paths
					    "%d,%d,%d,%d,%d,%s,%s,%s,%s,%s%n",
					    modelIndex, seed,
					    ds, pd, fn, comp, vuln, purp, cons, total,
					    stat(A_xfm.getMean()), stat(A_xfm.getStandardDeviation()), stat(A_xfm.getMin()), stat(A_xfm.getMax()), stat(A_xfm.getPercentile(50)),
					    stat(A_pur.getMean()), stat(A_pur.getStandardDeviation()), stat(A_pur.getMin()), stat(A_pur.getMax()), stat(A_pur.getPercentile(50)),
					    stat(A_risk.getMean()), stat(A_risk.getStandardDeviation()), stat(A_risk.getMin()), stat(A_risk.getMax()), stat(A_risk.getPercentile(50)),
					    stat(A_join.getMean()), stat(A_join.getStandardDeviation()), stat(A_join.getMin()), stat(A_join.getMax()), stat(A_join.getPercentile(50)),
					    stat(B_xfm.getMean()), stat(B_xfm.getStandardDeviation()), stat(B_xfm.getMin()), stat(B_xfm.getMax()), stat(B_xfm.getPercentile(50)),
					    stat(B_pur.getMean()), stat(B_pur.getStandardDeviation()), stat(B_pur.getMin()), stat(B_pur.getMax()), stat(B_pur.getPercentile(50)),
					    stat(B_risk.getMean()), stat(B_risk.getStandardDeviation()), stat(B_risk.getMin()), stat(B_risk.getMax()), stat(B_risk.getPercentile(50)),
					    stat(B_join.getMean()), stat(B_join.getStandardDeviation()), stat(B_join.getMin()), stat(B_join.getMax()), stat(B_join.getPercentile(50)),
					    A_join.getN(),
					    gtUnrel, gtSpec, gtRiskN,
					    relSummary,          
					    safeStr(basePath), safeStr(aPrePath), safeStr(aPostPath), safeStr(bPrePath), safeStr(bPostPath)
					);
			}
		}
	}

	// -------------------- utils --------------------

	private static int idxOptional(String[] header, String name) {
		for (int i = 0; i < header.length; i++)
			if (name.equals(header[i]))
				return i;
		return -1;
	}

	private static String getOr(String[] row, int idx, String def) {
		if (idx < 0 || idx >= row.length)
			return def;
		return row[idx];
	}

	private static String[] splitCsvLine(String line, int expectCols) {
		String[] f = line.split(",", -1);
		if (f.length < expectCols) {
			String[] g = new String[expectCols];
			System.arraycopy(f, 0, g, 0, f.length);
			for (int i = f.length; i < expectCols; i++)
				g[i] = "";
			return g;
		}
		return f;
	}

	private static int parseIntSafe(String s, int def) {
		try {
			return Integer.parseInt(s);
		} catch (Exception e) {
			return def;
		}
	}

	private static long parseLongSafe(String s, Long def) {
		if (s == null)
			return def;
		try {
			return Long.parseLong(s);
		} catch (Exception e) {
			return def;
		}
	}

	private static String safeStr(String s) {
		return s == null ? "" : s;
	}

	private static double m(double v) {
		return Double.isFinite(v) ? v : 0.0;
	}

	private static double stat(double v) {
		return Double.isFinite(v) ? v : 0.0;
	}

	private static boolean fileExists(String p) {
		try {
			return p != null && !p.isBlank() && Files.exists(Paths.get(p));
		} catch (Exception e) {
			return false;
		}
	}

	private static Resource cloneToNewSet(Resource src) {
		org.eclipse.emf.ecore.resource.ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
		rs.getPackageRegistry().put(CASA.CASAPackage.eINSTANCE.getNsURI(), CASA.CASAPackage.eINSTANCE);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
				org.eclipse.emf.ecore.resource.Resource.Factory.Registry.DEFAULT_EXTENSION,
				new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
		Resource dst = rs.createResource(URI.createURI("memory:/clone.xmi"));
		@SuppressWarnings("unchecked")
		java.util.Collection<org.eclipse.emf.ecore.EObject> copies = org.eclipse.emf.ecore.util.EcoreUtil
				.copyAll(src.getContents());
		dst.getContents().addAll(copies);
		return dst;
	}

	private static Resource loadXmi(String path, String ecorePath) {
		try {
			CasaModelGenerator dummy = new CasaModelGenerator(new CasaModelGenerator.Config());
			dummy.loadEcore(URI.createFileURI(new File(ecorePath).getAbsolutePath()));
			org.eclipse.emf.ecore.resource.ResourceSet rs = new org.eclipse.emf.ecore.resource.impl.ResourceSetImpl();
			rs.getPackageRegistry().put(CASA.CASAPackage.eINSTANCE.getNsURI(), CASA.CASAPackage.eINSTANCE);
			rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(
					org.eclipse.emf.ecore.resource.Resource.Factory.Registry.DEFAULT_EXTENSION,
					new org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl());
			Resource r = rs.getResource(URI.createFileURI(new File(path).getAbsolutePath()), true);
			r.load(null);
			return r;
		} catch (Exception e) {
			throw new RuntimeException("Failed to load XMI: " + path, e);
		}
	}

	/** CSV-escape a string if needed. */
	private static String csv(String s) {
		if (s == null)
			return "";
		boolean need = s.contains(",") || s.contains("\"") || s.contains("\n") || s.contains("\r");
		if (!need)
			return s;
		return "\"" + s.replace("\"", "\"\"") + "\"";
	}

	/** Write one raw-sample row into the gzipped CSV. */
	private static void writeRaw(
		    PrintWriter raw, int modelIndex, long seed, String scenario, String phase, int rep,
		    long micros, long ds, long pd, long fn, long comp, long vuln, long purp, long cons, long total,
		    int gtUnrel, int gtSpec, int gtRisk,
		    String basePath, String aPre, String aPost, String bPre, String bPost, String riskPath,
		    long totalRelations
		) {
		    raw.println(
		      modelIndex + "," + seed + "," + csv(scenario) + "," + csv(phase) + "," + rep + "," + micros + "," +
		      ds + "," + pd + "," + fn + "," + comp + "," + vuln + "," + purp + "," + cons + "," + total + "," +
		      gtUnrel + "," + gtSpec + "," + gtRisk + "," +
		      csv(basePath) + "," + csv(aPre) + "," + csv(aPost) + "," + csv(bPre) + "," + csv(bPost) + "," + csv(riskPath) + "," +
		      totalRelations
		    );
		}
	
	private static String slurp(Path p) {
	    try { return Files.readString(p, StandardCharsets.UTF_8); }
	    catch (IOException e) { return null; }
	}

	private static String extractString(String json, String key) {
	    if (json == null) return null;
	    java.util.regex.Matcher m = java.util.regex.Pattern
	        .compile("\"" + java.util.regex.Pattern.quote(key) + "\"\\s*:\\s*\"([^\"]+)\"")
	        .matcher(json);
	    return m.find() ? m.group(1) : null;
	}

	private static Integer extractInt(String json, String key) {
	    if (json == null) return null;
	    java.util.regex.Matcher m = java.util.regex.Pattern
	        .compile("\"" + java.util.regex.Pattern.quote(key) + "\"\\s*:\\s*([-+]?[0-9]+)")
	        .matcher(json);
	    return m.find() ? Integer.valueOf(m.group(1)) : null;
	}

	private static Long extractLong(String json, String key) {
	    if (json == null) return null;
	    java.util.regex.Matcher m = java.util.regex.Pattern
	        .compile("\"" + java.util.regex.Pattern.quote(key) + "\"\\s*:\\s*([-+]?[0-9]+)")
	        .matcher(json);
	    return m.find() ? Long.valueOf(m.group(1)) : null;
	}

	private static CASARisk.EstimationMode parseModeOrNull(String s) {
	    if (s == null) return null;
	    try { return CASARisk.EstimationMode.valueOf(s.trim()); }
	    catch (IllegalArgumentException ex) { return null; }
	}

	private CASAOfflineConsentAnalyzer.RiskEngineConfig loadRiskConfig(Spec s) {
	    // Defaults match CASAOfflineConsentAnalyzer() no-arg constructor
	    CASARisk.EstimationMode mode = CASARisk.EstimationMode.AUTO;
	    int mcSamples = 20_000;
	    long mcSeed = 1234L;
	    int exhaustiveMax = 15;

	    // Locate experiment_config.json next to the manifest, unless overridden
	    Path configPath;
	    if (s.experimentConfigPath != null && !s.experimentConfigPath.isBlank()) {
	        configPath = Paths.get(s.experimentConfigPath);
	    } else {
	        Path manifest = Paths.get(s.manifestPath);
	        Path parent = manifest.getParent() != null ? manifest.getParent() : manifest.toAbsolutePath().getParent();
	        configPath = parent != null ? parent.resolve("experiment_config.json") : Paths.get("experiment_config.json");
	    }

	    String json = Files.exists(configPath) ? slurp(configPath) : null;
	    if (json != null) {
	        CASARisk.EstimationMode m = parseModeOrNull(extractString(json, "riskEstimationMode"));
	        Integer smp = extractInt(json, "riskMcSamples");
	        Long sd = extractLong(json, "riskMcSeed");
	        Integer ex = extractInt(json, "riskExhaustiveMaxVulns");

	        if (m != null) mode = m;
	        if (smp != null) mcSamples = smp;
	        if (sd != null) mcSeed = sd;
	        if (ex != null) exhaustiveMax = ex;
	    }

	    // Apply explicit benchmark overrides if provided
	    if (s.riskEstimationModeOverride != null) mode = s.riskEstimationModeOverride;
	    if (s.riskMcSamplesOverride != null) mcSamples = s.riskMcSamplesOverride;
	    if (s.riskMcSeedOverride != null) mcSeed = s.riskMcSeedOverride;
	    if (s.riskExhaustiveMaxVulnsOverride != null) exhaustiveMax = s.riskExhaustiveMaxVulnsOverride;

	    return new CASAOfflineConsentAnalyzer.RiskEngineConfig(mode, mcSamples, mcSeed, exhaustiveMax);
	}

}
