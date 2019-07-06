package kz.epam.java_information_handling_task.entity.text_part_composite;

import kz.epam.java_information_handling_task.action.TextSort;
import kz.epam.java_information_handling_task.entity.text_parse_chain.TextParser;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Lexeme implements TextPart {
	private static Logger logger = Logger.getLogger(Text.class);
	private List<TextPart> textParts = new ArrayList<>();
	private final String lexemeContent;

	public Lexeme(String text) {
		lexemeContent = text;
		for (String str : new TextParser().parseText(0, lexemeContent)) {
			textParts.add(new Word(str));
		}
		logger.info("Lexeme was parsed to word");
	}

	@Override
	public String getOriginalTextPart() {
		return lexemeContent;
	}

	public String getCurrentTextPart() {
		return TextSort.listToString(new ArrayList<>(textParts), 0);
	}

	public int getNumOfCompositeElement() {
		return textParts.size();
	}

	public void sort(int sortType) {
		throw new UnsupportedOperationException("No such operation");
	}
}
