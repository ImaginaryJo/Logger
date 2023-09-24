import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.FileHandler;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

public class LoggerClass {
    //file path
    private static final String filePath = "C:\\Enter Path where you want logs kept";
    //logger
    private static final Logger logger = Logger.getLogger(LoggerClass.class.getName());
    //declaring handler variable
    private static Handler fileHandler;
    static {
        try {
            // set up logger with a file handler
            fileHandler = new FileHandler(filePath, true);
            //set level for fileHandler
            fileHandler.setLevel(Level.ALL);
            logger.addHandler(fileHandler);
            
            // Set log level and format
            logger.setLevel(Level.ALL);
            SimpleFormatter formatter = new SimpleFormatter();
            fileHandler.setFormatter(formatter);
            
        } catch (IOException e) {
            // Handle exception when creating file handler
            e.printStackTrace();
        }
    }
    //logger method
    public static void log(Level level, String message) {
        logger.log(level, message);
    }
  //method to read log file
    public static void readLogFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
