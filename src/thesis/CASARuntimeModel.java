package thesis;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.eclipse.emf.common.util.BasicDiagnostic;
import org.eclipse.emf.common.util.Diagnostic;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.util.Diagnostician;
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.interpreter.impl.LoggingApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.Unit;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
//import org.eclipse.ocl.ecore.EcoreEnvironmentFactory;
//import org.eclipse.ocl.ecore.OCL;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import org.eclipse.ocl.pivot.evaluation.Executor;
//import org.eclipse.ocl.pivot.utilities.PivotUtil;

import CASA.CASAPackage;
import CASA.System;
import thesis.CASARMServerUpdaterBase.UpdateAction;

public class CASARuntimeModel {

	private static final Logger logger = LoggerFactory.getLogger(CASARuntimeModel.class);

	private static final StatsCollector collector = StatsCollector.getInstance();

	private static final String BASEDIR = "src/thesis";

	private static final String ECOREPATH = "CASA.ecore";
	private String MODELPATH = "CASA.xmi";
	
	private static final double DIMMERSTEP = 0.25;
	
	private static final String IDENTIFYSTATERULESPATH = "default.henshin";
	private static final String CHANGEDIMMERRULESPATH = "CASAUpdateDimmerRules.henshin";
	private final Map<String, Rule> identifyStateRules;
	private final Map<String, Rule> changeDimmerRules;
	
	private CASARMDimmerUpdaterBase dimmerUpdater;
	private CASARMServerUpdaterBase serverUpdater;
	private CASA.System modelRoot;
	private Engine engine;
	private EGraph graph;

	private HenshinResourceSet rs;

	public CASARuntimeModel(String modelPath, CASARMDimmerUpdaterBase dimmerUpdater, CASARMServerUpdaterBase serverUpdater) {
		this.rs = new HenshinResourceSet(BASEDIR);
		rs.registerDynamicEPackages(ECOREPATH);
		rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), 
				CASAPackage.eINSTANCE);
		
		this.MODELPATH = modelPath;
		
		this.modelRoot = HenshinUtils.loadModel(MODELPATH, this.rs);
		this.identifyStateRules = HenshinUtils.loadRules(IDENTIFYSTATERULESPATH, this.rs);
		this.changeDimmerRules = HenshinUtils.loadRules(CHANGEDIMMERRULESPATH, this.rs);
		
		this.engine = new EngineImpl();
		this.graph = new EGraphImpl(this.modelRoot);
		
		this.engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);
		
		this.dimmerUpdater = dimmerUpdater;
		this.serverUpdater = serverUpdater;
	}
	
	public void update(SWIMReceivedStruct swimReceivedStruct) {
		this.dimmerUpdater.updateModel(this.graph, swimReceivedStruct.observation.current_dimmer);
		// this.serverUpdater.updateModel(graph, (int) swimReceivedStruct.observation.active_servers);
		this.serverUpdater.updateModel(graph, (int) swimReceivedStruct.observation.servers);
	}

	public CASASelfAdaptationAnalysisModel generateAnalysisModel(SWIMAdaptation adaptation) {	
		EGraph newGraph = new EGraphImpl(EcoreUtil.copy(this.modelRoot));
		CASASelfAdaptationAnalysisModel newModel = new CASASelfAdaptationAnalysisModel(newGraph);
		this.dimmerUpdater.updateModel(newGraph, adaptation.dimmer);
		
		// Get kind of server adaptation
		CASARMServerUpdaterBase.UpdateAction action;
		if (adaptation.add_server) {
			action = UpdateAction.ADD_SERVER;
		} else if (adaptation.remove_server) {
			action = UpdateAction.REMOVE_SERVER;
		} else {
			action = UpdateAction.NOTHING;
		}
		this.serverUpdater.updateModel(newGraph, action);
		
		return newModel;
	}
	
	public boolean validateSelf() {
////		org.eclipse.ocl.xtext.oclinecore.OCLinEcoreStandaloneSetup.doSetup(); 
////		
////		OCL ocl = OCL.newInstance(new EcoreEnvironmentFactory(this.rs.getPackageRegistry()));
////		OCL.Helper helper = ocl.createOCLHelper();
////	    helper.setContext(this.modelRoot.eClass());
////        if (helper.getContextClassifier() == this.modelRoot) 
////        {
////            helper.setContext(this.modelRoot.eClass());
////        }
////		
////        
////		Executor exec = PivotUtil.getExecutor(modelRoot);
//		
////		CASAValidator validator = CASAValidator.INSTANCE;
//		Diagnostician diagnostician = Diagnostician.INSTANCE;
//		
//		Map<Object, Object> context = diagnostician.createDefaultContext();
//		BasicDiagnostic diagnostics = diagnostician.createDefaultDiagnostic(modelRoot);
////		boolean result = validator.validate(modelRoot, diagnostics, context);
//		// boolean result = validator.validateSystem(modelRoot, diagnostics, context);
//		
//		boolean result = false;
//		for (CASA.Purpose p : this.modelRoot.getPurposes()) {
//			 result = validator.validatePurpose(p, diagnostics, context);
////			result = validator.validate(p, diagnostics, context);
//		}
//		return result;
//		
//		// OCL.initialize(rs);
//		// return validateModel(this.modelRoot);
		return true;
	}
	
	public static boolean validateModel(EGraph graph) {
		return true;
	}
	
	protected static boolean validateModelPurpose(EGraph graph) {
		return true;
	}
	
	protected static boolean validateModelVulnerability(EGraph graph) {
		return true;
	}

}
