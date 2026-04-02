/**
 */
package CASA;

import org.eclipse.emf.ecore.EFactory;

/**
 * <!-- begin-user-doc -->
 * The <b>Factory</b> for the model.
 * It provides a create method for each non-abstract class of the model.
 * <!-- end-user-doc -->
 * @see CASA.CASAPackage
 * @generated
 */
public interface CASAFactory extends EFactory {
	/**
	 * The singleton instance of the factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CASAFactory eINSTANCE = CASA.impl.CASAFactoryImpl.init();

	/**
	 * Returns a new object of class '<em>Consent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Consent</em>'.
	 * @generated
	 */
	Consent createConsent();

	/**
	 * Returns a new object of class '<em>Data Subject</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Data Subject</em>'.
	 * @generated
	 */
	DataSubject createDataSubject();

	/**
	 * Returns a new object of class '<em>User</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>User</em>'.
	 * @generated
	 */
	User createUser();

	/**
	 * Returns a new object of class '<em>Administrator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Administrator</em>'.
	 * @generated
	 */
	Administrator createAdministrator();

	/**
	 * Returns a new object of class '<em>Moderator</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Moderator</em>'.
	 * @generated
	 */
	Moderator createModerator();

	/**
	 * Returns a new object of class '<em>Personal Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Personal Data</em>'.
	 * @generated
	 */
	PersonalData createPersonalData();

	/**
	 * Returns a new object of class '<em>Username</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Username</em>'.
	 * @generated
	 */
	Username createUsername();

	/**
	 * Returns a new object of class '<em>Password</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Password</em>'.
	 * @generated
	 */
	Password createPassword();

	/**
	 * Returns a new object of class '<em>Email Address</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Email Address</em>'.
	 * @generated
	 */
	EmailAddress createEmailAddress();

	/**
	 * Returns a new object of class '<em>Payment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Payment</em>'.
	 * @generated
	 */
	Payment createPayment();

	/**
	 * Returns a new object of class '<em>Streaming History</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Streaming History</em>'.
	 * @generated
	 */
	StreamingHistory createStreamingHistory();

	/**
	 * Returns a new object of class '<em>Tracking Cookie</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Tracking Cookie</em>'.
	 * @generated
	 */
	TrackingCookie createTrackingCookie();

	/**
	 * Returns a new object of class '<em>Video Content</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Video Content</em>'.
	 * @generated
	 */
	VideoContent createVideoContent();

	/**
	 * Returns a new object of class '<em>Video Comment</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Video Comment</em>'.
	 * @generated
	 */
	VideoComment createVideoComment();

	/**
	 * Returns a new object of class '<em>Video Metadata</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Video Metadata</em>'.
	 * @generated
	 */
	VideoMetadata createVideoMetadata();

	/**
	 * Returns a new object of class '<em>Device Type</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Type</em>'.
	 * @generated
	 */
	DeviceType createDeviceType();

	/**
	 * Returns a new object of class '<em>Device Location</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Device Location</em>'.
	 * @generated
	 */
	DeviceLocation createDeviceLocation();

	/**
	 * Returns a new object of class '<em>Request Timestamps</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Request Timestamps</em>'.
	 * @generated
	 */
	RequestTimestamps createRequestTimestamps();

	/**
	 * Returns a new object of class '<em>Non Personal Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Non Personal Data</em>'.
	 * @generated
	 */
	NonPersonalData createNonPersonalData();

	/**
	 * Returns a new object of class '<em>Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Component</em>'.
	 * @generated
	 */
	Component createComponent();

	/**
	 * Returns a new object of class '<em>Angular SPA</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Angular SPA</em>'.
	 * @generated
	 */
	AngularSPA createAngularSPA();

	/**
	 * Returns a new object of class '<em>Nginx</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Nginx</em>'.
	 * @generated
	 */
	Nginx createNginx();

	/**
	 * Returns a new object of class '<em>Express JS</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Express JS</em>'.
	 * @generated
	 */
	ExpressJS createExpressJS();

	/**
	 * Returns a new object of class '<em>Function</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Function</em>'.
	 * @generated
	 */
	Function createFunction();

	/**
	 * Returns a new object of class '<em>Func Pers Data</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Func Pers Data</em>'.
	 * @generated
	 */
	FuncPersData createFuncPersData();

