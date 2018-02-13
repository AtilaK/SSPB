package core.game;

import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import core.game.Game;
import core.game.GameMode;
import core.game.Shape;
import core.items.Item;

public class GameTest {

	@Test
    public void setHumanUserItemForShapeInvalidShape() {
		Game game = new Game();
		try {
			game.setHumanUserItemForShape(Shape.WELL);
		} catch (IllegalArgumentException expected) {
			assertThat("Shape WELL only allowed in enhanced mode!", is(expected.getMessage()));
		}
					
	}
	
	@Test
    public void playBasicGameWithScissor() {
		Game game = new Game();
		game.setHumanUserItemForShape(Shape.SCISSOR);
		game.play();
		
		Item aiUserItem = game.getAIUserItem();
		
		if (Shape.SCISSOR.equals(aiUserItem.getShape())){
			assertThat(game.getGameResult(), is(GameResult.TIE));
		} else if (Shape.PAPER.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.WON));
		} else if (Shape.ROCK.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.LOST));
		}		
	}

	@Test
    public void playBasicGameWithRock() {
		Game game = new Game();
		game.setHumanUserItemForShape(Shape.ROCK);
		game.play();
		
		Item aiUserItem = game.getAIUserItem();
		
		if (Shape.SCISSOR.equals(aiUserItem.getShape())){
			assertThat(game.getGameResult(), is(GameResult.WON));
		} else if (Shape.PAPER.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.LOST));
		} else if (Shape.ROCK.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.TIE));
		}		
	}
	
	@Test
    public void playEnhancedGameWithRock() {
		Game game = new Game();
		game.setGameMode(GameMode.ENHANCED);
		game.setHumanUserItemForShape(Shape.ROCK);
		game.play();
		
		Item aiUserItem = game.getAIUserItem();
		
		if (Shape.ROCK.equals(aiUserItem.getShape())){
			assertThat(game.getGameResult(), is(GameResult.TIE));
		} else if (Shape.SCISSOR.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.WON));
		} else if (Shape.PAPER.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.LOST));
		} else if (Shape.WELL.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.LOST));
		}
	}
	
	@Test
    public void playEnhancedGameWithWell() {
		Game game = new Game();
		game.setGameMode(GameMode.ENHANCED);
		game.setHumanUserItemForShape(Shape.WELL);
		game.play();
		
		Item aiUserItem = game.getAIUserItem();
		
		if (Shape.WELL.equals(aiUserItem.getShape())){
			assertThat(game.getGameResult(), is(GameResult.TIE));
		} else if (Shape.SCISSOR.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.WON));
		} else if (Shape.PAPER.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.LOST));
		} else if (Shape.ROCK.equals(aiUserItem.getShape())) {
			assertThat(game.getGameResult(), is(GameResult.WON));
		}
	}	
	
	@Test
    public void testGameResultEmptyBeforeGamePlayed() {
		Game game = new Game();
		game.setHumanUserItemForShape(Shape.SCISSOR);		
		assertThat(game.getGameResult(), is(nullValue()));			
	}
	
	@Test
    public void testValidNumberItemsInBasicGameIs3() {
		Game game = new Game();		
		assertThat(game.getGameMode().getnumberOfValidItems(), is(3));			
	}
	
	@Test
    public void testValidNumberItemsInenhancedGameIs4() {
		Game game = new Game();
		game.setGameMode(GameMode.ENHANCED);
		assertThat(game.getGameMode().getnumberOfValidItems(), is(4));			
	}
	
}
