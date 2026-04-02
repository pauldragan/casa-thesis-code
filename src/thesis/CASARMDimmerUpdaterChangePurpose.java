package thesis;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.model.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CASARMDimmerUpdaterChangePurpose extends CASARMDimmerUpdaterBase {
    private static final Logger logger = LoggerFactory.getLogger(CASARMDimmerUpdaterChangePurpose.class);
	
	private void increaseDimmer(EGraph model, double oldDimmer, double newDimmer) {
		for (double dimmer = oldDimmer + DIMMERSTEP; dimmer <= newDimmer; dimmer += DIMMERSTEP) {
			 Rule rule;
			 if (dimmer == 0.0) {
				 continue;
			 } else if (dimmer == 0.25) {
				 rule = this.changeDimmerRules.get("AddStandardAds");
			 } else if (dimmer == 0.5) {
				 rule = this.changeDimmerRules.get("AddTargetedAds");
			 } else if (dimmer == 0.75) {
				 rule = this.changeDimmerRules.get("AddLocationTargetedAds");
			 } else if (dimmer == 1.0) {
				 rule = this.changeDimmerRules.get("AddBehaviorTargetedAds");
			 } else {
				 throw new RuntimeException("Cannot find increase rule for dimmer=" + dimmer);
			 }
			 logger.info("oldDimmer=" + oldDimmer + " newDimmer=" + newDimmer + " dimmer=" + dimmer + " rule=" + rule.getName());
			 HenshinUtils.applyModelChangeRule(model, rule, this.engine);
		}
	}
	
	private void decreaseDimmer(EGraph model, double oldDimmer, double newDimmer) {
		for (double dimmer = oldDimmer; dimmer > newDimmer; dimmer -= DIMMERSTEP) {
			 Rule rule;
			 if (dimmer == 0.0) {
				 continue;
			 } else if (dimmer == 0.25) {
				 rule = this.changeDimmerRules.get("RemoveStandardAds");
			 } else if (dimmer == 0.5) {
				 rule = this.changeDimmerRules.get("RemoveTargetedAds");
			 } else if (dimmer == 0.75) {
				 rule = this.changeDimmerRules.get("RemoveLocationTargetedAds");
			 } else if (dimmer == 1.0) {
				 rule = this.changeDimmerRules.get("RemoveBehaviorTargetedAds");
			 } else {
				 throw new RuntimeException("Cannot find decrease rule for dimmer=" + dimmer);
			 }
			 logger.info("oldDimmer=" + oldDimmer + " newDimmer=" + newDimmer + " dimmer=" + dimmer + " rule=" + rule.getName());
			 HenshinUtils.applyModelChangeRule(model, rule, this.engine);
		}
	}

	@Override
	protected void changedDimmer(EGraph model, double oldDimmerValue, double newDimmerValue) {
 		if (oldDimmerValue < newDimmerValue) {
			increaseDimmer(model, oldDimmerValue, newDimmerValue);
		} else if (oldDimmerValue > newDimmerValue) {
			decreaseDimmer(model, oldDimmerValue, newDimmerValue);
		} else {
			// do nothing if equal
		}
	}

}