	/**
	 * Returns a new object of class '<em>Serve Standard Ads</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Serve Standard Ads</em>'.
	 * @generated
	 */
	ServeStandardAds createServeStandardAds();

	/**
	 * Returns a new object of class '<em>Upload Video</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Upload Video</em>'.
	 * @generated
	 */
	UploadVideo createUploadVideo();

	/**
	 * Returns a new object of class '<em>Stream Video</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Stream Video</em>'.
	 * @generated
	 */
	StreamVideo createStreamVideo();

	/**
	 * Returns a new object of class '<em>Remove Video</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Remove Video</em>'.
	 * @generated
	 */
	RemoveVideo createRemoveVideo();

	/**
	 * Returns a new object of class '<em>Live Stream Video</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Live Stream Video</em>'.
	 * @generated
	 */
	LiveStreamVideo createLiveStreamVideo();

	/**
	 * Returns a new object of class '<em>P2P Streaming</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>P2P Streaming</em>'.
	 * @generated
	 */
	P2PStreaming createP2PStreaming();

	/**
	 * Returns a new object of class '<em>Recommend Videos</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Recommend Videos</em>'.
	 * @generated
	 */
	RecommendVideos createRecommendVideos();

	/**
	 * Returns a new object of class '<em>Serve Behavior Targeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Serve Behavior Targeted Ads</em>'.
	 * @generated
	 */
	ServeBehaviorTargetedAds createServeBehaviorTargetedAds();

	/**
	 * Returns a new object of class '<em>Comment Write Read</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Comment Write Read</em>'.
	 * @generated
	 */
	CommentWriteRead createCommentWriteRead();

	/**
	 * Returns a new object of class '<em>Serve Location Targeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Serve Location Targeted Ads</em>'.
	 * @generated
	 */
	ServeLocationTargetedAds createServeLocationTargetedAds();

	/**
	 * Returns a new object of class '<em>Purpose No Consent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Purpose No Consent</em>'.
	 * @generated
	 */
	PurposeNoConsent createPurposeNoConsent();

	/**
	 * Returns a new object of class '<em>Purpose Consent</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Purpose Consent</em>'.
	 * @generated
	 */
	PurposeConsent createPurposeConsent();

	/**
	 * Returns a new object of class '<em>PMarketing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PMarketing</em>'.
	 * @generated
	 */
	PMarketing createPMarketing();

	/**
	 * Returns a new object of class '<em>PStandard Ads</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PStandard Ads</em>'.
	 * @generated
	 */
	PStandardAds createPStandardAds();

	/**
	 * Returns a new object of class '<em>PTargeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PTargeted Ads</em>'.
	 * @generated
	 */
	PTargetedAds createPTargetedAds();

	/**
	 * Returns a new object of class '<em>PLocation Targeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PLocation Targeted Ads</em>'.
	 * @generated
	 */
	PLocationTargetedAds createPLocationTargetedAds();

	/**
	 * Returns a new object of class '<em>PBehavior Targeted Ads</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PBehavior Targeted Ads</em>'.
	 * @generated
	 */
	PBehaviorTargetedAds createPBehaviorTargetedAds();

	/**
	 * Returns a new object of class '<em>PProfiling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PProfiling</em>'.
	 * @generated
	 */
	PProfiling createPProfiling();

	/**
	 * Returns a new object of class '<em>PFirst Party Profiling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PFirst Party Profiling</em>'.
	 * @generated
	 */
	PFirstPartyProfiling createPFirstPartyProfiling();

	/**
	 * Returns a new object of class '<em>PThird Party Profiling</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PThird Party Profiling</em>'.
	 * @generated
	 */
	PThirdPartyProfiling createPThirdPartyProfiling();

	/**
	 * Returns a new object of class '<em>PUser Experience</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PUser Experience</em>'.
	 * @generated
	 */
	PUserExperience createPUserExperience();

	/**
	 * Returns a new object of class '<em>PVideo Recommendation</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PVideo Recommendation</em>'.
	 * @generated
	 */
	PVideoRecommendation createPVideoRecommendation();

	/**
	 * Returns a new object of class '<em>PP2P Streaming</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PP2P Streaming</em>'.
	 * @generated
	 */
	PP2PStreaming createPP2PStreaming();

