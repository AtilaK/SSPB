package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.game.Selections;
import core.items.Rock;
import core.items.Scissor;

@Rule(name = "rock scissor rule", description = "rock beats scissor" )
public class RockScissorRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Rock && selections.getAIUserItem() instanceof Scissor;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getHumanUserItem().setWinner(true);
        System.out.println("Rock beats scissor: User A wins!");
    }
	
}
