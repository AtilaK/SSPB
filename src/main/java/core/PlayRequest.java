package core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * DTO to transport JSON input for the REST service called play
 * 
 */
@ApiModel
public class PlayRequest {

	public PlayRequest() {

	}
	
	public PlayRequest(String shape, String gameMode) {
		this.shape = shape;
		this.gameMode = gameMode;
	}
	
	@ApiModelProperty(required = true)
	private String shape;
	
	@ApiModelProperty(required = true)
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
