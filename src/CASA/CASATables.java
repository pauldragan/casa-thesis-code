/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 *   /PhDThesisCode/src/thesis/CASA.ecore
 * using:
 *   /PhDThesisCode/src/thesis/CASA.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package CASA;

// import CASA.CASAPackage;
// import CASA.CASATables;
import CASA.CVSS.CVSSPackage;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.ocl.pivot.ids.ClassId;
import org.eclipse.ocl.pivot.ids.CollectionTypeId;
import org.eclipse.ocl.pivot.ids.DataTypeId;
import org.eclipse.ocl.pivot.ids.EnumerationId;
import org.eclipse.ocl.pivot.ids.IdManager;
import org.eclipse.ocl.pivot.ids.NsURIPackageId;
import org.eclipse.ocl.pivot.ids.RootPackageId;
import org.eclipse.ocl.pivot.ids.TypeId;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreLibraryOppositeProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorPropertyWithImplementation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorType;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;
import org.eclipse.ocl.pivot.utilities.ValueUtil;
import org.eclipse.ocl.pivot.values.IntegerValue;

/**
 * CASATables provides the dispatch tables for the CASA for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class CASATables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(CASAPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */
	public static final /*@NonInvalid*/ RootPackageId PACKid_$metamodel$ = IdManager.getRootPackageId("$metamodel$");
	public static final /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_casa_com = IdManager.getNsURIPackageId("http://www.casa.com", null, CASAPackage.eINSTANCE);
	public static final /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_casa_com_s_cvss = IdManager.getNsURIPackageId("http://www.casa.com/cvss", null, CVSSPackage.eINSTANCE);
	public static final /*@NonInvalid*/ NsURIPackageId PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore = IdManager.getNsURIPackageId("http://www.eclipse.org/emf/2002/Ecore", null, EcorePackage.eINSTANCE);
	public static final /*@NonInvalid*/ ClassId CLSSid_CVSSVector = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("CVSSVector", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Class = CASATables.PACKid_$metamodel$.getClassId("Class", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Component = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("Component", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Consent = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("Consent", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Data = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("Data", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_DataSubject = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("DataSubject", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_FuncPersData = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("FuncPersData", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Function = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("Function", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_NonPersonalData = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("NonPersonalData", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_PersonalData = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("PersonalData", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Purpose = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("Purpose", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_PurposeConsent = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("PurposeConsent", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Risk = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("Risk", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_System = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("System", 0);
	public static final /*@NonInvalid*/ ClassId CLSSid_Vulnerability = CASATables.PACKid_http_c_s_s_www_casa_com.getClassId("Vulnerability", 0);
	public static final /*@NonInvalid*/ DataTypeId DATAid_EDouble = CASATables.PACKid_http_c_s_s_www_eclipse_org_s_emf_s_2002_s_Ecore.getDataTypeId("EDouble", 0);
	public static final /*@NonInvalid*/ EnumerationId ENUMid_AttackComplexity = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("AttackComplexity");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_AttackVector = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("AttackVector");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_AvailabilityImpact = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("AvailabilityImpact");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_AvailabilityRequirement = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("AvailabilityRequirement");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_ConfidentialityImpact = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("ConfidentialityImpact");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_ConfidentialityRequirement = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("ConfidentialityRequirement");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_ExploitCodeMaturity = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("ExploitCodeMaturity");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_IntegrityImpact = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("IntegrityImpact");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_IntegrityRequirement = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("IntegrityRequirement");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_PrivilegesRequired = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("PrivilegesRequired");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_RemediationLevel = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("RemediationLevel");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_ReportConfidence = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("ReportConfidence");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_Scope = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("Scope");
	public static final /*@NonInvalid*/ EnumerationId ENUMid_UserInteraction = CASATables.PACKid_http_c_s_s_www_casa_com_s_cvss.getEnumerationId("UserInteraction");
	public static final /*@NonInvalid*/ IntegerValue INT_0 = ValueUtil.integerValueOf("0");
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Component = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_Component, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Consent = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_Consent, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Data = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_Data, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_DataSubject = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_DataSubject, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_FuncPersData = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_FuncPersData, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Function = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_Function, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_NonPersonalData = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_NonPersonalData, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PersonalData = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_PersonalData, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PersonalData_0 = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_PersonalData, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Purpose = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_Purpose, true, ValueUtil.ONE_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_PurposeConsent = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_PurposeConsent, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Purpose_0 = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_Purpose, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Risk = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_Risk, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId ORD_CLSSid_Vulnerability = TypeId.ORDERED_SET.getSpecializedId(CASATables.CLSSid_Vulnerability, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Purpose = TypeId.SET.getSpecializedId(CASATables.CLSSid_Purpose, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);
	public static final /*@NonInvalid*/ CollectionTypeId SET_CLSSid_Vulnerability = TypeId.SET.getSpecializedId(CASATables.CLSSid_Vulnerability, true, ValueUtil.ZERO_VALUE, ValueUtil.UNLIMITED_VALUE);

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			CASATables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::TypeParameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The type descriptors for each type.
	 */
	public static class Types {
		static {
			Init.initStart();
			TypeParameters.init();
		}

		public static final EcoreExecutorType _Administrator = new EcoreExecutorType(CASAPackage.Literals.ADMINISTRATOR, PACKAGE, 0);
		public static final EcoreExecutorType _AngularSPA = new EcoreExecutorType(CASAPackage.Literals.ANGULAR_SPA, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2018_16843 = new EcoreExecutorType(CASAPackage.Literals.CVE_2018_16843, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2018_16844 = new EcoreExecutorType(CASAPackage.Literals.CVE_2018_16844, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2018_16845 = new EcoreExecutorType(CASAPackage.Literals.CVE_2018_16845, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2019_9511 = new EcoreExecutorType(CASAPackage.Literals.CVE_2019_9511, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2019_9513 = new EcoreExecutorType(CASAPackage.Literals.CVE_2019_9513, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2019_9516 = new EcoreExecutorType(CASAPackage.Literals.CVE_2019_9516, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2021_23017 = new EcoreExecutorType(CASAPackage.Literals.CVE_2021_23017, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2021_3618 = new EcoreExecutorType(CASAPackage.Literals.CVE_2021_3618, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2022_24834 = new EcoreExecutorType(CASAPackage.Literals.CVE_2022_24834, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2022_36021 = new EcoreExecutorType(CASAPackage.Literals.CVE_2022_36021, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2022_41862 = new EcoreExecutorType(CASAPackage.Literals.CVE_2022_41862, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2023_2455 = new EcoreExecutorType(CASAPackage.Literals.CVE_2023_2455, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2023_25155 = new EcoreExecutorType(CASAPackage.Literals.CVE_2023_25155, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2023_28856 = new EcoreExecutorType(CASAPackage.Literals.CVE_2023_28856, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2023_44487 = new EcoreExecutorType(CASAPackage.Literals.CVE_2023_44487, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2023_45145 = new EcoreExecutorType(CASAPackage.Literals.CVE_2023_45145, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2023_46809 = new EcoreExecutorType(CASAPackage.Literals.CVE_2023_46809, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2023_5870 = new EcoreExecutorType(CASAPackage.Literals.CVE_2023_5870, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_0985 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_0985, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_10976 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_10976, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_10977 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_10977, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_10978 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_10978, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_10979 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_10979, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_21890 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_21890, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_21891 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_21891, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_21896 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_21896, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_22017 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_22017, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_22018 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_22018, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_22019 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_22019, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_22020 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_22020, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_22025 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_22025, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_27980 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_27980, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_27983 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_27983, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_31449 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_31449, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_31489 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_31489, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_3566 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_3566, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_36137 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_36137, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_36138 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_36138, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_37372 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_37372, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_46981 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_46981, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_5205 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_5205, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_7347 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_7347, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2024_7348 = new EcoreExecutorType(CASAPackage.Literals.CVE_2024_7348, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_1094 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_1094, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_11187 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_11187, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_15468 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_15468, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_21605 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_21605, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_23084 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_23084, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_23090 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_23090, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_32023 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_32023, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_62506 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_62506, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_62507 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_62507, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_66199 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_66199, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_69418 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_69418, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_69420 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_69420, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2025_69421 = new EcoreExecutorType(CASAPackage.Literals.CVE_2025_69421, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2026_22795 = new EcoreExecutorType(CASAPackage.Literals.CVE_2026_22795, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2026_22796 = new EcoreExecutorType(CASAPackage.Literals.CVE_2026_22796, PACKAGE, 0);
		public static final EcoreExecutorType _CVE_2026_27970 = new EcoreExecutorType(CASAPackage.Literals.CVE_2026_27970, PACKAGE, 0);
		public static final EcoreExecutorType _CVSSVector = new EcoreExecutorType(CASAPackage.Literals.CVSS_VECTOR, PACKAGE, 0);
		public static final EcoreExecutorType _CommentWriteRead = new EcoreExecutorType(CASAPackage.Literals.COMMENT_WRITE_READ, PACKAGE, 0);
		public static final EcoreExecutorType _Component = new EcoreExecutorType(CASAPackage.Literals.COMPONENT, PACKAGE, 0);
		public static final EcoreExecutorType _Consent = new EcoreExecutorType(CASAPackage.Literals.CONSENT, PACKAGE, 0);
		public static final EcoreExecutorType _Data = new EcoreExecutorType(CASAPackage.Literals.DATA, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final EcoreExecutorType _DataSubject = new EcoreExecutorType(CASAPackage.Literals.DATA_SUBJECT, PACKAGE, 0);
		public static final EcoreExecutorType _DeviceLocation = new EcoreExecutorType(CASAPackage.Literals.DEVICE_LOCATION, PACKAGE, 0);
		public static final EcoreExecutorType _DeviceType = new EcoreExecutorType(CASAPackage.Literals.DEVICE_TYPE, PACKAGE, 0);
		public static final EcoreExecutorType _EmailAddress = new EcoreExecutorType(CASAPackage.Literals.EMAIL_ADDRESS, PACKAGE, 0);
		public static final EcoreExecutorType _ExpressJS = new EcoreExecutorType(CASAPackage.Literals.EXPRESS_JS, PACKAGE, 0);
		public static final EcoreExecutorType _FilesystemComponent = new EcoreExecutorType(CASAPackage.Literals.FILESYSTEM_COMPONENT, PACKAGE, 0);
		public static final EcoreExecutorType _FuncPersData = new EcoreExecutorType(CASAPackage.Literals.FUNC_PERS_DATA, PACKAGE, 0);
		public static final EcoreExecutorType _Function = new EcoreExecutorType(CASAPackage.Literals.FUNCTION, PACKAGE, 0);
		public static final EcoreExecutorType _LiveStreamVideo = new EcoreExecutorType(CASAPackage.Literals.LIVE_STREAM_VIDEO, PACKAGE, 0);
		public static final EcoreExecutorType _Moderator = new EcoreExecutorType(CASAPackage.Literals.MODERATOR, PACKAGE, 0);
		public static final EcoreExecutorType _Nginx = new EcoreExecutorType(CASAPackage.Literals.NGINX, PACKAGE, 0);
		public static final EcoreExecutorType _NonPersonalData = new EcoreExecutorType(CASAPackage.Literals.NON_PERSONAL_DATA, PACKAGE, 0);
		public static final EcoreExecutorType _P2PStreaming = new EcoreExecutorType(CASAPackage.Literals.P2P_STREAMING, PACKAGE, 0);
		public static final EcoreExecutorType _PBehaviorTargetedAds = new EcoreExecutorType(CASAPackage.Literals.PBEHAVIOR_TARGETED_ADS, PACKAGE, 0);
		public static final EcoreExecutorType _PComments = new EcoreExecutorType(CASAPackage.Literals.PCOMMENTS, PACKAGE, 0);
		public static final EcoreExecutorType _PFirstPartyProfiling = new EcoreExecutorType(CASAPackage.Literals.PFIRST_PARTY_PROFILING, PACKAGE, 0);
		public static final EcoreExecutorType _PLocationTargetedAds = new EcoreExecutorType(CASAPackage.Literals.PLOCATION_TARGETED_ADS, PACKAGE, 0);
		public static final EcoreExecutorType _PMarketing = new EcoreExecutorType(CASAPackage.Literals.PMARKETING, PACKAGE, 0);
		public static final EcoreExecutorType _PP2PStreaming = new EcoreExecutorType(CASAPackage.Literals.PP2P_STREAMING, PACKAGE, 0);
		public static final EcoreExecutorType _PProfiling = new EcoreExecutorType(CASAPackage.Literals.PPROFILING, PACKAGE, 0);
		public static final EcoreExecutorType _PSocial = new EcoreExecutorType(CASAPackage.Literals.PSOCIAL, PACKAGE, 0);
		public static final EcoreExecutorType _PStandardAds = new EcoreExecutorType(CASAPackage.Literals.PSTANDARD_ADS, PACKAGE, 0);
		public static final EcoreExecutorType _PTargetedAds = new EcoreExecutorType(CASAPackage.Literals.PTARGETED_ADS, PACKAGE, 0);
		public static final EcoreExecutorType _PThirdPartyProfiling = new EcoreExecutorType(CASAPackage.Literals.PTHIRD_PARTY_PROFILING, PACKAGE, 0);
		public static final EcoreExecutorType _PUserExperience = new EcoreExecutorType(CASAPackage.Literals.PUSER_EXPERIENCE, PACKAGE, 0);
		public static final EcoreExecutorType _PVideoRecommendation = new EcoreExecutorType(CASAPackage.Literals.PVIDEO_RECOMMENDATION, PACKAGE, 0);
		public static final EcoreExecutorType _PVideoSharing = new EcoreExecutorType(CASAPackage.Literals.PVIDEO_SHARING, PACKAGE, 0);
		public static final EcoreExecutorType _Password = new EcoreExecutorType(CASAPackage.Literals.PASSWORD, PACKAGE, 0);
		public static final EcoreExecutorType _Payment = new EcoreExecutorType(CASAPackage.Literals.PAYMENT, PACKAGE, 0);
		public static final EcoreExecutorType _PersonalData = new EcoreExecutorType(CASAPackage.Literals.PERSONAL_DATA, PACKAGE, 0);
		public static final EcoreExecutorType _Postgresql = new EcoreExecutorType(CASAPackage.Literals.POSTGRESQL, PACKAGE, 0);
		public static final EcoreExecutorType _Purpose = new EcoreExecutorType(CASAPackage.Literals.PURPOSE, PACKAGE, 0 | ExecutorType.ABSTRACT);
		public static final EcoreExecutorType _PurposeConsent = new EcoreExecutorType(CASAPackage.Literals.PURPOSE_CONSENT, PACKAGE, 0);
		public static final EcoreExecutorType _PurposeNoConsent = new EcoreExecutorType(CASAPackage.Literals.PURPOSE_NO_CONSENT, PACKAGE, 0);
		public static final EcoreExecutorType _RecommendVideos = new EcoreExecutorType(CASAPackage.Literals.RECOMMEND_VIDEOS, PACKAGE, 0);
		public static final EcoreExecutorType _RedisComponent = new EcoreExecutorType(CASAPackage.Literals.REDIS_COMPONENT, PACKAGE, 0);
		public static final EcoreExecutorType _RemoveVideo = new EcoreExecutorType(CASAPackage.Literals.REMOVE_VIDEO, PACKAGE, 0);
		public static final EcoreExecutorType _RequestTimestamps = new EcoreExecutorType(CASAPackage.Literals.REQUEST_TIMESTAMPS, PACKAGE, 0);
		public static final EcoreExecutorType _Risk = new EcoreExecutorType(CASAPackage.Literals.RISK, PACKAGE, 0);
		public static final EcoreExecutorType _ServeBehaviorTargetedAds = new EcoreExecutorType(CASAPackage.Literals.SERVE_BEHAVIOR_TARGETED_ADS, PACKAGE, 0);
		public static final EcoreExecutorType _ServeLocationTargetedAds = new EcoreExecutorType(CASAPackage.Literals.SERVE_LOCATION_TARGETED_ADS, PACKAGE, 0);
		public static final EcoreExecutorType _ServeStandardAds = new EcoreExecutorType(CASAPackage.Literals.SERVE_STANDARD_ADS, PACKAGE, 0);
		public static final EcoreExecutorType _StreamVideo = new EcoreExecutorType(CASAPackage.Literals.STREAM_VIDEO, PACKAGE, 0);
		public static final EcoreExecutorType _StreamingHistory = new EcoreExecutorType(CASAPackage.Literals.STREAMING_HISTORY, PACKAGE, 0);
		public static final EcoreExecutorType _System = new EcoreExecutorType(CASAPackage.Literals.SYSTEM, PACKAGE, 0);
		public static final EcoreExecutorType _TrackingCookie = new EcoreExecutorType(CASAPackage.Literals.TRACKING_COOKIE, PACKAGE, 0);
		public static final EcoreExecutorType _UploadVideo = new EcoreExecutorType(CASAPackage.Literals.UPLOAD_VIDEO, PACKAGE, 0);
		public static final EcoreExecutorType _User = new EcoreExecutorType(CASAPackage.Literals.USER, PACKAGE, 0);
		public static final EcoreExecutorType _Username = new EcoreExecutorType(CASAPackage.Literals.USERNAME, PACKAGE, 0);
		public static final EcoreExecutorType _VideoComment = new EcoreExecutorType(CASAPackage.Literals.VIDEO_COMMENT, PACKAGE, 0);
		public static final EcoreExecutorType _VideoContent = new EcoreExecutorType(CASAPackage.Literals.VIDEO_CONTENT, PACKAGE, 0);
		public static final EcoreExecutorType _VideoMetadata = new EcoreExecutorType(CASAPackage.Literals.VIDEO_METADATA, PACKAGE, 0);
		public static final EcoreExecutorType _Vulnerability = new EcoreExecutorType(CASAPackage.Literals.VULNERABILITY, PACKAGE, 0);

		private static final EcoreExecutorType /*@NonNull*/ [] types = {
			_Administrator,
			_AngularSPA,
			_CVE_2018_16843,
			_CVE_2018_16844,
			_CVE_2018_16845,
			_CVE_2019_9511,
			_CVE_2019_9513,
			_CVE_2019_9516,
			_CVE_2021_23017,
			_CVE_2021_3618,
			_CVE_2022_24834,
			_CVE_2022_36021,
			_CVE_2022_41862,
			_CVE_2023_2455,
			_CVE_2023_25155,
			_CVE_2023_28856,
			_CVE_2023_44487,
			_CVE_2023_45145,
			_CVE_2023_46809,
			_CVE_2023_5870,
			_CVE_2024_0985,
			_CVE_2024_10976,
			_CVE_2024_10977,
			_CVE_2024_10978,
			_CVE_2024_10979,
			_CVE_2024_21890,
			_CVE_2024_21891,
			_CVE_2024_21896,
			_CVE_2024_22017,
			_CVE_2024_22018,
			_CVE_2024_22019,
			_CVE_2024_22020,
			_CVE_2024_22025,
			_CVE_2024_27980,
			_CVE_2024_27983,
			_CVE_2024_31449,
			_CVE_2024_31489,
			_CVE_2024_3566,
			_CVE_2024_36137,
			_CVE_2024_36138,
			_CVE_2024_37372,
			_CVE_2024_46981,
			_CVE_2024_5205,
			_CVE_2024_7347,
			_CVE_2024_7348,
			_CVE_2025_1094,
			_CVE_2025_11187,
			_CVE_2025_15468,
			_CVE_2025_21605,
			_CVE_2025_23084,
			_CVE_2025_23090,
			_CVE_2025_32023,
			_CVE_2025_62506,
			_CVE_2025_62507,
			_CVE_2025_66199,
			_CVE_2025_69418,
			_CVE_2025_69420,
			_CVE_2025_69421,
			_CVE_2026_22795,
			_CVE_2026_22796,
			_CVE_2026_27970,
			_CVSSVector,
			_CommentWriteRead,
			_Component,
			_Consent,
			_Data,
			_DataSubject,
			_DeviceLocation,
			_DeviceType,
			_EmailAddress,
			_ExpressJS,
			_FilesystemComponent,
			_FuncPersData,
			_Function,
			_LiveStreamVideo,
			_Moderator,
			_Nginx,
			_NonPersonalData,
			_P2PStreaming,
			_PBehaviorTargetedAds,
			_PComments,
			_PFirstPartyProfiling,
			_PLocationTargetedAds,
			_PMarketing,
			_PP2PStreaming,
			_PProfiling,
			_PSocial,
			_PStandardAds,
			_PTargetedAds,
			_PThirdPartyProfiling,
			_PUserExperience,
			_PVideoRecommendation,
			_PVideoSharing,
			_Password,
			_Payment,
			_PersonalData,
			_Postgresql,
			_Purpose,
			_PurposeConsent,
			_PurposeNoConsent,
			_RecommendVideos,
			_RedisComponent,
			_RemoveVideo,
			_RequestTimestamps,
			_Risk,
			_ServeBehaviorTargetedAds,
			_ServeLocationTargetedAds,
			_ServeStandardAds,
			_StreamVideo,
			_StreamingHistory,
			_System,
			_TrackingCookie,
			_UploadVideo,
			_User,
			_Username,
			_VideoComment,
			_VideoContent,
			_VideoMetadata,
			_Vulnerability
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::Types and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragment descriptors for the local elements of each type and its supertypes.
	 */
	public static class Fragments {
		static {
			Init.initStart();
			Types.init();
		}

		private static final ExecutorFragment _Administrator__Administrator = new ExecutorFragment(Types._Administrator, CASATables.Types._Administrator);
		private static final ExecutorFragment _Administrator__DataSubject = new ExecutorFragment(Types._Administrator, CASATables.Types._DataSubject);
		private static final ExecutorFragment _Administrator__OclAny = new ExecutorFragment(Types._Administrator, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Administrator__OclElement = new ExecutorFragment(Types._Administrator, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _AngularSPA__AngularSPA = new ExecutorFragment(Types._AngularSPA, CASATables.Types._AngularSPA);
		private static final ExecutorFragment _AngularSPA__Component = new ExecutorFragment(Types._AngularSPA, CASATables.Types._Component);
		private static final ExecutorFragment _AngularSPA__OclAny = new ExecutorFragment(Types._AngularSPA, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _AngularSPA__OclElement = new ExecutorFragment(Types._AngularSPA, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _CVE_2018_16843__CVE_2018_16843 = new ExecutorFragment(Types._CVE_2018_16843, CASATables.Types._CVE_2018_16843);
		private static final ExecutorFragment _CVE_2018_16843__OclAny = new ExecutorFragment(Types._CVE_2018_16843, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2018_16843__OclElement = new ExecutorFragment(Types._CVE_2018_16843, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2018_16843__Vulnerability = new ExecutorFragment(Types._CVE_2018_16843, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2018_16844__CVE_2018_16844 = new ExecutorFragment(Types._CVE_2018_16844, CASATables.Types._CVE_2018_16844);
		private static final ExecutorFragment _CVE_2018_16844__OclAny = new ExecutorFragment(Types._CVE_2018_16844, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2018_16844__OclElement = new ExecutorFragment(Types._CVE_2018_16844, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2018_16844__Vulnerability = new ExecutorFragment(Types._CVE_2018_16844, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2018_16845__CVE_2018_16845 = new ExecutorFragment(Types._CVE_2018_16845, CASATables.Types._CVE_2018_16845);
		private static final ExecutorFragment _CVE_2018_16845__OclAny = new ExecutorFragment(Types._CVE_2018_16845, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2018_16845__OclElement = new ExecutorFragment(Types._CVE_2018_16845, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2018_16845__Vulnerability = new ExecutorFragment(Types._CVE_2018_16845, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2019_9511__CVE_2019_9511 = new ExecutorFragment(Types._CVE_2019_9511, CASATables.Types._CVE_2019_9511);
		private static final ExecutorFragment _CVE_2019_9511__OclAny = new ExecutorFragment(Types._CVE_2019_9511, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2019_9511__OclElement = new ExecutorFragment(Types._CVE_2019_9511, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2019_9511__Vulnerability = new ExecutorFragment(Types._CVE_2019_9511, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2019_9513__CVE_2019_9513 = new ExecutorFragment(Types._CVE_2019_9513, CASATables.Types._CVE_2019_9513);
		private static final ExecutorFragment _CVE_2019_9513__OclAny = new ExecutorFragment(Types._CVE_2019_9513, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2019_9513__OclElement = new ExecutorFragment(Types._CVE_2019_9513, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2019_9513__Vulnerability = new ExecutorFragment(Types._CVE_2019_9513, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2019_9516__CVE_2019_9516 = new ExecutorFragment(Types._CVE_2019_9516, CASATables.Types._CVE_2019_9516);
		private static final ExecutorFragment _CVE_2019_9516__OclAny = new ExecutorFragment(Types._CVE_2019_9516, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2019_9516__OclElement = new ExecutorFragment(Types._CVE_2019_9516, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2019_9516__Vulnerability = new ExecutorFragment(Types._CVE_2019_9516, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2021_23017__CVE_2021_23017 = new ExecutorFragment(Types._CVE_2021_23017, CASATables.Types._CVE_2021_23017);
		private static final ExecutorFragment _CVE_2021_23017__OclAny = new ExecutorFragment(Types._CVE_2021_23017, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2021_23017__OclElement = new ExecutorFragment(Types._CVE_2021_23017, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2021_23017__Vulnerability = new ExecutorFragment(Types._CVE_2021_23017, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2021_3618__CVE_2021_3618 = new ExecutorFragment(Types._CVE_2021_3618, CASATables.Types._CVE_2021_3618);
		private static final ExecutorFragment _CVE_2021_3618__OclAny = new ExecutorFragment(Types._CVE_2021_3618, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2021_3618__OclElement = new ExecutorFragment(Types._CVE_2021_3618, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2021_3618__Vulnerability = new ExecutorFragment(Types._CVE_2021_3618, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2022_24834__CVE_2022_24834 = new ExecutorFragment(Types._CVE_2022_24834, CASATables.Types._CVE_2022_24834);
		private static final ExecutorFragment _CVE_2022_24834__OclAny = new ExecutorFragment(Types._CVE_2022_24834, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2022_24834__OclElement = new ExecutorFragment(Types._CVE_2022_24834, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2022_24834__Vulnerability = new ExecutorFragment(Types._CVE_2022_24834, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2022_36021__CVE_2022_36021 = new ExecutorFragment(Types._CVE_2022_36021, CASATables.Types._CVE_2022_36021);
		private static final ExecutorFragment _CVE_2022_36021__OclAny = new ExecutorFragment(Types._CVE_2022_36021, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2022_36021__OclElement = new ExecutorFragment(Types._CVE_2022_36021, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2022_36021__Vulnerability = new ExecutorFragment(Types._CVE_2022_36021, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2022_41862__CVE_2022_41862 = new ExecutorFragment(Types._CVE_2022_41862, CASATables.Types._CVE_2022_41862);
		private static final ExecutorFragment _CVE_2022_41862__OclAny = new ExecutorFragment(Types._CVE_2022_41862, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2022_41862__OclElement = new ExecutorFragment(Types._CVE_2022_41862, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2022_41862__Vulnerability = new ExecutorFragment(Types._CVE_2022_41862, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2023_2455__CVE_2023_2455 = new ExecutorFragment(Types._CVE_2023_2455, CASATables.Types._CVE_2023_2455);
		private static final ExecutorFragment _CVE_2023_2455__OclAny = new ExecutorFragment(Types._CVE_2023_2455, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2023_2455__OclElement = new ExecutorFragment(Types._CVE_2023_2455, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2023_2455__Vulnerability = new ExecutorFragment(Types._CVE_2023_2455, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2023_25155__CVE_2023_25155 = new ExecutorFragment(Types._CVE_2023_25155, CASATables.Types._CVE_2023_25155);
		private static final ExecutorFragment _CVE_2023_25155__OclAny = new ExecutorFragment(Types._CVE_2023_25155, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2023_25155__OclElement = new ExecutorFragment(Types._CVE_2023_25155, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2023_25155__Vulnerability = new ExecutorFragment(Types._CVE_2023_25155, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2023_28856__CVE_2023_28856 = new ExecutorFragment(Types._CVE_2023_28856, CASATables.Types._CVE_2023_28856);
		private static final ExecutorFragment _CVE_2023_28856__OclAny = new ExecutorFragment(Types._CVE_2023_28856, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2023_28856__OclElement = new ExecutorFragment(Types._CVE_2023_28856, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2023_28856__Vulnerability = new ExecutorFragment(Types._CVE_2023_28856, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2023_44487__CVE_2023_44487 = new ExecutorFragment(Types._CVE_2023_44487, CASATables.Types._CVE_2023_44487);
		private static final ExecutorFragment _CVE_2023_44487__OclAny = new ExecutorFragment(Types._CVE_2023_44487, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2023_44487__OclElement = new ExecutorFragment(Types._CVE_2023_44487, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2023_44487__Vulnerability = new ExecutorFragment(Types._CVE_2023_44487, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2023_45145__CVE_2023_45145 = new ExecutorFragment(Types._CVE_2023_45145, CASATables.Types._CVE_2023_45145);
		private static final ExecutorFragment _CVE_2023_45145__OclAny = new ExecutorFragment(Types._CVE_2023_45145, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2023_45145__OclElement = new ExecutorFragment(Types._CVE_2023_45145, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2023_45145__Vulnerability = new ExecutorFragment(Types._CVE_2023_45145, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2023_46809__CVE_2023_46809 = new ExecutorFragment(Types._CVE_2023_46809, CASATables.Types._CVE_2023_46809);
		private static final ExecutorFragment _CVE_2023_46809__OclAny = new ExecutorFragment(Types._CVE_2023_46809, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2023_46809__OclElement = new ExecutorFragment(Types._CVE_2023_46809, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2023_46809__Vulnerability = new ExecutorFragment(Types._CVE_2023_46809, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2023_5870__CVE_2023_5870 = new ExecutorFragment(Types._CVE_2023_5870, CASATables.Types._CVE_2023_5870);
		private static final ExecutorFragment _CVE_2023_5870__OclAny = new ExecutorFragment(Types._CVE_2023_5870, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2023_5870__OclElement = new ExecutorFragment(Types._CVE_2023_5870, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2023_5870__Vulnerability = new ExecutorFragment(Types._CVE_2023_5870, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_0985__CVE_2024_0985 = new ExecutorFragment(Types._CVE_2024_0985, CASATables.Types._CVE_2024_0985);
		private static final ExecutorFragment _CVE_2024_0985__OclAny = new ExecutorFragment(Types._CVE_2024_0985, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_0985__OclElement = new ExecutorFragment(Types._CVE_2024_0985, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_0985__Vulnerability = new ExecutorFragment(Types._CVE_2024_0985, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_10976__CVE_2024_10976 = new ExecutorFragment(Types._CVE_2024_10976, CASATables.Types._CVE_2024_10976);
		private static final ExecutorFragment _CVE_2024_10976__OclAny = new ExecutorFragment(Types._CVE_2024_10976, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_10976__OclElement = new ExecutorFragment(Types._CVE_2024_10976, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_10976__Vulnerability = new ExecutorFragment(Types._CVE_2024_10976, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_10977__CVE_2024_10977 = new ExecutorFragment(Types._CVE_2024_10977, CASATables.Types._CVE_2024_10977);
		private static final ExecutorFragment _CVE_2024_10977__OclAny = new ExecutorFragment(Types._CVE_2024_10977, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_10977__OclElement = new ExecutorFragment(Types._CVE_2024_10977, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_10977__Vulnerability = new ExecutorFragment(Types._CVE_2024_10977, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_10978__CVE_2024_10978 = new ExecutorFragment(Types._CVE_2024_10978, CASATables.Types._CVE_2024_10978);
		private static final ExecutorFragment _CVE_2024_10978__OclAny = new ExecutorFragment(Types._CVE_2024_10978, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_10978__OclElement = new ExecutorFragment(Types._CVE_2024_10978, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_10978__Vulnerability = new ExecutorFragment(Types._CVE_2024_10978, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_10979__CVE_2024_10979 = new ExecutorFragment(Types._CVE_2024_10979, CASATables.Types._CVE_2024_10979);
		private static final ExecutorFragment _CVE_2024_10979__OclAny = new ExecutorFragment(Types._CVE_2024_10979, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_10979__OclElement = new ExecutorFragment(Types._CVE_2024_10979, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_10979__Vulnerability = new ExecutorFragment(Types._CVE_2024_10979, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_21890__CVE_2024_21890 = new ExecutorFragment(Types._CVE_2024_21890, CASATables.Types._CVE_2024_21890);
		private static final ExecutorFragment _CVE_2024_21890__OclAny = new ExecutorFragment(Types._CVE_2024_21890, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_21890__OclElement = new ExecutorFragment(Types._CVE_2024_21890, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_21890__Vulnerability = new ExecutorFragment(Types._CVE_2024_21890, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_21891__CVE_2024_21891 = new ExecutorFragment(Types._CVE_2024_21891, CASATables.Types._CVE_2024_21891);
		private static final ExecutorFragment _CVE_2024_21891__OclAny = new ExecutorFragment(Types._CVE_2024_21891, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_21891__OclElement = new ExecutorFragment(Types._CVE_2024_21891, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_21891__Vulnerability = new ExecutorFragment(Types._CVE_2024_21891, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_21896__CVE_2024_21896 = new ExecutorFragment(Types._CVE_2024_21896, CASATables.Types._CVE_2024_21896);
		private static final ExecutorFragment _CVE_2024_21896__OclAny = new ExecutorFragment(Types._CVE_2024_21896, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_21896__OclElement = new ExecutorFragment(Types._CVE_2024_21896, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_21896__Vulnerability = new ExecutorFragment(Types._CVE_2024_21896, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_22017__CVE_2024_22017 = new ExecutorFragment(Types._CVE_2024_22017, CASATables.Types._CVE_2024_22017);
		private static final ExecutorFragment _CVE_2024_22017__OclAny = new ExecutorFragment(Types._CVE_2024_22017, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_22017__OclElement = new ExecutorFragment(Types._CVE_2024_22017, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_22017__Vulnerability = new ExecutorFragment(Types._CVE_2024_22017, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_22018__CVE_2024_22018 = new ExecutorFragment(Types._CVE_2024_22018, CASATables.Types._CVE_2024_22018);
		private static final ExecutorFragment _CVE_2024_22018__OclAny = new ExecutorFragment(Types._CVE_2024_22018, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_22018__OclElement = new ExecutorFragment(Types._CVE_2024_22018, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_22018__Vulnerability = new ExecutorFragment(Types._CVE_2024_22018, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_22019__CVE_2024_22019 = new ExecutorFragment(Types._CVE_2024_22019, CASATables.Types._CVE_2024_22019);
		private static final ExecutorFragment _CVE_2024_22019__OclAny = new ExecutorFragment(Types._CVE_2024_22019, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_22019__OclElement = new ExecutorFragment(Types._CVE_2024_22019, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_22019__Vulnerability = new ExecutorFragment(Types._CVE_2024_22019, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_22020__CVE_2024_22020 = new ExecutorFragment(Types._CVE_2024_22020, CASATables.Types._CVE_2024_22020);
		private static final ExecutorFragment _CVE_2024_22020__OclAny = new ExecutorFragment(Types._CVE_2024_22020, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_22020__OclElement = new ExecutorFragment(Types._CVE_2024_22020, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_22020__Vulnerability = new ExecutorFragment(Types._CVE_2024_22020, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_22025__CVE_2024_22025 = new ExecutorFragment(Types._CVE_2024_22025, CASATables.Types._CVE_2024_22025);
		private static final ExecutorFragment _CVE_2024_22025__OclAny = new ExecutorFragment(Types._CVE_2024_22025, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_22025__OclElement = new ExecutorFragment(Types._CVE_2024_22025, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_22025__Vulnerability = new ExecutorFragment(Types._CVE_2024_22025, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_27980__CVE_2024_27980 = new ExecutorFragment(Types._CVE_2024_27980, CASATables.Types._CVE_2024_27980);
		private static final ExecutorFragment _CVE_2024_27980__OclAny = new ExecutorFragment(Types._CVE_2024_27980, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_27980__OclElement = new ExecutorFragment(Types._CVE_2024_27980, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_27980__Vulnerability = new ExecutorFragment(Types._CVE_2024_27980, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_27983__CVE_2024_27983 = new ExecutorFragment(Types._CVE_2024_27983, CASATables.Types._CVE_2024_27983);
		private static final ExecutorFragment _CVE_2024_27983__OclAny = new ExecutorFragment(Types._CVE_2024_27983, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_27983__OclElement = new ExecutorFragment(Types._CVE_2024_27983, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_27983__Vulnerability = new ExecutorFragment(Types._CVE_2024_27983, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_31449__CVE_2024_31449 = new ExecutorFragment(Types._CVE_2024_31449, CASATables.Types._CVE_2024_31449);
		private static final ExecutorFragment _CVE_2024_31449__OclAny = new ExecutorFragment(Types._CVE_2024_31449, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_31449__OclElement = new ExecutorFragment(Types._CVE_2024_31449, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_31449__Vulnerability = new ExecutorFragment(Types._CVE_2024_31449, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_31489__CVE_2024_31489 = new ExecutorFragment(Types._CVE_2024_31489, CASATables.Types._CVE_2024_31489);
		private static final ExecutorFragment _CVE_2024_31489__OclAny = new ExecutorFragment(Types._CVE_2024_31489, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_31489__OclElement = new ExecutorFragment(Types._CVE_2024_31489, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_31489__Vulnerability = new ExecutorFragment(Types._CVE_2024_31489, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_3566__CVE_2024_3566 = new ExecutorFragment(Types._CVE_2024_3566, CASATables.Types._CVE_2024_3566);
		private static final ExecutorFragment _CVE_2024_3566__OclAny = new ExecutorFragment(Types._CVE_2024_3566, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_3566__OclElement = new ExecutorFragment(Types._CVE_2024_3566, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_3566__Vulnerability = new ExecutorFragment(Types._CVE_2024_3566, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_36137__CVE_2024_36137 = new ExecutorFragment(Types._CVE_2024_36137, CASATables.Types._CVE_2024_36137);
		private static final ExecutorFragment _CVE_2024_36137__OclAny = new ExecutorFragment(Types._CVE_2024_36137, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_36137__OclElement = new ExecutorFragment(Types._CVE_2024_36137, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_36137__Vulnerability = new ExecutorFragment(Types._CVE_2024_36137, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_36138__CVE_2024_36138 = new ExecutorFragment(Types._CVE_2024_36138, CASATables.Types._CVE_2024_36138);
		private static final ExecutorFragment _CVE_2024_36138__OclAny = new ExecutorFragment(Types._CVE_2024_36138, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_36138__OclElement = new ExecutorFragment(Types._CVE_2024_36138, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_36138__Vulnerability = new ExecutorFragment(Types._CVE_2024_36138, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_37372__CVE_2024_37372 = new ExecutorFragment(Types._CVE_2024_37372, CASATables.Types._CVE_2024_37372);
		private static final ExecutorFragment _CVE_2024_37372__OclAny = new ExecutorFragment(Types._CVE_2024_37372, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_37372__OclElement = new ExecutorFragment(Types._CVE_2024_37372, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_37372__Vulnerability = new ExecutorFragment(Types._CVE_2024_37372, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_46981__CVE_2024_46981 = new ExecutorFragment(Types._CVE_2024_46981, CASATables.Types._CVE_2024_46981);
		private static final ExecutorFragment _CVE_2024_46981__OclAny = new ExecutorFragment(Types._CVE_2024_46981, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_46981__OclElement = new ExecutorFragment(Types._CVE_2024_46981, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_46981__Vulnerability = new ExecutorFragment(Types._CVE_2024_46981, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_5205__CVE_2024_5205 = new ExecutorFragment(Types._CVE_2024_5205, CASATables.Types._CVE_2024_5205);
		private static final ExecutorFragment _CVE_2024_5205__OclAny = new ExecutorFragment(Types._CVE_2024_5205, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_5205__OclElement = new ExecutorFragment(Types._CVE_2024_5205, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_5205__Vulnerability = new ExecutorFragment(Types._CVE_2024_5205, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_7347__CVE_2024_7347 = new ExecutorFragment(Types._CVE_2024_7347, CASATables.Types._CVE_2024_7347);
		private static final ExecutorFragment _CVE_2024_7347__OclAny = new ExecutorFragment(Types._CVE_2024_7347, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_7347__OclElement = new ExecutorFragment(Types._CVE_2024_7347, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_7347__Vulnerability = new ExecutorFragment(Types._CVE_2024_7347, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2024_7348__CVE_2024_7348 = new ExecutorFragment(Types._CVE_2024_7348, CASATables.Types._CVE_2024_7348);
		private static final ExecutorFragment _CVE_2024_7348__OclAny = new ExecutorFragment(Types._CVE_2024_7348, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2024_7348__OclElement = new ExecutorFragment(Types._CVE_2024_7348, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2024_7348__Vulnerability = new ExecutorFragment(Types._CVE_2024_7348, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_1094__CVE_2025_1094 = new ExecutorFragment(Types._CVE_2025_1094, CASATables.Types._CVE_2025_1094);
		private static final ExecutorFragment _CVE_2025_1094__OclAny = new ExecutorFragment(Types._CVE_2025_1094, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_1094__OclElement = new ExecutorFragment(Types._CVE_2025_1094, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_1094__Vulnerability = new ExecutorFragment(Types._CVE_2025_1094, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_11187__CVE_2025_11187 = new ExecutorFragment(Types._CVE_2025_11187, CASATables.Types._CVE_2025_11187);
		private static final ExecutorFragment _CVE_2025_11187__OclAny = new ExecutorFragment(Types._CVE_2025_11187, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_11187__OclElement = new ExecutorFragment(Types._CVE_2025_11187, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_11187__Vulnerability = new ExecutorFragment(Types._CVE_2025_11187, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_15468__CVE_2025_15468 = new ExecutorFragment(Types._CVE_2025_15468, CASATables.Types._CVE_2025_15468);
		private static final ExecutorFragment _CVE_2025_15468__OclAny = new ExecutorFragment(Types._CVE_2025_15468, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_15468__OclElement = new ExecutorFragment(Types._CVE_2025_15468, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_15468__Vulnerability = new ExecutorFragment(Types._CVE_2025_15468, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_21605__CVE_2025_21605 = new ExecutorFragment(Types._CVE_2025_21605, CASATables.Types._CVE_2025_21605);
		private static final ExecutorFragment _CVE_2025_21605__OclAny = new ExecutorFragment(Types._CVE_2025_21605, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_21605__OclElement = new ExecutorFragment(Types._CVE_2025_21605, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_21605__Vulnerability = new ExecutorFragment(Types._CVE_2025_21605, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_23084__CVE_2025_23084 = new ExecutorFragment(Types._CVE_2025_23084, CASATables.Types._CVE_2025_23084);
		private static final ExecutorFragment _CVE_2025_23084__OclAny = new ExecutorFragment(Types._CVE_2025_23084, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_23084__OclElement = new ExecutorFragment(Types._CVE_2025_23084, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_23084__Vulnerability = new ExecutorFragment(Types._CVE_2025_23084, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_23090__CVE_2025_23090 = new ExecutorFragment(Types._CVE_2025_23090, CASATables.Types._CVE_2025_23090);
		private static final ExecutorFragment _CVE_2025_23090__OclAny = new ExecutorFragment(Types._CVE_2025_23090, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_23090__OclElement = new ExecutorFragment(Types._CVE_2025_23090, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_23090__Vulnerability = new ExecutorFragment(Types._CVE_2025_23090, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_32023__CVE_2025_32023 = new ExecutorFragment(Types._CVE_2025_32023, CASATables.Types._CVE_2025_32023);
		private static final ExecutorFragment _CVE_2025_32023__OclAny = new ExecutorFragment(Types._CVE_2025_32023, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_32023__OclElement = new ExecutorFragment(Types._CVE_2025_32023, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_32023__Vulnerability = new ExecutorFragment(Types._CVE_2025_32023, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_62506__CVE_2025_62506 = new ExecutorFragment(Types._CVE_2025_62506, CASATables.Types._CVE_2025_62506);
		private static final ExecutorFragment _CVE_2025_62506__OclAny = new ExecutorFragment(Types._CVE_2025_62506, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_62506__OclElement = new ExecutorFragment(Types._CVE_2025_62506, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_62506__Vulnerability = new ExecutorFragment(Types._CVE_2025_62506, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_62507__CVE_2025_62507 = new ExecutorFragment(Types._CVE_2025_62507, CASATables.Types._CVE_2025_62507);
		private static final ExecutorFragment _CVE_2025_62507__OclAny = new ExecutorFragment(Types._CVE_2025_62507, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_62507__OclElement = new ExecutorFragment(Types._CVE_2025_62507, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_62507__Vulnerability = new ExecutorFragment(Types._CVE_2025_62507, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_66199__CVE_2025_66199 = new ExecutorFragment(Types._CVE_2025_66199, CASATables.Types._CVE_2025_66199);
		private static final ExecutorFragment _CVE_2025_66199__OclAny = new ExecutorFragment(Types._CVE_2025_66199, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_66199__OclElement = new ExecutorFragment(Types._CVE_2025_66199, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_66199__Vulnerability = new ExecutorFragment(Types._CVE_2025_66199, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_69418__CVE_2025_69418 = new ExecutorFragment(Types._CVE_2025_69418, CASATables.Types._CVE_2025_69418);
		private static final ExecutorFragment _CVE_2025_69418__OclAny = new ExecutorFragment(Types._CVE_2025_69418, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_69418__OclElement = new ExecutorFragment(Types._CVE_2025_69418, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_69418__Vulnerability = new ExecutorFragment(Types._CVE_2025_69418, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_69420__CVE_2025_69420 = new ExecutorFragment(Types._CVE_2025_69420, CASATables.Types._CVE_2025_69420);
		private static final ExecutorFragment _CVE_2025_69420__OclAny = new ExecutorFragment(Types._CVE_2025_69420, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_69420__OclElement = new ExecutorFragment(Types._CVE_2025_69420, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_69420__Vulnerability = new ExecutorFragment(Types._CVE_2025_69420, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2025_69421__CVE_2025_69421 = new ExecutorFragment(Types._CVE_2025_69421, CASATables.Types._CVE_2025_69421);
		private static final ExecutorFragment _CVE_2025_69421__OclAny = new ExecutorFragment(Types._CVE_2025_69421, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2025_69421__OclElement = new ExecutorFragment(Types._CVE_2025_69421, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2025_69421__Vulnerability = new ExecutorFragment(Types._CVE_2025_69421, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2026_22795__CVE_2026_22795 = new ExecutorFragment(Types._CVE_2026_22795, CASATables.Types._CVE_2026_22795);
		private static final ExecutorFragment _CVE_2026_22795__OclAny = new ExecutorFragment(Types._CVE_2026_22795, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2026_22795__OclElement = new ExecutorFragment(Types._CVE_2026_22795, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2026_22795__Vulnerability = new ExecutorFragment(Types._CVE_2026_22795, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2026_22796__CVE_2026_22796 = new ExecutorFragment(Types._CVE_2026_22796, CASATables.Types._CVE_2026_22796);
		private static final ExecutorFragment _CVE_2026_22796__OclAny = new ExecutorFragment(Types._CVE_2026_22796, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2026_22796__OclElement = new ExecutorFragment(Types._CVE_2026_22796, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2026_22796__Vulnerability = new ExecutorFragment(Types._CVE_2026_22796, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVE_2026_27970__CVE_2026_27970 = new ExecutorFragment(Types._CVE_2026_27970, CASATables.Types._CVE_2026_27970);
		private static final ExecutorFragment _CVE_2026_27970__OclAny = new ExecutorFragment(Types._CVE_2026_27970, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVE_2026_27970__OclElement = new ExecutorFragment(Types._CVE_2026_27970, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _CVE_2026_27970__Vulnerability = new ExecutorFragment(Types._CVE_2026_27970, CASATables.Types._Vulnerability);

		private static final ExecutorFragment _CVSSVector__CVSSVector = new ExecutorFragment(Types._CVSSVector, CASATables.Types._CVSSVector);
		private static final ExecutorFragment _CVSSVector__OclAny = new ExecutorFragment(Types._CVSSVector, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CVSSVector__OclElement = new ExecutorFragment(Types._CVSSVector, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _CommentWriteRead__CommentWriteRead = new ExecutorFragment(Types._CommentWriteRead, CASATables.Types._CommentWriteRead);
		private static final ExecutorFragment _CommentWriteRead__FuncPersData = new ExecutorFragment(Types._CommentWriteRead, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _CommentWriteRead__Function = new ExecutorFragment(Types._CommentWriteRead, CASATables.Types._Function);
		private static final ExecutorFragment _CommentWriteRead__OclAny = new ExecutorFragment(Types._CommentWriteRead, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _CommentWriteRead__OclElement = new ExecutorFragment(Types._CommentWriteRead, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Component__Component = new ExecutorFragment(Types._Component, CASATables.Types._Component);
		private static final ExecutorFragment _Component__OclAny = new ExecutorFragment(Types._Component, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Component__OclElement = new ExecutorFragment(Types._Component, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Consent__Consent = new ExecutorFragment(Types._Consent, CASATables.Types._Consent);
		private static final ExecutorFragment _Consent__OclAny = new ExecutorFragment(Types._Consent, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Consent__OclElement = new ExecutorFragment(Types._Consent, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Data__Data = new ExecutorFragment(Types._Data, CASATables.Types._Data);
		private static final ExecutorFragment _Data__OclAny = new ExecutorFragment(Types._Data, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Data__OclElement = new ExecutorFragment(Types._Data, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _DataSubject__DataSubject = new ExecutorFragment(Types._DataSubject, CASATables.Types._DataSubject);
		private static final ExecutorFragment _DataSubject__OclAny = new ExecutorFragment(Types._DataSubject, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _DataSubject__OclElement = new ExecutorFragment(Types._DataSubject, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _DeviceLocation__Data = new ExecutorFragment(Types._DeviceLocation, CASATables.Types._Data);
		private static final ExecutorFragment _DeviceLocation__DeviceLocation = new ExecutorFragment(Types._DeviceLocation, CASATables.Types._DeviceLocation);
		private static final ExecutorFragment _DeviceLocation__OclAny = new ExecutorFragment(Types._DeviceLocation, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _DeviceLocation__OclElement = new ExecutorFragment(Types._DeviceLocation, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _DeviceLocation__PersonalData = new ExecutorFragment(Types._DeviceLocation, CASATables.Types._PersonalData);

		private static final ExecutorFragment _DeviceType__Data = new ExecutorFragment(Types._DeviceType, CASATables.Types._Data);
		private static final ExecutorFragment _DeviceType__DeviceType = new ExecutorFragment(Types._DeviceType, CASATables.Types._DeviceType);
		private static final ExecutorFragment _DeviceType__OclAny = new ExecutorFragment(Types._DeviceType, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _DeviceType__OclElement = new ExecutorFragment(Types._DeviceType, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _DeviceType__PersonalData = new ExecutorFragment(Types._DeviceType, CASATables.Types._PersonalData);

		private static final ExecutorFragment _EmailAddress__Data = new ExecutorFragment(Types._EmailAddress, CASATables.Types._Data);
		private static final ExecutorFragment _EmailAddress__EmailAddress = new ExecutorFragment(Types._EmailAddress, CASATables.Types._EmailAddress);
		private static final ExecutorFragment _EmailAddress__OclAny = new ExecutorFragment(Types._EmailAddress, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _EmailAddress__OclElement = new ExecutorFragment(Types._EmailAddress, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _EmailAddress__PersonalData = new ExecutorFragment(Types._EmailAddress, CASATables.Types._PersonalData);

		private static final ExecutorFragment _ExpressJS__Component = new ExecutorFragment(Types._ExpressJS, CASATables.Types._Component);
		private static final ExecutorFragment _ExpressJS__ExpressJS = new ExecutorFragment(Types._ExpressJS, CASATables.Types._ExpressJS);
		private static final ExecutorFragment _ExpressJS__OclAny = new ExecutorFragment(Types._ExpressJS, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ExpressJS__OclElement = new ExecutorFragment(Types._ExpressJS, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _FilesystemComponent__Component = new ExecutorFragment(Types._FilesystemComponent, CASATables.Types._Component);
		private static final ExecutorFragment _FilesystemComponent__FilesystemComponent = new ExecutorFragment(Types._FilesystemComponent, CASATables.Types._FilesystemComponent);
		private static final ExecutorFragment _FilesystemComponent__OclAny = new ExecutorFragment(Types._FilesystemComponent, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _FilesystemComponent__OclElement = new ExecutorFragment(Types._FilesystemComponent, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _FuncPersData__FuncPersData = new ExecutorFragment(Types._FuncPersData, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _FuncPersData__Function = new ExecutorFragment(Types._FuncPersData, CASATables.Types._Function);
		private static final ExecutorFragment _FuncPersData__OclAny = new ExecutorFragment(Types._FuncPersData, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _FuncPersData__OclElement = new ExecutorFragment(Types._FuncPersData, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Function__Function = new ExecutorFragment(Types._Function, CASATables.Types._Function);
		private static final ExecutorFragment _Function__OclAny = new ExecutorFragment(Types._Function, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Function__OclElement = new ExecutorFragment(Types._Function, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _LiveStreamVideo__FuncPersData = new ExecutorFragment(Types._LiveStreamVideo, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _LiveStreamVideo__Function = new ExecutorFragment(Types._LiveStreamVideo, CASATables.Types._Function);
		private static final ExecutorFragment _LiveStreamVideo__LiveStreamVideo = new ExecutorFragment(Types._LiveStreamVideo, CASATables.Types._LiveStreamVideo);
		private static final ExecutorFragment _LiveStreamVideo__OclAny = new ExecutorFragment(Types._LiveStreamVideo, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _LiveStreamVideo__OclElement = new ExecutorFragment(Types._LiveStreamVideo, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Moderator__DataSubject = new ExecutorFragment(Types._Moderator, CASATables.Types._DataSubject);
		private static final ExecutorFragment _Moderator__Moderator = new ExecutorFragment(Types._Moderator, CASATables.Types._Moderator);
		private static final ExecutorFragment _Moderator__OclAny = new ExecutorFragment(Types._Moderator, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Moderator__OclElement = new ExecutorFragment(Types._Moderator, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _Nginx__Component = new ExecutorFragment(Types._Nginx, CASATables.Types._Component);
		private static final ExecutorFragment _Nginx__Nginx = new ExecutorFragment(Types._Nginx, CASATables.Types._Nginx);
		private static final ExecutorFragment _Nginx__OclAny = new ExecutorFragment(Types._Nginx, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Nginx__OclElement = new ExecutorFragment(Types._Nginx, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _NonPersonalData__Data = new ExecutorFragment(Types._NonPersonalData, CASATables.Types._Data);
		private static final ExecutorFragment _NonPersonalData__NonPersonalData = new ExecutorFragment(Types._NonPersonalData, CASATables.Types._NonPersonalData);
		private static final ExecutorFragment _NonPersonalData__OclAny = new ExecutorFragment(Types._NonPersonalData, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _NonPersonalData__OclElement = new ExecutorFragment(Types._NonPersonalData, OCLstdlibTables.Types._OclElement);

		private static final ExecutorFragment _P2PStreaming__FuncPersData = new ExecutorFragment(Types._P2PStreaming, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _P2PStreaming__Function = new ExecutorFragment(Types._P2PStreaming, CASATables.Types._Function);
		private static final ExecutorFragment _P2PStreaming__OclAny = new ExecutorFragment(Types._P2PStreaming, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _P2PStreaming__OclElement = new ExecutorFragment(Types._P2PStreaming, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _P2PStreaming__P2PStreaming = new ExecutorFragment(Types._P2PStreaming, CASATables.Types._P2PStreaming);

		private static final ExecutorFragment _PBehaviorTargetedAds__OclAny = new ExecutorFragment(Types._PBehaviorTargetedAds, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PBehaviorTargetedAds__OclElement = new ExecutorFragment(Types._PBehaviorTargetedAds, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PBehaviorTargetedAds__PBehaviorTargetedAds = new ExecutorFragment(Types._PBehaviorTargetedAds, CASATables.Types._PBehaviorTargetedAds);
		private static final ExecutorFragment _PBehaviorTargetedAds__PMarketing = new ExecutorFragment(Types._PBehaviorTargetedAds, CASATables.Types._PMarketing);
		private static final ExecutorFragment _PBehaviorTargetedAds__PTargetedAds = new ExecutorFragment(Types._PBehaviorTargetedAds, CASATables.Types._PTargetedAds);
		private static final ExecutorFragment _PBehaviorTargetedAds__Purpose = new ExecutorFragment(Types._PBehaviorTargetedAds, CASATables.Types._Purpose);
		private static final ExecutorFragment _PBehaviorTargetedAds__PurposeConsent = new ExecutorFragment(Types._PBehaviorTargetedAds, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PComments__OclAny = new ExecutorFragment(Types._PComments, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PComments__OclElement = new ExecutorFragment(Types._PComments, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PComments__PComments = new ExecutorFragment(Types._PComments, CASATables.Types._PComments);
		private static final ExecutorFragment _PComments__PSocial = new ExecutorFragment(Types._PComments, CASATables.Types._PSocial);
		private static final ExecutorFragment _PComments__Purpose = new ExecutorFragment(Types._PComments, CASATables.Types._Purpose);
		private static final ExecutorFragment _PComments__PurposeConsent = new ExecutorFragment(Types._PComments, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PFirstPartyProfiling__OclAny = new ExecutorFragment(Types._PFirstPartyProfiling, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PFirstPartyProfiling__OclElement = new ExecutorFragment(Types._PFirstPartyProfiling, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PFirstPartyProfiling__PFirstPartyProfiling = new ExecutorFragment(Types._PFirstPartyProfiling, CASATables.Types._PFirstPartyProfiling);
		private static final ExecutorFragment _PFirstPartyProfiling__PProfiling = new ExecutorFragment(Types._PFirstPartyProfiling, CASATables.Types._PProfiling);
		private static final ExecutorFragment _PFirstPartyProfiling__Purpose = new ExecutorFragment(Types._PFirstPartyProfiling, CASATables.Types._Purpose);
		private static final ExecutorFragment _PFirstPartyProfiling__PurposeConsent = new ExecutorFragment(Types._PFirstPartyProfiling, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PLocationTargetedAds__OclAny = new ExecutorFragment(Types._PLocationTargetedAds, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PLocationTargetedAds__OclElement = new ExecutorFragment(Types._PLocationTargetedAds, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PLocationTargetedAds__PLocationTargetedAds = new ExecutorFragment(Types._PLocationTargetedAds, CASATables.Types._PLocationTargetedAds);
		private static final ExecutorFragment _PLocationTargetedAds__PMarketing = new ExecutorFragment(Types._PLocationTargetedAds, CASATables.Types._PMarketing);
		private static final ExecutorFragment _PLocationTargetedAds__PTargetedAds = new ExecutorFragment(Types._PLocationTargetedAds, CASATables.Types._PTargetedAds);
		private static final ExecutorFragment _PLocationTargetedAds__Purpose = new ExecutorFragment(Types._PLocationTargetedAds, CASATables.Types._Purpose);
		private static final ExecutorFragment _PLocationTargetedAds__PurposeConsent = new ExecutorFragment(Types._PLocationTargetedAds, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PMarketing__OclAny = new ExecutorFragment(Types._PMarketing, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PMarketing__OclElement = new ExecutorFragment(Types._PMarketing, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PMarketing__PMarketing = new ExecutorFragment(Types._PMarketing, CASATables.Types._PMarketing);
		private static final ExecutorFragment _PMarketing__Purpose = new ExecutorFragment(Types._PMarketing, CASATables.Types._Purpose);
		private static final ExecutorFragment _PMarketing__PurposeConsent = new ExecutorFragment(Types._PMarketing, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PP2PStreaming__OclAny = new ExecutorFragment(Types._PP2PStreaming, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PP2PStreaming__OclElement = new ExecutorFragment(Types._PP2PStreaming, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PP2PStreaming__PP2PStreaming = new ExecutorFragment(Types._PP2PStreaming, CASATables.Types._PP2PStreaming);
		private static final ExecutorFragment _PP2PStreaming__PUserExperience = new ExecutorFragment(Types._PP2PStreaming, CASATables.Types._PUserExperience);
		private static final ExecutorFragment _PP2PStreaming__Purpose = new ExecutorFragment(Types._PP2PStreaming, CASATables.Types._Purpose);
		private static final ExecutorFragment _PP2PStreaming__PurposeConsent = new ExecutorFragment(Types._PP2PStreaming, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PProfiling__OclAny = new ExecutorFragment(Types._PProfiling, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PProfiling__OclElement = new ExecutorFragment(Types._PProfiling, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PProfiling__PProfiling = new ExecutorFragment(Types._PProfiling, CASATables.Types._PProfiling);
		private static final ExecutorFragment _PProfiling__Purpose = new ExecutorFragment(Types._PProfiling, CASATables.Types._Purpose);
		private static final ExecutorFragment _PProfiling__PurposeConsent = new ExecutorFragment(Types._PProfiling, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PSocial__OclAny = new ExecutorFragment(Types._PSocial, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PSocial__OclElement = new ExecutorFragment(Types._PSocial, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PSocial__PSocial = new ExecutorFragment(Types._PSocial, CASATables.Types._PSocial);
		private static final ExecutorFragment _PSocial__Purpose = new ExecutorFragment(Types._PSocial, CASATables.Types._Purpose);
		private static final ExecutorFragment _PSocial__PurposeConsent = new ExecutorFragment(Types._PSocial, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PStandardAds__OclAny = new ExecutorFragment(Types._PStandardAds, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PStandardAds__OclElement = new ExecutorFragment(Types._PStandardAds, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PStandardAds__PMarketing = new ExecutorFragment(Types._PStandardAds, CASATables.Types._PMarketing);
		private static final ExecutorFragment _PStandardAds__PStandardAds = new ExecutorFragment(Types._PStandardAds, CASATables.Types._PStandardAds);
		private static final ExecutorFragment _PStandardAds__Purpose = new ExecutorFragment(Types._PStandardAds, CASATables.Types._Purpose);
		private static final ExecutorFragment _PStandardAds__PurposeConsent = new ExecutorFragment(Types._PStandardAds, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PTargetedAds__OclAny = new ExecutorFragment(Types._PTargetedAds, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PTargetedAds__OclElement = new ExecutorFragment(Types._PTargetedAds, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PTargetedAds__PMarketing = new ExecutorFragment(Types._PTargetedAds, CASATables.Types._PMarketing);
		private static final ExecutorFragment _PTargetedAds__PTargetedAds = new ExecutorFragment(Types._PTargetedAds, CASATables.Types._PTargetedAds);
		private static final ExecutorFragment _PTargetedAds__Purpose = new ExecutorFragment(Types._PTargetedAds, CASATables.Types._Purpose);
		private static final ExecutorFragment _PTargetedAds__PurposeConsent = new ExecutorFragment(Types._PTargetedAds, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PThirdPartyProfiling__OclAny = new ExecutorFragment(Types._PThirdPartyProfiling, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PThirdPartyProfiling__OclElement = new ExecutorFragment(Types._PThirdPartyProfiling, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PThirdPartyProfiling__PFirstPartyProfiling = new ExecutorFragment(Types._PThirdPartyProfiling, CASATables.Types._PFirstPartyProfiling);
		private static final ExecutorFragment _PThirdPartyProfiling__PProfiling = new ExecutorFragment(Types._PThirdPartyProfiling, CASATables.Types._PProfiling);
		private static final ExecutorFragment _PThirdPartyProfiling__PThirdPartyProfiling = new ExecutorFragment(Types._PThirdPartyProfiling, CASATables.Types._PThirdPartyProfiling);
		private static final ExecutorFragment _PThirdPartyProfiling__Purpose = new ExecutorFragment(Types._PThirdPartyProfiling, CASATables.Types._Purpose);
		private static final ExecutorFragment _PThirdPartyProfiling__PurposeConsent = new ExecutorFragment(Types._PThirdPartyProfiling, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PUserExperience__OclAny = new ExecutorFragment(Types._PUserExperience, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PUserExperience__OclElement = new ExecutorFragment(Types._PUserExperience, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PUserExperience__PUserExperience = new ExecutorFragment(Types._PUserExperience, CASATables.Types._PUserExperience);
		private static final ExecutorFragment _PUserExperience__Purpose = new ExecutorFragment(Types._PUserExperience, CASATables.Types._Purpose);
		private static final ExecutorFragment _PUserExperience__PurposeConsent = new ExecutorFragment(Types._PUserExperience, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PVideoRecommendation__OclAny = new ExecutorFragment(Types._PVideoRecommendation, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PVideoRecommendation__OclElement = new ExecutorFragment(Types._PVideoRecommendation, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PVideoRecommendation__PUserExperience = new ExecutorFragment(Types._PVideoRecommendation, CASATables.Types._PUserExperience);
		private static final ExecutorFragment _PVideoRecommendation__PVideoRecommendation = new ExecutorFragment(Types._PVideoRecommendation, CASATables.Types._PVideoRecommendation);
		private static final ExecutorFragment _PVideoRecommendation__Purpose = new ExecutorFragment(Types._PVideoRecommendation, CASATables.Types._Purpose);
		private static final ExecutorFragment _PVideoRecommendation__PurposeConsent = new ExecutorFragment(Types._PVideoRecommendation, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PVideoSharing__OclAny = new ExecutorFragment(Types._PVideoSharing, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PVideoSharing__OclElement = new ExecutorFragment(Types._PVideoSharing, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PVideoSharing__PComments = new ExecutorFragment(Types._PVideoSharing, CASATables.Types._PComments);
		private static final ExecutorFragment _PVideoSharing__PSocial = new ExecutorFragment(Types._PVideoSharing, CASATables.Types._PSocial);
		private static final ExecutorFragment _PVideoSharing__PVideoSharing = new ExecutorFragment(Types._PVideoSharing, CASATables.Types._PVideoSharing);
		private static final ExecutorFragment _PVideoSharing__Purpose = new ExecutorFragment(Types._PVideoSharing, CASATables.Types._Purpose);
		private static final ExecutorFragment _PVideoSharing__PurposeConsent = new ExecutorFragment(Types._PVideoSharing, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _Password__Data = new ExecutorFragment(Types._Password, CASATables.Types._Data);
		private static final ExecutorFragment _Password__OclAny = new ExecutorFragment(Types._Password, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Password__OclElement = new ExecutorFragment(Types._Password, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Password__Password = new ExecutorFragment(Types._Password, CASATables.Types._Password);
		private static final ExecutorFragment _Password__PersonalData = new ExecutorFragment(Types._Password, CASATables.Types._PersonalData);

		private static final ExecutorFragment _Payment__Data = new ExecutorFragment(Types._Payment, CASATables.Types._Data);
		private static final ExecutorFragment _Payment__OclAny = new ExecutorFragment(Types._Payment, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Payment__OclElement = new ExecutorFragment(Types._Payment, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Payment__Payment = new ExecutorFragment(Types._Payment, CASATables.Types._Payment);
		private static final ExecutorFragment _Payment__PersonalData = new ExecutorFragment(Types._Payment, CASATables.Types._PersonalData);

		private static final ExecutorFragment _PersonalData__Data = new ExecutorFragment(Types._PersonalData, CASATables.Types._Data);
		private static final ExecutorFragment _PersonalData__OclAny = new ExecutorFragment(Types._PersonalData, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PersonalData__OclElement = new ExecutorFragment(Types._PersonalData, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PersonalData__PersonalData = new ExecutorFragment(Types._PersonalData, CASATables.Types._PersonalData);

		private static final ExecutorFragment _Postgresql__Component = new ExecutorFragment(Types._Postgresql, CASATables.Types._Component);
		private static final ExecutorFragment _Postgresql__OclAny = new ExecutorFragment(Types._Postgresql, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Postgresql__OclElement = new ExecutorFragment(Types._Postgresql, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Postgresql__Postgresql = new ExecutorFragment(Types._Postgresql, CASATables.Types._Postgresql);

		private static final ExecutorFragment _Purpose__OclAny = new ExecutorFragment(Types._Purpose, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Purpose__OclElement = new ExecutorFragment(Types._Purpose, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Purpose__Purpose = new ExecutorFragment(Types._Purpose, CASATables.Types._Purpose);

		private static final ExecutorFragment _PurposeConsent__OclAny = new ExecutorFragment(Types._PurposeConsent, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PurposeConsent__OclElement = new ExecutorFragment(Types._PurposeConsent, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PurposeConsent__Purpose = new ExecutorFragment(Types._PurposeConsent, CASATables.Types._Purpose);
		private static final ExecutorFragment _PurposeConsent__PurposeConsent = new ExecutorFragment(Types._PurposeConsent, CASATables.Types._PurposeConsent);

		private static final ExecutorFragment _PurposeNoConsent__OclAny = new ExecutorFragment(Types._PurposeNoConsent, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PurposeNoConsent__OclElement = new ExecutorFragment(Types._PurposeNoConsent, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PurposeNoConsent__Purpose = new ExecutorFragment(Types._PurposeNoConsent, CASATables.Types._Purpose);
		private static final ExecutorFragment _PurposeNoConsent__PurposeNoConsent = new ExecutorFragment(Types._PurposeNoConsent, CASATables.Types._PurposeNoConsent);

		private static final ExecutorFragment _RecommendVideos__FuncPersData = new ExecutorFragment(Types._RecommendVideos, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _RecommendVideos__Function = new ExecutorFragment(Types._RecommendVideos, CASATables.Types._Function);
		private static final ExecutorFragment _RecommendVideos__OclAny = new ExecutorFragment(Types._RecommendVideos, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _RecommendVideos__OclElement = new ExecutorFragment(Types._RecommendVideos, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _RecommendVideos__RecommendVideos = new ExecutorFragment(Types._RecommendVideos, CASATables.Types._RecommendVideos);

		private static final ExecutorFragment _RedisComponent__Component = new ExecutorFragment(Types._RedisComponent, CASATables.Types._Component);
		private static final ExecutorFragment _RedisComponent__OclAny = new ExecutorFragment(Types._RedisComponent, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _RedisComponent__OclElement = new ExecutorFragment(Types._RedisComponent, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _RedisComponent__RedisComponent = new ExecutorFragment(Types._RedisComponent, CASATables.Types._RedisComponent);

		private static final ExecutorFragment _RemoveVideo__FuncPersData = new ExecutorFragment(Types._RemoveVideo, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _RemoveVideo__Function = new ExecutorFragment(Types._RemoveVideo, CASATables.Types._Function);
		private static final ExecutorFragment _RemoveVideo__OclAny = new ExecutorFragment(Types._RemoveVideo, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _RemoveVideo__OclElement = new ExecutorFragment(Types._RemoveVideo, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _RemoveVideo__RemoveVideo = new ExecutorFragment(Types._RemoveVideo, CASATables.Types._RemoveVideo);

		private static final ExecutorFragment _RequestTimestamps__Data = new ExecutorFragment(Types._RequestTimestamps, CASATables.Types._Data);
		private static final ExecutorFragment _RequestTimestamps__OclAny = new ExecutorFragment(Types._RequestTimestamps, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _RequestTimestamps__OclElement = new ExecutorFragment(Types._RequestTimestamps, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _RequestTimestamps__PersonalData = new ExecutorFragment(Types._RequestTimestamps, CASATables.Types._PersonalData);
		private static final ExecutorFragment _RequestTimestamps__RequestTimestamps = new ExecutorFragment(Types._RequestTimestamps, CASATables.Types._RequestTimestamps);

		private static final ExecutorFragment _Risk__OclAny = new ExecutorFragment(Types._Risk, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Risk__OclElement = new ExecutorFragment(Types._Risk, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Risk__Risk = new ExecutorFragment(Types._Risk, CASATables.Types._Risk);

		private static final ExecutorFragment _ServeBehaviorTargetedAds__FuncPersData = new ExecutorFragment(Types._ServeBehaviorTargetedAds, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _ServeBehaviorTargetedAds__Function = new ExecutorFragment(Types._ServeBehaviorTargetedAds, CASATables.Types._Function);
		private static final ExecutorFragment _ServeBehaviorTargetedAds__OclAny = new ExecutorFragment(Types._ServeBehaviorTargetedAds, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ServeBehaviorTargetedAds__OclElement = new ExecutorFragment(Types._ServeBehaviorTargetedAds, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _ServeBehaviorTargetedAds__ServeBehaviorTargetedAds = new ExecutorFragment(Types._ServeBehaviorTargetedAds, CASATables.Types._ServeBehaviorTargetedAds);

		private static final ExecutorFragment _ServeLocationTargetedAds__FuncPersData = new ExecutorFragment(Types._ServeLocationTargetedAds, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _ServeLocationTargetedAds__Function = new ExecutorFragment(Types._ServeLocationTargetedAds, CASATables.Types._Function);
		private static final ExecutorFragment _ServeLocationTargetedAds__OclAny = new ExecutorFragment(Types._ServeLocationTargetedAds, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ServeLocationTargetedAds__OclElement = new ExecutorFragment(Types._ServeLocationTargetedAds, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _ServeLocationTargetedAds__ServeLocationTargetedAds = new ExecutorFragment(Types._ServeLocationTargetedAds, CASATables.Types._ServeLocationTargetedAds);

		private static final ExecutorFragment _ServeStandardAds__FuncPersData = new ExecutorFragment(Types._ServeStandardAds, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _ServeStandardAds__Function = new ExecutorFragment(Types._ServeStandardAds, CASATables.Types._Function);
		private static final ExecutorFragment _ServeStandardAds__OclAny = new ExecutorFragment(Types._ServeStandardAds, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ServeStandardAds__OclElement = new ExecutorFragment(Types._ServeStandardAds, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _ServeStandardAds__ServeStandardAds = new ExecutorFragment(Types._ServeStandardAds, CASATables.Types._ServeStandardAds);

		private static final ExecutorFragment _StreamVideo__FuncPersData = new ExecutorFragment(Types._StreamVideo, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _StreamVideo__Function = new ExecutorFragment(Types._StreamVideo, CASATables.Types._Function);
		private static final ExecutorFragment _StreamVideo__OclAny = new ExecutorFragment(Types._StreamVideo, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _StreamVideo__OclElement = new ExecutorFragment(Types._StreamVideo, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _StreamVideo__StreamVideo = new ExecutorFragment(Types._StreamVideo, CASATables.Types._StreamVideo);

		private static final ExecutorFragment _StreamingHistory__Data = new ExecutorFragment(Types._StreamingHistory, CASATables.Types._Data);
		private static final ExecutorFragment _StreamingHistory__OclAny = new ExecutorFragment(Types._StreamingHistory, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _StreamingHistory__OclElement = new ExecutorFragment(Types._StreamingHistory, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _StreamingHistory__PersonalData = new ExecutorFragment(Types._StreamingHistory, CASATables.Types._PersonalData);
		private static final ExecutorFragment _StreamingHistory__StreamingHistory = new ExecutorFragment(Types._StreamingHistory, CASATables.Types._StreamingHistory);

		private static final ExecutorFragment _System__OclAny = new ExecutorFragment(Types._System, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _System__OclElement = new ExecutorFragment(Types._System, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _System__System = new ExecutorFragment(Types._System, CASATables.Types._System);

		private static final ExecutorFragment _TrackingCookie__Data = new ExecutorFragment(Types._TrackingCookie, CASATables.Types._Data);
		private static final ExecutorFragment _TrackingCookie__OclAny = new ExecutorFragment(Types._TrackingCookie, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _TrackingCookie__OclElement = new ExecutorFragment(Types._TrackingCookie, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _TrackingCookie__PersonalData = new ExecutorFragment(Types._TrackingCookie, CASATables.Types._PersonalData);
		private static final ExecutorFragment _TrackingCookie__TrackingCookie = new ExecutorFragment(Types._TrackingCookie, CASATables.Types._TrackingCookie);

		private static final ExecutorFragment _UploadVideo__FuncPersData = new ExecutorFragment(Types._UploadVideo, CASATables.Types._FuncPersData);
		private static final ExecutorFragment _UploadVideo__Function = new ExecutorFragment(Types._UploadVideo, CASATables.Types._Function);
		private static final ExecutorFragment _UploadVideo__OclAny = new ExecutorFragment(Types._UploadVideo, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _UploadVideo__OclElement = new ExecutorFragment(Types._UploadVideo, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _UploadVideo__UploadVideo = new ExecutorFragment(Types._UploadVideo, CASATables.Types._UploadVideo);

		private static final ExecutorFragment _User__DataSubject = new ExecutorFragment(Types._User, CASATables.Types._DataSubject);
		private static final ExecutorFragment _User__OclAny = new ExecutorFragment(Types._User, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _User__OclElement = new ExecutorFragment(Types._User, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _User__User = new ExecutorFragment(Types._User, CASATables.Types._User);

		private static final ExecutorFragment _Username__Data = new ExecutorFragment(Types._Username, CASATables.Types._Data);
		private static final ExecutorFragment _Username__OclAny = new ExecutorFragment(Types._Username, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Username__OclElement = new ExecutorFragment(Types._Username, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Username__PersonalData = new ExecutorFragment(Types._Username, CASATables.Types._PersonalData);
		private static final ExecutorFragment _Username__Username = new ExecutorFragment(Types._Username, CASATables.Types._Username);

		private static final ExecutorFragment _VideoComment__Data = new ExecutorFragment(Types._VideoComment, CASATables.Types._Data);
		private static final ExecutorFragment _VideoComment__OclAny = new ExecutorFragment(Types._VideoComment, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _VideoComment__OclElement = new ExecutorFragment(Types._VideoComment, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _VideoComment__PersonalData = new ExecutorFragment(Types._VideoComment, CASATables.Types._PersonalData);
		private static final ExecutorFragment _VideoComment__VideoComment = new ExecutorFragment(Types._VideoComment, CASATables.Types._VideoComment);

		private static final ExecutorFragment _VideoContent__Data = new ExecutorFragment(Types._VideoContent, CASATables.Types._Data);
		private static final ExecutorFragment _VideoContent__OclAny = new ExecutorFragment(Types._VideoContent, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _VideoContent__OclElement = new ExecutorFragment(Types._VideoContent, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _VideoContent__PersonalData = new ExecutorFragment(Types._VideoContent, CASATables.Types._PersonalData);
		private static final ExecutorFragment _VideoContent__VideoContent = new ExecutorFragment(Types._VideoContent, CASATables.Types._VideoContent);

		private static final ExecutorFragment _VideoMetadata__Data = new ExecutorFragment(Types._VideoMetadata, CASATables.Types._Data);
		private static final ExecutorFragment _VideoMetadata__OclAny = new ExecutorFragment(Types._VideoMetadata, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _VideoMetadata__OclElement = new ExecutorFragment(Types._VideoMetadata, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _VideoMetadata__PersonalData = new ExecutorFragment(Types._VideoMetadata, CASATables.Types._PersonalData);
		private static final ExecutorFragment _VideoMetadata__VideoMetadata = new ExecutorFragment(Types._VideoMetadata, CASATables.Types._VideoMetadata);

		private static final ExecutorFragment _Vulnerability__OclAny = new ExecutorFragment(Types._Vulnerability, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Vulnerability__OclElement = new ExecutorFragment(Types._Vulnerability, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Vulnerability__Vulnerability = new ExecutorFragment(Types._Vulnerability, CASATables.Types._Vulnerability);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::Fragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The parameter lists shared by operations.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Parameters {
		static {
			Init.initStart();
			Fragments.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::Parameters and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The operation descriptors for each operation of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Operations {
		static {
			Init.initStart();
			Parameters.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::Operations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The property descriptors for each property of each type.
	 *
	 * @noextend This class is not intended to be subclassed by clients.
	 * @noinstantiate This class is not intended to be instantiated by clients.
	 * @noreference This class is not intended to be referenced by clients.
	 */
	public static class Properties {
		static {
			Init.initStart();
			Operations.init();
		}


		public static final ExecutorProperty _CVSSVector__attackComplexity = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__ATTACK_COMPLEXITY, Types._CVSSVector, 0);
		public static final ExecutorProperty _CVSSVector__attackVector = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__ATTACK_VECTOR, Types._CVSSVector, 1);
		public static final ExecutorProperty _CVSSVector__availabilityImpact = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__AVAILABILITY_IMPACT, Types._CVSSVector, 2);
		public static final ExecutorProperty _CVSSVector__availabilityRequirement = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__AVAILABILITY_REQUIREMENT, Types._CVSSVector, 3);
		public static final ExecutorProperty _CVSSVector__confidentialityImpact = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__CONFIDENTIALITY_IMPACT, Types._CVSSVector, 4);
		public static final ExecutorProperty _CVSSVector__confidentialityRequirement = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT, Types._CVSSVector, 5);
		public static final ExecutorProperty _CVSSVector__exploitCodeMaturity = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__EXPLOIT_CODE_MATURITY, Types._CVSSVector, 6);
		public static final ExecutorProperty _CVSSVector__integrityImpact = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__INTEGRITY_IMPACT, Types._CVSSVector, 7);
		public static final ExecutorProperty _CVSSVector__integrityRequirement = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__INTEGRITY_REQUIREMENT, Types._CVSSVector, 8);
		public static final ExecutorProperty _CVSSVector__privilegesRequired = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__PRIVILEGES_REQUIRED, Types._CVSSVector, 9);
		public static final ExecutorProperty _CVSSVector__remediationLevel = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__REMEDIATION_LEVEL, Types._CVSSVector, 10);
		public static final ExecutorProperty _CVSSVector__reportConfidence = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__REPORT_CONFIDENCE, Types._CVSSVector, 11);
		public static final ExecutorProperty _CVSSVector__scope = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__SCOPE, Types._CVSSVector, 12);
		public static final ExecutorProperty _CVSSVector__userInteraction = new EcoreExecutorProperty(CASAPackage.Literals.CVSS_VECTOR__USER_INTERACTION, Types._CVSSVector, 13);
		public static final ExecutorProperty _CVSSVector__Vulnerability__describedBy = new ExecutorPropertyWithImplementation("Vulnerability", Types._CVSSVector, 14, new EcoreLibraryOppositeProperty(CASAPackage.Literals.VULNERABILITY__DESCRIBED_BY));

		public static final ExecutorProperty _Component__affectedBy = new EcoreExecutorProperty(CASAPackage.Literals.COMPONENT__AFFECTED_BY, Types._Component, 0);
		public static final ExecutorProperty _Component__name = new EcoreExecutorProperty(CASAPackage.Literals.COMPONENT__NAME, Types._Component, 1);
		public static final ExecutorProperty _Component__realizes = new EcoreExecutorProperty(CASAPackage.Literals.COMPONENT__REALIZES, Types._Component, 2);
		public static final ExecutorProperty _Component__System__components = new ExecutorPropertyWithImplementation("System", Types._Component, 3, new EcoreLibraryOppositeProperty(CASAPackage.Literals.SYSTEM__COMPONENTS));

		public static final ExecutorProperty _Consent__forPersonalData = new EcoreExecutorProperty(CASAPackage.Literals.CONSENT__FOR_PERSONAL_DATA, Types._Consent, 0);
		public static final ExecutorProperty _Consent__forPurpose = new EcoreExecutorProperty(CASAPackage.Literals.CONSENT__FOR_PURPOSE, Types._Consent, 1);
		public static final ExecutorProperty _Consent__givenBy = new EcoreExecutorProperty(CASAPackage.Literals.CONSENT__GIVEN_BY, Types._Consent, 2);
		public static final ExecutorProperty _Consent__givenFor = new EcoreExecutorProperty(CASAPackage.Literals.CONSENT__GIVEN_FOR, Types._Consent, 3);
		public static final ExecutorProperty _Consent__informedRiskLevel = new EcoreExecutorProperty(CASAPackage.Literals.CONSENT__INFORMED_RISK_LEVEL, Types._Consent, 4);

		public static final ExecutorProperty _Data__name = new EcoreExecutorProperty(CASAPackage.Literals.DATA__NAME, Types._Data, 0);
		public static final ExecutorProperty _Data__System__datas = new ExecutorPropertyWithImplementation("System", Types._Data, 1, new EcoreLibraryOppositeProperty(CASAPackage.Literals.SYSTEM__DATAS));

		public static final ExecutorProperty _DataSubject__affectedBy = new EcoreExecutorProperty(CASAPackage.Literals.DATA_SUBJECT__AFFECTED_BY, Types._DataSubject, 0);
		public static final ExecutorProperty _DataSubject__gives = new EcoreExecutorProperty(CASAPackage.Literals.DATA_SUBJECT__GIVES, Types._DataSubject, 1);
		public static final ExecutorProperty _DataSubject__identifiedBy = new EcoreExecutorProperty(CASAPackage.Literals.DATA_SUBJECT__IDENTIFIED_BY, Types._DataSubject, 2);
		public static final ExecutorProperty _DataSubject__name = new EcoreExecutorProperty(CASAPackage.Literals.DATA_SUBJECT__NAME, Types._DataSubject, 3);
		public static final ExecutorProperty _DataSubject__System__dataSubjects = new ExecutorPropertyWithImplementation("System", Types._DataSubject, 4, new EcoreLibraryOppositeProperty(CASAPackage.Literals.SYSTEM__DATA_SUBJECTS));

		public static final ExecutorProperty _FuncPersData__has = new EcoreExecutorProperty(CASAPackage.Literals.FUNC_PERS_DATA__HAS, Types._FuncPersData, 0);
		public static final ExecutorProperty _FuncPersData__processesPersData = new EcoreExecutorProperty(CASAPackage.Literals.FUNC_PERS_DATA__PROCESSES_PERS_DATA, Types._FuncPersData, 1);

		public static final ExecutorProperty _Function__name = new EcoreExecutorProperty(CASAPackage.Literals.FUNCTION__NAME, Types._Function, 0);
		public static final ExecutorProperty _Function__processes = new EcoreExecutorProperty(CASAPackage.Literals.FUNCTION__PROCESSES, Types._Function, 1);
		public static final ExecutorProperty _Function__realizedBy = new EcoreExecutorProperty(CASAPackage.Literals.FUNCTION__REALIZED_BY, Types._Function, 2);
		public static final ExecutorProperty _Function__System__functions = new ExecutorPropertyWithImplementation("System", Types._Function, 3, new EcoreLibraryOppositeProperty(CASAPackage.Literals.SYSTEM__FUNCTIONS));

		public static final ExecutorProperty _NonPersonalData__processedBy = new EcoreExecutorProperty(CASAPackage.Literals.NON_PERSONAL_DATA__PROCESSED_BY, Types._NonPersonalData, 0);

		public static final ExecutorProperty _PersonalData__identifies = new EcoreExecutorProperty(CASAPackage.Literals.PERSONAL_DATA__IDENTIFIES, Types._PersonalData, 0);
		public static final ExecutorProperty _PersonalData__processedBy = new EcoreExecutorProperty(CASAPackage.Literals.PERSONAL_DATA__PROCESSED_BY, Types._PersonalData, 1);
		public static final ExecutorProperty _PersonalData__subjectOfConsent = new EcoreExecutorProperty(CASAPackage.Literals.PERSONAL_DATA__SUBJECT_OF_CONSENT, Types._PersonalData, 2);

		public static final ExecutorProperty _Purpose__name = new EcoreExecutorProperty(CASAPackage.Literals.PURPOSE__NAME, Types._Purpose, 0);
		public static final ExecutorProperty _Purpose__ofFunction = new EcoreExecutorProperty(CASAPackage.Literals.PURPOSE__OF_FUNCTION, Types._Purpose, 1);
		public static final ExecutorProperty _Purpose__System__purposes = new ExecutorPropertyWithImplementation("System", Types._Purpose, 2, new EcoreLibraryOppositeProperty(CASAPackage.Literals.SYSTEM__PURPOSES));

		public static final ExecutorProperty _PurposeConsent__requires = new EcoreExecutorProperty(CASAPackage.Literals.PURPOSE_CONSENT__REQUIRES, Types._PurposeConsent, 0);

		public static final ExecutorProperty _Risk__affects = new EcoreExecutorProperty(CASAPackage.Literals.RISK__AFFECTS, Types._Risk, 0);
		public static final ExecutorProperty _Risk__causedBy = new EcoreExecutorProperty(CASAPackage.Literals.RISK__CAUSED_BY, Types._Risk, 1);
		public static final ExecutorProperty _Risk__level = new EcoreExecutorProperty(CASAPackage.Literals.RISK__LEVEL, Types._Risk, 2);

		public static final ExecutorProperty _System__components = new EcoreExecutorProperty(CASAPackage.Literals.SYSTEM__COMPONENTS, Types._System, 0);
		public static final ExecutorProperty _System__dataSubjects = new EcoreExecutorProperty(CASAPackage.Literals.SYSTEM__DATA_SUBJECTS, Types._System, 1);
		public static final ExecutorProperty _System__datas = new EcoreExecutorProperty(CASAPackage.Literals.SYSTEM__DATAS, Types._System, 2);
		public static final ExecutorProperty _System__functions = new EcoreExecutorProperty(CASAPackage.Literals.SYSTEM__FUNCTIONS, Types._System, 3);
		public static final ExecutorProperty _System__purposes = new EcoreExecutorProperty(CASAPackage.Literals.SYSTEM__PURPOSES, Types._System, 4);
		public static final ExecutorProperty _System__vulnerabilities = new EcoreExecutorProperty(CASAPackage.Literals.SYSTEM__VULNERABILITIES, Types._System, 5);

		public static final ExecutorProperty _Vulnerability__affects = new EcoreExecutorProperty(CASAPackage.Literals.VULNERABILITY__AFFECTS, Types._Vulnerability, 0);
		public static final ExecutorProperty _Vulnerability__causes = new EcoreExecutorProperty(CASAPackage.Literals.VULNERABILITY__CAUSES, Types._Vulnerability, 1);
		public static final ExecutorProperty _Vulnerability__cveName = new EcoreExecutorProperty(CASAPackage.Literals.VULNERABILITY__CVE_NAME, Types._Vulnerability, 2);
		public static final ExecutorProperty _Vulnerability__describedBy = new EcoreExecutorProperty(CASAPackage.Literals.VULNERABILITY__DESCRIBED_BY, Types._Vulnerability, 3);
		public static final ExecutorProperty _Vulnerability__isEnabled = new EcoreExecutorProperty(CASAPackage.Literals.VULNERABILITY__IS_ENABLED, Types._Vulnerability, 4);
		public static final ExecutorProperty _Vulnerability__System__vulnerabilities = new ExecutorPropertyWithImplementation("System", Types._Vulnerability, 5, new EcoreLibraryOppositeProperty(CASAPackage.Literals.SYSTEM__VULNERABILITIES));
		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::Properties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The fragments for all base types in depth order: OclAny first, OclSelf last.
	 */
	public static class TypeFragments {
		static {
			Init.initStart();
			Properties.init();
		}

		private static final ExecutorFragment /*@NonNull*/ [] _Administrator =
			{
				Fragments._Administrator__OclAny /* 0 */,
				Fragments._Administrator__OclElement /* 1 */,
				Fragments._Administrator__DataSubject /* 2 */,
				Fragments._Administrator__Administrator /* 3 */
			};
		private static final int /*@NonNull*/ [] __Administrator = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _AngularSPA =
			{
				Fragments._AngularSPA__OclAny /* 0 */,
				Fragments._AngularSPA__OclElement /* 1 */,
				Fragments._AngularSPA__Component /* 2 */,
				Fragments._AngularSPA__AngularSPA /* 3 */
			};
		private static final int /*@NonNull*/ [] __AngularSPA = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2018_16843 =
			{
				Fragments._CVE_2018_16843__OclAny /* 0 */,
				Fragments._CVE_2018_16843__OclElement /* 1 */,
				Fragments._CVE_2018_16843__Vulnerability /* 2 */,
				Fragments._CVE_2018_16843__CVE_2018_16843 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2018_16843 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2018_16844 =
			{
				Fragments._CVE_2018_16844__OclAny /* 0 */,
				Fragments._CVE_2018_16844__OclElement /* 1 */,
				Fragments._CVE_2018_16844__Vulnerability /* 2 */,
				Fragments._CVE_2018_16844__CVE_2018_16844 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2018_16844 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2018_16845 =
			{
				Fragments._CVE_2018_16845__OclAny /* 0 */,
				Fragments._CVE_2018_16845__OclElement /* 1 */,
				Fragments._CVE_2018_16845__Vulnerability /* 2 */,
				Fragments._CVE_2018_16845__CVE_2018_16845 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2018_16845 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2019_9511 =
			{
				Fragments._CVE_2019_9511__OclAny /* 0 */,
				Fragments._CVE_2019_9511__OclElement /* 1 */,
				Fragments._CVE_2019_9511__Vulnerability /* 2 */,
				Fragments._CVE_2019_9511__CVE_2019_9511 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2019_9511 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2019_9513 =
			{
				Fragments._CVE_2019_9513__OclAny /* 0 */,
				Fragments._CVE_2019_9513__OclElement /* 1 */,
				Fragments._CVE_2019_9513__Vulnerability /* 2 */,
				Fragments._CVE_2019_9513__CVE_2019_9513 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2019_9513 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2019_9516 =
			{
				Fragments._CVE_2019_9516__OclAny /* 0 */,
				Fragments._CVE_2019_9516__OclElement /* 1 */,
				Fragments._CVE_2019_9516__Vulnerability /* 2 */,
				Fragments._CVE_2019_9516__CVE_2019_9516 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2019_9516 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2021_23017 =
			{
				Fragments._CVE_2021_23017__OclAny /* 0 */,
				Fragments._CVE_2021_23017__OclElement /* 1 */,
				Fragments._CVE_2021_23017__Vulnerability /* 2 */,
				Fragments._CVE_2021_23017__CVE_2021_23017 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2021_23017 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2021_3618 =
			{
				Fragments._CVE_2021_3618__OclAny /* 0 */,
				Fragments._CVE_2021_3618__OclElement /* 1 */,
				Fragments._CVE_2021_3618__Vulnerability /* 2 */,
				Fragments._CVE_2021_3618__CVE_2021_3618 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2021_3618 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2022_24834 =
			{
				Fragments._CVE_2022_24834__OclAny /* 0 */,
				Fragments._CVE_2022_24834__OclElement /* 1 */,
				Fragments._CVE_2022_24834__Vulnerability /* 2 */,
				Fragments._CVE_2022_24834__CVE_2022_24834 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2022_24834 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2022_36021 =
			{
				Fragments._CVE_2022_36021__OclAny /* 0 */,
				Fragments._CVE_2022_36021__OclElement /* 1 */,
				Fragments._CVE_2022_36021__Vulnerability /* 2 */,
				Fragments._CVE_2022_36021__CVE_2022_36021 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2022_36021 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2022_41862 =
			{
				Fragments._CVE_2022_41862__OclAny /* 0 */,
				Fragments._CVE_2022_41862__OclElement /* 1 */,
				Fragments._CVE_2022_41862__Vulnerability /* 2 */,
				Fragments._CVE_2022_41862__CVE_2022_41862 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2022_41862 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2023_2455 =
			{
				Fragments._CVE_2023_2455__OclAny /* 0 */,
				Fragments._CVE_2023_2455__OclElement /* 1 */,
				Fragments._CVE_2023_2455__Vulnerability /* 2 */,
				Fragments._CVE_2023_2455__CVE_2023_2455 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2023_2455 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2023_25155 =
			{
				Fragments._CVE_2023_25155__OclAny /* 0 */,
				Fragments._CVE_2023_25155__OclElement /* 1 */,
				Fragments._CVE_2023_25155__Vulnerability /* 2 */,
				Fragments._CVE_2023_25155__CVE_2023_25155 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2023_25155 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2023_28856 =
			{
				Fragments._CVE_2023_28856__OclAny /* 0 */,
				Fragments._CVE_2023_28856__OclElement /* 1 */,
				Fragments._CVE_2023_28856__Vulnerability /* 2 */,
				Fragments._CVE_2023_28856__CVE_2023_28856 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2023_28856 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2023_44487 =
			{
				Fragments._CVE_2023_44487__OclAny /* 0 */,
				Fragments._CVE_2023_44487__OclElement /* 1 */,
				Fragments._CVE_2023_44487__Vulnerability /* 2 */,
				Fragments._CVE_2023_44487__CVE_2023_44487 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2023_44487 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2023_45145 =
			{
				Fragments._CVE_2023_45145__OclAny /* 0 */,
				Fragments._CVE_2023_45145__OclElement /* 1 */,
				Fragments._CVE_2023_45145__Vulnerability /* 2 */,
				Fragments._CVE_2023_45145__CVE_2023_45145 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2023_45145 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2023_46809 =
			{
				Fragments._CVE_2023_46809__OclAny /* 0 */,
				Fragments._CVE_2023_46809__OclElement /* 1 */,
				Fragments._CVE_2023_46809__Vulnerability /* 2 */,
				Fragments._CVE_2023_46809__CVE_2023_46809 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2023_46809 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2023_5870 =
			{
				Fragments._CVE_2023_5870__OclAny /* 0 */,
				Fragments._CVE_2023_5870__OclElement /* 1 */,
				Fragments._CVE_2023_5870__Vulnerability /* 2 */,
				Fragments._CVE_2023_5870__CVE_2023_5870 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2023_5870 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_0985 =
			{
				Fragments._CVE_2024_0985__OclAny /* 0 */,
				Fragments._CVE_2024_0985__OclElement /* 1 */,
				Fragments._CVE_2024_0985__Vulnerability /* 2 */,
				Fragments._CVE_2024_0985__CVE_2024_0985 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_0985 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_10976 =
			{
				Fragments._CVE_2024_10976__OclAny /* 0 */,
				Fragments._CVE_2024_10976__OclElement /* 1 */,
				Fragments._CVE_2024_10976__Vulnerability /* 2 */,
				Fragments._CVE_2024_10976__CVE_2024_10976 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_10976 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_10977 =
			{
				Fragments._CVE_2024_10977__OclAny /* 0 */,
				Fragments._CVE_2024_10977__OclElement /* 1 */,
				Fragments._CVE_2024_10977__Vulnerability /* 2 */,
				Fragments._CVE_2024_10977__CVE_2024_10977 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_10977 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_10978 =
			{
				Fragments._CVE_2024_10978__OclAny /* 0 */,
				Fragments._CVE_2024_10978__OclElement /* 1 */,
				Fragments._CVE_2024_10978__Vulnerability /* 2 */,
				Fragments._CVE_2024_10978__CVE_2024_10978 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_10978 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_10979 =
			{
				Fragments._CVE_2024_10979__OclAny /* 0 */,
				Fragments._CVE_2024_10979__OclElement /* 1 */,
				Fragments._CVE_2024_10979__Vulnerability /* 2 */,
				Fragments._CVE_2024_10979__CVE_2024_10979 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_10979 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_21890 =
			{
				Fragments._CVE_2024_21890__OclAny /* 0 */,
				Fragments._CVE_2024_21890__OclElement /* 1 */,
				Fragments._CVE_2024_21890__Vulnerability /* 2 */,
				Fragments._CVE_2024_21890__CVE_2024_21890 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_21890 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_21891 =
			{
				Fragments._CVE_2024_21891__OclAny /* 0 */,
				Fragments._CVE_2024_21891__OclElement /* 1 */,
				Fragments._CVE_2024_21891__Vulnerability /* 2 */,
				Fragments._CVE_2024_21891__CVE_2024_21891 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_21891 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_21896 =
			{
				Fragments._CVE_2024_21896__OclAny /* 0 */,
				Fragments._CVE_2024_21896__OclElement /* 1 */,
				Fragments._CVE_2024_21896__Vulnerability /* 2 */,
				Fragments._CVE_2024_21896__CVE_2024_21896 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_21896 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_22017 =
			{
				Fragments._CVE_2024_22017__OclAny /* 0 */,
				Fragments._CVE_2024_22017__OclElement /* 1 */,
				Fragments._CVE_2024_22017__Vulnerability /* 2 */,
				Fragments._CVE_2024_22017__CVE_2024_22017 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_22017 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_22018 =
			{
				Fragments._CVE_2024_22018__OclAny /* 0 */,
				Fragments._CVE_2024_22018__OclElement /* 1 */,
				Fragments._CVE_2024_22018__Vulnerability /* 2 */,
				Fragments._CVE_2024_22018__CVE_2024_22018 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_22018 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_22019 =
			{
				Fragments._CVE_2024_22019__OclAny /* 0 */,
				Fragments._CVE_2024_22019__OclElement /* 1 */,
				Fragments._CVE_2024_22019__Vulnerability /* 2 */,
				Fragments._CVE_2024_22019__CVE_2024_22019 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_22019 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_22020 =
			{
				Fragments._CVE_2024_22020__OclAny /* 0 */,
				Fragments._CVE_2024_22020__OclElement /* 1 */,
				Fragments._CVE_2024_22020__Vulnerability /* 2 */,
				Fragments._CVE_2024_22020__CVE_2024_22020 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_22020 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_22025 =
			{
				Fragments._CVE_2024_22025__OclAny /* 0 */,
				Fragments._CVE_2024_22025__OclElement /* 1 */,
				Fragments._CVE_2024_22025__Vulnerability /* 2 */,
				Fragments._CVE_2024_22025__CVE_2024_22025 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_22025 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_27980 =
			{
				Fragments._CVE_2024_27980__OclAny /* 0 */,
				Fragments._CVE_2024_27980__OclElement /* 1 */,
				Fragments._CVE_2024_27980__Vulnerability /* 2 */,
				Fragments._CVE_2024_27980__CVE_2024_27980 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_27980 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_27983 =
			{
				Fragments._CVE_2024_27983__OclAny /* 0 */,
				Fragments._CVE_2024_27983__OclElement /* 1 */,
				Fragments._CVE_2024_27983__Vulnerability /* 2 */,
				Fragments._CVE_2024_27983__CVE_2024_27983 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_27983 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_31449 =
			{
				Fragments._CVE_2024_31449__OclAny /* 0 */,
				Fragments._CVE_2024_31449__OclElement /* 1 */,
				Fragments._CVE_2024_31449__Vulnerability /* 2 */,
				Fragments._CVE_2024_31449__CVE_2024_31449 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_31449 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_31489 =
			{
				Fragments._CVE_2024_31489__OclAny /* 0 */,
				Fragments._CVE_2024_31489__OclElement /* 1 */,
				Fragments._CVE_2024_31489__Vulnerability /* 2 */,
				Fragments._CVE_2024_31489__CVE_2024_31489 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_31489 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_3566 =
			{
				Fragments._CVE_2024_3566__OclAny /* 0 */,
				Fragments._CVE_2024_3566__OclElement /* 1 */,
				Fragments._CVE_2024_3566__Vulnerability /* 2 */,
				Fragments._CVE_2024_3566__CVE_2024_3566 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_3566 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_36137 =
			{
				Fragments._CVE_2024_36137__OclAny /* 0 */,
				Fragments._CVE_2024_36137__OclElement /* 1 */,
				Fragments._CVE_2024_36137__Vulnerability /* 2 */,
				Fragments._CVE_2024_36137__CVE_2024_36137 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_36137 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_36138 =
			{
				Fragments._CVE_2024_36138__OclAny /* 0 */,
				Fragments._CVE_2024_36138__OclElement /* 1 */,
				Fragments._CVE_2024_36138__Vulnerability /* 2 */,
				Fragments._CVE_2024_36138__CVE_2024_36138 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_36138 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_37372 =
			{
				Fragments._CVE_2024_37372__OclAny /* 0 */,
				Fragments._CVE_2024_37372__OclElement /* 1 */,
				Fragments._CVE_2024_37372__Vulnerability /* 2 */,
				Fragments._CVE_2024_37372__CVE_2024_37372 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_37372 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_46981 =
			{
				Fragments._CVE_2024_46981__OclAny /* 0 */,
				Fragments._CVE_2024_46981__OclElement /* 1 */,
				Fragments._CVE_2024_46981__Vulnerability /* 2 */,
				Fragments._CVE_2024_46981__CVE_2024_46981 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_46981 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_5205 =
			{
				Fragments._CVE_2024_5205__OclAny /* 0 */,
				Fragments._CVE_2024_5205__OclElement /* 1 */,
				Fragments._CVE_2024_5205__Vulnerability /* 2 */,
				Fragments._CVE_2024_5205__CVE_2024_5205 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_5205 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_7347 =
			{
				Fragments._CVE_2024_7347__OclAny /* 0 */,
				Fragments._CVE_2024_7347__OclElement /* 1 */,
				Fragments._CVE_2024_7347__Vulnerability /* 2 */,
				Fragments._CVE_2024_7347__CVE_2024_7347 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_7347 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2024_7348 =
			{
				Fragments._CVE_2024_7348__OclAny /* 0 */,
				Fragments._CVE_2024_7348__OclElement /* 1 */,
				Fragments._CVE_2024_7348__Vulnerability /* 2 */,
				Fragments._CVE_2024_7348__CVE_2024_7348 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2024_7348 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_1094 =
			{
				Fragments._CVE_2025_1094__OclAny /* 0 */,
				Fragments._CVE_2025_1094__OclElement /* 1 */,
				Fragments._CVE_2025_1094__Vulnerability /* 2 */,
				Fragments._CVE_2025_1094__CVE_2025_1094 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_1094 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_11187 =
			{
				Fragments._CVE_2025_11187__OclAny /* 0 */,
				Fragments._CVE_2025_11187__OclElement /* 1 */,
				Fragments._CVE_2025_11187__Vulnerability /* 2 */,
				Fragments._CVE_2025_11187__CVE_2025_11187 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_11187 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_15468 =
			{
				Fragments._CVE_2025_15468__OclAny /* 0 */,
				Fragments._CVE_2025_15468__OclElement /* 1 */,
				Fragments._CVE_2025_15468__Vulnerability /* 2 */,
				Fragments._CVE_2025_15468__CVE_2025_15468 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_15468 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_21605 =
			{
				Fragments._CVE_2025_21605__OclAny /* 0 */,
				Fragments._CVE_2025_21605__OclElement /* 1 */,
				Fragments._CVE_2025_21605__Vulnerability /* 2 */,
				Fragments._CVE_2025_21605__CVE_2025_21605 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_21605 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_23084 =
			{
				Fragments._CVE_2025_23084__OclAny /* 0 */,
				Fragments._CVE_2025_23084__OclElement /* 1 */,
				Fragments._CVE_2025_23084__Vulnerability /* 2 */,
				Fragments._CVE_2025_23084__CVE_2025_23084 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_23084 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_23090 =
			{
				Fragments._CVE_2025_23090__OclAny /* 0 */,
				Fragments._CVE_2025_23090__OclElement /* 1 */,
				Fragments._CVE_2025_23090__Vulnerability /* 2 */,
				Fragments._CVE_2025_23090__CVE_2025_23090 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_23090 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_32023 =
			{
				Fragments._CVE_2025_32023__OclAny /* 0 */,
				Fragments._CVE_2025_32023__OclElement /* 1 */,
				Fragments._CVE_2025_32023__Vulnerability /* 2 */,
				Fragments._CVE_2025_32023__CVE_2025_32023 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_32023 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_62506 =
			{
				Fragments._CVE_2025_62506__OclAny /* 0 */,
				Fragments._CVE_2025_62506__OclElement /* 1 */,
				Fragments._CVE_2025_62506__Vulnerability /* 2 */,
				Fragments._CVE_2025_62506__CVE_2025_62506 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_62506 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_62507 =
			{
				Fragments._CVE_2025_62507__OclAny /* 0 */,
				Fragments._CVE_2025_62507__OclElement /* 1 */,
				Fragments._CVE_2025_62507__Vulnerability /* 2 */,
				Fragments._CVE_2025_62507__CVE_2025_62507 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_62507 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_66199 =
			{
				Fragments._CVE_2025_66199__OclAny /* 0 */,
				Fragments._CVE_2025_66199__OclElement /* 1 */,
				Fragments._CVE_2025_66199__Vulnerability /* 2 */,
				Fragments._CVE_2025_66199__CVE_2025_66199 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_66199 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_69418 =
			{
				Fragments._CVE_2025_69418__OclAny /* 0 */,
				Fragments._CVE_2025_69418__OclElement /* 1 */,
				Fragments._CVE_2025_69418__Vulnerability /* 2 */,
				Fragments._CVE_2025_69418__CVE_2025_69418 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_69418 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_69420 =
			{
				Fragments._CVE_2025_69420__OclAny /* 0 */,
				Fragments._CVE_2025_69420__OclElement /* 1 */,
				Fragments._CVE_2025_69420__Vulnerability /* 2 */,
				Fragments._CVE_2025_69420__CVE_2025_69420 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_69420 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2025_69421 =
			{
				Fragments._CVE_2025_69421__OclAny /* 0 */,
				Fragments._CVE_2025_69421__OclElement /* 1 */,
				Fragments._CVE_2025_69421__Vulnerability /* 2 */,
				Fragments._CVE_2025_69421__CVE_2025_69421 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2025_69421 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2026_22795 =
			{
				Fragments._CVE_2026_22795__OclAny /* 0 */,
				Fragments._CVE_2026_22795__OclElement /* 1 */,
				Fragments._CVE_2026_22795__Vulnerability /* 2 */,
				Fragments._CVE_2026_22795__CVE_2026_22795 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2026_22795 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2026_22796 =
			{
				Fragments._CVE_2026_22796__OclAny /* 0 */,
				Fragments._CVE_2026_22796__OclElement /* 1 */,
				Fragments._CVE_2026_22796__Vulnerability /* 2 */,
				Fragments._CVE_2026_22796__CVE_2026_22796 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2026_22796 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVE_2026_27970 =
			{
				Fragments._CVE_2026_27970__OclAny /* 0 */,
				Fragments._CVE_2026_27970__OclElement /* 1 */,
				Fragments._CVE_2026_27970__Vulnerability /* 2 */,
				Fragments._CVE_2026_27970__CVE_2026_27970 /* 3 */
			};
		private static final int /*@NonNull*/ [] __CVE_2026_27970 = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CVSSVector =
			{
				Fragments._CVSSVector__OclAny /* 0 */,
				Fragments._CVSSVector__OclElement /* 1 */,
				Fragments._CVSSVector__CVSSVector /* 2 */
			};
		private static final int /*@NonNull*/ [] __CVSSVector = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _CommentWriteRead =
			{
				Fragments._CommentWriteRead__OclAny /* 0 */,
				Fragments._CommentWriteRead__OclElement /* 1 */,
				Fragments._CommentWriteRead__Function /* 2 */,
				Fragments._CommentWriteRead__FuncPersData /* 3 */,
				Fragments._CommentWriteRead__CommentWriteRead /* 4 */
			};
		private static final int /*@NonNull*/ [] __CommentWriteRead = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Component =
			{
				Fragments._Component__OclAny /* 0 */,
				Fragments._Component__OclElement /* 1 */,
				Fragments._Component__Component /* 2 */
			};
		private static final int /*@NonNull*/ [] __Component = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Consent =
			{
				Fragments._Consent__OclAny /* 0 */,
				Fragments._Consent__OclElement /* 1 */,
				Fragments._Consent__Consent /* 2 */
			};
		private static final int /*@NonNull*/ [] __Consent = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Data =
			{
				Fragments._Data__OclAny /* 0 */,
				Fragments._Data__OclElement /* 1 */,
				Fragments._Data__Data /* 2 */
			};
		private static final int /*@NonNull*/ [] __Data = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _DataSubject =
			{
				Fragments._DataSubject__OclAny /* 0 */,
				Fragments._DataSubject__OclElement /* 1 */,
				Fragments._DataSubject__DataSubject /* 2 */
			};
		private static final int /*@NonNull*/ [] __DataSubject = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _DeviceLocation =
			{
				Fragments._DeviceLocation__OclAny /* 0 */,
				Fragments._DeviceLocation__OclElement /* 1 */,
				Fragments._DeviceLocation__Data /* 2 */,
				Fragments._DeviceLocation__PersonalData /* 3 */,
				Fragments._DeviceLocation__DeviceLocation /* 4 */
			};
		private static final int /*@NonNull*/ [] __DeviceLocation = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _DeviceType =
			{
				Fragments._DeviceType__OclAny /* 0 */,
				Fragments._DeviceType__OclElement /* 1 */,
				Fragments._DeviceType__Data /* 2 */,
				Fragments._DeviceType__PersonalData /* 3 */,
				Fragments._DeviceType__DeviceType /* 4 */
			};
		private static final int /*@NonNull*/ [] __DeviceType = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _EmailAddress =
			{
				Fragments._EmailAddress__OclAny /* 0 */,
				Fragments._EmailAddress__OclElement /* 1 */,
				Fragments._EmailAddress__Data /* 2 */,
				Fragments._EmailAddress__PersonalData /* 3 */,
				Fragments._EmailAddress__EmailAddress /* 4 */
			};
		private static final int /*@NonNull*/ [] __EmailAddress = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ExpressJS =
			{
				Fragments._ExpressJS__OclAny /* 0 */,
				Fragments._ExpressJS__OclElement /* 1 */,
				Fragments._ExpressJS__Component /* 2 */,
				Fragments._ExpressJS__ExpressJS /* 3 */
			};
		private static final int /*@NonNull*/ [] __ExpressJS = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _FilesystemComponent =
			{
				Fragments._FilesystemComponent__OclAny /* 0 */,
				Fragments._FilesystemComponent__OclElement /* 1 */,
				Fragments._FilesystemComponent__Component /* 2 */,
				Fragments._FilesystemComponent__FilesystemComponent /* 3 */
			};
		private static final int /*@NonNull*/ [] __FilesystemComponent = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _FuncPersData =
			{
				Fragments._FuncPersData__OclAny /* 0 */,
				Fragments._FuncPersData__OclElement /* 1 */,
				Fragments._FuncPersData__Function /* 2 */,
				Fragments._FuncPersData__FuncPersData /* 3 */
			};
		private static final int /*@NonNull*/ [] __FuncPersData = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Function =
			{
				Fragments._Function__OclAny /* 0 */,
				Fragments._Function__OclElement /* 1 */,
				Fragments._Function__Function /* 2 */
			};
		private static final int /*@NonNull*/ [] __Function = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _LiveStreamVideo =
			{
				Fragments._LiveStreamVideo__OclAny /* 0 */,
				Fragments._LiveStreamVideo__OclElement /* 1 */,
				Fragments._LiveStreamVideo__Function /* 2 */,
				Fragments._LiveStreamVideo__FuncPersData /* 3 */,
				Fragments._LiveStreamVideo__LiveStreamVideo /* 4 */
			};
		private static final int /*@NonNull*/ [] __LiveStreamVideo = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Moderator =
			{
				Fragments._Moderator__OclAny /* 0 */,
				Fragments._Moderator__OclElement /* 1 */,
				Fragments._Moderator__DataSubject /* 2 */,
				Fragments._Moderator__Moderator /* 3 */
			};
		private static final int /*@NonNull*/ [] __Moderator = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Nginx =
			{
				Fragments._Nginx__OclAny /* 0 */,
				Fragments._Nginx__OclElement /* 1 */,
				Fragments._Nginx__Component /* 2 */,
				Fragments._Nginx__Nginx /* 3 */
			};
		private static final int /*@NonNull*/ [] __Nginx = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _NonPersonalData =
			{
				Fragments._NonPersonalData__OclAny /* 0 */,
				Fragments._NonPersonalData__OclElement /* 1 */,
				Fragments._NonPersonalData__Data /* 2 */,
				Fragments._NonPersonalData__NonPersonalData /* 3 */
			};
		private static final int /*@NonNull*/ [] __NonPersonalData = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _P2PStreaming =
			{
				Fragments._P2PStreaming__OclAny /* 0 */,
				Fragments._P2PStreaming__OclElement /* 1 */,
				Fragments._P2PStreaming__Function /* 2 */,
				Fragments._P2PStreaming__FuncPersData /* 3 */,
				Fragments._P2PStreaming__P2PStreaming /* 4 */
			};
		private static final int /*@NonNull*/ [] __P2PStreaming = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PBehaviorTargetedAds =
			{
				Fragments._PBehaviorTargetedAds__OclAny /* 0 */,
				Fragments._PBehaviorTargetedAds__OclElement /* 1 */,
				Fragments._PBehaviorTargetedAds__Purpose /* 2 */,
				Fragments._PBehaviorTargetedAds__PurposeConsent /* 3 */,
				Fragments._PBehaviorTargetedAds__PMarketing /* 4 */,
				Fragments._PBehaviorTargetedAds__PTargetedAds /* 5 */,
				Fragments._PBehaviorTargetedAds__PBehaviorTargetedAds /* 6 */
			};
		private static final int /*@NonNull*/ [] __PBehaviorTargetedAds = { 1,1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PComments =
			{
				Fragments._PComments__OclAny /* 0 */,
				Fragments._PComments__OclElement /* 1 */,
				Fragments._PComments__Purpose /* 2 */,
				Fragments._PComments__PurposeConsent /* 3 */,
				Fragments._PComments__PSocial /* 4 */,
				Fragments._PComments__PComments /* 5 */
			};
		private static final int /*@NonNull*/ [] __PComments = { 1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PFirstPartyProfiling =
			{
				Fragments._PFirstPartyProfiling__OclAny /* 0 */,
				Fragments._PFirstPartyProfiling__OclElement /* 1 */,
				Fragments._PFirstPartyProfiling__Purpose /* 2 */,
				Fragments._PFirstPartyProfiling__PurposeConsent /* 3 */,
				Fragments._PFirstPartyProfiling__PProfiling /* 4 */,
				Fragments._PFirstPartyProfiling__PFirstPartyProfiling /* 5 */
			};
		private static final int /*@NonNull*/ [] __PFirstPartyProfiling = { 1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PLocationTargetedAds =
			{
				Fragments._PLocationTargetedAds__OclAny /* 0 */,
				Fragments._PLocationTargetedAds__OclElement /* 1 */,
				Fragments._PLocationTargetedAds__Purpose /* 2 */,
				Fragments._PLocationTargetedAds__PurposeConsent /* 3 */,
				Fragments._PLocationTargetedAds__PMarketing /* 4 */,
				Fragments._PLocationTargetedAds__PTargetedAds /* 5 */,
				Fragments._PLocationTargetedAds__PLocationTargetedAds /* 6 */
			};
		private static final int /*@NonNull*/ [] __PLocationTargetedAds = { 1,1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PMarketing =
			{
				Fragments._PMarketing__OclAny /* 0 */,
				Fragments._PMarketing__OclElement /* 1 */,
				Fragments._PMarketing__Purpose /* 2 */,
				Fragments._PMarketing__PurposeConsent /* 3 */,
				Fragments._PMarketing__PMarketing /* 4 */
			};
		private static final int /*@NonNull*/ [] __PMarketing = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PP2PStreaming =
			{
				Fragments._PP2PStreaming__OclAny /* 0 */,
				Fragments._PP2PStreaming__OclElement /* 1 */,
				Fragments._PP2PStreaming__Purpose /* 2 */,
				Fragments._PP2PStreaming__PurposeConsent /* 3 */,
				Fragments._PP2PStreaming__PUserExperience /* 4 */,
				Fragments._PP2PStreaming__PP2PStreaming /* 5 */
			};
		private static final int /*@NonNull*/ [] __PP2PStreaming = { 1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PProfiling =
			{
				Fragments._PProfiling__OclAny /* 0 */,
				Fragments._PProfiling__OclElement /* 1 */,
				Fragments._PProfiling__Purpose /* 2 */,
				Fragments._PProfiling__PurposeConsent /* 3 */,
				Fragments._PProfiling__PProfiling /* 4 */
			};
		private static final int /*@NonNull*/ [] __PProfiling = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PSocial =
			{
				Fragments._PSocial__OclAny /* 0 */,
				Fragments._PSocial__OclElement /* 1 */,
				Fragments._PSocial__Purpose /* 2 */,
				Fragments._PSocial__PurposeConsent /* 3 */,
				Fragments._PSocial__PSocial /* 4 */
			};
		private static final int /*@NonNull*/ [] __PSocial = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PStandardAds =
			{
				Fragments._PStandardAds__OclAny /* 0 */,
				Fragments._PStandardAds__OclElement /* 1 */,
				Fragments._PStandardAds__Purpose /* 2 */,
				Fragments._PStandardAds__PurposeConsent /* 3 */,
				Fragments._PStandardAds__PMarketing /* 4 */,
				Fragments._PStandardAds__PStandardAds /* 5 */
			};
		private static final int /*@NonNull*/ [] __PStandardAds = { 1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PTargetedAds =
			{
				Fragments._PTargetedAds__OclAny /* 0 */,
				Fragments._PTargetedAds__OclElement /* 1 */,
				Fragments._PTargetedAds__Purpose /* 2 */,
				Fragments._PTargetedAds__PurposeConsent /* 3 */,
				Fragments._PTargetedAds__PMarketing /* 4 */,
				Fragments._PTargetedAds__PTargetedAds /* 5 */
			};
		private static final int /*@NonNull*/ [] __PTargetedAds = { 1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PThirdPartyProfiling =
			{
				Fragments._PThirdPartyProfiling__OclAny /* 0 */,
				Fragments._PThirdPartyProfiling__OclElement /* 1 */,
				Fragments._PThirdPartyProfiling__Purpose /* 2 */,
				Fragments._PThirdPartyProfiling__PurposeConsent /* 3 */,
				Fragments._PThirdPartyProfiling__PProfiling /* 4 */,
				Fragments._PThirdPartyProfiling__PFirstPartyProfiling /* 5 */,
				Fragments._PThirdPartyProfiling__PThirdPartyProfiling /* 6 */
			};
		private static final int /*@NonNull*/ [] __PThirdPartyProfiling = { 1,1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PUserExperience =
			{
				Fragments._PUserExperience__OclAny /* 0 */,
				Fragments._PUserExperience__OclElement /* 1 */,
				Fragments._PUserExperience__Purpose /* 2 */,
				Fragments._PUserExperience__PurposeConsent /* 3 */,
				Fragments._PUserExperience__PUserExperience /* 4 */
			};
		private static final int /*@NonNull*/ [] __PUserExperience = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PVideoRecommendation =
			{
				Fragments._PVideoRecommendation__OclAny /* 0 */,
				Fragments._PVideoRecommendation__OclElement /* 1 */,
				Fragments._PVideoRecommendation__Purpose /* 2 */,
				Fragments._PVideoRecommendation__PurposeConsent /* 3 */,
				Fragments._PVideoRecommendation__PUserExperience /* 4 */,
				Fragments._PVideoRecommendation__PVideoRecommendation /* 5 */
			};
		private static final int /*@NonNull*/ [] __PVideoRecommendation = { 1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PVideoSharing =
			{
				Fragments._PVideoSharing__OclAny /* 0 */,
				Fragments._PVideoSharing__OclElement /* 1 */,
				Fragments._PVideoSharing__Purpose /* 2 */,
				Fragments._PVideoSharing__PurposeConsent /* 3 */,
				Fragments._PVideoSharing__PSocial /* 4 */,
				Fragments._PVideoSharing__PComments /* 5 */,
				Fragments._PVideoSharing__PVideoSharing /* 6 */
			};
		private static final int /*@NonNull*/ [] __PVideoSharing = { 1,1,1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Password =
			{
				Fragments._Password__OclAny /* 0 */,
				Fragments._Password__OclElement /* 1 */,
				Fragments._Password__Data /* 2 */,
				Fragments._Password__PersonalData /* 3 */,
				Fragments._Password__Password /* 4 */
			};
		private static final int /*@NonNull*/ [] __Password = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Payment =
			{
				Fragments._Payment__OclAny /* 0 */,
				Fragments._Payment__OclElement /* 1 */,
				Fragments._Payment__Data /* 2 */,
				Fragments._Payment__PersonalData /* 3 */,
				Fragments._Payment__Payment /* 4 */
			};
		private static final int /*@NonNull*/ [] __Payment = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PersonalData =
			{
				Fragments._PersonalData__OclAny /* 0 */,
				Fragments._PersonalData__OclElement /* 1 */,
				Fragments._PersonalData__Data /* 2 */,
				Fragments._PersonalData__PersonalData /* 3 */
			};
		private static final int /*@NonNull*/ [] __PersonalData = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Postgresql =
			{
				Fragments._Postgresql__OclAny /* 0 */,
				Fragments._Postgresql__OclElement /* 1 */,
				Fragments._Postgresql__Component /* 2 */,
				Fragments._Postgresql__Postgresql /* 3 */
			};
		private static final int /*@NonNull*/ [] __Postgresql = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Purpose =
			{
				Fragments._Purpose__OclAny /* 0 */,
				Fragments._Purpose__OclElement /* 1 */,
				Fragments._Purpose__Purpose /* 2 */
			};
		private static final int /*@NonNull*/ [] __Purpose = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PurposeConsent =
			{
				Fragments._PurposeConsent__OclAny /* 0 */,
				Fragments._PurposeConsent__OclElement /* 1 */,
				Fragments._PurposeConsent__Purpose /* 2 */,
				Fragments._PurposeConsent__PurposeConsent /* 3 */
			};
		private static final int /*@NonNull*/ [] __PurposeConsent = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PurposeNoConsent =
			{
				Fragments._PurposeNoConsent__OclAny /* 0 */,
				Fragments._PurposeNoConsent__OclElement /* 1 */,
				Fragments._PurposeNoConsent__Purpose /* 2 */,
				Fragments._PurposeNoConsent__PurposeNoConsent /* 3 */
			};
		private static final int /*@NonNull*/ [] __PurposeNoConsent = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _RecommendVideos =
			{
				Fragments._RecommendVideos__OclAny /* 0 */,
				Fragments._RecommendVideos__OclElement /* 1 */,
				Fragments._RecommendVideos__Function /* 2 */,
				Fragments._RecommendVideos__FuncPersData /* 3 */,
				Fragments._RecommendVideos__RecommendVideos /* 4 */
			};
		private static final int /*@NonNull*/ [] __RecommendVideos = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _RedisComponent =
			{
				Fragments._RedisComponent__OclAny /* 0 */,
				Fragments._RedisComponent__OclElement /* 1 */,
				Fragments._RedisComponent__Component /* 2 */,
				Fragments._RedisComponent__RedisComponent /* 3 */
			};
		private static final int /*@NonNull*/ [] __RedisComponent = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _RemoveVideo =
			{
				Fragments._RemoveVideo__OclAny /* 0 */,
				Fragments._RemoveVideo__OclElement /* 1 */,
				Fragments._RemoveVideo__Function /* 2 */,
				Fragments._RemoveVideo__FuncPersData /* 3 */,
				Fragments._RemoveVideo__RemoveVideo /* 4 */
			};
		private static final int /*@NonNull*/ [] __RemoveVideo = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _RequestTimestamps =
			{
				Fragments._RequestTimestamps__OclAny /* 0 */,
				Fragments._RequestTimestamps__OclElement /* 1 */,
				Fragments._RequestTimestamps__Data /* 2 */,
				Fragments._RequestTimestamps__PersonalData /* 3 */,
				Fragments._RequestTimestamps__RequestTimestamps /* 4 */
			};
		private static final int /*@NonNull*/ [] __RequestTimestamps = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Risk =
			{
				Fragments._Risk__OclAny /* 0 */,
				Fragments._Risk__OclElement /* 1 */,
				Fragments._Risk__Risk /* 2 */
			};
		private static final int /*@NonNull*/ [] __Risk = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ServeBehaviorTargetedAds =
			{
				Fragments._ServeBehaviorTargetedAds__OclAny /* 0 */,
				Fragments._ServeBehaviorTargetedAds__OclElement /* 1 */,
				Fragments._ServeBehaviorTargetedAds__Function /* 2 */,
				Fragments._ServeBehaviorTargetedAds__FuncPersData /* 3 */,
				Fragments._ServeBehaviorTargetedAds__ServeBehaviorTargetedAds /* 4 */
			};
		private static final int /*@NonNull*/ [] __ServeBehaviorTargetedAds = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ServeLocationTargetedAds =
			{
				Fragments._ServeLocationTargetedAds__OclAny /* 0 */,
				Fragments._ServeLocationTargetedAds__OclElement /* 1 */,
				Fragments._ServeLocationTargetedAds__Function /* 2 */,
				Fragments._ServeLocationTargetedAds__FuncPersData /* 3 */,
				Fragments._ServeLocationTargetedAds__ServeLocationTargetedAds /* 4 */
			};
		private static final int /*@NonNull*/ [] __ServeLocationTargetedAds = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ServeStandardAds =
			{
				Fragments._ServeStandardAds__OclAny /* 0 */,
				Fragments._ServeStandardAds__OclElement /* 1 */,
				Fragments._ServeStandardAds__Function /* 2 */,
				Fragments._ServeStandardAds__FuncPersData /* 3 */,
				Fragments._ServeStandardAds__ServeStandardAds /* 4 */
			};
		private static final int /*@NonNull*/ [] __ServeStandardAds = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _StreamVideo =
			{
				Fragments._StreamVideo__OclAny /* 0 */,
				Fragments._StreamVideo__OclElement /* 1 */,
				Fragments._StreamVideo__Function /* 2 */,
				Fragments._StreamVideo__FuncPersData /* 3 */,
				Fragments._StreamVideo__StreamVideo /* 4 */
			};
		private static final int /*@NonNull*/ [] __StreamVideo = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _StreamingHistory =
			{
				Fragments._StreamingHistory__OclAny /* 0 */,
				Fragments._StreamingHistory__OclElement /* 1 */,
				Fragments._StreamingHistory__Data /* 2 */,
				Fragments._StreamingHistory__PersonalData /* 3 */,
				Fragments._StreamingHistory__StreamingHistory /* 4 */
			};
		private static final int /*@NonNull*/ [] __StreamingHistory = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _System =
			{
				Fragments._System__OclAny /* 0 */,
				Fragments._System__OclElement /* 1 */,
				Fragments._System__System /* 2 */
			};
		private static final int /*@NonNull*/ [] __System = { 1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _TrackingCookie =
			{
				Fragments._TrackingCookie__OclAny /* 0 */,
				Fragments._TrackingCookie__OclElement /* 1 */,
				Fragments._TrackingCookie__Data /* 2 */,
				Fragments._TrackingCookie__PersonalData /* 3 */,
				Fragments._TrackingCookie__TrackingCookie /* 4 */
			};
		private static final int /*@NonNull*/ [] __TrackingCookie = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _UploadVideo =
			{
				Fragments._UploadVideo__OclAny /* 0 */,
				Fragments._UploadVideo__OclElement /* 1 */,
				Fragments._UploadVideo__Function /* 2 */,
				Fragments._UploadVideo__FuncPersData /* 3 */,
				Fragments._UploadVideo__UploadVideo /* 4 */
			};
		private static final int /*@NonNull*/ [] __UploadVideo = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _User =
			{
				Fragments._User__OclAny /* 0 */,
				Fragments._User__OclElement /* 1 */,
				Fragments._User__DataSubject /* 2 */,
				Fragments._User__User /* 3 */
			};
		private static final int /*@NonNull*/ [] __User = { 1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Username =
			{
				Fragments._Username__OclAny /* 0 */,
				Fragments._Username__OclElement /* 1 */,
				Fragments._Username__Data /* 2 */,
				Fragments._Username__PersonalData /* 3 */,
				Fragments._Username__Username /* 4 */
			};
		private static final int /*@NonNull*/ [] __Username = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _VideoComment =
			{
				Fragments._VideoComment__OclAny /* 0 */,
				Fragments._VideoComment__OclElement /* 1 */,
				Fragments._VideoComment__Data /* 2 */,
				Fragments._VideoComment__PersonalData /* 3 */,
				Fragments._VideoComment__VideoComment /* 4 */
			};
		private static final int /*@NonNull*/ [] __VideoComment = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _VideoContent =
			{
				Fragments._VideoContent__OclAny /* 0 */,
				Fragments._VideoContent__OclElement /* 1 */,
				Fragments._VideoContent__Data /* 2 */,
				Fragments._VideoContent__PersonalData /* 3 */,
				Fragments._VideoContent__VideoContent /* 4 */
			};
		private static final int /*@NonNull*/ [] __VideoContent = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _VideoMetadata =
			{
				Fragments._VideoMetadata__OclAny /* 0 */,
				Fragments._VideoMetadata__OclElement /* 1 */,
				Fragments._VideoMetadata__Data /* 2 */,
				Fragments._VideoMetadata__PersonalData /* 3 */,
				Fragments._VideoMetadata__VideoMetadata /* 4 */
			};
		private static final int /*@NonNull*/ [] __VideoMetadata = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Vulnerability =
			{
				Fragments._Vulnerability__OclAny /* 0 */,
				Fragments._Vulnerability__OclElement /* 1 */,
				Fragments._Vulnerability__Vulnerability /* 2 */
			};
		private static final int /*@NonNull*/ [] __Vulnerability = { 1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._Administrator.initFragments(_Administrator, __Administrator);
			Types._AngularSPA.initFragments(_AngularSPA, __AngularSPA);
			Types._CVE_2018_16843.initFragments(_CVE_2018_16843, __CVE_2018_16843);
			Types._CVE_2018_16844.initFragments(_CVE_2018_16844, __CVE_2018_16844);
			Types._CVE_2018_16845.initFragments(_CVE_2018_16845, __CVE_2018_16845);
			Types._CVE_2019_9511.initFragments(_CVE_2019_9511, __CVE_2019_9511);
			Types._CVE_2019_9513.initFragments(_CVE_2019_9513, __CVE_2019_9513);
			Types._CVE_2019_9516.initFragments(_CVE_2019_9516, __CVE_2019_9516);
			Types._CVE_2021_23017.initFragments(_CVE_2021_23017, __CVE_2021_23017);
			Types._CVE_2021_3618.initFragments(_CVE_2021_3618, __CVE_2021_3618);
			Types._CVE_2022_24834.initFragments(_CVE_2022_24834, __CVE_2022_24834);
			Types._CVE_2022_36021.initFragments(_CVE_2022_36021, __CVE_2022_36021);
			Types._CVE_2022_41862.initFragments(_CVE_2022_41862, __CVE_2022_41862);
			Types._CVE_2023_2455.initFragments(_CVE_2023_2455, __CVE_2023_2455);
			Types._CVE_2023_25155.initFragments(_CVE_2023_25155, __CVE_2023_25155);
			Types._CVE_2023_28856.initFragments(_CVE_2023_28856, __CVE_2023_28856);
			Types._CVE_2023_44487.initFragments(_CVE_2023_44487, __CVE_2023_44487);
			Types._CVE_2023_45145.initFragments(_CVE_2023_45145, __CVE_2023_45145);
			Types._CVE_2023_46809.initFragments(_CVE_2023_46809, __CVE_2023_46809);
			Types._CVE_2023_5870.initFragments(_CVE_2023_5870, __CVE_2023_5870);
			Types._CVE_2024_0985.initFragments(_CVE_2024_0985, __CVE_2024_0985);
			Types._CVE_2024_10976.initFragments(_CVE_2024_10976, __CVE_2024_10976);
			Types._CVE_2024_10977.initFragments(_CVE_2024_10977, __CVE_2024_10977);
			Types._CVE_2024_10978.initFragments(_CVE_2024_10978, __CVE_2024_10978);
			Types._CVE_2024_10979.initFragments(_CVE_2024_10979, __CVE_2024_10979);
			Types._CVE_2024_21890.initFragments(_CVE_2024_21890, __CVE_2024_21890);
			Types._CVE_2024_21891.initFragments(_CVE_2024_21891, __CVE_2024_21891);
			Types._CVE_2024_21896.initFragments(_CVE_2024_21896, __CVE_2024_21896);
			Types._CVE_2024_22017.initFragments(_CVE_2024_22017, __CVE_2024_22017);
			Types._CVE_2024_22018.initFragments(_CVE_2024_22018, __CVE_2024_22018);
			Types._CVE_2024_22019.initFragments(_CVE_2024_22019, __CVE_2024_22019);
			Types._CVE_2024_22020.initFragments(_CVE_2024_22020, __CVE_2024_22020);
			Types._CVE_2024_22025.initFragments(_CVE_2024_22025, __CVE_2024_22025);
			Types._CVE_2024_27980.initFragments(_CVE_2024_27980, __CVE_2024_27980);
			Types._CVE_2024_27983.initFragments(_CVE_2024_27983, __CVE_2024_27983);
			Types._CVE_2024_31449.initFragments(_CVE_2024_31449, __CVE_2024_31449);
			Types._CVE_2024_31489.initFragments(_CVE_2024_31489, __CVE_2024_31489);
			Types._CVE_2024_3566.initFragments(_CVE_2024_3566, __CVE_2024_3566);
			Types._CVE_2024_36137.initFragments(_CVE_2024_36137, __CVE_2024_36137);
			Types._CVE_2024_36138.initFragments(_CVE_2024_36138, __CVE_2024_36138);
			Types._CVE_2024_37372.initFragments(_CVE_2024_37372, __CVE_2024_37372);
			Types._CVE_2024_46981.initFragments(_CVE_2024_46981, __CVE_2024_46981);
			Types._CVE_2024_5205.initFragments(_CVE_2024_5205, __CVE_2024_5205);
			Types._CVE_2024_7347.initFragments(_CVE_2024_7347, __CVE_2024_7347);
			Types._CVE_2024_7348.initFragments(_CVE_2024_7348, __CVE_2024_7348);
			Types._CVE_2025_1094.initFragments(_CVE_2025_1094, __CVE_2025_1094);
			Types._CVE_2025_11187.initFragments(_CVE_2025_11187, __CVE_2025_11187);
			Types._CVE_2025_15468.initFragments(_CVE_2025_15468, __CVE_2025_15468);
			Types._CVE_2025_21605.initFragments(_CVE_2025_21605, __CVE_2025_21605);
			Types._CVE_2025_23084.initFragments(_CVE_2025_23084, __CVE_2025_23084);
			Types._CVE_2025_23090.initFragments(_CVE_2025_23090, __CVE_2025_23090);
			Types._CVE_2025_32023.initFragments(_CVE_2025_32023, __CVE_2025_32023);
			Types._CVE_2025_62506.initFragments(_CVE_2025_62506, __CVE_2025_62506);
			Types._CVE_2025_62507.initFragments(_CVE_2025_62507, __CVE_2025_62507);
			Types._CVE_2025_66199.initFragments(_CVE_2025_66199, __CVE_2025_66199);
			Types._CVE_2025_69418.initFragments(_CVE_2025_69418, __CVE_2025_69418);
			Types._CVE_2025_69420.initFragments(_CVE_2025_69420, __CVE_2025_69420);
			Types._CVE_2025_69421.initFragments(_CVE_2025_69421, __CVE_2025_69421);
			Types._CVE_2026_22795.initFragments(_CVE_2026_22795, __CVE_2026_22795);
			Types._CVE_2026_22796.initFragments(_CVE_2026_22796, __CVE_2026_22796);
			Types._CVE_2026_27970.initFragments(_CVE_2026_27970, __CVE_2026_27970);
			Types._CVSSVector.initFragments(_CVSSVector, __CVSSVector);
			Types._CommentWriteRead.initFragments(_CommentWriteRead, __CommentWriteRead);
			Types._Component.initFragments(_Component, __Component);
			Types._Consent.initFragments(_Consent, __Consent);
			Types._Data.initFragments(_Data, __Data);
			Types._DataSubject.initFragments(_DataSubject, __DataSubject);
			Types._DeviceLocation.initFragments(_DeviceLocation, __DeviceLocation);
			Types._DeviceType.initFragments(_DeviceType, __DeviceType);
			Types._EmailAddress.initFragments(_EmailAddress, __EmailAddress);
			Types._ExpressJS.initFragments(_ExpressJS, __ExpressJS);
			Types._FilesystemComponent.initFragments(_FilesystemComponent, __FilesystemComponent);
			Types._FuncPersData.initFragments(_FuncPersData, __FuncPersData);
			Types._Function.initFragments(_Function, __Function);
			Types._LiveStreamVideo.initFragments(_LiveStreamVideo, __LiveStreamVideo);
			Types._Moderator.initFragments(_Moderator, __Moderator);
			Types._Nginx.initFragments(_Nginx, __Nginx);
			Types._NonPersonalData.initFragments(_NonPersonalData, __NonPersonalData);
			Types._P2PStreaming.initFragments(_P2PStreaming, __P2PStreaming);
			Types._PBehaviorTargetedAds.initFragments(_PBehaviorTargetedAds, __PBehaviorTargetedAds);
			Types._PComments.initFragments(_PComments, __PComments);
			Types._PFirstPartyProfiling.initFragments(_PFirstPartyProfiling, __PFirstPartyProfiling);
			Types._PLocationTargetedAds.initFragments(_PLocationTargetedAds, __PLocationTargetedAds);
			Types._PMarketing.initFragments(_PMarketing, __PMarketing);
			Types._PP2PStreaming.initFragments(_PP2PStreaming, __PP2PStreaming);
			Types._PProfiling.initFragments(_PProfiling, __PProfiling);
			Types._PSocial.initFragments(_PSocial, __PSocial);
			Types._PStandardAds.initFragments(_PStandardAds, __PStandardAds);
			Types._PTargetedAds.initFragments(_PTargetedAds, __PTargetedAds);
			Types._PThirdPartyProfiling.initFragments(_PThirdPartyProfiling, __PThirdPartyProfiling);
			Types._PUserExperience.initFragments(_PUserExperience, __PUserExperience);
			Types._PVideoRecommendation.initFragments(_PVideoRecommendation, __PVideoRecommendation);
			Types._PVideoSharing.initFragments(_PVideoSharing, __PVideoSharing);
			Types._Password.initFragments(_Password, __Password);
			Types._Payment.initFragments(_Payment, __Payment);
			Types._PersonalData.initFragments(_PersonalData, __PersonalData);
			Types._Postgresql.initFragments(_Postgresql, __Postgresql);
			Types._Purpose.initFragments(_Purpose, __Purpose);
			Types._PurposeConsent.initFragments(_PurposeConsent, __PurposeConsent);
			Types._PurposeNoConsent.initFragments(_PurposeNoConsent, __PurposeNoConsent);
			Types._RecommendVideos.initFragments(_RecommendVideos, __RecommendVideos);
			Types._RedisComponent.initFragments(_RedisComponent, __RedisComponent);
			Types._RemoveVideo.initFragments(_RemoveVideo, __RemoveVideo);
			Types._RequestTimestamps.initFragments(_RequestTimestamps, __RequestTimestamps);
			Types._Risk.initFragments(_Risk, __Risk);
			Types._ServeBehaviorTargetedAds.initFragments(_ServeBehaviorTargetedAds, __ServeBehaviorTargetedAds);
			Types._ServeLocationTargetedAds.initFragments(_ServeLocationTargetedAds, __ServeLocationTargetedAds);
			Types._ServeStandardAds.initFragments(_ServeStandardAds, __ServeStandardAds);
			Types._StreamVideo.initFragments(_StreamVideo, __StreamVideo);
			Types._StreamingHistory.initFragments(_StreamingHistory, __StreamingHistory);
			Types._System.initFragments(_System, __System);
			Types._TrackingCookie.initFragments(_TrackingCookie, __TrackingCookie);
			Types._UploadVideo.initFragments(_UploadVideo, __UploadVideo);
			Types._User.initFragments(_User, __User);
			Types._Username.initFragments(_Username, __Username);
			Types._VideoComment.initFragments(_VideoComment, __VideoComment);
			Types._VideoContent.initFragments(_VideoContent, __VideoContent);
			Types._VideoMetadata.initFragments(_VideoMetadata, __VideoMetadata);
			Types._Vulnerability.initFragments(_Vulnerability, __Vulnerability);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::TypeFragments and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local operations or local operation overrides for each fragment of each type.
	 */
	public static class FragmentOperations {
		static {
			Init.initStart();
			TypeFragments.init();
		}

		private static final ExecutorOperation /*@NonNull*/ [] _Administrator__Administrator = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Administrator__DataSubject = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Administrator__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Administrator__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _AngularSPA__AngularSPA = {};
		private static final ExecutorOperation /*@NonNull*/ [] _AngularSPA__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _AngularSPA__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _AngularSPA__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16843__CVE_2018_16843 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16843__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16843__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16843__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16844__CVE_2018_16844 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16844__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16844__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16844__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16845__CVE_2018_16845 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16845__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16845__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2018_16845__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9511__CVE_2019_9511 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9511__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9511__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9511__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9513__CVE_2019_9513 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9513__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9513__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9513__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9516__CVE_2019_9516 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9516__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9516__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2019_9516__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2021_23017__CVE_2021_23017 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2021_23017__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2021_23017__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2021_23017__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2021_3618__CVE_2021_3618 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2021_3618__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2021_3618__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2021_3618__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_24834__CVE_2022_24834 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_24834__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_24834__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_24834__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_36021__CVE_2022_36021 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_36021__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_36021__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_36021__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_41862__CVE_2022_41862 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_41862__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_41862__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2022_41862__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_2455__CVE_2023_2455 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_2455__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_2455__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_2455__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_25155__CVE_2023_25155 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_25155__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_25155__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_25155__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_28856__CVE_2023_28856 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_28856__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_28856__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_28856__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_44487__CVE_2023_44487 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_44487__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_44487__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_44487__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_45145__CVE_2023_45145 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_45145__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_45145__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_45145__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_46809__CVE_2023_46809 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_46809__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_46809__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_46809__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_5870__CVE_2023_5870 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_5870__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_5870__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2023_5870__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_0985__CVE_2024_0985 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_0985__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_0985__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_0985__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10976__CVE_2024_10976 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10976__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10976__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10976__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10977__CVE_2024_10977 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10977__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10977__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10977__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10978__CVE_2024_10978 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10978__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10978__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10978__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10979__CVE_2024_10979 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10979__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10979__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_10979__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21890__CVE_2024_21890 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21890__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21890__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21890__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21891__CVE_2024_21891 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21891__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21891__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21891__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21896__CVE_2024_21896 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21896__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21896__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_21896__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22017__CVE_2024_22017 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22017__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22017__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22017__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22018__CVE_2024_22018 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22018__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22018__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22018__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22019__CVE_2024_22019 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22019__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22019__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22019__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22020__CVE_2024_22020 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22020__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22020__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22020__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22025__CVE_2024_22025 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22025__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22025__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_22025__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_27980__CVE_2024_27980 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_27980__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_27980__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_27980__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_27983__CVE_2024_27983 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_27983__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_27983__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_27983__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_31449__CVE_2024_31449 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_31449__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_31449__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_31449__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_31489__CVE_2024_31489 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_31489__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_31489__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_31489__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_3566__CVE_2024_3566 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_3566__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_3566__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_3566__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_36137__CVE_2024_36137 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_36137__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_36137__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_36137__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_36138__CVE_2024_36138 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_36138__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_36138__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_36138__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_37372__CVE_2024_37372 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_37372__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_37372__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_37372__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_46981__CVE_2024_46981 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_46981__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_46981__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_46981__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_5205__CVE_2024_5205 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_5205__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_5205__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_5205__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_7347__CVE_2024_7347 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_7347__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_7347__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_7347__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_7348__CVE_2024_7348 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_7348__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_7348__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2024_7348__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_1094__CVE_2025_1094 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_1094__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_1094__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_1094__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_11187__CVE_2025_11187 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_11187__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_11187__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_11187__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_15468__CVE_2025_15468 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_15468__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_15468__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_15468__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_21605__CVE_2025_21605 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_21605__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_21605__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_21605__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_23084__CVE_2025_23084 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_23084__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_23084__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_23084__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_23090__CVE_2025_23090 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_23090__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_23090__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_23090__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_32023__CVE_2025_32023 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_32023__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_32023__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_32023__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_62506__CVE_2025_62506 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_62506__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_62506__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_62506__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_62507__CVE_2025_62507 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_62507__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_62507__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_62507__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_66199__CVE_2025_66199 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_66199__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_66199__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_66199__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69418__CVE_2025_69418 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69418__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69418__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69418__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69420__CVE_2025_69420 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69420__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69420__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69420__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69421__CVE_2025_69421 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69421__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69421__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2025_69421__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_22795__CVE_2026_22795 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_22795__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_22795__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_22795__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_22796__CVE_2026_22796 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_22796__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_22796__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_22796__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_27970__CVE_2026_27970 = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_27970__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_27970__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVE_2026_27970__Vulnerability = {};

		private static final ExecutorOperation /*@NonNull*/ [] _CVSSVector__CVSSVector = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CVSSVector__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CVSSVector__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _CommentWriteRead__CommentWriteRead = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CommentWriteRead__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CommentWriteRead__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _CommentWriteRead__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _CommentWriteRead__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Component__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Component__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Component__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Consent__Consent = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Consent__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Consent__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Data__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Data__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Data__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _DataSubject__DataSubject = {};
		private static final ExecutorOperation /*@NonNull*/ [] _DataSubject__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _DataSubject__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _DeviceLocation__DeviceLocation = {};
		private static final ExecutorOperation /*@NonNull*/ [] _DeviceLocation__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _DeviceLocation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _DeviceLocation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _DeviceLocation__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _DeviceType__DeviceType = {};
		private static final ExecutorOperation /*@NonNull*/ [] _DeviceType__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _DeviceType__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _DeviceType__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _DeviceType__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _EmailAddress__EmailAddress = {};
		private static final ExecutorOperation /*@NonNull*/ [] _EmailAddress__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _EmailAddress__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _EmailAddress__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _EmailAddress__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _ExpressJS__ExpressJS = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ExpressJS__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ExpressJS__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ExpressJS__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _FilesystemComponent__FilesystemComponent = {};
		private static final ExecutorOperation /*@NonNull*/ [] _FilesystemComponent__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _FilesystemComponent__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _FilesystemComponent__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _FuncPersData__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _FuncPersData__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _FuncPersData__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _FuncPersData__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Function__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Function__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Function__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _LiveStreamVideo__LiveStreamVideo = {};
		private static final ExecutorOperation /*@NonNull*/ [] _LiveStreamVideo__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _LiveStreamVideo__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _LiveStreamVideo__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _LiveStreamVideo__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Moderator__Moderator = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Moderator__DataSubject = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Moderator__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Moderator__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Nginx__Nginx = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Nginx__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Nginx__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Nginx__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _NonPersonalData__NonPersonalData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _NonPersonalData__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _NonPersonalData__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _NonPersonalData__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _P2PStreaming__P2PStreaming = {};
		private static final ExecutorOperation /*@NonNull*/ [] _P2PStreaming__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _P2PStreaming__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _P2PStreaming__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _P2PStreaming__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _PBehaviorTargetedAds__PBehaviorTargetedAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PBehaviorTargetedAds__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PBehaviorTargetedAds__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PBehaviorTargetedAds__PMarketing = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PBehaviorTargetedAds__PTargetedAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PBehaviorTargetedAds__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PBehaviorTargetedAds__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PComments__PComments = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PComments__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PComments__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PComments__PSocial = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PComments__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PComments__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PFirstPartyProfiling__PFirstPartyProfiling = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PFirstPartyProfiling__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PFirstPartyProfiling__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PFirstPartyProfiling__PProfiling = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PFirstPartyProfiling__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PFirstPartyProfiling__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PLocationTargetedAds__PLocationTargetedAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PLocationTargetedAds__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PLocationTargetedAds__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PLocationTargetedAds__PMarketing = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PLocationTargetedAds__PTargetedAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PLocationTargetedAds__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PLocationTargetedAds__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PMarketing__PMarketing = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PMarketing__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PMarketing__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PMarketing__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PMarketing__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PP2PStreaming__PP2PStreaming = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PP2PStreaming__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PP2PStreaming__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PP2PStreaming__PUserExperience = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PP2PStreaming__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PP2PStreaming__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PProfiling__PProfiling = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PProfiling__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PProfiling__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PProfiling__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PProfiling__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PSocial__PSocial = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PSocial__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PSocial__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PSocial__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PSocial__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PStandardAds__PStandardAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PStandardAds__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PStandardAds__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PStandardAds__PMarketing = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PStandardAds__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PStandardAds__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PTargetedAds__PTargetedAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PTargetedAds__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PTargetedAds__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PTargetedAds__PMarketing = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PTargetedAds__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PTargetedAds__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PThirdPartyProfiling__PThirdPartyProfiling = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PThirdPartyProfiling__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PThirdPartyProfiling__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PThirdPartyProfiling__PFirstPartyProfiling = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PThirdPartyProfiling__PProfiling = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PThirdPartyProfiling__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PThirdPartyProfiling__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PUserExperience__PUserExperience = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PUserExperience__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PUserExperience__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PUserExperience__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PUserExperience__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PVideoRecommendation__PVideoRecommendation = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoRecommendation__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoRecommendation__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoRecommendation__PUserExperience = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoRecommendation__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoRecommendation__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PVideoSharing__PVideoSharing = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoSharing__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoSharing__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoSharing__PComments = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoSharing__PSocial = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoSharing__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PVideoSharing__PurposeConsent = {};

		private static final ExecutorOperation /*@NonNull*/ [] _Password__Password = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Password__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Password__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Password__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Password__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _Payment__Payment = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Payment__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Payment__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Payment__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Payment__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PersonalData__PersonalData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PersonalData__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PersonalData__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PersonalData__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Postgresql__Postgresql = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Postgresql__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Postgresql__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Postgresql__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Purpose__Purpose = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Purpose__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Purpose__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _PurposeConsent__PurposeConsent = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PurposeConsent__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PurposeConsent__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PurposeConsent__Purpose = {};

		private static final ExecutorOperation /*@NonNull*/ [] _PurposeNoConsent__PurposeNoConsent = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PurposeNoConsent__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PurposeNoConsent__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PurposeNoConsent__Purpose = {};

		private static final ExecutorOperation /*@NonNull*/ [] _RecommendVideos__RecommendVideos = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RecommendVideos__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RecommendVideos__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RecommendVideos__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _RecommendVideos__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _RedisComponent__RedisComponent = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RedisComponent__Component = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RedisComponent__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _RedisComponent__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _RemoveVideo__RemoveVideo = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RemoveVideo__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RemoveVideo__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RemoveVideo__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _RemoveVideo__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _RequestTimestamps__RequestTimestamps = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RequestTimestamps__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RequestTimestamps__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _RequestTimestamps__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _RequestTimestamps__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _Risk__Risk = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Risk__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Risk__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ServeBehaviorTargetedAds__ServeBehaviorTargetedAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeBehaviorTargetedAds__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeBehaviorTargetedAds__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeBehaviorTargetedAds__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeBehaviorTargetedAds__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ServeLocationTargetedAds__ServeLocationTargetedAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeLocationTargetedAds__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeLocationTargetedAds__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeLocationTargetedAds__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeLocationTargetedAds__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ServeStandardAds__ServeStandardAds = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeStandardAds__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeStandardAds__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeStandardAds__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ServeStandardAds__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _StreamVideo__StreamVideo = {};
		private static final ExecutorOperation /*@NonNull*/ [] _StreamVideo__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _StreamVideo__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _StreamVideo__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _StreamVideo__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _StreamingHistory__StreamingHistory = {};
		private static final ExecutorOperation /*@NonNull*/ [] _StreamingHistory__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _StreamingHistory__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _StreamingHistory__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _StreamingHistory__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _System__System = {};
		private static final ExecutorOperation /*@NonNull*/ [] _System__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _System__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _TrackingCookie__TrackingCookie = {};
		private static final ExecutorOperation /*@NonNull*/ [] _TrackingCookie__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _TrackingCookie__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _TrackingCookie__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _TrackingCookie__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _UploadVideo__UploadVideo = {};
		private static final ExecutorOperation /*@NonNull*/ [] _UploadVideo__FuncPersData = {};
		private static final ExecutorOperation /*@NonNull*/ [] _UploadVideo__Function = {};
		private static final ExecutorOperation /*@NonNull*/ [] _UploadVideo__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _UploadVideo__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _User__User = {};
		private static final ExecutorOperation /*@NonNull*/ [] _User__DataSubject = {};
		private static final ExecutorOperation /*@NonNull*/ [] _User__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _User__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Username__Username = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Username__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Username__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Username__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Username__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _VideoComment__VideoComment = {};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoComment__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoComment__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoComment__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoComment__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _VideoContent__VideoContent = {};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoContent__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoContent__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoContent__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoContent__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _VideoMetadata__VideoMetadata = {};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoMetadata__Data = {};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoMetadata__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoMetadata__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _VideoMetadata__PersonalData = {};

		private static final ExecutorOperation /*@NonNull*/ [] _Vulnerability__Vulnerability = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Vulnerability__OclAny = {
			OCLstdlibTables.Operations._OclAny___lt__gt_ /* _'<>'(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny___eq_ /* _'='(OclSelf[?]) */,
			OCLstdlibTables.Operations._OclAny__oclAsSet /* oclAsSet() */,
			OCLstdlibTables.Operations._OclAny__oclAsType /* oclAsType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInState /* oclIsInState(OclState[?]) */,
			OCLstdlibTables.Operations._OclAny__oclIsInvalid /* oclIsInvalid() */,
			OCLstdlibTables.Operations._OclAny__oclIsKindOf /* oclIsKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsNew /* oclIsNew() */,
			OCLstdlibTables.Operations._OclAny__oclIsTypeOf /* oclIsTypeOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclAny__oclIsUndefined /* oclIsUndefined() */,
			OCLstdlibTables.Operations._OclAny__0_oclLog /* oclLog() */,
			OCLstdlibTables.Operations._OclAny__1_oclLog /* oclLog(String[1]) */,
			OCLstdlibTables.Operations._OclAny__oclType /* oclType() */,
			OCLstdlibTables.Operations._OclAny__oclTypes /* oclTypes() */,
			OCLstdlibTables.Operations._OclAny__toString /* toString() */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Vulnerability__OclElement = {
			OCLstdlibTables.Operations._OclElement__allInstances /* allInstances(Integer[1]) */,
			OCLstdlibTables.Operations._OclElement__oclAsModelType /* oclAsModelType(TT)(TT[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclBase /* oclBase() */,
			OCLstdlibTables.Operations._OclElement__1_oclBase /* oclBase(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclContainer /* oclContainer() */,
			OCLstdlibTables.Operations._OclElement__oclContents /* oclContents() */,
			OCLstdlibTables.Operations._OclElement__oclExtension /* oclExtension(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__0_oclExtensions /* oclExtensions() */,
			OCLstdlibTables.Operations._OclElement__1_oclExtensions /* oclExtensions(OclStereotype[1]) */,
			OCLstdlibTables.Operations._OclElement__oclIsModelKindOf /* oclIsModelKindOf(OclType[1]) */,
			OCLstdlibTables.Operations._OclElement__oclModelType /* oclModelType() */,
			OCLstdlibTables.Operations._OclElement__oclModelTypes /* oclModelTypes() */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Administrator__Administrator.initOperations(_Administrator__Administrator);
			Fragments._Administrator__DataSubject.initOperations(_Administrator__DataSubject);
			Fragments._Administrator__OclAny.initOperations(_Administrator__OclAny);
			Fragments._Administrator__OclElement.initOperations(_Administrator__OclElement);

			Fragments._AngularSPA__AngularSPA.initOperations(_AngularSPA__AngularSPA);
			Fragments._AngularSPA__Component.initOperations(_AngularSPA__Component);
			Fragments._AngularSPA__OclAny.initOperations(_AngularSPA__OclAny);
			Fragments._AngularSPA__OclElement.initOperations(_AngularSPA__OclElement);

			Fragments._CVE_2018_16843__CVE_2018_16843.initOperations(_CVE_2018_16843__CVE_2018_16843);
			Fragments._CVE_2018_16843__OclAny.initOperations(_CVE_2018_16843__OclAny);
			Fragments._CVE_2018_16843__OclElement.initOperations(_CVE_2018_16843__OclElement);
			Fragments._CVE_2018_16843__Vulnerability.initOperations(_CVE_2018_16843__Vulnerability);

			Fragments._CVE_2018_16844__CVE_2018_16844.initOperations(_CVE_2018_16844__CVE_2018_16844);
			Fragments._CVE_2018_16844__OclAny.initOperations(_CVE_2018_16844__OclAny);
			Fragments._CVE_2018_16844__OclElement.initOperations(_CVE_2018_16844__OclElement);
			Fragments._CVE_2018_16844__Vulnerability.initOperations(_CVE_2018_16844__Vulnerability);

			Fragments._CVE_2018_16845__CVE_2018_16845.initOperations(_CVE_2018_16845__CVE_2018_16845);
			Fragments._CVE_2018_16845__OclAny.initOperations(_CVE_2018_16845__OclAny);
			Fragments._CVE_2018_16845__OclElement.initOperations(_CVE_2018_16845__OclElement);
			Fragments._CVE_2018_16845__Vulnerability.initOperations(_CVE_2018_16845__Vulnerability);

			Fragments._CVE_2019_9511__CVE_2019_9511.initOperations(_CVE_2019_9511__CVE_2019_9511);
			Fragments._CVE_2019_9511__OclAny.initOperations(_CVE_2019_9511__OclAny);
			Fragments._CVE_2019_9511__OclElement.initOperations(_CVE_2019_9511__OclElement);
			Fragments._CVE_2019_9511__Vulnerability.initOperations(_CVE_2019_9511__Vulnerability);

			Fragments._CVE_2019_9513__CVE_2019_9513.initOperations(_CVE_2019_9513__CVE_2019_9513);
			Fragments._CVE_2019_9513__OclAny.initOperations(_CVE_2019_9513__OclAny);
			Fragments._CVE_2019_9513__OclElement.initOperations(_CVE_2019_9513__OclElement);
			Fragments._CVE_2019_9513__Vulnerability.initOperations(_CVE_2019_9513__Vulnerability);

			Fragments._CVE_2019_9516__CVE_2019_9516.initOperations(_CVE_2019_9516__CVE_2019_9516);
			Fragments._CVE_2019_9516__OclAny.initOperations(_CVE_2019_9516__OclAny);
			Fragments._CVE_2019_9516__OclElement.initOperations(_CVE_2019_9516__OclElement);
			Fragments._CVE_2019_9516__Vulnerability.initOperations(_CVE_2019_9516__Vulnerability);

			Fragments._CVE_2021_23017__CVE_2021_23017.initOperations(_CVE_2021_23017__CVE_2021_23017);
			Fragments._CVE_2021_23017__OclAny.initOperations(_CVE_2021_23017__OclAny);
			Fragments._CVE_2021_23017__OclElement.initOperations(_CVE_2021_23017__OclElement);
			Fragments._CVE_2021_23017__Vulnerability.initOperations(_CVE_2021_23017__Vulnerability);

			Fragments._CVE_2021_3618__CVE_2021_3618.initOperations(_CVE_2021_3618__CVE_2021_3618);
			Fragments._CVE_2021_3618__OclAny.initOperations(_CVE_2021_3618__OclAny);
			Fragments._CVE_2021_3618__OclElement.initOperations(_CVE_2021_3618__OclElement);
			Fragments._CVE_2021_3618__Vulnerability.initOperations(_CVE_2021_3618__Vulnerability);

			Fragments._CVE_2022_24834__CVE_2022_24834.initOperations(_CVE_2022_24834__CVE_2022_24834);
			Fragments._CVE_2022_24834__OclAny.initOperations(_CVE_2022_24834__OclAny);
			Fragments._CVE_2022_24834__OclElement.initOperations(_CVE_2022_24834__OclElement);
			Fragments._CVE_2022_24834__Vulnerability.initOperations(_CVE_2022_24834__Vulnerability);

			Fragments._CVE_2022_36021__CVE_2022_36021.initOperations(_CVE_2022_36021__CVE_2022_36021);
			Fragments._CVE_2022_36021__OclAny.initOperations(_CVE_2022_36021__OclAny);
			Fragments._CVE_2022_36021__OclElement.initOperations(_CVE_2022_36021__OclElement);
			Fragments._CVE_2022_36021__Vulnerability.initOperations(_CVE_2022_36021__Vulnerability);

			Fragments._CVE_2022_41862__CVE_2022_41862.initOperations(_CVE_2022_41862__CVE_2022_41862);
			Fragments._CVE_2022_41862__OclAny.initOperations(_CVE_2022_41862__OclAny);
			Fragments._CVE_2022_41862__OclElement.initOperations(_CVE_2022_41862__OclElement);
			Fragments._CVE_2022_41862__Vulnerability.initOperations(_CVE_2022_41862__Vulnerability);

			Fragments._CVE_2023_2455__CVE_2023_2455.initOperations(_CVE_2023_2455__CVE_2023_2455);
			Fragments._CVE_2023_2455__OclAny.initOperations(_CVE_2023_2455__OclAny);
			Fragments._CVE_2023_2455__OclElement.initOperations(_CVE_2023_2455__OclElement);
			Fragments._CVE_2023_2455__Vulnerability.initOperations(_CVE_2023_2455__Vulnerability);

			Fragments._CVE_2023_25155__CVE_2023_25155.initOperations(_CVE_2023_25155__CVE_2023_25155);
			Fragments._CVE_2023_25155__OclAny.initOperations(_CVE_2023_25155__OclAny);
			Fragments._CVE_2023_25155__OclElement.initOperations(_CVE_2023_25155__OclElement);
			Fragments._CVE_2023_25155__Vulnerability.initOperations(_CVE_2023_25155__Vulnerability);

			Fragments._CVE_2023_28856__CVE_2023_28856.initOperations(_CVE_2023_28856__CVE_2023_28856);
			Fragments._CVE_2023_28856__OclAny.initOperations(_CVE_2023_28856__OclAny);
			Fragments._CVE_2023_28856__OclElement.initOperations(_CVE_2023_28856__OclElement);
			Fragments._CVE_2023_28856__Vulnerability.initOperations(_CVE_2023_28856__Vulnerability);

			Fragments._CVE_2023_44487__CVE_2023_44487.initOperations(_CVE_2023_44487__CVE_2023_44487);
			Fragments._CVE_2023_44487__OclAny.initOperations(_CVE_2023_44487__OclAny);
			Fragments._CVE_2023_44487__OclElement.initOperations(_CVE_2023_44487__OclElement);
			Fragments._CVE_2023_44487__Vulnerability.initOperations(_CVE_2023_44487__Vulnerability);

			Fragments._CVE_2023_45145__CVE_2023_45145.initOperations(_CVE_2023_45145__CVE_2023_45145);
			Fragments._CVE_2023_45145__OclAny.initOperations(_CVE_2023_45145__OclAny);
			Fragments._CVE_2023_45145__OclElement.initOperations(_CVE_2023_45145__OclElement);
			Fragments._CVE_2023_45145__Vulnerability.initOperations(_CVE_2023_45145__Vulnerability);

			Fragments._CVE_2023_46809__CVE_2023_46809.initOperations(_CVE_2023_46809__CVE_2023_46809);
			Fragments._CVE_2023_46809__OclAny.initOperations(_CVE_2023_46809__OclAny);
			Fragments._CVE_2023_46809__OclElement.initOperations(_CVE_2023_46809__OclElement);
			Fragments._CVE_2023_46809__Vulnerability.initOperations(_CVE_2023_46809__Vulnerability);

			Fragments._CVE_2023_5870__CVE_2023_5870.initOperations(_CVE_2023_5870__CVE_2023_5870);
			Fragments._CVE_2023_5870__OclAny.initOperations(_CVE_2023_5870__OclAny);
			Fragments._CVE_2023_5870__OclElement.initOperations(_CVE_2023_5870__OclElement);
			Fragments._CVE_2023_5870__Vulnerability.initOperations(_CVE_2023_5870__Vulnerability);

			Fragments._CVE_2024_0985__CVE_2024_0985.initOperations(_CVE_2024_0985__CVE_2024_0985);
			Fragments._CVE_2024_0985__OclAny.initOperations(_CVE_2024_0985__OclAny);
			Fragments._CVE_2024_0985__OclElement.initOperations(_CVE_2024_0985__OclElement);
			Fragments._CVE_2024_0985__Vulnerability.initOperations(_CVE_2024_0985__Vulnerability);

			Fragments._CVE_2024_10976__CVE_2024_10976.initOperations(_CVE_2024_10976__CVE_2024_10976);
			Fragments._CVE_2024_10976__OclAny.initOperations(_CVE_2024_10976__OclAny);
			Fragments._CVE_2024_10976__OclElement.initOperations(_CVE_2024_10976__OclElement);
			Fragments._CVE_2024_10976__Vulnerability.initOperations(_CVE_2024_10976__Vulnerability);

			Fragments._CVE_2024_10977__CVE_2024_10977.initOperations(_CVE_2024_10977__CVE_2024_10977);
			Fragments._CVE_2024_10977__OclAny.initOperations(_CVE_2024_10977__OclAny);
			Fragments._CVE_2024_10977__OclElement.initOperations(_CVE_2024_10977__OclElement);
			Fragments._CVE_2024_10977__Vulnerability.initOperations(_CVE_2024_10977__Vulnerability);

			Fragments._CVE_2024_10978__CVE_2024_10978.initOperations(_CVE_2024_10978__CVE_2024_10978);
			Fragments._CVE_2024_10978__OclAny.initOperations(_CVE_2024_10978__OclAny);
			Fragments._CVE_2024_10978__OclElement.initOperations(_CVE_2024_10978__OclElement);
			Fragments._CVE_2024_10978__Vulnerability.initOperations(_CVE_2024_10978__Vulnerability);

			Fragments._CVE_2024_10979__CVE_2024_10979.initOperations(_CVE_2024_10979__CVE_2024_10979);
			Fragments._CVE_2024_10979__OclAny.initOperations(_CVE_2024_10979__OclAny);
			Fragments._CVE_2024_10979__OclElement.initOperations(_CVE_2024_10979__OclElement);
			Fragments._CVE_2024_10979__Vulnerability.initOperations(_CVE_2024_10979__Vulnerability);

			Fragments._CVE_2024_21890__CVE_2024_21890.initOperations(_CVE_2024_21890__CVE_2024_21890);
			Fragments._CVE_2024_21890__OclAny.initOperations(_CVE_2024_21890__OclAny);
			Fragments._CVE_2024_21890__OclElement.initOperations(_CVE_2024_21890__OclElement);
			Fragments._CVE_2024_21890__Vulnerability.initOperations(_CVE_2024_21890__Vulnerability);

			Fragments._CVE_2024_21891__CVE_2024_21891.initOperations(_CVE_2024_21891__CVE_2024_21891);
			Fragments._CVE_2024_21891__OclAny.initOperations(_CVE_2024_21891__OclAny);
			Fragments._CVE_2024_21891__OclElement.initOperations(_CVE_2024_21891__OclElement);
			Fragments._CVE_2024_21891__Vulnerability.initOperations(_CVE_2024_21891__Vulnerability);

			Fragments._CVE_2024_21896__CVE_2024_21896.initOperations(_CVE_2024_21896__CVE_2024_21896);
			Fragments._CVE_2024_21896__OclAny.initOperations(_CVE_2024_21896__OclAny);
			Fragments._CVE_2024_21896__OclElement.initOperations(_CVE_2024_21896__OclElement);
			Fragments._CVE_2024_21896__Vulnerability.initOperations(_CVE_2024_21896__Vulnerability);

			Fragments._CVE_2024_22017__CVE_2024_22017.initOperations(_CVE_2024_22017__CVE_2024_22017);
			Fragments._CVE_2024_22017__OclAny.initOperations(_CVE_2024_22017__OclAny);
			Fragments._CVE_2024_22017__OclElement.initOperations(_CVE_2024_22017__OclElement);
			Fragments._CVE_2024_22017__Vulnerability.initOperations(_CVE_2024_22017__Vulnerability);

			Fragments._CVE_2024_22018__CVE_2024_22018.initOperations(_CVE_2024_22018__CVE_2024_22018);
			Fragments._CVE_2024_22018__OclAny.initOperations(_CVE_2024_22018__OclAny);
			Fragments._CVE_2024_22018__OclElement.initOperations(_CVE_2024_22018__OclElement);
			Fragments._CVE_2024_22018__Vulnerability.initOperations(_CVE_2024_22018__Vulnerability);

			Fragments._CVE_2024_22019__CVE_2024_22019.initOperations(_CVE_2024_22019__CVE_2024_22019);
			Fragments._CVE_2024_22019__OclAny.initOperations(_CVE_2024_22019__OclAny);
			Fragments._CVE_2024_22019__OclElement.initOperations(_CVE_2024_22019__OclElement);
			Fragments._CVE_2024_22019__Vulnerability.initOperations(_CVE_2024_22019__Vulnerability);

			Fragments._CVE_2024_22020__CVE_2024_22020.initOperations(_CVE_2024_22020__CVE_2024_22020);
			Fragments._CVE_2024_22020__OclAny.initOperations(_CVE_2024_22020__OclAny);
			Fragments._CVE_2024_22020__OclElement.initOperations(_CVE_2024_22020__OclElement);
			Fragments._CVE_2024_22020__Vulnerability.initOperations(_CVE_2024_22020__Vulnerability);

			Fragments._CVE_2024_22025__CVE_2024_22025.initOperations(_CVE_2024_22025__CVE_2024_22025);
			Fragments._CVE_2024_22025__OclAny.initOperations(_CVE_2024_22025__OclAny);
			Fragments._CVE_2024_22025__OclElement.initOperations(_CVE_2024_22025__OclElement);
			Fragments._CVE_2024_22025__Vulnerability.initOperations(_CVE_2024_22025__Vulnerability);

			Fragments._CVE_2024_27980__CVE_2024_27980.initOperations(_CVE_2024_27980__CVE_2024_27980);
			Fragments._CVE_2024_27980__OclAny.initOperations(_CVE_2024_27980__OclAny);
			Fragments._CVE_2024_27980__OclElement.initOperations(_CVE_2024_27980__OclElement);
			Fragments._CVE_2024_27980__Vulnerability.initOperations(_CVE_2024_27980__Vulnerability);

			Fragments._CVE_2024_27983__CVE_2024_27983.initOperations(_CVE_2024_27983__CVE_2024_27983);
			Fragments._CVE_2024_27983__OclAny.initOperations(_CVE_2024_27983__OclAny);
			Fragments._CVE_2024_27983__OclElement.initOperations(_CVE_2024_27983__OclElement);
			Fragments._CVE_2024_27983__Vulnerability.initOperations(_CVE_2024_27983__Vulnerability);

			Fragments._CVE_2024_31449__CVE_2024_31449.initOperations(_CVE_2024_31449__CVE_2024_31449);
			Fragments._CVE_2024_31449__OclAny.initOperations(_CVE_2024_31449__OclAny);
			Fragments._CVE_2024_31449__OclElement.initOperations(_CVE_2024_31449__OclElement);
			Fragments._CVE_2024_31449__Vulnerability.initOperations(_CVE_2024_31449__Vulnerability);

			Fragments._CVE_2024_31489__CVE_2024_31489.initOperations(_CVE_2024_31489__CVE_2024_31489);
			Fragments._CVE_2024_31489__OclAny.initOperations(_CVE_2024_31489__OclAny);
			Fragments._CVE_2024_31489__OclElement.initOperations(_CVE_2024_31489__OclElement);
			Fragments._CVE_2024_31489__Vulnerability.initOperations(_CVE_2024_31489__Vulnerability);

			Fragments._CVE_2024_3566__CVE_2024_3566.initOperations(_CVE_2024_3566__CVE_2024_3566);
			Fragments._CVE_2024_3566__OclAny.initOperations(_CVE_2024_3566__OclAny);
			Fragments._CVE_2024_3566__OclElement.initOperations(_CVE_2024_3566__OclElement);
			Fragments._CVE_2024_3566__Vulnerability.initOperations(_CVE_2024_3566__Vulnerability);

			Fragments._CVE_2024_36137__CVE_2024_36137.initOperations(_CVE_2024_36137__CVE_2024_36137);
			Fragments._CVE_2024_36137__OclAny.initOperations(_CVE_2024_36137__OclAny);
			Fragments._CVE_2024_36137__OclElement.initOperations(_CVE_2024_36137__OclElement);
			Fragments._CVE_2024_36137__Vulnerability.initOperations(_CVE_2024_36137__Vulnerability);

			Fragments._CVE_2024_36138__CVE_2024_36138.initOperations(_CVE_2024_36138__CVE_2024_36138);
			Fragments._CVE_2024_36138__OclAny.initOperations(_CVE_2024_36138__OclAny);
			Fragments._CVE_2024_36138__OclElement.initOperations(_CVE_2024_36138__OclElement);
			Fragments._CVE_2024_36138__Vulnerability.initOperations(_CVE_2024_36138__Vulnerability);

			Fragments._CVE_2024_37372__CVE_2024_37372.initOperations(_CVE_2024_37372__CVE_2024_37372);
			Fragments._CVE_2024_37372__OclAny.initOperations(_CVE_2024_37372__OclAny);
			Fragments._CVE_2024_37372__OclElement.initOperations(_CVE_2024_37372__OclElement);
			Fragments._CVE_2024_37372__Vulnerability.initOperations(_CVE_2024_37372__Vulnerability);

			Fragments._CVE_2024_46981__CVE_2024_46981.initOperations(_CVE_2024_46981__CVE_2024_46981);
			Fragments._CVE_2024_46981__OclAny.initOperations(_CVE_2024_46981__OclAny);
			Fragments._CVE_2024_46981__OclElement.initOperations(_CVE_2024_46981__OclElement);
			Fragments._CVE_2024_46981__Vulnerability.initOperations(_CVE_2024_46981__Vulnerability);

			Fragments._CVE_2024_5205__CVE_2024_5205.initOperations(_CVE_2024_5205__CVE_2024_5205);
			Fragments._CVE_2024_5205__OclAny.initOperations(_CVE_2024_5205__OclAny);
			Fragments._CVE_2024_5205__OclElement.initOperations(_CVE_2024_5205__OclElement);
			Fragments._CVE_2024_5205__Vulnerability.initOperations(_CVE_2024_5205__Vulnerability);

			Fragments._CVE_2024_7347__CVE_2024_7347.initOperations(_CVE_2024_7347__CVE_2024_7347);
			Fragments._CVE_2024_7347__OclAny.initOperations(_CVE_2024_7347__OclAny);
			Fragments._CVE_2024_7347__OclElement.initOperations(_CVE_2024_7347__OclElement);
			Fragments._CVE_2024_7347__Vulnerability.initOperations(_CVE_2024_7347__Vulnerability);

			Fragments._CVE_2024_7348__CVE_2024_7348.initOperations(_CVE_2024_7348__CVE_2024_7348);
			Fragments._CVE_2024_7348__OclAny.initOperations(_CVE_2024_7348__OclAny);
			Fragments._CVE_2024_7348__OclElement.initOperations(_CVE_2024_7348__OclElement);
			Fragments._CVE_2024_7348__Vulnerability.initOperations(_CVE_2024_7348__Vulnerability);

			Fragments._CVE_2025_1094__CVE_2025_1094.initOperations(_CVE_2025_1094__CVE_2025_1094);
			Fragments._CVE_2025_1094__OclAny.initOperations(_CVE_2025_1094__OclAny);
			Fragments._CVE_2025_1094__OclElement.initOperations(_CVE_2025_1094__OclElement);
			Fragments._CVE_2025_1094__Vulnerability.initOperations(_CVE_2025_1094__Vulnerability);

			Fragments._CVE_2025_11187__CVE_2025_11187.initOperations(_CVE_2025_11187__CVE_2025_11187);
			Fragments._CVE_2025_11187__OclAny.initOperations(_CVE_2025_11187__OclAny);
			Fragments._CVE_2025_11187__OclElement.initOperations(_CVE_2025_11187__OclElement);
			Fragments._CVE_2025_11187__Vulnerability.initOperations(_CVE_2025_11187__Vulnerability);

			Fragments._CVE_2025_15468__CVE_2025_15468.initOperations(_CVE_2025_15468__CVE_2025_15468);
			Fragments._CVE_2025_15468__OclAny.initOperations(_CVE_2025_15468__OclAny);
			Fragments._CVE_2025_15468__OclElement.initOperations(_CVE_2025_15468__OclElement);
			Fragments._CVE_2025_15468__Vulnerability.initOperations(_CVE_2025_15468__Vulnerability);

			Fragments._CVE_2025_21605__CVE_2025_21605.initOperations(_CVE_2025_21605__CVE_2025_21605);
			Fragments._CVE_2025_21605__OclAny.initOperations(_CVE_2025_21605__OclAny);
			Fragments._CVE_2025_21605__OclElement.initOperations(_CVE_2025_21605__OclElement);
			Fragments._CVE_2025_21605__Vulnerability.initOperations(_CVE_2025_21605__Vulnerability);

			Fragments._CVE_2025_23084__CVE_2025_23084.initOperations(_CVE_2025_23084__CVE_2025_23084);
			Fragments._CVE_2025_23084__OclAny.initOperations(_CVE_2025_23084__OclAny);
			Fragments._CVE_2025_23084__OclElement.initOperations(_CVE_2025_23084__OclElement);
			Fragments._CVE_2025_23084__Vulnerability.initOperations(_CVE_2025_23084__Vulnerability);

			Fragments._CVE_2025_23090__CVE_2025_23090.initOperations(_CVE_2025_23090__CVE_2025_23090);
			Fragments._CVE_2025_23090__OclAny.initOperations(_CVE_2025_23090__OclAny);
			Fragments._CVE_2025_23090__OclElement.initOperations(_CVE_2025_23090__OclElement);
			Fragments._CVE_2025_23090__Vulnerability.initOperations(_CVE_2025_23090__Vulnerability);

			Fragments._CVE_2025_32023__CVE_2025_32023.initOperations(_CVE_2025_32023__CVE_2025_32023);
			Fragments._CVE_2025_32023__OclAny.initOperations(_CVE_2025_32023__OclAny);
			Fragments._CVE_2025_32023__OclElement.initOperations(_CVE_2025_32023__OclElement);
			Fragments._CVE_2025_32023__Vulnerability.initOperations(_CVE_2025_32023__Vulnerability);

			Fragments._CVE_2025_62506__CVE_2025_62506.initOperations(_CVE_2025_62506__CVE_2025_62506);
			Fragments._CVE_2025_62506__OclAny.initOperations(_CVE_2025_62506__OclAny);
			Fragments._CVE_2025_62506__OclElement.initOperations(_CVE_2025_62506__OclElement);
			Fragments._CVE_2025_62506__Vulnerability.initOperations(_CVE_2025_62506__Vulnerability);

			Fragments._CVE_2025_62507__CVE_2025_62507.initOperations(_CVE_2025_62507__CVE_2025_62507);
			Fragments._CVE_2025_62507__OclAny.initOperations(_CVE_2025_62507__OclAny);
			Fragments._CVE_2025_62507__OclElement.initOperations(_CVE_2025_62507__OclElement);
			Fragments._CVE_2025_62507__Vulnerability.initOperations(_CVE_2025_62507__Vulnerability);

			Fragments._CVE_2025_66199__CVE_2025_66199.initOperations(_CVE_2025_66199__CVE_2025_66199);
			Fragments._CVE_2025_66199__OclAny.initOperations(_CVE_2025_66199__OclAny);
			Fragments._CVE_2025_66199__OclElement.initOperations(_CVE_2025_66199__OclElement);
			Fragments._CVE_2025_66199__Vulnerability.initOperations(_CVE_2025_66199__Vulnerability);

			Fragments._CVE_2025_69418__CVE_2025_69418.initOperations(_CVE_2025_69418__CVE_2025_69418);
			Fragments._CVE_2025_69418__OclAny.initOperations(_CVE_2025_69418__OclAny);
			Fragments._CVE_2025_69418__OclElement.initOperations(_CVE_2025_69418__OclElement);
			Fragments._CVE_2025_69418__Vulnerability.initOperations(_CVE_2025_69418__Vulnerability);

			Fragments._CVE_2025_69420__CVE_2025_69420.initOperations(_CVE_2025_69420__CVE_2025_69420);
			Fragments._CVE_2025_69420__OclAny.initOperations(_CVE_2025_69420__OclAny);
			Fragments._CVE_2025_69420__OclElement.initOperations(_CVE_2025_69420__OclElement);
			Fragments._CVE_2025_69420__Vulnerability.initOperations(_CVE_2025_69420__Vulnerability);

			Fragments._CVE_2025_69421__CVE_2025_69421.initOperations(_CVE_2025_69421__CVE_2025_69421);
			Fragments._CVE_2025_69421__OclAny.initOperations(_CVE_2025_69421__OclAny);
			Fragments._CVE_2025_69421__OclElement.initOperations(_CVE_2025_69421__OclElement);
			Fragments._CVE_2025_69421__Vulnerability.initOperations(_CVE_2025_69421__Vulnerability);

			Fragments._CVE_2026_22795__CVE_2026_22795.initOperations(_CVE_2026_22795__CVE_2026_22795);
			Fragments._CVE_2026_22795__OclAny.initOperations(_CVE_2026_22795__OclAny);
			Fragments._CVE_2026_22795__OclElement.initOperations(_CVE_2026_22795__OclElement);
			Fragments._CVE_2026_22795__Vulnerability.initOperations(_CVE_2026_22795__Vulnerability);

			Fragments._CVE_2026_22796__CVE_2026_22796.initOperations(_CVE_2026_22796__CVE_2026_22796);
			Fragments._CVE_2026_22796__OclAny.initOperations(_CVE_2026_22796__OclAny);
			Fragments._CVE_2026_22796__OclElement.initOperations(_CVE_2026_22796__OclElement);
			Fragments._CVE_2026_22796__Vulnerability.initOperations(_CVE_2026_22796__Vulnerability);

			Fragments._CVE_2026_27970__CVE_2026_27970.initOperations(_CVE_2026_27970__CVE_2026_27970);
			Fragments._CVE_2026_27970__OclAny.initOperations(_CVE_2026_27970__OclAny);
			Fragments._CVE_2026_27970__OclElement.initOperations(_CVE_2026_27970__OclElement);
			Fragments._CVE_2026_27970__Vulnerability.initOperations(_CVE_2026_27970__Vulnerability);

			Fragments._CVSSVector__CVSSVector.initOperations(_CVSSVector__CVSSVector);
			Fragments._CVSSVector__OclAny.initOperations(_CVSSVector__OclAny);
			Fragments._CVSSVector__OclElement.initOperations(_CVSSVector__OclElement);

			Fragments._CommentWriteRead__CommentWriteRead.initOperations(_CommentWriteRead__CommentWriteRead);
			Fragments._CommentWriteRead__FuncPersData.initOperations(_CommentWriteRead__FuncPersData);
			Fragments._CommentWriteRead__Function.initOperations(_CommentWriteRead__Function);
			Fragments._CommentWriteRead__OclAny.initOperations(_CommentWriteRead__OclAny);
			Fragments._CommentWriteRead__OclElement.initOperations(_CommentWriteRead__OclElement);

			Fragments._Component__Component.initOperations(_Component__Component);
			Fragments._Component__OclAny.initOperations(_Component__OclAny);
			Fragments._Component__OclElement.initOperations(_Component__OclElement);

			Fragments._Consent__Consent.initOperations(_Consent__Consent);
			Fragments._Consent__OclAny.initOperations(_Consent__OclAny);
			Fragments._Consent__OclElement.initOperations(_Consent__OclElement);

			Fragments._Data__Data.initOperations(_Data__Data);
			Fragments._Data__OclAny.initOperations(_Data__OclAny);
			Fragments._Data__OclElement.initOperations(_Data__OclElement);

			Fragments._DataSubject__DataSubject.initOperations(_DataSubject__DataSubject);
			Fragments._DataSubject__OclAny.initOperations(_DataSubject__OclAny);
			Fragments._DataSubject__OclElement.initOperations(_DataSubject__OclElement);

			Fragments._DeviceLocation__Data.initOperations(_DeviceLocation__Data);
			Fragments._DeviceLocation__DeviceLocation.initOperations(_DeviceLocation__DeviceLocation);
			Fragments._DeviceLocation__OclAny.initOperations(_DeviceLocation__OclAny);
			Fragments._DeviceLocation__OclElement.initOperations(_DeviceLocation__OclElement);
			Fragments._DeviceLocation__PersonalData.initOperations(_DeviceLocation__PersonalData);

			Fragments._DeviceType__Data.initOperations(_DeviceType__Data);
			Fragments._DeviceType__DeviceType.initOperations(_DeviceType__DeviceType);
			Fragments._DeviceType__OclAny.initOperations(_DeviceType__OclAny);
			Fragments._DeviceType__OclElement.initOperations(_DeviceType__OclElement);
			Fragments._DeviceType__PersonalData.initOperations(_DeviceType__PersonalData);

			Fragments._EmailAddress__Data.initOperations(_EmailAddress__Data);
			Fragments._EmailAddress__EmailAddress.initOperations(_EmailAddress__EmailAddress);
			Fragments._EmailAddress__OclAny.initOperations(_EmailAddress__OclAny);
			Fragments._EmailAddress__OclElement.initOperations(_EmailAddress__OclElement);
			Fragments._EmailAddress__PersonalData.initOperations(_EmailAddress__PersonalData);

			Fragments._ExpressJS__Component.initOperations(_ExpressJS__Component);
			Fragments._ExpressJS__ExpressJS.initOperations(_ExpressJS__ExpressJS);
			Fragments._ExpressJS__OclAny.initOperations(_ExpressJS__OclAny);
			Fragments._ExpressJS__OclElement.initOperations(_ExpressJS__OclElement);

			Fragments._FilesystemComponent__Component.initOperations(_FilesystemComponent__Component);
			Fragments._FilesystemComponent__FilesystemComponent.initOperations(_FilesystemComponent__FilesystemComponent);
			Fragments._FilesystemComponent__OclAny.initOperations(_FilesystemComponent__OclAny);
			Fragments._FilesystemComponent__OclElement.initOperations(_FilesystemComponent__OclElement);

			Fragments._FuncPersData__FuncPersData.initOperations(_FuncPersData__FuncPersData);
			Fragments._FuncPersData__Function.initOperations(_FuncPersData__Function);
			Fragments._FuncPersData__OclAny.initOperations(_FuncPersData__OclAny);
			Fragments._FuncPersData__OclElement.initOperations(_FuncPersData__OclElement);

			Fragments._Function__Function.initOperations(_Function__Function);
			Fragments._Function__OclAny.initOperations(_Function__OclAny);
			Fragments._Function__OclElement.initOperations(_Function__OclElement);

			Fragments._LiveStreamVideo__FuncPersData.initOperations(_LiveStreamVideo__FuncPersData);
			Fragments._LiveStreamVideo__Function.initOperations(_LiveStreamVideo__Function);
			Fragments._LiveStreamVideo__LiveStreamVideo.initOperations(_LiveStreamVideo__LiveStreamVideo);
			Fragments._LiveStreamVideo__OclAny.initOperations(_LiveStreamVideo__OclAny);
			Fragments._LiveStreamVideo__OclElement.initOperations(_LiveStreamVideo__OclElement);

			Fragments._Moderator__DataSubject.initOperations(_Moderator__DataSubject);
			Fragments._Moderator__Moderator.initOperations(_Moderator__Moderator);
			Fragments._Moderator__OclAny.initOperations(_Moderator__OclAny);
			Fragments._Moderator__OclElement.initOperations(_Moderator__OclElement);

			Fragments._Nginx__Component.initOperations(_Nginx__Component);
			Fragments._Nginx__Nginx.initOperations(_Nginx__Nginx);
			Fragments._Nginx__OclAny.initOperations(_Nginx__OclAny);
			Fragments._Nginx__OclElement.initOperations(_Nginx__OclElement);

			Fragments._NonPersonalData__Data.initOperations(_NonPersonalData__Data);
			Fragments._NonPersonalData__NonPersonalData.initOperations(_NonPersonalData__NonPersonalData);
			Fragments._NonPersonalData__OclAny.initOperations(_NonPersonalData__OclAny);
			Fragments._NonPersonalData__OclElement.initOperations(_NonPersonalData__OclElement);

			Fragments._P2PStreaming__FuncPersData.initOperations(_P2PStreaming__FuncPersData);
			Fragments._P2PStreaming__Function.initOperations(_P2PStreaming__Function);
			Fragments._P2PStreaming__OclAny.initOperations(_P2PStreaming__OclAny);
			Fragments._P2PStreaming__OclElement.initOperations(_P2PStreaming__OclElement);
			Fragments._P2PStreaming__P2PStreaming.initOperations(_P2PStreaming__P2PStreaming);

			Fragments._PBehaviorTargetedAds__OclAny.initOperations(_PBehaviorTargetedAds__OclAny);
			Fragments._PBehaviorTargetedAds__OclElement.initOperations(_PBehaviorTargetedAds__OclElement);
			Fragments._PBehaviorTargetedAds__PBehaviorTargetedAds.initOperations(_PBehaviorTargetedAds__PBehaviorTargetedAds);
			Fragments._PBehaviorTargetedAds__PMarketing.initOperations(_PBehaviorTargetedAds__PMarketing);
			Fragments._PBehaviorTargetedAds__PTargetedAds.initOperations(_PBehaviorTargetedAds__PTargetedAds);
			Fragments._PBehaviorTargetedAds__Purpose.initOperations(_PBehaviorTargetedAds__Purpose);
			Fragments._PBehaviorTargetedAds__PurposeConsent.initOperations(_PBehaviorTargetedAds__PurposeConsent);

			Fragments._PComments__OclAny.initOperations(_PComments__OclAny);
			Fragments._PComments__OclElement.initOperations(_PComments__OclElement);
			Fragments._PComments__PComments.initOperations(_PComments__PComments);
			Fragments._PComments__PSocial.initOperations(_PComments__PSocial);
			Fragments._PComments__Purpose.initOperations(_PComments__Purpose);
			Fragments._PComments__PurposeConsent.initOperations(_PComments__PurposeConsent);

			Fragments._PFirstPartyProfiling__OclAny.initOperations(_PFirstPartyProfiling__OclAny);
			Fragments._PFirstPartyProfiling__OclElement.initOperations(_PFirstPartyProfiling__OclElement);
			Fragments._PFirstPartyProfiling__PFirstPartyProfiling.initOperations(_PFirstPartyProfiling__PFirstPartyProfiling);
			Fragments._PFirstPartyProfiling__PProfiling.initOperations(_PFirstPartyProfiling__PProfiling);
			Fragments._PFirstPartyProfiling__Purpose.initOperations(_PFirstPartyProfiling__Purpose);
			Fragments._PFirstPartyProfiling__PurposeConsent.initOperations(_PFirstPartyProfiling__PurposeConsent);

			Fragments._PLocationTargetedAds__OclAny.initOperations(_PLocationTargetedAds__OclAny);
			Fragments._PLocationTargetedAds__OclElement.initOperations(_PLocationTargetedAds__OclElement);
			Fragments._PLocationTargetedAds__PLocationTargetedAds.initOperations(_PLocationTargetedAds__PLocationTargetedAds);
			Fragments._PLocationTargetedAds__PMarketing.initOperations(_PLocationTargetedAds__PMarketing);
			Fragments._PLocationTargetedAds__PTargetedAds.initOperations(_PLocationTargetedAds__PTargetedAds);
			Fragments._PLocationTargetedAds__Purpose.initOperations(_PLocationTargetedAds__Purpose);
			Fragments._PLocationTargetedAds__PurposeConsent.initOperations(_PLocationTargetedAds__PurposeConsent);

			Fragments._PMarketing__OclAny.initOperations(_PMarketing__OclAny);
			Fragments._PMarketing__OclElement.initOperations(_PMarketing__OclElement);
			Fragments._PMarketing__PMarketing.initOperations(_PMarketing__PMarketing);
			Fragments._PMarketing__Purpose.initOperations(_PMarketing__Purpose);
			Fragments._PMarketing__PurposeConsent.initOperations(_PMarketing__PurposeConsent);

			Fragments._PP2PStreaming__OclAny.initOperations(_PP2PStreaming__OclAny);
			Fragments._PP2PStreaming__OclElement.initOperations(_PP2PStreaming__OclElement);
			Fragments._PP2PStreaming__PP2PStreaming.initOperations(_PP2PStreaming__PP2PStreaming);
			Fragments._PP2PStreaming__PUserExperience.initOperations(_PP2PStreaming__PUserExperience);
			Fragments._PP2PStreaming__Purpose.initOperations(_PP2PStreaming__Purpose);
			Fragments._PP2PStreaming__PurposeConsent.initOperations(_PP2PStreaming__PurposeConsent);

			Fragments._PProfiling__OclAny.initOperations(_PProfiling__OclAny);
			Fragments._PProfiling__OclElement.initOperations(_PProfiling__OclElement);
			Fragments._PProfiling__PProfiling.initOperations(_PProfiling__PProfiling);
			Fragments._PProfiling__Purpose.initOperations(_PProfiling__Purpose);
			Fragments._PProfiling__PurposeConsent.initOperations(_PProfiling__PurposeConsent);

			Fragments._PSocial__OclAny.initOperations(_PSocial__OclAny);
			Fragments._PSocial__OclElement.initOperations(_PSocial__OclElement);
			Fragments._PSocial__PSocial.initOperations(_PSocial__PSocial);
			Fragments._PSocial__Purpose.initOperations(_PSocial__Purpose);
			Fragments._PSocial__PurposeConsent.initOperations(_PSocial__PurposeConsent);

			Fragments._PStandardAds__OclAny.initOperations(_PStandardAds__OclAny);
			Fragments._PStandardAds__OclElement.initOperations(_PStandardAds__OclElement);
			Fragments._PStandardAds__PMarketing.initOperations(_PStandardAds__PMarketing);
			Fragments._PStandardAds__PStandardAds.initOperations(_PStandardAds__PStandardAds);
			Fragments._PStandardAds__Purpose.initOperations(_PStandardAds__Purpose);
			Fragments._PStandardAds__PurposeConsent.initOperations(_PStandardAds__PurposeConsent);

			Fragments._PTargetedAds__OclAny.initOperations(_PTargetedAds__OclAny);
			Fragments._PTargetedAds__OclElement.initOperations(_PTargetedAds__OclElement);
			Fragments._PTargetedAds__PMarketing.initOperations(_PTargetedAds__PMarketing);
			Fragments._PTargetedAds__PTargetedAds.initOperations(_PTargetedAds__PTargetedAds);
			Fragments._PTargetedAds__Purpose.initOperations(_PTargetedAds__Purpose);
			Fragments._PTargetedAds__PurposeConsent.initOperations(_PTargetedAds__PurposeConsent);

			Fragments._PThirdPartyProfiling__OclAny.initOperations(_PThirdPartyProfiling__OclAny);
			Fragments._PThirdPartyProfiling__OclElement.initOperations(_PThirdPartyProfiling__OclElement);
			Fragments._PThirdPartyProfiling__PFirstPartyProfiling.initOperations(_PThirdPartyProfiling__PFirstPartyProfiling);
			Fragments._PThirdPartyProfiling__PProfiling.initOperations(_PThirdPartyProfiling__PProfiling);
			Fragments._PThirdPartyProfiling__PThirdPartyProfiling.initOperations(_PThirdPartyProfiling__PThirdPartyProfiling);
			Fragments._PThirdPartyProfiling__Purpose.initOperations(_PThirdPartyProfiling__Purpose);
			Fragments._PThirdPartyProfiling__PurposeConsent.initOperations(_PThirdPartyProfiling__PurposeConsent);

			Fragments._PUserExperience__OclAny.initOperations(_PUserExperience__OclAny);
			Fragments._PUserExperience__OclElement.initOperations(_PUserExperience__OclElement);
			Fragments._PUserExperience__PUserExperience.initOperations(_PUserExperience__PUserExperience);
			Fragments._PUserExperience__Purpose.initOperations(_PUserExperience__Purpose);
			Fragments._PUserExperience__PurposeConsent.initOperations(_PUserExperience__PurposeConsent);

			Fragments._PVideoRecommendation__OclAny.initOperations(_PVideoRecommendation__OclAny);
			Fragments._PVideoRecommendation__OclElement.initOperations(_PVideoRecommendation__OclElement);
			Fragments._PVideoRecommendation__PUserExperience.initOperations(_PVideoRecommendation__PUserExperience);
			Fragments._PVideoRecommendation__PVideoRecommendation.initOperations(_PVideoRecommendation__PVideoRecommendation);
			Fragments._PVideoRecommendation__Purpose.initOperations(_PVideoRecommendation__Purpose);
			Fragments._PVideoRecommendation__PurposeConsent.initOperations(_PVideoRecommendation__PurposeConsent);

			Fragments._PVideoSharing__OclAny.initOperations(_PVideoSharing__OclAny);
			Fragments._PVideoSharing__OclElement.initOperations(_PVideoSharing__OclElement);
			Fragments._PVideoSharing__PComments.initOperations(_PVideoSharing__PComments);
			Fragments._PVideoSharing__PSocial.initOperations(_PVideoSharing__PSocial);
			Fragments._PVideoSharing__PVideoSharing.initOperations(_PVideoSharing__PVideoSharing);
			Fragments._PVideoSharing__Purpose.initOperations(_PVideoSharing__Purpose);
			Fragments._PVideoSharing__PurposeConsent.initOperations(_PVideoSharing__PurposeConsent);

			Fragments._Password__Data.initOperations(_Password__Data);
			Fragments._Password__OclAny.initOperations(_Password__OclAny);
			Fragments._Password__OclElement.initOperations(_Password__OclElement);
			Fragments._Password__Password.initOperations(_Password__Password);
			Fragments._Password__PersonalData.initOperations(_Password__PersonalData);

			Fragments._Payment__Data.initOperations(_Payment__Data);
			Fragments._Payment__OclAny.initOperations(_Payment__OclAny);
			Fragments._Payment__OclElement.initOperations(_Payment__OclElement);
			Fragments._Payment__Payment.initOperations(_Payment__Payment);
			Fragments._Payment__PersonalData.initOperations(_Payment__PersonalData);

			Fragments._PersonalData__Data.initOperations(_PersonalData__Data);
			Fragments._PersonalData__OclAny.initOperations(_PersonalData__OclAny);
			Fragments._PersonalData__OclElement.initOperations(_PersonalData__OclElement);
			Fragments._PersonalData__PersonalData.initOperations(_PersonalData__PersonalData);

			Fragments._Postgresql__Component.initOperations(_Postgresql__Component);
			Fragments._Postgresql__OclAny.initOperations(_Postgresql__OclAny);
			Fragments._Postgresql__OclElement.initOperations(_Postgresql__OclElement);
			Fragments._Postgresql__Postgresql.initOperations(_Postgresql__Postgresql);

			Fragments._Purpose__OclAny.initOperations(_Purpose__OclAny);
			Fragments._Purpose__OclElement.initOperations(_Purpose__OclElement);
			Fragments._Purpose__Purpose.initOperations(_Purpose__Purpose);

			Fragments._PurposeConsent__OclAny.initOperations(_PurposeConsent__OclAny);
			Fragments._PurposeConsent__OclElement.initOperations(_PurposeConsent__OclElement);
			Fragments._PurposeConsent__Purpose.initOperations(_PurposeConsent__Purpose);
			Fragments._PurposeConsent__PurposeConsent.initOperations(_PurposeConsent__PurposeConsent);

			Fragments._PurposeNoConsent__OclAny.initOperations(_PurposeNoConsent__OclAny);
			Fragments._PurposeNoConsent__OclElement.initOperations(_PurposeNoConsent__OclElement);
			Fragments._PurposeNoConsent__Purpose.initOperations(_PurposeNoConsent__Purpose);
			Fragments._PurposeNoConsent__PurposeNoConsent.initOperations(_PurposeNoConsent__PurposeNoConsent);

			Fragments._RecommendVideos__FuncPersData.initOperations(_RecommendVideos__FuncPersData);
			Fragments._RecommendVideos__Function.initOperations(_RecommendVideos__Function);
			Fragments._RecommendVideos__OclAny.initOperations(_RecommendVideos__OclAny);
			Fragments._RecommendVideos__OclElement.initOperations(_RecommendVideos__OclElement);
			Fragments._RecommendVideos__RecommendVideos.initOperations(_RecommendVideos__RecommendVideos);

			Fragments._RedisComponent__Component.initOperations(_RedisComponent__Component);
			Fragments._RedisComponent__OclAny.initOperations(_RedisComponent__OclAny);
			Fragments._RedisComponent__OclElement.initOperations(_RedisComponent__OclElement);
			Fragments._RedisComponent__RedisComponent.initOperations(_RedisComponent__RedisComponent);

			Fragments._RemoveVideo__FuncPersData.initOperations(_RemoveVideo__FuncPersData);
			Fragments._RemoveVideo__Function.initOperations(_RemoveVideo__Function);
			Fragments._RemoveVideo__OclAny.initOperations(_RemoveVideo__OclAny);
			Fragments._RemoveVideo__OclElement.initOperations(_RemoveVideo__OclElement);
			Fragments._RemoveVideo__RemoveVideo.initOperations(_RemoveVideo__RemoveVideo);

			Fragments._RequestTimestamps__Data.initOperations(_RequestTimestamps__Data);
			Fragments._RequestTimestamps__OclAny.initOperations(_RequestTimestamps__OclAny);
			Fragments._RequestTimestamps__OclElement.initOperations(_RequestTimestamps__OclElement);
			Fragments._RequestTimestamps__PersonalData.initOperations(_RequestTimestamps__PersonalData);
			Fragments._RequestTimestamps__RequestTimestamps.initOperations(_RequestTimestamps__RequestTimestamps);

			Fragments._Risk__OclAny.initOperations(_Risk__OclAny);
			Fragments._Risk__OclElement.initOperations(_Risk__OclElement);
			Fragments._Risk__Risk.initOperations(_Risk__Risk);

			Fragments._ServeBehaviorTargetedAds__FuncPersData.initOperations(_ServeBehaviorTargetedAds__FuncPersData);
			Fragments._ServeBehaviorTargetedAds__Function.initOperations(_ServeBehaviorTargetedAds__Function);
			Fragments._ServeBehaviorTargetedAds__OclAny.initOperations(_ServeBehaviorTargetedAds__OclAny);
			Fragments._ServeBehaviorTargetedAds__OclElement.initOperations(_ServeBehaviorTargetedAds__OclElement);
			Fragments._ServeBehaviorTargetedAds__ServeBehaviorTargetedAds.initOperations(_ServeBehaviorTargetedAds__ServeBehaviorTargetedAds);

			Fragments._ServeLocationTargetedAds__FuncPersData.initOperations(_ServeLocationTargetedAds__FuncPersData);
			Fragments._ServeLocationTargetedAds__Function.initOperations(_ServeLocationTargetedAds__Function);
			Fragments._ServeLocationTargetedAds__OclAny.initOperations(_ServeLocationTargetedAds__OclAny);
			Fragments._ServeLocationTargetedAds__OclElement.initOperations(_ServeLocationTargetedAds__OclElement);
			Fragments._ServeLocationTargetedAds__ServeLocationTargetedAds.initOperations(_ServeLocationTargetedAds__ServeLocationTargetedAds);

			Fragments._ServeStandardAds__FuncPersData.initOperations(_ServeStandardAds__FuncPersData);
			Fragments._ServeStandardAds__Function.initOperations(_ServeStandardAds__Function);
			Fragments._ServeStandardAds__OclAny.initOperations(_ServeStandardAds__OclAny);
			Fragments._ServeStandardAds__OclElement.initOperations(_ServeStandardAds__OclElement);
			Fragments._ServeStandardAds__ServeStandardAds.initOperations(_ServeStandardAds__ServeStandardAds);

			Fragments._StreamVideo__FuncPersData.initOperations(_StreamVideo__FuncPersData);
			Fragments._StreamVideo__Function.initOperations(_StreamVideo__Function);
			Fragments._StreamVideo__OclAny.initOperations(_StreamVideo__OclAny);
			Fragments._StreamVideo__OclElement.initOperations(_StreamVideo__OclElement);
			Fragments._StreamVideo__StreamVideo.initOperations(_StreamVideo__StreamVideo);

			Fragments._StreamingHistory__Data.initOperations(_StreamingHistory__Data);
			Fragments._StreamingHistory__OclAny.initOperations(_StreamingHistory__OclAny);
			Fragments._StreamingHistory__OclElement.initOperations(_StreamingHistory__OclElement);
			Fragments._StreamingHistory__PersonalData.initOperations(_StreamingHistory__PersonalData);
			Fragments._StreamingHistory__StreamingHistory.initOperations(_StreamingHistory__StreamingHistory);

			Fragments._System__OclAny.initOperations(_System__OclAny);
			Fragments._System__OclElement.initOperations(_System__OclElement);
			Fragments._System__System.initOperations(_System__System);

			Fragments._TrackingCookie__Data.initOperations(_TrackingCookie__Data);
			Fragments._TrackingCookie__OclAny.initOperations(_TrackingCookie__OclAny);
			Fragments._TrackingCookie__OclElement.initOperations(_TrackingCookie__OclElement);
			Fragments._TrackingCookie__PersonalData.initOperations(_TrackingCookie__PersonalData);
			Fragments._TrackingCookie__TrackingCookie.initOperations(_TrackingCookie__TrackingCookie);

			Fragments._UploadVideo__FuncPersData.initOperations(_UploadVideo__FuncPersData);
			Fragments._UploadVideo__Function.initOperations(_UploadVideo__Function);
			Fragments._UploadVideo__OclAny.initOperations(_UploadVideo__OclAny);
			Fragments._UploadVideo__OclElement.initOperations(_UploadVideo__OclElement);
			Fragments._UploadVideo__UploadVideo.initOperations(_UploadVideo__UploadVideo);

			Fragments._User__DataSubject.initOperations(_User__DataSubject);
			Fragments._User__OclAny.initOperations(_User__OclAny);
			Fragments._User__OclElement.initOperations(_User__OclElement);
			Fragments._User__User.initOperations(_User__User);

			Fragments._Username__Data.initOperations(_Username__Data);
			Fragments._Username__OclAny.initOperations(_Username__OclAny);
			Fragments._Username__OclElement.initOperations(_Username__OclElement);
			Fragments._Username__PersonalData.initOperations(_Username__PersonalData);
			Fragments._Username__Username.initOperations(_Username__Username);

			Fragments._VideoComment__Data.initOperations(_VideoComment__Data);
			Fragments._VideoComment__OclAny.initOperations(_VideoComment__OclAny);
			Fragments._VideoComment__OclElement.initOperations(_VideoComment__OclElement);
			Fragments._VideoComment__PersonalData.initOperations(_VideoComment__PersonalData);
			Fragments._VideoComment__VideoComment.initOperations(_VideoComment__VideoComment);

			Fragments._VideoContent__Data.initOperations(_VideoContent__Data);
			Fragments._VideoContent__OclAny.initOperations(_VideoContent__OclAny);
			Fragments._VideoContent__OclElement.initOperations(_VideoContent__OclElement);
			Fragments._VideoContent__PersonalData.initOperations(_VideoContent__PersonalData);
			Fragments._VideoContent__VideoContent.initOperations(_VideoContent__VideoContent);

			Fragments._VideoMetadata__Data.initOperations(_VideoMetadata__Data);
			Fragments._VideoMetadata__OclAny.initOperations(_VideoMetadata__OclAny);
			Fragments._VideoMetadata__OclElement.initOperations(_VideoMetadata__OclElement);
			Fragments._VideoMetadata__PersonalData.initOperations(_VideoMetadata__PersonalData);
			Fragments._VideoMetadata__VideoMetadata.initOperations(_VideoMetadata__VideoMetadata);

			Fragments._Vulnerability__OclAny.initOperations(_Vulnerability__OclAny);
			Fragments._Vulnerability__OclElement.initOperations(_Vulnerability__OclElement);
			Fragments._Vulnerability__Vulnerability.initOperations(_Vulnerability__Vulnerability);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::FragmentOperations and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of local properties for the local fragment of each type.
	 */
	public static class FragmentProperties {
		static {
			Init.initStart();
			FragmentOperations.init();
		}

		private static final ExecutorProperty /*@NonNull*/ [] _Administrator = {
			CASATables.Properties._DataSubject__affectedBy,
			CASATables.Properties._DataSubject__gives,
			CASATables.Properties._DataSubject__identifiedBy,
			CASATables.Properties._DataSubject__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _AngularSPA = {
			CASATables.Properties._Component__affectedBy,
			CASATables.Properties._Component__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Component__realizes
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2018_16843 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2018_16844 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2018_16845 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2019_9511 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2019_9513 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2019_9516 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2021_23017 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2021_3618 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2022_24834 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2022_36021 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2022_41862 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2023_2455 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2023_25155 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2023_28856 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2023_44487 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2023_45145 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2023_46809 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2023_5870 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_0985 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_10976 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_10977 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_10978 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_10979 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_21890 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_21891 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_21896 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_22017 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_22018 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_22019 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_22020 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_22025 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_27980 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_27983 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_31449 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_31489 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_3566 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_36137 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_36138 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_37372 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_46981 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_5205 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_7347 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2024_7348 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_1094 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_11187 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_15468 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_21605 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_23084 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_23090 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_32023 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_62506 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_62507 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_66199 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_69418 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_69420 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2025_69421 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2026_22795 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2026_22796 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVE_2026_27970 = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CVSSVector = {
			CASATables.Properties._CVSSVector__attackComplexity,
			CASATables.Properties._CVSSVector__attackVector,
			CASATables.Properties._CVSSVector__availabilityImpact,
			CASATables.Properties._CVSSVector__availabilityRequirement,
			CASATables.Properties._CVSSVector__confidentialityImpact,
			CASATables.Properties._CVSSVector__confidentialityRequirement,
			CASATables.Properties._CVSSVector__exploitCodeMaturity,
			CASATables.Properties._CVSSVector__integrityImpact,
			CASATables.Properties._CVSSVector__integrityRequirement,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._CVSSVector__privilegesRequired,
			CASATables.Properties._CVSSVector__remediationLevel,
			CASATables.Properties._CVSSVector__reportConfidence,
			CASATables.Properties._CVSSVector__scope,
			CASATables.Properties._CVSSVector__userInteraction
		};

		private static final ExecutorProperty /*@NonNull*/ [] _CommentWriteRead = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Component = {
			CASATables.Properties._Component__affectedBy,
			CASATables.Properties._Component__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Component__realizes
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Consent = {
			CASATables.Properties._Consent__forPersonalData,
			CASATables.Properties._Consent__forPurpose,
			CASATables.Properties._Consent__givenBy,
			CASATables.Properties._Consent__givenFor,
			CASATables.Properties._Consent__informedRiskLevel,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Data = {
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _DataSubject = {
			CASATables.Properties._DataSubject__affectedBy,
			CASATables.Properties._DataSubject__gives,
			CASATables.Properties._DataSubject__identifiedBy,
			CASATables.Properties._DataSubject__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _DeviceLocation = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _DeviceType = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _EmailAddress = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ExpressJS = {
			CASATables.Properties._Component__affectedBy,
			CASATables.Properties._Component__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Component__realizes
		};

		private static final ExecutorProperty /*@NonNull*/ [] _FilesystemComponent = {
			CASATables.Properties._Component__affectedBy,
			CASATables.Properties._Component__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Component__realizes
		};

		private static final ExecutorProperty /*@NonNull*/ [] _FuncPersData = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Function = {
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _LiveStreamVideo = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Moderator = {
			CASATables.Properties._DataSubject__affectedBy,
			CASATables.Properties._DataSubject__gives,
			CASATables.Properties._DataSubject__identifiedBy,
			CASATables.Properties._DataSubject__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Nginx = {
			CASATables.Properties._Component__affectedBy,
			CASATables.Properties._Component__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Component__realizes
		};

		private static final ExecutorProperty /*@NonNull*/ [] _NonPersonalData = {
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._NonPersonalData__processedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _P2PStreaming = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PBehaviorTargetedAds = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PComments = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PFirstPartyProfiling = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PLocationTargetedAds = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PMarketing = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PP2PStreaming = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PProfiling = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PSocial = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PStandardAds = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PTargetedAds = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PThirdPartyProfiling = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PUserExperience = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PVideoRecommendation = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PVideoSharing = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Password = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Payment = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PersonalData = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Postgresql = {
			CASATables.Properties._Component__affectedBy,
			CASATables.Properties._Component__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Component__realizes
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Purpose = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PurposeConsent = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction,
			CASATables.Properties._PurposeConsent__requires
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PurposeNoConsent = {
			CASATables.Properties._Purpose__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Purpose__ofFunction
		};

		private static final ExecutorProperty /*@NonNull*/ [] _RecommendVideos = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _RedisComponent = {
			CASATables.Properties._Component__affectedBy,
			CASATables.Properties._Component__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Component__realizes
		};

		private static final ExecutorProperty /*@NonNull*/ [] _RemoveVideo = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _RequestTimestamps = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Risk = {
			CASATables.Properties._Risk__affects,
			CASATables.Properties._Risk__causedBy,
			CASATables.Properties._Risk__level,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ServeBehaviorTargetedAds = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ServeLocationTargetedAds = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ServeStandardAds = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _StreamVideo = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _StreamingHistory = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _System = {
			CASATables.Properties._System__components,
			CASATables.Properties._System__dataSubjects,
			CASATables.Properties._System__datas,
			CASATables.Properties._System__functions,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._System__purposes,
			CASATables.Properties._System__vulnerabilities
		};

		private static final ExecutorProperty /*@NonNull*/ [] _TrackingCookie = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _UploadVideo = {
			CASATables.Properties._FuncPersData__has,
			CASATables.Properties._Function__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._Function__processes,
			CASATables.Properties._FuncPersData__processesPersData,
			CASATables.Properties._Function__realizedBy
		};

		private static final ExecutorProperty /*@NonNull*/ [] _User = {
			CASATables.Properties._DataSubject__affectedBy,
			CASATables.Properties._DataSubject__gives,
			CASATables.Properties._DataSubject__identifiedBy,
			CASATables.Properties._DataSubject__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Username = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _VideoComment = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _VideoContent = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _VideoMetadata = {
			CASATables.Properties._PersonalData__identifies,
			CASATables.Properties._Data__name,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents,
			CASATables.Properties._PersonalData__processedBy,
			CASATables.Properties._PersonalData__subjectOfConsent
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Vulnerability = {
			CASATables.Properties._Vulnerability__affects,
			CASATables.Properties._Vulnerability__causes,
			CASATables.Properties._Vulnerability__cveName,
			CASATables.Properties._Vulnerability__describedBy,
			CASATables.Properties._Vulnerability__isEnabled,
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._Administrator__Administrator.initProperties(_Administrator);
			Fragments._AngularSPA__AngularSPA.initProperties(_AngularSPA);
			Fragments._CVE_2018_16843__CVE_2018_16843.initProperties(_CVE_2018_16843);
			Fragments._CVE_2018_16844__CVE_2018_16844.initProperties(_CVE_2018_16844);
			Fragments._CVE_2018_16845__CVE_2018_16845.initProperties(_CVE_2018_16845);
			Fragments._CVE_2019_9511__CVE_2019_9511.initProperties(_CVE_2019_9511);
			Fragments._CVE_2019_9513__CVE_2019_9513.initProperties(_CVE_2019_9513);
			Fragments._CVE_2019_9516__CVE_2019_9516.initProperties(_CVE_2019_9516);
			Fragments._CVE_2021_23017__CVE_2021_23017.initProperties(_CVE_2021_23017);
			Fragments._CVE_2021_3618__CVE_2021_3618.initProperties(_CVE_2021_3618);
			Fragments._CVE_2022_24834__CVE_2022_24834.initProperties(_CVE_2022_24834);
			Fragments._CVE_2022_36021__CVE_2022_36021.initProperties(_CVE_2022_36021);
			Fragments._CVE_2022_41862__CVE_2022_41862.initProperties(_CVE_2022_41862);
			Fragments._CVE_2023_2455__CVE_2023_2455.initProperties(_CVE_2023_2455);
			Fragments._CVE_2023_25155__CVE_2023_25155.initProperties(_CVE_2023_25155);
			Fragments._CVE_2023_28856__CVE_2023_28856.initProperties(_CVE_2023_28856);
			Fragments._CVE_2023_44487__CVE_2023_44487.initProperties(_CVE_2023_44487);
			Fragments._CVE_2023_45145__CVE_2023_45145.initProperties(_CVE_2023_45145);
			Fragments._CVE_2023_46809__CVE_2023_46809.initProperties(_CVE_2023_46809);
			Fragments._CVE_2023_5870__CVE_2023_5870.initProperties(_CVE_2023_5870);
			Fragments._CVE_2024_0985__CVE_2024_0985.initProperties(_CVE_2024_0985);
			Fragments._CVE_2024_10976__CVE_2024_10976.initProperties(_CVE_2024_10976);
			Fragments._CVE_2024_10977__CVE_2024_10977.initProperties(_CVE_2024_10977);
			Fragments._CVE_2024_10978__CVE_2024_10978.initProperties(_CVE_2024_10978);
			Fragments._CVE_2024_10979__CVE_2024_10979.initProperties(_CVE_2024_10979);
			Fragments._CVE_2024_21890__CVE_2024_21890.initProperties(_CVE_2024_21890);
			Fragments._CVE_2024_21891__CVE_2024_21891.initProperties(_CVE_2024_21891);
			Fragments._CVE_2024_21896__CVE_2024_21896.initProperties(_CVE_2024_21896);
			Fragments._CVE_2024_22017__CVE_2024_22017.initProperties(_CVE_2024_22017);
			Fragments._CVE_2024_22018__CVE_2024_22018.initProperties(_CVE_2024_22018);
			Fragments._CVE_2024_22019__CVE_2024_22019.initProperties(_CVE_2024_22019);
			Fragments._CVE_2024_22020__CVE_2024_22020.initProperties(_CVE_2024_22020);
			Fragments._CVE_2024_22025__CVE_2024_22025.initProperties(_CVE_2024_22025);
			Fragments._CVE_2024_27980__CVE_2024_27980.initProperties(_CVE_2024_27980);
			Fragments._CVE_2024_27983__CVE_2024_27983.initProperties(_CVE_2024_27983);
			Fragments._CVE_2024_31449__CVE_2024_31449.initProperties(_CVE_2024_31449);
			Fragments._CVE_2024_31489__CVE_2024_31489.initProperties(_CVE_2024_31489);
			Fragments._CVE_2024_3566__CVE_2024_3566.initProperties(_CVE_2024_3566);
			Fragments._CVE_2024_36137__CVE_2024_36137.initProperties(_CVE_2024_36137);
			Fragments._CVE_2024_36138__CVE_2024_36138.initProperties(_CVE_2024_36138);
			Fragments._CVE_2024_37372__CVE_2024_37372.initProperties(_CVE_2024_37372);
			Fragments._CVE_2024_46981__CVE_2024_46981.initProperties(_CVE_2024_46981);
			Fragments._CVE_2024_5205__CVE_2024_5205.initProperties(_CVE_2024_5205);
			Fragments._CVE_2024_7347__CVE_2024_7347.initProperties(_CVE_2024_7347);
			Fragments._CVE_2024_7348__CVE_2024_7348.initProperties(_CVE_2024_7348);
			Fragments._CVE_2025_1094__CVE_2025_1094.initProperties(_CVE_2025_1094);
			Fragments._CVE_2025_11187__CVE_2025_11187.initProperties(_CVE_2025_11187);
			Fragments._CVE_2025_15468__CVE_2025_15468.initProperties(_CVE_2025_15468);
			Fragments._CVE_2025_21605__CVE_2025_21605.initProperties(_CVE_2025_21605);
			Fragments._CVE_2025_23084__CVE_2025_23084.initProperties(_CVE_2025_23084);
			Fragments._CVE_2025_23090__CVE_2025_23090.initProperties(_CVE_2025_23090);
			Fragments._CVE_2025_32023__CVE_2025_32023.initProperties(_CVE_2025_32023);
			Fragments._CVE_2025_62506__CVE_2025_62506.initProperties(_CVE_2025_62506);
			Fragments._CVE_2025_62507__CVE_2025_62507.initProperties(_CVE_2025_62507);
			Fragments._CVE_2025_66199__CVE_2025_66199.initProperties(_CVE_2025_66199);
			Fragments._CVE_2025_69418__CVE_2025_69418.initProperties(_CVE_2025_69418);
			Fragments._CVE_2025_69420__CVE_2025_69420.initProperties(_CVE_2025_69420);
			Fragments._CVE_2025_69421__CVE_2025_69421.initProperties(_CVE_2025_69421);
			Fragments._CVE_2026_22795__CVE_2026_22795.initProperties(_CVE_2026_22795);
			Fragments._CVE_2026_22796__CVE_2026_22796.initProperties(_CVE_2026_22796);
			Fragments._CVE_2026_27970__CVE_2026_27970.initProperties(_CVE_2026_27970);
			Fragments._CVSSVector__CVSSVector.initProperties(_CVSSVector);
			Fragments._CommentWriteRead__CommentWriteRead.initProperties(_CommentWriteRead);
			Fragments._Component__Component.initProperties(_Component);
			Fragments._Consent__Consent.initProperties(_Consent);
			Fragments._Data__Data.initProperties(_Data);
			Fragments._DataSubject__DataSubject.initProperties(_DataSubject);
			Fragments._DeviceLocation__DeviceLocation.initProperties(_DeviceLocation);
			Fragments._DeviceType__DeviceType.initProperties(_DeviceType);
			Fragments._EmailAddress__EmailAddress.initProperties(_EmailAddress);
			Fragments._ExpressJS__ExpressJS.initProperties(_ExpressJS);
			Fragments._FilesystemComponent__FilesystemComponent.initProperties(_FilesystemComponent);
			Fragments._FuncPersData__FuncPersData.initProperties(_FuncPersData);
			Fragments._Function__Function.initProperties(_Function);
			Fragments._LiveStreamVideo__LiveStreamVideo.initProperties(_LiveStreamVideo);
			Fragments._Moderator__Moderator.initProperties(_Moderator);
			Fragments._Nginx__Nginx.initProperties(_Nginx);
			Fragments._NonPersonalData__NonPersonalData.initProperties(_NonPersonalData);
			Fragments._P2PStreaming__P2PStreaming.initProperties(_P2PStreaming);
			Fragments._PBehaviorTargetedAds__PBehaviorTargetedAds.initProperties(_PBehaviorTargetedAds);
			Fragments._PComments__PComments.initProperties(_PComments);
			Fragments._PFirstPartyProfiling__PFirstPartyProfiling.initProperties(_PFirstPartyProfiling);
			Fragments._PLocationTargetedAds__PLocationTargetedAds.initProperties(_PLocationTargetedAds);
			Fragments._PMarketing__PMarketing.initProperties(_PMarketing);
			Fragments._PP2PStreaming__PP2PStreaming.initProperties(_PP2PStreaming);
			Fragments._PProfiling__PProfiling.initProperties(_PProfiling);
			Fragments._PSocial__PSocial.initProperties(_PSocial);
			Fragments._PStandardAds__PStandardAds.initProperties(_PStandardAds);
			Fragments._PTargetedAds__PTargetedAds.initProperties(_PTargetedAds);
			Fragments._PThirdPartyProfiling__PThirdPartyProfiling.initProperties(_PThirdPartyProfiling);
			Fragments._PUserExperience__PUserExperience.initProperties(_PUserExperience);
			Fragments._PVideoRecommendation__PVideoRecommendation.initProperties(_PVideoRecommendation);
			Fragments._PVideoSharing__PVideoSharing.initProperties(_PVideoSharing);
			Fragments._Password__Password.initProperties(_Password);
			Fragments._Payment__Payment.initProperties(_Payment);
			Fragments._PersonalData__PersonalData.initProperties(_PersonalData);
			Fragments._Postgresql__Postgresql.initProperties(_Postgresql);
			Fragments._Purpose__Purpose.initProperties(_Purpose);
			Fragments._PurposeConsent__PurposeConsent.initProperties(_PurposeConsent);
			Fragments._PurposeNoConsent__PurposeNoConsent.initProperties(_PurposeNoConsent);
			Fragments._RecommendVideos__RecommendVideos.initProperties(_RecommendVideos);
			Fragments._RedisComponent__RedisComponent.initProperties(_RedisComponent);
			Fragments._RemoveVideo__RemoveVideo.initProperties(_RemoveVideo);
			Fragments._RequestTimestamps__RequestTimestamps.initProperties(_RequestTimestamps);
			Fragments._Risk__Risk.initProperties(_Risk);
			Fragments._ServeBehaviorTargetedAds__ServeBehaviorTargetedAds.initProperties(_ServeBehaviorTargetedAds);
			Fragments._ServeLocationTargetedAds__ServeLocationTargetedAds.initProperties(_ServeLocationTargetedAds);
			Fragments._ServeStandardAds__ServeStandardAds.initProperties(_ServeStandardAds);
			Fragments._StreamVideo__StreamVideo.initProperties(_StreamVideo);
			Fragments._StreamingHistory__StreamingHistory.initProperties(_StreamingHistory);
			Fragments._System__System.initProperties(_System);
			Fragments._TrackingCookie__TrackingCookie.initProperties(_TrackingCookie);
			Fragments._UploadVideo__UploadVideo.initProperties(_UploadVideo);
			Fragments._User__User.initProperties(_User);
			Fragments._Username__Username.initProperties(_Username);
			Fragments._VideoComment__VideoComment.initProperties(_VideoComment);
			Fragments._VideoContent__VideoContent.initProperties(_VideoContent);
			Fragments._VideoMetadata__VideoMetadata.initProperties(_VideoMetadata);
			Fragments._Vulnerability__Vulnerability.initProperties(_Vulnerability);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::FragmentProperties and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 *	The lists of enumeration literals for each enumeration.
	 */
	public static class EnumerationLiterals {
		static {
			Init.initStart();
			FragmentProperties.init();
		}

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CASATables::EnumerationLiterals and all preceding sub-packages.
		 */
		public static void init() {}
	}

	/**
	 * The multiple packages above avoid problems with the Java 65536 byte limit but introduce a difficulty in ensuring that
	 * static construction occurs in the disciplined order of the packages when construction may start in any of the packages.
	 * The problem is resolved by ensuring that the static construction of each package first initializes its immediate predecessor.
	 * On completion of predecessor initialization, the residual packages are initialized by starting an initialization in the last package.
	 * This class maintains a count so that the various predecessors can distinguish whether they are the starting point and so
	 * ensure that residual construction occurs just once after all predecessors.
	 */
	private static class Init {
		/**
		 * Counter of nested static constructions. On return to zero residual construction starts. -ve once residual construction started.
		 */
		private static int initCount = 0;

		/**
		 * Invoked at the start of a static construction to defer residual construction until primary constructions complete.
		 */
		private static void initStart() {
			if (initCount >= 0) {
				initCount++;
			}
		}

		/**
		 * Invoked at the end of a static construction to activate residual construction once primary constructions complete.
		 */
		private static void initEnd() {
			if (initCount > 0) {
				if (--initCount == 0) {
					initCount = -1;
					EnumerationLiterals.init();
				}
			}
		}
	}

	static {
		Init.initEnd();
	}

	/*
	 * Force initialization of outer fields. Inner fields are lazily initialized.
	 */
	public static void init() {
		new CASATables();
	}

	private CASATables() {
		super(CASAPackage.eNS_URI);
	}

	/*
	 * The EClasses whose instances should be cached to support allInstances().
	 */
	private static final EClass allInstancesEClasses /*@NonNull*/ [] = {
		CASAPackage.Literals.PURPOSE,
		CASAPackage.Literals.VULNERABILITY
	};

	@Override
	public EClass /*@NonNull*/ [] basicGetAllInstancesClasses() {
		return allInstancesEClasses;
	}
}
