package telran.util;

import java.util.Arrays;
import java.util.function.Predicate;

public class ArrayList<T> implements List<T> {

	private static final int DEFAULT_CAPACITY = 16;
	private T[] array;
	private int size;
	@SuppressWarnings("unchecked")
	public ArrayList(int capacity) {
		array = (T[]) new Object[capacity];
	}
	public ArrayList() {
		this(DEFAULT_CAPACITY);
	}
	@Override
	public boolean add(T element) {
		if (size == array.length) {
			reallocate();
		}
		array[size++] = element;
		return true;
	}
	private void reallocate() {
		array = Arrays.copyOf(array, array.length * 2);
	}

	@Override
	public boolean remove(T pattern) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeIf(Predicate<T> predicate) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isEmpty() {
		return size < 1;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public boolean contains(T pattern) {

		return indexOf(pattern) > -1;
	}

	@Override
	public T[] toArray(T[] ar) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void add(int index, T element) {
		isUsableIndex(index);
		if (size == array.length) {
			reallocate();
		}
		System.arraycopy(array, index, array, index + 1, size - index);
		array[index] = element;
		size++;

	}

	@Override
	public T remove(int index) {
		return null;

	}

	@Override
	public int indexOf(T pattern) {
		int i = 0;
		while (i < size && !isEqual(array[i], pattern)) {
			i++;
		}
		return i < size ? i : -1;
	}

	private static <T> boolean isEqual(T element, T pattern) {
		return element == null ? element == pattern : element.equals(pattern);
	}
	
	@Override
	public int lastIndexOf(T pattern) {
		int res = -1;
		for (int i = 0; i < size; i++) {
			if(isEqual(array[i], pattern)) {
			res = i;
			}
		}
		return res;
	}

	@Override
	public T get(int index) {
		return isUsableIndex(index) ? array[index] : null;
	}

	@Override
	public void set(int index, T element) {
		if (isUsableIndex(index)) {
			array[index] = element;
		}
	}
	private boolean isUsableIndex(int index) {
		return index < size && index > -1;
	}

}
