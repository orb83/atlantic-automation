package Modular_Driven_FrameWork;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

public class ModularDrivenFrwkTest {

    WebDriver driver;

    @BeforeMethod
    public void instantiateDriver(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }
    public void invokeBrowser(){
        driver.get("https://demo.openmrs.org/openmrs/login.htm");
    }
    public void navigateToHomePage(){
        driver.findElement(By.xpath("//body/ul[@id='breadcrumbs']/li[1]/a[1]/i[1]")).click();
    }
    public void enterInputValue(){
        driver.findElement(By.id("username")).sendKeys("Admin");
        driver.findElement(By.id("password")).sendKeys("Admin123");
        driver.findElement(By.id("Inpatient Ward")).click();
        driver.findElement(By.id("loginButton")).click();

    }
    public void navigateToServiceTypeList(){
        driver.findElement(By.id("appointmentschedulingui-homeAppLink-appointmentschedulingui-homeAppLink-extension")).click();
        driver.findElement(By.id("appointmentschedulingui-manageAppointmentTypes-app")).click();
    }
    public boolean verifyServiceType(String serviceType) {
        boolean result = false;
        List<WebElement> pagelist = driver.findElements(By.xpath("//div[@id=\"appointmentTypesTable_paginate\"]/span/a[2]"));
        List<WebElement> serviceTypeList = driver.findElements(By.xpath("//table[@id=\"appointmentTypesTable\"]/tbody/tr[1]/td[1]"));


        for (int i = 0; i < pagelist.size();i++) {
            pagelist = driver.findElements(By.xpath("//div[@id=\"appointmentTypesTable_paginate\"]/span/a[2]"));
            pagelist.get(i).click();
            serviceTypeList = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));

            for (int j = 0; j < serviceTypeList.size(); j++) {
                if (serviceTypeList.get(j).getText().equals("Oncology")) {
                    System.out.println("ServiceType Found : " + serviceTypeList.get(j).getText());
                    result = true;
                    break ;
                }
            }
        }
        return result;
    }
    public boolean deleteServiceType(String serviceType){
            boolean result = false;
        List<WebElement> pagelist = driver.findElements(By.xpath("//div[@id=\"appointmentTypesTable_paginate\"]/span/a[2]"));
        List<WebElement> serviceTypeList = driver.findElements(By.xpath("//table[@id=\"appointmentTypesTable\"]/tbody/tr[1]/td[1]"));


        for (int i = 0; i < pagelist.size(); i++) {
            pagelist = driver.findElements(By.xpath("//div[@id=\"appointmentTypesTable_paginate\"]/span/a[2]"));
            pagelist.get(i).click();
            serviceTypeList = driver.findElements(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr/td[1]"));

            for (int j = 0; j < serviceTypeList.size(); j++) {

                if (serviceTypeList.get(j).getText().equals("serviceType")) {

                    System.out.println("ServiceType Found : " + serviceTypeList.get(j).getText());
                             //click on delete(cross sign) //Xpath=//table/tbody/tr[5]/td[4]/span/i[@id="appointmentschedulingui-delete-Oncology\
                    driver.findElement(By.xpath("//table[@id='appointmentTypesTable']/tbody/tr["+(j+1)+"]/td[text()='"+serviceType+"']/following-sibling::td/span/i[@title='Delete']")).click();
                            //click on yes button
                    driver.findElement(By.xpath("//div[@id=\"simplemodal-container\"]/div/div/div[2]/button[1]")).click();

                    result = true;
                    break;
                }
            }
        }

        return result;
    }

        @Test(priority = 1, description = "Scenario1 verify the service type available in the html table")
        public void verifyServiceTypeFunctions () {
            invokeBrowser();
            enterInputValue();
            navigateToServiceTypeList();
            boolean result = verifyServiceType("Obstetrics");
            Assert.assertTrue(result);
        }
        @Test(priority = 2, description = "Scenario2 delete the service type and verify the deleted service type is not available in the html table")
         public void deleteServiceTypeFunctions(){
            invokeBrowser();
            enterInputValue();
            navigateToServiceTypeList();

            SoftAssert sa = new SoftAssert();
            boolean result = deleteServiceType("Obstetrics");
            sa.assertTrue(result);
            navigateToHomePage();
            navigateToServiceTypeList();
            result = verifyServiceType("Obstetrics");
            sa.assertFalse(result);
           // sa.assertAll();

        }
        @AfterMethod
        public void closeBrowser(){
          //  driver.quit();
        }
}