package com.automation.stepdefinitions.salesforce;

import com.automation.pages.salesforce.ContactsPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;

public class ContactSteps extends ContactsPage {
    String contactName;

    @And("I search for a contact in salesforce")
    public void iSearchForAContactInSalesforce(List<Map<String, String>> contacts) {
        String contactName = contacts.get(0).get("Contact");
        this.contactName = contactName;
        enterContactInSearchBox(contactName);
        clickContact(contactName);
    }

    @Then("the contact should be displayed in contacts list")
    public void theContactShouldBeDisplayedInContactsList() {
        verifyContact(contactName);
    }
}
