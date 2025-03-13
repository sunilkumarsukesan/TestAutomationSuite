package com.automation.pages.salesforce;

import com.automation.core.base.BasePage;
import com.automation.core.design.Locators;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;

@Slf4j
public class ContactsPage extends BasePage {
    private By contactSearchBox = getBy(Locators.XPATH, "//input[@placeholder='Search this list...']");

    private By getContactLocator (String contactName) {
        return getBy(Locators.XPATH,
                "//a[text()='" + contactName + "' and @title='" + contactName + "']");
    }
    private By getVerifyContactLocator (String contactName) {
        return getBy(Locators.XPATH,
                "//lightning-formatted-name[contains(text(),'" + contactName +"')]");
    }


    public ContactsPage enterContactInSearchBox(String contactName){
        typeAndEnter(locateElement(contactSearchBox),contactName);
        logStep("User able to enter the contact in search box successfully", "pass");
        return this;
    }

    public ContactsPage clickContact(String contactName){
        click(getContactLocator(contactName));
        logStep("User able to click on the contact successfully", "pass");
        return this;
    }

    public ContactsPage verifyContact(String contactName){
        verifyDisplayed(locateElement(getVerifyContactLocator(contactName)));
        logStep(    "User is able to view the contact successfully", "pass");
        return this;
    }

}
