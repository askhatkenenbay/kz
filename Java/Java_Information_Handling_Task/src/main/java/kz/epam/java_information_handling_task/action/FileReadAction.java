package kz.epam.java_information_handling_task.action;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.apache.log4j.Logger;

public class FileReadAction {
	private static Logger logger = Logger.getLogger(FileReadAction.class);

	public static String readFile(String fileName) {
		try {
			FileReader fileReader = new FileReader(fileName + ".txt");
			BufferedReader stream = new BufferedReader(fileReader);
			StringBuilder sb = new StringBuilder();
			String line = stream.readLine();
			while (line != null) {
				sb.append(line);
				sb.append(System.lineSeparator());
				line = stream.readLine();
			}

			return sb.toString();
		} catch (FileNotFoundException fnfe) {
			logger.error("FileNotFoundException while processing: " + fileName);
			fnfe.printStackTrace();
		} catch (IOException e) {
			logger.error("IOException while processing: " + fileName);
			e.printStackTrace();
		}
		return null;
	}

	private FileReadAction() {
		logger.info(new IllegalStateException("Utility class"));
		throw new IllegalStateException("Utility class");
	}
}
