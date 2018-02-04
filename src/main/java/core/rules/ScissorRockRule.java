package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.game.Selections;
import core.items.Rock;
import core.items.Scissor;

@Rule(name = "scissor rock rule", description = "rock beats scissor" )
public class ScissorRockRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Scissor && selections.getAIUserItem() instanceof Rock;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getAIUserItem().setWinner(true);
    	System.out.println("rock beats scissor: User B wins!");
    }
	
}