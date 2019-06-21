package kz.epam.action;

import kz.epam.validator.CharToIntegerValidator;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class MatrixReadAction {
	public static String readMatrixName(String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName + ".txt");
			BufferedReader matrixStream = new BufferedReader(fileReader);
			String result = matrixStream.readLine();
			matrixStream.close();
			return result;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}

	public static int readSizeOfMatrix(String fileName) {
		try {
			int result;
			FileReader fileReader = new FileReader(fileName + ".txt");
			BufferedReader matrixStream = new BufferedReader(fileReader);
			matrixStream.readLine();
			String str = matrixStream.readLine();
			if (CharToIntegerValidator.validateCharToInteger(str.charAt(str.length() - 1)) &&
					CharToIntegerValidator.validateCharToInteger(str.charAt(str.length() - 2))) {
				result = Integer.parseInt(str.substring(str.length() - 2));
			} else {
				result = Character.getNumericValue(str.charAt(str.length() - 1));
			}
			matrixStream.close();
			return result;
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return -1;
	}

	public static int[][] readIntegerMatrix(String fileName) {
		int size = readSizeOfMatrix(fileName);
		int[][] result = new int[size][size];
		try {
			FileReader fileReader = new FileReader(fileName + ".txt");
			BufferedReader matrixStream = new BufferedReader(fileReader);
			matrixStream.readLine();
			matrixStream.readLine();

			for (int i = 0; i < size; i++) {
				int j = 0;
				String str = matrixStream.readLine();
				for (int k = 0; k < str.length(); k++) {
					if (CharToIntegerValidator.validateCharToInteger(str.charAt(k))) {
						result[i][j] = Character.getNumericValue(str.charAt(k));
						j++;
					}
				}
			}
			matrixStream.close();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return result;
	}
}
