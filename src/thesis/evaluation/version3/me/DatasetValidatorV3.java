package thesis.evaluation.version3.me;

import java.util.HashSet;
import java.util.Set;

final class DatasetValidatorV3 {
    private final GenerationConfig config;

    DatasetValidatorV3(GenerationConfig config) {
        this.config = config;
    }

    ValidationResult validate(ManagedElementSpec spec, ManagedElementInstance me, ModelStats stats) {
        ValidationResult out = new ValidationResult();

        validateExpectedCounts(spec, me, out);
        validateConceptCompleteness(spec, me, out);
        validateForeignKeys(me, out);
        validateNoForbiddenRiskLinks(me, out);
        validateBaselinePurposeSafety(me, out);

        if (stats.totalInstances <= 0) {
            out.add("EMPTY_MODEL: totalInstances <= 0");
        }
        return out;
    }

    private void validateExpectedCounts(ManagedElementSpec spec, ManagedElementInstance me, ValidationResult out) {
        checkCount("DATA_SUBJECTS", me.dataSubjects.size(), spec.totalDataSubjects(), out);
        checkCount("FUNCTIONS", me.functions.size(), spec.totalFunctions(), out);
        checkCount("COMPONENTS", me.components.size(), spec.totalComponents(), out);
    }

    private void checkCount(String label, int actual, int sampled, ValidationResult out) {
        if (config.enablePruning) {
            if (actual > sampled) {
                out.add("COUNT_EXCEEDS_SAMPLED_" + label + ":actual=" + actual + ",sampled=" + sampled);
            }
        } else if (actual != sampled) {
            out.add("COUNT_MISMATCH_" + label + ":actual=" + actual + ",sampled=" + sampled);
        }
    }

    private void validateConceptCompleteness(ManagedElementSpec spec, ManagedElementInstance me, ValidationResult out) {
        if (me.purposes.size() != spec.expectedPurposeConcepts) {
            out.add("PURPOSE_CONCEPT_COUNT_MISMATCH");
        }
        if (me.vulnerabilities.size() != spec.expectedVulnerabilityConcepts) {
            out.add("VULNERABILITY_CONCEPT_COUNT_MISMATCH");
        }
    }

    private void validateForeignKeys(ManagedElementInstance me, ValidationResult out) {
        Set<String> nodeIds = new HashSet<>();
        nodeIds.addAll(me.dataSubjects.keySet());
        nodeIds.addAll(me.personalData.keySet());
        nodeIds.addAll(me.functions.keySet());
        nodeIds.addAll(me.components.keySet());
        nodeIds.addAll(me.purposes.keySet());
        nodeIds.addAll(me.vulnerabilities.keySet());
        nodeIds.addAll(me.consents.keySet());

        for (ManagedElementInstance.Edge edge : me.edges) {
            if (!nodeIds.contains(edge.srcId)) {
                out.add("BROKEN_EDGE_SRC:" + edge.type + ":" + edge.srcId);
            }
            if (!nodeIds.contains(edge.dstId)) {
                out.add("BROKEN_EDGE_DST:" + edge.type + ":" + edge.dstId);
            }
        }
    }

    private void validateNoForbiddenRiskLinks(ManagedElementInstance me, ValidationResult out) {
        boolean found = me.edges.stream().anyMatch(e ->
                ("affects".equals(e.type) || "affectedBy".equals(e.type)));
        if (found) {
            out.add("FORBIDDEN_BASELINE_RISK_LINK_PRESENT");
        }
    }

    private void validateBaselinePurposeSafety(ManagedElementInstance me, ValidationResult out) {
        for (ManagedElementInstance.PersonalDataNode pd : me.personalData.values()) {
            Set<String> consentedPurposes = new HashSet<>();
            for (ManagedElementInstance.ConsentNode c : me.consents.values()) {
                if (c.forPersonalDataId.equals(pd.id) && c.givenByDsId.equals(pd.identifiesDsId)) {
                    consentedPurposes.add(c.givenForPurposeId);
                }
            }
            for (ManagedElementInstance.FunctionNode fn : me.functionsProcessingPersonalData(pd.id)) {
                for (String p : fn.hasPurposeIds) {
                    if (!consentedPurposes.contains(p)) {
                        out.add("PURPOSE_BASELINE_MISMATCH:pd=" + pd.id + ",fn=" + fn.id + ",purpose=" + p);
                    }
                }
            }
        }
    }
}
