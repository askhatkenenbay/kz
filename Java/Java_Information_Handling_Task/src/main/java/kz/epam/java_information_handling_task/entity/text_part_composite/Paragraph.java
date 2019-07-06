package kz.epam.java_information_handling_task.entity.text_part_composite;

import kz.epam.java_information_handling_task.action.TextSort;
import kz.epam.java_information_handling_task.entity.text_parse_chain.TextParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Paragraph implements TextPart {
	private static Logger logger = Logger.getLogger(Paragraph.class);
	private List<TextPart> textParts = new ArrayList<>();
	private final String paragraphContent;

	public Paragraph(String text) {
		paragraphContent = text;
		for (String str : new TextParser().parseText(2, paragraphContent)) {
			textParts.add(new Sentence(str));
		}
		logger.info("Paragraph was parsed to sentences");
	}

	@Override
	public String getOriginalTextPart() {
		return paragraphContent;
	}

	public String getCurrentTextPart() {
		return TextSort.listToString(new ArrayList<>(textParts), 2);
	}

	public int getNumOfCompositeElement() {
		return textParts.size();
	}

	public void sort(int sortType) {
		if (sortType == 2) {
			for (TextPart part : textParts) {
				part.sort(sortType);
			}
		} else {
			textParts = TextSort.sortTypeThree(new ArrayList<>(textParts));
		}
	}
}
