package com.empower.steps.serenity;
import com.empower.pages.HeaderMenu;

public class HeaderMenuSteps {
    HeaderMenu headerMenu;

    public void selectItemOfPastSalesMenu(String itemName) {
        headerMenu.clickOnPostSales();
        headerMenu.selectPostSalesItem(itemName);
    }
}
