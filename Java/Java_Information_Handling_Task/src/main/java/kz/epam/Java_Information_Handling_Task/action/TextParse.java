package kz.epam.Java_Information_Handling_Task.action;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextParse {
	public static List<String> regexFinder(String theRegex, String str2Check) {
		List<String> result = new ArrayList<>();
		Pattern checkRegex = Pattern.compile(theRegex, Pattern.DOTALL);
		Matcher regexMatcher = checkRegex.matcher(str2Check);
		while (regexMatcher.find()) {
			result.add(regexMatcher.group());
		}
		return result;
	}
}
