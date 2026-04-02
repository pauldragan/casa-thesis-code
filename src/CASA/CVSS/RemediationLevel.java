/**
 */
package CASA.CVSS;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.eclipse.emf.common.util.Enumerator;

/**
 * <!-- begin-user-doc -->
 * A representation of the literals of the enumeration '<em><b>Remediation Level</b></em>',
 * and utility methods for working with them.
 * <!-- end-user-doc -->
 * @see CASA.CVSS.CVSSPackage#getRemediationLevel()
 * @model
 * @generated
 */
public enum RemediationLevel implements Enumerator {
	/**
	 * The '<em><b>Not Defined</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_DEFINED_VALUE
	 * @generated
	 * @ordered
	 */
	NOT_DEFINED(0, "NotDefined", "X"),

	/**
	 * The '<em><b>Unavailable</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNAVAILABLE_VALUE
	 * @generated
	 * @ordered
	 */
	UNAVAILABLE(1, "Unavailable", "U"),

	/**
	 * The '<em><b>Workaround</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WORKAROUND_VALUE
	 * @generated
	 * @ordered
	 */
	WORKAROUND(2, "Workaround", "W"),

	/**
	 * The '<em><b>Temporary Fix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPORARY_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	TEMPORARY_FIX(3, "TemporaryFix", "T"),

	/**
	 * The '<em><b>Official Fix</b></em>' literal object.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFFICIAL_FIX_VALUE
	 * @generated
	 * @ordered
	 */
	OFFICIAL_FIX(4, "OfficialFix", "O");

	/**
	 * The '<em><b>Not Defined</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #NOT_DEFINED
	 * @model name="NotDefined" literal="X"
	 * @generated
	 * @ordered
	 */
	public static final int NOT_DEFINED_VALUE = 0;

	/**
	 * The '<em><b>Unavailable</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #UNAVAILABLE
	 * @model name="Unavailable" literal="U"
	 * @generated
	 * @ordered
	 */
	public static final int UNAVAILABLE_VALUE = 1;

	/**
	 * The '<em><b>Workaround</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #WORKAROUND
	 * @model name="Workaround" literal="W"
	 * @generated
	 * @ordered
	 */
	public static final int WORKAROUND_VALUE = 2;

	/**
	 * The '<em><b>Temporary Fix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #TEMPORARY_FIX
	 * @model name="TemporaryFix" literal="T"
	 * @generated
	 * @ordered
	 */
	public static final int TEMPORARY_FIX_VALUE = 3;

	/**
	 * The '<em><b>Official Fix</b></em>' literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @see #OFFICIAL_FIX
	 * @model name="OfficialFix" literal="O"
	 * @generated
	 * @ordered
	 */
	public static final int OFFICIAL_FIX_VALUE = 4;

	/**
	 * An array of all the '<em><b>Remediation Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private static final RemediationLevel[] VALUES_ARRAY =
		new RemediationLevel[] {
			NOT_DEFINED,
			UNAVAILABLE,
			WORKAROUND,
			TEMPORARY_FIX,
			OFFICIAL_FIX,
		};

	/**
	 * A public read-only list of all the '<em><b>Remediation Level</b></em>' enumerators.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final List<RemediationLevel> VALUES = Collections.unmodifiableList(Arrays.asList(VALUES_ARRAY));

	/**
	 * Returns the '<em><b>Remediation Level</b></em>' literal with the specified literal value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param literal the literal.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RemediationLevel get(String literal) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RemediationLevel result = VALUES_ARRAY[i];
			if (result.toString().equals(literal)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Remediation Level</b></em>' literal with the specified name.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param name the name.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RemediationLevel getByName(String name) {
		for (int i = 0; i < VALUES_ARRAY.length; ++i) {
			RemediationLevel result = VALUES_ARRAY[i];
			if (result.getName().equals(name)) {
				return result;
			}
		}
		return null;
	}

	/**
	 * Returns the '<em><b>Remediation Level</b></em>' literal with the specified integer value.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @param value the integer value.
	 * @return the matching enumerator or <code>null</code>.
	 * @generated
	 */
	public static RemediationLevel get(int value) {
		switch (value) {
			case NOT_DEFINED_VALUE: return NOT_DEFINED;
			case UNAVAILABLE_VALUE: return UNAVAILABLE;
			case WORKAROUND_VALUE: return WORKAROUND;
			case TEMPORARY_FIX_VALUE: return TEMPORARY_FIX;
			case OFFICIAL_FIX_VALUE: return OFFICIAL_FIX;
		}
		return null;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final int value;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String name;

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private final String literal;

	/**
	 * Only this class can construct instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	private RemediationLevel(int value, String name, String literal) {
		this.value = value;
		this.name = name;
		this.literal = literal;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public int getValue() {
	  return value;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getName() {
	  return name;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public String getLiteral() {
	  return literal;
	}

	/**
	 * Returns the literal value of the enumerator, which is its string representation.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public String toString() {
		return literal;
	}
	
} //RemediationLevel
