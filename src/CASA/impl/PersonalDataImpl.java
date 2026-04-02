/**
 */
package CASA.impl;

import CASA.CASAPackage;
import CASA.Consent;
import CASA.DataSubject;
import CASA.FuncPersData;
import CASA.PersonalData;

import java.util.Collection;

import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.ENotificationImpl;

import org.eclipse.emf.ecore.util.EObjectWithInverseResolvingEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>Personal Data</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.PersonalDataImpl#getIdentifies <em>Identifies</em>}</li>
 *   <li>{@link CASA.impl.PersonalDataImpl#getProcessedBy <em>Processed By</em>}</li>
 *   <li>{@link CASA.impl.PersonalDataImpl#getSubjectOfConsent <em>Subject Of Consent</em>}</li>
 * </ul>
 *
 * @generated
 */
public class PersonalDataImpl extends DataImpl implements PersonalData {
	/**
	 * The cached value of the '{@link #getIdentifies() <em>Identifies</em>}' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getIdentifies()
	 * @generated
	 * @ordered
	 */
	protected DataSubject identifies;

	/**
	 * The cached value of the '{@link #getProcessedBy() <em>Processed By</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getProcessedBy()
	 * @generated
	 * @ordered
	 */
	protected EList<FuncPersData> processedBy;

	/**
	 * The cached value of the '{@link #getSubjectOfConsent() <em>Subject Of Consent</em>}' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getSubjectOfConsent()
	 * @generated
	 * @ordered
	 */
	protected EList<Consent> subjectOfConsent;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected PersonalDataImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.PERSONAL_DATA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSubject getIdentifies() {
		if (identifies != null && identifies.eIsProxy()) {
			InternalEObject oldIdentifies = (InternalEObject)identifies;
			identifies = (DataSubject)eResolveProxy(oldIdentifies);
			if (identifies != oldIdentifies) {
				if (eNotificationRequired())
					eNotify(new ENotificationImpl(this, Notification.RESOLVE, CASAPackage.PERSONAL_DATA__IDENTIFIES, oldIdentifies, identifies));
			}
		}
		return identifies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSubject basicGetIdentifies() {
		return identifies;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NotificationChain basicSetIdentifies(DataSubject newIdentifies, NotificationChain msgs) {
		DataSubject oldIdentifies = identifies;
		identifies = newIdentifies;
		if (eNotificationRequired()) {
			ENotificationImpl notification = new ENotificationImpl(this, Notification.SET, CASAPackage.PERSONAL_DATA__IDENTIFIES, oldIdentifies, newIdentifies);
			if (msgs == null) msgs = notification; else msgs.add(notification);
		}
		return msgs;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setIdentifies(DataSubject newIdentifies) {
		if (newIdentifies != identifies) {
			NotificationChain msgs = null;
			if (identifies != null)
				msgs = ((InternalEObject)identifies).eInverseRemove(this, CASAPackage.DATA_SUBJECT__IDENTIFIED_BY, DataSubject.class, msgs);
			if (newIdentifies != null)
				msgs = ((InternalEObject)newIdentifies).eInverseAdd(this, CASAPackage.DATA_SUBJECT__IDENTIFIED_BY, DataSubject.class, msgs);
			msgs = basicSetIdentifies(newIdentifies, msgs);
			if (msgs != null) msgs.dispatch();
		}
		else if (eNotificationRequired())
			eNotify(new ENotificationImpl(this, Notification.SET, CASAPackage.PERSONAL_DATA__IDENTIFIES, newIdentifies, newIdentifies));
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<FuncPersData> getProcessedBy() {
		if (processedBy == null) {
			processedBy = new EObjectWithInverseResolvingEList.ManyInverse<FuncPersData>(FuncPersData.class, this, CASAPackage.PERSONAL_DATA__PROCESSED_BY, CASAPackage.FUNC_PERS_DATA__PROCESSES_PERS_DATA);
		}
		return processedBy;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Consent> getSubjectOfConsent() {
		if (subjectOfConsent == null) {
			subjectOfConsent = new EObjectWithInverseResolvingEList.ManyInverse<Consent>(Consent.class, this, CASAPackage.PERSONAL_DATA__SUBJECT_OF_CONSENT, CASAPackage.CONSENT__FOR_PERSONAL_DATA);
		}
		return subjectOfConsent;
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
			case CASAPackage.PERSONAL_DATA__IDENTIFIES:
				if (identifies != null)
					msgs = ((InternalEObject)identifies).eInverseRemove(this, CASAPackage.DATA_SUBJECT__IDENTIFIED_BY, DataSubject.class, msgs);
				return basicSetIdentifies((DataSubject)otherEnd, msgs);
			case CASAPackage.PERSONAL_DATA__PROCESSED_BY:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getProcessedBy()).basicAdd(otherEnd, msgs);
			case CASAPackage.PERSONAL_DATA__SUBJECT_OF_CONSENT:
				return ((InternalEList<InternalEObject>)(InternalEList<?>)getSubjectOfConsent()).basicAdd(otherEnd, msgs);
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
			case CASAPackage.PERSONAL_DATA__IDENTIFIES:
				return basicSetIdentifies(null, msgs);
			case CASAPackage.PERSONAL_DATA__PROCESSED_BY:
				return ((InternalEList<?>)getProcessedBy()).basicRemove(otherEnd, msgs);
			case CASAPackage.PERSONAL_DATA__SUBJECT_OF_CONSENT:
				return ((InternalEList<?>)getSubjectOfConsent()).basicRemove(otherEnd, msgs);
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
			case CASAPackage.PERSONAL_DATA__IDENTIFIES:
				if (resolve) return getIdentifies();
				return basicGetIdentifies();
			case CASAPackage.PERSONAL_DATA__PROCESSED_BY:
				return getProcessedBy();
			case CASAPackage.PERSONAL_DATA__SUBJECT_OF_CONSENT:
				return getSubjectOfConsent();
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
			case CASAPackage.PERSONAL_DATA__IDENTIFIES:
				setIdentifies((DataSubject)newValue);
				return;
			case CASAPackage.PERSONAL_DATA__PROCESSED_BY:
				getProcessedBy().clear();
				getProcessedBy().addAll((Collection<? extends FuncPersData>)newValue);
				return;
			case CASAPackage.PERSONAL_DATA__SUBJECT_OF_CONSENT:
				getSubjectOfConsent().clear();
				getSubjectOfConsent().addAll((Collection<? extends Consent>)newValue);
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
			case CASAPackage.PERSONAL_DATA__IDENTIFIES:
				setIdentifies((DataSubject)null);
				return;
			case CASAPackage.PERSONAL_DATA__PROCESSED_BY:
				getProcessedBy().clear();
				return;
			case CASAPackage.PERSONAL_DATA__SUBJECT_OF_CONSENT:
				getSubjectOfConsent().clear();
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
			case CASAPackage.PERSONAL_DATA__IDENTIFIES:
				return identifies != null;
			case CASAPackage.PERSONAL_DATA__PROCESSED_BY:
				return processedBy != null && !processedBy.isEmpty();
			case CASAPackage.PERSONAL_DATA__SUBJECT_OF_CONSENT:
				return subjectOfConsent != null && !subjectOfConsent.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //PersonalDataImpl
