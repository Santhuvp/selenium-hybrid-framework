package listeners;

import base.Base_Class;
import org.testng.ITestListener;
import org.testng.ITestResult;

/**
 * TestNG Listener that captures a screenshot automatically on test failure.
 * Register this in testng.xml under <listeners>.
 */
public class Listner implements ITestListener {

    /**
     * Called by TestNG when a test method fails.
     * Captures a screenshot using the current thread's WebDriver.
     */
    @Override
    public void onTestFailure(ITestResult result) {
        try {
            String screenshotPath = Generic_ScreenShot.captureScreenshot(
                    Base_Class.driver.get(),   // ThreadLocal — must call .get()
                    result.getName()
            );
            System.out.println("Screenshot saved for failed test [" + result.getName() + "]: " + screenshotPath);
        } catch (Exception e) {
            System.err.println("Failed to capture screenshot for test: " + result.getName());
            e.printStackTrace();
        }
    }
}
