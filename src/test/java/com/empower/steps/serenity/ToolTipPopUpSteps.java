package com.empower.steps.serenity;
import com.empower.pages.ToolTipPopUp;
import net.thucydides.core.annotations.Step;

public class ToolTipPopUpSteps {
    ToolTipPopUp toolTipPopUp;

    @Step
    public void closeTooltipPopUp() {
        toolTipPopUp.closeToolTipPopup();
    }
}
