/**
 */
package CASA.impl;

import CASA.Administrator;
import CASA.AngularSPA;
import CASA.CASAFactory;
import CASA.CASAPackage;

import CASA.CVSS.CVSSPackage;

import CASA.CVSS.impl.CVSSPackageImpl;

import CASA.CVSSVector;
import CASA.CommentWriteRead;
import CASA.Component;
import CASA.Consent;
import CASA.Data;
import CASA.DataSubject;
import CASA.DeviceLocation;
import CASA.DeviceType;
import CASA.EmailAddress;
import CASA.ExpressJS;
import CASA.FilesystemComponent;
import CASA.FuncPersData;
import CASA.Function;
import CASA.LiveStreamVideo;
import CASA.Moderator;
import CASA.Nginx;
import CASA.NonPersonalData;
import CASA.P2PStreaming;
import CASA.PBehaviorTargetedAds;
import CASA.PComments;
import CASA.PFirstPartyProfiling;
import CASA.PLocationTargetedAds;
import CASA.PMarketing;
import CASA.PP2PStreaming;
import CASA.PProfiling;
import CASA.PSocial;
import CASA.PStandardAds;
import CASA.PTargetedAds;
import CASA.PThirdPartyProfiling;
import CASA.PUserExperience;
import CASA.PVideoRecommendation;
import CASA.PVideoSharing;
import CASA.Password;
import CASA.Payment;
import CASA.PersonalData;
import CASA.Postgresql;
import CASA.Purpose;
import CASA.PurposeConsent;
import CASA.PurposeNoConsent;
import CASA.RecommendVideos;
import CASA.RedisComponent;
import CASA.RemoveVideo;
import CASA.RequestTimestamps;
import CASA.Risk;
import CASA.ServeBehaviorTargetedAds;
import CASA.ServeLocationTargetedAds;
import CASA.ServeStandardAds;
import CASA.StreamVideo;
import CASA.StreamingHistory;
import CASA.TrackingCookie;
import CASA.UploadVideo;
import CASA.User;
import CASA.Username;
import CASA.VideoComment;
import CASA.VideoContent;
import CASA.VideoMetadata;
import CASA.Vulnerability;

import CASA.util.CASAValidator;
import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EGenericType;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

import org.eclipse.emf.ecore.EValidator;
import org.eclipse.emf.ecore.impl.EPackageImpl;

/**
 * <!-- begin-user-doc -->
 * An implementation of the model <b>Package</b>.
 * <!-- end-user-doc -->
 * @generated
 */
public class CASAPackageImpl extends EPackageImpl implements CASAPackage {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass consentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataSubjectEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass userEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass administratorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass moderatorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass personalDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass usernameEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass passwordEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass emailAddressEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass paymentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamingHistoryEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass trackingCookieEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass videoContentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass videoCommentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass videoMetadataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceTypeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass deviceLocationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass requestTimestampsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass dataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nonPersonalDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass purposeEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass componentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass angularSPAEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass nginxEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass expressJSEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass functionEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass funcPersDataEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serveStandardAdsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass uploadVideoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass streamVideoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass removeVideoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass liveStreamVideoEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass p2PStreamingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass recommendVideosEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serveBehaviorTargetedAdsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass commentWriteReadEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass serveLocationTargetedAdsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass purposeNoConsentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass purposeConsentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pMarketingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pStandardAdsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pTargetedAdsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pLocationTargetedAdsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pBehaviorTargetedAdsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pProfilingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pFirstPartyProfilingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pThirdPartyProfilingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pUserExperienceEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pVideoRecommendationEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pp2PStreamingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pSocialEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2018_16843EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2018_16844EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2018_16845EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2019_9511EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2019_9513EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2019_9516EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2021_23017EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2021_3618EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2022_24834EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2022_36021EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2022_41862EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2023_2455EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2023_25155EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2023_28856EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2023_44487EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2023_45145EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2023_46809EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2023_5870EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_0985EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_10976EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_10977EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_10978EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_10979EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_21890EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_21891EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_21896EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_22017EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_22018EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_22019EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_22020EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_22025EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_27980EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_27983EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_31449EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_31489EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_3566EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_36137EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_36138EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_37372EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_46981EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_5205EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_7347EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2024_7348EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_1094EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_11187EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_15468EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_21605EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_23084EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_23090EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_32023EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_62506EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_62507EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_66199EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_69418EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_69420EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2025_69421EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2026_22795EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2026_22796EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvE_2026_27970EClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pCommentsEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass pVideoSharingEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass vulnerabilityEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass cvssVectorEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass riskEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass systemEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass redisComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass filesystemComponentEClass = null;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private EClass postgresqlEClass = null;

	/**
	 * Creates an instance of the model <b>Package</b>, registered with
	 * {@link org.eclipse.emf.ecore.EPackage.Registry EPackage.Registry} by the package
	 * package URI value.
	 * <p>Note: the correct way to create the package is via the static
	 * factory method {@link #init init()}, which also performs
	 * initialization of the package, or returns the registered package,
	 * if one already exists.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see org.eclipse.emf.ecore.EPackage.Registry
	 * @see CASA.CASAPackage#eNS_URI
	 * @see #init()
	 * @generated
	 */
	private CASAPackageImpl() {
		super(eNS_URI, CASAFactory.eINSTANCE);
	}
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static boolean isInited = false;

