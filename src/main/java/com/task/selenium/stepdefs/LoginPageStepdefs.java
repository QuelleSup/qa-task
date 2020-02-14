package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.AccountOverviewPage;
import com.task.selenium.pageobjects.LoginPage;
import io.cucumber.java.en.Given;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class LoginPageStepdefs {

    private LoginPage loginPage;
    private AccountOverviewPage accountOverviewPage;

    @Given("^I am logged in client$")
    public void iAmLoggedInClient() {
        loginPage.logInToApp();
        accountOverviewPage.accountOverviewPageAppearsAsExpected();
    }
}
