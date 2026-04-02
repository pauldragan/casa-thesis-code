package thesis.evaluation.version3.me;

import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

final class GenerationConfig {
    static final String PROFILE_DEFAULT = "default";
    // Alternate flow for manual inspection.
    static final String PROFILE_TINY = "tiny";

    final long baseSeed;
    final int targetCount;
    final boolean enablePruning;
    final boolean exportXmi;
    final boolean exportGraphMl;
    final boolean resume;
    final Path runRoot;

    final Catalog catalog;
    final Ranges ranges;
    final String profileName;

    GenerationConfig(
            long baseSeed,
            int targetCount,
            boolean enablePruning,
            boolean exportXmi,
            boolean exportGraphMl,
            boolean resume,
            Path runRoot,
            Catalog catalog,
            Ranges ranges,
            String profileName) {
        this.baseSeed = baseSeed;
        this.targetCount = targetCount;
        this.enablePruning = enablePruning;
        this.exportXmi = exportXmi;
        this.exportGraphMl = exportGraphMl;
        this.resume = resume;
        this.runRoot = runRoot;
        this.catalog = catalog;
        this.ranges = ranges;
        this.profileName = profileName;
    }

    static GenerationConfig defaults(Path outRoot) {
        Catalog catalog = Catalog.defaults();
        return new GenerationConfig(
                20260309L,
                1000,
                true,
                true,
                false,
                false,
                outRoot,
                catalog,
                Ranges.defaults(catalog),
                PROFILE_DEFAULT);
    }

    // Alternate flow for manual inspection.
    static GenerationConfig tiny(Path outRoot) {
        Catalog catalog = Catalog.defaults();
        return new GenerationConfig(
                20260309L,
                1000,
                true,
                true,
                false,
                false,
                outRoot,
                catalog,
                Ranges.tiny(catalog),
                PROFILE_TINY);
    }

    static final class Catalog {
        final List<String> dataSubjectTypes;
        final List<String> mandatoryFunctionTypes;
        final List<String> optionalFunctionTypes;
        final List<String> componentTypes;
        final List<String> mandatoryPersonalDataTypes;
        final List<String> optionalPersonalDataTypes;
        final List<String> purposeTypes;
        final Map<String, List<String>> vulnerabilitiesByComponentType;

        Catalog(
                List<String> dataSubjectTypes,
                List<String> mandatoryFunctionTypes,
                List<String> optionalFunctionTypes,
                List<String> componentTypes,
                List<String> mandatoryPersonalDataTypes,
                List<String> optionalPersonalDataTypes,
                List<String> purposeTypes,
                Map<String, List<String>> vulnerabilitiesByComponentType) {
            this.dataSubjectTypes = dataSubjectTypes;
            this.mandatoryFunctionTypes = mandatoryFunctionTypes;
            this.optionalFunctionTypes = optionalFunctionTypes;
            this.componentTypes = componentTypes;
            this.mandatoryPersonalDataTypes = mandatoryPersonalDataTypes;
            this.optionalPersonalDataTypes = optionalPersonalDataTypes;
            this.purposeTypes = purposeTypes;
            this.vulnerabilitiesByComponentType = vulnerabilitiesByComponentType;
        }

        int expectedPurposeCount() {
            return purposeTypes.size();
        }

        int expectedVulnerabilityCount() {
            int total = 0;
            for (List<String> cves : vulnerabilitiesByComponentType.values()) {
                total += cves.size();
            }
            return total;
        }

        static Catalog defaults() {
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

            return new Catalog(
                    List.of("DSUser", "DSModerator", "DSAdministrator"),
                    List.of("FUploadVideo", "FStreamVideo", "FRemoveVideo", "FComments"),
                    List.of("FLiveStreamVideo", "FP2PStreaming", "FRecommendVideos", "FServeStandardAds",
                            "FServeLocationTargetedAds", "FServeBehaviorTargetedAds"),
                    List.of("CNginx", "CExpressJS", "CPostgresql", "CAngularSPA", "CRedis", "CFilesystem"),
                    List.of("PDUsername", "PDPassword", "PDEmail"),
                    List.of("PDPaymentDetails", "PDTrackingCookie", "PDStreamingHistory", "PDUploadedVideo",
                            "PDComment", "PDVideoMetadata", "PDDeviceType", "PDDeviceLocation", "PDRequestTimestamp"),
                    List.of("PMarketing", "PStandardAds", "PTargetedAds", "PLocationTargetedAds",
                            "PBehaviorTargetedAds", "PProfiling", "PFirstPartyProfiling", "PThirdPartyProfiling",
                            "PUserExperience", "PVideoRecommendation", "PP2PStreaming", "PSocial", "PComments",
                            "PVideoSharing"),
                    vulns);
        }
    }

