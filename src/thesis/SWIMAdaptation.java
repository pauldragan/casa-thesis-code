package thesis;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SWIMAdaptation {
    public boolean add_server;
    public boolean remove_server;
    public double dimmer;
    
    public Map<String, Object> otherStats;

    @JsonCreator
    public SWIMAdaptation(
        @JsonProperty("add_server") boolean add_server,
        @JsonProperty("remove_server") boolean remove_server,
        @JsonProperty("dimmer") double dimmer,
        @JsonProperty("other_stats") Map<String, Object> otherStats
    ) {
        this.add_server = add_server;
        this.remove_server = remove_server;
        this.dimmer = dimmer;
        
        this.otherStats = otherStats;
    }
    
    @JsonCreator
    public SWIMAdaptation(
        @JsonProperty("add_server") boolean add_server,
        @JsonProperty("remove_server") boolean remove_server,
        @JsonProperty("dimmer") double dimmer
    ) {
        this.add_server = add_server;
        this.remove_server = remove_server;
        this.dimmer = dimmer;
        
        this.otherStats = new HashMap<>();
    }
    
    @Override
    public String toString() {
    	return "[" + this.getClass().getName() + "@" 
                   + Integer.toHexString(hashCode()) + ": " 
    			   + "[add_server=" + this.add_server + "], "
    			   + "[remove_server=" + this.remove_server + "], "
    			   + "[dimmer=" + this.dimmer + "]";
    }
}
