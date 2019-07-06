package kz.epam.java_information_handling_task.action;


import kz.epam.java_information_handling_task.entity.text_part_composite.TextPart;
import org.apache.log4j.Logger;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TextSort {
	private static Logger logger = Logger.getLogger(TextSort.class);

	public static int chooseSortType() {
		System.out.println("[1] Отсортировать абзацы по количеству предложений");
		System.out.println("[2] Отсортировать слова в предложений по длине");
		System.out.println("[3] Отсортировать предложения в абзаце по количеству слов");
		System.out.println("[4] Exit");
		Scanner scanner = new Scanner(System.in);
		int inputInt = scanner.nextInt();
		while (inputInt < 1 || inputInt > 4) {
			System.out.println("Invalid input try again");
			inputInt = scanner.nextInt();
		}
		return inputInt;
	}

	public static String listToString(List<TextPart> input, int i) {
		StringBuilder result = new StringBuilder();
		for (TextPart part : input) {
			result.append(part.getCurrentTextPart());
			if (i == 3) {
				result.append("\n\n");
			} else if (i == 2) {
				result.append(". ");
			} else if (i == 0) {
				result.append(" ");
			}
		}
		return result.toString();
	}

	public static List<TextPart> sortTypeOne(List<TextPart> input) {
		input.sort(new SortTypeOne());
		return input;
	}

	private static class SortTypeOne implements Comparator<TextPart> {
		public int compare(TextPart a, TextPart b) {
			return a.getNumOfCompositeElement() - b.getNumOfCompositeElement();
		}
	}

	public static List<TextPart> sortTypeTwo(List<TextPart> input) {
		input.sort(new SortTypeTwo());
		return input;
	}

	private static class SortTypeTwo implements Comparator<TextPart> {
		public int compare(TextPart a, TextPart b) {
			String REGEX_WORD = "[a-zA-Z][a-zA-Z\\-]*";
			return TextParse.regexFinder(REGEX_WORD, a.getOriginalTextPart()).get(0).length() -
					TextParse.regexFinder(REGEX_WORD, b.getOriginalTextPart()).get(0).length();

		}
	}

	public static List<TextPart> sortTypeThree(List<TextPart> input) {
		input.sort(new SortTypeThree());
		return input;
	}

	private static class SortTypeThree implements Comparator<TextPart> {
		public int compare(TextPart a, TextPart b) {
			return a.getNumOfCompositeElement() - b.getNumOfCompositeElement();
		}
	}

	private TextSort() {
		logger.error(new IllegalStateException("Utility Class"));
		throw new IllegalStateException("Utility Class");
	}
}
