package com.automation.pages.salesforce;

import com.automation.core.web.WebDriverActions;
import com.automation.core.web.WebDriverUtils;

public class HomePage {
    private WebDriverActions actions;

    public HomePage() {
        this.actions = actions;
    }

    public HomePage verifyHomePageDisplayed() {
        System.out.println("Home Page is displayed");  // Replace with actual verification
        return this;
    }
}
