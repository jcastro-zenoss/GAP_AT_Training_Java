package com.gap.at.testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Oscar on 7/5/2017.
 */
public class example01 {
    WebDriver driver = null;
    String url = "https://www.google.com/";

    @BeforeMethod
    public void beforeMethod(){
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability(InternetExplorerDriver.ENABLE_PERSISTENT_HOVERING,false);
        dc.setCapability(InternetExplorerDriver.REQUIRE_WINDOW_FOCUS, false);
        dc.setCapability(InternetExplorerDriver.UNEXPECTED_ALERT_BEHAVIOR, true);
        dc.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        dc.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, url);
        dc.setJavascriptEnabled(true);
        driver = new InternetExplorerDriver(dc);
    }

    // IE example
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
