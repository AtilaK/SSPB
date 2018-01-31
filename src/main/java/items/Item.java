package items;

public abstract class Item {

	private boolean isWinner = false;

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}
}
