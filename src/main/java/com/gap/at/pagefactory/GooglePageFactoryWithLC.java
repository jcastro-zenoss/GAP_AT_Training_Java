package com.gap.at.pagefactory;

import com.gap.at.botstyletest.BotStyle;
import com.gap.at.pageobject.SearchPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.LoadableComponent;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

/**
 * Created by jcastro on 2/26/17.
 */
public class GooglePageFactoryWithLC extends LoadableComponent<GooglePageFactoryWithLC> {

    WebDriver driver;
    BotStyle botDriver;

    //Web Elements
    @FindBy(name = "q")
    private WebElement searchField;

    @FindBy(name = "btnK")
    private WebElement searchButton;

    /**
     * Constructor of class
     * @param driver Web Driver to manage page elements
     */
    public GooglePageFactoryWithLC(WebDriver driver){
        this.driver = driver;
        this.botDriver = new BotStyle(driver);
        PageFactory.initElements(driver, this);
    }

    @Override
    protected void load() {
        driver.get("http://www.google.com");
    }

    @Override
    protected void isLoaded() throws Error {
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("google.com"), "Not on the issue entry page: " + url);
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
     * This method look for a text in google
     *
     * @param textToSearch Text to search in google
     * @return SearchPage object
     */
    public SearchPage searchText(String textToSearch){
        searchField.sendKeys(textToSearch);
        searchField.submit();
        return new SearchPage(this.driver);
    }

    /**
     * This method wait until page title contains the text to search
     * It means the page with results has been loaded
     *
     * @param textToSearch Text to search
     * @param timeToWaitSecs max time to wait for page title
     */
    public void waitForPageWithResults(final String textToSearch, int timeToWaitSecs){

        // Google's search is rendered dynamically with JavaScript.
        // Wait for the page to load, timeout after 10 seconds
        (new WebDriverWait(driver, timeToWaitSecs)).until(new ExpectedCondition<Boolean>() {
            public Boolean apply(WebDriver d) {
                return d.getTitle().toLowerCase().startsWith(textToSearch.toLowerCase());
            }
        });
    }
}
