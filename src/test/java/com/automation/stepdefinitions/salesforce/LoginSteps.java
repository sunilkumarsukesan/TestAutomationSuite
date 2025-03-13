package com.automation.stepdefinitions.salesforce;

import com.automation.core.config.ConfigManager;
import com.automation.core.hooks.Hooks;
import com.automation.core.testData.TestDataManager;
import com.automation.pages.salesforce.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

public class LoginSteps extends LoginPage {

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() throws Exception {
        String username = ConfigManager.getApplicationUsername(Hooks.application);
        String password = ConfigManager.getApplicationPassword(Hooks.application);
        enterUsername(username).enterPassword(password);
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        clickLogin();
    }

    @Then("User should be redirected to Salesforce home page")
    public void user_should_be_redirected_to_salesforce_home_page() {
        // Add validation logic here
    }

    @Given("I login to Salesforce application using valid username and password")
    public void iLoginToSalesforce() throws Exception {
        user_enters_valid_username_and_password();
        clickLogin();
    }

}
