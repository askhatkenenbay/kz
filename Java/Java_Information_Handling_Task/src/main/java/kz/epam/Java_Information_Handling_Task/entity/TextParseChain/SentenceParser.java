package kz.epam.Java_Information_Handling_Task.entity.TextParseChain;

import kz.epam.Java_Information_Handling_Task.action.TextParse;

import java.util.List;

public class SentenceParser implements TextParserChain {
	private TextParserChain successor = new LexemeParser();
	private static final String REGEX_SENTENCE = "\t?[A-Z][^\\.]+\\.";
	@Override
	public List<String> parseText(int i, String text) {
		if(i==2){
			return TextParse.regexFinder(REGEX_SENTENCE,text);
		}else{
			return successor.parseText(i,text);
		}
	}
}
