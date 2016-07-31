package com.gap.selenium;

import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by jcastro on 5/22/16.
 */
public class SeleniumBase {
    private WebDriver driver;

    /**
     * This method create a instance of the driver
     *
     * @param browserName Browser name
     * @return Driver to use
     */
    public WebDriver initDriver(String browserName, URL... url){

        switch (browserName) {
            case "Chrome":
                this.driver = initChromeDriver();
                break;
            case "Grid_Chrome":
                this.driver = initGridChromeDriver(url[0]);
                break;
            case "IE":
                this.driver = initIEDriver();
                break;
            case "Firefox":
                this.driver = initFirefoxDriver();
                break;
            case "Grid_Firefox":
                this.driver = initGridFirefoxDriver(url[0]);
                break;
            case "HtmlUnit":
                initHTMLUnitDriver();
                break;
            default:
                this.driver = null;
                break;
        }
        return this.driver;
    }

    private WebDriver initChromeDriver(){
        return new ChromeDriver();
    }

    private WebDriver initGridChromeDriver(URL url){
        DesiredCapabilities capability=DesiredCapabilities.firefox();
        capability.setBrowserName("chrome");
        capability.setPlatform(Platform.VISTA);
        return new RemoteWebDriver(url, capability);
    }

    private WebDriver initIEDriver(){
        return new InternetExplorerDriver();
    }

    private WebDriver initFirefoxDriver(){
        return new FirefoxDriver();
    }

    private WebDriver initGridFirefoxDriver(URL url){
        DesiredCapabilities capability=DesiredCapabilities.firefox();
        capability.setBrowserName("firefox");
        capability.setPlatform(Platform.VISTA);
        return new RemoteWebDriver(url, capability);
    }

    private WebDriver initHTMLUnitDriver(){
        return new HtmlUnitDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    public void setDriver(WebDriver driver) {
        this.driver=driver;
    }

    @BeforeMethod
    @Parameters({"browser", "nodeUrl", "nodeIp", "nodePort"})
    public void before(String browser, String nodeUrl, String nodeIp, String nodePort) throws MalformedURLException {
        URL url = new URL(String.format(nodeUrl, nodeIp, nodePort));
        initDriver(browser, url);
    }

    @AfterMethod
    public void after(){
        driver.quit();
    }
}
