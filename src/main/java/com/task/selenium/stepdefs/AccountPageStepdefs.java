package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.AccountPage;
import io.cucumber.java.en.Then;


public class AccountPageStepdefs {

    private AccountPage accountPage;

    public AccountPageStepdefs(AccountPage accountPage) {
        this.accountPage = accountPage;
    }

    @Then("^Account should be successfully created and I'm logged into platform$")
    public void iClickSignUpFormFromMyAccountDropdown() {
        accountPage.accountPageAppearsAsExpected();
    }

}
