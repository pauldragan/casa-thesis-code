package thesis.evaluation.version3.sa;

import java.util.Map;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class SelfAdaptationSpecSamplerTestsV3 {
    private SelfAdaptationSpecSamplerTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.SelfAdaptationSpecSampler.samplesViolationRequestsForViolationCases",
                SelfAdaptationSpecSamplerTestsV3::samplesViolationRequestsForViolationCases);
        TestSupportV3.run("sa.SelfAdaptationSpecSampler.respectsCaseAddCounts",
                SelfAdaptationSpecSamplerTestsV3::respectsCaseAddCounts);
    }

    private static void samplesViolationRequestsForViolationCases() {
        SelfAdaptationSpecSampler sampler = new SelfAdaptationSpecSampler(SelfAdaptationGenerationConfig.tiny());
        SourceManagedElementProfile profile = profile();

        SelfAdaptationSpec afp = sampler.sample(profile, 0, 1, 1L, 2L);
        SelfAdaptationSpec acr = sampler.sample(profile, 0, 15, 1L, 16L);

        TestSupportV3.check(afp.requestedPurposeViolations > 0, "afp should request purpose violations");
        TestSupportV3.check(acr.requestedRiskViolations > 0, "acr should request risk violations");
    }

    private static void respectsCaseAddCounts() {
        SelfAdaptationSpecSampler sampler = new SelfAdaptationSpecSampler(SelfAdaptationGenerationConfig.tiny());
        SourceManagedElementProfile profile = profile();

        SelfAdaptationSpec afsAfp = sampler.sample(profile, 0, 2, 1L, 3L);
        SelfAdaptationSpec acsAcr = sampler.sample(profile, 0, 24, 1L, 25L);

        TestSupportV3.check(afsAfp.addFunctionCount >= 2, "afs_afp should sample at least one safe and one violating function");
        TestSupportV3.check(acsAcr.addComponentCount >= 2, "acs_acr should sample at least one safe and one risky component");
    }

    private static SourceManagedElementProfile profile() {
        return new SourceManagedElementProfile("me_000000", 3, 8, 8,
                Map.of("FUploadVideo", 2, "FStreamVideo", 2, "FRemoveVideo", 2, "FComments", 2),
                Map.of("CNginx", 2, "CExpressJS", 2, "CPostgresql", 1, "CAngularSPA", 1, "CRedis", 1, "CFilesystem", 1));
    }
}
