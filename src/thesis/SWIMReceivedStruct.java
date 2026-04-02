package thesis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SWIMReceivedStruct {
    public SWIMObservation observation;
    public double utility;

    @JsonCreator
    public SWIMReceivedStruct(
        @JsonProperty("observation") SWIMObservation observation,
        @JsonProperty("utility") double utility
    ) {
        this.observation = observation;
        this.utility = utility;
    }
}
