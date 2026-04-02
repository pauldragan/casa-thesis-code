/**
 */
package CASA;

import java.util.Map;
import org.eclipse.emf.common.util.DiagnosticChain;
import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Purpose</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.Purpose#getName <em>Name</em>}</li>
 *   <li>{@link CASA.Purpose#getOfFunction <em>Of Function</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getPurpose()
 * @model abstract="true"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore constraints='UniquePurposes'"
 * @generated
 */
public interface Purpose extends EObject {
	/**
	 * Returns the value of the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Name</em>' attribute.
	 * @see #setName(String)
	 * @see CASA.CASAPackage#getPurpose_Name()
	 * @model
	 * @generated
	 */
	String getName();

	/**
	 * Sets the value of the '{@link CASA.Purpose#getName <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Name</em>' attribute.
	 * @see #getName()
	 * @generated
	 */
	void setName(String value);

	/**
	 * Returns the value of the '<em><b>Of Function</b></em>' reference list.
	 * The list contents are of type {@link CASA.FuncPersData}.
	 * It is bidirectional and its opposite is '{@link CASA.FuncPersData#getHas <em>Has</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Of Function</em>' reference list.
	 * @see CASA.CASAPackage#getPurpose_OfFunction()
	 * @see CASA.FuncPersData#getHas
	 * @model opposite="has"
	 * @generated
	 */
	EList<FuncPersData> getOfFunction();

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @model annotation="http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot body='\n\t\t\tPurpose.allInstances() -&gt; isUnique(p | p.name)'"
	 * @generated
	 */
	boolean UniquePurposes(DiagnosticChain diagnostics, Map<Object, Object> context);

} // Purpose
