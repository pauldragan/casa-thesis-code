package thesis;

import java.io.File;
import java.io.IOException;
import java.util.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.resource.Resource;

import org.eclipse.emf.henshin.model.*;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.impl.HenshinFactoryImpl;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import org.eclipse.emf.henshin.interpreter.*;
import org.eclipse.emf.henshin.interpreter.impl.*;

import CASA.CASAPackage;

/**
 * Builds Henshin rules (programmatically) that CREATE structure which leads to
 * consent violations, and applies them with fixed matches / parameters.
 *
 * This version creates rules ON THE FLY with randomly chosen concrete subtypes
 * of FuncPersData and Component (based on the generated CASAPackage).
 *
 * Extended to optionally attach a configurable number of NON-VIOLATING purposes
 * to each created function.
 */
public class CASAAdaptationGenerator {

	private static final HenshinFactory HF = HenshinFactoryImpl.eINSTANCE;

	// ---- purpose names ----
	public static final String P_VIOL_UNREL = "ViolationUnrelated";
	public static final String P_VIOL_GEN   = "ViolationGeneralization";
	public static final String P_BASE       = "Base"; // considered non-violating

	// ---- rule names (base) ----
	private static final String R_ADD_UNRELATED     = "AddUnrelatedPurposeViolation";
	private static final String R_ADD_SPECIAL       = "AddSpecializationPurposeViolation";
	private static final String R_CREATE_RISK_FUNC  = "CreateRiskFunction";
	private static final String R_ATTACH_PD         = "AttachPDToFunction";
	private static final String R_ADD_COMP          = "AddComponentToFunction";
	private static final String R_ADD_VULN          = "AddVulnToComponent";
	private static final String R_ATTACH_PD_DIRECT  = "AttachPDToFunctionDirect";
	private static final String R_ZERO_RISK         = "ZeroRiskOnConsent";
	private static final String R_ATTACH_PURPOSE    = "AttachPurposeToFunction";

	// parameters
	private static final String PAR_FUNC_NAME = "fname";
	private static final String PAR_CVE_NAME  = "cvename";

	public Module buildStructuralModule() {
		Module m = HF.createModule();
		m.setName("CASA_Adaptation_Structural");

		// rules independent of concrete subtypes:
		m.getUnits().add(buildAttachPDToFunctionDirectRule());
		m.getUnits().add(buildZeroRiskOnConsentRule());
		m.getUnits().add(buildAddVulnToComponentRule());
		m.getUnits().add(buildAttachPurposeToFunctionRule());

		return m;
	}

	// --- subtype helpers ---------------------------------------------------

	private static List<EClass> concreteSubtypesOf(EClass base) {
		List<EClass> out = new ArrayList<>();
		for (EClassifier cl : CASAPackage.eINSTANCE.getEClassifiers()) {
			if (cl instanceof EClass) {
				EClass ec = (EClass) cl;
				if (!ec.isAbstract() && !ec.isInterface() && ec.getEAllSuperTypes().contains(base)) {
					out.add(ec);
				}
			}
		}
		return out;
	}

	private static EClass pickRandomSubtype(EClass base, Random rnd) {
		List<EClass> subs = concreteSubtypesOf(base);
		if (subs.isEmpty()) return base;
		return subs.get(rnd.nextInt(subs.size()));
	}

	// ---------------------------------------------------------------------
	// Rules 
	// ---------------------------------------------------------------------

