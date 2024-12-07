import org.historial.Logger;
import org.historial.LoggerFactory;
import org.historial.Writer;

public class Main {

    private static String FILE_PATH = "historial.txt";


    public static void main(String args[]){


        LoggerFactory loggerFactory = new LoggerFactory();

        Logger logger = loggerFactory.createLogger(FILE_PATH);
        logger.log("hello world");

    }
}
