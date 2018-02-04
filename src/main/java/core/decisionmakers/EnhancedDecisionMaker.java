package core.decisionmakers;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import core.game.Selections;
import core.rules.PaperRockRule;
import core.rules.PaperScissorRule;
import core.rules.PaperWellRule;
import core.rules.RockPaperRule;
import core.rules.RockScissorRule;
import core.rules.RockWellRule;
import core.rules.ScissorPaperRule;
import core.rules.ScissorRockRule;
import core.rules.ScissorWellRule;
import core.rules.TieRule;
import core.rules.WellPaperRule;
import core.rules.WellRockRule;
import core.rules.WellScissorRule;

public class EnhancedDecisionMaker extends DecisionMaker {

	private static EnhancedDecisionMaker instance = null;

	private static Facts facts;
	
	private static Rules rules;
	
	private EnhancedDecisionMaker() {
		
	}
	
	public static EnhancedDecisionMaker getInstance() {
		if (instance == null) {
			
			instance = new EnhancedDecisionMaker();			
			instance.setEnhancedDecisionMaker(true);

			facts = new Facts();			
		    rules = new Rules();
		    
		    rules.register(new PaperRockRule());
		    rules.register(new PaperScissorRule());
		    rules.register(new RockPaperRule());
		    rules.register(new RockScissorRule());
		    rules.register(new ScissorPaperRule());
		    rules.register(new ScissorRockRule());
		    
		    // rules for advanced game
		    rules.register(new PaperWellRule());
		    rules.register(new WellPaperRule());
		    rules.register(new RockWellRule());
		    rules.register(new WellRockRule());
		    rules.register(new ScissorWellRule());
		    rules.register(new WellScissorRule());	    
		    
		    rules.register(new TieRule());		    
		}
		return instance;
	}
		
	public boolean decide(Selections selections) {
		
		facts.put("selections", selections);
	    RulesEngine rulesEngine = new DefaultRulesEngine();
	    rulesEngine.fire(rules, facts);
	    
	    facts.remove("selections");
	   
	    return true;
	}

}
