package rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.Selections;
import items.Scissor;
import items.Well;

@Rule(name = "Scissor well rule", description = "well beats scissor" )
public class ScissorWellRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem() instanceof Scissor && selections.getUserBItem() instanceof Well;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getUserBItem().setWinner(true);
        System.out.println("Well beats c: User B wins!");
    }
	
}