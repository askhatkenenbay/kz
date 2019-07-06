package kz.epam.Java_Information_Handling_Task.entity.TextParseChain;

import kz.epam.Java_Information_Handling_Task.action.TextParse;

import java.util.ArrayList;
import java.util.List;

public class WordParser implements TextParserChain {
	private static final String REGEX_WORD = "[a-zA-Z][a-zA-Z\\-]*";
	@Override
	public List<String> parseText(int i, String text) {
		if(i == 0){
			return TextParse.regexFinder(REGEX_WORD,text);
		}else{
			return new ArrayList<>();
		}
	}
}
