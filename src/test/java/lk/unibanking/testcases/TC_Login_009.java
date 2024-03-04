package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TC_Login_009 extends BaseClass {

    //Login with invalid username and Valid Password Data

    @Test
    void testInValidData() {

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setTextUserName("aaa");
        loginPage.setTxtPassword(password);
        loginPage.loginBtnClick();

        if(isAlertPresent()){
            Alert alert = driver.switchTo().alert();
            String alertText=alert.getText();
            if (alertText.equals("User is not valid")) {
                Assert.assertTrue(true);
            } else {
                Assert.assertTrue(false);
            }
            alert.accept();
        }


        if (driver.getTitle().equals("Guru99 Bank Manager HomePage")) {
            Assert.assertTrue(false);
            logger.info("Successfully Login");
        } else {
            Assert.assertTrue(true);
            logger.info("Login Failed");
        }

    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }

    }

}
