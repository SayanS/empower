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

public class AllRequestsPage extends CustomPageObject{
    private Utils utils;

    private String CREATE_REQUEST_BUTTON = ".//button[@id='create_request']";
    private String SEARCH_BY_DROP_DOWN = ".//div[@class='input-group-addon']";
    private String SEARCH_FIELD = ".//input[@name='value']";
    private String GO_BUTTON = ".//button[@id='spa-rev-filter-go-button']";
    private String TOP_NEXT_BUTTON = "(.//button[contains(text(),'Next')])[1]";
    private String BOTOM_NEXT_BUTTON = "(.//button[contains(text(),'Next')])[2]";
    private String ALL_ARROW_ICON = "(//table[@id='return-invoice-table']/tbody/tr/td/i)";
    private String STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES = "(.//tbody/tr//label[contains(@class,'myCheckbox')])";
    private String STEP_1_ALL_NAMES_OF_PRODUCT_LIST_FOR_INVOICES = "(.//table[@id='return-invoice-line-table']/tbody/tr/td[3])";
    private String STEP_2_ALL_CATALOG = "(.//table[@id='returnTrackingTableStep2']/tbody/tr/td[1])";
    private String STEP_2_REASON_FOR_REQUEST_DROPDOWN="(.//td[@class='reason-request-col']//div[@data-toggle='dropdown'])";
    private String STEP_2_REQUEST_ACTION_DROPDOWN="(.//td[@class='request-action-col']//select)";


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
        (new WebDriverWait(getDriver(), 10)).until(ExpectedConditions.presenceOfElementLocated(By.xpath(".//*[@id='return-invoice-table']/tbody/tr[1]/td[1]")));
    }

    public WebElementFacade getTopNextButton() {
        return $(TOP_NEXT_BUTTON);
    }

    public WebElementFacade getBottomNextButton() {
        return $(BOTOM_NEXT_BUTTON);
    }

    public Invoice selectInvoicefromSearchResults(String lineNumber) {
        Invoice invoice = new Invoice();
        waitABit(5000);
        ((JavascriptExecutor)getDriver()).executeScript("scroll(0,-10000);");
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
      // (new WebDriverWait(getDriver(),20)).until(ExpectedConditions.presenceOfElementLocated(By.xpath("(.//input[@class='invoice-line-check-box'])[1]")));
        waitABit(5000);
        return $(ALL_ARROW_ICON + "[" + line + "]").getCssValue("color");
    }

    public void clickOnTopNextButton() {
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(TOP_NEXT_BUTTON)));
        $(TOP_NEXT_BUTTON).click();
    }

    public List<InvoiceLine> getAllCatalogNameAndQtyLabelFromReasonForRequestStep() {
        List<InvoiceLine> catalogNames = new ArrayList<>();
        for (int i = 1; i <= getDriver().findElements(By.xpath(STEP_2_ALL_CATALOG)).size() ; i++) {
            catalogNames.add(new InvoiceLine());
            catalogNames.get(i-1).setCatalogName(findBy(STEP_2_ALL_CATALOG + "[" + i + "]").getText());
            catalogNames.get(i-1).setLabelQty(findBy("(.//table[@id='returnTrackingTableStep2']//span[contains(@class,'reason-qty-text')])" + "[" + i + "]").getText().replace("of ", ""));
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
        (new WebDriverWait(getDriver(),100)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(.//tbody/tr//td[contains(@class,'line-number')])[1]")));
        for (int i = 1; i <= findAll(STEP_1_ALL_CHECKBOXES_OF_PRODUCT_LIST_FOR_INVOICES).size(); i++) {
            invoiceLines.add(selectProductFromRequestedList(Integer.toString(i)));
        }
        return invoiceLines;
    }

    public List<String> getInvoiceProductsNames() {
        return utils.getTextFromList(findAll(STEP_1_ALL_NAMES_OF_PRODUCT_LIST_FOR_INVOICES));
    }


    public void selectFromReasonForRequest(String reason, String index) {
        $(STEP_2_REASON_FOR_REQUEST_DROPDOWN+"["+index+"]").click();
        moveTo("(//ul[@class='return-type-dropdown-list'])[1]//li/a[.='"+reason+"']").click();
    }

    public void selectRequestedTypeForProductInLine(String requestedType, String lineIndex) {
        moveTo("(//ul[@class='return-type-dropdown-list'])[1]//li/a[.='"+requestedType+"']"+"["+lineIndex+"]").click();
    }

    public void selectRequestedSubTypeForProductInLine(String requestedSubType, String lineIndex) {
        moveTo("(//ul[@class='return-type-dropdown-list'])[1]//li/a[.='"+requestedSubType+"']"+"["+lineIndex+"]").click();
    }

    public void selectRequestedActionForProductInLine(String requestedAction, String lineIndex) {

    }

    public Integer getAmountOfProductsStep_2() {
        return findAll("//td[@class='invoice-number']").size();
    }


    public void selectReasonForRequestForProductInLine(Integer line, String reasonForRequest, String requestedType, String requestedSubType) {

        $(STEP_2_REASON_FOR_REQUEST_DROPDOWN+"["+line+"]").click();

        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(By.xpath("(.//td[@class='reason-request-col']//ul/li/a[.='"+reasonForRequest+"'])["+line+"]")));
        moveTo("(.//td[@class='reason-request-col']//ul/li/a[.='"+reasonForRequest+"'])["+line+"]").click();

        moveTo("(.//td[@class='reason-request-col']//ul/li/a[.='Defective'])["+line+"]/following-sibling::div/ul/li[1]");
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(By.xpath("(.//td[@class='reason-request-col']//ul/li/a[.='"+requestedType+"'])["+line+"]")));
        moveTo("(.//td[@class='reason-request-col']//ul/li/a[.='"+requestedType+"'])["+line+"]").click();

        moveTo("((.//*[@id='returnTrackingTableStep2']/tbody//tr)[1]//a[@data-name='"+reasonForRequest+"']/ancestor::li//a[@data-name='"+requestedType+"']/ancestor::li[1]//a[@name='subtype'])["+line+"]");
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(By.xpath("(.//td//p[.='Request Sub Type']/ancestor::div/ul/li/a[.='"+requestedType+"'])["+line+"]/following-sibling::div/ul/li/a[.='"+requestedSubType+"']")));
        moveTo("(.//td//p[.='Request Sub Type']/ancestor::div/ul/li/a[.='"+requestedType+"'])["+line+"]/following-sibling::div/ul/li/a[.='"+requestedSubType+"']").click();
    }

    public void selectReasonForRequestForProductInLine(Integer line, String reasonForRequest, String requestedType) {
        ((JavascriptExecutor)getDriver()).executeScript("scroll(0,-10000);");
        $(STEP_2_REASON_FOR_REQUEST_DROPDOWN+"["+line+"]").click();

        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(By.xpath("(.//td[@class='reason-request-col']//ul/li/a[.='"+reasonForRequest+"'])["+line+"]")));
        moveTo("(.//td[@class='reason-request-col']//ul/li/a[.='"+reasonForRequest+"'])["+line+"]").click();

        moveTo("(.//td[@class='reason-request-col']//ul/li/a[.='Defective'])["+line+"]/following-sibling::div/ul/li[1]");
        ((JavascriptExecutor)getDriver()).executeScript("arguments[0].scrollIntoView(true);", getDriver().findElement(By.xpath("(.//td[@class='reason-request-col']//ul/li/a[.='"+requestedType+"'])["+line+"]")));
        moveTo("(.//td[@class='reason-request-col']//ul/li/a[.='"+requestedType+"'])["+line+"]").click();
    }

}
