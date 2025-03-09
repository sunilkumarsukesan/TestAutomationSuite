package com.automation.stepdefinitions.salesforce;
import com.automation.core.base.BaseTest;
import com.automation.core.drivers.DriverManager;
import com.automation.pages.salesforce.LoginPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.remote.RemoteWebDriver;

public class LoginSteps extends LoginPage {
    private RemoteWebDriver driver;

    @When("User enters valid username and password")
    public void user_enters_valid_username_and_password() {
        enterUsername().enterPassword();
    }

    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
        clickLogin();
    }

    @Then("User should be redirected to Salesforce home page")
    public void user_should_be_redirected_to_salesforce_home_page() {
        // Add validation logic here
    }
}
