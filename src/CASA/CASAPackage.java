/**
 */
package CASA;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EClass;
import org.eclipse.emf.ecore.EOperation;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;

/**
 * <!-- begin-user-doc -->
 * The <b>Package</b> for the model.
 * It contains accessors for the meta objects to represent
 * <ul>
 *   <li>each class,</li>
 *   <li>each feature of each class,</li>
 *   <li>each operation of each class,</li>
 *   <li>each enum,</li>
 *   <li>and each data type</li>
 * </ul>
 * <!-- end-user-doc -->
 * @see CASA.CASAFactory
 * @model kind="package"
 *        annotation="http://www.eclipse.org/emf/2002/Ecore"
 * @generated
 */
public interface CASAPackage extends EPackage {
	/**
	 * The package name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNAME = "CASA";

	/**
	 * The package namespace URI.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_URI = "http://www.casa.com";

	/**
	 * The package namespace name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	String eNS_PREFIX = "casa";

	/**
	 * The singleton instance of the package.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	CASAPackage eINSTANCE = CASA.impl.CASAPackageImpl.init();

	/**
	 * The meta object id for the '{@link CASA.impl.ConsentImpl <em>Consent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.ConsentImpl
	 * @see CASA.impl.CASAPackageImpl#getConsent()
	 * @generated
	 */
	int CONSENT = 0;

	/**
	 * The feature id for the '<em><b>For Purpose</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT__FOR_PURPOSE = 0;

	/**
	 * The feature id for the '<em><b>Informed Risk Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT__INFORMED_RISK_LEVEL = 1;

	/**
	 * The feature id for the '<em><b>Given For</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT__GIVEN_FOR = 2;

	/**
	 * The feature id for the '<em><b>Given By</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT__GIVEN_BY = 3;

	/**
	 * The feature id for the '<em><b>For Personal Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT__FOR_PERSONAL_DATA = 4;

	/**
	 * The number of structural features of the '<em>Consent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_FEATURE_COUNT = 5;

	/**
	 * The number of operations of the '<em>Consent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CONSENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link CASA.impl.DataSubjectImpl <em>Data Subject</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.DataSubjectImpl
	 * @see CASA.impl.CASAPackageImpl#getDataSubject()
	 * @generated
	 */
	int DATA_SUBJECT = 1;

	/**
	 * The feature id for the '<em><b>Identified By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT__IDENTIFIED_BY = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Gives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT__GIVES = 2;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT__AFFECTED_BY = 3;

	/**
	 * The number of structural features of the '<em>Data Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT_FEATURE_COUNT = 4;

	/**
	 * The number of operations of the '<em>Data Subject</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_SUBJECT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link CASA.impl.UserImpl <em>User</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.UserImpl
	 * @see CASA.impl.CASAPackageImpl#getUser()
	 * @generated
	 */
	int USER = 2;

	/**
	 * The feature id for the '<em><b>Identified By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__IDENTIFIED_BY = DATA_SUBJECT__IDENTIFIED_BY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__NAME = DATA_SUBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Gives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__GIVES = DATA_SUBJECT__GIVES;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER__AFFECTED_BY = DATA_SUBJECT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_FEATURE_COUNT = DATA_SUBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>User</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USER_OPERATION_COUNT = DATA_SUBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.AdministratorImpl <em>Administrator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.AdministratorImpl
	 * @see CASA.impl.CASAPackageImpl#getAdministrator()
	 * @generated
	 */
	int ADMINISTRATOR = 3;

	/**
	 * The feature id for the '<em><b>Identified By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR__IDENTIFIED_BY = DATA_SUBJECT__IDENTIFIED_BY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR__NAME = DATA_SUBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Gives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR__GIVES = DATA_SUBJECT__GIVES;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR__AFFECTED_BY = DATA_SUBJECT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>Administrator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR_FEATURE_COUNT = DATA_SUBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Administrator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ADMINISTRATOR_OPERATION_COUNT = DATA_SUBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.ModeratorImpl <em>Moderator</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.ModeratorImpl
	 * @see CASA.impl.CASAPackageImpl#getModerator()
	 * @generated
	 */
	int MODERATOR = 4;

	/**
	 * The feature id for the '<em><b>Identified By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODERATOR__IDENTIFIED_BY = DATA_SUBJECT__IDENTIFIED_BY;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODERATOR__NAME = DATA_SUBJECT__NAME;

	/**
	 * The feature id for the '<em><b>Gives</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODERATOR__GIVES = DATA_SUBJECT__GIVES;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODERATOR__AFFECTED_BY = DATA_SUBJECT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>Moderator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODERATOR_FEATURE_COUNT = DATA_SUBJECT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Moderator</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int MODERATOR_OPERATION_COUNT = DATA_SUBJECT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.DataImpl <em>Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.DataImpl
	 * @see CASA.impl.CASAPackageImpl#getData()
	 * @generated
	 */
	int DATA = 18;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA__NAME = 0;

	/**
	 * The number of structural features of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_FEATURE_COUNT = 1;

	/**
	 * The number of operations of the '<em>Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DATA_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PersonalDataImpl <em>Personal Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PersonalDataImpl
	 * @see CASA.impl.CASAPackageImpl#getPersonalData()
	 * @generated
	 */
	int PERSONAL_DATA = 5;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA__NAME = DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA__IDENTIFIES = DATA_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA__PROCESSED_BY = DATA_FEATURE_COUNT + 1;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA__SUBJECT_OF_CONSENT = DATA_FEATURE_COUNT + 2;

	/**
	 * The number of structural features of the '<em>Personal Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_FEATURE_COUNT = DATA_FEATURE_COUNT + 3;

	/**
	 * The number of operations of the '<em>Personal Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PERSONAL_DATA_OPERATION_COUNT = DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.UsernameImpl <em>Username</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.UsernameImpl
	 * @see CASA.impl.CASAPackageImpl#getUsername()
	 * @generated
	 */
	int USERNAME = 6;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERNAME__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERNAME__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERNAME__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERNAME__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Username</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERNAME_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Username</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int USERNAME_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PasswordImpl <em>Password</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PasswordImpl
	 * @see CASA.impl.CASAPackageImpl#getPassword()
	 * @generated
	 */
	int PASSWORD = 7;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Password</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Password</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PASSWORD_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.EmailAddressImpl <em>Email Address</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.EmailAddressImpl
	 * @see CASA.impl.CASAPackageImpl#getEmailAddress()
	 * @generated
	 */
	int EMAIL_ADDRESS = 8;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_ADDRESS__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_ADDRESS__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_ADDRESS__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_ADDRESS__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Email Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_ADDRESS_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Email Address</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EMAIL_ADDRESS_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PaymentImpl <em>Payment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PaymentImpl
	 * @see CASA.impl.CASAPackageImpl#getPayment()
	 * @generated
	 */
	int PAYMENT = 9;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Payment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Payment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PAYMENT_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.StreamingHistoryImpl <em>Streaming History</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.StreamingHistoryImpl
	 * @see CASA.impl.CASAPackageImpl#getStreamingHistory()
	 * @generated
	 */
	int STREAMING_HISTORY = 10;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAMING_HISTORY__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAMING_HISTORY__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAMING_HISTORY__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAMING_HISTORY__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Streaming History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAMING_HISTORY_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Streaming History</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAMING_HISTORY_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.TrackingCookieImpl <em>Tracking Cookie</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.TrackingCookieImpl
	 * @see CASA.impl.CASAPackageImpl#getTrackingCookie()
	 * @generated
	 */
	int TRACKING_COOKIE = 11;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKING_COOKIE__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKING_COOKIE__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKING_COOKIE__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKING_COOKIE__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Tracking Cookie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKING_COOKIE_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Tracking Cookie</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int TRACKING_COOKIE_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.VideoContentImpl <em>Video Content</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.VideoContentImpl
	 * @see CASA.impl.CASAPackageImpl#getVideoContent()
	 * @generated
	 */
	int VIDEO_CONTENT = 12;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_CONTENT__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_CONTENT__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_CONTENT__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_CONTENT__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Video Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_CONTENT_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Video Content</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_CONTENT_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.VideoCommentImpl <em>Video Comment</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.VideoCommentImpl
	 * @see CASA.impl.CASAPackageImpl#getVideoComment()
	 * @generated
	 */
	int VIDEO_COMMENT = 13;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_COMMENT__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_COMMENT__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_COMMENT__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_COMMENT__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Video Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_COMMENT_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Video Comment</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_COMMENT_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.VideoMetadataImpl <em>Video Metadata</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.VideoMetadataImpl
	 * @see CASA.impl.CASAPackageImpl#getVideoMetadata()
	 * @generated
	 */
	int VIDEO_METADATA = 14;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_METADATA__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_METADATA__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_METADATA__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_METADATA__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Video Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_METADATA_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Video Metadata</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VIDEO_METADATA_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.DeviceTypeImpl <em>Device Type</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.DeviceTypeImpl
	 * @see CASA.impl.CASAPackageImpl#getDeviceType()
	 * @generated
	 */
	int DEVICE_TYPE = 15;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Device Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Device Type</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_TYPE_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.DeviceLocationImpl <em>Device Location</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.DeviceLocationImpl
	 * @see CASA.impl.CASAPackageImpl#getDeviceLocation()
	 * @generated
	 */
	int DEVICE_LOCATION = 16;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_LOCATION__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_LOCATION__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_LOCATION__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_LOCATION__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Device Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_LOCATION_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Device Location</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int DEVICE_LOCATION_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.RequestTimestampsImpl <em>Request Timestamps</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.RequestTimestampsImpl
	 * @see CASA.impl.CASAPackageImpl#getRequestTimestamps()
	 * @generated
	 */
	int REQUEST_TIMESTAMPS = 17;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TIMESTAMPS__NAME = PERSONAL_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Identifies</b></em>' reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TIMESTAMPS__IDENTIFIES = PERSONAL_DATA__IDENTIFIES;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TIMESTAMPS__PROCESSED_BY = PERSONAL_DATA__PROCESSED_BY;

	/**
	 * The feature id for the '<em><b>Subject Of Consent</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TIMESTAMPS__SUBJECT_OF_CONSENT = PERSONAL_DATA__SUBJECT_OF_CONSENT;

	/**
	 * The number of structural features of the '<em>Request Timestamps</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TIMESTAMPS_FEATURE_COUNT = PERSONAL_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Request Timestamps</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REQUEST_TIMESTAMPS_OPERATION_COUNT = PERSONAL_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.NonPersonalDataImpl <em>Non Personal Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.NonPersonalDataImpl
	 * @see CASA.impl.CASAPackageImpl#getNonPersonalData()
	 * @generated
	 */
	int NON_PERSONAL_DATA = 19;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_PERSONAL_DATA__NAME = DATA__NAME;

	/**
	 * The feature id for the '<em><b>Processed By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_PERSONAL_DATA__PROCESSED_BY = DATA_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Non Personal Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_PERSONAL_DATA_FEATURE_COUNT = DATA_FEATURE_COUNT + 1;

	/**
	 * The number of operations of the '<em>Non Personal Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NON_PERSONAL_DATA_OPERATION_COUNT = DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PurposeImpl <em>Purpose</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PurposeImpl
	 * @see CASA.impl.CASAPackageImpl#getPurpose()
	 * @generated
	 */
	int PURPOSE = 20;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE__NAME = 0;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE__OF_FUNCTION = 1;

	/**
	 * The number of structural features of the '<em>Purpose</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_FEATURE_COUNT = 2;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Purpose</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link CASA.impl.ComponentImpl <em>Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.ComponentImpl
	 * @see CASA.impl.CASAPackageImpl#getComponent()
	 * @generated
	 */
	int COMPONENT = 21;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__REALIZES = 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__NAME = 1;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT__AFFECTED_BY = 2;

	/**
	 * The number of structural features of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMPONENT_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link CASA.impl.AngularSPAImpl <em>Angular SPA</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.AngularSPAImpl
	 * @see CASA.impl.CASAPackageImpl#getAngularSPA()
	 * @generated
	 */
	int ANGULAR_SPA = 22;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANGULAR_SPA__REALIZES = COMPONENT__REALIZES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANGULAR_SPA__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANGULAR_SPA__AFFECTED_BY = COMPONENT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>Angular SPA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANGULAR_SPA_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Angular SPA</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int ANGULAR_SPA_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.NginxImpl <em>Nginx</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.NginxImpl
	 * @see CASA.impl.CASAPackageImpl#getNginx()
	 * @generated
	 */
	int NGINX = 23;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NGINX__REALIZES = COMPONENT__REALIZES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NGINX__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NGINX__AFFECTED_BY = COMPONENT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>Nginx</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NGINX_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Nginx</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int NGINX_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.ExpressJSImpl <em>Express JS</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.ExpressJSImpl
	 * @see CASA.impl.CASAPackageImpl#getExpressJS()
	 * @generated
	 */
	int EXPRESS_JS = 24;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESS_JS__REALIZES = COMPONENT__REALIZES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESS_JS__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESS_JS__AFFECTED_BY = COMPONENT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>Express JS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESS_JS_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Express JS</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int EXPRESS_JS_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.FunctionImpl <em>Function</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.FunctionImpl
	 * @see CASA.impl.CASAPackageImpl#getFunction()
	 * @generated
	 */
	int FUNCTION = 25;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__NAME = 0;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__REALIZED_BY = 1;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION__PROCESSES = 2;

	/**
	 * The number of structural features of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Function</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNCTION_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link CASA.impl.FuncPersDataImpl <em>Func Pers Data</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.FuncPersDataImpl
	 * @see CASA.impl.CASAPackageImpl#getFuncPersData()
	 * @generated
	 */
	int FUNC_PERS_DATA = 26;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_PERS_DATA__NAME = FUNCTION__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_PERS_DATA__REALIZED_BY = FUNCTION__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_PERS_DATA__PROCESSES = FUNCTION__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_PERS_DATA__PROCESSES_PERS_DATA = FUNCTION_FEATURE_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_PERS_DATA__HAS = FUNCTION_FEATURE_COUNT + 1;

	/**
	 * The number of structural features of the '<em>Func Pers Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_PERS_DATA_FEATURE_COUNT = FUNCTION_FEATURE_COUNT + 2;

	/**
	 * The number of operations of the '<em>Func Pers Data</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FUNC_PERS_DATA_OPERATION_COUNT = FUNCTION_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.ServeStandardAdsImpl <em>Serve Standard Ads</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.ServeStandardAdsImpl
	 * @see CASA.impl.CASAPackageImpl#getServeStandardAds()
	 * @generated
	 */
	int SERVE_STANDARD_ADS = 27;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_STANDARD_ADS__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_STANDARD_ADS__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_STANDARD_ADS__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_STANDARD_ADS__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_STANDARD_ADS__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Serve Standard Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_STANDARD_ADS_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Serve Standard Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_STANDARD_ADS_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.UploadVideoImpl <em>Upload Video</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.UploadVideoImpl
	 * @see CASA.impl.CASAPackageImpl#getUploadVideo()
	 * @generated
	 */
	int UPLOAD_VIDEO = 28;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_VIDEO__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_VIDEO__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_VIDEO__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_VIDEO__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_VIDEO__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Upload Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_VIDEO_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Upload Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int UPLOAD_VIDEO_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.StreamVideoImpl <em>Stream Video</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.StreamVideoImpl
	 * @see CASA.impl.CASAPackageImpl#getStreamVideo()
	 * @generated
	 */
	int STREAM_VIDEO = 29;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_VIDEO__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_VIDEO__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_VIDEO__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_VIDEO__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_VIDEO__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Stream Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_VIDEO_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Stream Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int STREAM_VIDEO_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.RemoveVideoImpl <em>Remove Video</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.RemoveVideoImpl
	 * @see CASA.impl.CASAPackageImpl#getRemoveVideo()
	 * @generated
	 */
	int REMOVE_VIDEO = 30;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIDEO__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIDEO__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIDEO__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIDEO__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIDEO__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Remove Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIDEO_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Remove Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REMOVE_VIDEO_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.LiveStreamVideoImpl <em>Live Stream Video</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.LiveStreamVideoImpl
	 * @see CASA.impl.CASAPackageImpl#getLiveStreamVideo()
	 * @generated
	 */
	int LIVE_STREAM_VIDEO = 31;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_STREAM_VIDEO__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_STREAM_VIDEO__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_STREAM_VIDEO__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_STREAM_VIDEO__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_STREAM_VIDEO__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Live Stream Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_STREAM_VIDEO_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Live Stream Video</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int LIVE_STREAM_VIDEO_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.P2PStreamingImpl <em>P2P Streaming</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.P2PStreamingImpl
	 * @see CASA.impl.CASAPackageImpl#getP2PStreaming()
	 * @generated
	 */
	int P2P_STREAMING = 32;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int P2P_STREAMING__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int P2P_STREAMING__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int P2P_STREAMING__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int P2P_STREAMING__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int P2P_STREAMING__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>P2P Streaming</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int P2P_STREAMING_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>P2P Streaming</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int P2P_STREAMING_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.RecommendVideosImpl <em>Recommend Videos</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.RecommendVideosImpl
	 * @see CASA.impl.CASAPackageImpl#getRecommendVideos()
	 * @generated
	 */
	int RECOMMEND_VIDEOS = 33;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMEND_VIDEOS__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMEND_VIDEOS__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMEND_VIDEOS__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMEND_VIDEOS__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMEND_VIDEOS__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Recommend Videos</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMEND_VIDEOS_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Recommend Videos</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RECOMMEND_VIDEOS_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.ServeBehaviorTargetedAdsImpl <em>Serve Behavior Targeted Ads</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.ServeBehaviorTargetedAdsImpl
	 * @see CASA.impl.CASAPackageImpl#getServeBehaviorTargetedAds()
	 * @generated
	 */
	int SERVE_BEHAVIOR_TARGETED_ADS = 34;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_BEHAVIOR_TARGETED_ADS__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_BEHAVIOR_TARGETED_ADS__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_BEHAVIOR_TARGETED_ADS__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_BEHAVIOR_TARGETED_ADS__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_BEHAVIOR_TARGETED_ADS__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Serve Behavior Targeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_BEHAVIOR_TARGETED_ADS_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Serve Behavior Targeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_BEHAVIOR_TARGETED_ADS_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CommentWriteReadImpl <em>Comment Write Read</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CommentWriteReadImpl
	 * @see CASA.impl.CASAPackageImpl#getCommentWriteRead()
	 * @generated
	 */
	int COMMENT_WRITE_READ = 35;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_WRITE_READ__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_WRITE_READ__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_WRITE_READ__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_WRITE_READ__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_WRITE_READ__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Comment Write Read</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_WRITE_READ_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Comment Write Read</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int COMMENT_WRITE_READ_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.ServeLocationTargetedAdsImpl <em>Serve Location Targeted Ads</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.ServeLocationTargetedAdsImpl
	 * @see CASA.impl.CASAPackageImpl#getServeLocationTargetedAds()
	 * @generated
	 */
	int SERVE_LOCATION_TARGETED_ADS = 36;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_LOCATION_TARGETED_ADS__NAME = FUNC_PERS_DATA__NAME;

