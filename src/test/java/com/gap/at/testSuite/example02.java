package com.gap.at.testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Oscar on 7/5/2017.
 */
public class example02 {
    WebDriver driver = null;
    String url = "https://www.google.com/";

    @BeforeMethod
    public void beforeMethod(){
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.startup.homepage", url);
        driver = new FirefoxDriver(profile);
    }

    // FF example
    @Test
    public void test01() throws InterruptedException {
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("100");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();
    }
}
