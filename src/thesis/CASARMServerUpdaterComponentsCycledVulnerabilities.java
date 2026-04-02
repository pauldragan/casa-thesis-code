package thesis;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CASARMServerUpdaterComponentsCycledVulnerabilities extends CASARMServerUpdaterComponents {
    private static final Logger logger = LoggerFactory.getLogger(CASARMServerUpdaterComponentsCycledVulnerabilities.class);

    private static final String VULRULEBASE = "AddServer_CVE";
    private static final int MAXVULS = 3;
	
	@Override
	protected void addServers(EGraph model, int oldServers, int newServers) {
		for (int server = oldServers + 1; server <= newServers; server += 1) {
			Rule rule = this.changeServerRules.get(
					getRuleName(server, MAXVULS)
					);
			String serverName = compNameBase + server;
			
			List<Pair<String,String>> params = new ArrayList<>();
			params.add(new ImmutablePair<String, String>("serverName", serverName));
			params.add(new ImmutablePair<String, String>("functionName", funcName));
			
			logger.info("Adding server=" + serverName);
			HenshinUtils.applyModelChangeRule(model, rule, engine, params);
		}
	}
	
	private String getRuleName(int server, int maxVulnerabilities) {
		int vulnerabilityIndex = maxVulnerabilities % server + 1;
		return VULRULEBASE + vulnerabilityIndex;
	}
}
