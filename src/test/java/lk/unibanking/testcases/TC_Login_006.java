package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login_006 extends BaseClass {

    @Test
    void loginButtonAvailableTest() {

        LoginPage loginPage = new LoginPage(driver);
        if (loginPage.getBtnLogin().isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("Login Button is Available");
        } else {
            Assert.assertTrue(false);
            logger.warn("Login Button is not Available");
            captureScreenShot(driver, "loginButtonAvailableTest");
        }
    }


}
