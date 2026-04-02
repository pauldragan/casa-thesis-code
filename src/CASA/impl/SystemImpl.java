/**
 */
package CASA.impl;

import CASA.CASAPackage;
import CASA.Component;
import CASA.Data;
import CASA.DataSubject;
import CASA.Function;
import CASA.Purpose;
import CASA.Vulnerability;

import java.util.Collection;

import org.eclipse.emf.common.notify.NotificationChain;

import org.eclipse.emf.common.util.EList;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.InternalEObject;

import org.eclipse.emf.ecore.impl.MinimalEObjectImpl;

import org.eclipse.emf.ecore.util.EObjectContainmentEList;
import org.eclipse.emf.ecore.util.InternalEList;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model object '<em><b>System</b></em>'.
 * <!-- end-user-doc -->
 * <p>
 * The following features are implemented:
 * </p>
 * <ul>
 *   <li>{@link CASA.impl.SystemImpl#getFunctions <em>Functions</em>}</li>
 *   <li>{@link CASA.impl.SystemImpl#getDatas <em>Datas</em>}</li>
 *   <li>{@link CASA.impl.SystemImpl#getDataSubjects <em>Data Subjects</em>}</li>
 *   <li>{@link CASA.impl.SystemImpl#getVulnerabilities <em>Vulnerabilities</em>}</li>
 *   <li>{@link CASA.impl.SystemImpl#getComponents <em>Components</em>}</li>
 *   <li>{@link CASA.impl.SystemImpl#getPurposes <em>Purposes</em>}</li>
 * </ul>
 *
 * @generated
 */
public class SystemImpl extends MinimalEObjectImpl.Container implements CASA.System {
	/**
	 * The cached value of the '{@link #getFunctions() <em>Functions</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getFunctions()
	 * @generated
	 * @ordered
	 */
	protected EList<Function> functions;

	/**
	 * The cached value of the '{@link #getDatas() <em>Datas</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDatas()
	 * @generated
	 * @ordered
	 */
	protected EList<Data> datas;

	/**
	 * The cached value of the '{@link #getDataSubjects() <em>Data Subjects</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getDataSubjects()
	 * @generated
	 * @ordered
	 */
	protected EList<DataSubject> dataSubjects;

	/**
	 * The cached value of the '{@link #getVulnerabilities() <em>Vulnerabilities</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getVulnerabilities()
	 * @generated
	 * @ordered
	 */
	protected EList<Vulnerability> vulnerabilities;

	/**
	 * The cached value of the '{@link #getComponents() <em>Components</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getComponents()
	 * @generated
	 * @ordered
	 */
	protected EList<Component> components;

	/**
	 * The cached value of the '{@link #getPurposes() <em>Purposes</em>}' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #getPurposes()
	 * @generated
	 * @ordered
	 */
	protected EList<Purpose> purposes;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected SystemImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	protected EClass eStaticClass() {
		return CASAPackage.Literals.SYSTEM;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Function> getFunctions() {
		if (functions == null) {
			functions = new EObjectContainmentEList<Function>(Function.class, this, CASAPackage.SYSTEM__FUNCTIONS);
		}
		return functions;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Data> getDatas() {
		if (datas == null) {
			datas = new EObjectContainmentEList<Data>(Data.class, this, CASAPackage.SYSTEM__DATAS);
		}
		return datas;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<DataSubject> getDataSubjects() {
		if (dataSubjects == null) {
			dataSubjects = new EObjectContainmentEList<DataSubject>(DataSubject.class, this, CASAPackage.SYSTEM__DATA_SUBJECTS);
		}
		return dataSubjects;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Vulnerability> getVulnerabilities() {
		if (vulnerabilities == null) {
			vulnerabilities = new EObjectContainmentEList<Vulnerability>(Vulnerability.class, this, CASAPackage.SYSTEM__VULNERABILITIES);
		}
		return vulnerabilities;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Component> getComponents() {
		if (components == null) {
			components = new EObjectContainmentEList<Component>(Component.class, this, CASAPackage.SYSTEM__COMPONENTS);
		}
		return components;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EList<Purpose> getPurposes() {
		if (purposes == null) {
			purposes = new EObjectContainmentEList<Purpose>(Purpose.class, this, CASAPackage.SYSTEM__PURPOSES);
		}
		return purposes;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public NotificationChain eInverseRemove(InternalEObject otherEnd, int featureID, NotificationChain msgs) {
		switch (featureID) {
			case CASAPackage.SYSTEM__FUNCTIONS:
				return ((InternalEList<?>)getFunctions()).basicRemove(otherEnd, msgs);
			case CASAPackage.SYSTEM__DATAS:
				return ((InternalEList<?>)getDatas()).basicRemove(otherEnd, msgs);
			case CASAPackage.SYSTEM__DATA_SUBJECTS:
				return ((InternalEList<?>)getDataSubjects()).basicRemove(otherEnd, msgs);
			case CASAPackage.SYSTEM__VULNERABILITIES:
				return ((InternalEList<?>)getVulnerabilities()).basicRemove(otherEnd, msgs);
			case CASAPackage.SYSTEM__COMPONENTS:
				return ((InternalEList<?>)getComponents()).basicRemove(otherEnd, msgs);
			case CASAPackage.SYSTEM__PURPOSES:
				return ((InternalEList<?>)getPurposes()).basicRemove(otherEnd, msgs);
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
			case CASAPackage.SYSTEM__FUNCTIONS:
				return getFunctions();
			case CASAPackage.SYSTEM__DATAS:
				return getDatas();
			case CASAPackage.SYSTEM__DATA_SUBJECTS:
				return getDataSubjects();
			case CASAPackage.SYSTEM__VULNERABILITIES:
				return getVulnerabilities();
			case CASAPackage.SYSTEM__COMPONENTS:
				return getComponents();
			case CASAPackage.SYSTEM__PURPOSES:
				return getPurposes();
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
			case CASAPackage.SYSTEM__FUNCTIONS:
				getFunctions().clear();
				getFunctions().addAll((Collection<? extends Function>)newValue);
				return;
			case CASAPackage.SYSTEM__DATAS:
				getDatas().clear();
				getDatas().addAll((Collection<? extends Data>)newValue);
				return;
			case CASAPackage.SYSTEM__DATA_SUBJECTS:
				getDataSubjects().clear();
				getDataSubjects().addAll((Collection<? extends DataSubject>)newValue);
				return;
			case CASAPackage.SYSTEM__VULNERABILITIES:
				getVulnerabilities().clear();
				getVulnerabilities().addAll((Collection<? extends Vulnerability>)newValue);
				return;
			case CASAPackage.SYSTEM__COMPONENTS:
				getComponents().clear();
				getComponents().addAll((Collection<? extends Component>)newValue);
				return;
			case CASAPackage.SYSTEM__PURPOSES:
				getPurposes().clear();
				getPurposes().addAll((Collection<? extends Purpose>)newValue);
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
			case CASAPackage.SYSTEM__FUNCTIONS:
				getFunctions().clear();
				return;
			case CASAPackage.SYSTEM__DATAS:
				getDatas().clear();
				return;
			case CASAPackage.SYSTEM__DATA_SUBJECTS:
				getDataSubjects().clear();
				return;
			case CASAPackage.SYSTEM__VULNERABILITIES:
				getVulnerabilities().clear();
				return;
			case CASAPackage.SYSTEM__COMPONENTS:
				getComponents().clear();
				return;
			case CASAPackage.SYSTEM__PURPOSES:
				getPurposes().clear();
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
			case CASAPackage.SYSTEM__FUNCTIONS:
				return functions != null && !functions.isEmpty();
			case CASAPackage.SYSTEM__DATAS:
				return datas != null && !datas.isEmpty();
			case CASAPackage.SYSTEM__DATA_SUBJECTS:
				return dataSubjects != null && !dataSubjects.isEmpty();
			case CASAPackage.SYSTEM__VULNERABILITIES:
				return vulnerabilities != null && !vulnerabilities.isEmpty();
			case CASAPackage.SYSTEM__COMPONENTS:
				return components != null && !components.isEmpty();
			case CASAPackage.SYSTEM__PURPOSES:
				return purposes != null && !purposes.isEmpty();
		}
		return super.eIsSet(featureID);
	}

} //SystemImpl
