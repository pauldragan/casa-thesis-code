/**
 */
package CASA.impl;

import CASA.CASAPackage;
import CASA.Function;
import CASA.NonPersonalData;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Non Personal Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.NonPersonalDataImpl#getProcessedBy <em>Processed By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class NonPersonalDataImpl extends DataImpl implements NonPersonalData {
	/**
	 * The cached value of the '{@link #getProcessedBy() <em>Processed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> processedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected NonPersonalDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.NON_PERSONAL_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getProcessedBy() {
		if (processedBy == null) {
			processedBy = new EObjectWithInverseResolvingEList.ManyInverse<Function>(Function.class, this, CASAPackage.NON_PERSONAL_DATA__PROCESSED_BY, CASAPackage.FUNCTION__PROCESSES);
		}
		return processedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public NotificationChain eInverseAdd(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CASAPackage.NON_PERSONAL_DATA__PROCESSED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProcessedBy()).basicAdd(otherEnd, msgs);
		}
		return super.eInverseAdd(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CASAPackage.NON_PERSONAL_DATA__PROCESSED_BY:
				return ((InternalEList<?>)getProcessedBy()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CASAPackage.NON_PERSONAL_DATA__PROCESSED_BY:
				return getProcessedBy();
		}
		return super.eGet(featureID, resolve, coreType);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@SuppressWarnings("unchecked")
	@Override
	public void eSet(int featureID, Object newValue) {
		switch (featureID) {
			case CASAPackage.NON_PERSONAL_DATA__PROCESSED_BY:
				getProcessedBy().clear();
				getProcessedBy().addAll((Collection<? extends Function>)newValue);
				return;
		}
		super.eSet(featureID, newValue);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public void eUnset(int featureID) {
		switch (featureID) {
			case CASAPackage.NON_PERSONAL_DATA__PROCESSED_BY:
				getProcessedBy().clear();
				return;
		}
		super.eUnset(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean eIsSet(int featureID) {
		switch (featureID) {
			case CASAPackage.NON_PERSONAL_DATA__PROCESSED_BY:
				return processedBy != null && !processedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //NonPersonalDataImpl
