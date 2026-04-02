package thesis;

//File: CasaModelGenerator.java
//Requires: org.eclipse.emf:org.eclipse.emf.ecore + org.eclipse.emf:org.eclipse.emf.ecore.xmi
import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.*;
import org.eclipse.emf.ecore.resource.*;
import org.eclipse.emf.ecore.resource.impl.ResourceSetImpl;
import org.eclipse.emf.ecore.xmi.impl.XMIResourceFactoryImpl;

import java.io.File;
import java.util.*;

public class CasaModelGenerator {

// ------------ Config ------------
	public static class Config {
		public int numDataSubjects = 100;
		public int personalDataPerSubject = 3;
		public int numFuncPersData = 10;
		public int numComponents = 20;
		public int componentsPerFunction = 2;
		public int vulnsPerComponent = 3;
		public int functionsPerPersonalData = 2;
		
		public int nonViolatingPurposesPerFunction = 1;


		// split purpose-mismatch into two flavors
		public int purposeMismatchUnrelated = 0; // → forPurpose="Research"
		public int purposeMismatchSpecialized = 0; // → forPurpose="Special"
		
		public int disabledVulnsPerComponent = 0;

		public int riskViolations = 0; // informedRiskLevel = 0.0
		public double nonViolatingRiskLevel = 1e9;
		public long seed = 42L;
		public boolean saveAsXMI = true;

		public CVSSPreset cvssPreset = CVSSPreset.defaultPreset();

		// Choose from these concrete classes (by simple EClass name)
		public List<String> dataSubjectConcreteTypes = Arrays.asList("User", "Administrator", "Moderator");

		public List<String> personalDataConcreteTypes = Arrays.asList("Username", "Password", "EmailAddress", "Payment",
				"StreamingHistory", "TrackingCookie", "VideoContent", "VideoComment", "VideoMetadata", "DeviceType",
				"DeviceLocation", "RequestTimestamps");

		public List<String> componentConcreteTypes = Arrays.asList("AngularSPA", "Nginx", "ExpressJS", "RedisComponent",
				"FilesystemComponent", "Postgresql");

		// FuncPersData (function) subtypes to pick from
		public List<String> funcPersDataConcreteTypes = Arrays.asList("ServeStandardAds", "P2PStreaming",
				"RecommendVideos", "ServeBehaviorTargetedAds", "CommentWriteRead", "ServeLocationTargetedAds");
	}

	public static class CVSSPreset {
		public String attackVector; // AttackVector
		public String attackComplexity; // AttackComplexity
		public String scope; // Scope
		public String privilegesRequired; // PrivilegesRequired
		public String userInteraction; // UserInteraction
		public String exploitCodeMaturity; // ExploitCodeMaturity
		public String reportConfidence; // ReportConfidence
		public String confidentialityImpact; // ConfidentialityImpact
		public String integrityImpact; // IntegrityImpact
		public String availabilityImpact; // AvailabilityImpact
		public String remediationLevel; // RemediationLevel
		public String confidentialityRequirement; // ConfidentialityRequirement
		public String integrityRequirement; // IntegrityRequirement
		public String availabilityRequirement; // AvailabilityRequirement

		public static CVSSPreset defaultPreset() {
			CVSSPreset p = new CVSSPreset();
			p.attackVector = "Network";
			p.attackComplexity = "Low";
			p.scope = "Unchanged";
			p.privilegesRequired = "None";
			p.userInteraction = "None";
			p.exploitCodeMaturity = "Functional";
			p.reportConfidence = "Confirmed";
			p.confidentialityImpact = "High";
			p.integrityImpact = "High";
			p.availabilityImpact = "High";
			p.remediationLevel = "TemporaryFix";
			p.confidentialityRequirement = "Medium";
			p.integrityRequirement = "Medium";
			p.availabilityRequirement = "Medium";
			return p;
		}
	}

// ------------ State ------------
	private final Config cfg;
	private final Random rnd;
	private final ResourceSet rs = new ResourceSetImpl();
	private EPackage casa;
	private final Map<String, EClass> C = new HashMap<>();
	private final Map<String, EEnum> E = new HashMap<>();

