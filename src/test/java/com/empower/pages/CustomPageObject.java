package com.empower.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CustomPageObject extends PageObject{

    public WebElementFacade scrollIntoView(String xpath){
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", $(xpath));
        }catch(Exception e){
            return null;
        }
        return $(xpath);
    }

    public WebElementFacade scrollIntoView(WebElementFacade webElementFacade){
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElementFacade);
        }catch(Exception e){
            return null;
        }
        return webElementFacade;
    }

    public WebElementFacade waitElementToBeClickable(String xpath){
        try {
            (new WebDriverWait(getDriver(), 5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        }catch(Exception e){
            return null;
        }
        return $(xpath);
    }

    public WebElementFacade  waitElementToBeClickable(WebElementFacade webElement){
        try {
            (new WebDriverWait(getDriver(), 5)).until(ExpectedConditions.elementToBeClickable(webElement));
        }catch(Exception e){
            return null;
        }
        return webElement;
    }

    public WebElementFacade moveTo(WebElementFacade webElementFacade){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(webElementFacade);
        return webElementFacade;
    }

    public void clickOnButton(String buttonName) {
        waitElementToBeClickable(".//button[.='Go']").click();
    }
}
