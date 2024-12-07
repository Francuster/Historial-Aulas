package org.historial;


//TODO: implement Observer from core project
public class Logger {

    private Writer writer;

    public Logger(Writer writer) {
        this.writer = writer;
    }


    //TODO: format line here before writing
    public void log(String line){
        writer.write(line);
    }


    //TODO: implement obversable method update
//    @Override
//    public void update(Observable<Map<String, String>> observable, Map<String, String> arg) {
//
//        arg.forEach((materia, aula) -> {
//            String mensaje = String.format("Aula: %s , materia: %s", aula, materia);
//            guardarEnHistorial(mensaje);
//            System.out.println(mensaje);
//        });
//    }
}
