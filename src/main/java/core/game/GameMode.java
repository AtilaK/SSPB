package core.game;

public enum GameMode {
	BASIC("Klassik", 3), ENHANCED("Fortgeschritten", 4);
	
	private String mode;
	
	private int numberOfValidItems;
	
	private GameMode(String mode, int numberOfValidItems) {
		this.mode = mode;
		this.numberOfValidItems = numberOfValidItems;
	}

	public int getnumberOfValidItems() {
		return numberOfValidItems;
	}
	
	public String toString() {
		return this.mode;
	}	
	
}
