package kz.epam.Java_Information_Handling_Task.entity.TextParseChain;

import kz.epam.Java_Information_Handling_Task.action.TextParse;

import java.util.List;

public class ParagraphParser implements TextParserChain {
	private TextParserChain successor = new SentenceParser();
	private static final String REGEX_PARAGRAPH = "\t[^\t]+\\.";
	@Override
	public List<String> parseText(int i, String text) {
		if(i == 3){
			return TextParse.regexFinder(REGEX_PARAGRAPH,text);
		}else{
			return successor.parseText(i,text);
		}
	}
}
