package com.empower.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;

public class HeaderMenu extends PageObject{
    private String HOME=".//div[@id='navbar']//li/a[.='Home']";
    private String MY_CART=".//div[@id='navbar']//li/a[.='My Cart']";
    private String ORDER_STATUS=".//div[@id='navbar']//li/a[.='Order Status']";
    private String SAVED_ITEMS=".//div[@id='navbar']//li/a[.='SAVED ITEMS']";
    private String INVOICE=".//div[@id='navbar']//li/a[.='Invoice']";
    private String PRODUCTS=".//div[@id='navbar']//li/a[.='PRODUCTS']";
    private String POST_SALES=".//div[@id='navbar']//li/div[contains(text(),'Post Sales')]";
    private String SPECIAL_PRICING=".//div[@id='navbar']//li/a[.='Special Pricing']";

    public void clickOnPostSales(){
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].click();", $(POST_SALES));
        //$(POST_SALES).click();
    }

    public void selectPostSalesItem(String itemName){
      $(POST_SALES).find(By.xpath("//a[contains(text(),'"+itemName+"')]")).click();
    }



}
