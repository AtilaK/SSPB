package core.items;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.instanceOf;
import org.junit.Test;
import core.game.Shape;

public class ItemFactoryTest {

	@Test
	public void getRockWithShapeRock() {
		assertThat(ItemFactory.getItemWithShape(Shape.ROCK), instanceOf(Rock.class));
	}
		
	@Test
	public void getScissorWithShapeScissor() {
		assertThat(ItemFactory.getItemWithShape(Shape.SCISSOR), instanceOf(Scissor.class));
	}
	
	@Test
	public void getPaperWithShapePaper() {
		assertThat(ItemFactory.getItemWithShape(Shape.PAPER), instanceOf(Paper.class));
	}	

	@Test
	public void getWellWithShapeWell() {
		assertThat(ItemFactory.getItemWithShape(Shape.WELL), instanceOf(Well.class));
	}	
		
	@Test
	public void getRockWithShapeRockId() {
		assertThat(ItemFactory.getItemWithShapeId(Shape.ROCK.getId()), instanceOf(Rock.class));
	}
		
	@Test
	public void getScissorWithShapeScissorId() {
		assertThat(ItemFactory.getItemWithShapeId(Shape.SCISSOR.getId()), instanceOf(Scissor.class));
	}
	
	@Test
	public void getPaperWithShapePaperId() {
		assertThat(ItemFactory.getItemWithShapeId(Shape.PAPER.getId()), instanceOf(Paper.class));
	}	

	@Test
	public void getWellWithShapeWellId() {
		assertThat(ItemFactory.getItemWithShapeId(Shape.WELL.getId()), instanceOf(Well.class));
	}	
	
}