	/**
	 * The feature id for the '<em><b>Realized By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_LOCATION_TARGETED_ADS__REALIZED_BY = FUNC_PERS_DATA__REALIZED_BY;

	/**
	 * The feature id for the '<em><b>Processes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_LOCATION_TARGETED_ADS__PROCESSES = FUNC_PERS_DATA__PROCESSES;

	/**
	 * The feature id for the '<em><b>Processes Pers Data</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_LOCATION_TARGETED_ADS__PROCESSES_PERS_DATA = FUNC_PERS_DATA__PROCESSES_PERS_DATA;

	/**
	 * The feature id for the '<em><b>Has</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_LOCATION_TARGETED_ADS__HAS = FUNC_PERS_DATA__HAS;

	/**
	 * The number of structural features of the '<em>Serve Location Targeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_LOCATION_TARGETED_ADS_FEATURE_COUNT = FUNC_PERS_DATA_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Serve Location Targeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SERVE_LOCATION_TARGETED_ADS_OPERATION_COUNT = FUNC_PERS_DATA_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PurposeNoConsentImpl <em>Purpose No Consent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PurposeNoConsentImpl
	 * @see CASA.impl.CASAPackageImpl#getPurposeNoConsent()
	 * @generated
	 */
	int PURPOSE_NO_CONSENT = 37;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_NO_CONSENT__NAME = PURPOSE__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_NO_CONSENT__OF_FUNCTION = PURPOSE__OF_FUNCTION;

	/**
	 * The number of structural features of the '<em>Purpose No Consent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_NO_CONSENT_FEATURE_COUNT = PURPOSE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_NO_CONSENT___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PURPOSE___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Purpose No Consent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_NO_CONSENT_OPERATION_COUNT = PURPOSE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PurposeConsentImpl <em>Purpose Consent</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PurposeConsentImpl
	 * @see CASA.impl.CASAPackageImpl#getPurposeConsent()
	 * @generated
	 */
	int PURPOSE_CONSENT = 38;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_CONSENT__NAME = PURPOSE__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_CONSENT__OF_FUNCTION = PURPOSE__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_CONSENT__REQUIRES = PURPOSE_FEATURE_COUNT + 0;

	/**
	 * The number of structural features of the '<em>Purpose Consent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_CONSENT_FEATURE_COUNT = PURPOSE_FEATURE_COUNT + 1;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_CONSENT___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PURPOSE___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>Purpose Consent</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PURPOSE_CONSENT_OPERATION_COUNT = PURPOSE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PMarketingImpl <em>PMarketing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PMarketingImpl
	 * @see CASA.impl.CASAPackageImpl#getPMarketing()
	 * @generated
	 */
	int PMARKETING = 39;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMARKETING__NAME = PURPOSE_CONSENT__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMARKETING__OF_FUNCTION = PURPOSE_CONSENT__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMARKETING__REQUIRES = PURPOSE_CONSENT__REQUIRES;

	/**
	 * The number of structural features of the '<em>PMarketing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMARKETING_FEATURE_COUNT = PURPOSE_CONSENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMARKETING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PURPOSE_CONSENT___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PMarketing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PMARKETING_OPERATION_COUNT = PURPOSE_CONSENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PStandardAdsImpl <em>PStandard Ads</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PStandardAdsImpl
	 * @see CASA.impl.CASAPackageImpl#getPStandardAds()
	 * @generated
	 */
	int PSTANDARD_ADS = 40;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTANDARD_ADS__NAME = PMARKETING__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTANDARD_ADS__OF_FUNCTION = PMARKETING__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTANDARD_ADS__REQUIRES = PMARKETING__REQUIRES;

	/**
	 * The number of structural features of the '<em>PStandard Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTANDARD_ADS_FEATURE_COUNT = PMARKETING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTANDARD_ADS___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PMARKETING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PStandard Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSTANDARD_ADS_OPERATION_COUNT = PMARKETING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PTargetedAdsImpl <em>PTargeted Ads</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PTargetedAdsImpl
	 * @see CASA.impl.CASAPackageImpl#getPTargetedAds()
	 * @generated
	 */
	int PTARGETED_ADS = 41;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTARGETED_ADS__NAME = PMARKETING__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTARGETED_ADS__OF_FUNCTION = PMARKETING__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTARGETED_ADS__REQUIRES = PMARKETING__REQUIRES;

	/**
	 * The number of structural features of the '<em>PTargeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTARGETED_ADS_FEATURE_COUNT = PMARKETING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTARGETED_ADS___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PMARKETING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PTargeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTARGETED_ADS_OPERATION_COUNT = PMARKETING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PLocationTargetedAdsImpl <em>PLocation Targeted Ads</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PLocationTargetedAdsImpl
	 * @see CASA.impl.CASAPackageImpl#getPLocationTargetedAds()
	 * @generated
	 */
	int PLOCATION_TARGETED_ADS = 42;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOCATION_TARGETED_ADS__NAME = PTARGETED_ADS__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOCATION_TARGETED_ADS__OF_FUNCTION = PTARGETED_ADS__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOCATION_TARGETED_ADS__REQUIRES = PTARGETED_ADS__REQUIRES;

	/**
	 * The number of structural features of the '<em>PLocation Targeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOCATION_TARGETED_ADS_FEATURE_COUNT = PTARGETED_ADS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOCATION_TARGETED_ADS___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PTARGETED_ADS___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PLocation Targeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PLOCATION_TARGETED_ADS_OPERATION_COUNT = PTARGETED_ADS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PBehaviorTargetedAdsImpl <em>PBehavior Targeted Ads</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PBehaviorTargetedAdsImpl
	 * @see CASA.impl.CASAPackageImpl#getPBehaviorTargetedAds()
	 * @generated
	 */
	int PBEHAVIOR_TARGETED_ADS = 43;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBEHAVIOR_TARGETED_ADS__NAME = PTARGETED_ADS__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBEHAVIOR_TARGETED_ADS__OF_FUNCTION = PTARGETED_ADS__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBEHAVIOR_TARGETED_ADS__REQUIRES = PTARGETED_ADS__REQUIRES;

	/**
	 * The number of structural features of the '<em>PBehavior Targeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBEHAVIOR_TARGETED_ADS_FEATURE_COUNT = PTARGETED_ADS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBEHAVIOR_TARGETED_ADS___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PTARGETED_ADS___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PBehavior Targeted Ads</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PBEHAVIOR_TARGETED_ADS_OPERATION_COUNT = PTARGETED_ADS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PProfilingImpl <em>PProfiling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PProfilingImpl
	 * @see CASA.impl.CASAPackageImpl#getPProfiling()
	 * @generated
	 */
	int PPROFILING = 44;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPROFILING__NAME = PURPOSE_CONSENT__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPROFILING__OF_FUNCTION = PURPOSE_CONSENT__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPROFILING__REQUIRES = PURPOSE_CONSENT__REQUIRES;

	/**
	 * The number of structural features of the '<em>PProfiling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPROFILING_FEATURE_COUNT = PURPOSE_CONSENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPROFILING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PURPOSE_CONSENT___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PProfiling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PPROFILING_OPERATION_COUNT = PURPOSE_CONSENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PFirstPartyProfilingImpl <em>PFirst Party Profiling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PFirstPartyProfilingImpl
	 * @see CASA.impl.CASAPackageImpl#getPFirstPartyProfiling()
	 * @generated
	 */
	int PFIRST_PARTY_PROFILING = 45;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PFIRST_PARTY_PROFILING__NAME = PPROFILING__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PFIRST_PARTY_PROFILING__OF_FUNCTION = PPROFILING__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PFIRST_PARTY_PROFILING__REQUIRES = PPROFILING__REQUIRES;

	/**
	 * The number of structural features of the '<em>PFirst Party Profiling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PFIRST_PARTY_PROFILING_FEATURE_COUNT = PPROFILING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PFIRST_PARTY_PROFILING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PPROFILING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PFirst Party Profiling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PFIRST_PARTY_PROFILING_OPERATION_COUNT = PPROFILING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PThirdPartyProfilingImpl <em>PThird Party Profiling</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PThirdPartyProfilingImpl
	 * @see CASA.impl.CASAPackageImpl#getPThirdPartyProfiling()
	 * @generated
	 */
	int PTHIRD_PARTY_PROFILING = 46;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTHIRD_PARTY_PROFILING__NAME = PFIRST_PARTY_PROFILING__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTHIRD_PARTY_PROFILING__OF_FUNCTION = PFIRST_PARTY_PROFILING__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTHIRD_PARTY_PROFILING__REQUIRES = PFIRST_PARTY_PROFILING__REQUIRES;

	/**
	 * The number of structural features of the '<em>PThird Party Profiling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTHIRD_PARTY_PROFILING_FEATURE_COUNT = PFIRST_PARTY_PROFILING_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTHIRD_PARTY_PROFILING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PFIRST_PARTY_PROFILING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PThird Party Profiling</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PTHIRD_PARTY_PROFILING_OPERATION_COUNT = PFIRST_PARTY_PROFILING_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PUserExperienceImpl <em>PUser Experience</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PUserExperienceImpl
	 * @see CASA.impl.CASAPackageImpl#getPUserExperience()
	 * @generated
	 */
	int PUSER_EXPERIENCE = 47;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSER_EXPERIENCE__NAME = PURPOSE_CONSENT__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSER_EXPERIENCE__OF_FUNCTION = PURPOSE_CONSENT__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSER_EXPERIENCE__REQUIRES = PURPOSE_CONSENT__REQUIRES;

	/**
	 * The number of structural features of the '<em>PUser Experience</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSER_EXPERIENCE_FEATURE_COUNT = PURPOSE_CONSENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSER_EXPERIENCE___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PURPOSE_CONSENT___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PUser Experience</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PUSER_EXPERIENCE_OPERATION_COUNT = PURPOSE_CONSENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PVideoRecommendationImpl <em>PVideo Recommendation</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PVideoRecommendationImpl
	 * @see CASA.impl.CASAPackageImpl#getPVideoRecommendation()
	 * @generated
	 */
	int PVIDEO_RECOMMENDATION = 48;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_RECOMMENDATION__NAME = PUSER_EXPERIENCE__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_RECOMMENDATION__OF_FUNCTION = PUSER_EXPERIENCE__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_RECOMMENDATION__REQUIRES = PUSER_EXPERIENCE__REQUIRES;

	/**
	 * The number of structural features of the '<em>PVideo Recommendation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_RECOMMENDATION_FEATURE_COUNT = PUSER_EXPERIENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_RECOMMENDATION___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PUSER_EXPERIENCE___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PVideo Recommendation</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_RECOMMENDATION_OPERATION_COUNT = PUSER_EXPERIENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PP2PStreamingImpl <em>PP2P Streaming</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PP2PStreamingImpl
	 * @see CASA.impl.CASAPackageImpl#getPP2PStreaming()
	 * @generated
	 */
	int PP2P_STREAMING = 49;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP2P_STREAMING__NAME = PUSER_EXPERIENCE__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP2P_STREAMING__OF_FUNCTION = PUSER_EXPERIENCE__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP2P_STREAMING__REQUIRES = PUSER_EXPERIENCE__REQUIRES;

	/**
	 * The number of structural features of the '<em>PP2P Streaming</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP2P_STREAMING_FEATURE_COUNT = PUSER_EXPERIENCE_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP2P_STREAMING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PUSER_EXPERIENCE___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PP2P Streaming</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PP2P_STREAMING_OPERATION_COUNT = PUSER_EXPERIENCE_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PSocialImpl <em>PSocial</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PSocialImpl
	 * @see CASA.impl.CASAPackageImpl#getPSocial()
	 * @generated
	 */
	int PSOCIAL = 50;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSOCIAL__NAME = PURPOSE_CONSENT__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSOCIAL__OF_FUNCTION = PURPOSE_CONSENT__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSOCIAL__REQUIRES = PURPOSE_CONSENT__REQUIRES;

	/**
	 * The number of structural features of the '<em>PSocial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSOCIAL_FEATURE_COUNT = PURPOSE_CONSENT_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSOCIAL___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PURPOSE_CONSENT___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PSocial</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PSOCIAL_OPERATION_COUNT = PURPOSE_CONSENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PCommentsImpl <em>PComments</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PCommentsImpl
	 * @see CASA.impl.CASAPackageImpl#getPComments()
	 * @generated
	 */
	int PCOMMENTS = 110;

	/**
	 * The meta object id for the '{@link CASA.impl.VulnerabilityImpl <em>Vulnerability</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.VulnerabilityImpl
	 * @see CASA.impl.CASAPackageImpl#getVulnerability()
	 * @generated
	 */
	int VULNERABILITY = 112;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULNERABILITY__CVE_NAME = 0;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULNERABILITY__AFFECTS = 1;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULNERABILITY__DESCRIBED_BY = 2;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULNERABILITY__CAUSES = 3;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULNERABILITY__IS_ENABLED = 4;

