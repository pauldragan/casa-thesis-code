package thesis;

import java.util.Collection;
import java.util.Optional;

import CASA.Consent;

public class FirstNonViolating extends LawfulBasisSelectionPolicy {

	@Override
	public Optional<Consent> selectLawfulBasis(
			String processingPurposeName,
			Collection<Consent> candidateConsents,
			CASAPurposeModel purposeModel,
			CASAPurposeConsentRules purposeConsentRules,
			CASAPurpose.PurposeNameMappingMode purposeNameMappingMode) {
		for (Consent consent : candidateConsents) {
			String consentPurposeName = CASAPurpose.convertHenshinPurposeToPurposeModelName(
					consent.getForPurpose(), purposeNameMappingMode);
			CASAPurposeModel.PurposeRelation relation = purposeModel.calculatePurposeRelation(
					processingPurposeName, consentPurposeName);
			CASAPurposeConsentRules.PurposeConsentViolation violation = purposeConsentRules.applyRule(relation);
			System.out.println(processingPurposeName + " -> " + consentPurposeName + " ?: " + violation);

			if (violation == CASAPurposeConsentRules.PurposeConsentViolation.NOT_VIOLATED) {
				return Optional.of(consent);
			}
		}
		return Optional.empty();
	}
}
