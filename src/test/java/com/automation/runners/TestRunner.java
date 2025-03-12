package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;
import java.io.IOException;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.stepdefinitions", "com.automation.core.hooks"},
        plugin = {
                "pretty",
                "html:target/CucumberReports.html",
                "json:target/CucumberReports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "com.automation.core.utils.FeatureFilePathPlugin"
        },
        monochrome = true,
        tags = "@VerifyContact"
)
public class TestRunner extends AbstractTestNGCucumberTests {

    @BeforeSuite
    public void beforeSuite() throws IOException {
        System.out.println("Executing tests from feature files: " + String.join(", ", getTagExpression()));
    }

    private String[] getTagExpression() {
        CucumberOptions cucumberOptions = this.getClass().getAnnotation(CucumberOptions.class);
        return cucumberOptions.features();
    }

    // Enables parallel execution of scenarios
    @Override
    @DataProvider(parallel = true)
    public Object[][] scenarios() {
        return super.scenarios();
    }
}