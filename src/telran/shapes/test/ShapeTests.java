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

	private void displayStrings(String strings[]) {
		for (String str : strings) {
			System.out.println(str);
		}
	}

	@Test
	void leftTriangleTest() {
		SquareLeftTriangle triangle = new SquareLeftTriangle(20);
		displayStrings(triangle.presentation(10));
	}

	@Test
	void rightTriangleTest() {
		SquareRightTriangle triangle = new SquareRightTriangle(20);
		displayStrings(triangle.presentation(10));
	}

}