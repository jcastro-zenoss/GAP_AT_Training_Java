package com.gap.selenium;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

/**
 * Created by Oscar Valerio on 11/07/2016.
 */
public class SeleniumActions {
    private Actions action;

    public SeleniumActions(WebDriver driver) {
        action = new Actions(driver);
    }

    /**
     * This method performs a double click action
     * @param element <p>The element that will receive the action</p>
     */
    public void doubleClick(WebElement element)
    {
        action.doubleClick(element).perform();
    }

    /**
     * This method performs a drag and drop action
     * @param source The source element to move.
     * @param target The target method to release
     */
    public void dragAndDrop(WebElement source, WebElement target)
    {
        action.dragAndDrop(source, target).build().perform();
    }

    /**
     * This method select all text performing a keydown and key up actions
     */
    public void selectAllTextAndRemoveContent()
    {
        action.keyDown(Keys.CONTROL).sendKeys("a").keyUp(Keys.CONTROL).sendKeys(Keys.DELETE).perform();
    }

    /**
     * This method perform a move to element action, it works for example if you need to do a mouse over.
     * @param element Element to move to.
     */
    public void moveToElement(WebElement element)
    {
        action.moveToElement(element).build().perform();
    }

    /**
     * This method perform a drag and drop using the click and hold functionality
     * @param source The element to move to another one
     * @param target The element that receives the drop action
     */
    public void dragAndDropUsingClickAndHold(WebElement source, WebElement target)
    {
        Action dragAndDrop = action.clickAndHold(source)
                .moveToElement(target)
                .release(target)
                .build();
        dragAndDrop.perform();
    }
}
