package rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.Selections;
import items.Paper;
import items.Rock;

@Rule(name = "rock paper rule", description = "paper beats rock" )
public class RockPaperRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem() instanceof Rock && selections.getUserBItem() instanceof Paper;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getUserBItem().setWinner(true);
        System.out.println("Paper beats rock: User B wins!");
    }
	
}
