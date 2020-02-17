Feature: Whole test scenarios

  Scenario: Create account with valid credentials
    Given Website HomePage is open
    When I click signUp form from MyAccount dropdown
    And I fill sign up form with valid credentials
    Then I will be logged into to Account Overview page
    And I Log out from platform

  Scenario: Fill address data in existing profile
    Given I log in to app
    When I open My Profile section
    And I fill and submit address details
    Then Address details will be updated
    And I Log out from platform

  Scenario: Change user password
    Given I log in to app
    When I open My Profile section
    And I change my password and submit
    And I Log out from platform
    When I log in to app
    Then I will be logged into to Account Overview page


