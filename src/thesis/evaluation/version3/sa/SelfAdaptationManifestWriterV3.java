package thesis.evaluation.version3.sa;

import java.io.BufferedWriter;
import java.io.Closeable;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class SelfAdaptationManifestWriterV3 implements Closeable {
    private final BufferedWriter writer;

    SelfAdaptationManifestWriterV3(Path manifestPath) throws IOException {
        this(manifestPath, false);
    }

    SelfAdaptationManifestWriterV3(Path manifestPath, boolean append) throws IOException {
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
        List<String> cols = List.of(
                "model_index",
                "model_id",
                "adaptation_index",
                "adaptation_id",
                "source_model_seed",
                "seed",
                "combination_index",
                "case_slug",
                "henshin_path",
                "combination_bits",
                "added_functions",
                "removed_functions",
                "added_components",
                "removed_components",
                "changed_functions_total",
                "changed_components_total",
                "changed_instances_total",
                "added_function_types",
                "removed_function_types",
                "added_component_types",
                "removed_component_types",
                "added_relations",
                "removed_relations",
                "changed_relations_total",
                "added_relation_types",
                "removed_relation_types",
                "expected_purpose_violations",
                "expected_identifiable_purpose_violations",
                "expected_risk_violations",
                "expected_identifiable_risk_violations",
                "validation_ok",
                "error_code",
                "error_message",
                "notes");
        writer.write(String.join(",", cols));
        writer.newLine();
        writer.flush();
    }

    void append(
            int modelIndex,
            SelfAdaptationSpec spec,
            SelfAdaptationInstance instance,
            SourceManagedElementInstance source,
            SaValidationResult validation)
            throws IOException {
        Map<String, Integer> addedFunctionTypes = countAddedFunctionTypes(instance);
        Map<String, Integer> removedFunctionTypes = countRemovedFunctionTypes(instance, source);
        Map<String, Integer> addedComponentTypes = countAddedComponentTypes(instance);
        Map<String, Integer> removedComponentTypes = countRemovedComponentTypes(instance, source);
        Map<String, Integer> addedRelationTypes = countRelationTypes(instance.addedRelations);
        List<String> removedRelations = deriveRemovedRelations(instance, source);
        Map<String, Integer> removedRelationTypes = countRelationTypes(removedRelations);

        List<String> vals = new ArrayList<>();
        vals.add(String.valueOf(modelIndex));
        vals.add(csv(spec.sourceModelId));
        vals.add(String.valueOf(spec.adaptationIndex));
        vals.add(csv(instance.adaptationId));
        vals.add(String.valueOf(spec.sourceModelSeed));
        vals.add(String.valueOf(spec.seed));
        vals.add(String.valueOf(spec.combination.combinationIndex()));
        vals.add(csv(spec.combination.caseSlug()));
        vals.add(csv(instance.henshinPath));
        vals.add(spec.combination.bits());
        vals.add(String.valueOf(instance.addedFunctions.size()));
        vals.add(String.valueOf(instance.removedFunctionIds.size()));
        vals.add(String.valueOf(instance.addedComponents.size()));
        vals.add(String.valueOf(instance.removedComponentIds.size()));
        vals.add(String.valueOf(instance.addedFunctions.size() + instance.removedFunctionIds.size()));
        vals.add(String.valueOf(instance.addedComponents.size() + instance.removedComponentIds.size()));
        vals.add(String.valueOf(
                instance.addedFunctions.size()
                        + instance.removedFunctionIds.size()
                        + instance.addedComponents.size()
                        + instance.removedComponentIds.size()));
        vals.add(csv(serializeCounts(addedFunctionTypes)));
        vals.add(csv(serializeCounts(removedFunctionTypes)));
        vals.add(csv(serializeCounts(addedComponentTypes)));
        vals.add(csv(serializeCounts(removedComponentTypes)));
        vals.add(String.valueOf(instance.addedRelations.size()));
        vals.add(String.valueOf(removedRelations.size()));
        vals.add(String.valueOf(instance.addedRelations.size() + removedRelations.size()));
        vals.add(csv(serializeCounts(addedRelationTypes)));
        vals.add(csv(serializeCounts(removedRelationTypes)));
        vals.add(String.valueOf(instance.expectedPurposeViolations.size()));
        vals.add(String.valueOf(instance.expectedIdentifiablePurposeViolations.size()));
        vals.add(String.valueOf(instance.expectedRiskViolations.size()));
        vals.add(String.valueOf(instance.expectedIdentifiableRiskViolations.size()));
        vals.add(String.valueOf(validation.valid()));
        vals.add(csv(validation.errorCode()));
        vals.add(csv(validation.message()));
        vals.add(csv(String.join(" | ", instance.notes)));
        writer.write(String.join(",", vals));
        writer.newLine();
        writer.flush();
    }

    private static Map<String, Integer> countAddedFunctionTypes(SelfAdaptationInstance instance) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (SelfAdaptationInstance.AddedFunction function : instance.addedFunctions) {
            counts.merge(function.type(), 1, Integer::sum);
        }
        return counts;
    }

    private static Map<String, Integer> countRemovedFunctionTypes(
            SelfAdaptationInstance instance,
            SourceManagedElementInstance source) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String functionId : instance.removedFunctionIds) {
            SourceManagedElementInstance.FunctionView function = source.functions.get(functionId);
            if (function != null) {
                counts.merge(function.type(), 1, Integer::sum);
            }
        }
        return counts;
    }

    private static Map<String, Integer> countAddedComponentTypes(SelfAdaptationInstance instance) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (SelfAdaptationInstance.AddedComponent component : instance.addedComponents) {
            counts.merge(component.type(), 1, Integer::sum);
        }
        return counts;
    }

    private static Map<String, Integer> countRemovedComponentTypes(
            SelfAdaptationInstance instance,
            SourceManagedElementInstance source) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String componentId : instance.removedComponentIds) {
            SourceManagedElementInstance.ComponentView component = source.components.get(componentId);
            if (component != null) {
                counts.merge(component.type(), 1, Integer::sum);
            }
        }
        return counts;
    }

    private static Map<String, Integer> countRelationTypes(List<String> relations) {
        Map<String, Integer> counts = new LinkedHashMap<>();
        for (String relation : relations) {
            int cut = relation.indexOf(':');
            String type = cut > 0 ? relation.substring(0, cut) : relation;
            counts.merge(type, 1, Integer::sum);
        }
        return counts;
    }

    private static List<String> deriveRemovedRelations(
            SelfAdaptationInstance instance,
            SourceManagedElementInstance source) {
        Set<String> removed = new LinkedHashSet<>();
        Set<String> removedFunctionIds = new LinkedHashSet<>(instance.removedFunctionIds);
        Set<String> removedComponentIds = new LinkedHashSet<>(instance.removedComponentIds);

        for (String functionId : removedFunctionIds) {
            SourceManagedElementInstance.FunctionView function = source.functions.get(functionId);
            if (function == null) {
                continue;
            }
            for (String personalDataId : function.processesPersonalDataIds()) {
                removed.add("processes:" + functionId + "->" + personalDataId);
            }
            for (String purposeId : function.hasPurposeIds()) {
                removed.add("hasPurpose:" + functionId + "->" + purposeId);
            }
            for (String componentId : function.realizedByComponentIds()) {
                removed.add("realizedBy:" + functionId + "->" + componentId);
            }
        }

        for (String componentId : removedComponentIds) {
            for (SourceManagedElementInstance.FunctionView function : source.functions.values()) {
                if (removedFunctionIds.contains(function.id())) {
                    continue;
                }
                if (function.realizedByComponentIds().contains(componentId)) {
                    removed.add("realizedBy:" + function.id() + "->" + componentId);
                }
            }
        }

        return new ArrayList<>(removed);
    }

    private static String serializeCounts(Map<String, Integer> counts) {
        if (counts.isEmpty()) {
            return "";
        }
        List<String> parts = new ArrayList<>();
        for (Map.Entry<String, Integer> entry : counts.entrySet()) {
            parts.add(entry.getKey() + "=" + entry.getValue());
        }
        return String.join(";", parts);
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
