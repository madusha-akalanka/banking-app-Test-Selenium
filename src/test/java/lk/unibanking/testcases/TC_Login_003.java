package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login_003 extends BaseClass {

    @Test
    void passwordLabelTest() {

        LoginPage loginPage = new LoginPage(driver);
        if (loginPage.getPasswordLabel().isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Password Label is Available");
        } else {
            Assert.assertTrue(false);
            logger.warn("Password Label is not Available");
            captureScreenShot(driver, "passwordLabelTest");
        }
    }


}
