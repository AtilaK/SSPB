package core;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
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
import core.game.Shape;

@RestController
public class PlayController {
	  
	@Autowired Environment environment;
	
	@Autowired Game game;

	private static final Logger LOGGER = LoggerFactory.getLogger(PlayController.class);
	
    @RequestMapping(method = RequestMethod.POST, value = "/play", produces = APPLICATION_JSON_VALUE)
    public @ResponseBody PlayResponse play(@RequestBody PlayRequest playRequest) {
    	
    	LOGGER.debug(playRequest.toString());
    	
     	GameMode gameMode = analyseGameMode(playRequest);
	  	
    	if (gameMode == null) {
    		String message = environment.getProperty("gameMode.invalid");
    		LOGGER.debug(message);
    		throw new IllegalArgumentException(message); 		
    	}
    	
    	game.setGameMode(gameMode);
    	
     	Shape shape = analyseShape(playRequest, gameMode);
    	
    	if (shape == null) {
    		String message = environment.getProperty("shape.invalid");
    		LOGGER.debug(message);
    		throw new IllegalArgumentException(message); 		
    	}
		    	
    	game.setHumanUserItemForShape(shape);
   		
    	game.play();
    	
    	return createPlayResponse(game);    			
    }

	private GameMode analyseGameMode(PlayRequest playRequest) {
		if (GameMode.BASIC.toString().equals(playRequest.getGameMode())) {
    		return GameMode.BASIC;
    		
    	} else if (GameMode.ENHANCED.toString().equals(playRequest.getGameMode())) {
    		return GameMode.ENHANCED;
    		
    	}
		return null;
	}
    
	private Shape analyseShape(PlayRequest playRequest, GameMode gameMode) {
		if (Shape.ROCK.toString().equals(playRequest.getShape())) {
			return Shape.ROCK;
			
		} else if (Shape.SCISSOR.toString().equals(playRequest.getShape())) {
			return Shape.SCISSOR;
			
		} else if (Shape.PAPER.toString().equals(playRequest.getShape())) {
			return Shape.PAPER;
			
		} else if (gameMode.equals(GameMode.ENHANCED) && Shape.WELL.toString().equals(playRequest.getShape())) {
			return Shape.WELL;
			
		}
		return null;
	}

	private PlayResponse createPlayResponse(Game game) {
		
		PlayResponse playResponse = new PlayResponse();
		
		GameResult gameResult = game.getGameResult();
		
		String humanUserShape = game.getHumanUserItem().getShape().toString();		
		String aiUserShape = game.getAIUserItem().getShape().toString();
		
		if (GameResult.TIE.equals(gameResult)) {
			playResponse.setResultShort(GameResult.TIE.toString());
			playResponse.setResultDetailed(createResultDetailString("resultMessage.tie", humanUserShape, aiUserShape));
			
		} else if (GameResult.WON.equals(gameResult)) {
			playResponse.setResultShort(GameResult.WON.toString());
			playResponse.setResultDetailed(createResultDetailString("resultMessage.win", humanUserShape, aiUserShape));
			
		} else {
			playResponse.setResultShort(GameResult.LOST.toString());
			playResponse.setResultDetailed(createResultDetailString("resultMessage.lost", humanUserShape, aiUserShape));			
		}		
		
		playResponse.setYourShape(humanUserShape);;
		playResponse.setOpponentShape(aiUserShape);;
		playResponse.setGameMode(game.getGameMode().toString());
		
		return playResponse;
	}
    
	private String createResultDetailString(String message, String humanUserShape, String aiUserShape) {
		return environment.getProperty(message)+"  >>> ["+humanUserShape+"] "+" --- "+" ["+aiUserShape+"] ";
	}
	
    @ExceptionHandler
    void handleIllegalArgumentException(IllegalArgumentException e, HttpServletResponse response) throws IOException {
        response.sendError(HttpStatus.BAD_REQUEST.value());
    }
}
