package kz.epam.Action;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TextPartAction {
	public static ArrayList<String> regexFinder(String theRegex, String str2Check) {
		ArrayList<String> result = new ArrayList<>();
		Pattern checkRegex = Pattern.compile(theRegex, Pattern.DOTALL);
		Matcher regexMatcher = checkRegex.matcher(str2Check);
		while (regexMatcher.find()) {
			result.add(regexMatcher.group());
		}
		return result;
	}

	public static int chooseSortType() {
		System.out.println("Choose Sort Type for text:");
		System.out.println("[1] Отсортировать абзацы по количеству предложений");
		System.out.println("[2] Отсортировать слова в предложений по длине");
		System.out.println("[3] Отсортировать предложения в абзаце по количеству слов");
		Scanner scanner = new Scanner(System.in);
		int inputInt = scanner.nextInt();
		while (inputInt < 1 || inputInt > 3) {
			System.out.println("Invalid input try again");
			inputInt = scanner.nextInt();
		}
		return inputInt;
	}
}
