package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ApparalandShoes {


    @FindBy(xpath = "//ul[@class='top-menu']/li[4]/a")
    private WebElement appshoe;




    @FindBy(linkText = "50's Rockabilly Polka Dot Top JR Plus Size")
    private WebElement productlink;

   @FindBy(id = "add-to-cart-button-5")
    private WebElement addToCart;

public ApparalandShoes(WebDriver driver)
{
    PageFactory.initElements(driver,this);
}


    public WebElement getAppshoe() {
        return appshoe;
    }

    public WebElement getProductlink() {
        return productlink;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

}
