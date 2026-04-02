package thesis;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SWIMObservation {
	public double basic_response_time;
	public double opt_response_time;
	public double basic_throughput;
	public double opt_throughput;
	public double avg_response_time;
	public double utilization;
	public double current_dimmer;
	public int servers;
	public double active_servers;
	public int max_servers;
	public boolean is_booting;
	public int boot_remaining;
	public double request_arrival_mean;
	public double request_arrival_variance;
	public double low_fidelity_service_time;
	public double low_fidelity_service_time_variance;
	public double service_time;
	public double service_time_variance;
	public int server_threads;
	public double threshold_response_time;
	public double dimmer_step;
	
    @JsonCreator
    public SWIMObservation(
        @JsonProperty("basic_response_time") double basic_response_time,
        @JsonProperty("opt_response_time") double opt_response_time,
        @JsonProperty("basic_throughput") double basic_throughput,
        @JsonProperty("opt_throughput") double opt_throughput,
        @JsonProperty("avg_response_time") double avg_response_time,
        @JsonProperty("utilization") double utilization,
        @JsonProperty("current_dimmer") double current_dimmer,
        @JsonProperty("servers") int servers,
        @JsonProperty("active_servers") double active_servers,
        @JsonProperty("max_servers") int max_servers,
        @JsonProperty("is_booting") boolean is_booting,
        @JsonProperty("boot_remaining") int boot_remaining,
        @JsonProperty("request_arrival_mean") double request_arrival_mean,
        @JsonProperty("request_arrival_variance") double request_arrival_variance,
        @JsonProperty("low_fidelity_service_time") double low_fidelity_service_time,
        @JsonProperty("low_fidelity_service_time_variance") double low_fidelity_service_time_variance,
        @JsonProperty("service_time") double service_time,
        @JsonProperty("service_time_variance") double service_time_variance,
        @JsonProperty("server_threads") int server_threads,
        @JsonProperty("threshold_response_time") double threshold_response_time,
        @JsonProperty("dimmer_step") double dimmer_step
    ) {
        this.basic_response_time = basic_response_time;
        this.opt_response_time = opt_response_time;
        this.basic_throughput = basic_throughput;
        this.opt_throughput = opt_throughput;
        this.avg_response_time = avg_response_time;
        this.utilization = utilization;
        this.current_dimmer = current_dimmer;
        this.servers = servers;
        this.active_servers = active_servers;
        this.max_servers = max_servers;
        this.is_booting = is_booting;
        this.boot_remaining = boot_remaining;
        this.request_arrival_mean = request_arrival_mean;
        this.request_arrival_variance = request_arrival_variance;
        this.low_fidelity_service_time = low_fidelity_service_time;
        this.low_fidelity_service_time_variance = low_fidelity_service_time_variance;
        this.service_time = service_time;
        this.service_time_variance = service_time_variance;
        this.server_threads = server_threads;
        this.threshold_response_time = threshold_response_time;
        this.dimmer_step = dimmer_step;
    }
}
