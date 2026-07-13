package testscripts;

import base.BaseTest;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * LoginTest — Test class for verifying login functionality on
 * https://demowebshop.tricentis.com/
 *
 * @BeforeMethod (inherited from Base_Class) automatically logs in before each test.
 * @AfterMethod  (inherited from Base_Class) automatically logs out after each test.
 */
public class LoginTest extends BaseTest {

    /**
     * TC_01 — Verify that a valid login results in the "Log out" link being present,
     * confirming the user is authenticated.
     */
    @Test
    public void verifySuccessfulLogin() {
        ExtentTest extentTest = extent.createTest("TC_01 - Verify Successful Login");
        test.set(extentTest);

        String pageSource = getdriver().getPageSource();
        boolean isLoggedIn = pageSource.contains("Log out");

        if (isLoggedIn) {
            extentTest.pass("User logged in successfully — 'Log out' link found on page.");
        } else {
            extentTest.fail("Login failed — 'Log out' link NOT found on page.");
        }

        Assert.assertTrue(isLoggedIn, "Expected user to be logged in (Log out link should be visible).");
    }

    /**
     * TC_02 — Verify the page title contains 'Demo Web Shop' after login.
     */
    @Test
    public void verifyPageTitleAfterLogin() {
        ExtentTest extentTest = extent.createTest("TC_02 - Verify Page Title After Login");
        test.set(extentTest);

        String title = getdriver().getTitle();
        extentTest.pass("Page title after login: " + title);

        Assert.assertTrue(
                title.contains("Demo Web Shop"),
                "Expected page title to contain 'Demo Web Shop' but was: " + title
        );
    }

    /**
     * TC_03 — Verify the URL remains on the demowebshop domain after login.
     */
    @Test
    public void verifyUrlAfterLogin() {
        ExtentTest extentTest = extent.createTest("TC_03 - Verify URL After Login");
        test.set(extentTest);

        String currentUrl = getdriver().getCurrentUrl();
        extentTest.pass("Current URL after login: " + currentUrl);

        Assert.assertTrue(
                currentUrl.contains("demowebshop.tricentis.com"),
                "Expected URL to contain 'demowebshop.tricentis.com' but was: " + currentUrl
        );
    }
}
