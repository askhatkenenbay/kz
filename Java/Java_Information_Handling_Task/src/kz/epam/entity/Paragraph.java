package kz.epam.entity;

import kz.epam.Action.TextPartAction;
import kz.epam.Action.TextSortAction;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextPart, TextSort {
	private String paragraphContent = "";
	private List<Sentence> textPartList = new ArrayList<>();
	private static final String regexSentence = "\t?[A-Z][^\\.]+\\.";
	private List<String> sentence;
	public Paragraph(String str) {
		paragraphContent = str;
		sentence = TextPartAction.regexFinder(regexSentence, paragraphContent);
		for (int i = 0; i < sentence.size(); i++) {
			textPartList.add(new Sentence(sentence.get(i)));
		}
	}

	public List<String> getSentence() {
		return sentence;
	}

	@Override
	public String getInformation() {

		return paragraphContent;
	}

	public List<Sentence> getTextPartList(){
		List<Sentence> clone = new ArrayList<>();
		for (int i = 0; i < textPartList.size(); i++) {
			clone.add(textPartList.get(i));
		}
		return clone;
	}
	@Override
	public String sort(int sortType) {
		return TextSortAction.paragraphSort(sortType,this.getTextPartList());
	}
}
