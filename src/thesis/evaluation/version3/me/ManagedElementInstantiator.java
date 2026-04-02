package thesis.evaluation.version3.me;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.LinkedHashSet;

final class ManagedElementInstantiator {
    private final GenerationConfig config;

    ManagedElementInstantiator(GenerationConfig config) {
        this.config = config;
    }

    ManagedElementInstance instantiate(ManagedElementSpec spec) {
        Random rng = new Random(spec.seed);
        ManagedElementInstance me = new ManagedElementInstance(String.format("me_%06d", spec.modelIndex));

        createDataSubjects(spec, me);
        createPersonalData(spec, me);
        createFunctions(spec, me);
        createComponents(spec, me);
        createPurposes(me);
        createVulnerabilities(me);

        assignRealizedBy(spec, me, rng);
        assignProcesses(spec, me, rng);
        assignHasPurpose(spec, me, rng);
        createBaselineConsents(me);

        return me;
    }

    private void createDataSubjects(ManagedElementSpec spec, ManagedElementInstance me) {
        for (String type : config.catalog.dataSubjectTypes) {
            int count = spec.dataSubjectCountByType.getOrDefault(type, 0);
            for (int i = 0; i < count; i++) {
                String id = String.format("%s_%04d", type, i + 1);
                me.dataSubjects.put(id, new ManagedElementInstance.DataSubjectNode(id, type, id));
            }
        }
    }

    private void createPersonalData(ManagedElementSpec spec, ManagedElementInstance me) {
        List<ManagedElementInstance.DataSubjectNode> subjects = new ArrayList<>(me.dataSubjects.values());
        Random rng = new Random(spec.seed ^ 0x5DEECE66DL);
        int counter = 1;
        for (ManagedElementInstance.DataSubjectNode ds : subjects) {
            for (String pdType : config.ranges.personalDataCountByTypePerDataSubject.keySet()) {
                int count = config.ranges.personalDataCountByTypePerDataSubject.get(pdType).sample(rng);
                for (int i = 0; i < count; i++) {
                    String id = String.format("%s_%05d", pdType, counter++);
                    me.personalData.put(id, new ManagedElementInstance.PersonalDataNode(id, pdType, id, ds.id));
                    me.addEdge("identifies", id, ds.id);
                }
            }
        }
    }

    private void createFunctions(ManagedElementSpec spec, ManagedElementInstance me) {
        for (String type : spec.functionCountByType.keySet()) {
            int count = spec.functionCountByType.get(type);
            for (int i = 0; i < count; i++) {
                String id = String.format("%s_%04d", type, i + 1);
                me.functions.put(id, new ManagedElementInstance.FunctionNode(id, type, id));
            }
        }
    }

    private void createComponents(ManagedElementSpec spec, ManagedElementInstance me) {
        for (String type : spec.componentCountByType.keySet()) {
            int count = spec.componentCountByType.get(type);
            for (int i = 0; i < count; i++) {
                String id = String.format("%s_%04d", type, i + 1);
                me.components.put(id, new ManagedElementInstance.ComponentNode(id, type, id));
            }
        }
    }

    private void createPurposes(ManagedElementInstance me) {
        for (String type : config.catalog.purposeTypes) {
            String id = type;
            me.purposes.put(id, new ManagedElementInstance.PurposeNode(id, type, type));
        }
    }

    private void createVulnerabilities(ManagedElementInstance me) {
        int duplicateCounter = 1;
        Set<String> seenIds = new LinkedHashSet<>();
        for (String componentType : config.catalog.vulnerabilitiesByComponentType.keySet()) {
            List<String> cves = config.catalog.vulnerabilitiesByComponentType.get(componentType);
            for (String cve : cves) {
                String id = cve;
                if (seenIds.contains(id)) {
                    id = cve + "_dup" + duplicateCounter++;
                }
                seenIds.add(id);
                me.vulnerabilities.put(id, new ManagedElementInstance.VulnerabilityNode(id, cve, componentType));
            }
        }
    }

    private void assignRealizedBy(ManagedElementSpec spec, ManagedElementInstance me, Random rng) {
        List<String> compIds = new ArrayList<>(me.components.keySet());
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            int wanted = Math.min(config.ranges.realizesPerFunction.sample(rng), compIds.size());
            for (String cId : pickDistinct(compIds, wanted, rng)) {
                fn.realizedByComponentIds.add(cId);
                me.addEdge("realizedBy", fn.id, cId);
            }
        }
    }

    private void assignProcesses(ManagedElementSpec spec, ManagedElementInstance me, Random rng) {
        List<String> pdIds = new ArrayList<>(me.personalData.keySet());
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            int wanted = Math.min(config.ranges.processesPerFunction.sample(rng), pdIds.size());
            for (String pdId : pickDistinct(pdIds, wanted, rng)) {
                fn.processesPersonalDataIds.add(pdId);
                me.addEdge("processes", fn.id, pdId);
            }
        }
    }

    private void assignHasPurpose(ManagedElementSpec spec, ManagedElementInstance me, Random rng) {
        List<String> purposeIds = new ArrayList<>(me.purposes.keySet());
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            int wanted = Math.min(config.ranges.hasPurposePerFunction.sample(rng), purposeIds.size());
            for (String pId : pickDistinct(purposeIds, wanted, rng)) {
                fn.hasPurposeIds.add(pId);
                me.addEdge("hasPurpose", fn.id, pId);
            }
        }
    }

    private void createBaselineConsents(ManagedElementInstance me) {
        int consentCounter = 1;
        for (ManagedElementInstance.PersonalDataNode pd : me.personalData.values()) {
            List<ManagedElementInstance.FunctionNode> processingFunctions = me.functionsProcessingPersonalData(pd.id);
            Set<String> neededPurposes = new LinkedHashSet<>();
            for (ManagedElementInstance.FunctionNode fn : processingFunctions) {
                neededPurposes.addAll(fn.hasPurposeIds);
            }
            for (String purposeId : neededPurposes) {
                String consentId = String.format("CONS_%05d", consentCounter++);
                ManagedElementInstance.ConsentNode consent =
                        new ManagedElementInstance.ConsentNode(consentId, pd.identifiesDsId, pd.id, purposeId);
                me.consents.put(consentId, consent);
                me.addEdge("givenBy", consentId, consent.givenByDsId);
                me.addEdge("forPersData", consentId, consent.forPersonalDataId);
                me.addEdge("givenFor", consentId, consent.givenForPurposeId);
            }
        }
    }

    private static List<String> pickDistinct(List<String> pool, int count, Random rng) {
        if (count <= 0 || pool.isEmpty()) {
            return List.of();
        }
        List<String> copy = new ArrayList<>(pool);
        Collections.shuffle(copy, rng);
        return copy.subList(0, Math.min(count, copy.size()));
    }
}
