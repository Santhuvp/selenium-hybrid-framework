package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public  class CheckoutPOM {
    @FindBy(xpath = "//span[text()='Shopping cart']")
    private WebElement cartLink;

    @FindBy(id = "termsofservice")
    private WebElement termsCheckbox;

    @FindBy(id = "checkout")
    private WebElement checkoutButton;

    @FindBy(xpath = "//input[@onclick='Billing.save()']")
    private WebElement confirmShipmentAddressContinueButton;

    @FindBy(xpath = "//input[@onclick='Shipping.save()']")
    private  WebElement shippingAddressContinueButton;

    @FindBy(xpath = "//input[@onclick='ShippingMethod.save()']")
    private  WebElement shippingMethodContinueButton;

    @FindBy(xpath = "//input[@onclick='PaymentMethod.save()']")
    private  WebElement paymentMethodContinue;

    @FindBy(xpath = "//input[@onclick='PaymentInfo.save()']")
    private  WebElement paymentInformationConfirmationContinue;


    @FindBy(xpath = "//input[@onclick='ConfirmOrder.save()']")
    private  WebElement checkoutionConfirmationContinue;

    @FindBy(xpath = "//ul[@class='details']/li")
    private  WebElement orderID;

    public CheckoutPOM(WebDriver driver)
    {
        PageFactory.initElements(driver,this);
    }

    public WebElement getCartLink() {
        return cartLink;
    }

    public WebElement getTermsCheckbox() {
        return termsCheckbox;
    }

    public WebElement getCheckoutButton() {
        return checkoutButton;
    }

    public WebElement getConfirmShipmentAddressContinueButton() {
        return confirmShipmentAddressContinueButton;
    }

    public WebElement getShippingAddressContinueButton() {
        return shippingAddressContinueButton;
    }

    public WebElement getShippingMethodContinueButton() {
        return shippingMethodContinueButton;
    }

    public WebElement getPaymentMethodContinue() {
        return paymentMethodContinue;
    }

    public WebElement getPaymentInformationConfirmationContinue() {
        return paymentInformationConfirmationContinue;
    }

    public WebElement getCheckoutionConfirmationContinue() {
        return checkoutionConfirmationContinue;
    }

    public WebElement getOrderID() {
        return orderID;
    }
}
