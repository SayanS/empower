package com.empower.steps.serenity;


import com.empower.pages.AccountManagementPage;

public class AccountManagementSteps {
    AccountManagementPage accountManagementPage;


    public void searchForAccountFromRegion(String accountNumber, String region) {
        accountManagementPage.enterAccountName(accountNumber);
        accountManagementPage.enterAccountName(accountNumber);
        accountManagementPage.selectRegionOfAccount(region);
        accountManagementPage.clickOnSearchButton();
    }

    public void selectAccountFromSearchResults(String accountName) {
       accountManagementPage.selectAccountFromSearchResults(accountName);
    }
}
