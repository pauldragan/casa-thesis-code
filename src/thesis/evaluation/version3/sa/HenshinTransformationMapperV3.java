package thesis.evaluation.version3.sa;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.HenshinFactory;
import org.eclipse.emf.henshin.model.Mapping;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;

import CASA.CASAPackage;
import CASA.CVSS.AttackComplexity;
import CASA.CVSS.AttackVector;
import CASA.CVSS.AvailabilityImpact;
import CASA.CVSS.AvailabilityRequirement;
import CASA.CVSS.ConfidentialityImpact;
import CASA.CVSS.ConfidentialityRequirement;
import CASA.CVSS.ExploitCodeMaturity;
import CASA.CVSS.IntegrityImpact;
import CASA.CVSS.IntegrityRequirement;
import CASA.CVSS.PrivilegesRequired;
import CASA.CVSS.RemediationLevel;
import CASA.CVSS.ReportConfidence;
import CASA.CVSS.Scope;
import CASA.CVSS.UserInteraction;
import thesis.evaluation.version3.me.CvssCatalogV3;

final class HenshinTransformationMapperV3 {
    private static final HenshinFactory HF = HenshinFactory.eINSTANCE;
    private final CvssCatalogV3 cvssCatalog = CvssCatalogV3.defaults();

    Module map(SelfAdaptationInstance instance, SourceManagedElementInstance source) {
        Module module = HF.createModule();
        module.setName(instance.adaptationId);
        module.getImports().add(CASAPackage.eINSTANCE);

        SequentialUnit sequence = HF.createSequentialUnit();
        sequence.setName(instance.adaptationId + "_sequence");
        sequence.setStrict(true);
        sequence.setRollback(false);
        module.getUnits().add(sequence);

        for (SelfAdaptationInstance.AddedComponent component : instance.addedComponents) {
            Rule rule = buildAddComponentRule(component, source);
            module.getUnits().add(rule);
            sequence.getSubUnits().add(rule);
        }
        for (SelfAdaptationInstance.AddedFunction function : instance.addedFunctions) {
            Rule rule = buildAddFunctionRule(function, source);
            module.getUnits().add(rule);
            sequence.getSubUnits().add(rule);
        }
        for (String removedFunctionId : instance.removedFunctionIds) {
            Rule rule = buildRemoveFunctionRule(removedFunctionId, source);
            module.getUnits().add(rule);
            sequence.getSubUnits().add(rule);
        }
        for (String removedComponentId : instance.removedComponentIds) {
            Rule rule = buildRemoveComponentRule(removedComponentId, source, instance);
            module.getUnits().add(rule);
            sequence.getSubUnits().add(rule);
        }
        return module;
    }

    private Rule buildAddComponentRule(SelfAdaptationInstance.AddedComponent component, SourceManagedElementInstance source) {
        Rule rule = HF.createRule();
        rule.setName("AddComponent_" + component.id());

        Graph lhs = HF.createGraph("Lhs");
        Graph rhs = HF.createGraph("Rhs");
        rule.setLhs(lhs);
        rule.setRhs(rhs);

        Node sysL = node(lhs, CASAPackage.Literals.SYSTEM, "sys");
        Node sysR = node(rhs, CASAPackage.Literals.SYSTEM, "sys");
        map(rule, sysL, sysR);

        Map<String, Node> rhsFunctionNodes = new LinkedHashMap<>();
        for (String functionId : component.realizedFunctionIds()) {
            SourceManagedElementInstance.FunctionView function = source.functions.get(functionId);
            if (function == null) {
                throw new IllegalStateException(
                        "Unknown function " + functionId + " referenced by added component " + component.id());
            }
            EClass functionType = mapFunctionType(function.type());
            Node fL = existingNamedNode(lhs, functionType, "f_" + sanitize(functionId), function.name(),
                    CASAPackage.Literals.FUNCTION__NAME);
            Node fR = existingNamedNode(rhs, functionType, "f_" + sanitize(functionId), function.name(),
                    CASAPackage.Literals.FUNCTION__NAME);
            map(rule, fL, fR);
            rhsFunctionNodes.put(functionId, fR);
        }

        Node cR = node(rhs, mapComponentType(component.type()), "c");
        attr(cR, CASAPackage.Literals.COMPONENT__NAME, quoted(component.name()));
        edge(sysR, cR, CASAPackage.Literals.SYSTEM__COMPONENTS);

        for (Node fR : rhsFunctionNodes.values()) {
            edge(cR, fR, CASAPackage.Literals.COMPONENT__REALIZES);
            edge(fR, cR, CASAPackage.Literals.FUNCTION__REALIZED_BY);
        }

        int idx = 0;
        for (String cve : component.vulnerabilityCves()) {
            Node vR = node(rhs, mapVulnerabilityType(cve), "v_" + idx);
            attr(vR, CASAPackage.Literals.VULNERABILITY__CVE_NAME, quoted(cve));
            attr(vR, CASAPackage.Literals.VULNERABILITY__IS_ENABLED, "true");
            Node cvss = node(rhs, CASAPackage.Literals.CVSS_VECTOR, "vec_" + idx);
            addCuratedCvssAttributes(cvss, cve);
            edge(sysR, vR, CASAPackage.Literals.SYSTEM__VULNERABILITIES);
            edge(vR, cvss, CASAPackage.Literals.VULNERABILITY__DESCRIBED_BY);
            edge(vR, cR, CASAPackage.Literals.VULNERABILITY__AFFECTS);
            edge(cR, vR, CASAPackage.Literals.COMPONENT__AFFECTED_BY);
            idx++;
        }

        return rule;
    }

