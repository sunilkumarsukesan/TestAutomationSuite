package com.automation.hooks;

import com.automation.core.config.ConfigManager;
import com.automation.core.drivers.DriverManager;
import com.automation.core.reporting.ExtentManager;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setUpScenario(Scenario scenario) {
        System.out.println("Setting up WebDriver before scenario: " + scenario.getName());

        String browser = ConfigManager.getBrowser();
        DriverManager.initDriver(browser);  //Ensure WebDriver is initialized
        String baseUrl = ConfigManager.getApplicationUrl();  //Fetch URL from config

        if (baseUrl == null || baseUrl.isEmpty()) {
            throw new IllegalStateException("Base URL is not set. Please check ConfigManager.");
        }

        DriverManager.getDriver().get(baseUrl);  //Navigate to the application URL
        System.out.println("Navigated to URL: " + baseUrl);

        ExtentTest test = ExtentManager.createTest(scenario.getName(), scenario.getSourceTagNames().toString());
        ExtentManager.setTestThread(test);
    }

    @After
    public void tearDownScenario(Scenario scenario) {
        System.out.println("Quitting WebDriver after scenario: " + scenario.getName());

        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) DriverManager.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/jpg", "Failure Screenshot");
            ExtentManager.getCurrentTest().log(Status.FAIL, "Scenario Failed");
        } else {
            ExtentManager.getCurrentTest().log(Status.PASS, "Scenario Passed");
        }
        ExtentManager.flushReports();
        DriverManager.quitDriver();
    }
}
