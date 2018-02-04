package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.game.Selections;
import core.items.Rock;
import core.items.Well;

@Rule(name = "rock well rule", description = "well beats rock" )
public class RockWellRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem() instanceof Rock && selections.getUserBItem() instanceof Well;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getUserBItem().setWinner(true);
        System.out.println("Well beats rock: User B wins!");
    }
	
}