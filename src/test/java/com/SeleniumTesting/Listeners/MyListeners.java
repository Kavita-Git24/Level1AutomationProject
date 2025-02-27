package com.SeleniumTesting.Listeners;

import com.SeleniumTesting.base.CommonToAllTest;
import com.SeleniumTesting.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.io.File;
public class MyListeners extends CommonToAllTest implements ITestListener {
    public void onTestStart(ITestResult result)
    {
        System.out.println("Test Started");
    }

    public void onTestSuccess(ITestResult result)
    {
        System.out.println("Test Succeed");
    }

    public void onTestFailure(ITestResult result)
    {
        System.out.println("Test Failed");
        capturefullpageScreenshot();
    }

    public void onTestSkipped(ITestResult result)
    {
        System.out.println("Test Skipped");
    }

    public void onStart(ITestContext context)
    {
        System.out.println("Test excecution Started");
    }

    public void onFinish(ITestContext context)
    {
        System.out.println("Test excecution Finished");
    }
}