	/**
	 * Creates, registers, and initializes the <b>Package</b> for this model, and for any others upon which it depends.
	 *
	 * <p>This method is used to initialize {@link CASAPackage#eINSTANCE} when that field is accessed.
	 * Clients should not invoke it directly. Instead, they should simply access that field to obtain the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #eNS_URI
	 * @see #createPackageContents()
	 * @see #initializePackageContents()
	 * @generated
	 */
	public static CASAPackage init() {
		if (isInited) return (CASAPackage)EPackage.Registry.INSTANCE.getEPackage(CASAPackage.eNS_URI);

		// Obtain or create and register package
		Object registeredCASAPackage = EPackage.Registry.INSTANCE.get(eNS_URI);
		CASAPackageImpl theCASAPackage = registeredCASAPackage instanceof CASAPackageImpl ? (CASAPackageImpl)registeredCASAPackage : new CASAPackageImpl();

		isInited = true;

		// Obtain or create and register interdependencies
		Object registeredPackage = EPackage.Registry.INSTANCE.getEPackage(CVSSPackage.eNS_URI);
		CVSSPackageImpl theCVSSPackage = (CVSSPackageImpl)(registeredPackage instanceof CVSSPackageImpl ? registeredPackage : CVSSPackage.eINSTANCE);

		// Create package meta-data objects
		theCASAPackage.createPackageContents();
		theCVSSPackage.createPackageContents();

		// Initialize created meta-data
		theCASAPackage.initializePackageContents();
		theCVSSPackage.initializePackageContents();

		// Register package validator
		EValidator.Registry.INSTANCE.put
			(theCASAPackage,
			 new EValidator.Descriptor() {
				 public EValidator getEValidator() {
					 return CASAValidator.INSTANCE;
				 }
			 });

		// Mark meta-data to indicate it can't be changed
		theCASAPackage.freeze();

		// Update the registry and return the package
		EPackage.Registry.INSTANCE.put(CASAPackage.eNS_URI, theCASAPackage);
		return theCASAPackage;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getConsent() {
		return consentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsent_ForPurpose() {
		return (EAttribute)consentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getConsent_InformedRiskLevel() {
		return (EAttribute)consentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConsent_GivenFor() {
		return (EReference)consentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConsent_GivenBy() {
		return (EReference)consentEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getConsent_ForPersonalData() {
		return (EReference)consentEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDataSubject() {
		return dataSubjectEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSubject_IdentifiedBy() {
		return (EReference)dataSubjectEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getDataSubject_Name() {
		return (EAttribute)dataSubjectEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSubject_Gives() {
		return (EReference)dataSubjectEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getDataSubject_AffectedBy() {
		return (EReference)dataSubjectEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUser() {
		return userEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAdministrator() {
		return administratorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getModerator() {
		return moderatorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPersonalData() {
		return personalDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonalData_Identifies() {
		return (EReference)personalDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonalData_ProcessedBy() {
		return (EReference)personalDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPersonalData_SubjectOfConsent() {
		return (EReference)personalDataEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUsername() {
		return usernameEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPassword() {
		return passwordEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getEmailAddress() {
		return emailAddressEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPayment() {
		return paymentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStreamingHistory() {
		return streamingHistoryEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getTrackingCookie() {
		return trackingCookieEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVideoContent() {
		return videoContentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVideoComment() {
		return videoCommentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVideoMetadata() {
		return videoMetadataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceType() {
		return deviceTypeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getDeviceLocation() {
		return deviceLocationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRequestTimestamps() {
		return requestTimestampsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getData() {
		return dataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getData_Name() {
		return (EAttribute)dataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNonPersonalData() {
		return nonPersonalDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getNonPersonalData_ProcessedBy() {
		return (EReference)nonPersonalDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPurpose() {
		return purposeEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getPurpose_Name() {
		return (EAttribute)purposeEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPurpose_OfFunction() {
		return (EReference)purposeEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getPurpose__UniquePurposes__DiagnosticChain_Map() {
		return purposeEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getComponent() {
		return componentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_Realizes() {
		return (EReference)componentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getComponent_Name() {
		return (EAttribute)componentEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getComponent_AffectedBy() {
		return (EReference)componentEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getAngularSPA() {
		return angularSPAEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getNginx() {
		return nginxEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getExpressJS() {
		return expressJSEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFunction() {
		return functionEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getFunction_Name() {
		return (EAttribute)functionEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_RealizedBy() {
		return (EReference)functionEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFunction_Processes() {
		return (EReference)functionEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFuncPersData() {
		return funcPersDataEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuncPersData_ProcessesPersData() {
		return (EReference)funcPersDataEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getFuncPersData_Has() {
		return (EReference)funcPersDataEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServeStandardAds() {
		return serveStandardAdsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getUploadVideo() {
		return uploadVideoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getStreamVideo() {
		return streamVideoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRemoveVideo() {
		return removeVideoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getLiveStreamVideo() {
		return liveStreamVideoEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getP2PStreaming() {
		return p2PStreamingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRecommendVideos() {
		return recommendVideosEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServeBehaviorTargetedAds() {
		return serveBehaviorTargetedAdsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCommentWriteRead() {
		return commentWriteReadEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getServeLocationTargetedAds() {
		return serveLocationTargetedAdsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPurposeNoConsent() {
		return purposeNoConsentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPurposeConsent() {
		return purposeConsentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getPurposeConsent_Requires() {
		return (EReference)purposeConsentEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPMarketing() {
		return pMarketingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPStandardAds() {
		return pStandardAdsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPTargetedAds() {
		return pTargetedAdsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPLocationTargetedAds() {
		return pLocationTargetedAdsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPBehaviorTargetedAds() {
		return pBehaviorTargetedAdsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPProfiling() {
		return pProfilingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPFirstPartyProfiling() {
		return pFirstPartyProfilingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPThirdPartyProfiling() {
		return pThirdPartyProfilingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPUserExperience() {
		return pUserExperienceEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPVideoRecommendation() {
		return pVideoRecommendationEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPP2PStreaming() {
		return pp2PStreamingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPSocial() {
		return pSocialEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2018_16843() {
		return cvE_2018_16843EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2018_16844() {
		return cvE_2018_16844EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2018_16845() {
		return cvE_2018_16845EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2019_9511() {
		return cvE_2019_9511EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2019_9513() {
		return cvE_2019_9513EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2019_9516() {
		return cvE_2019_9516EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2021_23017() {
		return cvE_2021_23017EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2021_3618() {
		return cvE_2021_3618EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2022_24834() {
		return cvE_2022_24834EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2022_36021() {
		return cvE_2022_36021EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2022_41862() {
		return cvE_2022_41862EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2023_2455() {
		return cvE_2023_2455EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2023_25155() {
		return cvE_2023_25155EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2023_28856() {
		return cvE_2023_28856EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2023_44487() {
		return cvE_2023_44487EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2023_45145() {
		return cvE_2023_45145EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2023_46809() {
		return cvE_2023_46809EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2023_5870() {
		return cvE_2023_5870EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_0985() {
		return cvE_2024_0985EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_10976() {
		return cvE_2024_10976EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_10977() {
		return cvE_2024_10977EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_10978() {
		return cvE_2024_10978EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_10979() {
		return cvE_2024_10979EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_21890() {
		return cvE_2024_21890EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_21891() {
		return cvE_2024_21891EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_21896() {
		return cvE_2024_21896EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_22017() {
		return cvE_2024_22017EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_22018() {
		return cvE_2024_22018EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_22019() {
		return cvE_2024_22019EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_22020() {
		return cvE_2024_22020EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_22025() {
		return cvE_2024_22025EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_27980() {
		return cvE_2024_27980EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_27983() {
		return cvE_2024_27983EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_31449() {
		return cvE_2024_31449EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_31489() {
		return cvE_2024_31489EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_3566() {
		return cvE_2024_3566EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_36137() {
		return cvE_2024_36137EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_36138() {
		return cvE_2024_36138EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_37372() {
		return cvE_2024_37372EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_46981() {
		return cvE_2024_46981EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_5205() {
		return cvE_2024_5205EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_7347() {
		return cvE_2024_7347EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2024_7348() {
		return cvE_2024_7348EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_1094() {
		return cvE_2025_1094EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_11187() {
		return cvE_2025_11187EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_15468() {
		return cvE_2025_15468EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_21605() {
		return cvE_2025_21605EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_23084() {
		return cvE_2025_23084EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_23090() {
		return cvE_2025_23090EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_32023() {
		return cvE_2025_32023EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_62506() {
		return cvE_2025_62506EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_62507() {
		return cvE_2025_62507EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_66199() {
		return cvE_2025_66199EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_69418() {
		return cvE_2025_69418EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_69420() {
		return cvE_2025_69420EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2025_69421() {
		return cvE_2025_69421EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2026_22795() {
		return cvE_2026_22795EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2026_22796() {
		return cvE_2026_22796EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVE_2026_27970() {
		return cvE_2026_27970EClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPComments() {
		return pCommentsEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPVideoSharing() {
		return pVideoSharingEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getVulnerability() {
		return vulnerabilityEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVulnerability_CveName() {
		return (EAttribute)vulnerabilityEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVulnerability_Affects() {
		return (EReference)vulnerabilityEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVulnerability_DescribedBy() {
		return (EReference)vulnerabilityEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getVulnerability_Causes() {
		return (EReference)vulnerabilityEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getVulnerability_IsEnabled() {
		return (EAttribute)vulnerabilityEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EOperation getVulnerability__UniqueVulnerabilities__DiagnosticChain_Map() {
		return vulnerabilityEClass.getEOperations().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getCVSSVector() {
		return cvssVectorEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_AttackVector() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_AttackComplexity() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_Scope() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_PrivilegesRequired() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_UserInteraction() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_ExploitCodeMaturity() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_ReportConfidence() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(6);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_ConfidentialityImpact() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(7);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_IntegrityImpact() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(8);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_AvailabilityImpact() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(9);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_RemediationLevel() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(10);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_ConfidentialityRequirement() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(11);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_IntegrityRequirement() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(12);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getCVSSVector_AvailabilityRequirement() {
		return (EAttribute)cvssVectorEClass.getEStructuralFeatures().get(13);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRisk() {
		return riskEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EAttribute getRisk_Level() {
		return (EAttribute)riskEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRisk_Affects() {
		return (EReference)riskEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getRisk_CausedBy() {
		return (EReference)riskEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getSystem() {
		return systemEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Functions() {
		return (EReference)systemEClass.getEStructuralFeatures().get(0);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Datas() {
		return (EReference)systemEClass.getEStructuralFeatures().get(1);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_DataSubjects() {
		return (EReference)systemEClass.getEStructuralFeatures().get(2);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Vulnerabilities() {
		return (EReference)systemEClass.getEStructuralFeatures().get(3);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Components() {
		return (EReference)systemEClass.getEStructuralFeatures().get(4);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EReference getSystem_Purposes() {
		return (EReference)systemEClass.getEStructuralFeatures().get(5);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getRedisComponent() {
		return redisComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getFilesystemComponent() {
		return filesystemComponentEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EClass getPostgresql() {
		return postgresqlEClass;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CASAFactory getCASAFactory() {
		return (CASAFactory)getEFactoryInstance();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isCreated = false;

	/**
	 * Creates the meta-model objects for the package.  This method is
	 * guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void createPackageContents() {
		if (isCreated) return;
		isCreated = true;

		// Create classes and their features
		consentEClass = createEClass(CONSENT);
		createEAttribute(consentEClass, CONSENT__FOR_PURPOSE);
		createEAttribute(consentEClass, CONSENT__INFORMED_RISK_LEVEL);
		createEReference(consentEClass, CONSENT__GIVEN_FOR);
		createEReference(consentEClass, CONSENT__GIVEN_BY);
		createEReference(consentEClass, CONSENT__FOR_PERSONAL_DATA);

		dataSubjectEClass = createEClass(DATA_SUBJECT);
		createEReference(dataSubjectEClass, DATA_SUBJECT__IDENTIFIED_BY);
		createEAttribute(dataSubjectEClass, DATA_SUBJECT__NAME);
		createEReference(dataSubjectEClass, DATA_SUBJECT__GIVES);
		createEReference(dataSubjectEClass, DATA_SUBJECT__AFFECTED_BY);

		userEClass = createEClass(USER);

		administratorEClass = createEClass(ADMINISTRATOR);

		moderatorEClass = createEClass(MODERATOR);

		personalDataEClass = createEClass(PERSONAL_DATA);
		createEReference(personalDataEClass, PERSONAL_DATA__IDENTIFIES);
		createEReference(personalDataEClass, PERSONAL_DATA__PROCESSED_BY);
		createEReference(personalDataEClass, PERSONAL_DATA__SUBJECT_OF_CONSENT);

		usernameEClass = createEClass(USERNAME);

		passwordEClass = createEClass(PASSWORD);

		emailAddressEClass = createEClass(EMAIL_ADDRESS);

		paymentEClass = createEClass(PAYMENT);

		streamingHistoryEClass = createEClass(STREAMING_HISTORY);

		trackingCookieEClass = createEClass(TRACKING_COOKIE);

		videoContentEClass = createEClass(VIDEO_CONTENT);

		videoCommentEClass = createEClass(VIDEO_COMMENT);

		videoMetadataEClass = createEClass(VIDEO_METADATA);

		deviceTypeEClass = createEClass(DEVICE_TYPE);

		deviceLocationEClass = createEClass(DEVICE_LOCATION);

		requestTimestampsEClass = createEClass(REQUEST_TIMESTAMPS);

		dataEClass = createEClass(DATA);
		createEAttribute(dataEClass, DATA__NAME);

		nonPersonalDataEClass = createEClass(NON_PERSONAL_DATA);
		createEReference(nonPersonalDataEClass, NON_PERSONAL_DATA__PROCESSED_BY);

		purposeEClass = createEClass(PURPOSE);
		createEAttribute(purposeEClass, PURPOSE__NAME);
		createEReference(purposeEClass, PURPOSE__OF_FUNCTION);
		createEOperation(purposeEClass, PURPOSE___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP);

		componentEClass = createEClass(COMPONENT);
		createEReference(componentEClass, COMPONENT__REALIZES);
		createEAttribute(componentEClass, COMPONENT__NAME);
		createEReference(componentEClass, COMPONENT__AFFECTED_BY);

		angularSPAEClass = createEClass(ANGULAR_SPA);

		nginxEClass = createEClass(NGINX);

		expressJSEClass = createEClass(EXPRESS_JS);

		functionEClass = createEClass(FUNCTION);
		createEAttribute(functionEClass, FUNCTION__NAME);
		createEReference(functionEClass, FUNCTION__REALIZED_BY);
		createEReference(functionEClass, FUNCTION__PROCESSES);

		funcPersDataEClass = createEClass(FUNC_PERS_DATA);
		createEReference(funcPersDataEClass, FUNC_PERS_DATA__PROCESSES_PERS_DATA);
		createEReference(funcPersDataEClass, FUNC_PERS_DATA__HAS);

		serveStandardAdsEClass = createEClass(SERVE_STANDARD_ADS);

		uploadVideoEClass = createEClass(UPLOAD_VIDEO);

		streamVideoEClass = createEClass(STREAM_VIDEO);

		removeVideoEClass = createEClass(REMOVE_VIDEO);

		liveStreamVideoEClass = createEClass(LIVE_STREAM_VIDEO);

		p2PStreamingEClass = createEClass(P2P_STREAMING);

		recommendVideosEClass = createEClass(RECOMMEND_VIDEOS);

		serveBehaviorTargetedAdsEClass = createEClass(SERVE_BEHAVIOR_TARGETED_ADS);

		commentWriteReadEClass = createEClass(COMMENT_WRITE_READ);

		serveLocationTargetedAdsEClass = createEClass(SERVE_LOCATION_TARGETED_ADS);

		purposeNoConsentEClass = createEClass(PURPOSE_NO_CONSENT);

		purposeConsentEClass = createEClass(PURPOSE_CONSENT);
		createEReference(purposeConsentEClass, PURPOSE_CONSENT__REQUIRES);

		pMarketingEClass = createEClass(PMARKETING);

		pStandardAdsEClass = createEClass(PSTANDARD_ADS);

		pTargetedAdsEClass = createEClass(PTARGETED_ADS);

		pLocationTargetedAdsEClass = createEClass(PLOCATION_TARGETED_ADS);

		pBehaviorTargetedAdsEClass = createEClass(PBEHAVIOR_TARGETED_ADS);

		pProfilingEClass = createEClass(PPROFILING);

		pFirstPartyProfilingEClass = createEClass(PFIRST_PARTY_PROFILING);

		pThirdPartyProfilingEClass = createEClass(PTHIRD_PARTY_PROFILING);

		pUserExperienceEClass = createEClass(PUSER_EXPERIENCE);

		pVideoRecommendationEClass = createEClass(PVIDEO_RECOMMENDATION);

		pp2PStreamingEClass = createEClass(PP2P_STREAMING);

		pSocialEClass = createEClass(PSOCIAL);

		cvE_2018_16843EClass = createEClass(CVE_2018_16843);

		cvE_2018_16844EClass = createEClass(CVE_2018_16844);

		cvE_2018_16845EClass = createEClass(CVE_2018_16845);

		cvE_2019_9511EClass = createEClass(CVE_2019_9511);

		cvE_2019_9513EClass = createEClass(CVE_2019_9513);

		cvE_2019_9516EClass = createEClass(CVE_2019_9516);

		cvE_2021_23017EClass = createEClass(CVE_2021_23017);

		cvE_2021_3618EClass = createEClass(CVE_2021_3618);

		cvE_2022_24834EClass = createEClass(CVE_2022_24834);

		cvE_2022_36021EClass = createEClass(CVE_2022_36021);

		cvE_2022_41862EClass = createEClass(CVE_2022_41862);

		cvE_2023_2455EClass = createEClass(CVE_2023_2455);

		cvE_2023_25155EClass = createEClass(CVE_2023_25155);

		cvE_2023_28856EClass = createEClass(CVE_2023_28856);

		cvE_2023_44487EClass = createEClass(CVE_2023_44487);

		cvE_2023_45145EClass = createEClass(CVE_2023_45145);

		cvE_2023_46809EClass = createEClass(CVE_2023_46809);

		cvE_2023_5870EClass = createEClass(CVE_2023_5870);

		cvE_2024_0985EClass = createEClass(CVE_2024_0985);

		cvE_2024_10976EClass = createEClass(CVE_2024_10976);

		cvE_2024_10977EClass = createEClass(CVE_2024_10977);

		cvE_2024_10978EClass = createEClass(CVE_2024_10978);

		cvE_2024_10979EClass = createEClass(CVE_2024_10979);

		cvE_2024_21890EClass = createEClass(CVE_2024_21890);

		cvE_2024_21891EClass = createEClass(CVE_2024_21891);

		cvE_2024_21896EClass = createEClass(CVE_2024_21896);

		cvE_2024_22017EClass = createEClass(CVE_2024_22017);

		cvE_2024_22018EClass = createEClass(CVE_2024_22018);

		cvE_2024_22019EClass = createEClass(CVE_2024_22019);

		cvE_2024_22020EClass = createEClass(CVE_2024_22020);

		cvE_2024_22025EClass = createEClass(CVE_2024_22025);

		cvE_2024_27980EClass = createEClass(CVE_2024_27980);

		cvE_2024_27983EClass = createEClass(CVE_2024_27983);

		cvE_2024_31449EClass = createEClass(CVE_2024_31449);

		cvE_2024_31489EClass = createEClass(CVE_2024_31489);

		cvE_2024_3566EClass = createEClass(CVE_2024_3566);

		cvE_2024_36137EClass = createEClass(CVE_2024_36137);

		cvE_2024_36138EClass = createEClass(CVE_2024_36138);

		cvE_2024_37372EClass = createEClass(CVE_2024_37372);

		cvE_2024_46981EClass = createEClass(CVE_2024_46981);

		cvE_2024_5205EClass = createEClass(CVE_2024_5205);

		cvE_2024_7347EClass = createEClass(CVE_2024_7347);

		cvE_2024_7348EClass = createEClass(CVE_2024_7348);

		cvE_2025_1094EClass = createEClass(CVE_2025_1094);

		cvE_2025_11187EClass = createEClass(CVE_2025_11187);

		cvE_2025_15468EClass = createEClass(CVE_2025_15468);

		cvE_2025_21605EClass = createEClass(CVE_2025_21605);

		cvE_2025_23084EClass = createEClass(CVE_2025_23084);

		cvE_2025_23090EClass = createEClass(CVE_2025_23090);

		cvE_2025_32023EClass = createEClass(CVE_2025_32023);

		cvE_2025_62506EClass = createEClass(CVE_2025_62506);

		cvE_2025_62507EClass = createEClass(CVE_2025_62507);

		cvE_2025_66199EClass = createEClass(CVE_2025_66199);

		cvE_2025_69418EClass = createEClass(CVE_2025_69418);

		cvE_2025_69420EClass = createEClass(CVE_2025_69420);

		cvE_2025_69421EClass = createEClass(CVE_2025_69421);

		cvE_2026_22795EClass = createEClass(CVE_2026_22795);

		cvE_2026_22796EClass = createEClass(CVE_2026_22796);

		cvE_2026_27970EClass = createEClass(CVE_2026_27970);

		pCommentsEClass = createEClass(PCOMMENTS);

		pVideoSharingEClass = createEClass(PVIDEO_SHARING);

		vulnerabilityEClass = createEClass(VULNERABILITY);
		createEAttribute(vulnerabilityEClass, VULNERABILITY__CVE_NAME);
		createEReference(vulnerabilityEClass, VULNERABILITY__AFFECTS);
		createEReference(vulnerabilityEClass, VULNERABILITY__DESCRIBED_BY);
		createEReference(vulnerabilityEClass, VULNERABILITY__CAUSES);
		createEAttribute(vulnerabilityEClass, VULNERABILITY__IS_ENABLED);
		createEOperation(vulnerabilityEClass, VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP);

		cvssVectorEClass = createEClass(CVSS_VECTOR);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__ATTACK_VECTOR);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__ATTACK_COMPLEXITY);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__SCOPE);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__PRIVILEGES_REQUIRED);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__USER_INTERACTION);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__EXPLOIT_CODE_MATURITY);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__REPORT_CONFIDENCE);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__CONFIDENTIALITY_IMPACT);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__INTEGRITY_IMPACT);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__AVAILABILITY_IMPACT);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__REMEDIATION_LEVEL);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__INTEGRITY_REQUIREMENT);
		createEAttribute(cvssVectorEClass, CVSS_VECTOR__AVAILABILITY_REQUIREMENT);

		riskEClass = createEClass(RISK);
		createEAttribute(riskEClass, RISK__LEVEL);
		createEReference(riskEClass, RISK__AFFECTS);
		createEReference(riskEClass, RISK__CAUSED_BY);

		systemEClass = createEClass(SYSTEM);
		createEReference(systemEClass, SYSTEM__FUNCTIONS);
		createEReference(systemEClass, SYSTEM__DATAS);
		createEReference(systemEClass, SYSTEM__DATA_SUBJECTS);
		createEReference(systemEClass, SYSTEM__VULNERABILITIES);
		createEReference(systemEClass, SYSTEM__COMPONENTS);
		createEReference(systemEClass, SYSTEM__PURPOSES);

		redisComponentEClass = createEClass(REDIS_COMPONENT);

		filesystemComponentEClass = createEClass(FILESYSTEM_COMPONENT);

		postgresqlEClass = createEClass(POSTGRESQL);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private boolean isInitialized = false;

	/**
	 * Complete the initialization of the package and its meta-model.  This
	 * method is guarded to have no affect on any invocation but its first.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void initializePackageContents() {
		if (isInitialized) return;
		isInitialized = true;

		// Initialize package
		setName(eNAME);
		setNsPrefix(eNS_PREFIX);
		setNsURI(eNS_URI);

		// Obtain other dependent packages
		CVSSPackage theCVSSPackage = (CVSSPackage)EPackage.Registry.INSTANCE.getEPackage(CVSSPackage.eNS_URI);

		// Add subpackages
		getESubpackages().add(theCVSSPackage);

		// Create type parameters

		// Set bounds for type parameters

		// Add supertypes to classes
		userEClass.getESuperTypes().add(this.getDataSubject());
		administratorEClass.getESuperTypes().add(this.getDataSubject());
		moderatorEClass.getESuperTypes().add(this.getDataSubject());
		personalDataEClass.getESuperTypes().add(this.getData());
		usernameEClass.getESuperTypes().add(this.getPersonalData());
		passwordEClass.getESuperTypes().add(this.getPersonalData());
		emailAddressEClass.getESuperTypes().add(this.getPersonalData());
		paymentEClass.getESuperTypes().add(this.getPersonalData());
		streamingHistoryEClass.getESuperTypes().add(this.getPersonalData());
		trackingCookieEClass.getESuperTypes().add(this.getPersonalData());
		videoContentEClass.getESuperTypes().add(this.getPersonalData());
		videoCommentEClass.getESuperTypes().add(this.getPersonalData());
		videoMetadataEClass.getESuperTypes().add(this.getPersonalData());
		deviceTypeEClass.getESuperTypes().add(this.getPersonalData());
		deviceLocationEClass.getESuperTypes().add(this.getPersonalData());
		requestTimestampsEClass.getESuperTypes().add(this.getPersonalData());
		nonPersonalDataEClass.getESuperTypes().add(this.getData());
		angularSPAEClass.getESuperTypes().add(this.getComponent());
		nginxEClass.getESuperTypes().add(this.getComponent());
		expressJSEClass.getESuperTypes().add(this.getComponent());
		funcPersDataEClass.getESuperTypes().add(this.getFunction());
		serveStandardAdsEClass.getESuperTypes().add(this.getFuncPersData());
		uploadVideoEClass.getESuperTypes().add(this.getFuncPersData());
		streamVideoEClass.getESuperTypes().add(this.getFuncPersData());
		removeVideoEClass.getESuperTypes().add(this.getFuncPersData());
		liveStreamVideoEClass.getESuperTypes().add(this.getFuncPersData());
		p2PStreamingEClass.getESuperTypes().add(this.getFuncPersData());
		recommendVideosEClass.getESuperTypes().add(this.getFuncPersData());
		serveBehaviorTargetedAdsEClass.getESuperTypes().add(this.getFuncPersData());
		commentWriteReadEClass.getESuperTypes().add(this.getFuncPersData());
		serveLocationTargetedAdsEClass.getESuperTypes().add(this.getFuncPersData());
		purposeNoConsentEClass.getESuperTypes().add(this.getPurpose());
		purposeConsentEClass.getESuperTypes().add(this.getPurpose());
		pMarketingEClass.getESuperTypes().add(this.getPurposeConsent());
		pStandardAdsEClass.getESuperTypes().add(this.getPMarketing());
		pTargetedAdsEClass.getESuperTypes().add(this.getPMarketing());
		pLocationTargetedAdsEClass.getESuperTypes().add(this.getPTargetedAds());
		pBehaviorTargetedAdsEClass.getESuperTypes().add(this.getPTargetedAds());
		pProfilingEClass.getESuperTypes().add(this.getPurposeConsent());
		pFirstPartyProfilingEClass.getESuperTypes().add(this.getPProfiling());
		pThirdPartyProfilingEClass.getESuperTypes().add(this.getPFirstPartyProfiling());
		pUserExperienceEClass.getESuperTypes().add(this.getPurposeConsent());
		pVideoRecommendationEClass.getESuperTypes().add(this.getPUserExperience());
		pp2PStreamingEClass.getESuperTypes().add(this.getPUserExperience());
		pSocialEClass.getESuperTypes().add(this.getPurposeConsent());
		cvE_2018_16843EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2018_16844EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2018_16845EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2019_9511EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2019_9513EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2019_9516EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2021_23017EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2021_3618EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2022_24834EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2022_36021EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2022_41862EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2023_2455EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2023_25155EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2023_28856EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2023_44487EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2023_45145EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2023_46809EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2023_5870EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_0985EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_10976EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_10977EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_10978EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_10979EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_21890EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_21891EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_21896EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_22017EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_22018EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_22019EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_22020EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_22025EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_27980EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_27983EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_31449EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_31489EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_3566EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_36137EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_36138EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_37372EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_46981EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_5205EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_7347EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2024_7348EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_1094EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_11187EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_15468EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_21605EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_23084EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_23090EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_32023EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_62506EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_62507EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_66199EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_69418EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_69420EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2025_69421EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2026_22795EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2026_22796EClass.getESuperTypes().add(this.getVulnerability());
		cvE_2026_27970EClass.getESuperTypes().add(this.getVulnerability());
		pCommentsEClass.getESuperTypes().add(this.getPSocial());
		pVideoSharingEClass.getESuperTypes().add(this.getPComments());
		redisComponentEClass.getESuperTypes().add(this.getComponent());
		filesystemComponentEClass.getESuperTypes().add(this.getComponent());
		postgresqlEClass.getESuperTypes().add(this.getComponent());

		// Initialize classes, features, and operations; add parameters
		initEClass(consentEClass, Consent.class, "Consent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getConsent_ForPurpose(), ecorePackage.getEString(), "forPurpose", null, 0, 1, Consent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getConsent_InformedRiskLevel(), ecorePackage.getEDouble(), "informedRiskLevel", null, 1, 1, Consent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsent_GivenFor(), this.getPurposeConsent(), this.getPurposeConsent_Requires(), "givenFor", null, 0, -1, Consent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsent_GivenBy(), this.getDataSubject(), this.getDataSubject_Gives(), "givenBy", null, 1, 1, Consent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getConsent_ForPersonalData(), this.getPersonalData(), this.getPersonalData_SubjectOfConsent(), "forPersonalData", null, 0, -1, Consent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(dataSubjectEClass, DataSubject.class, "DataSubject", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getDataSubject_IdentifiedBy(), this.getPersonalData(), this.getPersonalData_Identifies(), "identifiedBy", null, 0, -1, DataSubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getDataSubject_Name(), ecorePackage.getEString(), "name", null, 0, 1, DataSubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSubject_Gives(), this.getConsent(), this.getConsent_GivenBy(), "gives", null, 0, -1, DataSubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getDataSubject_AffectedBy(), this.getRisk(), this.getRisk_Affects(), "affectedBy", null, 0, 1, DataSubject.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(userEClass, User.class, "User", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(administratorEClass, Administrator.class, "Administrator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(moderatorEClass, Moderator.class, "Moderator", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(personalDataEClass, PersonalData.class, "PersonalData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPersonalData_Identifies(), this.getDataSubject(), this.getDataSubject_IdentifiedBy(), "identifies", null, 1, 1, PersonalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonalData_ProcessedBy(), this.getFuncPersData(), this.getFuncPersData_ProcessesPersData(), "processedBy", null, 0, -1, PersonalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPersonalData_SubjectOfConsent(), this.getConsent(), this.getConsent_ForPersonalData(), "subjectOfConsent", null, 0, -1, PersonalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(usernameEClass, Username.class, "Username", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(passwordEClass, Password.class, "Password", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(emailAddressEClass, EmailAddress.class, "EmailAddress", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(paymentEClass, Payment.class, "Payment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(streamingHistoryEClass, StreamingHistory.class, "StreamingHistory", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(trackingCookieEClass, TrackingCookie.class, "TrackingCookie", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(videoContentEClass, VideoContent.class, "VideoContent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(videoCommentEClass, VideoComment.class, "VideoComment", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(videoMetadataEClass, VideoMetadata.class, "VideoMetadata", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deviceTypeEClass, DeviceType.class, "DeviceType", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(deviceLocationEClass, DeviceLocation.class, "DeviceLocation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(requestTimestampsEClass, RequestTimestamps.class, "RequestTimestamps", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(dataEClass, Data.class, "Data", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getData_Name(), ecorePackage.getEString(), "name", null, 0, 1, Data.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(nonPersonalDataEClass, NonPersonalData.class, "NonPersonalData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getNonPersonalData_ProcessedBy(), this.getFunction(), this.getFunction_Processes(), "processedBy", null, 0, -1, NonPersonalData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(purposeEClass, Purpose.class, "Purpose", IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getPurpose_Name(), ecorePackage.getEString(), "name", null, 0, 1, Purpose.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getPurpose_OfFunction(), this.getFuncPersData(), this.getFuncPersData_Has(), "ofFunction", null, 0, -1, Purpose.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		EOperation op = initEOperation(getPurpose__UniquePurposes__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "UniquePurposes", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		EGenericType g1 = createEGenericType(ecorePackage.getEMap());
		EGenericType g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(componentEClass, Component.class, "Component", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getComponent_Realizes(), this.getFunction(), this.getFunction_RealizedBy(), "realizes", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getComponent_Name(), ecorePackage.getEString(), "name", null, 0, 1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getComponent_AffectedBy(), this.getVulnerability(), this.getVulnerability_Affects(), "affectedBy", null, 0, -1, Component.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(angularSPAEClass, AngularSPA.class, "AngularSPA", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(nginxEClass, Nginx.class, "Nginx", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(expressJSEClass, ExpressJS.class, "ExpressJS", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(functionEClass, Function.class, "Function", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getFunction_Name(), ecorePackage.getEString(), "name", null, 0, 1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_RealizedBy(), this.getComponent(), this.getComponent_Realizes(), "realizedBy", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFunction_Processes(), this.getNonPersonalData(), this.getNonPersonalData_ProcessedBy(), "processes", null, 0, -1, Function.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(funcPersDataEClass, FuncPersData.class, "FuncPersData", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getFuncPersData_ProcessesPersData(), this.getPersonalData(), this.getPersonalData_ProcessedBy(), "processesPersData", null, 1, -1, FuncPersData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getFuncPersData_Has(), this.getPurpose(), this.getPurpose_OfFunction(), "has", null, 1, -1, FuncPersData.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(serveStandardAdsEClass, ServeStandardAds.class, "ServeStandardAds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(uploadVideoEClass, UploadVideo.class, "UploadVideo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(streamVideoEClass, StreamVideo.class, "StreamVideo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(removeVideoEClass, RemoveVideo.class, "RemoveVideo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(liveStreamVideoEClass, LiveStreamVideo.class, "LiveStreamVideo", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(p2PStreamingEClass, P2PStreaming.class, "P2PStreaming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(recommendVideosEClass, RecommendVideos.class, "RecommendVideos", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(serveBehaviorTargetedAdsEClass, ServeBehaviorTargetedAds.class, "ServeBehaviorTargetedAds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(commentWriteReadEClass, CommentWriteRead.class, "CommentWriteRead", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(serveLocationTargetedAdsEClass, ServeLocationTargetedAds.class, "ServeLocationTargetedAds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(purposeNoConsentEClass, PurposeNoConsent.class, "PurposeNoConsent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(purposeConsentEClass, PurposeConsent.class, "PurposeConsent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getPurposeConsent_Requires(), this.getConsent(), this.getConsent_GivenFor(), "requires", null, 0, -1, PurposeConsent.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(pMarketingEClass, PMarketing.class, "PMarketing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pStandardAdsEClass, PStandardAds.class, "PStandardAds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pTargetedAdsEClass, PTargetedAds.class, "PTargetedAds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pLocationTargetedAdsEClass, PLocationTargetedAds.class, "PLocationTargetedAds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pBehaviorTargetedAdsEClass, PBehaviorTargetedAds.class, "PBehaviorTargetedAds", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pProfilingEClass, PProfiling.class, "PProfiling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pFirstPartyProfilingEClass, PFirstPartyProfiling.class, "PFirstPartyProfiling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pThirdPartyProfilingEClass, PThirdPartyProfiling.class, "PThirdPartyProfiling", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pUserExperienceEClass, PUserExperience.class, "PUserExperience", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pVideoRecommendationEClass, PVideoRecommendation.class, "PVideoRecommendation", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pp2PStreamingEClass, PP2PStreaming.class, "PP2PStreaming", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pSocialEClass, PSocial.class, "PSocial", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2018_16843EClass, CASA.CVE_2018_16843.class, "CVE_2018_16843", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2018_16844EClass, CASA.CVE_2018_16844.class, "CVE_2018_16844", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2018_16845EClass, CASA.CVE_2018_16845.class, "CVE_2018_16845", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2019_9511EClass, CASA.CVE_2019_9511.class, "CVE_2019_9511", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2019_9513EClass, CASA.CVE_2019_9513.class, "CVE_2019_9513", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2019_9516EClass, CASA.CVE_2019_9516.class, "CVE_2019_9516", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2021_23017EClass, CASA.CVE_2021_23017.class, "CVE_2021_23017", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2021_3618EClass, CASA.CVE_2021_3618.class, "CVE_2021_3618", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2022_24834EClass, CASA.CVE_2022_24834.class, "CVE_2022_24834", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2022_36021EClass, CASA.CVE_2022_36021.class, "CVE_2022_36021", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2022_41862EClass, CASA.CVE_2022_41862.class, "CVE_2022_41862", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2023_2455EClass, CASA.CVE_2023_2455.class, "CVE_2023_2455", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2023_25155EClass, CASA.CVE_2023_25155.class, "CVE_2023_25155", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2023_28856EClass, CASA.CVE_2023_28856.class, "CVE_2023_28856", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2023_44487EClass, CASA.CVE_2023_44487.class, "CVE_2023_44487", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2023_45145EClass, CASA.CVE_2023_45145.class, "CVE_2023_45145", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2023_46809EClass, CASA.CVE_2023_46809.class, "CVE_2023_46809", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2023_5870EClass, CASA.CVE_2023_5870.class, "CVE_2023_5870", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_0985EClass, CASA.CVE_2024_0985.class, "CVE_2024_0985", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_10976EClass, CASA.CVE_2024_10976.class, "CVE_2024_10976", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_10977EClass, CASA.CVE_2024_10977.class, "CVE_2024_10977", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_10978EClass, CASA.CVE_2024_10978.class, "CVE_2024_10978", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_10979EClass, CASA.CVE_2024_10979.class, "CVE_2024_10979", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_21890EClass, CASA.CVE_2024_21890.class, "CVE_2024_21890", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_21891EClass, CASA.CVE_2024_21891.class, "CVE_2024_21891", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_21896EClass, CASA.CVE_2024_21896.class, "CVE_2024_21896", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_22017EClass, CASA.CVE_2024_22017.class, "CVE_2024_22017", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_22018EClass, CASA.CVE_2024_22018.class, "CVE_2024_22018", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_22019EClass, CASA.CVE_2024_22019.class, "CVE_2024_22019", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_22020EClass, CASA.CVE_2024_22020.class, "CVE_2024_22020", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_22025EClass, CASA.CVE_2024_22025.class, "CVE_2024_22025", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_27980EClass, CASA.CVE_2024_27980.class, "CVE_2024_27980", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_27983EClass, CASA.CVE_2024_27983.class, "CVE_2024_27983", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_31449EClass, CASA.CVE_2024_31449.class, "CVE_2024_31449", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_31489EClass, CASA.CVE_2024_31489.class, "CVE_2024_31489", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_3566EClass, CASA.CVE_2024_3566.class, "CVE_2024_3566", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_36137EClass, CASA.CVE_2024_36137.class, "CVE_2024_36137", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_36138EClass, CASA.CVE_2024_36138.class, "CVE_2024_36138", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_37372EClass, CASA.CVE_2024_37372.class, "CVE_2024_37372", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_46981EClass, CASA.CVE_2024_46981.class, "CVE_2024_46981", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_5205EClass, CASA.CVE_2024_5205.class, "CVE_2024_5205", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_7347EClass, CASA.CVE_2024_7347.class, "CVE_2024_7347", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2024_7348EClass, CASA.CVE_2024_7348.class, "CVE_2024_7348", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_1094EClass, CASA.CVE_2025_1094.class, "CVE_2025_1094", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_11187EClass, CASA.CVE_2025_11187.class, "CVE_2025_11187", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_15468EClass, CASA.CVE_2025_15468.class, "CVE_2025_15468", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_21605EClass, CASA.CVE_2025_21605.class, "CVE_2025_21605", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_23084EClass, CASA.CVE_2025_23084.class, "CVE_2025_23084", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_23090EClass, CASA.CVE_2025_23090.class, "CVE_2025_23090", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_32023EClass, CASA.CVE_2025_32023.class, "CVE_2025_32023", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_62506EClass, CASA.CVE_2025_62506.class, "CVE_2025_62506", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_62507EClass, CASA.CVE_2025_62507.class, "CVE_2025_62507", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_66199EClass, CASA.CVE_2025_66199.class, "CVE_2025_66199", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_69418EClass, CASA.CVE_2025_69418.class, "CVE_2025_69418", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_69420EClass, CASA.CVE_2025_69420.class, "CVE_2025_69420", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2025_69421EClass, CASA.CVE_2025_69421.class, "CVE_2025_69421", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2026_22795EClass, CASA.CVE_2026_22795.class, "CVE_2026_22795", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2026_22796EClass, CASA.CVE_2026_22796.class, "CVE_2026_22796", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(cvE_2026_27970EClass, CASA.CVE_2026_27970.class, "CVE_2026_27970", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pCommentsEClass, PComments.class, "PComments", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(pVideoSharingEClass, PVideoSharing.class, "PVideoSharing", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(vulnerabilityEClass, Vulnerability.class, "Vulnerability", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getVulnerability_CveName(), ecorePackage.getEString(), "cveName", null, 0, 1, Vulnerability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVulnerability_Affects(), this.getComponent(), this.getComponent_AffectedBy(), "affects", null, 0, -1, Vulnerability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVulnerability_DescribedBy(), this.getCVSSVector(), null, "describedBy", null, 1, 1, Vulnerability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getVulnerability_Causes(), this.getRisk(), this.getRisk_CausedBy(), "causes", null, 0, -1, Vulnerability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getVulnerability_IsEnabled(), ecorePackage.getEBoolean(), "isEnabled", "true", 0, 1, Vulnerability.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		op = initEOperation(getVulnerability__UniqueVulnerabilities__DiagnosticChain_Map(), ecorePackage.getEBoolean(), "UniqueVulnerabilities", 0, 1, IS_UNIQUE, IS_ORDERED);
		addEParameter(op, ecorePackage.getEDiagnosticChain(), "diagnostics", 0, 1, IS_UNIQUE, IS_ORDERED);
		g1 = createEGenericType(ecorePackage.getEMap());
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		g2 = createEGenericType(ecorePackage.getEJavaObject());
		g1.getETypeArguments().add(g2);
		addEParameter(op, g1, "context", 0, 1, IS_UNIQUE, IS_ORDERED);

		initEClass(cvssVectorEClass, CVSSVector.class, "CVSSVector", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getCVSSVector_AttackVector(), theCVSSPackage.getAttackVector(), "attackVector", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_AttackComplexity(), theCVSSPackage.getAttackComplexity(), "attackComplexity", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_Scope(), theCVSSPackage.getScope(), "scope", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_PrivilegesRequired(), theCVSSPackage.getPrivilegesRequired(), "privilegesRequired", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_UserInteraction(), theCVSSPackage.getUserInteraction(), "userInteraction", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_ExploitCodeMaturity(), theCVSSPackage.getExploitCodeMaturity(), "exploitCodeMaturity", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_ReportConfidence(), theCVSSPackage.getReportConfidence(), "reportConfidence", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_ConfidentialityImpact(), theCVSSPackage.getConfidentialityImpact(), "confidentialityImpact", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_IntegrityImpact(), theCVSSPackage.getIntegrityImpact(), "integrityImpact", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_AvailabilityImpact(), theCVSSPackage.getAvailabilityImpact(), "availabilityImpact", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_RemediationLevel(), theCVSSPackage.getRemediationLevel(), "remediationLevel", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_ConfidentialityRequirement(), theCVSSPackage.getConfidentialityRequirement(), "confidentialityRequirement", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_IntegrityRequirement(), theCVSSPackage.getIntegrityRequirement(), "integrityRequirement", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEAttribute(getCVSSVector_AvailabilityRequirement(), theCVSSPackage.getAvailabilityRequirement(), "availabilityRequirement", null, 0, 1, CVSSVector.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(riskEClass, Risk.class, "Risk", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEAttribute(getRisk_Level(), ecorePackage.getEDouble(), "level", null, 0, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_UNSETTABLE, !IS_ID, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRisk_Affects(), this.getDataSubject(), this.getDataSubject_AffectedBy(), "affects", null, 1, 1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getRisk_CausedBy(), this.getVulnerability(), this.getVulnerability_Causes(), "causedBy", null, 0, -1, Risk.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, !IS_COMPOSITE, IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(systemEClass, CASA.System.class, "System", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);
		initEReference(getSystem_Functions(), this.getFunction(), null, "functions", null, 0, -1, CASA.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Datas(), this.getData(), null, "datas", null, 0, -1, CASA.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_DataSubjects(), this.getDataSubject(), null, "dataSubjects", null, 0, -1, CASA.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Vulnerabilities(), this.getVulnerability(), null, "vulnerabilities", null, 0, -1, CASA.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Components(), this.getComponent(), null, "components", null, 0, -1, CASA.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);
		initEReference(getSystem_Purposes(), this.getPurpose(), null, "purposes", null, 0, -1, CASA.System.class, !IS_TRANSIENT, !IS_VOLATILE, IS_CHANGEABLE, IS_COMPOSITE, !IS_RESOLVE_PROXIES, !IS_UNSETTABLE, IS_UNIQUE, !IS_DERIVED, IS_ORDERED);

		initEClass(redisComponentEClass, RedisComponent.class, "RedisComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(filesystemComponentEClass, FilesystemComponent.class, "FilesystemComponent", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		initEClass(postgresqlEClass, Postgresql.class, "Postgresql", !IS_ABSTRACT, !IS_INTERFACE, IS_GENERATED_INSTANCE_CLASS);

		// Create resource
		createResource(eNS_URI);

		// Create annotations
		// http://www.eclipse.org/emf/2002/Ecore
		createEcoreAnnotations();
		// http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot
		createPivotAnnotations();
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createEcoreAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore";
		addAnnotation
		  (this,
		   source,
		   new String[] {
		   });
		addAnnotation
		  (purposeEClass,
		   source,
		   new String[] {
			   "constraints", "UniquePurposes"
		   });
		addAnnotation
		  (vulnerabilityEClass,
		   source,
		   new String[] {
			   "constraints", "UniqueVulnerabilities"
		   });
	}

	/**
	 * Initializes the annotations for <b>http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot</b>.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected void createPivotAnnotations() {
		String source = "http://www.eclipse.org/emf/2002/Ecore/OCL/Pivot";
		addAnnotation
		  (getPurpose__UniquePurposes__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\tPurpose.allInstances() -> isUnique(p | p.name)"
		   });
		addAnnotation
		  (getVulnerability__UniqueVulnerabilities__DiagnosticChain_Map(),
		   source,
		   new String[] {
			   "body", "\n\t\t\tVulnerability.allInstances() -> isUnique(v | v.cveName)"
		   });
	}

} //CASAPackageImpl