	/**
	 * Returns a new object of class '<em>PSocial</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PSocial</em>'.
	 * @generated
	 */
	PSocial createPSocial();

	/**
	 * Returns a new object of class '<em>CVE 2018 16843</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2018 16843</em>'.
	 * @generated
	 */
	CVE_2018_16843 createCVE_2018_16843();

	/**
	 * Returns a new object of class '<em>CVE 2018 16844</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2018 16844</em>'.
	 * @generated
	 */
	CVE_2018_16844 createCVE_2018_16844();

	/**
	 * Returns a new object of class '<em>CVE 2018 16845</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2018 16845</em>'.
	 * @generated
	 */
	CVE_2018_16845 createCVE_2018_16845();

	/**
	 * Returns a new object of class '<em>CVE 2019 9511</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2019 9511</em>'.
	 * @generated
	 */
	CVE_2019_9511 createCVE_2019_9511();

	/**
	 * Returns a new object of class '<em>CVE 2019 9513</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2019 9513</em>'.
	 * @generated
	 */
	CVE_2019_9513 createCVE_2019_9513();

	/**
	 * Returns a new object of class '<em>CVE 2019 9516</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2019 9516</em>'.
	 * @generated
	 */
	CVE_2019_9516 createCVE_2019_9516();

	/**
	 * Returns a new object of class '<em>CVE 2021 23017</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2021 23017</em>'.
	 * @generated
	 */
	CVE_2021_23017 createCVE_2021_23017();

	/**
	 * Returns a new object of class '<em>CVE 2021 3618</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2021 3618</em>'.
	 * @generated
	 */
	CVE_2021_3618 createCVE_2021_3618();

	/**
	 * Returns a new object of class '<em>CVE 2022 24834</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2022 24834</em>'.
	 * @generated
	 */
	CVE_2022_24834 createCVE_2022_24834();

	/**
	 * Returns a new object of class '<em>CVE 2022 36021</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2022 36021</em>'.
	 * @generated
	 */
	CVE_2022_36021 createCVE_2022_36021();

	/**
	 * Returns a new object of class '<em>CVE 2022 41862</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2022 41862</em>'.
	 * @generated
	 */
	CVE_2022_41862 createCVE_2022_41862();

	/**
	 * Returns a new object of class '<em>CVE 2023 2455</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2023 2455</em>'.
	 * @generated
	 */
	CVE_2023_2455 createCVE_2023_2455();

	/**
	 * Returns a new object of class '<em>CVE 2023 25155</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2023 25155</em>'.
	 * @generated
	 */
	CVE_2023_25155 createCVE_2023_25155();

	/**
	 * Returns a new object of class '<em>CVE 2023 28856</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2023 28856</em>'.
	 * @generated
	 */
	CVE_2023_28856 createCVE_2023_28856();

	/**
	 * Returns a new object of class '<em>CVE 2023 44487</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2023 44487</em>'.
	 * @generated
	 */
	CVE_2023_44487 createCVE_2023_44487();

	/**
	 * Returns a new object of class '<em>CVE 2023 45145</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2023 45145</em>'.
	 * @generated
	 */
	CVE_2023_45145 createCVE_2023_45145();

	/**
	 * Returns a new object of class '<em>CVE 2023 46809</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2023 46809</em>'.
	 * @generated
	 */
	CVE_2023_46809 createCVE_2023_46809();

	/**
	 * Returns a new object of class '<em>CVE 2023 5870</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2023 5870</em>'.
	 * @generated
	 */
	CVE_2023_5870 createCVE_2023_5870();

	/**
	 * Returns a new object of class '<em>CVE 2024 0985</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 0985</em>'.
	 * @generated
	 */
	CVE_2024_0985 createCVE_2024_0985();

	/**
	 * Returns a new object of class '<em>CVE 2024 10976</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 10976</em>'.
	 * @generated
	 */
	CVE_2024_10976 createCVE_2024_10976();

	/**
	 * Returns a new object of class '<em>CVE 2024 10977</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 10977</em>'.
	 * @generated
	 */
	CVE_2024_10977 createCVE_2024_10977();

	/**
	 * Returns a new object of class '<em>CVE 2024 10978</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 10978</em>'.
	 * @generated
	 */
	CVE_2024_10978 createCVE_2024_10978();