	private Rule buildZeroRiskOnConsentRule() {
	    Rule r = HF.createRule();
	    r.setName(R_ZERO_RISK);

	    Graph lhs = HF.createGraph();
	    r.setLhs(lhs);
	    Node pd   = HF.createNode(lhs, CASAPackage.Literals.PERSONAL_DATA, "pd");
	    Node cons = HF.createNode(lhs, CASAPackage.Literals.CONSENT,       "cons");
	    HF.createEdge(pd,   cons, CASAPackage.Literals.PERSONAL_DATA__SUBJECT_OF_CONSENT);
	    HF.createEdge(cons, pd,   CASAPackage.Literals.CONSENT__FOR_PERSONAL_DATA);

	    Graph rhs = HF.createGraph();
	    r.setRhs(rhs);
	    Node pd2   = HF.createNode(rhs, CASAPackage.Literals.PERSONAL_DATA, "pd2");
	    Node cons2 = HF.createNode(rhs, CASAPackage.Literals.CONSENT,       "cons2");
	    HF.createEdge(pd2,   cons2, CASAPackage.Literals.PERSONAL_DATA__SUBJECT_OF_CONSENT);
	    HF.createEdge(cons2, pd2,   CASAPackage.Literals.CONSENT__FOR_PERSONAL_DATA);

	    r.getMappings().add(HF.createMapping(pd,   pd2));
	    r.getMappings().add(HF.createMapping(cons, cons2));

	    Attribute lvl = HF.createAttribute();
	    lvl.setType(CASAPackage.Literals.CONSENT__INFORMED_RISK_LEVEL);
	    lvl.setValue("0.0");
	    cons2.getAttributes().add(lvl);

	    return r;
	}

	private Rule buildAttachPDToFunctionDirectRule() {
	    Rule r = HF.createRule();
	    r.setName(R_ATTACH_PD_DIRECT);

	    Graph lhs = HF.createGraph();  r.setLhs(lhs);
	    Node f  = HF.createNode(lhs, CASAPackage.Literals.FUNC_PERS_DATA, "f");
	    Node pd = HF.createNode(lhs, CASAPackage.Literals.PERSONAL_DATA,  "pd");

	    Graph rhs = HF.createGraph();  r.setRhs(rhs);
	    Node f2  = HF.createNode(rhs, CASAPackage.Literals.FUNC_PERS_DATA, "f2");
	    Node pd2 = HF.createNode(rhs, CASAPackage.Literals.PERSONAL_DATA,  "pd2");
	    r.getMappings().add(HF.createMapping(f,  f2));
	    r.getMappings().add(HF.createMapping(pd, pd2));

	    HF.createEdge(f2, pd2, CASAPackage.Literals.FUNC_PERS_DATA__PROCESSES_PERS_DATA);
	    return r;
	}

	/** AttachPurposeToFunction: add f.has -> purp (non-violating purpose attachment). */
	private Rule buildAttachPurposeToFunctionRule() {
		Rule r = HF.createRule();
		r.setName(R_ATTACH_PURPOSE);

		Graph lhs = HF.createGraph(); r.setLhs(lhs);
		Node f    = HF.createNode(lhs, CASAPackage.Literals.FUNC_PERS_DATA,   "f");
		Node purp = HF.createNode(lhs, CASAPackage.Literals.PURPOSE_CONSENT,  "purp");

		Graph rhs = HF.createGraph(); r.setRhs(rhs);
		Node f2    = HF.createNode(rhs, CASAPackage.Literals.FUNC_PERS_DATA,  "f2");
		Node purp2 = HF.createNode(rhs, CASAPackage.Literals.PURPOSE_CONSENT, "purp2");

		r.getMappings().add(HF.createMapping(f,    f2));
		r.getMappings().add(HF.createMapping(purp, purp2));

		HF.createEdge(f2, purp2, CASAPackage.Literals.FUNC_PERS_DATA__HAS);
		return r;
	}


	private static final String PAR_NEW_FNAME = "newFName";
	private static final String PAR_NEW_CNAME = "newCName";

