package testscripts;

import base.Base_Class;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import pomrepo.Electroincs;
import pomrepo.CheckoutPOM;

public class Buy_Electronics extends Base_Class {


    @Test
            public  void buyElectronics()
    {
        Electroincs ec = new Electroincs(getdriver());
        extent.createTest("Electronics").assignAuthor("Santhosh");

        clickElement(ec.getElectronicsLink());
        clickElement(ec.getCellPhoneProducts());
        clickElement(ec.getSmartPhone());
        clickElement(ec.getAddToCart());
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
