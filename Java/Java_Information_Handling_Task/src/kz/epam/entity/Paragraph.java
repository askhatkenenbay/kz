package kz.epam.entity;

import kz.epam.Action.TextPartAction;

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
	public String showInformation() {

		return paragraphContent;
	}


	@Override
	public String sort(int sortType) {
		StringBuilder result = new StringBuilder();
		if(sortType == 2){
			for (int i = 0; i < textPartList.size(); i++) {
				result.append(textPartList.get(i).sort(sortType));
				result.append("*****");
			}
		}
		if(sortType ==3){
			for (int j = 1; j < 100; j++){
				for (int i = 0; i < textPartList.size(); i++){
					if(textPartList.get(i).numOfWordInSentence() == j){
						result.append(textPartList.get(i).showInformation());
					}
				}
			}
		}
		return result.toString();
	}
}