	private Rule buildAddPurposeViolationRule(String ruleName, String purposeLiteralName,
	                                          EClass funcType, EClass compType) {
		Rule r = HF.createRule();
		r.setName(ruleName);

		Parameter pF = HF.createParameter(); pF.setName(PAR_NEW_FNAME); r.getParameters().add(pF);
		Parameter pC = HF.createParameter(); pC.setName(PAR_NEW_CNAME); r.getParameters().add(pC);

		Graph lhs = HF.createGraph(); r.setLhs(lhs);
		Node sys  = HF.createNode(lhs, CASAPackage.Literals.SYSTEM,          "sys");
		Node pd   = HF.createNode(lhs, CASAPackage.Literals.PERSONAL_DATA,   "pd");
		Node purp = HF.createNode(lhs, CASAPackage.Literals.PURPOSE_CONSENT, "purp");

	    Attribute purpName = HF.createAttribute();
	    purpName.setType(CASAPackage.Literals.PURPOSE__NAME);
	    purpName.setValue("'" + purposeLiteralName + "'");
	    purp.getAttributes().add(purpName);

		Graph rhs = HF.createGraph(); r.setRhs(rhs);
		Node sys2  = HF.createNode(rhs, CASAPackage.Literals.SYSTEM,          "sys2");
		Node pd2   = HF.createNode(rhs, CASAPackage.Literals.PERSONAL_DATA,   "pd2");
		Node purp2 = HF.createNode(rhs, CASAPackage.Literals.PURPOSE_CONSENT, "purp2");
		Node f     = HF.createNode(rhs, funcType,                              "f"); // typed
		Node c     = HF.createNode(rhs, compType,                              "c"); // typed

		Attribute purpName2 = HF.createAttribute();
		purpName2.setType(CASAPackage.Literals.PURPOSE__NAME);
		purpName2.setValue("'" + purposeLiteralName + "'");
		purp2.getAttributes().add(purpName2);

		r.getMappings().add(HF.createMapping(sys,  sys2));
		r.getMappings().add(HF.createMapping(pd,   pd2));
		r.getMappings().add(HF.createMapping(purp, purp2));

		Attribute fName = HF.createAttribute();
		fName.setType(CASAPackage.Literals.FUNCTION__NAME);
		fName.setValue(PAR_NEW_FNAME);
		f.getAttributes().add(fName);

		Attribute cName = HF.createAttribute();
		cName.setType(CASAPackage.Literals.COMPONENT__NAME);
		cName.setValue(PAR_NEW_CNAME);
		c.getAttributes().add(cName);

		HF.createEdge(sys2, f, CASAPackage.Literals.SYSTEM__FUNCTIONS);
		HF.createEdge(sys2, c, CASAPackage.Literals.SYSTEM__COMPONENTS);
		HF.createEdge(f, purp2, CASAPackage.Literals.FUNC_PERS_DATA__HAS);
		HF.createEdge(f, c,     CASAPackage.Literals.FUNCTION__REALIZED_BY);
		return r;
	}

	private Rule buildCreateRiskFunctionRule(EClass funcType) {
		Rule r = HF.createRule();
		r.setName(R_CREATE_RISK_FUNC + "_" + funcType.getName());

		Parameter fname = HF.createParameter(); fname.setName(PAR_FUNC_NAME);
		r.getParameters().add(fname);

		Graph lhs = HF.createGraph(); r.setLhs(lhs);
		Node sys  = HF.createNode(lhs, CASAPackage.Literals.SYSTEM,          "sys");
		Node purp = HF.createNode(lhs, CASAPackage.Literals.PURPOSE_CONSENT, "pBase");

		Graph rhs = HF.createGraph(); r.setRhs(rhs);
		Node sys2 = HF.createNode(rhs, CASAPackage.Literals.SYSTEM,          "sys2");
		Node p2   = HF.createNode(rhs, CASAPackage.Literals.PURPOSE_CONSENT, "p2");
		Node f    = HF.createNode(rhs, funcType,                              "f"); // typed

		r.getMappings().add(HF.createMapping(sys,  sys2));
		r.getMappings().add(HF.createMapping(purp, p2));

		Attribute fName = HF.createAttribute();
		fName.setType(CASAPackage.Literals.FUNCTION__NAME);
		fName.setValue(PAR_FUNC_NAME);
		f.getAttributes().add(fName);

		HF.createEdge(sys2, f, CASAPackage.Literals.SYSTEM__FUNCTIONS);
		HF.createEdge(f,    p2, CASAPackage.Literals.FUNC_PERS_DATA__HAS);
		return r;
	}

