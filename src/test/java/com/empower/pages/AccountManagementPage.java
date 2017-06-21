package com.empower.pages;

import net.serenitybdd.core.pages.PageObject;
import org.yecht.Data;

public class AccountManagementPage extends PageObject {
    String REGION_DROP_DOWN = ".//select[@id='region']";
    String SEARCH_ACCOUNT_FIELD = "id='searchAccount'";
    String SAERCH_BUTTON = "(.//button[.='Search'])[2]";

    public void selectAccountName(String accountName) {
         $(".//tr/td/a[.='$accountName']").click();
    }
}
