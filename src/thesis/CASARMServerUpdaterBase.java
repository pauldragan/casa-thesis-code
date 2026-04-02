package thesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.impl.EngineImpl;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CASA.CASAPackage;

public abstract class CASARMServerUpdaterBase {
    private static final Logger logger = LoggerFactory.getLogger(CASARMServerUpdaterBase.class);
	
	private static final String BASEDIR = "src/thesis";

	private static final String ECOREPATH = "CASA.ecore";
	private static final String MODELPATH = "CASA.xmi";
		
	protected static final String IDENTIFYSTATERULESPATH = "default.henshin";
	protected final String CHANGESERVERRULESPATH;
	protected final Map<String, Rule> identifyStateRules;
	protected final Map<String, Rule> changeServerRules;
	
    // protected static final String funcName = "ServeStandardAdsFunction";
    protected static final String funcName = "DoSProtectionFunction";
    protected static final String compNameBase = "Server_";
	
	protected Engine engine;
	
	protected HenshinResourceSet rs;
	
	public enum UpdateAction {
		ADD_SERVER,
		REMOVE_SERVER,
		NOTHING
	}
	
	public CASARMServerUpdaterBase(String changeServerRulesPath) {
		this.rs = new HenshinResourceSet(BASEDIR);
		rs.registerDynamicEPackages(ECOREPATH);
		rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), 
				CASAPackage.eINSTANCE);
		
		this.CHANGESERVERRULESPATH = changeServerRulesPath;
		
		this.identifyStateRules = HenshinUtils.loadRules(IDENTIFYSTATERULESPATH, this.rs);
		this.changeServerRules = HenshinUtils.loadRules(CHANGESERVERRULESPATH, this.rs);
		
		this.engine = new EngineImpl();
		
		this.engine.getOptions().put(Engine.OPTION_DETERMINISTIC, false);
	}
	
	public CASARMServerUpdaterBase() {
		this("CASAUpdateServerRules.henshin");
	}
	
	protected int determineServerNumberFromModel(EGraph model) {
//		Rule rule =  this.identifyStateRules.get("IdentifyServerInstance");
//		
//		List<Pair<String,String>> params = new ArrayList<>();
//		params.add(new ImmutablePair<String, String>("functionName", funcName));
//		
//		int n = 0;
//		while (HenshinUtils.applyModelChangeRule(model, rule, engine, params)) {
//			n++;
//		}
		
		List<Match> matches = HenshinUtils.applyMatchRule(model, this.identifyStateRules.get("IdentifyServerInstance"), engine);
		if (matches == null) {
			return 0;
		} else {
			return matches.size();
		}
	}
	
	protected abstract void changeServer(EGraph model, int oldNumberOfServers, int newNumberOfServers);

	public void updateModel(EGraph model, int newNumberOfServers) {
		logger.info("Updating servers for newNumberOfServers=" + newNumberOfServers);
		int oldNumberOfServers = this.determineServerNumberFromModel(model);
		this.changeServer(model, oldNumberOfServers, newNumberOfServers);
	}
	
	public void updateModel(EGraph model, UpdateAction action) {	
		int change = 0;
		switch (action) {
		case NOTHING:
			change = 0;
			break;
		case ADD_SERVER:
			change = 1;
			break;
		case REMOVE_SERVER:
			change = -1;
			break;
		}
		
		if (change == 0) {
			return;
		}
		
		int oldNumberOfServers = this.determineServerNumberFromModel(model);
		int newNumberOfServers = oldNumberOfServers + change;
		logger.info("Updating servers for action=" + newNumberOfServers);
		this.changeServer(model, oldNumberOfServers, newNumberOfServers);
	}
}
