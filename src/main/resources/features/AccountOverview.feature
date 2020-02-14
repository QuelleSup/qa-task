Feature: Account Overview

  Scenario: Fill address data in existing profile
    Given I am logged in client
    When I open My Profile section
    And I fill address details
    Then Address information will be updated