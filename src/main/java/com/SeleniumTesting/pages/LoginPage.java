package com.SeleniumTesting.pages;

import com.SeleniumTesting.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage {
    // Page Class
    // Page Locators
    WebDriver driver;
    public LoginPage(WebDriver driver)
    {
        this.driver=driver;
    }

    private By username = By.xpath("//input[@id='username']");
    private By password = By.xpath("//input[@id='password']");
    private By signButton = By.xpath("//a[@id='log-in']");

    public String loginwithvalidCredientials(String user,String pwd) {

        driver.get(PropertiesReader.readKey("login_page_url"));
        driver.manage().window().maximize();
        driver.findElement(username).sendKeys(user);
        driver.findElement(password).sendKeys(pwd);
        driver.findElement(signButton).click();
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        String get_current_Url=driver.getCurrentUrl();
        return get_current_Url;
    }
}
