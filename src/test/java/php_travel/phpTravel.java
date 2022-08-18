package php_travel;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class phpTravel {
    WebDriver driver;

    @BeforeMethod
    public void openBrowser(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://phptravels.com/demo/");
        driver.manage().window().maximize();
        System.out.println("The title of this Webpage : " +driver.getTitle());
    }
    @Test
    public void vrifyHomePageTitle(){
        String actualTitle = driver.getTitle();
        String expectedTitle = "Demo Script Test drive - PHPTRAVELS";

        Assert.assertEquals(actualTitle,expectedTitle);
    }
    @AfterMethod
    public void closeBrowser(){
        driver.quit();
    }
}
