package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.game.Selections;
import core.items.Rock;
import core.items.Well;

@Rule(name = "well rock rule", description = "well beats rock" )
public class WellRockRule {

	private static final Logger LOGGER = LoggerFactory.getLogger(WellRockRule.class);
	
    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Well && selections.getAIUserItem() instanceof Rock;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getHumanUserItem().setWinner(true);
    	LOGGER.info("Well beats rock: User A wins!");
    }
	
}