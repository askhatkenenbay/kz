package kz.epam.java_information_handling_task.entity.text_parse_chain;

import kz.epam.java_information_handling_task.action.TextParse;

import java.util.List;

public class LexemeParser implements TextParserChain {
	private TextParserChain successor = new WordParser();
	private static final String REGEX_LEXEME = "\\s?.+?[\\s\\.]";

	@Override
	public List<String> parseText(int i, String text) {
		if (i == 1) {
			return TextParse.regexFinder(REGEX_LEXEME, text);
		} else {
			return successor.parseText(i, text);
		}
	}
}
