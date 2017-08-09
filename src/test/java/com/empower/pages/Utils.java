package com.empower.pages;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Utils extends CustomPageObject {

    public List<String> getTextFromList(List<WebElementFacade> list){
        List<String> textList=new ArrayList<>();
        for(WebElementFacade we:list){
            textList.add(we.getText());
        }
        return textList;
    }

    public void waitInvisabilityOfSpinner() {
        (new WebDriverWait(getDriver(), 5)).until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("(//img[@src=\"/geempower/_ui/responsive/common/images/ajax-loader.gif\"])[1]")));
    }

    public Calendar stringToDate(String format, String date) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat(format);
        Date resultDate = dateFormat.parse(date);
        Calendar cal = Calendar.getInstance();
        cal.setTime(resultDate);
        return cal;
    }

}
