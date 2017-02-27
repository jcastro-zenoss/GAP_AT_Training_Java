package com.gap.at.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Created by jcastro on 5/22/16.
 */
public class SeleniumBase {

    protected WebDriver driver;

    /**
     * This method create a instance of the driver
     *
     * @param browserName Browser name
     * @return Driver to use
     */
    public WebDriver initDriver(String browserName){

        switch (browserName) {
            case "Chrome":
                this.driver = initChromeDriver();
                break;
            case "IE":
                this.driver = initIEDriver();
                break;
            case "Firefox":
                this.driver = initFirefoxDriver();
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

    private WebDriver initIEDriver(){
        return new InternetExplorerDriver();
    }

    private WebDriver initFirefoxDriver(){
        return new FirefoxDriver();
    }

    private WebDriver initHTMLUnitDriver(){
        return new HtmlUnitDriver();
    }
}
