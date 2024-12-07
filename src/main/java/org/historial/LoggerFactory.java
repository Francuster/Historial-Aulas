package org.historial;

public class LoggerFactory {

    public Logger createLogger(String path){

        Writer writer = new Writer(path);

        return new Logger(writer);
    }
}
