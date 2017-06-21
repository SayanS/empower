package com.empower.steps.serenity;

import com.empower.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage;
    public void login(String userID, String password) {
        loginPage.login(userID, password);
    }

}
