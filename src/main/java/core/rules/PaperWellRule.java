package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import core.game.Selections;
import core.items.Paper;
import core.items.Well;

@Rule(name = "paper well rule", description = "paper beats well" )
public class PaperWellRule extends GameRule {

	private static final Logger LOGGER = LoggerFactory.getLogger(PaperWellRule.class);
	
    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Paper && selections.getAIUserItem() instanceof Well;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	setHumanUserItemWinner(selections);
        LOGGER.info("Paper beats well: User A wins!");
    }
	
}