package thesis.evaluation.version3.result_evaluation;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

final class ResultEvaluationManifestWriterV3 implements Closeable {
    private final BufferedWriter writer;

    ResultEvaluationManifestWriterV3(Path manifestPath) throws IOException {
        this(manifestPath, false);
    }

    ResultEvaluationManifestWriterV3(Path manifestPath, boolean append) throws IOException {
        Files.createDirectories(manifestPath.getParent());
        boolean fileExists = Files.exists(manifestPath) && Files.size(manifestPath) > 0;
        this.writer = Files.newBufferedWriter(
                manifestPath,
                StandardCharsets.UTF_8,
                append ? java.nio.file.StandardOpenOption.APPEND : java.nio.file.StandardOpenOption.CREATE,
                append ? java.nio.file.StandardOpenOption.CREATE : java.nio.file.StandardOpenOption.TRUNCATE_EXISTING,
                java.nio.file.StandardOpenOption.WRITE);
        if (!append || !fileExists) {
            writer.write(String.join(",", List.of(
                    "model_index",
                    "model_id",
                    "adaptation_index",
                    "adaptation_id",
                    "case_slug",
                    "source_model_path",
                    "prospective_model_path",
                    "derivation_correct",
                    "derivation_issue_count",
                    "derivation_issues",
                    "expected_purpose_violations",
                    "expected_identifiable_purpose_violations",
                    "identified_by_casa_purpose_violations",
                    "purpose_true_positives",
                    "purpose_false_negatives",
                    "purpose_false_positives",
                    "purpose_accuracy",
                    "expected_risk_violations",
                    "expected_identifiable_risk_violations",
                    "identified_by_casa_risk_violations",
                    "risk_true_positives",
                    "risk_false_negatives",
                    "risk_false_positives",
                    "risk_accuracy",
                    "status",
                    "error_code",
                    "error_message")));
            writer.newLine();
            writer.flush();
        }
    }

    void append(ResultEvaluationRecord record) throws IOException {
        writer.write(String.join(",", List.of(
                String.valueOf(record.modelIndex),
                csv(record.modelId),
                String.valueOf(record.adaptationIndex),
                csv(record.adaptationId),
                csv(record.caseSlug),
                csv(record.sourceModelPath),
                csv(record.prospectiveModelPath),
                String.valueOf(record.derivationCorrect),
                String.valueOf(record.derivationIssueCount),
                csv(record.derivationIssues),
                String.valueOf(record.expectedPurposeViolations),
                String.valueOf(record.expectedIdentifiablePurposeViolations),
                String.valueOf(record.actualPurposeViolations),
                String.valueOf(record.purposeTruePositives),
                String.valueOf(record.purposeFalseNegatives),
                String.valueOf(record.purposeFalsePositives),
                String.valueOf(record.purposeAccuracy),
                String.valueOf(record.expectedRiskViolations),
                String.valueOf(record.expectedIdentifiableRiskViolations),
                String.valueOf(record.actualRiskViolations),
                String.valueOf(record.riskTruePositives),
                String.valueOf(record.riskFalseNegatives),
                String.valueOf(record.riskFalsePositives),
                String.valueOf(record.riskAccuracy),
                csv(record.status),
                csv(record.errorCode),
                csv(record.errorMessage))));
        writer.newLine();
        writer.flush();
    }

    private static String csv(String value) {
        String v = value == null ? "" : value;
        if (v.contains(",") || v.contains("\"") || v.contains("\n")) {
            return "\"" + v.replace("\"", "\"\"") + "\"";
        }
        return v;
    }

    @Override
    public void close() throws IOException {
        writer.close();
    }
}
