@Login
Feature: Salesforce Login

  Background:
    Given Test data file "LoginTestData" is loaded


  @validLogin
  Scenario: Login with valid credentials
    Given User enters valid username and password
    And User clicks on login button
    Then User should be redirected to Salesforce home page


  @invalidLogin
  Scenario: Login with invalid credentials
    Given User is on the Salesforce login page
    #When User enters invalid username and password
    And User clicks on login button
    #Then User should see an error message
