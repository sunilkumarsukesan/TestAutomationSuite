package com.automation.runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = {"com.automation.stepdefinitions", "com.automation.core.hooks"},
        plugin = {
                "pretty",
                "html:target/CucumberReports.html",
                "json:target/CucumberReports.json",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:"
        },
        monochrome = true,
        tags = "@VerifyContact or @validLogin"
)
public class TestRunner extends AbstractTestNGCucumberTests {
    private static final Logger logger = LoggerFactory.getLogger(TestRunner.class);

    @BeforeSuite
    public void beforeSuite() {
        logger.info("Executing tests from feature files: " + String.join(", ", getTagExpression()));
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