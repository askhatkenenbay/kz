package kz.epam.action;


import java.util.Random;

public class MatrixAction {
	private static final int MIN_SIZE_MATRIX = 8;
	private static final int MAX_SIZE_MATRIX = 12;

	public static int[][] createMatrix() {
		int sizeOfMatrix = (int) (Math.random() * ((MAX_SIZE_MATRIX - MIN_SIZE_MATRIX) + 1) + MIN_SIZE_MATRIX);
		int[][] result = new int[sizeOfMatrix][sizeOfMatrix];
		for (int i = 0; i < result.length; i++) {
			for (int j = 0; j < result[0].length; j++) {
				if (i != j) {
					result[i][j] = new Random().nextInt(9) + 1;
				}
			}
		}
		return result;
	}

}
