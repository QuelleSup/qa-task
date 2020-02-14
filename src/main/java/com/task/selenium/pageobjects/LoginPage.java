package com.task.selenium.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.task.selenium.entities.User;
import com.task.selenium.utils.CssSelector;

import java.io.IOException;

import static com.codeborne.selenide.Selenide.$;
import static com.task.selenium.utils.TestUserUtil.*;

public class LoginPage {

    private SelenideElement emailField = $(CssSelector.name("username"));
    private SelenideElement passwordField = $(CssSelector.name("password"));
    private SelenideElement loginButton = $(CssSelector.cssClass("loginbtn"));

    public void logInToApp() throws IOException {
        User user = getEmailAndPasswordFromPropertiesFile();
        emailField.setValue(user.getEmail());
        passwordField.setValue(user.getPassword());
        loginButton.click();
    }

}
