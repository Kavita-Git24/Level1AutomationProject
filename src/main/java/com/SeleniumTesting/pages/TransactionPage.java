package com.SeleniumTesting.pages;

import com.SeleniumTesting.base.CommonToAllPages;
import com.SeleniumTesting.utils.PropertiesReader;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TransactionPage extends CommonToAllPages {
    // Page Class
    // Page Locators
    WebDriver driver;


    private By Web_table=By.xpath("//table[@class='table table-padded']/tbody/tr");

    public TransactionPage(WebDriver driver){
        this.driver=driver;
    }
    public String transaction_total()
    {
        Openhomepage();

        int row=driver.findElements(Web_table).size();
        return total_amt_cal(row);

    }
}
