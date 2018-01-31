package core;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import rules.PaperRockRule;
import rules.PaperScissorRule;
import rules.RockPaperRule;
import rules.RockScissorRule;
import rules.ScissorPaperRule;
import rules.ScissorRockRule;
import rules.TieRule;

public class BasicDecisionMaker extends DecisionMaker {

	private static BasicDecisionMaker instance = null;
		
	private static Facts facts;
	
	private static Rules rules;
	
	protected BasicDecisionMaker() {
		
	}
	
	public static BasicDecisionMaker getInstance() {
		if (instance == null) {
			
			instance = new BasicDecisionMaker();
			
			facts = new Facts();			
		    rules = new Rules();
		    
		    rules.register(new PaperRockRule());
		    rules.register(new PaperScissorRule());
		    rules.register(new RockPaperRule());
		    rules.register(new RockScissorRule());
		    rules.register(new ScissorPaperRule());
		    rules.register(new ScissorRockRule());
		    rules.register(new TieRule());		    
		}
		return instance;
	}
		
	public boolean decide(Selections selections) {
		
		facts.put("selections", selections);
	    RulesEngine rulesEngine = new DefaultRulesEngine();
	    rulesEngine.fire(rules, facts);
	    
	    facts.remove("selections");
	   
	    // TODO should return false if decision making not possible!
	    return true;
	}

}
