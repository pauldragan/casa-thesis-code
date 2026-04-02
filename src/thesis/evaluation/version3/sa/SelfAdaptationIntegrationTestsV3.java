package thesis.evaluation.version3.sa;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.ecore.EAttribute;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class SelfAdaptationIntegrationTestsV3 {
    private SelfAdaptationIntegrationTestsV3() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.henshinMappingContainsExpectedAddAndRemoveRules",
                SelfAdaptationIntegrationTestsV3::henshinMappingContainsExpectedAddAndRemoveRules);
        TestSupportV3.run("sa.henshinMappingEmitsNoSpuriousRules",
                SelfAdaptationIntegrationTestsV3::henshinMappingEmitsNoSpuriousRules);
    }

    private static void henshinMappingContainsExpectedAddAndRemoveRules() {
        SelfAdaptationInstance instance = fixtureInstance();
        Module module = new HenshinTransformationMapperV3().map(instance, sourceModel());

        TestSupportV3.equals(instance.adaptationId, module.getName(), "Module name should match adaptation id");
        TestSupportV3.equals(5, module.getUnits().size(), "Module should contain one sequence and four rules");
        TestSupportV3.equals(1, module.getImports().size(), "Module should import the CASA metamodel exactly once");
        TestSupportV3.check(module.getUnits().get(0) instanceof SequentialUnit, "First unit should be the sequential unit");

        SequentialUnit sequence = (SequentialUnit) module.getUnits().get(0);
        TestSupportV3.equals(4, sequence.getSubUnits().size(), "Sequence should include all four concrete rules");

        Rule addComponent = rule(module, "AddComponent_sa_000000_000_afs_comp_000");
        Rule addFunction = rule(module, "AddFunction_sa_000000_000_afs_fn_000");
        Rule removeFunction = rule(module, "RemoveFunction_f1");
        Rule removeComponent = rule(module, "RemoveComponent_c1");

        TestSupportV3.check(findNodeByType(addComponent.getRhs(), "Nginx") != null,
                "AddComponent rule should create the mapped component subtype");
        TestSupportV3.check(findNodeByType(addComponent.getRhs(), "CVE_2024_7347") != null,
                "AddComponent rule should create the concrete vulnerability subtype node");
        TestSupportV3.check(findNodeByType(addComponent.getRhs(), "CVSSVector") != null,
                "AddComponent rule should create a CVSSVector node");

        Node addedFunctionNode = findNodeByName(addFunction.getRhs(), "sa_000000_000_afs_fn_000");
        TestSupportV3.check(addedFunctionNode != null, "AddFunction rule should create the added function node");
        TestSupportV3.equals("UploadVideo", addedFunctionNode.getType().getName(),
                "AddFunction rule should use the mapped CASA function subtype");

        TestSupportV3.check(findNodeByName(removeFunction.getLhs(), "stream_1") != null,
                "RemoveFunction rule should match the source function on the LHS");
        TestSupportV3.check(findNodeByName(removeFunction.getRhs(), "stream_1") == null,
                "RemoveFunction rule should remove the function from the RHS");

        TestSupportV3.check(findNodeByName(removeComponent.getLhs(), "nginx_1") != null,
                "RemoveComponent rule should match the source component on the LHS");
        TestSupportV3.check(findNodeByName(removeComponent.getRhs(), "nginx_1") == null,
                "RemoveComponent rule should remove the component from the RHS");
    }

    private static void henshinMappingEmitsNoSpuriousRules() {
        Module module = new HenshinTransformationMapperV3().map(fixtureInstance(), sourceModel());
        Set<String> actualRuleNames = module.getUnits().stream()
                .filter(Rule.class::isInstance)
                .map(unit -> unit.getName())
                .collect(Collectors.toCollection(LinkedHashSet::new));
        Set<String> expectedRuleNames = Set.of(
                "AddComponent_sa_000000_000_afs_comp_000",
                "AddFunction_sa_000000_000_afs_fn_000",
                "RemoveFunction_f1",
                "RemoveComponent_c1");
        TestSupportV3.equals(expectedRuleNames, actualRuleNames,
                "Henshin mapper should emit exactly the expected add/remove rules for the fixture");
    }

    private static Rule rule(Module module, String name) {
        return module.getUnits().stream()
                .filter(Rule.class::isInstance)
                .map(Rule.class::cast)
                .filter(rule -> name.equals(rule.getName()))
                .findFirst()
                .orElseThrow(() -> new AssertionError("Expected rule not found: " + name));
    }

    private static Node findNodeByType(Graph graph, String typeName) {
        return graph.getNodes().stream()
                .filter(node -> node.getType() != null && typeName.equals(node.getType().getName()))
                .findFirst()
                .orElse(null);
    }

    private static Node findNodeByName(Graph graph, String expectedName) {
        return graph.getNodes().stream()
                .filter(node -> expectedName.equals(attributeValue(node, "name")))
                .findFirst()
                .orElse(null);
    }

    private static String attributeValue(Node node, String attributeName) {
        return node.getAttributes().stream()
                .filter(attr -> attr.getType() != null && attributeName.equals(attr.getType().getName()))
                .map(Attribute::getValue)
                .map(SelfAdaptationIntegrationTestsV3::unquote)
                .findFirst()
                .orElse(null);
    }

    private static String unquote(String value) {
        if (value == null || value.length() < 2) {
            return value;
        }
        if (value.startsWith("\"") && value.endsWith("\"")) {
            return value.substring(1, value.length() - 1);
        }
        return value;
    }

    private static SourceManagedElementInstance sourceModel() {
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

    private static SelfAdaptationInstance fixtureInstance() {
        SelfAdaptationInstance instance = new SelfAdaptationInstance();
        instance.adaptationId = "sa_000000_000_afs";
        instance.sourceModelId = "me_000000";
        instance.addedComponents.add(new SelfAdaptationInstance.AddedComponent(
                "sa_000000_000_afs_comp_000",
                "CNginx",
                "sa_000000_000_afs_comp_000",
                Set.of("f1"),
                Set.of("sa_000000_000_afs_comp_000_vuln_0"),
                Set.of("CVE-2024-7347")));
        instance.addedFunctions.add(new SelfAdaptationInstance.AddedFunction(
                "sa_000000_000_afs_fn_000",
                "FUploadVideo",
                "sa_000000_000_afs_fn_000",
                Set.of("pd1"),
                Set.of("PComments"),
                Set.of("c1")));
        instance.removedFunctionIds.add("f1");
        instance.removedComponentIds.add("c1");
        return instance;
    }
}
