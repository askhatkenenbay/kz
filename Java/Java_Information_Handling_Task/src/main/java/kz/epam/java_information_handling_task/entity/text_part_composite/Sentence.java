package kz.epam.java_information_handling_task.entity.text_part_composite;

import kz.epam.java_information_handling_task.action.TextSort;
import kz.epam.java_information_handling_task.entity.text_parse_chain.TextParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Sentence implements TextPart {
	private static Logger logger = Logger.getLogger(Text.class);
	private List<TextPart> textParts = new ArrayList<>();
	private String sentenceContent;

	public Sentence(String text) {
		sentenceContent = text;
		for (String str : new TextParser().parseText(1, sentenceContent)) {
			textParts.add(new Lexeme(str));
		}
		logger.info("Sentence was parsed to lexemes");
	}

	@Override
	public String getOriginalTextPart() {
		return sentenceContent;
	}

	public String getCurrentTextPart() {
		return TextSort.listToString(new ArrayList<>(textParts), 1);
	}

	public int getNumOfCompositeElement() {
		return textParts.size();
	}

	public void sort(int sortType) {
		if (sortType == 2) {
			textParts = TextSort.sortTypeTwo(new ArrayList<>(textParts));
		}
	}
}
