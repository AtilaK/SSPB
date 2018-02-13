package core.game;

public enum Shape {
	ROCK("Stein", 1), SCISSOR("Schere", 2), PAPER("Papier", 3), WELL("Brunnen", 4);
	
	private String shape;
	
	private int id;
	
	private Shape(String shape, int id) {
		this.shape = shape;
		this.id = id;
	}

	public int getId() {
		return id;
	}	
	
	public String toString() {
		return this.shape;
	}

}
