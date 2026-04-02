/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.System#getFunctions <em>Functions</em>}</li>
 *   <li>{@link CASA.System#getDatas <em>Datas</em>}</li>
 *   <li>{@link CASA.System#getDataSubjects <em>Data Subjects</em>}</li>
 *   <li>{@link CASA.System#getVulnerabilities <em>Vulnerabilities</em>}</li>
 *   <li>{@link CASA.System#getComponents <em>Components</em>}</li>
 *   <li>{@link CASA.System#getPurposes <em>Purposes</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getSystem()
 * @model
 * @generated
 */
public interface System extends EObject {
	/**
	 * Returns the value of the '<em><b>Functions</b></em>' containment reference list.
	 * The list contents are of type {@link CASA.Function}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Functions</em>' containment reference list.
	 * @see CASA.CASAPackage#getSystem_Functions()
	 * @model containment="true"
	 * @generated
	 */
	EList<Function> getFunctions();

	/**
	 * Returns the value of the '<em><b>Datas</b></em>' containment reference list.
	 * The list contents are of type {@link CASA.Data}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Datas</em>' containment reference list.
	 * @see CASA.CASAPackage#getSystem_Datas()
	 * @model containment="true"
	 * @generated
	 */
	EList<Data> getDatas();

	/**
	 * Returns the value of the '<em><b>Data Subjects</b></em>' containment reference list.
	 * The list contents are of type {@link CASA.DataSubject}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Data Subjects</em>' containment reference list.
	 * @see CASA.CASAPackage#getSystem_DataSubjects()
	 * @model containment="true"
	 * @generated
	 */
	EList<DataSubject> getDataSubjects();

	/**
	 * Returns the value of the '<em><b>Vulnerabilities</b></em>' containment reference list.
	 * The list contents are of type {@link CASA.Vulnerability}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Vulnerabilities</em>' containment reference list.
	 * @see CASA.CASAPackage#getSystem_Vulnerabilities()
	 * @model containment="true"
	 * @generated
	 */
	EList<Vulnerability> getVulnerabilities();

	/**
	 * Returns the value of the '<em><b>Components</b></em>' containment reference list.
	 * The list contents are of type {@link CASA.Component}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Components</em>' containment reference list.
	 * @see CASA.CASAPackage#getSystem_Components()
	 * @model containment="true"
	 * @generated
	 */
	EList<Component> getComponents();

	/**
	 * Returns the value of the '<em><b>Purposes</b></em>' containment reference list.
	 * The list contents are of type {@link CASA.Purpose}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Purposes</em>' containment reference list.
	 * @see CASA.CASAPackage#getSystem_Purposes()
	 * @model containment="true"
	 * @generated
	 */
	EList<Purpose> getPurposes();

} // System
