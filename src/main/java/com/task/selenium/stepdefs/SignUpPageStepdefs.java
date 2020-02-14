package com.task.selenium.stepdefs;

import com.task.selenium.pageobjects.SignUpPage;
import io.cucumber.java.en.When;

import lombok.AllArgsConstructor;

import java.io.IOException;

@AllArgsConstructor
public class SignUpPageStepdefs {

    private SignUpPage signUpPage;

    @When("^I fill sign up form with valid credentials$")
    public void iFillSignUpFormWithValidCredentials() throws IOException {
        signUpPage.completeSignUpForm();
    }

}
