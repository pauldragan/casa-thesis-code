/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Purpose Consent</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.PurposeConsent#getRequires <em>Requires</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getPurposeConsent()
 * @model
 * @generated
 */
public interface PurposeConsent extends Purpose {
	/**
	 * Returns the value of the '<em><b>Requires</b></em>' reference list.
	 * The list contents are of type {@link CASA.Consent}.
	 * It is bidirectional and its opposite is '{@link CASA.Consent#getGivenFor <em>Given For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Requires</em>' reference list.
	 * @see CASA.CASAPackage#getPurposeConsent_Requires()
	 * @see CASA.Consent#getGivenFor
	 * @model opposite="givenFor"
	 * @generated
	 */
	EList<Consent> getRequires();

} // PurposeConsent
