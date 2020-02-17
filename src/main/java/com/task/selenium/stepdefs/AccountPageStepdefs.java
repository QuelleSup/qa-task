package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.AccountOverviewPage;
import com.task.selenium.utils.TestUserUtil;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class AccountPageStepdefs {

    private AccountOverviewPage accountOverviewPage;

    @When("^I open My Profile section")
    public void iOpenMyProfileSection() {
        accountOverviewPage.openMyProfileTab();
    }

    @And("^I fill and submit address details")
    public void iFillAndSubmitAddressDetails() {
        accountOverviewPage.fillAndSubmitAddressDetails();
    }

    @Then("^Address details will be updated")
    public void addressDetailsWillBeUpdated()  {
        accountOverviewPage.openMyProfileTab();
        accountOverviewPage.addressDetailsAppearsCorrectlyWithUpdatedValues();
    }

    @And("^I change my password and submit")
    public void changePasswordAndSubmit() throws Exception{
        accountOverviewPage.changePasswordAndSubmit();
    }

    @Then("^I will be logged into to Account Overview page")
    public void iWillBeLoggedIntoAccountOverviewPage() {
        accountOverviewPage.accountOverviewPageAppearsAsExpected();
    }
}
