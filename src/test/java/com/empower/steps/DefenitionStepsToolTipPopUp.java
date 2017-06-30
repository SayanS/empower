package com.empower.steps;

import com.empower.steps.serenity.ToolTipPopUpSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import net.thucydides.core.annotations.Steps;

public class DefenitionStepsToolTipPopUp {
    @Steps
    ToolTipPopUpSteps toolTipPopUpSteps;

    @And("^Close Tooltip pop-up$")
    public void closeTooltipPopUp() {
        toolTipPopUpSteps.closeTooltipPopUp();
    }
}
