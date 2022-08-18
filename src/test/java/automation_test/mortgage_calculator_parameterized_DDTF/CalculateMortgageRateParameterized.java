package automation_test.mortgage_calculator_parameterized_DDTF;

import command_providers_ModularFrmWrk.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.Home;
import page_objects.utilities.DateUtils;
import page_objects.utilities.ReadConfigFiles;
import page_objects.utilities.ScreenCapture;
import page_objects.utilities.SqlConnector;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CalculateMortgageRateParameterized {
    private static final Logger LOGGER = LogManager.getLogger(CalculateMortgageRateParameterized.class);
    WebDriver driver;

    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        LOGGER.info("--------------Test Name: Calculate Monthly Payment-----------");

        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
    }

    @Test
    public void calculateMonthlyPayment(){
        String[] date = DateUtils.returnNextMonth();
        try {
            ResultSet rs = SqlConnector.readData("select * from monthly_mortgage");
            while (rs.next()){
                new Home(driver)
                        .typeHomePrice(rs.getString("homevalue"))
                        .clickDownPaymentInDollar()
                        .typeDownPayment(rs.getString("downpayment"))
                        .typeLoanAmount(rs.getString("loanamount"))
                        .typeInterestRate(rs.getString("interestrate"))
                        .typeLoanTermYears(rs.getString("loanterm"))
                        .selectMonth(date[0])
                        .typeYear(date[1])
                        .typePropertyTax(rs.getString("propertytax"))
                        .typePMI(rs.getString("pmi"))
                        .typeHomeOwnerInsurance(rs.getString("homeownerinsurance"))
                        .typeMOnthlyHOA(rs.getString("monthlyhoa"))
                        .selectLoanType(rs.getString("loantype"))
                        .selectBuyOrRefinance(rs.getString("buyorrefi"))
                        .clickOnCalculateButton()
                        .validateTotalMonthlyPayment(rs.getString("totalmonthlypayment"));
            }
        }catch (SQLException e){
            LOGGER.error("SQL Data Read Exception: " +e.getMessage());
        }
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {
        if(ITestResult.FAILURE== result.getStatus()){
            ScreenCapture.getScreenShot(driver);
        }
        ActOn.browser(driver).closeBrowser();
        LOGGER.info("-----End Test Case: Calculate Monthly Payment------");
    }
}
