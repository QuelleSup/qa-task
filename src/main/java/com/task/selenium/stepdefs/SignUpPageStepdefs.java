package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.SignUpPage;
import io.cucumber.java.en.When;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class SignUpPageStepdefs {

    private SignUpPage signUpPage;

    @When("^I fill sign up form with valid credentials$")
    public void iClickSignUpFormFromMyAccountDropdown() {
        signUpPage.completeSignUpForm();
    }

}
