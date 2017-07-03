package com.empower.steps.serenity;


import com.empower.pages.AccountManagementPage;
import net.thucydides.core.annotations.Step;

public class AccountManagementSteps {
    AccountManagementPage accountManagementPage;

    @Step
    public void searchForAccountFromRegion(String accountNumber, String region) {
        accountManagementPage.enterAccountName(accountNumber);
        accountManagementPage.enterAccountName(accountNumber);
        accountManagementPage.selectRegionOfAccount(region);
        accountManagementPage.clickOnSearchButton();
    }

    @Step
    public void selectAccountFromSearchResults(String accountName, String salesOrg) {
        accountManagementPage.selectAccountFromSearchResults(accountName, salesOrg);
    }
}
