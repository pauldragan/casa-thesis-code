package thesis.evaluation.version3.result_evaluation;

import java.lang.reflect.Method;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.eclipse.emf.ecore.EObject;

import thesis.CASAOfflineConsentAnalyzer;
import thesis.CASAPurpose;
import thesis.CASARisk;

public final class OfflineResultAnalyzerV3 {
    private static final String V3_PURPOSE_ONTOLOGY_PATH = "src/resources/casa-v3-eval-purpose-model.owx";
    private static final double V3_RISK_CONSENT_THRESHOLD = 0.000001d;
    private final CASAOfflineConsentAnalyzer analyzer;

    public OfflineResultAnalyzerV3() {
        this.analyzer = new CASAOfflineConsentAnalyzer(
                new CASAOfflineConsentAnalyzer.RiskEngineConfig(
                        CASARisk.EstimationMode.AUTO,
                        20_000,
                        1234L,
                        15,
                        V3_RISK_CONSENT_THRESHOLD),
                V3_PURPOSE_ONTOLOGY_PATH,
                CASAPurpose.PurposeNameMappingMode.V3);
    }

    public Set<String> analyzePurposeViolationKeys(EObject modelRoot) throws Exception {
        CASAPurpose.PurposeCheckResult purposeResult = analyzer.runPurposeOnly(modelRoot);
        Set<String> violations = new LinkedHashSet<>();
        Object analysis = purposeResult.getAnalysis();
        if (analysis == null) {
            return violations;
        }
        Method getViolations = analysis.getClass().getDeclaredMethod("getViolations");
        getViolations.setAccessible(true);
        @SuppressWarnings("unchecked")
        List<Object> raw = (List<Object>) getViolations.invoke(analysis);
        for (Object violation : raw) {
            Object ds = invoke(violation, "getDs");
            Object d = invoke(violation, "getD");
            Object f = invoke(violation, "getF");
            Object p = invoke(violation, "getP");
            violations.add(purposeKey(
                    invokeString(ds, "getName"),
                    invokeString(d, "getName"),
                    invokeString(f, "getName"),
                    invokeString(p, "getName")));
        }
        return violations;
    }

    public Set<String> analyzeRiskViolationDataSubjects(EObject modelRoot) {
        CASAPurpose.PurposeCheckResult purposeResult = analyzer.runPurposeOnly(modelRoot);
        if (purposeResult.isViolated()) {
            return new LinkedHashSet<>();
        }
        CASARisk.RiskCheckResult riskResult = analyzer.runRiskOnlyDetailed(modelRoot, purposeResult);
        Set<String> violations = new LinkedHashSet<>();
        for (CASARisk.RiskViolation violation : riskResult.getViolations()) {
            String dataSubjectId = violation.getDataSubject() == null ? "" : violation.getDataSubject().getName();
            violations.add(dataSubjectId);
        }
        return violations;
    }

    private static Object invoke(Object target, String methodName) throws Exception {
        Method method = target.getClass().getDeclaredMethod(methodName);
        method.setAccessible(true);
        return method.invoke(target);
    }

    private static String invokeString(Object target, String methodName) throws Exception {
        if (target == null) {
            return "";
        }
        Method method = target.getClass().getMethod(methodName);
        Object value = method.invoke(target);
        return value == null ? "" : String.valueOf(value);
    }

    private static String purposeKey(String dsId, String pdId, String functionId, String purposeId) {
        return dsId + "|" + pdId + "|" + functionId + "|" + purposeId;
    }
}
