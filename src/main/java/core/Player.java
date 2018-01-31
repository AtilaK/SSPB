package core;

public class Player {

	public Player() {

	}
	
	public Player(String shape, String gameMode) {
		this.shape = shape;
		this.gameMode = gameMode;
	}

	private String shape;
	
	private String gameMode;

	public String getShape() {
		return shape;
	}

	public void setShape(String shape) {
		this.shape = shape;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
	
}
