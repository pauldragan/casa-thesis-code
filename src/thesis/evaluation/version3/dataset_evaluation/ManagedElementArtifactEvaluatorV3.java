package thesis.evaluation.version3.dataset_evaluation;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.resource.ResourceSet;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import CASA.CASAPackage;

final class ManagedElementArtifactEvaluatorV3 {
    private final ResourceSet resourceSet;

    ManagedElementArtifactEvaluatorV3() {
        this.resourceSet = new ResourceSetImpl();
        this.resourceSet.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
        this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put(Resource.Factory.Registry.DEFAULT_EXTENSION, new XMIResourceFactoryImpl());
        this.resourceSet.getResourceFactoryRegistry().getExtensionToFactoryMap()
                .put("xmi", new XMIResourceFactoryImpl());
    }

    ManagedElementArtifactMetrics evaluate(int modelIndex, String modelId, Path xmiPath) throws IOException {
        Resource res = resourceSet.getResource(URI.createFileURI(xmiPath.toAbsolutePath().toString()), true);
        if (res.getContents().isEmpty()) {
            throw new IllegalStateException("Empty XMI resource: " + xmiPath);
        }
        EObject root = res.getContents().get(0);
        ManagedElementArtifactMetrics metrics = new ManagedElementArtifactMetrics();
        metrics.modelIndex = modelIndex;
        metrics.modelId = modelId;
        metrics.xmiPath = xmiPath.toString();

        countObjects(root, metrics.countByType);
        collectPersonalDataPerDataSubject(root, metrics);
        metrics.totalInstances = metrics.countByType.values().stream().mapToInt(Integer::intValue).sum();

        List<Integer> realizesPerFn = new ArrayList<>();
        List<Integer> processesPerFn = new ArrayList<>();
        List<Integer> hasPurposePerFn = new ArrayList<>();
        List<Integer> affectedByPerComponent = new ArrayList<>();

        for (EObject ds : many(root, "dataSubjects")) {
            int gives = many(ds, "gives").size();
            metrics.relationCountByType.merge("gives", gives, Integer::sum);
        }
        for (EObject pd : many(root, "datas")) {
            int identifies = referenceCount(pd, "identifies");
            metrics.relationCountByType.merge("identifies", identifies, Integer::sum);
        }
        for (EObject fn : many(root, "functions")) {
            int realizes = many(fn, "realizedBy").size();
            int processes = many(fn, "processesPersData").size();
            int hasPurpose = many(fn, "has").size();
            metrics.relationCountByType.merge("realizedBy", realizes, Integer::sum);
            metrics.relationCountByType.merge("processesPersData", processes, Integer::sum);
            metrics.relationCountByType.merge("has", hasPurpose, Integer::sum);
            metrics.realizesTotal += realizes;
            metrics.processesTotal += processes;
            metrics.hasPurposeTotal += hasPurpose;
            realizesPerFn.add(realizes);
            processesPerFn.add(processes);
            hasPurposePerFn.add(hasPurpose);
        }
        for (EObject component : many(root, "components")) {
            int realizes = many(component, "realizes").size();
            int affectedBy = many(component, "affectedBy").size();
            metrics.relationCountByType.merge("realizes", realizes, Integer::sum);
            metrics.relationCountByType.merge("affectedBy", affectedBy, Integer::sum);
            metrics.affectedByTotal += affectedBy;
            affectedByPerComponent.add(affectedBy);
        }
        for (EObject vulnerability : many(root, "vulnerabilities")) {
            int affects = many(vulnerability, "affects").size();
            metrics.relationCountByType.merge("affects", affects, Integer::sum);
        }
        for (EObject consent : allConsents(root)) {
            metrics.relationCountByType.merge("givenBy", referenceCount(consent, "givenBy"), Integer::sum);
            metrics.relationCountByType.merge("forPersonalData", referenceCount(consent, "forPersonalData"), Integer::sum);
            metrics.relationCountByType.merge("givenFor", referenceCount(consent, "givenFor"), Integer::sum);
        }

        finalizeRelationStats(realizesPerFn, metrics, "realizes");
        finalizeRelationStats(processesPerFn, metrics, "processes");
        finalizeRelationStats(hasPurposePerFn, metrics, "hasPurpose");
        finalizeRelationStats(affectedByPerComponent, metrics, "affectedBy");
        metrics.relationValuesPerFunctionByType.put("realizes", List.copyOf(realizesPerFn));
        metrics.relationValuesPerFunctionByType.put("processes", List.copyOf(processesPerFn));
        metrics.relationValuesPerFunctionByType.put("hasPurpose", List.copyOf(hasPurposePerFn));
        metrics.relationValuesPerFunctionByType.put("affectedBy", List.copyOf(affectedByPerComponent));

        metrics.totalRelations = metrics.relationCountByType.values().stream().mapToInt(Integer::intValue).sum();
        metrics.connectivity = metrics.totalInstances == 0 ? 0.0 : (double) metrics.totalRelations / metrics.totalInstances;
        return metrics;
    }

