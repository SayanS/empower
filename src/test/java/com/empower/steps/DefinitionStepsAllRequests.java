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
    public void clickOnCreateRequestButton() {
        allRequestsSteps.clickOnCreateRequestButton();
    }

    @And("^Search for \"([^\"]*)\" by \"([^\"]*)\"$")
    public void searchForValueBy(String value, String searchBy) {
        allRequestsSteps.searchForValueBy(value, searchBy);
    }


    @Then("^All Next buttons should be inactive$")
    public void topAndBottomNextButtonsShouldBeInactive() {
        allRequestsSteps.isAllNextButtonInactive();
    }

    @And("^Select Invoice from Search results in line \"([^\"]*)\"$")
    public void selectInvoicefromSearchResults(String lineNumber) {
        allRequestsSteps.selectInvoicefromSearchResults(lineNumber);
    }

    @Then("^Arrow icon should have color \"([^\"]*)\" for selected invoice in line \"([^\"]*)\"$")
    public void arrowIconShouldHaveColorForInvoiceInLine(String color, String line) {
        allRequestsSteps.isColorOfArrowIconInLine(color, line);
    }

    @Then("^All Next buttons should be active$")
    public void allNextButtonsShouldBeActive() {
        allRequestsSteps.isAllNextButtonActive();
    }

    @And("^Click on top Next button$")
    public void clickOnTopNextButton() {
        allRequestsSteps.clickOnTopNextButton();
    }

    @Then("^Reason for Request step should contain all selected products from Step 1$")
    public void reasonForRequestStepShouldContainAllCatalogFromFirstStep() {
        allRequestsSteps.isReasonForRequestStepContainAllCatalogFromFirstStep();
    }

    @Then("^All Qty label on Reason for Request step should contain appropriate values from Step 1$")
    public void allQtyLabelOnReasonForRequestStepShouldContainAppropriateValuesFromStep() {
        allRequestsSteps.isAllQtyLabelOnReasonForRequestStepContainAppropriateValuesFromStep1();
    }


    @And("^Select \"([^\"]*)\" Product from requested list$")
    public void selectProductFromRequestedList(String index) {
        allRequestsSteps.selectProductFromRequestedList(index);
    }

    @And("^Select Last Product from requested list$")
    public void selectLastProductFromRequestedList() {
        allRequestsSteps.selectLastProductFromRequestedList();
    }

    @And("^Select All Product from requested list$")
    public void selectAllProductFromRequestedList() {
       allRequestsSteps.selectAllProductFromRequestedList();
    }

    @Then("^Invoice should contain product \"([^\"]*)\"$")
    public void invoiceShouldContainProduct(String productName) {
        allRequestsSteps.isInvoiceContains(productName);
    }
}
