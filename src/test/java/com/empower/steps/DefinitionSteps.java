package com.empower.steps;

import cucumber.api.PendingException;
import net.thucydides.core.annotations.Steps;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import com.empower.steps.serenity.EndUserSteps;
import com.empower.steps.serenity.LoginSteps;

public class DefinitionSteps {

    @Steps
    EndUserSteps endUserSteps;
    @Steps
    LoginSteps loginSteps;

    @Given("^Login with \"([^\"]*)\" and \"([^\"]*)\"$")
    public void login(String userID, String password) {
        loginSteps.login(userID, password);
    }

    @Given("^Open Login Page$")
    public void openLoginPage() {
        endUserSteps.openLoginPage();
    }
}
