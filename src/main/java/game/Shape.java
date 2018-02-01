package game;

public enum Shape {
	ROCK("stein"), SCISSOR("schere"), PAPER("papier"), WELL("brunnen");
	
	private String shape;
	
	private Shape(String shape) {
		this.shape = shape;
	}
	
	public String getShape() {
		return shape;
	}
	
	public String toString() {
		return this.shape;
	}
}
