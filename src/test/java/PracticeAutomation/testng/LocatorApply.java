package PracticeAutomation.testng;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class LocatorApply {
    @Test
    public void uselocators(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.mortgagecalculator.org/");
        driver.manage().window().maximize();

//        // using locator id
//        driver.findElement(By.id("homeval")).clear(); // clear input field
//        driver.findElement(By.id("homeval")).sendKeys("300000");
//
//        //using locator name
//        driver.findElement(By.name("param[downpayment]")).clear();
//        driver.findElement(By.name("param[downpayment]")).sendKeys("70000");
//
//        //using linkText
//        driver.findElement(By.linkText("Mortgage Calcs")).click();
//       // driver.findElement(By.linkText("15 yr Fixed")).click();
//
//        //using PartialLinkText
//        driver.findElement(By.partialLinkText("Mortgage")).click();

          //using css for id (tagname#id value)
//        driver.findElement(By.cssSelector("input#homeval")).clear();
//        driver.findElement(By.ssSelector("input#homeval")).sendKeys("500000");
         //using css for class
//        driver.findElement(By.cssSelector("input.right-cell")).clear();
//        driver.findElement(By.cssSelector("input.right-cell")).sendKeys("600000");
         //using css for other attributes
//         WebElement homevlue =driver.findElement(By.cssSelector("label[for='homeval']"));
//         String hv = homevlue.getText();
//         System.out.println(hv);
//        //using css for multiple attributes
//        WebElement homevlue1 =driver.findElement(By.cssSelector("label.left-cell[for='homeval']"));
//        String hv1 = homevlue.getText();
//        System.out.println(hv1);
        driver.findElement(By.xpath("//input[@id=\'loanterm\']")).clear();
        driver.findElement(By.xpath("//input[@id=\'loanterm\']")).sendKeys("40");

    }

}
