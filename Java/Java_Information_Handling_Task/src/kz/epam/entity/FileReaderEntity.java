package kz.epam.entity;

import kz.epam.Action.FileReadAction;

public class FileReaderEntity {

	private  String fileContent = "";

	public FileReaderEntity(String fileName){
		fileContent = FileReadAction.readFile(fileName);
	}

	public String getFileContent() {
		return fileContent;
	}
}
