/**
 */
package CASA.impl;

import CASA.CASAPackage;
import CASA.Consent;
import CASA.DataSubject;
import CASA.PersonalData;
import CASA.PurposeConsent;

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
 * An implementation of the model object '<em><b>Consent</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.ConsentImpl#getForPurpose <em>For Purpose</em>}</li>
 *   <li>{@link CASA.impl.ConsentImpl#getInformedRiskLevel <em>Informed Risk Level</em>}</li>
 *   <li>{@link CASA.impl.ConsentImpl#getGivenFor <em>Given For</em>}</li>
 *   <li>{@link CASA.impl.ConsentImpl#getGivenBy <em>Given By</em>}</li>
 *   <li>{@link CASA.impl.ConsentImpl#getForPersonalData <em>For Personal Data</em>}</li>
 * </ul>
 *
 * @generated
 */
public class ConsentImpl extends MinimalEObjectImpl.Container implements Consent {
	/**
	 * The default value of the '{@link #getForPurpose() <em>For Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForPurpose()
	 * @generated
	 * @ordered
	 */
	protected static final String FOR_PURPOSE_EDEFAULT = null;

	/**
	 * The cached value of the '{@link #getForPurpose() <em>For Purpose</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForPurpose()
	 * @generated
	 * @ordered
	 */
	protected String forPurpose = FOR_PURPOSE_EDEFAULT;

	/**
	 * The default value of the '{@link #getInformedRiskLevel() <em>Informed Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInformedRiskLevel()
	 * @generated
	 * @ordered
	 */
	protected static final double INFORMED_RISK_LEVEL_EDEFAULT = 0.0;

	/**
	 * The cached value of the '{@link #getInformedRiskLevel() <em>Informed Risk Level</em>}' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getInformedRiskLevel()
	 * @generated
	 * @ordered
	 */
	protected double informedRiskLevel = INFORMED_RISK_LEVEL_EDEFAULT;

	/**
	 * The cached value of the '{@link #getGivenFor() <em>Given For</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getGivenFor()
	 * @generated
	 * @ordered
	 */
	protected EList<PurposeConsent> givenFor;

	/**
	 * The cached value of the '{@link #getForPersonalData() <em>For Personal Data</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getForPersonalData()
	 * @generated
	 * @ordered
	 */
	protected EList<PersonalData> forPersonalData;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ConsentImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.CONSENT;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getForPurpose() {
		return forPurpose;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setForPurpose(String newForPurpose) {
		String oldForPurpose = forPurpose;
		forPurpose = newForPurpose;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CONSENT__FOR_PURPOSE, oldForPurpose, forPurpose));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public double getInformedRiskLevel() {
		return informedRiskLevel;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setInformedRiskLevel(double newInformedRiskLevel) {
		double oldInformedRiskLevel = informedRiskLevel;
		informedRiskLevel = newInformedRiskLevel;
		if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CONSENT__INFORMED_RISK_LEVEL, oldInformedRiskLevel, informedRiskLevel));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PurposeConsent> getGivenFor() {
		if (givenFor == null) {
			givenFor = new EObjectWithInverseResolvingEList.ManyInverse<PurposeConsent>(PurposeConsent.class, this, CASAPackage.CONSENT__GIVEN_FOR, CASAPackage.PURPOSE_CONSENT__REQUIRES);
		}
		return givenFor;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSubject getGivenBy() {
		if (eContainerFeatureID() != CASAPackage.CONSENT__GIVEN_BY) return null;
		return (DataSubject)eInternalContainer();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetGivenBy(DataSubject newGivenBy, NotificationChain msgs) {
		msgs = eBasicSetContainer((InternalEObject)newGivenBy, CASAPackage.CONSENT__GIVEN_BY, msgs);
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setGivenBy(DataSubject newGivenBy) {
		if (newGivenBy != eInternalContainer() || (eContainerFeatureID() != CASAPackage.CONSENT__GIVEN_BY && newGivenBy != null)) {
			if (EcoreUtil.isAncestor(this, newGivenBy))
				throw new IllegalArgumentException("Recursive containment not allowed for " + toString());
			NotificationChain msgs = null;
			if (eInternalContainer() != null)
				msgs = eBasicRemoveFromContainer(msgs);
			if (newGivenBy != null)
				msgs = ((InternalEObject)newGivenBy).eInverseAdd(this, CASAPackage.DATA_SUBJECT__GIVES, DataSubject.class, msgs);
			msgs = basicSetGivenBy(newGivenBy, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.CONSENT__GIVEN_BY, newGivenBy, newGivenBy));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<PersonalData> getForPersonalData() {
		if (forPersonalData == null) {
			forPersonalData = new EObjectWithInverseResolvingEList.ManyInverse<PersonalData>(PersonalData.class, this, CASAPackage.CONSENT__FOR_PERSONAL_DATA, CASAPackage.PERSONAL_DATA__SUBJECT_OF_CONSENT);
		}
		return forPersonalData;
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
			case CASAPackage.CONSENT__GIVEN_FOR:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getGivenFor()).basicAdd(otherEnd, msgs);
			case CASAPackage.CONSENT__GIVEN_BY:
				if (eInternalContainer() != null)
					msgs = eBasicRemoveFromContainer(msgs);
				return basicSetGivenBy((DataSubject)otherEnd, msgs);
			case CASAPackage.CONSENT__FOR_PERSONAL_DATA:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getForPersonalData()).basicAdd(otherEnd, msgs);
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
			case CASAPackage.CONSENT__GIVEN_FOR:
				return ((InternalEList<?>)getGivenFor()).basicRemove(otherEnd, msgs);
			case CASAPackage.CONSENT__GIVEN_BY:
				return basicSetGivenBy(null, msgs);
			case CASAPackage.CONSENT__FOR_PERSONAL_DATA:
				return ((InternalEList<?>)getForPersonalData()).basicRemove(otherEnd, msgs);
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
			case CASAPackage.CONSENT__GIVEN_BY:
				return eInternalContainer().eInverseRemove(this, CASAPackage.DATA_SUBJECT__GIVES, DataSubject.class, msgs);
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
			case CASAPackage.CONSENT__FOR_PURPOSE:
				return getForPurpose();
			case CASAPackage.CONSENT__INFORMED_RISK_LEVEL:
				return getInformedRiskLevel();
			case CASAPackage.CONSENT__GIVEN_FOR:
				return getGivenFor();
			case CASAPackage.CONSENT__GIVEN_BY:
				return getGivenBy();
			case CASAPackage.CONSENT__FOR_PERSONAL_DATA:
				return getForPersonalData();
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
			case CASAPackage.CONSENT__FOR_PURPOSE:
				setForPurpose((String)newValue);
				return;
			case CASAPackage.CONSENT__INFORMED_RISK_LEVEL:
				setInformedRiskLevel((Double)newValue);
				return;
			case CASAPackage.CONSENT__GIVEN_FOR:
				getGivenFor().clear();
				getGivenFor().addAll((Collection<? extends PurposeConsent>)newValue);
				return;
			case CASAPackage.CONSENT__GIVEN_BY:
				setGivenBy((DataSubject)newValue);
				return;
			case CASAPackage.CONSENT__FOR_PERSONAL_DATA:
				getForPersonalData().clear();
				getForPersonalData().addAll((Collection<? extends PersonalData>)newValue);
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
			case CASAPackage.CONSENT__FOR_PURPOSE:
				setForPurpose(FOR_PURPOSE_EDEFAULT);
				return;
			case CASAPackage.CONSENT__INFORMED_RISK_LEVEL:
				setInformedRiskLevel(INFORMED_RISK_LEVEL_EDEFAULT);
				return;
			case CASAPackage.CONSENT__GIVEN_FOR:
				getGivenFor().clear();
				return;
			case CASAPackage.CONSENT__GIVEN_BY:
				setGivenBy((DataSubject)null);
				return;
			case CASAPackage.CONSENT__FOR_PERSONAL_DATA:
				getForPersonalData().clear();
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
			case CASAPackage.CONSENT__FOR_PURPOSE:
				return FOR_PURPOSE_EDEFAULT == null ? forPurpose != null : !FOR_PURPOSE_EDEFAULT.equals(forPurpose);
			case CASAPackage.CONSENT__INFORMED_RISK_LEVEL:
				return informedRiskLevel != INFORMED_RISK_LEVEL_EDEFAULT;
			case CASAPackage.CONSENT__GIVEN_FOR:
				return givenFor != null && !givenFor.isEmpty();
			case CASAPackage.CONSENT__GIVEN_BY:
				return getGivenBy() != null;
			case CASAPackage.CONSENT__FOR_PERSONAL_DATA:
				return forPersonalData != null && !forPersonalData.isEmpty();
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
		result.append(" (forPurpose: ");
		result.append(forPurpose);
		result.append(", informedRiskLevel: ");
		result.append(informedRiskLevel);
		result.append(')');
		return result.toString();
	}

} //ConsentImpl
