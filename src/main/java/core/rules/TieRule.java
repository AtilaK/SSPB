package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.game.Selections;

@Rule(name = "tie rule", description = "tie situation" )
public class TieRule {

	private static final Logger LOGGER = LoggerFactory.getLogger(TieRule.class);
	
    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem().getClass().equals(selections.getAIUserItem().getClass());
    }
    
    @Action
    public void decide() {
        LOGGER.info("The game is tied: No one wins!");
    }
	
}