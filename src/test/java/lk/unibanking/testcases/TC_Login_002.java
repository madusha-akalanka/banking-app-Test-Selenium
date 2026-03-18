package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login_002 extends BaseClass {

    @Test
    void userIdLabelTest() {

        LoginPage loginPage = new LoginPage(driver);
        if (loginPage.getUserIdLabel().isDisplayed()) {
            Assert.assertTrue(true);
            logger.info("UserId Label is Available");
        } else {
            Assert.assertTrue(false);
            logger.warn("UserId Label is not Available");
            captureScreenShot("userIdLabelTest");
        }
    }


}
