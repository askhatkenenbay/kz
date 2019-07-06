package kz.epam.java_information_handling_task.entity.text_part_composite;

import org.apache.log4j.Logger;

public class Word implements TextPart {
	private static Logger logger = Logger.getLogger(Word.class);
	private final String wordContent;


	public Word(String str) {
		wordContent = str;
	}

	@Override
	public String getOriginalTextPart() {
		return wordContent;
	}

	public String getCurrentTextPart() {
		return wordContent;
	}

	public int getNumOfCompositeElement() {
		return 1;
	}

	public void sort(int sortType) {
		logger.error(new UnsupportedOperationException("No such operation"));
		throw new UnsupportedOperationException("No such operation");
	}
}
