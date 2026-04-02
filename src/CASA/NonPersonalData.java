/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Non Personal Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.NonPersonalData#getProcessedBy <em>Processed By</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getNonPersonalData()
 * @model
 * @generated
 */
public interface NonPersonalData extends Data {
	/**
	 * Returns the value of the '<em><b>Processed By</b></em>' reference list.
	 * The list contents are of type {@link CASA.Function}.
	 * It is bidirectional and its opposite is '{@link CASA.Function#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processed By</em>' reference list.
	 * @see CASA.CASAPackage#getNonPersonalData_ProcessedBy()
	 * @see CASA.Function#getProcesses
	 * @model opposite="processes"
	 * @generated
	 */
	EList<Function> getProcessedBy();

} // NonPersonalData
