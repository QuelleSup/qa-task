package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.NavigationBar;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HomePageStepdefs {

    private NavigationBar navigationBar;

    @Given("^Website HomePage is open$")
    public void websiteHomePageIsOpen() {
        navigationBar.homePageNavAppearsAsExpected();
    }

    @When("^I click signUp form from MyAccount dropdown$")
    public void iClickSignUpFormFromMyAccountDropdown() {
        navigationBar.openMyAccountDropdown();
        navigationBar.clickSignUpButton();
    }

    @And("^I log out from platform")
    public void iLogOutFromPlatform() {
        navigationBar.openMyAccountDropdown();
        navigationBar.clickLogOutButton();
    }
}
