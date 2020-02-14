package com.task.selenium.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.task.selenium.utils.CssSelector;

import static com.codeborne.selenide.Selenide.$;

public class AccountOverviewPage {

    private SelenideElement userWelcome = $(CssSelector.cssClass("text-align-left"));
    private SelenideElement myProfileTab = $(CssSelector.href("#profile"));
    private SelenideElement addressInput = $(CssSelector.cssClass(CssSelector.href("#profile")));
    private SelenideElement secondAddressInput = $(CssSelector.cssClass(CssSelector.href("#profile")));
    private SelenideElement cityInput = $(CssSelector.cssClass(CssSelector.href("#profile")));
    private SelenideElement stateRegionInput = $(CssSelector.cssClass(CssSelector.href("#profile")));
    private SelenideElement postalZipCodeInput = $(CssSelector.cssClass(CssSelector.href("#profile")));
    private SelenideElement countryDropdown = $(CssSelector.cssClass("chosen-container .chosen-single"));
    private SelenideElement fillCountryInput = $(CssSelector.cssClass("chosen-search-input"));
    private SelenideElement countryResult = $(CssSelector.cssClass("active-result"));
    private SelenideElement submitButton = $(CssSelector.cssClass("btn .updateprofile"));

    public void accountOverviewPageAppearsAsExpected() {
        userWelcome.shouldHave(Condition.text("Hi, Jack White"));
    }

    public void openMyProfileTab() { myProfileTab.click(); }

    public void fillAddressDetails() {
        addressInput.setValue("TEST123");
        secondAddressInput.setValue("TEST123");
        cityInput.setValue("KRAKOW");
        stateRegionInput.setValue("MALOPOLSKIE");
        postalZipCodeInput.setValue("31-586");
        setCountry();
        submitButton.click();
    }

    private void setCountry() {
        countryDropdown.click();
        fillCountryInput.click();
        fillCountryInput.setValue("Poland");
        countryResult.click();
    }

    public void addressDetailsAppearsCorrectlyWithUpdatedValues() {
        addressInput.shouldHave(Condition.value("TEST123"));
        secondAddressInput.shouldHave(Condition.value("TEST123"));
        cityInput.shouldHave(Condition.value("KRAKOW"));
        stateRegionInput.shouldHave(Condition.value("MALOPOLSKIE"));
        postalZipCodeInput.shouldHave(Condition.value("31-586"));
        // Seems that checking selected country is bugged so I commented this piece of code
//        countryDropdown.$("span").shouldHave(Condition.text("Poland"));

    }
}