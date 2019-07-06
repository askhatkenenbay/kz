package kz.epam.Java_Information_Handling_Task.entity;
import kz.epam.Java_Information_Handling_Task.action.FileReadAction;
public class FileReaderEntity {
		private final String fileContent;

		public FileReaderEntity(String fileName) {
			fileContent = FileReadAction.readFile(fileName);
		}

		public String getFileContent() {
			return fileContent;
		}
}
