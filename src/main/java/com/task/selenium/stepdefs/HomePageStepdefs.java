package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.HomePageNavigation;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import java.util.logging.Logger;

import static com.task.selenium.utils.WindowManager.isWindowContainingUrlOpen;
import static com.task.selenium.utils.WindowManager.switchToWindowWithUrlContaining;

public class HomePageStepdefs {

    private static final Logger LOG = Logger.getLogger(HomePageStepdefs.class.getName());

    private HomePageNavigation homePageNavigation;

    public HomePageStepdefs(HomePageNavigation homePageNavigation) {
        this.homePageNavigation = homePageNavigation;
    }


    @Given("^Website HomePage is open$")
    public void websiteHomePageIsOpen() {
        boolean isWebsiteHomePageOpen = isWindowContainingUrlOpen("home");
        if (isWebsiteHomePageOpen) {
            LOG.info("PHPTRAVELS website is already opened.");
        } else {
            switchToWindowWithUrlContaining("home");
            homePageNavigation.homePageNavAppearsAsExpected();
        }
    }

    @When("^I click signUp form from MyAccount dropdown$")
    public void iClickSignUpFormFromMyAccountDropdown() {
        homePageNavigation.openMyAccountDropdown();
        homePageNavigation.clickSignUpButton();
    }
}
