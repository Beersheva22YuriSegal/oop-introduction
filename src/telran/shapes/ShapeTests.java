package telran.shapes;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Disabled;

import telran.shapes.Rectangle;
import org.junit.jupiter.api.Test;

class ShapeTests {
	
	private void displayStrings(String[] strings) {
		for (String str: strings) {
			System.out.println(str);
		}
	}
	
	@Test
	@Disabled
	void rectangleTest() {
		Rectangle rectangle =  new Rectangle(10, 7);
		assertEquals(10, rectangle.getWidth());
		assertEquals(7, rectangle.getHeight());
		Rectangle.setSymbol("$");
		displayStrings(rectangle.presentation(40));
	}
	
	@Test
	void squareTest() {
		Rectangle square = new Square(7);
		assertEquals(7, square.getWidth());
		assertEquals(7, square.getHeight());
		displayStrings(square.presentation(35));
	}
	
	@Test
	void squareLeftTriangleTest() {
		SquareLeftTriangle triangle = new SquareLeftTriangle(7);
		displayStrings(triangle.presentation(35));
	}
	
	@Test
	void squareRightTriangleTest() {
		SquareRightTriangle triangle = new SquareRightTriangle(7);
		displayStrings(triangle.presentation(35));
	}
	
}