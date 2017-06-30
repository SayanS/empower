package com.empower.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HeaderMenu extends PageObject {
    private String HOME = ".//div[@id='navbar']//li/a[.='Home']";
    private String MY_CART = ".//div[@id='navbar']//li/a[.='My Cart']";
    private String ORDER_STATUS = ".//div[@id='navbar']//li/a[.='Order Status']";
    private String SAVED_ITEMS = ".//div[@id='navbar']//li/a[.='SAVED ITEMS']";
    private String INVOICE = ".//div[@id='navbar']//li/a[.='Invoice']";
    private String PRODUCTS = ".//div[@id='navbar']//li/a[.='PRODUCTS']";
    private String POST_SALES = ".//div[@id='navbar']//li/div[contains(text(),'Post Sales')]";
    private String SPECIAL_PRICING = ".//div[@id='navbar']//li/a[.='Special Pricing']";

    public void clickOnPostSales() {
        moveTo(".//div[@data-toggle='dropdown']");
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].click();", $(".//div[@data-toggle='dropdown']"));
        //$(POST_SALES).click();
    }

    public void selectPostSalesItem(String itemName) {
        Actions actions = new Actions(getDriver());
        actions.moveToElement($(POST_SALES).find(By.xpath("//a[contains(text(),'" + itemName + "')]"))).perform();
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.elementToBeClickable(By.xpath(POST_SALES + "//a[contains(text(),'" + itemName + "')]")));

        $(POST_SALES).find(By.xpath("//a[contains(text(),'" + itemName + "')]")).click();
    }


}
