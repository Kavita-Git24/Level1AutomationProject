package com.SeleniumTesting.tests;

import com.SeleniumTesting.base.CommonToAllTest;
import com.SeleniumTesting.driver.DriverManager;
import com.SeleniumTesting.pages.LoginPage;
import com.SeleniumTesting.utils.PropertiesReader;
import io.qameta.allure.Description;
import io.qameta.allure.internal.shadowed.jackson.databind.annotation.JsonAppend;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Test_Login extends CommonToAllTest {
    @Description("Verify that user is able to login with valid credentials")
    @Test
    public void test_with_valid_credentials() throws InterruptedException{
        LoginPage loginPage= new LoginPage(DriverManager.getDriver());
        String get_current_Url=loginPage.loginwithvalidCredientials(PropertiesReader.readKey("username"),PropertiesReader.readKey("password"));

        Assert.assertEquals(get_current_Url, PropertiesReader.readKey("home_page_url"));
        }
}
