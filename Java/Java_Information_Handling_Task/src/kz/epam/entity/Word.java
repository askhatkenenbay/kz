package kz.epam.entity;

public class Word implements TextPart, TextSort {
	private String word;

	public Word(String word) {
		this.word = word;
	}

	@Override
	public String getInformation() {
		return word;
	}

	@Override
	public String sort(int sortType) {
		return "" + word.length();
	}
}
