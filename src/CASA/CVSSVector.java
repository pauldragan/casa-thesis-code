/**
 */
package CASA;

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

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>CVSS Vector</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.CVSSVector#getAttackVector <em>Attack Vector</em>}</li>
 *   <li>{@link CASA.CVSSVector#getAttackComplexity <em>Attack Complexity</em>}</li>
 *   <li>{@link CASA.CVSSVector#getScope <em>Scope</em>}</li>
 *   <li>{@link CASA.CVSSVector#getPrivilegesRequired <em>Privileges Required</em>}</li>
 *   <li>{@link CASA.CVSSVector#getUserInteraction <em>User Interaction</em>}</li>
 *   <li>{@link CASA.CVSSVector#getExploitCodeMaturity <em>Exploit Code Maturity</em>}</li>
 *   <li>{@link CASA.CVSSVector#getReportConfidence <em>Report Confidence</em>}</li>
 *   <li>{@link CASA.CVSSVector#getConfidentialityImpact <em>Confidentiality Impact</em>}</li>
 *   <li>{@link CASA.CVSSVector#getIntegrityImpact <em>Integrity Impact</em>}</li>
 *   <li>{@link CASA.CVSSVector#getAvailabilityImpact <em>Availability Impact</em>}</li>
 *   <li>{@link CASA.CVSSVector#getRemediationLevel <em>Remediation Level</em>}</li>
 *   <li>{@link CASA.CVSSVector#getConfidentialityRequirement <em>Confidentiality Requirement</em>}</li>
 *   <li>{@link CASA.CVSSVector#getIntegrityRequirement <em>Integrity Requirement</em>}</li>
 *   <li>{@link CASA.CVSSVector#getAvailabilityRequirement <em>Availability Requirement</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getCVSSVector()
 * @model
 * @generated
 */
public interface CVSSVector extends EObject {
	/**
	 * Returns the value of the '<em><b>Attack Vector</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.AttackVector}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attack Vector</em>' attribute.
	 * @see CASA.CVSS.AttackVector
	 * @see #setAttackVector(AttackVector)
	 * @see CASA.CASAPackage#getCVSSVector_AttackVector()
	 * @model
	 * @generated
	 */
	AttackVector getAttackVector();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getAttackVector <em>Attack Vector</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attack Vector</em>' attribute.
	 * @see CASA.CVSS.AttackVector
	 * @see #getAttackVector()
	 * @generated
	 */
	void setAttackVector(AttackVector value);

	/**
	 * Returns the value of the '<em><b>Attack Complexity</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.AttackComplexity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Attack Complexity</em>' attribute.
	 * @see CASA.CVSS.AttackComplexity
	 * @see #setAttackComplexity(AttackComplexity)
	 * @see CASA.CASAPackage#getCVSSVector_AttackComplexity()
	 * @model
	 * @generated
	 */
	AttackComplexity getAttackComplexity();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getAttackComplexity <em>Attack Complexity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Attack Complexity</em>' attribute.
	 * @see CASA.CVSS.AttackComplexity
	 * @see #getAttackComplexity()
	 * @generated
	 */
	void setAttackComplexity(AttackComplexity value);

	/**
	 * Returns the value of the '<em><b>Scope</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.Scope}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Scope</em>' attribute.
	 * @see CASA.CVSS.Scope
	 * @see #setScope(Scope)
	 * @see CASA.CASAPackage#getCVSSVector_Scope()
	 * @model
	 * @generated
	 */
	Scope getScope();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getScope <em>Scope</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Scope</em>' attribute.
	 * @see CASA.CVSS.Scope
	 * @see #getScope()
	 * @generated
	 */
	void setScope(Scope value);

	/**
	 * Returns the value of the '<em><b>Privileges Required</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.PrivilegesRequired}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Privileges Required</em>' attribute.
	 * @see CASA.CVSS.PrivilegesRequired
	 * @see #setPrivilegesRequired(PrivilegesRequired)
	 * @see CASA.CASAPackage#getCVSSVector_PrivilegesRequired()
	 * @model
	 * @generated
	 */
	PrivilegesRequired getPrivilegesRequired();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getPrivilegesRequired <em>Privileges Required</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Privileges Required</em>' attribute.
	 * @see CASA.CVSS.PrivilegesRequired
	 * @see #getPrivilegesRequired()
	 * @generated
	 */
	void setPrivilegesRequired(PrivilegesRequired value);

	/**
	 * Returns the value of the '<em><b>User Interaction</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.UserInteraction}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>User Interaction</em>' attribute.
	 * @see CASA.CVSS.UserInteraction
	 * @see #setUserInteraction(UserInteraction)
	 * @see CASA.CASAPackage#getCVSSVector_UserInteraction()
	 * @model
	 * @generated
	 */
	UserInteraction getUserInteraction();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getUserInteraction <em>User Interaction</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>User Interaction</em>' attribute.
	 * @see CASA.CVSS.UserInteraction
	 * @see #getUserInteraction()
	 * @generated
	 */
	void setUserInteraction(UserInteraction value);

	/**
	 * Returns the value of the '<em><b>Exploit Code Maturity</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.ExploitCodeMaturity}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Exploit Code Maturity</em>' attribute.
	 * @see CASA.CVSS.ExploitCodeMaturity
	 * @see #setExploitCodeMaturity(ExploitCodeMaturity)
	 * @see CASA.CASAPackage#getCVSSVector_ExploitCodeMaturity()
	 * @model
	 * @generated
	 */
	ExploitCodeMaturity getExploitCodeMaturity();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getExploitCodeMaturity <em>Exploit Code Maturity</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Exploit Code Maturity</em>' attribute.
	 * @see CASA.CVSS.ExploitCodeMaturity
	 * @see #getExploitCodeMaturity()
	 * @generated
	 */
	void setExploitCodeMaturity(ExploitCodeMaturity value);

	/**
	 * Returns the value of the '<em><b>Report Confidence</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.ReportConfidence}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Report Confidence</em>' attribute.
	 * @see CASA.CVSS.ReportConfidence
	 * @see #setReportConfidence(ReportConfidence)
	 * @see CASA.CASAPackage#getCVSSVector_ReportConfidence()
	 * @model
	 * @generated
	 */
	ReportConfidence getReportConfidence();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getReportConfidence <em>Report Confidence</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Report Confidence</em>' attribute.
	 * @see CASA.CVSS.ReportConfidence
	 * @see #getReportConfidence()
	 * @generated
	 */
	void setReportConfidence(ReportConfidence value);

	/**
	 * Returns the value of the '<em><b>Confidentiality Impact</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.ConfidentialityImpact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidentiality Impact</em>' attribute.
	 * @see CASA.CVSS.ConfidentialityImpact
	 * @see #setConfidentialityImpact(ConfidentialityImpact)
	 * @see CASA.CASAPackage#getCVSSVector_ConfidentialityImpact()
	 * @model
	 * @generated
	 */
	ConfidentialityImpact getConfidentialityImpact();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getConfidentialityImpact <em>Confidentiality Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidentiality Impact</em>' attribute.
	 * @see CASA.CVSS.ConfidentialityImpact
	 * @see #getConfidentialityImpact()
	 * @generated
	 */
	void setConfidentialityImpact(ConfidentialityImpact value);

	/**
	 * Returns the value of the '<em><b>Integrity Impact</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.IntegrityImpact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integrity Impact</em>' attribute.
	 * @see CASA.CVSS.IntegrityImpact
	 * @see #setIntegrityImpact(IntegrityImpact)
	 * @see CASA.CASAPackage#getCVSSVector_IntegrityImpact()
	 * @model
	 * @generated
	 */
	IntegrityImpact getIntegrityImpact();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getIntegrityImpact <em>Integrity Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integrity Impact</em>' attribute.
	 * @see CASA.CVSS.IntegrityImpact
	 * @see #getIntegrityImpact()
	 * @generated
	 */
	void setIntegrityImpact(IntegrityImpact value);

	/**
	 * Returns the value of the '<em><b>Availability Impact</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.AvailabilityImpact}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Availability Impact</em>' attribute.
	 * @see CASA.CVSS.AvailabilityImpact
	 * @see #setAvailabilityImpact(AvailabilityImpact)
	 * @see CASA.CASAPackage#getCVSSVector_AvailabilityImpact()
	 * @model
	 * @generated
	 */
	AvailabilityImpact getAvailabilityImpact();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getAvailabilityImpact <em>Availability Impact</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Availability Impact</em>' attribute.
	 * @see CASA.CVSS.AvailabilityImpact
	 * @see #getAvailabilityImpact()
	 * @generated
	 */
	void setAvailabilityImpact(AvailabilityImpact value);

	/**
	 * Returns the value of the '<em><b>Remediation Level</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.RemediationLevel}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Remediation Level</em>' attribute.
	 * @see CASA.CVSS.RemediationLevel
	 * @see #setRemediationLevel(RemediationLevel)
	 * @see CASA.CASAPackage#getCVSSVector_RemediationLevel()
	 * @model
	 * @generated
	 */
	RemediationLevel getRemediationLevel();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getRemediationLevel <em>Remediation Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Remediation Level</em>' attribute.
	 * @see CASA.CVSS.RemediationLevel
	 * @see #getRemediationLevel()
	 * @generated
	 */
	void setRemediationLevel(RemediationLevel value);

	/**
	 * Returns the value of the '<em><b>Confidentiality Requirement</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.ConfidentialityRequirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Confidentiality Requirement</em>' attribute.
	 * @see CASA.CVSS.ConfidentialityRequirement
	 * @see #setConfidentialityRequirement(ConfidentialityRequirement)
	 * @see CASA.CASAPackage#getCVSSVector_ConfidentialityRequirement()
	 * @model
	 * @generated
	 */
	ConfidentialityRequirement getConfidentialityRequirement();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getConfidentialityRequirement <em>Confidentiality Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Confidentiality Requirement</em>' attribute.
	 * @see CASA.CVSS.ConfidentialityRequirement
	 * @see #getConfidentialityRequirement()
	 * @generated
	 */
	void setConfidentialityRequirement(ConfidentialityRequirement value);

	/**
	 * Returns the value of the '<em><b>Integrity Requirement</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.IntegrityRequirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Integrity Requirement</em>' attribute.
	 * @see CASA.CVSS.IntegrityRequirement
	 * @see #setIntegrityRequirement(IntegrityRequirement)
	 * @see CASA.CASAPackage#getCVSSVector_IntegrityRequirement()
	 * @model
	 * @generated
	 */
	IntegrityRequirement getIntegrityRequirement();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getIntegrityRequirement <em>Integrity Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Integrity Requirement</em>' attribute.
	 * @see CASA.CVSS.IntegrityRequirement
	 * @see #getIntegrityRequirement()
	 * @generated
	 */
	void setIntegrityRequirement(IntegrityRequirement value);

	/**
	 * Returns the value of the '<em><b>Availability Requirement</b></em>' attribute.
	 * The literals are from the enumeration {@link CASA.CVSS.AvailabilityRequirement}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Availability Requirement</em>' attribute.
	 * @see CASA.CVSS.AvailabilityRequirement
	 * @see #setAvailabilityRequirement(AvailabilityRequirement)
	 * @see CASA.CASAPackage#getCVSSVector_AvailabilityRequirement()
	 * @model
	 * @generated
	 */
	AvailabilityRequirement getAvailabilityRequirement();

	/**
	 * Sets the value of the '{@link CASA.CVSSVector#getAvailabilityRequirement <em>Availability Requirement</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Availability Requirement</em>' attribute.
	 * @see CASA.CVSS.AvailabilityRequirement
	 * @see #getAvailabilityRequirement()
	 * @generated
	 */
	void setAvailabilityRequirement(AvailabilityRequirement value);

} // CVSSVector
