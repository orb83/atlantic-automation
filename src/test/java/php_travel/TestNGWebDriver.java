package php_travel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.utilities.ScreenCapture;

import java.io.IOException;

public class TestNGWebDriver {

    WebDriver driver;

    @BeforeMethod
    public void browserInitialization(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo/");
        driver.manage().window().maximize();
    }
    @Test
    public void verifyhomepagetitle() throws IOException {

        String exceptedtitle = "Demo Script Test drive - PHPTRAVELS";
        String actualtitle = driver.getTitle();
        System.out.println("Actual Title is : " + actualtitle);

        Assert.assertEquals(actualtitle, exceptedtitle);


    }
    @AfterMethod
    public void closeBrowser(ITestResult result){
        if (ITestResult.FAILURE==result.getStatus()){
            try {
                ScreenCapture.getScreenShot(driver);
            }catch (Exception e){
                System.out.println("Exception while taking screenshot " + e.getMessage());
            }
        }
        //driver.quit();
    }
}

