package thesis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CASARMServerUpdaterDatasubjects extends CASARMServerUpdaterBase{
    private static final Logger logger = LoggerFactory.getLogger(CASARMServerUpdaterDatasubjects.class);
       
    protected static final String compNameBase = "Datasubject_";
    
    public CASARMServerUpdaterDatasubjects() {
    	super("CASA_scalability_rules.henshin");
    }
    
    @Override
    protected int determineServerNumberFromModel(EGraph model) {
		List<Match> matches = HenshinUtils.applyMatchRule(model, this.identifyStateRules.get("IdentifyDatasubjectInstance"), engine);
		if (matches == null) {
			return 0;
		} else {
			return matches.size();
		}
    }
        
	@Override
	protected void changeServer(EGraph model, int oldNumberOfServers, int newNumberOfServers) {
		if (oldNumberOfServers < newNumberOfServers) {
			addServers(model, oldNumberOfServers, newNumberOfServers);
		} else if (oldNumberOfServers > newNumberOfServers) {
			removeServers(model, oldNumberOfServers, newNumberOfServers);
		} else {
			// do nothing if equal
		}
	}
	
	private void addServers(EGraph model, int oldServers, int newServers) {
		for (int server = oldServers + 1; server <= newServers; server += 1) {
			Rule rule = this.changeServerRules.get("AddDataSubject");
			String serverName = compNameBase + server;
			
			List<Pair<String,String>> params = new ArrayList<>();
			params.add(new ImmutablePair<String, String>("datasubjectName", serverName));
			// params.add(new ImmutablePair<String, String>("functionName", funcName));
			
			logger.info("Adding datasubject=" + serverName);
			HenshinUtils.applyModelChangeRule(model, rule, engine, params);
		}
	}
	
	private void removeServers(EGraph model, int oldServers, int newServers) {
		for (int server = oldServers; server > newServers; server -= 1) {
			Rule rule = this.changeServerRules.get("RemoveDataSubject");
			String serverName = compNameBase + server;
			
			List<Pair<String,String>> params = new ArrayList<>();
			params.add(new ImmutablePair<String, String>("datasubjectName", serverName));
			// params.add(new ImmutablePair<String, String>("functionName", funcName));
			
			logger.info("Removing datasubject=" + serverName);
			HenshinUtils.applyModelChangeRule(model, rule, engine, params);
		}
	}

}
