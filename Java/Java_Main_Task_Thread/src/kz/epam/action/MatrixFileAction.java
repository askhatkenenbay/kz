package kz.epam.action;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MatrixFileAction {
	public static void writeMatrix(String fileName, String matrixName, int[][] integerMatrix) {
		try {
			FileWriter matrixFile = new FileWriter(fileName + ".txt");
			PrintWriter matrixWriter = new PrintWriter(matrixFile);
			matrixWriter.println(matrixName);
			matrixWriter.println("size:" + integerMatrix.length);
			for (int i = 0; i < integerMatrix.length; i++) {
				for (int j = 0; j < integerMatrix[0].length; j++) {
					matrixWriter.print(integerMatrix[i][j] + "\t");
				}
				matrixWriter.println();
			}
			matrixWriter.close();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}
}
