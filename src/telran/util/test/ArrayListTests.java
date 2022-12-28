package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import telran.util.*;

class ArrayListTests {

	@Test
	void arrayListTest() {
		ArrayList<Integer> arrList = new ArrayList<Integer>(1);
		arrList.add(2);
		arrList.add(2);
		arrList.add(3);
		arrList.add(4);
		assertEquals(4, arrList.size());
		assertEquals(4, arrList.get(3));
		assertEquals(null, arrList.get(5));
		assertTrue(arrList.contains(3));
		assertFalse(arrList.contains(5));
		assertFalse(arrList.isEmpty());
		assertEquals(2, arrList.indexOf(3));
		assertEquals(0, arrList.indexOf(2));
		assertEquals(1, arrList.lastIndexOf(2));
		
		arrList.add(0, 1);
		arrList.add(0, 5);
		assertEquals(5, arrList.get(0));
		assertEquals(4, arrList.get(5));
	}
}
