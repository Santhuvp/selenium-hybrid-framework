package testscripts;

import base.BaseTest;
import base.Base_Class;
import org.testng.annotations.Test;
import pomrepo.ApparalandShoes;
import pomrepo.CheckoutPOM;

public class Buy_Apparel extends Base_Class {

    @Test
    public void buy_Apparal()
    {
        extent.createTest("Buy Apparel").assignAuthor("Santhosh");
        ApparalandShoes ap = new ApparalandShoes(getdriver());
        clickElement(ap.getAppshoe());
        clickElement(ap.getProductlink());
        clickElement(ap.getAddToCart());
        CheckoutPOM checkoutPOM = new CheckoutPOM(getdriver());
        clickElement(checkoutPOM.getCartLink());
        clickElement(checkoutPOM.getTermsCheckbox());
        clickElement(checkoutPOM.getCheckoutButton());
        clickElement(checkoutPOM.getConfirmShipmentAddressContinueButton());
        clickElement(checkoutPOM.getShippingAddressContinueButton());
        clickElement(checkoutPOM.getShippingMethodContinueButton());
        clickElement(checkoutPOM.getPaymentMethodContinue());
        clickElement(checkoutPOM.getPaymentInformationConfirmationContinue());
        clickElement(checkoutPOM.getCheckoutionConfirmationContinue());
        System.out.println("The Order ID is "+checkoutPOM.getOrderID().getText());
    }

}

