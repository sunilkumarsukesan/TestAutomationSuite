Feature: Sample Feature for Web Application Testing

  @Regression
  Scenario: Verify login functionality for App A
    Given I open "App A" login page
    When I enter valid credentials
    Then I should be logged in successfully
