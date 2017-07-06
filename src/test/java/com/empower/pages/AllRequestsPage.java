package com.empower.pages;

import com.empower.models.Invoice;
import com.empower.models.InvoiceLine;
import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class AllRequestsPage extends PageObject {


    private String CREATE_REQUEST_BUTTON = ".//button[@id='create_request']";
    private String SEARCH_BY_DROP_DOWN = ".//div[@class='input-group-addon']";
    private String SEARCH_FIELD = ".//input[@name='value']";
    private String GO_BUTTON = ".//button[@id='spa-rev-filter-go-button']";
    private String TOP_NEXT_BUTTON = "(.//button[contains(text(),'Next')])[1]";
    private String BOTOM_NEXT_BUTTON = "(.//button[contains(text(),'Next')])[2]";
    private String ALL_ARROW_ICON = "(//table[@id='return-invoice-table']/tbody/tr/td/i)";
    private String STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES = "(.//tbody/tr//label[contains(@class,'myCheckbox')])";
    private String STEP_1_ALL_NAMES_OF_PRODUCT_LIST_FOR_INVOICES = "(.//table[@id='return-invoice-line-table']/tbody/tr/td[3])";
    private String STEP_2_ALL_CATALOG = ".//table[@id='returnTrackingTableStep2']/tbody/tr/td[1]";
    private String STEP_1_ALL_QTY_OF_PRODUCT_LIST_FOR_INVOICES = "(.//table[@id='return-invoice-line-table']/tbody/tr/td[4])";


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
        $(GO_BUTTON).click();

    }

    public WebElementFacade getTopNextButton() {
        return $(TOP_NEXT_BUTTON);
    }

    public WebElementFacade getBottomNextButton() {
        return $(BOTOM_NEXT_BUTTON);
    }

    public Invoice selectInvoicefromSearchResults(String lineNumber) {
        Invoice invoice = new Invoice();
        (new WebDriverWait(getDriver(), 10000)).until(ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath(ALL_ARROW_ICON + "[" + lineNumber + "]")));
        (new Actions(getDriver())).moveToElement(findBy(ALL_ARROW_ICON + "[" + lineNumber + "]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", $(ALL_ARROW_ICON + "[" + lineNumber + "]"));
        $(ALL_ARROW_ICON + "[" + lineNumber + "]").click();

        invoice.setNumber($("(.//table[@id='return-invoice-table']//tr/td[1])" + "[" + lineNumber + "]").getText());
        invoice.setDate($("(.//table[@id='return-invoice-table']//tr/td[2])" + "[" + lineNumber + "]").getText());
        invoice.setPoNumber($("(.//table[@id='return-invoice-table']//tr/td[3])" + "[" + lineNumber + "]").getText());
        invoice.setGeSalesOrder($("(.//table[@id='return-invoice-table']//tr/td[4])" + "[" + lineNumber + "]").getText());
        invoice.setCheckedForRequest(true);
        return invoice;
    }


    public String getColorOfArrowIcon(String line) {
        return $(ALL_ARROW_ICON + "[" + line + "]").getCssValue("color");
    }

    public void clickOnTopNextButton() {
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOP_NEXT_BUTTON)));
        $(TOP_NEXT_BUTTON).click();
    }

    public List<String> getAllCatalogNameFromReasonForRequestStep() {
        List<String> catalogNames = new ArrayList<>();
        for (WebElement catalogName : getDriver().findElements(By.xpath(STEP_2_ALL_CATALOG))) {
            catalogNames.add(catalogName.getText());
        }
        return catalogNames;
    }

    public String getQtyLabelFromStep2(Integer lineNumber) {
        return  getDriver().findElement(By.xpath("(.//table[@id='returnTrackingTableStep2']//span[contains(@class,'reason-qty-text')])"+"["+lineNumber+"]")).getText().replace("of ", "");
    }

    public InvoiceLine selectProductFromRequestedList(String index) {
        InvoiceLine invoiceLine=new InvoiceLine();
        (new WebDriverWait(getDriver(),5000)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@id='FullScreenProgressIndicatorModalDialog']//img[contains(@src,'ajax-loader.gif')]")));
        (new WebDriverWait(getDriver(),5000)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@id='FullScreenProgressIndicatorModalDialog']//img[contains(@src,'ajax-loader.gif')]")));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", $(STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES+"["+index+"]"));
        $(STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES+"["+index+"]").click();
        invoiceLine.setCatalogName($("(.//table[@id='return-invoice-line-table']/tbody/tr/td[3])"+"["+index+"]").getText());
        invoiceLine.setQty($("(.//table[@id='return-invoice-line-table']/tbody/tr/td[4])"+"["+index+"]").getText());
        invoiceLine.setReturnable($("(.//table[@id='return-invoice-line-table']/tbody/tr/td[5])"+"["+index+"]").getText());
        invoiceLine.setCheckedForRequest(true);

        return invoiceLine;
    }

    public InvoiceLine selectLastProductFromRequestedList() {
        return selectProductFromRequestedList(Integer.toString(findAll(STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES).size()));
    }

    public List<InvoiceLine> selectAllProductFromRequestedList() {
        List<InvoiceLine> invoiceLines=new ArrayList<>();
        for(int i=1;i<=findAll(STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES).size();i++) {
            invoiceLines.add(selectProductFromRequestedList(Integer.toString(i)));
        }
        return invoiceLines;
    }

    public List<String> getInvoiceProductsNames() {
        return (new Utils()).getTextFromList(findAll(STEP_1_ALL_NAMES_OF_PRODUCT_LIST_FOR_INVOICES));
    }
}
