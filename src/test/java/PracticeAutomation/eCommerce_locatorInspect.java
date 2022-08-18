package PracticeAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.utilities.ScreenCapture;

import java.io.IOException;

public class eCommerce_locatorInspect {
    WebDriver driver;
    Select select;
    @BeforeMethod
    public void openbrowser(){

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/selenium-practice-form.html");
        driver.manage().window().maximize();

    }
    public void inputdata() {

        driver.findElement(By.name("firstname")).sendKeys("David");
        driver.findElement(By.name("lastname")).sendKeys("Alaba");
        driver.findElement(By.id("sex-0")).click();
        driver.findElement(By.id("exp-4")).click();
        driver.findElement(By.id("datepicker")).sendKeys("7/29/2022");
        driver.findElement(By.id("profession-1")).click();
        driver.findElement(By.id("tool-2")).click();

        select = new Select(driver.findElement(By.id("continents")));
        select.selectByVisibleText("North America");

        select = new Select(driver.findElement(By.id("selenium_commands")));
        select.selectByVisibleText("WebElement Commands");
    }
    @Test
    public void verifyOpenNewTab() throws IOException {

        inputdata();

        String newtab = Keys.chord(Keys.CONTROL , Keys.ENTER);

      //  driver.findElement(By.xpath("//*[@id=\"post-body-3077692503353518311\"]/div[1]/div/div/h2[2]/div[1]/div/div[28]/div[2]/div/a")).sendKeys(newtab);
        driver.findElement(By.linkText("Click here to Download File")).sendKeys(newtab);
        ScreenCapture.getScreenShot(driver);

//        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
//        driver.switchTo().window(tabs.get(1));
//        System.out.println("The current URL is : "+driver.getCurrentUrl());

//        String expectedurl = driver.getCurrentUrl();
//
//        String actualurl = "https://github.com/stanfy/behave-rest/blob/master/features/conf.yaml";
//
//        Assert.assertEquals(actualurl,expectedurl);
    }
    @AfterMethod
    public void closebrowser(){
       // driver.quit();
    }
}
