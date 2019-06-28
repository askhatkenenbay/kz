package kz.epam.Action;

import kz.epam.entity.Paragraph;
import kz.epam.entity.Sentence;
import kz.epam.entity.Word;

import java.util.List;

public class TextSortAction {

	public static String sort(int sortType, List<Paragraph> textPartList) {
		if (sortType < 1 || sortType > 3) {
			return null;
		}
		StringBuilder result = new StringBuilder();
		if (sortType == 1) {
			int[] temp = new int[textPartList.size()];
			for (int i = 0; i < temp.length; i++) {
				temp[i] = textPartList.get(i).getSentence().size();
			}
			for (int i = 1; i < 100; i++) {
				for (int j = 0; j < temp.length; j++) {
					if (temp[j] == i) {
						result.append(textPartList.get(j).getInformation());
						result.append("\n");
					}
				}
			}
			return result.toString();
		} else if (sortType == 2) {
			for (int i = 0; i < textPartList.size(); i++) {
				result.append(textPartList.get(i).sort(sortType));
				if (i != textPartList.size() - 1) {
					result.append("\n-|-------------New Paragraph-------------------|-\n");
				}
			}
			return result.toString();
		} else {
			for (int i = 0; i < textPartList.size(); i++) {
				result.append(textPartList.get(i).sort(sortType));
				result.append("\n");
			}
			return result.toString();
		}
	}

	public static String paragraphSort(int sortType, List<Sentence> textPartList) {
		StringBuilder result = new StringBuilder();
		if (sortType == 2) {
			for (int i = 0; i < textPartList.size(); i++) {
				result.append(textPartList.get(i).sort(sortType));
				if(i != textPartList.size()-1){
					result.append("<<New Sentence>>");
				}
			}
		}
		if (sortType == 3) {
			for (int j = 1; j < 100; j++) {
				for (int i = 0; i < textPartList.size(); i++) {
					if (textPartList.get(i).numOfWordInSentence() == j) {
						result.append(textPartList.get(i).getInformation());
					}
				}
			}
		}
		return result.toString();
	}

	public static String sentenceSort(int sortType, List<Word> textPartList) {
		StringBuilder result = new StringBuilder();
		if (sortType == 2) {
			for (int i = 1; i < 100; i++) {
				for (int j = 0; j < textPartList.size(); j++) {
					if (Integer.parseInt(textPartList.get(j).sort(sortType)) == i) {
						result.append(textPartList.get(j).getInformation());
						//result.append("|");
					}
				}
			}
		}
		return result.toString();
	}
}
