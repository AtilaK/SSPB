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

@Rule(name = "well paper rule", description = "paper beats well" )
public class WellPaperRule extends GameRule {

	private static final Logger LOGGER = LoggerFactory.getLogger(WellPaperRule.class);
	
    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Well && selections.getAIUserItem() instanceof Paper;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	setAIUserItemWinner(selections);
    	LOGGER.info("Paper beats well: User B wins!");
    }
	
}