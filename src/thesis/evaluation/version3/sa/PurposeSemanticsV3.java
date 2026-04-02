package thesis.evaluation.version3.sa;

import java.util.LinkedHashMap;
import java.util.Map;

final class PurposeSemanticsV3 {
    private final Map<String, String> parentByPurpose = new LinkedHashMap<>();

    PurposeSemanticsV3() {
        parentByPurpose.put("PStandardAds", "PMarketing");
        parentByPurpose.put("PTargetedAds", "PMarketing");
        parentByPurpose.put("PLocationTargetedAds", "PTargetedAds");
        parentByPurpose.put("PBehaviorTargetedAds", "PTargetedAds");
        parentByPurpose.put("PFirstPartyProfiling", "PProfiling");
        parentByPurpose.put("PThirdPartyProfiling", "PProfiling");
        parentByPurpose.put("PP2PStreaming", "PUserExperience");
        parentByPurpose.put("PVideoRecommendation", "PUserExperience");
        parentByPurpose.put("PComments", "PSocial");
        parentByPurpose.put("PVideoSharing", "PSocial");
    }

    boolean isSameOrSpecialization(String functionPurposeId, String consentPurposeId) {
        if (functionPurposeId.equals(consentPurposeId)) {
            return true;
        }
        String current = functionPurposeId;
        while ((current = parentByPurpose.get(current)) != null) {
            if (current.equals(consentPurposeId)) {
                return true;
            }
        }
        return false;
    }

    boolean isGeneralizationOrUnrelated(String functionPurposeId, String consentPurposeId) {
        if (functionPurposeId.equals(consentPurposeId)) {
            return false;
        }
        if (isSameOrSpecialization(functionPurposeId, consentPurposeId)) {
            return false;
        }
        return true;
    }
}
