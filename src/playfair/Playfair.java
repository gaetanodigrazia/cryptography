/**
 * 
 */
package playfair;

import vigenere.Vigenere;

/**
 * @author Gaetano
 *
 */
public class Playfair extends Vigenere {

	public Playfair() {
		super();
	}

	/**
	 * @param phrase, the phrase to normalize
	 * @param displacement, the displacement for playfair is 2: we use digram
	 * @return normalized phrase
	 */
	public String normalize(String phrase, int displacement) {
		char[] phrase_array = phrase.toCharArray();
		int size = phrase_array.length;
		if (((size) % displacement) == 0) {

		} else {
			++size;
			phrase_array[size] = '@';
		}

		return phrase_array.toString();
	}

	@Override
	public void initializeAlphabet() {
		super.putInAlphabet('@', 27);
	}
}
