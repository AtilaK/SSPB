package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.game.Selections;
import core.items.Scissor;
import core.items.Well;

@Rule(name = "Well scissor rule", description = "well beats scissor" )
public class WellScissorRule extends GameRule {

	private static final Logger LOGGER = LoggerFactory.getLogger(WellScissorRule.class);
	
    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Well && selections.getAIUserItem() instanceof Scissor;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	setHumanUserItemWinner(selections);
    	LOGGER.info("Well beats scissor: User A wins!");
    }
	
}