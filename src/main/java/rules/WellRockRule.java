package rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.Selections;
import items.Rock;
import items.Well;

@Rule(name = "well rock rule", description = "well beats rock" )
public class WellRockRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem() instanceof Well && selections.getUserBItem() instanceof Rock;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getUserAItem().setWinner(true);
        System.out.println("Well beats rock: User A wins!");
    }
	
}