	public CasaModelGenerator(Config cfg) {
		this.cfg = cfg;
		this.rnd = new Random(cfg.seed);
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put(Resource.Factory.Registry.DEFAULT_EXTENSION,
				new XMIResourceFactoryImpl());
		rs.getResourceFactoryRegistry().getExtensionToFactoryMap().put("ecore",
				new org.eclipse.emf.ecore.xmi.impl.EcoreResourceFactoryImpl());
	}

// ------------ Entry ------------
	public static void main(String[] args) throws Exception {
		if (args.length < 2) {
			System.err.println("Usage: java CasaModelGenerator <path-to-CASA.ecore> <out-dir> [seed]");
			return;
		}
		Config cfg = new Config();
		if (args.length >= 3)
			cfg.seed = Long.parseLong(args[2]);
		CasaModelGenerator gen = new CasaModelGenerator(cfg);
		gen.loadEcore(URI.createFileURI(new File(args[0]).getAbsolutePath()));
		Resource r = gen.generate(URI.createFileURI(new File(args[1]).getAbsolutePath()));
		r.save(null);
		System.out.println("Wrote: " + r.getURI());
	}

	private EObject pickRandomNotLinked(List<EObject> candidates, Set<EObject> already) {
		// Build a compact list of available candidates
		List<EObject> pool = new ArrayList<>(Math.max(0, candidates.size() - already.size()));
		for (EObject f : candidates)
			if (!already.contains(f))
				pool.add(f);
		if (pool.isEmpty())
			return null;
		return pool.get(rnd.nextInt(pool.size())); // seeded RNG for reproducibility
	}

// ------------ Load & index ------------
	// ------------ Load & index ------------
	public void loadEcore(URI ecoreUriIgnored) {
		// Prefer generated package (typed instances)
		try {
			casa = CASA.CASAPackage.eINSTANCE;
			rs.getPackageRegistry().put(casa.getNsURI(), casa);
			collect(casa); // index classes/enums from the generated package
			return;
		} catch (Throwable t) {
			// fall back if generated code isn't on the classpath
		}

		// Fallback: dynamic (only if you truly need it)
		Resource r = rs.getResource(ecoreUriIgnored, true);
		for (EObject obj : r.getContents()) {
			if (obj instanceof EPackage) {
				EPackage p = (EPackage) obj;
				if ("CASA".equals(p.getName()))
					casa = p;
				collect(p);
			}
		}
		if (casa == null)
			throw new IllegalStateException("Could not find EPackage 'CASA'");
	}

	private void collect(EPackage p) {
		for (EClassifier cl : p.getEClassifiers()) {
			if (cl instanceof EClass)
				C.put(((EClass) cl).getName(), (EClass) cl);
			else if (cl instanceof EEnum)
				E.put(((EEnum) cl).getName(), (EEnum) cl);
		}
		for (EPackage sub : p.getESubpackages())
			collect(sub);
	}

	// --- Subtype discovery & instantiation helpers ---

	// Cache to avoid recomputing
	private final Map<String, List<EClass>> concreteSubtypesCache = new HashMap<>();

	/**
	 * Returns all non-abstract, non-interface EClasses that inherit (directly or
	 * transitively) from baseName, excluding the base itself.
	 */
	private List<EClass> getConcreteSubtypesOf(String baseName) {
		List<EClass> cached = concreteSubtypesCache.get(baseName);
		if (cached != null)
			return cached;

		EClass base = C.get(baseName);
		if (base == null)
			throw new IllegalArgumentException("Base EClass not found: " + baseName);

		List<EClass> result = new ArrayList<>();
		for (EClass cl : C.values()) {
			if (cl == base)
				continue;
			if (cl.isAbstract() || cl.isInterface())
				continue;
			// robust: use transitive supertypes computed by EMF
			if (cl.getEAllSuperTypes().contains(base))
				result.add(cl);
		}

		concreteSubtypesCache.put(baseName, Collections.unmodifiableList(result));
		return concreteSubtypesCache.get(baseName);
	}

	private EObject newRandomSubtypeInstance(String baseName) {
		List<EClass> subs = getConcreteSubtypesOf(baseName);
		if (!subs.isEmpty()) {
			EClass pick = subs.get(rnd.nextInt(subs.size()));
			return pick.getEPackage().getEFactoryInstance().create(pick);
		}
		// Fallback (and also OK if there truly are no subtypes)
		return newInstance(baseName);
	}

