/**
 */
package CASA.util;

import CASA.Administrator;
import CASA.AngularSPA;
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

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;

import org.eclipse.emf.ecore.util.Switch;

/**
 * <!-- begin-user-doc -->
 * The <b>Switch</b> for the model's inheritance hierarchy.
 * It supports the call {@link #doSwitch(EObject) doSwitch(object)}
 * to invoke the <code>caseXXX</code> method for each class of the model,
 * starting with the actual class of the object
 * and proceeding up the inheritance hierarchy
 * until a non-null result is returned,
 * which is the result of the switch.
 * <!-- end-user-doc -->
 * @see CASA.CASAPackage
 * @generated
 */
public class CASASwitch<T> extends Switch<T> {
	/**
	 * The cached model package
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected static CASAPackage modelPackage;

	/**
	 * Creates an instance of the switch.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public CASASwitch() {
		if (modelPackage == null) {
			modelPackage = CASAPackage.eINSTANCE;
		}
	}

	/**
	 * Checks whether this is a switch for the given package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param ePackage the package in question.
	 * @return whether this is a switch for the given package.
	 * @generated
	 */
	@Override
	protected boolean isSwitchFor(EPackage ePackage) {
		return ePackage == modelPackage;
	}

	/**
	 * Calls <code>caseXXX</code> for each class of the model until one returns a non null result; it yields that result.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the first non-null result returned by a <code>caseXXX</code> call.
	 * @generated
	 */
	@Override
	protected T doSwitch(int classifierID, EObject theEObject) {
		switch (classifierID) {
			case CASAPackage.CONSENT: {
				Consent consent = (Consent)theEObject;
				T result = caseConsent(consent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.DATA_SUBJECT: {
				DataSubject dataSubject = (DataSubject)theEObject;
				T result = caseDataSubject(dataSubject);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.USER: {
				User user = (User)theEObject;
				T result = caseUser(user);
				if (result == null) result = caseDataSubject(user);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.ADMINISTRATOR: {
				Administrator administrator = (Administrator)theEObject;
				T result = caseAdministrator(administrator);
				if (result == null) result = caseDataSubject(administrator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.MODERATOR: {
				Moderator moderator = (Moderator)theEObject;
				T result = caseModerator(moderator);
				if (result == null) result = caseDataSubject(moderator);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PERSONAL_DATA: {
				PersonalData personalData = (PersonalData)theEObject;
				T result = casePersonalData(personalData);
				if (result == null) result = caseData(personalData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.USERNAME: {
				Username username = (Username)theEObject;
				T result = caseUsername(username);
				if (result == null) result = casePersonalData(username);
				if (result == null) result = caseData(username);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PASSWORD: {
				Password password = (Password)theEObject;
				T result = casePassword(password);
				if (result == null) result = casePersonalData(password);
				if (result == null) result = caseData(password);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.EMAIL_ADDRESS: {
				EmailAddress emailAddress = (EmailAddress)theEObject;
				T result = caseEmailAddress(emailAddress);
				if (result == null) result = casePersonalData(emailAddress);
				if (result == null) result = caseData(emailAddress);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PAYMENT: {
				Payment payment = (Payment)theEObject;
				T result = casePayment(payment);
				if (result == null) result = casePersonalData(payment);
				if (result == null) result = caseData(payment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.STREAMING_HISTORY: {
				StreamingHistory streamingHistory = (StreamingHistory)theEObject;
				T result = caseStreamingHistory(streamingHistory);
				if (result == null) result = casePersonalData(streamingHistory);
				if (result == null) result = caseData(streamingHistory);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.TRACKING_COOKIE: {
				TrackingCookie trackingCookie = (TrackingCookie)theEObject;
				T result = caseTrackingCookie(trackingCookie);
				if (result == null) result = casePersonalData(trackingCookie);
				if (result == null) result = caseData(trackingCookie);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.VIDEO_CONTENT: {
				VideoContent videoContent = (VideoContent)theEObject;
				T result = caseVideoContent(videoContent);
				if (result == null) result = casePersonalData(videoContent);
				if (result == null) result = caseData(videoContent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.VIDEO_COMMENT: {
				VideoComment videoComment = (VideoComment)theEObject;
				T result = caseVideoComment(videoComment);
				if (result == null) result = casePersonalData(videoComment);
				if (result == null) result = caseData(videoComment);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.VIDEO_METADATA: {
				VideoMetadata videoMetadata = (VideoMetadata)theEObject;
				T result = caseVideoMetadata(videoMetadata);
				if (result == null) result = casePersonalData(videoMetadata);
				if (result == null) result = caseData(videoMetadata);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.DEVICE_TYPE: {
				DeviceType deviceType = (DeviceType)theEObject;
				T result = caseDeviceType(deviceType);
				if (result == null) result = casePersonalData(deviceType);
				if (result == null) result = caseData(deviceType);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.DEVICE_LOCATION: {
				DeviceLocation deviceLocation = (DeviceLocation)theEObject;
				T result = caseDeviceLocation(deviceLocation);
				if (result == null) result = casePersonalData(deviceLocation);
				if (result == null) result = caseData(deviceLocation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.REQUEST_TIMESTAMPS: {
				RequestTimestamps requestTimestamps = (RequestTimestamps)theEObject;
				T result = caseRequestTimestamps(requestTimestamps);
				if (result == null) result = casePersonalData(requestTimestamps);
				if (result == null) result = caseData(requestTimestamps);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.DATA: {
				Data data = (Data)theEObject;
				T result = caseData(data);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.NON_PERSONAL_DATA: {
				NonPersonalData nonPersonalData = (NonPersonalData)theEObject;
				T result = caseNonPersonalData(nonPersonalData);
				if (result == null) result = caseData(nonPersonalData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PURPOSE: {
				Purpose purpose = (Purpose)theEObject;
				T result = casePurpose(purpose);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.COMPONENT: {
				Component component = (Component)theEObject;
				T result = caseComponent(component);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.ANGULAR_SPA: {
				AngularSPA angularSPA = (AngularSPA)theEObject;
				T result = caseAngularSPA(angularSPA);
				if (result == null) result = caseComponent(angularSPA);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.NGINX: {
				Nginx nginx = (Nginx)theEObject;
				T result = caseNginx(nginx);
				if (result == null) result = caseComponent(nginx);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.EXPRESS_JS: {
				ExpressJS expressJS = (ExpressJS)theEObject;
				T result = caseExpressJS(expressJS);
				if (result == null) result = caseComponent(expressJS);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.FUNCTION: {
				Function function = (Function)theEObject;
				T result = caseFunction(function);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.FUNC_PERS_DATA: {
				FuncPersData funcPersData = (FuncPersData)theEObject;
				T result = caseFuncPersData(funcPersData);
				if (result == null) result = caseFunction(funcPersData);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.SERVE_STANDARD_ADS: {
				ServeStandardAds serveStandardAds = (ServeStandardAds)theEObject;
				T result = caseServeStandardAds(serveStandardAds);
				if (result == null) result = caseFuncPersData(serveStandardAds);
				if (result == null) result = caseFunction(serveStandardAds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.UPLOAD_VIDEO: {
				UploadVideo uploadVideo = (UploadVideo)theEObject;
				T result = caseUploadVideo(uploadVideo);
				if (result == null) result = caseFuncPersData(uploadVideo);
				if (result == null) result = caseFunction(uploadVideo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.STREAM_VIDEO: {
				StreamVideo streamVideo = (StreamVideo)theEObject;
				T result = caseStreamVideo(streamVideo);
				if (result == null) result = caseFuncPersData(streamVideo);
				if (result == null) result = caseFunction(streamVideo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.REMOVE_VIDEO: {
				RemoveVideo removeVideo = (RemoveVideo)theEObject;
				T result = caseRemoveVideo(removeVideo);
				if (result == null) result = caseFuncPersData(removeVideo);
				if (result == null) result = caseFunction(removeVideo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.LIVE_STREAM_VIDEO: {
				LiveStreamVideo liveStreamVideo = (LiveStreamVideo)theEObject;
				T result = caseLiveStreamVideo(liveStreamVideo);
				if (result == null) result = caseFuncPersData(liveStreamVideo);
				if (result == null) result = caseFunction(liveStreamVideo);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.P2P_STREAMING: {
				P2PStreaming p2PStreaming = (P2PStreaming)theEObject;
				T result = caseP2PStreaming(p2PStreaming);
				if (result == null) result = caseFuncPersData(p2PStreaming);
				if (result == null) result = caseFunction(p2PStreaming);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.RECOMMEND_VIDEOS: {
				RecommendVideos recommendVideos = (RecommendVideos)theEObject;
				T result = caseRecommendVideos(recommendVideos);
				if (result == null) result = caseFuncPersData(recommendVideos);
				if (result == null) result = caseFunction(recommendVideos);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.SERVE_BEHAVIOR_TARGETED_ADS: {
				ServeBehaviorTargetedAds serveBehaviorTargetedAds = (ServeBehaviorTargetedAds)theEObject;
				T result = caseServeBehaviorTargetedAds(serveBehaviorTargetedAds);
				if (result == null) result = caseFuncPersData(serveBehaviorTargetedAds);
				if (result == null) result = caseFunction(serveBehaviorTargetedAds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.COMMENT_WRITE_READ: {
				CommentWriteRead commentWriteRead = (CommentWriteRead)theEObject;
				T result = caseCommentWriteRead(commentWriteRead);
				if (result == null) result = caseFuncPersData(commentWriteRead);
				if (result == null) result = caseFunction(commentWriteRead);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.SERVE_LOCATION_TARGETED_ADS: {
				ServeLocationTargetedAds serveLocationTargetedAds = (ServeLocationTargetedAds)theEObject;
				T result = caseServeLocationTargetedAds(serveLocationTargetedAds);
				if (result == null) result = caseFuncPersData(serveLocationTargetedAds);
				if (result == null) result = caseFunction(serveLocationTargetedAds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PURPOSE_NO_CONSENT: {
				PurposeNoConsent purposeNoConsent = (PurposeNoConsent)theEObject;
				T result = casePurposeNoConsent(purposeNoConsent);
				if (result == null) result = casePurpose(purposeNoConsent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PURPOSE_CONSENT: {
				PurposeConsent purposeConsent = (PurposeConsent)theEObject;
				T result = casePurposeConsent(purposeConsent);
				if (result == null) result = casePurpose(purposeConsent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PMARKETING: {
				PMarketing pMarketing = (PMarketing)theEObject;
				T result = casePMarketing(pMarketing);
				if (result == null) result = casePurposeConsent(pMarketing);
				if (result == null) result = casePurpose(pMarketing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PSTANDARD_ADS: {
				PStandardAds pStandardAds = (PStandardAds)theEObject;
				T result = casePStandardAds(pStandardAds);
				if (result == null) result = casePMarketing(pStandardAds);
				if (result == null) result = casePurposeConsent(pStandardAds);
				if (result == null) result = casePurpose(pStandardAds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PTARGETED_ADS: {
				PTargetedAds pTargetedAds = (PTargetedAds)theEObject;
				T result = casePTargetedAds(pTargetedAds);
				if (result == null) result = casePMarketing(pTargetedAds);
				if (result == null) result = casePurposeConsent(pTargetedAds);
				if (result == null) result = casePurpose(pTargetedAds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PLOCATION_TARGETED_ADS: {
				PLocationTargetedAds pLocationTargetedAds = (PLocationTargetedAds)theEObject;
				T result = casePLocationTargetedAds(pLocationTargetedAds);
				if (result == null) result = casePTargetedAds(pLocationTargetedAds);
				if (result == null) result = casePMarketing(pLocationTargetedAds);
				if (result == null) result = casePurposeConsent(pLocationTargetedAds);
				if (result == null) result = casePurpose(pLocationTargetedAds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PBEHAVIOR_TARGETED_ADS: {
				PBehaviorTargetedAds pBehaviorTargetedAds = (PBehaviorTargetedAds)theEObject;
				T result = casePBehaviorTargetedAds(pBehaviorTargetedAds);
				if (result == null) result = casePTargetedAds(pBehaviorTargetedAds);
				if (result == null) result = casePMarketing(pBehaviorTargetedAds);
				if (result == null) result = casePurposeConsent(pBehaviorTargetedAds);
				if (result == null) result = casePurpose(pBehaviorTargetedAds);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PPROFILING: {
				PProfiling pProfiling = (PProfiling)theEObject;
				T result = casePProfiling(pProfiling);
				if (result == null) result = casePurposeConsent(pProfiling);
				if (result == null) result = casePurpose(pProfiling);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PFIRST_PARTY_PROFILING: {
				PFirstPartyProfiling pFirstPartyProfiling = (PFirstPartyProfiling)theEObject;
				T result = casePFirstPartyProfiling(pFirstPartyProfiling);
				if (result == null) result = casePProfiling(pFirstPartyProfiling);
				if (result == null) result = casePurposeConsent(pFirstPartyProfiling);
				if (result == null) result = casePurpose(pFirstPartyProfiling);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PTHIRD_PARTY_PROFILING: {
				PThirdPartyProfiling pThirdPartyProfiling = (PThirdPartyProfiling)theEObject;
				T result = casePThirdPartyProfiling(pThirdPartyProfiling);
				if (result == null) result = casePFirstPartyProfiling(pThirdPartyProfiling);
				if (result == null) result = casePProfiling(pThirdPartyProfiling);
				if (result == null) result = casePurposeConsent(pThirdPartyProfiling);
				if (result == null) result = casePurpose(pThirdPartyProfiling);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PUSER_EXPERIENCE: {
				PUserExperience pUserExperience = (PUserExperience)theEObject;
				T result = casePUserExperience(pUserExperience);
				if (result == null) result = casePurposeConsent(pUserExperience);
				if (result == null) result = casePurpose(pUserExperience);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PVIDEO_RECOMMENDATION: {
				PVideoRecommendation pVideoRecommendation = (PVideoRecommendation)theEObject;
				T result = casePVideoRecommendation(pVideoRecommendation);
				if (result == null) result = casePUserExperience(pVideoRecommendation);
				if (result == null) result = casePurposeConsent(pVideoRecommendation);
				if (result == null) result = casePurpose(pVideoRecommendation);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PP2P_STREAMING: {
				PP2PStreaming pp2PStreaming = (PP2PStreaming)theEObject;
				T result = casePP2PStreaming(pp2PStreaming);
				if (result == null) result = casePUserExperience(pp2PStreaming);
				if (result == null) result = casePurposeConsent(pp2PStreaming);
				if (result == null) result = casePurpose(pp2PStreaming);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PSOCIAL: {
				PSocial pSocial = (PSocial)theEObject;
				T result = casePSocial(pSocial);
				if (result == null) result = casePurposeConsent(pSocial);
				if (result == null) result = casePurpose(pSocial);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2018_16843: {
				CVE_2018_16843 cvE_2018_16843 = (CVE_2018_16843)theEObject;
				T result = caseCVE_2018_16843(cvE_2018_16843);
				if (result == null) result = caseVulnerability(cvE_2018_16843);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2018_16844: {
				CVE_2018_16844 cvE_2018_16844 = (CVE_2018_16844)theEObject;
				T result = caseCVE_2018_16844(cvE_2018_16844);
				if (result == null) result = caseVulnerability(cvE_2018_16844);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2018_16845: {
				CVE_2018_16845 cvE_2018_16845 = (CVE_2018_16845)theEObject;
				T result = caseCVE_2018_16845(cvE_2018_16845);
				if (result == null) result = caseVulnerability(cvE_2018_16845);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2019_9511: {
				CVE_2019_9511 cvE_2019_9511 = (CVE_2019_9511)theEObject;
				T result = caseCVE_2019_9511(cvE_2019_9511);
				if (result == null) result = caseVulnerability(cvE_2019_9511);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2019_9513: {
				CVE_2019_9513 cvE_2019_9513 = (CVE_2019_9513)theEObject;
				T result = caseCVE_2019_9513(cvE_2019_9513);
				if (result == null) result = caseVulnerability(cvE_2019_9513);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2019_9516: {
				CVE_2019_9516 cvE_2019_9516 = (CVE_2019_9516)theEObject;
				T result = caseCVE_2019_9516(cvE_2019_9516);
				if (result == null) result = caseVulnerability(cvE_2019_9516);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2021_23017: {
				CVE_2021_23017 cvE_2021_23017 = (CVE_2021_23017)theEObject;
				T result = caseCVE_2021_23017(cvE_2021_23017);
				if (result == null) result = caseVulnerability(cvE_2021_23017);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2021_3618: {
				CVE_2021_3618 cvE_2021_3618 = (CVE_2021_3618)theEObject;
				T result = caseCVE_2021_3618(cvE_2021_3618);
				if (result == null) result = caseVulnerability(cvE_2021_3618);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2022_24834: {
				CVE_2022_24834 cvE_2022_24834 = (CVE_2022_24834)theEObject;
				T result = caseCVE_2022_24834(cvE_2022_24834);
				if (result == null) result = caseVulnerability(cvE_2022_24834);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2022_36021: {
				CVE_2022_36021 cvE_2022_36021 = (CVE_2022_36021)theEObject;
				T result = caseCVE_2022_36021(cvE_2022_36021);
				if (result == null) result = caseVulnerability(cvE_2022_36021);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2022_41862: {
				CVE_2022_41862 cvE_2022_41862 = (CVE_2022_41862)theEObject;
				T result = caseCVE_2022_41862(cvE_2022_41862);
				if (result == null) result = caseVulnerability(cvE_2022_41862);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2023_2455: {
				CVE_2023_2455 cvE_2023_2455 = (CVE_2023_2455)theEObject;
				T result = caseCVE_2023_2455(cvE_2023_2455);
				if (result == null) result = caseVulnerability(cvE_2023_2455);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2023_25155: {
				CVE_2023_25155 cvE_2023_25155 = (CVE_2023_25155)theEObject;
				T result = caseCVE_2023_25155(cvE_2023_25155);
				if (result == null) result = caseVulnerability(cvE_2023_25155);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2023_28856: {
				CVE_2023_28856 cvE_2023_28856 = (CVE_2023_28856)theEObject;
				T result = caseCVE_2023_28856(cvE_2023_28856);
				if (result == null) result = caseVulnerability(cvE_2023_28856);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2023_44487: {
				CVE_2023_44487 cvE_2023_44487 = (CVE_2023_44487)theEObject;
				T result = caseCVE_2023_44487(cvE_2023_44487);
				if (result == null) result = caseVulnerability(cvE_2023_44487);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2023_45145: {
				CVE_2023_45145 cvE_2023_45145 = (CVE_2023_45145)theEObject;
				T result = caseCVE_2023_45145(cvE_2023_45145);
				if (result == null) result = caseVulnerability(cvE_2023_45145);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2023_46809: {
				CVE_2023_46809 cvE_2023_46809 = (CVE_2023_46809)theEObject;
				T result = caseCVE_2023_46809(cvE_2023_46809);
				if (result == null) result = caseVulnerability(cvE_2023_46809);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2023_5870: {
				CVE_2023_5870 cvE_2023_5870 = (CVE_2023_5870)theEObject;
				T result = caseCVE_2023_5870(cvE_2023_5870);
				if (result == null) result = caseVulnerability(cvE_2023_5870);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_0985: {
				CVE_2024_0985 cvE_2024_0985 = (CVE_2024_0985)theEObject;
				T result = caseCVE_2024_0985(cvE_2024_0985);
				if (result == null) result = caseVulnerability(cvE_2024_0985);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_10976: {
				CVE_2024_10976 cvE_2024_10976 = (CVE_2024_10976)theEObject;
				T result = caseCVE_2024_10976(cvE_2024_10976);
				if (result == null) result = caseVulnerability(cvE_2024_10976);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_10977: {
				CVE_2024_10977 cvE_2024_10977 = (CVE_2024_10977)theEObject;
				T result = caseCVE_2024_10977(cvE_2024_10977);
				if (result == null) result = caseVulnerability(cvE_2024_10977);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_10978: {
				CVE_2024_10978 cvE_2024_10978 = (CVE_2024_10978)theEObject;
				T result = caseCVE_2024_10978(cvE_2024_10978);
				if (result == null) result = caseVulnerability(cvE_2024_10978);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_10979: {
				CVE_2024_10979 cvE_2024_10979 = (CVE_2024_10979)theEObject;
				T result = caseCVE_2024_10979(cvE_2024_10979);
				if (result == null) result = caseVulnerability(cvE_2024_10979);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_21890: {
				CVE_2024_21890 cvE_2024_21890 = (CVE_2024_21890)theEObject;
				T result = caseCVE_2024_21890(cvE_2024_21890);
				if (result == null) result = caseVulnerability(cvE_2024_21890);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_21891: {
				CVE_2024_21891 cvE_2024_21891 = (CVE_2024_21891)theEObject;
				T result = caseCVE_2024_21891(cvE_2024_21891);
				if (result == null) result = caseVulnerability(cvE_2024_21891);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_21896: {
				CVE_2024_21896 cvE_2024_21896 = (CVE_2024_21896)theEObject;
				T result = caseCVE_2024_21896(cvE_2024_21896);
				if (result == null) result = caseVulnerability(cvE_2024_21896);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_22017: {
				CVE_2024_22017 cvE_2024_22017 = (CVE_2024_22017)theEObject;
				T result = caseCVE_2024_22017(cvE_2024_22017);
				if (result == null) result = caseVulnerability(cvE_2024_22017);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_22018: {
				CVE_2024_22018 cvE_2024_22018 = (CVE_2024_22018)theEObject;
				T result = caseCVE_2024_22018(cvE_2024_22018);
				if (result == null) result = caseVulnerability(cvE_2024_22018);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_22019: {
				CVE_2024_22019 cvE_2024_22019 = (CVE_2024_22019)theEObject;
				T result = caseCVE_2024_22019(cvE_2024_22019);
				if (result == null) result = caseVulnerability(cvE_2024_22019);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_22020: {
				CVE_2024_22020 cvE_2024_22020 = (CVE_2024_22020)theEObject;
				T result = caseCVE_2024_22020(cvE_2024_22020);
				if (result == null) result = caseVulnerability(cvE_2024_22020);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_22025: {
				CVE_2024_22025 cvE_2024_22025 = (CVE_2024_22025)theEObject;
				T result = caseCVE_2024_22025(cvE_2024_22025);
				if (result == null) result = caseVulnerability(cvE_2024_22025);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_27980: {
				CVE_2024_27980 cvE_2024_27980 = (CVE_2024_27980)theEObject;
				T result = caseCVE_2024_27980(cvE_2024_27980);
				if (result == null) result = caseVulnerability(cvE_2024_27980);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_27983: {
				CVE_2024_27983 cvE_2024_27983 = (CVE_2024_27983)theEObject;
				T result = caseCVE_2024_27983(cvE_2024_27983);
				if (result == null) result = caseVulnerability(cvE_2024_27983);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_31449: {
				CVE_2024_31449 cvE_2024_31449 = (CVE_2024_31449)theEObject;
				T result = caseCVE_2024_31449(cvE_2024_31449);
				if (result == null) result = caseVulnerability(cvE_2024_31449);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_31489: {
				CVE_2024_31489 cvE_2024_31489 = (CVE_2024_31489)theEObject;
				T result = caseCVE_2024_31489(cvE_2024_31489);
				if (result == null) result = caseVulnerability(cvE_2024_31489);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_3566: {
				CVE_2024_3566 cvE_2024_3566 = (CVE_2024_3566)theEObject;
				T result = caseCVE_2024_3566(cvE_2024_3566);
				if (result == null) result = caseVulnerability(cvE_2024_3566);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_36137: {
				CVE_2024_36137 cvE_2024_36137 = (CVE_2024_36137)theEObject;
				T result = caseCVE_2024_36137(cvE_2024_36137);
				if (result == null) result = caseVulnerability(cvE_2024_36137);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_36138: {
				CVE_2024_36138 cvE_2024_36138 = (CVE_2024_36138)theEObject;
				T result = caseCVE_2024_36138(cvE_2024_36138);
				if (result == null) result = caseVulnerability(cvE_2024_36138);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_37372: {
				CVE_2024_37372 cvE_2024_37372 = (CVE_2024_37372)theEObject;
				T result = caseCVE_2024_37372(cvE_2024_37372);
				if (result == null) result = caseVulnerability(cvE_2024_37372);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_46981: {
				CVE_2024_46981 cvE_2024_46981 = (CVE_2024_46981)theEObject;
				T result = caseCVE_2024_46981(cvE_2024_46981);
				if (result == null) result = caseVulnerability(cvE_2024_46981);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_5205: {
				CVE_2024_5205 cvE_2024_5205 = (CVE_2024_5205)theEObject;
				T result = caseCVE_2024_5205(cvE_2024_5205);
				if (result == null) result = caseVulnerability(cvE_2024_5205);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_7347: {
				CVE_2024_7347 cvE_2024_7347 = (CVE_2024_7347)theEObject;
				T result = caseCVE_2024_7347(cvE_2024_7347);
				if (result == null) result = caseVulnerability(cvE_2024_7347);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2024_7348: {
				CVE_2024_7348 cvE_2024_7348 = (CVE_2024_7348)theEObject;
				T result = caseCVE_2024_7348(cvE_2024_7348);
				if (result == null) result = caseVulnerability(cvE_2024_7348);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_1094: {
				CVE_2025_1094 cvE_2025_1094 = (CVE_2025_1094)theEObject;
				T result = caseCVE_2025_1094(cvE_2025_1094);
				if (result == null) result = caseVulnerability(cvE_2025_1094);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_11187: {
				CVE_2025_11187 cvE_2025_11187 = (CVE_2025_11187)theEObject;
				T result = caseCVE_2025_11187(cvE_2025_11187);
				if (result == null) result = caseVulnerability(cvE_2025_11187);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_15468: {
				CVE_2025_15468 cvE_2025_15468 = (CVE_2025_15468)theEObject;
				T result = caseCVE_2025_15468(cvE_2025_15468);
				if (result == null) result = caseVulnerability(cvE_2025_15468);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_21605: {
				CVE_2025_21605 cvE_2025_21605 = (CVE_2025_21605)theEObject;
				T result = caseCVE_2025_21605(cvE_2025_21605);
				if (result == null) result = caseVulnerability(cvE_2025_21605);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_23084: {
				CVE_2025_23084 cvE_2025_23084 = (CVE_2025_23084)theEObject;
				T result = caseCVE_2025_23084(cvE_2025_23084);
				if (result == null) result = caseVulnerability(cvE_2025_23084);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_23090: {
				CVE_2025_23090 cvE_2025_23090 = (CVE_2025_23090)theEObject;
				T result = caseCVE_2025_23090(cvE_2025_23090);
				if (result == null) result = caseVulnerability(cvE_2025_23090);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_32023: {
				CVE_2025_32023 cvE_2025_32023 = (CVE_2025_32023)theEObject;
				T result = caseCVE_2025_32023(cvE_2025_32023);
				if (result == null) result = caseVulnerability(cvE_2025_32023);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_62506: {
				CVE_2025_62506 cvE_2025_62506 = (CVE_2025_62506)theEObject;
				T result = caseCVE_2025_62506(cvE_2025_62506);
				if (result == null) result = caseVulnerability(cvE_2025_62506);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_62507: {
				CVE_2025_62507 cvE_2025_62507 = (CVE_2025_62507)theEObject;
				T result = caseCVE_2025_62507(cvE_2025_62507);
				if (result == null) result = caseVulnerability(cvE_2025_62507);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_66199: {
				CVE_2025_66199 cvE_2025_66199 = (CVE_2025_66199)theEObject;
				T result = caseCVE_2025_66199(cvE_2025_66199);
				if (result == null) result = caseVulnerability(cvE_2025_66199);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_69418: {
				CVE_2025_69418 cvE_2025_69418 = (CVE_2025_69418)theEObject;
				T result = caseCVE_2025_69418(cvE_2025_69418);
				if (result == null) result = caseVulnerability(cvE_2025_69418);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_69420: {
				CVE_2025_69420 cvE_2025_69420 = (CVE_2025_69420)theEObject;
				T result = caseCVE_2025_69420(cvE_2025_69420);
				if (result == null) result = caseVulnerability(cvE_2025_69420);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2025_69421: {
				CVE_2025_69421 cvE_2025_69421 = (CVE_2025_69421)theEObject;
				T result = caseCVE_2025_69421(cvE_2025_69421);
				if (result == null) result = caseVulnerability(cvE_2025_69421);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2026_22795: {
				CVE_2026_22795 cvE_2026_22795 = (CVE_2026_22795)theEObject;
				T result = caseCVE_2026_22795(cvE_2026_22795);
				if (result == null) result = caseVulnerability(cvE_2026_22795);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2026_22796: {
				CVE_2026_22796 cvE_2026_22796 = (CVE_2026_22796)theEObject;
				T result = caseCVE_2026_22796(cvE_2026_22796);
				if (result == null) result = caseVulnerability(cvE_2026_22796);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVE_2026_27970: {
				CVE_2026_27970 cvE_2026_27970 = (CVE_2026_27970)theEObject;
				T result = caseCVE_2026_27970(cvE_2026_27970);
				if (result == null) result = caseVulnerability(cvE_2026_27970);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PCOMMENTS: {
				PComments pComments = (PComments)theEObject;
				T result = casePComments(pComments);
				if (result == null) result = casePSocial(pComments);
				if (result == null) result = casePurposeConsent(pComments);
				if (result == null) result = casePurpose(pComments);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.PVIDEO_SHARING: {
				PVideoSharing pVideoSharing = (PVideoSharing)theEObject;
				T result = casePVideoSharing(pVideoSharing);
				if (result == null) result = casePComments(pVideoSharing);
				if (result == null) result = casePSocial(pVideoSharing);
				if (result == null) result = casePurposeConsent(pVideoSharing);
				if (result == null) result = casePurpose(pVideoSharing);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.VULNERABILITY: {
				Vulnerability vulnerability = (Vulnerability)theEObject;
				T result = caseVulnerability(vulnerability);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.CVSS_VECTOR: {
				CVSSVector cvssVector = (CVSSVector)theEObject;
				T result = caseCVSSVector(cvssVector);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.RISK: {
				Risk risk = (Risk)theEObject;
				T result = caseRisk(risk);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.SYSTEM: {
				CASA.System system = (CASA.System)theEObject;
				T result = caseSystem(system);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.REDIS_COMPONENT: {
				RedisComponent redisComponent = (RedisComponent)theEObject;
				T result = caseRedisComponent(redisComponent);
				if (result == null) result = caseComponent(redisComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.FILESYSTEM_COMPONENT: {
				FilesystemComponent filesystemComponent = (FilesystemComponent)theEObject;
				T result = caseFilesystemComponent(filesystemComponent);
				if (result == null) result = caseComponent(filesystemComponent);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			case CASAPackage.POSTGRESQL: {
				Postgresql postgresql = (Postgresql)theEObject;
				T result = casePostgresql(postgresql);
				if (result == null) result = caseComponent(postgresql);
				if (result == null) result = defaultCase(theEObject);
				return result;
			}
			default: return defaultCase(theEObject);
		}
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Consent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Consent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseConsent(Consent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data Subject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data Subject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDataSubject(DataSubject object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>User</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUser(User object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Administrator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Administrator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAdministrator(Administrator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Moderator</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Moderator</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseModerator(Moderator object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Personal Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Personal Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePersonalData(PersonalData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Username</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Username</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUsername(Username object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Password</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Password</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePassword(Password object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Email Address</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Email Address</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseEmailAddress(EmailAddress object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Payment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Payment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePayment(Payment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Streaming History</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Streaming History</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStreamingHistory(StreamingHistory object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Tracking Cookie</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Tracking Cookie</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseTrackingCookie(TrackingCookie object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Video Content</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Video Content</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVideoContent(VideoContent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Video Comment</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Video Comment</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVideoComment(VideoComment object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Video Metadata</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Video Metadata</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVideoMetadata(VideoMetadata object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Type</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceType(DeviceType object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Device Location</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Device Location</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseDeviceLocation(DeviceLocation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Request Timestamps</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Request Timestamps</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRequestTimestamps(RequestTimestamps object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseData(Data object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Non Personal Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Non Personal Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNonPersonalData(NonPersonalData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Purpose</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Purpose</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePurpose(Purpose object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseComponent(Component object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Angular SPA</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Angular SPA</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseAngularSPA(AngularSPA object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Nginx</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Nginx</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseNginx(Nginx object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Express JS</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Express JS</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseExpressJS(ExpressJS object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Function</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFunction(Function object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Func Pers Data</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Func Pers Data</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFuncPersData(FuncPersData object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Serve Standard Ads</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serve Standard Ads</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServeStandardAds(ServeStandardAds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Upload Video</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Upload Video</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseUploadVideo(UploadVideo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Stream Video</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Stream Video</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseStreamVideo(StreamVideo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Remove Video</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Remove Video</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRemoveVideo(RemoveVideo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Live Stream Video</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Live Stream Video</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseLiveStreamVideo(LiveStreamVideo object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>P2P Streaming</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>P2P Streaming</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseP2PStreaming(P2PStreaming object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Recommend Videos</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Recommend Videos</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRecommendVideos(RecommendVideos object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Serve Behavior Targeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serve Behavior Targeted Ads</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServeBehaviorTargetedAds(ServeBehaviorTargetedAds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Comment Write Read</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Comment Write Read</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCommentWriteRead(CommentWriteRead object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Serve Location Targeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Serve Location Targeted Ads</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseServeLocationTargetedAds(ServeLocationTargetedAds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Purpose No Consent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Purpose No Consent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePurposeNoConsent(PurposeNoConsent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Purpose Consent</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Purpose Consent</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePurposeConsent(PurposeConsent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PMarketing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PMarketing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePMarketing(PMarketing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PStandard Ads</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PStandard Ads</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePStandardAds(PStandardAds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PTargeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PTargeted Ads</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePTargetedAds(PTargetedAds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PLocation Targeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PLocation Targeted Ads</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePLocationTargetedAds(PLocationTargetedAds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PBehavior Targeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PBehavior Targeted Ads</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePBehaviorTargetedAds(PBehaviorTargetedAds object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PProfiling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PProfiling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePProfiling(PProfiling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PFirst Party Profiling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PFirst Party Profiling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePFirstPartyProfiling(PFirstPartyProfiling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PThird Party Profiling</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PThird Party Profiling</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePThirdPartyProfiling(PThirdPartyProfiling object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PUser Experience</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PUser Experience</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePUserExperience(PUserExperience object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PVideo Recommendation</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PVideo Recommendation</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePVideoRecommendation(PVideoRecommendation object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PP2P Streaming</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PP2P Streaming</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePP2PStreaming(PP2PStreaming object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PSocial</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PSocial</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePSocial(PSocial object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2018 16843</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2018 16843</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2018_16843(CVE_2018_16843 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2018 16844</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2018 16844</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2018_16844(CVE_2018_16844 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2018 16845</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2018 16845</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2018_16845(CVE_2018_16845 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2019 9511</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2019 9511</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2019_9511(CVE_2019_9511 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2019 9513</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2019 9513</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2019_9513(CVE_2019_9513 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2019 9516</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2019 9516</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2019_9516(CVE_2019_9516 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2021 23017</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2021 23017</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2021_23017(CVE_2021_23017 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2021 3618</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2021 3618</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2021_3618(CVE_2021_3618 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2022 24834</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2022 24834</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2022_24834(CVE_2022_24834 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2022 36021</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2022 36021</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2022_36021(CVE_2022_36021 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2022 41862</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2022 41862</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2022_41862(CVE_2022_41862 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2023 2455</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2023 2455</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2023_2455(CVE_2023_2455 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2023 25155</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2023 25155</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2023_25155(CVE_2023_25155 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2023 28856</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2023 28856</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2023_28856(CVE_2023_28856 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2023 44487</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2023 44487</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2023_44487(CVE_2023_44487 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2023 45145</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2023 45145</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2023_45145(CVE_2023_45145 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2023 46809</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2023 46809</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2023_46809(CVE_2023_46809 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2023 5870</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2023 5870</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2023_5870(CVE_2023_5870 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 0985</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 0985</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_0985(CVE_2024_0985 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 10976</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 10976</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_10976(CVE_2024_10976 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 10977</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 10977</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_10977(CVE_2024_10977 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 10978</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 10978</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_10978(CVE_2024_10978 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 10979</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 10979</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_10979(CVE_2024_10979 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 21890</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 21890</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_21890(CVE_2024_21890 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 21891</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 21891</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_21891(CVE_2024_21891 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 21896</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 21896</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_21896(CVE_2024_21896 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 22017</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 22017</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_22017(CVE_2024_22017 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 22018</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 22018</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_22018(CVE_2024_22018 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 22019</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 22019</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_22019(CVE_2024_22019 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 22020</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 22020</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_22020(CVE_2024_22020 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 22025</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 22025</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_22025(CVE_2024_22025 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 27980</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 27980</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_27980(CVE_2024_27980 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 27983</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 27983</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_27983(CVE_2024_27983 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 31449</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 31449</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_31449(CVE_2024_31449 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 31489</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 31489</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_31489(CVE_2024_31489 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 3566</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 3566</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_3566(CVE_2024_3566 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 36137</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 36137</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_36137(CVE_2024_36137 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 36138</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 36138</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_36138(CVE_2024_36138 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 37372</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 37372</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_37372(CVE_2024_37372 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 46981</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 46981</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_46981(CVE_2024_46981 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 5205</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 5205</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_5205(CVE_2024_5205 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 7347</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 7347</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_7347(CVE_2024_7347 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2024 7348</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2024 7348</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2024_7348(CVE_2024_7348 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 1094</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 1094</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_1094(CVE_2025_1094 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 11187</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 11187</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_11187(CVE_2025_11187 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 15468</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 15468</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_15468(CVE_2025_15468 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 21605</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 21605</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_21605(CVE_2025_21605 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 23084</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 23084</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_23084(CVE_2025_23084 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 23090</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 23090</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_23090(CVE_2025_23090 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 32023</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 32023</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_32023(CVE_2025_32023 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 62506</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 62506</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_62506(CVE_2025_62506 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 62507</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 62507</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_62507(CVE_2025_62507 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 66199</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 66199</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_66199(CVE_2025_66199 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 69418</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 69418</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_69418(CVE_2025_69418 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 69420</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 69420</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_69420(CVE_2025_69420 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2025 69421</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2025 69421</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2025_69421(CVE_2025_69421 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2026 22795</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2026 22795</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2026_22795(CVE_2026_22795 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2026 22796</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2026 22796</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2026_22796(CVE_2026_22796 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVE 2026 27970</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVE 2026 27970</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVE_2026_27970(CVE_2026_27970 object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PComments</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PComments</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePComments(PComments object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>PVideo Sharing</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>PVideo Sharing</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePVideoSharing(PVideoSharing object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Vulnerability</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Vulnerability</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseVulnerability(Vulnerability object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>CVSS Vector</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>CVSS Vector</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseCVSSVector(CVSSVector object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Risk</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Risk</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRisk(Risk object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>System</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseSystem(CASA.System object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Redis Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Redis Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseRedisComponent(RedisComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Filesystem Component</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Filesystem Component</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T caseFilesystemComponent(FilesystemComponent object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>Postgresql</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>Postgresql</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject) doSwitch(EObject)
	 * @generated
	 */
	public T casePostgresql(Postgresql object) {
		return null;
	}

	/**
	 * Returns the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * <!-- begin-user-doc -->
	 * This implementation returns null;
	 * returning a non-null result will terminate the switch, but this is the last case anyway.
	 * <!-- end-user-doc -->
	 * @param object the target of the switch.
	 * @return the result of interpreting the object as an instance of '<em>EObject</em>'.
	 * @see #doSwitch(org.eclipse.emf.ecore.EObject)
	 * @generated
	 */
	@Override
	public T defaultCase(EObject object) {
		return null;
	}

} //CASASwitch
