package game;

import java.util.concurrent.ThreadLocalRandom;

import decisionmakers.BasicDecisionMaker;
import decisionmakers.DecisionMaker;
import decisionmakers.EnhancedDecisionMaker;
import items.Item;
import items.ItemFactory;
import items.Paper;
import items.Rock;
import items.Scissor;
import items.Well;

public class Game {

	private GameMode gameMode;
	private Item userItem;	
	private Item aiItem;	
	private DecisionMaker decisionMaker;
	
	public Game(GameMode gameMode, Shape shape) {
			
		this.gameMode = gameMode;
		
		if (gameMode.equals(GameMode.BASIC)) {
			decisionMaker = BasicDecisionMaker.getInstance();
		} else if (gameMode.equals(GameMode.ENHANCED)) {
			decisionMaker = EnhancedDecisionMaker.getInstance();
		}
					
		userItem = ItemFactory.getItemWithShape(shape);
		
	}

	public Item getUserItem() {
		return userItem;
	}
	
	public String play () {
    	
    	this.aiItem = null;
    	
    	if (gameMode.equals(GameMode.BASIC)) {    	
    	
    		this.aiItem = getRandomItem(4); 
    		
    	} if (gameMode.equals(GameMode.ENHANCED)) {  
    		
    		this.aiItem = getRandomItem(5);
    	}
    	
		Selections selections = new Selections(userItem, aiItem);
		decisionMaker.decide(selections);
		
		StringBuffer resultMessage = new StringBuffer();
		
		if (selections.isTie()) {
			resultMessage.append("Unentschieden!"+ "\n");
		} else if (selections.isUserAWinner()) {
			resultMessage.append("DU hast gewonnen!!!"+ "\n");			
		} else {
			resultMessage.append("Leider hat dein Gegenspieler gewonnen!"+ "\n");
		}
		
		resultMessage.append("Dein Symbol:"+ userItem.getShape() + " Gegenspieler's Symbol:"+aiItem.getShape()+ "\n");
		resultMessage.append("Spielmodus:"+gameMode+ "\n");
		
		return resultMessage.toString();
	}
	
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
