package thesis.evaluation.version3.me;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;

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

public final class CasaModelMapperV3Tests {
    private CasaModelMapperV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("me.CasaModelMapperV3.mapsFunctionsComponentsPurposesAndConsents",
                CasaModelMapperV3Tests::mapsFunctionsComponentsPurposesAndConsents);
        TestSupportV3.run("me.CasaModelMapperV3.usesConcreteVulnerabilitySubtypeAndCvss",
                CasaModelMapperV3Tests::usesConcreteVulnerabilitySubtypeAndCvss);
    }

    private static void mapsFunctionsComponentsPurposesAndConsents() {
        Resource resource = new CasaModelMapperV3().mapToResource(ManagedElementIntegrationTestsFixture.fixture(), URI.createURI("memory:/me_test.xmi"));
        CASA.System system = (CASA.System) resource.getContents().get(0);
        DataSubject ds = system.getDataSubjects().get(0);
        PersonalData pd = (PersonalData) system.getDatas().get(0);
        FuncPersData fn = (FuncPersData) system.getFunctions().get(0);
        Component comp = system.getComponents().get(0);
        Purpose purpose = system.getPurposes().get(0);

        TestSupportV3.equals("user_1", ds.getName(), "CasaModelMapperV3 should map data subject name");
        TestSupportV3.equals(ds, pd.getIdentifies(), "CasaModelMapperV3 should map PD ownership");
        TestSupportV3.equals(comp, fn.getRealizedBy().get(0), "CasaModelMapperV3 should map realizedBy");
        TestSupportV3.equals(pd, fn.getProcessesPersData().get(0), "CasaModelMapperV3 should map processes");
        TestSupportV3.equals(purpose, fn.getHas().get(0), "CasaModelMapperV3 should map purposes");

        Consent consent = ds.getGives().get(0);
        TestSupportV3.equals("PComments", consent.getForPurpose(), "CasaModelMapperV3 should map consent forPurpose string");
        TestSupportV3.equals(purpose, consent.getGivenFor().get(0), "CasaModelMapperV3 should map consent givenFor");
        TestSupportV3.equals(pd, consent.getForPersonalData().get(0), "CasaModelMapperV3 should map consent forPersonalData");
    }

    private static void usesConcreteVulnerabilitySubtypeAndCvss() {
        Resource resource = new CasaModelMapperV3().mapToResource(ManagedElementIntegrationTestsFixture.fixture(), URI.createURI("memory:/me_test.xmi"));
        CASA.System system = (CASA.System) resource.getContents().get(0);
        Vulnerability vulnerability = system.getVulnerabilities().get(0);
        CVSSVector cvss = vulnerability.getDescribedBy();
        CvssCatalogV3.Entry entry = CvssCatalogV3.defaults().getRequired("CVE-2024-7347");

        TestSupportV3.equals("CVE_2024_7347", vulnerability.eClass().getName(),
                "CasaModelMapperV3 should instantiate the concrete vulnerability subtype");
        TestSupportV3.equals(attackVector(entry.attackVector()), cvss.getAttackVector(), "CasaModelMapperV3 should map CVSS attack vector");
        TestSupportV3.equals(attackComplexity(entry.attackComplexity()), cvss.getAttackComplexity(), "CasaModelMapperV3 should map CVSS attack complexity");
        TestSupportV3.equals(confidentialityImpact(entry.confidentialityImpact()), cvss.getConfidentialityImpact(), "CasaModelMapperV3 should map confidentiality impact");
        TestSupportV3.equals(integrityImpact(entry.integrityImpact()), cvss.getIntegrityImpact(), "CasaModelMapperV3 should map integrity impact");
        TestSupportV3.equals(availabilityImpact(entry.availabilityImpact()), cvss.getAvailabilityImpact(), "CasaModelMapperV3 should map availability impact");
    }

    private static AttackVector attackVector(String value) {
        return switch (value) {
            case "NETWORK" -> AttackVector.NETWORK;
            case "ADJACENT", "ADJACENT_NETWORK" -> AttackVector.ADJACENT;
            case "LOCAL" -> AttackVector.LOCAL;
            case "PHYSICAL" -> AttackVector.PHYSICAL;
            default -> throw new IllegalArgumentException(value);
        };
    }

    private static AttackComplexity attackComplexity(String value) {
        return switch (value) {
            case "LOW" -> AttackComplexity.LOW;
            case "HIGH" -> AttackComplexity.HIGH;
            default -> throw new IllegalArgumentException(value);
        };
    }

    private static ConfidentialityImpact confidentialityImpact(String value) {
        return switch (value) {
            case "NONE" -> ConfidentialityImpact.NONE;
            case "LOW" -> ConfidentialityImpact.LOW;
            case "HIGH" -> ConfidentialityImpact.HIGH;
            default -> throw new IllegalArgumentException(value);
        };
    }

    private static IntegrityImpact integrityImpact(String value) {
        return switch (value) {
            case "NONE" -> IntegrityImpact.NONE;
            case "LOW" -> IntegrityImpact.LOW;
            case "HIGH" -> IntegrityImpact.HIGH;
            default -> throw new IllegalArgumentException(value);
        };
    }

    private static AvailabilityImpact availabilityImpact(String value) {
        return switch (value) {
            case "NONE" -> AvailabilityImpact.NONE;
            case "LOW" -> AvailabilityImpact.LOW;
            case "HIGH" -> AvailabilityImpact.HIGH;
            default -> throw new IllegalArgumentException(value);
        };
    }

    static final class ManagedElementIntegrationTestsFixture {
        static ManagedElementInstance fixture() {
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
    }
}
