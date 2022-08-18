package mortgage_calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

public class CalculateRealAprRate {

    WebDriver driver;
   private final By RatesLink = By.linkText("Rates");
   private final By RealAPRLink = By.linkText("Real APR");
   private final By CalculatorTab = By.xpath("//label[text()='Calculator']");
   private final By HomePriceInputField = By.name("HomeValue");
   private final By DownPaymentInputField = By.name("DownPayment");
   private final By DownPaymentDollarButton = By.id("DownPaymentSel0");
   private final By InterestRateInputField = By.xpath("//*[@id=\"content1\"]/table[1]/tbody/tr[3]/td[2]/input");
   private final By CalculateButton = By.name("calculate");
   private final By ActualAPR = By.xpath("//*[@id='analysisDiv']/table[1]/tbody/tr[6]/td[2]/strong");


    @BeforeMethod
    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
        System.out.println("The title of the Webpage : "+driver.getTitle());
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    public void navigateToRealAprPage(){

        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(RatesLink)).perform();

        driver.findElement( RealAPRLink).click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOfElementLocated(CalculatorTab));
    }

    public void enterData(){

        driver.findElement(HomePriceInputField).clear();
        driver.findElement(HomePriceInputField).sendKeys("200000");

        driver.findElement(DownPaymentInputField).clear();
        driver.findElement(DownPaymentInputField).sendKeys("15000");

        driver.findElement(DownPaymentDollarButton).click();

        driver.findElement(InterestRateInputField).clear();
        driver.findElement(InterestRateInputField).sendKeys("3");

    }

    @Test
    public void calculaterealApr(){

        navigateToRealAprPage();
        enterData();

        driver.findElement(CalculateButton).click();


       // String actualRealAprRate = driver.findElement(By.xpath("//*[@id='analysisDiv']/table[1]/tbody/tr[6]/td[2]/strong")).getText();
        String actualRealAprRate = driver.findElement(ActualAPR).getText();
        Assert.assertEquals(actualRealAprRate,"3.130%");

    }

    @AfterMethod
    public void closeBrowser(){
       // driver.quit();
    }
}
