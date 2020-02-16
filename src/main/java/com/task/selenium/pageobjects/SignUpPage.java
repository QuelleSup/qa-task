package com.task.selenium.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.task.selenium.entities.User;
import com.task.selenium.utils.CssSelector;
import com.task.selenium.utils.TestUserUtil;
import lombok.NoArgsConstructor;


import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;

@NoArgsConstructor
public class SignUpPage {
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

    public void completeSignUpForm() throws IOException {
        User user = TestUserUtil.getAllUserDetailsFromPropertiesFile();
        firstNameField.setValue(user.getFirstName());
        lastNameField.setValue(user.getLastName());
        mobileNumberField.setValue(user.getPhoneNumber());
        emailField.setValue(user.getEmail());
        passwordField.setValue(user.getPassword());
        confirmPasswordField.setValue(user.getPassword());
        signUpButton.click();
    }
}
