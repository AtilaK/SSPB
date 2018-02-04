package core.game;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;

import org.junit.Test;

import core.decisionmakers.BasicDecisionMaker;
import core.items.ItemFactory;
import core.items.Paper;
import core.items.Rock;
public class SelectionsTest {

	@Test
	public void getGameResultTie() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.SCISSOR));
        BasicDecisionMaker.getInstance().decide(selections);   
        assertThat(selections.getGameResult(), is(GameResult.TIE));
	}
	
	@Test
	public void getGameResultWinnerA() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.SCISSOR));
        BasicDecisionMaker.getInstance().decide(selections);   
        assertThat(selections.getGameResult(), is(GameResult.WON));
	}

	@Test
	public void getGameResultWinnerB() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.PAPER));
        BasicDecisionMaker.getInstance().decide(selections);   
        assertThat(selections.getGameResult(), is(GameResult.LOST));
	}
	
	@Test
    public void getWinningItemWinnerB() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.ROCK));
        BasicDecisionMaker.getInstance().decide(selections);       
        assertThat(selections.getWinningItem(), instanceOf(Rock.class));
	}
	
	@Test
    public void getWinningItemWinnerA() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.ROCK));
        BasicDecisionMaker.getInstance().decide(selections);       
        assertThat(selections.getWinningItem(), instanceOf(Paper.class));
	}
	
	@Test
    public void getWinningItemTie() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.ROCK));
        BasicDecisionMaker.getInstance().decide(selections);       
        assertThat(selections.getWinningItem(), is(nullValue()));
	}
	

	
}
