package thesis;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class StatsCollector {
    private static final StatsCollector INSTANCE = new StatsCollector();
    private final Map<String, List<Object>> stats = new ConcurrentHashMap<>();

    // Private constructor for Singleton
    private StatsCollector() {}

    public static StatsCollector getInstance() {
        return INSTANCE;
    }

    // Generic method to record any type of value
    public void record(String key, Object value) {
        stats.computeIfAbsent(key, k -> Collections.synchronizedList(new ArrayList<>())).add(value);
    }
    
    public Set<String> getKeys() {
    	return stats.keySet();
    }

    // Generic retrieval: Get all values as List<Object>
    public List<Object> getStats(String key) {
        return stats.getOrDefault(key, Collections.emptyList());
    }

    // Type-safe retrieval methods
    public List<Integer> getIntStats(String key) {
        return getStatsByType(key, Integer.class);
    }

    public List<Double> getDoubleStats(String key) {
        return getStatsByType(key, Double.class);
    }

    public List<String> getStringStats(String key) {
        return getStatsByType(key, String.class);
    }
    
    public List<Boolean> getBooleanStats(String key) {
        return getStatsByType(key, Boolean.class);
    }

    private <T> List<T> getStatsByType(String key, Class<T> type) {
        List<Object> rawValues = stats.getOrDefault(key, Collections.emptyList());
        List<T> typedValues = new ArrayList<>();
        for (Object value : rawValues) {
            if (type.isInstance(value)) {
                typedValues.add(type.cast(value));
            }
        }
        return typedValues;
    }

    // Save statistics to a CSV file
    public void saveToFile(String filename) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            for (var entry : stats.entrySet()) {
                writer.write(entry.getKey() + "," + entry.getValue().toString().replaceAll("[\\[\\]]", ""));
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Clear collected stats (useful after saving)
    public void clear() {
        stats.clear();
    }
}