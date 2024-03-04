package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import static org.testng.Assert.*;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;


public class TC_Login_001 extends BaseClass{






    @Test
    public void loginTest()  {
        SoftAssert softAssert = new SoftAssert();

        LoginPage loginPage= new LoginPage(driver);
        logger.info("Enter User Name");
        loginPage.setTextUserName(userName);
        logger.info("Enter Password");
        loginPage.setTxtPassword(password);
        loginPage.loginBtnClick();

        if(driver.getTitle().equals("Guru99 Bank Manager HomePage")){
            assertTrue(true);
            logger.info("Login test Passed");
        }else {
            captureScreenShot(driver,"loginTest");
           assertTrue(false);
            logger.error("Login Test Failed");
        }

    }
}
