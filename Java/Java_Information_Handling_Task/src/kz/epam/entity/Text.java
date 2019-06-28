package kz.epam.entity;

import kz.epam.Action.TextPartAction;
import kz.epam.Action.TextSortAction;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextPart, TextSort {
	//stores original text
	private String originalText;
	//regular expression to find paragraphs
	private static final String regexParagraph = "\t[^\t]+\\.";
	//stores all paragraphs in text
	private List<Paragraph> textPartList = new ArrayList<>();
	private ArrayList<String> paragraph;
	private TextSort nextChain;

	public Text(String fileName) {
		originalText = new FileReaderEntity(fileName).getFileContent();
		paragraph = TextPartAction.regexFinder(regexParagraph, originalText);
		for (int i = 0; i < paragraph.size(); i++) {
			textPartList.add(new Paragraph(paragraph.get(i)));
		}
	}

	@Override
	public String getInformation() {
		return originalText;
	}


	public List<Paragraph> getTextPartList(){
		List<Paragraph> clone = new ArrayList<>();
		for (int i = 0; i < textPartList.size(); i++) {
			clone.add(textPartList.get(i));
		}
		return clone;
	}
	public String sort() {
		return sort(TextPartAction.chooseSortType());
	}
	@Override
	public String sort(int sortType) {
		return TextSortAction.sort(sortType,this.getTextPartList());
	}
}
