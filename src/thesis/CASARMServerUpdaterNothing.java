package thesis;

import org.eclipse.emf.henshin.interpreter.EGraph;

public class CASARMServerUpdaterNothing extends CASARMServerUpdaterBase {

	@Override
	protected int determineServerNumberFromModel(EGraph model) {
		return 0;
	}
	
	@Override
	protected void changeServer(EGraph model, int oldNumberOfServers, int newNumberOfServers) {
		return;
	}

}
