package com.empower.pages;

import com.empower.models.Invoice;
import com.empower.models.InvoiceLine;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class AllRequestsPage extends CustomPageObject {
    private Utils utils;

    private String CREATE_REQUEST_BUTTON = ".//button[@id='create_request']";
    private String SEARCH_BY_DROP_DOWN = ".//div[@class='input-group-addon']";
    private String SEARCH_FIELD = ".//input[@name='value']";
    private String GO_BUTTON = ".//button[@id='spa-rev-filter-go-button']";
    private String TOP_NEXT_BUTTON = "(.//section[@class=\"main-content-section create-return-content-section\"]/div//button[contains(text(),'Next')])[1]";
    private String BOTOM_NEXT_BUTTON = "(.//section[@class=\"main-content-section create-return-content-section\"]/div//button[contains(text(),'Next')])[2]";
    private String ALL_ARROW_ICON = "(//table[@id='return-invoice-table']/tbody/tr/td/i)";
    private String STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES = "(.//tbody/tr//label[contains(@class,'myCheckbox')])";
    private String STEP_1_ALL_NAMES_OF_PRODUCT_LIST_FOR_INVOICES = "(.//table[@id='return-invoice-line-table']/tbody/tr/td[3])";
    private String STEP_2_ALL_CATALOG = "(.//table[@id='returnTrackingTableStep2']/tbody/tr/td[1])";
    private String STEP_2_REASON_FOR_REQUEST_DROPDOWN = "(.//td[@class='reason-request-col']//div[@data-toggle='dropdown'])";
    private String STEP_2_REQUEST_ACTION_DROPDOWN = "(.//td[@class='request-action-col']//select)";
    private String REQUESTED_ACTION_DROPDOWN = ".//input[@name='invoiceNumber' and contains(@value,'$invoice')]/ancestor::td[contains(text(),'$product')]/following-sibling::td/div[@class='return-type']";
    private String REQUESTED_ACTION_DROPDOWN_VALUE = "//ul[@class='select2-results__options']/li[.='$requestedAction']";
    private String STEP_2_NEW_REQUEST_LINE = ".//input[@name='invoiceNumber' and contains(@value,'$invoice')]/ancestor::td[contains(text(),'$product')]/ancestor::tr";


    public void clickOnCreateRequestButton() {
        Actions actions = new Actions(getDriver());
        (new WebDriverWait(getDriver(), 10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_REQUEST_BUTTON)));
        actions.moveToElement(getDriver().findElement(By.xpath(CREATE_REQUEST_BUTTON)));
        $(CREATE_REQUEST_BUTTON).click();
    }

    public void searchForValueBy(String value, String searchBy) {
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.elementToBeClickable(org.openqa.selenium.By.xpath(SEARCH_BY_DROP_DOWN)));
        $(SEARCH_BY_DROP_DOWN).click();
        findBy(".//ul/li[.='" + searchBy + "']").click();
        $(SEARCH_FIELD).clear();
        $(SEARCH_FIELD).sendKeys(value);
    }

    public WebElementFacade getTopNextButton() {
        return $(TOP_NEXT_BUTTON);
    }

    public WebElementFacade getBottomNextButton() {
        return $(BOTOM_NEXT_BUTTON);
    }

    public Invoice selectInvoicefromSearchResults(String lineNumber) {
        Invoice invoice = new Invoice();
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='return-invoice-table']/tbody/tr[1]/td[1]")));
        ((JavascriptExecutor) getDriver()).executeScript("scroll(0,-10000);");
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.elementToBeClickable(org.openqa.selenium.By.xpath(ALL_ARROW_ICON + "[" + lineNumber + "]")));
        (new Actions(getDriver())).moveToElement(findBy(ALL_ARROW_ICON + "[" + lineNumber + "]"));
        $(ALL_ARROW_ICON + "[" + lineNumber + "]").click();

        invoice.setNumber($("(.//table[@id='return-invoice-table']//tr/td[1])" + "[" + lineNumber + "]").getText());
        invoice.setDate($("(.//table[@id='return-invoice-table']//tr/td[2])" + "[" + lineNumber + "]").getText());
        invoice.setPoNumber($("(.//table[@id='return-invoice-table']//tr/td[3])" + "[" + lineNumber + "]").getText());
        invoice.setGeSalesOrder($("(.//table[@id='return-invoice-table']//tr/td[4])" + "[" + lineNumber + "]").getText());
        invoice.setCheckedForRequest(true);
        return invoice;
    }


    public String getColorOfArrowIcon(String line) {
        waitABit(5000);
        return $(ALL_ARROW_ICON + "[" + line + "]").getCssValue("color");
    }

    public void clickOnTopNextButton() {
        (new WebDriverWait(getDriver(), 5)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(TOP_NEXT_BUTTON)));
        $(TOP_NEXT_BUTTON).click();
    }

    public List<InvoiceLine> getAllCatalogNameAndQtyLabelFromReasonForRequestStep() {
        List<InvoiceLine> catalogNames = new ArrayList<>();
        for (int i = 1; i <= getDriver().findElements(By.xpath(STEP_2_ALL_CATALOG)).size(); i++) {
            catalogNames.add(new InvoiceLine());
            catalogNames.get(i - 1).setCatalogName(findBy(STEP_2_ALL_CATALOG + "[" + i + "]").getText());
            catalogNames.get(i - 1).setLabelQty(findBy("(.//table[@id='returnTrackingTableStep2']//span[contains(@class,'reason-qty-text')])" + "[" + i + "]").getText().replace("of ", ""));
        }
        return catalogNames;
    }

    public String getQtyLabelFromStep2(Integer lineNumber) {
        return getDriver().findElement(By.xpath("(.//table[@id='returnTrackingTableStep2']//span[contains(@class,'reason-qty-text')])" + "[" + lineNumber + "]")).getText().replace("of ", "");
    }

    public InvoiceLine selectProductFromRequestedList(String index) {
        InvoiceLine invoiceLine = new InvoiceLine();
        utils.waitInvisabilityOfSpinner();
        ((JavascriptExecutor) getDriver()).executeScript("scroll(0,-1000)");
        $(STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES + "[" + index + "]").click();
        invoiceLine.setCatalogName($("(.//table[@id='return-invoice-line-table']/tbody/tr/td[3])" + "[" + index + "]").getText());
        invoiceLine.setQty($("(.//table[@id='return-invoice-line-table']/tbody/tr/td[4])" + "[" + index + "]").getText());
        invoiceLine.setReturnable($("(.//table[@id='return-invoice-line-table']/tbody/tr/td[5])" + "[" + index + "]").getText());
        invoiceLine.setCheckedForRequest(true);

        return invoiceLine;
    }

    public InvoiceLine selectLastProductFromRequestedList() {
        return selectProductFromRequestedList(Integer.toString(findAll(STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES).size()));
    }

    public List<InvoiceLine> selectAllProductFromRequestedList() {
        List<InvoiceLine> invoiceLines = new ArrayList<>();
        (new WebDriverWait(getDriver(), 100)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//tbody/tr//td[contains(@class,'line-number')])[1]")));
        for (int i = 1; i <= findAll(STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES).size(); i++) {
            invoiceLines.add(selectProductFromRequestedList(Integer.toString(i)));
        }
        return invoiceLines;
    }

    public List<String> getInvoiceProductsNames() {
        return utils.getTextFromList(findAll(STEP_1_ALL_NAMES_OF_PRODUCT_LIST_FOR_INVOICES));
    }


    public void selectFromReasonForRequest(String reason, String index) {
        $(STEP_2_REASON_FOR_REQUEST_DROPDOWN + "[" + index + "]").click();
        moveTo("(//ul[@class='return-type-dropdown-list'])[1]//li/a[.='" + reason + "']").click();
    }

    public void selectRequestedTypeForProductInLine(String requestedType, String lineIndex) {
        moveTo("(//ul[@class='return-type-dropdown-list'])[1]//li/a[.='" + requestedType + "']" + "[" + lineIndex + "]").click();
    }

    public void selectRequestedSubTypeForProductInLine(String requestedSubType, String lineIndex) {
        moveTo("(//ul[@class='return-type-dropdown-list'])[1]//li/a[.='" + requestedSubType + "']" + "[" + lineIndex + "]").click();
    }

    public void selectRequestedActionForProductInLine(String requestedAction, String lineIndex) {

    }

    public Integer getAmountOfProductsStep_2() {
        return findAll("//td[@class='invoice-number']").size();
    }


    private String getXpathOfNewRequestLine(String invoice, String product) {
        List<WebElementFacade> catalogNumberColumn = new ArrayList<>();
        List<String> productsName = new ArrayList<>();
        Integer line = 1;
        catalogNumberColumn = findAll(".//input[@name='invoiceNumber' and contains(@value,'" + invoice + "')]/ancestor::td[contains(text(),'" + product + "')]");
        productsName = utils.getTextFromList(catalogNumberColumn);
        for (String s : productsName) {
            if (s.equals(product)) {
                return "(" + STEP_2_NEW_REQUEST_LINE.replace("$invoice", invoice).replace("$product", product) + ")[" + line + "]";
            }
            line++;
        }
        return null;
    }

    public String selectReasonForRequest(String invoice, String product, String reason, String requestedType, String requestedSubType) {
        String xpathOfNewRequestLine = selectReasonForRequest(invoice, product, reason, requestedType);
        scrollIntoView(xpathOfNewRequestLine + "//ul/li/a[.='" + requestedSubType + "']");
        moveTo(xpathOfNewRequestLine + "//ul/li/a[.='" + requestedSubType + "']").click();
        waitElementToBeClickable(xpathOfNewRequestLine);
        return xpathOfNewRequestLine;
    }

    public String selectReasonForRequest(String invoice, String product, String reason, String requestedType) {
        String xpathOfNewRequestLine = selectReasonForRequest(invoice, product, reason);
        moveTo(xpathOfNewRequestLine + "//a[@data-name='" + reason + "']/following-sibling::div/ul/li[1]/a");
        scrollIntoView(xpathOfNewRequestLine + "//a[@data-name='" + reason + "']/following-sibling::div/ul/li/a[.='" + requestedType + "']");
        moveTo(xpathOfNewRequestLine + "//a[@data-name='" + reason + "']/following-sibling::div/ul/li/a[.='" + requestedType + "']").click();
        waitElementToBeClickable(xpathOfNewRequestLine);
        return xpathOfNewRequestLine;
    }

    public String selectReasonForRequest(String invoice, String product, String reason) {
        String xpathOfNewRequestLine = getXpathOfNewRequestLine(invoice, product);
        scrollIntoView(xpathOfNewRequestLine + "/td[@class='reason-request-col']/div");
        $(xpathOfNewRequestLine + "/td[@class='reason-request-col']/div").click();
        scrollIntoView(xpathOfNewRequestLine + "/td[@class='reason-request-col']/div//a[@data-type='reason' and .='" + reason + "']");
        moveTo(xpathOfNewRequestLine + "/td[@class='reason-request-col']/div//a[@data-type='reason' and .='" + reason + "']").click();
        return xpathOfNewRequestLine + "/td[@class='reason-request-col']/div";
    }

    public void selectRequestedAction(String invoice, String product, String requestedAction) {
        String xpathOfNewRequestLine = getXpathOfNewRequestLine(invoice, product);
        scrollIntoView(xpathOfNewRequestLine + "/td[@class='request-action-col']/div[@class='return-type']");
        moveTo(xpathOfNewRequestLine + "/td[@class='request-action-col']/div[@class='return-type']").click();
        moveTo(REQUESTED_ACTION_DROPDOWN_VALUE.replace("$requestedAction", requestedAction)).click();
    }

    public void enterRequestedQty(String invoice, String product, String requestedQty) {
        String xpathOfNewRequestLine = getXpathOfNewRequestLine(invoice, product);
        scrollIntoView(xpathOfNewRequestLine + "/td[@class='request-action-col']/div[@class='return-qty-col']");
        $(xpathOfNewRequestLine + "//input[@class='form-control qty-input-val done']").type(requestedQty);
    }

    public void selectInvoiceDateRangeFromTo(String dateFrom, String dateTo) throws ParseException {
        String NEXT_YEAR_BUTTON = ".//div[@class='datepicker-months']/table/thead/tr/th[@class='next']";
        String PREV_YEAR_BUTTON = ".//div[@class='datepicker-months']/table/thead/tr/th[@class='prev']";
        String DATE_PICKER_BUTTON = ".//div[@class='datepicker-days']/table/thead/tr/th[@class='datepicker-switch']";
        String DATE_PICKER_MONTHS_BUTTON = ".//div[@class='datepicker-months']/table/thead/tr/th[@class='datepicker-switch']";
        String MONTH_PICKERS = "(.//div[@class='datepicker-months']/table/tbody/tr/td/span)";
        String DAY_PICKERS = "(.//div[@class='datepicker-days']/table/tbody/tr/td[@class='day'])";
        String INVOICE_DATE_FROM_FIELD = "(.//div[@class='input-group date datetimepicker']/a)[1]";
        String INVOICE_DATE_TO_FIELD = "(.//div[@class='input-group date datetimepicker']/a)[2]";

        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = dateFormat.parse(dateFrom);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        $(INVOICE_DATE_FROM_FIELD).click();
        $(DATE_PICKER_BUTTON).click();
        while (Integer.valueOf($(DATE_PICKER_MONTHS_BUTTON).getText()) != cal.get(Calendar.YEAR)) {
            if (cal.get(Calendar.YEAR) > Integer.valueOf($(DATE_PICKER_MONTHS_BUTTON).getText())) {
                $(NEXT_YEAR_BUTTON).click();
            } else {
                $(PREV_YEAR_BUTTON).click();
            }
        }
        $(MONTH_PICKERS + "[" + cal.get(Calendar.MONTH + 1) + "]").click();
        $(DAY_PICKERS + "[" + cal.get(Calendar.DAY_OF_MONTH) + "]").click();

        date = dateFormat.parse(dateTo);
        cal = Calendar.getInstance();
        cal.setTime(date);
        $(INVOICE_DATE_TO_FIELD).click();
        $(DATE_PICKER_BUTTON).click();
        while (Integer.valueOf($(DATE_PICKER_MONTHS_BUTTON).getText()) != cal.get(Calendar.YEAR)) {
            if (cal.get(Calendar.YEAR) > Integer.valueOf($(DATE_PICKER_MONTHS_BUTTON).getText())) {
                $(NEXT_YEAR_BUTTON).click();
            } else {
                $(PREV_YEAR_BUTTON).click();
            }
        }
        $(MONTH_PICKERS + "[" + cal.get(Calendar.MONTH + 1) + "]").click();
        $(DAY_PICKERS + "[" + cal.get(Calendar.DAY_OF_MONTH) + "]").click();
    }

}
