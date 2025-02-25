package com.SeleniumTesting.tests;

import com.SeleniumTesting.pages.LoginPage;
import com.SeleniumTesting.pages.TransactionPage;
import io.qameta.allure.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Test_Trans {
    static float total_amount;
    @Description("Verify that total amount")
    @Test
    public void test_total_amount() throws InterruptedException {
        WebDriver driver = new EdgeDriver();
        TransactionPage transactionPage=new TransactionPage(driver);
        String actualresult=transactionPage.transaction_total();
        Assert.assertEquals(actualresult,"1996.22");
    }
}
