package decisionmakers;

import game.Selections;

public abstract class DecisionMaker {

	private boolean isEnhancedDecisionMaker = false;

	public boolean isEnhancedDecisionMaker() {
		return isEnhancedDecisionMaker;
	}

	protected void setEnhancedDecisionMaker(boolean isEnhancedDecisionMaker) {
		this.isEnhancedDecisionMaker = isEnhancedDecisionMaker;
	}
	
	public abstract boolean decide(Selections selections);
}