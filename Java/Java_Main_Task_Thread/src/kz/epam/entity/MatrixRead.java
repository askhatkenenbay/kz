package kz.epam.entity;

import kz.epam.action.MatrixReadAction;

public class MatrixRead {
	private final String matrixName;
	private final int matrixSize;
	private final int[][] integerMatrix;

	public MatrixRead(String fileName) {
		matrixName = MatrixReadAction.readMatrixName(fileName);
		matrixSize = MatrixReadAction.readSizeOfMatrix(fileName);
		integerMatrix = MatrixReadAction.readIntegerMatrix(fileName);
	}

	public String toString() {
		StringBuilder result = new StringBuilder();
		result.append(matrixName);
		result.append("(size: ");
		result.append(matrixSize);
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

	public int[][] getMatrix() {
		return cloneIntegerMatrix();
	}

	private int[][] cloneIntegerMatrix() {
		int[][] clone = new int[matrixSize][matrixSize];
		System.arraycopy(integerMatrix, 0, clone, 0, integerMatrix.length);
		return clone;
	}
}