	/**
	 * The number of structural features of the '<em>Vulnerability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULNERABILITY_FEATURE_COUNT = 5;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = 0;

	/**
	 * The number of operations of the '<em>Vulnerability</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int VULNERABILITY_OPERATION_COUNT = 1;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2018_16843Impl <em>CVE 2018 16843</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2018_16843Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2018_16843()
	 * @generated
	 */
	int CVE_2018_16843 = 51;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16843__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16843__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16843__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16843__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16843__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2018 16843</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16843_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16843___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2018 16843</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16843_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2018_16844Impl <em>CVE 2018 16844</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2018_16844Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2018_16844()
	 * @generated
	 */
	int CVE_2018_16844 = 52;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16844__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16844__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16844__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16844__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16844__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2018 16844</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16844_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16844___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2018 16844</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16844_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2018_16845Impl <em>CVE 2018 16845</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2018_16845Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2018_16845()
	 * @generated
	 */
	int CVE_2018_16845 = 53;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16845__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16845__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16845__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16845__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16845__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2018 16845</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16845_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16845___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2018 16845</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2018_16845_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2019_9511Impl <em>CVE 2019 9511</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2019_9511Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2019_9511()
	 * @generated
	 */
	int CVE_2019_9511 = 54;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9511__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9511__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9511__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9511__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9511__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2019 9511</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9511_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9511___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2019 9511</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9511_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2019_9513Impl <em>CVE 2019 9513</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2019_9513Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2019_9513()
	 * @generated
	 */
	int CVE_2019_9513 = 55;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9513__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9513__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9513__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9513__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9513__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2019 9513</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9513_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9513___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2019 9513</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9513_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2019_9516Impl <em>CVE 2019 9516</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2019_9516Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2019_9516()
	 * @generated
	 */
	int CVE_2019_9516 = 56;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9516__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9516__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9516__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9516__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9516__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2019 9516</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9516_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9516___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2019 9516</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2019_9516_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2021_23017Impl <em>CVE 2021 23017</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2021_23017Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2021_23017()
	 * @generated
	 */
	int CVE_2021_23017 = 57;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_23017__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_23017__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_23017__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_23017__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_23017__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2021 23017</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_23017_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_23017___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2021 23017</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_23017_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2021_3618Impl <em>CVE 2021 3618</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2021_3618Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2021_3618()
	 * @generated
	 */
	int CVE_2021_3618 = 58;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_3618__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_3618__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_3618__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_3618__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_3618__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2021 3618</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_3618_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_3618___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2021 3618</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2021_3618_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2022_24834Impl <em>CVE 2022 24834</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2022_24834Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2022_24834()
	 * @generated
	 */
	int CVE_2022_24834 = 59;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_24834__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_24834__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_24834__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_24834__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_24834__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2022 24834</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_24834_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_24834___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2022 24834</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_24834_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2022_36021Impl <em>CVE 2022 36021</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2022_36021Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2022_36021()
	 * @generated
	 */
	int CVE_2022_36021 = 60;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_36021__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_36021__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_36021__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_36021__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_36021__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2022 36021</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_36021_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_36021___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2022 36021</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_36021_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2022_41862Impl <em>CVE 2022 41862</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2022_41862Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2022_41862()
	 * @generated
	 */
	int CVE_2022_41862 = 61;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_41862__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_41862__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_41862__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_41862__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_41862__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2022 41862</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_41862_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_41862___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2022 41862</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2022_41862_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2023_2455Impl <em>CVE 2023 2455</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2023_2455Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2023_2455()
	 * @generated
	 */
	int CVE_2023_2455 = 62;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_2455__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_2455__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_2455__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_2455__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_2455__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2023 2455</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_2455_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_2455___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2023 2455</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_2455_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2023_25155Impl <em>CVE 2023 25155</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2023_25155Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2023_25155()
	 * @generated
	 */
	int CVE_2023_25155 = 63;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_25155__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_25155__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_25155__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_25155__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_25155__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2023 25155</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_25155_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_25155___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2023 25155</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_25155_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2023_28856Impl <em>CVE 2023 28856</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2023_28856Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2023_28856()
	 * @generated
	 */
	int CVE_2023_28856 = 64;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_28856__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_28856__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_28856__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_28856__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_28856__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2023 28856</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_28856_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_28856___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2023 28856</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_28856_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2023_44487Impl <em>CVE 2023 44487</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2023_44487Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2023_44487()
	 * @generated
	 */
	int CVE_2023_44487 = 65;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_44487__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_44487__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_44487__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_44487__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_44487__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2023 44487</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_44487_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_44487___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2023 44487</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_44487_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2023_45145Impl <em>CVE 2023 45145</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2023_45145Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2023_45145()
	 * @generated
	 */
	int CVE_2023_45145 = 66;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_45145__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_45145__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_45145__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_45145__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_45145__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2023 45145</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_45145_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_45145___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2023 45145</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_45145_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2023_46809Impl <em>CVE 2023 46809</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2023_46809Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2023_46809()
	 * @generated
	 */
	int CVE_2023_46809 = 67;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_46809__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_46809__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_46809__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_46809__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_46809__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2023 46809</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_46809_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_46809___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2023 46809</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_46809_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2023_5870Impl <em>CVE 2023 5870</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2023_5870Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2023_5870()
	 * @generated
	 */
	int CVE_2023_5870 = 68;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_5870__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_5870__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_5870__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_5870__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_5870__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2023 5870</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_5870_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_5870___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2023 5870</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2023_5870_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_0985Impl <em>CVE 2024 0985</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_0985Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_0985()
	 * @generated
	 */
	int CVE_2024_0985 = 69;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_0985__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_0985__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_0985__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_0985__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_0985__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 0985</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_0985_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_0985___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 0985</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_0985_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_10976Impl <em>CVE 2024 10976</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_10976Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_10976()
	 * @generated
	 */
	int CVE_2024_10976 = 70;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10976__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10976__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10976__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10976__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10976__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 10976</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10976_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10976___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 10976</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10976_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_10977Impl <em>CVE 2024 10977</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_10977Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_10977()
	 * @generated
	 */
	int CVE_2024_10977 = 71;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10977__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10977__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10977__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10977__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10977__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 10977</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10977_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10977___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 10977</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10977_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_10978Impl <em>CVE 2024 10978</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_10978Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_10978()
	 * @generated
	 */
	int CVE_2024_10978 = 72;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10978__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10978__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10978__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10978__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10978__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 10978</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10978_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10978___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 10978</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10978_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_10979Impl <em>CVE 2024 10979</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_10979Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_10979()
	 * @generated
	 */
	int CVE_2024_10979 = 73;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10979__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10979__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10979__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10979__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10979__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 10979</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10979_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10979___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 10979</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_10979_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_21890Impl <em>CVE 2024 21890</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_21890Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_21890()
	 * @generated
	 */
	int CVE_2024_21890 = 74;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21890__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21890__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21890__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21890__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21890__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 21890</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21890_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21890___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 21890</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21890_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_21891Impl <em>CVE 2024 21891</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_21891Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_21891()
	 * @generated
	 */
	int CVE_2024_21891 = 75;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21891__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21891__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21891__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21891__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21891__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 21891</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21891_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21891___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 21891</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21891_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_21896Impl <em>CVE 2024 21896</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_21896Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_21896()
	 * @generated
	 */
	int CVE_2024_21896 = 76;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21896__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21896__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21896__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21896__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21896__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 21896</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21896_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21896___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 21896</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_21896_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_22017Impl <em>CVE 2024 22017</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_22017Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22017()
	 * @generated
	 */
	int CVE_2024_22017 = 77;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22017__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22017__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22017__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22017__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22017__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 22017</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22017_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22017___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 22017</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22017_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_22018Impl <em>CVE 2024 22018</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_22018Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22018()
	 * @generated
	 */
	int CVE_2024_22018 = 78;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22018__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22018__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22018__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22018__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22018__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 22018</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22018_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22018___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 22018</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22018_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_22019Impl <em>CVE 2024 22019</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_22019Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22019()
	 * @generated
	 */
	int CVE_2024_22019 = 79;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22019__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22019__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22019__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22019__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22019__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 22019</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22019_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22019___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 22019</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22019_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_22020Impl <em>CVE 2024 22020</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_22020Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22020()
	 * @generated
	 */
	int CVE_2024_22020 = 80;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22020__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22020__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22020__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22020__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22020__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 22020</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22020_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22020___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 22020</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22020_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_22025Impl <em>CVE 2024 22025</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_22025Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22025()
	 * @generated
	 */
	int CVE_2024_22025 = 81;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22025__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22025__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22025__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22025__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22025__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 22025</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22025_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22025___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 22025</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_22025_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_27980Impl <em>CVE 2024 27980</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_27980Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_27980()
	 * @generated
	 */
	int CVE_2024_27980 = 82;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27980__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27980__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27980__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27980__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27980__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 27980</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27980_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27980___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 27980</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27980_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_27983Impl <em>CVE 2024 27983</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_27983Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_27983()
	 * @generated
	 */
	int CVE_2024_27983 = 83;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27983__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27983__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27983__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27983__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27983__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 27983</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27983_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27983___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 27983</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_27983_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_31449Impl <em>CVE 2024 31449</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_31449Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_31449()
	 * @generated
	 */
	int CVE_2024_31449 = 84;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31449__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31449__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31449__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31449__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31449__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 31449</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31449_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31449___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 31449</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31449_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_31489Impl <em>CVE 2024 31489</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_31489Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_31489()
	 * @generated
	 */
	int CVE_2024_31489 = 85;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31489__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31489__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31489__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31489__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31489__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 31489</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31489_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31489___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 31489</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_31489_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_3566Impl <em>CVE 2024 3566</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_3566Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_3566()
	 * @generated
	 */
	int CVE_2024_3566 = 86;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_3566__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_3566__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_3566__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_3566__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_3566__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 3566</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_3566_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_3566___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 3566</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_3566_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_36137Impl <em>CVE 2024 36137</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_36137Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_36137()
	 * @generated
	 */
	int CVE_2024_36137 = 87;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36137__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36137__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36137__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36137__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36137__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 36137</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36137_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36137___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 36137</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36137_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_36138Impl <em>CVE 2024 36138</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_36138Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_36138()
	 * @generated
	 */
	int CVE_2024_36138 = 88;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36138__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36138__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36138__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36138__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36138__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 36138</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36138_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36138___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 36138</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_36138_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_37372Impl <em>CVE 2024 37372</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_37372Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_37372()
	 * @generated
	 */
	int CVE_2024_37372 = 89;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_37372__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_37372__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_37372__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_37372__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_37372__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 37372</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_37372_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_37372___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 37372</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_37372_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_46981Impl <em>CVE 2024 46981</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_46981Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_46981()
	 * @generated
	 */
	int CVE_2024_46981 = 90;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_46981__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_46981__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_46981__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_46981__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_46981__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 46981</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_46981_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_46981___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 46981</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_46981_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_5205Impl <em>CVE 2024 5205</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_5205Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_5205()
	 * @generated
	 */
	int CVE_2024_5205 = 91;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_5205__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_5205__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_5205__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_5205__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_5205__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 5205</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_5205_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_5205___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 5205</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_5205_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_7347Impl <em>CVE 2024 7347</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_7347Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_7347()
	 * @generated
	 */
	int CVE_2024_7347 = 92;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7347__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7347__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7347__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7347__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7347__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 7347</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7347_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7347___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 7347</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7347_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2024_7348Impl <em>CVE 2024 7348</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2024_7348Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2024_7348()
	 * @generated
	 */
	int CVE_2024_7348 = 93;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7348__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7348__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7348__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7348__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7348__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2024 7348</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7348_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7348___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2024 7348</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2024_7348_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_1094Impl <em>CVE 2025 1094</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_1094Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_1094()
	 * @generated
	 */
	int CVE_2025_1094 = 94;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_1094__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_1094__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_1094__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_1094__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_1094__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 1094</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_1094_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_1094___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 1094</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_1094_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_11187Impl <em>CVE 2025 11187</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_11187Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_11187()
	 * @generated
	 */
	int CVE_2025_11187 = 95;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_11187__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_11187__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_11187__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_11187__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_11187__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 11187</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_11187_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_11187___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 11187</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_11187_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_15468Impl <em>CVE 2025 15468</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_15468Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_15468()
	 * @generated
	 */
	int CVE_2025_15468 = 96;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_15468__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_15468__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_15468__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_15468__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_15468__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 15468</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_15468_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_15468___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 15468</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_15468_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_21605Impl <em>CVE 2025 21605</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_21605Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_21605()
	 * @generated
	 */
	int CVE_2025_21605 = 97;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_21605__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_21605__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_21605__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_21605__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_21605__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 21605</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_21605_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_21605___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 21605</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_21605_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_23084Impl <em>CVE 2025 23084</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_23084Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_23084()
	 * @generated
	 */
	int CVE_2025_23084 = 98;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23084__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23084__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23084__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23084__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23084__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 23084</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23084_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23084___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 23084</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23084_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_23090Impl <em>CVE 2025 23090</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_23090Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_23090()
	 * @generated
	 */
	int CVE_2025_23090 = 99;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23090__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23090__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23090__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23090__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23090__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 23090</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23090_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23090___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 23090</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_23090_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_32023Impl <em>CVE 2025 32023</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_32023Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_32023()
	 * @generated
	 */
	int CVE_2025_32023 = 100;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_32023__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_32023__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_32023__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_32023__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_32023__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 32023</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_32023_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_32023___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 32023</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_32023_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_62506Impl <em>CVE 2025 62506</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_62506Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_62506()
	 * @generated
	 */
	int CVE_2025_62506 = 101;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62506__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62506__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62506__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62506__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62506__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 62506</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62506_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62506___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 62506</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62506_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_62507Impl <em>CVE 2025 62507</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_62507Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_62507()
	 * @generated
	 */
	int CVE_2025_62507 = 102;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62507__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62507__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62507__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62507__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62507__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 62507</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62507_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62507___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 62507</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_62507_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_66199Impl <em>CVE 2025 66199</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_66199Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_66199()
	 * @generated
	 */
	int CVE_2025_66199 = 103;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_66199__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_66199__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_66199__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_66199__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_66199__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 66199</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_66199_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_66199___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 66199</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_66199_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_69418Impl <em>CVE 2025 69418</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_69418Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_69418()
	 * @generated
	 */
	int CVE_2025_69418 = 104;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69418__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69418__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69418__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69418__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69418__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 69418</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69418_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69418___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 69418</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69418_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_69420Impl <em>CVE 2025 69420</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_69420Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_69420()
	 * @generated
	 */
	int CVE_2025_69420 = 105;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69420__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69420__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69420__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69420__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69420__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 69420</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69420_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69420___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 69420</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69420_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2025_69421Impl <em>CVE 2025 69421</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2025_69421Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2025_69421()
	 * @generated
	 */
	int CVE_2025_69421 = 106;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69421__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69421__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69421__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69421__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69421__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2025 69421</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69421_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69421___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2025 69421</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2025_69421_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2026_22795Impl <em>CVE 2026 22795</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2026_22795Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2026_22795()
	 * @generated
	 */
	int CVE_2026_22795 = 107;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22795__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22795__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22795__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22795__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22795__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2026 22795</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22795_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22795___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2026 22795</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22795_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2026_22796Impl <em>CVE 2026 22796</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2026_22796Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2026_22796()
	 * @generated
	 */
	int CVE_2026_22796 = 108;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22796__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22796__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22796__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22796__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22796__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2026 22796</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22796_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22796___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2026 22796</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_22796_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVE_2026_27970Impl <em>CVE 2026 27970</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVE_2026_27970Impl
	 * @see CASA.impl.CASAPackageImpl#getCVE_2026_27970()
	 * @generated
	 */
	int CVE_2026_27970 = 109;

	/**
	 * The feature id for the '<em><b>Cve Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_27970__CVE_NAME = VULNERABILITY__CVE_NAME;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_27970__AFFECTS = VULNERABILITY__AFFECTS;

	/**
	 * The feature id for the '<em><b>Described By</b></em>' containment reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_27970__DESCRIBED_BY = VULNERABILITY__DESCRIBED_BY;

	/**
	 * The feature id for the '<em><b>Causes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_27970__CAUSES = VULNERABILITY__CAUSES;

	/**
	 * The feature id for the '<em><b>Is Enabled</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_27970__IS_ENABLED = VULNERABILITY__IS_ENABLED;

	/**
	 * The number of structural features of the '<em>CVE 2026 27970</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_27970_FEATURE_COUNT = VULNERABILITY_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Vulnerabilities</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_27970___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>CVE 2026 27970</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVE_2026_27970_OPERATION_COUNT = VULNERABILITY_OPERATION_COUNT + 0;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMMENTS__NAME = PSOCIAL__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMMENTS__OF_FUNCTION = PSOCIAL__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMMENTS__REQUIRES = PSOCIAL__REQUIRES;

	/**
	 * The number of structural features of the '<em>PComments</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMMENTS_FEATURE_COUNT = PSOCIAL_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMMENTS___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PSOCIAL___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PComments</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PCOMMENTS_OPERATION_COUNT = PSOCIAL_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PVideoSharingImpl <em>PVideo Sharing</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PVideoSharingImpl
	 * @see CASA.impl.CASAPackageImpl#getPVideoSharing()
	 * @generated
	 */
	int PVIDEO_SHARING = 111;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_SHARING__NAME = PCOMMENTS__NAME;

	/**
	 * The feature id for the '<em><b>Of Function</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_SHARING__OF_FUNCTION = PCOMMENTS__OF_FUNCTION;

	/**
	 * The feature id for the '<em><b>Requires</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_SHARING__REQUIRES = PCOMMENTS__REQUIRES;

	/**
	 * The number of structural features of the '<em>PVideo Sharing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_SHARING_FEATURE_COUNT = PCOMMENTS_FEATURE_COUNT + 0;

	/**
	 * The operation id for the '<em>Unique Purposes</em>' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_SHARING___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = PCOMMENTS___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP;

	/**
	 * The number of operations of the '<em>PVideo Sharing</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int PVIDEO_SHARING_OPERATION_COUNT = PCOMMENTS_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.CVSSVectorImpl <em>CVSS Vector</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.CVSSVectorImpl
	 * @see CASA.impl.CASAPackageImpl#getCVSSVector()
	 * @generated
	 */
	int CVSS_VECTOR = 113;

