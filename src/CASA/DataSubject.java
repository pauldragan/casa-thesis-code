/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Data Subject</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.DataSubject#getIdentifiedBy <em>Identified By</em>}</li>
 *   <li>{@link CASA.DataSubject#getName <em>Name</em>}</li>
 *   <li>{@link CASA.DataSubject#getGives <em>Gives</em>}</li>
 *   <li>{@link CASA.DataSubject#getAffectedBy <em>Affected By</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getDataSubject()
 * @model
 * @generated
 */
public interface DataSubject extends EObject {
	/**
	 * Returns the value of the '<em><b>Identified By</b></em>' reference list.
	 * The list contents are of type {@link CASA.PersonalData}.
	 * It is bidirectional and its opposite is '{@link CASA.PersonalData#getIdentifies <em>Identifies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Identified By</em>' reference list.
	 * @see CASA.CASAPackage#getDataSubject_IdentifiedBy()
	 * @see CASA.PersonalData#getIdentifies
	 * @model opposite="identifies"
	 * @generated
	 */
	EList<PersonalData> getIdentifiedBy();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see CASA.CASAPackage#getDataSubject_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link CASA.DataSubject#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Gives</b></em>' containment reference list.
	 * The list contents are of type {@link CASA.Consent}.
	 * It is bidirectional and its opposite is '{@link CASA.Consent#getGivenBy <em>Given By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Gives</em>' containment reference list.
	 * @see CASA.CASAPackage#getDataSubject_Gives()
	 * @see CASA.Consent#getGivenBy
	 * @model opposite="givenBy" containment="true"
	 * @generated
	 */
	EList<Consent> getGives();

	/**
	 * Returns the value of the '<em><b>Affected By</b></em>' containment reference.
	 * It is bidirectional and its opposite is '{@link CASA.Risk#getAffects <em>Affects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected By</em>' containment reference.
	 * @see #setAffectedBy(Risk)
	 * @see CASA.CASAPackage#getDataSubject_AffectedBy()
	 * @see CASA.Risk#getAffects
	 * @model opposite="affects" containment="true"
	 * @generated
	 */
	Risk getAffectedBy();

	/**
	 * Sets the value of the '{@link CASA.DataSubject#getAffectedBy <em>Affected By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affected By</em>' containment reference.
	 * @see #getAffectedBy()
	 * @generated
	 */
	void setAffectedBy(Risk value);

} // DataSubject
