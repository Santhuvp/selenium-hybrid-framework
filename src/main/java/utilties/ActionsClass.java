package utilties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ActionsClass {
    public static Actions actionsObject(WebDriver driver)
    {
        Actions actions = new Actions(driver);
        return actions;
    }

    public static void doubleClick(WebDriver driver , WebElement element)
    {
        actionsObject(driver).doubleClick(element).perform();
    }

    public  static void rightClick(WebDriver driver , WebElement element)
    {
        actionsObject(driver).contextClick(element).perform();
    }

    public static void mouseHover(WebDriver driver , WebElement element)
    {
        actionsObject(driver).moveToElement(element).perform();
    }
}
