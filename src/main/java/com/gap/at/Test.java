package com.gap.at;

import com.gap.at.selenium.SeleniumBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jcastro on 5/22/16.
 */
public class Test {

    public static void main(String [] args){

        SeleniumBase seleniumBase = new SeleniumBase();
        WebDriver driver = seleniumBase.initDriver("Chrome");

        driver.get("http://www.google.com/xhtml");

        try {
            Thread.sleep(5000);  // Let the user actually see something!
            WebElement we = driver.findElement(By.name("q"));
            we.sendKeys("Selenium");
            we.submit();
            Thread.sleep(5000);  // Let the user actually see something!

            driver.quit();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
