package kz.epam.java_information_handling_task.entity.text_parse_chain;

import java.util.List;

public class TextParser implements TextParserChain {
	private TextParserChain successor = new ParagraphParser();

	@Override
	public List<String> parseText(int i, String text) {
		return successor.parseText(i, text);
	}
}
