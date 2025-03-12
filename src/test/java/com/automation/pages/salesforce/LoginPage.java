package com.automation.pages.salesforce;

import com.automation.core.reporting.ExtentManager;
import com.automation.core.design.Locators;
import org.openqa.selenium.WebElement;

public class LoginPage extends BasePage {

    private WebElement usernameField = actions.locateElement(Locators.ID, "username");
    private WebElement passwordField = actions.locateElement(Locators.ID, "password");
    private WebElement loginButton = actions.locateElement(Locators.ID, "Login");

    // ✅ Fetch elements dynamically before each action to avoid stale element issues
    public LoginPage enterUsername(String userName) {
        actions.clearAndType(usernameField, userName);
        ExtentManager.logStep("User entered the username successfully", "PASS", true);
        return this;
    }

    public LoginPage enterPassword(String password) {
        actions.clearAndType(passwordField, password);
        ExtentManager.logStep("User entered the password successfully", "PASS", true);
        return this;
    }

    public HomePage clickLogin() {
        actions.click(loginButton);
        ExtentManager.logStep("User clicked on login button successfully", "PASS", true);
        return new HomePage();
    }

    public boolean isLoginSuccessful() {
        return driver.getTitle().contains("Home"); // Update with actual validation logic
    }
}
