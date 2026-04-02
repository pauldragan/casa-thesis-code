/*******************************************************************************
 *************************************************************************
 * This code is 100% auto-generated
 * from:
 * using:
 *   /PhDThesisCode/src/thesis/CASA.genmodel
 *   org.eclipse.ocl.examples.codegen.oclinecore.OCLinEcoreTables
 *
 * Do not edit it.
 *******************************************************************************/
package CASA.CVSS;

// import CASA.CVSS.CVSSTables;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumeration;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorEnumerationLiteral;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorPackage;
import org.eclipse.ocl.pivot.internal.library.ecore.EcoreExecutorType;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorFragment;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorOperation;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorProperty;
import org.eclipse.ocl.pivot.internal.library.executor.ExecutorStandardLibrary;
import org.eclipse.ocl.pivot.oclstdlib.OCLstdlibTables;
import org.eclipse.ocl.pivot.utilities.AbstractTables;

/**
 * CVSSTables provides the dispatch tables for the CVSS for use by the OCL dispatcher.
 *
 * In order to ensure correct static initialization, a top level class element must be accessed
 * before any nested class element. Therefore an access to PACKAGE.getClass() is recommended.
 */
public class CVSSTables extends AbstractTables
{
	static {
		Init.initStart();
	}

	/**
	 *	The package descriptor for the package.
	 */
	public static final EcoreExecutorPackage PACKAGE = new EcoreExecutorPackage(CVSSPackage.eINSTANCE);

	/**
	 *	The library of all packages and types.
	 */
	public static final ExecutorStandardLibrary LIBRARY = OCLstdlibTables.LIBRARY;

	/**
	 *	Constants used by auto-generated code.
	 */

	/**
	 *	The type parameters for templated types and operations.
	 */
	public static class TypeParameters {
		static {
			Init.initStart();
			CVSSTables.init();
		}

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CVSSTables::TypeParameters and all preceding sub-packages.
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

