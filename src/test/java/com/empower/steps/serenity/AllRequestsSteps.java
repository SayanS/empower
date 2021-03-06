package com.empower.steps.serenity;

import com.empower.models.Invoice;
import com.empower.models.InvoiceLine;
import com.empower.pages.AllRequestsPage;
import com.empower.pages.Utils;
import com.esotericsoftware.yamlbeans.YamlException;
import com.esotericsoftware.yamlbeans.YamlReader;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonToken;
import com.fasterxml.jackson.core.type.TypeReference;
import net.thucydides.core.annotations.Step;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.junit.Assert;
import com.empower.pages.Utils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;

public class AllRequestsSteps {
    Utils utils;
    private AllRequestsPage allRequestsPage;
    private List<Invoice> expectedProductsForReturn = new ArrayList<>();
    private List<Invoice> invoicesForRequest = new ArrayList<>();
    private List<InvoiceLine> actualCatalogNamesLabelQty = new ArrayList<>();
    List<InvoiceLine> expectedInvoicesLines = new ArrayList<>();

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

        for (Invoice invoice : invoicesForRequest) {
            for (InvoiceLine invoiceLine : invoice.getLines()) {
                expectedInvoicesLines.add(new InvoiceLine(invoiceLine));
            }
        }
        Collections.sort(expectedInvoicesLines, new InvoiceLine());

        actualCatalogNamesLabelQty = allRequestsPage.getAllCatalogNameAndQtyLabelFromReasonForRequestStep();
        Collections.sort(actualCatalogNamesLabelQty, new InvoiceLine());

