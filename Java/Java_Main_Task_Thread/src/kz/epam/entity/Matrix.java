package kz.epam.entity;

import kz.epam.action.MatrixAction;

public class Matrix {
	private final String matrixName;
	private static int matrixCount = 0;
	private final int[][] integerMatrix;

	public Matrix() {
		matrixName = "Matrix-" + matrixCount;
		integerMatrix = MatrixAction.createMatrix();
		matrixCount++;
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(getMatrixName());
		result.append("(size: ");
		result.append(integerMatrix.length);
		result.append("):\n");
		for (int i = 0; i < integerMatrix.length; i++) {
			for (int j = 0; j < integerMatrix[0].length; j++) {
				result.append(integerMatrix[i][j]);
				result.append("\t");
			}
			result.append("\n");
		}
		return result.toString();
	}

	public String getMatrixName() {
		return matrixName;
	}

	public int getSize() {
		return integerMatrix.length;
	}

	public int[][] getIntegerMatrixClone() {
		int[][] result = new int[getSize()][getSize()];
		System.arraycopy(integerMatrix, 0, result, 0, integerMatrix.length);
		return result;
	}
}
