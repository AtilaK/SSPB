package rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import game.Selections;
import items.Rock;
import items.Scissor;

@Rule(name = "scissor rock rule", description = "rock beats scissor" )
public class ScissorRockRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem() instanceof Scissor && selections.getUserBItem() instanceof Rock;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getUserBItem().setWinner(true);
    	System.out.println("rock beats scissor: User B wins!");
    }
	
}