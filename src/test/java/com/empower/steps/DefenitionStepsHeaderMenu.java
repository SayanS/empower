package com.empower.steps;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;
import com.empower.steps.serenity.HeaderMenuSteps;

public class DefenitionStepsHeaderMenu {
    @Steps
    HeaderMenuSteps headerMenuSteps;
        @And("^Select \"([^\"]*)\" option from Post Sales item of the Header menu$")
        public void selectItemOfPastSalesMenu(String itemName) {
            headerMenuSteps.selectItemOfPastSalesMenu(itemName);
        }



}
