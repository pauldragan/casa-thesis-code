/**
 */
package CASA.impl;

import CASA.CASAPackage;
import CASA.DataSubject;
import CASA.Risk;
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
import org.eclipse.emf.ecore.util.EcoreUtil;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Risk</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.RiskImpl#getLevel <em>Level</em>}</li>
 *   <li>{@link CASA.impl.RiskImpl#getAffects <em>Affects</em>}</li>
 *   <li>{@link CASA.impl.RiskImpl#getCausedBy <em>Caused By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class RiskImpl extends MinimalEObjectImpl.Container implements Risk {
	/**
	 * The default value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected static final double LEVEL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getLevel() <em>Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getLevel()
	 * @generated
	 * @ordered
	 */
	protected double level = LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getCausedBy() <em>Caused By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getCausedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<Vulnerability> causedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected RiskImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.RISK;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getLevel() {
		return level;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setLevel(double newLevel) {
		double oldLevel = level;
		level = newLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.RISK__LEVEL, oldLevel, level));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSubject getAffects() {
		if (eContainerFeatureID() != CASAPackage.RISK__AFFECTS) return null;
		return (DataSubject)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAffects(DataSubject newAffects, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newAffects, CASAPackage.RISK__AFFECTS, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffects(DataSubject newAffects) {
		if (newAffects != eInternalContainer() || (eContainerFeatureID() != CASAPackage.RISK__AFFECTS && newAffects != null)) {
			if (EcoreUtil.isAncestor(this, newAffects))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newAffects != null)
				msgs = ((InternalEObject)newAffects).eInverseAdd(this, CASAPackage.DATA_SUBJECT__AFFECTED_BY, DataSubject.class, msgs);
			msgs = basicSetAffects(newAffects, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.RISK__AFFECTS, newAffects, newAffects));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vulnerability> getCausedBy() {
		if (causedBy == null) {
			causedBy = new EObjectWithInverseResolvingEList.ManyInverse<Vulnerability>(Vulnerability.class, this, CASAPackage.RISK__CAUSED_BY, CASAPackage.VULNERABILITY__CAUSES);
		}
		return causedBy;
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
			case CASAPackage.RISK__AFFECTS:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetAffects((DataSubject)otherEnd, msgs);
			case CASAPackage.RISK__CAUSED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getCausedBy()).basicAdd(otherEnd, msgs);
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
			case CASAPackage.RISK__AFFECTS:
				return basicSetAffects(null, msgs);
			case CASAPackage.RISK__CAUSED_BY:
				return ((InternalEList<?>)getCausedBy()).basicRemove(otherEnd, msgs);
		}
		return super.eInverseRemove(otherEnd, featureID, msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eBasicRemoveFromContainerFeature(NotificationChain msgs) {
		switch (eContainerFeatureID()) {
			case CASAPackage.RISK__AFFECTS:
				return eInternalContainer().eInverseRemove(this, CASAPackage.DATA_SUBJECT__AFFECTED_BY, DataSubject.class, msgs);
		}
		return super.eBasicRemoveFromContainerFeature(msgs);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object eGet(int featureID, boolean resolve, boolean coreType) {
		switch (featureID) {
			case CASAPackage.RISK__LEVEL:
				return getLevel();
			case CASAPackage.RISK__AFFECTS:
				return getAffects();
			case CASAPackage.RISK__CAUSED_BY:
				return getCausedBy();
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
			case CASAPackage.RISK__LEVEL:
				setLevel((Double)newValue);
				return;
			case CASAPackage.RISK__AFFECTS:
				setAffects((DataSubject)newValue);
				return;
			case CASAPackage.RISK__CAUSED_BY:
				getCausedBy().clear();
				getCausedBy().addAll((Collection<? extends Vulnerability>)newValue);
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
			case CASAPackage.RISK__LEVEL:
				setLevel(LEVEL_EDEFAULT);
				return;
			case CASAPackage.RISK__AFFECTS:
				setAffects((DataSubject)null);
				return;
			case CASAPackage.RISK__CAUSED_BY:
				getCausedBy().clear();
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
			case CASAPackage.RISK__LEVEL:
				return level != LEVEL_EDEFAULT;
			case CASAPackage.RISK__AFFECTS:
				return getAffects() != null;
			case CASAPackage.RISK__CAUSED_BY:
				return causedBy != null && !causedBy.isEmpty();
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
		result.append(" (level: ");
		result.append(level);
		result.append(')');
		return result.toString();
	}

} //RiskImpl
