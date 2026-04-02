package thesis.evaluation.version3.me;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

public final class CvssCatalogV3 {
    private static final ObjectMapper MAPPER = new ObjectMapper()
            .disable(MapperFeature.CAN_OVERRIDE_ACCESS_MODIFIERS);
    private static final List<Path> DEFAULT_PATHS = List.of(
            Path.of("src/thesis/evaluation/version3/me/python/manual_cvss_overrides.json"),
            Path.of("code/src/thesis/evaluation/version3/me/python/manual_cvss_overrides.json"),
            Path.of("../code/src/thesis/evaluation/version3/me/python/manual_cvss_overrides.json"));

    private static volatile CvssCatalogV3 defaultInstance;

    private final Map<String, Entry> entriesByCveId;
    private final Path sourcePath;

    private CvssCatalogV3(Path sourcePath, List<Entry> entries) {
        this.sourcePath = sourcePath;
        this.entriesByCveId = index(entries, sourcePath);
    }

    public static CvssCatalogV3 defaults() {
        CvssCatalogV3 current = defaultInstance;
        if (current != null) {
            return current;
        }
        synchronized (CvssCatalogV3.class) {
            current = defaultInstance;
            if (current == null) {
                current = load(resolveDefaultPath());
                defaultInstance = current;
            }
            return current;
        }
    }

    public static CvssCatalogV3 load(Path path) {
        try {
            JsonNode root = MAPPER.readTree(Files.readString(path));
            JsonNode entriesNode = root.get("entries");
            if (entriesNode == null || !entriesNode.isArray() || entriesNode.isEmpty()) {
                throw new IllegalStateException("CVSS catalog contains no entries: " + path);
            }
            List<Entry> entries = new ArrayList<>();
            for (JsonNode entryNode : entriesNode) {
                entries.add(parseEntry(entryNode));
            }
            return new CvssCatalogV3(path, entries);
        } catch (IOException e) {
            throw new IllegalStateException("Failed to load CVSS catalog from " + path, e);
        }
    }

    public Entry getRequired(String cveId) {
        Entry entry = entriesByCveId.get(cveId);
        if (entry == null) {
            throw new IllegalStateException("Missing CVSS entry for " + cveId + " in " + sourcePath);
        }
        return entry;
    }

    private static Path resolveDefaultPath() {
        return DEFAULT_PATHS.stream()
                .filter(Files::exists)
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Could not locate manual_cvss_overrides.json. Tried: " + DEFAULT_PATHS));
    }

    private static Entry validate(Entry entry, Path sourcePath) {
        require(entry.cveId, "cveId", sourcePath);
        require(entry.cvssVersion, "cvssVersion", sourcePath);
        require(entry.attackVector, "attackVector", sourcePath);
        require(entry.attackComplexity, "attackComplexity", sourcePath);
        require(entry.privilegesRequired, "privilegesRequired", sourcePath);
        require(entry.userInteraction, "userInteraction", sourcePath);
        require(entry.scope, "scope", sourcePath);
        require(entry.confidentialityImpact, "confidentialityImpact", sourcePath);
        require(entry.integrityImpact, "integrityImpact", sourcePath);
        require(entry.availabilityImpact, "availabilityImpact", sourcePath);
        return entry;
    }

    private static Map<String, Entry> index(List<Entry> entries, Path sourcePath) {
        Map<String, Entry> byCve = new LinkedHashMap<>();
        for (Entry rawEntry : entries) {
            Entry entry = validate(rawEntry, sourcePath);
            Entry existing = byCve.get(entry.cveId);
            if (existing == null) {
                byCve.put(entry.cveId, entry);
                continue;
            }
            if (!sameCvss(existing, entry)) {
                throw new IllegalStateException("Conflicting duplicate CVSS entries for " + entry.cveId + " in "
                        + sourcePath + ": componentType=" + existing.componentType + " vs " + entry.componentType);
            }
        }
        return Map.copyOf(byCve);
    }

