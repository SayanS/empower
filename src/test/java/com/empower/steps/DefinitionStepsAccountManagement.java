package com.empower.steps;

import com.empower.steps.serenity.AccountManagementSteps;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

public class DefinitionStepsAccountManagement {

    @Steps
    AccountManagementSteps accountManagementSteps;

    @When("^Search for account \"([^\"]*)\" from region \"([^\"]*)\"$")
    public void searchForAccountFromRegion(String accountNumber, String region) {
        accountManagementSteps.searchForAccountFromRegion(accountNumber, region);
    }

    @And("^Select account \"([^\"]*)\" from search results with Seles org \"([^\"]*)\"$")
    public void selectAccountFromSearchResults(String accountName, String salesOrg) {
        accountManagementSteps.selectAccountFromSearchResults(accountName, salesOrg);
    }
}
