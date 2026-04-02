package thesis;

import java.util.List;
import java.util.Map;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EGraphImpl;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CASA.CASAPackage;

public abstract class CASARMDimmerUpdaterBase {
    private static final Logger logger = LoggerFactory.getLogger(CASARMDimmerUpdaterBase.class);
	
	private static final String BASEDIR = "src/thesis";

	private static final String ECOREPATH = "CASA.ecore";
	private static final String MODELPATH = "CASA.xmi";
	
	protected static final double DIMMERSTEP = 0.25;
	
	private static final String IDENTIFYSTATERULESPATH = "default.henshin";
	private static final String CHANGEDIMMERRULESPATH = "CASAUpdateDimmerRules.henshin";
	protected final Map<String, Rule> identifyStateRules;
	protected final Map<String, Rule> changeDimmerRules;
	
	protected Engine engine;
	
	protected HenshinResourceSet rs;
	
	public CASARMDimmerUpdaterBase() {
		this.rs = new HenshinResourceSet(BASEDIR);
		rs.registerDynamicEPackages(ECOREPATH);
		rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), 
				CASAPackage.eINSTANCE);
		
		this.identifyStateRules = HenshinUtils.loadRules(IDENTIFYSTATERULESPATH, this.rs);
		this.changeDimmerRules = HenshinUtils.loadRules(CHANGEDIMMERRULESPATH, this.rs);
		
		this.engine = new EngineImpl();
		
		this.engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);
	}
	
	protected double determineDimmerValueFromModel(EGraph model) {
		List<Match> matches;
		if (!(matches = HenshinUtils.applyMatchRule(model, this.identifyStateRules.get("IdentifyBehavioralTargetedAds"), engine)).isEmpty()) {
			return 1.0;
		} else if (!(matches = HenshinUtils.applyMatchRule(model, this.identifyStateRules.get("IdentifyLocationTargetedAds"), engine)).isEmpty()) {
			return 0.75;
		} else if (!(matches = HenshinUtils.applyMatchRule(model, this.identifyStateRules.get("IdentifyTargetedAds"), engine)).isEmpty()) {
			return 0.5;
		} else if (!(matches = HenshinUtils.applyMatchRule(model, this.identifyStateRules.get("IdentifyStandardAds"), engine)).isEmpty()) {
			return 0.25;
		} else {
			return 0.0;
		}
	}
	
	protected abstract void changedDimmer(EGraph model, double oldDimmerValue, double newDimmerValue);
	
	public void updateModel(EGraph model, double newDimmerValue) {
		logger.info("Updating dimmer for newDimmerValue=" + newDimmerValue);
		double oldDimmerValue = this.determineDimmerValueFromModel(model);
		this.changedDimmer(model, oldDimmerValue, newDimmerValue);
	}
	
}
