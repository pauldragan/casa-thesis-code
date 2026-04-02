package thesis;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.apache.commons.math3.stat.descriptive.DescriptiveStatistics;

import com.google.common.base.Stopwatch;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import thesis.CASABase.CASABenchDecisionResult;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
class PhaseStats {
	private Double avg; // microseconds
	private Double var;
	private Double std;
	private Double median;
	private Double max;
	private Double min;
}

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
class BenchmarkResult {
	private PhaseStats transform;
	private PhaseStats purpose;
	private PhaseStats risk;
	private PhaseStats joint; // purpose + risk (like the other runner)
	private Long iterations; // number of post-warmup samples
}

public class CASAScalabilityTester {
	private static final Logger logger = LoggerFactory.getLogger(CASAScalabilityTester.class);

	enum TestMode {
		SERVERS, VULNERABILITIES, PURPOSES, FUNCTIONS, DATASUBJECTS, PURPOSESCONSENT, CONSENT, PERSONALDATA
	}

	public static class Spec {
		public int warmupIterations = 100; // replaces WARMUPITERATIONS
		public int iterations = 500;
		public double startDimmer = 0.25;
		public double dimmerStep = 0.25;
		public String purposeOwlPath = "src/resources/casa-swim-purpose-model-scalability.owx";

		// --- Risk engine config (same knobs as elsewhere)
		public CASARisk.EstimationMode riskEstimationMode = CASARisk.EstimationMode.AUTO;
		public int riskMcSamples = 20_000;
		public long riskMcSeed = 1234L;
		public int riskExhaustiveMaxVulns = 15;
	}

	private final Spec spec;

	public CASAScalabilityTester() {
		this(new Spec());
	}

	public CASAScalabilityTester(Spec spec) {
		this.spec = spec;
	}

	private static final class RuntimeCtx {
		final CASABase casa;
		final CASARuntimeModel model;

		RuntimeCtx(CASABase c, CASARuntimeModel m) {
			this.casa = c;
			this.model = m;
		}
	}

	private SWIMReceivedStruct getReceivedStruct(int startServers, double startDimmer, double dimmerStep) {
		SWIMObservation obs = new SWIMObservation(0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0, 0.0, 0, false, 0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0, 0.0, 0.0);
		obs.servers = startServers;
		obs.active_servers = startServers;
		obs.dimmer_step = dimmerStep;
		obs.current_dimmer = startDimmer;
		SWIMReceivedStruct state = new SWIMReceivedStruct(obs, 0.0);
		return state;
	}

	private CASABase initialize(TestMode mode, SWIMReceivedStruct startState) {
		// Purpose model
		CASAPurpose casaPurpose = new CASAPurpose(spec.purposeOwlPath);

		// Risk with configured mode/params
		CASARisk casaRisk = new CASARisk().setMode(spec.riskEstimationMode).setMcSamples(spec.riskMcSamples)
				.setMcSeed(spec.riskMcSeed).setExhaustiveMaxVulns(spec.riskExhaustiveMaxVulns);

		// Updaters (unchanged)
		CASARMDimmerUpdaterBase dimmerUpdater;
		CASARMServerUpdaterBase serverUpdater;

		switch (mode) {
		case SERVERS -> {
			serverUpdater = new CASARMServerUpdaterComponents();
			dimmerUpdater = new CASARMDimmerUpdaterNothing();
		}
		case VULNERABILITIES -> {
			serverUpdater = new CASARMServerUpdaterVulnerabilities();
			dimmerUpdater = new CASARMDimmerUpdaterNothing();
		}
		case DATASUBJECTS -> {
			serverUpdater = new CASARMServerUpdaterDatasubjects();
			dimmerUpdater = new CASARMDimmerUpdaterNothing();
		}
		case FUNCTIONS -> {
			serverUpdater = new CASARMServerUpdaterFunctions();
			dimmerUpdater = new CASARMDimmerUpdaterNothing();
		}
		case PURPOSESCONSENT -> {
			serverUpdater = new CASARMServerUpdaterPurposes("AddPurposeConsent", "RemovePurposeConsent",
					"IdentifyPurposeInstance");
			dimmerUpdater = new CASARMDimmerUpdaterNothing();
		}
		case PURPOSES -> {
			serverUpdater = new CASARMServerUpdaterPurposes("AddPurpose", "RemovePurpose", "IdentifyPurposeInstance");
			dimmerUpdater = new CASARMDimmerUpdaterNothing();
		}
		case CONSENT -> {
			serverUpdater = new CASARMServerUpdaterPurposes("AddConsent", "RemoveConsent", "IdentifyConsentInstance");
			dimmerUpdater = new CASARMDimmerUpdaterNothing();
		}
		case PERSONALDATA -> {
			serverUpdater = new CASARMServerUpdaterPurposes("AddPersonalData", "RemovePersonalData",
					"IdentifyPersonalDataInstance");
			dimmerUpdater = new CASARMDimmerUpdaterNothing();
		}
		default -> throw new RuntimeException("Unknown tester mode.");
		}

		CASARuntimeModel model = new CASARuntimeModel("CASA_scalability_base_1.xmi", dimmerUpdater, serverUpdater);

		// Bring model to starting point of the experiment
		model.update(startState);

		CASABase casa = new CASABase(model, casaPurpose, casaRisk);
		return casa;
	}

