package rules;

import org.jeasy.rules.annotation.Action;
import org.jeasy.rules.annotation.Condition;
import org.jeasy.rules.annotation.Fact;
import org.jeasy.rules.annotation.Rule;

import game.Selections;

@Rule(name = "tie rule", description = "tie situation" )
public class TieRule {

    @Condition
    public boolean evaluate(@Fact("selections") Selections selections) {
    	 return selections.getUserAItem().getClass().equals(selections.getUserBItem().getClass());
    }
    
    @Action
    public void decide() {
        System.out.println("The game is tied: No one wins!");
    }
	
}