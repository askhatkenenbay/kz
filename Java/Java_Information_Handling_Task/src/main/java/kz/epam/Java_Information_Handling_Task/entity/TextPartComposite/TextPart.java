package kz.epam.Java_Information_Handling_Task.entity.TextPartComposite;

public interface TextPart {
	String getOriginalTextPart();
	String getCurrentTextPart();
	int getNumOfCompositeElement();
	void sort(int sortType);
}
