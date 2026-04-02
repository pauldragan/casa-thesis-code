/**
 */
package CASA.impl;

import CASA.Administrator;
import CASA.AngularSPA;
import CASA.CASAFactory;
import CASA.CASAPackage;
import CASA.CVE_2018_16843;
import CASA.CVE_2018_16844;
import CASA.CVE_2018_16845;
import CASA.CVE_2019_9511;
import CASA.CVE_2019_9513;
import CASA.CVE_2019_9516;
import CASA.CVE_2021_23017;
import CASA.CVE_2021_3618;
import CASA.CVE_2022_24834;
import CASA.CVE_2022_36021;
import CASA.CVE_2022_41862;
import CASA.CVE_2023_2455;
import CASA.CVE_2023_25155;
import CASA.CVE_2023_28856;
import CASA.CVE_2023_44487;
import CASA.CVE_2023_45145;
import CASA.CVE_2023_46809;
import CASA.CVE_2023_5870;
import CASA.CVE_2024_0985;
import CASA.CVE_2024_10976;
import CASA.CVE_2024_10977;
import CASA.CVE_2024_10978;
import CASA.CVE_2024_10979;
import CASA.CVE_2024_21890;
import CASA.CVE_2024_21891;
import CASA.CVE_2024_21896;
import CASA.CVE_2024_22017;
import CASA.CVE_2024_22018;
import CASA.CVE_2024_22019;
import CASA.CVE_2024_22020;
import CASA.CVE_2024_22025;
import CASA.CVE_2024_27980;
import CASA.CVE_2024_27983;
import CASA.CVE_2024_31449;
import CASA.CVE_2024_31489;
import CASA.CVE_2024_3566;
import CASA.CVE_2024_36137;
import CASA.CVE_2024_36138;
import CASA.CVE_2024_37372;
import CASA.CVE_2024_46981;
import CASA.CVE_2024_5205;
import CASA.CVE_2024_7347;
import CASA.CVE_2024_7348;
import CASA.CVE_2025_1094;
import CASA.CVE_2025_11187;
import CASA.CVE_2025_15468;
import CASA.CVE_2025_21605;
import CASA.CVE_2025_23084;
import CASA.CVE_2025_23090;
import CASA.CVE_2025_32023;
import CASA.CVE_2025_62506;
import CASA.CVE_2025_62507;
import CASA.CVE_2025_66199;
import CASA.CVE_2025_69418;
import CASA.CVE_2025_69420;
import CASA.CVE_2025_69421;
import CASA.CVE_2026_22795;
import CASA.CVE_2026_22796;
import CASA.CVE_2026_27970;
import CASA.CVSSVector;
import CASA.CommentWriteRead;
import CASA.Component;
import CASA.Consent;
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

