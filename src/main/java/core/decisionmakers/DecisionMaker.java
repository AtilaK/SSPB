package core.decisionmakers;

import core.game.Selections;

public abstract class DecisionMaker {

	private boolean isEnhancedDecisionMaker = false;

	public boolean isEnhancedDecisionMaker() {
		return isEnhancedDecisionMaker;
	}

	protected void setEnhancedDecisionMaker(boolean isEnhancedDecisionMaker) {
		this.isEnhancedDecisionMaker = isEnhancedDecisionMaker;
	}
	
	public abstract void decide(Selections selections);
}
