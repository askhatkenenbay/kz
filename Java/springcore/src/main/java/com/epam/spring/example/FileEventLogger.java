package com.epam.spring.example;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;

public class FileEventLogger implements EventLogger {
    private String filename;

    FileEventLogger(String filename) {
        this.filename = filename;
    }

    @Override
    public void logEvent(Event event) {
        try {
            FileUtils.writeStringToFile(new File(filename), String.valueOf(event) + "\n", true);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void init() throws IOException {
        File file = new File(filename);
        if (!file.canWrite()) {
            throw new IOException("can not write to file");
        }
    }
}
