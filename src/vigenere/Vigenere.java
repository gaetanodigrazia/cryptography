package vigenere;

import caesar.Caesar;

/**
 * <h1>Vigenere Cipher!</h1> The Vigenere Cipher program encrypt and/or decrypt
 * a generical string
 * <p>
 *
 *
 *
 * @author Gaetano Di Grazia
 * @version 1.0
 * @since 2020-11-21
 */

public class Vigenere extends Caesar {

	public Vigenere() {
		super();
	}

	/**
	 * @param key_phrase
	 * @param phrase
	 * @return decrypted phrase
	 */
	public String decrypt(String key_phrase, String phrase) {
		char[] encrypted_to_array = removeSpaces(phrase).toCharArray();
		char[] key_phrase_array = removeSpaces(key_phrase).toCharArray();
		char[] plain = new char[encrypted_to_array.length];
		for (int i = 0; i < encrypted_to_array.length; i++) {
			int modular_index = i % (key_phrase_array.length);
			plain[i] = super.calculateDecrypt(encrypted_to_array[i],
					super.getIndexFromLetter(key_phrase_array[modular_index]));

		}
		// TODO Auto-generated method stub
		return String.valueOf(plain);
	}

	/**
	 * @param key_phrase
	 * @param phrase
	 * @return encrypted phrase
	 */
	public String encrypt(String key_phrase, String phrase) {
		char[] plain_to_array = removeSpaces(phrase).toCharArray();
		char[] key_phrase_array = removeSpaces(key_phrase).toCharArray();
		char[] encrypted = new char[plain_to_array.length];
		for (int i = 0; i < plain_to_array.length; i++) {
			int modular_index = i % (key_phrase_array.length);
			encrypted[i] = super.calculateCrypt(plain_to_array[i],
					super.getIndexFromLetter(key_phrase_array[modular_index]));

		}
		// TODO Auto-generated method stub
		return String.valueOf(encrypted);
	}

	public String removeSpaces(String key_phrase) {
		return key_phrase.replaceAll(" ", "");
	}
	
	public char getLetterFromIndex(int index) {
		return super.getLetterFromIndex(index);
	}

}
