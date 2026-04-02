/**
 */
package CASA.CVSS.impl;

import CASA.CASAPackage;

import CASA.CVSS.AttackComplexity;
import CASA.CVSS.AttackVector;
import CASA.CVSS.AvailabilityImpact;
import CASA.CVSS.AvailabilityRequirement;
import CASA.CVSS.CVSSFactory;
import CASA.CVSS.CVSSPackage;
import CASA.CVSS.ConfidentialityImpact;
import CASA.CVSS.ConfidentialityRequirement;
import CASA.CVSS.ExploitCodeMaturity;
import CASA.CVSS.IntegrityImpact;
import CASA.CVSS.IntegrityRequirement;
import CASA.CVSS.PrivilegesRequired;
import CASA.CVSS.RemediationLevel;
import CASA.CVSS.ReportConfidence;
import CASA.CVSS.Scope;
import CASA.CVSS.UserInteraction;

import CASA.impl.CASAPackageImpl;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CVSSPackageImpl extends EPackageImpl implements CVSSPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum attackVectorEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum attackComplexityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum scopeEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum privilegesRequiredEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum userInteractionEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum exploitCodeMaturityEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum reportConfidenceEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum confidentialityImpactEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum integrityImpactEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum availabilityImpactEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum remediationLevelEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum confidentialityRequirementEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum integrityRequirementEEnum = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EEnum availabilityRequirementEEnum = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see CASA.CVSS.CVSSPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CVSSPackageImpl() {
		super(eNS_URI, CVSSFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CVSSPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CVSSPackage init() {
		if (isInited) return (CVSSPackage)EPackage.Registry.INSTANCE.getEPackage(CVSSPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCVSSPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CVSSPackageImpl theCVSSPackage = registeredCVSSPackage instanceof CVSSPackageImpl ? (CVSSPackageImpl)registeredCVSSPackage : new CVSSPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CASAPackage.eNS_URI);
		CASAPackageImpl theCASAPackage = (CASAPackageImpl)(registeredPackage instanceof CASAPackageImpl ? registeredPackage : CASAPackage.eINSTANCE);

		// Create package meta-data objects
		theCVSSPackage.createPackageContents();
		theCASAPackage.createPackageContents();

		// Initialize created meta-data
		theCVSSPackage.initializePackageContents();
		theCASAPackage.initializePackageContents();

		// Mark meta-data to indicate it can't be changed
		theCVSSPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CVSSPackage.eNS_URI, theCVSSPackage);
		return theCVSSPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAttackVector() {
		return attackVectorEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAttackComplexity() {
		return attackComplexityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getScope() {
		return scopeEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getPrivilegesRequired() {
		return privilegesRequiredEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getUserInteraction() {
		return userInteractionEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getExploitCodeMaturity() {
		return exploitCodeMaturityEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getReportConfidence() {
		return reportConfidenceEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConfidentialityImpact() {
		return confidentialityImpactEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIntegrityImpact() {
		return integrityImpactEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAvailabilityImpact() {
		return availabilityImpactEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getRemediationLevel() {
		return remediationLevelEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getConfidentialityRequirement() {
		return confidentialityRequirementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getIntegrityRequirement() {
		return integrityRequirementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EEnum getAvailabilityRequirement() {
		return availabilityRequirementEEnum;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSSFactory getCVSSFactory() {
		return (CVSSFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create enums
		attackVectorEEnum = createEEnum(ATTACK_VECTOR);
		attackComplexityEEnum = createEEnum(ATTACK_COMPLEXITY);
		scopeEEnum = createEEnum(SCOPE);
		privilegesRequiredEEnum = createEEnum(PRIVILEGES_REQUIRED);
		userInteractionEEnum = createEEnum(USER_INTERACTION);
		exploitCodeMaturityEEnum = createEEnum(EXPLOIT_CODE_MATURITY);
		reportConfidenceEEnum = createEEnum(REPORT_CONFIDENCE);
		confidentialityImpactEEnum = createEEnum(CONFIDENTIALITY_IMPACT);
		integrityImpactEEnum = createEEnum(INTEGRITY_IMPACT);
		availabilityImpactEEnum = createEEnum(AVAILABILITY_IMPACT);
		remediationLevelEEnum = createEEnum(REMEDIATION_LEVEL);
		confidentialityRequirementEEnum = createEEnum(CONFIDENTIALITY_REQUIREMENT);
		integrityRequirementEEnum = createEEnum(INTEGRITY_REQUIREMENT);
		availabilityRequirementEEnum = createEEnum(AVAILABILITY_REQUIREMENT);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Initialize enums and add enum literals
		initEEnum(attackVectorEEnum, AttackVector.class, "AttackVector");
		addEEnumLiteral(attackVectorEEnum, AttackVector.NETWORK);
		addEEnumLiteral(attackVectorEEnum, AttackVector.ADJACENT);
		addEEnumLiteral(attackVectorEEnum, AttackVector.LOCAL);
		addEEnumLiteral(attackVectorEEnum, AttackVector.PHYSICAL);

		initEEnum(attackComplexityEEnum, AttackComplexity.class, "AttackComplexity");
		addEEnumLiteral(attackComplexityEEnum, AttackComplexity.LOW);
		addEEnumLiteral(attackComplexityEEnum, AttackComplexity.HIGH);

		initEEnum(scopeEEnum, Scope.class, "Scope");
		addEEnumLiteral(scopeEEnum, Scope.UNCHANGED);
		addEEnumLiteral(scopeEEnum, Scope.CHANGED);

		initEEnum(privilegesRequiredEEnum, PrivilegesRequired.class, "PrivilegesRequired");
		addEEnumLiteral(privilegesRequiredEEnum, PrivilegesRequired.NONE);
		addEEnumLiteral(privilegesRequiredEEnum, PrivilegesRequired.LOW);
		addEEnumLiteral(privilegesRequiredEEnum, PrivilegesRequired.HIGH);

		initEEnum(userInteractionEEnum, UserInteraction.class, "UserInteraction");
		addEEnumLiteral(userInteractionEEnum, UserInteraction.NONE);
		addEEnumLiteral(userInteractionEEnum, UserInteraction.REQUIRED);

		initEEnum(exploitCodeMaturityEEnum, ExploitCodeMaturity.class, "ExploitCodeMaturity");
		addEEnumLiteral(exploitCodeMaturityEEnum, ExploitCodeMaturity.NOT_DEFINED);
		addEEnumLiteral(exploitCodeMaturityEEnum, ExploitCodeMaturity.HIGH);
		addEEnumLiteral(exploitCodeMaturityEEnum, ExploitCodeMaturity.FUNCTIONAL);
		addEEnumLiteral(exploitCodeMaturityEEnum, ExploitCodeMaturity.PROOF_OF_CONCEPT);
		addEEnumLiteral(exploitCodeMaturityEEnum, ExploitCodeMaturity.UNPROVEN);

		initEEnum(reportConfidenceEEnum, ReportConfidence.class, "ReportConfidence");
		addEEnumLiteral(reportConfidenceEEnum, ReportConfidence.NOT_DEFINED);
		addEEnumLiteral(reportConfidenceEEnum, ReportConfidence.CONFIRMED);
		addEEnumLiteral(reportConfidenceEEnum, ReportConfidence.REASONABLE);
		addEEnumLiteral(reportConfidenceEEnum, ReportConfidence.UNKNOWN);

		initEEnum(confidentialityImpactEEnum, ConfidentialityImpact.class, "ConfidentialityImpact");
		addEEnumLiteral(confidentialityImpactEEnum, ConfidentialityImpact.HIGH);
		addEEnumLiteral(confidentialityImpactEEnum, ConfidentialityImpact.LOW);
		addEEnumLiteral(confidentialityImpactEEnum, ConfidentialityImpact.NONE);

		initEEnum(integrityImpactEEnum, IntegrityImpact.class, "IntegrityImpact");
		addEEnumLiteral(integrityImpactEEnum, IntegrityImpact.HIGH);
		addEEnumLiteral(integrityImpactEEnum, IntegrityImpact.LOW);
		addEEnumLiteral(integrityImpactEEnum, IntegrityImpact.NONE);

		initEEnum(availabilityImpactEEnum, AvailabilityImpact.class, "AvailabilityImpact");
		addEEnumLiteral(availabilityImpactEEnum, AvailabilityImpact.HIGH);
		addEEnumLiteral(availabilityImpactEEnum, AvailabilityImpact.LOW);
		addEEnumLiteral(availabilityImpactEEnum, AvailabilityImpact.NONE);

		initEEnum(remediationLevelEEnum, RemediationLevel.class, "RemediationLevel");
		addEEnumLiteral(remediationLevelEEnum, RemediationLevel.NOT_DEFINED);
		addEEnumLiteral(remediationLevelEEnum, RemediationLevel.UNAVAILABLE);
		addEEnumLiteral(remediationLevelEEnum, RemediationLevel.WORKAROUND);
		addEEnumLiteral(remediationLevelEEnum, RemediationLevel.TEMPORARY_FIX);
		addEEnumLiteral(remediationLevelEEnum, RemediationLevel.OFFICIAL_FIX);

		initEEnum(confidentialityRequirementEEnum, ConfidentialityRequirement.class, "ConfidentialityRequirement");
		addEEnumLiteral(confidentialityRequirementEEnum, ConfidentialityRequirement.NOT_DEFINED);
		addEEnumLiteral(confidentialityRequirementEEnum, ConfidentialityRequirement.HIGH);
		addEEnumLiteral(confidentialityRequirementEEnum, ConfidentialityRequirement.MEDIUM);
		addEEnumLiteral(confidentialityRequirementEEnum, ConfidentialityRequirement.LOW);

		initEEnum(integrityRequirementEEnum, IntegrityRequirement.class, "IntegrityRequirement");
		addEEnumLiteral(integrityRequirementEEnum, IntegrityRequirement.NOT_DEFINED);
		addEEnumLiteral(integrityRequirementEEnum, IntegrityRequirement.HIGH);
		addEEnumLiteral(integrityRequirementEEnum, IntegrityRequirement.MEDIUM);
		addEEnumLiteral(integrityRequirementEEnum, IntegrityRequirement.LOW);

		initEEnum(availabilityRequirementEEnum, AvailabilityRequirement.class, "AvailabilityRequirement");
		addEEnumLiteral(availabilityRequirementEEnum, AvailabilityRequirement.NOT_DEFINED);
		addEEnumLiteral(availabilityRequirementEEnum, AvailabilityRequirement.HIGH);
		addEEnumLiteral(availabilityRequirementEEnum, AvailabilityRequirement.MEDIUM);
		addEEnumLiteral(availabilityRequirementEEnum, AvailabilityRequirement.LOW);
	}

} //CVSSPackageImpl
