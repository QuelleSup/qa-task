package com.task.selenium.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.task.selenium.utils.CssSelector;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NavigationBar {

    private static final String REGISTER_URL = "https://phptravels.net/register";
    private static final String LOGOUT_URL = "https://phptravels.net/account/logout";

    private SelenideElement myAccountButton = $(CssSelector.cssClass("dropdown-login"))
            .$(CssSelector.id("dropdownCurrency"));

    private SelenideElement signUpButton = $(CssSelector.href(REGISTER_URL));

    private SelenideElement logoutButton = $(CssSelector.href(LOGOUT_URL));

    private SelenideElement homePageNav = $(CssSelector.cssClass("main-nav-menu"));

    public void homePageNavAppearsAsExpected() {
        homePageNav.shouldBe(visible);
    }

    public void openMyAccountDropdown() {
        myAccountButton.waitUntil(visible, 1000).hover().click();
    }

    public void clickSignUpButton() {
        signUpButton.waitUntil(visible, 1000).hover().click();
    }

    public void clickLogOutButton() {
        logoutButton.waitUntil(visible, 1000).hover().click();
    }

}