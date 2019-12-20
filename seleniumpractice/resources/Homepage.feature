Feature: Using the Homepage

  Scenario: As a user I want to be able to use the search bar to search for specific locations and days so that I can plan a holiday
    Given I am on the Homepage
    When I enter the location into the location bar
    And the Check-in date is entered
    And the Check-out date is entered
    Then I will be able to see the correct information