package kz.epam.Java_Information_Handling_Task.entity.TextPartComposite;

import kz.epam.Java_Information_Handling_Task.action.TextSort;
import kz.epam.Java_Information_Handling_Task.entity.TextParseChain.TextParser;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextPart {
	private List<TextPart> textParts = new ArrayList<>();
	private String sentenceContent;

	public Sentence(String text) {
		sentenceContent = text;

		for (String str:new TextParser().parseText(1,sentenceContent)) {
			textParts.add(new Lexeme(str));
		}
	}
	@Override
	public String getOriginalTextPart() {
		return sentenceContent;
	}
	public String getCurrentTextPart(){
		return TextSort.listToString(new ArrayList<TextPart>(textParts),1);
	}
	public int getNumOfCompositeElement() {
		return textParts.size();
	}
	public void sort(int sortType){
		if(sortType==2){
			textParts = TextSort.sortTypeTwo(new ArrayList<TextPart>(textParts));
		}
	}
}
