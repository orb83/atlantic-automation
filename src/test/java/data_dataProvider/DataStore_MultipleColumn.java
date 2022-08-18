package data_dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataStore_MultipleColumn {

    @DataProvider(name = "MultipleColumnValue")
    public Object[][] storeMultipleColumnValue(){
        return new Object[][]{
                {"Rifat","Florida",33018},
                {"Farid","New York",12457},
                {"Ashraf","Pennsylvania",11436}
        };

    }
    @Test(dataProvider = "MultipleColumnValue")
    public void run(String name, String state, int zipcode){
        System.out.println("Name is : " +name);
        System.out.println("State is : " +state );
        System.out.println("zipcode is : " +zipcode +"\n");
    }
}
