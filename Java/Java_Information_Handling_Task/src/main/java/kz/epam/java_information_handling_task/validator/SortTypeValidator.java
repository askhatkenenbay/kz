package kz.epam.java_information_handling_task.validator;

import org.apache.log4j.Logger;

public class SortTypeValidator {
	private static Logger logger = Logger.getLogger(SortTypeValidator.class);

	public static boolean validateSortType(int sortType) {
		return !(sortType > 3 || sortType < 1);
	}

	private SortTypeValidator() {
		logger.error(new IllegalStateException("Utility class"));
		throw new IllegalStateException("Utility Class");
	}
}