	private CASABenchDecisionResult runIteration(CASABase casa, SWIMReceivedStruct state, SWIMAdaptation adaptation) {
		return casa.analyzeAdaptationWithBenchmark(state, adaptation);
	}

	private BenchmarkResult benchmark(CASABase casa, SWIMReceivedStruct state, SWIMAdaptation adaptation,
			long iterations, int warmUpIterations) {
		DescriptiveStatistics statsTransform = new DescriptiveStatistics();
		DescriptiveStatistics statsPurpose = new DescriptiveStatistics();
		DescriptiveStatistics statsRisk = new DescriptiveStatistics();
		DescriptiveStatistics statsJoint = new DescriptiveStatistics();

		for (int i = 0; i < iterations + warmUpIterations; i++) {

			Stopwatch sw = Stopwatch.createStarted();
			CASABenchDecisionResult casaResult = this.runIteration(casa, state, adaptation);
			sw.stop();
			if (i >= warmUpIterations) {
				statsTransform.addValue(casaResult.elapsedTransform);
				statsPurpose.addValue(casaResult.elapsedPurpose);
				statsRisk.addValue(casaResult.elapsedRisk);
				statsJoint.addValue(sw.elapsed(TimeUnit.MICROSECONDS));
			}
		}

		BenchmarkResult result = new BenchmarkResult();

		result.setTransform(summarize(statsTransform));
		result.setPurpose(summarize(statsPurpose));
		result.setRisk(summarize(statsRisk));
		result.setJoint(summarize(statsJoint));
		result.setIterations(statsJoint.getN());

		return result;
	}

	public Map<TestMode, Map<Integer, BenchmarkResult>> runAllScalabilityTest(int variableUpperBound, int iterations) {
		Map<TestMode, Map<Integer, BenchmarkResult>> results = new HashMap<>();
		for (TestMode mode : TestMode.values()) {
			Map<Integer, BenchmarkResult> result = runScalabilityTest(mode, variableUpperBound, iterations);
			results.put(mode, result);
		}
		return results;
	}

	public Map<Integer, BenchmarkResult> runScalabilityTest(TestMode mode, int variableUpperBound, int iterations) {
		Map<Integer, BenchmarkResult> results = new HashMap<>();
		for (int i = 1; i <= variableUpperBound; i++) {
			SWIMReceivedStruct startState = getReceivedStruct(i, spec.startDimmer, spec.dimmerStep);
			CASABase casa = this.initialize(mode, startState);

			SWIMAdaptation adaptation = new SWIMAdaptation(true, false, spec.startDimmer);
			BenchmarkResult result = benchmark(casa, startState, adaptation, iterations, spec.warmupIterations);

			results.put(i, result);
			logger.info("Benchmark result: " + result);
		}
		return results;
	}

	public static <T> void writeResultsToCSV(T mode, Map<Integer, BenchmarkResult> results, String path,
			boolean append) {
		try (FileWriter writer = new FileWriter(path, append)) {
			if (!append) {
				writer.append(String.join(",", "Mode", "Scale", "Iter", "XfmAvg", "XfmVar", "XfmStd", "XfmMin",
						"XfmMax", "XfmMed", "PurAvg", "PurVar", "PurStd", "PurMin", "PurMax", "PurMed", "RiskAvg",
						"RiskVar", "RiskStd", "RiskMin", "RiskMax", "RiskMed", "JointAvg", "JointVar", "JointStd",
						"JointMin", "JointMax", "JointMed")).append('\n');
			}

			for (Map.Entry<Integer, BenchmarkResult> e : results.entrySet()) {
				int scale = e.getKey();
				BenchmarkResult r = e.getValue();

				PhaseStats x = r.getTransform();
				PhaseStats p = r.getPurpose();
				PhaseStats rk = r.getRisk();
				PhaseStats j = r.getJoint();

				String row = String.join(",", String.valueOf(mode), String.valueOf(scale),
						String.valueOf(r.getIterations() == null ? 0 : r.getIterations()),
// Xfm
						d(x.getAvg()), d(x.getVar()), d(x.getStd()), d(x.getMin()), d(x.getMax()), d(x.getMedian()),
// Pur
						d(p.getAvg()), d(p.getVar()), d(p.getStd()), d(p.getMin()), d(p.getMax()), d(p.getMedian()),
// Risk
						d(rk.getAvg()), d(rk.getVar()), d(rk.getStd()), d(rk.getMin()), d(rk.getMax()),
						d(rk.getMedian()),
// Joint
						d(j.getAvg()), d(j.getVar()), d(j.getStd()), d(j.getMin()), d(j.getMax()), d(j.getMedian()));

				writer.append(row).append('\n');
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}
	
    private static String d(Double v) { return v == null ? "0" : v.toString(); }

	private static PhaseStats summarize(DescriptiveStatistics s) {
		PhaseStats ps = new PhaseStats();
		ps.setAvg(Double.isFinite(s.getMean()) ? s.getMean() : 0.0);
		ps.setVar(Double.isFinite(s.getVariance()) ? s.getVariance() : 0.0);
		ps.setStd(Double.isFinite(s.getStandardDeviation()) ? s.getStandardDeviation() : 0.0);
		ps.setMedian(Double.isFinite(s.getPercentile(50)) ? s.getPercentile(50) : 0.0);
		ps.setMax(Double.isFinite(s.getMax()) ? s.getMax() : 0.0);
		ps.setMin(Double.isFinite(s.getMin()) ? s.getMin() : 0.0);
		return ps;
	}
}
