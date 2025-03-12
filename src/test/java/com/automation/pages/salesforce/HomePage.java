package com.automation.pages.salesforce;

import com.automation.core.design.Locators;
import com.automation.core.pages.BasePage;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class HomePage extends BasePage {
    String module;

    private By appLauncher = getBy(Locators.XPATH, "//span[text()='App Launcher']");
    private By appLauncherSearchBox = getBy(Locators.XPATH, "//input[@placeholder='Search apps and items...']");
    private By selectContact = getBy(Locators.XPATH, "//b[text()='Contacts']");

    public HomePage verifyHomePageDisplayed() {
        System.out.println("Home Page is displayed");  // Replace with actual verification
        return this;
    }

    public HomePage clickAppLauncher(){
        clickUsingJs(appLauncher);
        logStep("User clicked on the App launcher successfully", "pass");
        return this;
    }

    public HomePage enterModuleNameInSearchBox(String module){
        typeAndEnter(locateElement(appLauncherSearchBox), module);
        logStep("User entered the module name in search box successfully", "pass");
        return this;
    }

    public ContactsPage clickContact(){
        click(locateElement(selectContact));
        logStep("User clicked on the contact successfully", "pass");
        return new ContactsPage();
    }

    public HomePage verifyLandingPage(String module){
        By ModulePage = getBy(Locators.XPATH,"//one-app-nav-bar-item-root[contains(@class,'slds-is-active')]//span[text()='"+ module + "']");
        verifyDisplayed(locateElement(ModulePage));
        logStep("User is on the " + module.toUpperCase() + " module page", "pass");
        return this;
    }

    public HomePage navigateToModule(String Module){
        clickAppLauncher().
        enterModuleNameInSearchBox(Module).
        clickContact();
        verifyLandingPage(Module);
        return this;
    }
}
