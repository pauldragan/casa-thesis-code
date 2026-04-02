package thesis.evaluation.version3.me;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

final class RulePrunerV3 {

    PruneResult prune(ManagedElementInstance me) {
        PruneResult result = new PruneResult();
        result.coreComponentsBefore = countCoreComponents(me);

        int edgesBefore = me.edges.size();

        // 1) Remove functions with no processed personal data.
        List<String> fnToRemove = new ArrayList<>();
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            if (fn.processesPersonalDataIds.isEmpty()) {
                fnToRemove.add(fn.id);
            }
        }
        fnToRemove.forEach(id -> me.functions.remove(id));
        result.removedFunctions = fnToRemove.size();

        // 2) Remove components that realize no remaining function.
        Set<String> realizedComponents = new LinkedHashSet<>();
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            realizedComponents.addAll(fn.realizedByComponentIds);
        }
        List<String> compToRemove = new ArrayList<>();
        for (ManagedElementInstance.ComponentNode c : me.components.values()) {
            if (!realizedComponents.contains(c.id)) {
                compToRemove.add(c.id);
            }
        }
        compToRemove.forEach(id -> me.components.remove(id));
        result.removedComponents = compToRemove.size();

        // 3) Remove DataSubject with no personal data processed by any remaining function.
        Set<String> processedPdIds = new LinkedHashSet<>();
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            processedPdIds.addAll(fn.processesPersonalDataIds);
        }

        Map<String, List<String>> pdsByDs = new HashMap<>();
        for (ManagedElementInstance.PersonalDataNode pd : me.personalData.values()) {
            pdsByDs.computeIfAbsent(pd.identifiesDsId, k -> new ArrayList<>()).add(pd.id);
        }

        List<String> dsToRemove = new ArrayList<>();
        Set<String> pdToRemove = new LinkedHashSet<>();
        Set<String> consToRemove = new LinkedHashSet<>();
        for (ManagedElementInstance.DataSubjectNode ds : me.dataSubjects.values()) {
            List<String> pds = pdsByDs.getOrDefault(ds.id, List.of());
            boolean hasProcessedPd = false;
            for (String pdId : pds) {
                if (processedPdIds.contains(pdId)) {
                    hasProcessedPd = true;
                    break;
                }
            }
            if (!hasProcessedPd) {
                dsToRemove.add(ds.id);
                pdToRemove.addAll(pds);
            }
        }

        for (ManagedElementInstance.ConsentNode c : me.consents.values()) {
            if (dsToRemove.contains(c.givenByDsId) || pdToRemove.contains(c.forPersonalDataId)) {
                consToRemove.add(c.id);
            }
        }

        dsToRemove.forEach(id -> me.dataSubjects.remove(id));
        pdToRemove.forEach(id -> me.personalData.remove(id));
        consToRemove.forEach(id -> me.consents.remove(id));
        result.removedDataSubjects = dsToRemove.size();
        result.removedPersonalData = pdToRemove.size();
        result.removedConsents = consToRemove.size();

        // 4) Remove dangling consents/edges and normalize relation sets.
        normalizeRelations(me);
        removeDanglingConsents(me);
        removeDanglingEdges(me);

        result.removedEdges = Math.max(0, edgesBefore - me.edges.size());

        validatePruningIntentOrThrow(me);
        return result;
    }

    private void normalizeRelations(ManagedElementInstance me) {
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            fn.processesPersonalDataIds.removeIf(pdId -> !me.personalData.containsKey(pdId));
            fn.realizedByComponentIds.removeIf(cId -> !me.components.containsKey(cId));
            fn.hasPurposeIds.removeIf(pId -> !me.purposes.containsKey(pId));
        }
    }

    private void removeDanglingConsents(ManagedElementInstance me) {
        List<String> remove = new ArrayList<>();
        for (ManagedElementInstance.ConsentNode c : me.consents.values()) {
            boolean bad = !me.dataSubjects.containsKey(c.givenByDsId)
                    || !me.personalData.containsKey(c.forPersonalDataId)
                    || !me.purposes.containsKey(c.givenForPurposeId);
            if (bad) {
                remove.add(c.id);
            }
        }
        remove.forEach(id -> me.consents.remove(id));
    }

    private void removeDanglingEdges(ManagedElementInstance me) {
        Set<String> nodeIds = allNodeIds(me);
        me.edges.removeIf(e -> !nodeIds.contains(e.srcId) || !nodeIds.contains(e.dstId));
    }

    private Set<String> allNodeIds(ManagedElementInstance me) {
        Set<String> ids = new HashSet<>();
        ids.addAll(me.dataSubjects.keySet());
        ids.addAll(me.personalData.keySet());
        ids.addAll(me.functions.keySet());
        ids.addAll(me.components.keySet());
        ids.addAll(me.purposes.keySet());
        ids.addAll(me.vulnerabilities.keySet());
        ids.addAll(me.consents.keySet());
        return ids;
    }

    private int countCoreComponents(ManagedElementInstance me) {
        Set<String> core = new LinkedHashSet<>();
        core.addAll(me.dataSubjects.keySet());
        core.addAll(me.personalData.keySet());
        core.addAll(me.functions.keySet());
        core.addAll(me.components.keySet());
        core.addAll(me.consents.keySet());
        if (core.isEmpty()) {
            return 0;
        }

        Map<String, Set<String>> adj = new HashMap<>();
        core.forEach(id -> adj.put(id, new LinkedHashSet<>()));
        for (ManagedElementInstance.Edge e : me.edges) {
            if (core.contains(e.srcId) && core.contains(e.dstId)) {
                adj.get(e.srcId).add(e.dstId);
                adj.get(e.dstId).add(e.srcId);
            }
        }

        Set<String> visited = new HashSet<>();
        int comps = 0;
        for (String start : core) {
            if (visited.contains(start)) {
                continue;
            }
            comps++;
            ArrayDeque<String> q = new ArrayDeque<>();
            q.add(start);
            visited.add(start);
            while (!q.isEmpty()) {
                String cur = q.removeFirst();
                for (String nxt : adj.getOrDefault(cur, Set.of())) {
                    if (visited.add(nxt)) {
                        q.addLast(nxt);
                    }
                }
            }
        }
        return comps;
    }

    private void validatePruningIntentOrThrow(ManagedElementInstance me) {
        List<String> errors = new ArrayList<>();

        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            if (fn.processesPersonalDataIds.isEmpty()) {
                errors.add("Function without processed PD: " + fn.id);
            }
        }

        Set<String> realizedComps = new HashSet<>();
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            realizedComps.addAll(fn.realizedByComponentIds);
        }
        for (ManagedElementInstance.ComponentNode c : me.components.values()) {
            if (!realizedComps.contains(c.id)) {
                errors.add("Component without realized function: " + c.id);
            }
        }

        Set<String> processedPd = new HashSet<>();
        for (ManagedElementInstance.FunctionNode fn : me.functions.values()) {
            processedPd.addAll(fn.processesPersonalDataIds);
        }
        Map<String, List<String>> pdByDs = new HashMap<>();
        for (ManagedElementInstance.PersonalDataNode pd : me.personalData.values()) {
            pdByDs.computeIfAbsent(pd.identifiesDsId, k -> new ArrayList<>()).add(pd.id);
        }
        for (ManagedElementInstance.DataSubjectNode ds : me.dataSubjects.values()) {
            boolean ok = false;
            for (String pdId : pdByDs.getOrDefault(ds.id, List.of())) {
                if (processedPd.contains(pdId)) {
                    ok = true;
                    break;
                }
            }
            if (!ok) {
                errors.add("DataSubject without processed PD: " + ds.id);
            }
        }

        Set<String> nodeIds = allNodeIds(me);
        for (ManagedElementInstance.Edge e : me.edges) {
            if (!nodeIds.contains(e.srcId) || !nodeIds.contains(e.dstId)) {
                errors.add("Dangling edge: " + e.type + " " + e.srcId + " -> " + e.dstId);
            }
        }
        for (ManagedElementInstance.ConsentNode c : me.consents.values()) {
            if (!me.dataSubjects.containsKey(c.givenByDsId)
                    || !me.personalData.containsKey(c.forPersonalDataId)
                    || !me.purposes.containsKey(c.givenForPurposeId)) {
                errors.add("Dangling consent refs: " + c.id);
            }
        }

        if (!errors.isEmpty()) {
            throw new IllegalStateException("Post-prune intent validation failed: " + String.join(" | ", errors));
        }
    }
}
