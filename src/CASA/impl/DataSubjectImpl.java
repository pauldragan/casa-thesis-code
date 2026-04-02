/**
 */
package CASA.impl;

import CASA.CASAPackage;
import CASA.Consent;
import CASA.DataSubject;
import CASA.PersonalData;
import CASA.Risk;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;
import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentWithInverseEList;
import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Data Subject</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.DataSubjectImpl#getIdentifiedBy <em>Identified By</em>}</li>
 *   <li>{@link CASA.impl.DataSubjectImpl#getName <em>Name</em>}</li>
 *   <li>{@link CASA.impl.DataSubjectImpl#getGives <em>Gives</em>}</li>
 *   <li>{@link CASA.impl.DataSubjectImpl#getAffectedBy <em>Affected By</em>}</li>
 * </ul>
 *
 * @generated
 */
public class DataSubjectImpl extends MinimalEObjectImpl.Container implements DataSubject {
	/**
	 * The cached value of the '{@link #getIdentifiedBy() <em>Identified By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifiedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<PersonalData> identifiedBy;

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
	 * The cached value of the '{@link #getGives() <em>Gives</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGives()
	 * @generated
	 * @ordered
	 */
	protected EList<Consent> gives;

	/**
	 * The cached value of the '{@link #getAffectedBy() <em>Affected By</em>}' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getAffectedBy()
	 * @generated
	 * @ordered
	 */
	protected Risk affectedBy;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DataSubjectImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.DATA_SUBJECT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PersonalData> getIdentifiedBy() {
		if (identifiedBy == null) {
			identifiedBy = new EObjectWithInverseResolvingEList<PersonalData>(PersonalData.class, this, CASAPackage.DATA_SUBJECT__IDENTIFIED_BY, CASAPackage.PERSONAL_DATA__IDENTIFIES);
		}
		return identifiedBy;
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
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.DATA_SUBJECT__NAME, oldName, name));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Consent> getGives() {
		if (gives == null) {
			gives = new EObjectContainmentWithInverseEList<Consent>(Consent.class, this, CASAPackage.DATA_SUBJECT__GIVES, CASAPackage.CONSENT__GIVEN_BY);
		}
		return gives;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Risk getAffectedBy() {
		return affectedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetAffectedBy(Risk newAffectedBy, NotificationChain msgs) {
		Risk oldAffectedBy = affectedBy;
		affectedBy = newAffectedBy;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CASAPackage.DATA_SUBJECT__AFFECTED_BY, oldAffectedBy, newAffectedBy);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setAffectedBy(Risk newAffectedBy) {
		if (newAffectedBy != affectedBy) {
			NotificationChain msgs = null;
			if (affectedBy != null)
				msgs = ((InternalEObject)affectedBy).eInverseRemove(this, CASAPackage.RISK__AFFECTS, Risk.class, msgs);
			if (newAffectedBy != null)
				msgs = ((InternalEObject)newAffectedBy).eInverseAdd(this, CASAPackage.RISK__AFFECTS, Risk.class, msgs);
			msgs = basicSetAffectedBy(newAffectedBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.DATA_SUBJECT__AFFECTED_BY, newAffectedBy, newAffectedBy));
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
			case CASAPackage.DATA_SUBJECT__IDENTIFIED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getIdentifiedBy()).basicAdd(otherEnd, msgs);
			case CASAPackage.DATA_SUBJECT__GIVES:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGives()).basicAdd(otherEnd, msgs);
			case CASAPackage.DATA_SUBJECT__AFFECTED_BY:
				if (affectedBy != null)
					msgs = ((InternalEObject)affectedBy).eInverseRemove(this, EOPPOSITE_FEATURE_BASE - CASAPackage.DATA_SUBJECT__AFFECTED_BY, null, msgs);
				return basicSetAffectedBy((Risk)otherEnd, msgs);
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
			case CASAPackage.DATA_SUBJECT__IDENTIFIED_BY:
				return ((InternalEList<?>)getIdentifiedBy()).basicRemove(otherEnd, msgs);
			case CASAPackage.DATA_SUBJECT__GIVES:
				return ((InternalEList<?>)getGives()).basicRemove(otherEnd, msgs);
			case CASAPackage.DATA_SUBJECT__AFFECTED_BY:
				return basicSetAffectedBy(null, msgs);
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
			case CASAPackage.DATA_SUBJECT__IDENTIFIED_BY:
				return getIdentifiedBy();
			case CASAPackage.DATA_SUBJECT__NAME:
				return getName();
			case CASAPackage.DATA_SUBJECT__GIVES:
				return getGives();
			case CASAPackage.DATA_SUBJECT__AFFECTED_BY:
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
			case CASAPackage.DATA_SUBJECT__IDENTIFIED_BY:
				getIdentifiedBy().clear();
				getIdentifiedBy().addAll((Collection<? extends PersonalData>)newValue);
				return;
			case CASAPackage.DATA_SUBJECT__NAME:
				setName((String)newValue);
				return;
			case CASAPackage.DATA_SUBJECT__GIVES:
				getGives().clear();
				getGives().addAll((Collection<? extends Consent>)newValue);
				return;
			case CASAPackage.DATA_SUBJECT__AFFECTED_BY:
				setAffectedBy((Risk)newValue);
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
			case CASAPackage.DATA_SUBJECT__IDENTIFIED_BY:
				getIdentifiedBy().clear();
				return;
			case CASAPackage.DATA_SUBJECT__NAME:
				setName(NAME_EDEFAULT);
				return;
			case CASAPackage.DATA_SUBJECT__GIVES:
				getGives().clear();
				return;
			case CASAPackage.DATA_SUBJECT__AFFECTED_BY:
				setAffectedBy((Risk)null);
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
			case CASAPackage.DATA_SUBJECT__IDENTIFIED_BY:
				return identifiedBy != null && !identifiedBy.isEmpty();
			case CASAPackage.DATA_SUBJECT__NAME:
				return NAME_EDEFAULT == null ? name != null : !NAME_EDEFAULT.equals(name);
			case CASAPackage.DATA_SUBJECT__GIVES:
				return gives != null && !gives.isEmpty();
			case CASAPackage.DATA_SUBJECT__AFFECTED_BY:
				return affectedBy != null;
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

} //DataSubjectImpl
