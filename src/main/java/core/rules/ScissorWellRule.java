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

@Rule(name = "Scissor well rule", description = "well beats scissor" )
public class ScissorWellRule {

	private static final Logger LOGGER = LoggerFactory.getLogger(ScissorWellRule.class);
	
    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Scissor && selections.getAIUserItem() instanceof Well;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getAIUserItem().setWinner(true);
        LOGGER.info("Well beats c: User B wins!");
    }
	
}