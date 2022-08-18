package automation_test.parallelTesting;

import command_providers_ModularFrmWrk.ActOn;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.ThreadContext;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import page_objects.utilities.DriverFactory;
import page_objects.utilities.ReadConfigFiles;
import page_objects.utilities.ScreenCapture;

import java.io.IOException;

public class BaseUIClass {
    public WebDriver  driver;

    public Logger LOGGER = LogManager.getLogger(this.getClass().getName());
    String testCaseName = String.format("----Test: %s------",this.getClass().getName());
    String endtestCase = String.format("----Test End: %s------",this.getClass().getName());

    @BeforeClass
    public void  addThread(){
        ThreadContext.put("threadName",this.getClass().getName());
        driver = DriverFactory.getInstance().getDriver();
    }

    @BeforeMethod
    public void BrowserInitialization(){
        String browserUrl = ReadConfigFiles.getPropertyValues("Url");
        ActOn.browser(driver).openBrowser(browserUrl);
        LOGGER.info(testCaseName);
        LOGGER.debug("Opening the URL: " +browserUrl);
        ActOn.browser(driver).openBrowser(browserUrl);
    }
    @AfterMethod
    public void closeBrowser(ITestResult result) throws IOException {
        if (ITestResult.FAILURE==result.getStatus()){
            ScreenCapture.getScreenShot(driver);
        }
        DriverFactory.getInstance().removeDriver();
        LOGGER.info(endtestCase);
    }
}
