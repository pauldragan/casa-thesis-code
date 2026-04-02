package thesis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SWIMDefaultReactiveAdaptationManagerV2 extends SWIMAdaptationManagerBase {

	private static final Logger logger = LoggerFactory.getLogger(SWIMDefaultReactiveAdaptationManagerV2.class);
	private static final StatsCollector collector = StatsCollector.getInstance();

	public SWIMDefaultReactiveAdaptationManagerV2(CASABase casa) {
		super(casa);
	}

	@Override
	public SWIMAdaptation planAdaptation(SWIMReceivedStruct swimReceivedStruct) {
		final SWIMObservation obs = swimReceivedStruct.observation;
		SWIMAdaptation adaptation = new SWIMAdaptation(false, false, obs.current_dimmer);

		final double runtimeThreshold = obs.threshold_response_time;
		final double dimmerStep = obs.dimmer_step;

		if (obs.avg_response_time > runtimeThreshold) {
			if (!obs.is_booting && obs.servers < obs.max_servers) {
				adaptation.add_server = true;
			} else if (obs.current_dimmer > 0.0) {
				adaptation.dimmer = Math.max(0.0, obs.current_dimmer - dimmerStep);
			}
		} else if (obs.avg_response_time < runtimeThreshold) {
			if (obs.current_dimmer < 1.0) {
				double newDimmer = Math.min(1.0, obs.current_dimmer + dimmerStep);
				logger.info("Changing dimmer to " + newDimmer);
				adaptation.dimmer = newDimmer;
			} else if (!obs.is_booting && obs.servers > 1) {
				adaptation.remove_server = true;
			}

		}

		return adaptation;
	}
}
