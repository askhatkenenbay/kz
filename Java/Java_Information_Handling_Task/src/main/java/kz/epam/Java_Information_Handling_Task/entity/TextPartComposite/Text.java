package kz.epam.Java_Information_Handling_Task.entity.TextPartComposite;

import kz.epam.Java_Information_Handling_Task.action.TextSort;
import kz.epam.Java_Information_Handling_Task.entity.FileReaderEntity;
import kz.epam.Java_Information_Handling_Task.entity.TextParseChain.TextParser;
import kz.epam.Java_Information_Handling_Task.validator.SortTypeValidator;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextPart {
	//stores original text
	private String originalText;
	//stores current state
	private List<TextPart> textParts = new ArrayList<>();

	public Text(String fileName) {
		originalText = new FileReaderEntity(fileName).getFileContent();
		for (String str : new TextParser().parseText(3, originalText)) {
			textParts.add(new Paragraph(str));
		}
	}

	@Override
	public String getOriginalTextPart() {
		//textParts.removeIf(o -> o == null);
		//textParts.forEach(TextPart::getTextPart);
		return originalText;
	}
	public String getCurrentTextPart(){
		return TextSort.listToString(new ArrayList<TextPart>(textParts),3);
	}

	@Override
	public int getNumOfCompositeElement() {
		return textParts.size();
	}

	public void sort(){
		int sortType = TextSort.chooseSortType();
		if(sortType==4){
			return;
		}else{
			sort(sortType);
		}
	}
	public void sort(int sortType){
		if(!SortTypeValidator.validateSortType(sortType)){
			return;
		}
		if(sortType==1){
			textParts = TextSort.sortTypeOne(new ArrayList<TextPart>(textParts));
		}else if(sortType==2){
			for (TextPart part:textParts) {
				part.sort(sortType);
			}
		}else{
			for (TextPart part:textParts) {
				part.sort(sortType);
			}
		}
	}

}
