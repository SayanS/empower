package com.empower.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.util.Calendar;

public class CustomPageObject extends PageObject{
    Utils utils;

    public WebElementFacade scrollIntoView(String xpath){
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", $(xpath));
        }catch(Exception e){
            return null;
        }
        return $(xpath);
    }

    public WebElementFacade scrollIntoView(WebElementFacade webElementFacade){
        try {
            ((JavascriptExecutor) getDriver()).executeScript("arguments[0].scrollIntoView(true);", webElementFacade);
        }catch(Exception e){
            return null;
        }
        return webElementFacade;
    }

    public WebElementFacade waitElementToBeClickable(String xpath){
        try {
            (new WebDriverWait(getDriver(), 5)).until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
        }catch(Exception e){
            return null;
        }
        return $(xpath);
    }

    public WebElementFacade  waitElementToBeClickable(WebElementFacade webElement){
        try {
            (new WebDriverWait(getDriver(), 5)).until(ExpectedConditions.elementToBeClickable(webElement));
        }catch(Exception e){
            return null;
        }
        return webElement;
    }

    public WebElementFacade moveTo(WebElementFacade webElementFacade){
        Actions actions=new Actions(getDriver());
        actions.moveToElement(webElementFacade);
        return webElementFacade;
    }

    public void clickOnButton(String buttonName) {
        waitElementToBeClickable(".//button[.='Go']").click();
    }

    public void selectDateRangeFilter(String dateFrom, String dateTo) throws ParseException {
        String NEXT_YEAR_BUTTON = ".//div[@class='datepicker-months']/table/thead/tr/th[@class='next']";
        String PREV_YEAR_BUTTON = ".//div[@class='datepicker-months']/table/thead/tr/th[@class='prev']";
        String DATE_PICKER_BUTTON = ".//div[@class='datepicker-days']/table/thead/tr/th[@class='datepicker-switch']";
        String DATE_PICKER_MONTHS_BUTTON = ".//div[@class='datepicker-months']/table/thead/tr/th[@class='datepicker-switch']";
        String MONTH_PICKERS = "(.//div[@class='datepicker-months']/table/tbody/tr/td/span)";
        String DAY_PICKERS = "(.//div[@class='datepicker-days']/table/tbody/tr/td[@class='day'])";
        String INVOICE_DATE_FROM_FIELD = "(.//div[@class='input-group date datetimepicker']/a)[1]";
        String INVOICE_DATE_TO_FIELD = "(.//div[@class='input-group date datetimepicker']/a)[2]";
        Calendar cal;
        cal=utils.stringToDate("MM-dd-yyyy",dateFrom);
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

        cal = utils.stringToDate("MM-dd-yyyy",dateTo);
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
