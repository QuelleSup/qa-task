package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.HomePageNavigation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class HomePageStepdefs {

    private HomePageNavigation homePageNavigation;

    @Given("^Website HomePage is open$")
    public void websiteHomePageIsOpen() {
        homePageNavigation.homePageNavAppearsAsExpected();
    }

    @When("^I click signUp form from MyAccount dropdown$")
    public void iClickSignUpFormFromMyAccountDropdown() {
        homePageNavigation.openMyAccountDropdown();
        homePageNavigation.clickSignUpButton();
    }
}
