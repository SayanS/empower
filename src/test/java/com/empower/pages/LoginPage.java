package com.empower.pages;

import net.serenitybdd.core.pages.PageObject;

public class LoginPage extends PageObject{
    private String User_ID=".//input[@id='userId']";
    private String PASSWORD=".//*[@id='password']";
    private String SUBMIT_BUTTON="//button[@type='submit']";

    public void login(String userID, String password){
        $(User_ID).sendKeys(userID, password);
        $(SUBMIT_BUTTON).click();
    }

}
