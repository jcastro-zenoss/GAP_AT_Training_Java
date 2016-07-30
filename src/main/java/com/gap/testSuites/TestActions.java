package com.gap.testSuites;

import com.gap.pageObject.PageObjectActionExamples;
import com.gap.selenium.SeleniumBase;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

/**
 * Created by Oscar Valerio on 11/07/2016.
 */
public class TestActions {
    WebDriver driver;
    // the url change depends on each local machine.
    String url="file:///C:/Users/Automation/Desktop/AT/workspace/GAP_AT_Training_Java/src/main/resources/html/index.html";

    @BeforeMethod
    public void beforeMethod()
    {
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void doubleClick() throws InterruptedException
    {
        PageObjectActionExamples po = PageFactory.initElements(driver, PageObjectActionExamples.class);

        // double click
        po.doubleClick();
        Thread.sleep(5000);

        // drag and drop
        po.dragAndDrop();
        po.dragAndDropUsingClickAndHold();
        Thread.sleep(5000);

        //select all text and delete
        po.doubleClickTextArea();
        po.selectAllTextAndRemoveContent();
        Thread.sleep(5000);

        //move to element
        po.moveToElement();
        Thread.sleep(5000);
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }
}
