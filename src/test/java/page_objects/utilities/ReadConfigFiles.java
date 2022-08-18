package page_objects.utilities;
import org.testng.annotations.Test;
import java.util.Properties;

public class ReadConfigFiles {
    public static String getPropertyValues(String propName){

        Properties prop;
        String propValue = null;
        try {
            prop = new LoadConfigFiles().readPropertyValues();
            propValue = prop.getProperty(propName);
        }catch (Exception e){
            System.out.println();
        }
        return propValue;
    }
    @Test
    public void testPropertyFile(){
        System.out.println("The value of DbName : " + ReadConfigFiles.getPropertyValues("DbName"));
        System.out.println("The value of DbUser : " +ReadConfigFiles.getPropertyValues( "DbUser"));
    }
}
