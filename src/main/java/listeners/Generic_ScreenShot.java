package listeners;

import constants.Framework_Constants;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class Generic_ScreenShot {
    public static String captureScreenshot(WebDriver driver, String testName) throws IOException {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File src = ts.getScreenshotAs(OutputType.FILE);
        String path = Framework_Constants.SCREENSHOT_PATH + testName + ".png";
        FileUtils.copyFile(src, new File(path));

        return path;
    }


}
