/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Personal Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.PersonalData#getIdentifies <em>Identifies</em>}</li>
 *   <li>{@link CASA.PersonalData#getProcessedBy <em>Processed By</em>}</li>
 *   <li>{@link CASA.PersonalData#getSubjectOfConsent <em>Subject Of Consent</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getPersonalData()
 * @model
 * @generated
 */
public interface PersonalData extends Data {
	/**
	 * Returns the value of the '<em><b>Identifies</b></em>' reference.
	 * It is bidirectional and its opposite is '{@link CASA.DataSubject#getIdentifiedBy <em>Identified By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identifies</em>' reference.
	 * @see #setIdentifies(DataSubject)
	 * @see CASA.CASAPackage#getPersonalData_Identifies()
	 * @see CASA.DataSubject#getIdentifiedBy
	 * @model opposite="identifiedBy" required="true"
	 * @generated
	 */
	DataSubject getIdentifies();

	/**
	 * Sets the value of the '{@link CASA.PersonalData#getIdentifies <em>Identifies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Identifies</em>' reference.
	 * @see #getIdentifies()
	 * @generated
	 */
	void setIdentifies(DataSubject value);

	/**
	 * Returns the value of the '<em><b>Processed By</b></em>' reference list.
	 * The list contents are of type {@link CASA.FuncPersData}.
	 * It is bidirectional and its opposite is '{@link CASA.FuncPersData#getProcessesPersData <em>Processes Pers Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processed By</em>' reference list.
	 * @see CASA.CASAPackage#getPersonalData_ProcessedBy()
	 * @see CASA.FuncPersData#getProcessesPersData
	 * @model opposite="processesPersData"
	 * @generated
	 */
	EList<FuncPersData> getProcessedBy();

	/**
	 * Returns the value of the '<em><b>Subject Of Consent</b></em>' reference list.
	 * The list contents are of type {@link CASA.Consent}.
	 * It is bidirectional and its opposite is '{@link CASA.Consent#getForPersonalData <em>For Personal Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Subject Of Consent</em>' reference list.
	 * @see CASA.CASAPackage#getPersonalData_SubjectOfConsent()
	 * @see CASA.Consent#getForPersonalData
	 * @model opposite="forPersonalData"
	 * @generated
	 */
	EList<Consent> getSubjectOfConsent();

} // PersonalData
