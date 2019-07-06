package kz.epam.java_information_handling_task;


import kz.epam.java_information_handling_task.entity.text_part_composite.Text;


public class Main {
	public static void main(String[] args){
		Text example = new Text("TextExample2");
		example.sort(1);
		example.sort(2);
		example.sort(3);
	}
}
