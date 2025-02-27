package com.SeleniumTesting.tests;

import com.SeleniumTesting.base.CommonToAllTest;
import com.SeleniumTesting.driver.DriverManager;
import com.SeleniumTesting.pages.LoginPage;
import com.SeleniumTesting.pages.TransactionPage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Test_Trans extends CommonToAllTest {
    private static final Logger logger= LogManager.getLogger(Test_Trans.class);
    static float total_amount;
    @Description("Verify that Valid total amount of transaction")
    @Test
    public void test_valid_total_amount() throws InterruptedException {
        logger.info("Starting the Testcase for Valid Total Transaction...");
        TransactionPage transactionPage=new TransactionPage(DriverManager.getDriver());
        //WebElement Feature_capture=transactionPage.get_transaction_table();
        String actualresult=transactionPage.transaction_total();

        logger.info("End of the Testcase for Valid Total Transaction...");
        Assert.assertEquals(actualresult,"1996.22");
    }

    @Description("Verify that total amount of transaction is invalid")
    @Test
    public void test_invalid_total_amount() throws InterruptedException {
        logger.info("Starting the Testcase for Invalid Total Transaction...");
        TransactionPage transactionPage=new TransactionPage(DriverManager.getDriver());
        //WebElement Feature_capture=transactionPage.get_transaction_table();
        String actualresult=transactionPage.transaction_total();

        logger.info("End of the Testcase for Invalid Total Transaction...");
        Assert.assertEquals(actualresult,"1996.225");
    }
}
