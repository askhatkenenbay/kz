package kz.epam.Java_Information_Handling_Task.entity.TextPartComposite;

import kz.epam.Java_Information_Handling_Task.action.TextSort;
import kz.epam.Java_Information_Handling_Task.entity.TextParseChain.TextParser;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextPart {
	private List<TextPart> textParts = new ArrayList<>();
	private final String paragraphContent;
	public Paragraph(String text) {
		paragraphContent = text;
		for (String str:new TextParser().parseText(2,paragraphContent)) {
			textParts.add(new Sentence(str));
		}
	}
	@Override
	public String getOriginalTextPart() {
		return paragraphContent;
	}
	public String getCurrentTextPart(){
		return TextSort.listToString(new ArrayList<TextPart>(textParts),2);
	}
	public int getNumOfCompositeElement() {
		return textParts.size();
	}
	public void sort(int sortType){
		if(sortType==2){
			for (TextPart part : textParts) {
				part.sort(sortType);
			}
		}else{
			textParts = TextSort.sortTypeThree(new ArrayList<TextPart>(textParts));
		}
	}
}
