package kz.epam.entity;


import kz.epam.Action.TextPartAction;

import java.util.ArrayList;

import java.util.List;

public class Text implements TextPart, TextSort {
	private String originalText;
	private static final String regexParagraph = "\t[^\t]+\\.";
	private List<Paragraph> textPartList = new ArrayList<>();
	private TextSort nextChain;
	private ArrayList<String> paragraph;

	public Text(String fileName) {
		originalText = new FileReaderEntity(fileName).getFileContent();
		paragraph = TextPartAction.regexFinder(regexParagraph, originalText);
		for (int i = 0; i < paragraph.size(); i++) {
			textPartList.add(new Paragraph(paragraph.get(i)));
		}
	}

	@Override
	public String showInformation() {
		return originalText;
	}

	public String sort() {
		return sort(TextPartAction.chooseSortType());
	}

	@Override
	public String sort(int sortType) {
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
						result.append(textPartList.get(j).showInformation());
						result.append("\n");
					}
				}
			}
			return result.toString();
		} else if (sortType == 2) {
			for (int i = 0; i < textPartList.size(); i++) {
				result.append(textPartList.get(i).sort(sortType));
				result.append("\n");
				result.append("\n");
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
}
