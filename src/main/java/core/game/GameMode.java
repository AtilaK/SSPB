package core.game;

public enum GameMode {
	BASIC("Klassik"), ENHANCED("Fortgeschritten");
	
	private String mode;
	
	private GameMode(String mode) {
		this.mode = mode;
	}

	public String getMode() {
		return mode;
	}

	public String toString() {
		return this.mode;
	}
}
