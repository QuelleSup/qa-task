package com.task.selenium.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.task.selenium.utils.CssSelector;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class NavigationBar {

    private static final int SLEEP_TIME = 1000;
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
        myAccountButton.scrollTo();
        myAccountButton.waitUntil(visible, SLEEP_TIME).click();
    }

    public void clickSignUpButton() {
        signUpButton.waitUntil(visible, SLEEP_TIME).click();
    }

    public void clickLogOutButton() {
        logoutButton.waitUntil(visible, SLEEP_TIME).click();
    }

}
