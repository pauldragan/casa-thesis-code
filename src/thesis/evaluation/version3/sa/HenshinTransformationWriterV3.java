package thesis.evaluation.version3.sa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.TreeIterator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Edge;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import CASA.CASAPackage;

final class HenshinTransformationWriterV3 {
    Path write(Module module, Path henshinPath) throws IOException {
        Files.createDirectories(henshinPath.getParent());
        HenshinResourceSet rs = new HenshinResourceSet(henshinPath.getParent().toAbsolutePath().toString());
        Path sourceCasaEcore = resolveCasaEcore();
        Path localCasaEcore = henshinPath.getParent().resolve("CASA.ecore");
        if (!Files.exists(localCasaEcore)) {
            Files.copy(sourceCasaEcore, localCasaEcore, StandardCopyOption.REPLACE_EXISTING);
        }
        Resource ecoreRes = rs.getResource("CASA.ecore");
        EPackage ePackage = (EPackage) ecoreRes.getContents().get(0);
        rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), ePackage);
        module.getImports().clear();
        module.getImports().add(ePackage);
        rebindToImportedPackage(module, ePackage);
        Resource res = rs.createResource(henshinPath.getFileName().toString());
        res.getContents().add(module);
        res.save(null);
        return henshinPath;
    }

    private static void rebindToImportedPackage(Module module, EPackage importedPackage) {
        Map<String, EClass> classesByName = new HashMap<>();
        Map<String, EStructuralFeature> featuresByOwnerAndName = new HashMap<>();
        indexPackage(importedPackage, classesByName, featuresByOwnerAndName);

        TreeIterator<EObject> it = module.eAllContents();
        while (it.hasNext()) {
            EObject next = it.next();
            if (next instanceof Node node && node.getType() != null) {
                EClass rebound = classesByName.get(node.getType().getName());
                if (rebound != null) {
                    node.setType(rebound);
                }
            } else if (next instanceof Edge edge && edge.getType() != null) {
                EReference rebound = (EReference) featuresByOwnerAndName
                        .get(featureKey(edge.getType().getEContainingClass().getName(), edge.getType().getName()));
                if (rebound != null) {
                    edge.setType(rebound);
                }
            } else if (next instanceof Attribute attribute && attribute.getType() != null) {
                EAttribute rebound = (EAttribute) featuresByOwnerAndName
                        .get(featureKey(attribute.getType().getEContainingClass().getName(), attribute.getType().getName()));
                if (rebound != null) {
                    attribute.setType(rebound);
                }
            }
        }
    }

    private static void indexPackage(EPackage ePackage, Map<String, EClass> classesByName,
            Map<String, EStructuralFeature> featuresByOwnerAndName) {
        for (EClassifier classifier : ePackage.getEClassifiers()) {
            if (classifier instanceof EClass eClass) {
                classesByName.put(eClass.getName(), eClass);
                for (EStructuralFeature feature : eClass.getEAllStructuralFeatures()) {
                    featuresByOwnerAndName.put(featureKey(feature.getEContainingClass().getName(), feature.getName()), feature);
                }
            }
        }
        for (EPackage subpackage : ePackage.getESubpackages()) {
            indexPackage(subpackage, classesByName, featuresByOwnerAndName);
        }
    }

    private static String featureKey(String ownerName, String featureName) {
        return ownerName + "::" + featureName;
    }

    private static Path resolveCasaEcore() {
        Path cwd = Path.of("").toAbsolutePath().normalize();
        Path[] candidates = new Path[] {
                cwd.resolve("src/thesis/CASA.ecore"),
                cwd.resolve("code/src/thesis/CASA.ecore"),
                cwd.getParent() == null ? null : cwd.getParent().resolve("code/src/thesis/CASA.ecore"),
                cwd.getParent() == null ? null : cwd.getParent().resolve("src/thesis/CASA.ecore")
        };
        for (Path candidate : candidates) {
            if (candidate != null && Files.exists(candidate)) {
                return candidate.normalize();
            }
        }
        throw new IllegalStateException("Could not resolve CASA.ecore from cwd: " + cwd);
    }
}
