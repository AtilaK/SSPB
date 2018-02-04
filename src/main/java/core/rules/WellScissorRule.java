package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.game.Selections;
import core.items.Scissor;
import core.items.Well;

@Rule(name = "Well scissor rule", description = "well beats scissor" )
public class WellScissorRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Well && selections.getAIUserItem() instanceof Scissor;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getHumanUserItem().setWinner(true);
        System.out.println("Well beats scissor: User A wins!");
    }
	
}