package org.example;

import classroom.notifier.AdministradorMaterias;
import classroom.notifier.ClassroomNotifier;
import classroom.notifier.entity.Observable;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;

public class BuscadorClassroom {

    boolean encontrado = false;
    javax.swing.Timer timer;
    Registrador registrador = null;

    public BuscadorClassroom(String[] args){
        int frecuencia = 5000;

        timer = new javax.swing.Timer(frecuencia, e -> {
            //changesDetectedVisible = !changesDetectedVisible;
            buscarClassroom(args);
            if(encontrado) timer.stop();
        });
        timer.setRepeats(true);
        timer.start();
    }

    public Registrador generarRegistrador(){
        return registrador;
    }

    public void buscarClassroom(String[] args) {


        try {

            // Dynamically load App1Class
            Class<?> app1Class = Class.forName("classroom.notifier.ClassroomNotifier");//,false,ClassroomNotifier.class.getClassLoader());

            //Constructor<?> constructor = app1Class.getDeclaredConstructor(classroom.getClass());
            //Object instance =  constructor.newInstance(classroom);
            Method getInstanceMethod =  app1Class.getMethod("getInstance",args.getClass());
            Object[] param = new Object[1];
            param[0] = args;
            ClassroomNotifier notifier = (ClassroomNotifier) getInstanceMethod.invoke(null,param);
            System.out.printf( (notifier ==null)? "null" : "inicializado");

            if(notifier ==null) return;

            registrador = new Registrador(notifier);
            //notifier.addObserver(registrador);
            /*
            //Constructor<?> constructor = app1Class.getDeclaredConstructor(args.getClass());
            //this.classroomNotifier =  (ClassroomNotifier) constructor.newInstance(args);

            */
            encontrado = true;
        } catch (ClassNotFoundException | NoClassDefFoundError | NoSuchMethodException e) {
            System.out.println("App1Class could not be loaded. Skipping message print.");
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }


    }
}
