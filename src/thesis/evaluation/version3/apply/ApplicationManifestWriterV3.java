package thesis.evaluation.version3.apply;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.List;

final class ApplicationManifestWriterV3 implements Closeable {
    private final BufferedWriter writer;

    ApplicationManifestWriterV3(Path manifestPath) throws IOException {
        this(manifestPath, false);
    }

    ApplicationManifestWriterV3(Path manifestPath, boolean append) throws IOException {
        Files.createDirectories(manifestPath.getParent());
        boolean appendToExisting = append && Files.exists(manifestPath) && Files.size(manifestPath) > 0;
        this.writer = appendToExisting
                ? Files.newBufferedWriter(manifestPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)
                : Files.newBufferedWriter(manifestPath, StandardCharsets.UTF_8);
        if (!appendToExisting) {
            writeHeader();
        }
    }

    private void writeHeader() throws IOException {
        writer.write(String.join(",", List.of(
                "model_index",
                "model_id",
                "adaptation_index",
                "adaptation_id",
                "case_slug",
                "source_model_path",
                "henshin_path",
                "prospective_model_path",
                "status",
                "application_succeeded",
                "emf_validation_ok",
                "oracle_check_ok",
                "applied_unit_name",
                "execution_time_millis",
                "source_functions",
                "source_components",
                "result_functions",
                "result_components",
                "delta_functions",
                "delta_components",
                "error_code",
                "error_message")));
        writer.newLine();
        writer.flush();
    }

    void append(ApplicationResult result) throws IOException {
        writer.write(String.join(",", List.of(
                String.valueOf(result.modelIndex),
                csv(result.modelId),
                String.valueOf(result.adaptationIndex),
                csv(result.adaptationId),
                csv(result.caseSlug),
                csv(result.sourceModelPath),
                csv(result.henshinPath),
                csv(result.prospectiveModelPath),
                csv(result.status),
                String.valueOf(result.applicationSucceeded),
                String.valueOf(result.emfValidationOk),
                String.valueOf(result.oracleCheckOk),
                csv(result.appliedUnitName),
                String.valueOf(result.executionTimeMillis),
                String.valueOf(result.sourceFunctions),
                String.valueOf(result.sourceComponents),
                String.valueOf(result.resultFunctions),
                String.valueOf(result.resultComponents),
                String.valueOf(result.deltaFunctions),
                String.valueOf(result.deltaComponents),
                csv(result.errorCode),
                csv(result.errorMessage))));
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
