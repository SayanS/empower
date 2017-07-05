package com.empower.steps.serenity;

import com.empower.models.Invoice;
import com.empower.models.InvoiceLine;
import com.empower.pages.AllRequestsPage;
import net.thucydides.core.annotations.Step;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class AllRequestsSteps {
    private AllRequestsPage allRequestsPage;
    private List<Invoice> invoicesForRequest = new ArrayList<>();

    @Step
    public void clickOnCreateRequestButton() {
        allRequestsPage.clickOnCreateRequestButton();
    }

    @Step
    public void searchForValueBy(String value, String searchBy) {
        allRequestsPage.searchForValueBy(value, searchBy);
    }

    @Step
    public void isAllNextButtonInactive() {
        Assert.assertFalse("TOP Next button isn't inactive", allRequestsPage.getTopNextButton().isEnabled());
        Assert.assertFalse("Bottom Next button isn't inactive", allRequestsPage.getBottomNextButton().isEnabled());
    }

    @Step
    public void isColorOfArrowIconInLines(String expectedColor, String lines) {
            Assert.assertEquals("The color of Arrow icon isn't " + expectedColor + " in line " + lines, expectedColor, allRequestsPage.getColorOfArrowIcon(lines));
    }

    @Step
    public void isAllNextButtonActive() {
        Assert.assertTrue("TOP Next button isn't active", allRequestsPage.getTopNextButton().isEnabled());
        Assert.assertTrue("Bottom Next button isn't active", allRequestsPage.getBottomNextButton().isEnabled());
    }

    @Step
    public void clickOnTopNextButton() {
        allRequestsPage.clickOnTopNextButton();
    }

    @Step
    public void isReasonForRequestStepContainAllCatalogFromFirstStep() {
        List<String> expectedCatalogName = new ArrayList<>();
        for (Invoice invoice : invoicesForRequest) {
            for (InvoiceLine invoiceLine : invoice.getLines()) {
                expectedCatalogName.add(invoiceLine.getCatalogName());
            }
        }
        Assert.assertEquals(expectedCatalogName, allRequestsPage.getAllCatalogNameFromReasonForRequestStep());
    }

    @Step
    public void isAllQtyLabelOnReasonForRequestStepContainAppropriateValuesFromStep1() {
        // Assert.assertEquals(selectedProductQtyFromStep_1, allRequestsPage.getAllQtyFromQtyLabelStep_2());
    }

    @Step
    public void selectInvoicefromSearchResults(String lineNumber) {
        Invoice invoice = new Invoice();
        invoice = allRequestsPage.selectInvoicefromSearchResults(lineNumber);
        invoicesForRequest.add(invoice);
    }
    @Step
    public void selectFirstProductFromRequestedList() {
        allRequestsPage.selectFirstProductFromRequestedList();
    }
    @Step
    public void selectLastProductFromRequestedList() {
        allRequestsPage.selectLastProductFromRequestedList();
    }
}
