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
