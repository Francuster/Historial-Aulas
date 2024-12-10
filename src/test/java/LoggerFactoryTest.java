import org.historial.Logger;
import org.historial.LoggerFactory;
import org.junit.jupiter.api.Test;

public class LoggerFactoryTest {

    private static String FILE_PATH = "historial.txt";
    
    @Test
    public void init(){
        LoggerFactory loggerFactory = new LoggerFactory();

        Logger logger = loggerFactory.createLogger(FILE_PATH);
        logger.log("hello world");
    }
}
