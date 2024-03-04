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


    @Test(dataProvider = "loginData")
    public void loginDDT(String username, String password) {
        LoginPage loginPage = new LoginPage(driver);
        logger.info("User Name is Provided");
        loginPage.setTextUserName(username);
        logger.info("Password is Provided");
        loginPage.setTxtPassword(password);
        loginPage.loginBtnClick();
        if (isAlertPresent() == true) {
            Alert alert = driver.switchTo().alert();
            alert.accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(false);
            logger.warn("Login Failure");
            captureScreenShot(driver,"loginDDT");

        } else {
            Assert.assertTrue(true);
            logger.info("Pass The Test Case");
            loginPage.btnLogoutClick();
            logger.info("Logout the Application");
            driver.switchTo().alert().accept();

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


    @DataProvider(name = "loginData")
    String[][] getData() throws IOException {

        String path = "/home/akalanka/Desktop/selenium IDE/banking-app-test/src/test/java/lk/unibanking/testdata/LoginData.xlsx";


        int rownum = XLUtil.getRowCount(path, "Sheet1");
        int colnum = XLUtil.getCellCount(path, "Sheet1", 1);

        String logindata[][] = new String[rownum][colnum];

        for (int i = 1; i <= rownum; i++) {

            for (int c = 0; c < colnum; c++) {
                logindata[i - 1][c] = XLUtil.getCellData(path, "Sheet1", i, c);
            }
        }
        return logindata;
    }
}