		public static final EcoreExecutorEnumeration _AttackComplexity = new EcoreExecutorEnumeration(CVSSPackage.Literals.ATTACK_COMPLEXITY, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _AttackVector = new EcoreExecutorEnumeration(CVSSPackage.Literals.ATTACK_VECTOR, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _AvailabilityImpact = new EcoreExecutorEnumeration(CVSSPackage.Literals.AVAILABILITY_IMPACT, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _AvailabilityRequirement = new EcoreExecutorEnumeration(CVSSPackage.Literals.AVAILABILITY_REQUIREMENT, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _ConfidentialityImpact = new EcoreExecutorEnumeration(CVSSPackage.Literals.CONFIDENTIALITY_IMPACT, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _ConfidentialityRequirement = new EcoreExecutorEnumeration(CVSSPackage.Literals.CONFIDENTIALITY_REQUIREMENT, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _ExploitCodeMaturity = new EcoreExecutorEnumeration(CVSSPackage.Literals.EXPLOIT_CODE_MATURITY, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _IntegrityImpact = new EcoreExecutorEnumeration(CVSSPackage.Literals.INTEGRITY_IMPACT, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _IntegrityRequirement = new EcoreExecutorEnumeration(CVSSPackage.Literals.INTEGRITY_REQUIREMENT, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _PrivilegesRequired = new EcoreExecutorEnumeration(CVSSPackage.Literals.PRIVILEGES_REQUIRED, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _RemediationLevel = new EcoreExecutorEnumeration(CVSSPackage.Literals.REMEDIATION_LEVEL, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _ReportConfidence = new EcoreExecutorEnumeration(CVSSPackage.Literals.REPORT_CONFIDENCE, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _Scope = new EcoreExecutorEnumeration(CVSSPackage.Literals.SCOPE, PACKAGE, 0);
		public static final EcoreExecutorEnumeration _UserInteraction = new EcoreExecutorEnumeration(CVSSPackage.Literals.USER_INTERACTION, PACKAGE, 0);

		private static final EcoreExecutorType /*@NonNull*/ [] types = {
			_AttackComplexity,
			_AttackVector,
			_AvailabilityImpact,
			_AvailabilityRequirement,
			_ConfidentialityImpact,
			_ConfidentialityRequirement,
			_ExploitCodeMaturity,
			_IntegrityImpact,
			_IntegrityRequirement,
			_PrivilegesRequired,
			_RemediationLevel,
			_ReportConfidence,
			_Scope,
			_UserInteraction
		};

		/*
		 *	Install the type descriptors in the package descriptor.
		 */
		static {
			PACKAGE.init(LIBRARY, types);
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CVSSTables::Types and all preceding sub-packages.
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

		private static final ExecutorFragment _AttackComplexity__AttackComplexity = new ExecutorFragment(Types._AttackComplexity, CVSSTables.Types._AttackComplexity);
		private static final ExecutorFragment _AttackComplexity__OclAny = new ExecutorFragment(Types._AttackComplexity, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _AttackComplexity__OclElement = new ExecutorFragment(Types._AttackComplexity, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _AttackComplexity__OclEnumeration = new ExecutorFragment(Types._AttackComplexity, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _AttackComplexity__OclType = new ExecutorFragment(Types._AttackComplexity, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _AttackVector__AttackVector = new ExecutorFragment(Types._AttackVector, CVSSTables.Types._AttackVector);
		private static final ExecutorFragment _AttackVector__OclAny = new ExecutorFragment(Types._AttackVector, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _AttackVector__OclElement = new ExecutorFragment(Types._AttackVector, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _AttackVector__OclEnumeration = new ExecutorFragment(Types._AttackVector, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _AttackVector__OclType = new ExecutorFragment(Types._AttackVector, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _AvailabilityImpact__AvailabilityImpact = new ExecutorFragment(Types._AvailabilityImpact, CVSSTables.Types._AvailabilityImpact);
		private static final ExecutorFragment _AvailabilityImpact__OclAny = new ExecutorFragment(Types._AvailabilityImpact, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _AvailabilityImpact__OclElement = new ExecutorFragment(Types._AvailabilityImpact, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _AvailabilityImpact__OclEnumeration = new ExecutorFragment(Types._AvailabilityImpact, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _AvailabilityImpact__OclType = new ExecutorFragment(Types._AvailabilityImpact, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _AvailabilityRequirement__AvailabilityRequirement = new ExecutorFragment(Types._AvailabilityRequirement, CVSSTables.Types._AvailabilityRequirement);
		private static final ExecutorFragment _AvailabilityRequirement__OclAny = new ExecutorFragment(Types._AvailabilityRequirement, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _AvailabilityRequirement__OclElement = new ExecutorFragment(Types._AvailabilityRequirement, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _AvailabilityRequirement__OclEnumeration = new ExecutorFragment(Types._AvailabilityRequirement, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _AvailabilityRequirement__OclType = new ExecutorFragment(Types._AvailabilityRequirement, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _ConfidentialityImpact__ConfidentialityImpact = new ExecutorFragment(Types._ConfidentialityImpact, CVSSTables.Types._ConfidentialityImpact);
		private static final ExecutorFragment _ConfidentialityImpact__OclAny = new ExecutorFragment(Types._ConfidentialityImpact, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ConfidentialityImpact__OclElement = new ExecutorFragment(Types._ConfidentialityImpact, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _ConfidentialityImpact__OclEnumeration = new ExecutorFragment(Types._ConfidentialityImpact, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _ConfidentialityImpact__OclType = new ExecutorFragment(Types._ConfidentialityImpact, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _ConfidentialityRequirement__ConfidentialityRequirement = new ExecutorFragment(Types._ConfidentialityRequirement, CVSSTables.Types._ConfidentialityRequirement);
		private static final ExecutorFragment _ConfidentialityRequirement__OclAny = new ExecutorFragment(Types._ConfidentialityRequirement, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ConfidentialityRequirement__OclElement = new ExecutorFragment(Types._ConfidentialityRequirement, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _ConfidentialityRequirement__OclEnumeration = new ExecutorFragment(Types._ConfidentialityRequirement, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _ConfidentialityRequirement__OclType = new ExecutorFragment(Types._ConfidentialityRequirement, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _ExploitCodeMaturity__ExploitCodeMaturity = new ExecutorFragment(Types._ExploitCodeMaturity, CVSSTables.Types._ExploitCodeMaturity);
		private static final ExecutorFragment _ExploitCodeMaturity__OclAny = new ExecutorFragment(Types._ExploitCodeMaturity, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ExploitCodeMaturity__OclElement = new ExecutorFragment(Types._ExploitCodeMaturity, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _ExploitCodeMaturity__OclEnumeration = new ExecutorFragment(Types._ExploitCodeMaturity, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _ExploitCodeMaturity__OclType = new ExecutorFragment(Types._ExploitCodeMaturity, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _IntegrityImpact__IntegrityImpact = new ExecutorFragment(Types._IntegrityImpact, CVSSTables.Types._IntegrityImpact);
		private static final ExecutorFragment _IntegrityImpact__OclAny = new ExecutorFragment(Types._IntegrityImpact, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _IntegrityImpact__OclElement = new ExecutorFragment(Types._IntegrityImpact, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _IntegrityImpact__OclEnumeration = new ExecutorFragment(Types._IntegrityImpact, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _IntegrityImpact__OclType = new ExecutorFragment(Types._IntegrityImpact, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _IntegrityRequirement__IntegrityRequirement = new ExecutorFragment(Types._IntegrityRequirement, CVSSTables.Types._IntegrityRequirement);
		private static final ExecutorFragment _IntegrityRequirement__OclAny = new ExecutorFragment(Types._IntegrityRequirement, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _IntegrityRequirement__OclElement = new ExecutorFragment(Types._IntegrityRequirement, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _IntegrityRequirement__OclEnumeration = new ExecutorFragment(Types._IntegrityRequirement, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _IntegrityRequirement__OclType = new ExecutorFragment(Types._IntegrityRequirement, OCLstdlibTables.Types._OclType);

		private static final ExecutorFragment _PrivilegesRequired__OclAny = new ExecutorFragment(Types._PrivilegesRequired, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _PrivilegesRequired__OclElement = new ExecutorFragment(Types._PrivilegesRequired, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _PrivilegesRequired__OclEnumeration = new ExecutorFragment(Types._PrivilegesRequired, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _PrivilegesRequired__OclType = new ExecutorFragment(Types._PrivilegesRequired, OCLstdlibTables.Types._OclType);
		private static final ExecutorFragment _PrivilegesRequired__PrivilegesRequired = new ExecutorFragment(Types._PrivilegesRequired, CVSSTables.Types._PrivilegesRequired);

		private static final ExecutorFragment _RemediationLevel__OclAny = new ExecutorFragment(Types._RemediationLevel, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _RemediationLevel__OclElement = new ExecutorFragment(Types._RemediationLevel, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _RemediationLevel__OclEnumeration = new ExecutorFragment(Types._RemediationLevel, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _RemediationLevel__OclType = new ExecutorFragment(Types._RemediationLevel, OCLstdlibTables.Types._OclType);
		private static final ExecutorFragment _RemediationLevel__RemediationLevel = new ExecutorFragment(Types._RemediationLevel, CVSSTables.Types._RemediationLevel);

		private static final ExecutorFragment _ReportConfidence__OclAny = new ExecutorFragment(Types._ReportConfidence, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _ReportConfidence__OclElement = new ExecutorFragment(Types._ReportConfidence, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _ReportConfidence__OclEnumeration = new ExecutorFragment(Types._ReportConfidence, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _ReportConfidence__OclType = new ExecutorFragment(Types._ReportConfidence, OCLstdlibTables.Types._OclType);
		private static final ExecutorFragment _ReportConfidence__ReportConfidence = new ExecutorFragment(Types._ReportConfidence, CVSSTables.Types._ReportConfidence);

		private static final ExecutorFragment _Scope__OclAny = new ExecutorFragment(Types._Scope, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _Scope__OclElement = new ExecutorFragment(Types._Scope, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _Scope__OclEnumeration = new ExecutorFragment(Types._Scope, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _Scope__OclType = new ExecutorFragment(Types._Scope, OCLstdlibTables.Types._OclType);
		private static final ExecutorFragment _Scope__Scope = new ExecutorFragment(Types._Scope, CVSSTables.Types._Scope);

		private static final ExecutorFragment _UserInteraction__OclAny = new ExecutorFragment(Types._UserInteraction, OCLstdlibTables.Types._OclAny);
		private static final ExecutorFragment _UserInteraction__OclElement = new ExecutorFragment(Types._UserInteraction, OCLstdlibTables.Types._OclElement);
		private static final ExecutorFragment _UserInteraction__OclEnumeration = new ExecutorFragment(Types._UserInteraction, OCLstdlibTables.Types._OclEnumeration);
		private static final ExecutorFragment _UserInteraction__OclType = new ExecutorFragment(Types._UserInteraction, OCLstdlibTables.Types._OclType);
		private static final ExecutorFragment _UserInteraction__UserInteraction = new ExecutorFragment(Types._UserInteraction, CVSSTables.Types._UserInteraction);

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CVSSTables::Fragments and all preceding sub-packages.
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
		 * Force initialization of the fields of CVSSTables::Parameters and all preceding sub-packages.
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
		 * Force initialization of the fields of CVSSTables::Operations and all preceding sub-packages.
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

		static {
			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CVSSTables::Properties and all preceding sub-packages.
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

		private static final ExecutorFragment /*@NonNull*/ [] _AttackComplexity =
			{
				Fragments._AttackComplexity__OclAny /* 0 */,
				Fragments._AttackComplexity__OclElement /* 1 */,
				Fragments._AttackComplexity__OclType /* 2 */,
				Fragments._AttackComplexity__OclEnumeration /* 3 */,
				Fragments._AttackComplexity__AttackComplexity /* 4 */
			};
		private static final int /*@NonNull*/ [] __AttackComplexity = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _AttackVector =
			{
				Fragments._AttackVector__OclAny /* 0 */,
				Fragments._AttackVector__OclElement /* 1 */,
				Fragments._AttackVector__OclType /* 2 */,
				Fragments._AttackVector__OclEnumeration /* 3 */,
				Fragments._AttackVector__AttackVector /* 4 */
			};
		private static final int /*@NonNull*/ [] __AttackVector = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _AvailabilityImpact =
			{
				Fragments._AvailabilityImpact__OclAny /* 0 */,
				Fragments._AvailabilityImpact__OclElement /* 1 */,
				Fragments._AvailabilityImpact__OclType /* 2 */,
				Fragments._AvailabilityImpact__OclEnumeration /* 3 */,
				Fragments._AvailabilityImpact__AvailabilityImpact /* 4 */
			};
		private static final int /*@NonNull*/ [] __AvailabilityImpact = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _AvailabilityRequirement =
			{
				Fragments._AvailabilityRequirement__OclAny /* 0 */,
				Fragments._AvailabilityRequirement__OclElement /* 1 */,
				Fragments._AvailabilityRequirement__OclType /* 2 */,
				Fragments._AvailabilityRequirement__OclEnumeration /* 3 */,
				Fragments._AvailabilityRequirement__AvailabilityRequirement /* 4 */
			};
		private static final int /*@NonNull*/ [] __AvailabilityRequirement = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ConfidentialityImpact =
			{
				Fragments._ConfidentialityImpact__OclAny /* 0 */,
				Fragments._ConfidentialityImpact__OclElement /* 1 */,
				Fragments._ConfidentialityImpact__OclType /* 2 */,
				Fragments._ConfidentialityImpact__OclEnumeration /* 3 */,
				Fragments._ConfidentialityImpact__ConfidentialityImpact /* 4 */
			};
		private static final int /*@NonNull*/ [] __ConfidentialityImpact = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ConfidentialityRequirement =
			{
				Fragments._ConfidentialityRequirement__OclAny /* 0 */,
				Fragments._ConfidentialityRequirement__OclElement /* 1 */,
				Fragments._ConfidentialityRequirement__OclType /* 2 */,
				Fragments._ConfidentialityRequirement__OclEnumeration /* 3 */,
				Fragments._ConfidentialityRequirement__ConfidentialityRequirement /* 4 */
			};
		private static final int /*@NonNull*/ [] __ConfidentialityRequirement = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ExploitCodeMaturity =
			{
				Fragments._ExploitCodeMaturity__OclAny /* 0 */,
				Fragments._ExploitCodeMaturity__OclElement /* 1 */,
				Fragments._ExploitCodeMaturity__OclType /* 2 */,
				Fragments._ExploitCodeMaturity__OclEnumeration /* 3 */,
				Fragments._ExploitCodeMaturity__ExploitCodeMaturity /* 4 */
			};
		private static final int /*@NonNull*/ [] __ExploitCodeMaturity = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _IntegrityImpact =
			{
				Fragments._IntegrityImpact__OclAny /* 0 */,
				Fragments._IntegrityImpact__OclElement /* 1 */,
				Fragments._IntegrityImpact__OclType /* 2 */,
				Fragments._IntegrityImpact__OclEnumeration /* 3 */,
				Fragments._IntegrityImpact__IntegrityImpact /* 4 */
			};
		private static final int /*@NonNull*/ [] __IntegrityImpact = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _IntegrityRequirement =
			{
				Fragments._IntegrityRequirement__OclAny /* 0 */,
				Fragments._IntegrityRequirement__OclElement /* 1 */,
				Fragments._IntegrityRequirement__OclType /* 2 */,
				Fragments._IntegrityRequirement__OclEnumeration /* 3 */,
				Fragments._IntegrityRequirement__IntegrityRequirement /* 4 */
			};
		private static final int /*@NonNull*/ [] __IntegrityRequirement = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _PrivilegesRequired =
			{
				Fragments._PrivilegesRequired__OclAny /* 0 */,
				Fragments._PrivilegesRequired__OclElement /* 1 */,
				Fragments._PrivilegesRequired__OclType /* 2 */,
				Fragments._PrivilegesRequired__OclEnumeration /* 3 */,
				Fragments._PrivilegesRequired__PrivilegesRequired /* 4 */
			};
		private static final int /*@NonNull*/ [] __PrivilegesRequired = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _RemediationLevel =
			{
				Fragments._RemediationLevel__OclAny /* 0 */,
				Fragments._RemediationLevel__OclElement /* 1 */,
				Fragments._RemediationLevel__OclType /* 2 */,
				Fragments._RemediationLevel__OclEnumeration /* 3 */,
				Fragments._RemediationLevel__RemediationLevel /* 4 */
			};
		private static final int /*@NonNull*/ [] __RemediationLevel = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _ReportConfidence =
			{
				Fragments._ReportConfidence__OclAny /* 0 */,
				Fragments._ReportConfidence__OclElement /* 1 */,
				Fragments._ReportConfidence__OclType /* 2 */,
				Fragments._ReportConfidence__OclEnumeration /* 3 */,
				Fragments._ReportConfidence__ReportConfidence /* 4 */
			};
		private static final int /*@NonNull*/ [] __ReportConfidence = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _Scope =
			{
				Fragments._Scope__OclAny /* 0 */,
				Fragments._Scope__OclElement /* 1 */,
				Fragments._Scope__OclType /* 2 */,
				Fragments._Scope__OclEnumeration /* 3 */,
				Fragments._Scope__Scope /* 4 */
			};
		private static final int /*@NonNull*/ [] __Scope = { 1,1,1,1,1 };

		private static final ExecutorFragment /*@NonNull*/ [] _UserInteraction =
			{
				Fragments._UserInteraction__OclAny /* 0 */,
				Fragments._UserInteraction__OclElement /* 1 */,
				Fragments._UserInteraction__OclType /* 2 */,
				Fragments._UserInteraction__OclEnumeration /* 3 */,
				Fragments._UserInteraction__UserInteraction /* 4 */
			};
		private static final int /*@NonNull*/ [] __UserInteraction = { 1,1,1,1,1 };

		/**
		 *	Install the fragment descriptors in the class descriptors.
		 */
		static {
			Types._AttackComplexity.initFragments(_AttackComplexity, __AttackComplexity);
			Types._AttackVector.initFragments(_AttackVector, __AttackVector);
			Types._AvailabilityImpact.initFragments(_AvailabilityImpact, __AvailabilityImpact);
			Types._AvailabilityRequirement.initFragments(_AvailabilityRequirement, __AvailabilityRequirement);
			Types._ConfidentialityImpact.initFragments(_ConfidentialityImpact, __ConfidentialityImpact);
			Types._ConfidentialityRequirement.initFragments(_ConfidentialityRequirement, __ConfidentialityRequirement);
			Types._ExploitCodeMaturity.initFragments(_ExploitCodeMaturity, __ExploitCodeMaturity);
			Types._IntegrityImpact.initFragments(_IntegrityImpact, __IntegrityImpact);
			Types._IntegrityRequirement.initFragments(_IntegrityRequirement, __IntegrityRequirement);
			Types._PrivilegesRequired.initFragments(_PrivilegesRequired, __PrivilegesRequired);
			Types._RemediationLevel.initFragments(_RemediationLevel, __RemediationLevel);
			Types._ReportConfidence.initFragments(_ReportConfidence, __ReportConfidence);
			Types._Scope.initFragments(_Scope, __Scope);
			Types._UserInteraction.initFragments(_UserInteraction, __UserInteraction);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CVSSTables::TypeFragments and all preceding sub-packages.
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

		private static final ExecutorOperation /*@NonNull*/ [] _AttackComplexity__AttackComplexity = {};
		private static final ExecutorOperation /*@NonNull*/ [] _AttackComplexity__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _AttackComplexity__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _AttackComplexity__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _AttackComplexity__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _AttackVector__AttackVector = {};
		private static final ExecutorOperation /*@NonNull*/ [] _AttackVector__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _AttackVector__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _AttackVector__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _AttackVector__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityImpact__AvailabilityImpact = {};
		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityImpact__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityImpact__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityImpact__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityImpact__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityRequirement__AvailabilityRequirement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityRequirement__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityRequirement__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityRequirement__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _AvailabilityRequirement__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityImpact__ConfidentialityImpact = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityImpact__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityImpact__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityImpact__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityImpact__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityRequirement__ConfidentialityRequirement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityRequirement__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityRequirement__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityRequirement__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ConfidentialityRequirement__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ExploitCodeMaturity__ExploitCodeMaturity = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ExploitCodeMaturity__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _ExploitCodeMaturity__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _ExploitCodeMaturity__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ExploitCodeMaturity__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityImpact__IntegrityImpact = {};
		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityImpact__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityImpact__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityImpact__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityImpact__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityRequirement__IntegrityRequirement = {};
		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityRequirement__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityRequirement__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityRequirement__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _IntegrityRequirement__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _PrivilegesRequired__PrivilegesRequired = {};
		private static final ExecutorOperation /*@NonNull*/ [] _PrivilegesRequired__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _PrivilegesRequired__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _PrivilegesRequired__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _PrivilegesRequired__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _RemediationLevel__RemediationLevel = {};
		private static final ExecutorOperation /*@NonNull*/ [] _RemediationLevel__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _RemediationLevel__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _RemediationLevel__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _RemediationLevel__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _ReportConfidence__ReportConfidence = {};
		private static final ExecutorOperation /*@NonNull*/ [] _ReportConfidence__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _ReportConfidence__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _ReportConfidence__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _ReportConfidence__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _Scope__Scope = {};
		private static final ExecutorOperation /*@NonNull*/ [] _Scope__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _Scope__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _Scope__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _Scope__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		private static final ExecutorOperation /*@NonNull*/ [] _UserInteraction__UserInteraction = {};
		private static final ExecutorOperation /*@NonNull*/ [] _UserInteraction__OclAny = {
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
		private static final ExecutorOperation /*@NonNull*/ [] _UserInteraction__OclElement = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */,
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
		private static final ExecutorOperation /*@NonNull*/ [] _UserInteraction__OclEnumeration = {
			OCLstdlibTables.Operations._OclEnumeration__allInstances /* allInstances(Integer[1]) */
		};
		private static final ExecutorOperation /*@NonNull*/ [] _UserInteraction__OclType = {
			OCLstdlibTables.Operations._OclType__conformsTo /* conformsTo(OclType[?]) */
		};

		/*
		 *	Install the operation descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AttackComplexity__AttackComplexity.initOperations(_AttackComplexity__AttackComplexity);
			Fragments._AttackComplexity__OclAny.initOperations(_AttackComplexity__OclAny);
			Fragments._AttackComplexity__OclElement.initOperations(_AttackComplexity__OclElement);
			Fragments._AttackComplexity__OclEnumeration.initOperations(_AttackComplexity__OclEnumeration);
			Fragments._AttackComplexity__OclType.initOperations(_AttackComplexity__OclType);

			Fragments._AttackVector__AttackVector.initOperations(_AttackVector__AttackVector);
			Fragments._AttackVector__OclAny.initOperations(_AttackVector__OclAny);
			Fragments._AttackVector__OclElement.initOperations(_AttackVector__OclElement);
			Fragments._AttackVector__OclEnumeration.initOperations(_AttackVector__OclEnumeration);
			Fragments._AttackVector__OclType.initOperations(_AttackVector__OclType);

			Fragments._AvailabilityImpact__AvailabilityImpact.initOperations(_AvailabilityImpact__AvailabilityImpact);
			Fragments._AvailabilityImpact__OclAny.initOperations(_AvailabilityImpact__OclAny);
			Fragments._AvailabilityImpact__OclElement.initOperations(_AvailabilityImpact__OclElement);
			Fragments._AvailabilityImpact__OclEnumeration.initOperations(_AvailabilityImpact__OclEnumeration);
			Fragments._AvailabilityImpact__OclType.initOperations(_AvailabilityImpact__OclType);

			Fragments._AvailabilityRequirement__AvailabilityRequirement.initOperations(_AvailabilityRequirement__AvailabilityRequirement);
			Fragments._AvailabilityRequirement__OclAny.initOperations(_AvailabilityRequirement__OclAny);
			Fragments._AvailabilityRequirement__OclElement.initOperations(_AvailabilityRequirement__OclElement);
			Fragments._AvailabilityRequirement__OclEnumeration.initOperations(_AvailabilityRequirement__OclEnumeration);
			Fragments._AvailabilityRequirement__OclType.initOperations(_AvailabilityRequirement__OclType);

			Fragments._ConfidentialityImpact__ConfidentialityImpact.initOperations(_ConfidentialityImpact__ConfidentialityImpact);
			Fragments._ConfidentialityImpact__OclAny.initOperations(_ConfidentialityImpact__OclAny);
			Fragments._ConfidentialityImpact__OclElement.initOperations(_ConfidentialityImpact__OclElement);
			Fragments._ConfidentialityImpact__OclEnumeration.initOperations(_ConfidentialityImpact__OclEnumeration);
			Fragments._ConfidentialityImpact__OclType.initOperations(_ConfidentialityImpact__OclType);

			Fragments._ConfidentialityRequirement__ConfidentialityRequirement.initOperations(_ConfidentialityRequirement__ConfidentialityRequirement);
			Fragments._ConfidentialityRequirement__OclAny.initOperations(_ConfidentialityRequirement__OclAny);
			Fragments._ConfidentialityRequirement__OclElement.initOperations(_ConfidentialityRequirement__OclElement);
			Fragments._ConfidentialityRequirement__OclEnumeration.initOperations(_ConfidentialityRequirement__OclEnumeration);
			Fragments._ConfidentialityRequirement__OclType.initOperations(_ConfidentialityRequirement__OclType);

			Fragments._ExploitCodeMaturity__ExploitCodeMaturity.initOperations(_ExploitCodeMaturity__ExploitCodeMaturity);
			Fragments._ExploitCodeMaturity__OclAny.initOperations(_ExploitCodeMaturity__OclAny);
			Fragments._ExploitCodeMaturity__OclElement.initOperations(_ExploitCodeMaturity__OclElement);
			Fragments._ExploitCodeMaturity__OclEnumeration.initOperations(_ExploitCodeMaturity__OclEnumeration);
			Fragments._ExploitCodeMaturity__OclType.initOperations(_ExploitCodeMaturity__OclType);

			Fragments._IntegrityImpact__IntegrityImpact.initOperations(_IntegrityImpact__IntegrityImpact);
			Fragments._IntegrityImpact__OclAny.initOperations(_IntegrityImpact__OclAny);
			Fragments._IntegrityImpact__OclElement.initOperations(_IntegrityImpact__OclElement);
			Fragments._IntegrityImpact__OclEnumeration.initOperations(_IntegrityImpact__OclEnumeration);
			Fragments._IntegrityImpact__OclType.initOperations(_IntegrityImpact__OclType);

			Fragments._IntegrityRequirement__IntegrityRequirement.initOperations(_IntegrityRequirement__IntegrityRequirement);
			Fragments._IntegrityRequirement__OclAny.initOperations(_IntegrityRequirement__OclAny);
			Fragments._IntegrityRequirement__OclElement.initOperations(_IntegrityRequirement__OclElement);
			Fragments._IntegrityRequirement__OclEnumeration.initOperations(_IntegrityRequirement__OclEnumeration);
			Fragments._IntegrityRequirement__OclType.initOperations(_IntegrityRequirement__OclType);

			Fragments._PrivilegesRequired__OclAny.initOperations(_PrivilegesRequired__OclAny);
			Fragments._PrivilegesRequired__OclElement.initOperations(_PrivilegesRequired__OclElement);
			Fragments._PrivilegesRequired__OclEnumeration.initOperations(_PrivilegesRequired__OclEnumeration);
			Fragments._PrivilegesRequired__OclType.initOperations(_PrivilegesRequired__OclType);
			Fragments._PrivilegesRequired__PrivilegesRequired.initOperations(_PrivilegesRequired__PrivilegesRequired);

			Fragments._RemediationLevel__OclAny.initOperations(_RemediationLevel__OclAny);
			Fragments._RemediationLevel__OclElement.initOperations(_RemediationLevel__OclElement);
			Fragments._RemediationLevel__OclEnumeration.initOperations(_RemediationLevel__OclEnumeration);
			Fragments._RemediationLevel__OclType.initOperations(_RemediationLevel__OclType);
			Fragments._RemediationLevel__RemediationLevel.initOperations(_RemediationLevel__RemediationLevel);

			Fragments._ReportConfidence__OclAny.initOperations(_ReportConfidence__OclAny);
			Fragments._ReportConfidence__OclElement.initOperations(_ReportConfidence__OclElement);
			Fragments._ReportConfidence__OclEnumeration.initOperations(_ReportConfidence__OclEnumeration);
			Fragments._ReportConfidence__OclType.initOperations(_ReportConfidence__OclType);
			Fragments._ReportConfidence__ReportConfidence.initOperations(_ReportConfidence__ReportConfidence);

			Fragments._Scope__OclAny.initOperations(_Scope__OclAny);
			Fragments._Scope__OclElement.initOperations(_Scope__OclElement);
			Fragments._Scope__OclEnumeration.initOperations(_Scope__OclEnumeration);
			Fragments._Scope__OclType.initOperations(_Scope__OclType);
			Fragments._Scope__Scope.initOperations(_Scope__Scope);

			Fragments._UserInteraction__OclAny.initOperations(_UserInteraction__OclAny);
			Fragments._UserInteraction__OclElement.initOperations(_UserInteraction__OclElement);
			Fragments._UserInteraction__OclEnumeration.initOperations(_UserInteraction__OclEnumeration);
			Fragments._UserInteraction__OclType.initOperations(_UserInteraction__OclType);
			Fragments._UserInteraction__UserInteraction.initOperations(_UserInteraction__UserInteraction);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CVSSTables::FragmentOperations and all preceding sub-packages.
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

		private static final ExecutorProperty /*@NonNull*/ [] _AttackComplexity = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _AttackVector = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _AvailabilityImpact = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _AvailabilityRequirement = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ConfidentialityImpact = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ConfidentialityRequirement = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ExploitCodeMaturity = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _IntegrityImpact = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _IntegrityRequirement = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _PrivilegesRequired = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _RemediationLevel = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _ReportConfidence = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _Scope = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		private static final ExecutorProperty /*@NonNull*/ [] _UserInteraction = {
			OCLstdlibTables.Properties._OclElement__oclContainer,
			OCLstdlibTables.Properties._OclElement__oclContents
		};

		/**
		 *	Install the property descriptors in the fragment descriptors.
		 */
		static {
			Fragments._AttackComplexity__AttackComplexity.initProperties(_AttackComplexity);
			Fragments._AttackVector__AttackVector.initProperties(_AttackVector);
			Fragments._AvailabilityImpact__AvailabilityImpact.initProperties(_AvailabilityImpact);
			Fragments._AvailabilityRequirement__AvailabilityRequirement.initProperties(_AvailabilityRequirement);
			Fragments._ConfidentialityImpact__ConfidentialityImpact.initProperties(_ConfidentialityImpact);
			Fragments._ConfidentialityRequirement__ConfidentialityRequirement.initProperties(_ConfidentialityRequirement);
			Fragments._ExploitCodeMaturity__ExploitCodeMaturity.initProperties(_ExploitCodeMaturity);
			Fragments._IntegrityImpact__IntegrityImpact.initProperties(_IntegrityImpact);
			Fragments._IntegrityRequirement__IntegrityRequirement.initProperties(_IntegrityRequirement);
			Fragments._PrivilegesRequired__PrivilegesRequired.initProperties(_PrivilegesRequired);
			Fragments._RemediationLevel__RemediationLevel.initProperties(_RemediationLevel);
			Fragments._ReportConfidence__ReportConfidence.initProperties(_ReportConfidence);
			Fragments._Scope__Scope.initProperties(_Scope);
			Fragments._UserInteraction__UserInteraction.initProperties(_UserInteraction);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CVSSTables::FragmentProperties and all preceding sub-packages.
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

		public static final EcoreExecutorEnumerationLiteral _AttackComplexity__Low = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.ATTACK_COMPLEXITY.getEEnumLiteral("Low"), Types._AttackComplexity, 0);
		public static final EcoreExecutorEnumerationLiteral _AttackComplexity__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.ATTACK_COMPLEXITY.getEEnumLiteral("High"), Types._AttackComplexity, 1);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _AttackComplexity = {
			_AttackComplexity__Low,
			_AttackComplexity__High
		};

		public static final EcoreExecutorEnumerationLiteral _AttackVector__Network = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.ATTACK_VECTOR.getEEnumLiteral("Network"), Types._AttackVector, 0);
		public static final EcoreExecutorEnumerationLiteral _AttackVector__Adjacent = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.ATTACK_VECTOR.getEEnumLiteral("Adjacent"), Types._AttackVector, 1);
		public static final EcoreExecutorEnumerationLiteral _AttackVector__Local = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.ATTACK_VECTOR.getEEnumLiteral("Local"), Types._AttackVector, 2);
		public static final EcoreExecutorEnumerationLiteral _AttackVector__Physical = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.ATTACK_VECTOR.getEEnumLiteral("Physical"), Types._AttackVector, 3);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _AttackVector = {
			_AttackVector__Network,
			_AttackVector__Adjacent,
			_AttackVector__Local,
			_AttackVector__Physical
		};

		public static final EcoreExecutorEnumerationLiteral _AvailabilityImpact__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.AVAILABILITY_IMPACT.getEEnumLiteral("High"), Types._AvailabilityImpact, 0);
		public static final EcoreExecutorEnumerationLiteral _AvailabilityImpact__Low = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.AVAILABILITY_IMPACT.getEEnumLiteral("Low"), Types._AvailabilityImpact, 1);
		public static final EcoreExecutorEnumerationLiteral _AvailabilityImpact__None = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.AVAILABILITY_IMPACT.getEEnumLiteral("None"), Types._AvailabilityImpact, 2);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _AvailabilityImpact = {
			_AvailabilityImpact__High,
			_AvailabilityImpact__Low,
			_AvailabilityImpact__None
		};

		public static final EcoreExecutorEnumerationLiteral _AvailabilityRequirement__NotDefined = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.AVAILABILITY_REQUIREMENT.getEEnumLiteral("NotDefined"), Types._AvailabilityRequirement, 0);
		public static final EcoreExecutorEnumerationLiteral _AvailabilityRequirement__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.AVAILABILITY_REQUIREMENT.getEEnumLiteral("High"), Types._AvailabilityRequirement, 1);
		public static final EcoreExecutorEnumerationLiteral _AvailabilityRequirement__Medium = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.AVAILABILITY_REQUIREMENT.getEEnumLiteral("Medium"), Types._AvailabilityRequirement, 2);
		public static final EcoreExecutorEnumerationLiteral _AvailabilityRequirement__Low = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.AVAILABILITY_REQUIREMENT.getEEnumLiteral("Low"), Types._AvailabilityRequirement, 3);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _AvailabilityRequirement = {
			_AvailabilityRequirement__NotDefined,
			_AvailabilityRequirement__High,
			_AvailabilityRequirement__Medium,
			_AvailabilityRequirement__Low
		};

		public static final EcoreExecutorEnumerationLiteral _ConfidentialityImpact__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.CONFIDENTIALITY_IMPACT.getEEnumLiteral("High"), Types._ConfidentialityImpact, 0);
		public static final EcoreExecutorEnumerationLiteral _ConfidentialityImpact__Low = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.CONFIDENTIALITY_IMPACT.getEEnumLiteral("Low"), Types._ConfidentialityImpact, 1);
		public static final EcoreExecutorEnumerationLiteral _ConfidentialityImpact__None = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.CONFIDENTIALITY_IMPACT.getEEnumLiteral("None"), Types._ConfidentialityImpact, 2);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _ConfidentialityImpact = {
			_ConfidentialityImpact__High,
			_ConfidentialityImpact__Low,
			_ConfidentialityImpact__None
		};

		public static final EcoreExecutorEnumerationLiteral _ConfidentialityRequirement__NotDefined = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.CONFIDENTIALITY_REQUIREMENT.getEEnumLiteral("NotDefined"), Types._ConfidentialityRequirement, 0);
		public static final EcoreExecutorEnumerationLiteral _ConfidentialityRequirement__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.CONFIDENTIALITY_REQUIREMENT.getEEnumLiteral("High"), Types._ConfidentialityRequirement, 1);
		public static final EcoreExecutorEnumerationLiteral _ConfidentialityRequirement__Medium = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.CONFIDENTIALITY_REQUIREMENT.getEEnumLiteral("Medium"), Types._ConfidentialityRequirement, 2);
		public static final EcoreExecutorEnumerationLiteral _ConfidentialityRequirement__Low = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.CONFIDENTIALITY_REQUIREMENT.getEEnumLiteral("Low"), Types._ConfidentialityRequirement, 3);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _ConfidentialityRequirement = {
			_ConfidentialityRequirement__NotDefined,
			_ConfidentialityRequirement__High,
			_ConfidentialityRequirement__Medium,
			_ConfidentialityRequirement__Low
		};

		public static final EcoreExecutorEnumerationLiteral _ExploitCodeMaturity__NotDefined = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.EXPLOIT_CODE_MATURITY.getEEnumLiteral("NotDefined"), Types._ExploitCodeMaturity, 0);
		public static final EcoreExecutorEnumerationLiteral _ExploitCodeMaturity__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.EXPLOIT_CODE_MATURITY.getEEnumLiteral("High"), Types._ExploitCodeMaturity, 1);
		public static final EcoreExecutorEnumerationLiteral _ExploitCodeMaturity__Functional = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.EXPLOIT_CODE_MATURITY.getEEnumLiteral("Functional"), Types._ExploitCodeMaturity, 2);
		public static final EcoreExecutorEnumerationLiteral _ExploitCodeMaturity__ProofOfConcept = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.EXPLOIT_CODE_MATURITY.getEEnumLiteral("ProofOfConcept"), Types._ExploitCodeMaturity, 3);
		public static final EcoreExecutorEnumerationLiteral _ExploitCodeMaturity__Unproven = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.EXPLOIT_CODE_MATURITY.getEEnumLiteral("Unproven"), Types._ExploitCodeMaturity, 4);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _ExploitCodeMaturity = {
			_ExploitCodeMaturity__NotDefined,
			_ExploitCodeMaturity__High,
			_ExploitCodeMaturity__Functional,
			_ExploitCodeMaturity__ProofOfConcept,
			_ExploitCodeMaturity__Unproven
		};

		public static final EcoreExecutorEnumerationLiteral _IntegrityImpact__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.INTEGRITY_IMPACT.getEEnumLiteral("High"), Types._IntegrityImpact, 0);
		public static final EcoreExecutorEnumerationLiteral _IntegrityImpact__Low = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.INTEGRITY_IMPACT.getEEnumLiteral("Low"), Types._IntegrityImpact, 1);
		public static final EcoreExecutorEnumerationLiteral _IntegrityImpact__None = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.INTEGRITY_IMPACT.getEEnumLiteral("None"), Types._IntegrityImpact, 2);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _IntegrityImpact = {
			_IntegrityImpact__High,
			_IntegrityImpact__Low,
			_IntegrityImpact__None
		};

		public static final EcoreExecutorEnumerationLiteral _IntegrityRequirement__NotDefined = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.INTEGRITY_REQUIREMENT.getEEnumLiteral("NotDefined"), Types._IntegrityRequirement, 0);
		public static final EcoreExecutorEnumerationLiteral _IntegrityRequirement__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.INTEGRITY_REQUIREMENT.getEEnumLiteral("High"), Types._IntegrityRequirement, 1);
		public static final EcoreExecutorEnumerationLiteral _IntegrityRequirement__Medium = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.INTEGRITY_REQUIREMENT.getEEnumLiteral("Medium"), Types._IntegrityRequirement, 2);
		public static final EcoreExecutorEnumerationLiteral _IntegrityRequirement__Low = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.INTEGRITY_REQUIREMENT.getEEnumLiteral("Low"), Types._IntegrityRequirement, 3);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _IntegrityRequirement = {
			_IntegrityRequirement__NotDefined,
			_IntegrityRequirement__High,
			_IntegrityRequirement__Medium,
			_IntegrityRequirement__Low
		};

		public static final EcoreExecutorEnumerationLiteral _PrivilegesRequired__None = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.PRIVILEGES_REQUIRED.getEEnumLiteral("None"), Types._PrivilegesRequired, 0);
		public static final EcoreExecutorEnumerationLiteral _PrivilegesRequired__Low = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.PRIVILEGES_REQUIRED.getEEnumLiteral("Low"), Types._PrivilegesRequired, 1);
		public static final EcoreExecutorEnumerationLiteral _PrivilegesRequired__High = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.PRIVILEGES_REQUIRED.getEEnumLiteral("High"), Types._PrivilegesRequired, 2);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _PrivilegesRequired = {
			_PrivilegesRequired__None,
			_PrivilegesRequired__Low,
			_PrivilegesRequired__High
		};

		public static final EcoreExecutorEnumerationLiteral _RemediationLevel__NotDefined = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REMEDIATION_LEVEL.getEEnumLiteral("NotDefined"), Types._RemediationLevel, 0);
		public static final EcoreExecutorEnumerationLiteral _RemediationLevel__Unavailable = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REMEDIATION_LEVEL.getEEnumLiteral("Unavailable"), Types._RemediationLevel, 1);
		public static final EcoreExecutorEnumerationLiteral _RemediationLevel__Workaround = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REMEDIATION_LEVEL.getEEnumLiteral("Workaround"), Types._RemediationLevel, 2);
		public static final EcoreExecutorEnumerationLiteral _RemediationLevel__TemporaryFix = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REMEDIATION_LEVEL.getEEnumLiteral("TemporaryFix"), Types._RemediationLevel, 3);
		public static final EcoreExecutorEnumerationLiteral _RemediationLevel__OfficialFix = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REMEDIATION_LEVEL.getEEnumLiteral("OfficialFix"), Types._RemediationLevel, 4);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _RemediationLevel = {
			_RemediationLevel__NotDefined,
			_RemediationLevel__Unavailable,
			_RemediationLevel__Workaround,
			_RemediationLevel__TemporaryFix,
			_RemediationLevel__OfficialFix
		};

		public static final EcoreExecutorEnumerationLiteral _ReportConfidence__NotDefined = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REPORT_CONFIDENCE.getEEnumLiteral("NotDefined"), Types._ReportConfidence, 0);
		public static final EcoreExecutorEnumerationLiteral _ReportConfidence__Confirmed = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REPORT_CONFIDENCE.getEEnumLiteral("Confirmed"), Types._ReportConfidence, 1);
		public static final EcoreExecutorEnumerationLiteral _ReportConfidence__Reasonable = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REPORT_CONFIDENCE.getEEnumLiteral("Reasonable"), Types._ReportConfidence, 2);
		public static final EcoreExecutorEnumerationLiteral _ReportConfidence__Unknown = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.REPORT_CONFIDENCE.getEEnumLiteral("Unknown"), Types._ReportConfidence, 3);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _ReportConfidence = {
			_ReportConfidence__NotDefined,
			_ReportConfidence__Confirmed,
			_ReportConfidence__Reasonable,
			_ReportConfidence__Unknown
		};

		public static final EcoreExecutorEnumerationLiteral _Scope__Unchanged = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.SCOPE.getEEnumLiteral("Unchanged"), Types._Scope, 0);
		public static final EcoreExecutorEnumerationLiteral _Scope__Changed = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.SCOPE.getEEnumLiteral("Changed"), Types._Scope, 1);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _Scope = {
			_Scope__Unchanged,
			_Scope__Changed
		};

		public static final EcoreExecutorEnumerationLiteral _UserInteraction__None = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.USER_INTERACTION.getEEnumLiteral("None"), Types._UserInteraction, 0);
		public static final EcoreExecutorEnumerationLiteral _UserInteraction__Required = new EcoreExecutorEnumerationLiteral(CVSSPackage.Literals.USER_INTERACTION.getEEnumLiteral("Required"), Types._UserInteraction, 1);
		private static final EcoreExecutorEnumerationLiteral /*@NonNull*/ [] _UserInteraction = {
			_UserInteraction__None,
			_UserInteraction__Required
		};

		/**
		 *	Install the enumeration literals in the enumerations.
		 */
		static {
			Types._AttackComplexity.initLiterals(_AttackComplexity);
			Types._AttackVector.initLiterals(_AttackVector);
			Types._AvailabilityImpact.initLiterals(_AvailabilityImpact);
			Types._AvailabilityRequirement.initLiterals(_AvailabilityRequirement);
			Types._ConfidentialityImpact.initLiterals(_ConfidentialityImpact);
			Types._ConfidentialityRequirement.initLiterals(_ConfidentialityRequirement);
			Types._ExploitCodeMaturity.initLiterals(_ExploitCodeMaturity);
			Types._IntegrityImpact.initLiterals(_IntegrityImpact);
			Types._IntegrityRequirement.initLiterals(_IntegrityRequirement);
			Types._PrivilegesRequired.initLiterals(_PrivilegesRequired);
			Types._RemediationLevel.initLiterals(_RemediationLevel);
			Types._ReportConfidence.initLiterals(_ReportConfidence);
			Types._Scope.initLiterals(_Scope);
			Types._UserInteraction.initLiterals(_UserInteraction);

			Init.initEnd();
		}

		/**
		 * Force initialization of the fields of CVSSTables::EnumerationLiterals and all preceding sub-packages.
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
		new CVSSTables();
	}

	private CVSSTables() {
		super(CVSSPackage.eNS_URI);
	}
}