	/**
	 * The feature id for the '<em><b>Attack Vector</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__ATTACK_VECTOR = 0;

	/**
	 * The feature id for the '<em><b>Attack Complexity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__ATTACK_COMPLEXITY = 1;

	/**
	 * The feature id for the '<em><b>Scope</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__SCOPE = 2;

	/**
	 * The feature id for the '<em><b>Privileges Required</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__PRIVILEGES_REQUIRED = 3;

	/**
	 * The feature id for the '<em><b>User Interaction</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__USER_INTERACTION = 4;

	/**
	 * The feature id for the '<em><b>Exploit Code Maturity</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__EXPLOIT_CODE_MATURITY = 5;

	/**
	 * The feature id for the '<em><b>Report Confidence</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__REPORT_CONFIDENCE = 6;

	/**
	 * The feature id for the '<em><b>Confidentiality Impact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__CONFIDENTIALITY_IMPACT = 7;

	/**
	 * The feature id for the '<em><b>Integrity Impact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__INTEGRITY_IMPACT = 8;

	/**
	 * The feature id for the '<em><b>Availability Impact</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__AVAILABILITY_IMPACT = 9;

	/**
	 * The feature id for the '<em><b>Remediation Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__REMEDIATION_LEVEL = 10;

	/**
	 * The feature id for the '<em><b>Confidentiality Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT = 11;

	/**
	 * The feature id for the '<em><b>Integrity Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__INTEGRITY_REQUIREMENT = 12;

	/**
	 * The feature id for the '<em><b>Availability Requirement</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR__AVAILABILITY_REQUIREMENT = 13;

	/**
	 * The number of structural features of the '<em>CVSS Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR_FEATURE_COUNT = 14;

	/**
	 * The number of operations of the '<em>CVSS Vector</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int CVSS_VECTOR_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link CASA.impl.RiskImpl <em>Risk</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.RiskImpl
	 * @see CASA.impl.CASAPackageImpl#getRisk()
	 * @generated
	 */
	int RISK = 114;

	/**
	 * The feature id for the '<em><b>Level</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK__LEVEL = 0;

	/**
	 * The feature id for the '<em><b>Affects</b></em>' container reference.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK__AFFECTS = 1;

	/**
	 * The feature id for the '<em><b>Caused By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK__CAUSED_BY = 2;

	/**
	 * The number of structural features of the '<em>Risk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK_FEATURE_COUNT = 3;

	/**
	 * The number of operations of the '<em>Risk</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int RISK_OPERATION_COUNT = 0;

	/**
	 * The meta object id for the '{@link CASA.impl.SystemImpl <em>System</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.SystemImpl
	 * @see CASA.impl.CASAPackageImpl#getSystem()
	 * @generated
	 */
	int SYSTEM = 115;

	/**
	 * The feature id for the '<em><b>Functions</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__FUNCTIONS = 0;

	/**
	 * The feature id for the '<em><b>Datas</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DATAS = 1;

	/**
	 * The feature id for the '<em><b>Data Subjects</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__DATA_SUBJECTS = 2;

	/**
	 * The feature id for the '<em><b>Vulnerabilities</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__VULNERABILITIES = 3;

	/**
	 * The feature id for the '<em><b>Components</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__COMPONENTS = 4;

	/**
	 * The feature id for the '<em><b>Purposes</b></em>' containment reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM__PURPOSES = 5;

	/**
	 * The number of structural features of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_FEATURE_COUNT = 6;

	/**
	 * The number of operations of the '<em>System</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int SYSTEM_OPERATION_COUNT = 0;


	/**
	 * The meta object id for the '{@link CASA.impl.RedisComponentImpl <em>Redis Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.RedisComponentImpl
	 * @see CASA.impl.CASAPackageImpl#getRedisComponent()
	 * @generated
	 */
	int REDIS_COMPONENT = 116;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDIS_COMPONENT__REALIZES = COMPONENT__REALIZES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDIS_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDIS_COMPONENT__AFFECTED_BY = COMPONENT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>Redis Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDIS_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Redis Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int REDIS_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.FilesystemComponentImpl <em>Filesystem Component</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.FilesystemComponentImpl
	 * @see CASA.impl.CASAPackageImpl#getFilesystemComponent()
	 * @generated
	 */
	int FILESYSTEM_COMPONENT = 117;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_COMPONENT__REALIZES = COMPONENT__REALIZES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_COMPONENT__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_COMPONENT__AFFECTED_BY = COMPONENT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>Filesystem Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_COMPONENT_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Filesystem Component</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int FILESYSTEM_COMPONENT_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;

	/**
	 * The meta object id for the '{@link CASA.impl.PostgresqlImpl <em>Postgresql</em>}' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see CASA.impl.PostgresqlImpl
	 * @see CASA.impl.CASAPackageImpl#getPostgresql()
	 * @generated
	 */
	int POSTGRESQL = 118;

	/**
	 * The feature id for the '<em><b>Realizes</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTGRESQL__REALIZES = COMPONENT__REALIZES;

	/**
	 * The feature id for the '<em><b>Name</b></em>' attribute.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTGRESQL__NAME = COMPONENT__NAME;

	/**
	 * The feature id for the '<em><b>Affected By</b></em>' reference list.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTGRESQL__AFFECTED_BY = COMPONENT__AFFECTED_BY;

	/**
	 * The number of structural features of the '<em>Postgresql</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTGRESQL_FEATURE_COUNT = COMPONENT_FEATURE_COUNT + 0;

	/**
	 * The number of operations of the '<em>Postgresql</em>' class.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 * @ordered
	 */
	int POSTGRESQL_OPERATION_COUNT = COMPONENT_OPERATION_COUNT + 0;


	/**
	 * Returns the meta object for class '{@link CASA.Consent <em>Consent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Consent</em>'.
	 * @see CASA.Consent
	 * @generated
	 */
	EClass getConsent();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Consent#getForPurpose <em>For Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>For Purpose</em>'.
	 * @see CASA.Consent#getForPurpose()
	 * @see #getConsent()
	 * @generated
	 */
	EAttribute getConsent_ForPurpose();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Consent#getInformedRiskLevel <em>Informed Risk Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Informed Risk Level</em>'.
	 * @see CASA.Consent#getInformedRiskLevel()
	 * @see #getConsent()
	 * @generated
	 */
	EAttribute getConsent_InformedRiskLevel();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Consent#getGivenFor <em>Given For</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Given For</em>'.
	 * @see CASA.Consent#getGivenFor()
	 * @see #getConsent()
	 * @generated
	 */
	EReference getConsent_GivenFor();

	/**
	 * Returns the meta object for the container reference '{@link CASA.Consent#getGivenBy <em>Given By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Given By</em>'.
	 * @see CASA.Consent#getGivenBy()
	 * @see #getConsent()
	 * @generated
	 */
	EReference getConsent_GivenBy();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Consent#getForPersonalData <em>For Personal Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>For Personal Data</em>'.
	 * @see CASA.Consent#getForPersonalData()
	 * @see #getConsent()
	 * @generated
	 */
	EReference getConsent_ForPersonalData();

	/**
	 * Returns the meta object for class '{@link CASA.DataSubject <em>Data Subject</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data Subject</em>'.
	 * @see CASA.DataSubject
	 * @generated
	 */
	EClass getDataSubject();

	/**
	 * Returns the meta object for the reference list '{@link CASA.DataSubject#getIdentifiedBy <em>Identified By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Identified By</em>'.
	 * @see CASA.DataSubject#getIdentifiedBy()
	 * @see #getDataSubject()
	 * @generated
	 */
	EReference getDataSubject_IdentifiedBy();

	/**
	 * Returns the meta object for the attribute '{@link CASA.DataSubject#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see CASA.DataSubject#getName()
	 * @see #getDataSubject()
	 * @generated
	 */
	EAttribute getDataSubject_Name();

	/**
	 * Returns the meta object for the containment reference list '{@link CASA.DataSubject#getGives <em>Gives</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Gives</em>'.
	 * @see CASA.DataSubject#getGives()
	 * @see #getDataSubject()
	 * @generated
	 */
	EReference getDataSubject_Gives();

	/**
	 * Returns the meta object for the containment reference '{@link CASA.DataSubject#getAffectedBy <em>Affected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Affected By</em>'.
	 * @see CASA.DataSubject#getAffectedBy()
	 * @see #getDataSubject()
	 * @generated
	 */
	EReference getDataSubject_AffectedBy();

	/**
	 * Returns the meta object for class '{@link CASA.User <em>User</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>User</em>'.
	 * @see CASA.User
	 * @generated
	 */
	EClass getUser();

	/**
	 * Returns the meta object for class '{@link CASA.Administrator <em>Administrator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Administrator</em>'.
	 * @see CASA.Administrator
	 * @generated
	 */
	EClass getAdministrator();

	/**
	 * Returns the meta object for class '{@link CASA.Moderator <em>Moderator</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Moderator</em>'.
	 * @see CASA.Moderator
	 * @generated
	 */
	EClass getModerator();

	/**
	 * Returns the meta object for class '{@link CASA.PersonalData <em>Personal Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Personal Data</em>'.
	 * @see CASA.PersonalData
	 * @generated
	 */
	EClass getPersonalData();

	/**
	 * Returns the meta object for the reference '{@link CASA.PersonalData#getIdentifies <em>Identifies</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference '<em>Identifies</em>'.
	 * @see CASA.PersonalData#getIdentifies()
	 * @see #getPersonalData()
	 * @generated
	 */
	EReference getPersonalData_Identifies();

	/**
	 * Returns the meta object for the reference list '{@link CASA.PersonalData#getProcessedBy <em>Processed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Processed By</em>'.
	 * @see CASA.PersonalData#getProcessedBy()
	 * @see #getPersonalData()
	 * @generated
	 */
	EReference getPersonalData_ProcessedBy();

	/**
	 * Returns the meta object for the reference list '{@link CASA.PersonalData#getSubjectOfConsent <em>Subject Of Consent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Subject Of Consent</em>'.
	 * @see CASA.PersonalData#getSubjectOfConsent()
	 * @see #getPersonalData()
	 * @generated
	 */
	EReference getPersonalData_SubjectOfConsent();

	/**
	 * Returns the meta object for class '{@link CASA.Username <em>Username</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Username</em>'.
	 * @see CASA.Username
	 * @generated
	 */
	EClass getUsername();

	/**
	 * Returns the meta object for class '{@link CASA.Password <em>Password</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Password</em>'.
	 * @see CASA.Password
	 * @generated
	 */
	EClass getPassword();

	/**
	 * Returns the meta object for class '{@link CASA.EmailAddress <em>Email Address</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Email Address</em>'.
	 * @see CASA.EmailAddress
	 * @generated
	 */
	EClass getEmailAddress();

	/**
	 * Returns the meta object for class '{@link CASA.Payment <em>Payment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Payment</em>'.
	 * @see CASA.Payment
	 * @generated
	 */
	EClass getPayment();

	/**
	 * Returns the meta object for class '{@link CASA.StreamingHistory <em>Streaming History</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Streaming History</em>'.
	 * @see CASA.StreamingHistory
	 * @generated
	 */
	EClass getStreamingHistory();

	/**
	 * Returns the meta object for class '{@link CASA.TrackingCookie <em>Tracking Cookie</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Tracking Cookie</em>'.
	 * @see CASA.TrackingCookie
	 * @generated
	 */
	EClass getTrackingCookie();

	/**
	 * Returns the meta object for class '{@link CASA.VideoContent <em>Video Content</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Content</em>'.
	 * @see CASA.VideoContent
	 * @generated
	 */
	EClass getVideoContent();

	/**
	 * Returns the meta object for class '{@link CASA.VideoComment <em>Video Comment</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Comment</em>'.
	 * @see CASA.VideoComment
	 * @generated
	 */
	EClass getVideoComment();

	/**
	 * Returns the meta object for class '{@link CASA.VideoMetadata <em>Video Metadata</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Video Metadata</em>'.
	 * @see CASA.VideoMetadata
	 * @generated
	 */
	EClass getVideoMetadata();

	/**
	 * Returns the meta object for class '{@link CASA.DeviceType <em>Device Type</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Type</em>'.
	 * @see CASA.DeviceType
	 * @generated
	 */
	EClass getDeviceType();

	/**
	 * Returns the meta object for class '{@link CASA.DeviceLocation <em>Device Location</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Device Location</em>'.
	 * @see CASA.DeviceLocation
	 * @generated
	 */
	EClass getDeviceLocation();

	/**
	 * Returns the meta object for class '{@link CASA.RequestTimestamps <em>Request Timestamps</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Request Timestamps</em>'.
	 * @see CASA.RequestTimestamps
	 * @generated
	 */
	EClass getRequestTimestamps();

	/**
	 * Returns the meta object for class '{@link CASA.Data <em>Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Data</em>'.
	 * @see CASA.Data
	 * @generated
	 */
	EClass getData();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Data#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see CASA.Data#getName()
	 * @see #getData()
	 * @generated
	 */
	EAttribute getData_Name();

	/**
	 * Returns the meta object for class '{@link CASA.NonPersonalData <em>Non Personal Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Non Personal Data</em>'.
	 * @see CASA.NonPersonalData
	 * @generated
	 */
	EClass getNonPersonalData();

	/**
	 * Returns the meta object for the reference list '{@link CASA.NonPersonalData#getProcessedBy <em>Processed By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Processed By</em>'.
	 * @see CASA.NonPersonalData#getProcessedBy()
	 * @see #getNonPersonalData()
	 * @generated
	 */
	EReference getNonPersonalData_ProcessedBy();

	/**
	 * Returns the meta object for class '{@link CASA.Purpose <em>Purpose</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Purpose</em>'.
	 * @see CASA.Purpose
	 * @generated
	 */
	EClass getPurpose();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Purpose#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see CASA.Purpose#getName()
	 * @see #getPurpose()
	 * @generated
	 */
	EAttribute getPurpose_Name();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Purpose#getOfFunction <em>Of Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Of Function</em>'.
	 * @see CASA.Purpose#getOfFunction()
	 * @see #getPurpose()
	 * @generated
	 */
	EReference getPurpose_OfFunction();

	/**
	 * Returns the meta object for the '{@link CASA.Purpose#UniquePurposes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Unique Purposes</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Unique Purposes</em>' operation.
	 * @see CASA.Purpose#UniquePurposes(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getPurpose__UniquePurposes__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link CASA.Component <em>Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Component</em>'.
	 * @see CASA.Component
	 * @generated
	 */
	EClass getComponent();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Component#getRealizes <em>Realizes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realizes</em>'.
	 * @see CASA.Component#getRealizes()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_Realizes();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Component#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see CASA.Component#getName()
	 * @see #getComponent()
	 * @generated
	 */
	EAttribute getComponent_Name();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Component#getAffectedBy <em>Affected By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affected By</em>'.
	 * @see CASA.Component#getAffectedBy()
	 * @see #getComponent()
	 * @generated
	 */
	EReference getComponent_AffectedBy();

	/**
	 * Returns the meta object for class '{@link CASA.AngularSPA <em>Angular SPA</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Angular SPA</em>'.
	 * @see CASA.AngularSPA
	 * @generated
	 */
	EClass getAngularSPA();

	/**
	 * Returns the meta object for class '{@link CASA.Nginx <em>Nginx</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Nginx</em>'.
	 * @see CASA.Nginx
	 * @generated
	 */
	EClass getNginx();

	/**
	 * Returns the meta object for class '{@link CASA.ExpressJS <em>Express JS</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Express JS</em>'.
	 * @see CASA.ExpressJS
	 * @generated
	 */
	EClass getExpressJS();

	/**
	 * Returns the meta object for class '{@link CASA.Function <em>Function</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Function</em>'.
	 * @see CASA.Function
	 * @generated
	 */
	EClass getFunction();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Function#getName <em>Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Name</em>'.
	 * @see CASA.Function#getName()
	 * @see #getFunction()
	 * @generated
	 */
	EAttribute getFunction_Name();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Function#getRealizedBy <em>Realized By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Realized By</em>'.
	 * @see CASA.Function#getRealizedBy()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_RealizedBy();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Function#getProcesses <em>Processes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Processes</em>'.
	 * @see CASA.Function#getProcesses()
	 * @see #getFunction()
	 * @generated
	 */
	EReference getFunction_Processes();

	/**
	 * Returns the meta object for class '{@link CASA.FuncPersData <em>Func Pers Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Func Pers Data</em>'.
	 * @see CASA.FuncPersData
	 * @generated
	 */
	EClass getFuncPersData();

