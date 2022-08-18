package automation_test.mortgage_calculator;

import command_providers_ModularFrmWrk.ActOn;
import command_providers_ModularFrmWrk.AssertThat;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.utilities.DateUtils;
import page_objects.utilities.ScreenCapture;

import java.io.IOException;

public class CalculateMonthlyPayment {

    WebDriver driver;

    private final By HomevalueInputField = By.id("homeval");
    private final By DownpaymentInputField = By.id("downpayment");
    private final By DownpaymentTypeInDollar = By.xpath("//*[@id='calc']//input[@name='param[downpayment_type]'][@value='money']");
    private final By LoanamountInputField = By.id("loanamt");
    private final By InterestRateInputField = By.id("intrstsrate");
    private final By LoantermInputField = By.id("loanterm");
    private final By StartMonthDropDown = By.name("param[start_month]");
    private final By StartYearInputField = By.id("start_year");
    private final By PropertyTaxInputField = By.id("pptytax");
    private final By PmiInputField = By.id("pmi");
    private final By HomeInsInputField = By.id("hoi");
    private final By MonthlyhoaInputField = By.id("hoa");
    private final By LoanTypeDropDown = By.name("param[milserve]");
    private final By BuyOrRefDropDown= By.name("param[refiorbuy]");
    private final By CalculateButton = By.name("cal");
    //private final By TotalMonthlyPayment = By.xpath("//*[@id='calc']//h3[contains(text(),'$1,611.85')]");

    Select select;
    @BeforeMethod
    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
       // driver.manage().window().maximize();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }

    public void enterData(){
        //Enter Home value "300000"
        ActOn.element(driver,HomevalueInputField).setvalue("300000");
        //Enter down payment "60000"
        ActOn.element(driver,DownpaymentInputField).setvalue("60000");

        ActOn.element(driver,DownpaymentTypeInDollar).click();

        ActOn.element(driver,LoanamountInputField).setvalue("240000");

        ActOn.element(driver,InterestRateInputField).setvalue("3");

        ActOn.element(driver ,LoantermInputField).setvalue("30");

        //Enter start Date will be always next month
//        String date = DateUtils.returnNextMonth();
//        String[] dates = date.split("-");
//        String month = dates[0];
//        String year = dates[1];

        //Capturing the date array
        String[] date = DateUtils.returnNextMonth();

        //Select the start date month in the next month
        ActOn.element(driver,StartMonthDropDown).selectvalue(date[0]);

        //Enter the Year
        ActOn.element(driver,StartYearInputField).setvalue(date[1]);

        //Enter the Property tax "5000"
        ActOn.element(driver,PropertyTaxInputField).setvalue("5000");
        //Enter the pmi "0.5"
        ActOn.element(driver,PmiInputField).setvalue("0.5");

        //Enter the home ins "1000"
        ActOn.element(driver,HomeInsInputField).setvalue("1000");
        //Enter the monthly hoa "100"
        ActOn.element(driver,MonthlyhoaInputField).setvalue("100");
        //Enter the Loan Type "FHA"
        ActOn.element(driver,LoanTypeDropDown).selectvalue("FHA");

        ActOn.element(driver,BuyOrRefDropDown).selectvalue("Buy");
    }
    @Test
    public void validateTitle(){

        String actualTitle = ActOn.browser(driver).getTitle();
       // System.out.println(driver.getTitle());
        String expectedTitle = "Mortgage Calculator";

        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @Test
    public void calculateMonthlyPayment(){

        //Entering data into the desired field
        enterData();

        //Click on Calculate Button
        ActOn.element(driver,CalculateButton).click();

        String expectedTotalMonthlyPayment = "1,611.85";
        String formattedXpath = String.format("//h3[text()='$%s']",expectedTotalMonthlyPayment);

        //Validating the total payment is generated as per the calculation
        AssertThat.elementAssertions(driver,By.xpath(formattedXpath)).elementIsDisplayed();
    }

    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {
        if(ITestResult.FAILURE== result.getStatus()){
            ScreenCapture.getScreenShot(driver);
        }
        // driver.quit();
       ActOn.browser(driver).closeBrowser();
    }
}
