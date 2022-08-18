package automation_test.mortgage_calculator;

import command_providers_ModularFrmWrk.ActOn;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.utilities.ScreenCapture;

import java.io.IOException;

public class CalculateApr_MdlrFrwk {

    WebDriver driver;
    private final By RatesLink = By.linkText("Rates");
    private final By RealAPRLink = By.linkText("Real APR");
    private final By RealAprHeader = By.xpath("//*[id='calcForm']/h1[text()='What is the Real APR?']");
    private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
    private final By HomeValueInputField = By.name("HomeValue");
    private final By DownPaymentInputField = By.name("DownPayment");
    private final By DownPaymentDollarButton = By.id("DownPaymentSel0");
    private final By InterestRateInputField = By.xpath("//*[@id=\"content1\"]/table[1]/tbody/tr[3]/td[2]/input");
    private final By CalculateButton = By.name("calculate");
    private final By ActualAprRate = By.xpath("//*[@id='analysisDiv']/table[1]/tbody/tr[6]/td[2]/strong");

    @BeforeMethod
    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        ActOn.browser(driver).openBrowser("https://www.mortgagecalculator.org/");
    }
    public void navigateToRealAprPage(){
        // mouse hover to the Rates Link
        ActOn.element(driver,RatesLink).mouseHover();
        //click on Real APR Link
        ActOn.element(driver, RealAPRLink).click();
        ActOn.wait(driver,CalculatorTab).waitForElementToBeVisible();
    }
    public void enterData(){

        //Enter Home value "200000"
        ActOn.element(driver,HomeValueInputField).setvalue("200000");

        //Click on the $ down payment
        ActOn.element(driver,DownPaymentDollarButton).click();

        //Enter the down payment "15000"
        ActOn.element(driver,DownPaymentInputField).setvalue("15000");

        //Enter the Interest rate ""3%0
        ActOn.element(driver,InterestRateInputField).setvalue("3");
    }
    @Test
    public void calculateRealAPR(){

        navigateToRealAprPage();
        enterData();

        //Click on the Calculate Button
        ActOn.element(driver,CalculateButton).click();

        //Validate the real Apr is "3.130%"
        String actualRealAprRate = ActOn.element(driver,ActualAprRate).getTextValue();
        Assert.assertEquals(actualRealAprRate,"3.130%");
    }
    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {
        if (ITestResult.FAILURE==result.getStatus()){
            ScreenCapture.getScreenShot(driver);
    }
        ActOn.browser(driver).closeBrowser();
    }
}
