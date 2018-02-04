package game;

import java.util.concurrent.ThreadLocalRandom;

import org.springframework.stereotype.Component;

import decisionmakers.BasicDecisionMaker;
import decisionmakers.DecisionMaker;
import decisionmakers.EnhancedDecisionMaker;
import items.Item;
import items.ItemFactory;
import items.Paper;
import items.Rock;
import items.Scissor;
import items.Well;

@Component
public class Game {
	
	private GameMode gameMode;
	private Item userItem;	
	private Item aiItem;	
	private DecisionMaker decisionMaker;
	
	public Game() {
		this.gameMode = GameMode.BASIC;		
	}
	
	public void setToEnhancedMode () {
		this.gameMode = GameMode.ENHANCED;
	}
	
	public void setUserItemForShape (Shape shape) {
		userItem = ItemFactory.getItemWithShape(shape);
	}

	public Item getUserItem() {
		return userItem;
	}
	
	public Selections play () {
    	
    	this.aiItem = null;
    	
    	if (gameMode.equals(GameMode.BASIC)) {    	
    		decisionMaker = BasicDecisionMaker.getInstance();
    		this.aiItem = getRandomItem(4); 
    		
    	} if (gameMode.equals(GameMode.ENHANCED)) {  
    		decisionMaker = EnhancedDecisionMaker.getInstance();
    		this.aiItem = getRandomItem(5);
    	}
    	
		Selections selections = new Selections(userItem, aiItem);
		decisionMaker.decide(selections);		
		return selections;
	}
	
	/**
	 * Creates a random item
	 * bound = upper bound exclusive: 4 for basic game and 5 for enhanced game
	 * @return
	 */
	private Item getRandomItem (int bound) {
		
		int randomNum = ThreadLocalRandom.current().nextInt(1, bound);
		
		if (randomNum == 1) {
			return new Rock();
		} else if (randomNum == 2) {
			return new Scissor();
		} else if (randomNum == 3) {
			return new Paper();
		} else if (randomNum == 4) {
			return new Well();
		}
		
		return new Rock();
	}
	
}
