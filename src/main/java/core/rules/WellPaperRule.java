package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.game.Selections;
import core.items.Paper;
import core.items.Well;

@Rule(name = "well paper rule", description = "paper beats well" )
public class WellPaperRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Well && selections.getAIUserItem() instanceof Paper;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getAIUserItem().setWinner(true);
        System.out.println("Paper beats well: User B wins!");
    }
	
}