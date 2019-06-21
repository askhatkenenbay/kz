package kz.epam.validator;

public class CharToIntegerValidator {
	private static final int ZERO_AS_CHAR = 48;
	private static final int NINE_AS_CHAR = 57;

	public static boolean validateCharToInteger(int integerIn) {
		return (integerIn >= ZERO_AS_CHAR && integerIn <= NINE_AS_CHAR);
	}
}
