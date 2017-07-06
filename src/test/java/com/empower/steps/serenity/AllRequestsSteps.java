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
    public void isColorOfArrowIconInLine(String expectedColor, String line) {
            Assert.assertEquals("The color of Arrow icon isn't " + expectedColor + " in line " + line, expectedColor, allRequestsPage.getColorOfArrowIcon(line));
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
        Integer lineNumber=1;
        for(Invoice invoice:invoicesForRequest) {
            for(InvoiceLine invoiceLine:invoice.getLines()) {
                Assert.assertEquals("Qty from step 2 is mismatched to Qty from step 1 in line "+lineNumber, invoiceLine.getQty(), allRequestsPage.getQtyLabelFromStep2(lineNumber));
                lineNumber++;
            }
        }
    }

    @Step
    public void selectInvoicefromSearchResults(String lineNumber) {
        invoicesForRequest.add(new Invoice(allRequestsPage.selectInvoicefromSearchResults(lineNumber)));
    }
    @Step
    public void selectProductFromRequestedList(String index) {
        invoicesForRequest.get(invoicesForRequest.size()-1).addInvoiceLine(allRequestsPage.selectProductFromRequestedList(index));
    }
    @Step
    public void selectLastProductFromRequestedList() {
        invoicesForRequest.get(invoicesForRequest.size()-1).addInvoiceLine(allRequestsPage.selectLastProductFromRequestedList());
    }

    @Step
    public void selectAllProductFromRequestedList() {
        invoicesForRequest.get(invoicesForRequest.size()-1).setLines(allRequestsPage.selectAllProductFromRequestedList());
    }
    @Step
    public void isInvoiceContains(String productName) {
        Assert.assertTrue("Invoice isn't contain "+productName+" product in "+ allRequestsPage.getInvoiceProductsNames().toString(),allRequestsPage.getInvoiceProductsNames().contains(productName));
    }
}
