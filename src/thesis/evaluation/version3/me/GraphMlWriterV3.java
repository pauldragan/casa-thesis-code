package thesis.evaluation.version3.me;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

final class GraphMlWriterV3 {

    Path write(ManagedElementInstance me, Path graphPath) throws IOException {
        Files.createDirectories(graphPath.getParent());
        StringBuilder sb = new StringBuilder(256 * 1024);

        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n");
        sb.append("<graphml xmlns=\"http://graphml.graphdrawing.org/xmlns\" ");
        sb.append("xmlns:xsi=\"http://www.w3.org/2001/XMLSchema-instance\" ");
        sb.append("xsi:schemaLocation=\"http://graphml.graphdrawing.org/xmlns ");
        sb.append("http://graphml.graphdrawing.org/xmlns/1.0/graphml.xsd\">\n");
        sb.append("  <key id=\"node_type\" for=\"node\" attr.name=\"type\" attr.type=\"string\"/>\n");
        sb.append("  <key id=\"node_group\" for=\"node\" attr.name=\"group\" attr.type=\"string\"/>\n");
        sb.append("  <key id=\"node_label\" for=\"node\" attr.name=\"label\" attr.type=\"string\"/>\n");
        sb.append("  <key id=\"edge_type\" for=\"edge\" attr.name=\"type\" attr.type=\"string\"/>\n");
        sb.append("  <graph id=\"").append(xml(me.modelId)).append("\" edgedefault=\"directed\">\n");

        me.dataSubjects.values().forEach(n -> appendNode(sb, n.id, n.type, "DataSubject", n.name));
        me.personalData.values().forEach(n -> appendNode(sb, n.id, n.type, "PersonalData", n.name));
        me.functions.values().forEach(n -> appendNode(sb, n.id, n.type, "Function", n.name));
        me.components.values().forEach(n -> appendNode(sb, n.id, n.type, "Component", n.name));
        me.purposes.values().forEach(n -> appendNode(sb, n.id, n.type, "Purpose", n.name));
        me.vulnerabilities.values().forEach(n -> appendNode(sb, n.id, "Vulnerability", "Vulnerability", n.cveName));
        me.consents.values().forEach(n -> appendNode(sb, n.id, "Consent", "Consent", n.id));

        int edgeIdx = 0;
        for (ManagedElementInstance.Edge e : me.edges) {
            sb.append("    <edge id=\"e").append(edgeIdx++).append("\" source=\"")
                    .append(xml(e.srcId)).append("\" target=\"").append(xml(e.dstId)).append("\">\n");
            sb.append("      <data key=\"edge_type\">").append(xml(e.type)).append("</data>\n");
            sb.append("    </edge>\n");
        }

        sb.append("  </graph>\n");
        sb.append("</graphml>\n");

        Files.writeString(graphPath, sb.toString(), StandardCharsets.UTF_8);
        return graphPath;
    }

    private static void appendNode(StringBuilder sb, String id, String type, String group, String label) {
        sb.append("    <node id=\"").append(xml(id)).append("\">\n");
        sb.append("      <data key=\"node_type\">").append(xml(type)).append("</data>\n");
        sb.append("      <data key=\"node_group\">").append(xml(group)).append("</data>\n");
        sb.append("      <data key=\"node_label\">").append(xml(label)).append("</data>\n");
        sb.append("    </node>\n");
    }

    private static String xml(String value) {
        if (value == null) {
            return "";
        }
        return value
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&apos;");
    }
}
