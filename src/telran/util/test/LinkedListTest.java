package telran.util.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import telran.util.*;

public class LinkedListTest extends ListTest{
	@BeforeEach
	@Override
	void setUp() throws Exception {
		collection = new LinkedList<>();
		super.setUp();
	}
	
	@Test
	void isLoopTest() {
		LinkedList <Integer> list = (LinkedList <Integer>) collection;
		assertFalse(list.isLoop());
		list.setNext(4, 2);
		assertTrue(list.isLoop());
		assertThrowsExactly(IllegalArgumentException.class, () -> list.setNext(0, 2));
	}
	

}
