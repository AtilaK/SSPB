package core.items;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import org.junit.Test;
import core.game.Shape;

public class ItemFactoryTest {

	@Test
	public void getItemWithShapeRock() {
		assertThat(ItemFactory.getItemWithShape(Shape.ROCK), instanceOf(Rock.class));
	}
		
	@Test
	public void getItemWithShapeScissor() {
		assertThat(ItemFactory.getItemWithShape(Shape.SCISSOR), instanceOf(Scissor.class));
	}
	
	@Test
	public void getItemWithShapePaper() {
		assertThat(ItemFactory.getItemWithShape(Shape.PAPER), instanceOf(Paper.class));
	}	

	@Test
	public void getItemWithShapeWell() {
		assertThat(ItemFactory.getItemWithShape(Shape.WELL), instanceOf(Well.class));
	}	
		
}
