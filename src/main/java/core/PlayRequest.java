package core;

/**
 * DTO to transport JSON input for the REST service called play
 * @author atila
 * 
 */
public class PlayRequest {

	public PlayRequest() {

	}
	
	public PlayRequest(String shape, String gameMode) {
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

	@Override
	public String toString() {
		return "PlayRequest [shape=" + shape + ", gameMode=" + gameMode + "]";
	}
	
}
