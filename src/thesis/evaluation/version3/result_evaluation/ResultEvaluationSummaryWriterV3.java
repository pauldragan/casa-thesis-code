package thesis.evaluation.version3.result_evaluation;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

final class ResultEvaluationSummaryWriterV3 {
    void write(Path outRoot, List<ResultEvaluationRecord> records) throws IOException {
        writeDetailCsvs(outRoot, records);
        int total = records.size();
        long correctDerivations = records.stream().filter(r -> r.derivationCorrect).count();
        long incorrectDerivations = total - correctDerivations;

        int totalPurposeGt = records.stream().mapToInt(r -> r.expectedPurposeViolations).sum();
        int totalPurposeIdentifiableGt = records.stream().mapToInt(r -> r.expectedIdentifiablePurposeViolations).sum();
        int totalPurposeTp = records.stream().mapToInt(r -> r.purposeTruePositives).sum();
        int totalPurposeFn = records.stream().mapToInt(r -> r.purposeFalseNegatives).sum();
        int totalPurposeFp = records.stream().mapToInt(r -> r.purposeFalsePositives).sum();

        int totalRiskGt = records.stream().mapToInt(r -> r.expectedRiskViolations).sum();
        int totalRiskIdentifiableGt = records.stream().mapToInt(r -> r.expectedIdentifiableRiskViolations).sum();
        int totalRiskTp = records.stream().mapToInt(r -> r.riskTruePositives).sum();
        int totalRiskFn = records.stream().mapToInt(r -> r.riskFalseNegatives).sum();
        int totalRiskFp = records.stream().mapToInt(r -> r.riskFalsePositives).sum();

        double derivationAccuracy = total == 0 ? 0.0 : (double) correctDerivations / total;
        double purposeAccuracy = totalPurposeIdentifiableGt == 0 && totalPurposeFp == 0 ? 1.0
                : totalPurposeIdentifiableGt == 0 ? 0.0 : (double) totalPurposeTp / totalPurposeIdentifiableGt;
        double riskAccuracy = totalRiskIdentifiableGt == 0 && totalRiskFp == 0 ? 1.0
                : totalRiskIdentifiableGt == 0 ? 0.0 : (double) totalRiskTp / totalRiskIdentifiableGt;

        String json = """
                {
                  "totalDerivationsEvaluated": %d,
                  "correctDerivations": %d,
                  "incorrectDerivations": %d,
                  "derivationAccuracy": %.6f,
                  "totalPurposeGroundTruthViolations": %d,
                  "totalIdentifiablePurposeGroundTruthViolations": %d,
                  "correctlyIdentifiedPurposeViolations": %d,
                  "purposeFalseNegatives": %d,
                  "purposeFalsePositives": %d,
                  "purposeAccuracy": %.6f,
                  "totalRiskGroundTruthViolations": %d,
                  "totalIdentifiableRiskGroundTruthViolations": %d,
                  "correctlyIdentifiedRiskViolations": %d,
                  "riskFalseNegatives": %d,
                  "riskFalsePositives": %d,
                  "riskAccuracy": %.6f
                }
                """.formatted(
                total,
                correctDerivations,
                incorrectDerivations,
                derivationAccuracy,
                totalPurposeGt,
                totalPurposeIdentifiableGt,
                totalPurposeTp,
                totalPurposeFn,
                totalPurposeFp,
                purposeAccuracy,
                totalRiskGt,
                totalRiskIdentifiableGt,
                totalRiskTp,
                totalRiskFn,
                totalRiskFp,
                riskAccuracy);
        Files.writeString(outRoot.resolve("result_evaluation_summary.json"), json, StandardCharsets.UTF_8);

        writeLatexTable(outRoot.resolve("table_derivation_accuracy.tex"),
                "Results for the derivation of prospective managed element models.",
                List.of(
                        row("Total derivations evaluated", String.valueOf(total)),
                        row("Correct derivations", String.valueOf(correctDerivations)),
                        row("Incorrect derivations", String.valueOf(incorrectDerivations)),
                        row("Derivation accuracy ($\\\\text{Accuracy}_d$)", formatMetric(derivationAccuracy))));
        writeLatexTable(outRoot.resolve("table_purpose_accuracy.tex"),
                "Results for identifying consent violations due to incompatible purposes.",
                List.of(
                        row("Total ground truth violations", String.valueOf(totalPurposeGt)),
                        row("Total identifiable ground truth violations", String.valueOf(totalPurposeIdentifiableGt)),
                        row("Correctly identified violations", String.valueOf(totalPurposeTp)),
                        row("Missed violations (false negatives)", String.valueOf(totalPurposeFn)),
                        row("Incorrectly reported violations (false positives)", String.valueOf(totalPurposeFp)),
                        row("Accuracy ($\\\\text{Accuracy}_v^p$)", formatMetric(purposeAccuracy))));
        writeLatexTable(outRoot.resolve("table_risk_accuracy.tex"),
                "Results for identifying consent violations due to increased risk.",
                List.of(
                        row("Total ground truth violations", String.valueOf(totalRiskGt)),
                        row("Total identifiable ground truth violations", String.valueOf(totalRiskIdentifiableGt)),
                        row("Correctly identified violations", String.valueOf(totalRiskTp)),
                        row("Missed violations (false negatives)", String.valueOf(totalRiskFn)),
                        row("Incorrectly reported violations (false positives)", String.valueOf(totalRiskFp)),
                        row("Accuracy ($\\\\text{Accuracy}_v^r$)", formatMetric(riskAccuracy))));
    }

