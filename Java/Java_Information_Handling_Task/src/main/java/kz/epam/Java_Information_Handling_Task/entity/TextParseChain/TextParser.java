package kz.epam.Java_Information_Handling_Task.entity.TextParseChain;

import java.util.List;

public class TextParser implements TextParserChain {
	private TextParserChain successor = new ParagraphParser();
	@Override
	public List<String> parseText(int i, String text) {
		return successor.parseText(i, text);
	}
}
