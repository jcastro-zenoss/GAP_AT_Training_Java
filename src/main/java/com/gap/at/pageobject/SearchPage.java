package com.gap.at.pageobject;

import com.gap.at.botstyletest.BotStyle;
import org.openqa.selenium.WebDriver;

/**
 * Created by jcastro on 2/26/17.
 */
public class SearchPage {

    BotStyle botDriver;
    WebDriver driver;

    public SearchPage(WebDriver driver){
        this.driver = driver;
        botDriver = new BotStyle(driver);
    }

    /**
     * This method wait until page title contains the text to search
     * It means the page with results has been loaded
     *
     * @param textToSearch Text to search
     * @param timeToWaitSecs max time to wait for page title
     */
    public void waitForPageWithResults(String textToSearch, int timeToWaitSecs){
        botDriver.waitForPageTitle(timeToWaitSecs, textToSearch);
    }
}