    private static void writeDetailCsvs(Path outRoot, List<ResultEvaluationRecord> records) throws IOException {
        StringBuilder derivation = new StringBuilder("model_index,adaptation_index,adaptation_id,case_slug,derivation_correct,derivation_issue_count,derivation_issues\n");
        StringBuilder purpose = new StringBuilder("model_index,adaptation_index,adaptation_id,case_slug,expected_purpose_violations,expected_identifiable_purpose_violations,identified_by_casa_purpose_violations,purpose_true_positives,purpose_false_negatives,purpose_false_positives,purpose_accuracy\n");
        StringBuilder risk = new StringBuilder("model_index,adaptation_index,adaptation_id,case_slug,expected_risk_violations,expected_identifiable_risk_violations,identified_by_casa_risk_violations,risk_true_positives,risk_false_negatives,risk_false_positives,risk_accuracy\n");
        for (ResultEvaluationRecord record : records) {
            derivation.append(record.modelIndex).append(',')
                    .append(record.adaptationIndex).append(',')
                    .append(csv(record.adaptationId)).append(',')
                    .append(csv(record.caseSlug)).append(',')
                    .append(record.derivationCorrect).append(',')
                    .append(record.derivationIssueCount).append(',')
                    .append(csv(record.derivationIssues)).append('\n');
            purpose.append(record.modelIndex).append(',')
                    .append(record.adaptationIndex).append(',')
                    .append(csv(record.adaptationId)).append(',')
                    .append(csv(record.caseSlug)).append(',')
                    .append(record.expectedPurposeViolations).append(',')
                    .append(record.expectedIdentifiablePurposeViolations).append(',')
                    .append(record.actualPurposeViolations).append(',')
                    .append(record.purposeTruePositives).append(',')
                    .append(record.purposeFalseNegatives).append(',')
                    .append(record.purposeFalsePositives).append(',')
                    .append(record.purposeAccuracy).append('\n');
            risk.append(record.modelIndex).append(',')
                    .append(record.adaptationIndex).append(',')
                    .append(csv(record.adaptationId)).append(',')
                    .append(csv(record.caseSlug)).append(',')
                    .append(record.expectedRiskViolations).append(',')
                    .append(record.expectedIdentifiableRiskViolations).append(',')
                    .append(record.actualRiskViolations).append(',')
                    .append(record.riskTruePositives).append(',')
                    .append(record.riskFalseNegatives).append(',')
                    .append(record.riskFalsePositives).append(',')
                    .append(record.riskAccuracy).append('\n');
        }
        Files.writeString(outRoot.resolve("result_evaluation_derivation.csv"), derivation.toString(), StandardCharsets.UTF_8);
        Files.writeString(outRoot.resolve("result_evaluation_purpose.csv"), purpose.toString(), StandardCharsets.UTF_8);
        Files.writeString(outRoot.resolve("result_evaluation_risk.csv"), risk.toString(), StandardCharsets.UTF_8);
    }

    private static String[] row(String metric, String value) {
        return new String[] { metric, value };
    }

    private static String formatMetric(double value) {
        return String.format("%.6f", value);
    }

    private static void writeLatexTable(Path path, String caption, List<String[]> rows) throws IOException {
        StringBuilder sb = new StringBuilder();
        sb.append("\\begin{table}[t]\n");
        sb.append("\\centering\n");
        sb.append("\\footnotesize\n");
        sb.append("\\caption{").append(caption).append("}\n");
        sb.append("\\begin{tabular}{l r}\n");
        sb.append("\\toprule\n");
        sb.append("Metric & Value \\\\\n");
        sb.append("\\midrule\n");
        for (String[] row : rows) {
            sb.append(row[0]).append(" & ").append(row[1]).append(" \\\\\n");
        }
        sb.append("\\bottomrule\n");
        sb.append("\\end{tabular}\n");
        sb.append("\\end{table}\n");
        Files.writeString(path, sb.toString(), StandardCharsets.UTF_8);
    }

    private static String csv(String value) {
        String v = value == null ? "" : value;
        if (v.contains(",") || v.contains("\"") || v.contains("\n")) {
            return "\"" + v.replace("\"", "\"\"") + "\"";
        }
        return v;
    }
}
