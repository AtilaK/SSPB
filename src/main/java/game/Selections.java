package game;

import items.Item;

public class Selections {

	private Item userAItem;	
	private Item userBItem;
	
	public Selections(Item userAItem, Item userBItem) {		
		this.userAItem = userAItem;
		this.userBItem = userBItem;
	}
	
	public Item getUserAItem() {
		return userAItem;
	}
	public void setUserAItem(Item userAItem) {
		this.userAItem = userAItem;
	}
	public Item getUserBItem() {
		return userBItem;
	}
	public void setUserBItem(Item userBItem) {
		this.userBItem = userBItem;
	}

	/**
	 * 
	 * @return the game result from the human user perspective 
	 */
	public GameResult getGameResult() {
		if (userAItem.isWinner()) {
			return GameResult.WON; 
		} else if (userBItem.isWinner()) {
			return GameResult.LOST;
		}
		return GameResult.TIE;
	}
	
	public Item getWinningItem () {
		
		GameResult gameResult = getGameResult();
		
		if (GameResult.TIE.equals(gameResult)) {
			return null;
		} else if (GameResult.WON.equals(gameResult)){
			return userAItem;
		} else {
			return userBItem;
		}		
	}
	
}