    private static boolean sameCvss(Entry left, Entry right) {
        return Objects.equals(left.cvssVersion, right.cvssVersion)
                && Objects.equals(left.vectorString, right.vectorString)
                && Objects.equals(left.baseScore, right.baseScore)
                && Objects.equals(left.baseSeverity, right.baseSeverity)
                && Objects.equals(left.attackVector, right.attackVector)
                && Objects.equals(left.attackComplexity, right.attackComplexity)
                && Objects.equals(left.privilegesRequired, right.privilegesRequired)
                && Objects.equals(left.userInteraction, right.userInteraction)
                && Objects.equals(left.scope, right.scope)
                && Objects.equals(left.confidentialityImpact, right.confidentialityImpact)
                && Objects.equals(left.integrityImpact, right.integrityImpact)
                && Objects.equals(left.availabilityImpact, right.availabilityImpact);
    }

    private static void require(String value, String fieldName, Path sourcePath) {
        if (value == null || value.isBlank()) {
            throw new IllegalStateException("CVSS entry missing " + fieldName + " in " + sourcePath);
        }
    }

    public static class Entry {
        public String cveId;
        public String componentType;
        public List<String> problemReasons;
        public String sourceName;
        public String sourceUrl;
        public String cvssVersion;
        public String vectorString;
        public Double baseScore;
        public String baseSeverity;
        public String attackVector;
        public String attackComplexity;
        public String privilegesRequired;
        public String userInteraction;
        public String scope;
        public String confidentialityImpact;
        public String integrityImpact;
        public String availabilityImpact;
        public String notes;

        public String cveId() {
            return cveId;
        }

        public String attackVector() {
            return attackVector;
        }

        public String attackComplexity() {
            return attackComplexity;
        }

        public String privilegesRequired() {
            return privilegesRequired;
        }

        public String userInteraction() {
            return userInteraction;
        }

        public String scope() {
            return scope;
        }

        public String confidentialityImpact() {
            return confidentialityImpact;
        }

        public String integrityImpact() {
            return integrityImpact;
        }

        public String availabilityImpact() {
            return availabilityImpact;
        }

        @Override
        public int hashCode() {
            return Objects.hash(cveId);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entry other)) {
                return false;
            }
            return Objects.equals(cveId, other.cveId);
        }
    }

    private static Entry parseEntry(JsonNode node) {
        Entry entry = new Entry();
        entry.cveId = text(node, "cveId");
        entry.componentType = text(node, "componentType");
        entry.problemReasons = textList(node.get("problemReasons"));
        entry.sourceName = text(node, "sourceName");
        entry.sourceUrl = text(node, "sourceUrl");
        entry.cvssVersion = text(node, "cvssVersion");
        entry.vectorString = text(node, "vectorString");
        entry.baseScore = number(node.get("baseScore"));
        entry.baseSeverity = text(node, "baseSeverity");
        entry.attackVector = text(node, "attackVector");
        entry.attackComplexity = text(node, "attackComplexity");
        entry.privilegesRequired = text(node, "privilegesRequired");
        entry.userInteraction = text(node, "userInteraction");
        entry.scope = text(node, "scope");
        entry.confidentialityImpact = text(node, "confidentialityImpact");
        entry.integrityImpact = text(node, "integrityImpact");
        entry.availabilityImpact = text(node, "availabilityImpact");
        entry.notes = text(node, "notes");
        return entry;
    }

    private static String text(JsonNode node, String field) {
        JsonNode value = node.get(field);
        return value == null || value.isNull() ? null : value.asText();
    }

    private static Double number(JsonNode node) {
        return node == null || node.isNull() ? null : node.asDouble();
    }

    private static List<String> textList(JsonNode node) {
        if (node == null || node.isNull() || !node.isArray()) {
            return List.of();
        }
        List<String> values = new ArrayList<>();
        for (JsonNode item : node) {
            values.add(item.asText());
        }
        return List.copyOf(values);
    }
}
