package thesis.evaluation.version3.me;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import CASA.CASAFactory;
import CASA.CASAPackage;
import CASA.CVSSVector;
import CASA.Component;
import CASA.Consent;
import CASA.DataSubject;
import CASA.FuncPersData;
import CASA.PersonalData;
import CASA.Purpose;
import CASA.Vulnerability;
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

final class CasaModelMapperV3 {
    private final CASAFactory factory = CASAFactory.eINSTANCE;
    private final CvssCatalogV3 cvssCatalog = CvssCatalogV3.defaults();

    Resource mapToResource(ManagedElementInstance me, URI uri) {
        ResourceSet rs = new ResourceSetImpl();
        rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put("xmi", new XMIResourceFactoryImpl());

        Resource resource = rs.createResource(uri);
        CASA.System system = factory.createSystem();
        resource.getContents().add(system);

        Map<String, DataSubject> dsMap = new HashMap<>();
        Map<String, PersonalData> pdMap = new HashMap<>();
        Map<String, FuncPersData> fnMap = new HashMap<>();
        Map<String, Component> compMap = new HashMap<>();
        Map<String, Purpose> purposeMap = new HashMap<>();
        Map<String, Vulnerability> vulnMap = new HashMap<>();

        for (ManagedElementInstance.DataSubjectNode node : me.dataSubjects.values()) {
            DataSubject ds = (DataSubject) createByMappedClass(mapDataSubjectType(node.type));
            ds.setName(node.name);
            system.getDataSubjects().add(ds);
            dsMap.put(node.id, ds);
        }

        for (ManagedElementInstance.PersonalDataNode node : me.personalData.values()) {
            PersonalData pd = (PersonalData) createByMappedClass(mapPersonalDataType(node.type));
            pd.setName(node.name);
            DataSubject owner = dsMap.get(node.identifiesDsId);
            if (owner != null) {
                pd.setIdentifies(owner);
            }
            system.getDatas().add(pd);
            pdMap.put(node.id, pd);
        }

        for (ManagedElementInstance.FunctionNode node : me.functions.values()) {
            FuncPersData fn = (FuncPersData) createByMappedClass(mapFunctionType(node.type));
            fn.setName(node.name);
            system.getFunctions().add(fn);
            fnMap.put(node.id, fn);
        }

        for (ManagedElementInstance.ComponentNode node : me.components.values()) {
            Component comp = (Component) createByMappedClass(mapComponentType(node.type));
            comp.setName(node.name);
            system.getComponents().add(comp);
            compMap.put(node.id, comp);
        }

        for (ManagedElementInstance.PurposeNode node : me.purposes.values()) {
            Purpose purpose = (Purpose) createByMappedClass(mapPurposeType(node.type));
            purpose.setName(node.name);
            system.getPurposes().add(purpose);
            purposeMap.put(node.id, purpose);
        }

        for (ManagedElementInstance.VulnerabilityNode node : me.vulnerabilities.values()) {
            Vulnerability vuln = (Vulnerability) createByMappedClass(mapVulnerabilityType(node.cveName));
            vuln.setCveName(node.cveName);
            vuln.setIsEnabled(true);
            vuln.setDescribedBy(curatedCvss(node.cveName));
            system.getVulnerabilities().add(vuln);
            vulnMap.put(node.id, vuln);
        }

        for (ManagedElementInstance.FunctionNode node : me.functions.values()) {
            FuncPersData fn = fnMap.get(node.id);
            for (String compId : node.realizedByComponentIds) {
                Component comp = compMap.get(compId);
                if (comp != null) {
                    fn.getRealizedBy().add(comp);
                }
            }
            for (String pdId : node.processesPersonalDataIds) {
                PersonalData pd = pdMap.get(pdId);
                if (pd != null) {
                    fn.getProcessesPersData().add(pd);
                }
            }
            for (String purposeId : node.hasPurposeIds) {
                Purpose purpose = purposeMap.get(purposeId);
                if (purpose != null) {
                    fn.getHas().add(purpose);
                }
            }
        }

        for (ManagedElementInstance.ConsentNode node : me.consents.values()) {
            DataSubject ds = dsMap.get(node.givenByDsId);
            PersonalData pd = pdMap.get(node.forPersonalDataId);
            Purpose purpose = purposeMap.get(node.givenForPurposeId);
            if (ds == null || pd == null || purpose == null) {
                throw new IllegalStateException("Cannot map consent due to missing referenced node: " + node.id);
            }
            if (!(purpose instanceof CASA.PurposeConsent purposeConsent)) {
                throw new IllegalStateException("Consent requires PurposeConsent subtype for purpose: " + node.givenForPurposeId);
            }
            Consent consent = factory.createConsent();
            consent.setForPurpose(purpose.getName());
            consent.setInformedRiskLevel(0.0d);
            consent.getGivenFor().add(purposeConsent);
            consent.getForPersonalData().add(pd);
            ds.getGives().add(consent);
        }

        return resource;
    }

