package com.SeleniumTesting.driver;

import com.SeleniumTesting.utils.PropertiesReader;
import org.apache.poi.ss.formula.atp.Switch;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        return driver;
    }

    public static void setDriver(WebDriver driver){
        DriverManager.driver=driver;
    }

    public static void init(){
        String browser= PropertiesReader.readKey("browser");
        browser=browser.toLowerCase();
        switch (browser)
        {
            case "edge":
                driver= new EdgeDriver();
                driver.manage().window().maximize();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                driver.manage().window().maximize();
                break;
            case "chrome":
                driver=new ChromeDriver();
                driver.manage().window().maximize();
                break;
            default:
                System.out.println("Browser not found!!");
        }
    }

    public static void down(){
        if(driver!=null){
            driver.quit();
            driver=null;
        }

    }
}
