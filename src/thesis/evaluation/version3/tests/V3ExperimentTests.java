package thesis.evaluation.version3.tests;

import thesis.CASAPurposeTests;
import thesis.CASAPurposeConsentRulesTests;
import thesis.CASAPurposeModelTests;
import thesis.CASARiskTests;
import thesis.CASARiskConsentRulesTests;
import thesis.FirstNonViolatingTests;
import thesis.evaluation.version3.me.CasaModelMapperV3Tests;
import thesis.evaluation.version3.me.CvssCatalogV3Tests;
import thesis.evaluation.version3.me.ManagedElementInstantiatorTestsV3;
import thesis.evaluation.version3.me.RulePrunerV3Tests;
import thesis.evaluation.version3.me.SpecSamplerTestsV3;
import thesis.evaluation.version3.apply.TransformationApplicatorV3Tests;
import thesis.evaluation.version3.result_evaluation.ManagedElementArtifactProjectorV3Tests;
import thesis.evaluation.version3.result_evaluation.OfflineResultAnalyzerV3Tests;
import thesis.evaluation.version3.result_evaluation.ProspectiveModelComparatorV3Tests;
import thesis.evaluation.version3.result_evaluation.ResultEvaluationRunnerV3Tests;
import thesis.evaluation.version3.sa.HenshinTransformationMapperV3Tests;
import thesis.evaluation.version3.sa.HenshinTransformationWriterV3Tests;
import thesis.evaluation.version3.sa.PurposeSemanticsV3Tests;
import thesis.evaluation.version3.sa.SelfAdaptationCombinationTestsV3;
import thesis.evaluation.version3.sa.SelfAdaptationInstantiatorTestsV3;
import thesis.evaluation.version3.sa.SelfAdaptationOracleRebuilderV3Tests;
import thesis.evaluation.version3.sa.SelfAdaptationSpecSamplerTestsV3;
import thesis.evaluation.version3.sa.SourceManagedElementAdapterTestsV3;
import thesis.evaluation.version3.sa.SelfAdaptationValidatorV3Tests;

public final class V3ExperimentTests {
    private V3ExperimentTests() {
    }

    public static void runAll() {
        runGroup("me.SpecSampler", SpecSamplerTestsV3::runAll);
        runGroup("me.ManagedElementInstantiator", ManagedElementInstantiatorTestsV3::runAll);
        runGroup("me.CasaModelMapperV3", CasaModelMapperV3Tests::runAll);
        runGroup("me.RulePrunerV3", RulePrunerV3Tests::runAll);
        runGroup("me.CvssCatalogV3", CvssCatalogV3Tests::runAll);
        runGroup("thesis.FirstNonViolating", FirstNonViolatingTests::runAll);
        runGroup("thesis.CASAPurposeConsentRules", CASAPurposeConsentRulesTests::runAll);
        runGroup("thesis.CASAPurposeModel", CASAPurposeModelTests::runAll);
        runGroup("thesis.CASAPurpose", CASAPurposeTests::runAll);
        runGroup("thesis.CASARiskConsentRules", CASARiskConsentRulesTests::runAll);
        runGroup("thesis.CASARisk", CASARiskTests::runAll);
        runGroup("sa.SelfAdaptationCombination", SelfAdaptationCombinationTestsV3::runAll);
        runGroup("sa.SelfAdaptationSpecSampler", SelfAdaptationSpecSamplerTestsV3::runAll);
        runGroup("sa.SelfAdaptationInstantiator", SelfAdaptationInstantiatorTestsV3::runAll);
        runGroup("sa.SelfAdaptationValidatorV3", SelfAdaptationValidatorV3Tests::runAll);
        runGroup("sa.SourceManagedElementAdapter", SourceManagedElementAdapterTestsV3::runAll);
        runGroup("sa.SelfAdaptationOracleRebuilderV3", SelfAdaptationOracleRebuilderV3Tests::runAll);
        runGroup("sa.HenshinTransformationMapperV3", HenshinTransformationMapperV3Tests::runAll);
        runGroup("sa.HenshinTransformationWriterV3", HenshinTransformationWriterV3Tests::runAll);
        runGroup("sa.PurposeSemanticsV3", PurposeSemanticsV3Tests::runAll);
        runGroup("apply.TransformationApplicatorV3", TransformationApplicatorV3Tests::runAll);
        runGroup("result.ManagedElementArtifactProjectorV3", ManagedElementArtifactProjectorV3Tests::runAll);
        runGroup("result.ProspectiveModelComparatorV3", ProspectiveModelComparatorV3Tests::runAll);
        runGroup("result.OfflineResultAnalyzerV3", OfflineResultAnalyzerV3Tests::runAll);
        runGroup("result.ResultEvaluationRunnerV3", ResultEvaluationRunnerV3Tests::runAll);
        System.out.println("[v3_tests] DONE   class-oriented experiment tests passed");
    }

    private static void runGroup(String groupName, Runnable group) {
        System.out.println("[v3_tests] GROUP  " + groupName);
        group.run();
        System.out.println("[v3_tests] OK     " + groupName);
    }
}
