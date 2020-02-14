package com.task.selenium.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.task.selenium.utils.CssSelector;

import static com.codeborne.selenide.Selenide.$;
import static com.task.selenium.utils.EmailUtil.*;

public class SignUpPage {
    private static final String EMAIL_FORMAT = "%s@simulated.com";
    private static final String FIRST_NAME = "firstname";
    private static final String LAST_NAME = "lastname";
    private static final String MOBILE_NUMBER = "phone";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";
    private static final String CONFIRM_PASSWORD = "confirmpassword";

    private SelenideElement firstNameField = $(CssSelector.name(FIRST_NAME));
    private SelenideElement lastNameField = $(CssSelector.name(LAST_NAME));
    private SelenideElement mobileNumberField = $(CssSelector.name(MOBILE_NUMBER));
    private SelenideElement emailField = $(CssSelector.name(EMAIL));
    private SelenideElement passwordField = $(CssSelector.name(PASSWORD));
    private SelenideElement confirmPasswordField = $(CssSelector.name(CONFIRM_PASSWORD));
    private SelenideElement signUpButton = $(CssSelector.cssClass("signupbtn"));

    public void completeSignUpForm() {
        firstNameField.setValue("Jack");
        lastNameField.setValue("White");
        mobileNumberField.setValue("21321321");
        emailField.setValue(prepareEmailAndLog(EMAIL_FORMAT));
        passwordField.setValue("Welcome1");
        confirmPasswordField.setValue("Welcome1");
        signUpButton.click();
    }
}
