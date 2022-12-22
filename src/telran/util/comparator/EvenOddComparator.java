package telran.util.comparator;

import java.util.Comparator;

public class EvenOddComparator implements Comparator<Integer> {
	
	@Override
	public int compare(Integer o1, Integer o2) {
		int res = 0;
		if (isEven(o1) && isEven(o2)) {
			res = o1 - o2;
		} else if (isEven(o1) && !isEven(o2)) {
			res = -1;
		} else if (!isEven(o1) && !isEven(o2)) {
			res = - (o1 - o2);
		} else if (!isEven(o1) && isEven(o2)) {
			res = 1;
		}
		return res;
	}

	private boolean isEven(Integer num) {
		return num % 2 == 0;
	}
	
}
