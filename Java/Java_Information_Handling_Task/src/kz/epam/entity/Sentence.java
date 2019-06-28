package kz.epam.entity;

import kz.epam.Action.TextPartAction;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextPart, TextSort {
	private String sentenceContent = "";
	private List<Word> textPartList = new ArrayList<>();
	private static final String regexWord = "\\s?[a-zA-Z,]+(\\s|\\.)";
	private List<String> word;
	public Sentence(String sentence) {
		sentenceContent = sentence;
		word = TextPartAction.regexFinder(regexWord, sentenceContent);
		for (int i = 0; i < word.size(); i++) {
			textPartList.add(new Word(word.get(i)));
		}
	}

	@Override
	public String showInformation() {
		return sentenceContent;
	}


	@Override
	public String sort(int sortType) {
		StringBuilder result = new StringBuilder();
		if(sortType == 2){
			for (int i = 1; i < 100; i++) {
				for (int j = 0; j < textPartList.size(); j++) {
					if(Integer.parseInt(textPartList.get(j).sort(sortType)) == i){
						result.append(textPartList.get(j).showInformation());
						result.append("|");
					}
				}
			}
		}
		if(sortType == 3){

		}
		return result.toString();
	}

	public int numOfWordInSentence(){
		return word.size();
	}
}
