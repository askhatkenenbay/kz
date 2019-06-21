package kz.epam.validator;

public class MatrixThreadValidator {
	private static final int MIN_NUMBER = 100;
	private static final int MAX_NUMBER = 999;

	public static boolean validateNumberOfThread(int numberOfThread) {
		return (numberOfThread >= MIN_NUMBER && numberOfThread <= MAX_NUMBER);
	}
}
