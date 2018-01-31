package core;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import items.Rock;
import items.Scissor;

@RestController
public class HelloController {
	  
    @RequestMapping("/")
    public String index() {
    	
    	//tryRules();

        return "Greetings from Spring Boot!";
    }

	private void tryRules() {
		     
		Selections selections = new Selections(new Scissor(), new Rock());
		
        BasicDecisionMaker.getInstance().decide(selections);
	}

}
