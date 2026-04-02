package thesis.evaluation.version3.me;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class RulePrunerV3Tests {
    private RulePrunerV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("me.RulePrunerV3.removesUnusedFunctionsComponentsAndDanglingConsentClosure",
                RulePrunerV3Tests::removesUnusedFunctionsComponentsAndDanglingConsentClosure);
    }

    private static void removesUnusedFunctionsComponentsAndDanglingConsentClosure() {
        ManagedElementInstance me = fixture();
        PruneResult result = new RulePrunerV3().prune(me);

        TestSupportV3.equals(1, result.removedFunctions, "Pruner should remove functions with no processed PD");
        TestSupportV3.equals(1, result.removedComponents, "Pruner should remove components that realize no remaining function");
        TestSupportV3.equals(1, result.removedDataSubjects, "Pruner should remove data subjects with no processed PD remaining");
        TestSupportV3.equals(1, result.removedPersonalData, "Pruner should remove personal data owned only by removed data subjects");
        TestSupportV3.equals(1, result.removedConsents, "Pruner should remove dangling consents");

        TestSupportV3.check(me.functions.containsKey("fn_keep"), "Pruner should keep functions with processed PD");
        TestSupportV3.check(!me.functions.containsKey("fn_drop"), "Pruner should remove unused functions");
        TestSupportV3.check(me.components.containsKey("c_keep"), "Pruner should keep realized components");
        TestSupportV3.check(!me.components.containsKey("c_drop"), "Pruner should remove unrealized components");
        TestSupportV3.check(me.dataSubjects.containsKey("ds_keep"), "Pruner should keep connected data subjects");
        TestSupportV3.check(!me.dataSubjects.containsKey("ds_drop"), "Pruner should remove disconnected data subjects");
        TestSupportV3.check(!me.consents.containsKey("cons_drop"), "Pruner should remove dangling consents");
    }

    private static ManagedElementInstance fixture() {
        ManagedElementInstance me = new ManagedElementInstance("me_prune");
        me.dataSubjects.put("ds_keep", new ManagedElementInstance.DataSubjectNode("ds_keep", "DSUser", "ds_keep"));
        me.dataSubjects.put("ds_drop", new ManagedElementInstance.DataSubjectNode("ds_drop", "DSUser", "ds_drop"));
        me.personalData.put("pd_keep", new ManagedElementInstance.PersonalDataNode("pd_keep", "PDComment", "pd_keep", "ds_keep"));
        me.personalData.put("pd_drop", new ManagedElementInstance.PersonalDataNode("pd_drop", "PDComment", "pd_drop", "ds_drop"));
        me.functions.put("fn_keep", new ManagedElementInstance.FunctionNode("fn_keep", "FUploadVideo", "fn_keep"));
        me.functions.put("fn_drop", new ManagedElementInstance.FunctionNode("fn_drop", "FUploadVideo", "fn_drop"));
        me.components.put("c_keep", new ManagedElementInstance.ComponentNode("c_keep", "CNginx", "c_keep"));
        me.components.put("c_drop", new ManagedElementInstance.ComponentNode("c_drop", "CNginx", "c_drop"));
        me.purposes.put("PComments", new ManagedElementInstance.PurposeNode("PComments", "PComments", "PComments"));
        me.consents.put("cons_keep", new ManagedElementInstance.ConsentNode("cons_keep", "ds_keep", "pd_keep", "PComments"));
        me.consents.put("cons_drop", new ManagedElementInstance.ConsentNode("cons_drop", "ds_drop", "pd_drop", "PComments"));

        me.functions.get("fn_keep").processesPersonalDataIds.add("pd_keep");
        me.functions.get("fn_keep").realizedByComponentIds.add("c_keep");
        me.functions.get("fn_keep").hasPurposeIds.add("PComments");
        me.functions.get("fn_drop").realizedByComponentIds.add("c_drop");
        me.functions.get("fn_drop").hasPurposeIds.add("PComments");

        me.addEdge("identifies", "pd_keep", "ds_keep");
        me.addEdge("identifies", "pd_drop", "ds_drop");
        me.addEdge("processes", "fn_keep", "pd_keep");
        me.addEdge("processes", "fn_drop", "pd_drop");
        me.addEdge("realizedBy", "fn_keep", "c_keep");
        me.addEdge("realizedBy", "fn_drop", "c_drop");
        me.addEdge("consent", "ds_keep", "cons_keep");
        me.addEdge("consent", "ds_drop", "cons_drop");
        return me;
    }
}
