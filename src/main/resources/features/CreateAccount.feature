Feature: Creating account

  Scenario: Create account with valid credentials
    Given Website HomePage is open
    When I click signUp form from MyAccount dropdown
    And I fill sign up form with valid credentials
    Then Account should be successfully created and I'm logged into platform
