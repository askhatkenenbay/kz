package kz.epam;


import kz.epam.entity.MatrixSingleton;

public class Main {
	public static void main(String[] args) {
		MatrixSingleton matrix = MatrixSingleton.getInstance();
		System.out.println(matrix);

		matrix.changeDiagonal();
		System.out.println(matrix);
	}
}