    private Rule buildAddFunctionRule(SelfAdaptationInstance.AddedFunction function, SourceManagedElementInstance source) {
        Rule rule = HF.createRule();
        rule.setName("AddFunction_" + function.id());

        Graph lhs = HF.createGraph("Lhs");
        Graph rhs = HF.createGraph("Rhs");
        rule.setLhs(lhs);
        rule.setRhs(rhs);

        Node sysL = node(lhs, CASAPackage.Literals.SYSTEM, "sys");
        Node sysR = node(rhs, CASAPackage.Literals.SYSTEM, "sys");
        map(rule, sysL, sysR);

        Map<String, Node> rhsComponents = new LinkedHashMap<>();
        for (String componentId : function.realizedByComponentIds()) {
            SourceManagedElementInstance.ComponentView component = source.components.get(componentId);
            String componentName = component == null ? componentId : component.name();
            Node cL = existingNamedNode(lhs, CASAPackage.Literals.COMPONENT, "c_" + sanitize(componentId), componentName,
                    CASAPackage.Literals.COMPONENT__NAME);
            Node cR = existingNamedNode(rhs, CASAPackage.Literals.COMPONENT, "c_" + sanitize(componentId), componentName,
                    CASAPackage.Literals.COMPONENT__NAME);
            map(rule, cL, cR);
            rhsComponents.put(componentId, cR);
        }

        Map<String, Node> rhsPersonalData = new LinkedHashMap<>();
        for (String personalDataId : function.processesPersonalDataIds()) {
            SourceManagedElementInstance.PersonalDataView personalData = source.personalData.get(personalDataId);
            String personalDataName = personalData == null ? personalDataId : personalData.name();
            Node pdL = existingNamedNode(lhs, CASAPackage.Literals.PERSONAL_DATA, "pd_" + sanitize(personalDataId),
                    personalDataName, CASAPackage.Literals.DATA__NAME);
            Node pdR = existingNamedNode(rhs, CASAPackage.Literals.PERSONAL_DATA, "pd_" + sanitize(personalDataId),
                    personalDataName, CASAPackage.Literals.DATA__NAME);
            map(rule, pdL, pdR);
            rhsPersonalData.put(personalDataId, pdR);
        }

        Map<String, Node> rhsPurposes = new LinkedHashMap<>();
        for (String purposeId : function.hasPurposeIds()) {
            SourceManagedElementInstance.PurposeView purpose = source.purposes.get(purposeId);
            String purposeName = purpose == null ? purposeId : purpose.name();
            EClass purposeType = purpose == null ? inferPurposeTypeFromId(purposeId) : mapPurposeType(purpose.type());
            Node pL = existingNamedNode(lhs, purposeType, "p_" + sanitize(purposeId), purposeName,
                    CASAPackage.Literals.PURPOSE__NAME);
            Node pR = existingNamedNode(rhs, purposeType, "p_" + sanitize(purposeId), purposeName,
                    CASAPackage.Literals.PURPOSE__NAME);
            map(rule, pL, pR);
            rhsPurposes.put(purposeId, pR);
        }

        Node fR = node(rhs, mapFunctionType(function.type()), "f");
        attr(fR, CASAPackage.Literals.FUNCTION__NAME, quoted(function.name()));
        edge(sysR, fR, CASAPackage.Literals.SYSTEM__FUNCTIONS);

        for (Node component : rhsComponents.values()) {
            edge(fR, component, CASAPackage.Literals.FUNCTION__REALIZED_BY);
            edge(component, fR, CASAPackage.Literals.COMPONENT__REALIZES);
        }
        for (Node personalData : rhsPersonalData.values()) {
            edge(fR, personalData, CASAPackage.Literals.FUNC_PERS_DATA__PROCESSES_PERS_DATA);
            edge(personalData, fR, CASAPackage.Literals.PERSONAL_DATA__PROCESSED_BY);
        }
        for (Node purpose : rhsPurposes.values()) {
            edge(fR, purpose, CASAPackage.Literals.FUNC_PERS_DATA__HAS);
            edge(purpose, fR, CASAPackage.Literals.PURPOSE__OF_FUNCTION);
        }

        return rule;
    }

