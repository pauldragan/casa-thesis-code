package thesis.evaluation.version3.apply;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EStructuralFeature;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.xmi.XMLResource;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.SequentialUnit;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import CASA.CASAPackage;
final class TransformationApplicatorV3 {

    ApplicationResult apply(ApplicationInput input, Path outXmiPath) {
        ApplicationResult result = new ApplicationResult();
        result.modelIndex = input.modelIndex();
        result.modelId = input.modelId();
        result.adaptationIndex = input.adaptationIndex();
        result.adaptationId = input.adaptationId();
        result.caseSlug = input.caseSlug();
        result.sourceModelPath = input.sourceModelPath().toString();
        result.henshinPath = input.henshinPath().toString();
        result.prospectiveModelPath = outXmiPath.toString();
        result.status = "STARTED";
        try {
            Path henshinDir = input.henshinPath().getParent();
            HenshinResourceSet rs = new HenshinResourceSet(henshinDir.toAbsolutePath().toString());
            rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
            rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
            rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                    new XMIResourceFactoryImpl());
            if (Files.exists(henshinDir.resolve("CASA.ecore"))) {
                rs.registerDynamicEPackages("CASA.ecore");
            }

            Resource sourceRes = rs.getResource(URI.createFileURI(input.sourceModelPath().toAbsolutePath().toString()), true);
            EObject sourceRoot = sourceRes.getContents().get(0);
            EObject workingRoot = EcoreUtil.copy(sourceRoot);
            result.sourceFunctions = countMany(sourceRoot, "functions");
            result.sourceComponents = countMany(sourceRoot, "components");

            Module module = rs.getModule(input.henshinPath().getFileName().toString(), true);
            Unit mainUnit = resolveMainUnit(module);
            result.appliedUnitName = mainUnit.getName();

            EGraph graph = new EGraphImpl(workingRoot);
            Engine engine = new EngineImpl();
            engine.getOptions().put(Engine.OPTION_DETERMINISTIC, Boolean.TRUE);
            UnitApplication application = new UnitApplicationImpl(engine, graph, mainUnit, null);

            long start = System.nanoTime();
            boolean applied = application.execute(null);
            result.executionTimeMillis = (System.nanoTime() - start) / 1_000_000L;
            result.applicationSucceeded = applied;
            if (!applied) {
                result.status = "NO_APPLICABLE_UNIT";
                result.errorCode = "NO_APPLICABLE_UNIT";
                result.errorMessage = "Henshin unit did not apply to source model";
                return result;
            }

            result.resultFunctions = countMany(workingRoot, "functions");
            result.resultComponents = countMany(workingRoot, "components");
            result.deltaFunctions = result.resultFunctions - result.sourceFunctions;
            result.deltaComponents = result.resultComponents - result.sourceComponents;

            writeResultModel(rs, workingRoot, outXmiPath);
            result.emfValidationOk = validateResultModel(outXmiPath, henshinDir);
            result.oracleCheckOk = checkOracle(input, result);
            result.status = result.emfValidationOk && result.oracleCheckOk ? "OK" : "INVALID";
            if (!result.emfValidationOk) {
                result.errorCode = "EMF_VALIDATION_FAILED";
                result.errorMessage = "Reload or Diagnostician validation failed";
            } else if (!result.oracleCheckOk) {
                result.errorCode = "ORACLE_CHECK_FAILED";
                result.errorMessage = "Observed function/component deltas differ from expected deltas";
            }
            return result;
        } catch (Exception e) {
            result.status = "FAILED";
            result.errorCode = e.getClass().getSimpleName();
            result.errorMessage = e.getMessage() == null ? "" : e.getMessage();
            return result;
        }
    }

    private static Unit resolveMainUnit(Module module) {
        for (Unit unit : module.getUnits()) {
            if (unit instanceof SequentialUnit) {
                return unit;
            }
        }
        if (!module.getUnits().isEmpty()) {
            return module.getUnits().get(0);
        }
        throw new IllegalStateException("No executable unit found in module: " + module.getName());
    }

    private static int countMany(EObject root, String featureName) {
        EStructuralFeature feature = root.eClass().getEStructuralFeature(featureName);
        if (feature == null) {
            throw new IllegalStateException("Missing feature '" + featureName + "' on " + root.eClass().getName());
        }
        Object value = root.eGet(feature);
        if (value instanceof EList<?> list) {
            return list.size();
        }
        throw new IllegalStateException("Feature '" + featureName + "' is not multi-valued on " + root.eClass().getName());
    }

    private static void writeResultModel(HenshinResourceSet baseRs, EObject root, Path outXmiPath) throws IOException {
        Files.createDirectories(outXmiPath.getParent());
        HenshinResourceSet writeRs = new HenshinResourceSet(outXmiPath.getParent().toAbsolutePath().toString());
        writeRs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
        writeRs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        writeRs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());
        Resource outRes = writeRs.createResource(URI.createFileURI(outXmiPath.toAbsolutePath().toString()));
        outRes.getContents().add(EcoreUtil.copy(root));
        Map<Object, Object> options = new HashMap<>();
        options.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);
        outRes.save(options);
    }

    private static boolean validateResultModel(Path outXmiPath, Path henshinDir) throws IOException {
        HenshinResourceSet rs = new HenshinResourceSet(henshinDir.toAbsolutePath().toString());
        rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("xmi", new XMIResourceFactoryImpl());
        rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
                new XMIResourceFactoryImpl());
        if (Files.exists(henshinDir.resolve("CASA.ecore"))) {
            rs.registerDynamicEPackages("CASA.ecore");
        }
        Resource reloaded = rs.getResource(URI.createFileURI(outXmiPath.toAbsolutePath().toString()), true);
        if (reloaded.getContents().isEmpty()) {
            return false;
        }
        EObject root = reloaded.getContents().get(0);
        if (!"System".equals(root.eClass().getName())) {
            return false;
        }
        if (!EcoreUtil.UnresolvedProxyCrossReferencer.find(reloaded).isEmpty()) {
            return false;
        }
        return true;
    }

    private static boolean checkOracle(ApplicationInput input, ApplicationResult result) {
        int expectedDeltaFunctions = input.expectedAddedFunctions() - input.expectedRemovedFunctions();
        int expectedDeltaComponents = input.expectedAddedComponents() - input.expectedRemovedComponents();
        return result.deltaFunctions == expectedDeltaFunctions && result.deltaComponents == expectedDeltaComponents;
    }
}
