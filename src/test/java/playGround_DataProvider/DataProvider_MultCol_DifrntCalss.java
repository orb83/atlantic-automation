package playGround_DataProvider;

import data_dataProvider.DataStore;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class DataProvider_MultCol_DifrntCalss {
    private static final Logger LOGGER = LogManager.getLogger(DataProvider_MultCol_DifrntCalss.class);

    @Test(dataProvider = "MultipleColumnValues",dataProviderClass = DataStore.class)
    public void run(String name, String state, int age){
        LOGGER.info("Name is : "+name);
        LOGGER.info("State is : "+state);
        LOGGER.info("Age is : "+age);
    }
}
