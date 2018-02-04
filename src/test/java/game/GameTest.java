package game;

import org.junit.Test;

public class GameTest {

	@Test
    public void getPlayTestBasic() {
		Game game = new Game();
		game.setUserItemForShape(Shape.SCISSOR);
		System.out.println(game.play());
		
	}

	@Test
    public void getPlayTestEnhanced() {
		Game game = new Game();
		game.setGameMode(GameMode.ENHANCED);
		game.setUserItemForShape(Shape.ROCK);
		System.out.println(game.play());
	}
	
}
