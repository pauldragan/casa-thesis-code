package thesis.evaluation.version3.me;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.List;

final class ManifestWriterV3 implements Closeable {
    private final BufferedWriter writer;
    private final List<String> actualTypeColumns;

    ManifestWriterV3(Path manifestPath, GenerationConfig config) throws IOException {
        this(manifestPath, config, false);
    }

    ManifestWriterV3(Path manifestPath, GenerationConfig config, boolean append) throws IOException {
        Files.createDirectories(manifestPath.getParent());
        this.actualTypeColumns = buildActualTypeColumns(config);
        boolean appendToExisting = append && Files.exists(manifestPath) && Files.size(manifestPath) > 0;
        this.writer = appendToExisting
                ? Files.newBufferedWriter(manifestPath, StandardCharsets.UTF_8, StandardOpenOption.APPEND)
                : Files.newBufferedWriter(manifestPath, StandardCharsets.UTF_8);
        if (!appendToExisting) {
            writeHeader();
        }
    }

    private List<String> buildActualTypeColumns(GenerationConfig config) {
        List<String> cols = new ArrayList<>();
        config.catalog.dataSubjectTypes.forEach(cols::add);
        config.catalog.mandatoryFunctionTypes.forEach(cols::add);
        config.catalog.optionalFunctionTypes.forEach(cols::add);
        config.catalog.componentTypes.forEach(cols::add);
        config.catalog.mandatoryPersonalDataTypes.forEach(cols::add);
        config.catalog.optionalPersonalDataTypes.forEach(cols::add);
        config.catalog.purposeTypes.forEach(cols::add);
        config.catalog.vulnerabilitiesByComponentType.values()
                .forEach(cves -> cves.forEach(cve -> {
                    if (!cols.contains(cve)) {
                        cols.add(cve);
                    }
                }));
        cols.add("Consent");
        return cols;
    }

    private void writeHeader() throws IOException {
        List<String> cols = new ArrayList<>();
        cols.add("model_index");
        cols.add("seed");
        cols.add("model_id");
        cols.add("status");
        cols.add("xmi_path");
        cols.add("graphml_path");
        actualTypeColumns.forEach(c -> cols.add("count_" + c));
        cols.add("total_instances");
        cols.add("total_relations");
        cols.add("connectivity");
        cols.add("pruned_functions");
        cols.add("pruned_components");
        cols.add("pruned_data_subjects");
        cols.add("pruned_personal_data");
        cols.add("pruned_consents");
        cols.add("pruned_edges");
        cols.add("core_components_before_prune");
        cols.add("validation_ok");
        cols.add("error_code");
        cols.add("error_message");
        writer.write(String.join(",", cols));
        writer.newLine();
        writer.flush();
    }

    void append(GenerationRecord record) throws IOException {
        List<String> vals = new ArrayList<>();
        vals.add(String.valueOf(record.modelIndex));
        vals.add(String.valueOf(record.seed));
        vals.add(csv(record.modelId));
        vals.add(csv(record.status));
        vals.add(csv(record.xmiPath));
        vals.add(csv(record.graphMlPath));
        vals.addAll(actualTypeValues(record.stats));
        vals.add(String.valueOf(record.stats.totalInstances));
        vals.add(String.valueOf(record.stats.totalRelations));
        vals.add(String.format(java.util.Locale.ROOT, "%.8f", record.stats.connectivity));
        vals.add(String.valueOf(record.prune == null ? 0 : record.prune.removedFunctions));
        vals.add(String.valueOf(record.prune == null ? 0 : record.prune.removedComponents));
        vals.add(String.valueOf(record.prune == null ? 0 : record.prune.removedDataSubjects));
        vals.add(String.valueOf(record.prune == null ? 0 : record.prune.removedPersonalData));
        vals.add(String.valueOf(record.prune == null ? 0 : record.prune.removedConsents));
        vals.add(String.valueOf(record.prune == null ? 0 : record.prune.removedEdges));
        vals.add(String.valueOf(record.prune == null ? 0 : record.prune.coreComponentsBefore));
        vals.add(String.valueOf(record.validation.isValid()));
        vals.add(csv(record.validation.errorCode()));
        vals.add(csv(record.validation.message()));
        writer.write(String.join(",", vals));
        writer.newLine();
        writer.flush();
    }

    private List<String> actualTypeValues(ModelStats stats) {
        List<String> vals = new ArrayList<>();
        for (String type : actualTypeColumns) {
            vals.add(String.valueOf(stats.countByType.getOrDefault(type, 0)));
        }
        return vals;
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
