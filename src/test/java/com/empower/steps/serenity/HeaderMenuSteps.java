package com.empower.steps.serenity;
import com.empower.pages.HeaderMenu;
import net.thucydides.core.annotations.Step;

public class HeaderMenuSteps {
    HeaderMenu headerMenu;

    @Step
    public void selectItemOfPastSalesMenu(String itemName) {
        headerMenu.clickOnPostSales();
        headerMenu.selectPostSalesItem(itemName);
    }
}
