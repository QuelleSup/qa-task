package com.task.selenium.pageobjects;

import com.codeborne.selenide.SelenideElement;
import com.task.selenium.utils.CssSelector;

import static com.codeborne.selenide.Selenide.$;

public class LoginPage {

    private SelenideElement emailField = $(CssSelector.name("username"));
    private SelenideElement passwordField = $(CssSelector.name("password"));
    private SelenideElement loginButton = $(CssSelector.cssClass("loginbtn"));

    public void logInToApp() {
        emailField.setValue("1581687886992@simulated.com");
        passwordField.setValue("Welcome1");
        loginButton.click();
    }

}
