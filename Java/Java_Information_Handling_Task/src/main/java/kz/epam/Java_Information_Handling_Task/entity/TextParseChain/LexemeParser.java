package kz.epam.Java_Information_Handling_Task.entity.TextParseChain;

import kz.epam.Java_Information_Handling_Task.action.TextParse;

import java.util.List;

public class LexemeParser implements TextParserChain {
	private TextParserChain successor = new WordParser();
	private static final String REGEX_LEXEME = "\\s?.+?[\\s\\.]";
	@Override
	public List<String> parseText(int i, String text) {
		if(i==1){
			return TextParse.regexFinder(REGEX_LEXEME,text);
		}else{
			return successor.parseText(i,text);
		}
	}
}
