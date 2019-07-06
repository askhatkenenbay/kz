package kz.epam.Java_Information_Handling_Task.validator;

public class SortTypeValidator {
	public static boolean validateSortType(int sortType){
		return !(sortType>3 || sortType<1);
	}
}
