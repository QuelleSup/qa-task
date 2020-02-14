package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.AccountOverviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class AccountPageStepdefs {

    private AccountOverviewPage accountOverviewPage;

    @Then("^Account should be successfully created and I'm logged into platform")
    public void iClickSignUpFormFromMyAccountDropdown() {
        accountOverviewPage.accountOverviewPageAppearsAsExpected();
    }

    @When("^I open My Profile section")
    public void iOpenMyProfileSection() {
        accountOverviewPage.openMyProfileTab();
    }

    @And("^I fill address details")
    public void iFillAddressDetails() {
        accountOverviewPage.fillAddressDetails();
    }

    @Then("^Address details will be updated")
    public void addressDetailsWillBeUpdated() {
        accountOverviewPage.openMyProfileTab();
        accountOverviewPage.addressDetailsAppearsCorrectlyWithUpdatedValues();
    }
}
