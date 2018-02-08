package core.rules;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import core.game.Selections;
import core.game.Shape;
import core.items.ItemFactory;
import core.rules.GameRule;

public class GameRuleTest {

	@Test
    public void setAIUserItemWinnerExceptionExpected() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.ROCK));
		selections.getHumanUserItem().setWinner(true);
		GameRule gameRule = new PaperScissorRule();
		try{
			gameRule.setAIUserItemWinner(selections);	
		} catch (IllegalArgumentException expected) {	
			assertThat("Trying to set AI user item winner, but human user item is already winner!", is(expected.getMessage()));
		}			
	}
	
	@Test
    public void setAIUserItemWinnerSuccess() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.ROCK));
		GameRule gameRule = new PaperScissorRule();
		gameRule.setAIUserItemWinner(selections);	
	}
	
	@Test
    public void setHumanUserItemWinnerExceptionExpected() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.PAPER));
		selections.getAIUserItem().setWinner(true);
		GameRule gameRule = new PaperScissorRule();
		try{
			gameRule.setHumanUserItemWinner(selections);	
		} catch (IllegalArgumentException expected) {	
			assertThat("Trying to set human user item winner, but AI user item is already winner!", is(expected.getMessage()));
		}			
	}
	
	@Test
    public void setHumanUserItemWinnerSuccess() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.PAPER));
		GameRule gameRule = new PaperScissorRule();
		gameRule.setHumanUserItemWinner(selections);
	}
	
}
