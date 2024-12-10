package org.historial;


import classroom.notifier.entity.Observable;
import classroom.notifier.implement.Observer;

import java.util.Date;

public class Logger  implements Observer {

    private Writer writer;

    public Logger(Writer writer) {
        this.writer = writer;
    }


    public void log(String line) {
        String formatedMessage = String.format("%s. Fecha: %s", line, new Date().toString());
        System.out.println(formatedMessage);
        writer.write(formatedMessage);

    }

    @Override
    public void update(Object data) {
        log((String) data);
    }

}


