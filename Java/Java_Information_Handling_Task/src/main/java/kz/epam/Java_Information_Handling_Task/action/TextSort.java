package kz.epam.Java_Information_Handling_Task.action;


import kz.epam.Java_Information_Handling_Task.entity.TextPartComposite.TextPart;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class TextSort {
	public static int chooseSortType() {
		System.out.println("Choose Sort Type for text:");
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

	public static List<TextPart> sortTypeOne(List<TextPart> input){
		Collections.sort(input,new SortTypeOne());
		return input;
	}
	private static class SortTypeOne implements Comparator<TextPart> {
		public int compare(TextPart a, TextPart b){
			return a.getNumOfCompositeElement() - b.getNumOfCompositeElement();
		}
	}
	public static String listToString(List<TextPart> input, int i){
		StringBuilder result = new StringBuilder();
		for (TextPart part: input) {
			result.append(part.getCurrentTextPart());
			if(i == 3){
				result.append("\n\n");
			}else if(i == 2){
				result.append(". ");
			}else if(i==0){
				result.append(" ");
			}
		}
		return result.toString();
	}

	public static List<TextPart> sortTypeTwo(List<TextPart> input){
		Collections.sort(input,new SortTypeTwo());
		return input;
	}
	private static class SortTypeTwo implements Comparator<TextPart> {
		public int compare(TextPart a, TextPart b){
			String REGEX_WORD = "[a-zA-Z][a-zA-Z\\-]*";
			return TextParse.regexFinder(REGEX_WORD, a.getOriginalTextPart()).get(0).length() -
					TextParse.regexFinder(REGEX_WORD, b.getOriginalTextPart()).get(0).length();

		}
	}

	public static List<TextPart> sortTypeThree(List<TextPart> input){
		Collections.sort(input,new SortTypeThree());
		return input;
	}
	private static class SortTypeThree implements Comparator<TextPart> {
		public int compare(TextPart a, TextPart b){
			return a.getNumOfCompositeElement() - b.getNumOfCompositeElement();
		}
	}
}
