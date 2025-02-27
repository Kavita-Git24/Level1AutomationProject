package com.SeleniumTesting.base;

import com.SeleniumTesting.driver.DriverManager;
import com.SeleniumTesting.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static com.SeleniumTesting.driver.DriverManager.getDriver;

public class CommonToAllPages {

    public CommonToAllPages(){
    }

    public void openLoginUrl(){
        getDriver().get(PropertiesReader.readKey("login_page_url"));
    }

    public void custom_wait(){
        try{
            Thread.sleep(3000);
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void enterInput(By by,String key){
        getDriver().findElement(by).sendKeys(key);
    }

    public void clickButton(By by){
        getDriver().findElement(by).click();
    }
    public String getUrl(){
        return getDriver().getCurrentUrl();
      }
    public void Openhomepage(){
        getDriver().get(PropertiesReader.readKey("home_page_url"));
    }

    public String total_amt_cal(int row_count)
    {
        float total_amount=0;
        String first="//table[@class='table table-padded']/tbody/tr[";
        String second="]/td[5]";

        for(int i=1;i<=row_count;i++){
            String path=first+i+second;
            String data=getDriver().findElement(By.xpath(path)).getText();

            if(data.contains("+"))
            {
                float amount=Float.valueOf(data.substring(1,data.length()).replaceAll("[^0-9.]+",""));
                total_amount=total_amount+amount;

            }
            else if(data.contains("-")) {
                float amount=Float.valueOf(data.substring(1,data.length()).replaceAll("[^0-9.]+",""));
                total_amount=total_amount-amount;

            }
            else {
                System.out.println("Invalid amount");
            }
        }
        String actual_result= Float.toString(total_amount);
        return actual_result;
       }

       public void custom_imp_wait(){
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(1500));
       }

       public WebElement visibilityofElement(By elementLocation){
           return new WebDriverWait(getDriver(),Duration.ofSeconds(20)).until(ExpectedConditions.visibilityOfElementLocated(elementLocation));
       }

       public WebElement getElement(By by){
         return getDriver().findElement(by);
       }

}
