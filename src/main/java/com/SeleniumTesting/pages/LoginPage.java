package com.SeleniumTesting.pages;

import com.SeleniumTesting.base.CommonToAllPages;
import com.SeleniumTesting.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends CommonToAllPages {
    // Page Class
    // Page Locators
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By username = By.id("username");
    private By password = By.id("password");
    private By signButton = By.id("log-in");

    public String loginwithvalidCredientials(String user,String pwd) {

        openLoginUrl();
        enterInput(username,user);
        enterInput(password,pwd);
        clickButton(signButton);
        custom_imp_wait();
        return getUrl();
    }
}
