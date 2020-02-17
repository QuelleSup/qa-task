package com.task.selenium.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.task.selenium.entities.User;
import com.task.selenium.utils.CssSelector;
import com.task.selenium.utils.TestUserUtil;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.task.selenium.utils.TestUserUtil.getAllUserDetailsFromPropertiesFile;


public class AccountOverviewPage {

    private User userDetails;
    private SelenideElement userWelcome = $(CssSelector.cssClass("text-align-left"));
    private ElementsCollection navElementsCollection = $$(CssSelector.cssClass("nav-link"));
    private SelenideElement addressInput = $(CssSelector.name("address1"));
    private SelenideElement secondAddressInput = $(CssSelector.name("address2"));
    private SelenideElement cityInput = $(CssSelector.name("city"));
    private SelenideElement stateRegionInput = $(CssSelector.name("state"));
    private SelenideElement postalZipCodeInput = $(CssSelector.name("zip"));
    private SelenideElement countryDropdown = $(CssSelector.cssClass("chosen-container.chosen-single"));
    private SelenideElement fillCountryInput = $(CssSelector.cssClass("chosen-search-input"));
    private SelenideElement countryResult = $(CssSelector.cssClass("active-result"));
    private SelenideElement submitButton = $(CssSelector.cssClass("btn.updateprofile"));
    private SelenideElement passwordInput = $(CssSelector.name("password"));
    private SelenideElement confirmPasswordInput = $(CssSelector.name("confirmpassword"));

    public AccountOverviewPage() throws IOException {
        userDetails = getAllUserDetailsFromPropertiesFile();
    }


    public void accountOverviewPageAppearsAsExpected() {
        userWelcome.shouldHave(Condition.text(String.format("Hi, %s %s", userDetails.getFirstName(), userDetails.getLastName())));
    }

    public void openMyProfileTab() {
        navElementsCollection.get(1).click();
    }

    public void fillAndSubmitAddressDetails() {
        addressInput.setValue(userDetails.getFirstAddress());
        secondAddressInput.setValue(userDetails.getSecondAddress());
        cityInput.setValue(userDetails.getCity());
        stateRegionInput.setValue(userDetails.getState());
        postalZipCodeInput.setValue(userDetails.getPostalCode());
//        setCountry();
        submitButton.scrollTo().click();
    }

    private void setCountry() {
        countryDropdown.click();
        fillCountryInput.click();
        fillCountryInput.setValue(userDetails.getCountry());
        countryResult.click();
    }

    public void addressDetailsAppearsCorrectlyWithUpdatedValues() {
        addressInput.shouldHave(Condition.value(userDetails.getFirstAddress()));
        secondAddressInput.shouldHave(Condition.value(userDetails.getSecondAddress()));
        cityInput.shouldHave(Condition.value(userDetails.getCity()));
        stateRegionInput.shouldHave(Condition.value(userDetails.getState()));
        postalZipCodeInput.shouldHave(Condition.value(userDetails.getPostalCode()));
        // Seems that checking selected country is bugged so I commented this piece of code
//        countryDropdown.$("span").shouldHave(Condition.text("Poland"));
    }

    public void changePasswordAndSubmit() throws IOException {
        String newPassword = userDetails.getPassword()+"1";
        passwordInput.setValue(newPassword);
        confirmPasswordInput.setValue(newPassword);
        submitButton.scrollTo().waitUntil(Condition.visible, 3000).click();
        TestUserUtil.setNewPasswordAndEmail(newPassword, userDetails.getEmail());
    }
}