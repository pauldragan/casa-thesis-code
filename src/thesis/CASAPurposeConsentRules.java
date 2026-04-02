package thesis;

public class CASAPurposeConsentRules {
	public enum PurposeConsentViolation {
		VIOLATED,
		NOT_VIOLATED
	}
		
	public PurposeConsentViolation applyRule(CASAPurposeModel.PurposeRelation relation) {
		if (relation == CASAPurposeModel.PurposeRelation.SAME || relation == CASAPurposeModel.PurposeRelation.SPECIALIZATION) {
			return PurposeConsentViolation.NOT_VIOLATED;
		}		
		return PurposeConsentViolation.VIOLATED;
	}
}
