package page_objects.utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenCapture {

    public static void getScreenShot(WebDriver driver) throws IOException {

        String fileName = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss").format(new Date());

        File screenshotFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshotFile,new File("screenshot/" + fileName + ".png"));

//        TakesScreenshot ts = (TakesScreenshot)driver;
//        File sourcefile = ts.getScreenshotAs(OutputType.FILE);
//        File targetfile = new File(".\\screenshot\\filename.png");
//        FileUtils.copyFile(sourcefile,targetfile);
    }
}
