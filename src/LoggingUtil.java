import java.io.FileInputStream;
import java.io.IOException;
import java.util.logging.*;

public class LoggingUtil {

    public static void initLogManager() throws IOException {
        FileInputStream fis =  new FileInputStream("logging.properties");
        try {
            LogManager.getLogManager().readConfiguration(fis);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    public static Logger configureShipLogger(String loggerName) {
        final Logger LOGGER = Logger.getLogger(loggerName);
        try {
            FileHandler fileHandler_critical = new FileHandler("logs/" + loggerName + "_critical.log");
            FileHandler fileHandler_all = new FileHandler("logs/" + loggerName + "_all.log");
            fileHandler_critical.setFormatter(new SimpleFormatter());
            fileHandler_all.setFormatter(new SimpleFormatter());
            fileHandler_critical.setLevel(Level.WARNING);
            fileHandler_all.setLevel(Level.ALL);
            LOGGER.addHandler(fileHandler_critical);
            LOGGER.addHandler(fileHandler_all);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return LOGGER;
    }

    public static Logger configureContainerLogger(String loggerName) {
        final Logger LOGGER = Logger.getLogger(loggerName);
        try {
            FileHandler fileHandler = new FileHandler("logs/" + loggerName + ".log");
            fileHandler.setLevel(Level.INFO);
            LOGGER.addHandler(fileHandler);
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return LOGGER;
    }
}
