package com.gap.at.pageobject;

import com.gap.at.BotStyleTest.BotStyle;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

/**
 * Created by jcastro on 2/26/17.
 */
public class GooglePage {

    WebDriver driver;
    BotStyle botDriver;

    //Web Elements
    By searchField = By.name("q");

    /**
     * Constructor of class
     * @param driver Web Driver to manage page elements
     */
    public GooglePage(WebDriver driver){
        this.driver = driver;
        this.botDriver = new BotStyle(driver);
    }

    /**
     * This method returns the page title
     *
     * @return Page title
     */
    public String getPageTitle(){
        return this.driver.getTitle();
    }

    /**
     * Load the page
     * @param url URL of page to load
     */
    public void gotoSearchPage(String url){
        driver.navigate().to(url);
    }

    /**
     * This method look for a text in google
     *
     * @param textToSearch Text to search in google
     * @return SearchPage object
     */
    public SearchPage searchText(String textToSearch){
        WebElement findWE = botDriver.waitForElementPresent(searchField, 15);
        findWE.sendKeys(textToSearch);
        findWE.submit();
        return new SearchPage(this.driver);
    }

}
