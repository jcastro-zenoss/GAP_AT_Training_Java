package com.gap.testSuites;

import com.gap.selenium.SeleniumBase;
import org.openqa.selenium.Platform;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.net.MalformedURLException;
import java.net.URL;

// To use the RemoteWebDriver object

/**
 * Created by Oscar Valerio on 30/06/2016.
 */
public class GridTest extends SeleniumBase {

    String baseUrl="https://www.google.com/"; //site url to test

    @Test
    public void test01() throws InterruptedException {
        getDriver().get(baseUrl);
        Thread.sleep(10);
    }
}
