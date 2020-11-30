
package hill;

import playfair.Playfair;
import Jama.Matrix;

import java.util.concurrent.ExecutionException;

import com.mathworks.engine.*;

/**
 * @author Gaetano
 *
 */
public class Hill extends Playfair {
	Matrix A;

	public Hill() {
		super();
		super.initializeAlphabet();
	}

	public void encrypt(double[][] matrix, String phrase) {
		phrase = super.removeSpaces(phrase);
		phrase = super.normalize(phrase, 3);
		//A = new Matrix(matrix);
		double[][] arr = { {9, 18, 10}, {16, 21, 1 }, {5, 12, 23}}; 		
		A = new Matrix(arr);
		checkCoherence(A);

		/*
		 * for(int i = 0; i < phrase.length()-3;i=i+3) { 
		 * // TRASFORMARE LE LETTERE DELLA
		 * FRASE A 3 A 3 IN NUMERI 
		 * // RISOLVERE L'EQUAZIONE 
		 * // RITRASFORMARE I NUMERI IN
		 * LETTERE }
		 */
		double[] nums = {8, 2 ,0};
		Matrix test = new Matrix(equationSolver(nums), 1);
		System.out.println(test.get(0, 0));
		System.out.println(test.get(0, 1));
		System.out.println(test.get(0, 2));
		System.out.println((int) test.get(0, 0));
		System.out.println(super.getLetterFromIndex(4));
		//super.getLetterFromIndex((int) test.get(0, 0));
		//super.getLetterFromIndex((int) test.get(0, 1));
		//super.getLetterFromIndex((int) test.get(0, 2));

		

	}

	public void decrypt(int[][] matrix, String phrase) {

	}

	public double[] equationSolver(double[] columnVector) {
		Matrix b = new Matrix(columnVector, 1);
		Matrix result = A.times(b.transpose());
		result.print(1, 0);

		return module(result);
	}

	public double[] module(Matrix matrix) {
		double[] vector = new double[matrix.getRowDimension()];
		for (int i = 0; i < matrix.getRowDimension(); i++) {
			vector[i] = (matrix.get(i, 0) % 26);
		}
		return vector;
	}

	public boolean checkCoherence(Matrix matrix) {
		int determinant = calculateDeterminant(matrix);
		if (isSingular(determinant) == false && isCoprime(determinant) == true) {
			return true;
		}
		System.exit(0);
		return false;
	}

	public int calculateDeterminant(Matrix matrix) {
		return (int) matrix.det();
	}

	public boolean isSingular(int determinant) {
		if (determinant == 0) {
			System.out.println("Non è possibile continuare, la matrice inserita è singolare!");
			return true;
		}
		return false;
	}

	public boolean isCoprime(int determinant) {
		System.out.println("Non è possibile continuare, il determinante non è coprimo");
		return true;
	}

}
