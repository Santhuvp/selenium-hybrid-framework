package base;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import constants.Framework_Constants;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.*;
import pomrepo.LoginPage;
import utilties.ReadDataFromExcel;
import utilties.ReadDataFromProperty;

import java.io.IOException;
import java.time.Duration;

import java.net.MalformedURLException;
import java.net.URL;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

public class Base_Class {

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    public static ExtentReports extent;
    public static ThreadLocal<ExtentTest> test = new ThreadLocal<>();
    public LoginPage loginPage;

    public static WebDriver getdriver() {
        return driver.get();

    }

    public void clickElement(WebElement element) {
        try {
            new WebDriverWait(getdriver(), Duration.ofSeconds(Framework_Constants.EXPLICIT_WAIT))
                    .until(ExpectedConditions.elementToBeClickable(element));
            element.click();
        } catch (Exception e) {
            utilties.JS_Utility.jsClick(getdriver(), element);
        }
    }



    @BeforeTest
    public static void setupReport() throws IOException {
        ReadDataFromProperty.loadProperty();
        ExtentSparkReporter spark = new ExtentSparkReporter(Framework_Constants.REPORT_PATH);
        extent = new ExtentReports();
        extent.attachReporter(spark);

    }

    @Parameters({ "browser" })
    @BeforeClass
    public static void launchBrowser(@Optional("chrome") String browser) {
        WebDriver localdriver;

        String headlessProp = ReadDataFromProperty.prop.getProperty("headless");
        boolean defaultHeadless = "true".equalsIgnoreCase(headlessProp);

        String systemHeadless = System.getProperty("headless");
        boolean isHeadless = (systemHeadless != null)
                ? "true".equalsIgnoreCase(systemHeadless)
                : (System.getenv("CI") != null || defaultHeadless);

        // NEW: if set, tests run on a remote Selenium (Grid/standalone) instead of locally
        String remoteUrl = System.getProperty("remote.url");
        boolean useRemote = remoteUrl != null && !remoteUrl.trim().isEmpty();

        switch (browser.toLowerCase()) {
            case "firefox":
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                if (isHeadless) {
                    firefoxOptions.addArguments("--headless");
                }
                if (useRemote) {
                    localdriver = createRemoteDriver(remoteUrl, firefoxOptions);
                } else {
                    WebDriverManager.firefoxdriver().setup();
                    localdriver = new FirefoxDriver(firefoxOptions);
                }
                break;

            case "chrome":
                ChromeOptions chromeOptions = new ChromeOptions();
                if (isHeadless) {
                    chromeOptions.addArguments("--headless=new");
                    chromeOptions.addArguments("--no-sandbox");
                    chromeOptions.addArguments("--disable-dev-shm-usage");
                    chromeOptions.addArguments("--window-size=1920,1080");
                }
                if (useRemote) {
                    localdriver = createRemoteDriver(remoteUrl, chromeOptions);
                } else {
                    WebDriverManager.chromedriver().setup();
                    localdriver = new ChromeDriver(chromeOptions);
                }
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + browser.toLowerCase());
        }

        localdriver.manage().window().maximize();
        localdriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Framework_Constants.IMPLICIT_WAIT));
        localdriver.get(ReadDataFromProperty.prop.getProperty("url"));
        driver.set(localdriver);
    }

    // NEW helper (add it in the same class)
    private static WebDriver createRemoteDriver(String remoteUrl, Capabilities options) {
        try {
            return new RemoteWebDriver(new URL(remoteUrl), options);
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Invalid remote.url: " + remoteUrl, e);
        }
    }

    @BeforeMethod
    public void login() throws IOException {
        // Read credentials from Excel (Login sheet, row 0)
        Object[][] loginData = ReadDataFromExcel.getDatafromEcel("Login");
        String email = loginData[0][0].toString();
        String password = loginData[0][1].toString();

        // Navigate directly to the login page for reliability
        getdriver().get(ReadDataFromProperty.prop.getProperty("url") + "login");

        this.loginPage = new LoginPage(getdriver());
        loginPage.getEmailField().sendKeys(email);
        loginPage.getPassworField().sendKeys(password);
        loginPage.getLogin_btn().click();

        // Explicit wait: wait until the 'Log out' link appears, confirming successful
        // login
        new WebDriverWait(getdriver(), Duration.ofSeconds(Framework_Constants.EXPLICIT_WAIT))
                .until(ExpectedConditions.presenceOfElementLocated(
                        org.openqa.selenium.By.linkText("Log out")));
    }

    @AfterMethod
    public void logout() {
        loginPage = new LoginPage(getdriver());
        loginPage.getLogout().click();
    }

    @AfterClass
    public void closeBrowser() {
        getdriver().quit();
        driver.remove();

    }

    @AfterTest
    public void tearDownReport() {
        extent.flush();
    }

}
