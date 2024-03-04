package lk.unibanking.pageobject;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    WebDriver driver;

    @Getter
    @FindBy(name = "uid")
    @CacheLookup
    WebElement txtUserName;


    @Getter
    @FindBy(name = "password")
    @CacheLookup
    WebElement txtPassword;

    @Getter
    @FindBy(name = "btnLogin")
    @CacheLookup
    WebElement btnLogin;

    @Getter
    @FindBy(name = "btnReset")
    WebElement btnReset;

    @FindBy(xpath = "//a[contains(text(),\"Log out\")]")
    @CacheLookup
    WebElement btnLogOut;


    @Getter
    @FindBy(xpath = "//h2[contains(text(),'Guru99 Bank')]")
    WebElement heading;

    @Getter
    @FindBy(xpath = "//td[contains(text(),'UserID')]")
    WebElement userIdLabel;

    @Getter
    @FindBy(xpath = "//td[contains(text(),'Password')]")
    WebElement passwordLabel;




    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void setTextUserName(String username) {
        txtUserName.sendKeys(username);
    }

    public void setTxtPassword(String password) {
        txtPassword.sendKeys(password);
    }

    public void loginBtnClick() {
        btnLogin.click();
    }

    public void btnLogoutClick() {
        btnLogOut.click();
    }


}
