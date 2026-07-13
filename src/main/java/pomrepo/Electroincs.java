package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Electroincs {

    @FindBy(linkText = "Electronics")
    private WebElement electronicsLink;

    @FindBy(xpath = "//img[@title='Show products in category Cell phones']")
    private WebElement cellPhoneProducts;

    @FindBy(xpath = "//img[@title='Show details for Smartphone']")
    private WebElement smartPhone;


    @FindBy(id ="add-to-cart-button-43")
    private WebElement addToCart;


   public Electroincs(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getCellPhoneProducts() {
        return cellPhoneProducts;
    }

    public WebElement getElectronicsLink() {
        return electronicsLink;
    }

    public WebElement getSmartPhone() {
        return smartPhone;
    }

    public WebElement getAddToCart() {
        return addToCart;
    }

//EOC
}
