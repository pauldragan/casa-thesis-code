/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Consent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.Consent#getForPurpose <em>For Purpose</em>}</li>
 *   <li>{@link CASA.Consent#getInformedRiskLevel <em>Informed Risk Level</em>}</li>
 *   <li>{@link CASA.Consent#getGivenFor <em>Given For</em>}</li>
 *   <li>{@link CASA.Consent#getGivenBy <em>Given By</em>}</li>
 *   <li>{@link CASA.Consent#getForPersonalData <em>For Personal Data</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getConsent()
 * @model
 * @generated
 */
public interface Consent extends EObject {
	/**
	 * Returns the value of the '<em><b>For Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Purpose</em>' attribute.
	 * @see #setForPurpose(String)
	 * @see CASA.CASAPackage#getConsent_ForPurpose()
	 * @model
	 * @generated
	 */
	String getForPurpose();

	/**
	 * Sets the value of the '{@link CASA.Consent#getForPurpose <em>For Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>For Purpose</em>' attribute.
	 * @see #getForPurpose()
	 * @generated
	 */
	void setForPurpose(String value);

	/**
	 * Returns the value of the '<em><b>Informed Risk Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Informed Risk Level</em>' attribute.
	 * @see #setInformedRiskLevel(double)
	 * @see CASA.CASAPackage#getConsent_InformedRiskLevel()
	 * @model required="true"
	 * @generated
	 */
	double getInformedRiskLevel();

	/**
	 * Sets the value of the '{@link CASA.Consent#getInformedRiskLevel <em>Informed Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Informed Risk Level</em>' attribute.
	 * @see #getInformedRiskLevel()
	 * @generated
	 */
	void setInformedRiskLevel(double value);

	/**
	 * Returns the value of the '<em><b>Given For</b></em>' reference list.
	 * The list contents are of type {@link CASA.PurposeConsent}.
	 * It is bidirectional and its opposite is '{@link CASA.PurposeConsent#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Given For</em>' reference list.
	 * @see CASA.CASAPackage#getConsent_GivenFor()
	 * @see CASA.PurposeConsent#getRequires
	 * @model opposite="requires"
	 * @generated
	 */
	EList<PurposeConsent> getGivenFor();

	/**
	 * Returns the value of the '<em><b>Given By</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link CASA.DataSubject#getGives <em>Gives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Given By</em>' container reference.
	 * @see #setGivenBy(DataSubject)
	 * @see CASA.CASAPackage#getConsent_GivenBy()
	 * @see CASA.DataSubject#getGives
	 * @model opposite="gives" required="true" transient="false"
	 * @generated
	 */
	DataSubject getGivenBy();

	/**
	 * Sets the value of the '{@link CASA.Consent#getGivenBy <em>Given By</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Given By</em>' container reference.
	 * @see #getGivenBy()
	 * @generated
	 */
	void setGivenBy(DataSubject value);

	/**
	 * Returns the value of the '<em><b>For Personal Data</b></em>' reference list.
	 * The list contents are of type {@link CASA.PersonalData}.
	 * It is bidirectional and its opposite is '{@link CASA.PersonalData#getSubjectOfConsent <em>Subject Of Consent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>For Personal Data</em>' reference list.
	 * @see CASA.CASAPackage#getConsent_ForPersonalData()
	 * @see CASA.PersonalData#getSubjectOfConsent
	 * @model opposite="subjectOfConsent"
	 * @generated
	 */
	EList<PersonalData> getForPersonalData();

} // Consent
