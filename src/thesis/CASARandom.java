package thesis;

import java.util.Random;

public class CASARandom extends CASABase {
	private static final StatsCollector collector = StatsCollector.getInstance();
	
    private final double P;
	
	public CASARandom(double p) {
		super(null, null, null);
		this.P = p;
	}
	
	@Override
	public CASA_DECISION analyzeAdaptation(SWIMReceivedStruct swimReceivedStruct, SWIMAdaptation adaptation) {
		collector.record("exclusionProbability", P);
		if (enabled) {
			if (randomBoolean(P) == true) {
				return CASA_DECISION.EXCLUDED;
			} else {
				return CASA_DECISION.OK;
			}
		}
		return CASA_DECISION.OK;
	}
	
    protected static boolean randomBoolean(double probability) {
        Random rand = new Random();
        return rand.nextDouble() < probability;
    }
}
