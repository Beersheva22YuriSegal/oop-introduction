package Cipher;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseCipherTest {

	@Test
	void baseCipherTest() {
		BaseCipher basecipher = new BaseCipher(25);
		assertEquals(123456, basecipher.decipher(basecipher.cipher(123456)));
		
		BaseCipher baseCipher = new BaseCipher(3);
		String bobs = baseCipher.cipher(123);
		assertEquals(123, baseCipher.decipher(bobs));
		
		basecipher.setKey("0123456789abcd");
		assertEquals("46db", basecipher.cipher(12345));
		assertEquals(12345, basecipher.decipher("46db"));
	}
}