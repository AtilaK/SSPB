package core;

public abstract class DecisionMaker {

	private boolean isEnhancedDecisionMaker = false;

	public boolean isEnhancedDecisionMaker() {
		return isEnhancedDecisionMaker;
	}

	protected void setEnhancedDecisionMaker(boolean isEnhancedDecisionMaker) {
		this.isEnhancedDecisionMaker = isEnhancedDecisionMaker;
	}
	
	
}