	/**
	 * Returns the meta object for the reference list '{@link CASA.FuncPersData#getProcessesPersData <em>Processes Pers Data</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Processes Pers Data</em>'.
	 * @see CASA.FuncPersData#getProcessesPersData()
	 * @see #getFuncPersData()
	 * @generated
	 */
	EReference getFuncPersData_ProcessesPersData();

	/**
	 * Returns the meta object for the reference list '{@link CASA.FuncPersData#getHas <em>Has</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Has</em>'.
	 * @see CASA.FuncPersData#getHas()
	 * @see #getFuncPersData()
	 * @generated
	 */
	EReference getFuncPersData_Has();

	/**
	 * Returns the meta object for class '{@link CASA.ServeStandardAds <em>Serve Standard Ads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serve Standard Ads</em>'.
	 * @see CASA.ServeStandardAds
	 * @generated
	 */
	EClass getServeStandardAds();

	/**
	 * Returns the meta object for class '{@link CASA.UploadVideo <em>Upload Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Upload Video</em>'.
	 * @see CASA.UploadVideo
	 * @generated
	 */
	EClass getUploadVideo();

	/**
	 * Returns the meta object for class '{@link CASA.StreamVideo <em>Stream Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Stream Video</em>'.
	 * @see CASA.StreamVideo
	 * @generated
	 */
	EClass getStreamVideo();

	/**
	 * Returns the meta object for class '{@link CASA.RemoveVideo <em>Remove Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Remove Video</em>'.
	 * @see CASA.RemoveVideo
	 * @generated
	 */
	EClass getRemoveVideo();

	/**
	 * Returns the meta object for class '{@link CASA.LiveStreamVideo <em>Live Stream Video</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Live Stream Video</em>'.
	 * @see CASA.LiveStreamVideo
	 * @generated
	 */
	EClass getLiveStreamVideo();

	/**
	 * Returns the meta object for class '{@link CASA.P2PStreaming <em>P2P Streaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>P2P Streaming</em>'.
	 * @see CASA.P2PStreaming
	 * @generated
	 */
	EClass getP2PStreaming();

	/**
	 * Returns the meta object for class '{@link CASA.RecommendVideos <em>Recommend Videos</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Recommend Videos</em>'.
	 * @see CASA.RecommendVideos
	 * @generated
	 */
	EClass getRecommendVideos();

	/**
	 * Returns the meta object for class '{@link CASA.ServeBehaviorTargetedAds <em>Serve Behavior Targeted Ads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serve Behavior Targeted Ads</em>'.
	 * @see CASA.ServeBehaviorTargetedAds
	 * @generated
	 */
	EClass getServeBehaviorTargetedAds();

	/**
	 * Returns the meta object for class '{@link CASA.CommentWriteRead <em>Comment Write Read</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Comment Write Read</em>'.
	 * @see CASA.CommentWriteRead
	 * @generated
	 */
	EClass getCommentWriteRead();

	/**
	 * Returns the meta object for class '{@link CASA.ServeLocationTargetedAds <em>Serve Location Targeted Ads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Serve Location Targeted Ads</em>'.
	 * @see CASA.ServeLocationTargetedAds
	 * @generated
	 */
	EClass getServeLocationTargetedAds();

	/**
	 * Returns the meta object for class '{@link CASA.PurposeNoConsent <em>Purpose No Consent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Purpose No Consent</em>'.
	 * @see CASA.PurposeNoConsent
	 * @generated
	 */
	EClass getPurposeNoConsent();

	/**
	 * Returns the meta object for class '{@link CASA.PurposeConsent <em>Purpose Consent</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Purpose Consent</em>'.
	 * @see CASA.PurposeConsent
	 * @generated
	 */
	EClass getPurposeConsent();

	/**
	 * Returns the meta object for the reference list '{@link CASA.PurposeConsent#getRequires <em>Requires</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Requires</em>'.
	 * @see CASA.PurposeConsent#getRequires()
	 * @see #getPurposeConsent()
	 * @generated
	 */
	EReference getPurposeConsent_Requires();

	/**
	 * Returns the meta object for class '{@link CASA.PMarketing <em>PMarketing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PMarketing</em>'.
	 * @see CASA.PMarketing
	 * @generated
	 */
	EClass getPMarketing();

	/**
	 * Returns the meta object for class '{@link CASA.PStandardAds <em>PStandard Ads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PStandard Ads</em>'.
	 * @see CASA.PStandardAds
	 * @generated
	 */
	EClass getPStandardAds();

	/**
	 * Returns the meta object for class '{@link CASA.PTargetedAds <em>PTargeted Ads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PTargeted Ads</em>'.
	 * @see CASA.PTargetedAds
	 * @generated
	 */
	EClass getPTargetedAds();

	/**
	 * Returns the meta object for class '{@link CASA.PLocationTargetedAds <em>PLocation Targeted Ads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PLocation Targeted Ads</em>'.
	 * @see CASA.PLocationTargetedAds
	 * @generated
	 */
	EClass getPLocationTargetedAds();

	/**
	 * Returns the meta object for class '{@link CASA.PBehaviorTargetedAds <em>PBehavior Targeted Ads</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PBehavior Targeted Ads</em>'.
	 * @see CASA.PBehaviorTargetedAds
	 * @generated
	 */
	EClass getPBehaviorTargetedAds();

	/**
	 * Returns the meta object for class '{@link CASA.PProfiling <em>PProfiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PProfiling</em>'.
	 * @see CASA.PProfiling
	 * @generated
	 */
	EClass getPProfiling();

	/**
	 * Returns the meta object for class '{@link CASA.PFirstPartyProfiling <em>PFirst Party Profiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PFirst Party Profiling</em>'.
	 * @see CASA.PFirstPartyProfiling
	 * @generated
	 */
	EClass getPFirstPartyProfiling();

	/**
	 * Returns the meta object for class '{@link CASA.PThirdPartyProfiling <em>PThird Party Profiling</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PThird Party Profiling</em>'.
	 * @see CASA.PThirdPartyProfiling
	 * @generated
	 */
	EClass getPThirdPartyProfiling();

	/**
	 * Returns the meta object for class '{@link CASA.PUserExperience <em>PUser Experience</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PUser Experience</em>'.
	 * @see CASA.PUserExperience
	 * @generated
	 */
	EClass getPUserExperience();

	/**
	 * Returns the meta object for class '{@link CASA.PVideoRecommendation <em>PVideo Recommendation</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PVideo Recommendation</em>'.
	 * @see CASA.PVideoRecommendation
	 * @generated
	 */
	EClass getPVideoRecommendation();

	/**
	 * Returns the meta object for class '{@link CASA.PP2PStreaming <em>PP2P Streaming</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PP2P Streaming</em>'.
	 * @see CASA.PP2PStreaming
	 * @generated
	 */
	EClass getPP2PStreaming();

	/**
	 * Returns the meta object for class '{@link CASA.PSocial <em>PSocial</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PSocial</em>'.
	 * @see CASA.PSocial
	 * @generated
	 */
	EClass getPSocial();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2018_16843 <em>CVE 2018 16843</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2018 16843</em>'.
	 * @see CASA.CVE_2018_16843
	 * @generated
	 */
	EClass getCVE_2018_16843();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2018_16844 <em>CVE 2018 16844</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2018 16844</em>'.
	 * @see CASA.CVE_2018_16844
	 * @generated
	 */
	EClass getCVE_2018_16844();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2018_16845 <em>CVE 2018 16845</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2018 16845</em>'.
	 * @see CASA.CVE_2018_16845
	 * @generated
	 */
	EClass getCVE_2018_16845();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2019_9511 <em>CVE 2019 9511</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2019 9511</em>'.
	 * @see CASA.CVE_2019_9511
	 * @generated
	 */
	EClass getCVE_2019_9511();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2019_9513 <em>CVE 2019 9513</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2019 9513</em>'.
	 * @see CASA.CVE_2019_9513
	 * @generated
	 */
	EClass getCVE_2019_9513();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2019_9516 <em>CVE 2019 9516</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2019 9516</em>'.
	 * @see CASA.CVE_2019_9516
	 * @generated
	 */
	EClass getCVE_2019_9516();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2021_23017 <em>CVE 2021 23017</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2021 23017</em>'.
	 * @see CASA.CVE_2021_23017
	 * @generated
	 */
	EClass getCVE_2021_23017();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2021_3618 <em>CVE 2021 3618</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2021 3618</em>'.
	 * @see CASA.CVE_2021_3618
	 * @generated
	 */
	EClass getCVE_2021_3618();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2022_24834 <em>CVE 2022 24834</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2022 24834</em>'.
	 * @see CASA.CVE_2022_24834
	 * @generated
	 */
	EClass getCVE_2022_24834();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2022_36021 <em>CVE 2022 36021</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2022 36021</em>'.
	 * @see CASA.CVE_2022_36021
	 * @generated
	 */
	EClass getCVE_2022_36021();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2022_41862 <em>CVE 2022 41862</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2022 41862</em>'.
	 * @see CASA.CVE_2022_41862
	 * @generated
	 */
	EClass getCVE_2022_41862();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2023_2455 <em>CVE 2023 2455</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2023 2455</em>'.
	 * @see CASA.CVE_2023_2455
	 * @generated
	 */
	EClass getCVE_2023_2455();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2023_25155 <em>CVE 2023 25155</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2023 25155</em>'.
	 * @see CASA.CVE_2023_25155
	 * @generated
	 */
	EClass getCVE_2023_25155();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2023_28856 <em>CVE 2023 28856</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2023 28856</em>'.
	 * @see CASA.CVE_2023_28856
	 * @generated
	 */
	EClass getCVE_2023_28856();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2023_44487 <em>CVE 2023 44487</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2023 44487</em>'.
	 * @see CASA.CVE_2023_44487
	 * @generated
	 */
	EClass getCVE_2023_44487();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2023_45145 <em>CVE 2023 45145</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2023 45145</em>'.
	 * @see CASA.CVE_2023_45145
	 * @generated
	 */
	EClass getCVE_2023_45145();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2023_46809 <em>CVE 2023 46809</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2023 46809</em>'.
	 * @see CASA.CVE_2023_46809
	 * @generated
	 */
	EClass getCVE_2023_46809();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2023_5870 <em>CVE 2023 5870</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2023 5870</em>'.
	 * @see CASA.CVE_2023_5870
	 * @generated
	 */
	EClass getCVE_2023_5870();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_0985 <em>CVE 2024 0985</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 0985</em>'.
	 * @see CASA.CVE_2024_0985
	 * @generated
	 */
	EClass getCVE_2024_0985();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_10976 <em>CVE 2024 10976</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 10976</em>'.
	 * @see CASA.CVE_2024_10976
	 * @generated
	 */
	EClass getCVE_2024_10976();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_10977 <em>CVE 2024 10977</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 10977</em>'.
	 * @see CASA.CVE_2024_10977
	 * @generated
	 */
	EClass getCVE_2024_10977();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_10978 <em>CVE 2024 10978</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 10978</em>'.
	 * @see CASA.CVE_2024_10978
	 * @generated
	 */
	EClass getCVE_2024_10978();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_10979 <em>CVE 2024 10979</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 10979</em>'.
	 * @see CASA.CVE_2024_10979
	 * @generated
	 */
	EClass getCVE_2024_10979();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_21890 <em>CVE 2024 21890</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 21890</em>'.
	 * @see CASA.CVE_2024_21890
	 * @generated
	 */
	EClass getCVE_2024_21890();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_21891 <em>CVE 2024 21891</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 21891</em>'.
	 * @see CASA.CVE_2024_21891
	 * @generated
	 */
	EClass getCVE_2024_21891();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_21896 <em>CVE 2024 21896</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 21896</em>'.
	 * @see CASA.CVE_2024_21896
	 * @generated
	 */
	EClass getCVE_2024_21896();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_22017 <em>CVE 2024 22017</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 22017</em>'.
	 * @see CASA.CVE_2024_22017
	 * @generated
	 */
	EClass getCVE_2024_22017();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_22018 <em>CVE 2024 22018</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 22018</em>'.
	 * @see CASA.CVE_2024_22018
	 * @generated
	 */
	EClass getCVE_2024_22018();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_22019 <em>CVE 2024 22019</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 22019</em>'.
	 * @see CASA.CVE_2024_22019
	 * @generated
	 */
	EClass getCVE_2024_22019();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_22020 <em>CVE 2024 22020</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 22020</em>'.
	 * @see CASA.CVE_2024_22020
	 * @generated
	 */
	EClass getCVE_2024_22020();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_22025 <em>CVE 2024 22025</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 22025</em>'.
	 * @see CASA.CVE_2024_22025
	 * @generated
	 */
	EClass getCVE_2024_22025();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_27980 <em>CVE 2024 27980</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 27980</em>'.
	 * @see CASA.CVE_2024_27980
	 * @generated
	 */
	EClass getCVE_2024_27980();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_27983 <em>CVE 2024 27983</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 27983</em>'.
	 * @see CASA.CVE_2024_27983
	 * @generated
	 */
	EClass getCVE_2024_27983();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_31449 <em>CVE 2024 31449</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 31449</em>'.
	 * @see CASA.CVE_2024_31449
	 * @generated
	 */
	EClass getCVE_2024_31449();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_31489 <em>CVE 2024 31489</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 31489</em>'.
	 * @see CASA.CVE_2024_31489
	 * @generated
	 */
	EClass getCVE_2024_31489();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_3566 <em>CVE 2024 3566</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 3566</em>'.
	 * @see CASA.CVE_2024_3566
	 * @generated
	 */
	EClass getCVE_2024_3566();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_36137 <em>CVE 2024 36137</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 36137</em>'.
	 * @see CASA.CVE_2024_36137
	 * @generated
	 */
	EClass getCVE_2024_36137();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_36138 <em>CVE 2024 36138</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 36138</em>'.
	 * @see CASA.CVE_2024_36138
	 * @generated
	 */
	EClass getCVE_2024_36138();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_37372 <em>CVE 2024 37372</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 37372</em>'.
	 * @see CASA.CVE_2024_37372
	 * @generated
	 */
	EClass getCVE_2024_37372();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_46981 <em>CVE 2024 46981</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 46981</em>'.
	 * @see CASA.CVE_2024_46981
	 * @generated
	 */
	EClass getCVE_2024_46981();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_5205 <em>CVE 2024 5205</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 5205</em>'.
	 * @see CASA.CVE_2024_5205
	 * @generated
	 */
	EClass getCVE_2024_5205();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_7347 <em>CVE 2024 7347</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 7347</em>'.
	 * @see CASA.CVE_2024_7347
	 * @generated
	 */
	EClass getCVE_2024_7347();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2024_7348 <em>CVE 2024 7348</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2024 7348</em>'.
	 * @see CASA.CVE_2024_7348
	 * @generated
	 */
	EClass getCVE_2024_7348();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_1094 <em>CVE 2025 1094</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 1094</em>'.
	 * @see CASA.CVE_2025_1094
	 * @generated
	 */
	EClass getCVE_2025_1094();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_11187 <em>CVE 2025 11187</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 11187</em>'.
	 * @see CASA.CVE_2025_11187
	 * @generated
	 */
	EClass getCVE_2025_11187();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_15468 <em>CVE 2025 15468</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 15468</em>'.
	 * @see CASA.CVE_2025_15468
	 * @generated
	 */
	EClass getCVE_2025_15468();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_21605 <em>CVE 2025 21605</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 21605</em>'.
	 * @see CASA.CVE_2025_21605
	 * @generated
	 */
	EClass getCVE_2025_21605();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_23084 <em>CVE 2025 23084</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 23084</em>'.
	 * @see CASA.CVE_2025_23084
	 * @generated
	 */
	EClass getCVE_2025_23084();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_23090 <em>CVE 2025 23090</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 23090</em>'.
	 * @see CASA.CVE_2025_23090
	 * @generated
	 */
	EClass getCVE_2025_23090();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_32023 <em>CVE 2025 32023</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 32023</em>'.
	 * @see CASA.CVE_2025_32023
	 * @generated
	 */
	EClass getCVE_2025_32023();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_62506 <em>CVE 2025 62506</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 62506</em>'.
	 * @see CASA.CVE_2025_62506
	 * @generated
	 */
	EClass getCVE_2025_62506();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_62507 <em>CVE 2025 62507</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 62507</em>'.
	 * @see CASA.CVE_2025_62507
	 * @generated
	 */
	EClass getCVE_2025_62507();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_66199 <em>CVE 2025 66199</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 66199</em>'.
	 * @see CASA.CVE_2025_66199
	 * @generated
	 */
	EClass getCVE_2025_66199();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_69418 <em>CVE 2025 69418</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 69418</em>'.
	 * @see CASA.CVE_2025_69418
	 * @generated
	 */
	EClass getCVE_2025_69418();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_69420 <em>CVE 2025 69420</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 69420</em>'.
	 * @see CASA.CVE_2025_69420
	 * @generated
	 */
	EClass getCVE_2025_69420();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2025_69421 <em>CVE 2025 69421</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2025 69421</em>'.
	 * @see CASA.CVE_2025_69421
	 * @generated
	 */
	EClass getCVE_2025_69421();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2026_22795 <em>CVE 2026 22795</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2026 22795</em>'.
	 * @see CASA.CVE_2026_22795
	 * @generated
	 */
	EClass getCVE_2026_22795();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2026_22796 <em>CVE 2026 22796</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2026 22796</em>'.
	 * @see CASA.CVE_2026_22796
	 * @generated
	 */
	EClass getCVE_2026_22796();

