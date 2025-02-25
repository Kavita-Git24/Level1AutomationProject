package com.SeleniumTesting.tests;

import com.SeleniumTesting.pages.LoginPage;
import com.SeleniumTesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Login {
    @Description("Verify that user is able to login with valid credentials")
    @Test
    public void test_with_valid_credentials() throws InterruptedException {
        WebDriver driver=new EdgeDriver();
        LoginPage loginPage= new LoginPage(driver);
        String get_current_Url=loginPage.loginwithvalidCredientials("Admin","Password@123");

        Assert.assertEquals(get_current_Url, PropertiesReader.readKey("home_page_url"));
        driver.quit();
    }
}
