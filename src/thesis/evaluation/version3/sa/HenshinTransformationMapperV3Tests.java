package thesis.evaluation.version3.sa;

import java.util.LinkedHashSet;
import java.util.Set;
import java.util.stream.Collectors;

import org.eclipse.emf.henshin.model.Attribute;
import org.eclipse.emf.henshin.model.Graph;
import org.eclipse.emf.henshin.model.Module;
import org.eclipse.emf.henshin.model.Node;
import org.eclipse.emf.henshin.model.Rule;
import org.eclipse.emf.henshin.model.SequentialUnit;

import thesis.evaluation.version3.tests.TestSupportV3;

public final class HenshinTransformationMapperV3Tests {
    private HenshinTransformationMapperV3Tests() {
    }

    public static void runAll() {
        TestSupportV3.run("sa.HenshinTransformationMapperV3.emitsExpectedRulesAndNodes",
                HenshinTransformationMapperV3Tests::emitsExpectedRulesAndNodes);
        TestSupportV3.run("sa.HenshinTransformationMapperV3.emitsNoSpuriousRules",
                HenshinTransformationMapperV3Tests::emitsNoSpuriousRules);
    }

    private static void emitsExpectedRulesAndNodes() {
        Module module = new HenshinTransformationMapperV3().map(SelfAdaptationTestFixturesV3.crossStageAdaptationInstance(),
                SelfAdaptationTestFixturesV3.crossStageSourceInstance());

        TestSupportV3.equals("sa_cross_stage", module.getName(), "Module name should match adaptation id");
        TestSupportV3.check(module.getUnits().get(0) instanceof SequentialUnit, "First unit should be the sequence");

        SequentialUnit sequence = (SequentialUnit) module.getUnits().get(0);
        TestSupportV3.equals(4, sequence.getSubUnits().size(), "Sequence should include all generated rules");

        Rule addComponent = rule(module, "AddComponent_sa_cross_stage_comp_000");
        Rule addFunction = rule(module, "AddFunction_sa_cross_stage_fn_000");
        Rule removeFunction = rule(module, "RemoveFunction_f1");
        Rule removeComponent = rule(module, "RemoveComponent_c1");

        TestSupportV3.check(findNodeByType(addComponent.getRhs(), "Nginx") != null,
                "AddComponent should create the mapped CASA component subtype");
        TestSupportV3.check(findNodeByType(addComponent.getRhs(), "CVE_2024_7347") != null,
                "AddComponent should create the concrete vulnerability subtype");
        TestSupportV3.check(findNodeByType(addComponent.getRhs(), "CVSSVector") != null,
                "AddComponent should create the CVSSVector");

        Node addedFunctionNode = findNodeByName(addFunction.getRhs(), "sa_cross_stage_fn_000");
        TestSupportV3.check(addedFunctionNode != null, "AddFunction should create the added function");
        TestSupportV3.equals("UploadVideo", addedFunctionNode.getType().getName(),
                "AddFunction should use the mapped CASA function subtype");

        TestSupportV3.check(findNodeByName(removeFunction.getLhs(), "stream_1") != null,
                "RemoveFunction should match the original function on the LHS");
        TestSupportV3.check(findNodeByName(removeFunction.getRhs(), "stream_1") == null,
                "RemoveFunction should remove the function from the RHS");
        TestSupportV3.check(findNodeByName(removeComponent.getLhs(), "nginx_1") != null,
                "RemoveComponent should match the original component on the LHS");
        TestSupportV3.check(findNodeByName(removeComponent.getRhs(), "nginx_1") == null,
                "RemoveComponent should remove the component from the RHS");
    }

    private static void emitsNoSpuriousRules() {
        Module module = new HenshinTransformationMapperV3().map(SelfAdaptationTestFixturesV3.crossStageAdaptationInstance(),
                SelfAdaptationTestFixturesV3.crossStageSourceInstance());
        Set<String> actualRuleNames = module.getUnits().stream()
                .filter(Rule.class::isInstance)
                .map(unit -> unit.getName())
                .collect(Collectors.toCollection(LinkedHashSet::new));

        TestSupportV3.equals(Set.of(
                "AddComponent_sa_cross_stage_comp_000",
                "AddFunction_sa_cross_stage_fn_000",
                "RemoveFunction_f1",
                "RemoveComponent_c1"), actualRuleNames,
                "Henshin mapper should emit exactly the expected rules");
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
                .map(HenshinTransformationMapperV3Tests::unquote)
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
}
