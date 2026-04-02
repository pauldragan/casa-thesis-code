package thesis;

import java.io.File;
import java.io.IOException;
import java.util.Map;

import org.semanticweb.HermiT.Reasoner;
import org.semanticweb.owlapi.apibinding.OWLManager;
import org.semanticweb.owlapi.formats.FunctionalSyntaxDocumentFormat;
import org.semanticweb.owlapi.model.IRI;
import org.semanticweb.owlapi.model.OWLClass;
import org.semanticweb.owlapi.model.OWLDataFactory;
import org.semanticweb.owlapi.model.OWLOntology;
import org.semanticweb.owlapi.model.OWLOntologyCreationException;
import org.semanticweb.owlapi.model.OWLOntologyManager;
import org.semanticweb.owlapi.model.OWLOntologyStorageException;
import org.semanticweb.owlapi.reasoner.Node;
import org.semanticweb.owlapi.reasoner.NodeSet;
import org.semanticweb.owlapi.reasoner.OWLReasoner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import thesis.evaluation.version3.apply.GenerateAppliedSelfAdaptationsV3;
import thesis.evaluation.version3.dataset_evaluation.GenerateManagedElementDatasetEvaluationV3;
import thesis.evaluation.version3.dataset_evaluation.GenerateSelfAdaptationDatasetEvaluationV3;
import thesis.evaluation.version3.me.GenerateManagedElementsV3;
import thesis.evaluation.version3.benchmark.GenerateScalabilityBenchmarkV3;
import thesis.evaluation.version3.sa.GenerateSelfAdaptationsV3;
import thesis.evaluation.version3.result_evaluation.GenerateResultEvaluationV3;
import thesis.evaluation.version3.tests.V3ExperimentTests;

import thesis.CASAScalabilityTester.TestMode;
import thesis.CASAAdaptationGenerator;

import org.semanticweb.owlapi.model.IRI;

public class Thesis {
	private static final Logger logger = LoggerFactory.getLogger(Thesis.class);

