package thesis;

public class CASARiskConsentRules {
	
	private final double threshold;

	public CASARiskConsentRules() {
		this(10.0);
	}

	public CASARiskConsentRules(double threshold) {
		this.threshold = threshold;
	}
	
	public enum RiskConsentViolation {
		VIOLATED,
		NOT_VIOLATED
	}
	
	public RiskConsentViolation applyRule(double newRiskLevel, double oldRiskLevel) {
		if (newRiskLevel - oldRiskLevel >= this.threshold) {
			return RiskConsentViolation.VIOLATED;
		}		
		return RiskConsentViolation.NOT_VIOLATED;
	}
	
	public double getAcceptableRiskLevel(double informedRiskLevel) {
		return informedRiskLevel + this.threshold;
	}
}