	private Rule buildAddComponentToFunctionRule(EClass compType) {
	    Rule r = HF.createRule();
	    r.setName(R_ADD_COMP + "_" + compType.getName());

	    Graph lhs = HF.createGraph(); r.setLhs(lhs);
	    Node sys = HF.createNode(lhs, CASAPackage.Literals.SYSTEM,        "sys");
	    Node f   = HF.createNode(lhs, CASAPackage.Literals.FUNC_PERS_DATA,"f");

	    Graph rhs = HF.createGraph(); r.setRhs(rhs);
	    Node sys2 = HF.createNode(rhs, CASAPackage.Literals.SYSTEM,        "sys2");
	    Node f2   = HF.createNode(rhs, CASAPackage.Literals.FUNC_PERS_DATA,"f2");
	    Node c    = HF.createNode(rhs, compType,                            "c"); // typed

	    r.getMappings().add(HF.createMapping(sys, sys2));
	    r.getMappings().add(HF.createMapping(f,   f2));

	    Attribute cName = HF.createAttribute();
	    cName.setType(CASAPackage.Literals.COMPONENT__NAME);
	    cName.setValue("'RiskComp_' + Math.floor(Math.random()*1000000)");
	    c.getAttributes().add(cName);

	    HF.createEdge(sys2, c, CASAPackage.Literals.SYSTEM__COMPONENTS);
	    HF.createEdge(f2,   c, CASAPackage.Literals.FUNCTION__REALIZED_BY);
	    return r;
	}

	private Rule buildAddVulnToComponentRule() {
		Rule r = HF.createRule();
		r.setName(R_ADD_VULN);

		Parameter cve = HF.createParameter(); cve.setName(PAR_CVE_NAME);
		r.getParameters().add(cve);

		Graph lhs = HF.createGraph(); r.setLhs(lhs);
		Node sys = HF.createNode(lhs, CASAPackage.Literals.SYSTEM,    "sys");
		Node c   = HF.createNode(lhs, CASAPackage.Literals.COMPONENT, "c");
		Node ds  = HF.createNode(lhs, CASAPackage.Literals.DATA_SUBJECT, "ds");

		Graph rhs = HF.createGraph(); r.setRhs(rhs);
		Node sys2 = HF.createNode(rhs, CASAPackage.Literals.SYSTEM,    "sys2");
		Node c2   = HF.createNode(rhs, CASAPackage.Literals.COMPONENT, "c2");
		Node ds2  = HF.createNode(rhs, CASAPackage.Literals.DATA_SUBJECT, "ds2");
		Node v    = HF.createNode(rhs, CASAPackage.Literals.VULNERABILITY, "v");
		Node vec  = HF.createNode(rhs, CASAPackage.Literals.CVSS_VECTOR,   "vec");

		r.getMappings().add(HF.createMapping(sys, sys2));
		r.getMappings().add(HF.createMapping(c,   c2));
		r.getMappings().add(HF.createMapping(ds,  ds2));

		HF.createEdge(sys2, v,   CASAPackage.Literals.SYSTEM__VULNERABILITIES);
		HF.createEdge(v,    vec, CASAPackage.Literals.VULNERABILITY__DESCRIBED_BY);
		HF.createEdge(v,    c2,  CASAPackage.Literals.VULNERABILITY__AFFECTS);

		Attribute cv = HF.createAttribute();
		cv.setType(CASAPackage.Literals.VULNERABILITY__CVE_NAME);
		cv.setValue(PAR_CVE_NAME);
		v.getAttributes().add(cv);

		return r;
	}

	// ---------------------------------------------------------------------
	// Driver: apply structural violations with Henshin rules
	// ---------------------------------------------------------------------

	public static class StructuralReport {
		public final int doneUnrel, doneSpec, riskPDs, extraPurposesAttached;
		public StructuralReport(int u, int s, int r, int extra) {
			doneUnrel = u; doneSpec = s; riskPDs = r; extraPurposesAttached = extra;
		}
		@Override public String toString() {
			return "StructuralReport{unrelated=" + doneUnrel +
					", specialized=" + doneSpec +
					", riskPDs=" + riskPDs +
					", extraNonViolPurposes=" + extraPurposesAttached + "}";
		}
	}


	public StructuralReport applyStructuralViolationsWithHenshin(Resource res,
		int nUnrelated, int nSpecial, int nRisk,
		int maxSetSize, int maxComponents, int maxVulns, long seed) {
		return applyStructuralViolationsWithHenshin(
			res, nUnrelated, nSpecial, nRisk,
			maxSetSize, maxComponents, maxVulns,
			/*extraPurposesMin*/ 0, /*extraPurposesMax*/ 0,
			seed
		);
	}