	public static void main(String[] args) {
//		CASARuntimeModel mdl = new CASARuntimeModel("CASA_transformed.xmi", new CASARMDimmerUpdaterNothing(),
//					new CASARMServerUpdaterNothing());
//		
//		boolean vald = mdl.validateSelf();
//		logger.info("Validation result: " + vald);
//		

		Args myArgs = new Args();

		JCommander.newBuilder().addObject(myArgs).build().parse(args);

		logger.info("Hello world!");
		logger.info("Commandline args: " + myArgs.toString());

		StatsCollector collector = StatsCollector.getInstance();

		// CASAPurposeModel purposeModel = new
		// CASAPurposeModel("src/resources/casa-swim-purpose-model.owx");
		// CASAPurposeModel.PurposeRelation result =
		// purposeModel.calculatePurposeRelation("LocationTargetedAds", "Profiling");
		// System.out.println("Relation: " + result);

		// CASAPurpose casaPurpose = new CASAPurpose();
		// casaPurpose.test();

		// CASARisk casaRisk = new CASARisk();

		// TcpSocketClient client = new TcpSocketClient("localhost", 60396);
		// System.out.println(client.initialize());
		// client.close();

//		OWLOntologyManager manager = OWLManager.createOWLOntologyManager();
//		OWLOntology ontology = null;
//		try {
//			File owx = new File("src/resources/casa-swim-purpose-model.owx");
//			ontology = manager.loadOntologyFromOntologyDocument(owx);
//	        OWLReasoner reasoner = new Reasoner.ReasonerFactory().createReasoner(ontology);
//	        OWLDataFactory dataFactory = manager.getOWLDataFactory();
//	        // Node<OWLClass> myClass = reasoner.getTopClassNode();
//	        // NodeSet<OWLClass> classes = reasoner.getSubClasses(myClass.getEntities().iterator().next(), false);
//	        
//	        OWLClass myClass = dataFactory.getOWLClass(IRI.create("http://www.semanticweb.org/paul/ontologies/2025/1/casa-swim-purpose-model#Marketing"));
//	        NodeSet<OWLClass> classes = reasoner.getSubClasses(myClass, false);
//	        
//	        for (OWLClass c : classes.entities().toList()) {
//	        	System.out.println("Class: " + c);
//	        }
//	        
//	        
//		} catch (OWLOntologyCreationException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		try {
//			ontology.saveOntology(new FunctionalSyntaxDocumentFormat(), System.out);
//		} catch (OWLOntologyStorageException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		// use the default swim adaptation manager without CASA
		if (myArgs.configType.equals("swim")) {
			logger.info("Running experiment with default SWIM adaptation manager.");
			CASAPurpose casaPurpose = new CASAPurpose();
			CASARisk casaRisk = new CASARisk();

//			CASARuntimeModel runtimeModel = new CASARuntimeModel("CASA.xmi", new CASARMDimmerUpdaterChangePurpose(),
//					new CASARMServerUpdaterNothing());
			CASARuntimeModel runtimeModel = new CASARuntimeModel("CASA_server.xmi", new CASARMDimmerUpdaterNothing(),
					new CASARMServerUpdaterComponents());

			TcpSocketServer server = new TcpSocketServer("localhost", 60397);

			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					if (server.close() != TcpSocketServer.STATUS.CLOSE_ERROR) {
						logger.error("Error closing server.");
					}
				}
			});

			CASABase casa = new CASABase(runtimeModel, casaPurpose, casaRisk);
			casa.disable();

			SWIMAdaptationManagerBase manager = new SWIMDefaultReactiveAdaptationManagerV2(casa);
			server.subscribe(manager);

			logger.info(server.initialize().toString());

		} else if (myArgs.configType.equals("swim_check")) {
			logger.info("Running experiment with default SWIM adaptation manager with CASA checking.");
			CASAPurpose casaPurpose = new CASAPurpose();
			CASARisk casaRisk = new CASARisk();

			String modelFileName = "CASA.xmi";
			switch (myArgs.purposeExperiment) {
			case 3:
				modelFileName = "CASA_both_3.xmi";
				break;
			default:
				throw new RuntimeException(
						"CASA Both with purpose experiment=" + myArgs.purposeExperiment + " is not known!");
			}

			CASARuntimeModel runtimeModel = new CASARuntimeModel(modelFileName, new CASARMDimmerUpdaterChangePurpose(),
					new CASARMServerUpdaterComponentsCycledVulnerabilities());

			TcpSocketServer server = new TcpSocketServer("localhost", 60397);

			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					if (server.close() != TcpSocketServer.STATUS.CLOSE_ERROR) {
						logger.error("Error closing server.");
					}
				}
			});

			CASABase casa = new CASABase(runtimeModel, casaPurpose, casaRisk);

			SWIMAdaptationManagerBase manager = new SWIMDefaultReactiveAdaptationManagerV2(casa);
			manager.ignoreCASADecision();

			server.subscribe(manager);

			logger.info(server.initialize().toString());

		}
		// use the random exclusion of self-adaptations
		else if (myArgs.configType.equals("random")) {
			TcpSocketServer server = new TcpSocketServer("localhost", 60397);

			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					if (server.close() != TcpSocketServer.STATUS.CLOSE_ERROR) {
						logger.error("Error closing server.");
					}
				}
			});

			CASABase casa = new CASARandom(myArgs.probability);

			// SWIMDefaultReactiveAdaptationManager manager = new
			// SWIMDefaultReactiveAdaptationManager(casa);
			SWIMAdaptationManagerBase manager = new SWIMDefaultReactiveAdaptationManagerV2(casa);

			server.subscribe(manager);

			logger.info(server.initialize().toString());
		}
		// use CASA only for risk-related violations
		else if (myArgs.configType.equals("risk")) {
			CASAPurpose casaPurpose = new CASAPurpose();
			CASARisk casaRisk = new CASARisk();

			CASARuntimeModel runtimeModel = new CASARuntimeModel("CASA_server.xmi", new CASARMDimmerUpdaterNothing(),
					new CASARMServerUpdaterComponentsCycledVulnerabilities());

			TcpSocketServer server = new TcpSocketServer("localhost", 60397);

			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					if (server.close() != TcpSocketServer.STATUS.CLOSE_ERROR) {
						logger.error("Error closing server.");
					}
				}
			});

			CASABase casa = new CASABase(runtimeModel, casaPurpose, casaRisk);

			// SWIMDefaultReactiveAdaptationManager manager = new
			// SWIMDefaultReactiveAdaptationManager(casa);
			SWIMAdaptationManagerBase manager = new SWIMDefaultReactiveAdaptationManagerV2(casa);
			if (myArgs.checkSwimOnly) {
				manager.ignoreCASADecision();
			}

			server.subscribe(manager);

			logger.info(server.initialize().toString());
		}
		// use CASA only for purpose-related violations
		else if (myArgs.configType.equals("purpose")) {
			logger.info("Running experiment with CASA Purpose; purpose experiment=" + myArgs.purposeExperiment);
			CASAPurpose casaPurpose = new CASAPurpose();
			CASARisk casaRisk = new CASARisk();

			String modelFileName = "CASA.xmi";
			switch (myArgs.purposeExperiment) {
			case 0:
				modelFileName = "CASA_purpose_0.xmi";
				break;
			case 1:
				modelFileName = "CASA_purpose_1.xmi";
				break;
			case 2:
				modelFileName = "CASA_purpose_2.xmi";
				break;
			case 3:
				modelFileName = "CASA_purpose_3.xmi";
				break;
			case 4:
				modelFileName = "CASA_purpose_4.xmi";
				break;
			case 5:
				modelFileName = "CASA_purpose_5.xmi";
				break;
			default:
				throw new RuntimeException("CASA Purpose experiment=" + myArgs.purposeExperiment + " is not known!");
			}

			CASARuntimeModel runtimeModel = new CASARuntimeModel(modelFileName, new CASARMDimmerUpdaterChangePurpose(),
					new CASARMServerUpdaterNothing());

			TcpSocketServer server = new TcpSocketServer("localhost", 60397);

			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					if (server.close() != TcpSocketServer.STATUS.CLOSE_ERROR) {
						logger.error("Error closing server.");
					}
				}
			});

			CASABase casa = new CASABase(runtimeModel, casaPurpose, casaRisk);

			// SWIMDefaultReactiveAdaptationManager manager = new
			// SWIMDefaultReactiveAdaptationManager(casa);
			SWIMAdaptationManagerBase manager = new SWIMDefaultReactiveAdaptationManagerV2(casa);
			if (myArgs.checkSwimOnly) {
				manager.ignoreCASADecision();
			}
			server.subscribe(manager);

			logger.info(server.initialize().toString());

		}
		// use CASA for both purpose and risk related violations
		else if (myArgs.configType.equals("both")) {
			logger.info("Running experiment with CASA Both; purpose experiment=" + myArgs.purposeExperiment);
			CASAPurpose casaPurpose = new CASAPurpose();
			CASARisk casaRisk = new CASARisk();

			String modelFileName = "CASA.xmi";
			switch (myArgs.purposeExperiment) {
			case 1:
				modelFileName = "CASA_both_1.xmi";
				break;
			case 3:
				modelFileName = "CASA_both_3.xmi";
				break;
			default:
				throw new RuntimeException(
						"CASA Both with purpose experiment=" + myArgs.purposeExperiment + " is not known!");
			}

			CASARuntimeModel runtimeModel = new CASARuntimeModel(modelFileName, new CASARMDimmerUpdaterChangePurpose(),
					new CASARMServerUpdaterComponentsCycledVulnerabilities());

			TcpSocketServer server = new TcpSocketServer("localhost", 60397);

			Runtime.getRuntime().addShutdownHook(new Thread() {
				public void run() {
					if (server.close() != TcpSocketServer.STATUS.CLOSE_ERROR) {
						logger.error("Error closing server.");
					}
				}
			});

			CASABase casa = new CASABase(runtimeModel, casaPurpose, casaRisk);

			// SWIMDefaultReactiveAdaptationManager manager = new
			// SWIMDefaultReactiveAdaptationManager(casa);
			SWIMAdaptationManagerBase manager = new SWIMDefaultReactiveAdaptationManagerV2(casa);
			if (myArgs.checkSwimOnly) {
				manager.ignoreCASADecision();
			}
			server.subscribe(manager);

			logger.info(server.initialize().toString());

		} else if (myArgs.configType.equals("complex_test")) {
			logger.info("Running hard-coded 'complex' configuration …");

			// --- hard-coded generation setup ---
			CasaModelGenerator.Config cfg = new CasaModelGenerator.Config();
			cfg.numDataSubjects = 6;
			cfg.personalDataPerSubject = 5;
			cfg.numFuncPersData = 5;
			cfg.numComponents = 4;
			cfg.componentsPerFunction = 7;
			cfg.vulnsPerComponent = 3;
			cfg.functionsPerPersonalData = 1;
			cfg.purposeMismatchUnrelated = 0;
			cfg.purposeMismatchSpecialized = 0;
			cfg.riskViolations = 2;
			cfg.seed = 20251013L;

			// one fixed CVSS for all vulnerabilities
			CasaModelGenerator.CVSSPreset p = new CasaModelGenerator.CVSSPreset();
			p.attackVector = "Network";
			p.attackComplexity = "Low";
			p.scope = "Unchanged";
			p.privilegesRequired = "None";
			p.userInteraction = "None";
			p.exploitCodeMaturity = "Functional";
			p.reportConfidence = "Confirmed";
			p.confidentialityImpact = "High";
			p.integrityImpact = "High";
			p.availabilityImpact = "High";
			p.remediationLevel = "TemporaryFix";
			p.confidentialityRequirement = "Medium";
			p.integrityRequirement = "Medium";
			p.availabilityRequirement = "Medium";
			cfg.cvssPreset = p;

			// paths
			String ecorePath = "src/thesis/CASA.ecore"; // adjust if in a subfolder
			String outDir = "./out"; // will contain model.xmi
			new File(outDir).mkdirs();

			try {
				CasaModelGenerator gen = new CasaModelGenerator(cfg);
				org.eclipse.emf.common.util.URI ecoreURI = org.eclipse.emf.common.util.URI
						.createFileURI(new File(ecorePath).getAbsolutePath());
				String outFileName = "CASA_Complex_Test.xmi"; // chosen name
				File outFile = new File(outDir, outFileName);
				org.eclipse.emf.common.util.URI outURI = org.eclipse.emf.common.util.URI
						.createFileURI(outFile.getAbsolutePath());

				gen.loadEcore(ecoreURI);
				org.eclipse.emf.ecore.resource.Resource res = gen.generate(outURI);
				res.save(null);

				logger.info("Generated model written to: {}", res.getURI().toFileString());

				// quick summary
				org.eclipse.emf.ecore.EObject system = res.getContents().get(0);
				int ds = sizeOf(system, "dataSubjects");
				int pd = sizeOf(system, "datas");
				int fn = sizeOf(system, "functions");
				int cp = sizeOf(system, "components");
				int vu = sizeOf(system, "vulnerabilities");
				int pu = sizeOf(system, "purposes");
				logger.info(
						"Model summary → DataSubjects={}, PersonalData={}, FuncPersData={}, Components={}, Vulnerabilities={}, Purposes={}",
						ds, pd, fn, cp, vu, pu);

				// analyze in-memory
				CASAOfflineConsentAnalyzer offline = new CASAOfflineConsentAnalyzer();
				CASAOfflineConsentAnalyzer.Result ar = offline.analyzeResource(res);

				logger.info("CASA purpose OK? {}", ar.purposeOK);
				logger.info("CASA risk OK? {}", ar.riskOK);
				logger.info("CASA final reason: {}", ar.reason);

			} catch (Exception e) {
				logger.error("Error during generation", e);
			}
		} else if (myArgs.configType.equals("complex_scalability")) {
			// First, assume you already ran the experiments with
			// CASAConsentExperimentsRunner
			CASAConsentBenchmarkRunner.Spec b = new CASAConsentBenchmarkRunner.Spec();
			b.modelsDir = "./out/models_experiment"; // must match the runner
			b.manifestPath = "./out/models_experiment/exp_1760629280061/index.csv"; // produced by the runner
			b.benchCsvPath = "./out/exp_1760629280061/benchmark_results.csv";
			b.ecorePath = "src/thesis/CASA.ecore";
			b.warmup = 20;
			b.iterations = 100;

			try {
				new CASAConsentBenchmarkRunner(b).run();
			} catch (Exception e) {
				logger.error("Benchmark failed", e);
			}
		}
		
		else if (myArgs.configType.equals("complex_transform_scalability")) {
			// First, assume you already ran the experiments with
			// CASAConsentExperimentsRunner
			CASAConsentBenchmarkRunner.Spec b = new CASAConsentBenchmarkRunner.Spec();
			b.modelsDir = "./out/models_experiment"; // must match the runner
			b.manifestPath = "./out/models_experiment/try_1/exp_transform_1761479363669_xfm/index.csv"; // produced by the runner
			b.benchCsvPath = "./out/models_experiment/try_1/exp_transform_1761479363669_xfm/benchmark_results.csv";
			b.ecorePath = "src/thesis/CASA.ecore";
			b.rawSamplesPath = "./out/models_experiment/try_1/exp_transform_1761479363669_xfm/benchmark_results.csv.gz";
			b.warmup = 20;
			b.iterations = 300;
			b.transformMode = "regen";

			try {
				new CASAConsentBenchmarkRunner(b).run();
			} catch (Exception e) {
				logger.error("Benchmark failed", e);
			}
		}

		else if (myArgs.configType.equals("complex_transform")) {
		    CASAConsentExperimentsRunner.Spec spec = new CASAConsentExperimentsRunner.Spec();
		    spec.totalModels = 500;
		    spec.baseSeed = 20251022L;
		    spec.ecorePath = "src/thesis/CASA.ecore";
		    spec.outModelsRoot = "./out/models_experiment/try_1";
		    spec.runId = "exp_transform_" + System.currentTimeMillis();

		    // structure bounds (example)
		    spec.numDataSubjects        = new CASAConsentExperimentsRunner.IntBounds(1, 30);
		    spec.personalDataPerSubject = new CASAConsentExperimentsRunner.IntBounds(1, 10);
		    spec.numFuncPersData        = new CASAConsentExperimentsRunner.IntBounds(1, 30);
		    spec.numComponents          = new CASAConsentExperimentsRunner.IntBounds(5, 100);
		    spec.componentsPerFunction  = new CASAConsentExperimentsRunner.IntBounds(1, 5);
		    spec.vulnsPerComponent      = new CASAConsentExperimentsRunner.IntBounds(0, 0);
		    spec.functionsPerPersonalData = new CASAConsentExperimentsRunner.IntBounds(1, 5);
		    spec.riskGroupSize = new CASAConsentExperimentsRunner.IntBounds(1, 5);   // group 2–4 PDs per risk function
		    spec.riskComponents = new CASAConsentExperimentsRunner.IntBounds(1, 5);  // 1–3 components per risk function
		    spec.riskVulns = new CASAConsentExperimentsRunner.IntBounds(1, 5);       // 1–2 vulnerabilities per component
		    
		    spec.nonViolatingPurposesPerFunction = new CASAConsentExperimentsRunner.IntBounds(1, 5);

		    // how many violations to inject (sampled per model from these bounds)
		    spec.purposeMismatchUnrelated = new CASAConsentExperimentsRunner.IntBounds(0, 10);
		    spec.purposeMismatchSpecial   = new CASAConsentExperimentsRunner.IntBounds(0, 10);
		    spec.riskViolations           = new CASAConsentExperimentsRunner.IntBounds(0, 10);
		    
		    spec.extraPurposesPerFunction = new CASAConsentExperimentsRunner.IntBounds(0, 5);
		    spec.disabledVulnsPerComponent = new CASAConsentExperimentsRunner.IntBounds(0, 5);
		    
		    spec.riskEstimationMode = CASARisk.EstimationMode.MONTE_CARLO; // or EXHAUSTIVE / AUTO
		    spec.riskMcSamples = 50_000;
		    spec.riskMcSeed = 20251024L;
		    spec.riskExhaustiveMaxVulns = 18;

		    try {
				new CASAConsentExperimentsRunner(spec).runUsingTransformations();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



			else if (myArgs.configType.equals("scalability")) {
			int iterations = myArgs.scalabilityIterations;
			final int SCALE = 64; // however only 16 is allowed for purposes
			final String CSVPATH = "../swim_results/scalability_results_newversion_2.csv";
			
			CASAScalabilityTester.Spec spec = new CASAScalabilityTester.Spec();
			spec.warmupIterations = 100;
			spec.iterations       = myArgs.scalabilityIterations;
			spec.startDimmer      = 0.25;
			spec.dimmerStep       = 0.25;
			spec.purposeOwlPath   = "src/resources/casa-swim-purpose-model-scalability.owx";
			spec.riskEstimationMode = CASARisk.EstimationMode.EXHAUSTIVE;
			CASAScalabilityTester scalabilityTester = new CASAScalabilityTester(spec);
				
			CASAScalabilityTester.Spec specExh = new CASAScalabilityTester.Spec();
			specExh.warmupIterations = spec.warmupIterations;
			specExh.iterations       = spec.iterations;
			specExh.startDimmer      = spec.startDimmer;
			specExh.dimmerStep       = spec.dimmerStep;
			specExh.purposeOwlPath   = spec.purposeOwlPath;
			specExh.riskEstimationMode = CASARisk.EstimationMode.EXHAUSTIVE;

			CASAScalabilityTester.Spec specMc = new CASAScalabilityTester.Spec();
			specMc.warmupIterations = spec.warmupIterations;
			specMc.iterations       = spec.iterations;
			specMc.startDimmer      = spec.startDimmer;
			specMc.dimmerStep       = spec.dimmerStep;
			specMc.purposeOwlPath   = spec.purposeOwlPath;
			specMc.riskEstimationMode = CASARisk.EstimationMode.MONTE_CARLO;
			specMc.riskMcSamples      = 100;
			specMc.riskMcSeed         = 1234L;
			
			CASAScalabilityTester.Spec specMc1k = new CASAScalabilityTester.Spec();
			specMc1k.warmupIterations = spec.warmupIterations;
			specMc1k.iterations       = spec.iterations;
			specMc1k.startDimmer      = spec.startDimmer;
			specMc1k.dimmerStep       = spec.dimmerStep;
			specMc1k.purposeOwlPath   = spec.purposeOwlPath;
			specMc1k.riskEstimationMode = CASARisk.EstimationMode.MONTE_CARLO;
			specMc1k.riskMcSamples      = 1000;
			specMc1k.riskMcSeed         = 1234L;

			CASAScalabilityTester.Spec specMc10k = new CASAScalabilityTester.Spec();
			specMc10k.warmupIterations = spec.warmupIterations;
			specMc10k.iterations       = spec.iterations;
			specMc10k.startDimmer      = spec.startDimmer;
			specMc10k.dimmerStep       = spec.dimmerStep;
			specMc10k.purposeOwlPath   = spec.purposeOwlPath;
			specMc10k.riskEstimationMode = CASARisk.EstimationMode.MONTE_CARLO;
			specMc10k.riskMcSamples      = 10000;
			specMc10k.riskMcSeed         = 1234L;
			
			CASAScalabilityTester.Spec specMc20k = new CASAScalabilityTester.Spec();
			specMc20k.warmupIterations = spec.warmupIterations;
			specMc20k.iterations       = spec.iterations;
			specMc20k.startDimmer      = spec.startDimmer;
			specMc20k.dimmerStep       = spec.dimmerStep;
			specMc20k.purposeOwlPath   = spec.purposeOwlPath;
			specMc20k.riskEstimationMode = CASARisk.EstimationMode.MONTE_CARLO;
			specMc20k.riskMcSamples      = 20000;
			specMc20k.riskMcSeed         = 1234L;
			
			CASAScalabilityTester.Spec specMc40k = new CASAScalabilityTester.Spec();
			specMc40k.warmupIterations = spec.warmupIterations;
			specMc40k.iterations       = spec.iterations;
			specMc40k.startDimmer      = spec.startDimmer;
			specMc40k.dimmerStep       = spec.dimmerStep;
			specMc40k.purposeOwlPath   = spec.purposeOwlPath;
			specMc40k.riskEstimationMode = CASARisk.EstimationMode.MONTE_CARLO;
			specMc40k.riskMcSamples      = 40000;
			specMc40k.riskMcSeed         = 1234L;

			CASAScalabilityTester testerExh = new CASAScalabilityTester(specExh);
			CASAScalabilityTester testerMc  = new CASAScalabilityTester(specMc);
			CASAScalabilityTester testerMc20k  = new CASAScalabilityTester(specMc20k);
			CASAScalabilityTester testerMc10k  = new CASAScalabilityTester(specMc10k);
			CASAScalabilityTester testerMc1k  = new CASAScalabilityTester(specMc1k);
			CASAScalabilityTester testerMc40k  = new CASAScalabilityTester(specMc40k);


			Map<Integer, BenchmarkResult> results = null;

//			results = scalabilityTester.runScalabilityTest(TestMode.PURPOSES, SCALE, iterations);
//			CASAScalabilityTester.writeResultsToCSV("purposes", results, CSVPATH, true);

			//// Dummy run to get Eclipse hot and running
			//// ////////////////////////////////////////
			results = scalabilityTester.runScalabilityTest(TestMode.FUNCTIONS, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("functions", results, CSVPATH, false);
			//////////////////////////////////////////////////////////////////////////////////////

			results = scalabilityTester.runScalabilityTest(TestMode.FUNCTIONS, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("functions", results, CSVPATH, false);

			results = scalabilityTester.runScalabilityTest(TestMode.DATASUBJECTS, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("data subjects", results, CSVPATH, true);

			results = scalabilityTester.runScalabilityTest(TestMode.PURPOSES, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("purposes", results, CSVPATH, true);

			results = scalabilityTester.runScalabilityTest(TestMode.PURPOSESCONSENT, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("purposes & consent", results, CSVPATH, true);

			results = scalabilityTester.runScalabilityTest(TestMode.CONSENT, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("consent", results, CSVPATH, true);

			results = scalabilityTester.runScalabilityTest(TestMode.PERSONALDATA, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("personal data", results, CSVPATH, true);

			results = scalabilityTester.runScalabilityTest(TestMode.SERVERS, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("servers", results, CSVPATH, true);

			results = scalabilityTester.runScalabilityTest(TestMode.VULNERABILITIES, 16, iterations);
			CASAScalabilityTester.writeResultsToCSV("vulnerabilities(ex)", results, CSVPATH, true);
			
			results = testerMc.runScalabilityTest(TestMode.VULNERABILITIES, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("vulnerabilities(mc1s)", results, CSVPATH, true);
			
			results = testerMc20k.runScalabilityTest(TestMode.VULNERABILITIES, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("vulnerabilities(mc20ks)", results, CSVPATH, true);
			
			results = testerMc40k.runScalabilityTest(TestMode.VULNERABILITIES, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("vulnerabilities(mc40ks)", results, CSVPATH, true);
			
			results = testerMc10k.runScalabilityTest(TestMode.VULNERABILITIES, SCALE, iterations);
			CASAScalabilityTester.writeResultsToCSV("vulnerabilities(mc10ks)", results, CSVPATH, true);
			
				results = testerMc1k.runScalabilityTest(TestMode.VULNERABILITIES, SCALE, iterations);
				CASAScalabilityTester.writeResultsToCSV("vulnerabilities(mc1ks)", results, CSVPATH, true);
			} else if (myArgs.configType.equals("v3_smoke")) {
				logger.info("Running v3 smoke generation: count={}, seed={}, out={}, xmi={}, graphml={}, prune={}, resume={}, tiny={}",
						myArgs.v3Count, myArgs.v3Seed, myArgs.v3Out, myArgs.v3Xmi, myArgs.v3GraphMl, myArgs.v3Prune, myArgs.v3Resume, myArgs.v3Tiny);
				try {
					GenerateManagedElementsV3.run(
							myArgs.v3Count,
							myArgs.v3Seed,
							myArgs.v3Out,
							myArgs.v3Xmi,
							myArgs.v3GraphMl,
							myArgs.v3Prune,
							myArgs.v3Resume,
							myArgs.v3Tiny);
				} catch (Exception e) {
					logger.error("v3 smoke generation failed", e);
				}
			} else if (myArgs.configType.equals("v3_sa_smoke")) {
				logger.info("Running v3 self-adaptation smoke generation: modelCount={}, seed={}, out={}, pruneSource={}, resume={}, tiny={}",
						myArgs.v3SaModelCount, myArgs.v3SaSeed, myArgs.v3SaOut, myArgs.v3SaPruneSource, myArgs.v3Resume, myArgs.v3Tiny);
				try {
					GenerateSelfAdaptationsV3.runSmoke(
							myArgs.v3SaModelCount,
							myArgs.v3SaSeed,
							myArgs.v3SaOut,
							myArgs.v3SaPruneSource,
							myArgs.v3Resume,
							myArgs.v3Tiny);
				} catch (Exception e) {
					logger.error("v3 self-adaptation smoke generation failed", e);
				}
			} else if (myArgs.configType.equals("v3_apply_smoke")) {
				logger.info("Running v3 self-adaptation application smoke generation: modelCount={}, seed={}, out={}, pruneSource={}, resume={}, tiny={}",
						myArgs.v3ApplyModelCount, myArgs.v3ApplySeed, myArgs.v3ApplyOut, myArgs.v3ApplyPruneSource, myArgs.v3Resume, myArgs.v3Tiny);
				try {
					GenerateAppliedSelfAdaptationsV3.runSmoke(
							myArgs.v3ApplyModelCount,
							myArgs.v3ApplySeed,
							myArgs.v3ApplyOut,
							myArgs.v3ApplyPruneSource,
							myArgs.v3Resume,
							myArgs.v3Tiny);
				} catch (Exception e) {
					logger.error("v3 self-adaptation application smoke generation failed", e);
				}
			} else if (myArgs.configType.equals("v3_me_dataset_eval")) {
				logger.info("Running v3 managed-element dataset evaluation: in={}, out={}",
						myArgs.v3MeEvalIn, myArgs.v3MeEvalOut);
				try {
					GenerateManagedElementDatasetEvaluationV3.run(
							myArgs.v3MeEvalIn,
							myArgs.v3MeEvalOut);
				} catch (Exception e) {
					logger.error("v3 managed-element dataset evaluation failed", e);
				}
			} else if (myArgs.configType.equals("v3_sa_dataset_eval")) {
				logger.info("Running v3 self-adaptation dataset evaluation: in={}, out={}",
						myArgs.v3SaEvalIn, myArgs.v3SaEvalOut);
				try {
					GenerateSelfAdaptationDatasetEvaluationV3.run(
							myArgs.v3SaEvalIn,
							myArgs.v3SaEvalOut);
				} catch (Exception e) {
					logger.error("v3 self-adaptation dataset evaluation failed", e);
				}
			} else if (myArgs.configType.equals("v3_dataset_eval")) {
				logger.info("Running v3 full dataset evaluation: in={}, out={}",
						myArgs.v3DatasetEvalIn, myArgs.v3DatasetEvalOut);
				try {
					java.nio.file.Path datasetIn = java.nio.file.Path.of(myArgs.v3DatasetEvalIn);
					java.nio.file.Path datasetOut = java.nio.file.Path.of(myArgs.v3DatasetEvalOut);
					GenerateManagedElementDatasetEvaluationV3.run(
							datasetIn.resolve("managed_elements").toString(),
							datasetOut.resolve("managed_elements").toString());
					GenerateSelfAdaptationDatasetEvaluationV3.run(
							datasetIn.resolve("self_adaptations").toString(),
							datasetOut.resolve("self_adaptations").toString());
				} catch (Exception e) {
					logger.error("v3 full dataset evaluation failed", e);
				}
			} else if (myArgs.configType.equals("v3_result_eval")) {
				logger.info("Running v3 result evaluation: in={}, out={}, resume={}",
						myArgs.v3ResultEvalIn, myArgs.v3ResultEvalOut, myArgs.v3ResultEvalResume);
				try {
					GenerateResultEvaluationV3.run(
							myArgs.v3ResultEvalIn,
							myArgs.v3ResultEvalOut,
							myArgs.v3ResultEvalResume);
				} catch (Exception e) {
					logger.error("v3 result evaluation failed", e);
				}
			} else if (myArgs.configType.equals("v3_benchmark")) {
				logger.info(
						"Running v3 scalability benchmark: in={}, out={}, sampleCount={}, sampleSeed={}, warmup={}, repetitions={}",
						myArgs.v3BenchIn,
						myArgs.v3BenchOut,
						myArgs.v3BenchModelCount,
						myArgs.v3BenchSeed,
						myArgs.v3BenchWarmup,
						myArgs.v3BenchRepetitions);
				try {
					GenerateScalabilityBenchmarkV3.run(
							myArgs.v3BenchIn,
							myArgs.v3BenchOut,
							myArgs.v3BenchModelCount,
							myArgs.v3BenchSeed,
							myArgs.v3BenchWarmup,
							myArgs.v3BenchRepetitions);
				} catch (Exception e) {
					logger.error("v3 scalability benchmark failed", e);
				}
			} else if (myArgs.configType.equals("v3_tests")) {
				logger.info("Running v3 experiment tests");
				try {
					V3ExperimentTests.runAll();
					logger.info("v3 experiment tests passed");
				} catch (AssertionError e) {
					logger.error("v3 experiment tests failed: {}", e.getMessage(), e);
				} catch (Exception e) {
					logger.error("v3 experiment tests failed", e);
				}
			} else {
				throw new RuntimeException("Unrecognized configurations: " + myArgs.configType);
			}

	}
	
	@SuppressWarnings("rawtypes")
	private static java.util.Map xmiSaveOptions() {
	    java.util.Map<Object, Object> opts = new java.util.HashMap<>();
	    opts.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);
	    opts.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
	    opts.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
	    opts.put(org.eclipse.emf.ecore.xmi.XMLResource.OPTION_SAVE_ONLY_IF_CHANGED,
	             org.eclipse.emf.ecore.xmi.XMLResource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
	    return opts;
	}


	// helper to count many-valued features
	private static int sizeOf(org.eclipse.emf.ecore.EObject obj, String feature) {
		org.eclipse.emf.ecore.EStructuralFeature f = obj.eClass().getEStructuralFeature(feature);
		if (f == null)
			return 0;
		Object v = obj.eGet(f);
		if (v instanceof java.util.Collection<?>)
			return ((java.util.Collection<?>) v).size();
		return v == null ? 0 : 1;
	}

}