    private void countObjects(EObject root, Map<String, Integer> countByType) {
        for (EObject ds : many(root, "dataSubjects")) {
            inc(countByType, inferDataSubjectType(ds));
        }
        for (EObject pd : many(root, "datas")) {
            inc(countByType, inferPersonalDataType(pd));
        }
        for (EObject fn : many(root, "functions")) {
            inc(countByType, inferFunctionType(fn));
        }
        for (EObject comp : many(root, "components")) {
            inc(countByType, inferComponentType(comp));
        }
        for (EObject purpose : many(root, "purposes")) {
            inc(countByType, inferNamedType(purpose, "name", purpose.eClass().getName()));
        }
        for (EObject vuln : many(root, "vulnerabilities")) {
            inc(countByType, stringAttr(vuln, "cveName"));
        }
        for (EObject ds : many(root, "dataSubjects")) {
            for (EObject consent : many(ds, "gives")) {
                inc(countByType, "Consent");
            }
        }
    }

    private void collectPersonalDataPerDataSubject(EObject root, ManagedElementArtifactMetrics metrics) {
        List<EObject> dataSubjects = many(root, "dataSubjects");
        for (EObject pd : many(root, "datas")) {
            String type = inferPersonalDataType(pd);
            List<Integer> counts = metrics.personalDataCountsPerDataSubjectByType.computeIfAbsent(
                    type,
                    key -> zeroList(dataSubjects.size()));
            EObject identified = one(pd, "identifies");
            if (identified == null) {
                continue;
            }
            int dsIndex = dataSubjects.indexOf(identified);
            if (dsIndex >= 0 && dsIndex < counts.size()) {
                counts.set(dsIndex, counts.get(dsIndex) + 1);
            }
        }
        for (String type : metrics.countByType.keySet()) {
            if (type.startsWith("PD")) {
                metrics.personalDataCountsPerDataSubjectByType.computeIfAbsent(
                        type,
                        key -> zeroList(dataSubjects.size()));
            }
        }
    }

    private static List<EObject> allConsents(EObject root) {
        List<EObject> result = new ArrayList<>();
        for (EObject ds : many(root, "dataSubjects")) {
            result.addAll(many(ds, "gives"));
        }
        return result;
    }

