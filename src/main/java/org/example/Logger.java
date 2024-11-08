package org.example;

import classroom.notifier.ClassroomNotifier;
import classroom.notifier.entity.Observable;
import classroom.notifier.implement.Observer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Logger implements Observer<Map<String,String>> {

    private final String FILE_PATH = "historial.txt";

    public Logger(ClassroomNotifier classroomNotifier) {
        classroomNotifier.getAdministradorMaterias().addObserver(this);
    }

    private void writeToFile(String text) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // 'true' enables append mode
            writer.write(text + System.lineSeparator()); // Adds a newline after each message
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public void update(Observable<Map<String, String>> observable, Map<String, String> arg) {

        arg.forEach((materia, aula) -> {
            String mensaje = String.format("Aula: %s , materia: %s", aula, materia);
            writeToFile(mensaje);
            System.out.println(mensaje);
        });
    }
}
