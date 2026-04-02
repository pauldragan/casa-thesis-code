package thesis.evaluation.version3.sa;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class PurposeSemanticsV3Tests {
    private PurposeSemanticsV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.PurposeSemanticsV3.detectsSpecializationCompatibility",
                PurposeSemanticsV3Tests::detectsSpecializationCompatibility);
        TestSupportV3.run("sa.PurposeSemanticsV3.detectsGeneralizationOrUnrelatedIncompatibility",
                PurposeSemanticsV3Tests::detectsGeneralizationOrUnrelatedIncompatibility);
    }

    private static void detectsSpecializationCompatibility() {
        PurposeSemanticsV3 semantics = new PurposeSemanticsV3();
        TestSupportV3.check(semantics.isSameOrSpecialization("PComments", "PSocial"),
                "PComments should be compatible with PSocial by specialization");
        TestSupportV3.check(semantics.isSameOrSpecialization("PBehaviorTargetedAds", "PMarketing"),
                "PBehaviorTargetedAds should be compatible with PMarketing by specialization chain");
    }

    private static void detectsGeneralizationOrUnrelatedIncompatibility() {
        PurposeSemanticsV3 semantics = new PurposeSemanticsV3();
        TestSupportV3.check(semantics.isGeneralizationOrUnrelated("PSocial", "PComments"),
                "PSocial should count as incompatible with PComments for afp generation");
        TestSupportV3.check(semantics.isGeneralizationOrUnrelated("PMarketing", "PComments"),
                "Unrelated purposes should count as incompatible");
    }
}
