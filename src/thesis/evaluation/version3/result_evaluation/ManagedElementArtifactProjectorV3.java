package thesis.evaluation.version3.result_evaluation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import CASA.CASAPackage;

public final class ManagedElementArtifactProjectorV3 {
    public LoadedModel load(Path xmiPath) throws IOException {
        ResourceSet resourceSet = new ResourceSetImpl();
        resourceSet.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        Resource resource = resourceSet.getResource(URI.createFileURI(xmiPath.toAbsolutePath().toString()), true);
        if (resource.getContents().isEmpty()) {
            throw new IOException("Empty XMI resource: " + xmiPath);
        }
        return new LoadedModel(resourceSet, resource, resource.getContents().get(0));
    }

    public NormalizedManagedElementModel project(Path xmiPath) throws IOException {
        try (LoadedModel loaded = load(xmiPath)) {
            return project(loaded.root());
        }
    }

    public NormalizedManagedElementModel project(EObject root) {
        NormalizedManagedElementModel model = new NormalizedManagedElementModel();
        model.modelId = stringAttr(root, "name");

        for (EObject ds : many(root, "dataSubjects")) {
            model.dataSubjectTypes.put(stringAttr(ds, "name"), inferDataSubjectType(ds));
            for (EObject consent : many(ds, "gives")) {
                String dsId = stringAttr(ds, "name");
                List<EObject> personalData = many(consent, "forPersonalData");
                List<EObject> purposes = many(consent, "givenFor");
                String pdId = personalData.isEmpty() ? "" : stringAttr(personalData.get(0), "name");
                String purposeId = purposes.isEmpty() ? "" : stringAttr(purposes.get(0), "name");
                model.consentKeys.add(consentKey(dsId, pdId, purposeId));
            }
        }

        for (EObject pd : many(root, "datas")) {
            String pdId = stringAttr(pd, "name");
            model.personalDataTypes.put(pdId, inferPersonalDataType(pd));
            EObject owner = one(pd, "identifies");
            model.personalDataIdentifies.put(pdId, owner == null ? "" : stringAttr(owner, "name"));
        }

        for (EObject function : many(root, "functions")) {
            String functionId = stringAttr(function, "name");
            model.addFunction(functionId, inferFunctionType(function));
            for (EObject component : many(function, "realizedBy")) {
                model.functionRealizedBy.get(functionId).add(stringAttr(component, "name"));
            }
            for (EObject pd : many(function, "processesPersData")) {
                model.functionProcesses.get(functionId).add(stringAttr(pd, "name"));
            }
            for (EObject purpose : many(function, "has")) {
                model.functionHasPurpose.get(functionId).add(stringAttr(purpose, "name"));
            }
        }

        for (EObject component : many(root, "components")) {
            model.componentTypes.put(stringAttr(component, "name"), inferComponentType(component));
        }
        for (EObject purpose : many(root, "purposes")) {
            model.purposeTypes.put(stringAttr(purpose, "name"), inferPurposeType(purpose));
        }
        for (EObject vulnerability : many(root, "vulnerabilities")) {
            String cve = stringAttr(vulnerability, "cveName");
            model.addVulnerability(cve);
            for (EObject component : many(vulnerability, "affects")) {
                model.vulnerabilityAffects.get(cve).add(stringAttr(component, "name"));
            }
        }

        return model;
    }

    public static String consentKey(String dsId, String personalDataId, String purposeId) {
        return dsId + "|" + personalDataId + "|" + purposeId;
    }

    private static String inferDataSubjectType(EObject obj) {
        if (hasEClassOrSuper(obj, "User")) {
            return "DSUser";
        }
        if (hasEClassOrSuper(obj, "Moderator")) {
            return "DSModerator";
        }
        if (hasEClassOrSuper(obj, "Administrator")) {
            return "DSAdministrator";
        }
        throw new IllegalStateException("Unsupported data subject EObject type: " + obj.eClass().getName());
    }

    private static String inferPersonalDataType(EObject obj) {
        if (hasEClassOrSuper(obj, "Username")) {
            return "PDUsername";
        }
        if (hasEClassOrSuper(obj, "Password")) {
            return "PDPassword";
        }
        if (hasEClassOrSuper(obj, "EmailAddress")) {
            return "PDEmail";
        }
        if (hasEClassOrSuper(obj, "Payment")) {
            return "PDPaymentDetails";
        }
        if (hasEClassOrSuper(obj, "TrackingCookie")) {
            return "PDTrackingCookie";
        }
        if (hasEClassOrSuper(obj, "StreamingHistory")) {
            return "PDStreamingHistory";
        }
        if (hasEClassOrSuper(obj, "VideoContent")) {
            return "PDUploadedVideo";
        }
        if (hasEClassOrSuper(obj, "VideoComment")) {
            return "PDComment";
        }
        if (hasEClassOrSuper(obj, "VideoMetadata")) {
            return "PDVideoMetadata";
        }
        if (hasEClassOrSuper(obj, "DeviceType")) {
            return "PDDeviceType";
        }
        if (hasEClassOrSuper(obj, "DeviceLocation")) {
            return "PDDeviceLocation";
        }
        if (hasEClassOrSuper(obj, "RequestTimestamps")) {
            return "PDRequestTimestamp";
        }
        throw new IllegalStateException("Unsupported personal data EObject type: " + obj.eClass().getName());
    }

