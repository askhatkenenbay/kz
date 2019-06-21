package kz.epam.entity;

import kz.epam.action.MatrixFileAction;


public class MatrixFileCreator {
	private final Matrix matrixToWrite;
	private final String fileName;

	public MatrixFileCreator(String fileName) {
		this.fileName = fileName;
		matrixToWrite = new Matrix();
	}

	public void writeMatrix() {
		MatrixFileAction.writeMatrix(fileName, matrixToWrite.getMatrixName(), matrixToWrite.getIntegerMatrixClone());
	}

	public String getFileName() {
		return fileName;
	}
}
