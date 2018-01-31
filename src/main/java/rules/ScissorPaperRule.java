package rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import core.Selections;
import items.Paper;
import items.Scissor;

@Rule(name = "scissor paper rule", description = "scissor beats paper" )
public class ScissorPaperRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem() instanceof Scissor && selections.getUserBItem() instanceof Paper;
    }
    
    @Action
    public void decide(@Fact("selections") Selections selections) {
    	selections.getUserAItem().setWinner(true);
        System.out.println("Scissor beats paper: User A wins!");
    }
	
}
