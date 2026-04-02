/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Func Pers Data</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.FuncPersData#getProcessesPersData <em>Processes Pers Data</em>}</li>
 *   <li>{@link CASA.FuncPersData#getHas <em>Has</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getFuncPersData()
 * @model
 * @generated
 */
public interface FuncPersData extends Function {
	/**
	 * Returns the value of the '<em><b>Processes Pers Data</b></em>' reference list.
	 * The list contents are of type {@link CASA.PersonalData}.
	 * It is bidirectional and its opposite is '{@link CASA.PersonalData#getProcessedBy <em>Processed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Processes Pers Data</em>' reference list.
	 * @see CASA.CASAPackage#getFuncPersData_ProcessesPersData()
	 * @see CASA.PersonalData#getProcessedBy
	 * @model opposite="processedBy" required="true"
	 * @generated
	 */
	EList<PersonalData> getProcessesPersData();

	/**
	 * Returns the value of the '<em><b>Has</b></em>' reference list.
	 * The list contents are of type {@link CASA.Purpose}.
	 * It is bidirectional and its opposite is '{@link CASA.Purpose#getOfFunction <em>Of Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Has</em>' reference list.
	 * @see CASA.CASAPackage#getFuncPersData_Has()
	 * @see CASA.Purpose#getOfFunction
	 * @model opposite="ofFunction" required="true"
	 * @generated
	 */
	EList<Purpose> getHas();

} // FuncPersData