	/**
	 * Apply Henshin rules to inject violations AND attach a random number of
	 * non-violating purposes to each created function.
	 *
	 * @param extraPurposesMin minimum extra non-violating purposes per created function
	 * @param extraPurposesMax maximum extra non-violating purposes per created function
	 */
	public StructuralReport applyStructuralViolationsWithHenshin(Resource res,
			int nUnrelated, int nSpecial, int nRisk,
			int maxSetSize, int maxComponents, int maxVulns,
			int extraPurposesMin, int extraPurposesMax,
			long seed) {

		if (res == null || res.getContents().isEmpty())
			throw new IllegalArgumentException("Resource is empty");
		if (extraPurposesMin < 0 || extraPurposesMax < extraPurposesMin)
			throw new IllegalArgumentException("Invalid extraPurposes bounds");

		Module mod = buildStructuralModule();

		// from module (generic)
		Rule attachPDDirect = (Rule) mod.getUnit(R_ATTACH_PD_DIRECT);
		Rule zeroRisk       = (Rule) mod.getUnit(R_ZERO_RISK);
		Rule addVuln        = (Rule) mod.getUnit(R_ADD_VULN);
		Rule attachPurpose  = (Rule) mod.getUnit(R_ATTACH_PURPOSE); // NEW

		Engine engine = new EngineImpl();
		EGraph graph  = new EGraphImpl(res.getContents().get(0));

		CASA.System sys = (CASA.System) res.getContents().get(0);

		// collect PersonalData
		List<CASA.PersonalData> allPDs = new ArrayList<>();
		for (CASA.Data d : sys.getDatas()) {
			if (d instanceof CASA.PersonalData) allPDs.add((CASA.PersonalData) d);
		}
		if (allPDs.isEmpty()) return new StructuralReport(0, 0, 0, 0);

		Random rnd = new Random(seed);
		Collections.shuffle(allPDs, rnd);

		Set<CASA.PersonalData> usedForPurposeViolations = new HashSet<>();
		int extraAttachedTotal = 0;

		// ---- 1) unrelated purpose ----
		int doneU = 0;
		for (int i = 0; i < allPDs.size() && doneU < nUnrelated; i++) {
			CASA.PersonalData pd = allPDs.get(i);
			if (usedForPurposeViolations.contains(pd)) continue;

			CASA.PurposeConsent purpVU = findPurposeByName(sys, P_VIOL_UNREL);
			if (purpVU == null) break;

			EClass funcType = pickRandomSubtype(CASAPackage.Literals.FUNC_PERS_DATA, rnd);
			EClass compType = pickRandomSubtype(CASAPackage.Literals.COMPONENT,      rnd);

			Rule addUnrelTyped = buildAddPurposeViolationRule(
					R_ADD_UNRELATED + "_" + funcType.getName() + "_" + compType.getName(),
					P_VIOL_UNREL, funcType, compType);

			Match m = new MatchImpl(addUnrelTyped);
			m.setNodeTarget(findLhs(addUnrelTyped, "sys"),  sys);
			m.setNodeTarget(findLhs(addUnrelTyped, "pd"),   pd);
			m.setNodeTarget(findLhs(addUnrelTyped, "purp"), purpVU);

			RuleApplication app = new RuleApplicationImpl(engine);
			app.setRule(addUnrelTyped);
			app.setEGraph(graph);
			app.setCompleteMatch(m);

			String pdName = pd.getName();
			app.setParameterValue(PAR_NEW_FNAME, "ViolFP_"  + pdName);
			app.setParameterValue(PAR_NEW_CNAME, "ViolComp_"+ pdName);

			if (app.execute(null)) {
				CASA.FuncPersData created = findFuncByName(sys, "ViolFP_" + pdName);
				if (created != null) {
					// attach PD
					Match mAtt = new MatchImpl(attachPDDirect);
					mAtt.setNodeTarget(findLhs(attachPDDirect, "f"),  created);
					mAtt.setNodeTarget(findLhs(attachPDDirect, "pd"), pd);
					RuleApplication att = new RuleApplicationImpl(engine);
					att.setRule(attachPDDirect);
					att.setEGraph(graph);
					att.setCompleteMatch(mAtt);
					att.execute(null);

					extraAttachedTotal += attachExtraNonViolatingPurposes(
							sys, created, attachPurpose, engine, graph, rnd, extraPurposesMin, extraPurposesMax);
				}
				usedForPurposeViolations.add(pd);
				doneU++;
			}
		}

		// ---- 2) specialization purpose ----
		int doneS = 0;
		for (int i = 0; i < allPDs.size() && doneS < nSpecial; i++) {
			CASA.PersonalData pd = allPDs.get(i);
			if (usedForPurposeViolations.contains(pd)) continue;

			CASA.PurposeConsent purpVG = findPurposeByName(sys, P_VIOL_GEN);
			if (purpVG == null) break;

			EClass funcType = pickRandomSubtype(CASAPackage.Literals.FUNC_PERS_DATA, rnd);
			EClass compType = pickRandomSubtype(CASAPackage.Literals.COMPONENT,      rnd);

			Rule addSpecTyped = buildAddPurposeViolationRule(
					R_ADD_SPECIAL + "_" + funcType.getName() + "_" + compType.getName(),
					P_VIOL_GEN, funcType, compType);

			Match m = new MatchImpl(addSpecTyped);
			m.setNodeTarget(findLhs(addSpecTyped, "sys"),  sys);
			m.setNodeTarget(findLhs(addSpecTyped, "pd"),   pd);
			m.setNodeTarget(findLhs(addSpecTyped, "purp"), purpVG);

			RuleApplication app = new RuleApplicationImpl(engine);
			app.setRule(addSpecTyped);
			app.setEGraph(graph);
			app.setCompleteMatch(m);

			String pdName = pd.getName();
			app.setParameterValue(PAR_NEW_FNAME, "ViolFP_"  + pdName);
			app.setParameterValue(PAR_NEW_CNAME, "ViolComp_"+ pdName);

			if (app.execute(null)) {
				CASA.FuncPersData created = findFuncByName(sys, "ViolFP_" + pdName);
				if (created != null) {
					Match mAtt = new MatchImpl(attachPDDirect);
					mAtt.setNodeTarget(findLhs(attachPDDirect, "f"),  created);
					mAtt.setNodeTarget(findLhs(attachPDDirect, "pd"), pd);
					RuleApplication att = new RuleApplicationImpl(engine);
					att.setRule(attachPDDirect);
					att.setEGraph(graph);
					att.setCompleteMatch(mAtt);
					att.execute(null);

					extraAttachedTotal += attachExtraNonViolatingPurposes(
							sys, created, attachPurpose, engine, graph, rnd, extraPurposesMin, extraPurposesMax);
				}
				usedForPurposeViolations.add(pd);
				doneS++;
			}
		}

		// ---- 3) risk violations ----
		int riskPDs = 0;
		if (nRisk > 0) {
			List<CASA.PersonalData> availableForRisk = new ArrayList<>();
			for (CASA.PersonalData pd : allPDs) if (!usedForPurposeViolations.contains(pd)) availableForRisk.add(pd);

			int take = Math.min(nRisk, availableForRisk.size());
			List<CASA.PersonalData> pick = new ArrayList<>();
			for (int i = 0; i < take; i++) pick.add(availableForRisk.get(i));

			// partition into random groups of size in [1..maxSetSize]
			List<List<CASA.PersonalData>> groups = new ArrayList<>();
			for (int idx = 0; idx < pick.size();) {
				int remaining = pick.size() - idx;
				int g = 1 + rnd.nextInt(Math.max(1, Math.min(maxSetSize, remaining)));
				groups.add(pick.subList(idx, idx + g));
				idx += g;
			}

			CASA.PurposeConsent basePurp = findPurposeByName(sys, P_BASE);

			for (List<CASA.PersonalData> gpd : groups) {
				if (basePurp == null) break;

				EClass funcType = pickRandomSubtype(CASAPackage.Literals.FUNC_PERS_DATA, rnd);
				Rule createRF_typed = buildCreateRiskFunctionRule(funcType);

				String fname = "RiskFP_" + gpd.get(0).getName() + "_" + Math.abs(rnd.nextInt());

				// snapshot before
				Set<CASA.FuncPersData> beforeFns = new HashSet<>();
				for (CASA.Function f0 : sys.getFunctions()) if (f0 instanceof CASA.FuncPersData) beforeFns.add((CASA.FuncPersData) f0);

				RuleApplication createApp = new RuleApplicationImpl(engine);
				createApp.setRule(createRF_typed);
				createApp.setEGraph(graph);
				createApp.setParameterValue(PAR_FUNC_NAME, fname);

				Match mCreate = new MatchImpl(createRF_typed);
				mCreate.setNodeTarget(findLhs(createRF_typed, "sys"),   sys);
				mCreate.setNodeTarget(findLhs(createRF_typed, "pBase"), basePurp);
				createApp.setCompleteMatch(mCreate);

				if (!createApp.execute(null)) {
					System.out.println("[risk] createRF not applicable; skip.");
					continue;
				}

				// find created function
				CASA.FuncPersData createdRF = null;
				for (CASA.Function f0 : sys.getFunctions()) {
					if (f0 instanceof CASA.FuncPersData && !beforeFns.contains(f0)) { createdRF = (CASA.FuncPersData) f0; break; }
				}
				if (createdRF == null) { System.out.println("[risk] createdRF missing; skip group."); continue; }
				if (createdRF.getName() == null || createdRF.getName().isEmpty()) createdRF.setName(fname);

				// attach PDs + zero risk
				for (CASA.PersonalData pd : gpd) {
					Match mAtt = new MatchImpl(attachPDDirect);
					mAtt.setNodeTarget(findLhs(attachPDDirect, "f"),  createdRF);
					mAtt.setNodeTarget(findLhs(attachPDDirect, "pd"), pd);

					RuleApplication att = new RuleApplicationImpl(engine);
					att.setRule(attachPDDirect);
					att.setEGraph(graph);
					att.setCompleteMatch(mAtt);
					boolean ok = att.execute(null);
					if (ok) riskPDs++;

					CASA.Consent cons = null;
					try { if (!pd.getSubjectOfConsent().isEmpty()) cons = pd.getSubjectOfConsent().get(0); } catch (Throwable ignore) {}
					if (cons != null) {
						Match mz = new MatchImpl(zeroRisk);
						mz.setNodeTarget(findLhs(zeroRisk, "pd"),   pd);
						mz.setNodeTarget(findLhs(zeroRisk, "cons"), cons);
						RuleApplication zr = new RuleApplicationImpl(engine);
						zr.setRule(zeroRisk);
						zr.setEGraph(graph);
						zr.setCompleteMatch(mz);
						zr.execute(null);
					}
				}

				extraAttachedTotal += attachExtraNonViolatingPurposes(
						sys, createdRF, attachPurpose, engine, graph, rnd, extraPurposesMin, extraPurposesMax);

				// components
				int compCount = 1 + rnd.nextInt(Math.max(1, maxComponents));
				for (int i = 0; i < compCount; i++) {
					EClass compType = pickRandomSubtype(CASAPackage.Literals.COMPONENT, rnd);
					Rule addComp_typed = buildAddComponentToFunctionRule(compType);

					RuleApplication ac = new RuleApplicationImpl(engine);
					ac.setRule(addComp_typed);
					ac.setEGraph(graph);

					Match mC = new MatchImpl(addComp_typed);
					mC.setNodeTarget(findLhs(addComp_typed, "sys"), sys);
					mC.setNodeTarget(findLhs(addComp_typed, "f"),   createdRF);
					ac.setCompleteMatch(mC);

					ac.execute(null);
				}

				// vulnerabilities
				CASA.FuncPersData fp2 = findFuncByName(sys, fname);
				if (fp2 != null) {
					List<CASA.Component> comps = findComponentsOfFunction(fp2);
					CASA.DataSubject ds0 = gpd.get(0).getIdentifies();

					for (CASA.Component c : comps) {
					 int vCount = 1 + rnd.nextInt(Math.max(1, maxVulns));
					 for (int v = 0; v < vCount; v++) {
						RuleApplication av = new RuleApplicationImpl(engine);
						av.setRule(addVuln);
						av.setEGraph(graph);
						av.setParameterValue(PAR_CVE_NAME, "CVE-RISK-" + Math.abs(rnd.nextInt()));

						Match mV = new MatchImpl(addVuln);
						mV.setNodeTarget(findLhs(addVuln, "sys"), sys);
						mV.setNodeTarget(findLhs(addVuln, "c"),   c);
						mV.setNodeTarget(findLhs(addVuln, "ds"),  ds0);
						av.setCompleteMatch(mV);
						av.execute(null);
					 }
					}
				}
			}
		}

		return new StructuralReport(doneU, doneS, riskPDs, extraAttachedTotal);
	}

