package thesis.evaluation.version3.sa;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class SelfAdaptationGenerationConfig {
    static final String PROFILE_DEFAULT = "default";
    // Alternate flow for manual inspection.
    static final String PROFILE_TINY = "tiny";

    final long baseSeed;
    final int maxAddedFunctions;
    final int maxAddedComponents;
    final int maxAffectedByPerAddedComponent;
    final int minRealizedByPerAddedFunction;
    final int maxRealizedByPerAddedFunction;
    final int minProcessesPerAddedFunction;
    final int maxProcessesPerAddedFunction;
    final int minHasPurposePerAddedFunction;
    final int maxHasPurposePerAddedFunction;
    final int maxAttemptsPerCase;
    final int maxSourceModelRegenerations;
    final List<String> functionTypes;
    final List<String> mandatoryFunctionTypes;
    final List<String> componentTypes;
    final List<String> purposeTypes;
    final Map<String, List<String>> vulnerabilitiesByComponentType;
    final String profileName;

    SelfAdaptationGenerationConfig(
            long baseSeed,
            int maxAddedFunctions,
            int maxAddedComponents,
            int maxAffectedByPerAddedComponent,
            int minRealizedByPerAddedFunction,
            int maxRealizedByPerAddedFunction,
            int minProcessesPerAddedFunction,
            int maxProcessesPerAddedFunction,
            int minHasPurposePerAddedFunction,
            int maxHasPurposePerAddedFunction,
            int maxAttemptsPerCase,
            int maxSourceModelRegenerations,
            List<String> functionTypes,
            List<String> mandatoryFunctionTypes,
            List<String> componentTypes,
            List<String> purposeTypes,
            Map<String, List<String>> vulnerabilitiesByComponentType,
            String profileName) {
        this.baseSeed = baseSeed;
        this.maxAddedFunctions = maxAddedFunctions;
        this.maxAddedComponents = maxAddedComponents;
        this.maxAffectedByPerAddedComponent = maxAffectedByPerAddedComponent;
        this.minRealizedByPerAddedFunction = minRealizedByPerAddedFunction;
        this.maxRealizedByPerAddedFunction = maxRealizedByPerAddedFunction;
        this.minProcessesPerAddedFunction = minProcessesPerAddedFunction;
        this.maxProcessesPerAddedFunction = maxProcessesPerAddedFunction;
        this.minHasPurposePerAddedFunction = minHasPurposePerAddedFunction;
        this.maxHasPurposePerAddedFunction = maxHasPurposePerAddedFunction;
        this.maxAttemptsPerCase = maxAttemptsPerCase;
        this.maxSourceModelRegenerations = maxSourceModelRegenerations;
        this.functionTypes = functionTypes;
        this.mandatoryFunctionTypes = mandatoryFunctionTypes;
        this.componentTypes = componentTypes;
        this.purposeTypes = purposeTypes;
        this.vulnerabilitiesByComponentType = vulnerabilitiesByComponentType;
        this.profileName = profileName;
    }

    static SelfAdaptationGenerationConfig defaults() {
        Map<String, List<String>> vulns = new LinkedHashMap<>();
        vulns.put("CNginx", List.of(
                "CVE-2024-7347", "CVE-2023-44487", "CVE-2021-23017", "CVE-2021-3618", "CVE-2019-9516",
                "CVE-2019-9513", "CVE-2019-9511", "CVE-2018-16845", "CVE-2018-16844", "CVE-2018-16843"));
        vulns.put("CExpressJS", List.of(
                "CVE-2024-27983", "CVE-2024-21891", "CVE-2024-21890", "CVE-2024-3566", "CVE-2023-46809",
                "CVE-2025-23084", "CVE-2024-36138", "CVE-2024-36137", "CVE-2024-37372", "CVE-2025-23090"));
        vulns.put("CPostgresql", List.of(
                "CVE-2025-1094", "CVE-2024-10979", "CVE-2024-10978", "CVE-2024-10977", "CVE-2024-10976",
                "CVE-2024-7348", "CVE-2024-0985", "CVE-2023-5870", "CVE-2023-2455", "CVE-2022-41862"));
        vulns.put("CAngularSPA", List.of(
                "CVE-2024-5205", "CVE-2024-27983", "CVE-2024-27980", "CVE-2024-22025", "CVE-2024-22020",
                "CVE-2024-22019", "CVE-2024-22018", "CVE-2024-22017", "CVE-2024-21896", "CVE-2026-27970"));
        vulns.put("CRedis", List.of(
                "CVE-2025-21605", "CVE-2022-24834", "CVE-2022-36021", "CVE-2023-25155", "CVE-2023-28856",
                "CVE-2023-45145", "CVE-2024-46981", "CVE-2024-31449", "CVE-2025-32023", "CVE-2025-62507"));
        vulns.put("CFilesystem", List.of(
                "CVE-2024-31489", "CVE-2025-69418", "CVE-2025-15468", "CVE-2025-69421", "CVE-2025-11187",
                "CVE-2025-66199", "CVE-2025-69420", "CVE-2026-22795", "CVE-2026-22796", "CVE-2025-62506"));

        return new SelfAdaptationGenerationConfig(
                20260309L,
                10,
                6,
                10,
                1,
                6,
                1,
                14,
                1,
                14,
                50,
                1,
                List.of("FUploadVideo", "FStreamVideo", "FRemoveVideo", "FComments", "FLiveStreamVideo",
                        "FP2PStreaming", "FRecommendVideos", "FServeStandardAds", "FServeLocationTargetedAds",
                        "FServeBehaviorTargetedAds"),
                List.of("FUploadVideo", "FStreamVideo", "FRemoveVideo", "FComments"),
                List.of("CNginx", "CExpressJS", "CPostgresql", "CAngularSPA", "CRedis", "CFilesystem"),
                List.of("PMarketing", "PStandardAds", "PTargetedAds", "PLocationTargetedAds",
                        "PBehaviorTargetedAds", "PProfiling", "PFirstPartyProfiling", "PThirdPartyProfiling",
                        "PUserExperience", "PVideoRecommendation", "PP2PStreaming", "PSocial", "PComments",
                        "PVideoSharing"),
                vulns,
                PROFILE_DEFAULT);
    }

    // Alternate flow for manual inspection.
    static SelfAdaptationGenerationConfig tiny() {
        Map<String, List<String>> vulns = defaults().vulnerabilitiesByComponentType;
        return new SelfAdaptationGenerationConfig(
                20260309L,
                2,
                2,
                2,
                1,
                2,
                1,
                3,
                1,
                2,
                50,
                1,
                List.of("FUploadVideo", "FStreamVideo", "FRemoveVideo", "FComments", "FLiveStreamVideo",
                        "FP2PStreaming", "FRecommendVideos", "FServeStandardAds", "FServeLocationTargetedAds",
                        "FServeBehaviorTargetedAds"),
                List.of("FUploadVideo", "FStreamVideo", "FRemoveVideo", "FComments"),
                List.of("CNginx", "CExpressJS", "CPostgresql", "CAngularSPA", "CRedis", "CFilesystem"),
                List.of("PMarketing", "PStandardAds", "PTargetedAds", "PLocationTargetedAds",
                        "PBehaviorTargetedAds", "PProfiling", "PFirstPartyProfiling", "PThirdPartyProfiling",
                        "PUserExperience", "PVideoRecommendation", "PP2PStreaming", "PSocial", "PComments",
                        "PVideoSharing"),
                vulns,
                PROFILE_TINY);
    }
}
