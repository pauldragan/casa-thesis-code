package thesis.evaluation.version3.sa;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashSet;
import java.util.Set;

import org.eclipse.emf.henshin.model.Module;

public final class SelfAdaptationTestFixturesV3 {
    private SelfAdaptationTestFixturesV3() {
    }

    public static Path writeCrossStageTransformation(Path outDir) throws IOException {
        Files.createDirectories(outDir);
        Path henshinPath = outDir.resolve("sa_cross_stage.henshin");
        Module module = new HenshinTransformationMapperV3().map(crossStageAdaptationInstance(), crossStageSourceInstance());
        return new HenshinTransformationWriterV3().write(module, henshinPath);
    }

    public static SourceManagedElementInstance crossStageSourceInstance() {
        SourceManagedElementInstance source = new SourceManagedElementInstance("me_000000");
        source.dataSubjects.put("ds1", new SourceManagedElementInstance.DataSubjectView("ds1", "DSUser", "user_1"));
        source.personalData.put("pd1", new SourceManagedElementInstance.PersonalDataView("pd1", "PDComment", "comment_1", "ds1"));
        source.components.put("c1", new SourceManagedElementInstance.ComponentView("c1", "CNginx", "nginx_1"));
        source.functions.put("f1", new SourceManagedElementInstance.FunctionView(
                "f1",
                "FStreamVideo",
                "stream_1",
                new LinkedHashSet<>(Set.of("c1")),
                new LinkedHashSet<>(Set.of("pd1")),
                new LinkedHashSet<>(Set.of("PComments"))));
        source.purposes.put("PComments", new SourceManagedElementInstance.PurposeView("PComments", "PComments", "PComments"));
        source.consents.put("cons1", new SourceManagedElementInstance.ConsentView("cons1", "ds1", "pd1", "PComments"));
        return source;
    }

    public static SelfAdaptationInstance crossStageAdaptationInstance() {
        SelfAdaptationInstance instance = new SelfAdaptationInstance();
        instance.adaptationId = "sa_cross_stage";
        instance.sourceModelId = "me_000000";
        instance.addedComponents.add(new SelfAdaptationInstance.AddedComponent(
                "sa_cross_stage_comp_000",
                "CNginx",
                "sa_cross_stage_comp_000",
                Set.of(),
                Set.of("sa_cross_stage_comp_000_vuln_0"),
                Set.of("CVE-2024-7347")));
        instance.addedFunctions.add(new SelfAdaptationInstance.AddedFunction(
                "sa_cross_stage_fn_000",
                "FUploadVideo",
                "sa_cross_stage_fn_000",
                Set.of("pd1"),
                Set.of("PComments"),
                Set.of("sa_cross_stage_comp_000")));
        instance.removedFunctionIds.add("f1");
        instance.removedComponentIds.add("c1");
        return instance;
    }
}
