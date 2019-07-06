package kz.epam.java_information_handling_task.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.log4j.Logger;

public class TextParse {
	private static Logger logger = Logger.getLogger(TextParse.class);

	public static List<String> regexFinder(String theRegex, String str2Check) {
		List<String> result = new ArrayList<>();
		Pattern checkRegex = Pattern.compile(theRegex, Pattern.DOTALL);
		Matcher regexMatcher = checkRegex.matcher(str2Check);
		while (regexMatcher.find()) {
			result.add(regexMatcher.group());
		}
		return result;
	}

	private TextParse() {
		logger.info(new IllegalStateException("Utility class"));
		throw new IllegalStateException("Utility class");
	}
}