	/** True if cl inherits (transitively) from base. */
	private boolean inheritsFrom(EClass cl, EClass base) {
		if (cl.getESuperTypes().isEmpty())
			return false;
		for (EClass s : cl.getESuperTypes()) {
			if (s == base)
				return true;
			if (inheritsFrom(s, base))
				return true;
		}
		return false;
	}

	/** Utility: return the simple class name for logging/naming. */
	private static String simple(EObject o) {
		return o.eClass().getName();
	}

	/**
	 * Create an instance of a random EClass from `names`. If none are valid, fall
	 * back to `fallbackBase`.
	 */
	private EObject newRandomFromNames(List<String> names, String fallbackBase) {
		List<EClass> candidates = new ArrayList<>();
		for (String n : names) {
			EClass cl = C.get(n);
			if (cl != null && !cl.isAbstract() && !cl.isInterface()) {
				candidates.add(cl);
			}
		}
		EClass chosen;
		if (!candidates.isEmpty()) {
			chosen = candidates.get(rnd.nextInt(candidates.size()));
		} else {
			// Fallback if the list is empty or contains unknown classes
			chosen = C.get(fallbackBase);
			if (chosen == null)
				throw new IllegalArgumentException("Fallback EClass not found: " + fallbackBase);
		}
		return chosen.getEPackage().getEFactoryInstance().create(chosen);
	}

// ------------ Generation ------------
	public Resource generate(URI outDir) {
		File dir = new File(outDir.toFileString());
		if (!dir.exists())
			dir.mkdirs();
		Resource r = rs.createResource(outDir.appendSegment("model").appendFileExtension("xmi"));

		EObject system = newInstance("System");
		r.getContents().add(system);

		List<EObject> subjects = new ArrayList<>();
		List<EObject> personal = new ArrayList<>();
		List<EObject> risks = new ArrayList<>();
		List<EObject> components = new ArrayList<>();
		List<EObject> vulns = new ArrayList<>();
		List<EObject> fpFuncs = new ArrayList<>();

		// ---- DataSubjects (+ Risk placeholder) ----
		for (int i = 0; i < cfg.numDataSubjects; i++) {
			// OLD: EObject ds = newRandomSubtypeInstance("DataSubject");
			EObject ds = newRandomFromNames(cfg.dataSubjectConcreteTypes, "DataSubject");
			setAttr(ds, "name", ds.eClass().getName() + "_" + i);

			EObject risk = newInstance("Risk");
			setRef(risk, "affects", ds);
			addContainment(ds, "affectedBy", risk);

			addContainment(system, "dataSubjects", ds);

			subjects.add(ds);
			risks.add(risk);

			for (int k = 0; k < cfg.personalDataPerSubject; k++) {
				// OLD: EObject pd = newRandomSubtypeInstance("PersonalData");
				EObject pd = newRandomFromNames(cfg.personalDataConcreteTypes, "PersonalData");
				setAttr(pd, "name", pd.eClass().getName() + "_" + i + "_" + k);
				setRef(pd, "identifies", ds);
				addContainment(system, "datas", pd);
				personal.add(pd);
			}
		}

		// ---- Components (+ fixed CVSS vulnerabilities) ----
		for (int i = 0; i < cfg.numComponents; i++) {
		    EObject c = newRandomFromNames(cfg.componentConcreteTypes, "Component");
		    setAttr(c, "name", c.eClass().getName() + "_" + i);
		    addContainment(system, "components", c);
		    components.add(c);

		    // Enabled (default) vulnerabilities
		    for (int v = 0; v < cfg.vulnsPerComponent; v++) {
		        String cve = "CVE-2022-" + (1000 + i * 100 + v);
		        EObject vuln = newInstance("Vulnerability");
		        setAttr(vuln, "cveName", cve);
		        // default isEnabled=true from Ecore; no need to set explicitly

		        EObject cvss = newInstance("CVSSVector");
		        applyPresetCVSS(cvss, cfg.cvssPreset);
		        addContainment(vuln, "describedBy", cvss);

		        addRef(vuln, "affects", c);

		        EObject someRisk = risks.get(Math.min(i % risks.size(), risks.size() - 1));
		        addRef(vuln, "causes", someRisk);

		        addContainment(system, "vulnerabilities", vuln);
		        vulns.add(vuln);
		    }

		    // Disabled vulnerabilities (do not affect consent/risk)
		    for (int v = 0; v < cfg.disabledVulnsPerComponent; v++) {
		        String cve = "CVE-DISABLED-" + (2000 + i * 100 + v);
		        EObject vuln = newInstance("Vulnerability");
		        setAttr(vuln, "cveName", cve);
		        setAttr(vuln, "isEnabled", false); // key bit

		        EObject cvss = newInstance("CVSSVector");
		        applyPresetCVSS(cvss, cfg.cvssPreset);
		        addContainment(vuln, "describedBy", cvss);

		        addRef(vuln, "affects", c);

		        EObject someRisk = risks.get(Math.min(i % risks.size(), risks.size() - 1));
		        addRef(vuln, "causes", someRisk);

		        addContainment(system, "vulnerabilities", vuln);
		        vulns.add(vuln);
		    }
		}


		// ---- Functions (FuncPersData) ----
		for (int i = 0; i < cfg.numFuncPersData; i++) {
		    EObject f = newRandomFromNames(cfg.funcPersDataConcreteTypes, "FuncPersData");
		    setAttr(f, "name", f.eClass().getName() + "_" + i);

		    // realizedBy K components (random, seeded)
		    for (EObject c : pickK(components, cfg.componentsPerFunction)) {
		        addRef(f, "realizedBy", c);
		    }

		    addContainment(system, "functions", f);
		    fpFuncs.add(f);
		}

		// ---- Purposes: instantiate all, reserve Research & Special ----
		final List<String> purposeNames = Arrays.asList("BehaviorTargetedAds", "DoSProtection", "FirstPartyProfiling",
				"Health", "Humanitarian", "Journalistic", "Judicial", "LocationTargetedAds", "Marketing",
				"OnlineAdvertising", "Profiling", "PublicInterest", "Base", "Research", // reserved
				"Special", // reserved
				"Security", "StandardAds", "Statistic", "TargetedAds", "ThirdPartyProfiling", "ViolationUnrelated", // reserved
																													// for
																													// Henshin
																													// rule
																													// LHS
				"ViolationGeneralization" // reserved for Henshin rule LHS
		);

		final Set<String> reservedPurposes = new HashSet<>(
				Arrays.asList("Research", "Special", "ViolationUnrelated", "ViolationGeneralization"));

		List<EObject> assignablePurposes = new ArrayList<>();
		EObject researchPurpose = null, specialPurpose = null, basePurpose = null;
		for (String pname : purposeNames) {
			EObject pc = newInstance("PurposeConsent");
			setAttr(pc, "name", pname);
			addContainment(system, "purposes", pc);

			if ("Research".equals(pname))
				researchPurpose = pc; // reserved
			else if ("Special".equals(pname))
				specialPurpose = pc; // reserved
			else if ("Base".equals(pname)) {
				basePurpose = pc;
				assignablePurposes.add(pc);
			} else if (!reservedPurposes.contains(pname)) {
				assignablePurposes.add(pc); // normal assignable purposes
			}
		}
		// Assign exactly one non-reserved purpose to each function
//		if (!fpFuncs.isEmpty() && !assignablePurposes.isEmpty()) {
//			for (EObject f : fpFuncs) {
//				EObject chosen = assignablePurposes.get(rnd.nextInt(assignablePurposes.size()));
//				addRef(f, "has", chosen);
//			}
//		}
		
		if (!fpFuncs.isEmpty() && !assignablePurposes.isEmpty()) {
		    int Kcfg = Math.max(1, cfg.nonViolatingPurposesPerFunction);                // at least 1
		    int Kmax = Math.min(Kcfg, assignablePurposes.size());                       // cannot exceed pool

		    for (EObject f : fpFuncs) {
		        // pick Kmax distinct purposes deterministically (seeded)
		        List<EObject> pool = new ArrayList<>(assignablePurposes);
		        Collections.shuffle(pool, rnd);
		        for (int j = 0; j < Kmax; j++) {
		            addRef(f, "has", pool.get(j));
		        }
		    }
		}

		// ---- Link PersonalData ↔ FuncPersData (random, with constraints) ----
		if (!personal.isEmpty() && !fpFuncs.isEmpty()) {
			// Each function processes at least one PD
			for (int i = 0; i < fpFuncs.size(); i++) {
				EObject f = fpFuncs.get(i);
				EObject pd = personal.get(i % personal.size());
				addRef(f, "processesPersData", pd);
			}

			// Each PD processed by K distinct functions (random)
			int targetK = Math.max(1, Math.min(cfg.functionsPerPersonalData, fpFuncs.size()));
			EStructuralFeature pdProcessedByFeat = C.get("PersonalData").getEStructuralFeature("processedBy");

			for (EObject pd : personal) {
				@SuppressWarnings("unchecked")
				List<EObject> currentFuncs = (List<EObject>) pd.eGet(pdProcessedByFeat);
				Set<EObject> currentSet = new HashSet<>(currentFuncs);

				while (currentSet.size() < targetK) {
					List<EObject> pool = new ArrayList<>(fpFuncs.size());
					for (EObject f : fpFuncs)
						if (!currentSet.contains(f))
							pool.add(f);
					if (pool.isEmpty())
						break;
					EObject chosenF = pool.get(rnd.nextInt(pool.size()));
					addRef(chosenF, "processesPersData", pd); // updates pd.processedBy opposite
					currentSet.add(chosenF);
				}
			}
		}

		// ---- Consents: exactly ONE per PersonalData ----
		{
			List<EObject> pdShuffled = new ArrayList<>(personal);
			Collections.shuffle(pdShuffled, rnd);

			int total = pdShuffled.size();
			int pmU = Math.max(0, Math.min(cfg.purposeMismatchUnrelated, total)); // unrelated → Research
			int pmS = Math.max(0, Math.min(cfg.purposeMismatchSpecialized, Math.max(0, total - pmU))); 
			int rv = Math.max(0, Math.min(cfg.riskViolations, Math.max(0, total - pmU - pmS))); 


			EStructuralFeature pdOwnerFeat = C.get("PersonalData").getEStructuralFeature("identifies");
			EStructuralFeature pdProcByFeat = C.get("PersonalData").getEStructuralFeature("processedBy");
			EStructuralFeature fHasFeat = C.get("FuncPersData").getEStructuralFeature("has");

			for (int i = 0; i < total; i++) {
				EObject pd = pdShuffled.get(i);

				boolean mismatchUnrelated = (i < pmU);
				boolean mismatchSpecial = (!mismatchUnrelated && i < pmU + pmS);
				boolean riskViolation = (!mismatchUnrelated && !mismatchSpecial && i < pmU + pmS + rv);

				EObject ds = (EObject) pd.eGet(pdOwnerFeat);

				// pick ONE function that processes this PD (if any)
				@SuppressWarnings("unchecked")
				List<EObject> procBy = (List<EObject>) pd.eGet(pdProcByFeat);
				EObject chosenFunc = (procBy != null && !procBy.isEmpty()) ? procBy.get(rnd.nextInt(procBy.size()))
						: null;

				// purpose to link in givenFor (function’s purpose if available, else fallback)
				EObject givenForPurpose = null;
				if (chosenFunc != null) {
					@SuppressWarnings("unchecked")
					List<EObject> has = (List<EObject>) chosenFunc.eGet(fHasFeat);
					if (has != null && !has.isEmpty())
						givenForPurpose = has.get(0);
				}
				if (givenForPurpose == null) {
					if (basePurpose != null)
						givenForPurpose = basePurpose;
					else if (researchPurpose != null)
						givenForPurpose = researchPurpose;
					else
						givenForPurpose = specialPurpose;
				}

				EObject consent = newInstance("Consent");

				String consentPurpose = mismatchUnrelated ? "Research" : mismatchSpecial ? "Special" : "Base";
				setAttr(consent, "forPurpose", consentPurpose);

				// risk:
				setAttr(consent, "informedRiskLevel", riskViolation ? 0.0 : cfg.nonViolatingRiskLevel);

				if (ds != null) {
					setRef(consent, "givenBy", ds);
					addContainment(ds, "gives", consent);
				}
				if (givenForPurpose != null)
					addRef(consent, "givenFor", givenForPurpose);
				addRef(consent, "forPersonalData", pd);
			}
		}

		return r;
	}

// ------------ Helpers ------------
	private EObject newInstance(String className) {
		EClass cls = C.get(className);
		if (cls == null)
			throw new IllegalArgumentException("EClass not found: " + className);
		return cls.getEPackage().getEFactoryInstance().create(cls);
	}

