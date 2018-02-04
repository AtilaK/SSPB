package core.decisionmakers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import core.game.Selections;
import core.game.Shape;
import core.items.ItemFactory;

public class EnhancedDecisionMakerTest {

	@Test
    public void testPaperRock() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.ROCK));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);
	}
	
	@Test
    public void testPaperScissor() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.SCISSOR));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testPaperWell() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.WELL));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);  
	}
	
	@Test
    public void testRockScissor() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.SCISSOR));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);
	}	

	@Test
    public void testRockPaper() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.PAPER));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);
	}
	
	@Test
    public void testRockWell() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.WELL));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);
	}	
	
	@Test
    public void testScissorRock() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.ROCK));
        EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testScissorPaper() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.PAPER));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);   
	}
	
	@Test
    public void testScissorWell() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.WELL));
        EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testPaperPaper() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.PAPER), ItemFactory.getItemWithShape(Shape.PAPER));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testRockRock() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.ROCK), ItemFactory.getItemWithShape(Shape.ROCK));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testScissorScissor() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.SCISSOR), ItemFactory.getItemWithShape(Shape.SCISSOR));
		EnhancedDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testWellWell() {
		Selections selections = new Selections(ItemFactory.getItemWithShape(Shape.WELL), ItemFactory.getItemWithShape(Shape.WELL));
		EnhancedDecisionMaker.getInstance().decide(selections);       
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
