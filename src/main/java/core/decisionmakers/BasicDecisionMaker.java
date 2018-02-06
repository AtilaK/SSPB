package core.decisionmakers;

import org.jeasy.rules.api.Facts;
import org.jeasy.rules.api.Rules;
import org.jeasy.rules.api.RulesEngine;
import org.jeasy.rules.core.DefaultRulesEngine;

import core.game.Selections;
import core.rules.PaperRockRule;
import core.rules.PaperScissorRule;
import core.rules.RockPaperRule;
import core.rules.RockScissorRule;
import core.rules.ScissorPaperRule;
import core.rules.ScissorRockRule;
import core.rules.TieRule;

public class BasicDecisionMaker extends DecisionMaker {

	private static BasicDecisionMaker instance = null;
		
	private static Facts facts;
	
	private static Rules rules;
	
	private BasicDecisionMaker() {
		
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
		
	public void decide(Selections selections) {
		
		facts.put("selections", selections);
	    RulesEngine rulesEngine = new DefaultRulesEngine();
		rulesEngine.fire(rules, facts);
		    
	    facts.remove("selections");

	}

}
