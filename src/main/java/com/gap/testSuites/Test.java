package com.gap.testSuites;

import br.eti.kinoshita.testlinkjavaapi.TestLinkAPI;
import com.gap.selenium.SeleniumBase;
import com.gap.testmanagementtool.testlink.TestLinkAccess;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.net.MalformedURLException;

/**
 * Created by jcastro on 5/22/16.
 */
public class Test {

    public static void main(String [] args){

        String url = "https://testlink.wearegap.com/lib/api/xmlrpc/v1/xmlrpc.php";
        String key = "80535d62d292f57003486de62441abe8";

        try {
            createTestLinkProject(url, key);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public static void createTestLinkProject(String url, String key) throws MalformedURLException {

        TestLinkAccess testLinkAccess = new TestLinkAccess(url, key);
        testLinkAccess.createTestlinkProject("TestAutomation1", "AT-", "This is a Testlink project", false, true, true, false, true, true);

    }

    public static void test1(){
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
