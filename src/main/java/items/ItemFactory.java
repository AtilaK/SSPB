package items;

import game.Shape;

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
}
