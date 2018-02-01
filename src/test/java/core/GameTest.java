package core;

import org.junit.Test;

import game.Game;
import game.GameMode;
import game.Shape;

public class GameTest {

	@Test
    public void getPlayTestBasic() {
		Game game = new Game (GameMode.BASIC, Shape.SCISSOR);
		System.out.println(game.play());
	}

	@Test
    public void getPlayTestEnhanced() {
		Game game = new Game (GameMode.ENHANCED, Shape.ROCK);
		System.out.println(game.play());
	}
	
}
