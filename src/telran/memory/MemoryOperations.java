package telran.memory;

public class MemoryOperations {
	public static int getMaxAvailableMemory() {
		byte[] ar = null;
		int left = 0;
		int maxAvailable = 0;
		int right = Integer.MAX_VALUE;
		int mid = right / 2;
		while (left <= right) {
			ar = null;
			try {
				ar = new byte[mid];
				maxAvailable = mid;
				left = mid + 1;
			} catch(Throwable e) {
				right = mid - 1;
			}
			mid = left + (right - left) / 2;
		}
		return maxAvailable;
	}
}