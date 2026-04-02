/**
 */
package CASA.impl;

import CASA.CASAPackage;
import CASA.FuncPersData;
import CASA.PersonalData;
import CASA.Purpose;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Func Pers Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.FuncPersDataImpl#getProcessesPersData <em>Processes Pers Data</em>}</li>
 *   <li>{@link CASA.impl.FuncPersDataImpl#getHas <em>Has</em>}</li>
 * </ul>
 *
 * @generated
 */
public class FuncPersDataImpl extends FunctionImpl implements FuncPersData {
	/**
	 * The cached value of the '{@link #getProcessesPersData() <em>Processes Pers Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessesPersData()
	 * @generated
	 * @ordered
	 */
	protected EList<PersonalData> processesPersData;

	/**
	 * The cached value of the '{@link #getHas() <em>Has</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getHas()
	 * @generated
	 * @ordered
	 */
	protected EList<Purpose> has;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected FuncPersDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.FUNC_PERS_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PersonalData> getProcessesPersData() {
		if (processesPersData == null) {
			processesPersData = new EObjectWithInverseResolvingEList.ManyInverse<PersonalData>(PersonalData.class, this, CASAPackage.FUNC_PERS_DATA__PROCESSES_PERS_DATA, CASAPackage.PERSONAL_DATA__PROCESSED_BY);
		}
		return processesPersData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Purpose> getHas() {
		if (has == null) {
			has = new EObjectWithInverseResolvingEList.ManyInverse<Purpose>(Purpose.class, this, CASAPackage.FUNC_PERS_DATA__HAS, CASAPackage.PURPOSE__OF_FUNCTION);
		}
		return has;
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
			case CASAPackage.FUNC_PERS_DATA__PROCESSES_PERS_DATA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProcessesPersData()).basicAdd(otherEnd, msgs);
			case CASAPackage.FUNC_PERS_DATA__HAS:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getHas()).basicAdd(otherEnd, msgs);
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
			case CASAPackage.FUNC_PERS_DATA__PROCESSES_PERS_DATA:
				return ((InternalEList<?>)getProcessesPersData()).basicRemove(otherEnd, msgs);
			case CASAPackage.FUNC_PERS_DATA__HAS:
				return ((InternalEList<?>)getHas()).basicRemove(otherEnd, msgs);
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
			case CASAPackage.FUNC_PERS_DATA__PROCESSES_PERS_DATA:
				return getProcessesPersData();
			case CASAPackage.FUNC_PERS_DATA__HAS:
				return getHas();
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
			case CASAPackage.FUNC_PERS_DATA__PROCESSES_PERS_DATA:
				getProcessesPersData().clear();
				getProcessesPersData().addAll((Collection<? extends PersonalData>)newValue);
				return;
			case CASAPackage.FUNC_PERS_DATA__HAS:
				getHas().clear();
				getHas().addAll((Collection<? extends Purpose>)newValue);
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
			case CASAPackage.FUNC_PERS_DATA__PROCESSES_PERS_DATA:
				getProcessesPersData().clear();
				return;
			case CASAPackage.FUNC_PERS_DATA__HAS:
				getHas().clear();
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
			case CASAPackage.FUNC_PERS_DATA__PROCESSES_PERS_DATA:
				return processesPersData != null && !processesPersData.isEmpty();
			case CASAPackage.FUNC_PERS_DATA__HAS:
				return has != null && !has.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //FuncPersDataImpl
