package com.empower.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;

public class HeaderMenu extends PageObject{
    private String HOME=".//div[@id='navbar']//li/a[.='Home']";
    private String MY_CART=".//div[@id='navbar']//li/a[.='My Cart']";
    private String ORDER_STATUS=".//div[@id='navbar']//li/a[.='Order Status']";
    private String SAVED_ITEMS=".//div[@id='navbar']//li/a[.='SAVED ITEMS']";
    private String INVOICE=".//div[@id='navbar']//li/a[.='Invoice']";
    private String PRODUCTS=".//div[@id='navbar']//li/a[.='PRODUCTS']";
    private String POST_SALES=".//div[@id='navbar']//li/div[.='Post Sales']";
    private String SPECIAL_PRICING=".//div[@id='navbar']//li/a[.='Special Pricing']";

    public void clickOnPostSales(){
        $(POST_SALES).click();
    }

    public void selectPostSalesOption(String optionName){
      $(POST_SALES).find(By.xpath("//a[.='"+optionName+"']")).click();
    }



}
