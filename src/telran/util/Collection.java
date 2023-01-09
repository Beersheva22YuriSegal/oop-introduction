package telran.util;

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.*;

public interface Collection<T> extends Iterable<T> {
	boolean add(T element);
	boolean remove(T pattern);

	default boolean removeIf(Predicate<T> predicate) {
		Iterator<T> it = iterator();
		int oldSize = size();
		while(it.hasNext()) {
			T obj = it.next();
			if (predicate.test(obj)) {
				it.remove();
			}
		}
		return oldSize > size();
	}

	boolean isEmpty();
	int size();
	boolean contains(T pattern);
	
	boolean isLoop();
	

	/**
	 * 
	 * @param ar
	 * @return array containing elements of a Collection if ar refers to memory that
	 *         enough for all elements of Collection then new array is not created,
	 *         otherwise there will be created new array. if ar refers to memory
	 *         that is greater than required for all elements of Collection then all
	 *         element Collection will be put in the array and rest of memory will
	 *         be filled by null's
	 *         
	 *         	T[] toArray(T[] ar);
	 */
	default T[] toArray(T[] array) {
		int size = size();
		if (array.length < size) {
			array = Arrays.copyOf(array, size);
		}
		Iterator <T> it = iterator();
		int index = 0;
		while (it.hasNext()) {
			array[index++] = it.next();
		}
		Arrays.fill(array, size, array.length, null);
		return array;
	}

}
