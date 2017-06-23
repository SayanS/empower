package com.empower.pages;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://qa.geempower.com/geempower")
public class LoginPage extends PageObject{
    private String User_ID=".//input[@id='userId']";
    private String PASSWORD=".//*[@id='password']";
    private String SUBMIT_BUTTON="//button[@type='submit']";

    public void login(String userID, String password){
        $(User_ID).clear();
        $(User_ID).sendKeys(userID);
        $(PASSWORD).clear();
        $(PASSWORD).sendKeys(password);
        $(SUBMIT_BUTTON).click();
    }

}
