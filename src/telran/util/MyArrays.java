package telran.util;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class MyArrays {
	static public <T> void sort(T[] objects, Comparator<T> comparator) {
		int length = objects.length;
		do {
			length--;
		} while (moveMaxAtEnd(objects, length, comparator));

	}

	public static <T> int binarySearch(T[] arrSorted, T key, Comparator<T> comp) {
		int left = 0;
		int right = arrSorted.length - 1;
		int middle = right / 2;
		while (left <= right && !arrSorted[middle].equals(key)) {
			if (comp.compare(key, arrSorted[middle]) < 0) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
			middle = (left + right) / 2;
		}
		return left > right ? -left - 1 : middle;
	}

	private static <T> boolean moveMaxAtEnd(T[] objects, int length, Comparator<T> comp) {
		boolean res = false;
		for (int i = 0; i < length; i++) {
			if (comp.compare(objects[i], objects[i + 1]) > 0) {
				swap(objects, i, i + 1);
				res = true;
			}
		}
		return res;
	}

	private static <T> void swap(T[] objects, int i, int j) {
		T tmp = objects[i];
		objects[i] = objects[j];
		objects[j] = tmp;

	}

	public static<T> T[] filter(T[] array, Predicate<T> predicate) {
		T[] res = Arrays.copyOf(array, array.length);
		int index = 0;
		for(T element: array) {
			if(predicate.test(element)) {
				res[index++] = element;
			}
		}
		return Arrays.copyOf(res, index);
	}

	public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
		return filter(array, predicate.negate());
	}

	public static <T> T[] removeRepeated(T[] array) {
		final Object[] helper = new Object[array.length];
		final int[] index = {0};
		return removeIf(array, element -> {
			boolean res = true;
			if (!contains(helper, element)) {
				helper[index[0]++] = element;
				res = false;
			}
			return res;
		});
	}

	public static <T> boolean contains(T[] array, T pattern) {
		int index = 0;
		while(index < array.length && !isEqual(array[index], pattern)) {
			index++;
		}
		return index < array.length;
	}
	
	private static boolean isEqual(Object element, Object pattern) {
		return element == null ? element == pattern : element.equals(pattern);
	}

	public static <T> String join(T[] array, String delimeter) {
		String res = "";
		if (array.length > 0) {
			StringBuilder builder = new StringBuilder(array[0].toString());
			for (int i = 1; i < array.length; i++) {
				builder.append(delimeter).append(array[i]);
			}
			res = builder.toString();
		}
		return res;
	}
	
	public static <T> String joinString(T[] array, String delimeter) {
		String res = "";
		if (array.length > 0) {
			res = array[0].toString();
			for (int i = 1; i < array.length; i++) {
				res += delimeter + array[i];
			}
		}
		return res;
	}
}