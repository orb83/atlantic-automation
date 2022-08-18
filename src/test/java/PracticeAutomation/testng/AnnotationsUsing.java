package PracticeAutomation.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AnnotationsUsing {

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo");
        System.out.println("Title of the page : "+driver.getTitle());
    }
    @Test
    public void validatehomepagetitle(){

        String actualtitle = driver.getTitle();
        String exceptedtitle = "Demo Script Test drive - PHPTRAVELS";
        Assert.assertEquals(actualtitle,exceptedtitle);
    }
    @AfterMethod
    public void closebrowser(){
        driver.quit();
    }




}
