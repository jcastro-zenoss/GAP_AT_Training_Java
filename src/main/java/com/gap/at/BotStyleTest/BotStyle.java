package com.gap.at.BotStyleTest;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.sql.Driver;
import java.util.concurrent.TimeUnit;

/**
 * Created by jcastro on 2/26/17.
 */
public class BotStyle{

    WebDriver driver;

    public BotStyle(WebDriver driver){
        this.driver = driver;
    }

    public WebDriver getDriver(){
        return this.driver;
    }

    public void waitForPageTitle(int timeToWaitSecs, String title){

        (new WebDriverWait(driver, timeToWaitSecs)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(title.toLowerCase());
            }
        });
    }

    public WebElement waitForElementPresent(By byElement, int timeoutInSeconds){
        Wait<WebDriver> wait = new WebDriverWait(driver, timeoutInSeconds);

        WebElement we= wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                 return driver.findElement(byElement);
            }
        });
        return we;
    }

    public void sendKeys(WebElement we, String text){
        we.clear();
        we.sendKeys(text);
    }
}
