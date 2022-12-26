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

	public static <T> T[] filter(T[] array, Predicate<T> predicate) {
		int countPredicate = getCountPredicate(array, predicate);
		T[] res = Arrays.copyOf(array, countPredicate);
		int index = 0;
		for (T element : array) {
			if (predicate.test(element)) {
				res[index++] = element;
			}
		}

		return res;
	}

	private static <T> int getCountPredicate(T[] array, Predicate<T> predicate) {
		int res = 0;
		for (T element : array) {
			if (predicate.test(element)) {
				res++;
			}
		}
		return res;
	}

	public static <T> T[] removeIf(T[] array, Predicate<T> predicate) {
		return filter(array, predicate.negate());

	}

	public static <T> T[] removeRepeated(T[] array) {
		T[] res = Arrays.copyOf(array, array.length);
		Arrays.fill(res, null);
		int index = 0;
		while (array.length > 0) {
			res[index++] = array[0];
			array = removeIf(array, a -> contains(res, a));
		}
		return Arrays.copyOf(res, index);
	}

	public static <T> boolean contains(T[] array, T pattern) {
		boolean res = false;
		int i = 0;
		while (!res && i < array.length) {
			if (array[i] == pattern) {
				res = true;
			}
			i++;
		}
		return res;
	}
}