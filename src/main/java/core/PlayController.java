package core;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import items.Item;
import items.Paper;
import items.Rock;
import items.Scissor;
import items.Well;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

@RestController
public class PlayController {
	  
    @RequestMapping("/")
    public String index() {    	
          return "Welcome to scissor rock paper (well) game! \n Select an item and game mode (basic or with well enhanced)" + "\n";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/play", produces = APPLICATION_JSON_VALUE)
    public String getPlayer(@RequestBody Player player) {
    	
    	DecisionMaker decisionMaker = null;
    	
    	String gameMode = player.getGameMode();
    	
    	if (!gameMode.isEmpty()) {
    		if (gameMode.equals("klassik")) {
    			decisionMaker = BasicDecisionMaker.getInstance();
    		} else if (gameMode.equals("fortgeschritten")) {
    			decisionMaker = EnhancedDecisionMaker.getInstance();
    		}   		
    	}
    	if (decisionMaker == null) {
    		throw new IllegalArgumentException("gameMode invalid. Valid values: klassik or fortgeschritten"+ "\n");
    	}
    	
    	String shape = player.getShape();
    	Item userItem = null;
    	
    	if (!shape.isEmpty()) {
    		if (shape.equals("stein")) {
    			userItem = new Rock();
    		} else if (shape.equals("schere")) {
    			userItem = new Scissor();
    		} else if (shape.equals("papier")) {
    			userItem = new Paper();
    		} else if (gameMode.equals("fortgeschritten") && shape.equals("brunnen")) {
    			userItem = new Well();
    		}
    	}
    	
    	if (userItem == null) {
    		throw new IllegalArgumentException("shape invalid. Valid values: stein or schere or papier. In gameMode fortgeschritten also brunnen is valid)");
    	}
    	
    	// TODO hardcoded AI selection here!!!
    	Item aiItem = new Rock();
    	
		Selections selections = new Selections(userItem, aiItem);
		EnhancedDecisionMaker.getInstance().decide(selections); 
    	
		StringBuffer resultMessage = new StringBuffer();
		
		if (selections.isTie()) {
			resultMessage.append("Unentschieden!"+ "\n");
		} else if (selections.isUserAWinner()) {
			resultMessage.append("DU hast gewonnen!!!"+ "\n");			
		} else {
			resultMessage.append("Leider hat dein Gegenspieler gewonnen!"+ "\n");
		}
		
		resultMessage.append("Dein Symbol:"+shape+ " Gegenspieler's Symbol:"+aiItem.getClass().getSimpleName()+ "\n");
		resultMessage.append("Spielmodus:"+gameMode+ "\n");
		
    	return resultMessage.toString();
    			
    }
    
    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
