package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.game.Selections;
import core.items.Paper;
import core.items.Rock;

@Rule(name = "paper rock rule", description = "paper beats rock" )
public class PaperRockRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Paper && selections.getAIUserItem() instanceof Rock;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getHumanUserItem().setWinner(true);
        System.out.println("Paper beats rock: User A wins!");
    }
	
}