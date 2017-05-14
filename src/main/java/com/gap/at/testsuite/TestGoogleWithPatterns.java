package com.gap.at.testsuite;

import com.gap.at.pagefactory.GooglePageFactory;
import com.gap.at.pagefactory.GooglePageFactoryWithLC;
import com.gap.at.pageobject.GooglePage;
import com.gap.at.pageobject.SearchPage;
import com.gap.at.selenium.SeleniumBase;
import org.openqa.selenium.WebDriver;

/**
 * Created by jcastro on 2/26/17.
 */
public class TestGoogleWithPatterns {

    public static void main(String[] args) {

        SeleniumBase seleniumBase = new SeleniumBase();
        WebDriver driver = seleniumBase.initDriver("Chrome");

        String searchText = "Cheese!";
        //testPageObject(driver, searchText);
        //testPageFactory(driver, searchText);
        //testPageFactoryWithBotStyle(driver, searchText);
        testPageFactoryWithLC(driver, searchText);

    }

    public static void testPageObject(WebDriver driver, String searchText){

        try {
            GooglePage googlePage = new GooglePage(driver);
            googlePage.gotoSearchPage("http://www.google.com");

            //Print page title before searching for text
            System.out.println("Page title is: " + googlePage.getPageTitle());

            SearchPage searchPage = googlePage.searchText(searchText);      //Search a text

            // Check the title of the page
            searchPage.waitForPageWithResults(searchText, 10);
            System.out.println("Page title is: " + googlePage.getPageTitle());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();  //Close the browser
        }
    }

    public static void testPageFactory(WebDriver driver, String searchText){

        try {
            GooglePageFactory googlePageF = new GooglePageFactory(driver);
            googlePageF.gotoSearchPage("http://www.google.com");

            //Print page title before searching for text
            System.out.println("Page title is: " + googlePageF.getPageTitle());

            SearchPage searchPage = googlePageF.searchText(searchText);      //Search a text

            // Check the title of the page
            searchPage.waitForPageWithResults(searchText, 10);
            System.out.println("Page title is: " + googlePageF.getPageTitle());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();  //Close the browser
        }
    }

    public static void testPageFactoryWithBotStyle(WebDriver driver, String searchText){

        try {
            GooglePageFactory googlePageF = new GooglePageFactory(driver);
            googlePageF.gotoSearchPage("http://www.google.com");

            //Print page title before searching for text
            System.out.println("Page title is: " + googlePageF.getPageTitle());

            SearchPage searchPage = googlePageF.searchTextWithBoot(searchText);      //Search a text

            // Check the title of the page
            searchPage.waitForPageWithResults(searchText, 10);
            System.out.println("Page title is: " + googlePageF.getPageTitle());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();  //Close the browser
        }
    }

    public static void testPageFactoryWithLC(WebDriver driver, String searchText){

        try {
            GooglePageFactoryWithLC googlePageF = new GooglePageFactoryWithLC(driver).get();

            //Print page title before searching for text
            System.out.println("Page title is: " + googlePageF.getPageTitle());

            SearchPage searchPage = googlePageF.searchText(searchText);      //Search a text

            // Check the title of the page
            searchPage.waitForPageWithResults(searchText, 10);
            System.out.println("Page title is: " + googlePageF.getPageTitle());

        } catch (Exception e){
            e.printStackTrace();
        } finally {
            driver.quit();  //Close the browser
        }
    }
}
