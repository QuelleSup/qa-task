Feature: Whole test scenarios

  Scenario: Create account with valid credentials
    Given Website HomePage is open
    When I click signUp form from MyAccount dropdown
    And I fill sign up form with valid credentials
    Then Account should be successfully created and I'm logged into platform
    And I log out from platform

  Scenario: Fill address data in existing profile
    Given I am logged in client
    When I open My Profile section
    And I fill address details
    Then Address details will be updated
