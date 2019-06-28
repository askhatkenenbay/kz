package kz.epam.entity;

import kz.epam.Action.FileReadAction;

public class FileReaderEntity {

	private final String fileContent;

	public FileReaderEntity(String fileName) {
		fileContent = FileReadAction.readFile(fileName);
	}

	public String getFileContent() {
		return fileContent;
	}
}
