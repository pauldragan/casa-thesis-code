package thesis;

import java.util.Optional;
import java.util.concurrent.TimeUnit;

import com.google.common.base.Stopwatch;

public class CASABase {
	
	private static final StatsCollector collector = StatsCollector.getInstance();
	
	public enum CASA_DECISION {
		OK,
		EXCLUDED
	}
	
	public static class CASABenchDecisionResult {
		public CASA_DECISION decision = CASA_DECISION.EXCLUDED;
		public Long elapsedTransform = 0L;
		public Long elapsedPurpose = 0L;
		public Long elapsedRisk = 0L;
	}
	
	public enum CASA_REASON {
		NOT_VIOLATED(0),
		PURPOSE_VIOLATED(1),
		RISK_VIOLATED(2);
		
		private int reason;
		
		CASA_REASON(int reason) {
			this.reason = reason;
		}
		
		public int getValue() {
			return reason;
		}
	}
	
	protected CASARuntimeModel casaModel;
	protected CASAPurpose casaPurpose;
	protected CASARisk casaRisk;
	
	protected boolean enabled = true;
	
	protected CASA_REASON lastReason;
	
	public CASABase(CASARuntimeModel casaModel, CASAPurpose casaPurpose, CASARisk casaRisk) {
		this.casaModel = casaModel;
		this.casaPurpose = casaPurpose;
		this.casaRisk = casaRisk;
		this.lastReason = CASA_REASON.NOT_VIOLATED;
	}
	
	public void disable() {
		enabled = false;
	}
	
	public void enable() {
		enabled = true;
	}
	
	public boolean getEnabled() {
		return enabled;
	}
	
	protected void setLastReason(CASA_REASON reason) {
		this.lastReason = reason;
	}
	
	public CASA_REASON getLastReason() {
		return this.lastReason;
	}
		
	public CASA_DECISION analyzeAdaptation(SWIMReceivedStruct swimReceivedStruct, SWIMAdaptation adaptation) {

		if (enabled) {
			casaModel.update(swimReceivedStruct);
			CASASelfAdaptationAnalysisModel adaptationAnalysisModel = casaModel.generateAnalysisModel(adaptation);
			
			Optional<CASASelfAdaptationAnalysisModel> analysisModelPurpOpt = casaPurpose.applyCASAPurpose(adaptationAnalysisModel);
			if (analysisModelPurpOpt.isEmpty()) {
				this.setLastReason(CASA_REASON.PURPOSE_VIOLATED);
				return CASA_DECISION.EXCLUDED;
			}
			
			Optional<CASASelfAdaptationAnalysisModel> analysisModelRiskOpt = casaRisk.applyCASARisk(analysisModelPurpOpt.get());
			if (analysisModelRiskOpt.isEmpty()) {
				this.setLastReason(CASA_REASON.RISK_VIOLATED);
				return CASA_DECISION.EXCLUDED;
			}
		}
		
		this.setLastReason(CASA_REASON.NOT_VIOLATED);
		return CASA_DECISION.OK;
	}
	
	public CASABenchDecisionResult analyzeAdaptationWithBenchmark(SWIMReceivedStruct swimReceivedStruct, SWIMAdaptation adaptation) {
		CASABenchDecisionResult result = new CASABenchDecisionResult();
		if (enabled) {
			Stopwatch stopwatchTransform = Stopwatch.createStarted();
			casaModel.update(swimReceivedStruct);
			CASASelfAdaptationAnalysisModel adaptationAnalysisModel = casaModel.generateAnalysisModel(adaptation);
			stopwatchTransform.stop();
			result.elapsedTransform = stopwatchTransform.elapsed(TimeUnit.MICROSECONDS);
			
			Stopwatch stopwatchPurpose = Stopwatch.createStarted();
			Optional<CASASelfAdaptationAnalysisModel> analysisModelPurpOpt = casaPurpose.applyCASAPurpose(adaptationAnalysisModel);
			stopwatchPurpose.stop();
			result.elapsedPurpose = stopwatchPurpose.elapsed(TimeUnit.MICROSECONDS);
			if (analysisModelPurpOpt.isEmpty()) {
				this.setLastReason(CASA_REASON.PURPOSE_VIOLATED);
				result.decision =  CASA_DECISION.EXCLUDED;
				return result;
			}
			
			Stopwatch stopwatchRisk = Stopwatch.createStarted();
			Optional<CASASelfAdaptationAnalysisModel> analysisModelRiskOpt = casaRisk.applyCASARisk(analysisModelPurpOpt.get());
			stopwatchRisk.stop();
			result.elapsedRisk = stopwatchRisk.elapsed(TimeUnit.MICROSECONDS);
			if (analysisModelRiskOpt.isEmpty()) {
				this.setLastReason(CASA_REASON.RISK_VIOLATED);
				result.decision = CASA_DECISION.EXCLUDED;
				return result;
			}
		}
		
		this.setLastReason(CASA_REASON.NOT_VIOLATED);
		result.decision = CASA_DECISION.OK;
		return result;
	}
}
