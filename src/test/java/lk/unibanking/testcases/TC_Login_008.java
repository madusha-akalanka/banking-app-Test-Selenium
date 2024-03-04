package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import lk.unibanking.utilities.XLUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;

public class TC_Login_008 extends BaseClass {

    //Login with Valid Data-Positive Test Case

    @Test
    void testValidData() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setTextUserName(userName);
        loginPage.setTxtPassword(password);
        loginPage.loginBtnClick();

        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(true);
            logger.info("Successfully Login");
        } else {
            Assert.assertTrue(false);
            logger.info("Login Failed");
        }

    }

}
