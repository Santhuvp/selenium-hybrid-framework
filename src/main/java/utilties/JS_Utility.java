package utilties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JS_Utility {

    public static JavascriptExecutor javascript(WebDriver driver)
    {
        JavascriptExecutor js= (JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebDriver driver , WebElement element)
    {
        javascript(driver).executeScript("arguments[0].click();",element);
    }
    public static void jsCText(WebDriver driver ,String text, WebElement element)
    {
        javascript(driver).executeScript("arguments[0].value= '"+text+"'",element);
    }
    public static void jsScroll(WebDriver driver , WebElement element)
    {
        javascript(driver).executeScript("arguments[0].scrollIntoView();",element);
    }
}
