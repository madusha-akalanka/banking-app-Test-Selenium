package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login_005 extends BaseClass {

    @Test
    void passwordFieldChecking() {

        LoginPage loginPage = new LoginPage(driver);
        if (loginPage.getTxtPassword().isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Password text-field is Available");
        } else {
            Assert.assertTrue(false);
            logger.warn("Password text-field is not Available");
            captureScreenShot(driver, "passwordFieldChecking");
        }
    }


}