	/**
	 * Returns the meta object for class '{@link CASA.CVE_2026_27970 <em>CVE 2026 27970</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVE 2026 27970</em>'.
	 * @see CASA.CVE_2026_27970
	 * @generated
	 */
	EClass getCVE_2026_27970();

	/**
	 * Returns the meta object for class '{@link CASA.PComments <em>PComments</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PComments</em>'.
	 * @see CASA.PComments
	 * @generated
	 */
	EClass getPComments();

	/**
	 * Returns the meta object for class '{@link CASA.PVideoSharing <em>PVideo Sharing</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>PVideo Sharing</em>'.
	 * @see CASA.PVideoSharing
	 * @generated
	 */
	EClass getPVideoSharing();

	/**
	 * Returns the meta object for class '{@link CASA.Vulnerability <em>Vulnerability</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Vulnerability</em>'.
	 * @see CASA.Vulnerability
	 * @generated
	 */
	EClass getVulnerability();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Vulnerability#getCveName <em>Cve Name</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Cve Name</em>'.
	 * @see CASA.Vulnerability#getCveName()
	 * @see #getVulnerability()
	 * @generated
	 */
	EAttribute getVulnerability_CveName();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Vulnerability#getAffects <em>Affects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Affects</em>'.
	 * @see CASA.Vulnerability#getAffects()
	 * @see #getVulnerability()
	 * @generated
	 */
	EReference getVulnerability_Affects();

	/**
	 * Returns the meta object for the containment reference '{@link CASA.Vulnerability#getDescribedBy <em>Described By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference '<em>Described By</em>'.
	 * @see CASA.Vulnerability#getDescribedBy()
	 * @see #getVulnerability()
	 * @generated
	 */
	EReference getVulnerability_DescribedBy();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Vulnerability#getCauses <em>Causes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Causes</em>'.
	 * @see CASA.Vulnerability#getCauses()
	 * @see #getVulnerability()
	 * @generated
	 */
	EReference getVulnerability_Causes();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Vulnerability#isIsEnabled <em>Is Enabled</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Is Enabled</em>'.
	 * @see CASA.Vulnerability#isIsEnabled()
	 * @see #getVulnerability()
	 * @generated
	 */
	EAttribute getVulnerability_IsEnabled();

	/**
	 * Returns the meta object for the '{@link CASA.Vulnerability#UniqueVulnerabilities(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map) <em>Unique Vulnerabilities</em>}' operation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the '<em>Unique Vulnerabilities</em>' operation.
	 * @see CASA.Vulnerability#UniqueVulnerabilities(org.eclipse.emf.common.util.DiagnosticChain, java.util.Map)
	 * @generated
	 */
	EOperation getVulnerability__UniqueVulnerabilities__DiagnosticChain_Map();

	/**
	 * Returns the meta object for class '{@link CASA.CVSSVector <em>CVSS Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>CVSS Vector</em>'.
	 * @see CASA.CVSSVector
	 * @generated
	 */
	EClass getCVSSVector();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getAttackVector <em>Attack Vector</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attack Vector</em>'.
	 * @see CASA.CVSSVector#getAttackVector()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_AttackVector();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getAttackComplexity <em>Attack Complexity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Attack Complexity</em>'.
	 * @see CASA.CVSSVector#getAttackComplexity()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_AttackComplexity();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getScope <em>Scope</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Scope</em>'.
	 * @see CASA.CVSSVector#getScope()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_Scope();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getPrivilegesRequired <em>Privileges Required</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Privileges Required</em>'.
	 * @see CASA.CVSSVector#getPrivilegesRequired()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_PrivilegesRequired();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getUserInteraction <em>User Interaction</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>User Interaction</em>'.
	 * @see CASA.CVSSVector#getUserInteraction()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_UserInteraction();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getExploitCodeMaturity <em>Exploit Code Maturity</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Exploit Code Maturity</em>'.
	 * @see CASA.CVSSVector#getExploitCodeMaturity()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_ExploitCodeMaturity();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getReportConfidence <em>Report Confidence</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Report Confidence</em>'.
	 * @see CASA.CVSSVector#getReportConfidence()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_ReportConfidence();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getConfidentialityImpact <em>Confidentiality Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confidentiality Impact</em>'.
	 * @see CASA.CVSSVector#getConfidentialityImpact()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_ConfidentialityImpact();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getIntegrityImpact <em>Integrity Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integrity Impact</em>'.
	 * @see CASA.CVSSVector#getIntegrityImpact()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_IntegrityImpact();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getAvailabilityImpact <em>Availability Impact</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Availability Impact</em>'.
	 * @see CASA.CVSSVector#getAvailabilityImpact()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_AvailabilityImpact();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getRemediationLevel <em>Remediation Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Remediation Level</em>'.
	 * @see CASA.CVSSVector#getRemediationLevel()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_RemediationLevel();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getConfidentialityRequirement <em>Confidentiality Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Confidentiality Requirement</em>'.
	 * @see CASA.CVSSVector#getConfidentialityRequirement()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_ConfidentialityRequirement();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getIntegrityRequirement <em>Integrity Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Integrity Requirement</em>'.
	 * @see CASA.CVSSVector#getIntegrityRequirement()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_IntegrityRequirement();

	/**
	 * Returns the meta object for the attribute '{@link CASA.CVSSVector#getAvailabilityRequirement <em>Availability Requirement</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Availability Requirement</em>'.
	 * @see CASA.CVSSVector#getAvailabilityRequirement()
	 * @see #getCVSSVector()
	 * @generated
	 */
	EAttribute getCVSSVector_AvailabilityRequirement();

	/**
	 * Returns the meta object for class '{@link CASA.Risk <em>Risk</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Risk</em>'.
	 * @see CASA.Risk
	 * @generated
	 */
	EClass getRisk();

	/**
	 * Returns the meta object for the attribute '{@link CASA.Risk#getLevel <em>Level</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the attribute '<em>Level</em>'.
	 * @see CASA.Risk#getLevel()
	 * @see #getRisk()
	 * @generated
	 */
	EAttribute getRisk_Level();

	/**
	 * Returns the meta object for the container reference '{@link CASA.Risk#getAffects <em>Affects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the container reference '<em>Affects</em>'.
	 * @see CASA.Risk#getAffects()
	 * @see #getRisk()
	 * @generated
	 */
	EReference getRisk_Affects();

	/**
	 * Returns the meta object for the reference list '{@link CASA.Risk#getCausedBy <em>Caused By</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the reference list '<em>Caused By</em>'.
	 * @see CASA.Risk#getCausedBy()
	 * @see #getRisk()
	 * @generated
	 */
	EReference getRisk_CausedBy();

	/**
	 * Returns the meta object for class '{@link CASA.System <em>System</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>System</em>'.
	 * @see CASA.System
	 * @generated
	 */
	EClass getSystem();

	/**
	 * Returns the meta object for the containment reference list '{@link CASA.System#getFunctions <em>Functions</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Functions</em>'.
	 * @see CASA.System#getFunctions()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Functions();

	/**
	 * Returns the meta object for the containment reference list '{@link CASA.System#getDatas <em>Datas</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Datas</em>'.
	 * @see CASA.System#getDatas()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Datas();

	/**
	 * Returns the meta object for the containment reference list '{@link CASA.System#getDataSubjects <em>Data Subjects</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Data Subjects</em>'.
	 * @see CASA.System#getDataSubjects()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_DataSubjects();

	/**
	 * Returns the meta object for the containment reference list '{@link CASA.System#getVulnerabilities <em>Vulnerabilities</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Vulnerabilities</em>'.
	 * @see CASA.System#getVulnerabilities()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Vulnerabilities();

	/**
	 * Returns the meta object for the containment reference list '{@link CASA.System#getComponents <em>Components</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Components</em>'.
	 * @see CASA.System#getComponents()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Components();

	/**
	 * Returns the meta object for the containment reference list '{@link CASA.System#getPurposes <em>Purposes</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for the containment reference list '<em>Purposes</em>'.
	 * @see CASA.System#getPurposes()
	 * @see #getSystem()
	 * @generated
	 */
	EReference getSystem_Purposes();

	/**
	 * Returns the meta object for class '{@link CASA.RedisComponent <em>Redis Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Redis Component</em>'.
	 * @see CASA.RedisComponent
	 * @generated
	 */
	EClass getRedisComponent();

	/**
	 * Returns the meta object for class '{@link CASA.FilesystemComponent <em>Filesystem Component</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Filesystem Component</em>'.
	 * @see CASA.FilesystemComponent
	 * @generated
	 */
	EClass getFilesystemComponent();

	/**
	 * Returns the meta object for class '{@link CASA.Postgresql <em>Postgresql</em>}'.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the meta object for class '<em>Postgresql</em>'.
	 * @see CASA.Postgresql
	 * @generated
	 */
	EClass getPostgresql();

	/**
	 * Returns the factory that creates the instances of the model.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @return the factory that creates the instances of the model.
	 * @generated
	 */
	CASAFactory getCASAFactory();

	/**
	 * <!-- begin-user-doc -->
	 * Defines literals for the meta objects that represent
	 * <ul>
	 *   <li>each class,</li>
	 *   <li>each feature of each class,</li>
	 *   <li>each operation of each class,</li>
	 *   <li>each enum,</li>
	 *   <li>and each data type</li>
	 * </ul>
	 * <!-- end-user-doc -->
	 * @generated
	 */
	interface Literals {
		/**
		 * The meta object literal for the '{@link CASA.impl.ConsentImpl <em>Consent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.ConsentImpl
		 * @see CASA.impl.CASAPackageImpl#getConsent()
		 * @generated
		 */
		EClass CONSENT = eINSTANCE.getConsent();

		/**
		 * The meta object literal for the '<em><b>For Purpose</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSENT__FOR_PURPOSE = eINSTANCE.getConsent_ForPurpose();

		/**
		 * The meta object literal for the '<em><b>Informed Risk Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CONSENT__INFORMED_RISK_LEVEL = eINSTANCE.getConsent_InformedRiskLevel();

		/**
		 * The meta object literal for the '<em><b>Given For</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT__GIVEN_FOR = eINSTANCE.getConsent_GivenFor();

		/**
		 * The meta object literal for the '<em><b>Given By</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT__GIVEN_BY = eINSTANCE.getConsent_GivenBy();

		/**
		 * The meta object literal for the '<em><b>For Personal Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference CONSENT__FOR_PERSONAL_DATA = eINSTANCE.getConsent_ForPersonalData();

		/**
		 * The meta object literal for the '{@link CASA.impl.DataSubjectImpl <em>Data Subject</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.DataSubjectImpl
		 * @see CASA.impl.CASAPackageImpl#getDataSubject()
		 * @generated
		 */
		EClass DATA_SUBJECT = eINSTANCE.getDataSubject();

		/**
		 * The meta object literal for the '<em><b>Identified By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SUBJECT__IDENTIFIED_BY = eINSTANCE.getDataSubject_IdentifiedBy();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA_SUBJECT__NAME = eINSTANCE.getDataSubject_Name();

		/**
		 * The meta object literal for the '<em><b>Gives</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SUBJECT__GIVES = eINSTANCE.getDataSubject_Gives();

		/**
		 * The meta object literal for the '<em><b>Affected By</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference DATA_SUBJECT__AFFECTED_BY = eINSTANCE.getDataSubject_AffectedBy();

		/**
		 * The meta object literal for the '{@link CASA.impl.UserImpl <em>User</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.UserImpl
		 * @see CASA.impl.CASAPackageImpl#getUser()
		 * @generated
		 */
		EClass USER = eINSTANCE.getUser();

		/**
		 * The meta object literal for the '{@link CASA.impl.AdministratorImpl <em>Administrator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.AdministratorImpl
		 * @see CASA.impl.CASAPackageImpl#getAdministrator()
		 * @generated
		 */
		EClass ADMINISTRATOR = eINSTANCE.getAdministrator();

		/**
		 * The meta object literal for the '{@link CASA.impl.ModeratorImpl <em>Moderator</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.ModeratorImpl
		 * @see CASA.impl.CASAPackageImpl#getModerator()
		 * @generated
		 */
		EClass MODERATOR = eINSTANCE.getModerator();

		/**
		 * The meta object literal for the '{@link CASA.impl.PersonalDataImpl <em>Personal Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PersonalDataImpl
		 * @see CASA.impl.CASAPackageImpl#getPersonalData()
		 * @generated
		 */
		EClass PERSONAL_DATA = eINSTANCE.getPersonalData();

		/**
		 * The meta object literal for the '<em><b>Identifies</b></em>' reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONAL_DATA__IDENTIFIES = eINSTANCE.getPersonalData_Identifies();

		/**
		 * The meta object literal for the '<em><b>Processed By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONAL_DATA__PROCESSED_BY = eINSTANCE.getPersonalData_ProcessedBy();

		/**
		 * The meta object literal for the '<em><b>Subject Of Consent</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PERSONAL_DATA__SUBJECT_OF_CONSENT = eINSTANCE.getPersonalData_SubjectOfConsent();

		/**
		 * The meta object literal for the '{@link CASA.impl.UsernameImpl <em>Username</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.UsernameImpl
		 * @see CASA.impl.CASAPackageImpl#getUsername()
		 * @generated
		 */
		EClass USERNAME = eINSTANCE.getUsername();

		/**
		 * The meta object literal for the '{@link CASA.impl.PasswordImpl <em>Password</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PasswordImpl
		 * @see CASA.impl.CASAPackageImpl#getPassword()
		 * @generated
		 */
		EClass PASSWORD = eINSTANCE.getPassword();

		/**
		 * The meta object literal for the '{@link CASA.impl.EmailAddressImpl <em>Email Address</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.EmailAddressImpl
		 * @see CASA.impl.CASAPackageImpl#getEmailAddress()
		 * @generated
		 */
		EClass EMAIL_ADDRESS = eINSTANCE.getEmailAddress();

		/**
		 * The meta object literal for the '{@link CASA.impl.PaymentImpl <em>Payment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PaymentImpl
		 * @see CASA.impl.CASAPackageImpl#getPayment()
		 * @generated
		 */
		EClass PAYMENT = eINSTANCE.getPayment();

		/**
		 * The meta object literal for the '{@link CASA.impl.StreamingHistoryImpl <em>Streaming History</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.StreamingHistoryImpl
		 * @see CASA.impl.CASAPackageImpl#getStreamingHistory()
		 * @generated
		 */
		EClass STREAMING_HISTORY = eINSTANCE.getStreamingHistory();

		/**
		 * The meta object literal for the '{@link CASA.impl.TrackingCookieImpl <em>Tracking Cookie</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.TrackingCookieImpl
		 * @see CASA.impl.CASAPackageImpl#getTrackingCookie()
		 * @generated
		 */
		EClass TRACKING_COOKIE = eINSTANCE.getTrackingCookie();

		/**
		 * The meta object literal for the '{@link CASA.impl.VideoContentImpl <em>Video Content</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.VideoContentImpl
		 * @see CASA.impl.CASAPackageImpl#getVideoContent()
		 * @generated
		 */
		EClass VIDEO_CONTENT = eINSTANCE.getVideoContent();

		/**
		 * The meta object literal for the '{@link CASA.impl.VideoCommentImpl <em>Video Comment</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.VideoCommentImpl
		 * @see CASA.impl.CASAPackageImpl#getVideoComment()
		 * @generated
		 */
		EClass VIDEO_COMMENT = eINSTANCE.getVideoComment();

		/**
		 * The meta object literal for the '{@link CASA.impl.VideoMetadataImpl <em>Video Metadata</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.VideoMetadataImpl
		 * @see CASA.impl.CASAPackageImpl#getVideoMetadata()
		 * @generated
		 */
		EClass VIDEO_METADATA = eINSTANCE.getVideoMetadata();