        for (int i = 0; i < expectedInvoicesLines.size() - 1; i++) {
            Assert.assertEquals("List of Products from Step 2 isn't equals to List on Step1 " + actualCatalogNamesLabelQty.get(i).getCatalogName() + " " + " " + expectedInvoicesLines.get(i).getCatalogName(), expectedInvoicesLines.get(i).getCatalogName(), actualCatalogNamesLabelQty.get(i).getCatalogName());
        }
    }

    @Step
    public void isAllQtyLabelOnReasonForRequestStepContainAppropriateValuesFromStep1() {
        List<String> actualUnitedCatalogNamesLabelQty = new ArrayList<>();
        List<String> expectedUnitedCatalogNamesLabelQty = new ArrayList<>();
        for (InvoiceLine invoiceLine : actualCatalogNamesLabelQty) {
            actualUnitedCatalogNamesLabelQty.add(invoiceLine.getCatalogName() + " " + invoiceLine.getLabelQty());
        }
        Collections.sort(actualUnitedCatalogNamesLabelQty);

        for (InvoiceLine invoiceLine : expectedInvoicesLines) {
            expectedUnitedCatalogNamesLabelQty.add(invoiceLine.getCatalogName() + " " + invoiceLine.getQty());
        }
        Collections.sort(expectedUnitedCatalogNamesLabelQty);

        for (int i = 0; i <= expectedInvoicesLines.size(); i++) {
            Assert.assertEquals("Qty from step 2 is mismatched to Qty from step 1 ", actualUnitedCatalogNamesLabelQty, expectedUnitedCatalogNamesLabelQty);

        }
    }

    @Step
    public void selectInvoicefromSearchResults(String lineNumber) {
        invoicesForRequest.add(new Invoice(allRequestsPage.selectInvoicefromSearchResults(lineNumber)));
    }

    @Step
    public void selectProductFromRequestedList(String index) {
        invoicesForRequest.get(invoicesForRequest.size() - 1).addInvoiceLine(allRequestsPage.selectProductFromRequestedList(index));
    }

    @Step
    public void selectLastProductFromRequestedList() {
        invoicesForRequest.get(invoicesForRequest.size() - 1).addInvoiceLine(allRequestsPage.selectLastProductFromRequestedList());
    }

    @Step
    public void selectAllProductFromRequestedList() {
        invoicesForRequest.get(invoicesForRequest.size() - 1).setLines(allRequestsPage.selectAllProductFromRequestedList());
    }

    @Step
    public void isInvoiceContains(String productName) {
        Assert.assertTrue("Invoice isn't contain " + productName + " product in " + allRequestsPage.getInvoiceProductsNames().toString(), allRequestsPage.getInvoiceProductsNames().contains(productName));
    }

    @Step
    public void selectFromReasonForRequestDropDownOfProductInLine(String reason, String index) {
        allRequestsPage.selectFromReasonForRequest(reason, index);
    }

    @Step
    public void selectRequestedTypeForProductInLine(String requestedType, String lineIndex) {
        allRequestsPage.selectRequestedTypeForProductInLine(requestedType, lineIndex);
    }

    @Step
    public void selectRequestedSubTypeForProductInLine(String requestedSubType, String lineIndex) {
        allRequestsPage.selectRequestedSubTypeForProductInLine(requestedSubType, lineIndex);
    }

    @Step
    public void selectRequestedActionForProductInLine(String requestedAction, String lineIndex) {
        allRequestsPage.selectRequestedActionForProductInLine(requestedAction, lineIndex);
    }

    @Step
    public void selectReasonForRequestForAllProducts(String reason, String requestedType, String requestedSubType) {
        for (Invoice invoice:invoicesForRequest) {
            for(InvoiceLine product:invoice.getLines()) {
                allRequestsPage.selectReasonForRequest(invoice.getNumber(),product.getCatalogName(),reason, requestedType, requestedSubType);
            }
        }
    }

    @Step
    public void selectReasonForRequestForAllProducts(String reason, String requestedType) {
        for (Invoice invoice:invoicesForRequest) {
            for(InvoiceLine product:invoice.getLines()) {
                allRequestsPage.selectReasonForRequest(invoice.getNumber(),product.getCatalogName(),reason, requestedType);
            }
        }
    }

    @Step
    public void selectReasonForRequestForAllProducts(String reason) {
        for (Invoice invoice:invoicesForRequest) {
            for(InvoiceLine product:invoice.getLines()) {
                allRequestsPage.selectReasonForRequest(invoice.getNumber(),product.getCatalogName(),reason);
            }
        }
    }

    @Step
    public void selectRequestedActionForAllProducts(String requestedAction) {
        for (Invoice invoice:invoicesForRequest) {
            for(InvoiceLine product:invoice.getLines()) {
                allRequestsPage.selectRequestedAction(invoice.getNumber(),product.getCatalogName(),requestedAction);
            }
        }
    }
    @Step
    public void enterRequestedQtyValueForAllProducts(String requestedQty) {
        for(Invoice invoice:invoicesForRequest){
            for(InvoiceLine product:invoice.getLines()){
                allRequestsPage.enterRequestedQty(invoice.getNumber(),product.getCatalogName(),requestedQty);
            }
        }
    }
    @Step
    public void searchAndSelectProductsFromInvoicesForReturnFromFile(String pathFile) throws IOException {
        //If type of the file ".yml"
        /*
        YamlReader reader = new YamlReader(new FileReader(pathFile));
        List<Invoice> invoice=new ArrayList<>();
        invoice = (List<Invoice>)reader.read();
        expectedProductsForReturn= (List<Invoice>) invoice;
        expectedProductsForReturn.get(2).getLines().get(2).getCatalogName();
        */
        //If type of the file ".json"
        ObjectMapper mapper = new ObjectMapper();
        List<Invoice> invoice=new ArrayList<>();
        invoice = mapper.readValue(new File(pathFile), new TypeReference<List<Invoice>>() {});
    }
    @Step
    public void selectInvoiceDateRangeFromTo(String dateFrom, String dateTo) throws ParseException {
        allRequestsPage.selectDateRangeFilter(dateFrom, dateTo);
    }
    @Step
    public void clickOnButton(String buttonName) {
        allRequestsPage.clickOnButton(buttonName);
    }

    @Step
    public void isAllInvoicesInSearchResultsFromDateRange(String fromDate, String toDate) throws ParseException {
        String format="MM-dd-yyyy";
        for(Invoice invoice:allRequestsPage.getAllInvoicesFromSearchResults()){
            Assert.assertTrue("The date "+invoice.getDate()+" of Invoice № "+invoice.getNumber()+" is lower then expected fromDate "+fromDate,
                              utils.stringToDate(format, invoice.getDate()).getTime().after(utils.stringToDate(format, fromDate).getTime()));

            Assert.assertTrue("The date "+invoice.getDate()+" of Invoice № "+invoice.getNumber()+" is bigger then expected toDate "+toDate+"/n",
                    utils.stringToDate(format, invoice.getDate()).getTime().before(utils.stringToDate(format, toDate).getTime()));
        }
    }
    @Step
    public void isAmountOfInvoicesEqualToTotalSearchResults() {
        Assert.assertEquals(allRequestsPage.getAmountOfInvoicesInSearchResults(),allRequestsPage.getTotalSearchResultsValue());
    }
    @Step
    public void isOptionSelectedFromRangeInput(String rangeInputName, String optionName) {
        Assert.assertEquals(optionName,allRequestsPage.getSelectedOptionOfRangeInput(rangeInputName));
    }
}
