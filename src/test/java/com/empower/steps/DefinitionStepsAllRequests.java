package com.empower.steps;

import com.empower.steps.serenity.AllRequestsSteps;
import com.esotericsoftware.yamlbeans.YamlException;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import net.thucydides.core.annotations.Steps;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Date;
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

    @Then("^Select \"([^\"]*)\" from Reason for Request drop-down for Product in line \"([^\"]*)\"$")
    public void selectFromReasonForRequestDropDownOfProductInLine(String reason, String index) {
        allRequestsSteps.selectFromReasonForRequestDropDownOfProductInLine(reason, index);
    }

    @Then("^Select value \"([^\"]*)\" for Requested Type product in line \"([^\"]*)\"$")
    public void selectValueForRequestedTypeProductInLine(String requestedType, String lineIndex){
       allRequestsSteps.selectRequestedTypeForProductInLine(requestedType, lineIndex);
    }

    @Then("^Select Requested Sub Type value \"([^\"]*)\" for Product in line \"([^\"]*)\"$")
    public void selectRequestedSubTypeValueForProductInLine(String requestedSubType, String lineIndex) {
        allRequestsSteps.selectRequestedSubTypeForProductInLine(requestedSubType,lineIndex);
    }

    @Then("^Select Requested Action \"([^\"]*)\" for Product in line \"([^\"]*)\"$")
    public void selectRequestedActionForProductInLine(String requestedAction, String lineIndex) {
       allRequestsSteps.selectRequestedActionForProductInLine(requestedAction,lineIndex);
    }

    @Then("^Select Reason for Request \"([^\"]*)\" >> Requested Type \"([^\"]*)\" >> Requested Sub Type \"([^\"]*)\" for all products$")
    public void selectReasonForRequestRequestedTypeRequestedSubTypeForAllProducts(String reasonForRequest, String requestedType, String requestedSubType) throws Throwable {
        allRequestsSteps.selectReasonForRequestForAllProducts(reasonForRequest, requestedType, requestedSubType);
    }

    @Then("^Select Reason for Request \"([^\"]*)\" >> Requested Type \"([^\"]*)\" for all products$")
    public void selectReasonForRequestRequestedTypeForAllProducts(String reasonForRequest, String requestedType) {
        allRequestsSteps.selectReasonForRequestForAllProducts(reasonForRequest, requestedType);
    }

    @Then("^Select Reason for Request \"([^\"]*)\"$")
    public void selectReasonForRequest(String reasonForRequest)  {
        allRequestsSteps.selectReasonForRequestForAllProducts(reasonForRequest);
    }

    @Then("^Select Requested Action \"([^\"]*)\" for all products$")
    public void selectRequestedActionForAllProducts(String requestedAction) {
        allRequestsSteps.selectRequestedActionForAllProducts(requestedAction);
    }

    @And("^Enter Requested Qty value \"([^\"]*)\" for all products$")
    public void enterRequestedQtyValueForAllProducts(String requestedQty) {
        allRequestsSteps.enterRequestedQtyValueForAllProducts(requestedQty);
    }

    @And("^Search and Select products from invoices for return from file \"([^\"]*)\"$")
    public void searchAndSelectProductsFromInvoicesForReturnFromFile(String pathFile) throws IOException {
        allRequestsSteps.searchAndSelectProductsFromInvoicesForReturnFromFile(pathFile);
    }

    @When("^Select Invoice date range from \"([^\"]*)\" to \"([^\"]*)\"$")
    public void selectInvoiceDateRangeFromTo(String dateFrom, String dateTo) throws Throwable {
       allRequestsSteps.selectInvoiceDateRangeFromTo(dateFrom, dateTo);
    }

    @And("^Click on \"([^\"]*)\" button$")
    public void clickOnButton(String buttonName) {
        allRequestsSteps.clickOnButton(buttonName);
    }
}
