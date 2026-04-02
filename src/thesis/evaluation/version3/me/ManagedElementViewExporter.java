package thesis.evaluation.version3.me;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

public final class ManagedElementViewExporter {
    private ManagedElementViewExporter() {
    }

    public static ManagedElementView export(ManagedElementInstance me) {
        Map<String, ManagedElementView.DataSubjectView> dataSubjects = new LinkedHashMap<>();
        for (ManagedElementInstance.DataSubjectNode node : me.dataSubjects.values()) {
            dataSubjects.put(node.id, new ManagedElementView.DataSubjectView(node.id, node.type, node.name));
        }

        Map<String, ManagedElementView.PersonalDataView> personalData = new LinkedHashMap<>();
        for (ManagedElementInstance.PersonalDataNode node : me.personalData.values()) {
            personalData.put(node.id, new ManagedElementView.PersonalDataView(
                    node.id, node.type, node.name, node.identifiesDsId));
        }

        Map<String, ManagedElementView.FunctionView> functions = new LinkedHashMap<>();
        for (ManagedElementInstance.FunctionNode node : me.functions.values()) {
            functions.put(node.id, new ManagedElementView.FunctionView(
                    node.id,
                    node.type,
                    node.name,
                    new LinkedHashSet<>(node.realizedByComponentIds),
                    new LinkedHashSet<>(node.processesPersonalDataIds),
                    new LinkedHashSet<>(node.hasPurposeIds)));
        }

        Map<String, ManagedElementView.ComponentView> components = new LinkedHashMap<>();
        for (ManagedElementInstance.ComponentNode node : me.components.values()) {
            components.put(node.id, new ManagedElementView.ComponentView(node.id, node.type, node.name));
        }

        Map<String, ManagedElementView.PurposeView> purposes = new LinkedHashMap<>();
        for (ManagedElementInstance.PurposeNode node : me.purposes.values()) {
            purposes.put(node.id, new ManagedElementView.PurposeView(node.id, node.type, node.name));
        }

        Map<String, ManagedElementView.VulnerabilityView> vulnerabilities = new LinkedHashMap<>();
        for (ManagedElementInstance.VulnerabilityNode node : me.vulnerabilities.values()) {
            vulnerabilities.put(node.id, new ManagedElementView.VulnerabilityView(
                    node.id, node.cveName, node.componentTypeOwner));
        }

        Map<String, ManagedElementView.ConsentView> consents = new LinkedHashMap<>();
        for (ManagedElementInstance.ConsentNode node : me.consents.values()) {
            consents.put(node.id, new ManagedElementView.ConsentView(
                    node.id, node.givenByDsId, node.forPersonalDataId, node.givenForPurposeId));
        }

        return new ManagedElementView(me.modelId, dataSubjects, personalData, functions, components, purposes,
                vulnerabilities, consents);
    }
}
