package com.task.selenium.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import com.task.selenium.utils.CssSelector;

import static com.codeborne.selenide.Selenide.$;

public class AccountPage {

    private SelenideElement userWelcome = $(CssSelector.cssClass("text-align-left"));

    public void accountPageAppearsAsExpected() {
        userWelcome.shouldHave(Condition.text("Hi, Jack White"));
    }

}