package telran.shapes.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.shapes.*;

class ShapeTests {

	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle = new Rectangle(10, 5);
		assertEquals(10, rectangle.getWidth());
		assertEquals(5, rectangle.getHeight());
		displayStrings(rectangle.presentation(20));
		Rectangle.setSymbol("#");
		displayStrings(rectangle.presentation(20));
	}


	@Test
	@Disabled
	void leftTriangleTest() {
		SquareLeftTriangle triangle = new SquareLeftTriangle(20);
		displayStrings(triangle.presentation(10));
	}

	@Test
	@Disabled
	void rightTriangleTest() {
		SquareRightTriangle triangle = new SquareRightTriangle(20);
		displayStrings(triangle.presentation(10));
	}
	
	@Test
	
	void CanvasTest() {
		Shape rectangle = new Rectangle(10, 30);
		Shape square = new Square(20);
		Shape squareLeftTriangle = new SquareLeftTriangle(10);
		Shape squareRightTriangle = new SquareRightTriangle(15);
		Shape[] shapes = {rectangle, square, squareRightTriangle, squareLeftTriangle};
		
		Canvas canvas = new Canvas(10, 7, shapes);
		canvas.setMargin(3);
		displayStrings(canvas.presentation(5));
		canvas.setMargin(4);
		canvas.setDirection("column"); 
		displayStrings(canvas.presentation(5));
	}

	private void displayStrings(String strings[]) {
		for (String str : strings) {
			System.out.println(str);
		}
	}
}