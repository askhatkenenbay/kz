package kz.epam.Action;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReadAction {
	public static String readFile(String fileName){
		try{
			FileReader fileReader = new FileReader(fileName + ".txt");
			BufferedReader stream = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String line = stream.readLine();
			while(line != null){
				sb.append(line);
				sb.append(System.lineSeparator());
				line = stream.readLine();
			}
			stream.close();
			return sb.toString();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
		return null;
	}
}

