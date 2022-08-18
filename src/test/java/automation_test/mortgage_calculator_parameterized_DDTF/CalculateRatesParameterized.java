package automation_test.mortgage_calculator_parameterized_DDTF;

import command_providers_ModularFrmWrk.ActOn;
import data_dataProvider.DataStore;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import page_objects.utilities.ReadConfigFiles;

public class CalculateRatesParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateRatesParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        LOGGER.info("............Test Name: Calculate Real APR............");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

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
    @AfterMethod
    public void closeBrowser(){
        LOGGER.info("............End Test Case: Calculate Real APR............");
        ActOn.browser(driver).closeBrowser();
    }
}
