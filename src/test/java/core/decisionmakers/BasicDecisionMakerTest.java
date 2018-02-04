package core.decisionmakers;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import core.decisionmakers.BasicDecisionMaker;
import core.game.Selections;
import core.items.Paper;
import core.items.Rock;
import core.items.Scissor;

public class BasicDecisionMakerTest {

	@Test
    public void testScissorRock() {
		Selections selections = new Selections(new Scissor(), new Rock());
        BasicDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testRockScissor() {
		Selections selections = new Selections(new Rock(), new Scissor());
        BasicDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);
	}	

	@Test
    public void testPaperRock() {
		Selections selections = new Selections(new Paper(), new Rock());
        BasicDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);
	}
	
	@Test
    public void testRockPaper() {
		Selections selections = new Selections(new Rock(), new Paper());
        BasicDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);
	}
	
	@Test
    public void testScissorPaper() {
		Selections selections = new Selections(new Scissor(), new Paper());
        BasicDecisionMaker.getInstance().decide(selections);       
        userAWinnerAndUserBLooser(selections);   
	}
	
	@Test
    public void testPaperScissor() {
		Selections selections = new Selections(new Paper(), new Scissor());
        BasicDecisionMaker.getInstance().decide(selections);       
        userBWinnerAndUserALooser(selections);  
	}
	
	@Test
    public void testPaperPaper() {
		Selections selections = new Selections(new Paper(), new Paper());
        BasicDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testRockRock() {
		Selections selections = new Selections(new Paper(), new Paper());
        BasicDecisionMaker.getInstance().decide(selections);       
        assertTie(selections);  
	}
	
	@Test
    public void testScissorScissor() {
		Selections selections = new Selections(new Scissor(), new Scissor());
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