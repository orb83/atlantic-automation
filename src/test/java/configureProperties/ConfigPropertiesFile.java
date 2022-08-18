package configureProperties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

public class ConfigPropertiesFile {
    public static final Logger LOGGER = LogManager.getLogger(ConfigPropertiesFile.class);
    Properties properties = new Properties();

        //How to read value from config.properties file?
    public void readDataFromPropertiesFile()  {
       // String configpropertiesfilename= "config.properties";

       // Properties properties = new Properties();
        try {

            InputStream inputStream = new FileInputStream("C:/Users/morbe/IdeaProjects/MyFirstProject/src/test/resources/config.properties");
           // InputStream inputStream = new FileInputStream(configpropertiesfilename);
            properties.load(inputStream);
            System.out.println(properties.getProperty("DbUser"));
        }
        catch (Exception e){
            LOGGER.error("Exception" +e.getMessage());
    }
}
        // How to Set Data/value to config.properties file?
    public void setDataToPropertiesFile() {
        //Properties properties = new Properties();
        try {
            OutputStream outputStream = new FileOutputStream("C:/Users/morbe/IdeaProjects/MyFirstProject/src/test/resources/config.properties");
            properties.setProperty("DbAuthor","Obeydur");
            properties.store(outputStream,"Practicing Properties file ");
        }
        catch (Exception e){
             LOGGER.error("Exception: "+ e.getMessage());
    }
}
    @Test
    public void displayValueFromPropertiesFile(){
         readDataFromPropertiesFile();
        // setDataToPropertiesFile();
    }

    @Test
    public void setValueToPropertiesFile(){

        setDataToPropertiesFile();
    }
}
