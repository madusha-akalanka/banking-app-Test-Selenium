package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import lk.unibanking.utilities.XLUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

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
            captureScreenShot(driver, "userIdLabelTest");
        }
    }


}
