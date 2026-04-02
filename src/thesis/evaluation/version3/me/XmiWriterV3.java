package thesis.evaluation.version3.me;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.Map;

import org.eclipse.emf.ecore.resource.Resource;
import org.eclipse.emf.ecore.xmi.XMLResource;

final class XmiWriterV3 {
    Path write(Resource resource, Path xmiPath) throws IOException {
        Files.createDirectories(xmiPath.getParent());
        Map<Object, Object> options = new HashMap<>();
        options.put(XMLResource.OPTION_DECLARE_XML, Boolean.TRUE);
        options.put(XMLResource.OPTION_SCHEMA_LOCATION, Boolean.FALSE);
        options.put(XMLResource.OPTION_USE_ENCODED_ATTRIBUTE_STYLE, Boolean.TRUE);
        options.put(XMLResource.OPTION_SAVE_ONLY_IF_CHANGED,
                XMLResource.OPTION_SAVE_ONLY_IF_CHANGED_MEMORY_BUFFER);
        resource.save(options);
        return xmiPath;
    }
}
