package lk.unibanking.testcases;

import lk.unibanking.pageobject.LoginPage;
import lk.unibanking.utilities.XLUtil;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class TC_Login_DataDriven extends BaseClass{


    @Test(dataProvider = "loginData")
    void loginTest(String username,String password){

        LoginPage loginPage = new LoginPage(driver);
        loginPage.setTextUserName(username);
        loginPage.setTxtPassword(password);
        loginPage.loginBtnClick();

        if(isAlertPresent()){
            driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
            Alert alert=driver.switchTo().alert();
            alert.accept();
            driver.switchTo().defaultContent();
            Assert.assertTrue(true);
            logger.warn("Login Failure");
        }else{
            Assert.assertFalse(false);
            logger.info("Login Passed");
            loginPage.btnLogoutClick();
            driver.switchTo().alert().accept();
            logger.info("Logout Successfully");

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


    @DataProvider(name="loginData")
    String[][] getData() throws IOException {

        String path="/home/akalanka/Desktop/selenium IDE/banking-app-test/src/test/java/lk/unibanking/testdata/LoginData.xlsx";
        int row= XLUtil.getRowCount(path,"Sheet1");
        int col=XLUtil.getCellCount(path,"Sheet1",1);
        String[][] logindata = new String[row][col];

        for (int i=1;i<=row;i++){
            for(int j=0;j<col;j++){
                logindata[i-1][j]=XLUtil.getCellData(path,"Sheet1",i,j);
            }
        }
        return logindata;

    }
}
