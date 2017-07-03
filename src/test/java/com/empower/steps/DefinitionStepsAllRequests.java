package com.empower.steps;

import com.empower.steps.serenity.AllRequestsSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import net.thucydides.core.annotations.Steps;

import java.util.List;


public class DefinitionStepsAllRequests {
    @Steps
    AllRequestsSteps allRequestsSteps;

    @And("^Click on Create Request button$")
    public void clickOnCreateRequestButton(){
        allRequestsSteps.clickOnCreateRequestButton();
    }

    @And("^Search for value \"([^\"]*)\" by \"([^\"]*)\"$")
    public void searchForValueBy(String value, String searchBy) {
       allRequestsSteps.searchForValueBy(value, searchBy);
    }


    @Then("^All Next buttons should be inactive$")
    public void topAndBottomNextButtonsShouldBeInactive() {
        allRequestsSteps.isAllNextButtonInactive();
    }

    @And("^Add to Product List for Invoice No line number \"([^\"]*)\"$")
    public void addToProductListForInvoiceNoItemLineNumber(String lineNumber){
       allRequestsSteps.addToProductListForInvoiceNoLines(lineNumber);
    }

    @And("^From Product List for Invoice No select line number$")
    public void fromProductListForInvoiceNoSelectLineNumber(List<String> linesNumbers) {
       allRequestsSteps.selectLinesFromProductListForInvoiceNo(linesNumbers);
    }
}