    private Rule buildRemoveFunctionRule(String functionId, SourceManagedElementInstance source) {
        SourceManagedElementInstance.FunctionView function = source.functions.get(functionId);
        if (function == null) {
            throw new IllegalStateException("Unknown function for removal: " + functionId);
        }
        Rule rule = HF.createRule();
        rule.setName("RemoveFunction_" + functionId);

        Graph lhs = HF.createGraph("Lhs");
        Graph rhs = HF.createGraph("Rhs");
        rule.setLhs(lhs);
        rule.setRhs(rhs);

        Node sysL = node(lhs, CASAPackage.Literals.SYSTEM, "sys");
        Node sysR = node(rhs, CASAPackage.Literals.SYSTEM, "sys");
        map(rule, sysL, sysR);

        Node fL = existingNamedNode(lhs, mapFunctionType(function.type()), "f", function.name(),
                CASAPackage.Literals.FUNCTION__NAME);
        edge(sysL, fL, CASAPackage.Literals.SYSTEM__FUNCTIONS);

        for (String componentId : function.realizedByComponentIds()) {
            SourceManagedElementInstance.ComponentView component = source.components.get(componentId);
            if (component == null) {
                continue;
            }
            Node cL = existingNamedNode(lhs, CASAPackage.Literals.COMPONENT, "c_" + sanitize(componentId), component.name(),
                    CASAPackage.Literals.COMPONENT__NAME);
            Node cR = existingNamedNode(rhs, CASAPackage.Literals.COMPONENT, "c_" + sanitize(componentId), component.name(),
                    CASAPackage.Literals.COMPONENT__NAME);
            map(rule, cL, cR);
            edge(fL, cL, CASAPackage.Literals.FUNCTION__REALIZED_BY);
            edge(cL, fL, CASAPackage.Literals.COMPONENT__REALIZES);
        }
        for (String personalDataId : function.processesPersonalDataIds()) {
            SourceManagedElementInstance.PersonalDataView pd = source.personalData.get(personalDataId);
            if (pd == null) {
                continue;
            }
            Node pdL = existingNamedNode(lhs, CASAPackage.Literals.PERSONAL_DATA, "pd_" + sanitize(personalDataId), pd.name(),
                    CASAPackage.Literals.DATA__NAME);
            Node pdR = existingNamedNode(rhs, CASAPackage.Literals.PERSONAL_DATA, "pd_" + sanitize(personalDataId), pd.name(),
                    CASAPackage.Literals.DATA__NAME);
            map(rule, pdL, pdR);
            edge(fL, pdL, CASAPackage.Literals.FUNC_PERS_DATA__PROCESSES_PERS_DATA);
            edge(pdL, fL, CASAPackage.Literals.PERSONAL_DATA__PROCESSED_BY);
        }
        for (String purposeId : function.hasPurposeIds()) {
            SourceManagedElementInstance.PurposeView purpose = source.purposes.get(purposeId);
            if (purpose == null) {
                continue;
            }
            Node pL = existingNamedNode(lhs, mapPurposeType(purpose.type()), "p_" + sanitize(purposeId), purpose.name(),
                    CASAPackage.Literals.PURPOSE__NAME);
            Node pR = existingNamedNode(rhs, mapPurposeType(purpose.type()), "p_" + sanitize(purposeId), purpose.name(),
                    CASAPackage.Literals.PURPOSE__NAME);
            map(rule, pL, pR);
            edge(fL, pL, CASAPackage.Literals.FUNC_PERS_DATA__HAS);
            edge(pL, fL, CASAPackage.Literals.PURPOSE__OF_FUNCTION);
        }
        return rule;
    }

