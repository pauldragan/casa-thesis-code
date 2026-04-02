/**
 */
package CASA;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EObject;

/**
 * <!-- begin-user-doc -->
 * A representation of the model object '<em><b>Risk</b></em>'.
 * <!-- end-user-doc -->
 *
 * <p>
 * The following features are supported:
 * </p>
 * <ul>
 *   <li>{@link CASA.Risk#getLevel <em>Level</em>}</li>
 *   <li>{@link CASA.Risk#getAffects <em>Affects</em>}</li>
 *   <li>{@link CASA.Risk#getCausedBy <em>Caused By</em>}</li>
 * </ul>
 *
 * @see CASA.CASAPackage#getRisk()
 * @model
 * @generated
 */
public interface Risk extends EObject {
	/**
	 * Returns the value of the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Level</em>' attribute.
	 * @see #setLevel(double)
	 * @see CASA.CASAPackage#getRisk_Level()
	 * @model
	 * @generated
	 */
	double getLevel();

	/**
	 * Sets the value of the '{@link CASA.Risk#getLevel <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Level</em>' attribute.
	 * @see #getLevel()
	 * @generated
	 */
	void setLevel(double value);

	/**
	 * Returns the value of the '<em><b>Affects</b></em>' container reference.
	 * It is bidirectional and its opposite is '{@link CASA.DataSubject#getAffectedBy <em>Affected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Affects</em>' container reference.
	 * @see #setAffects(DataSubject)
	 * @see CASA.CASAPackage#getRisk_Affects()
	 * @see CASA.DataSubject#getAffectedBy
	 * @model opposite="affectedBy" required="true" transient="false"
	 * @generated
	 */
	DataSubject getAffects();

	/**
	 * Sets the value of the '{@link CASA.Risk#getAffects <em>Affects</em>}' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the new value of the '<em>Affects</em>' container reference.
	 * @see #getAffects()
	 * @generated
	 */
	void setAffects(DataSubject value);

	/**
	 * Returns the value of the '<em><b>Caused By</b></em>' reference list.
	 * The list contents are of type {@link CASA.Vulnerability}.
	 * It is bidirectional and its opposite is '{@link CASA.Vulnerability#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the value of the '<em>Caused By</em>' reference list.
	 * @see CASA.CASAPackage#getRisk_CausedBy()
	 * @see CASA.Vulnerability#getCauses
	 * @model opposite="causes"
	 * @generated
	 */
	EList<Vulnerability> getCausedBy();

} // Risk
