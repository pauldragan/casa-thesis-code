package thesis.evaluation.version3.sa;

import java.nio.file.Files;
import java.nio.file.Path;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.resource.HenshinResourceSet;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class HenshinTransformationWriterV3Tests {
    private HenshinTransformationWriterV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.HenshinTransformationWriterV3.writesModuleAndCopiesCasaEcore",
                HenshinTransformationWriterV3Tests::writesModuleAndCopiesCasaEcore);
    }

    private static void writesModuleAndCopiesCasaEcore() {
        try {
            Path dir = Files.createTempDirectory("v3_henshin_writer_");
            Path out = dir.resolve("sa_cross_stage.henshin");
            Module module = new HenshinTransformationMapperV3().map(
                    SelfAdaptationTestFixturesV3.crossStageAdaptationInstance(),
                    SelfAdaptationTestFixturesV3.crossStageSourceInstance());

            Path written = new HenshinTransformationWriterV3().write(module, out);

            TestSupportV3.check(Files.exists(written), "Writer should persist the henshin module");
            TestSupportV3.check(Files.exists(dir.resolve("CASA.ecore")), "Writer should copy CASA.ecore next to the henshin file");

            HenshinResourceSet rs = new HenshinResourceSet(dir.toAbsolutePath().toString());
            Resource resource = rs.getResource(written.getFileName().toString());
            Module reloaded = (Module) resource.getContents().get(0);
            TestSupportV3.equals("sa_cross_stage", reloaded.getName(), "Reloaded module should keep its name");
            TestSupportV3.equals(1, reloaded.getImports().size(), "Reloaded module should keep a single imported package");
            TestSupportV3.check(!reloaded.getUnits().isEmpty(), "Reloaded module should keep its units");
        } catch (Exception e) {
            throw new AssertionError("HenshinTransformationWriterV3 test failed: " + e.getMessage(), e);
        }
    }
}
