package thesis.evaluation.version3.me;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class ManagedElementInstance {
    final String modelId;

    final Map<String, DataSubjectNode> dataSubjects = new LinkedHashMap<>();
    final Map<String, PersonalDataNode> personalData = new LinkedHashMap<>();
    final Map<String, FunctionNode> functions = new LinkedHashMap<>();
    final Map<String, ComponentNode> components = new LinkedHashMap<>();
    final Map<String, PurposeNode> purposes = new LinkedHashMap<>();
    final Map<String, VulnerabilityNode> vulnerabilities = new LinkedHashMap<>();
    final Map<String, ConsentNode> consents = new LinkedHashMap<>();

    final LinkedHashSet<Edge> edges = new LinkedHashSet<>();

    ManagedElementInstance(String modelId) {
        this.modelId = modelId;
    }

    void addEdge(String type, String srcId, String dstId) {
        edges.add(new Edge(type, srcId, dstId));
    }

    List<FunctionNode> functionsProcessingPersonalData(String personalDataId) {
        List<FunctionNode> result = new ArrayList<>();
        for (FunctionNode fn : functions.values()) {
            if (fn.processesPersonalDataIds.contains(personalDataId)) {
                result.add(fn);
            }
        }
        return result;
    }

    static final class DataSubjectNode {
        final String id;
        final String type;
        final String name;

        DataSubjectNode(String id, String type, String name) {
            this.id = id;
            this.type = type;
            this.name = name;
        }
    }

    static final class PersonalDataNode {
        final String id;
        final String type;
        final String name;
        final String identifiesDsId;

        PersonalDataNode(String id, String type, String name, String identifiesDsId) {
            this.id = id;
            this.type = type;
            this.name = name;
            this.identifiesDsId = identifiesDsId;
        }
    }

    static final class FunctionNode {
        final String id;
        final String type;
        final String name;
        final Set<String> realizedByComponentIds = new LinkedHashSet<>();
        final Set<String> processesPersonalDataIds = new LinkedHashSet<>();
        final Set<String> hasPurposeIds = new LinkedHashSet<>();

        FunctionNode(String id, String type, String name) {
            this.id = id;
            this.type = type;
            this.name = name;
        }
    }

    static final class ComponentNode {
        final String id;
        final String type;
        final String name;

        ComponentNode(String id, String type, String name) {
            this.id = id;
            this.type = type;
            this.name = name;
        }
    }

    static final class PurposeNode {
        final String id;
        final String type;
        final String name;

        PurposeNode(String id, String type, String name) {
            this.id = id;
            this.type = type;
            this.name = name;
        }
    }

    static final class VulnerabilityNode {
        final String id;
        final String cveName;
        final String componentTypeOwner;

        VulnerabilityNode(String id, String cveName, String componentTypeOwner) {
            this.id = id;
            this.cveName = cveName;
            this.componentTypeOwner = componentTypeOwner;
        }
    }

    static final class ConsentNode {
        final String id;
        final String givenByDsId;
        final String forPersonalDataId;
        final String givenForPurposeId;

        ConsentNode(String id, String givenByDsId, String forPersonalDataId, String givenForPurposeId) {
            this.id = id;
            this.givenByDsId = givenByDsId;
            this.forPersonalDataId = forPersonalDataId;
            this.givenForPurposeId = givenForPurposeId;
        }
    }

    static final class Edge {
        final String type;
        final String srcId;
        final String dstId;

        Edge(String type, String srcId, String dstId) {
            this.type = type;
            this.srcId = srcId;
            this.dstId = dstId;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Edge other)) {
                return false;
            }
            return type.equals(other.type) && srcId.equals(other.srcId) && dstId.equals(other.dstId);
        }

        @Override
        public int hashCode() {
            int h = type.hashCode();
            h = 31 * h + srcId.hashCode();
            h = 31 * h + dstId.hashCode();
            return h;
        }
    }
}
