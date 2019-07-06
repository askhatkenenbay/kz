package kz.epam.Java_Information_Handling_Task;


import kz.epam.Java_Information_Handling_Task.entity.TextPartComposite.Text;
import org.apache.log4j.Logger;

public class Main {
	public static Logger logger = Logger.getLogger(Main.class);
	public static void main(String[] args){
		Text example = new Text("TextExample2");
		example.sort(1);
		example.sort(3);
		System.out.println(example.getCurrentTextPart());
	}
}
