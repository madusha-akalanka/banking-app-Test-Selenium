package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;

import org.testng.Assert;
import org.testng.annotations.Test;


public class TC_Login_001 extends BaseClass{


    @Test
    public void headerTest()  {

        LoginPage loginPage = new LoginPage(driver);
        if(loginPage.getHeading().isDisplayed()){
            Assert.assertTrue(true);
            logger.info("Heading  is Available");
        }else{
            Assert.assertTrue(false);
            logger.warn("Heading  is not Available");
            captureScreenShot("headerTest");
        }
    }
}
