package telran.util;

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
	

	/**
	 * 
	 * @param ar
	 * @return array containing elements of a Collection if ar refers to memory that
	 *         enough for all elements of Collection then new array is not created,
	 *         otherwise there will be created new array. if ar refers to memory
	 *         that is greater than required for all elements of Collection then all
	 *         element Collection will be put in the array and rest of memory will
	 *         be filled by null's
	 */
	T[] toArray(T[] ar);
}
