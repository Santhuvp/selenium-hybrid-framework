package utilties;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SelectClass {
    public static Select dropdownObject(WebElement element)
    {
        Select sel = new Select(element);
        return sel;
    }

    public static void selectOption(WebElement element,Object value)
    {
        Select select = dropdownObject(element);
        if(value instanceof Integer)
        {
            select.selectByIndex((Integer) value);
        } else if (value instanceof String) {
            try{
                select.selectByValue((String) value);
            }
            catch (Exception e)
            {
                select.selectByVisibleText((String) value);
            }

        }
    }
}
