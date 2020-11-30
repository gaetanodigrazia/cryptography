package hill;

import java.util.Scanner;

/**
 * <h1>Hill Cipher!</h1> The Hill Cipher program encrypt and/or decrypt a
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
	static int n, choose;
	static String phrase;
	static double[][] matrix;

	public static void main(String[] args) {		
		Hill hill = new Hill();
		takeInput();
		if (choose == 1) {
			// System.out.println(hill.decrypt(k, phrase));
		} else {
			// System.out.println(hill.encrypt(k, phrase));
			hill.encrypt(matrix, phrase);
		}
	}

	public static void takeInput() {

		System.out.println("-------------------------------");
		System.out.println("-------- HILL CIPHER --------");
		System.out.println("-------------------------------\n\n");

		System.out.println("INSERT KEY:\t");
		matrix = takeMatrix();

		System.out.println("INSERT PHRASE:\t");
		phrase = in.nextLine();
		phrase = phrase.toUpperCase();

		System.out.println("WANT TO:\n 0 - ENCRYPT \n 1 - DECRYPT\n");
		choose = in.nextInt();
	}

	public static double[][] takeMatrix() {
		System.out.println("Enter the number " + "of rows of the matrix");
		n = in.nextInt();
		double matrix[][] = new double[n][n];

		System.out.println("Enter the elements of the matrix");
		int i, j;
		for (i = 0; i < n; i++)
			for (j = 0; j < n; j++)
				matrix[i][j] = in.nextInt();
		return matrix;
	}


}