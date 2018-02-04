package core.items;

import core.game.Shape;

public abstract class Item {

	private boolean isWinner = false;
	
	private Shape shape = null;

	public boolean isWinner() {
		return isWinner;
	}

	public void setWinner(boolean isWinner) {
		this.isWinner = isWinner;
	}
	
	public Shape getShape() {
		return shape;
	}
	
	protected void setShape(Shape shape) {
		this.shape = shape;
	}
 }
