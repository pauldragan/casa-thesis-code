package thesis.evaluation.version3.me;

import java.util.LinkedHashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

import CASA.CASAPackage;
import CASA.CVSS.AttackComplexity;
import CASA.CVSS.AttackVector;
import CASA.CVSS.AvailabilityImpact;
import CASA.CVSS.ConfidentialityImpact;
import CASA.CVSS.IntegrityImpact;
import CASA.Component;
import CASA.Consent;
import CASA.CVSSVector;
import CASA.DataSubject;
import CASA.FuncPersData;
import CASA.PersonalData;
import CASA.Purpose;
import CASA.Vulnerability;
import thesis.evaluation.version3.tests.TestSupportV3;

public final class ManagedElementIntegrationTestsV3 {
    private ManagedElementIntegrationTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("me.mapToCasaResourceMapsFunctionsComponentsPurposesAndConsents",
                ManagedElementIntegrationTestsV3::mapToCasaResourceMapsFunctionsComponentsPurposesAndConsents);
        TestSupportV3.run("me.mapToCasaResourceUsesConcreteVulnerabilitySubtypeAndCvss",
                ManagedElementIntegrationTestsV3::mapToCasaResourceUsesConcreteVulnerabilitySubtypeAndCvss);
    }

    private static void mapToCasaResourceMapsFunctionsComponentsPurposesAndConsents() {
        Resource resource = new CasaModelMapperV3().mapToResource(fixture(), URI.createURI("memory:/me_test.xmi"));
        CASA.System system = (CASA.System) resource.getContents().get(0);

        TestSupportV3.equals(1, system.getDataSubjects().size(), "Mapped CASA model should contain one data subject");
        TestSupportV3.equals(1, system.getDatas().size(), "Mapped CASA model should contain one personal data object");
        TestSupportV3.equals(1, system.getFunctions().size(), "Mapped CASA model should contain one function");
        TestSupportV3.equals(1, system.getComponents().size(), "Mapped CASA model should contain one component");
        TestSupportV3.equals(1, system.getPurposes().size(), "Mapped CASA model should contain one purpose");

        DataSubject ds = system.getDataSubjects().get(0);
        PersonalData pd = (PersonalData) system.getDatas().get(0);
        FuncPersData fn = (FuncPersData) system.getFunctions().get(0);
        Component comp = system.getComponents().get(0);
        Purpose purpose = system.getPurposes().get(0);

        TestSupportV3.equals("user_1", ds.getName(), "Data subject name should be mapped");
        TestSupportV3.equals("comment_1", pd.getName(), "Personal data name should be mapped");
        TestSupportV3.equals(ds, pd.getIdentifies(), "Personal data owner should be mapped");
        TestSupportV3.equals("upload_1", fn.getName(), "Function name should be mapped");
        TestSupportV3.equals(1, fn.getRealizedBy().size(), "Function realizedBy relation should be mapped");
        TestSupportV3.equals(comp, fn.getRealizedBy().get(0), "Function should realize the mapped component");
        TestSupportV3.equals(1, fn.getProcessesPersData().size(), "Function processes relation should be mapped");
        TestSupportV3.equals(pd, fn.getProcessesPersData().get(0), "Function should process the mapped personal data");
        TestSupportV3.equals(1, fn.getHas().size(), "Function purpose relation should be mapped");
        TestSupportV3.equals(purpose, fn.getHas().get(0), "Function should reference the mapped purpose");

        TestSupportV3.equals(1, ds.getGives().size(), "Consent should be attached to the data subject");
        Consent consent = ds.getGives().get(0);
        TestSupportV3.equals(0.0d, consent.getInformedRiskLevel(), "v3 baseline consent informed risk should map to 0.0");
        TestSupportV3.equals("PComments", consent.getForPurpose(), "Consent forPurpose string should be mapped");
        TestSupportV3.equals(1, consent.getGivenFor().size(), "Consent should reference one purpose object");
        TestSupportV3.equals(purpose, consent.getGivenFor().get(0), "Consent should reference the mapped purpose object");
        TestSupportV3.equals(1, consent.getForPersonalData().size(), "Consent should reference one personal data object");
        TestSupportV3.equals(pd, consent.getForPersonalData().get(0), "Consent should reference the mapped personal data");
    }

    private static void mapToCasaResourceUsesConcreteVulnerabilitySubtypeAndCvss() {
        Resource resource = new CasaModelMapperV3().mapToResource(fixture(), URI.createURI("memory:/me_test.xmi"));
        CASA.System system = (CASA.System) resource.getContents().get(0);

        TestSupportV3.equals(1, system.getVulnerabilities().size(), "Mapped CASA model should contain one vulnerability");
        Vulnerability vulnerability = system.getVulnerabilities().get(0);
        TestSupportV3.equals("CVE-2024-7347", vulnerability.getCveName(), "Vulnerability CVE should be mapped");
        TestSupportV3.equals("CVE_2024_7347", vulnerability.eClass().getName(),
                "Mapper should instantiate the concrete vulnerability subtype");
        TestSupportV3.check(vulnerability.getDescribedBy() != null, "Mapped vulnerability should contain a CVSS vector");

        CVSSVector cvss = vulnerability.getDescribedBy();
        CvssCatalogV3.Entry entry = CvssCatalogV3.defaults().getRequired("CVE-2024-7347");
        TestSupportV3.equals(attackVector(entry.attackVector()), cvss.getAttackVector(), "CVSS attack vector should match catalog");
        TestSupportV3.equals(attackComplexity(entry.attackComplexity()), cvss.getAttackComplexity(), "CVSS attack complexity should match catalog");
        TestSupportV3.equals(confidentialityImpact(entry.confidentialityImpact()), cvss.getConfidentialityImpact(),
                "CVSS confidentiality impact should match catalog");
        TestSupportV3.equals(integrityImpact(entry.integrityImpact()), cvss.getIntegrityImpact(),
                "CVSS integrity impact should match catalog");
        TestSupportV3.equals(availabilityImpact(entry.availabilityImpact()), cvss.getAvailabilityImpact(),
                "CVSS availability impact should match catalog");
    }

    private static ManagedElementInstance fixture() {
        ManagedElementInstance me = new ManagedElementInstance("me_000000");
        me.dataSubjects.put("ds1", new ManagedElementInstance.DataSubjectNode("ds1", "DSUser", "user_1"));
        me.personalData.put("pd1", new ManagedElementInstance.PersonalDataNode("pd1", "PDComment", "comment_1", "ds1"));
        me.functions.put("fn1", new ManagedElementInstance.FunctionNode("fn1", "FUploadVideo", "upload_1"));
        me.components.put("c1", new ManagedElementInstance.ComponentNode("c1", "CNginx", "nginx_1"));
        me.purposes.put("PComments", new ManagedElementInstance.PurposeNode("PComments", "PComments", "PComments"));
        me.vulnerabilities.put("v1", new ManagedElementInstance.VulnerabilityNode("v1", "CVE-2024-7347", "CNginx"));
        me.consents.put("cons1", new ManagedElementInstance.ConsentNode("cons1", "ds1", "pd1", "PComments"));

        me.functions.get("fn1").realizedByComponentIds.add("c1");
        me.functions.get("fn1").processesPersonalDataIds.add("pd1");
        me.functions.get("fn1").hasPurposeIds.add("PComments");
        return me;
    }

    private static AttackVector attackVector(String value) {
        return switch (value) {
            case "NETWORK" -> AttackVector.NETWORK;
            case "ADJACENT", "ADJACENT_NETWORK" -> AttackVector.ADJACENT;
            case "LOCAL" -> AttackVector.LOCAL;
            case "PHYSICAL" -> AttackVector.PHYSICAL;
            default -> throw new IllegalArgumentException("Unexpected attack vector in test fixture: " + value);
        };
    }

    private static AttackComplexity attackComplexity(String value) {
        return switch (value) {
            case "LOW" -> AttackComplexity.LOW;
            case "HIGH" -> AttackComplexity.HIGH;
            default -> throw new IllegalArgumentException("Unexpected attack complexity in test fixture: " + value);
        };
    }

    private static ConfidentialityImpact confidentialityImpact(String value) {
        return switch (value) {
            case "NONE" -> ConfidentialityImpact.NONE;
            case "LOW" -> ConfidentialityImpact.LOW;
            case "HIGH" -> ConfidentialityImpact.HIGH;
            default -> throw new IllegalArgumentException("Unexpected confidentiality impact in test fixture: " + value);
        };
    }

    private static IntegrityImpact integrityImpact(String value) {
        return switch (value) {
            case "NONE" -> IntegrityImpact.NONE;
            case "LOW" -> IntegrityImpact.LOW;
            case "HIGH" -> IntegrityImpact.HIGH;
            default -> throw new IllegalArgumentException("Unexpected integrity impact in test fixture: " + value);
        };
    }

    private static AvailabilityImpact availabilityImpact(String value) {
        return switch (value) {
            case "NONE" -> AvailabilityImpact.NONE;
            case "LOW" -> AvailabilityImpact.LOW;
            case "HIGH" -> AvailabilityImpact.HIGH;
            default -> throw new IllegalArgumentException("Unexpected availability impact in test fixture: " + value);
        };
    }
}
