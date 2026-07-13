package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Business_logic {

    @FindBy(xpath = "//ul[@class='top-menu']/li[2]/a")
    private WebElement computers;

    @FindBy(xpath = "(//a[@title='Show products in category Desktops'])[1]")
    private WebElement desktop;

    @FindBy(xpath = "//a[text()='Build your own cheap computer']")
    private WebElement own_comp;

    @FindBy(xpath = "//input[@value=91]")
    private WebElement ram;

    @FindBy(xpath = "//input[@id='add-to-cart-button-72']")
    private WebElement addtocart;

    @FindBy(xpath = "//span[text()='Shopping cart']")
    private WebElement shopcart;

    @FindBy(xpath = "//input[@name='removefromcart']")
    private WebElement selectproduct;

    @FindBy(xpath = "//input[@id='termsofservice']")
    private WebElement termcon;

    @FindBy(xpath = "//button[@id='checkout']")
    private WebElement checkout;

    public Business_logic(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public WebElement getcomputes() {
        return computers;
    }

    public WebElement getdesktop() {
        return desktop;
    }

    public WebElement getowncomp() {
        return own_comp;
    }

    public WebElement getram() {
        return ram;
    }

    public WebElement getaddtocartbtn() {
        return addtocart;
    }

    public WebElement getshopcart() {
        return shopcart;
    }

    public WebElement getselectproduct() {
        return selectproduct;
    }

    public WebElement gettermsandcon() {
        return termcon;
    }

    public WebElement getcheckoutbtn() {
        return checkout;
    }

}