    private Rule buildRemoveComponentRule(
            String componentId,
            SourceManagedElementInstance source,
            SelfAdaptationInstance instance) {
        SourceManagedElementInstance.ComponentView component = source.components.get(componentId);
        if (component == null) {
            throw new IllegalStateException("Unknown component for removal: " + componentId);
        }
        Rule rule = HF.createRule();
        rule.setName("RemoveComponent_" + componentId);

        Graph lhs = HF.createGraph("Lhs");
        Graph rhs = HF.createGraph("Rhs");
        rule.setLhs(lhs);
        rule.setRhs(rhs);

        Node sysL = node(lhs, CASAPackage.Literals.SYSTEM, "sys");
        Node sysR = node(rhs, CASAPackage.Literals.SYSTEM, "sys");
        map(rule, sysL, sysR);

        Node cL = existingNamedNode(lhs, CASAPackage.Literals.COMPONENT, "c", component.name(),
                CASAPackage.Literals.COMPONENT__NAME);
        edge(sysL, cL, CASAPackage.Literals.SYSTEM__COMPONENTS);

        for (SourceManagedElementInstance.FunctionView function : source.functions.values()) {
            if (!function.realizedByComponentIds().contains(componentId)) {
                continue;
            }
            if (instance.removedFunctionIds.contains(function.id())) {
                continue;
            }
            Node fL = existingNamedNode(lhs, mapFunctionType(function.type()), "f_" + sanitize(function.id()), function.name(),
                    CASAPackage.Literals.FUNCTION__NAME);
            Node fR = existingNamedNode(rhs, mapFunctionType(function.type()), "f_" + sanitize(function.id()), function.name(),
                    CASAPackage.Literals.FUNCTION__NAME);
            map(rule, fL, fR);
            edge(cL, fL, CASAPackage.Literals.COMPONENT__REALIZES);
            edge(fL, cL, CASAPackage.Literals.FUNCTION__REALIZED_BY);
        }
        return rule;
    }

    private static Node existingNamedNode(Graph graph, EClass type, String nodeName, String matchValue,
            org.eclipse.emf.ecore.EAttribute attrType) {
        Node node = node(graph, type, nodeName);
        attr(node, attrType, quoted(matchValue));
        return node;
    }

    private static Node node(Graph graph, EClass type, String name) {
        return HF.createNode(graph, type, name);
    }

    private static Attribute attr(Node node, org.eclipse.emf.ecore.EAttribute type, String value) {
        return HF.createAttribute(node, type, value);
    }

    private static void edge(Node src, Node dst, org.eclipse.emf.ecore.EReference type) {
        HF.createEdge(src, dst, type);
    }

    private static void map(Rule rule, Node lhs, Node rhs) {
        Mapping mapping = HF.createMapping(lhs, rhs);
        rule.getMappings().add(mapping);
    }

    private static String quoted(String value) {
        return "\"" + value.replace("\"", "\\\"") + "\"";
    }

    private static String sanitize(String id) {
        return id.replaceAll("[^A-Za-z0-9_]", "_");
    }

    private EClass mapFunctionType(String type) {
        return switch (type) {
            case "FServeStandardAds" -> CASAPackage.Literals.SERVE_STANDARD_ADS;
            case "FUploadVideo" -> CASAPackage.Literals.UPLOAD_VIDEO;
            case "FStreamVideo" -> CASAPackage.Literals.STREAM_VIDEO;
            case "FRemoveVideo" -> CASAPackage.Literals.REMOVE_VIDEO;
            case "FLiveStreamVideo" -> CASAPackage.Literals.LIVE_STREAM_VIDEO;
            case "FP2PStreaming" -> CASAPackage.Literals.P2P_STREAMING;
            case "FRecommendVideos" -> CASAPackage.Literals.RECOMMEND_VIDEOS;
            case "FServeBehaviorTargetedAds" -> CASAPackage.Literals.SERVE_BEHAVIOR_TARGETED_ADS;
            case "FComments" -> CASAPackage.Literals.COMMENT_WRITE_READ;
            case "FServeLocationTargetedAds" -> CASAPackage.Literals.SERVE_LOCATION_TARGETED_ADS;
            default -> throw new IllegalArgumentException("Unknown function type: " + type);
        };
    }

