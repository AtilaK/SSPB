package core;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import core.game.Game;
import core.game.GameMode;
import core.game.GameResult;
import core.game.Selections;
import core.game.Shape;

@RestController
@ComponentScan("game")
public class PlayController {
	  
	@Autowired Environment environment;
	
	@Autowired Game game;
	
    @RequestMapping("/")
    public String index() {    	
          return environment.getProperty("welcome");
    }

    @RequestMapping(method = RequestMethod.POST, value = "/play", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody PlayResponse play(@RequestBody PlayRequest userRequest) {
    	
     	GameMode gameMode = analyseGameMode(userRequest);
	  	
    	if (gameMode == null) {
    		throw new IllegalArgumentException(environment.getProperty("gameMode.invalid"));
    	}
    	
    	game.setGameMode(gameMode);
    	
     	Shape shape = analyseShape(userRequest, gameMode);
    	
    	if (shape == null) {
    		throw new IllegalArgumentException(environment.getProperty("shape.invalid")); 		
    	}
		    	
    	game.setUserItemForShape(shape);
   		
    	Selections selections = game.play();
    	
    	return responseWithGameResult(selections, gameMode);    			
    }

	private GameMode analyseGameMode(PlayRequest userRequest) {
		if (GameMode.BASIC.toString().equals(userRequest.getGameMode())) {
    		return GameMode.BASIC;
    	} else if (GameMode.ENHANCED.toString().equals(userRequest.getGameMode())) {
    		return GameMode.ENHANCED;
    	}
		return null;
	}
    
	private Shape analyseShape(PlayRequest userRequest, GameMode gameMode) {
		if (Shape.ROCK.toString().equals(userRequest.getShape())) {
			return Shape.ROCK;
		} else if (Shape.SCISSOR.toString().equals(userRequest.getShape())) {
			return Shape.SCISSOR;
		} else if (Shape.PAPER.toString().equals(userRequest.getShape())) {
			return Shape.PAPER;
		} else if (gameMode.equals(GameMode.ENHANCED) && Shape.WELL.toString().equals(userRequest.getShape())) {
			return Shape.WELL;
		}
		return null;
	}

	private PlayResponse responseWithGameResult(Selections selections, GameMode gameMode) {
		
		PlayResponse humanUserResponse = new PlayResponse();
		
		GameResult gameResult = selections.getGameResult();
		
		String userAShapeString = selections.getUserAItem().getShape().toString();		
		String userBShapeString = selections.getUserBItem().getShape().toString();
		
		if (GameResult.TIE.equals(gameResult)) {
			humanUserResponse.setResultShort(GameResult.TIE.toString());
			humanUserResponse.setResultDetailed(environment.getProperty("resultMessage.tie")+"  >>>"+
					" ["+userAShapeString+"] "+" --- "+" ["+userBShapeString+"] ");
		} else if (GameResult.WON.equals(gameResult)) {
			humanUserResponse.setResultShort(GameResult.WON.toString());
			humanUserResponse.setResultDetailed(environment.getProperty("resultMessage.win")+"  >>>"+
					" ["+userAShapeString+"] "+" --- "+" ["+userBShapeString+"] ");			
		} else {
			humanUserResponse.setResultShort(GameResult.LOST.toString());
			humanUserResponse.setResultDetailed(environment.getProperty("resultMessage.lost")+"  >>>"+
					" ["+userAShapeString+"] "+" --- "+" ["+userBShapeString+"] ");	
		}		
		
		humanUserResponse.setYourShape(userAShapeString);;
		humanUserResponse.setOpponentShape(userBShapeString);;
		humanUserResponse.setGameMode(gameMode.toString());
		
		return humanUserResponse;
	}
    
    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
