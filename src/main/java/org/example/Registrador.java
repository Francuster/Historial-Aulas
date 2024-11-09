package org.example;

import classroom.notifier.ClassroomNotifier;
import classroom.notifier.entity.Observable;
import classroom.notifier.implement.Observer;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;

public class Registrador implements Observer<Map<String,String>> {

    private final String FILE_PATH = "historial.txt";

    public Registrador(ClassroomNotifier classroomNotifier) {
        classroomNotifier.getAdministradorMaterias().addObserver(this);
    }
    public Registrador() {
        //classroomNotifier.getAdministradorMaterias().addObserver(this);
    }

    private void guardarEnHistorial(String registro) {
        try (FileWriter writer = new FileWriter(FILE_PATH, true)) { // 'true' enables append mode
            writer.write(registro + System.lineSeparator()); // Adds a newline after each message
        } catch (IOException e) {
            System.err.println("Error writing to file: " + e.getMessage());
        }
    }

    @Override
    public void update(Observable<Map<String, String>> observable, Map<String, String> arg) {

        arg.forEach((materia, aula) -> {
            String mensaje = String.format("Aula: %s , materia: %s", aula, materia);
            guardarEnHistorial(mensaje);
            System.out.println(mensaje);
        });
    }
}
