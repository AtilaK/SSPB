package core.rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.game.Selections;
import core.items.Paper;
import core.items.Scissor;

@Rule(name = "paper scissor rule", description = "scissor beats paper" )
public class PaperScissorRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getHumanUserItem() instanceof Paper && selections.getAIUserItem() instanceof Scissor;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getAIUserItem().setWinner(true);
        System.out.println("Scissor beats paper: User B wins!");
    }
	
}