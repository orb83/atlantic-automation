package automation_test.parallelTesting;


import data_dataProvider.DataStore;
import org.testng.annotations.Test;
import page_objects.Home;

public class CalculateRealAprRate_ParallelTesting  extends BaseUIClass {

    @Test(dataProvider = "RealAprRates",dataProviderClass = DataStore.class) //Use Data Provider
    public void calculateRealApr(String homePrice,String downPayment,String interestRate,String expectedApr ){
        new Home(driver)
                .mouseHoverToRates()
                .navigateToRealApr()
                .waitForPageToLoad()
                .typeHomePrice(homePrice)
                .selectDownPaymentInDollar()
                .typeDownPayment(downPayment)
                .typeInterestRate(interestRate)
                .clickOnCalculateButton()
                .validateRealAprRate(expectedApr);
    }
}