	private void addContainment(EObject container, String feature, EObject child) {
		EStructuralFeature f = container.eClass().getEStructuralFeature(feature);
		if (f.isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) container.eGet(f);
			list.add(child);
		} else {
			container.eSet(f, child);
		}
	}

	private void addRef(EObject src, String feature, EObject tgt) {
		EStructuralFeature f = src.eClass().getEStructuralFeature(feature);
		if (f.isMany()) {
			@SuppressWarnings("unchecked")
			EList<EObject> list = (EList<EObject>) src.eGet(f);
			list.add(tgt);
		} else if (src.eGet(f) == null) {
			src.eSet(f, tgt);
		}
	}

	private void setRef(EObject src, String feature, EObject tgt) {
		src.eSet(src.eClass().getEStructuralFeature(feature), tgt);
	}

	private void setAttr(EObject obj, String feature, Object value) {
		obj.eSet(obj.eClass().getEStructuralFeature(feature), value);
	}

	private <T> List<T> pickK(List<T> pool, int k) {
		k = Math.max(0, Math.min(k, pool.size()));
		if (k == 0)
			return Collections.emptyList();

		// copy to shuffle without touching the original
		List<T> copy = new ArrayList<>(pool);
		Collections.shuffle(copy, rnd); // uses the same seeded Random for reproducibility
		return new ArrayList<>(copy.subList(0, k));
	}

