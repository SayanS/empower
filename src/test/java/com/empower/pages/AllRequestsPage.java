package com.empower.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.security.PrivateKey;
import java.util.List;

public class AllRequestsPage extends PageObject {
    private String CREATE_REQUEST_BUTTON = ".//button[@id='create_request']";
    private String SEARCH_BY_DROP_DOWN = ".//div[@class='input-group-addon']";
    private String SEARCH_FIELD = ".//input[@name='value']";
    private String GO_BUTTON = ".//button[@id='spa-rev-filter-go-button']";
    private String TOP_NEXT_BUTTON = "(.//button[contains(text(),'Next')])[1]";
    private String BOTOM_NEXT_BUTTON = "(.//button[contains(text(),'Next')])[2]";
    private String ALL_ARROW_ICON = "(//table[@id='return-invoice-table']/tbody/tr/td/i)";
    private String ALL_PRODUCT_LIST_FOR_INVOICES_CHECKBOXES = "(.//tbody/tr//label[@class='myCheckbox'])";

    public void clickOnCreateRequestButton() {
        Actions actions = new Actions(getDriver());
        (new WebDriverWait(getDriver(), 10000)).until(ExpectedConditions.visibilityOfElementLocated(By.xpath(CREATE_REQUEST_BUTTON)));
        actions.moveToElement(getDriver().findElement(By.xpath(CREATE_REQUEST_BUTTON)));
        $(CREATE_REQUEST_BUTTON).click();
    }

    public void searchForValueBy(String value, String searchBy) {
        (new WebDriverWait(getDriver(), 5000)).until(ExpectedConditions.elementToBeClickable(org.openqa.selenium.By.xpath(SEARCH_BY_DROP_DOWN)));
        $(SEARCH_BY_DROP_DOWN).click();
        //(new Actions(getDriver())).moveToElement(getDriver().findElement(org.openqa.selenium.By.ByTagName.xpath(".//ul/li[.='"+searchBy+"']")));
        findBy(".//ul/li[.='"+searchBy+"']").click();
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

    public void addToProductListForInvoiceNoLines(String lineNumbers) {
        (new WebDriverWait(getDriver(),10000)).until(ExpectedConditions.presenceOfElementLocated(org.openqa.selenium.By.xpath(ALL_ARROW_ICON + "[" + lineNumbers + "]")));
        (new Actions(getDriver())).moveToElement(findBy(ALL_ARROW_ICON + "[" + lineNumbers + "]"));
        ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", $(ALL_ARROW_ICON + "[" + lineNumbers + "]"));
        $(ALL_ARROW_ICON + "[" + lineNumbers + "]").click();
    }

    public void selectLinesFromProductListForInvoiceNo(List<String> linesNumbers) {
        for (String lineNumber : linesNumbers) {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView();", $(ALL_PRODUCT_LIST_FOR_INVOICES_CHECKBOXES + "[" + lineNumber + "]"));
            $(ALL_PRODUCT_LIST_FOR_INVOICES_CHECKBOXES + "[" + lineNumber + "]").click();

        }
    }
}
