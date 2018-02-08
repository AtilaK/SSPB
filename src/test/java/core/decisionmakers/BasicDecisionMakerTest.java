package core.decisionmakers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import core.decisionmakers.BasicDecisionMaker;
import core.game.Selections;
import core.game.Shape;
import core.items.ItemFactory;

public class BasicDecisionMakerTest {

	@Test
    public void decideScissorRockWinnerB() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.ROCK));
        BasicDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void decideRockScissorWinnerA() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.SCISSOR));
        BasicDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);
	}	

	@Test
    public void decidePaperRockWinnerA() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.ROCK));
        BasicDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);
	}
	
	@Test
    public void decideRockPaperWinnerB() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.PAPER));
        BasicDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);
	}
	
	@Test
    public void decideScissorPaperWinnerA() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.PAPER));
        BasicDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);   
	}
	
	@Test
    public void decidePaperScissorWinnerB() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.SCISSOR));
        BasicDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testPaperPaper() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.PAPER));
        BasicDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testRockRock() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.ROCK));
        BasicDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testScissorScissor() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.SCISSOR));
        BasicDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	private void assertTie(Selections selections) {
		assertThat(selections.getHumanUserItem().isWinner(), is(false));
        assertThat(selections.getAIUserItem().isWinner(), is(false));		
	}

	private void userAWinnerAndUserBLooser(Selections selections) {
		assertThat(selections.getHumanUserItem().isWinner(), is(true));
        assertThat(selections.getAIUserItem().isWinner(), is(false));
	}	
	
	private void userBWinnerAndUserALooser(Selections selections) {
		assertThat(selections.getAIUserItem().isWinner(), is(true));
        assertThat(selections.getHumanUserItem().isWinner(), is(false));
	}	
}
