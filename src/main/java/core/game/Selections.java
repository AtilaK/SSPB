package core.game;

import core.items.Item;

public class Selections {

	private Item humanUserItem;	
	private Item aiUserItem;
	
	public Selections(Item humanUserItem, Item aiUserItem) {		
		this.humanUserItem = humanUserItem;
		this.aiUserItem = aiUserItem;
	}
	
	public Item getHumanUserItem() {
		return humanUserItem;
	}
	
	public Item getAIUserItem() {
		return aiUserItem;
	}

	/**
	 * 
	 * @return the game result from the human user perspective 
	 */
	public GameResult getGameResult() {
		
		if (humanUserItem.isWinner()) {
			return GameResult.WON; 
			
		} else if (aiUserItem.isWinner()) {
			return GameResult.LOST;
		}
		
		return GameResult.TIE;
	}
	
	public Item getWinningItem () {
		
		GameResult gameResult = getGameResult();
		
		if (GameResult.TIE.equals(gameResult)) {
			return null;
			
		} else if (GameResult.WON.equals(gameResult)){
			return humanUserItem;
			
		} else {
			return aiUserItem;
			
		}		
	}
	
}
