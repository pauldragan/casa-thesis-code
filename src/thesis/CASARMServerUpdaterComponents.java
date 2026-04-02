package thesis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CASARMServerUpdaterComponents extends CASARMServerUpdaterBase{
    private static final Logger logger = LoggerFactory.getLogger(CASARMServerUpdaterComponents.class);
        
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
	
	protected void addServers(EGraph model, int oldServers, int newServers) {
		for (int server = oldServers + 1; server <= newServers; server += 1) {
			Rule rule = this.changeServerRules.get("AddServer");
			String serverName = compNameBase + server;
			
			List<Pair<String,String>> params = new ArrayList<>();
			params.add(new ImmutablePair<String, String>("serverName", serverName));
			params.add(new ImmutablePair<String, String>("functionName", funcName));
			
			logger.info("Adding server=" + serverName);
			HenshinUtils.applyModelChangeRule(model, rule, engine, params);
		}
	}
	
	protected void removeServers(EGraph model, int oldServers, int newServers) {
		for (int server = oldServers; server > newServers; server -= 1) {
			Rule rule = this.changeServerRules.get("RemoveServer");
			String serverName = compNameBase + server;
			
			List<Pair<String,String>> params = new ArrayList<>();
			params.add(new ImmutablePair<String, String>("serverName", serverName));
			params.add(new ImmutablePair<String, String>("functionName", funcName));
			
			logger.info("Removing server=" + serverName);
			HenshinUtils.applyModelChangeRule(model, rule, engine, params);
		}
	}

}
