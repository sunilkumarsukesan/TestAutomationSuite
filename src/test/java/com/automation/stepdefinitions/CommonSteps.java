package com.automation.stepdefinitions;

import com.automation.core.config.ConfigManager;
import com.automation.core.testData.TestDataManager;
import com.automation.hooks.Hooks;
import io.cucumber.java.en.Given;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class CommonSteps {
    public static String testDataFileForExecution;

    @Given("Test data file(s) {string} are loaded")
    public void loadTestDataFiles(String testDataFiles) throws IOException {
        // Split the input string by comma to handle single or multiple files
        List<String> testDataSheets = Arrays.asList(testDataFiles.split("\\s*,\\s*"));

        // Load each test data file
        for (String sheet : testDataSheets) {
            System.out.println("Loading test data for: " + sheet);
            TestDataManager.loadTestData(ConfigManager.getTestDataPath() + "/" +
                    ConfigManager.getApplicationName() + "/" +sheet);
        }
    }

    @Given("Test data file {string} is loaded")
    public void testDataFileIsLoaded(String testDataFile) throws IOException {
        testDataFileForExecution = String.format("%s%s/%s",
                ConfigManager.getTestDataPath(),
                ConfigManager.getApplicationName(),
                testDataFile.endsWith(".xlsx") ? testDataFile : testDataFile + ".xlsx"
        );
        TestDataManager.loadTestData(testDataFileForExecution);

        // Set the test data context using the dynamically fetched RowID
        TestDataManager.setCurrentTestDataContext(testDataFileForExecution, Hooks.getScenarioSpecificTag());
    }
}
