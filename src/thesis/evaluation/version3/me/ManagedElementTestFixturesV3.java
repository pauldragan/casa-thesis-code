package thesis.evaluation.version3.me;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.common.util.URI;
import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

public final class ManagedElementTestFixturesV3 {
    private ManagedElementTestFixturesV3() {
    }

    public static Path writeCrossStageSourceModel(Path outDir) throws IOException {
        Files.createDirectories(outDir);
        Path outXmi = outDir.resolve("source_cross_stage.xmi");
        Resource resource = new CasaModelMapperV3().mapToResource(crossStageSource(), URI.createFileURI(outXmi.toAbsolutePath().toString()));
        Map<Object, Object> options = new HashMap<>();
        options.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);
        resource.save(options);
        return outXmi;
    }

    public static Path writePurposeViolationModel(Path outDir) throws IOException {
        return writeModel(outDir, "purpose_violation.xmi", purposeViolationModel());
    }

    public static Path writePurposeAndRiskViolationModel(Path outDir) throws IOException {
        return writeModel(outDir, "purpose_and_risk_violation.xmi", purposeAndRiskViolationModel());
    }

    public static Path writePurposeSubtypeCoverageModel(Path outDir) throws IOException {
        return writeModel(outDir, "purpose_subtype_coverage.xmi", purposeSubtypeCoverageModel());
    }

    private static Path writeModel(Path outDir, String fileName, ManagedElementInstance me) throws IOException {
        Files.createDirectories(outDir);
        Path outXmi = outDir.resolve(fileName);
        Resource resource = new CasaModelMapperV3().mapToResource(me, URI.createFileURI(outXmi.toAbsolutePath().toString()));
        Map<Object, Object> options = new HashMap<>();
        options.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);
        resource.save(options);
        return outXmi;
    }

    private static ManagedElementInstance crossStageSource() {
        ManagedElementInstance me = new ManagedElementInstance("me_000000");
        me.dataSubjects.put("ds1", new ManagedElementInstance.DataSubjectNode("ds1", "DSUser", "user_1"));
        me.personalData.put("pd1", new ManagedElementInstance.PersonalDataNode("pd1", "PDComment", "comment_1", "ds1"));
        me.functions.put("f1", new ManagedElementInstance.FunctionNode("f1", "FStreamVideo", "stream_1"));
        me.components.put("c1", new ManagedElementInstance.ComponentNode("c1", "CNginx", "nginx_1"));
        me.purposes.put("PComments", new ManagedElementInstance.PurposeNode("PComments", "PComments", "PComments"));
        me.consents.put("cons1", new ManagedElementInstance.ConsentNode("cons1", "ds1", "pd1", "PComments"));

        me.functions.get("f1").realizedByComponentIds.add("c1");
        me.functions.get("f1").processesPersonalDataIds.add("pd1");
        me.functions.get("f1").hasPurposeIds.add("PComments");
        return me;
    }

    private static ManagedElementInstance purposeViolationModel() {
        ManagedElementInstance me = new ManagedElementInstance("me_test");
        me.dataSubjects.put("ds1", new ManagedElementInstance.DataSubjectNode("ds1", "DSUser", "user_1"));
        me.personalData.put("pd1", new ManagedElementInstance.PersonalDataNode("pd1", "PDComment", "comment_1", "ds1"));
        me.functions.put("f1", new ManagedElementInstance.FunctionNode("f1", "FUploadVideo", "upload_1"));
        me.components.put("c1", new ManagedElementInstance.ComponentNode("c1", "CNginx", "nginx_1"));
        me.purposes.put("PComments", new ManagedElementInstance.PurposeNode("PComments", "PComments", "PComments"));
        me.purposes.put("PMarketing", new ManagedElementInstance.PurposeNode("PMarketing", "PMarketing", "PMarketing"));
        me.consents.put("cons1", new ManagedElementInstance.ConsentNode("cons1", "ds1", "pd1", "PComments"));
        me.functions.get("f1").realizedByComponentIds.add("c1");
        me.functions.get("f1").processesPersonalDataIds.add("pd1");
        me.functions.get("f1").hasPurposeIds.add("PMarketing");
        return me;
    }

    private static ManagedElementInstance purposeAndRiskViolationModel() {
        ManagedElementInstance me = purposeViolationModel();
        me.vulnerabilities.put("v1", new ManagedElementInstance.VulnerabilityNode("v1", "CVE-2024-7347", "CNginx"));
        return me;
    }

    private static ManagedElementInstance purposeSubtypeCoverageModel() {
        ManagedElementInstance me = new ManagedElementInstance("me_purpose_subtypes");
        me.dataSubjects.put("ds1", new ManagedElementInstance.DataSubjectNode("ds1", "DSUser", "user_1"));
        me.personalData.put("pd1", new ManagedElementInstance.PersonalDataNode("pd1", "PDComment", "comment_1", "ds1"));
        me.components.put("c1", new ManagedElementInstance.ComponentNode("c1", "CNginx", "nginx_1"));
        me.functions.put("f1", new ManagedElementInstance.FunctionNode("f1", "FUploadVideo", "upload_1"));
        me.functions.get("f1").realizedByComponentIds.add("c1");
        me.functions.get("f1").processesPersonalDataIds.add("pd1");
        me.purposes.put("PComments", new ManagedElementInstance.PurposeNode("PComments", "PComments", "PComments"));
        me.purposes.put("PBehaviorTargetedAds",
                new ManagedElementInstance.PurposeNode("PBehaviorTargetedAds", "PBehaviorTargetedAds", "PBehaviorTargetedAds"));
        me.purposes.put("PThirdPartyProfiling",
                new ManagedElementInstance.PurposeNode("PThirdPartyProfiling", "PThirdPartyProfiling", "PThirdPartyProfiling"));
        me.functions.get("f1").hasPurposeIds.add("PComments");
        me.functions.get("f1").hasPurposeIds.add("PBehaviorTargetedAds");
        me.functions.get("f1").hasPurposeIds.add("PThirdPartyProfiling");
        me.consents.put("cons1", new ManagedElementInstance.ConsentNode("cons1", "ds1", "pd1", "PComments"));
        me.vulnerabilities.put("v1", new ManagedElementInstance.VulnerabilityNode("v1", "CVE-2024-7347", "CNginx"));
        return me;
    }
}
