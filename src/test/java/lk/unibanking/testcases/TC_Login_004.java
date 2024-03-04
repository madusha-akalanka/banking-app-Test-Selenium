package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login_004 extends BaseClass {

    @Test
    void textFieldChecking() {

        LoginPage loginPage = new LoginPage(driver);
        if (loginPage.getTxtUserName().isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Username text-field is Available");
        } else {
            Assert.assertTrue(false);
            logger.warn("Username text-field is not Available");
            captureScreenShot(driver, "textFieldChecking");
        }
    }


}