    private static String inferFunctionType(EObject obj) {
        if (hasEClassOrSuper(obj, "ServeStandardAds")) {
            return "FServeStandardAds";
        }
        if (hasEClassOrSuper(obj, "UploadVideo")) {
            return "FUploadVideo";
        }
        if (hasEClassOrSuper(obj, "StreamVideo")) {
            return "FStreamVideo";
        }
        if (hasEClassOrSuper(obj, "RemoveVideo")) {
            return "FRemoveVideo";
        }
        if (hasEClassOrSuper(obj, "LiveStreamVideo")) {
            return "FLiveStreamVideo";
        }
        if (hasEClassOrSuper(obj, "P2PStreaming")) {
            return "FP2PStreaming";
        }
        if (hasEClassOrSuper(obj, "RecommendVideos")) {
            return "FRecommendVideos";
        }
        if (hasEClassOrSuper(obj, "ServeBehaviorTargetedAds")) {
            return "FServeBehaviorTargetedAds";
        }
        if (hasEClassOrSuper(obj, "CommentWriteRead")) {
            return "FComments";
        }
        if (hasEClassOrSuper(obj, "ServeLocationTargetedAds")) {
            return "FServeLocationTargetedAds";
        }
        throw new IllegalStateException("Unsupported function EObject type: " + obj.eClass().getName());
    }

    private static String inferComponentType(EObject obj) {
        if (hasEClassOrSuper(obj, "Nginx")) {
            return "CNginx";
        }
        if (hasEClassOrSuper(obj, "ExpressJS")) {
            return "CExpressJS";
        }
        if (hasEClassOrSuper(obj, "Postgresql")) {
            return "CPostgresql";
        }
        if (hasEClassOrSuper(obj, "AngularSPA")) {
            return "CAngularSPA";
        }
        if (hasEClassOrSuper(obj, "RedisComponent")) {
            return "CRedis";
        }
        if (hasEClassOrSuper(obj, "FilesystemComponent")) {
            return "CFilesystem";
        }
        throw new IllegalStateException("Unsupported component EObject type: " + obj.eClass().getName());
    }

    private static String inferPurposeType(EObject obj) {
        if (hasEClassOrSuper(obj, "PBehaviorTargetedAds")) {
            return "PBehaviorTargetedAds";
        }
        if (hasEClassOrSuper(obj, "PLocationTargetedAds")) {
            return "PLocationTargetedAds";
        }
        if (hasEClassOrSuper(obj, "PTargetedAds")) {
            return "PTargetedAds";
        }
        if (hasEClassOrSuper(obj, "PThirdPartyProfiling")) {
            return "PThirdPartyProfiling";
        }
        if (hasEClassOrSuper(obj, "PFirstPartyProfiling")) {
            return "PFirstPartyProfiling";
        }
        if (hasEClassOrSuper(obj, "PProfiling")) {
            return "PProfiling";
        }
        if (hasEClassOrSuper(obj, "PVideoRecommendation")) {
            return "PVideoRecommendation";
        }
        if (hasEClassOrSuper(obj, "PP2PStreaming")) {
            return "PP2PStreaming";
        }
        if (hasEClassOrSuper(obj, "PUserExperience")) {
            return "PUserExperience";
        }
        if (hasEClassOrSuper(obj, "PVideoSharing")) {
            return "PVideoSharing";
        }
        if (hasEClassOrSuper(obj, "PComments")) {
            return "PComments";
        }
        if (hasEClassOrSuper(obj, "PStandardAds")) {
            return "PStandardAds";
        }
        if (hasEClassOrSuper(obj, "PSocial")) {
            return "PSocial";
        }
        if (hasEClassOrSuper(obj, "PMarketing")) {
            return "PMarketing";
        }
        throw new IllegalStateException("Unsupported purpose EObject type: " + obj.eClass().getName());
    }

    private static boolean hasEClassOrSuper(EObject obj, String className) {
        if (obj.eClass().getName().equals(className)) {
            return true;
        }
        return obj.eClass().getEAllSuperTypes().stream().anyMatch(type -> type.getName().equals(className));
    }

    private static String stringAttr(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            return "";
        }
        Object value = obj.eGet(feature);
        return value == null ? "" : String.valueOf(value);
    }

    @SuppressWarnings("unchecked")
    private static List<EObject> many(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            return List.of();
        }
        Object value = obj.eGet(feature);
        if (value instanceof EList<?>) {
            return (List<EObject>) value;
        }
        return List.of();
    }

    private static EObject one(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            return null;
        }
        Object value = obj.eGet(feature);
        return value instanceof EObject eObject ? eObject : null;
    }

    public static record LoadedModel(ResourceSet resourceSet, Resource resource, EObject root) implements AutoCloseable {
        @Override
        public void close() {
            try {
                resource.unload();
            } catch (Exception ignored) {
            }
            resourceSet.getResources().clear();
        }
    }
}
