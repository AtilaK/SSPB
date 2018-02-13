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
	 * Creates a random item using random number generator
	 * In basic game mode there are 3 valid items, in enhanced game 4
	 * 
	 * @return a random item
	 */
	private Item getRandomItem (GameMode gameMode) {
	
		//bound = upper bound exclusive, therefore bound = numberOfValidItems+1
		int randomNum = ThreadLocalRandom.current().nextInt(1, gameMode.getnumberOfValidItems()+1);	
		
		return ItemFactory.getItemWithShapeId(randomNum);		
	}
	
}
