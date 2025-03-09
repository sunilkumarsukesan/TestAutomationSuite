package com.automation.pages.salesforce;

import com.automation.core.drivers.DriverManager;
import com.automation.core.web.WebDriverActions;
import com.automation.core.web.WebDriverUtils;
import org.openqa.selenium.remote.RemoteWebDriver;

public class BasePage {
    protected RemoteWebDriver driver;
    protected WebDriverActions actions;

    public BasePage() {
        this.driver = DriverManager.getDriver();
        this.actions = new WebDriverUtils();
    }
}
