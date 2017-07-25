package com.empower.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ToolTipPopUp extends CustomPageObject{
    private String SKIP=".//div[@class='introjs-tooltipbuttons']/a[.='Skip']";

    public void closeToolTipPopup(){
        (new WebDriverWait(getDriver(), 10000)).until(ExpectedConditions.elementToBeClickable(By.xpath(SKIP)));
        $(SKIP).click();
    }
}
