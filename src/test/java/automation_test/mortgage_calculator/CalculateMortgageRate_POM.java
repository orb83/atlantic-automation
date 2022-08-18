package automation_test.mortgage_calculator;

import command_providers_ModularFrmWrk.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import page_objects.utilities.DateUtils;
import page_objects.utilities.ScreenCapture;

import java.io.IOException;

public class CalculateMortgageRate_POM {

    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    @Test
    public void calculateMonthlyPayment(){
        String[] date = DateUtils.returnNextMonth();

        new Home(driver)
                .typeHomePrice("300000")
                .clickDownPaymentInDollar()
                .typeDownPayment("60000")
                .typeLoanAmount("240000")
                .typeInterestRate("3")
                .typeLoanTermYears("30")
                .selectMonth(date[0])
                .typeYear(date[1])
                .typePropertyTax("5000")
                .typePMI("0.5")
                .typeHomeOwnerInsurance("1000")
                .typeMOnthlyHOA("100")
                .selectLoanType("FHA")
                .selectBuyOrRefinance("Buy")
                .clickOnCalculateButton()
                .validateTotalMonthlyPayment("1,611.85");
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {
        if(ITestResult.FAILURE== result.getStatus()){
            ScreenCapture.getScreenShot(driver);
        }
        // driver.quit();
       // ActOn.browser(driver).closeBrowser();
    }
}
