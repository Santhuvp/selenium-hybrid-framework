package testscripts;

import org.testng.annotations.Test;
import pomrepo.ApparalandShoes;
import pomrepo.CheckoutPOM;

import static base.Base_Class.getdriver;

public class Buy_Apparel {

    @Test
    public void buy_Apparal()
    {
        ApparalandShoes ap = new ApparalandShoes(getdriver());
        ap.getAppshoe().click();
        ap.getProductlink().click();
        ap.getAddToCart().click();
        CheckoutPOM checkoutPOM = new CheckoutPOM(getdriver());
        checkoutPOM.getCartLink().click();
        checkoutPOM.getTermsCheckbox().click();
        checkoutPOM.getCheckoutButton().click();
        checkoutPOM.getConfirmShipmentAddressContinueButton().click();
        checkoutPOM.getShippingAddressContinueButton().click();
        checkoutPOM.getShippingMethodContinueButton().click();
        checkoutPOM.getPaymentMethodContinue().click();
        checkoutPOM.getPaymentInformationConfirmationContinue().click();
        checkoutPOM.getCheckoutionConfirmationContinue().click();
        System.out.println("The Order ID is "+checkoutPOM.getOrderID().getText());
    }

}
