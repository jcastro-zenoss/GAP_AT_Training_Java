package com.gap.at.testSuite;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.File;
import java.util.Arrays;

/**
 * Created by Oscar on 7/5/2017.
 */
public class example03 {
    WebDriver driver = null;
    String url = "https://www.google.com/";

    @BeforeMethod
    public void beforeMethod(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("src/test/resources/extension_4_10_7.crx"));
        options.addArguments("start-maximized");
        //options.addArguments("-incognito");
        capabilities.setCapability("chrome.switches", Arrays.asList("--homepage=".concat(url)));
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        System.setProperty("webdriver.chrome.driver",new File("src/test/resources/chromedriver.exe").getAbsolutePath());
        driver = new ChromeDriver(capabilities);
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