// --- Fixed CVSS: set all enum-typed attributes to the preset literal by NAME ---
	private void applyPresetCVSS(EObject cvss, CVSSPreset p) {
		setEnumByName(cvss, "attackVector", "AttackVector", p.attackVector);
		setEnumByName(cvss, "attackComplexity", "AttackComplexity", p.attackComplexity);
		setEnumByName(cvss, "scope", "Scope", p.scope);
		setEnumByName(cvss, "privilegesRequired", "PrivilegesRequired", p.privilegesRequired);
		setEnumByName(cvss, "userInteraction", "UserInteraction", p.userInteraction);
		setEnumByName(cvss, "exploitCodeMaturity", "ExploitCodeMaturity", p.exploitCodeMaturity);
		setEnumByName(cvss, "reportConfidence", "ReportConfidence", p.reportConfidence);
		setEnumByName(cvss, "confidentialityImpact", "ConfidentialityImpact", p.confidentialityImpact);
		setEnumByName(cvss, "integrityImpact", "IntegrityImpact", p.integrityImpact);
		setEnumByName(cvss, "availabilityImpact", "AvailabilityImpact", p.availabilityImpact);
		setEnumByName(cvss, "remediationLevel", "RemediationLevel", p.remediationLevel);
		setEnumByName(cvss, "confidentialityRequirement", "ConfidentialityRequirement", p.confidentialityRequirement);
		setEnumByName(cvss, "integrityRequirement", "IntegrityRequirement", p.integrityRequirement);
		setEnumByName(cvss, "availabilityRequirement", "AvailabilityRequirement", p.availabilityRequirement);
	}

	private void setEnumByName(EObject obj, String feature, String enumName, String literalName) {
		EEnum en = E.get(enumName);
		if (en == null)
			throw new IllegalArgumentException("EEnum not found: " + enumName);

		EStructuralFeature f = obj.eClass().getEStructuralFeature(feature);
		if (f == null)
			throw new IllegalArgumentException("Feature not found: " + feature + " on " + obj.eClass().getName());

		// Find literal by name
		EEnumLiteral lit = en.getEEnumLiteral(literalName);
		if (lit == null)
			throw new IllegalArgumentException("Literal '" + literalName + "' not found in enum " + enumName);

		// Create the correct typed enum instance (works for generated or dynamic)
		EFactory factory = en.getEPackage().getEFactoryInstance();
		Object value = factory.createFromString((EDataType) en, lit.getLiteral());

		// Set the value
		obj.eSet(f, value);
	}

}