	/**
	 * Returns a new object of class '<em>CVE 2024 10979</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 10979</em>'.
	 * @generated
	 */
	CVE_2024_10979 createCVE_2024_10979();

	/**
	 * Returns a new object of class '<em>CVE 2024 21890</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 21890</em>'.
	 * @generated
	 */
	CVE_2024_21890 createCVE_2024_21890();

	/**
	 * Returns a new object of class '<em>CVE 2024 21891</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 21891</em>'.
	 * @generated
	 */
	CVE_2024_21891 createCVE_2024_21891();

	/**
	 * Returns a new object of class '<em>CVE 2024 21896</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 21896</em>'.
	 * @generated
	 */
	CVE_2024_21896 createCVE_2024_21896();

	/**
	 * Returns a new object of class '<em>CVE 2024 22017</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 22017</em>'.
	 * @generated
	 */
	CVE_2024_22017 createCVE_2024_22017();

	/**
	 * Returns a new object of class '<em>CVE 2024 22018</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 22018</em>'.
	 * @generated
	 */
	CVE_2024_22018 createCVE_2024_22018();

	/**
	 * Returns a new object of class '<em>CVE 2024 22019</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 22019</em>'.
	 * @generated
	 */
	CVE_2024_22019 createCVE_2024_22019();

	/**
	 * Returns a new object of class '<em>CVE 2024 22020</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 22020</em>'.
	 * @generated
	 */
	CVE_2024_22020 createCVE_2024_22020();

	/**
	 * Returns a new object of class '<em>CVE 2024 22025</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 22025</em>'.
	 * @generated
	 */
	CVE_2024_22025 createCVE_2024_22025();

	/**
	 * Returns a new object of class '<em>CVE 2024 27980</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 27980</em>'.
	 * @generated
	 */
	CVE_2024_27980 createCVE_2024_27980();

	/**
	 * Returns a new object of class '<em>CVE 2024 27983</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 27983</em>'.
	 * @generated
	 */
	CVE_2024_27983 createCVE_2024_27983();

	/**
	 * Returns a new object of class '<em>CVE 2024 31449</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 31449</em>'.
	 * @generated
	 */
	CVE_2024_31449 createCVE_2024_31449();

	/**
	 * Returns a new object of class '<em>CVE 2024 31489</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 31489</em>'.
	 * @generated
	 */
	CVE_2024_31489 createCVE_2024_31489();

	/**
	 * Returns a new object of class '<em>CVE 2024 3566</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 3566</em>'.
	 * @generated
	 */
	CVE_2024_3566 createCVE_2024_3566();

	/**
	 * Returns a new object of class '<em>CVE 2024 36137</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 36137</em>'.
	 * @generated
	 */
	CVE_2024_36137 createCVE_2024_36137();

	/**
	 * Returns a new object of class '<em>CVE 2024 36138</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 36138</em>'.
	 * @generated
	 */
	CVE_2024_36138 createCVE_2024_36138();

	/**
	 * Returns a new object of class '<em>CVE 2024 37372</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 37372</em>'.
	 * @generated
	 */
	CVE_2024_37372 createCVE_2024_37372();

	/**
	 * Returns a new object of class '<em>CVE 2024 46981</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 46981</em>'.
	 * @generated
	 */
	CVE_2024_46981 createCVE_2024_46981();

	/**
	 * Returns a new object of class '<em>CVE 2024 5205</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 5205</em>'.
	 * @generated
	 */
	CVE_2024_5205 createCVE_2024_5205();

	/**
	 * Returns a new object of class '<em>CVE 2024 7347</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 7347</em>'.
	 * @generated
	 */
	CVE_2024_7347 createCVE_2024_7347();

	/**
	 * Returns a new object of class '<em>CVE 2024 7348</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2024 7348</em>'.
	 * @generated
	 */
	CVE_2024_7348 createCVE_2024_7348();

	/**
	 * Returns a new object of class '<em>CVE 2025 1094</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 1094</em>'.
	 * @generated
	 */
	CVE_2025_1094 createCVE_2025_1094();

	/**
	 * Returns a new object of class '<em>CVE 2025 11187</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 11187</em>'.
	 * @generated
	 */
	CVE_2025_11187 createCVE_2025_11187();

