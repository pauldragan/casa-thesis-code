package thesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang3.tuple.ImmutablePair;
import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.model.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CASARMServerUpdaterPurposes extends CASARMServerUpdaterBase{
    private static final Logger logger = LoggerFactory.getLogger(CASARMServerUpdaterPurposes.class);
      
    protected final Map<Integer, String> allowedPurposes;
    
    protected final String addRuleName;
    protected final String removeRuleName;
    protected final String identifyRuleName;
    
    public CASARMServerUpdaterPurposes() {
//    	this("AddConsent", "RemoveConsent", "IdentifyConsentInstance");
    	this("AddPersonalData", "RemovePersonalData", "IdentifyPersonalDataInstance");
    }
    
    public CASARMServerUpdaterPurposes(String addRuleName, String removeRuleName, String identifyRuleName) {
    	super("CASA_scalability_rules.henshin");
    	this.addRuleName = addRuleName;
    	this.removeRuleName = removeRuleName;
    	this.identifyRuleName = identifyRuleName;
    	this.allowedPurposes = Map.ofEntries(Map.entry(1, "StandardAds"),
    										 Map.entry(2, "TargetedAds"),
    										 Map.entry(3, "OnlineAdvertising"),
    										 Map.entry(4, "BehaviorTargetedAds"),
    										 Map.entry(5, "LocationTargetedAds"),
    										 Map.entry(6, "Marketing"),
    										 Map.entry(7, "Health"),
    										 Map.entry(8, "Humanitarian"),
    										 Map.entry(9, "Journalistic"),
    										 Map.entry(10, "Judicial"),
    										 Map.entry(11, "Profiling"),
    										 Map.entry(12, "FirstPartyProfiling"),
    										 Map.entry(13, "ThirdPartyProfiling"),
    										 Map.entry(14, "PublicInterest"),
    										 Map.entry(15, "Research"),
    										 Map.entry(16, "Security"),
    										 Map.entry(17, "Statistic"),
    										 Map.entry(18, "Test_1"),
    										 Map.entry(19, "Test_2"),
    										 Map.entry(20, "Test_3"),
    										 Map.entry(21, "Test_4"),
    										 Map.entry(22, "Test_5"),
    										 Map.entry(23, "Test_6"),
    										 Map.entry(24, "Test_7"),
    										 Map.entry(25, "Test_8"),
    										 Map.entry(26, "Test_9"),
    										 Map.entry(27, "Test_10"),
    										 Map.entry(28, "Test_11"),
    										 Map.entry(29, "Test_12"),
    										 Map.entry(30, "Test_13"),
    										 Map.entry(31, "Test_14"),
    										 Map.entry(32, "Test_15"),
    										 Map.entry(33, "Test_16"),
    										 Map.entry(34, "Test_17"),
    										 Map.entry(35, "Test_18"),
    										 Map.entry(36, "Test_19"),
    										 Map.entry(37, "Test_20"),
    										 Map.entry(38, "Test_21"),
    										 Map.entry(39, "Test_22"),
    										 Map.entry(40, "Test_23"),
    										 Map.entry(41, "Test_24"),
    										 Map.entry(42, "Test_25"),
    										 Map.entry(43, "Test_26"),
    										 Map.entry(44, "Test_27"),
    										 Map.entry(45, "Test_28"),
    										 Map.entry(46, "Test_29"),
    										 Map.entry(47, "Test_30"),
    										 Map.entry(48, "Test_31"),
    										 Map.entry(49, "Test_32"),
    										 Map.entry(50, "Test_33"),
    										 Map.entry(51, "Test_34"),
    										 Map.entry(52, "Test_35"),
    										 Map.entry(53, "Test_36"),
    										 Map.entry(54, "Test_37"),
    										 Map.entry(55, "Test_38"),
    										 Map.entry(56, "Test_39"),
    										 Map.entry(57, "Test_40"),
    										 Map.entry(58, "Test_41"),
    										 Map.entry(59, "Test_42"),
    										 Map.entry(60, "Test_43"),
    										 Map.entry(61, "Test_44"),
    										 Map.entry(62, "Test_45"),
    										 Map.entry(63, "Test_46"),
    										 Map.entry(64, "Test_47"),
    										 Map.entry(65, "Test_48"),
    										 Map.entry(66, "Test_49"),
    										 Map.entry(67, "Test_50"),
    										 Map.entry(68, "Test_51"),
    										 Map.entry(69, "Test_52"),
    										 Map.entry(70, "Test_53"),
    										 Map.entry(71, "Test_54"),
    										 Map.entry(72, "Test_55"),
    										 Map.entry(73, "Test_56"),
    										 Map.entry(74, "Test_57"),
    										 Map.entry(75, "Test_58"),
    										 Map.entry(76, "Test_59"),
    										 Map.entry(77, "Test_60"),
    										 Map.entry(78, "Test_61"),
    										 Map.entry(79, "Test_62"),
    										 Map.entry(80, "Test_63"),
    										 Map.entry(81, "Test_64")
    			);
    }
    
    @Override
    protected int determineServerNumberFromModel(EGraph model) {
		List<Match> matches = HenshinUtils.applyMatchRule(model, this.identifyStateRules.get(this.identifyRuleName), engine);
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
			Rule rule = this.changeServerRules.get(this.addRuleName);
			String serverName = this.allowedPurposes.get(server);
			if (serverName == null) {
				throw new RuntimeException("Purpose not allowed for i=" + server);
			}
			
			List<Pair<String,String>> params = new ArrayList<>();
			params.add(new ImmutablePair<String, String>("purposeName", serverName));
			// params.add(new ImmutablePair<String, String>("functionName", funcName));
			
			logger.info("Adding purpose=" + serverName);
			HenshinUtils.applyModelChangeRule(model, rule, engine, params);
		}
	}
	
	private void removeServers(EGraph model, int oldServers, int newServers) {
		for (int server = oldServers; server > newServers; server -= 1) {
			Rule rule = this.changeServerRules.get(this.removeRuleName);
			String serverName = this.allowedPurposes.get(server);
			if (serverName == null) {
				throw new RuntimeException("Purpose not allowed for i=" + server);
			}
			
			List<Pair<String,String>> params = new ArrayList<>();
			params.add(new ImmutablePair<String, String>("purposeName", serverName));
			// params.add(new ImmutablePair<String, String>("functionName", funcName));
			
			logger.info("Removing purpose=" + serverName);
			HenshinUtils.applyModelChangeRule(model, rule, engine, params);
		}
	}

}
