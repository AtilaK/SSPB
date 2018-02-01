package core;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import game.Game;
import game.GameMode;
import game.Shape;

@RestController
public class PlayController {
	  
    @RequestMapping("/")
    public String index() {    	
          return "Welcome to scissor rock paper (well) game! \n Select an item and game mode (basic or with well enhanced)" + "\n";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/play", produces = APPLICATION_JSON_VALUE)
    public String getPlayer(@RequestBody Player player) {
    	
    	String gameModeString = player.getGameMode();
    
    	GameMode gameMode = null;
    	
    	if (gameModeString.equals(GameMode.BASIC.toString())) {
    		gameMode = GameMode.BASIC;
    	} else if (gameModeString.equals(GameMode.ENHANCED.toString())) {
    		gameMode = GameMode.ENHANCED;
    	}
	  	
    	if (gameMode == null) {	
    		throw new IllegalArgumentException("gameMode invalid. Valid values: klassik or fortgeschritten");
    	}

    	String shapeString = player.getShape();
    	Shape shape = null;
    	
		if (shapeString.equals(Shape.ROCK.toString())) {
			shape = Shape.ROCK;
		} else if (shapeString.equals(Shape.SCISSOR.toString())) {
			shape = Shape.SCISSOR;
		} else if (shapeString.equals(Shape.PAPER.toString())) {
			shape = Shape.PAPER;
		} else if (gameMode.equals(GameMode.ENHANCED) && shapeString.equals(Shape.WELL.toString())) {
			shape = Shape.WELL;
		}
    	
    	if (shape == null) {
    		throw new IllegalArgumentException("shape invalid. Valid values: stein or schere or papier. In gameMode fortgeschritten also brunnen is valid)"); 		
    	}
		
    	Game game = new Game(gameMode, shape);
   	
    	return game.play();
    			
    }
    
    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
