/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Function</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.Function#getName <em>Name</em>}</li>
 *   <li>{@link CASA.Function#getRealizedBy <em>Realized By</em>}</li>
 *   <li>{@link CASA.Function#getProcesses <em>Processes</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getFunction()
 * @model
 * @generated
 */
public interface Function extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see CASA.CASAPackage#getFunction_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link CASA.Function#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Realized By</b></em>' reference list.
	 * The list contents are of type {@link CASA.Component}.
	 * It is bidirectional and its opposite is '{@link CASA.Component#getRealizes <em>Realizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Realized By</em>' reference list.
	 * @see CASA.CASAPackage#getFunction_RealizedBy()
	 * @see CASA.Component#getRealizes
	 * @model opposite="realizes"
	 * @generated
	 */
	EList<Component> getRealizedBy();

	/**
	 * Returns the value of the '<em><b>Processes</b></em>' reference list.
	 * The list contents are of type {@link CASA.NonPersonalData}.
	 * It is bidirectional and its opposite is '{@link CASA.NonPersonalData#getProcessedBy <em>Processed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes</em>' reference list.
	 * @see CASA.CASAPackage#getFunction_Processes()
	 * @see CASA.NonPersonalData#getProcessedBy
	 * @model opposite="processedBy"
	 * @generated
	 */
	EList<NonPersonalData> getProcesses();

} // Function
