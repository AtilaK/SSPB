package core;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel
public class PlayResponse {

	public PlayResponse () {}
	
	@ApiModelProperty(required = true)
	public String resultShort;
	
	@ApiModelProperty(required = true)
	public String resultDetailed;
	
	@ApiModelProperty(required = true)
	public String yourShape;
	
	@ApiModelProperty(required = true)
	public String opponentShape;
	
	@ApiModelProperty(required = true)
	public String gameMode;

	public String getResultShort() {
		return resultShort;
	}

	public void setResultShort(String resultShort) {
		this.resultShort = resultShort;
	}

	public String getResultDetailed() {
		return resultDetailed;
	}

	public void setResultDetailed(String resultDetailed) {
		this.resultDetailed = resultDetailed;
	}

	public String getYourShape() {
		return yourShape;
	}

	public void setYourShape(String yourShape) {
		this.yourShape = yourShape;
	}

	public String getOpponentShape() {
		return opponentShape;
	}

	public void setOpponentShape(String opponentShape) {
		this.opponentShape = opponentShape;
	}

	public String getGameMode() {
		return gameMode;
	}

	public void setGameMode(String gameMode) {
		this.gameMode = gameMode;
	}
}
