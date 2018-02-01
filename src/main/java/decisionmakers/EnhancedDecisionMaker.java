package decisionmakers;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import game.Selections;
import rules.PaperRockRule;
import rules.PaperScissorRule;
import rules.PaperWellRule;
import rules.RockPaperRule;
import rules.RockScissorRule;
import rules.RockWellRule;
import rules.ScissorPaperRule;
import rules.ScissorRockRule;
import rules.ScissorWellRule;
import rules.TieRule;
import rules.WellPaperRule;
import rules.WellRockRule;
import rules.WellScissorRule;

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
