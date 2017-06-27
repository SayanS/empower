package com.empower.steps;

import com.empower.steps.serenity.AllRequestsSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;


public class DefinitionStepsAllRequests {
    AllRequestsSteps allRequestsSteps;

    @And("^Click on Create Request button$")
    public void clickOnCreateRequestButton(String buttonName){
        allRequestsSteps.clickOnCreateRequestButton();
    }
}
