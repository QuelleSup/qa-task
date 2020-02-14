package com.task.selenium.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features/CreateAccount.feature"},
        glue = {"com.qaasignment.selenium"}
)
public final class RunTests extends TestRunner {
}
