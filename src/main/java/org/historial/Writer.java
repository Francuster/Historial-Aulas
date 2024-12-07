package org.historial;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {

    private String path;

    public Writer(String path) {
        this.path = path;
    }

    public void write(String line){
        try (FileWriter writer = new FileWriter(path, true)) { // 'true' enables append mode
            writer.write(line + System.lineSeparator()); // Adds a newline after each message
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
