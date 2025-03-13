@Contacts
Feature: Test to validate the contacts functionality in saleforce

  Background:
    Given Test data file "ContactTestData" is loaded


  @VerifyContact
  Scenario: Verify contact presence in Salesforce
    Given I login to Salesforce application using valid username and password
    And I navigate to "Contacts" from AppLauncher
    And I search for a contact in salesforce
      | Contact     |
      | Sunil Kumar |
    Then the contact should be displayed in contacts list
