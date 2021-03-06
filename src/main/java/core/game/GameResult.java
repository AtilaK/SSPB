package core.game;

public enum GameResult {
	TIE("Unentschieden"), WON("Gewonnen"), LOST("Verloren");
	
	private String result;
	
	private GameResult(String result) {
		this.setResult(result);
	}

	public void setResult(String result) {
		this.result = result;
	}
	
	public String toString() {
		return this.result;
	}
	
}
