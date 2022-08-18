package data_dataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataStore {
    @DataProvider(name = "SingleColumnValue")
    public Object[][] storeSingleColumnValue(){
        return new Object[][]{
                {"Rifat"}, {"Farid"},{"Ashraf"}
        };

    }
    @DataProvider(name = "RealAprRates")
    public Object[][] storeRealAprRates(){
        return new Object[][] {
                {"200000","15000","3","3.130%"}
        };
    }
    @Test(dataProvider = "SingleColumnValue")
    public void run(String name){
        System.out.println("Name is : " +name);
    }
}