		/**
		 * The meta object literal for the '{@link CASA.impl.DeviceTypeImpl <em>Device Type</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.DeviceTypeImpl
		 * @see CASA.impl.CASAPackageImpl#getDeviceType()
		 * @generated
		 */
		EClass DEVICE_TYPE = eINSTANCE.getDeviceType();

		/**
		 * The meta object literal for the '{@link CASA.impl.DeviceLocationImpl <em>Device Location</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.DeviceLocationImpl
		 * @see CASA.impl.CASAPackageImpl#getDeviceLocation()
		 * @generated
		 */
		EClass DEVICE_LOCATION = eINSTANCE.getDeviceLocation();

		/**
		 * The meta object literal for the '{@link CASA.impl.RequestTimestampsImpl <em>Request Timestamps</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.RequestTimestampsImpl
		 * @see CASA.impl.CASAPackageImpl#getRequestTimestamps()
		 * @generated
		 */
		EClass REQUEST_TIMESTAMPS = eINSTANCE.getRequestTimestamps();

		/**
		 * The meta object literal for the '{@link CASA.impl.DataImpl <em>Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.DataImpl
		 * @see CASA.impl.CASAPackageImpl#getData()
		 * @generated
		 */
		EClass DATA = eINSTANCE.getData();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute DATA__NAME = eINSTANCE.getData_Name();

		/**
		 * The meta object literal for the '{@link CASA.impl.NonPersonalDataImpl <em>Non Personal Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.NonPersonalDataImpl
		 * @see CASA.impl.CASAPackageImpl#getNonPersonalData()
		 * @generated
		 */
		EClass NON_PERSONAL_DATA = eINSTANCE.getNonPersonalData();

		/**
		 * The meta object literal for the '<em><b>Processed By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference NON_PERSONAL_DATA__PROCESSED_BY = eINSTANCE.getNonPersonalData_ProcessedBy();

		/**
		 * The meta object literal for the '{@link CASA.impl.PurposeImpl <em>Purpose</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PurposeImpl
		 * @see CASA.impl.CASAPackageImpl#getPurpose()
		 * @generated
		 */
		EClass PURPOSE = eINSTANCE.getPurpose();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute PURPOSE__NAME = eINSTANCE.getPurpose_Name();

		/**
		 * The meta object literal for the '<em><b>Of Function</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PURPOSE__OF_FUNCTION = eINSTANCE.getPurpose_OfFunction();

		/**
		 * The meta object literal for the '<em><b>Unique Purposes</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation PURPOSE___UNIQUE_PURPOSES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getPurpose__UniquePurposes__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link CASA.impl.ComponentImpl <em>Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.ComponentImpl
		 * @see CASA.impl.CASAPackageImpl#getComponent()
		 * @generated
		 */
		EClass COMPONENT = eINSTANCE.getComponent();

		/**
		 * The meta object literal for the '<em><b>Realizes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__REALIZES = eINSTANCE.getComponent_Realizes();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute COMPONENT__NAME = eINSTANCE.getComponent_Name();

		/**
		 * The meta object literal for the '<em><b>Affected By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference COMPONENT__AFFECTED_BY = eINSTANCE.getComponent_AffectedBy();

		/**
		 * The meta object literal for the '{@link CASA.impl.AngularSPAImpl <em>Angular SPA</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.AngularSPAImpl
		 * @see CASA.impl.CASAPackageImpl#getAngularSPA()
		 * @generated
		 */
		EClass ANGULAR_SPA = eINSTANCE.getAngularSPA();

		/**
		 * The meta object literal for the '{@link CASA.impl.NginxImpl <em>Nginx</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.NginxImpl
		 * @see CASA.impl.CASAPackageImpl#getNginx()
		 * @generated
		 */
		EClass NGINX = eINSTANCE.getNginx();

		/**
		 * The meta object literal for the '{@link CASA.impl.ExpressJSImpl <em>Express JS</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.ExpressJSImpl
		 * @see CASA.impl.CASAPackageImpl#getExpressJS()
		 * @generated
		 */
		EClass EXPRESS_JS = eINSTANCE.getExpressJS();

		/**
		 * The meta object literal for the '{@link CASA.impl.FunctionImpl <em>Function</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.FunctionImpl
		 * @see CASA.impl.CASAPackageImpl#getFunction()
		 * @generated
		 */
		EClass FUNCTION = eINSTANCE.getFunction();

		/**
		 * The meta object literal for the '<em><b>Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute FUNCTION__NAME = eINSTANCE.getFunction_Name();

		/**
		 * The meta object literal for the '<em><b>Realized By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__REALIZED_BY = eINSTANCE.getFunction_RealizedBy();

		/**
		 * The meta object literal for the '<em><b>Processes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNCTION__PROCESSES = eINSTANCE.getFunction_Processes();

		/**
		 * The meta object literal for the '{@link CASA.impl.FuncPersDataImpl <em>Func Pers Data</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.FuncPersDataImpl
		 * @see CASA.impl.CASAPackageImpl#getFuncPersData()
		 * @generated
		 */
		EClass FUNC_PERS_DATA = eINSTANCE.getFuncPersData();

		/**
		 * The meta object literal for the '<em><b>Processes Pers Data</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC_PERS_DATA__PROCESSES_PERS_DATA = eINSTANCE.getFuncPersData_ProcessesPersData();

		/**
		 * The meta object literal for the '<em><b>Has</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference FUNC_PERS_DATA__HAS = eINSTANCE.getFuncPersData_Has();

		/**
		 * The meta object literal for the '{@link CASA.impl.ServeStandardAdsImpl <em>Serve Standard Ads</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.ServeStandardAdsImpl
		 * @see CASA.impl.CASAPackageImpl#getServeStandardAds()
		 * @generated
		 */
		EClass SERVE_STANDARD_ADS = eINSTANCE.getServeStandardAds();

		/**
		 * The meta object literal for the '{@link CASA.impl.UploadVideoImpl <em>Upload Video</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.UploadVideoImpl
		 * @see CASA.impl.CASAPackageImpl#getUploadVideo()
		 * @generated
		 */
		EClass UPLOAD_VIDEO = eINSTANCE.getUploadVideo();

		/**
		 * The meta object literal for the '{@link CASA.impl.StreamVideoImpl <em>Stream Video</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.StreamVideoImpl
		 * @see CASA.impl.CASAPackageImpl#getStreamVideo()
		 * @generated
		 */
		EClass STREAM_VIDEO = eINSTANCE.getStreamVideo();

		/**
		 * The meta object literal for the '{@link CASA.impl.RemoveVideoImpl <em>Remove Video</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.RemoveVideoImpl
		 * @see CASA.impl.CASAPackageImpl#getRemoveVideo()
		 * @generated
		 */
		EClass REMOVE_VIDEO = eINSTANCE.getRemoveVideo();

		/**
		 * The meta object literal for the '{@link CASA.impl.LiveStreamVideoImpl <em>Live Stream Video</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.LiveStreamVideoImpl
		 * @see CASA.impl.CASAPackageImpl#getLiveStreamVideo()
		 * @generated
		 */
		EClass LIVE_STREAM_VIDEO = eINSTANCE.getLiveStreamVideo();

		/**
		 * The meta object literal for the '{@link CASA.impl.P2PStreamingImpl <em>P2P Streaming</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.P2PStreamingImpl
		 * @see CASA.impl.CASAPackageImpl#getP2PStreaming()
		 * @generated
		 */
		EClass P2P_STREAMING = eINSTANCE.getP2PStreaming();

		/**
		 * The meta object literal for the '{@link CASA.impl.RecommendVideosImpl <em>Recommend Videos</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.RecommendVideosImpl
		 * @see CASA.impl.CASAPackageImpl#getRecommendVideos()
		 * @generated
		 */
		EClass RECOMMEND_VIDEOS = eINSTANCE.getRecommendVideos();

		/**
		 * The meta object literal for the '{@link CASA.impl.ServeBehaviorTargetedAdsImpl <em>Serve Behavior Targeted Ads</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.ServeBehaviorTargetedAdsImpl
		 * @see CASA.impl.CASAPackageImpl#getServeBehaviorTargetedAds()
		 * @generated
		 */
		EClass SERVE_BEHAVIOR_TARGETED_ADS = eINSTANCE.getServeBehaviorTargetedAds();

		/**
		 * The meta object literal for the '{@link CASA.impl.CommentWriteReadImpl <em>Comment Write Read</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CommentWriteReadImpl
		 * @see CASA.impl.CASAPackageImpl#getCommentWriteRead()
		 * @generated
		 */
		EClass COMMENT_WRITE_READ = eINSTANCE.getCommentWriteRead();

		/**
		 * The meta object literal for the '{@link CASA.impl.ServeLocationTargetedAdsImpl <em>Serve Location Targeted Ads</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.ServeLocationTargetedAdsImpl
		 * @see CASA.impl.CASAPackageImpl#getServeLocationTargetedAds()
		 * @generated
		 */
		EClass SERVE_LOCATION_TARGETED_ADS = eINSTANCE.getServeLocationTargetedAds();

		/**
		 * The meta object literal for the '{@link CASA.impl.PurposeNoConsentImpl <em>Purpose No Consent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PurposeNoConsentImpl
		 * @see CASA.impl.CASAPackageImpl#getPurposeNoConsent()
		 * @generated
		 */
		EClass PURPOSE_NO_CONSENT = eINSTANCE.getPurposeNoConsent();

		/**
		 * The meta object literal for the '{@link CASA.impl.PurposeConsentImpl <em>Purpose Consent</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PurposeConsentImpl
		 * @see CASA.impl.CASAPackageImpl#getPurposeConsent()
		 * @generated
		 */
		EClass PURPOSE_CONSENT = eINSTANCE.getPurposeConsent();

		/**
		 * The meta object literal for the '<em><b>Requires</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference PURPOSE_CONSENT__REQUIRES = eINSTANCE.getPurposeConsent_Requires();

		/**
		 * The meta object literal for the '{@link CASA.impl.PMarketingImpl <em>PMarketing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PMarketingImpl
		 * @see CASA.impl.CASAPackageImpl#getPMarketing()
		 * @generated
		 */
		EClass PMARKETING = eINSTANCE.getPMarketing();

		/**
		 * The meta object literal for the '{@link CASA.impl.PStandardAdsImpl <em>PStandard Ads</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PStandardAdsImpl
		 * @see CASA.impl.CASAPackageImpl#getPStandardAds()
		 * @generated
		 */
		EClass PSTANDARD_ADS = eINSTANCE.getPStandardAds();

		/**
		 * The meta object literal for the '{@link CASA.impl.PTargetedAdsImpl <em>PTargeted Ads</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PTargetedAdsImpl
		 * @see CASA.impl.CASAPackageImpl#getPTargetedAds()
		 * @generated
		 */
		EClass PTARGETED_ADS = eINSTANCE.getPTargetedAds();

		/**
		 * The meta object literal for the '{@link CASA.impl.PLocationTargetedAdsImpl <em>PLocation Targeted Ads</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PLocationTargetedAdsImpl
		 * @see CASA.impl.CASAPackageImpl#getPLocationTargetedAds()
		 * @generated
		 */
		EClass PLOCATION_TARGETED_ADS = eINSTANCE.getPLocationTargetedAds();

		/**
		 * The meta object literal for the '{@link CASA.impl.PBehaviorTargetedAdsImpl <em>PBehavior Targeted Ads</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PBehaviorTargetedAdsImpl
		 * @see CASA.impl.CASAPackageImpl#getPBehaviorTargetedAds()
		 * @generated
		 */
		EClass PBEHAVIOR_TARGETED_ADS = eINSTANCE.getPBehaviorTargetedAds();

		/**
		 * The meta object literal for the '{@link CASA.impl.PProfilingImpl <em>PProfiling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PProfilingImpl
		 * @see CASA.impl.CASAPackageImpl#getPProfiling()
		 * @generated
		 */
		EClass PPROFILING = eINSTANCE.getPProfiling();

		/**
		 * The meta object literal for the '{@link CASA.impl.PFirstPartyProfilingImpl <em>PFirst Party Profiling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PFirstPartyProfilingImpl
		 * @see CASA.impl.CASAPackageImpl#getPFirstPartyProfiling()
		 * @generated
		 */
		EClass PFIRST_PARTY_PROFILING = eINSTANCE.getPFirstPartyProfiling();

		/**
		 * The meta object literal for the '{@link CASA.impl.PThirdPartyProfilingImpl <em>PThird Party Profiling</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PThirdPartyProfilingImpl
		 * @see CASA.impl.CASAPackageImpl#getPThirdPartyProfiling()
		 * @generated
		 */
		EClass PTHIRD_PARTY_PROFILING = eINSTANCE.getPThirdPartyProfiling();

		/**
		 * The meta object literal for the '{@link CASA.impl.PUserExperienceImpl <em>PUser Experience</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PUserExperienceImpl
		 * @see CASA.impl.CASAPackageImpl#getPUserExperience()
		 * @generated
		 */
		EClass PUSER_EXPERIENCE = eINSTANCE.getPUserExperience();

		/**
		 * The meta object literal for the '{@link CASA.impl.PVideoRecommendationImpl <em>PVideo Recommendation</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PVideoRecommendationImpl
		 * @see CASA.impl.CASAPackageImpl#getPVideoRecommendation()
		 * @generated
		 */
		EClass PVIDEO_RECOMMENDATION = eINSTANCE.getPVideoRecommendation();

		/**
		 * The meta object literal for the '{@link CASA.impl.PP2PStreamingImpl <em>PP2P Streaming</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PP2PStreamingImpl
		 * @see CASA.impl.CASAPackageImpl#getPP2PStreaming()
		 * @generated
		 */
		EClass PP2P_STREAMING = eINSTANCE.getPP2PStreaming();