    static final class Ranges {
        final Map<String, IntRange> dataSubjectCountByType;
        final Map<String, IntRange> functionCountByType;
        final Map<String, IntRange> componentCountByType;
        final Map<String, IntRange> personalDataCountByTypePerDataSubject;
        final IntRange realizesPerFunction;
        final IntRange processesPerFunction;
        final IntRange hasPurposePerFunction;

        Ranges(
                Map<String, IntRange> dataSubjectCountByType,
                Map<String, IntRange> functionCountByType,
                Map<String, IntRange> componentCountByType,
                Map<String, IntRange> personalDataCountByTypePerDataSubject,
                IntRange realizesPerFunction,
                IntRange processesPerFunction,
                IntRange hasPurposePerFunction) {
            this.dataSubjectCountByType = dataSubjectCountByType;
            this.functionCountByType = functionCountByType;
            this.componentCountByType = componentCountByType;
            this.personalDataCountByTypePerDataSubject = personalDataCountByTypePerDataSubject;
            this.realizesPerFunction = realizesPerFunction;
            this.processesPerFunction = processesPerFunction;
            this.hasPurposePerFunction = hasPurposePerFunction;
        }

        static Ranges defaults(Catalog catalog) {
            Map<String, IntRange> ds = new LinkedHashMap<>();
            ds.put("DSUser", new IntRange(1, 265));
            ds.put("DSModerator", new IntRange(1, 30));
            ds.put("DSAdministrator", new IntRange(1, 3));

            Map<String, IntRange> fn = new LinkedHashMap<>();
            for (String type : catalog.optionalFunctionTypes) {
                fn.put(type, new IntRange(0, 5));
            }
            for (String type : catalog.mandatoryFunctionTypes) {
                fn.put(type, new IntRange(1, 5));
            }

            Map<String, IntRange> comp = new LinkedHashMap<>();
            for (String type : catalog.componentTypes) {
                comp.put(type, new IntRange(1, 20));
            }

            Map<String, IntRange> pd = new LinkedHashMap<>();
            for (String type : catalog.mandatoryPersonalDataTypes) {
                pd.put(type, new IntRange(1, 5));
            }
            for (String type : catalog.optionalPersonalDataTypes) {
                pd.put(type, new IntRange(0, 5));
            }

            return new Ranges(
                    ds,
                    fn,
                    comp,
                    pd,
                    new IntRange(1, 6),
                    new IntRange(1, 14),
                    new IntRange(1, 14));
        }

        // Alternate flow for manual inspection.
        static Ranges tiny(Catalog catalog) {
            Map<String, IntRange> ds = new LinkedHashMap<>();
            ds.put("DSUser", new IntRange(1, 3));
            ds.put("DSModerator", new IntRange(1, 2));
            ds.put("DSAdministrator", new IntRange(1, 1));

            Map<String, IntRange> fn = new LinkedHashMap<>();
            for (String type : catalog.optionalFunctionTypes) {
                fn.put(type, new IntRange(0, 1));
            }
            for (String type : catalog.mandatoryFunctionTypes) {
                fn.put(type, new IntRange(1, 2));
            }

            Map<String, IntRange> comp = new LinkedHashMap<>();
            for (String type : catalog.componentTypes) {
                comp.put(type, new IntRange(1, 2));
            }

            Map<String, IntRange> pd = new LinkedHashMap<>();
            for (String type : catalog.mandatoryPersonalDataTypes) {
                pd.put(type, new IntRange(1, 2));
            }
            for (String type : catalog.optionalPersonalDataTypes) {
                pd.put(type, new IntRange(0, 1));
            }

            return new Ranges(
                    ds,
                    fn,
                    comp,
                    pd,
                    new IntRange(1, 2),
                    new IntRange(1, 3),
                    new IntRange(1, 2));
        }
    }
}
