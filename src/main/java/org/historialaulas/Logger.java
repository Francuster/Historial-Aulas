package org.historialaulas;

import java.io.FileWriter;
import java.io.IOException;

public class Logger{

    private final String FILE_PATH = "historial.txt";


    private void writeToFile( String text) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // 'true' enables append mode
            writer.write(text + System.lineSeparator()); // Adds a newline after each message
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}
