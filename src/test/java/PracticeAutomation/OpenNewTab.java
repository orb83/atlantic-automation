package PracticeAutomation;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;

public class OpenNewTab {

    @Test
    public void openNewWindow(){

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.tutorialspoint.com/about/about_careers.htm");

        driver.manage().window().maximize();
        // open new tab
        String clickl = Keys.chord(Keys.CONTROL,Keys.ENTER);
        driver.findElement(By.xpath("//*[@id='tocCollapse']/div/ul[1]/li[7]/a")).sendKeys(clickl);

        // focus on current window/tab (new tab)
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));

        String expectedurl = driver.getCurrentUrl();

        System.out.println("The current URL is : "+expectedurl);

        String actualurl = "https://www.tutorialspoint.com/about/about_terms_of_use.htm";

        Assert.assertEquals(actualurl,expectedurl);
    }
}
