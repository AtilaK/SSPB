package core;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
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
	  
	@Autowired Environment environment;
	
    @RequestMapping("/")
    public String index() {    	
          return environment.getProperty("welcome");
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
    		throw new IllegalArgumentException(environment.getProperty("gameMode.invalid"));
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
    		throw new IllegalArgumentException(environment.getProperty("shape.invalid")); 		
    	}
		
    	Game game = new Game(environment, gameMode, shape);
   	
    	return game.play();
    			
    }
    
    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
