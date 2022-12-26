package telran.util.test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Comparator;
import java.util.function.Predicate;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import telran.util.MyArrays;
import telran.util.comparator.*;

class MyArraysTest {
	Integer[] numbers = { 13, 2, -8, 47, 100, 10, -7, 7 };
	String[] strings = { "ab", "abm", "abmb", "abmbc" };
	Comparator<Integer> evenOddComparator = this::evenOddCompare;
	

	@Test
	@Disabled
	void sortTest() {
		String[] strings = { "abcd", "lmn", "zz" };
		String[] expected = { "zz", "lmn", "abcd" };
		Integer[] ar = { 3, 2, 1 };

		MyArrays.sort(strings, new StringLengthComparator());
		assertArrayEquals(expected, strings);
		MyArrays.sort(ar, (a, b) -> a - b);

	}

	@Test
	void evenOddTest() {
		Integer[] numbers = { 13, 2, -8, 47, 100, 10, -7, 7 };
		Integer[] expected = { -8, 2, 10, 100, 47, 13, 7, -7 };
		MyArrays.sort(numbers, evenOddComparator);
		assertArrayEquals(expected, numbers);
	}

	@Test
	void binarySearchTest() {
		String[] strings = { "ab", "abm", "abmb", "abmbc" };
		Comparator<String> comp = new StringsComparator();
		assertEquals(0, MyArrays.binarySearch(strings, "ab", comp));
		assertEquals(2, MyArrays.binarySearch(strings, "abmb", comp));
		assertEquals(3, MyArrays.binarySearch(strings, "abmbc", comp));
		assertEquals(-1, MyArrays.binarySearch(strings, "a", comp));
		assertEquals(-3, MyArrays.binarySearch(strings, "abma", comp));
		assertEquals(-5, MyArrays.binarySearch(strings, "lmn", comp));
	}
	
	@Test
	void filterTest() {
		int divider = 2;
		String subStr = "m";
		Predicate<Integer> predEven = t -> t % divider == 0;
		Predicate<String> predSubstr = s -> s.contains(subStr);
		String[] expectedStr = { "abm", "abmb", "abmbc" };
		Integer[] expectedNumbers = { 2, -8, 100, 10 };
		assertArrayEquals(expectedStr, MyArrays.filter(strings, predSubstr));
		assertArrayEquals(expectedNumbers, MyArrays.filter(numbers, predEven));
	}
	
	@Test
	void removeIfTest() {
		int divider = 7;
		String subStr = "m";
		Predicate<Integer> predEven = t -> t % divider == 0;
		Predicate<String> predSubstr = s -> s.contains(subStr);
		String[] expectedStr = { "ab" };
		Integer[] expectedNumbers = { 13, 2, -8, 47, 100, 10 };
		assertArrayEquals(expectedNumbers, MyArrays.removeIf(numbers, predEven));
		assertArrayEquals(expectedStr, MyArrays.removeIf(strings, predSubstr));
	}
	
	@Test
	void removeRepeatedTest() {
		Integer initialInt[] = {1, 1, 1, 3, 7, 3, 9, 1};
		Integer expectedInt[] = {1, 3, 7, 9};
		String[] initialStr = {"ab", "b", "ab", "bc", "b", "ac", "ac" };
		String[] expectedStr = {"ab", "b", "bc", "ac" };
		
		assertArrayEquals(MyArrays.removeRepeated(initialInt), expectedInt);
		assertArrayEquals(MyArrays.removeRepeated(initialStr), expectedStr);
	}
	
	
	int evenOddCompare(Integer o1, Integer o2) {
		int remainder = Math.abs(o1) % 2;
		int res = remainder - Math.abs(o2) % 2;
		if (res == 0) {
			res = remainder != 0 ? Integer.compare(o2, o1) : Integer.compare(o1, o2);
		}
		return res;
	}
}