package thesis;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.TimeUnit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.Stopwatch;

import thesis.CASABase.CASA_DECISION;

public class SWIMAdaptationManagerBase implements TcpClientSubscriber {
	
	enum AdaptationStatus {
		NO_ADAPTATION(0),
		CONSENT_NOT_VIOLATED(1),
		CONSENT_VIOLATED_AND_EXCLUDED(2),
		CONSENT_VIOLATED(3);
		
		private final int value;
		
		AdaptationStatus(int value) {
			this.value = value;
		}
		
		public int getValue() {
			return value;
		}
	}
	
	private static final StatsCollector collector = StatsCollector.getInstance();
	
	private static final Logger logger = LoggerFactory.getLogger(SWIMAdaptationManagerBase.class);
	
	private CASABase casa;
	
	private boolean ignoreCASADecision;
	
	private double previousRiskLevel = 0.0;
	
	public SWIMAdaptationManagerBase(CASABase casa) {
		this.casa = casa;
		this.ignoreCASADecision = false;
	}
		
	public static SWIMAdaptation getNoAdaptation(SWIMReceivedStruct swimReceivedStruct) {
		return new SWIMAdaptation(false, false, swimReceivedStruct.observation.current_dimmer);
	}
	
	public SWIMAdaptation planAdaptation(SWIMReceivedStruct swimReceivedStruct) {
		SWIMAdaptation adaptation = new SWIMAdaptation(false, false, swimReceivedStruct.observation.current_dimmer);
		return adaptation;
	}
	
	public static boolean isChanged(SWIMReceivedStruct swimReceivedStruct, SWIMAdaptation adaptation) {
		if (adaptation.add_server == true
				|| adaptation.remove_server == true
				|| adaptation.dimmer != swimReceivedStruct.observation.current_dimmer) {
			return true;
		}
		return false;
	}
	
	public void ignoreCASADecision() {
		this.ignoreCASADecision = true;
	}
	
	public void doNotIgnoreCASADecision() {
		this.ignoreCASADecision = false;
	}
	
