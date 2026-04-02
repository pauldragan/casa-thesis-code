package thesis.evaluation.version3.me;

final class StatsCollectorV3 {

    ModelStats compute(ManagedElementInstance me) {
        ModelStats stats = new ModelStats();

        me.dataSubjects.values().forEach(n -> inc(stats.countByType, n.type));
        me.personalData.values().forEach(n -> inc(stats.countByType, n.type));
        me.functions.values().forEach(n -> inc(stats.countByType, n.type));
        me.components.values().forEach(n -> inc(stats.countByType, n.type));
        me.purposes.values().forEach(n -> inc(stats.countByType, n.type));
        me.vulnerabilities.values().forEach(n -> inc(stats.countByType, n.cveName));
        me.consents.values().forEach(n -> inc(stats.countByType, "Consent"));

        me.edges.forEach(e -> inc(stats.relationCountByType, e.type));

        stats.totalInstances =
                me.dataSubjects.size()
                        + me.personalData.size()
                        + me.functions.size()
                        + me.components.size()
                        + me.purposes.size()
                        + me.vulnerabilities.size()
                        + me.consents.size();
        stats.totalRelations = me.edges.size();
        stats.connectivity = stats.totalInstances == 0 ? 0.0 : ((double) stats.totalRelations) / stats.totalInstances;

        return stats;
    }

    private static void inc(java.util.Map<String, Integer> map, String key) {
        map.put(key, map.getOrDefault(key, 0) + 1);
    }
}
