/**
 */
package CASA.CVSS;

import org.eclipse.emf.ecore.EEnum;
import org.eclipse.emf.ecore.EPackage;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see CASA.CVSS.CVSSFactory
 * @model kind="package"
 * @generated
 */
public interface CVSSPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CVSS";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.casa.com/cvss";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "casa.cvss";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CVSSPackage eINSTANCE = CASA.CVSS.impl.CVSSPackageImpl.init();

	/**
	 * The meta object id for the '{@link CASA.CVSS.AttackVector <em>Attack Vector</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.AttackVector
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getAttackVector()
	 * @generated
	 */
	int ATTACK_VECTOR = 0;

	/**
	 * The meta object id for the '{@link CASA.CVSS.AttackComplexity <em>Attack Complexity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.AttackComplexity
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getAttackComplexity()
	 * @generated
	 */
	int ATTACK_COMPLEXITY = 1;

	/**
	 * The meta object id for the '{@link CASA.CVSS.Scope <em>Scope</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.Scope
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getScope()
	 * @generated
	 */
	int SCOPE = 2;

	/**
	 * The meta object id for the '{@link CASA.CVSS.PrivilegesRequired <em>Privileges Required</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.PrivilegesRequired
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getPrivilegesRequired()
	 * @generated
	 */
	int PRIVILEGES_REQUIRED = 3;

	/**
	 * The meta object id for the '{@link CASA.CVSS.UserInteraction <em>User Interaction</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.UserInteraction
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getUserInteraction()
	 * @generated
	 */
	int USER_INTERACTION = 4;

	/**
	 * The meta object id for the '{@link CASA.CVSS.ExploitCodeMaturity <em>Exploit Code Maturity</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.ExploitCodeMaturity
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getExploitCodeMaturity()
	 * @generated
	 */
	int EXPLOIT_CODE_MATURITY = 5;

	/**
	 * The meta object id for the '{@link CASA.CVSS.ReportConfidence <em>Report Confidence</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.ReportConfidence
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getReportConfidence()
	 * @generated
	 */
	int REPORT_CONFIDENCE = 6;

	/**
	 * The meta object id for the '{@link CASA.CVSS.ConfidentialityImpact <em>Confidentiality Impact</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.ConfidentialityImpact
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getConfidentialityImpact()
	 * @generated
	 */
	int CONFIDENTIALITY_IMPACT = 7;

	/**
	 * The meta object id for the '{@link CASA.CVSS.IntegrityImpact <em>Integrity Impact</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.IntegrityImpact
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getIntegrityImpact()
	 * @generated
	 */
	int INTEGRITY_IMPACT = 8;

	/**
	 * The meta object id for the '{@link CASA.CVSS.AvailabilityImpact <em>Availability Impact</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.AvailabilityImpact
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getAvailabilityImpact()
	 * @generated
	 */
	int AVAILABILITY_IMPACT = 9;

	/**
	 * The meta object id for the '{@link CASA.CVSS.RemediationLevel <em>Remediation Level</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.RemediationLevel
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getRemediationLevel()
	 * @generated
	 */
	int REMEDIATION_LEVEL = 10;

	/**
	 * The meta object id for the '{@link CASA.CVSS.ConfidentialityRequirement <em>Confidentiality Requirement</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.ConfidentialityRequirement
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getConfidentialityRequirement()
	 * @generated
	 */
	int CONFIDENTIALITY_REQUIREMENT = 11;

	/**
	 * The meta object id for the '{@link CASA.CVSS.IntegrityRequirement <em>Integrity Requirement</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.IntegrityRequirement
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getIntegrityRequirement()
	 * @generated
	 */
	int INTEGRITY_REQUIREMENT = 12;

	/**
	 * The meta object id for the '{@link CASA.CVSS.AvailabilityRequirement <em>Availability Requirement</em>}' enum.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.CVSS.AvailabilityRequirement
	 * @see CASA.CVSS.impl.CVSSPackageImpl#getAvailabilityRequirement()
	 * @generated
	 */
	int AVAILABILITY_REQUIREMENT = 13;


	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.AttackVector <em>Attack Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Attack Vector</em>'.
	 * @see CASA.CVSS.AttackVector
	 * @generated
	 */
	EEnum getAttackVector();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.AttackComplexity <em>Attack Complexity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Attack Complexity</em>'.
	 * @see CASA.CVSS.AttackComplexity
	 * @generated
	 */
	EEnum getAttackComplexity();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.Scope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Scope</em>'.
	 * @see CASA.CVSS.Scope
	 * @generated
	 */
	EEnum getScope();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.PrivilegesRequired <em>Privileges Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Privileges Required</em>'.
	 * @see CASA.CVSS.PrivilegesRequired
	 * @generated
	 */
	EEnum getPrivilegesRequired();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.UserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>User Interaction</em>'.
	 * @see CASA.CVSS.UserInteraction
	 * @generated
	 */
	EEnum getUserInteraction();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.ExploitCodeMaturity <em>Exploit Code Maturity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Exploit Code Maturity</em>'.
	 * @see CASA.CVSS.ExploitCodeMaturity
	 * @generated
	 */
	EEnum getExploitCodeMaturity();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.ReportConfidence <em>Report Confidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Report Confidence</em>'.
	 * @see CASA.CVSS.ReportConfidence
	 * @generated
	 */
	EEnum getReportConfidence();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.ConfidentialityImpact <em>Confidentiality Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Confidentiality Impact</em>'.
	 * @see CASA.CVSS.ConfidentialityImpact
	 * @generated
	 */
	EEnum getConfidentialityImpact();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.IntegrityImpact <em>Integrity Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Integrity Impact</em>'.
	 * @see CASA.CVSS.IntegrityImpact
	 * @generated
	 */
	EEnum getIntegrityImpact();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.AvailabilityImpact <em>Availability Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Availability Impact</em>'.
	 * @see CASA.CVSS.AvailabilityImpact
	 * @generated
	 */
	EEnum getAvailabilityImpact();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.RemediationLevel <em>Remediation Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Remediation Level</em>'.
	 * @see CASA.CVSS.RemediationLevel
	 * @generated
	 */
	EEnum getRemediationLevel();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.ConfidentialityRequirement <em>Confidentiality Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Confidentiality Requirement</em>'.
	 * @see CASA.CVSS.ConfidentialityRequirement
	 * @generated
	 */
	EEnum getConfidentialityRequirement();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.IntegrityRequirement <em>Integrity Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Integrity Requirement</em>'.
	 * @see CASA.CVSS.IntegrityRequirement
	 * @generated
	 */
	EEnum getIntegrityRequirement();

	/**
	 * Returns the meta object for enum '{@link CASA.CVSS.AvailabilityRequirement <em>Availability Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for enum '<em>Availability Requirement</em>'.
	 * @see CASA.CVSS.AvailabilityRequirement
	 * @generated
	 */
	EEnum getAvailabilityRequirement();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CVSSFactory getCVSSFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link CASA.CVSS.AttackVector <em>Attack Vector</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.AttackVector
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getAttackVector()
		 * @generated
		 */
		EEnum ATTACK_VECTOR = eINSTANCE.getAttackVector();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.AttackComplexity <em>Attack Complexity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.AttackComplexity
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getAttackComplexity()
		 * @generated
		 */
		EEnum ATTACK_COMPLEXITY = eINSTANCE.getAttackComplexity();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.Scope <em>Scope</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.Scope
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getScope()
		 * @generated
		 */
		EEnum SCOPE = eINSTANCE.getScope();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.PrivilegesRequired <em>Privileges Required</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.PrivilegesRequired
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getPrivilegesRequired()
		 * @generated
		 */
		EEnum PRIVILEGES_REQUIRED = eINSTANCE.getPrivilegesRequired();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.UserInteraction <em>User Interaction</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.UserInteraction
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getUserInteraction()
		 * @generated
		 */
		EEnum USER_INTERACTION = eINSTANCE.getUserInteraction();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.ExploitCodeMaturity <em>Exploit Code Maturity</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.ExploitCodeMaturity
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getExploitCodeMaturity()
		 * @generated
		 */
		EEnum EXPLOIT_CODE_MATURITY = eINSTANCE.getExploitCodeMaturity();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.ReportConfidence <em>Report Confidence</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.ReportConfidence
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getReportConfidence()
		 * @generated
		 */
		EEnum REPORT_CONFIDENCE = eINSTANCE.getReportConfidence();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.ConfidentialityImpact <em>Confidentiality Impact</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.ConfidentialityImpact
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getConfidentialityImpact()
		 * @generated
		 */
		EEnum CONFIDENTIALITY_IMPACT = eINSTANCE.getConfidentialityImpact();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.IntegrityImpact <em>Integrity Impact</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.IntegrityImpact
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getIntegrityImpact()
		 * @generated
		 */
		EEnum INTEGRITY_IMPACT = eINSTANCE.getIntegrityImpact();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.AvailabilityImpact <em>Availability Impact</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.AvailabilityImpact
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getAvailabilityImpact()
		 * @generated
		 */
		EEnum AVAILABILITY_IMPACT = eINSTANCE.getAvailabilityImpact();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.RemediationLevel <em>Remediation Level</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.RemediationLevel
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getRemediationLevel()
		 * @generated
		 */
		EEnum REMEDIATION_LEVEL = eINSTANCE.getRemediationLevel();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.ConfidentialityRequirement <em>Confidentiality Requirement</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.ConfidentialityRequirement
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getConfidentialityRequirement()
		 * @generated
		 */
		EEnum CONFIDENTIALITY_REQUIREMENT = eINSTANCE.getConfidentialityRequirement();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.IntegrityRequirement <em>Integrity Requirement</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.IntegrityRequirement
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getIntegrityRequirement()
		 * @generated
		 */
		EEnum INTEGRITY_REQUIREMENT = eINSTANCE.getIntegrityRequirement();

		/**
		 * The meta object literal for the '{@link CASA.CVSS.AvailabilityRequirement <em>Availability Requirement</em>}' enum.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.CVSS.AvailabilityRequirement
		 * @see CASA.CVSS.impl.CVSSPackageImpl#getAvailabilityRequirement()
		 * @generated
		 */
		EEnum AVAILABILITY_REQUIREMENT = eINSTANCE.getAvailabilityRequirement();

	}

} //CVSSPackage
