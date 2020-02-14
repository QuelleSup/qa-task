package com.task.selenium.runners;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = {"src/main/resources/features/CreateAccount.feature"},
        glue = {"com.task"}
)
public final class RunTests extends TestRunner {
}