	/**
	 * Returns a new object of class '<em>CVE 2025 15468</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 15468</em>'.
	 * @generated
	 */
	CVE_2025_15468 createCVE_2025_15468();

	/**
	 * Returns a new object of class '<em>CVE 2025 21605</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 21605</em>'.
	 * @generated
	 */
	CVE_2025_21605 createCVE_2025_21605();

	/**
	 * Returns a new object of class '<em>CVE 2025 23084</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 23084</em>'.
	 * @generated
	 */
	CVE_2025_23084 createCVE_2025_23084();

	/**
	 * Returns a new object of class '<em>CVE 2025 23090</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 23090</em>'.
	 * @generated
	 */
	CVE_2025_23090 createCVE_2025_23090();

	/**
	 * Returns a new object of class '<em>CVE 2025 32023</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 32023</em>'.
	 * @generated
	 */
	CVE_2025_32023 createCVE_2025_32023();

	/**
	 * Returns a new object of class '<em>CVE 2025 62506</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 62506</em>'.
	 * @generated
	 */
	CVE_2025_62506 createCVE_2025_62506();

	/**
	 * Returns a new object of class '<em>CVE 2025 62507</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 62507</em>'.
	 * @generated
	 */
	CVE_2025_62507 createCVE_2025_62507();

	/**
	 * Returns a new object of class '<em>CVE 2025 66199</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 66199</em>'.
	 * @generated
	 */
	CVE_2025_66199 createCVE_2025_66199();

	/**
	 * Returns a new object of class '<em>CVE 2025 69418</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 69418</em>'.
	 * @generated
	 */
	CVE_2025_69418 createCVE_2025_69418();

	/**
	 * Returns a new object of class '<em>CVE 2025 69420</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 69420</em>'.
	 * @generated
	 */
	CVE_2025_69420 createCVE_2025_69420();

	/**
	 * Returns a new object of class '<em>CVE 2025 69421</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2025 69421</em>'.
	 * @generated
	 */
	CVE_2025_69421 createCVE_2025_69421();

	/**
	 * Returns a new object of class '<em>CVE 2026 22795</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2026 22795</em>'.
	 * @generated
	 */
	CVE_2026_22795 createCVE_2026_22795();

	/**
	 * Returns a new object of class '<em>CVE 2026 22796</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2026 22796</em>'.
	 * @generated
	 */
	CVE_2026_22796 createCVE_2026_22796();

	/**
	 * Returns a new object of class '<em>CVE 2026 27970</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVE 2026 27970</em>'.
	 * @generated
	 */
	CVE_2026_27970 createCVE_2026_27970();

	/**
	 * Returns a new object of class '<em>PComments</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PComments</em>'.
	 * @generated
	 */
	PComments createPComments();

	/**
	 * Returns a new object of class '<em>PVideo Sharing</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>PVideo Sharing</em>'.
	 * @generated
	 */
	PVideoSharing createPVideoSharing();

	/**
	 * Returns a new object of class '<em>Vulnerability</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Vulnerability</em>'.
	 * @generated
	 */
	Vulnerability createVulnerability();

	/**
	 * Returns a new object of class '<em>CVSS Vector</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>CVSS Vector</em>'.
	 * @generated
	 */
	CVSSVector createCVSSVector();

	/**
	 * Returns a new object of class '<em>Risk</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Risk</em>'.
	 * @generated
	 */
	Risk createRisk();

	/**
	 * Returns a new object of class '<em>System</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>System</em>'.
	 * @generated
	 */
	System createSystem();

	/**
	 * Returns a new object of class '<em>Redis Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Redis Component</em>'.
	 * @generated
	 */
	RedisComponent createRedisComponent();

	/**
	 * Returns a new object of class '<em>Filesystem Component</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Filesystem Component</em>'.
	 * @generated
	 */
	FilesystemComponent createFilesystemComponent();

	/**
	 * Returns a new object of class '<em>Postgresql</em>'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return a new object of class '<em>Postgresql</em>'.
	 * @generated
	 */
	Postgresql createPostgresql();

	/**
	 * Returns the package supported by this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the package supported by this factory.
	 * @generated
	 */
	CASAPackage getCASAPackage();

} //CASAFactory
