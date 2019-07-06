package kz.epam.Java_Information_Handling_Task.entity.TextPartComposite;

import kz.epam.Java_Information_Handling_Task.action.TextSort;
import kz.epam.Java_Information_Handling_Task.entity.TextParseChain.TextParser;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements TextPart {
	private List<TextPart> textParts = new ArrayList<>();
	private final String lexemeContent;
	public Lexeme(String text){
		lexemeContent = text;
		for (String str:new TextParser().parseText(0,lexemeContent)) {
			textParts.add(new Word(str));
		}
	}
	@Override
	public String getOriginalTextPart() {
		return lexemeContent;
	}
	public String getCurrentTextPart(){
		return TextSort.listToString(new ArrayList<TextPart>(textParts),0);
	}
	public int getNumOfCompositeElement() {
		return textParts.size();
	}
	public void sort(int sortType){

	}
}