import org.eclipse.emf.ecore.EClass;
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
public class CASAFactoryImpl extends EFactoryImpl implements CASAFactory {
	/**
	 * Creates the default factory implementation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static CASAFactory init() {
		try {
			CASAFactory theCASAFactory = (CASAFactory)EPackage.Registry.INSTANCE.getEFactory(CASAPackage.eNS_URI);
			if (theCASAFactory != null) {
				return theCASAFactory;
			}
		}
		catch (Exception exception) {
			EcorePlugin.INSTANCE.log(exception);
		}
		return new CASAFactoryImpl();
	}

	/**
	 * Creates an instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CASAFactoryImpl() {
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
			case CASAPackage.CONSENT: return createConsent();
			case CASAPackage.DATA_SUBJECT: return createDataSubject();
			case CASAPackage.USER: return createUser();
			case CASAPackage.ADMINISTRATOR: return createAdministrator();
			case CASAPackage.MODERATOR: return createModerator();
			case CASAPackage.PERSONAL_DATA: return createPersonalData();
			case CASAPackage.USERNAME: return createUsername();
			case CASAPackage.PASSWORD: return createPassword();
			case CASAPackage.EMAIL_ADDRESS: return createEmailAddress();
			case CASAPackage.PAYMENT: return createPayment();
			case CASAPackage.STREAMING_HISTORY: return createStreamingHistory();
			case CASAPackage.TRACKING_COOKIE: return createTrackingCookie();
			case CASAPackage.VIDEO_CONTENT: return createVideoContent();
			case CASAPackage.VIDEO_COMMENT: return createVideoComment();
			case CASAPackage.VIDEO_METADATA: return createVideoMetadata();
			case CASAPackage.DEVICE_TYPE: return createDeviceType();
			case CASAPackage.DEVICE_LOCATION: return createDeviceLocation();
			case CASAPackage.REQUEST_TIMESTAMPS: return createRequestTimestamps();
			case CASAPackage.NON_PERSONAL_DATA: return createNonPersonalData();
			case CASAPackage.COMPONENT: return createComponent();
			case CASAPackage.ANGULAR_SPA: return createAngularSPA();
			case CASAPackage.NGINX: return createNginx();
			case CASAPackage.EXPRESS_JS: return createExpressJS();
			case CASAPackage.FUNCTION: return createFunction();
			case CASAPackage.FUNC_PERS_DATA: return createFuncPersData();
			case CASAPackage.SERVE_STANDARD_ADS: return createServeStandardAds();
			case CASAPackage.UPLOAD_VIDEO: return createUploadVideo();
			case CASAPackage.STREAM_VIDEO: return createStreamVideo();
			case CASAPackage.REMOVE_VIDEO: return createRemoveVideo();
			case CASAPackage.LIVE_STREAM_VIDEO: return createLiveStreamVideo();
			case CASAPackage.P2P_STREAMING: return createP2PStreaming();
			case CASAPackage.RECOMMEND_VIDEOS: return createRecommendVideos();
			case CASAPackage.SERVE_BEHAVIOR_TARGETED_ADS: return createServeBehaviorTargetedAds();
			case CASAPackage.COMMENT_WRITE_READ: return createCommentWriteRead();
			case CASAPackage.SERVE_LOCATION_TARGETED_ADS: return createServeLocationTargetedAds();
			case CASAPackage.PURPOSE_NO_CONSENT: return createPurposeNoConsent();
			case CASAPackage.PURPOSE_CONSENT: return createPurposeConsent();
			case CASAPackage.PMARKETING: return createPMarketing();
			case CASAPackage.PSTANDARD_ADS: return createPStandardAds();
			case CASAPackage.PTARGETED_ADS: return createPTargetedAds();
			case CASAPackage.PLOCATION_TARGETED_ADS: return createPLocationTargetedAds();
			case CASAPackage.PBEHAVIOR_TARGETED_ADS: return createPBehaviorTargetedAds();
			case CASAPackage.PPROFILING: return createPProfiling();
			case CASAPackage.PFIRST_PARTY_PROFILING: return createPFirstPartyProfiling();
			case CASAPackage.PTHIRD_PARTY_PROFILING: return createPThirdPartyProfiling();
			case CASAPackage.PUSER_EXPERIENCE: return createPUserExperience();
			case CASAPackage.PVIDEO_RECOMMENDATION: return createPVideoRecommendation();
			case CASAPackage.PP2P_STREAMING: return createPP2PStreaming();
			case CASAPackage.PSOCIAL: return createPSocial();
			case CASAPackage.CVE_2018_16843: return createCVE_2018_16843();
			case CASAPackage.CVE_2018_16844: return createCVE_2018_16844();
			case CASAPackage.CVE_2018_16845: return createCVE_2018_16845();
			case CASAPackage.CVE_2019_9511: return createCVE_2019_9511();
			case CASAPackage.CVE_2019_9513: return createCVE_2019_9513();
			case CASAPackage.CVE_2019_9516: return createCVE_2019_9516();
			case CASAPackage.CVE_2021_23017: return createCVE_2021_23017();
			case CASAPackage.CVE_2021_3618: return createCVE_2021_3618();
			case CASAPackage.CVE_2022_24834: return createCVE_2022_24834();
			case CASAPackage.CVE_2022_36021: return createCVE_2022_36021();
			case CASAPackage.CVE_2022_41862: return createCVE_2022_41862();
			case CASAPackage.CVE_2023_2455: return createCVE_2023_2455();
			case CASAPackage.CVE_2023_25155: return createCVE_2023_25155();
			case CASAPackage.CVE_2023_28856: return createCVE_2023_28856();
			case CASAPackage.CVE_2023_44487: return createCVE_2023_44487();
			case CASAPackage.CVE_2023_45145: return createCVE_2023_45145();
			case CASAPackage.CVE_2023_46809: return createCVE_2023_46809();
			case CASAPackage.CVE_2023_5870: return createCVE_2023_5870();
			case CASAPackage.CVE_2024_0985: return createCVE_2024_0985();
			case CASAPackage.CVE_2024_10976: return createCVE_2024_10976();
			case CASAPackage.CVE_2024_10977: return createCVE_2024_10977();
			case CASAPackage.CVE_2024_10978: return createCVE_2024_10978();
			case CASAPackage.CVE_2024_10979: return createCVE_2024_10979();
			case CASAPackage.CVE_2024_21890: return createCVE_2024_21890();
			case CASAPackage.CVE_2024_21891: return createCVE_2024_21891();
			case CASAPackage.CVE_2024_21896: return createCVE_2024_21896();
			case CASAPackage.CVE_2024_22017: return createCVE_2024_22017();
			case CASAPackage.CVE_2024_22018: return createCVE_2024_22018();
			case CASAPackage.CVE_2024_22019: return createCVE_2024_22019();
			case CASAPackage.CVE_2024_22020: return createCVE_2024_22020();
			case CASAPackage.CVE_2024_22025: return createCVE_2024_22025();
			case CASAPackage.CVE_2024_27980: return createCVE_2024_27980();
			case CASAPackage.CVE_2024_27983: return createCVE_2024_27983();
			case CASAPackage.CVE_2024_31449: return createCVE_2024_31449();
			case CASAPackage.CVE_2024_31489: return createCVE_2024_31489();
			case CASAPackage.CVE_2024_3566: return createCVE_2024_3566();
			case CASAPackage.CVE_2024_36137: return createCVE_2024_36137();
			case CASAPackage.CVE_2024_36138: return createCVE_2024_36138();
			case CASAPackage.CVE_2024_37372: return createCVE_2024_37372();
			case CASAPackage.CVE_2024_46981: return createCVE_2024_46981();
			case CASAPackage.CVE_2024_5205: return createCVE_2024_5205();
			case CASAPackage.CVE_2024_7347: return createCVE_2024_7347();
			case CASAPackage.CVE_2024_7348: return createCVE_2024_7348();
			case CASAPackage.CVE_2025_1094: return createCVE_2025_1094();
			case CASAPackage.CVE_2025_11187: return createCVE_2025_11187();
			case CASAPackage.CVE_2025_15468: return createCVE_2025_15468();
			case CASAPackage.CVE_2025_21605: return createCVE_2025_21605();
			case CASAPackage.CVE_2025_23084: return createCVE_2025_23084();
			case CASAPackage.CVE_2025_23090: return createCVE_2025_23090();
			case CASAPackage.CVE_2025_32023: return createCVE_2025_32023();
			case CASAPackage.CVE_2025_62506: return createCVE_2025_62506();
			case CASAPackage.CVE_2025_62507: return createCVE_2025_62507();
			case CASAPackage.CVE_2025_66199: return createCVE_2025_66199();
			case CASAPackage.CVE_2025_69418: return createCVE_2025_69418();
			case CASAPackage.CVE_2025_69420: return createCVE_2025_69420();
			case CASAPackage.CVE_2025_69421: return createCVE_2025_69421();
			case CASAPackage.CVE_2026_22795: return createCVE_2026_22795();
			case CASAPackage.CVE_2026_22796: return createCVE_2026_22796();
			case CASAPackage.CVE_2026_27970: return createCVE_2026_27970();
			case CASAPackage.PCOMMENTS: return createPComments();
			case CASAPackage.PVIDEO_SHARING: return createPVideoSharing();
			case CASAPackage.VULNERABILITY: return createVulnerability();
			case CASAPackage.CVSS_VECTOR: return createCVSSVector();
			case CASAPackage.RISK: return createRisk();
			case CASAPackage.SYSTEM: return createSystem();
			case CASAPackage.REDIS_COMPONENT: return createRedisComponent();
			case CASAPackage.FILESYSTEM_COMPONENT: return createFilesystemComponent();
			case CASAPackage.POSTGRESQL: return createPostgresql();
			default:
				throw new IllegalArgumentException("The class '" + eClass.getName() + "' is not a valid classifier");
		}
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Consent createConsent() {
		ConsentImpl consent = new ConsentImpl();
		return consent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DataSubject createDataSubject() {
		DataSubjectImpl dataSubject = new DataSubjectImpl();
		return dataSubject;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public User createUser() {
		UserImpl user = new UserImpl();
		return user;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Administrator createAdministrator() {
		AdministratorImpl administrator = new AdministratorImpl();
		return administrator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Moderator createModerator() {
		ModeratorImpl moderator = new ModeratorImpl();
		return moderator;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PersonalData createPersonalData() {
		PersonalDataImpl personalData = new PersonalDataImpl();
		return personalData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Username createUsername() {
		UsernameImpl username = new UsernameImpl();
		return username;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Password createPassword() {
		PasswordImpl password = new PasswordImpl();
		return password;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public EmailAddress createEmailAddress() {
		EmailAddressImpl emailAddress = new EmailAddressImpl();
		return emailAddress;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Payment createPayment() {
		PaymentImpl payment = new PaymentImpl();
		return payment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StreamingHistory createStreamingHistory() {
		StreamingHistoryImpl streamingHistory = new StreamingHistoryImpl();
		return streamingHistory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public TrackingCookie createTrackingCookie() {
		TrackingCookieImpl trackingCookie = new TrackingCookieImpl();
		return trackingCookie;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VideoContent createVideoContent() {
		VideoContentImpl videoContent = new VideoContentImpl();
		return videoContent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VideoComment createVideoComment() {
		VideoCommentImpl videoComment = new VideoCommentImpl();
		return videoComment;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public VideoMetadata createVideoMetadata() {
		VideoMetadataImpl videoMetadata = new VideoMetadataImpl();
		return videoMetadata;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceType createDeviceType() {
		DeviceTypeImpl deviceType = new DeviceTypeImpl();
		return deviceType;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public DeviceLocation createDeviceLocation() {
		DeviceLocationImpl deviceLocation = new DeviceLocationImpl();
		return deviceLocation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RequestTimestamps createRequestTimestamps() {
		RequestTimestampsImpl requestTimestamps = new RequestTimestampsImpl();
		return requestTimestamps;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public NonPersonalData createNonPersonalData() {
		NonPersonalDataImpl nonPersonalData = new NonPersonalDataImpl();
		return nonPersonalData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Component createComponent() {
		ComponentImpl component = new ComponentImpl();
		return component;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public AngularSPA createAngularSPA() {
		AngularSPAImpl angularSPA = new AngularSPAImpl();
		return angularSPA;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Nginx createNginx() {
		NginxImpl nginx = new NginxImpl();
		return nginx;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ExpressJS createExpressJS() {
		ExpressJSImpl expressJS = new ExpressJSImpl();
		return expressJS;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Function createFunction() {
		FunctionImpl function = new FunctionImpl();
		return function;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FuncPersData createFuncPersData() {
		FuncPersDataImpl funcPersData = new FuncPersDataImpl();
		return funcPersData;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServeStandardAds createServeStandardAds() {
		ServeStandardAdsImpl serveStandardAds = new ServeStandardAdsImpl();
		return serveStandardAds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public UploadVideo createUploadVideo() {
		UploadVideoImpl uploadVideo = new UploadVideoImpl();
		return uploadVideo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public StreamVideo createStreamVideo() {
		StreamVideoImpl streamVideo = new StreamVideoImpl();
		return streamVideo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RemoveVideo createRemoveVideo() {
		RemoveVideoImpl removeVideo = new RemoveVideoImpl();
		return removeVideo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public LiveStreamVideo createLiveStreamVideo() {
		LiveStreamVideoImpl liveStreamVideo = new LiveStreamVideoImpl();
		return liveStreamVideo;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public P2PStreaming createP2PStreaming() {
		P2PStreamingImpl p2PStreaming = new P2PStreamingImpl();
		return p2PStreaming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RecommendVideos createRecommendVideos() {
		RecommendVideosImpl recommendVideos = new RecommendVideosImpl();
		return recommendVideos;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServeBehaviorTargetedAds createServeBehaviorTargetedAds() {
		ServeBehaviorTargetedAdsImpl serveBehaviorTargetedAds = new ServeBehaviorTargetedAdsImpl();
		return serveBehaviorTargetedAds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CommentWriteRead createCommentWriteRead() {
		CommentWriteReadImpl commentWriteRead = new CommentWriteReadImpl();
		return commentWriteRead;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ServeLocationTargetedAds createServeLocationTargetedAds() {
		ServeLocationTargetedAdsImpl serveLocationTargetedAds = new ServeLocationTargetedAdsImpl();
		return serveLocationTargetedAds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PurposeNoConsent createPurposeNoConsent() {
		PurposeNoConsentImpl purposeNoConsent = new PurposeNoConsentImpl();
		return purposeNoConsent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PurposeConsent createPurposeConsent() {
		PurposeConsentImpl purposeConsent = new PurposeConsentImpl();
		return purposeConsent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PMarketing createPMarketing() {
		PMarketingImpl pMarketing = new PMarketingImpl();
		return pMarketing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PStandardAds createPStandardAds() {
		PStandardAdsImpl pStandardAds = new PStandardAdsImpl();
		return pStandardAds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PTargetedAds createPTargetedAds() {
		PTargetedAdsImpl pTargetedAds = new PTargetedAdsImpl();
		return pTargetedAds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PLocationTargetedAds createPLocationTargetedAds() {
		PLocationTargetedAdsImpl pLocationTargetedAds = new PLocationTargetedAdsImpl();
		return pLocationTargetedAds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PBehaviorTargetedAds createPBehaviorTargetedAds() {
		PBehaviorTargetedAdsImpl pBehaviorTargetedAds = new PBehaviorTargetedAdsImpl();
		return pBehaviorTargetedAds;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PProfiling createPProfiling() {
		PProfilingImpl pProfiling = new PProfilingImpl();
		return pProfiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PFirstPartyProfiling createPFirstPartyProfiling() {
		PFirstPartyProfilingImpl pFirstPartyProfiling = new PFirstPartyProfilingImpl();
		return pFirstPartyProfiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PThirdPartyProfiling createPThirdPartyProfiling() {
		PThirdPartyProfilingImpl pThirdPartyProfiling = new PThirdPartyProfilingImpl();
		return pThirdPartyProfiling;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PUserExperience createPUserExperience() {
		PUserExperienceImpl pUserExperience = new PUserExperienceImpl();
		return pUserExperience;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PVideoRecommendation createPVideoRecommendation() {
		PVideoRecommendationImpl pVideoRecommendation = new PVideoRecommendationImpl();
		return pVideoRecommendation;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PP2PStreaming createPP2PStreaming() {
		PP2PStreamingImpl pp2PStreaming = new PP2PStreamingImpl();
		return pp2PStreaming;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PSocial createPSocial() {
		PSocialImpl pSocial = new PSocialImpl();
		return pSocial;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2018_16843 createCVE_2018_16843() {
		CVE_2018_16843Impl cvE_2018_16843 = new CVE_2018_16843Impl();
		return cvE_2018_16843;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2018_16844 createCVE_2018_16844() {
		CVE_2018_16844Impl cvE_2018_16844 = new CVE_2018_16844Impl();
		return cvE_2018_16844;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2018_16845 createCVE_2018_16845() {
		CVE_2018_16845Impl cvE_2018_16845 = new CVE_2018_16845Impl();
		return cvE_2018_16845;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2019_9511 createCVE_2019_9511() {
		CVE_2019_9511Impl cvE_2019_9511 = new CVE_2019_9511Impl();
		return cvE_2019_9511;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2019_9513 createCVE_2019_9513() {
		CVE_2019_9513Impl cvE_2019_9513 = new CVE_2019_9513Impl();
		return cvE_2019_9513;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2019_9516 createCVE_2019_9516() {
		CVE_2019_9516Impl cvE_2019_9516 = new CVE_2019_9516Impl();
		return cvE_2019_9516;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2021_23017 createCVE_2021_23017() {
		CVE_2021_23017Impl cvE_2021_23017 = new CVE_2021_23017Impl();
		return cvE_2021_23017;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2021_3618 createCVE_2021_3618() {
		CVE_2021_3618Impl cvE_2021_3618 = new CVE_2021_3618Impl();
		return cvE_2021_3618;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2022_24834 createCVE_2022_24834() {
		CVE_2022_24834Impl cvE_2022_24834 = new CVE_2022_24834Impl();
		return cvE_2022_24834;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2022_36021 createCVE_2022_36021() {
		CVE_2022_36021Impl cvE_2022_36021 = new CVE_2022_36021Impl();
		return cvE_2022_36021;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2022_41862 createCVE_2022_41862() {
		CVE_2022_41862Impl cvE_2022_41862 = new CVE_2022_41862Impl();
		return cvE_2022_41862;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2023_2455 createCVE_2023_2455() {
		CVE_2023_2455Impl cvE_2023_2455 = new CVE_2023_2455Impl();
		return cvE_2023_2455;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2023_25155 createCVE_2023_25155() {
		CVE_2023_25155Impl cvE_2023_25155 = new CVE_2023_25155Impl();
		return cvE_2023_25155;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2023_28856 createCVE_2023_28856() {
		CVE_2023_28856Impl cvE_2023_28856 = new CVE_2023_28856Impl();
		return cvE_2023_28856;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2023_44487 createCVE_2023_44487() {
		CVE_2023_44487Impl cvE_2023_44487 = new CVE_2023_44487Impl();
		return cvE_2023_44487;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2023_45145 createCVE_2023_45145() {
		CVE_2023_45145Impl cvE_2023_45145 = new CVE_2023_45145Impl();
		return cvE_2023_45145;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2023_46809 createCVE_2023_46809() {
		CVE_2023_46809Impl cvE_2023_46809 = new CVE_2023_46809Impl();
		return cvE_2023_46809;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2023_5870 createCVE_2023_5870() {
		CVE_2023_5870Impl cvE_2023_5870 = new CVE_2023_5870Impl();
		return cvE_2023_5870;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_0985 createCVE_2024_0985() {
		CVE_2024_0985Impl cvE_2024_0985 = new CVE_2024_0985Impl();
		return cvE_2024_0985;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_10976 createCVE_2024_10976() {
		CVE_2024_10976Impl cvE_2024_10976 = new CVE_2024_10976Impl();
		return cvE_2024_10976;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_10977 createCVE_2024_10977() {
		CVE_2024_10977Impl cvE_2024_10977 = new CVE_2024_10977Impl();
		return cvE_2024_10977;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_10978 createCVE_2024_10978() {
		CVE_2024_10978Impl cvE_2024_10978 = new CVE_2024_10978Impl();
		return cvE_2024_10978;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_10979 createCVE_2024_10979() {
		CVE_2024_10979Impl cvE_2024_10979 = new CVE_2024_10979Impl();
		return cvE_2024_10979;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_21890 createCVE_2024_21890() {
		CVE_2024_21890Impl cvE_2024_21890 = new CVE_2024_21890Impl();
		return cvE_2024_21890;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_21891 createCVE_2024_21891() {
		CVE_2024_21891Impl cvE_2024_21891 = new CVE_2024_21891Impl();
		return cvE_2024_21891;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_21896 createCVE_2024_21896() {
		CVE_2024_21896Impl cvE_2024_21896 = new CVE_2024_21896Impl();
		return cvE_2024_21896;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_22017 createCVE_2024_22017() {
		CVE_2024_22017Impl cvE_2024_22017 = new CVE_2024_22017Impl();
		return cvE_2024_22017;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_22018 createCVE_2024_22018() {
		CVE_2024_22018Impl cvE_2024_22018 = new CVE_2024_22018Impl();
		return cvE_2024_22018;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_22019 createCVE_2024_22019() {
		CVE_2024_22019Impl cvE_2024_22019 = new CVE_2024_22019Impl();
		return cvE_2024_22019;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_22020 createCVE_2024_22020() {
		CVE_2024_22020Impl cvE_2024_22020 = new CVE_2024_22020Impl();
		return cvE_2024_22020;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_22025 createCVE_2024_22025() {
		CVE_2024_22025Impl cvE_2024_22025 = new CVE_2024_22025Impl();
		return cvE_2024_22025;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_27980 createCVE_2024_27980() {
		CVE_2024_27980Impl cvE_2024_27980 = new CVE_2024_27980Impl();
		return cvE_2024_27980;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_27983 createCVE_2024_27983() {
		CVE_2024_27983Impl cvE_2024_27983 = new CVE_2024_27983Impl();
		return cvE_2024_27983;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_31449 createCVE_2024_31449() {
		CVE_2024_31449Impl cvE_2024_31449 = new CVE_2024_31449Impl();
		return cvE_2024_31449;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_31489 createCVE_2024_31489() {
		CVE_2024_31489Impl cvE_2024_31489 = new CVE_2024_31489Impl();
		return cvE_2024_31489;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_3566 createCVE_2024_3566() {
		CVE_2024_3566Impl cvE_2024_3566 = new CVE_2024_3566Impl();
		return cvE_2024_3566;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_36137 createCVE_2024_36137() {
		CVE_2024_36137Impl cvE_2024_36137 = new CVE_2024_36137Impl();
		return cvE_2024_36137;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_36138 createCVE_2024_36138() {
		CVE_2024_36138Impl cvE_2024_36138 = new CVE_2024_36138Impl();
		return cvE_2024_36138;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_37372 createCVE_2024_37372() {
		CVE_2024_37372Impl cvE_2024_37372 = new CVE_2024_37372Impl();
		return cvE_2024_37372;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_46981 createCVE_2024_46981() {
		CVE_2024_46981Impl cvE_2024_46981 = new CVE_2024_46981Impl();
		return cvE_2024_46981;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_5205 createCVE_2024_5205() {
		CVE_2024_5205Impl cvE_2024_5205 = new CVE_2024_5205Impl();
		return cvE_2024_5205;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_7347 createCVE_2024_7347() {
		CVE_2024_7347Impl cvE_2024_7347 = new CVE_2024_7347Impl();
		return cvE_2024_7347;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2024_7348 createCVE_2024_7348() {
		CVE_2024_7348Impl cvE_2024_7348 = new CVE_2024_7348Impl();
		return cvE_2024_7348;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_1094 createCVE_2025_1094() {
		CVE_2025_1094Impl cvE_2025_1094 = new CVE_2025_1094Impl();
		return cvE_2025_1094;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_11187 createCVE_2025_11187() {
		CVE_2025_11187Impl cvE_2025_11187 = new CVE_2025_11187Impl();
		return cvE_2025_11187;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_15468 createCVE_2025_15468() {
		CVE_2025_15468Impl cvE_2025_15468 = new CVE_2025_15468Impl();
		return cvE_2025_15468;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_21605 createCVE_2025_21605() {
		CVE_2025_21605Impl cvE_2025_21605 = new CVE_2025_21605Impl();
		return cvE_2025_21605;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_23084 createCVE_2025_23084() {
		CVE_2025_23084Impl cvE_2025_23084 = new CVE_2025_23084Impl();
		return cvE_2025_23084;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_23090 createCVE_2025_23090() {
		CVE_2025_23090Impl cvE_2025_23090 = new CVE_2025_23090Impl();
		return cvE_2025_23090;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_32023 createCVE_2025_32023() {
		CVE_2025_32023Impl cvE_2025_32023 = new CVE_2025_32023Impl();
		return cvE_2025_32023;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_62506 createCVE_2025_62506() {
		CVE_2025_62506Impl cvE_2025_62506 = new CVE_2025_62506Impl();
		return cvE_2025_62506;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_62507 createCVE_2025_62507() {
		CVE_2025_62507Impl cvE_2025_62507 = new CVE_2025_62507Impl();
		return cvE_2025_62507;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_66199 createCVE_2025_66199() {
		CVE_2025_66199Impl cvE_2025_66199 = new CVE_2025_66199Impl();
		return cvE_2025_66199;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_69418 createCVE_2025_69418() {
		CVE_2025_69418Impl cvE_2025_69418 = new CVE_2025_69418Impl();
		return cvE_2025_69418;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_69420 createCVE_2025_69420() {
		CVE_2025_69420Impl cvE_2025_69420 = new CVE_2025_69420Impl();
		return cvE_2025_69420;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2025_69421 createCVE_2025_69421() {
		CVE_2025_69421Impl cvE_2025_69421 = new CVE_2025_69421Impl();
		return cvE_2025_69421;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2026_22795 createCVE_2026_22795() {
		CVE_2026_22795Impl cvE_2026_22795 = new CVE_2026_22795Impl();
		return cvE_2026_22795;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2026_22796 createCVE_2026_22796() {
		CVE_2026_22796Impl cvE_2026_22796 = new CVE_2026_22796Impl();
		return cvE_2026_22796;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVE_2026_27970 createCVE_2026_27970() {
		CVE_2026_27970Impl cvE_2026_27970 = new CVE_2026_27970Impl();
		return cvE_2026_27970;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PComments createPComments() {
		PCommentsImpl pComments = new PCommentsImpl();
		return pComments;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public PVideoSharing createPVideoSharing() {
		PVideoSharingImpl pVideoSharing = new PVideoSharingImpl();
		return pVideoSharing;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Vulnerability createVulnerability() {
		VulnerabilityImpl vulnerability = new VulnerabilityImpl();
		return vulnerability;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CVSSVector createCVSSVector() {
		CVSSVectorImpl cvssVector = new CVSSVectorImpl();
		return cvssVector;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Risk createRisk() {
		RiskImpl risk = new RiskImpl();
		return risk;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CASA.System createSystem() {
		SystemImpl system = new SystemImpl();
		return system;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public RedisComponent createRedisComponent() {
		RedisComponentImpl redisComponent = new RedisComponentImpl();
		return redisComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public FilesystemComponent createFilesystemComponent() {
		FilesystemComponentImpl filesystemComponent = new FilesystemComponentImpl();
		return filesystemComponent;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public Postgresql createPostgresql() {
		PostgresqlImpl postgresql = new PostgresqlImpl();
		return postgresql;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CASAPackage getCASAPackage() {
		return (CASAPackage)getEPackage();
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @deprecated
	 * @generated
	 */
	@Deprecated
	public static CASAPackage getPackage() {
		return CASAPackage.eINSTANCE;
	}

} //CASAFactoryImpl
