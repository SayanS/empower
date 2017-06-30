package com.empower.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class AllRequestsPage extends PageObject{
    String CREATE_REQUEST_BUTTON=".//button[@id='Create Request']";

    public void clickOnCreateRequestButton(){
        //Actions actions=new Actions(getDriver());

        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.elementToBeClickable(By.xpath(CREATE_REQUEST_BUTTON)));
        $(CREATE_REQUEST_BUTTON).click();
    }
}
