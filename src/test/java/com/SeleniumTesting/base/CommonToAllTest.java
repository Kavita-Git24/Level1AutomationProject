package com.SeleniumTesting.base;

import com.SeleniumTesting.driver.DriverManager;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

public class CommonToAllTest {

    @BeforeMethod
    public void setup(){
        DriverManager.init();
    }

    @AfterTest
    public void tearDown()
    {
        DriverManager.down();
    }
}
