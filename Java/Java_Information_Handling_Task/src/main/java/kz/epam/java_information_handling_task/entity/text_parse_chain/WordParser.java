package kz.epam.java_information_handling_task.entity.text_parse_chain;

import kz.epam.java_information_handling_task.action.TextParse;

import java.util.ArrayList;
import java.util.List;

public class WordParser implements TextParserChain {
	private static final String REGEX_WORD = "[a-zA-Z][a-zA-Z\\-]*";

	@Override
	public List<String> parseText(int i, String text) {
		if (i == 0) {
			return TextParse.regexFinder(REGEX_WORD, text);
		} else {
			return new ArrayList<>();
		}
	}
}
