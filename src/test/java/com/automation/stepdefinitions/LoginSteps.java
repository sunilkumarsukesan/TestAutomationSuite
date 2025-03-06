package com.automation.stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps {

    @Given("I open {string} login page")
    public void openLoginPage(String appName) {
        System.out.println("Opening login page for: " + appName);
    }

    @When("I enter valid credentials")
    public void enterValidCredentials() {
        System.out.println("Entering valid credentials...");
    }

    @Then("I should be logged in successfully")
    public void verifyLoginSuccess() {
        System.out.println("Login successful!");
    }
}
