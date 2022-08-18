package PracticeAutomation.testng;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class TestNgMavenTest_Logger {

    private static final Logger LOGGER = LogManager.getLogger(TestNgMavenTest_Logger.class);
    @Test
    public void run(){
       // System.out.println("This is TestNg Maven Example");

        LOGGER.debug("This is debug message");
        LOGGER.info("This is info message");
        LOGGER.warn("This is warning message");
        LOGGER.error("This is an error message");
        LOGGER.fatal("This is  dangerous");
    }
}
