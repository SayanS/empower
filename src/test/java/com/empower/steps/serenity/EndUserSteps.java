package com.empower.steps.serenity;

import com.empower.pages.DictionaryPage;
import com.empower.pages.HeaderMenu;
import com.empower.pages.LoginPage;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.steps.ScenarioSteps;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EndUserSteps {

    HeaderMenu headerMenu;
    LoginPage loginPage;

    public void openLoginPage() {
        loginPage.open();
    }
}