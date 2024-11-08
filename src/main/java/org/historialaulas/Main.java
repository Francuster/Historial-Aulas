package org.historialaulas;


import java.io.FileWriter;
import java.io.IOException;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    private static final String FILE_PATH = "historial.txt";

    public static void main(String[] args) {

    }

    private static void appendToFile(String filePath, String text) {
        try (FileWriter writer = new FileWriter(filePath, true)) { // 'true' enables append mode
            writer.write(text + System.lineSeparator()); // Adds a newline after each message
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }
}