    private Object createByMappedClass(String className) {
        EClassifier classifier = CASAPackage.eINSTANCE.getEClassifier(className);
        if (!(classifier instanceof EClass eClass)) {
            throw new IllegalStateException("Mapped CASA class not found or not EClass: " + className);
        }
        return factory.create(eClass);
    }

    private String mapDataSubjectType(String type) {
        return switch (type) {
            case "DSUser" -> "User";
            case "DSModerator" -> "Moderator";
            case "DSAdministrator" -> "Administrator";
            default -> throw new IllegalArgumentException("Unknown data subject type: " + type);
        };
    }

    private String mapPersonalDataType(String type) {
        return switch (type) {
            case "PDUsername" -> "Username";
            case "PDPassword" -> "Password";
            case "PDEmail" -> "EmailAddress";
            case "PDPaymentDetails" -> "Payment";
            case "PDTrackingCookie" -> "TrackingCookie";
            case "PDStreamingHistory" -> "StreamingHistory";
            case "PDUploadedVideo" -> "VideoContent";
            case "PDComment" -> "VideoComment";
            case "PDVideoMetadata" -> "VideoMetadata";
            case "PDDeviceType" -> "DeviceType";
            case "PDDeviceLocation" -> "DeviceLocation";
            case "PDRequestTimestamp" -> "RequestTimestamps";
            default -> throw new IllegalArgumentException("Unknown personal data type: " + type);
        };
    }

    private String mapFunctionType(String type) {
        return switch (type) {
            case "FServeStandardAds" -> "ServeStandardAds";
            case "FUploadVideo" -> "UploadVideo";
            case "FStreamVideo" -> "StreamVideo";
            case "FRemoveVideo" -> "RemoveVideo";
            case "FLiveStreamVideo" -> "LiveStreamVideo";
            case "FP2PStreaming" -> "P2PStreaming";
            case "FRecommendVideos" -> "RecommendVideos";
            case "FServeBehaviorTargetedAds" -> "ServeBehaviorTargetedAds";
            case "FComments" -> "CommentWriteRead";
            case "FServeLocationTargetedAds" -> "ServeLocationTargetedAds";
            default -> throw new IllegalArgumentException("Unknown function type: " + type);
        };
    }

    private String mapPurposeType(String type) {
        return switch (type) {
            case "PMarketing" -> "PMarketing";
            case "PStandardAds" -> "PStandardAds";
            case "PTargetedAds" -> "PTargetedAds";
            case "PLocationTargetedAds" -> "PLocationTargetedAds";
            case "PBehaviorTargetedAds" -> "PBehaviorTargetedAds";
            case "PProfiling" -> "PProfiling";
            case "PFirstPartyProfiling" -> "PFirstPartyProfiling";
            case "PThirdPartyProfiling" -> "PThirdPartyProfiling";
            case "PUserExperience" -> "PUserExperience";
            case "PVideoRecommendation" -> "PVideoRecommendation";
            case "PP2PStreaming" -> "PP2PStreaming";
            case "PSocial" -> "PSocial";
            case "PComments" -> "PComments";
            case "PVideoSharing" -> "PVideoSharing";
            default -> throw new IllegalArgumentException("Unknown purpose type: " + type);
        };
    }

    private String mapComponentType(String type) {
        return switch (type) {
            case "CNginx" -> "Nginx";
            case "CExpressJS" -> "ExpressJS";
            case "CPostgresql" -> "Postgresql";
            case "CAngularSPA" -> "AngularSPA";
            case "CRedis" -> "RedisComponent";
            case "CFilesystem" -> "FilesystemComponent";
            default -> throw new IllegalArgumentException("Unknown component type: " + type);
        };
    }

    private String mapVulnerabilityType(String cveId) {
        return cveId.replace('-', '_');
    }

    private CVSSVector curatedCvss(String cveId) {
        CvssCatalogV3.Entry entry = cvssCatalog.getRequired(cveId);
        CVSSVector cvss = factory.createCVSSVector();
        cvss.setAttackVector(parseAttackVector(entry.attackVector()));
        cvss.setAttackComplexity(parseAttackComplexity(entry.attackComplexity()));
        cvss.setScope(parseScope(entry.scope()));
        cvss.setPrivilegesRequired(parsePrivilegesRequired(entry.privilegesRequired()));
        cvss.setUserInteraction(parseUserInteraction(entry.userInteraction()));
        cvss.setExploitCodeMaturity(ExploitCodeMaturity.FUNCTIONAL);
        cvss.setReportConfidence(ReportConfidence.CONFIRMED);
        cvss.setConfidentialityImpact(parseConfidentialityImpact(entry.confidentialityImpact()));
        cvss.setIntegrityImpact(parseIntegrityImpact(entry.integrityImpact()));
        cvss.setAvailabilityImpact(parseAvailabilityImpact(entry.availabilityImpact()));
        cvss.setRemediationLevel(RemediationLevel.TEMPORARY_FIX);
        cvss.setConfidentialityRequirement(ConfidentialityRequirement.MEDIUM);
        cvss.setIntegrityRequirement(IntegrityRequirement.MEDIUM);
        cvss.setAvailabilityRequirement(AvailabilityRequirement.MEDIUM);
        return cvss;
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
