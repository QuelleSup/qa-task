package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.SignUpPage;
import io.cucumber.java.en.When;

public class SignUpPageStepdefs {

    private SignUpPage signUpPage;

    public SignUpPageStepdefs(SignUpPage signUpPage) {
        this.signUpPage = signUpPage;
    }

    @When("^I fill sign up form with valid credentials$")
    public void iClickSignUpFormFromMyAccountDropdown() {
        signUpPage.completeSignUpForm();
    }

}
