
package com.empower.steps.serenity;

import com.empower.pages.LoginPage;
import net.thucydides.core.annotations.Step;

public class LoginSteps {
    LoginPage loginPage;

    @Step
    public void login(String userID, String password) {
        loginPage.login(userID, password);
    }

}
