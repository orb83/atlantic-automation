package mortgage_calculator;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class CalculateMortgageRate {
    WebDriver driver;
    Select select;
@BeforeMethod
    public void openBrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();
        System.out.println("Title of the webpage : "+driver.getTitle());
    }

    private void enterData(){
        driver.findElement(By.id("homeval")).clear();
        driver.findElement(By.id("homeval")).sendKeys("300000");

        driver.findElement(By.id("downpayment")).clear();
        driver.findElement(By.id("downpayment")).sendKeys("60000");

        driver.findElement(By.name("param[downpayment_type]")).click();

        driver.findElement(By.id("loanamt")).clear();
        driver.findElement(By.id("loanamt")).sendKeys("240000");

        driver.findElement(By.id("intrstsrate")).clear();
        driver.findElement(By.id("intrstsrate")).sendKeys("3");

        driver.findElement(By.id("loanterm")).clear();
        driver.findElement(By.id("loanterm")).sendKeys("30");

       // WebElement selectmonth = driver.findElement(By.name("param[start_month]"));
       select = new Select(driver.findElement(By.name("param[start_month]")));
        select.selectByVisibleText("Aug");

        driver.findElement(By.id("start_year")).clear();
        driver.findElement(By.id("start_year")).sendKeys("2022");

       WebElement wb =  driver.findElement(By.xpath("//input[@id=\"pptytax\"]"));
       // driver.findElement(By.id("pptytax")).sendKeys("5000");
        wb.clear();
        wb.sendKeys("5000");

        driver.findElement(By.id("pmi")).clear();
        driver.findElement(By.id("pmi")).sendKeys("0.5");

        driver.findElement(By.id("hoi")).clear();
        driver.findElement(By.id("hoi")).sendKeys("1000");

        WebElement hoa = driver.findElement(By.id("hoa"));
        //driver.findElement(By.id("hoa")).sendKeys("100");
        hoa.clear();
        hoa.sendKeys("100");

      //  WebElement loantype = driver.findElement(By.name("param[milserve]"));
        select = new Select(driver.findElement(By.name("param[milserve]")));
        select.selectByVisibleText("FHA");

        select = new Select(driver.findElement(By.name("param[refiorbuy]")));
        select.selectByVisibleText("Buy");
    }

    @Test
    public void calculateMonthlyPayment(){

       enterData();

        driver.findElement(By.name("cal")).click();

       String expectedTotalMonthlyPayment = "1,611.85";
             // Using Xpath with text() :: //tagneme[text()='text value']
        String formattedXpath = String.format("//h3[text()='$%s']",expectedTotalMonthlyPayment);

       boolean present = driver.findElement(By.xpath(formattedXpath)).isDisplayed();

        Assert.assertTrue(present,"Total monthly payment is not presented ");
    }

    @AfterMethod
    public void closeBrowser(){

       // driver.quit();
    }
}
