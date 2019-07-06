package kz.epam.Java_Information_Handling_Task.entity.TextPartComposite;



public class Word implements TextPart {
	private final String wordContent;
	public Word(String str){
		wordContent = str;
	}

	@Override
	public String getOriginalTextPart() {
		return wordContent;
	}
	public String getCurrentTextPart(){
		return wordContent;
	}
	public int getNumOfCompositeElement() {
		return 1;
	}
	public void sort(int sortType){

	}
}
