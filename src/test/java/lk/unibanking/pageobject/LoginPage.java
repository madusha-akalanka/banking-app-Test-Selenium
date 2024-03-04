package lk.unibanking.pageobject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @FindBy(name = "uid")
    @CacheLookup
     WebElement txtUserName;

    @FindBy(name = "password")
    @CacheLookup
     WebElement txtPassword;

    @FindBy(name = "btnLogin")
    @CacheLookup
     WebElement btnLogin;
    @FindBy(xpath = "//a[contains(text(),\"Log out\")]")
     WebElement btnLogOut;

    public LoginPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    public void setTextUserName(String username){
        txtUserName.sendKeys(username);
    }

    public void setTxtPassword(String password){
        txtPassword.sendKeys(password);
    }

    public void loginBtnClick(){
        btnLogin.click();
    }

    public void btnLogoutClick(){
        btnLogOut.click();
    }
}
