package telran.util.test;

import org.junit.jupiter.api.BeforeEach;

import telran.util.*;

public class LinkedListTest extends ListTest{
	@BeforeEach
	@Override
	void setUp() throws Exception {
		collection = new LinkedList<>();
		super.setUp();
	}
	

}
