package pomrepo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(linkText = "Log in")
    private WebElement loginLink;

    @FindBy(id = "Email")
    private WebElement emailField;

    @FindBy(id = "Password")
    private WebElement passworField;

    @FindBy(xpath = "//input[@value='Log in']")
    private WebElement login_btn;

    @FindBy(xpath = "//a[text()='Log out']")
    private WebElement logout;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

    public WebElement getEmailField() {
        return emailField;
    }


    public WebElement getPassworField() {
        return passworField;
    }

    public WebElement getLogin_btn() {
        return login_btn;
    }

    public WebElement getLogout() {
        return logout;
    }

}