	@Override
	public Optional<String> processMessage(String message) {
		collector.clear();
		
		ObjectMapper objectMapper = new ObjectMapper();
		Optional<String> response = Optional.empty();
		AdaptationStatus adaptStat = AdaptationStatus.NO_ADAPTATION;
	    try {
	    	SWIMReceivedStruct swimReceivedStruct = objectMapper.readValue(message, SWIMReceivedStruct.class);
			logger.info(message);
			logger.info(swimReceivedStruct.toString());
			
			SWIMAdaptation adaptation = this.planAdaptation(swimReceivedStruct);
			logger.info("Adaptation before CASA: " + adaptation);
			
			boolean isTrueAdapt = isChanged(swimReceivedStruct, adaptation);
			if (isTrueAdapt) {
				collector.record("adaptationTick", 1);
				adaptStat = AdaptationStatus.CONSENT_NOT_VIOLATED;
			} else {
				collector.record("adaptationTick", 0);
				adaptStat = AdaptationStatus.NO_ADAPTATION;
			}
			
			Stopwatch stopwatch = Stopwatch.createStarted();
			CASABase.CASA_DECISION casaDecision = this.casa.analyzeAdaptation(swimReceivedStruct, adaptation);
			stopwatch.stop();
			collector.record("casaExecTimeMillis", (double) stopwatch.elapsed(TimeUnit.MILLISECONDS));

			SWIMAdaptation postCASAAdaptation;
			if (ignoreCASADecision) { 
				// CASA decision is ignored.
				logger.info("Adaptation was accepted. CASA decision ignored: " + casaDecision);
				postCASAAdaptation = adaptation;
				collector.record("adaptationExcluded", false);
				if (casaDecision != CASA_DECISION.OK && isTrueAdapt) {
					adaptStat = AdaptationStatus.CONSENT_VIOLATED;
				} else if (casaDecision == CASA_DECISION.OK && isTrueAdapt) {
					adaptStat = AdaptationStatus.CONSENT_NOT_VIOLATED;
				} else {
					adaptStat = AdaptationStatus.NO_ADAPTATION;
				}
			} else {
				if (casaDecision == CASABase.CASA_DECISION.OK && isTrueAdapt) {
					logger.info("Adaptation was accepted.");
					postCASAAdaptation = adaptation;
					collector.record("adaptationExcluded", false);
					adaptStat = AdaptationStatus.CONSENT_NOT_VIOLATED;
				} else if (casaDecision != CASABase.CASA_DECISION.OK && isTrueAdapt) {
					logger.info("Adaptation was excluded.");
					postCASAAdaptation = SWIMAdaptationManagerBase.getNoAdaptation(swimReceivedStruct);
					collector.record("adaptationExcluded", true);
					adaptStat = AdaptationStatus.CONSENT_VIOLATED_AND_EXCLUDED;
				} else {
					logger.info("There was no adaptation.");
					postCASAAdaptation = adaptation;
					collector.record("adaptationExcluded", false);
					adaptStat = AdaptationStatus.NO_ADAPTATION;
				}
			}
			collector.record("adaptationStatus", adaptStat.getValue());
			
			logger.info("Adaptation after CASA: " + postCASAAdaptation);
			
			int desiredServerChange = 0;
			if(adaptation.add_server && !adaptation.remove_server) {
				desiredServerChange = 1;
			} else if (!adaptation.add_server && adaptation.remove_server) { 
				desiredServerChange = -1;
			}
			
			int desiredServers = swimReceivedStruct.observation.servers + desiredServerChange;
			
			collector.record("desiredServerChange", desiredServerChange);
			collector.record("desiredServers", desiredServers);
			collector.record("desiredDimmer", adaptation.dimmer);
			
			collector.record("exclusionReason", this.casa.getLastReason().getValue());
			
			List<Double> riskLevel = null;
			if (this.ignoreCASADecision) { // use the CASA-determine risk level
				riskLevel = collector.getDoubleStats("riskLevel");
				
				if (riskLevel.isEmpty() || !isTrueAdapt) {
					// riskLevel = List.of(this.previousRiskLevel);
					// this.previousRiskLevel = riskLevel.get(0);
					riskLevel = List.of(-1.0);
				} 
				
				this.previousRiskLevel = riskLevel.get(0);
			} else { // use the actual risk level if the self-adaptation is excluded
				List<Double> measuredRiskLevel = collector.getDoubleStats("riskLevel");
				List<Double> acceptableRiskLevel = collector.getDoubleStats("acceptableRiskLevel");
				
				if (measuredRiskLevel.isEmpty() || acceptableRiskLevel.isEmpty() || !isTrueAdapt) { 
					// use the previous risk level if the self-adaptation is excluded
					// because of purpose change
					// riskLevel = List.of(this.previousRiskLevel);
					riskLevel = List.of(-1.0);
				} else {
					if (acceptableRiskLevel.get(0) < measuredRiskLevel.get(0)) {
						if (this.previousRiskLevel == 0.0) {
							this.previousRiskLevel = acceptableRiskLevel.get(0);
						}
						riskLevel = List.of(this.previousRiskLevel);
						this.previousRiskLevel = riskLevel.get(0);
					} else {
						riskLevel = measuredRiskLevel;
						this.previousRiskLevel = riskLevel.get(0);
					}
//					riskLevel = List.of(Math.min(measuredRiskLevel.get(0),
//							                     acceptableRiskLevel.get(0)));
				}
			}
			
			postCASAAdaptation.otherStats.put("adaptationExcluded", collector.getBooleanStats("adaptationExcluded"));
			postCASAAdaptation.otherStats.put("riskConsentViolated", collector.getBooleanStats("riskConsentViolated"));
			postCASAAdaptation.otherStats.put("riskLevel", riskLevel);
			postCASAAdaptation.otherStats.put("purposeConsentViolated", collector.getBooleanStats("purposeConsentViolated"));
			postCASAAdaptation.otherStats.put("acceptableRiskLevel", collector.getDoubleStats("acceptableRiskLevel"));
			postCASAAdaptation.otherStats.put("desiredServerChange", collector.getIntStats("desiredServerChange"));
			postCASAAdaptation.otherStats.put("desiredServers", collector.getIntStats("desiredServers"));
			postCASAAdaptation.otherStats.put("desiredDimmer", collector.getDoubleStats("desiredDimmer"));
			postCASAAdaptation.otherStats.put("casaExecTimeMillis", collector.getDoubleStats("casaExecTimeMillis"));
			postCASAAdaptation.otherStats.put("exclusionProbability", collector.getDoubleStats("exclusionProbability"));
			postCASAAdaptation.otherStats.put("adaptationTick", collector.getIntStats("adaptationTick"));
			postCASAAdaptation.otherStats.put("adaptationStatus", collector.getIntStats("adaptationStatus"));
			postCASAAdaptation.otherStats.put("exclusionReason", collector.getIntStats("exclusionReason"));
			
		    String swimAdaptationJsonString = objectMapper.writeValueAsString(postCASAAdaptation);
		    logger.info("Prepared response: " + swimAdaptationJsonString);
			response = Optional.of(swimAdaptationJsonString);
	    } catch (JsonProcessingException e) {
	    	logger.error("Could not parse SWIM observation!");
			e.printStackTrace();
		}
		
	    return response;
	}

}
