package thesis;

import com.beust.jcommander.Parameter;

import lombok.ToString;

@ToString
public class Args {
	@Parameter(names = "-config", description = "swim, random, risk, purpose, both, scalability, complex, v3_smoke, v3_sa_smoke, v3_apply_smoke, v3_me_dataset_eval, v3_sa_dataset_eval, v3_dataset_eval, v3_result_eval, v3_benchmark, v3_tests")
	public String configType = "risk";
	
	@Parameter(names = "-prob", description = "Probability for random CASA.")
	public Double probability = 0.0;
	
	@Parameter(names = "-purpose", description = "Experiment for purpose CASA and both CASA.")
	public Integer purposeExperiment = 1;
	
	@Parameter(names = "-iterations", description = "Number of iterations for scalability experiment.")
	public Integer scalabilityIterations = 500;
	
	@Parameter(names = "-check-swim-only", description = "Ignores CASA decisions. Useful for calculating the consent violations of the SWIM default adaptation logic.")
	public boolean checkSwimOnly = false;
	
	@Parameter(names = "-v3-count", description = "Number of generated models for v3 smoke generation.")
	public Integer v3Count = 5;
	
	@Parameter(names = "-v3-seed", description = "Base seed for v3 smoke generation.")
	public Long v3Seed = 20260309L;
	
	@Parameter(names = "-v3-out", description = "Output folder for v3 smoke generation.")
	public String v3Out = "./out/models_experiment/version3_smoke";
	
	@Parameter(names = "-v3-graphml", description = "Export GraphML files for Cytoscape import in v3 smoke generation.")
	public boolean v3GraphMl = true;
	
	@Parameter(names = "-v3-prune", description = "Enable post-generation pruning in v3 smoke generation.")
	public boolean v3Prune = true;
	
	@Parameter(names = "-v3-xmi", description = "Export CASA XMI files in v3 smoke generation.")
	public boolean v3Xmi = true;

	@Parameter(names = "-v3-resume", description = "Resume v3 generation/application runs from existing outputs if present.")
	public boolean v3Resume = false;

	@Parameter(names = "-v3-sa-model-count", description = "Number of source managed elements for v3 self-adaptation smoke generation.")
	public Integer v3SaModelCount = 1;

	@Parameter(names = "-v3-sa-seed", description = "Base seed for v3 self-adaptation smoke generation.")
	public Long v3SaSeed = 20260311L;

	@Parameter(names = "-v3-sa-out", description = "Output folder for v3 self-adaptation smoke generation.")
	public String v3SaOut = "./out/models_experiment/version3_sa_smoke";

	@Parameter(names = "-v3-sa-prune-source", description = "Enable pruning for source managed elements in v3 self-adaptation smoke generation.")
	public boolean v3SaPruneSource = true;

	@Parameter(names = "-v3-apply-model-count", description = "Number of source managed elements for v3 application smoke generation.")
	public Integer v3ApplyModelCount = 1;

	@Parameter(names = "-v3-apply-seed", description = "Base seed for v3 application smoke generation.")
	public Long v3ApplySeed = 20260311L;

	@Parameter(names = "-v3-apply-out", description = "Output folder for v3 application smoke generation.")
	public String v3ApplyOut = "./out/models_experiment/version3_apply_smoke";

	@Parameter(names = "-v3-apply-prune-source", description = "Enable pruning for source managed elements in v3 application smoke generation.")
	public boolean v3ApplyPruneSource = true;

	@Parameter(names = "-v3-me-eval-in", description = "Input ME generation run root for v3 managed-element dataset evaluation.")
	public String v3MeEvalIn = "./out/models_experiment/version3_smoke";

	@Parameter(names = "-v3-me-eval-out", description = "Output folder for v3 managed-element dataset evaluation.")
	public String v3MeEvalOut = "./out/models_experiment/version3_me_dataset_evaluation";

	@Parameter(names = "-v3-sa-eval-in", description = "Input self-adaptation run root for v3 self-adaptation dataset evaluation.")
	public String v3SaEvalIn = "./out/models_experiment/version3_sa_smoke";

	@Parameter(names = "-v3-sa-eval-out", description = "Output folder for v3 self-adaptation dataset evaluation.")
	public String v3SaEvalOut = "./out/models_experiment/version3_sa_dataset_evaluation";

	@Parameter(names = "-v3-dataset-eval-in", description = "Input apply run root for full v3 dataset evaluation.")
	public String v3DatasetEvalIn = "./out/models_experiment/version3_apply_smoke";

	@Parameter(names = "-v3-dataset-eval-out", description = "Output root for full v3 dataset evaluation.")
	public String v3DatasetEvalOut = "./out/models_experiment/version3_dataset_evaluation";

	@Parameter(names = "-v3-result-eval-in", description = "Input v3 apply-run root for result evaluation.")
	public String v3ResultEvalIn = "./out/models_experiment/version3_apply_smoke";

	@Parameter(names = "-v3-result-eval-out", description = "Output folder for v3 result evaluation.")
	public String v3ResultEvalOut = "./out/models_experiment/version3_result_evaluation";

	@Parameter(names = "-v3-result-eval-resume", description = "Resume v3 result evaluation from an existing manifest if present.")
	public boolean v3ResultEvalResume = false;

	@Parameter(names = "-v3-tiny", description = "Use a tiny/debug profile for v3 generation and application runs. Alternate flow for manual inspection.")
	public boolean v3Tiny = false;

	@Parameter(names = "-v3-bench-in", description = "Input apply-run root for v3 scalability benchmark sampling.")
	public String v3BenchIn = "./out/models_experiment/version3_apply_smoke";

	@Parameter(names = "-v3-bench-out", description = "Output folder for v3 scalability benchmark results.")
	public String v3BenchOut = "./out/models_experiment/version3_scalability_benchmark";

	@Parameter(names = "-v3-bench-model-count", description = "Number of source managed elements sampled for v3 scalability benchmark.")
	public Integer v3BenchModelCount = 500;

	@Parameter(names = "-v3-bench-seed", description = "Random seed used for model sampling in v3 scalability benchmark.")
	public Long v3BenchSeed = 20260324L;

	@Parameter(names = "-v3-bench-warmup", description = "Warmup iterations per sampled model/case for v3 scalability benchmark.")
	public Integer v3BenchWarmup = 50;

	@Parameter(names = "-v3-bench-repetitions", description = "Measured repetitions per sampled model/case for v3 scalability benchmark.")
	public Integer v3BenchRepetitions = 100;
}
