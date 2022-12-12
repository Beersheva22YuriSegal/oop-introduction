package Cipher;

public class BaseCipher {

	private static final char MIN_CHAR = 33;
	private static final char MAX_CHAR = 126;
	private static final int MIN_LENGTH = 2;
	private static final int MAX_LENGTH = MAX_CHAR - MIN_CHAR + 1;
	private String key;

	public BaseCipher(int length) {
		if (length < MIN_LENGTH) {
			length = MIN_LENGTH;
		} else if (length > MAX_LENGTH) {
			length = MAX_LENGTH;
		}
		this.key = generateKey(length);
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String cipher(int num) {
		String res = "";
		int length = key.length();
		char[] charArray = key.toCharArray();
		while (num != 0) {
			res = charArray[num % length] + res;
			num /= length;
		}
		return res;
	}

	public int decipher(String cipher) {
		int res = 0;
		int length = key.length();
		for (int i = 0; i < cipher.length(); i++) {
			int num = key.indexOf(cipher.charAt(i));
			res = res * length + num;
		}
		return res;
	}

	private String generateKey(int keyLength) {
		char[] res = new char[keyLength];
		boolean[] helper = new boolean[MAX_LENGTH];
		for (int i = 0; i < res.length; i++) {
			int num = getRandomNum(MIN_CHAR, MAX_CHAR);
			if (helper[num - MIN_CHAR] == false) {
				res[i] = (char) num;
				helper[num - MIN_CHAR] = true;
			}
		}
		return new String(res);
	}

	private int getRandomNum(int min, int max) {
		return (int) (min + Math.random() * (max - min + 1));
	}
}