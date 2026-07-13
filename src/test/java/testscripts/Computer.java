package testscripts;

import base.Base_Class;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import org.testng.annotations.Test;
import pomrepo.Business_logic;

import static base.Base_Class.driver;

public class Computer extends Base_Class {

    @Test
    public void script() throws InterruptedException {
        Business_logic bl = new Business_logic(getdriver());
        ExtentTest test = extent.createTest("COMPUTERS").assignAuthor("Santhosh");

        clickElement(bl.getcomputes());
        clickElement(bl.getdesktop());
        Thread.sleep(5000);
        clickElement(bl.getowncomp());
        test.log(Status.PASS, "Page is displayed");
        Thread.sleep(2000);
        clickElement(bl.getram());
        test.log(Status.PASS, "Configuration Page is displayed");
        Thread.sleep(2000);
        clickElement(bl.getaddtocartbtn());
        test.log(Status.PASS, "Add to cart button is displayed");
        Thread.sleep(2000);
        clickElement(bl.getshopcart());
        test.log(Status.PASS, "Add to cart button  is displayed");
        Thread.sleep(2000);
        clickElement(bl.getselectproduct());
        Thread.sleep(2000);
        clickElement(bl.gettermsandcon());
        test.log(Status.PASS, "T&C button  is displayed");
        Thread.sleep(2000);
        clickElement(bl.getcheckoutbtn());
    }
}
