package lk.unibanking.testcases;

import lk.unibanking.utilities.ReadConfig;
import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


import java.io.*;
import java.util.concurrent.TimeUnit;


public class BaseClass {

    public static WebDriver driver;

    public Logger logger;

    ReadConfig readConfig;
    String baseUrl;
    public String userName;
    String password;


    @Parameters("browser")
    @Test
    public void setup(@Optional("chrome") String browser) throws IOException, InterruptedException {


        logger=LogManager.getLogger(BaseClass.class);
        readConfig = new ReadConfig();
        baseUrl = readConfig.getApplicationUrl();
        userName = readConfig.getUserName();
        password = readConfig.getPassword();


        if (browser.equalsIgnoreCase("edge")) {
            driver = new EdgeDriver();

        } else if (browser.equals("chrome")) {
            driver = new ChromeDriver();
        } else if (browser.equals("firefox")) {
            driver = new FirefoxDriver();
        }
        logger.info("Url Is Open");
        driver.manage().timeouts().implicitlyWait(6,TimeUnit.SECONDS);
        driver.get(baseUrl);

    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }

    public void captureScreenShot(WebDriver driver,String name){
        TakesScreenshot ts= (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        File targetFile = new File("screenshot/" + name+".png");
        System.out.println("Take ScreenShot");

        try {
            FileUtils.copyFile(source,targetFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }


}

