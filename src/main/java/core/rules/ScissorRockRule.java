package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.game.Selections;
import core.items.Rock;
import core.items.Scissor;

@Rule(name = "scissor rock rule", description = "rock beats scissor" )
public class ScissorRockRule extends GameRule {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ScissorRockRule.class);

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Scissor && selections.getAIUserItem() instanceof Rock;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	setAIUserItemWinner(selections);
    	LOGGER.info("rock beats scissor: User B wins!");
    }
	
}