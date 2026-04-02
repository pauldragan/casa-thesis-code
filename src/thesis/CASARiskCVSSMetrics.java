package thesis;

import CASA.CVSS.*;

public class CASARiskCVSSMetrics {
	public static double getMetricValue(AttackVector v) {
		double metric = 0;
		switch (v) {
		case NETWORK:
			metric = 0.85;
			break;
		case ADJACENT:
			metric = 0.62;
			break;
		case LOCAL:
			metric = 0.55;
			break;
		case PHYSICAL:
			metric = 0.20;
			break;
		} 
		return metric;
	}
	
	public static double getMetricValue(AttackComplexity v) {
		double metric = 0;
		switch (v) {
		case LOW:
			metric = 0.77;
			break;
		case HIGH:
			metric = 0.44;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(PrivilegesRequired v, Scope s) {
		double metric = 0;
		switch (v) {
		case NONE:
			metric = 0.85;
			break;
		case LOW:
			switch (s) {
			case UNCHANGED:
				metric = 0.62;
				break;
			case CHANGED:
				metric = 0.68;
				break;
			}
			break;
		case HIGH:
			switch (s) {
			case UNCHANGED:
				metric = 0.27;
				break;
			case CHANGED:
				metric = 0.50;
				break;
			}
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(UserInteraction v) {
		double metric = 0;
		switch (v) {
		case NONE:
			metric = 0.85;
			break;
		case REQUIRED:
			metric = 0.62;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(ExploitCodeMaturity v) {
		double metric = 0;
		switch (v) {
		case NOT_DEFINED:
			metric = 1.0;
			break;
		case HIGH:
			metric = 1.0;
			break;
		case FUNCTIONAL:
			metric = 0.97;
			break;
		case PROOF_OF_CONCEPT:
			metric = 0.94;
			break;
		case UNPROVEN:
			metric = 0.91;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(ReportConfidence v) {
		double metric = 0;
		switch (v) {
		case NOT_DEFINED:
			metric = 1.0;
			break;
		case CONFIRMED:
			metric = 1.0;
			break;
		case REASONABLE:
			metric = 0.96;
			break;
		case UNKNOWN:
			metric = 0.92;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(ConfidentialityImpact v) {
		double metric = 0;
		switch (v) {
		case HIGH:
			metric = 0.56;
			break;
		case LOW:
			metric = 0.22;
			break;
		case NONE:
			metric = 0.0;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(AvailabilityImpact v) {
		double metric = 0;
		switch (v) {
		case HIGH:
			metric = 0.56;
			break;
		case LOW:
			metric = 0.22;
			break;
		case NONE:
			metric = 0.0;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(IntegrityImpact v) {
		double metric = 0;
		switch (v) {
		case HIGH:
			metric = 0.56;
			break;
		case LOW:
			metric = 0.22;
			break;
		case NONE:
			metric = 0.0;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(RemediationLevel v) {
		double metric = 0;
		switch (v) {
		case NOT_DEFINED:
			metric = 1.0;
			break;
		case UNAVAILABLE:
			metric = 1.0;
			break;
		case WORKAROUND:
			metric = 0.97;
			break;
		case TEMPORARY_FIX:
			metric = 0.96;
			break;
		case OFFICIAL_FIX:
			metric = 0.95;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(ConfidentialityRequirement v) {
		double metric = 0;
		switch (v) {
		case HIGH:
			metric = 100;
			break;
		case LOW:
			metric = 30;
			break;
		case MEDIUM:
			metric = 60;
			break;
		case NOT_DEFINED:
			metric = 100;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(IntegrityRequirement v) {
		double metric = 0;
		switch (v) {
		case HIGH:
			metric = 100;
			break;
		case LOW:
			metric = 30;
			break;
		case MEDIUM:
			metric = 60;
			break;
		case NOT_DEFINED:
			metric = 100;
			break;
		}
		return metric;
	}
	
	public static double getMetricValue(AvailabilityRequirement v) {
		double metric = 0;
		switch (v) {
		case HIGH:
			metric = 100;
			break;
		case LOW:
			metric = 30;
			break;
		case MEDIUM:
			metric = 60;
			break;
		case NOT_DEFINED:
			metric = 100;
			break;
		}
		return metric;
	}
}
