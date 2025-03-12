package com.automation.pages.salesforce;

import com.automation.core.pages.BasePage;
import com.automation.core.reporting.ExtentManager;
import com.automation.core.design.Locators;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private By usernameField = getBy(Locators.ID, "username");
    private By passwordField = getBy(Locators.ID, "password");
    private By loginButton = getBy(Locators.ID, "Login");

    public LoginPage enterUsername(String userName) {
        clearAndType(locateElement(usernameField), userName);
        logStep("User entered the username successfully", "PASS", true);
        return this;
    }

    public LoginPage enterPassword(String password) {
        clearAndType(locateElement(passwordField), password);
        logStep("User entered the password successfully", "PASS", true);
        return this;
    }

    public HomePage clickLogin() {
        click(locateElement(loginButton));
        logStep("User clicked on login button successfully", "PASS", true);
        return new HomePage();
    }

    public boolean isLoginSuccessful() {
        return driver.getTitle().contains("Home"); // Update with actual validation logic
    }
}
