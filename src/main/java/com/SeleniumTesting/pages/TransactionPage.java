package com.SeleniumTesting.pages;

import com.SeleniumTesting.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionPage {
    // Page Class
    // Page Locators
    WebDriver driver;
    static float total_amount;

    private By Web_table=By.xpath("//table[@class='table table-padded']/tbody/tr");

    public TransactionPage(WebDriver driver){
        this.driver=driver;
    }
    public String transaction_total()
    {
        driver.get(PropertiesReader.readKey("home_page_url"));
        driver.manage().window().maximize();
        int row=driver.findElements(Web_table).size();

        String first="//table[@class='table table-padded']/tbody/tr[";
        String second="]/td[5]";

        for(int i=1;i<=row;i++){
            String path=first+i+second;
            String data=driver.findElement(By.xpath(path)).getText();

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
}
