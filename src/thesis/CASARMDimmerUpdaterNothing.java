package thesis;

import java.util.List;

import org.eclipse.emf.henshin.interpreter.EGraph;
import org.eclipse.emf.henshin.interpreter.Match;

public class CASARMDimmerUpdaterNothing extends CASARMDimmerUpdaterBase {

	@Override
	protected double determineDimmerValueFromModel(EGraph model) {
		return 0.0;
	}
	
	@Override
	protected void changedDimmer(EGraph model, double oldDimmerValue, double newDimmerValue) {
		return;
	}
}
