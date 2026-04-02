/**
 */
package CASA.impl;

import CASA.CASAPackage;
import CASA.Component;
import CASA.Function;
import CASA.Vulnerability;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Component</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.ComponentImpl#getRealizes <em>Realizes</em>}</li>
 *   <li>{@link CASA.impl.ComponentImpl#getName <em>Name</em>}</li>
 *   <li>{@link CASA.impl.ComponentImpl#getAffectedBy <em>Affected By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ComponentImpl extends MinimalEObjectImpl.Container implements Component {
	/**
	 * The cached value of the '{@link #getRealizes() <em>Realizes</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getRealizes()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> realizes;

	/**
	 * The default value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected static final String NAME_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getName() <em>Name</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getName()
	 * @generated
	 * @ordered
	 */
	protected String name = NAME_EDEFAULT;

	/**
	 * The cached value of the '{@link #getAffectedBy() <em>Affected By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Vulnerability> affectedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComponentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.COMPONENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getRealizes() {
		if (realizes == null) {
			realizes = new EObjectWithInverseResolvingEList.ManyInverse<Function>(Function.class, this, CASAPackage.COMPONENT__REALIZES, CASAPackage.FUNCTION__REALIZED_BY);
		}
		return realizes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
		return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setName(String newName) {
		String oldName = name;
		name = newName;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.COMPONENT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vulnerability> getAffectedBy() {
		if (affectedBy == null) {
			affectedBy = new EObjectWithInverseResolvingEList.ManyInverse<Vulnerability>(Vulnerability.class, this, CASAPackage.COMPONENT__AFFECTED_BY, CASAPackage.VULNERABILITY__AFFECTS);
		}
		return affectedBy;
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
			case CASAPackage.COMPONENT__REALIZES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getRealizes()).basicAdd(otherEnd, msgs);
			case CASAPackage.COMPONENT__AFFECTED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getAffectedBy()).basicAdd(otherEnd, msgs);
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
			case CASAPackage.COMPONENT__REALIZES:
				return ((InternalEList<?>)getRealizes()).basicRemove(otherEnd, msgs);
			case CASAPackage.COMPONENT__AFFECTED_BY:
				return ((InternalEList<?>)getAffectedBy()).basicRemove(otherEnd, msgs);
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
			case CASAPackage.COMPONENT__REALIZES:
				return getRealizes();
			case CASAPackage.COMPONENT__NAME:
				return getName();
			case CASAPackage.COMPONENT__AFFECTED_BY:
				return getAffectedBy();
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
			case CASAPackage.COMPONENT__REALIZES:
				getRealizes().clear();
				getRealizes().addAll((Collection<? extends Function>)newValue);
				return;
			case CASAPackage.COMPONENT__NAME:
				setName((String)newValue);
				return;
			case CASAPackage.COMPONENT__AFFECTED_BY:
				getAffectedBy().clear();
				getAffectedBy().addAll((Collection<? extends Vulnerability>)newValue);
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
			case CASAPackage.COMPONENT__REALIZES:
				getRealizes().clear();
				return;
			case CASAPackage.COMPONENT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CASAPackage.COMPONENT__AFFECTED_BY:
				getAffectedBy().clear();
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
			case CASAPackage.COMPONENT__REALIZES:
				return realizes != null && !realizes.isEmpty();
			case CASAPackage.COMPONENT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CASAPackage.COMPONENT__AFFECTED_BY:
				return affectedBy != null && !affectedBy.isEmpty();
		}
		return super.eIsSet(featureID);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		if (eIsProxy()) return super.toString();

		StringBuilder result = new StringBuilder(super.toString());
		result.append(" (name: ");
		result.append(name);
		result.append(')');
		return result.toString();
	}

} //ComponentImpl
