package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.game.Selections;

public abstract class GameRule {

	private static final Logger LOGGER = LoggerFactory.getLogger(GameRule.class);
	
	@Condition
	public abstract boolean evaluate(@Fact("selections") Selections selections);
	
	@Action
	public abstract void decide(@Fact("selections") Selections selections);
	
	protected void setAIUserItemWinner(Selections selections) {	
		
		if (selections.getHumanUserItem().isWinner()) {
			throw new IllegalArgumentException("Trying to set AI user item winner, but human user item is already winner!");
		}
		selections.getAIUserItem().setWinner(true);
		LOGGER.debug("AI user item set to be winner");
	}

	protected void setHumanUserItemWinner(Selections selections) {	
		
		if (selections.getAIUserItem().isWinner()) {
			throw new IllegalArgumentException("Trying to set human user item winner, but AI user item is already winner!");
		}
		selections.getHumanUserItem().setWinner(true);
		LOGGER.debug("Human user item set to be winner");
	}
	
}