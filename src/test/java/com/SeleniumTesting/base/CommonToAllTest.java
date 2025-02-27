package com.SeleniumTesting.base;

import com.SeleniumTesting.driver.DriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.io.File;

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

    public void capturefullpageScreenshot(){
        TakesScreenshot ts=(TakesScreenshot)DriverManager.getDriver();
        File sourcefile = ts.getScreenshotAs(OutputType.FILE);
        File targetfile= new File(System.getProperty("user.dir")+"\\Screenshot\\screenshots" + System.currentTimeMillis() + ".png");
        sourcefile.renameTo(targetfile);
    }

    public void captureapecifiedareaScreenshot(WebElement webElement){
        File sourcefile = webElement.getScreenshotAs(OutputType.FILE);
        File targetfile= new File(System.getProperty("user.dir")+"\\Screenshot\\screenshots" + System.currentTimeMillis() + ".png");
        sourcefile.renameTo(targetfile);
    }
}