	// ---- helpers used by the driver ----

	private Node findLhs(Rule r, String name) {
		return r.getLhs().getNodes().stream()
				.filter(n -> name.equals(n.getName()))
				.findFirst()
				.orElseThrow(() -> new IllegalStateException("Missing LHS node '" + name + "' in rule " + r.getName()));
	}

	private CASA.FuncPersData findFuncByName(CASA.System sys, String fname) {
		for (CASA.Function f : sys.getFunctions()) {
			if (f instanceof CASA.FuncPersData && fname.equals(f.getName())) return (CASA.FuncPersData) f;
		}
		return null;
	}

	private List<CASA.Component> findComponentsOfFunction(CASA.FuncPersData f) {
		return new ArrayList<>(f.getRealizedBy());
	}

	private CASA.PurposeConsent findPurposeByName(CASA.System sys, String name) {
		for (CASA.Purpose p : sys.getPurposes()) {
			if (p instanceof CASA.PurposeConsent && name.equals(p.getName())) {
				return (CASA.PurposeConsent) p;
			}
		}
		return null;
	}

	/**
	 * Pick K non-violating purposes at random and attach them to the function with the
	 * generic AttachPurposeToFunction rule. Returns number of attachments performed.
	 */
	private int attachExtraNonViolatingPurposes(
			CASA.System sys,
			CASA.FuncPersData f,
			Rule attachPurposeRule,
			Engine engine,
			EGraph graph,
			Random rnd,
			int extraMin,
			int extraMax) {

		if (extraMax <= 0) return 0;

		// Build pool: all PurposeConsent except the violating ones
		List<CASA.PurposeConsent> pool = new ArrayList<>();
		for (CASA.Purpose p : sys.getPurposes()) {
			if (p instanceof CASA.PurposeConsent) {
				String name = p.getName();
				if (!P_VIOL_UNREL.equals(name) && !P_VIOL_GEN.equals(name)) {
					pool.add((CASA.PurposeConsent) p);
				}
			}
		}
		if (pool.isEmpty()) return 0;

		// Shuffle & cap K
		Collections.shuffle(pool, rnd);
		int k = extraMin + rnd.nextInt(extraMax - extraMin + 1);
		k = Math.min(k, pool.size());

		int attached = 0;
		for (int i = 0; i < k; i++) {
			CASA.PurposeConsent purp = pool.get(i);

			// avoid duplicates
			if (f.getHas().contains(purp)) continue;

			Match m = new MatchImpl(attachPurposeRule);
			m.setNodeTarget(findLhs(attachPurposeRule, "f"),    f);
			m.setNodeTarget(findLhs(attachPurposeRule, "purp"), purp);

			RuleApplication app = new RuleApplicationImpl(engine);
			app.setRule(attachPurposeRule);
			app.setEGraph(graph);
			app.setCompleteMatch(m);
			if (app.execute(null)) attached++;
		}
		return attached;
	}

	// ---- optional: save module for inspection ----
	public void saveModule(Module m, File targetFile) {
		try {
			targetFile.getParentFile().mkdirs();
			HenshinResourceSet rs = new HenshinResourceSet(targetFile.getParentFile().getAbsolutePath());
			rs.getPackageRegistry().put(CASAPackage.eINSTANCE.getNsURI(), CASAPackage.eINSTANCE);
			org.eclipse.emf.ecore.resource.Resource henshinRes = rs.createResource(targetFile.getName());
			henshinRes.getContents().add(m);
			henshinRes.save(null);
		} catch (IOException ioe) {
			throw new RuntimeException("Failed to save Henshin module to " + targetFile, ioe);
		}
	}
}
