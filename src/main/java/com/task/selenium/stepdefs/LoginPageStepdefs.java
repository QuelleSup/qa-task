package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.AccountOverviewPage;
import com.task.selenium.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class LoginPageStepdefs {

    private LoginPage loginPage;
    private AccountOverviewPage accountOverviewPage;

    @Given("^I log in to app$")
    public void iLogInToApp() throws IOException {
        loginPage.logInToApp();
        accountOverviewPage.accountOverviewPageAppearsAsExpected();
    }
}
