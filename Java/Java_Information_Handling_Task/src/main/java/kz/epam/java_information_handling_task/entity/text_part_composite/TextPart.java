package kz.epam.java_information_handling_task.entity.text_part_composite;

public interface TextPart {
	String getOriginalTextPart();

	String getCurrentTextPart();

	int getNumOfCompositeElement();

	void sort(int sortType);
}
