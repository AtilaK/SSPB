package core.items;

import core.game.Shape;

public class ItemFactory {

	public static Item getItemWithShape(Shape shape) {
		
		if (Shape.ROCK.equals(shape)) {
			return new Rock();
			
		} else if (Shape.SCISSOR.equals(shape)) {	
			return new Scissor();
			
		} else if (Shape.PAPER.equals(shape)) {	
			return new Paper();
			
		} else if (Shape.WELL.equals(shape)) {
			return new Well();
			
		} else {
			throw new IllegalArgumentException("Invalid shape to create an item");
		}
	}
	
	public static Item getItemWithShapeId(int id) {
		
		if (id == Shape.ROCK.getId()) {
			return new Rock();
			
		} else if (id == Shape.SCISSOR.getId()) {	
			return new Scissor();
			
		} else if (id == Shape.PAPER.getId()) {	
			return new Paper();
			
		} else if (id == Shape.WELL.getId()) {
			return new Well();
			
		} else {
			throw new IllegalArgumentException("Invalid id to create an item");
		}
	}
}
