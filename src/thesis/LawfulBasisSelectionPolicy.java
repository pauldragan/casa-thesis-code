package thesis;

import java.util.Collection;
import java.util.Optional;

import CASA.Consent;

public abstract class LawfulBasisSelectionPolicy {

	public abstract Optional<Consent> selectLawfulBasis(
			String processingPurposeName,
			Collection<Consent> candidateConsents,
			CASAPurposeModel purposeModel,
			CASAPurposeConsentRules purposeConsentRules,
			CASAPurpose.PurposeNameMappingMode purposeNameMappingMode);
}
