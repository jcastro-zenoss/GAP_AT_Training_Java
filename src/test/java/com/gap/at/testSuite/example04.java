package com.gap.at.testSuite;

import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.By;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by Oscar on 7/5/2017.
 */
public class example04 {
    WebDriver driver = null;
    BrowserMobProxy proxy;
    String url = "https://www.google.com/";
    String harFileName = "src/main/resources/example4.har";

    @BeforeMethod
    public void beforeMethod(){
        // start the proxy
        proxy = new BrowserMobProxyServer();
        proxy.start(0);
        int port = proxy.getPort();

        // get the Selenium proxy object
        Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

        // configure it as a desired capability
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);

        // start the browser up
        driver = new ChromeDriver(capabilities);

        // create a new HAR with the label "yahoo.com"
        proxy.newHar("google.com");
    }

    // FF example
    @Test
    public void test01() throws InterruptedException {
        driver.get(url);
        WebElement element = driver.findElement(By.name("q"));
        element.sendKeys("100");
        Thread.sleep(5000);
    }

    @AfterMethod
    public void afterMethod(){
        driver.quit();

        // get the HAR data
        Har har = proxy.getHar();

        // Write HAR Data in a File
        harFileName = new File(harFileName).getAbsolutePath();
        File harFile = new File(harFileName);
        try {
            har.writeTo(harFile);
        } catch (IOException ex) {
            System.out.println (ex.toString());
            System.out.println("Could not find file " + harFileName);
        }

        if (driver != null) {
            proxy.stop();
            driver.quit();
        }
    }
}
