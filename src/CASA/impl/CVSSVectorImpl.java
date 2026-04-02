/**
 */
package CASA.impl;

import CASA.CASAPackage;

import CASA.CVSS.AttackComplexity;
import CASA.CVSS.AttackVector;
import CASA.CVSS.AvailabilityImpact;
import CASA.CVSS.AvailabilityRequirement;
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

import CASA.CVSSVector;

import org.eclipse.emf.common.notify.Notification;

import org.eclipse.emf.ecore.EClass;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>CVSS Vector</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getAttackVector <em>Attack Vector</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getAttackComplexity <em>Attack Complexity</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getScope <em>Scope</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getPrivilegesRequired <em>Privileges Required</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getUserInteraction <em>User Interaction</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getExploitCodeMaturity <em>Exploit Code Maturity</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getReportConfidence <em>Report Confidence</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getConfidentialityImpact <em>Confidentiality Impact</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getIntegrityImpact <em>Integrity Impact</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getAvailabilityImpact <em>Availability Impact</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getRemediationLevel <em>Remediation Level</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getConfidentialityRequirement <em>Confidentiality Requirement</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getIntegrityRequirement <em>Integrity Requirement</em>}</li>
 *   <li>{@link CASA.impl.CVSSVectorImpl#getAvailabilityRequirement <em>Availability Requirement</em>}</li>
 * </ul>
 *
 * @generated
 */
public class CVSSVectorImpl extends MinimalEObjectImpl.Container implements CVSSVector {
	/**
	 * The default value of the '{@link #getAttackVector() <em>Attack Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackVector()
	 * @generated
	 * @ordered
	 */
	protected static final AttackVector ATTACK_VECTOR_EDEFAULT = AttackVector.NETWORK;

	/**
	 * The cached value of the '{@link #getAttackVector() <em>Attack Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackVector()
	 * @generated
	 * @ordered
	 */
	protected AttackVector attackVector = ATTACK_VECTOR_EDEFAULT;

	/**
	 * The default value of the '{@link #getAttackComplexity() <em>Attack Complexity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackComplexity()
	 * @generated
	 * @ordered
	 */
	protected static final AttackComplexity ATTACK_COMPLEXITY_EDEFAULT = AttackComplexity.LOW;

	/**
	 * The cached value of the '{@link #getAttackComplexity() <em>Attack Complexity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAttackComplexity()
	 * @generated
	 * @ordered
	 */
	protected AttackComplexity attackComplexity = ATTACK_COMPLEXITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected static final Scope SCOPE_EDEFAULT = Scope.UNCHANGED;

	/**
	 * The cached value of the '{@link #getScope() <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getScope()
	 * @generated
	 * @ordered
	 */
	protected Scope scope = SCOPE_EDEFAULT;

	/**
	 * The default value of the '{@link #getPrivilegesRequired() <em>Privileges Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrivilegesRequired()
	 * @generated
	 * @ordered
	 */
	protected static final PrivilegesRequired PRIVILEGES_REQUIRED_EDEFAULT = PrivilegesRequired.NONE;

	/**
	 * The cached value of the '{@link #getPrivilegesRequired() <em>Privileges Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPrivilegesRequired()
	 * @generated
	 * @ordered
	 */
	protected PrivilegesRequired privilegesRequired = PRIVILEGES_REQUIRED_EDEFAULT;

	/**
	 * The default value of the '{@link #getUserInteraction() <em>User Interaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserInteraction()
	 * @generated
	 * @ordered
	 */
	protected static final UserInteraction USER_INTERACTION_EDEFAULT = UserInteraction.NONE;

	/**
	 * The cached value of the '{@link #getUserInteraction() <em>User Interaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getUserInteraction()
	 * @generated
	 * @ordered
	 */
	protected UserInteraction userInteraction = USER_INTERACTION_EDEFAULT;

	/**
	 * The default value of the '{@link #getExploitCodeMaturity() <em>Exploit Code Maturity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExploitCodeMaturity()
	 * @generated
	 * @ordered
	 */
	protected static final ExploitCodeMaturity EXPLOIT_CODE_MATURITY_EDEFAULT = ExploitCodeMaturity.NOT_DEFINED;

	/**
	 * The cached value of the '{@link #getExploitCodeMaturity() <em>Exploit Code Maturity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getExploitCodeMaturity()
	 * @generated
	 * @ordered
	 */
	protected ExploitCodeMaturity exploitCodeMaturity = EXPLOIT_CODE_MATURITY_EDEFAULT;

	/**
	 * The default value of the '{@link #getReportConfidence() <em>Report Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReportConfidence()
	 * @generated
	 * @ordered
	 */
	protected static final ReportConfidence REPORT_CONFIDENCE_EDEFAULT = ReportConfidence.NOT_DEFINED;

	/**
	 * The cached value of the '{@link #getReportConfidence() <em>Report Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getReportConfidence()
	 * @generated
	 * @ordered
	 */
	protected ReportConfidence reportConfidence = REPORT_CONFIDENCE_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfidentialityImpact() <em>Confidentiality Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidentialityImpact()
	 * @generated
	 * @ordered
	 */
	protected static final ConfidentialityImpact CONFIDENTIALITY_IMPACT_EDEFAULT = ConfidentialityImpact.HIGH;

	/**
	 * The cached value of the '{@link #getConfidentialityImpact() <em>Confidentiality Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidentialityImpact()
	 * @generated
	 * @ordered
	 */
	protected ConfidentialityImpact confidentialityImpact = CONFIDENTIALITY_IMPACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntegrityImpact() <em>Integrity Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegrityImpact()
	 * @generated
	 * @ordered
	 */
	protected static final IntegrityImpact INTEGRITY_IMPACT_EDEFAULT = IntegrityImpact.HIGH;

	/**
	 * The cached value of the '{@link #getIntegrityImpact() <em>Integrity Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegrityImpact()
	 * @generated
	 * @ordered
	 */
	protected IntegrityImpact integrityImpact = INTEGRITY_IMPACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAvailabilityImpact() <em>Availability Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailabilityImpact()
	 * @generated
	 * @ordered
	 */
	protected static final AvailabilityImpact AVAILABILITY_IMPACT_EDEFAULT = AvailabilityImpact.HIGH;

	/**
	 * The cached value of the '{@link #getAvailabilityImpact() <em>Availability Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailabilityImpact()
	 * @generated
	 * @ordered
	 */
	protected AvailabilityImpact availabilityImpact = AVAILABILITY_IMPACT_EDEFAULT;

	/**
	 * The default value of the '{@link #getRemediationLevel() <em>Remediation Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemediationLevel()
	 * @generated
	 * @ordered
	 */
	protected static final RemediationLevel REMEDIATION_LEVEL_EDEFAULT = RemediationLevel.NOT_DEFINED;

	/**
	 * The cached value of the '{@link #getRemediationLevel() <em>Remediation Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRemediationLevel()
	 * @generated
	 * @ordered
	 */
	protected RemediationLevel remediationLevel = REMEDIATION_LEVEL_EDEFAULT;

	/**
	 * The default value of the '{@link #getConfidentialityRequirement() <em>Confidentiality Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidentialityRequirement()
	 * @generated
	 * @ordered
	 */
	protected static final ConfidentialityRequirement CONFIDENTIALITY_REQUIREMENT_EDEFAULT = ConfidentialityRequirement.NOT_DEFINED;

	/**
	 * The cached value of the '{@link #getConfidentialityRequirement() <em>Confidentiality Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getConfidentialityRequirement()
	 * @generated
	 * @ordered
	 */
	protected ConfidentialityRequirement confidentialityRequirement = CONFIDENTIALITY_REQUIREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getIntegrityRequirement() <em>Integrity Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegrityRequirement()
	 * @generated
	 * @ordered
	 */
	protected static final IntegrityRequirement INTEGRITY_REQUIREMENT_EDEFAULT = IntegrityRequirement.NOT_DEFINED;

	/**
	 * The cached value of the '{@link #getIntegrityRequirement() <em>Integrity Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIntegrityRequirement()
	 * @generated
	 * @ordered
	 */
	protected IntegrityRequirement integrityRequirement = INTEGRITY_REQUIREMENT_EDEFAULT;

	/**
	 * The default value of the '{@link #getAvailabilityRequirement() <em>Availability Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailabilityRequirement()
	 * @generated
	 * @ordered
	 */
	protected static final AvailabilityRequirement AVAILABILITY_REQUIREMENT_EDEFAULT = AvailabilityRequirement.NOT_DEFINED;

	/**
	 * The cached value of the '{@link #getAvailabilityRequirement() <em>Availability Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAvailabilityRequirement()
	 * @generated
	 * @ordered
	 */
	protected AvailabilityRequirement availabilityRequirement = AVAILABILITY_REQUIREMENT_EDEFAULT;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected CVSSVectorImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.CVSS_VECTOR;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackVector getAttackVector() {
		return attackVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttackVector(AttackVector newAttackVector) {
		AttackVector oldAttackVector = attackVector;
		attackVector = newAttackVector == null ? ATTACK_VECTOR_EDEFAULT : newAttackVector;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__ATTACK_VECTOR, oldAttackVector, attackVector));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackComplexity getAttackComplexity() {
		return attackComplexity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAttackComplexity(AttackComplexity newAttackComplexity) {
		AttackComplexity oldAttackComplexity = attackComplexity;
		attackComplexity = newAttackComplexity == null ? ATTACK_COMPLEXITY_EDEFAULT : newAttackComplexity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__ATTACK_COMPLEXITY, oldAttackComplexity, attackComplexity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scope getScope() {
		return scope;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setScope(Scope newScope) {
		Scope oldScope = scope;
		scope = newScope == null ? SCOPE_EDEFAULT : newScope;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__SCOPE, oldScope, scope));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrivilegesRequired getPrivilegesRequired() {
		return privilegesRequired;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setPrivilegesRequired(PrivilegesRequired newPrivilegesRequired) {
		PrivilegesRequired oldPrivilegesRequired = privilegesRequired;
		privilegesRequired = newPrivilegesRequired == null ? PRIVILEGES_REQUIRED_EDEFAULT : newPrivilegesRequired;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__PRIVILEGES_REQUIRED, oldPrivilegesRequired, privilegesRequired));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserInteraction getUserInteraction() {
		return userInteraction;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setUserInteraction(UserInteraction newUserInteraction) {
		UserInteraction oldUserInteraction = userInteraction;
		userInteraction = newUserInteraction == null ? USER_INTERACTION_EDEFAULT : newUserInteraction;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__USER_INTERACTION, oldUserInteraction, userInteraction));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExploitCodeMaturity getExploitCodeMaturity() {
		return exploitCodeMaturity;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setExploitCodeMaturity(ExploitCodeMaturity newExploitCodeMaturity) {
		ExploitCodeMaturity oldExploitCodeMaturity = exploitCodeMaturity;
		exploitCodeMaturity = newExploitCodeMaturity == null ? EXPLOIT_CODE_MATURITY_EDEFAULT : newExploitCodeMaturity;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__EXPLOIT_CODE_MATURITY, oldExploitCodeMaturity, exploitCodeMaturity));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportConfidence getReportConfidence() {
		return reportConfidence;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setReportConfidence(ReportConfidence newReportConfidence) {
		ReportConfidence oldReportConfidence = reportConfidence;
		reportConfidence = newReportConfidence == null ? REPORT_CONFIDENCE_EDEFAULT : newReportConfidence;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__REPORT_CONFIDENCE, oldReportConfidence, reportConfidence));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidentialityImpact getConfidentialityImpact() {
		return confidentialityImpact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidentialityImpact(ConfidentialityImpact newConfidentialityImpact) {
		ConfidentialityImpact oldConfidentialityImpact = confidentialityImpact;
		confidentialityImpact = newConfidentialityImpact == null ? CONFIDENTIALITY_IMPACT_EDEFAULT : newConfidentialityImpact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_IMPACT, oldConfidentialityImpact, confidentialityImpact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegrityImpact getIntegrityImpact() {
		return integrityImpact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegrityImpact(IntegrityImpact newIntegrityImpact) {
		IntegrityImpact oldIntegrityImpact = integrityImpact;
		integrityImpact = newIntegrityImpact == null ? INTEGRITY_IMPACT_EDEFAULT : newIntegrityImpact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__INTEGRITY_IMPACT, oldIntegrityImpact, integrityImpact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityImpact getAvailabilityImpact() {
		return availabilityImpact;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailabilityImpact(AvailabilityImpact newAvailabilityImpact) {
		AvailabilityImpact oldAvailabilityImpact = availabilityImpact;
		availabilityImpact = newAvailabilityImpact == null ? AVAILABILITY_IMPACT_EDEFAULT : newAvailabilityImpact;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__AVAILABILITY_IMPACT, oldAvailabilityImpact, availabilityImpact));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemediationLevel getRemediationLevel() {
		return remediationLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setRemediationLevel(RemediationLevel newRemediationLevel) {
		RemediationLevel oldRemediationLevel = remediationLevel;
		remediationLevel = newRemediationLevel == null ? REMEDIATION_LEVEL_EDEFAULT : newRemediationLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__REMEDIATION_LEVEL, oldRemediationLevel, remediationLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidentialityRequirement getConfidentialityRequirement() {
		return confidentialityRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setConfidentialityRequirement(ConfidentialityRequirement newConfidentialityRequirement) {
		ConfidentialityRequirement oldConfidentialityRequirement = confidentialityRequirement;
		confidentialityRequirement = newConfidentialityRequirement == null ? CONFIDENTIALITY_REQUIREMENT_EDEFAULT : newConfidentialityRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT, oldConfidentialityRequirement, confidentialityRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegrityRequirement getIntegrityRequirement() {
		return integrityRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIntegrityRequirement(IntegrityRequirement newIntegrityRequirement) {
		IntegrityRequirement oldIntegrityRequirement = integrityRequirement;
		integrityRequirement = newIntegrityRequirement == null ? INTEGRITY_REQUIREMENT_EDEFAULT : newIntegrityRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__INTEGRITY_REQUIREMENT, oldIntegrityRequirement, integrityRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityRequirement getAvailabilityRequirement() {
		return availabilityRequirement;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAvailabilityRequirement(AvailabilityRequirement newAvailabilityRequirement) {
		AvailabilityRequirement oldAvailabilityRequirement = availabilityRequirement;
		availabilityRequirement = newAvailabilityRequirement == null ? AVAILABILITY_REQUIREMENT_EDEFAULT : newAvailabilityRequirement;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CVSS_VECTOR__AVAILABILITY_REQUIREMENT, oldAvailabilityRequirement, availabilityRequirement));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CASAPackage.CVSS_VECTOR__ATTACK_VECTOR:
				return getAttackVector();
			case CASAPackage.CVSS_VECTOR__ATTACK_COMPLEXITY:
				return getAttackComplexity();
			case CASAPackage.CVSS_VECTOR__SCOPE:
				return getScope();
			case CASAPackage.CVSS_VECTOR__PRIVILEGES_REQUIRED:
				return getPrivilegesRequired();
			case CASAPackage.CVSS_VECTOR__USER_INTERACTION:
				return getUserInteraction();
			case CASAPackage.CVSS_VECTOR__EXPLOIT_CODE_MATURITY:
				return getExploitCodeMaturity();
			case CASAPackage.CVSS_VECTOR__REPORT_CONFIDENCE:
				return getReportConfidence();
			case CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_IMPACT:
				return getConfidentialityImpact();
			case CASAPackage.CVSS_VECTOR__INTEGRITY_IMPACT:
				return getIntegrityImpact();
			case CASAPackage.CVSS_VECTOR__AVAILABILITY_IMPACT:
				return getAvailabilityImpact();
			case CASAPackage.CVSS_VECTOR__REMEDIATION_LEVEL:
				return getRemediationLevel();
			case CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT:
				return getConfidentialityRequirement();
			case CASAPackage.CVSS_VECTOR__INTEGRITY_REQUIREMENT:
				return getIntegrityRequirement();
			case CASAPackage.CVSS_VECTOR__AVAILABILITY_REQUIREMENT:
				return getAvailabilityRequirement();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CASAPackage.CVSS_VECTOR__ATTACK_VECTOR:
				setAttackVector((AttackVector)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__ATTACK_COMPLEXITY:
				setAttackComplexity((AttackComplexity)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__SCOPE:
				setScope((Scope)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__PRIVILEGES_REQUIRED:
				setPrivilegesRequired((PrivilegesRequired)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__USER_INTERACTION:
				setUserInteraction((UserInteraction)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__EXPLOIT_CODE_MATURITY:
				setExploitCodeMaturity((ExploitCodeMaturity)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__REPORT_CONFIDENCE:
				setReportConfidence((ReportConfidence)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_IMPACT:
				setConfidentialityImpact((ConfidentialityImpact)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__INTEGRITY_IMPACT:
				setIntegrityImpact((IntegrityImpact)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__AVAILABILITY_IMPACT:
				setAvailabilityImpact((AvailabilityImpact)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__REMEDIATION_LEVEL:
				setRemediationLevel((RemediationLevel)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT:
				setConfidentialityRequirement((ConfidentialityRequirement)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__INTEGRITY_REQUIREMENT:
				setIntegrityRequirement((IntegrityRequirement)newValue);
				return;
			case CASAPackage.CVSS_VECTOR__AVAILABILITY_REQUIREMENT:
				setAvailabilityRequirement((AvailabilityRequirement)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CASAPackage.CVSS_VECTOR__ATTACK_VECTOR:
				setAttackVector(ATTACK_VECTOR_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__ATTACK_COMPLEXITY:
				setAttackComplexity(ATTACK_COMPLEXITY_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__SCOPE:
				setScope(SCOPE_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__PRIVILEGES_REQUIRED:
				setPrivilegesRequired(PRIVILEGES_REQUIRED_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__USER_INTERACTION:
				setUserInteraction(USER_INTERACTION_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__EXPLOIT_CODE_MATURITY:
				setExploitCodeMaturity(EXPLOIT_CODE_MATURITY_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__REPORT_CONFIDENCE:
				setReportConfidence(REPORT_CONFIDENCE_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_IMPACT:
				setConfidentialityImpact(CONFIDENTIALITY_IMPACT_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__INTEGRITY_IMPACT:
				setIntegrityImpact(INTEGRITY_IMPACT_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__AVAILABILITY_IMPACT:
				setAvailabilityImpact(AVAILABILITY_IMPACT_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__REMEDIATION_LEVEL:
				setRemediationLevel(REMEDIATION_LEVEL_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT:
				setConfidentialityRequirement(CONFIDENTIALITY_REQUIREMENT_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__INTEGRITY_REQUIREMENT:
				setIntegrityRequirement(INTEGRITY_REQUIREMENT_EDEFAULT);
				return;
			case CASAPackage.CVSS_VECTOR__AVAILABILITY_REQUIREMENT:
				setAvailabilityRequirement(AVAILABILITY_REQUIREMENT_EDEFAULT);
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CASAPackage.CVSS_VECTOR__ATTACK_VECTOR:
				return attackVector != ATTACK_VECTOR_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__ATTACK_COMPLEXITY:
				return attackComplexity != ATTACK_COMPLEXITY_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__SCOPE:
				return scope != SCOPE_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__PRIVILEGES_REQUIRED:
				return privilegesRequired != PRIVILEGES_REQUIRED_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__USER_INTERACTION:
				return userInteraction != USER_INTERACTION_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__EXPLOIT_CODE_MATURITY:
				return exploitCodeMaturity != EXPLOIT_CODE_MATURITY_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__REPORT_CONFIDENCE:
				return reportConfidence != REPORT_CONFIDENCE_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_IMPACT:
				return confidentialityImpact != CONFIDENTIALITY_IMPACT_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__INTEGRITY_IMPACT:
				return integrityImpact != INTEGRITY_IMPACT_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__AVAILABILITY_IMPACT:
				return availabilityImpact != AVAILABILITY_IMPACT_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__REMEDIATION_LEVEL:
				return remediationLevel != REMEDIATION_LEVEL_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT:
				return confidentialityRequirement != CONFIDENTIALITY_REQUIREMENT_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__INTEGRITY_REQUIREMENT:
				return integrityRequirement != INTEGRITY_REQUIREMENT_EDEFAULT;
			case CASAPackage.CVSS_VECTOR__AVAILABILITY_REQUIREMENT:
				return availabilityRequirement != AVAILABILITY_REQUIREMENT_EDEFAULT;
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (attackVector: ");
		result.append(attackVector);
		result.append(", attackComplexity: ");
		result.append(attackComplexity);
		result.append(", scope: ");
		result.append(scope);
		result.append(", privilegesRequired: ");
		result.append(privilegesRequired);
		result.append(", userInteraction: ");
		result.append(userInteraction);
		result.append(", exploitCodeMaturity: ");
		result.append(exploitCodeMaturity);
		result.append(", reportConfidence: ");
		result.append(reportConfidence);
		result.append(", confidentialityImpact: ");
		result.append(confidentialityImpact);
		result.append(", integrityImpact: ");
		result.append(integrityImpact);
		result.append(", availabilityImpact: ");
		result.append(availabilityImpact);
		result.append(", remediationLevel: ");
		result.append(remediationLevel);
		result.append(", confidentialityRequirement: ");
		result.append(confidentialityRequirement);
		result.append(", integrityRequirement: ");
		result.append(integrityRequirement);
		result.append(", availabilityRequirement: ");
		result.append(availabilityRequirement);
		result.append(')');
		return result.toString();
	}

} //CVSSVectorImpl
