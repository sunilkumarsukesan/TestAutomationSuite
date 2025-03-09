package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

import java.io.File;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.stepdefinitions", "com.automation.hooks"},
        plugin = {
                "pretty",
                "html:target/CucumberReports.html",
                "json:target/CucumberReports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@validLogin"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void setupExtentReports() {
        System.setProperty("extent.properties", "src/test/resources/config/extent.properties");
        setupReportFolder();
    }

    public void setupReportFolder() {
        File reportDir = new File("reports");
        if (!reportDir.exists()) {
            reportDir.mkdirs();
        }
    }

    // Enables parallel execution of scenarios
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}
