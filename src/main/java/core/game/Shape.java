package core.game;

public enum Shape {
	ROCK("Stein"), SCISSOR("Schere"), PAPER("Papier"), WELL("Brunnen");
	
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
