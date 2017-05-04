package com.gap.testSuites;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import org.testng.annotations.*;

import java.io.File;

/**
 * Created by Oscar on 3/5/2017.
 */
public class TestActionsV2 {

    WebDriver driver;
    // the url change depends on each local machine.
    String url = new File("src/main/resources/html/index.html").getAbsolutePath();

    @BeforeMethod
    public void beforeMethod()
    {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }

    @Test
    public void test() throws InterruptedException {
        // create the "Actions" Instance
        Actions action = new Actions(driver);
        Thread.sleep(3000);

        // double click
        WebElement elementToDoubleClick = driver.findElement(By.id("double_click"));
        action.doubleClick(elementToDoubleClick).perform();
        Thread.sleep(3000);

        // drag and drop
        // option 01
        WebElement source = driver.findElement(By.id("draggable"));
        WebElement target = driver.findElement(By.id("droppable"));
        action.dragAndDrop(source, target).perform();
        Thread.sleep(3000);

        //option 02
        action.clickAndHold(source)
                .moveToElement(target)
                .release(target)
                .build().perform();
        Thread.sleep(3000);

        //select all text and delete
        WebElement textArea = driver.findElement(By.cssSelector("textarea"));
        action.click(textArea).perform();
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
        Thread.sleep(3000);

        //move to element
        WebElement menu = driver.findElement(By.cssSelector(".dropbtn"));
        WebElement option1 = driver.findElement(By.xpath("//*[.='Submenu 1']"));
        WebElement option2 = driver.findElement(By.xpath("//*[.='Submenu 2']"));
        WebElement option3 = driver.findElement(By.xpath("//*[.='Submenu 3']"));

        action.moveToElement(menu).perform();
        Thread.sleep(1000);
        action.moveToElement(option1).perform();
        Thread.sleep(1000);
        action.moveToElement(option2).perform();
        Thread.sleep(1000);
        action.moveToElement(option3).perform();
        Thread.sleep(3000);
    }

    @AfterMethod
    public void afterMethod()
    {
        driver.quit();
    }
}
