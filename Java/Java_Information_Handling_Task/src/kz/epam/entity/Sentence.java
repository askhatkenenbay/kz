package kz.epam.entity;

import kz.epam.Action.TextPartAction;
import kz.epam.Action.TextSortAction;

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
	public String getInformation() {
		return sentenceContent;
	}

	public List<Word> getTextPartList(){
		List<Word> clone = new ArrayList<>();
		for (int i = 0; i < textPartList.size(); i++) {
			clone.add(textPartList.get(i));
		}
		return clone;
	}
	@Override
	public String sort(int sortType) {
		return TextSortAction.sentenceSort(sortType,textPartList);
	}

	public int numOfWordInSentence(){
		return word.size();
	}
}
