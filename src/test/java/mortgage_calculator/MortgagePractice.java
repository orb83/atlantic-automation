package mortgage_calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class MortgagePractice {

    private final By homevalueInputField = By.id("homeval");
    private final By downpaymentInputField = By.id("downpayment");
    private final By downpaymentType = By.name("param[downpayment_type]");
    private final By loanamountInputField = By.id("loanamt");
    private final By interestRateInputField = By.id("intrstsrate");
    private final By loantermInputField = By.id("loanterm");
    private final By monthSelectField = By.name("param[start_month]");
    private final By yearInputField = By.id("start_year");
    private final By propertyTaxField = By.xpath("//input[@id=\"pptytax\"]");
    private final By pmiInputField = By.id("pmi");
    private final By hoiInputField = By.id("hoi");
    private final By hoaInputField = By.id("hoa");
    private final By loantypeSelectField = By.name("param[milserve]");
    private final By buySelectOption= By.name("param[refiorbuy]");
    private final By calculatebutton = By.name("cal");

    WebDriver driver;
    Select select;
    @BeforeMethod
    public void browserOpen(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
        System.out.println("Title of the Webpage : "+driver.getTitle());
    }

    public void dataInput(){

        driver.findElement(homevalueInputField).clear();
        driver.findElement(homevalueInputField).sendKeys("300000");

        driver.findElement(downpaymentInputField).clear();
        driver.findElement(downpaymentInputField).sendKeys("60000");

        driver.findElement(downpaymentType).click();

        driver.findElement(loanamountInputField).clear();
        driver.findElement(loanamountInputField).sendKeys("240000");

        driver.findElement(interestRateInputField).clear();
        driver.findElement(interestRateInputField).sendKeys("3");

        driver.findElement(loantermInputField).clear();
        driver.findElement(loantermInputField).sendKeys("30");

        select = new Select(driver.findElement(monthSelectField));
        select.selectByVisibleText("Aug");

        driver.findElement(yearInputField).clear();
        driver.findElement(yearInputField).sendKeys("2022");

        driver.findElement(propertyTaxField).clear();
        driver.findElement(propertyTaxField).sendKeys("5000");

        driver.findElement(pmiInputField).clear();
        driver.findElement(pmiInputField).sendKeys("0.5");

        driver.findElement(hoiInputField).clear();
        driver.findElement(hoiInputField).sendKeys("1000");

        driver.findElement( hoaInputField).clear();
        driver.findElement( hoaInputField).sendKeys("100");

        select = new Select(driver.findElement(loantypeSelectField));
        select.selectByVisibleText("FHA");

        select = new Select(driver.findElement(buySelectOption));
        select.selectByVisibleText("Buy");
}
    @Test
    public void printmethod(){

        dataInput();

        driver.findElement(calculatebutton).click();

        String expectedTotalMonthlyPayment = "1,611.85";
        String formattedXpath = String.format("//h3[text()='$%s']",expectedTotalMonthlyPayment);

        boolean present = driver.findElement(By.xpath(formattedXpath)).isDisplayed();

        Assert.assertTrue(present,"Total monthly payment is not presented ");
    }

    @AfterMethod
    public void closeBrowser(){
       // driver.quit();
    }
}
