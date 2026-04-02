package thesis;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.StreamSupport;

import org.apache.commons.lang3.tuple.Pair;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Engine;
import org.eclipse.emf.henshin.interpreter.Match;
import org.eclipse.emf.henshin.interpreter.UnitApplication;
import org.eclipse.emf.henshin.interpreter.impl.LoggingApplicationMonitor;
import org.eclipse.emf.henshin.interpreter.impl.UnitApplicationImpl;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Parameter;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import CASA.CASAPackage;

public class HenshinUtils {
	private static final Logger logger = LoggerFactory.getLogger(HenshinUtils.class);
	public static Map<String, Rule> loadRules(String path, HenshinResourceSet rs)  {
		Module rules = rs.getModule(path, true);
		Map<String, Rule> rulesMap = new HashMap<>();

		Iterable<Rule> allRules = rules.getAllRules();
		for (Rule r : allRules) {
			logger.info("Rule: " + r);
			rulesMap.put(r.getName(), r);
		}
		return rulesMap;
	}
	
	public static CASA.System loadModel(String path, HenshinResourceSet rs) {
		Resource res = rs.getResource(path);

		EObject modelRootAbs = res.getContents().get(0);
		logger.info("Type of the root: " + modelRootAbs.getClass());
		CASA.System modelRoot = (CASA.System) modelRootAbs;
		logger.info("First item: " + modelRoot.getFunctions().get(0));	
		
		return modelRoot;
	}
	
	public static void saveModel(String name, String basedir, EObject model) throws RuntimeException {
		HenshinResourceSet rs = new HenshinResourceSet(basedir);
		Resource res = rs.createResource(name);
		res.getContents().add(model);

		try {
			res.save(null);
		} catch (IOException e) {
			e.printStackTrace();
			throw new RuntimeException("Could not save model");
		}
	}
	
	public static boolean applyModelChangeRule(EGraph graph, Rule rule, Engine engine) {	
		UnitApplication application = new UnitApplicationImpl(engine, graph, rule, null);

		return application.execute(new LoggingApplicationMonitor());
	}
	
	public static boolean applyModelChangeRule(EGraph graph, Rule rule, Engine engine, List<Pair<String, String>> params) {	
		UnitApplication application = new UnitApplicationImpl(engine, graph, rule, null);
		for (var param : params) {
			application.setParameterValue(param.getLeft(), param.getRight());
		}

		return application.execute(new LoggingApplicationMonitor());
	}
	
	public static List<Match> applyMatchRule(EGraph graph, Rule rule, Engine engine) {
		Iterable<Match> matches = engine.findMatches(rule, graph, null);
		return StreamSupport.stream(matches.spliterator(), false).toList();
	}
	
}
