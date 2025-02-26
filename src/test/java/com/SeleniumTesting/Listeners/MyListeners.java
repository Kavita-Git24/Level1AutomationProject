package com.SeleniumTesting.Listeners;

import com.SeleniumTesting.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.Listeners;

import java.io.File;
@Listeners(MyListeners.class)
public class MyListeners implements ITestListener {
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
        TakesScreenshot ts=(TakesScreenshot) DriverManager.getDriver();
        File sourcefile = ts.getScreenshotAs(OutputType.FILE);
        File targetfile= new File(System.getProperty("user.dir")+"\\Screenshots\\fullpage.png");
        sourcefile.renameTo(targetfile);
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
