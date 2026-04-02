/**
 */
package CASA.CVSS.impl;

import CASA.CVSS.*;

import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EDataType;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.impl.EFactoryImpl;

import org.eclipse.emf.ecore.plugin.EcorePlugin;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Factory</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CVSSFactoryImpl extends EFactoryImpl implements CVSSFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CVSSFactory init() {
		try {
			CVSSFactory theCVSSFactory = (CVSSFactory)EPackage.Registry.INSTANCE.getEFactory(CVSSPackage.eNS_URI);
			if (theCVSSFactory != null) {
				return theCVSSFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CVSSFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSSFactoryImpl() {
		super();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public EObject create(EClass eClass) {
		switch (eClass.getClassifierID()) {
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object createFromString(EDataType eDataType, String initialValue) {
		switch (eDataType.getClassifierID()) {
			case CVSSPackage.ATTACK_VECTOR:
				return createAttackVectorFromString(eDataType, initialValue);
			case CVSSPackage.ATTACK_COMPLEXITY:
				return createAttackComplexityFromString(eDataType, initialValue);
			case CVSSPackage.SCOPE:
				return createScopeFromString(eDataType, initialValue);
			case CVSSPackage.PRIVILEGES_REQUIRED:
				return createPrivilegesRequiredFromString(eDataType, initialValue);
			case CVSSPackage.USER_INTERACTION:
				return createUserInteractionFromString(eDataType, initialValue);
			case CVSSPackage.EXPLOIT_CODE_MATURITY:
				return createExploitCodeMaturityFromString(eDataType, initialValue);
			case CVSSPackage.REPORT_CONFIDENCE:
				return createReportConfidenceFromString(eDataType, initialValue);
			case CVSSPackage.CONFIDENTIALITY_IMPACT:
				return createConfidentialityImpactFromString(eDataType, initialValue);
			case CVSSPackage.INTEGRITY_IMPACT:
				return createIntegrityImpactFromString(eDataType, initialValue);
			case CVSSPackage.AVAILABILITY_IMPACT:
				return createAvailabilityImpactFromString(eDataType, initialValue);
			case CVSSPackage.REMEDIATION_LEVEL:
				return createRemediationLevelFromString(eDataType, initialValue);
			case CVSSPackage.CONFIDENTIALITY_REQUIREMENT:
				return createConfidentialityRequirementFromString(eDataType, initialValue);
			case CVSSPackage.INTEGRITY_REQUIREMENT:
				return createIntegrityRequirementFromString(eDataType, initialValue);
			case CVSSPackage.AVAILABILITY_REQUIREMENT:
				return createAvailabilityRequirementFromString(eDataType, initialValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String convertToString(EDataType eDataType, Object instanceValue) {
		switch (eDataType.getClassifierID()) {
			case CVSSPackage.ATTACK_VECTOR:
				return convertAttackVectorToString(eDataType, instanceValue);
			case CVSSPackage.ATTACK_COMPLEXITY:
				return convertAttackComplexityToString(eDataType, instanceValue);
			case CVSSPackage.SCOPE:
				return convertScopeToString(eDataType, instanceValue);
			case CVSSPackage.PRIVILEGES_REQUIRED:
				return convertPrivilegesRequiredToString(eDataType, instanceValue);
			case CVSSPackage.USER_INTERACTION:
				return convertUserInteractionToString(eDataType, instanceValue);
			case CVSSPackage.EXPLOIT_CODE_MATURITY:
				return convertExploitCodeMaturityToString(eDataType, instanceValue);
			case CVSSPackage.REPORT_CONFIDENCE:
				return convertReportConfidenceToString(eDataType, instanceValue);
			case CVSSPackage.CONFIDENTIALITY_IMPACT:
				return convertConfidentialityImpactToString(eDataType, instanceValue);
			case CVSSPackage.INTEGRITY_IMPACT:
				return convertIntegrityImpactToString(eDataType, instanceValue);
			case CVSSPackage.AVAILABILITY_IMPACT:
				return convertAvailabilityImpactToString(eDataType, instanceValue);
			case CVSSPackage.REMEDIATION_LEVEL:
				return convertRemediationLevelToString(eDataType, instanceValue);
			case CVSSPackage.CONFIDENTIALITY_REQUIREMENT:
				return convertConfidentialityRequirementToString(eDataType, instanceValue);
			case CVSSPackage.INTEGRITY_REQUIREMENT:
				return convertIntegrityRequirementToString(eDataType, instanceValue);
			case CVSSPackage.AVAILABILITY_REQUIREMENT:
				return convertAvailabilityRequirementToString(eDataType, instanceValue);
			default:
				throw new IllegalArgumentException("The datatype '" + eDataType.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackVector createAttackVectorFromString(EDataType eDataType, String initialValue) {
		AttackVector result = AttackVector.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttackVectorToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AttackComplexity createAttackComplexityFromString(EDataType eDataType, String initialValue) {
		AttackComplexity result = AttackComplexity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAttackComplexityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Scope createScopeFromString(EDataType eDataType, String initialValue) {
		Scope result = Scope.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertScopeToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PrivilegesRequired createPrivilegesRequiredFromString(EDataType eDataType, String initialValue) {
		PrivilegesRequired result = PrivilegesRequired.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertPrivilegesRequiredToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UserInteraction createUserInteractionFromString(EDataType eDataType, String initialValue) {
		UserInteraction result = UserInteraction.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertUserInteractionToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExploitCodeMaturity createExploitCodeMaturityFromString(EDataType eDataType, String initialValue) {
		ExploitCodeMaturity result = ExploitCodeMaturity.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertExploitCodeMaturityToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ReportConfidence createReportConfidenceFromString(EDataType eDataType, String initialValue) {
		ReportConfidence result = ReportConfidence.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertReportConfidenceToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidentialityImpact createConfidentialityImpactFromString(EDataType eDataType, String initialValue) {
		ConfidentialityImpact result = ConfidentialityImpact.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConfidentialityImpactToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegrityImpact createIntegrityImpactFromString(EDataType eDataType, String initialValue) {
		IntegrityImpact result = IntegrityImpact.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegrityImpactToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityImpact createAvailabilityImpactFromString(EDataType eDataType, String initialValue) {
		AvailabilityImpact result = AvailabilityImpact.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAvailabilityImpactToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemediationLevel createRemediationLevelFromString(EDataType eDataType, String initialValue) {
		RemediationLevel result = RemediationLevel.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertRemediationLevelToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ConfidentialityRequirement createConfidentialityRequirementFromString(EDataType eDataType, String initialValue) {
		ConfidentialityRequirement result = ConfidentialityRequirement.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertConfidentialityRequirementToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public IntegrityRequirement createIntegrityRequirementFromString(EDataType eDataType, String initialValue) {
		IntegrityRequirement result = IntegrityRequirement.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertIntegrityRequirementToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AvailabilityRequirement createAvailabilityRequirementFromString(EDataType eDataType, String initialValue) {
		AvailabilityRequirement result = AvailabilityRequirement.get(initialValue);
		if (result == null) throw new IllegalArgumentException("The value '" + initialValue + "' is not a valid enumerator of '" + eDataType.getName() + "'");
		return result;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String convertAvailabilityRequirementToString(EDataType eDataType, Object instanceValue) {
		return instanceValue == null ? null : instanceValue.toString();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSSPackage getCVSSPackage() {
		return (CVSSPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CVSSPackage getPackage() {
		return CVSSPackage.eINSTANCE;
	}

} //CVSSFactoryImpl
