package PracticeAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import page_objects.utilities.ScreenCapture;

import java.io.IOException;

public class TestLogin {

    @Test
    public void logintestcase() throws IOException {

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://practicetestautomation.com/practice-test-login/");

        driver.manage().window().maximize();

       // Dimension size = driver.findElement(By.id("main-container")).getSize();
        int size = driver.findElements(By.tagName("a")).size(); // count all link element in the page
        System.out.println("Total number of element in this page : " +size);

        driver.findElement(By.id("username")).sendKeys("student");
        driver.findElement(By.id("password")).sendKeys("Password123");

        driver.findElement(By.id("submit")).click();

        String expectedUrl = driver.getCurrentUrl();

        System.out.println( "The current URL is : "+expectedUrl);
        System.out.println("Title of the current URL : "+driver.getTitle());

        String acturalUrl = "https://practicetestautomation.com/logged-in-successfully/";

        Assert.assertEquals(acturalUrl,expectedUrl);

        ScreenCapture.getScreenShot(driver);

    }
}
