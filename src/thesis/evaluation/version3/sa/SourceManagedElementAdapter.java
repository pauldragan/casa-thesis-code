package thesis.evaluation.version3.sa;

import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;

import thesis.evaluation.version3.me.ManagedElementView;

public final class SourceManagedElementAdapter {
    private SourceManagedElementAdapter() {
    }

    public static SourceManagedElementProfile toProfile(ManagedElementView view) {
        Map<String, Integer> functionCountByType = new LinkedHashMap<>();
        view.functions.values().forEach(f -> functionCountByType.merge(f.type(), 1, Integer::sum));
        Map<String, Integer> componentCountByType = new LinkedHashMap<>();
        view.components.values().forEach(c -> componentCountByType.merge(c.type(), 1, Integer::sum));
        return new SourceManagedElementProfile(
                view.modelId,
                view.dataSubjects.size(),
                view.functions.size(),
                view.components.size(),
                functionCountByType,
                componentCountByType);
    }

    public static SourceManagedElementInstance toInstance(ManagedElementView view) {
        SourceManagedElementInstance snapshot = new SourceManagedElementInstance(view.modelId);
        view.dataSubjects.forEach((id, ds) -> snapshot.dataSubjects.put(
                id, new SourceManagedElementInstance.DataSubjectView(ds.id(), ds.type(), ds.name())));
        view.personalData.forEach((id, pd) -> snapshot.personalData.put(
                id, new SourceManagedElementInstance.PersonalDataView(pd.id(), pd.type(), pd.name(), pd.identifiesDsId())));
        view.functions.forEach((id, f) -> snapshot.functions.put(
                id,
                new SourceManagedElementInstance.FunctionView(
                        f.id(),
                        f.type(),
                        f.name(),
                        new LinkedHashSet<>(f.realizedByComponentIds()),
                        new LinkedHashSet<>(f.processesPersonalDataIds()),
                        new LinkedHashSet<>(f.hasPurposeIds()))));
        view.components.forEach((id, c) -> snapshot.components.put(
                id, new SourceManagedElementInstance.ComponentView(c.id(), c.type(), c.name())));
        view.purposes.forEach((id, p) -> snapshot.purposes.put(
                id, new SourceManagedElementInstance.PurposeView(p.id(), p.type(), p.name())));
        view.vulnerabilities.forEach((id, v) -> snapshot.vulnerabilities.put(
                id, new SourceManagedElementInstance.VulnerabilityView(v.id(), v.cveName(), v.componentTypeOwner())));
        view.consents.forEach((id, c) -> snapshot.consents.put(
                id, new SourceManagedElementInstance.ConsentView(c.id(), c.givenByDsId(), c.forPersonalDataId(), c.givenForPurposeId())));
        return snapshot;
    }
}
