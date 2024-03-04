package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login_007 extends BaseClass {

    @Test
    void resetButtonAvailableTest() {

        LoginPage loginPage = new LoginPage(driver);
        if (loginPage.getBtnReset().isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Reset Button is Available");
        } else {
            Assert.assertTrue(false);
            logger.warn("Reset Button is not Available");
            captureScreenShot(driver, "resetButtonAvailableTest");
        }
    }


}
