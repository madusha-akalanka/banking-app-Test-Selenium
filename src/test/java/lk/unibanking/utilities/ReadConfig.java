package lk.unibanking.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {

    Properties properties = new Properties();

    public ReadConfig() throws IOException {

        FileInputStream fis = new FileInputStream("/home/akalanka/Desktop/selenium IDE/banking-app-test/src/test/resources/application.properties");
        properties.load(fis);


    }

    public String getApplicationUrl() {
        String url = properties.getProperty("baseUrl");
        return url;
    }

    public String getUserName() {
        String username = properties.getProperty("username");
        return username;
    }

    public String getPassword() {
        String password = properties.getProperty("password");
        return password;
    }
}
