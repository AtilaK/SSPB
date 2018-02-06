package core.game;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import core.decisionmakers.BasicDecisionMaker;
import core.decisionmakers.DecisionMaker;
import core.decisionmakers.EnhancedDecisionMaker;
import core.items.Item;
import core.items.ItemFactory;

@Component
public class Game {
	
	private GameMode gameMode;
	private Item humanUserItem;	
	private Item aiUserItem;	
	private DecisionMaker decisionMaker;
	private Selections selections;
	
	public Game() {
		this.gameMode = GameMode.BASIC;		
	}
	
	public GameMode getGameMode() {
		return gameMode;
	}
	
	public void setGameMode(GameMode gameMode) {
		this.gameMode = gameMode;
	}
	
	public Item getHumanUserItem() {
		return humanUserItem;
	}
	
	public Item getAIUserItem() {
		return aiUserItem;
	}	
	
	public void setHumanUserItemForShape(Shape shape) {
		if (GameMode.BASIC.equals(gameMode) && Shape.WELL.equals(shape)) {
			throw new IllegalArgumentException("Shape WELL only allowed in enhanced mode!");
		}
		humanUserItem = ItemFactory.getItemWithShape(shape);
	}

	public GameResult getGameResult() {
		
		if (selections == null) {
			return null;			
		} else {
			return selections.getGameResult();
		}
	}
	
	public void play () {
    	
    	this.aiUserItem = null;
    	
    	if (GameMode.BASIC.equals(gameMode)) {    	
    		decisionMaker = BasicDecisionMaker.getInstance();
    		this.aiUserItem = getRandomItem(GameMode.BASIC); 
    		
    	} if (GameMode.ENHANCED.equals(gameMode)) {  
    		decisionMaker = EnhancedDecisionMaker.getInstance();
    		this.aiUserItem = getRandomItem(GameMode.ENHANCED);
    		
    	}
    	
		this.selections = new Selections(humanUserItem, aiUserItem);
		
		decisionMaker.decide(selections);		
		
	}
	
	/**
	 * Creates a random item
	 * bound = upper bound exclusive: 4 for basic game and 5 for enhanced game
	 * @return
	 */
	private Item getRandomItem (GameMode gameMode) {
		
		int bound = 4;
		
		if (GameMode.ENHANCED.equals(gameMode)) {
			bound = 5;	
		}
		
		int randomNum = ThreadLocalRandom.current().nextInt(1, bound);
		
		if (randomNum == 1) {
			return ItemFactory.getItemWithShape(Shape.ROCK);
		} else if (randomNum == 2) {
			return ItemFactory.getItemWithShape(Shape.SCISSOR);
		} else if (randomNum == 3) {
			return ItemFactory.getItemWithShape(Shape.PAPER);
		} else if (randomNum == 4) {
			return ItemFactory.getItemWithShape(Shape.WELL);
		}
		
		return ItemFactory.getItemWithShape(Shape.ROCK);
	}
	
}
