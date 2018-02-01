package rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import game.Selections;
import items.Scissor;
import items.Well;

@Rule(name = "Well scissor rule", description = "well beats scissor" )
public class WellScissorRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem() instanceof Well && selections.getUserBItem() instanceof Scissor;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getUserAItem().setWinner(true);
        System.out.println("Well beats scissor: User A wins!");
    }
	
}