
package caesar;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

/**
 * <h1>Caesar Cipher!</h1> The Caesar Cipher program encrypt and/or decrypt a
 * generical string
 * <p>
 *
 *
 *
 * @author Gaetano Di Grazia
 * @version 1.0
 * @since 2020-11-21
 */

public class Caesar {
	BiMap<Character, Integer> alphabet_hashmap = HashBiMap.create();

	public Caesar() {
		initializeAlphabet();
	}

	public void initializeAlphabet() {
		alphabet_hashmap.put('A', 0);
		alphabet_hashmap.put('B', 1);
		alphabet_hashmap.put('C', 2);
		alphabet_hashmap.put('D', 3);
		alphabet_hashmap.put('E', 4);
		alphabet_hashmap.put('F', 5);
		alphabet_hashmap.put('G', 6);
		alphabet_hashmap.put('H', 7);
		alphabet_hashmap.put('I', 8);
		alphabet_hashmap.put('J', 9);
		alphabet_hashmap.put('K', 10);
		alphabet_hashmap.put('L', 11);
		alphabet_hashmap.put('M', 12);
		alphabet_hashmap.put('N', 13);
		alphabet_hashmap.put('O', 14);
		alphabet_hashmap.put('P', 15);
		alphabet_hashmap.put('Q', 16);
		alphabet_hashmap.put('R', 17);
		alphabet_hashmap.put('S', 18);
		alphabet_hashmap.put('T', 19);
		alphabet_hashmap.put('U', 20);
		alphabet_hashmap.put('V', 21);
		alphabet_hashmap.put('W', 22);
		alphabet_hashmap.put('X', 23);
		alphabet_hashmap.put('Y', 24);
		alphabet_hashmap.put('Z', 25);
	}

	/**
	 * This method is used to encrypt the message.
	 * 
	 * @param k      This is the first parameter, is the key for encrypt
	 * @param phrase This is the second parameter, is the plain text to encrypt
	 * @return String This return the encrypted text
	 */
	public String encrypt(int k, String phrase) {
		char[] plain_to_array = phrase.toCharArray();
		char[] encrypted = new char[plain_to_array.length];
		for (int i = 0; i < plain_to_array.length; i++) {
			char c = plain_to_array[i];
			encrypted[i] = calculateCrypt(c, k);
		}
		return String.valueOf(encrypted);
	}

	/**
	 * This method is used to decrypt the message.
	 * 
	 * @param k      This is the first parameter, is the key for decrypt
	 * @param phrase This is the second parameter, is the encrypted text to decrypt
	 * @return String This return the decrypted text
	 */
	public String decrypt(int k, String phrase) {
		char[] encrypted_to_plain = phrase.toCharArray();
		char[] plain = new char[encrypted_to_plain.length];
		for (int i = 0; i < encrypted_to_plain.length; i++) {
			char c = encrypted_to_plain[i];
			plain[i] = calculateDecrypt(c, k);
		}
		return String.valueOf(plain);
	}

	public int getIndexFromLetter(char c) {
		return alphabet_hashmap.get(c);
	}

	public char getLetterFromIndex(int index) {
		return alphabet_hashmap.inverse().get(index);
	}

	public char calculateCrypt(char c, int k) {
		if (Character.isWhitespace(c)) {
			return ' ';
		} else {
			if (c == '@') {
				return alphabet_hashmap.inverse().get(23);

			} else {
				int new_index = (getIndexFromLetter(c) + k) % 26;
				return alphabet_hashmap.inverse().get(new_index);
			}
		}
	}

	public char calculateDecrypt(char c, int k) {
		if (Character.isWhitespace(c)) {
			return ' ';
		} else {
			int new_index = (getIndexFromLetter(c) - k);
			while (new_index < 0) {
				new_index += 26;
			}
			return alphabet_hashmap.inverse().get(new_index);
		}
	}

	public void putInAlphabet(char key, int value) {
		alphabet_hashmap.put(key, value);
	}

}