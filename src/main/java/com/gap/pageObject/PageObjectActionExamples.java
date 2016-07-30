package com.gap.pageObject;

import com.gap.selenium.SeleniumActions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Created by Oscar Valerio on 26/07/2016.
 */
public class PageObjectActionExamples {

    @FindBy(id = "double_click")
    private WebElement txtToDoubleClick;

    @FindBy(id = "draggable")
    private WebElement source;

    @FindBy(id = "droppable")
    private WebElement target;

    @FindBy(css = ".dropbtn")
    private WebElement menu;

    @FindBy(css = "textarea")
    private WebElement textarea;

    private WebDriver driver;
    private SeleniumActions seleniumActions;

    public PageObjectActionExamples(WebDriver driver){
        this.driver = driver;
        seleniumActions = new SeleniumActions(this.driver);
    }

    public void doubleClick(){
        seleniumActions.doubleClick(txtToDoubleClick);
    }

    public void dragAndDrop(){
        seleniumActions.dragAndDrop(source, target);
    }

    public void dragAndDropUsingClickAndHold(){
        seleniumActions.dragAndDropUsingClickAndHold(source, target);
    }

    public void moveToElement(){
        seleniumActions.moveToElement(menu);
    }

    public void moveToSource(){
        seleniumActions.moveToElement(source);
    }

    public void moveToTextArea(){
        seleniumActions.moveToElement(textarea);
    }

    public void doubleClickTextArea(){
        seleniumActions.doubleClick(textarea);
    }

    public void selectAllTextAndRemoveContent(){
        seleniumActions.selectAllTextAndRemoveContent();
    }
}
