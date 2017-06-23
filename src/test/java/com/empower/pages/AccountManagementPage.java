package com.empower.pages;

import net.serenitybdd.core.pages.PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.yecht.Data;

public class AccountManagementPage extends PageObject {
    String REGION_DROP_DOWN = ".//select[@id='region']";
    String SEARCH_BUTTON = "(.//button[.='Search'])[2]";
    String SEARCH_ACCOUNT_NAME_FIELD=".//*[@id='searchAccount']";
    String ACCOUNT_NAME_IN_SEARCH_RESULTS=".//tr/td/a[.='$accountName']";
    public void enterAccountName(String accountName) {
        $(SEARCH_ACCOUNT_NAME_FIELD).clear();
         $(SEARCH_ACCOUNT_NAME_FIELD).sendKeys(accountName);
    }

    public void selectRegionOfAccount(String regionName){
        moveTo("(.//ul/li/div[@class='form-group'])[6]").click();
        moveTo("//.//select[@id='region']//option[.='$region']".replace("$region", regionName)).click();
    }

    public void clickOnSearchButton(){
        $(SEARCH_BUTTON).click();
    }

    public void selectAccountFromSearchResults(String accountName) {
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(ACCOUNT_NAME_IN_SEARCH_RESULTS.replace("$accountName",accountName))));
        moveTo(ACCOUNT_NAME_IN_SEARCH_RESULTS.replace("$accountName",accountName));
        $(ACCOUNT_NAME_IN_SEARCH_RESULTS.replace("$accountName",accountName)).click();
    }
}
