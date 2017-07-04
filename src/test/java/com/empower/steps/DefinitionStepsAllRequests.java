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

    @And("^Search for value \"([^\"]*)\" by \"([^\"]*)\"$")
    public void searchForValueBy(String value, String searchBy) {
        allRequestsSteps.searchForValueBy(value, searchBy);
    }


    @Then("^All Next buttons should be inactive$")
    public void topAndBottomNextButtonsShouldBeInactive() {
        allRequestsSteps.isAllNextButtonInactive();
    }

    @And("^From Search results select Invoice line number \"([^\"]*)\" and select Products lines numbers$")
    public void fromSearchResultsSelectInvoiceLineNumberAndSelectProductsLinesNumbers(String invoiceLine, List<String> productsLines) {
        allRequestsSteps.fromSearchResultsSelectInvoiceLineAndSelectProductsLines(invoiceLine, productsLines);
    }

    @Then("^Arrow icon should have color \"([^\"]*)\" for invoices in lines$")
    public void arrowIconShouldHaveColorForInvoicesInLines(String color, List<String> lineNumbers) {
        allRequestsSteps.isColorOfArrowIconInLines(color, lineNumbers);
    }

    @Then("^All Next buttons should be active$")
    public void allNextButtonsShouldBeActive() {
        allRequestsSteps.isAllNextButtonActive();
    }

    @And("^Click on top Next button$")
    public void clickOnTopNextButton() {
        allRequestsSteps.clickOnTopNextButton();
    }

    @Then("^Reason for Request step should contain all Catalog № from first Step$")
    public void reasonForRequestStepShouldContainAllCatalogFromFirstStep() {
        allRequestsSteps.isReasonForRequestStepContainAllCatalogFromFirstStep();
    }

    @Then("^All Qty label on Reason for Request step should contain appropriate values from step 1$")
    public void allQtyLabelOnReasonForRequestStepShouldContainAppropriateValuesFromStep() {
        allRequestsSteps.isAllQtyLabelOnReasonForRequestStepContainAppropriateValuesFromStep1();
    }

}