    private EClass mapPurposeType(String type) {
        return switch (type) {
            case "PMarketing" -> CASAPackage.Literals.PMARKETING;
            case "PStandardAds" -> CASAPackage.Literals.PSTANDARD_ADS;
            case "PTargetedAds" -> CASAPackage.Literals.PTARGETED_ADS;
            case "PLocationTargetedAds" -> CASAPackage.Literals.PLOCATION_TARGETED_ADS;
            case "PBehaviorTargetedAds" -> CASAPackage.Literals.PBEHAVIOR_TARGETED_ADS;
            case "PProfiling" -> CASAPackage.Literals.PPROFILING;
            case "PFirstPartyProfiling" -> CASAPackage.Literals.PFIRST_PARTY_PROFILING;
            case "PThirdPartyProfiling" -> CASAPackage.Literals.PTHIRD_PARTY_PROFILING;
            case "PUserExperience" -> CASAPackage.Literals.PUSER_EXPERIENCE;
            case "PVideoRecommendation" -> CASAPackage.Literals.PVIDEO_RECOMMENDATION;
            case "PP2PStreaming" -> CASAPackage.Literals.PP2P_STREAMING;
            case "PSocial" -> CASAPackage.Literals.PSOCIAL;
            case "PComments" -> CASAPackage.Literals.PCOMMENTS;
            case "PVideoSharing" -> casaEClass("PVideoSharing");
            default -> throw new IllegalArgumentException("Unknown purpose type: " + type);
        };
    }

    private static EClass inferPurposeTypeFromId(String purposeId) {
        int cut = purposeId.indexOf('_');
        String type = cut > 0 ? purposeId.substring(0, cut) : purposeId;
        return switch (type) {
            case "PMarketing" -> CASAPackage.Literals.PMARKETING;
            case "PStandardAds" -> CASAPackage.Literals.PSTANDARD_ADS;
            case "PTargetedAds" -> CASAPackage.Literals.PTARGETED_ADS;
            case "PLocationTargetedAds" -> CASAPackage.Literals.PLOCATION_TARGETED_ADS;
            case "PBehaviorTargetedAds" -> CASAPackage.Literals.PBEHAVIOR_TARGETED_ADS;
            case "PProfiling" -> CASAPackage.Literals.PPROFILING;
            case "PFirstPartyProfiling" -> CASAPackage.Literals.PFIRST_PARTY_PROFILING;
            case "PThirdPartyProfiling" -> CASAPackage.Literals.PTHIRD_PARTY_PROFILING;
            case "PUserExperience" -> CASAPackage.Literals.PUSER_EXPERIENCE;
            case "PVideoRecommendation" -> CASAPackage.Literals.PVIDEO_RECOMMENDATION;
            case "PP2PStreaming" -> CASAPackage.Literals.PP2P_STREAMING;
            case "PSocial" -> CASAPackage.Literals.PSOCIAL;
            case "PComments" -> CASAPackage.Literals.PCOMMENTS;
            case "PVideoSharing" -> casaEClass("PVideoSharing");
            default -> throw new IllegalArgumentException("Unknown purpose id/type: " + purposeId);
        };
    }

    private static EClass casaEClass(String name) {
        if (!(CASAPackage.eINSTANCE.getEClassifier(name) instanceof EClass eClass)) {
            throw new IllegalStateException("CASA EClass not found: " + name);
        }
        return eClass;
    }


    private EClass mapComponentType(String type) {
        return switch (type) {
            case "CNginx" -> CASAPackage.Literals.NGINX;
            case "CExpressJS" -> CASAPackage.Literals.EXPRESS_JS;
            case "CPostgresql" -> CASAPackage.Literals.POSTGRESQL;
            case "CAngularSPA" -> CASAPackage.Literals.ANGULAR_SPA;
            case "CRedis" -> CASAPackage.Literals.REDIS_COMPONENT;
            case "CFilesystem" -> CASAPackage.Literals.FILESYSTEM_COMPONENT;
            default -> CASAPackage.Literals.COMPONENT;
        };
    }

    private EClass mapVulnerabilityType(String cveId) {
        String className = cveId.replace('-', '_');
        EClassifier classifier = CASAPackage.eINSTANCE.getEClassifier(className);
        if (!(classifier instanceof EClass eClass)) {
            throw new IllegalStateException("Unknown CASA vulnerability subtype for CVE: " + cveId);
        }
        return eClass;
    }

