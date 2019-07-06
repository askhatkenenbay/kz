package kz.epam.java_information_handling_task.entity.text_part_composite;

import kz.epam.java_information_handling_task.action.FileReadAction;
import kz.epam.java_information_handling_task.action.TextSort;
import kz.epam.java_information_handling_task.entity.text_parse_chain.TextParser;
import kz.epam.java_information_handling_task.validator.SortTypeValidator;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.List;

public class Text implements TextPart {
	private static Logger logger = Logger.getLogger(Text.class);
	//stores original text
	private String originalText;
	//stores current state
	private List<TextPart> textParts = new ArrayList<>();

	public Text(String fileName) {
		originalText = FileReadAction.readFile(fileName);
		logger.info("Text from "+fileName+" was obtained");
		for (String str : new TextParser().parseText(3, originalText)) {
			textParts.add(new Paragraph(str));
		}
		logger.info("Text was parsed to paragraphs");
	}

	@Override
	public String getOriginalTextPart() {
		return originalText;
	}

	public String getCurrentTextPart() {
		return TextSort.listToString(new ArrayList<>(textParts), 3);
	}

	@Override
	public int getNumOfCompositeElement() {
		return textParts.size();
	}

	public void sort() {
		int sortType = TextSort.chooseSortType();
		if (sortType != 4) {
			sort(sortType);
		}
	}

	public void sort(int sortType) {
		if (!SortTypeValidator.validateSortType(sortType)) {
			logger.info("Invalid input: "+sortType);
			return;
		}
		if (sortType == 1) {
			textParts = TextSort.sortTypeOne(new ArrayList<>(textParts));
			logger.info("Sorted as --> Отсортировать абзацы по количеству предложений");
			logger.info(TextSort.listToString(new ArrayList<>(textParts), 3));
		} else if (sortType == 2) {
			for (TextPart part : textParts) {
				part.sort(sortType);
			}
			logger.info("Sorted as --> Отсортировать слова в предложений по длине");
			logger.info(TextSort.listToString(new ArrayList<>(textParts), 3));
		} else {
			for (TextPart part : textParts) {
				part.sort(sortType);
			}
			logger.info("Sorted as --> Отсортировать предложения в абзаце по количеству слов");
			logger.info(TextSort.listToString(new ArrayList<>(textParts), 3));
		}
	}

}
