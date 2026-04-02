package thesis.evaluation.version3.dataset_evaluation;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class SelfAdaptationDatasetEvaluatorV3 {
    private final SelfAdaptationDatasetEvaluationConfig config;

    public SelfAdaptationDatasetEvaluatorV3(SelfAdaptationDatasetEvaluationConfig config) {
        this.config = config;
    }

    public void run() throws IOException {
        Files.createDirectories(config.outputRoot);
        Path manifestPath = config.saRunRoot.resolve("self_adaptation_manifest.csv");
        List<Map<String, String>> manifestRows = CsvTableV3.read(manifestPath);
        List<Map<String, String>> acceptedRows = new ArrayList<>();
        for (Map<String, String> row : manifestRows) {
            if (Boolean.parseBoolean(row.getOrDefault("validation_ok", "false"))) {
                acceptedRows.add(row);
            }
        }
        writeSummary(acceptedRows);
        writeCaseSummary(acceptedRows);
        writeCountMapRows(acceptedRows, "added_function_types", config.outputRoot.resolve("sa_functions_added_by_type.csv"));
        writeCountMapRows(acceptedRows, "removed_function_types", config.outputRoot.resolve("sa_functions_removed_by_type.csv"));
        writeCountMapRows(acceptedRows, "added_component_types", config.outputRoot.resolve("sa_components_added_by_type.csv"));
        writeCountMapRows(acceptedRows, "removed_component_types", config.outputRoot.resolve("sa_components_removed_by_type.csv"));
        writeCombinedRelationRows(acceptedRows, config.outputRoot.resolve("sa_relations_changed_by_type.csv"));
        writeViolationRows(acceptedRows, config.outputRoot.resolve("sa_violations.csv"));
    }

    private void writeCaseSummary(List<Map<String, String>> rows) throws IOException {
        Map<String, Integer> countsByCase = new LinkedHashMap<>();
        for (Map<String, String> row : rows) {
            countsByCase.merge(row.getOrDefault("case_slug", ""), 1, Integer::sum);
        }
        Path out = config.outputRoot.resolve("sa_case_summary.csv");
        int total = rows.size();
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("case_slug,function_case,component_case,self_adaptations,share_pct");
            w.newLine();
            for (Map.Entry<String, Integer> entry : countsByCase.entrySet()) {
                String caseSlug = entry.getKey();
                w.write(String.join(",",
                        csv(caseSlug),
                        csv(functionCaseSlug(caseSlug)),
                        csv(componentCaseSlug(caseSlug)),
                        String.valueOf(entry.getValue()),
                        total == 0 ? "0.00000000" : String.format(java.util.Locale.ROOT, "%.8f", 100.0 * entry.getValue() / total)));
                w.newLine();
            }
        }
    }

    private void writeSummary(List<Map<String, String>> rows) throws IOException {
        Path out = config.outputRoot.resolve("sa_summary.csv");
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write(String.join(",", List.of(
                    "model_index",
                    "model_id",
                    "adaptation_index",
                    "adaptation_id",
                    "case_slug",
                    "added_functions",
                    "removed_functions",
                    "added_components",
                    "removed_components",
                    "changed_functions_total",
                    "changed_components_total",
                    "changed_instances_total",
                    "added_relations",
                    "removed_relations",
                    "changed_relations_total",
                    "expected_purpose_violations",
                    "expected_identifiable_purpose_violations",
                    "expected_risk_violations",
                    "expected_identifiable_risk_violations")));
            w.newLine();
            for (Map<String, String> row : rows) {
                w.write(String.join(",", List.of(
                        row.getOrDefault("model_index", ""),
                        csv(row.get("model_id")),
                        row.getOrDefault("adaptation_index", ""),
                        csv(row.get("adaptation_id")),
                        csv(row.get("case_slug")),
                        row.getOrDefault("added_functions", "0"),
                        row.getOrDefault("removed_functions", "0"),
                        row.getOrDefault("added_components", "0"),
                        row.getOrDefault("removed_components", "0"),
                        row.getOrDefault("changed_functions_total", "0"),
                        row.getOrDefault("changed_components_total", "0"),
                        row.getOrDefault("changed_instances_total", "0"),
                        row.getOrDefault("added_relations", "0"),
                        row.getOrDefault("removed_relations", "0"),
                        row.getOrDefault("changed_relations_total", "0"),
                        row.getOrDefault("expected_purpose_violations", "0"),
                        row.getOrDefault("expected_identifiable_purpose_violations", "0"),
                        row.getOrDefault("expected_risk_violations", "0"),
                        row.getOrDefault("expected_identifiable_risk_violations", "0"))));
                w.newLine();
            }
        }
    }

    private void writeCountMapRows(List<Map<String, String>> rows, String column, Path out) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("model_index,model_id,adaptation_index,adaptation_id,case_slug,type,count");
            w.newLine();
            for (Map<String, String> row : rows) {
                for (Map.Entry<String, Integer> entry : parseCountMap(row.get(column)).entrySet()) {
                    w.write(String.join(",",
                            row.getOrDefault("model_index", ""),
                            csv(row.get("model_id")),
                            row.getOrDefault("adaptation_index", ""),
                            csv(row.get("adaptation_id")),
                            csv(row.get("case_slug")),
                            entry.getKey(),
                            String.valueOf(entry.getValue())));
                    w.newLine();
                }
            }
        }
    }

    private void writeCombinedRelationRows(List<Map<String, String>> rows, Path out) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("model_index,model_id,adaptation_index,adaptation_id,case_slug,relation_type,count");
            w.newLine();
            for (Map<String, String> row : rows) {
                Map<String, Integer> counts = new LinkedHashMap<>();
                mergeCounts(counts, parseCountMap(row.get("added_relation_types")));
                mergeCounts(counts, parseCountMap(row.get("removed_relation_types")));
                for (Map.Entry<String, Integer> entry : counts.entrySet()) {
                    w.write(String.join(",",
                            row.getOrDefault("model_index", ""),
                            csv(row.get("model_id")),
                            row.getOrDefault("adaptation_index", ""),
                            csv(row.get("adaptation_id")),
                            csv(row.get("case_slug")),
                            entry.getKey(),
                            String.valueOf(entry.getValue())));
                    w.newLine();
                }
            }
        }
    }

    private void writeViolationRows(List<Map<String, String>> rows, Path out) throws IOException {
        try (BufferedWriter w = Files.newBufferedWriter(out, StandardCharsets.UTF_8)) {
            w.write("model_index,model_id,adaptation_index,adaptation_id,case_slug,violation_type,count");
            w.newLine();
            for (Map<String, String> row : rows) {
                writeViolationRow(w, row, "purpose", row.getOrDefault("expected_purpose_violations", "0"));
                writeViolationRow(w, row, "identifiable_purpose", row.getOrDefault("expected_identifiable_purpose_violations", "0"));
                writeViolationRow(w, row, "risk", row.getOrDefault("expected_risk_violations", "0"));
                writeViolationRow(w, row, "identifiable_risk", row.getOrDefault("expected_identifiable_risk_violations", "0"));
            }
        }
    }

    private static void writeViolationRow(BufferedWriter w, Map<String, String> row, String type, String count) throws IOException {
        w.write(String.join(",",
                row.getOrDefault("model_index", ""),
                csv(row.get("model_id")),
                row.getOrDefault("adaptation_index", ""),
                csv(row.get("adaptation_id")),
                csv(row.get("case_slug")),
                type,
                count == null || count.isBlank() ? "0" : count));
        w.newLine();
    }

    static Map<String, Integer> parseCountMap(String raw) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        if (raw == null || raw.isBlank()) {
            return counts;
        }
        for (String part : raw.split(";")) {
            if (part.isBlank()) {
                continue;
            }
            int eq = part.indexOf('=');
            if (eq <= 0 || eq >= part.length() - 1) {
                continue;
            }
            String key = part.substring(0, eq);
            int value = Integer.parseInt(part.substring(eq + 1));
            counts.merge(key, value, Integer::sum);
        }
        return counts;
    }

    static void mergeCounts(Map<String, Integer> target, Map<String, Integer> source) {
        for (Map.Entry<String, Integer> entry : source.entrySet()) {
            target.merge(entry.getKey(), entry.getValue(), Integer::sum);
        }
    }

    private static String functionCaseSlug(String caseSlug) {
        return filterCaseSlug(caseSlug, List.of("afs", "afp", "rf"));
    }

    private static String componentCaseSlug(String caseSlug) {
        return filterCaseSlug(caseSlug, List.of("acs", "acr", "rc"));
    }

    private static String filterCaseSlug(String caseSlug, List<String> selectedCodes) {
        if (caseSlug == null || caseSlug.isBlank()) {
            return "none";
        }
        List<String> parts = new ArrayList<>();
        for (String token : caseSlug.split("_")) {
            if (selectedCodes.contains(token)) {
                parts.add(token);
            }
        }
        if (parts.isEmpty()) {
            return "none";
        }
        return String.join("_", parts);
    }

    static String csv(String value) {
        String v = value == null ? "" : value;
        if (v.contains(",") || v.contains("\"") || v.contains("\n")) {
            return "\"" + v.replace("\"", "\"\"") + "\"";
        }
        return v;
    }
}