    private void addCuratedCvssAttributes(Node cvss, String cveId) {
        CvssCatalogV3.Entry entry = cvssCatalog.getRequired(cveId);
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__ATTACK_VECTOR, quoted(parseAttackVector(entry.attackVector()).getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__ATTACK_COMPLEXITY,
                quoted(parseAttackComplexity(entry.attackComplexity()).getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__SCOPE, quoted(parseScope(entry.scope()).getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__PRIVILEGES_REQUIRED,
                quoted(parsePrivilegesRequired(entry.privilegesRequired()).getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__USER_INTERACTION,
                quoted(parseUserInteraction(entry.userInteraction()).getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__EXPLOIT_CODE_MATURITY,
                quoted(ExploitCodeMaturity.FUNCTIONAL.getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__REPORT_CONFIDENCE, quoted(ReportConfidence.CONFIRMED.getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__CONFIDENTIALITY_IMPACT,
                quoted(parseConfidentialityImpact(entry.confidentialityImpact()).getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__INTEGRITY_IMPACT,
                quoted(parseIntegrityImpact(entry.integrityImpact()).getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__AVAILABILITY_IMPACT,
                quoted(parseAvailabilityImpact(entry.availabilityImpact()).getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__REMEDIATION_LEVEL,
                quoted(RemediationLevel.TEMPORARY_FIX.getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT,
                quoted(ConfidentialityRequirement.MEDIUM.getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__INTEGRITY_REQUIREMENT,
                quoted(IntegrityRequirement.MEDIUM.getLiteral()));
        attr(cvss, CASAPackage.Literals.CVSS_VECTOR__AVAILABILITY_REQUIREMENT,
                quoted(AvailabilityRequirement.MEDIUM.getLiteral()));
    }

    private AttackVector parseAttackVector(String value) {
        return switch (value) {
            case "NETWORK" -> AttackVector.NETWORK;
            case "ADJACENT", "ADJACENT_NETWORK" -> AttackVector.ADJACENT;
            case "LOCAL" -> AttackVector.LOCAL;
            case "PHYSICAL" -> AttackVector.PHYSICAL;
            default -> throw new IllegalArgumentException("Unknown CVSS attack vector: " + value);
        };
    }

    private AttackComplexity parseAttackComplexity(String value) {
        return switch (value) {
            case "LOW" -> AttackComplexity.LOW;
            case "HIGH" -> AttackComplexity.HIGH;
            default -> throw new IllegalArgumentException("Unknown CVSS attack complexity: " + value);
        };
    }

    private Scope parseScope(String value) {
        return switch (value) {
            case "UNCHANGED" -> Scope.UNCHANGED;
            case "CHANGED" -> Scope.CHANGED;
            default -> throw new IllegalArgumentException("Unknown CVSS scope: " + value);
        };
    }

    private PrivilegesRequired parsePrivilegesRequired(String value) {
        return switch (value) {
            case "NONE" -> PrivilegesRequired.NONE;
            case "LOW" -> PrivilegesRequired.LOW;
            case "HIGH" -> PrivilegesRequired.HIGH;
            default -> throw new IllegalArgumentException("Unknown CVSS privileges required: " + value);
        };
    }

    private UserInteraction parseUserInteraction(String value) {
        return switch (value) {
            case "NONE" -> UserInteraction.NONE;
            case "REQUIRED" -> UserInteraction.REQUIRED;
            default -> throw new IllegalArgumentException("Unknown CVSS user interaction: " + value);
        };
    }

    private ConfidentialityImpact parseConfidentialityImpact(String value) {
        return switch (value) {
            case "NONE" -> ConfidentialityImpact.NONE;
            case "LOW" -> ConfidentialityImpact.LOW;
            case "HIGH" -> ConfidentialityImpact.HIGH;
            default -> throw new IllegalArgumentException("Unknown CVSS confidentiality impact: " + value);
        };
    }

    private IntegrityImpact parseIntegrityImpact(String value) {
        return switch (value) {
            case "NONE" -> IntegrityImpact.NONE;
            case "LOW" -> IntegrityImpact.LOW;
            case "HIGH" -> IntegrityImpact.HIGH;
            default -> throw new IllegalArgumentException("Unknown CVSS integrity impact: " + value);
        };
    }

    private AvailabilityImpact parseAvailabilityImpact(String value) {
        return switch (value) {
            case "NONE" -> AvailabilityImpact.NONE;
            case "LOW" -> AvailabilityImpact.LOW;
            case "HIGH" -> AvailabilityImpact.HIGH;
            default -> throw new IllegalArgumentException("Unknown CVSS availability impact: " + value);
        };
    }
}