		/**
		 * The meta object literal for the '{@link CASA.impl.PSocialImpl <em>PSocial</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PSocialImpl
		 * @see CASA.impl.CASAPackageImpl#getPSocial()
		 * @generated
		 */
		EClass PSOCIAL = eINSTANCE.getPSocial();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2018_16843Impl <em>CVE 2018 16843</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2018_16843Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2018_16843()
		 * @generated
		 */
		EClass CVE_2018_16843 = eINSTANCE.getCVE_2018_16843();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2018_16844Impl <em>CVE 2018 16844</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2018_16844Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2018_16844()
		 * @generated
		 */
		EClass CVE_2018_16844 = eINSTANCE.getCVE_2018_16844();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2018_16845Impl <em>CVE 2018 16845</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2018_16845Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2018_16845()
		 * @generated
		 */
		EClass CVE_2018_16845 = eINSTANCE.getCVE_2018_16845();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2019_9511Impl <em>CVE 2019 9511</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2019_9511Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2019_9511()
		 * @generated
		 */
		EClass CVE_2019_9511 = eINSTANCE.getCVE_2019_9511();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2019_9513Impl <em>CVE 2019 9513</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2019_9513Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2019_9513()
		 * @generated
		 */
		EClass CVE_2019_9513 = eINSTANCE.getCVE_2019_9513();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2019_9516Impl <em>CVE 2019 9516</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2019_9516Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2019_9516()
		 * @generated
		 */
		EClass CVE_2019_9516 = eINSTANCE.getCVE_2019_9516();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2021_23017Impl <em>CVE 2021 23017</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2021_23017Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2021_23017()
		 * @generated
		 */
		EClass CVE_2021_23017 = eINSTANCE.getCVE_2021_23017();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2021_3618Impl <em>CVE 2021 3618</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2021_3618Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2021_3618()
		 * @generated
		 */
		EClass CVE_2021_3618 = eINSTANCE.getCVE_2021_3618();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2022_24834Impl <em>CVE 2022 24834</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2022_24834Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2022_24834()
		 * @generated
		 */
		EClass CVE_2022_24834 = eINSTANCE.getCVE_2022_24834();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2022_36021Impl <em>CVE 2022 36021</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2022_36021Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2022_36021()
		 * @generated
		 */
		EClass CVE_2022_36021 = eINSTANCE.getCVE_2022_36021();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2022_41862Impl <em>CVE 2022 41862</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2022_41862Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2022_41862()
		 * @generated
		 */
		EClass CVE_2022_41862 = eINSTANCE.getCVE_2022_41862();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2023_2455Impl <em>CVE 2023 2455</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2023_2455Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2023_2455()
		 * @generated
		 */
		EClass CVE_2023_2455 = eINSTANCE.getCVE_2023_2455();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2023_25155Impl <em>CVE 2023 25155</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2023_25155Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2023_25155()
		 * @generated
		 */
		EClass CVE_2023_25155 = eINSTANCE.getCVE_2023_25155();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2023_28856Impl <em>CVE 2023 28856</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2023_28856Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2023_28856()
		 * @generated
		 */
		EClass CVE_2023_28856 = eINSTANCE.getCVE_2023_28856();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2023_44487Impl <em>CVE 2023 44487</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2023_44487Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2023_44487()
		 * @generated
		 */
		EClass CVE_2023_44487 = eINSTANCE.getCVE_2023_44487();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2023_45145Impl <em>CVE 2023 45145</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2023_45145Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2023_45145()
		 * @generated
		 */
		EClass CVE_2023_45145 = eINSTANCE.getCVE_2023_45145();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2023_46809Impl <em>CVE 2023 46809</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2023_46809Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2023_46809()
		 * @generated
		 */
		EClass CVE_2023_46809 = eINSTANCE.getCVE_2023_46809();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2023_5870Impl <em>CVE 2023 5870</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2023_5870Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2023_5870()
		 * @generated
		 */
		EClass CVE_2023_5870 = eINSTANCE.getCVE_2023_5870();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_0985Impl <em>CVE 2024 0985</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_0985Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_0985()
		 * @generated
		 */
		EClass CVE_2024_0985 = eINSTANCE.getCVE_2024_0985();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_10976Impl <em>CVE 2024 10976</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_10976Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_10976()
		 * @generated
		 */
		EClass CVE_2024_10976 = eINSTANCE.getCVE_2024_10976();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_10977Impl <em>CVE 2024 10977</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_10977Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_10977()
		 * @generated
		 */
		EClass CVE_2024_10977 = eINSTANCE.getCVE_2024_10977();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_10978Impl <em>CVE 2024 10978</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_10978Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_10978()
		 * @generated
		 */
		EClass CVE_2024_10978 = eINSTANCE.getCVE_2024_10978();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_10979Impl <em>CVE 2024 10979</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_10979Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_10979()
		 * @generated
		 */
		EClass CVE_2024_10979 = eINSTANCE.getCVE_2024_10979();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_21890Impl <em>CVE 2024 21890</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_21890Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_21890()
		 * @generated
		 */
		EClass CVE_2024_21890 = eINSTANCE.getCVE_2024_21890();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_21891Impl <em>CVE 2024 21891</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_21891Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_21891()
		 * @generated
		 */
		EClass CVE_2024_21891 = eINSTANCE.getCVE_2024_21891();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_21896Impl <em>CVE 2024 21896</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_21896Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_21896()
		 * @generated
		 */
		EClass CVE_2024_21896 = eINSTANCE.getCVE_2024_21896();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_22017Impl <em>CVE 2024 22017</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_22017Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22017()
		 * @generated
		 */
		EClass CVE_2024_22017 = eINSTANCE.getCVE_2024_22017();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_22018Impl <em>CVE 2024 22018</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_22018Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22018()
		 * @generated
		 */
		EClass CVE_2024_22018 = eINSTANCE.getCVE_2024_22018();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_22019Impl <em>CVE 2024 22019</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_22019Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22019()
		 * @generated
		 */
		EClass CVE_2024_22019 = eINSTANCE.getCVE_2024_22019();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_22020Impl <em>CVE 2024 22020</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_22020Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22020()
		 * @generated
		 */
		EClass CVE_2024_22020 = eINSTANCE.getCVE_2024_22020();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_22025Impl <em>CVE 2024 22025</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_22025Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_22025()
		 * @generated
		 */
		EClass CVE_2024_22025 = eINSTANCE.getCVE_2024_22025();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_27980Impl <em>CVE 2024 27980</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_27980Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_27980()
		 * @generated
		 */
		EClass CVE_2024_27980 = eINSTANCE.getCVE_2024_27980();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_27983Impl <em>CVE 2024 27983</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_27983Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_27983()
		 * @generated
		 */
		EClass CVE_2024_27983 = eINSTANCE.getCVE_2024_27983();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_31449Impl <em>CVE 2024 31449</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_31449Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_31449()
		 * @generated
		 */
		EClass CVE_2024_31449 = eINSTANCE.getCVE_2024_31449();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_31489Impl <em>CVE 2024 31489</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_31489Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_31489()
		 * @generated
		 */
		EClass CVE_2024_31489 = eINSTANCE.getCVE_2024_31489();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_3566Impl <em>CVE 2024 3566</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_3566Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_3566()
		 * @generated
		 */
		EClass CVE_2024_3566 = eINSTANCE.getCVE_2024_3566();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_36137Impl <em>CVE 2024 36137</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_36137Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_36137()
		 * @generated
		 */
		EClass CVE_2024_36137 = eINSTANCE.getCVE_2024_36137();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_36138Impl <em>CVE 2024 36138</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_36138Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_36138()
		 * @generated
		 */
		EClass CVE_2024_36138 = eINSTANCE.getCVE_2024_36138();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_37372Impl <em>CVE 2024 37372</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_37372Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_37372()
		 * @generated
		 */
		EClass CVE_2024_37372 = eINSTANCE.getCVE_2024_37372();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_46981Impl <em>CVE 2024 46981</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_46981Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_46981()
		 * @generated
		 */
		EClass CVE_2024_46981 = eINSTANCE.getCVE_2024_46981();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_5205Impl <em>CVE 2024 5205</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_5205Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_5205()
		 * @generated
		 */
		EClass CVE_2024_5205 = eINSTANCE.getCVE_2024_5205();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_7347Impl <em>CVE 2024 7347</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_7347Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_7347()
		 * @generated
		 */
		EClass CVE_2024_7347 = eINSTANCE.getCVE_2024_7347();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2024_7348Impl <em>CVE 2024 7348</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2024_7348Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2024_7348()
		 * @generated
		 */
		EClass CVE_2024_7348 = eINSTANCE.getCVE_2024_7348();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_1094Impl <em>CVE 2025 1094</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_1094Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_1094()
		 * @generated
		 */
		EClass CVE_2025_1094 = eINSTANCE.getCVE_2025_1094();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_11187Impl <em>CVE 2025 11187</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_11187Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_11187()
		 * @generated
		 */
		EClass CVE_2025_11187 = eINSTANCE.getCVE_2025_11187();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_15468Impl <em>CVE 2025 15468</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_15468Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_15468()
		 * @generated
		 */
		EClass CVE_2025_15468 = eINSTANCE.getCVE_2025_15468();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_21605Impl <em>CVE 2025 21605</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_21605Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_21605()
		 * @generated
		 */
		EClass CVE_2025_21605 = eINSTANCE.getCVE_2025_21605();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_23084Impl <em>CVE 2025 23084</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_23084Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_23084()
		 * @generated
		 */
		EClass CVE_2025_23084 = eINSTANCE.getCVE_2025_23084();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_23090Impl <em>CVE 2025 23090</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_23090Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_23090()
		 * @generated
		 */
		EClass CVE_2025_23090 = eINSTANCE.getCVE_2025_23090();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_32023Impl <em>CVE 2025 32023</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_32023Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_32023()
		 * @generated
		 */
		EClass CVE_2025_32023 = eINSTANCE.getCVE_2025_32023();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_62506Impl <em>CVE 2025 62506</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_62506Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_62506()
		 * @generated
		 */
		EClass CVE_2025_62506 = eINSTANCE.getCVE_2025_62506();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_62507Impl <em>CVE 2025 62507</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_62507Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_62507()
		 * @generated
		 */
		EClass CVE_2025_62507 = eINSTANCE.getCVE_2025_62507();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_66199Impl <em>CVE 2025 66199</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_66199Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_66199()
		 * @generated
		 */
		EClass CVE_2025_66199 = eINSTANCE.getCVE_2025_66199();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_69418Impl <em>CVE 2025 69418</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_69418Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_69418()
		 * @generated
		 */
		EClass CVE_2025_69418 = eINSTANCE.getCVE_2025_69418();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_69420Impl <em>CVE 2025 69420</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_69420Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_69420()
		 * @generated
		 */
		EClass CVE_2025_69420 = eINSTANCE.getCVE_2025_69420();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2025_69421Impl <em>CVE 2025 69421</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2025_69421Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2025_69421()
		 * @generated
		 */
		EClass CVE_2025_69421 = eINSTANCE.getCVE_2025_69421();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2026_22795Impl <em>CVE 2026 22795</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2026_22795Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2026_22795()
		 * @generated
		 */
		EClass CVE_2026_22795 = eINSTANCE.getCVE_2026_22795();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2026_22796Impl <em>CVE 2026 22796</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2026_22796Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2026_22796()
		 * @generated
		 */
		EClass CVE_2026_22796 = eINSTANCE.getCVE_2026_22796();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVE_2026_27970Impl <em>CVE 2026 27970</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVE_2026_27970Impl
		 * @see CASA.impl.CASAPackageImpl#getCVE_2026_27970()
		 * @generated
		 */
		EClass CVE_2026_27970 = eINSTANCE.getCVE_2026_27970();

		/**
		 * The meta object literal for the '{@link CASA.impl.PCommentsImpl <em>PComments</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PCommentsImpl
		 * @see CASA.impl.CASAPackageImpl#getPComments()
		 * @generated
		 */
		EClass PCOMMENTS = eINSTANCE.getPComments();

		/**
		 * The meta object literal for the '{@link CASA.impl.PVideoSharingImpl <em>PVideo Sharing</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PVideoSharingImpl
		 * @see CASA.impl.CASAPackageImpl#getPVideoSharing()
		 * @generated
		 */
		EClass PVIDEO_SHARING = eINSTANCE.getPVideoSharing();

		/**
		 * The meta object literal for the '{@link CASA.impl.VulnerabilityImpl <em>Vulnerability</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.VulnerabilityImpl
		 * @see CASA.impl.CASAPackageImpl#getVulnerability()
		 * @generated
		 */
		EClass VULNERABILITY = eINSTANCE.getVulnerability();

		/**
		 * The meta object literal for the '<em><b>Cve Name</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULNERABILITY__CVE_NAME = eINSTANCE.getVulnerability_CveName();

		/**
		 * The meta object literal for the '<em><b>Affects</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULNERABILITY__AFFECTS = eINSTANCE.getVulnerability_Affects();

		/**
		 * The meta object literal for the '<em><b>Described By</b></em>' containment reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULNERABILITY__DESCRIBED_BY = eINSTANCE.getVulnerability_DescribedBy();

		/**
		 * The meta object literal for the '<em><b>Causes</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference VULNERABILITY__CAUSES = eINSTANCE.getVulnerability_Causes();

		/**
		 * The meta object literal for the '<em><b>Is Enabled</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute VULNERABILITY__IS_ENABLED = eINSTANCE.getVulnerability_IsEnabled();

		/**
		 * The meta object literal for the '<em><b>Unique Vulnerabilities</b></em>' operation.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EOperation VULNERABILITY___UNIQUE_VULNERABILITIES__DIAGNOSTICCHAIN_MAP = eINSTANCE.getVulnerability__UniqueVulnerabilities__DiagnosticChain_Map();

		/**
		 * The meta object literal for the '{@link CASA.impl.CVSSVectorImpl <em>CVSS Vector</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.CVSSVectorImpl
		 * @see CASA.impl.CASAPackageImpl#getCVSSVector()
		 * @generated
		 */
		EClass CVSS_VECTOR = eINSTANCE.getCVSSVector();

		/**
		 * The meta object literal for the '<em><b>Attack Vector</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__ATTACK_VECTOR = eINSTANCE.getCVSSVector_AttackVector();

		/**
		 * The meta object literal for the '<em><b>Attack Complexity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__ATTACK_COMPLEXITY = eINSTANCE.getCVSSVector_AttackComplexity();

		/**
		 * The meta object literal for the '<em><b>Scope</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__SCOPE = eINSTANCE.getCVSSVector_Scope();

		/**
		 * The meta object literal for the '<em><b>Privileges Required</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__PRIVILEGES_REQUIRED = eINSTANCE.getCVSSVector_PrivilegesRequired();

		/**
		 * The meta object literal for the '<em><b>User Interaction</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__USER_INTERACTION = eINSTANCE.getCVSSVector_UserInteraction();

		/**
		 * The meta object literal for the '<em><b>Exploit Code Maturity</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__EXPLOIT_CODE_MATURITY = eINSTANCE.getCVSSVector_ExploitCodeMaturity();

		/**
		 * The meta object literal for the '<em><b>Report Confidence</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__REPORT_CONFIDENCE = eINSTANCE.getCVSSVector_ReportConfidence();

		/**
		 * The meta object literal for the '<em><b>Confidentiality Impact</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__CONFIDENTIALITY_IMPACT = eINSTANCE.getCVSSVector_ConfidentialityImpact();

		/**
		 * The meta object literal for the '<em><b>Integrity Impact</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__INTEGRITY_IMPACT = eINSTANCE.getCVSSVector_IntegrityImpact();

		/**
		 * The meta object literal for the '<em><b>Availability Impact</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__AVAILABILITY_IMPACT = eINSTANCE.getCVSSVector_AvailabilityImpact();

		/**
		 * The meta object literal for the '<em><b>Remediation Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__REMEDIATION_LEVEL = eINSTANCE.getCVSSVector_RemediationLevel();

		/**
		 * The meta object literal for the '<em><b>Confidentiality Requirement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__CONFIDENTIALITY_REQUIREMENT = eINSTANCE.getCVSSVector_ConfidentialityRequirement();

		/**
		 * The meta object literal for the '<em><b>Integrity Requirement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__INTEGRITY_REQUIREMENT = eINSTANCE.getCVSSVector_IntegrityRequirement();

		/**
		 * The meta object literal for the '<em><b>Availability Requirement</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute CVSS_VECTOR__AVAILABILITY_REQUIREMENT = eINSTANCE.getCVSSVector_AvailabilityRequirement();

		/**
		 * The meta object literal for the '{@link CASA.impl.RiskImpl <em>Risk</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.RiskImpl
		 * @see CASA.impl.CASAPackageImpl#getRisk()
		 * @generated
		 */
		EClass RISK = eINSTANCE.getRisk();

		/**
		 * The meta object literal for the '<em><b>Level</b></em>' attribute feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EAttribute RISK__LEVEL = eINSTANCE.getRisk_Level();

		/**
		 * The meta object literal for the '<em><b>Affects</b></em>' container reference feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RISK__AFFECTS = eINSTANCE.getRisk_Affects();

		/**
		 * The meta object literal for the '<em><b>Caused By</b></em>' reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference RISK__CAUSED_BY = eINSTANCE.getRisk_CausedBy();

		/**
		 * The meta object literal for the '{@link CASA.impl.SystemImpl <em>System</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.SystemImpl
		 * @see CASA.impl.CASAPackageImpl#getSystem()
		 * @generated
		 */
		EClass SYSTEM = eINSTANCE.getSystem();

		/**
		 * The meta object literal for the '<em><b>Functions</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__FUNCTIONS = eINSTANCE.getSystem_Functions();

		/**
		 * The meta object literal for the '<em><b>Datas</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__DATAS = eINSTANCE.getSystem_Datas();

		/**
		 * The meta object literal for the '<em><b>Data Subjects</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__DATA_SUBJECTS = eINSTANCE.getSystem_DataSubjects();

		/**
		 * The meta object literal for the '<em><b>Vulnerabilities</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__VULNERABILITIES = eINSTANCE.getSystem_Vulnerabilities();

		/**
		 * The meta object literal for the '<em><b>Components</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__COMPONENTS = eINSTANCE.getSystem_Components();

		/**
		 * The meta object literal for the '<em><b>Purposes</b></em>' containment reference list feature.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @generated
		 */
		EReference SYSTEM__PURPOSES = eINSTANCE.getSystem_Purposes();

		/**
		 * The meta object literal for the '{@link CASA.impl.RedisComponentImpl <em>Redis Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.RedisComponentImpl
		 * @see CASA.impl.CASAPackageImpl#getRedisComponent()
		 * @generated
		 */
		EClass REDIS_COMPONENT = eINSTANCE.getRedisComponent();

		/**
		 * The meta object literal for the '{@link CASA.impl.FilesystemComponentImpl <em>Filesystem Component</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.FilesystemComponentImpl
		 * @see CASA.impl.CASAPackageImpl#getFilesystemComponent()
		 * @generated
		 */
		EClass FILESYSTEM_COMPONENT = eINSTANCE.getFilesystemComponent();

		/**
		 * The meta object literal for the '{@link CASA.impl.PostgresqlImpl <em>Postgresql</em>}' class.
		 * <!-- begin-user-doc -->
		 * <!-- end-user-doc -->
		 * @see CASA.impl.PostgresqlImpl
		 * @see CASA.impl.CASAPackageImpl#getPostgresql()
		 * @generated
		 */
		EClass POSTGRESQL = eINSTANCE.getPostgresql();

	}

} //CASAPackage
