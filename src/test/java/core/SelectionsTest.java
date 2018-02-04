package core;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;

import core.decisionmakers.BasicDecisionMaker;
import core.game.GameResult;
import core.game.Selections;
import core.items.Paper;
import core.items.Rock;
import core.items.Scissor;

public class SelectionsTest {

	@Test
    public void isTiePositiveCase() {
		Selections selections = new Selections(new Scissor(), new Scissor());
        BasicDecisionMaker.getInstance().decide(selections);            
        assertThat(selections.getGameResult(), is(GameResult.TIE));
	}
	
	@Test
    public void isTieNegativeCase() {
		Selections selections = new Selections(new Scissor(), new Rock());
        BasicDecisionMaker.getInstance().decide(selections);       
        assertNotEquals(selections.getGameResult(), is(GameResult.TIE));
    }
	
	@Test
    public void getWinningItemWinnerB() {
		Selections selections = new Selections(new Scissor(), new Rock());
        BasicDecisionMaker.getInstance().decide(selections);       
        assertThat(selections.getWinningItem().getClass().getSimpleName()
        		, is("Rock"));
	}
	
	@Test
    public void getWinningItemWinnerA() {
		Selections selections = new Selections(new Paper(), new Rock());
        BasicDecisionMaker.getInstance().decide(selections);       
        assertThat(selections.getWinningItem().getClass().getSimpleName()
        		, is("Paper"));
	}
	
	@Test
    public void getWinningItemTie() {
		Selections selections = new Selections(new Rock(), new Rock());
        BasicDecisionMaker.getInstance().decide(selections);       
        assertThat(selections.getWinningItem(), is(nullValue()));
	}
	
}
