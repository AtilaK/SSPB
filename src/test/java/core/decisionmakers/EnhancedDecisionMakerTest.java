package core.decisionmakers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import core.decisionmakers.EnhancedDecisionMaker;
import core.game.Selections;
import core.items.Paper;
import core.items.Rock;
import core.items.Scissor;
import core.items.Well;

public class EnhancedDecisionMakerTest {

	@Test
    public void testPaperRock() {
		Selections selections = new Selections(new Paper(), new Rock());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);
	}
	
	@Test
    public void testPaperScissor() {
		Selections selections = new Selections(new Paper(), new Scissor());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testPaperWell() {
		Selections selections = new Selections(new Paper(), new Well());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);  
	}
	
	@Test
    public void testRockScissor() {
		Selections selections = new Selections(new Rock(), new Scissor());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);
	}	

	@Test
    public void testRockPaper() {
		Selections selections = new Selections(new Rock(), new Paper());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);
	}
	
	@Test
    public void testRockWell() {
		Selections selections = new Selections(new Rock(), new Well());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);
	}	
	
	@Test
    public void testScissorRock() {
		Selections selections = new Selections(new Scissor(), new Rock());
        EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testScissorPaper() {
		Selections selections = new Selections(new Scissor(), new Paper());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);   
	}
	
	@Test
    public void testScissorWell() {
		Selections selections = new Selections(new Scissor(), new Well());
        EnhancedDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testPaperPaper() {
		Selections selections = new Selections(new Paper(), new Paper());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testRockRock() {
		Selections selections = new Selections(new Paper(), new Paper());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testScissorScissor() {
		Selections selections = new Selections(new Scissor(), new Scissor());
		EnhancedDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testWellWell() {
		Selections selections = new Selections(new Well(), new Well());
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
