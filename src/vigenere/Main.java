package vigenere;

import java.util.Scanner;

/**
 * <h1>Vigenere Cipher!</h1> The Vigenere Cipher program encrypt and/or decrypt a
 * generical string
 * <p>
 *
 *
 *
 * @author Gaetano Di Grazia
 * @version 1.0
 * @since 2020-11-21
 * @see src.vigenere.Vigenere
 * @see src.caesar.Caesar
 */
public class Main {
	private static Scanner in = new Scanner(System.in);
	static int choose;
	static String phrase, key_phrase;
	

	public static void main(String[] args) {
		takeInput();
		Vigenere vigenere = new Vigenere();
		if (choose == 1) {
			System.out.println(vigenere.decrypt(key_phrase, phrase));
		} else {
			System.out.println(vigenere.encrypt(key_phrase, phrase));
		}
	}

	public static void takeInput() {
		System.out.println("-------------------------------");
		System.out.println("-------- VIGENERE CIPHER --------");
		System.out.println("-------------------------------\n\n");

		System.out.println("INSERT KEY:\t");
		key_phrase = in.nextLine();// This line you have to add (It consumes the \n character)
		key_phrase = key_phrase.toUpperCase();
		
		System.out.println("INSERT PHRASE:\t");
		phrase = in.nextLine();
		phrase = phrase.toUpperCase();

		System.out.println("WANT TO:\n 0 - ENCRYPT \n 1 - DECRYPT\n");
		choose = in.nextInt();
	}
}