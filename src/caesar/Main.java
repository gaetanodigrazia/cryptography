package caesar;

import java.util.Scanner;

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
 * @see src.caesar.Caesar
 */
public class Main {
	private static Scanner in = new Scanner(System.in);
	static int k, choose;
	static String phrase;

	public static void main(String[] args) {
		takeInput();
		Caesar caesar = new Caesar();
		if (choose == 1) {
			System.out.println(caesar.decrypt(k, phrase));
		} else {
			System.out.println(caesar.encrypt(k, phrase));
		}
	}

	public static void takeInput() {
		System.out.println("-------------------------------");
		System.out.println("-------- CAESER CIPHER --------");
		System.out.println("-------------------------------\n\n");

		System.out.println("INSERT KEY:\t");
		k = in.nextInt();
		in.nextLine(); // This line you have to add (It consumes the \n character)

		System.out.println("INSERT PHRASE:\t");
		phrase = in.nextLine();
		phrase = phrase.toUpperCase();

		System.out.println("WANT TO:\n 0 - ENCRYPT \n 1 - DECRYPT\n");
		choose = in.nextInt();
	}
}