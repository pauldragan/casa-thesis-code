/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.Component#getRealizes <em>Realizes</em>}</li>
 *   <li>{@link CASA.Component#getName <em>Name</em>}</li>
 *   <li>{@link CASA.Component#getAffectedBy <em>Affected By</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getComponent()
 * @model
 * @generated
 */
public interface Component extends EObject {
	/**
	 * Returns the value of the '<em><b>Realizes</b></em>' reference list.
	 * The list contents are of type {@link CASA.Function}.
	 * It is bidirectional and its opposite is '{@link CASA.Function#getRealizedBy <em>Realized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realizes</em>' reference list.
	 * @see CASA.CASAPackage#getComponent_Realizes()
	 * @see CASA.Function#getRealizedBy
	 * @model opposite="realizedBy"
	 * @generated
	 */
	EList<Function> getRealizes();

	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see CASA.CASAPackage#getComponent_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link CASA.Component#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Affected By</b></em>' reference list.
	 * The list contents are of type {@link CASA.Vulnerability}.
	 * It is bidirectional and its opposite is '{@link CASA.Vulnerability#getAffects <em>Affects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affected By</em>' reference list.
	 * @see CASA.CASAPackage#getComponent_AffectedBy()
	 * @see CASA.Vulnerability#getAffects
	 * @model opposite="affects"
	 * @generated
	 */
	EList<Vulnerability> getAffectedBy();

} // Component
