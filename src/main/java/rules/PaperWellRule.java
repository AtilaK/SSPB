package rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import game.Selections;
import items.Paper;
import items.Well;

@Rule(name = "paper well rule", description = "paper beats well" )
public class PaperWellRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem() instanceof Paper && selections.getUserBItem() instanceof Well;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getUserAItem().setWinner(true);
        System.out.println("Paper beats well: User A wins!");
    }
	
}