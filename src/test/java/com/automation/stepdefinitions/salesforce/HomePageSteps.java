package com.automation.stepdefinitions.salesforce;

import com.automation.pages.salesforce.HomePage;
import io.cucumber.java.en.And;

public class HomePageSteps extends HomePage {

    @And("I navigate to {string} from AppLauncher")
    public void iNavigateToFromAppLauncher(String module) {
        navigateToModule(module); // Method to navigate via AppLauncher
    }
}
