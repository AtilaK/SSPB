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
	public boolean isTie() {
		return !userAItem.isWinner() && !userBItem.isWinner();
	}
	public boolean isUserAWinner() {
		return userAItem.isWinner();
	}
	public Item getWinningItem () {
		if (isTie()) {
			return null;
		} else if (userAItem.isWinner()) {
			return userAItem;
		} else {
			return userBItem;
		}
	}
	
}