    private static EObject one(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            return null;
        }
        Object value = obj.eGet(feature);
        return value instanceof EObject ? (EObject) value : null;
    }

    private static List<Integer> zeroList(int size) {
        List<Integer> counts = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            counts.add(0);
        }
        return counts;
    }

    private static int referenceCount(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            return 0;
        }
        Object value = obj.eGet(feature);
        if (value == null) {
            return 0;
        }
        if (value instanceof EList<?>) {
            return ((EList<?>) value).size();
        }
        return 1;
    }

    private static void finalizeRelationStats(List<Integer> values, ManagedElementArtifactMetrics metrics, String relationType) {
        int min = values.isEmpty() ? 0 : Integer.MAX_VALUE;
        int max = values.isEmpty() ? 0 : Integer.MIN_VALUE;
        int sum = 0;
        for (int value : values) {
            min = Math.min(min, value);
            max = Math.max(max, value);
            sum += value;
        }
        double avg = values.isEmpty() ? 0.0 : (double) sum / values.size();
        switch (relationType) {
            case "realizes" -> {
                metrics.realizesMin = values.isEmpty() ? 0 : min;
                metrics.realizesMax = values.isEmpty() ? 0 : max;
                metrics.realizesAvg = avg;
            }
            case "processes" -> {
                metrics.processesMin = values.isEmpty() ? 0 : min;
                metrics.processesMax = values.isEmpty() ? 0 : max;
                metrics.processesAvg = avg;
            }
            case "hasPurpose" -> {
                metrics.hasPurposeMin = values.isEmpty() ? 0 : min;
                metrics.hasPurposeMax = values.isEmpty() ? 0 : max;
                metrics.hasPurposeAvg = avg;
            }
            case "affectedBy" -> {
                metrics.affectedByMin = values.isEmpty() ? 0 : min;
                metrics.affectedByMax = values.isEmpty() ? 0 : max;
                metrics.affectedByAvg = avg;
            }
            default -> throw new IllegalArgumentException("Unknown relation type: " + relationType);
        }
    }

    private static String inferDataSubjectType(EObject obj) {
        return inferNamedType(obj, "name", switch (obj.eClass().getName()) {
            case "User" -> "DSUser";
            case "Moderator" -> "DSModerator";
            case "Administrator" -> "DSAdministrator";
            default -> obj.eClass().getName();
        });
    }

    private static String inferPersonalDataType(EObject obj) {
        return inferNamedType(obj, "name", switch (obj.eClass().getName()) {
            case "Username" -> "PDUsername";
            case "Password" -> "PDPassword";
            case "EmailAddress" -> "PDEmail";
            case "Payment" -> "PDPaymentDetails";
            case "TrackingCookie" -> "PDTrackingCookie";
            case "StreamingHistory" -> "PDStreamingHistory";
            case "VideoContent" -> "PDUploadedVideo";
            case "VideoComment" -> "PDComment";
            case "VideoMetadata" -> "PDVideoMetadata";
            case "DeviceType" -> "PDDeviceType";
            case "DeviceLocation" -> "PDDeviceLocation";
            case "RequestTimestamps" -> "PDRequestTimestamp";
            default -> obj.eClass().getName();
        });
    }

    private static String inferFunctionType(EObject obj) {
        return inferNamedType(obj, "name", switch (obj.eClass().getName()) {
            case "ServeStandardAds" -> "FServeStandardAds";
            case "UploadVideo" -> "FUploadVideo";
            case "StreamVideo" -> "FStreamVideo";
            case "RemoveVideo" -> "FRemoveVideo";
            case "LiveStreamVideo" -> "FLiveStreamVideo";
            case "P2PStreaming" -> "FP2PStreaming";
            case "RecommendVideos" -> "FRecommendVideos";
            case "ServeBehaviorTargetedAds" -> "FServeBehaviorTargetedAds";
            case "CommentWriteRead" -> "FComments";
            case "ServeLocationTargetedAds" -> "FServeLocationTargetedAds";
            case "FuncPersData" -> "FuncPersData";
            default -> obj.eClass().getName();
        });
    }

    private static String inferComponentType(EObject obj) {
        return inferNamedType(obj, "name", switch (obj.eClass().getName()) {
            case "Nginx" -> "CNginx";
            case "ExpressJS" -> "CExpressJS";
            case "Postgresql" -> "CPostgresql";
            case "AngularSPA" -> "CAngularSPA";
            case "RedisComponent" -> "CRedis";
            case "FilesystemComponent" -> "CFilesystem";
            default -> obj.eClass().getName();
        });
    }

    private static String inferNamedType(EObject obj, String featureName, String fallback) {
        String name = stringAttr(obj, featureName);
        if (name == null || name.isBlank()) {
            return fallback;
        }
        int cut = name.indexOf('_');
        if (cut > 0) {
            return name.substring(0, cut);
        }
        return name;
    }

    private static String stringAttr(EObject obj, String featureName) {
        EStructuralFeature feature = obj.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            return null;
        }
        Object value = obj.eGet(feature);
        return value == null ? null : String.valueOf(value);
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

    private static void inc(Map<String, Integer> map, String key) {
        map.merge(key, 1, Integer::sum);
    }
}
